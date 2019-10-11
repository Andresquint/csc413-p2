package interpreter.bytecode;
import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LabelCode extends ByteCode {

    private String label;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("LABEL " + label);
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public String getLabel(){
        return label;
    }
}
