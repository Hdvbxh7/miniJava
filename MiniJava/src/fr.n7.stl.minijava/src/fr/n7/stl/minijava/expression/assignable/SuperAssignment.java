package fr.n7.stl.minijava.expression.assignable;

import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minijava.expression.AbstractSuper;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public class SuperAssignment extends AbstractSuper<AssignableExpression> implements AssignableExpression {

	public SuperAssignment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode is not implemented in SuperAssignment.");
	}

}
