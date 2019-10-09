package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.*;

public class Read extends ByteCode {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("Input a number:");
        //Scan user's input to add it to array
        int userInput = scanner.nextInt();
        vm.getRunStack().push(userInput);
    }

    @Override
    public void init(ArrayList<String> args) {}
}
