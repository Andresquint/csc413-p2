package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runStack;
    private Stack<Integer> returnAddrs;
    private Program        program;
    private int            pc;
    private boolean        isRunning;
    //add boolean dump

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            pc++;
        }
    }

    public boolean setRunningState(boolean b){
        return isRunning = b;
    }

    public void dump(){

    }

    public int peek(){
       return runStack.peek();
    }


    public int push(int i){
        return runStack.push(i);
    }

    public int pop(){
        return runStack.pop();
    }

    public int store(int offset){
        return runStack.store(offset);
    }

    public int load(int offset){
        return runStack.load(offset);
    }

    public void newFrameAt(int offset){
        runStack.newFrameAt(offset);
    }

    public void popFrame(){
        runStack.popFrame();
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public Stack<Integer> getReturnAddrs() {
        return returnAddrs;
    }
}
