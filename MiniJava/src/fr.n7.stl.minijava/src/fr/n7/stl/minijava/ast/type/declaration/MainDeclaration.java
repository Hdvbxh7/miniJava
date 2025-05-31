package fr.n7.stl.minijava.ast.type.declaration;

import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ConstantDeclaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.util.Logger;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public class MainDeclaration implements Instruction {
	
	protected String name;
	
	protected List<Declaration> declarations;
	
	protected Block main;

	public MainDeclaration(String _name, List<Declaration> _declarations, Block _main) {
		this.name = _name;
		this.declarations = _declarations;
		this.main = _main;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = true;
		for(Declaration d: declarations){
			if(d instanceof FunctionDeclaration dfunc){
				ok = ok && dfunc.collectAndPartialResolve(_scope);
			} else if(d instanceof VariableDeclaration dvar){
				ok = ok && dvar.collectAndPartialResolve(_scope);
			} else if(d instanceof ConstantDeclaration dcon){
				ok = ok && dcon.collectAndPartialResolve(_scope);
			} else {
				Logger.error("Le parser est cringe dans main declaration");
			}
		}
		return ok && main.collectAndPartialResolve(_scope);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
		boolean ok = true;
		for(Declaration d: declarations){
			if(d instanceof FunctionDeclaration dfunc){
				ok = ok && dfunc.collectAndPartialResolve(_scope,_container);
			} else if(d instanceof VariableDeclaration dvar){
				ok = ok && dvar.collectAndPartialResolve(_scope,_container);
			} else if(d instanceof ConstantDeclaration dcon){
				ok = ok && dcon.collectAndPartialResolve(_scope,_container);
			} else {
				Logger.error("Le parser est cringe dans main declaration");
			}
		}
		return ok && main.collectAndPartialResolve(_scope,_container);
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = true;
		for(Declaration d: declarations){
			if(d instanceof FunctionDeclaration dfunc){
				ok = ok && dfunc.completeResolve(_scope);
			} else if(d instanceof VariableDeclaration dvar){
				ok = ok && dvar.completeResolve(_scope);
			} else if(d instanceof ConstantDeclaration dcon){
				ok = ok && dcon.completeResolve(_scope);
			} else {
				Logger.error("Le parser est cringe dans main declaration");
			}
		}
		return ok && main.completeResolve(_scope);
	}

	@Override
	public boolean checkType() {
		boolean ok = true;
		for(Declaration d: declarations){
			if(d instanceof FunctionDeclaration dfunc){
				ok = ok && dfunc.checkType();
			} else if(d instanceof VariableDeclaration dvar){
				ok = ok && dvar.checkType();
			} else if(d instanceof ConstantDeclaration dcon){
				ok = ok && dcon.checkType();
			} else {
				Logger.error("Le parser est cringe dans main declaration");
			}
		}
		return ok && main.checkType();
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		main.allocateMemory(_register,_offset);
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		for(Declaration d: declarations){
			if(d instanceof FunctionDeclaration dfunc){
				fragment.append(dfunc.getCode(_factory));
			} else if(d instanceof VariableDeclaration dvar){
				fragment.append(dvar.getCode(_factory));
			} else if(d instanceof ConstantDeclaration dcon){
				fragment.append(dcon.getCode(_factory));
			} else {
				Logger.error("Le parser est cringe dans main declaration");
			}
		}
		fragment.append(main.getCode(_factory));
		return fragment;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		String image = "";
		image += "public class " + this.name + " ";
		image += "{\n";
		image += "\n";
		for (Declaration uneDeclaration : this.declarations) {
			image += uneDeclaration;
			image += "\n";
		}
		image += "\tpublic static void Main( String[] args) ";
		image += this.main;
		image += "\n";
		image += "}\n";
		return image;
	}

}
