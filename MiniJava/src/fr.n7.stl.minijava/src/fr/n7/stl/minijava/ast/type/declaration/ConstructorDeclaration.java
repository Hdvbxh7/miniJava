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
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.util.Logger;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Register;

public class ConstructorDeclaration extends ClassElement {
	
	protected List<ParameterDeclaration> parameters;
	
	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	protected Block body;

	protected ClassDeclaration classDec;

	protected HierarchicalScope<Declaration> localScope;

	public String funName;

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
		ok = ok && this.body.collectAndPartialResolve(localScope);
		return ok;
	};

	@Override
	public boolean completeResolve(ClassSymbolTable _scope){
		this.classDec = _scope.getClassD();
		return body.completeResolve(this.localScope);

	};

	@Override
	public int allocateMemory(int _offset) {
		int paramSizes = -1;
		for(ParameterDeclaration p : parameters){
			p.setOffset(paramSizes - p.getType().length());
			paramSizes = paramSizes - p.getType().length();
		}
		body.allocateMemory(Register.LB, 3);
		return 0;
	}

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
		return classDec.getType();
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		int i = _factory.createLabelNumber();
		this.funName = "CONSTRUCTOR"+this.name+i;
		fragment.add(_factory.createJump("SKIP"+funName));
		fragment.addSuffix(funName);
		fragment.append(body.getCode(_factory));
		fragment.add(_factory.createLoad(Register.LB,-1,1));
		fragment.add(_factory.createReturn(1,this.paramSize()));
		fragment.addSuffix("SKIP"+funName);
		return fragment;
	}

	private int paramSize(){
		int i =0;
		for(ParameterDeclaration pDecl:parameters){
			i += pDecl.getType().length();
		}
		return i;
	}
}
