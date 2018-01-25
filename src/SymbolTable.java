
public class SymbolTable {
	public int curLevel;
	public Scope curScope;
	public final static CodeGen vargen = new CodeGen("var.txt");
	
	public SymbolTable(){
		curLevel = 0;
		curScope = new Scope(curLevel, null);
	}
	
	public void enterScope(){
		++curLevel;
		Scope temp = curScope;
		curScope = new Scope(curLevel, temp);
	}
	
	public void leaveScope(){
		--curLevel;
		Scope temp = curScope.outer;
		temp.nextInner = curScope;
		curScope = temp;
	}
	
	public void insert(Symbol s){					// while inserting write file containing constants, globals and locals + their addresses
		if(curScope.nrOfLocals == 0){
			if(s.kind == Symbol.Kind.constKind){
				s.addr  = curScope.nrOfConstants;
				vargen.emitTest("CONSTANT " + s.name + " ADDR " + s.addr + " SCOPE " + curScope.level);
				++curScope.nrOfConstants;
			}
			else{
				s.addr  = curScope.nrOfLocals;
				if(s.kind == Symbol.Kind.varKind){
					vargen.emitTest("VAR " + s.name + " ADDR " + s.addr + " SCOPE " + curScope.level);					
				}
				++curScope.nrOfLocals;
			}
			curScope.locals = s;
			
			return;
		}
		
		Symbol end = curScope.locals;
		while(end.next != null){
			end = end.next;
		}
		if(s.kind == Symbol.Kind.constKind){
			s.addr  = curScope.nrOfConstants;
			vargen.emitTest("CONSTANT " + s.name + " ADDR " + s.addr + " SCOPE " + curScope.level);
			++curScope.nrOfConstants;
		}
		else{
			s.addr  = curScope.nrOfLocals;
			if(s.kind == Symbol.Kind.varKind){
				vargen.emitTest("VAR " + s.name + " ADDR " + s.addr + " SCOPE " + curScope.level);			
			}
			++curScope.nrOfLocals;
		}
		end.next = s;
	}
		
	public Symbol lookup(String str){		// start search in current scope and recursively search outwards
		Scope scope = curScope;
		//Symbol run = curScope.locals;
		Symbol run = scope.locals;
		while(scope.outer != null){
			while(run != null){
				if(run.name.equals(str)){
					return run;
				}
				run = run.next;
			}
			scope = scope.outer;
			run = scope.locals;
		}
		
		return null;
	}
	
}
