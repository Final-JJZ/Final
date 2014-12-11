import java.io.FileWriter;

public class uroboros {

	public static void main(String[] args) {
    
        String c = "%CCODE%";
        String cpp = "%CPPCODE%";
        String java = "%JAVACODE%";
        String python = "%PYTHONCODE%";
        
        String next = "";
        
		FileWriter writer = new FileWriter("uroboros.py");
        writer.write(next);
        writer.close();
        
        Runtime.getRuntime().exec("python uroboros.py")
	}
    
}
