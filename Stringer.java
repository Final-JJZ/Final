import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;

/**
 * 
 * @author James Bilbrey (bilbrey1@umbc.edu)
 */
public class Stringer {
	
	public enum FileType {
		C("c"),
		CPP("cpp"),
		GROOVY("groovy"),
		JAVA("java"),
		JAVASCRIPT("js"),
		PERL("pl"),
		PYTHON("py"),
		RUBY("rb");
		
		private final String extension;
		
		private FileType(String ext) {
			extension = ext;
		}
		
		public String getExt() {
			return extension;
		}
		
		public static String getExtFor(FileType type) {
			return type.extension;
		}
		
		public static FileType getByExt(String ext) {
			for (FileType type : values()) {
				if (type.extension.equals(ext)) {
					return type;
				}
			}
			return null;
		}
	}

    public static void main(String[] args) {
		
		// args are extensions
		HashMap<FileType, String> map = new HashMap<FileType, String>();
		
		try {
			contents(args, map);
			
			oneliner(map);
		
			FileWriter writer = new FileWriter("strings.txt");
			for (FileType type : map.keySet()) {
				//System.out.println("Writing: \n" + map.get(type));
				writer.write(type.name() + (type.name().length() < 4
						? ":\t\t" : ":\t") + map.get(type) + "\n");
			}
			writer.close();
			
		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		System.out.println("Strings are sorted by langauge in strings.txt\nOperation successful.");
    }
	
	public static void contents(String[] exts, HashMap<FileType, String> holder) throws FileNotFoundException, IOException {
		
		//System.out.println("Number of files: " + exts.length);
		File files[] = (new File(".")).listFiles();
		for (File file : files) {
			if (file.getName().startsWith("working")) {
				String ext = file.getName().split("\\.")[1];
				byte[] encoded = Files.readAllBytes(file.toPath());
				holder.put(FileType.getByExt(ext), new String(encoded, Charset.defaultCharset()));
			}
		}
//		for (String ext : exts) {
//			File file = new File("working." + ext);
//			//long size = Files.size(file.toPath());
//			//System.out.println("Size of " + file.getName() + ": " + size);
//			byte[] encoded = Files.readAllBytes(file.toPath());
//			holder.put(FileType.getByExt(ext), new String(encoded, Charset.defaultCharset()));
//		}
		
		/*for(int i=0; i < exts.length; i++) {
			File file = new File(exts[i]);
			long size = Files.size(file.toPath());
			System.out.println("Size of " + exts[i] + ": " + size);
//			FileReader reader = new FileReader(file);
//			CharBuffer buffer = CharBuffer.allocate((int) size);
//			reader.read(buffer);
//			reader.close();
//			ret[i] = buffer.toString();
			byte[] encoded = Files.readAllBytes(file.toPath());
			ret[i] = new String(encoded, Charset.defaultCharset());
			System.out.println("Read: \n" + ret[i]);
		}*/
	}
	
	public static void oneliner(HashMap<FileType, String> contents) {
		for (FileType key : contents.keySet()) {
			contents.put(key, contents.get(key).replaceAll("\"", "\\\\\"")
					.replaceAll("\t", "\\\\t").replaceAll("\n", "\\\\n"));
		}
		/*for (int i = 0; i < contents.length; i++) {
			contents[i] = contents[i].replaceAll("\"", "\\\\\"");
			contents[i] = contents[i].replaceAll("\t", "\\\\t");
			contents[i] = contents[i].replaceAll("\n", "\\\\n");
		}*/
		//return contents;
	}
}
