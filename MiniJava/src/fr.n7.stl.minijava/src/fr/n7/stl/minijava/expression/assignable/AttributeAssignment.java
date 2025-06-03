package fr.n7.stl.minijava.expression.assignable;

import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.expression.assignable.VariableAssignment;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.expression.AbstractAttribute;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.assignable.*;
import fr.n7.stl.tam.ast.Library;

public class AttributeAssignment extends AbstractAttribute<AssignableExpression> implements AssignableExpression {

	public AttributeAssignment(AssignableExpression _object, String _name) {
		super( _object, _name);
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		if((object instanceof VariableAssignment varobj) && (varobj.getDeclaration().getType() instanceof ClassType)){
			fragment.add(_factory.createLoad(varobj.getDeclaration().getRegister(), varobj.getDeclaration().getOffset(), 1));
			fragment.add(_factory.createLoadL(attribute.offset));
			fragment.add(Library.IAdd);
			fragment.add(_factory.createStoreI(attribute.getType().length()));
		}
		return fragment;
	}

}
