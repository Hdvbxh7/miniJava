/**
 * 
 */
package fr.n7.stl.minijava.ast.type.declaration;

import java.util.List;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.Scope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.util.Logger;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * 
 */
public class ClassDeclaration implements Instruction, Declaration {
	
	protected List<ClassElement> elements;
	
	public List<ClassElement> getElements() {
		return elements;
	}

	protected boolean concrete;
	
	protected String name;
	
	protected String ancestor;

	protected HierarchicalScope classScope;

	protected Type type;

	/**
	 * 
	 */
	public ClassDeclaration(boolean _concrete, String _name, String _ancestor, List<ClassElement> _elements) {
		this.concrete = _concrete;
		this.name = _name;
		this.ancestor = _ancestor;
		this.elements = _elements;
	}
	
	/**
	 * 
	 */
	public ClassDeclaration(boolean _concrete, String _name, List<ClassElement> _elements) {
		this( _concrete, _name, null, _elements);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = true;
		type = new ClassType(name);
		if (_scope.accepts(this)) {
			if (this.ancestor == null || _scope.knows(this.ancestor)) {
				_scope.register(this);
			}
		} else {
			Logger.error("Class " + this.name + " Is already defined");
		}

		classScope = new SymbolTable(_scope);

		for (ClassElement element : this.elements) {
			if (element instanceof AttributeDeclaration eAttribute) {

				if (classScope.accepts(eAttribute)) {
					classScope.register(eAttribute);
					ok = ok && eAttribute.getType().completeResolve(classScope);
				} else {
					Logger.error("Attribute " + eAttribute.getName() + " is already defined in class " + this.name);
				}

			} else if (element instanceof ConstructorDeclaration eConstructor) {

				if (classScope.accepts(eConstructor)) {
					classScope.register(eConstructor);
					ok = ok && eConstructor.body.collectAndPartialResolve(classScope);
				} else {
					Logger.error("Constructor " + eConstructor.getName() + " is already defined in class " + this.name);
				}
				
			} else if (element instanceof MethodDeclaration eMethod) {

				if (classScope.accepts(eMethod)) {
					classScope.register(eMethod);
				} else {
					Logger.error("Method " + eMethod.getName() + " is already defined in class " + this.name);
				}
			}
		}

		return true;
		
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {

		if (_scope.accepts(this) && _scope.knows(this.ancestor)) {
			_scope.register(this);
		} else {
			Logger.error("Class " + this.name + " Is already defined");
			
		}
		return true;

	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		return this.type.completeResolve(_scope);
	}

	@Override
	public boolean checkType() {
		boolean ok = true;
		for (ClassElement element : this.elements) {
			if (element instanceof ConstructorDeclaration eConstructor) {
					ok = ok && eConstructor.body.checkType();
			} else if (element instanceof MethodDeclaration eMethod) {
					ok = ok && eMethod.body.checkType();
			}
		}

		return ok;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		return fragment;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Type getType() {
		return type;
	}

	public String getAncestor() {
		return ancestor;
	}
	
	@Override
	public String toString() {
		String image = "";
		if (! this.concrete) {
			image += "abstract ";
		}
		image += "class " + this.name + " ";
		if (this.ancestor != null) {
			image += "extends " + this.ancestor + " ";
		}
		image += "{\n";
		for (ClassElement e : this.elements) {
			image += e;
		}
		image += "}\n";
		return image;
	}

}
