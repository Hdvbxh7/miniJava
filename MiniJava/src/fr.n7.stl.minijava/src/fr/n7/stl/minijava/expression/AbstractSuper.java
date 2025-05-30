package fr.n7.stl.minijava.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public abstract class AbstractSuper  <ObjectKind extends Expression> implements Expression {

	public AbstractSuper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		throw new SemanticsUndefinedException("Semantics collectAndPartialResolve is not implemented in AbstractSuper.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		throw new SemanticsUndefinedException("Semantics completeResolve is not implemented in AbstractSuper.");
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is not implemented in AbstractSuper.");
	}
	
	@Override
	public String toString() {
		return "super";
	}

}
