package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Return extends ByteCode {
    private String funcName;
    private int returnValue;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("RETURN");
        vm.getRunStack().popFrame();
        vm.setPc(vm.getReturnAddrs().pop());
        returnValue = vm.getRunStack().peek();
    }

    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty())
            funcName = args.get(0);
    }


}
