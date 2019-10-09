package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranch extends JumpCode {
    private String funcName;
    private int destAddress;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("FALSEBRANCH " + funcName);
        if(vm.pop() == 0)
            vm.setPc(destAddress);
    }

    @Override
    public void init(ArrayList<String> args) {
        funcName = args.get(0);
    }

    @Override
    public void setDestAddress(int destAddress) {
        this.destAddress = destAddress;
    }

    @Override
    public String getFuncName() {
        return funcName;
    }

    public int getDestAddress(){
        return destAddress;
    }
}
