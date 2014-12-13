import java.io.FileWriter;
import java.io.IOException;

public class uroboros {

	public static void main(String[] args) {
	
		String c = "%CCODE%";
		String cpp = "%CPPCODE%";
		String java = "%JAVACODE%";
		String python = "%PYTHONCODE%";
		
        String next = c.replaceAll("\n", "%N").replaceAll("\t", "%T").replaceAll("%Q", "\"");
        next = next.replaceFirst("%PYTHONCODE%", python).replaceFirst("%Q", java).replaceFirst("%CPPCODE%", cpp).replaceFirst("%CCODE%", c);
		
		try {
            FileWriter writer = new FileWriter("uroboros.c");
            writer.write(next);
            writer.close();
        } catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		String newArgs = args[0];
		if (args.length > 2) {
			for (int i = 2; i < args.length; i++) {
                newArgs += args[i];
			}
		}
        newArgs += args[1];
		
		try {
            Runtime.getRuntime().exec("g++ -ansi -Wall uroboros.c -o uroboros.o");
            Runtime.getRuntime().exec("./uroboros.o " + newArgs);
        } catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
}
