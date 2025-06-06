package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minijava.ast.type.declaration.ElementKind;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.util.Logger;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public abstract class ClassElement  implements Declaration {
	
	protected ElementKind elementKind;

	protected ClassDeclaration classDeclaration;
	
	public ClassDeclaration getClassDeclaration() {
		return classDeclaration;
	}

	protected AccessRight accessRight;
	
	protected String name;
	
	public ClassElement(ElementKind _elementKind, AccessRight _accessRight, String _name) {
		this.elementKind = _elementKind;
		this.accessRight = _accessRight; 
		this.name = _name;
	}

	public boolean collectAndPartialResolve(ClassSymbolTable _scope){
		return false;
	};

	public boolean completeResolve(ClassSymbolTable _scope){
		return false;
	};


	public int allocateMemory(int _offset) {
		return 0;
	}

	public boolean checkType(){
		return false;
	}

	public Fragment getCode(TAMFactory _factory) {
		return _factory.createFragment();
	}
	
	public ClassElement(String _name) {
		this(ElementKind.OBJECT, AccessRight.PACKAGE, _name);
	}
	
	public ElementKind getElementKind() {
		return this.elementKind;
	}
	
	public void setElementKind(ElementKind _elementKind) {
		this.elementKind = _elementKind;
	}
	
	public AccessRight getAccessRight() {
		return this.accessRight;
	}
	
	public void setAccessRight(AccessRight _accessRight) {
		this.accessRight = _accessRight;
	}
	
	@Override
	public String getName() {
		return this.name; 
	}

}
