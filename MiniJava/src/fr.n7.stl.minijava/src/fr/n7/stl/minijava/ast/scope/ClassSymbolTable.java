package fr.n7.stl.minijava.ast.scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.Scope;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ConstructorDeclaration;

public class ClassSymbolTable implements HierarchicalScope<Declaration> {
        
        private Map<String, Declaration> declarations;
        private ArrayList<ConstructorDeclaration> constructorDeclarations;
        protected ClassDeclaration classD;
        private Scope<Declaration> context;
    
        public ClassSymbolTable() {
        }

        public ClassSymbolTable(ClassDeclaration cd){
            this.classD = cd;
            this.declarations = new HashMap<String,Declaration>();
            this.constructorDeclarations = new ArrayList<ConstructorDeclaration>();
        }
        
        public ClassSymbolTable(Scope<Declaration> _context) {
            this.declarations = new HashMap<String,Declaration>();
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
            return (! this.contains(_declaration.getName()));
        }
    
        /* (non-Javadoc)
         * @see fr.n7.stl.block.ast.scope.Scope#register(fr.n7.stl.block.ast.scope.Declaration)
         */
        @Override
        public void register(Declaration _declaration) {
            if(_declaration instanceof ConstructorDeclaration cdecl){
                
            } else {
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
    
    }
