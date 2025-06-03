package fr.n7.stl.minijava.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.Scope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.util.Logger;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;

public abstract class AbstractSuper  <ObjectKind extends Expression> implements Expression {

	ClassDeclaration object;

	public AbstractSuper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = true;
		Scope<Declaration> scope = _scope;

		if(scope instanceof ClassSymbolTable cscope){
			object = cscope.getClassD();
			scope = cscope;
			ok = false;
		} else if(scope instanceof SymbolTable sscope){
			scope = sscope.getContext();
		} else {
			Logger.error("Super ne peut être utilisé que dans les classes");
			ok = false;
		}
		

		String ancestor = object.getAncestor();
		ClassDeclaration ancestorClass = (ClassDeclaration) scope.get(object.getAncestor());

		if (ancestorClass == null) {
			Logger.error("Super ne peut être utilisé que dans les classes qui ont un ancêtre");
			return false;
		}
		
		if (object.getName().equals(ancestorClass.getName())) {
			Logger.error("Super ne peut pas être utilisé dans la classe elle-même");
			return false;
		}

		




		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		throw new SemanticsUndefinedException("Semantics completeResolve is not implemented in AbstractSuper.");
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is not implemented in AbstractSuper.");
	}
	
	@Override
	public String toString() {
		return "super";
	}

}
