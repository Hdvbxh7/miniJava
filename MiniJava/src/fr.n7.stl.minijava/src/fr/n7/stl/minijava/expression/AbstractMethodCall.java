package fr.n7.stl.minijava.expression;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.MethodDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;

public abstract class AbstractMethodCall <ObjectKind extends Expression> implements Expression {
	
	protected String name;
	
	protected MethodDeclaration declaration;
	
	protected ObjectKind target;
	
	protected List<AccessibleExpression> arguments;

	public AbstractMethodCall(ObjectKind _target, String _name, List<AccessibleExpression> _arguments) {
		this.target = _target;
		this.name = _name;
		this.arguments = _arguments;
	}
	
	public AbstractMethodCall(String _name, List<AccessibleExpression> _arguments) {
		this( null, _name, _arguments);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		// throw new SemanticsUndefinedException("Semantics collectAndPartialResolve is not implemented in AbstractMethodCall.");
		boolean result = true;
		for (AccessibleExpression expr : this.arguments) {
			result = result && expr.collectAndPartialResolve(_scope);
		}

		if (this.target != null) {
			result = result && this.target.collectAndPartialResolve(_scope);
		}

		return result;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		boolean result = true;

		for (AccessibleExpression expr : this.arguments) {
			result = result && expr.completeResolve(_scope);
		}
		Type objectType;

		if (this.target != null) {
			result = result && this.target.completeResolve(_scope);
			objectType = this.target.getType();
			
		} else {
			Declaration thisDecl = _scope.get("this");
			if (thisDecl == null || !(thisDecl.getType() instanceof ClassType )) {
				System.err.println("Erreur : appel à une méthode sans cible, et this n'est pas dans le scope.");
				return false;
			}
			objectType = thisDecl.getType();
		}
		if (!(objectType instanceof ClassType classType)) {
			System.err.println("Erreur : le type de l'objet n'est pas une classe.");
			return false;
		}

		ClassDeclaration classDecl = classType.getDeclaration();
		if (classDecl == null) {
			System.err.println("Erreur : aucune déclaration pour le type " + classType.getName());
			return false;
		}
		this.declaration = classDecl.getMethod(this.name);
		if (this.declaration == null) {
			System.err.println("Erreur : la méthode '" + this.name +"' est introuvable dans la classe.");
			return false;
		}

		return result;
	}

	@Override
	public Type getType() {
		if(this.declaration!=null){
			return this.declaration.getType();
		} else{
			return null;
		}
		
	}
	
	@Override
	public String toString() {
		String image = "";
		if (this.target != null) {
			image += this.target + ".";
		}
		image += this.name +"( ";
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
