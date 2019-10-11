package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.*;

public class ReadCode extends ByteCode {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("Input a number:");
        //Scan user's input to add it to array
        int userInput = scanner.nextInt();
        vm.push(userInput);
    }

    @Override
    public void init(ArrayList<String> args) {}
}
