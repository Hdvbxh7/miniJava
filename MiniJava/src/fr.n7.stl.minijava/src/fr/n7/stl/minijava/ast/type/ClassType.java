package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public class ClassType implements Type {
	
	protected String name;

	public ClassType(String _name) {
		this.name = _name;
	}

	@Override
	public boolean equalsTo(Type _other) {
		throw new SemanticsUndefinedException("Semantics equalsTo is not implemented in ClassType.");
	}

	@Override
	public boolean compatibleWith(Type _other) {
		throw new SemanticsUndefinedException("Semantics compatibleWith is not implemented in ClassType.");
	}

	@Override
	public Type merge(Type _other) {
		throw new SemanticsUndefinedException("Semantics merge is not implemented in ClassType.");
	}

	@Override
	public int length() {
		throw new SemanticsUndefinedException("Semantics length is not implemented in ClassType.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		throw new SemanticsUndefinedException("Semantics completeResolve is not implemented in ClassType.");
	}
	
	public String toString() {
		return " " + this.name + " ";
	}

}
