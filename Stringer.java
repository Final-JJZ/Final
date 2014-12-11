import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;

public class Stringer {

    public static void main(String[] args) {
		
		String[] files = new String[]{"working.c", "working.java"};
		
		try {
			String[] contents = contents(files);
			
			
		
			FileWriter writer = new FileWriter("strings.txt");
			for (String content : contents) {
				writer.write(content);
			}
			writer.close();
			
		} catch (FileNotFoundException ex) {
			System.err.printf(ex.getMessage());
		} catch (IOException ex) {
			System.err.printf(ex.getMessage());
		}
    }
	
	public static String[] contents(String[] filenames) throws FileNotFoundException, IOException {
		
		String[] ret = new String[filenames.length];
		
		for(int i=0; i < filenames.length; i++) {
			File file = new File(filenames[i]);
			FileReader reader = new FileReader(file);
			long size = Files.size(file.toPath());
			CharBuffer buffer = CharBuffer.allocate((int) size);
			reader.read(buffer);
			reader.close();
			ret[i] = buffer.toString();
		}
		return ret;
	}
}
