package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class Call extends ByteCode {
    private String funcName;
    private int destAddress;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("CALL " + funcName + " " + destAddress);



    }

    @Override
    public void init(ArrayList<String> args) {
        funcName = args.get(0);
    }

    public String getFuncName(){
        return funcName;
    }

    public int getDestAddress(){
        return destAddress;
    }

    public void setDestAddress(int destAddress) {
        this.destAddress = destAddress;
    }
}
