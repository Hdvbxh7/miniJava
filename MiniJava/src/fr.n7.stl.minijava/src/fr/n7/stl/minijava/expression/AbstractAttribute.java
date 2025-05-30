package fr.n7.stl.minijava.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minic.ast.type.declaration.FieldDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public abstract class AbstractAttribute <ObjectKind extends Expression> implements Expression {
	
	protected ObjectKind object;
	protected String name;
	protected AttributeDeclaration attribute;

	public AbstractAttribute(ObjectKind _object, String _name) {
		this.object = _object;
		this.name = _name;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		throw new SemanticsUndefinedException("Semantics collectAndPartialResolve is not implemented in AbstractAttribute.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		throw new SemanticsUndefinedException("Semantics completeResolve is not implemented in AbstractAttribute.");
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is not implemented in AbstractAttribute.");
	}
	
	@Override
	public String toString() {
		String image = "";
		image += this.object;
		image += ".";
		image += this.name;
		return image;
	}

}
