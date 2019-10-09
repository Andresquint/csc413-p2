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

    /**
     * Used for dumping the current state of runTimeStack.
     * It prints portions of the stack based on respective frame markers.
     */
    public void dump(){

    }

    /**
     * returns top of runtime stack without removing
     * @return copy of the top of the stack
     */
    public int peek(){
        int lastElement = runTimeStack.size()-1;
        return runTimeStack.get(lastElement);
    }

    /**
     * push value i to top of the stack
     * @param i value to be pushed
     * @return value pushed
     */
    public int push(int i){
        runTimeStack.add(i);
        return i;
    }

    /**
     * removes top of runtime stack
     * @return value popped
     */
    public int pop(){
        int lastElement = runTimeStack.size()-1;
        int valuePopped = runTimeStack.get(lastElement);
        runTimeStack.remove(lastElement);

        return valuePopped;
    }

    /**
     * Takes top item of runtime stack and stores it into an offset
     * starting from current frame
     * @param offset
     * @return item just stored
     */
    public int store(int offset){
        int lastElement = runTimeStack.size()-1;
        int topValue = runTimeStack.get(lastElement);
        runTimeStack.remove(lastElement);
        //Store offset starting from current frame
        runTimeStack.set(framePointer.peek()+offset, topValue);
        return topValue;
    }

    /**
     * Takes value from runtime stack that is at offset from current frame
     * and pushes it onto top of stack
     * @param offset
     * @return item just loaded
     */
    public int load(int offset){
        int value = runTimeStack.get(framePointer.peek()-offset);
        runTimeStack.add(value);
        return value;
    }

    /**
     * Create a new frame pointer at the index offset slots down from the top
     * of the runtime stack
     * @param offset
     */
    public void newFrameAt(int offset){
        framePointer.add(runTimeStack.size()-offset);
    }

    /**
     * Pop current frame off the runtime stack. Also removes the frame
     * pointer value from FramePointer stack
     */
    public void popFrame(){
        int lastElement = runTimeStack.size()-1;
        int value = runTimeStack.get(lastElement);
        while(runTimeStack.size() != framePointer.peek())
            runTimeStack.remove(lastElement);
        if(framePointer.peek() != 0)
            framePointer.pop();
        runTimeStack.add(value);
    }
    
}
