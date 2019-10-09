package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Lit extends ByteCode {
    private int num;
    private String labelName;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("LIT " + num);
        vm.getRunStack().push(num);
    }

    @Override
    public void init(ArrayList<String> args) {
        num = Integer.parseInt(args.get(0));
        //Check size of args. If larger than 1, assign second arg to labelName
        if(args.size()>1)
            labelName=args.get(0);
    }
}
