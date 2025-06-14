package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.util.Logger;

public class AttributeDeclaration extends ClassElement {
	
	protected Type type;

	public int offset=-1;

	public AttributeDeclaration( String _name, Type _type) {
		super(_name);
		this.type = _type;
	}

	@Override
	public boolean collectAndPartialResolve(ClassSymbolTable _scope){
		if (_scope.accepts(this)) {
			_scope.register(this);
			return true;
		} else {
			Logger.error("Attribute " + this.name + " is already defined in class "+ _scope.getClassD().getName());
		}
		return false;
	};

	@Override
	public int allocateMemory(int _offset) {
		this.offset = _offset;
		return type.length();
	}


	@Override
	public boolean completeResolve(ClassSymbolTable _scope){
		this.classDeclaration = _scope.getClassD();
		return type.completeResolve(_scope);
	};

	@Override
	public boolean checkType(){
		return true;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.accessRight + " " + type + " " + this.name + ";\n"; 
	}
}
