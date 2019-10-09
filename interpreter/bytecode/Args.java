package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Args extends ByteCode {

    private int numArgs;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("ARGS"+numArgs);
        vm.getRunStack().newFrameAt(numArgs);
    }

    @Override
    public void init(ArrayList<String> args) {
        numArgs = Integer.parseInt(args.get(0));
    }
}
