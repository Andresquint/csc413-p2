package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Pop extends ByteCode {
    private int popNum;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("POP "+popNum);
        while(popNum != 0) {
            vm.getRunStack().pop();
            popNum--;
        }
    }

    @Override
    public void init(ArrayList<String> args) {
            popNum = Integer.parseInt(args.get(0));
    }
}
