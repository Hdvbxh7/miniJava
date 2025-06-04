package fr.n7.stl.minijava.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minic.ast.type.declaration.FieldDeclaration;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minic.ast.expression.assignable.VariableAssignment;
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
		boolean ok =true;
		ok = ok && this.object.collectAndPartialResolve(_scope);
		ok = ok && this.object.getType().completeResolve(_scope);
		return ok;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = object.completeResolve(_scope) ;	
		ok = ok && this.object.getType().completeResolve(_scope);
		if(this.object.getType() instanceof ClassType cobject){
			if((_scope.knows(cobject.getName()) && (_scope.get(cobject.getName()) instanceof ClassDeclaration cdec))){
				attribute = cdec.getAttribute(name);
				return ok;
			}
		}
		return false;
	}
	
	@Override
	public Type getType() {
		if(this.attribute!=null){
			return this.attribute.getType();
		} else {
			return null;
		}
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
