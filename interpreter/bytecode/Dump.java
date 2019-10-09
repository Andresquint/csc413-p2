package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Dump extends ByteCode {
    private boolean flag; //defines if DUMP is ON or not
    private String state;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("DUMP " + state);
        if(flag)
            vm.dump();
    }

    @Override
    public void init(ArrayList<String> args) {
        state = args.get(0);
        if(state == "ON")
            flag = true;
        flag = false;
    }

    public boolean isFlag() {
        return flag;
    }
}
