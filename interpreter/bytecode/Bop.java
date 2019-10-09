package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Bop extends ByteCode {

    private String operator;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("BOP "+ operator);
        int firstOp = vm.getRunStack().pop();  //Access runtime stack. Get first operand
        int secondOp = vm.getRunStack().pop(); //Access runtime stack. Get second operand
        int trueStatement = 1;
        int falseStatement = 0;

        //Evaluate operand. Cases: +, -, /, *, ==, ! =, <=, >, >=, <
        switch (operator){
            case "+":
                vm.getRunStack().push(firstOp + secondOp);
                break;
            case "-":
                vm.getRunStack().push(firstOp - secondOp);
                break;
            case "/":
                vm.getRunStack().push(firstOp / secondOp);
                break;
            case "*":
                vm.getRunStack().push(firstOp * secondOp);
                break;
            case "==":
                if(firstOp == secondOp)
                    vm.getRunStack().push(trueStatement);
                vm.getRunStack().push(falseStatement);
                break;
            case "!=":
                if(firstOp != secondOp)
                    vm.getRunStack().push(trueStatement);
                vm.getRunStack().push(falseStatement);
                break;
            case "<=":
                if(firstOp <= secondOp)
                    vm.getRunStack().push(trueStatement);
                vm.getRunStack().push(falseStatement);
                break;
            case ">":
                if(firstOp > secondOp)
                    vm.getRunStack().push(trueStatement);
                vm.getRunStack().push(falseStatement);
                break;
            case "<":
                if(firstOp < secondOp)
                    vm.getRunStack().push(trueStatement);
                vm.getRunStack().push(falseStatement);
                break;
            case ">=":
                if(firstOp >= secondOp)
                    vm.getRunStack().push(trueStatement);
                vm.getRunStack().push(falseStatement);
                break;
            default:
                vm.getRunStack().push(0);

        }
    }

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }
}
