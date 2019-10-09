package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranch extends ByteCode {
    private String funcName;
    private int destAddress;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("FALSEBRANCH " + funcName);
        if(vm.getRunStack().pop() == 0)
            vm.setPc(destAddress);
    }

    @Override
    public void init(ArrayList<String> args) {
        funcName = args.get(0);
    }

    public int getBranch() {
        return destAddress;
    }

    public String getLabel() {
        return funcName;
    }

    public void setBranch(int destAddress) {
        this.destAddress = destAddress;
    }
}
