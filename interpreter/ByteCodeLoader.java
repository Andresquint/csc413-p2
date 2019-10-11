
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        //Create new program object
        Program program = new Program();
        //Set string tokenizer to null
        StringTokenizer tokenizer = new StringTokenizer(null);

        //Handle exceptions in try/catch block. Try initialize tokenizer with the byteSource
        try {
            tokenizer = new StringTokenizer(byteSource.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //If not null, loop over tokenizer
        while(tokenizer != null){
            String className = CodeTable.getClassName(tokenizer.nextToken());

            //Set bytecode className and create arguments arraylist
            try {
                ByteCode bc = (ByteCode)(Class.forName("interpreter.bytecode."+className).newInstance());
                ArrayList<String> args = new ArrayList<>();

                //Loop over tokenizer. While it has more tokens, add them to ArrayList
                while(tokenizer.hasMoreTokens()){
                    args.add(tokenizer.nextToken());
                }

                bc.init(args);
                program.add(bc);
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        program.resolveAddrs();
        return program;
    }

}
