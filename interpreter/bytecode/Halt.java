package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Halt extends ByteCode {
    @Override
    public void execute(VirtualMachine vm) {
        vm.setRunningState(false);
        System.out.println("HALT");
    }

    @Override
    public void init(ArrayList<String> args) {}
}
