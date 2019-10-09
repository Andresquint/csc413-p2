package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Load extends ByteCode {
    private int offset;
    private String id;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("LOAD " + id);
        vm.getRunStack().load(offset);
    }

    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size()>1)
            id = args.get(1);
    }
}
