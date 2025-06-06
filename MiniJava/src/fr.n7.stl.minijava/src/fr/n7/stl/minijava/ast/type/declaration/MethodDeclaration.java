package fr.n7.stl.minijava.ast.type.declaration;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.util.Logger;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.type.*;

public class MethodDeclaration  extends ClassElement {
	
	protected boolean concrete;
	
	protected List<ParameterDeclaration> parameters;

	protected HierarchicalScope<Declaration> localScope;

	protected FunctionDeclaration func;
	
	protected Block body;

	public String funName;
	
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
		this.func = new FunctionDeclaration(this.name,type,parameters,body);
		return this.func.collectAndPartialResolve(_scope);
	};

	@Override
	public boolean completeResolve(ClassSymbolTable _scope){
		return this.func.completeResolve(_scope);
	};

	@Override
	public boolean checkType(){
		return this.func.checkType();
	}
	@Override
	public int allocateMemory(int _offset) {
		int paramSizes = -1;
		for(ParameterDeclaration p : parameters){
			p.setOffset(paramSizes - p.getType().length());
			paramSizes = paramSizes - p.getType().length();
		}
		body.allocateMemory(Register.LB,3);
		return 0;
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

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		int i = _factory.createLabelNumber();
		this.funName = "Method"+this.name+i;
		fragment.add(_factory.createJump("SKIP"+this.funName));
		fragment.addSuffix(this.funName);
		fragment.append(body.getCode(_factory));
		if(this.type.compatibleWith(AtomicType.VoidType)){
			fragment.add(_factory.createReturn(0,this.paramSize()+1));
		}
		fragment.addSuffix("SKIP"+this.funName);
		return fragment;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	private int paramSize(){
		int i =0;
		for(ParameterDeclaration pDecl:parameters){
			i += pDecl.getType().length();
		}
		return i;
	}
}
