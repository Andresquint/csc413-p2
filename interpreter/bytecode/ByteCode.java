package interpreter.bytecode;

import java.util.ArrayList;

public abstract class ByteCode {
    public abstract void execute();
    public abstract void init(ArrayList<String> args);
}
