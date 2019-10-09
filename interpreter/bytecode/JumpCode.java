package interpreter.bytecode;

public abstract class JumpCode extends ByteCode{
    public abstract void setDestAddress(int destAddress);
    public abstract String getFuncName();
}
