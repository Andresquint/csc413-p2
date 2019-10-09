package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runStack;
    private Stack<Integer> returnAddrs;
    private Program        program;
    private int            pc;
    private boolean        isRunning;

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

    public RunTimeStack getRunStack(){
        return runStack;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public Stack<Integer> getReturnAddrs() {
        return returnAddrs;
    }
}
