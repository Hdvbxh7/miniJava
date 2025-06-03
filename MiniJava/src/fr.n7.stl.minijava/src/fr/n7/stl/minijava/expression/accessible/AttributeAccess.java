package fr.n7.stl.minijava.expression.accessible;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.AccessRight;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.expression.AbstractAttribute;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.util.Logger;
import fr.n7.stl.tam.ast.Library;

public class AttributeAccess extends AbstractAttribute<AccessibleExpression>  implements AccessibleExpression {

	public AttributeAccess(AccessibleExpression _object, String _name) {
		super(_object,_name);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok =true;
		ok = ok && this.object.collectAndPartialResolve(_scope);
		ok = ok && this.object.getType().completeResolve(_scope);	
		if(this.object.getType() instanceof ClassType cobject){
			if((_scope.knows(cobject.getName()) && (_scope.get(cobject.getName()) instanceof ClassDeclaration cdec))){
				attribute = cdec.getAttribute(name);
				if(attribute.getAccessRight()==AccessRight.PROTECTED||attribute.getAccessRight()==AccessRight.PRIVATE){
					Logger.error("L'attribut "+ attribute.getName() +" de la classe "+object.toString() +" est inaccesssible");
				}
				return ok;
			}
		}
		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		return object.completeResolve(_scope);
	}

	@Override
	public Type getType() {
		return attribute.getType();
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		fragment.append(object.getCode(_factory));
		fragment.add(_factory.createLoadL(attribute.offset));
		fragment.add(Library.IAdd);
		fragment.add(_factory.createLoadI(attribute.getType().length()));
		return fragment;
	}

}
