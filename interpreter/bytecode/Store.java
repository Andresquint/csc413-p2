package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Store extends ByteCode {
    private String id="";
    private int offset;
    private int topValue;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("STORE "+ id + " " + topValue);
        topValue = vm.getRunStack().pop();
        vm.getRunStack().store(offset);
    }

    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size()>1)
            id = args.get(1);
    }
}
