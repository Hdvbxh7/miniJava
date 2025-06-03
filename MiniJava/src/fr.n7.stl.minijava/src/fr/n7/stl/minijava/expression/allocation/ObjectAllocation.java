package fr.n7.stl.minijava.expression.allocation;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.scope.ClassSymbolTable;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ConstructorDeclaration;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.util.Logger;

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
		if(_scope.knows(name) && arguments.isEmpty()){
			this.declaration = _scope.get(name);
			return true;
		} else if(_scope.knows(name)){
			boolean valider = false;
			Declaration decl = _scope.get(name);
			if(decl instanceof ClassDeclaration classDeclaration){
				for(ConstructorDeclaration cd: classDeclaration.getConstructors()){
					List<ParameterDeclaration> paramList = cd.getParameters();
					if(arguments.size()==paramList.size()){
						boolean ok = true;
						for(int i=0;i<arguments.size();i++){
							if(!(arguments.get(i).getType().compatibleWith(paramList.get(i).getType()))){
								ok= false;
							}
						}
						if(ok){
							declaration=cd;
							valider = true;
						}
					} else{
						Logger.error("Les paramètres ne correspondent pas aux arguments pour la fonction" + " " + toString());
					}
				}
			}
			return valider;
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
		if(!arguments.isEmpty()){
			for(AccessibleExpression e: arguments){
				fragment.append(e.getCode(_factory));
			}
			if(declaration.getType() instanceof ClassType cType){
				fragment.add(_factory.createLoadL(cType.lengthAttr()));
			}
			fragment.add(Library.MAlloc);
			if(declaration instanceof ConstructorDeclaration cdec){
				System.out.println(cdec.funName);
				fragment.add(_factory.createCall(cdec.funName,Register.LB));
			}
		} else {
			if(declaration.getType() instanceof ClassType cType){
				fragment.add(_factory.createLoadL(cType.lengthAttr()));
			}
			fragment.add(Library.MAlloc);
		}
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
