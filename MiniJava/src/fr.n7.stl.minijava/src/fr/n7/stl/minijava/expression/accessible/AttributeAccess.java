package fr.n7.stl.minijava.expression.accessible;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.expression.AbstractAttribute;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.util.Logger;

public class AttributeAccess extends AbstractAttribute<AccessibleExpression>  implements AccessibleExpression {

	public AttributeAccess(AccessibleExpression _object, String _name) {
		super(_object,_name);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = object.collectAndPartialResolve(_scope);
		if(object.getType() instanceof ClassType cobj){
			Declaration dec = _scope.get(object.toString());
			
		}
		return ok;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		return object.completeResolve(_scope);
	}

	@Override
	public Type getType() {
		System.out.println(name);
		return attribute.getType();
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode is not implemented in access.");
	}

}
