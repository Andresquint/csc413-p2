
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader {

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
        Program program = new Program();
        ArrayList<String> args = new ArrayList<>();
        String code = null;

        try {
            code = byteSource.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (code != null) {
            StringTokenizer tokenizer = new StringTokenizer(code);
            args.clear();

            String codeClass = CodeTable.getClassName(tokenizer.nextToken());
            while (tokenizer.hasMoreTokens()) {
                args.add(tokenizer.nextToken());
            }

            ByteCode bc = null;
            try {
                bc = (ByteCode) Class.forName("interpreter.bytecode." + codeClass).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            //assert handles null pointer exception
            assert bc != null;
            bc.init(args);
            program.add(bc);

            try {
                code = byteSource.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        program.resolveAddrs();
        return program;
    }
}
