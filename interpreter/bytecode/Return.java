package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Return extends ByteCode {
    private String funcName;
    private int returnValue;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("RETURN");
        vm.popFrame();
        vm.setPc(vm.getReturnAddrs().pop());
        returnValue = vm.peek();
    }

    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty())
            funcName = args.get(0);
    }


}
