package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump(){

    }

    public int peek(){
        int lastElement = runTimeStack.size()-1;
        return runTimeStack.get(lastElement);
    }

    public int push(int i){
        runTimeStack.add(i);
        return i;
    }

    public int pop(){
        int lastElement = runTimeStack.size()-1;
        int valuePopped = runTimeStack.get(lastElement);
        runTimeStack.remove(lastElement);

        return valuePopped;
    }

    public int store(int offset){
        int lastElement = runTimeStack.size()-1;

        return lastElement;
    }

    public int load(int offset){
        int value = runTimeStack.get(framePointer.peek()-offset);
        runTimeStack.add(value);
        return value;
    }

    public void newFrameAt(int offset){
        framePointer.add(runTimeStack.size()-offset);
    }

    public void popFrame(){
        if(framePointer.peek() != 0)
            framePointer.pop();
    }
    
}
