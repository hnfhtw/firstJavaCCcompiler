import java.util.ArrayList;
import java.util.HashMap;

public class Namelist {
	private int m_spix;
	
	// name -> spix
	private HashMap<String, Integer> m_nameIndices;
	
	// spix -> name
	private ArrayList<String> m_names;

	public Namelist(){
		m_spix = 0;
		m_nameIndices = new HashMap<String, Integer>();
		m_names = new ArrayList<String>();
	}
	
	public String nameOf(int spix){
		String name = m_names.get(spix);
		return name;
	}
	
	public int spixOf(String name){
		int spix = m_nameIndices.get(name);
		return spix;
	}
	
	public void add(String name){
		m_nameIndices.put(name, m_spix);
		m_names.add(m_spix, name);
		++m_spix;
	}
}
