package fr.n7.stl.minijava.instruction;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.declaration.MethodDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;

public class MethodCall implements Instruction {
	
	protected AccessibleExpression target;
	
	protected String name;
	
	protected MethodDeclaration method;
	
	protected List<AccessibleExpression> arguments;

	public MethodCall(AccessibleExpression _target, String _name, List<AccessibleExpression> _arguments) {
		this.name = _name;
		this.method = null;
		this.target = _target;
		this.arguments = _arguments;
	}
	
	public MethodCall(String _name, List<AccessibleExpression> _arguments) {
		this( null, _name,_arguments);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean result = true;
		if (this.target != null) {
			result = this.target.collectAndPartialResolve(_scope);
		}
		for (AccessibleExpression arg : this.arguments) {
			result &= arg.collectAndPartialResolve(_scope);
		}
		return result;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
		boolean result = true;
		if (this.target != null) {
			result = this.target.collectAndPartialResolve(_scope);
		}
		for (AccessibleExpression arg : this.arguments) {
			result &= arg.collectAndPartialResolve(_scope);
		}
		return result;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		boolean result = true;
		if (this.target != null) {
			result &= this.target.completeResolve(_scope);
			if (!(this.target.getType() instanceof ClassType classType)) {
				System.err.println("Target is not a class type.");
				return false;
			}
			ClassDeclaration classDecl = classType.getDeclaration();
			this.method = classDecl.getMethod(this.name);
			if (this.method == null) {
				System.err.println("Method " + this.name + " not found in class " + classType.getName());
				return false;
			}
		} else {
			if (_scope.knows(this.name) && _scope.get(this.name) instanceof MethodDeclaration md) {
				this.method = md;
			} else {
				System.err.println("Method " +this.name + " not found in current scope.");
				return false;
			}
		}
		for (AccessibleExpression arg : this.arguments) {
			result &= arg.completeResolve(_scope);
		}
		return result;
	}

	@Override
	public boolean checkType() {
		List<ParameterDeclaration> parameters = this.method.getParameters();
		if (parameters.size() != this.arguments.size()) {
			System.err.println("Method call argument count mismatch.");
			return false;
		}
		boolean result = true;
		for (int i = 0; i < arguments.size(); i++) {
			if (!arguments.get(i).getType().compatibleWith(parameters.get(i).getType())) {
				System.err.println("Argument " + (i + 1) + " type mismatch.");
				result = false;
			}
		}
		return result;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment code = _factory.createFragment();
		if (this.target != null) {
			code.append(this.target.getCode(_factory));
		}
		for (AccessibleExpression arg : this.arguments) {
			code.append(arg.getCode(_factory));
		}
		code.add(_factory.createCall(this.method.getLabel(), Register.LB));
		return code;
	}
	
	@Override
	public String toString() {
		String image = "";
		if (this.target != null) {
			image += target + ".";
		}
		image += this.name;
		image += "( ";
		Iterator<AccessibleExpression> iterator = this.arguments.iterator();
		if (iterator.hasNext()) {
			AccessibleExpression argument = iterator.next();
			image += argument;
			while (iterator.hasNext()) {
				 argument = iterator.next();
				 image += " ," + argument;
			}
		}
		image += ");\n";
		return image;
	}

}
