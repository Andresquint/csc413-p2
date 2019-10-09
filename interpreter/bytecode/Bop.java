package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Bop extends ByteCode {

    private String operator;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("BOP "+ operator);
        int firstOp = vm.pop();  //Get first operand
        int secondOp = vm.pop(); //Get second operand

        //Evaluate operand. Cases: +, -, /, *, ==, ! =, <=, >, >=, <
        switch (operator){
            case "+":
                vm.push(firstOp + secondOp);
                break;
            case "-":
                vm.push(firstOp - secondOp);
                break;
            case "/":
                vm.push(firstOp / secondOp);
                break;
            case "*":
                vm.push(firstOp * secondOp);
                break;
            case "==":
                if(firstOp == secondOp)
                    vm.push(1);
                vm.push(0);
                break;
            case "!=":
                if(firstOp != secondOp)
                    vm.push(1);
                vm.push(0);
                break;
            case "<=":
                if(firstOp <= secondOp)
                    vm.push(1);
                vm.push(0);
                break;
            case ">":
                if(firstOp > secondOp)
                    vm.push(1);
                vm.push(0);
                break;
            case "<":
                if(firstOp < secondOp)
                    vm.push(1);
                vm.push(0);
                break;
            case ">=":
                if(firstOp >= secondOp)
                    vm.push(1);
                vm.push(0);
                break;
            default:
                vm.push(0);

        }
    }

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }
}
