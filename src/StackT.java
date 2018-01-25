import java.util.HashMap;
import java.util.Stack;

public class StackT {
	
	Stack<Integer> stack;
	HashMap<Integer, Integer> variables;
	
	public StackT(){
		stack = new Stack<Integer> ();
	}
	
	public int pop(){
		return stack.pop();
	}
	
	public void push(int operand){
		stack.push(operand);
	}
	
	public void set(int index, int value){
		variables.put(index, value);		// put(key, value)
	}
	
	public int get(int index){
		return variables.get(index);
	}
	
}
