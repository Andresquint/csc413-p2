package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Write extends ByteCode {

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.getRunStack().peek());
    }

    @Override
    public void init(ArrayList<String> args) {}
}
