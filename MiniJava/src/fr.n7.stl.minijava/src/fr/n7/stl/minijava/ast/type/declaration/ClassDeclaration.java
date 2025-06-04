/**
 * 
 */
package fr.n7.stl.minijava.ast.type.declaration;

import java.util.ArrayList;
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
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * 
 */
public class ClassDeclaration implements Instruction, Declaration {
	
	protected List<ClassElement> elements;

	protected List<ClassElement> elementsandHerited;
	
	public List<ClassElement> getElements() {
		return elements;
	}

	protected boolean concrete;
	
	protected String name;
	
	protected String ancestor;

	private ClassDeclaration ancestorClass;

	protected ClassSymbolTable classScope;

	protected Type type;

	/**
	 * 
	 */
	public ClassDeclaration(boolean _concrete, String _name, String _ancestor, List<ClassElement> _elements) {
		this.concrete = _concrete;
		this.name = _name;
		this.ancestor = _ancestor;
		this.elements = _elements;
		this.elementsandHerited = new ArrayList<>();
	}
	
	/**
	 * 
	 */
	public ClassDeclaration(boolean _concrete, String _name, List<ClassElement> _elements) {
		this( _concrete, _name, null, _elements);
		this.elementsandHerited = new ArrayList<>();
	}

	

	public ArrayList<ConstructorDeclaration> getConstructors(){
		ArrayList<ConstructorDeclaration> constructors = new ArrayList<ConstructorDeclaration>();
		for(ClassElement ce : elements){
			if(ce instanceof ConstructorDeclaration cd){
				constructors.add(cd);
			}
		}
		return constructors;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		this.elementsandHerited.addAll(elements);
		boolean ok = true;
		type = new ClassType(name);
		if (_scope.accepts(this)) {
			if (this.ancestor == null || _scope.knows(this.ancestor)) {
				_scope.register(this);
			}
		} else {
			Logger.error("Class " + this.name + " Is already defined");
		}

		classScope = new ClassSymbolTable(this,_scope);

		for (ClassElement element : this.elements) {
			element.collectAndPartialResolve(classScope);
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
		if (this.ancestor != null && _scope.knows(this.ancestor)) {
			Declaration ancestor = _scope.get(this.ancestor);
			if(ancestor instanceof ClassDeclaration ancestorclass){
				ancestorClass = ancestorclass;
				for(ClassElement ceAn: ancestorclass.getElements()){
					int index = alreadyIn(ceAn);
					if(index==-1){
						elementsandHerited.add(ancestorclass.getElements().indexOf(ceAn),ceAn);
					} else {
						ClassElement classElement = elementsandHerited.get(index);
						elementsandHerited.remove(index);
						elementsandHerited.add(ancestorclass.getElements().indexOf(ceAn),classElement);
					}
				}
			}
		}
		for (ClassElement element : this.elements) {
			element.completeResolve(classScope);
		}
		return this.type.completeResolve(_scope);
	}

	@Override
	public boolean checkType() {
		boolean ok = true;
		for (ClassElement element : this.elements) {
			element.checkType();
		}

		return ok;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		int off = 0;
		for (ClassElement classElement : elements) {
				off += classElement.allocateMemory(off);
		}
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		for (ClassElement classElement : elements) {
			fragment.append(classElement.getCode(_factory));
		}
		if((elements.size()-attributenum())==0){
			fragment.add(_factory.createPush(0));
		}
		fragment.addComment("Classe : " + this.name);
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

	private int alreadyIn(ClassElement ce){
		if (ce instanceof AttributeDeclaration eAttribute) {
			for(ClassElement ceIn: elements){
				if(ceIn instanceof AttributeDeclaration eAttributeIn){
					if(ceIn.getName().equals(ce.getName())){
						return elements.indexOf(ceIn);
					}
				}
			}
		}else if (ce instanceof MethodDeclaration eMethod) {
			for(ClassElement ceIn: elements){
				if(ceIn instanceof MethodDeclaration eMethodIn){
					if(ceIn.getName().equals(ce.getName())){
						return elements.indexOf(ceIn);
					}
				}
			}
		} else if (ce instanceof ConstructorDeclaration eConstructor) {
			for(ClassElement ceIn: elements){
				if(ceIn instanceof MethodDeclaration eConstructorIn){
					if(ceIn.getName().equals(ce.getName())){
						return elements.indexOf(ceIn);
					}
				}
			}
		}else{
			Logger.error("les elements explosent pour l'heritage de classDeclaration");
		}
		return -1;
	}

	public AttributeDeclaration getAttribute(String nameatt){
		for(ClassElement ceIn: elementsandHerited){
			if(ceIn instanceof AttributeDeclaration eAttributeIn){
				if(eAttributeIn.getName().equals(nameatt)){
					return eAttributeIn;
				}
			}
		}
		Logger.error("attribut "+nameatt+" non existant dans la classe "+name);
		return null;
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

	private int attributenum(){
		int i= 0;
		for(ClassElement ceIn: elements){
			if(ceIn instanceof AttributeDeclaration eAttributeIn){
				i++;
			}
		}
		return i;
	}
	
		public MethodDeclaration getMethod(String name){
		for(ClassElement element: this.elementsandHerited){
			if(element instanceof MethodDeclaration method && method.getName().equals(name)){
				return method;
			}
		}
		return null;
	}

}