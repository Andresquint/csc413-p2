package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;


public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> bCodeLabels;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public void add(ByteCode bc){
        if(bc instanceof Label){
            Label label = (Label) bc;
            bCodeLabels.put(label.getLabel(), program.size());
        }
        program.add(bc);
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */
    public void resolveAddrs() {

    }




}
