/**
 * 
 */
package fr.n7.stl.minijava.ast.type.declaration;

import java.lang.classfile.ClassElement;
import java.util.List;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.Scope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * 
 */
public class ClassDeclaration implements Instruction, Declaration {
	
	protected List<ClassElement> elements;
	
	protected boolean concrete;
	
	protected String name;
	
	protected String ancestor;

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

		if (_scope.accepts(this) && _scope.knows(this.ancestor)) {
			_scope.register(this);
		} else {
			Logger.warning("Class" + this.name + "Is already defined");
			return false;
		}
		
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {

		if (_scope.accepts(this) && _scope.knows(this.ancestor)) {
			_scope.register(this);
		} else {
			Logger.warning("Class" + this.name + "Is already defined");
			return false;
		}

	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {

		for (ClassElement element : this.elements) {
			if (element instanceof AttributeDeclaration) {

				if (_scope.accepts(this)) {
					_scope.register(element.getName());
				}

			} else if (element instanceof MethodDeclaration) {

			} else if (element instanceof ConstructorDeclaration) {

			}

		}

		return true;

	}

	@Override
	public boolean checkType() {
		throw new SemanticsUndefinedException( "Semantics check type is undefined in ClassDeclaration.");
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new SemanticsUndefinedException( "Semantics allocation memory is undefined in ClassDeclaration.");
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException( "Semantics get code is undefined in ClassDeclaration.");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is not implemented in ClassDeclaration.");
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
