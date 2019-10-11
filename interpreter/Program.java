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
        if(bc instanceof LabelCode){
            LabelCode label = (LabelCode) bc;
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
        //for every bytecode(1st) in program:
        for (ByteCode bc1 : program) {
            //if bytecode instance of JumCode
            if(bc1 instanceof JumpCode){
                //for every bytecode (2nd) in program
                for(ByteCode bc2 : program){
                    //if bytecode (2nd) instanceof label
                    if(bc2 instanceof LabelCode){
                        //if bytecode(1st).args == bytecode(2nd).args;
                        if(((JumpCode) bc1).getFuncName() == ((LabelCode) bc2).getLabel()){
                            //set bytecode(1st) argument to index of bytecode(2nd)
                            ((JumpCode) bc1).setDestAddress(bCodeLabels.get(bc2));
                        }
                    }

                }
            }
        }


    }

}
