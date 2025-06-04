package fr.n7.stl.minijava.ast.type.declaration;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.util.Logger;

public class MethodDeclaration  extends ClassElement {
	
	protected boolean concrete;
	
	protected List<ParameterDeclaration> parameters;
	
	protected Block body;
	
	protected Type type;
	
	public MethodDeclaration(String _name, Type _type, List<ParameterDeclaration> _parameters, Block _body) {
		super( _name );
		this.parameters = _parameters;
		this.body = _body;
		this.concrete = (_body != null);
		this.type = _type;
	}
	
	public MethodDeclaration(String _name, Type _type, List<ParameterDeclaration> _parameters) {
		this( _name, _type, _parameters, null);
	}

	public List<ParameterDeclaration> getParameters() {
		return this.parameters;
	}

	@Override
	public boolean collectAndPartialResolve(ClassSymbolTable _scope){
		if (_scope.accepts(this)) {
			_scope.register(this);
			return true;
		} else {
			Logger.error("Method " + this.name + " is already defined in class " + _scope.getClassD().getName());
		}
		return false;
	};

	@Override
	public boolean completeResolve(ClassSymbolTable _scope){
		return true;
	};

	@Override
	public boolean checkType(){
		return true;
	}
	
	@Override
	public String toString() {
		String image = "";
		if (! this.concrete) {
			image += "abstract ";
		}
		image += this.accessRight + " " + this.type + " " + this.name + "( ";
		Iterator<ParameterDeclaration> iterator = this.parameters.iterator();
		if (iterator.hasNext()) {
			ParameterDeclaration parameter = iterator.next();
			image += parameter;
			while (iterator.hasNext()) {
				 parameter = iterator.next();
				 image += " ," + parameter;
			}
		}
		image += ")";
		if (this.concrete) {
			image += this.body; 
		} else {
			image += ";";
		}
		return image;
	}

	public String getLabel() {
		return "codes_" + this.name;
	}

	@Override
	public Type getType() {
		return this.type;
	}
}
