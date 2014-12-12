import java.io.FileWriter;

public class uroboros {

	public static void main(String[] args) {
	
		String c = "%CCODE%";
		String cpp = "%CPPCODE%";
		String java = "%JAVACODE%";
		String python = "%PYTHONCODE%";
		
		String next = python;
		
		FileWriter writer = new FileWriter("uroboros.py");
		writer.write(next);
		writer.close();
		
		String newArgs = args[0];
		if (args.length > 2) {
			for () {
			
			}
		}
		
		Runtime.getRuntime().exec("python uroboros.py")
	}
	
}
