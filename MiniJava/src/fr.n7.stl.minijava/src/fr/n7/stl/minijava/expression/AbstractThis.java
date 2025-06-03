package fr.n7.stl.minijava.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public abstract class AbstractThis <ObjectKind extends Expression> implements Expression {

	protected ClassDeclaration object;

	public AbstractThis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = true;
		while (ok) {
			if(_scope instanceof ClassSymbolTable cscope){
				object = csope.getClass();
			}
		}
		return true;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		return true;
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is not implemented in this.");
	}
	
	@Override
	public String toString() {
		return "this";
	}
}
