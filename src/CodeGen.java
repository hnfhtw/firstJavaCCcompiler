import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGen {
	private FileWriter out;
	
	public CodeGen(String filename){
		try {
			out = new FileWriter(filename, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void emitTest(String text){
		try {
			out.write(text + '\n');
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
