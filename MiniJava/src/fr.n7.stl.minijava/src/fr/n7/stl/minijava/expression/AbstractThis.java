package fr.n7.stl.minijava.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.Scope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.util.Logger;
import fr.n7.stl.minic.ast.*;
import fr.n7.stl.minic.ast.instruction.declaration.*;



public abstract class AbstractThis <ObjectKind extends Expression> implements Expression {

	protected ClassDeclaration object;
	protected String z;

	public AbstractThis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = true;
		Scope<Declaration> scope = _scope;
		while (ok) {
			if(scope instanceof ClassSymbolTable cscope){
				object = cscope.getClassD();
				return true;
			} else if(scope instanceof SymbolTable sscope){
				scope = sscope.getContext();
			} else {
				Logger.error("This ne peut être utilisé que dans les classes");
				ok = false;
			}
		}
		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		return true;
	}

	@Override
	public Type getType() {
		return object.getType();
	}
	
	@Override
	public String toString() {
		return "this";
	}
}
