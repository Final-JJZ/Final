import java.io.FileWriter;

public class uroboros {

	public static void main(String[] args) {
    
        String c = "%CCODE%";
        String cpp = "%CPPCODE%";
        String java = "%JAVACODE%";
        String python = "%PYTHONCODE%";
        
		FileWriter writer = new FileWriter("uroboros.py");
        for (FileType type : map.keySet()) {
            //System.out.println("Writing: \n" + map.get(type));
            writer.write(python);
        }
        writer.close();
        
        Runtime.getRuntime().exec("python uroboros.py")
	}
    
}
