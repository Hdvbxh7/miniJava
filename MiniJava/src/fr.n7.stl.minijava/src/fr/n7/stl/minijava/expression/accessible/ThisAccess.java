package fr.n7.stl.minijava.expression.accessible;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minijava.expression.AbstractThis;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public class ThisAccess extends AbstractThis<AccessibleExpression> implements AccessibleExpression {
	
	public ThisAccess() {
		super();
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode is not implemented in ThisAccess.");
	}

}
