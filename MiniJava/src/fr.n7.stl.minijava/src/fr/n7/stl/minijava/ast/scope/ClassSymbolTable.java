package fr.n7.stl.minijava.ast.scope;

import java.lang.foreign.FunctionDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.Scope;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ConstructorDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.MethodDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.*;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.util.Logger;


public class ClassSymbolTable implements HierarchicalScope<Declaration> {
        
        private Map<String, Declaration> declarations;
        private ArrayList<ConstructorDeclaration> constructorDeclarations;
        private Map<String,ArrayList<FunctionDeclaration>> methodDeclarations;
        protected ClassDeclaration classD;
        
        public ClassDeclaration getClassD() {
            return classD;
        }

        private Scope<Declaration> context;
    
        public ClassSymbolTable() {
        }

        public ClassSymbolTable(ClassDeclaration cd,Scope<Declaration> _context){
            this.classD = cd;
            this.declarations = new HashMap<String,Declaration>();
            this.constructorDeclarations = new ArrayList<ConstructorDeclaration>();
            this.methodDeclarations = new  HashMap<String,ArrayList<FunctionDeclaration>>();
            this.context = _context;
        }
        
        public ClassSymbolTable(Scope<Declaration> _context) {
            this.declarations = new HashMap<String,Declaration>();
            this.constructorDeclarations = new ArrayList<ConstructorDeclaration>();
            this.methodDeclarations = new  HashMap<String,ArrayList<FunctionDeclaration>>();
            this.context = _context;
        }
    
        /* (non-Javadoc)
         * @see fr.n7.stl.block.ast.scope.Scope#get(java.lang.String)
         */
        @Override
        public Declaration get(String _name) {
            if (this.declarations.containsKey(_name)) {
                return this.declarations.get(_name);
            } else {
                if (this.context != null) {
                    return this.context.get(_name);
                } else {
                    return null;
                }
            }
        }
    
        /* (non-Javadoc)
         * @see fr.n7.stl.block.ast.scope.Scope#contains(java.lang.String)
         */
        @Override
        public boolean contains(String _name) {
            return (this.declarations.containsKey(_name));
        }
    
        /* (non-Javadoc)
         * @see fr.n7.stl.block.ast.scope.Scope#accepts(fr.n7.stl.block.ast.scope.Declaration)
         */
        @Override
        public boolean accepts(Declaration _declaration) {
            if(_declaration instanceof ConstructorDeclaration cdec){
                if(cdec.getName().equals(classD.getName())){
                    List<ParameterDeclaration> paramList = cdec.getParameters();
                    for(ConstructorDeclaration cdIn : constructorDeclarations){
                        if(cdIn.getParameters().size()==paramList.size()){
                            boolean ok = true;
                            for(int i=0;i<cdIn.getParameters().size();i++){
                                if(!(cdIn.getParameters().get(i).getType().compatibleWith(paramList.get(i).getType()))){
                                    ok= false;
                                }
                            }
                            if(ok){
                                Logger.error("Constructeurs déja existant \n "+cdec.toString());
                            }
                        } 
                    }
                } else{
                    return false;
                }
                return true;
            }else if(_declaration instanceof FunctionDeclaration mdec){
                if(this.methodDeclarations.containsKey(mdec.getName())){
                    List<ParameterDeclaration> paramList = mdec.getParameters();
                    for(FunctionDeclaration mdIn : methodDeclarations.get(mdec.getName())){
                        if(mdIn.getParameters().size()==paramList.size()){
                            boolean ok = true;
                            for(int i=0;i<mdIn.getParameters().size();i++){
                                if(!(mdIn.getParameters().get(i).getType().compatibleWith(paramList.get(i).getType()))){
                                    ok= false;
                                }
                            }
                            if(ok){
                                Logger.error("Method "+mdec.toStringSignature()+" déja existante \n ");
                            }
                        } 
                    }
                }
                return true;
            }else{
                return (!this.contains(_declaration.getName()));
            }
        }
    
        /* (non-Javadoc)
         * @see fr.n7.stl.block.ast.scope.Scope#register(fr.n7.stl.block.ast.scope.Declaration)
         */
        @Override
        public void register(Declaration _declaration) {
            if(_declaration instanceof ConstructorDeclaration cdecl){
                this.constructorDeclarations.add(cdecl);
            } else if(_declaration instanceof FunctionDeclaration mdecl){
                ArrayList<FunctionDeclaration> mdeclist;
                if(this.methodDeclarations.containsKey(mdecl.getName())){
                   mdeclist = this.methodDeclarations.get(mdecl.getName());
                   mdeclist.add(mdecl);
                } else{
                   mdeclist = new ArrayList<>();
                   mdeclist.add(mdecl);
                }
                this.methodDeclarations.put(mdecl.getName(),mdeclist);
            }else {
                if (this.accepts(_declaration)) {
                    this.declarations.put(_declaration.getName(), _declaration);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    
        /* (non-Javadoc)
         * @see fr.n7.stl.block.ast.scope.HierarchicalScope#knows(java.lang.String)
         */
        @Override
        public boolean knows(String _name) {
            if (this.contains(_name)) {
                return true;
            } else {
                if (this.context != null) {
                    if (this.context instanceof HierarchicalScope<?>) {
                        return ((HierarchicalScope<?>)this.context).knows(_name);
                    } else {
                        return this.context.contains(_name);
                    }
                } else {
                    return false;
                }
            }
        }

        /* (non-Javadoc)
         * @see fr.n7.stl.block.ast.scope.HierarchicalScope#knows(java.lang.String)
         */
        public boolean knowsConstructor(String _name) {
            if (this.contains(_name)) {
                return true;
            } else {
                if (this.context != null) {
                    if (this.context instanceof HierarchicalScope<?>) {
                        return ((HierarchicalScope<?>)this.context).knows(_name);
                    } else {
                        return this.context.contains(_name);
                    }
                } else {
                    return false;
                }
            }
        }

        
        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            String _local = "";
            if (this.context != null) {
                _local += "Hierarchical definitions :\n" + this.context.toString();
            }
            _local += "Local definitions : ";
            for (Entry<String,Declaration> _entry : this.declarations.entrySet()) {
                _local += _entry.getKey() + " -> " + _entry.getValue().toString() + "\n";
            }
            return _local;
        }

        @Override
        public Declaration getThisClass() {
            return this.classD;
        }
    
    }
