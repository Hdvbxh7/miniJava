package fr.n7.stl.minijava.expression.assignable;

import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.expression.AbstractThis;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;

public class ThisAssignment extends AbstractThis<AssignableExpression> implements AssignableExpression {

	public ThisAssignment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		fragment.add(_factory.createLoad(Register.LB, -1, 1));
		return fragment;
	}
}
