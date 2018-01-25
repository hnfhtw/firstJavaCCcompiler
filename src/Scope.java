
public class Scope {
	public Scope outer;
	public Scope nextInner;
	public int level;
	public int nrOfParams;		// not used
	public int nrOfLocals;
	public int nrOfConstants;
	public Symbol locals;
	
	public Scope(int level, Scope outer){
		this.level = level;
		this.outer = outer;
		nrOfParams = 0;		// not used
		nrOfLocals = 0;
		nrOfConstants = 0;
		locals = null;
	}
	
	
}
