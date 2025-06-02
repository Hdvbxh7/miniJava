package fr.n7.stl.minijava.expression.allocation;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public class ObjectAllocation  implements AccessibleExpression, AssignableExpression {
	
	protected String name;
	protected Declaration declaration;
	
	protected List<AccessibleExpression> arguments;

	public ObjectAllocation(String _name, List<AccessibleExpression> _arguments) {
		this.name = _name;
		this.arguments = _arguments;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		if(_scope.knows(name)){
			this.declaration = _scope.get(name);
			return true;
		}
		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		return true;
	}

	@Override
	public Type getType() {
		return declaration.getType();
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		fragment.add(_factory.createLoadL(declaration.getType().length()));
		fragment.add(Library.MAlloc);
		return fragment;
	}
	
	@Override
	public String toString() {
		String image = "";
		image += "new " + this.name + "( ";
		Iterator<AccessibleExpression> iterator = this.arguments.iterator();
		if (iterator.hasNext()) {
			AccessibleExpression argument = iterator.next();
			image += argument;
			while (iterator.hasNext()) {
				 argument = iterator.next();
				 image += " ," + argument;
			}
		}
		image += ")";
		return image;
	}

}
