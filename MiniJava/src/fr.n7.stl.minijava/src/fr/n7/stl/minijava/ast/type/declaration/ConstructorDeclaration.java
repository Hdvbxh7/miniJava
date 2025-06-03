package fr.n7.stl.minijava.ast.type.declaration;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.util.Logger;
import fr.n7.stl.minic.ast.scope.SymbolTable;

public class ConstructorDeclaration extends ClassElement {
	
	protected List<ParameterDeclaration> parameters;
	
	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	protected Block body;

	protected ClassDeclaration classDec;

	protected HierarchicalScope<Declaration> localScope;

	public ConstructorDeclaration(String _name, List<ParameterDeclaration> _parameters, Block _body) {
		super( _name);
		this.parameters = _parameters;
		this.body = _body;
	}

	@Override
	public boolean collectAndPartialResolve(ClassSymbolTable _scope){
		boolean ok = true;
		if(_scope.accepts(this)) {
			_scope.register(this);
			ok = ok && true;
		} else {
			Logger.warning("Variable" + this.name + "Is already defined");
			return false;
		}	
		this.localScope = new SymbolTable(_scope);
		for(ParameterDeclaration p : parameters){
			if(this.localScope .accepts(p)) {
				this.localScope .register(p);
				ok = ok && true;
			} else {
				Logger.warning("Parameter " + p.getName() + "Is already defined");
				ok = ok && false;
			}
		}
		return ok && this.body.collectAndPartialResolve(localScope);
	};

	@Override
	public boolean completeResolve(ClassSymbolTable _scope){
		this.classDec = _scope.getClassD();
		return body.completeResolve(this.localScope);

	};

	@Override
	public boolean checkType(){
		if(classDec.getName().equals(this.name)){
			return true;
		}
		Logger.error("Le constructeur n'est pas du bon type");
		return false;
	}

	@Override
	public String toString() {
		String image = "";
		image += this.accessRight + " " + this.name + "( ";
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
		image += this.body; 
		return image;
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is not implemented in constructor.");
	}
}
