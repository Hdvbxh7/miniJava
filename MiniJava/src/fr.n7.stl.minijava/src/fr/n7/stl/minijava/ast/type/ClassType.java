package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassElement;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public class ClassType implements Type {
	
	protected String name;
	protected ClassDeclaration declaration;
	protected ClassType ancestor;

	public ClassType(String _name) {
		this.name = _name;
	}

	@Override
	public boolean equalsTo(Type _other) {
		if(_other instanceof ClassType cother){
			return this.name.equals(cother.name);
		} else{
			return false;
		}
	}

	@Override
	public boolean compatibleWith(Type _other) {
		if(_other instanceof ClassType cother){
			if(this.equalsTo(cother)){
				return true;
			} else{
				if(this.ancestor != null){
					return ancestor.compatibleWith(_other);
				}
			}
		}
		return false;
	}

	@Override
	public Type merge(Type _other) {
		throw new SemanticsUndefinedException("Semantics merge is not implemented in ClassType.");
	}

	@Override
	public int length() {
		int length = 0;
		for (ClassElement element : declaration.getElements()) {
			if (element instanceof AttributeDeclaration eAttribute) {
				length += eAttribute.getType().length();
			}
		}

		return length;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		if(_scope.knows(name)){
			if(_scope.get(name) instanceof ClassDeclaration cdec){
				this.declaration = cdec;
				if(declaration.getAncestor()!=null){
					if(_scope.get(declaration.getAncestor()).getType() instanceof ClassType atype){
						this.ancestor = atype;
						return true;
					}
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return " " + this.name + " ";
	}

}
