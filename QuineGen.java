import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java master race.
 * @author James Bilbrey (bilbrey1@umbc.edu)
 */
public class QuineGen {
	
	public enum FileType {
		C("c", "%CCODE%"),
		CPP("cpp", "%CPPCODE%"),
		GROOVY("groovy", "%GROOVYCODE%"),
		JAVA("java", "%JAVACODE%"),
		JAVASCRIPT("js", "%JSCODE%"),
		PERL("pl", "%PERLCODE%"),
		PYTHON("py", "%PYTHONCODE%"),
		RUBY("rb", "%RUBYCODE%");
		
		private final String extension, replacer;
		
		private FileType(String ext, String rep) {
			extension = ext;
			replacer = rep;
		}
		
		public String getExt() {
			return extension;
		}
		
		public String getReplacer() {
			return replacer;
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
	
	public static class Language {
		
		FileType type;
		String original;
		String oneLine;
		public Language(FileType t, String o) {
			type = t;
			original = o;
		}
		
		public String getOriginal() {
			return original;
		}

		public String getOneLine() {
			return oneLine;
		}

		public void setOneLine(String oneLine) {
			this.oneLine = oneLine;
		}
	}

    public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("rm -f Final.*");
		} catch (IOException ex) {
			Logger.getLogger(QuineGen.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		// args are extensions
		HashMap<FileType, Language> map = new HashMap<FileType, Language>();
		
		try {
			contents(map);
			
			oneliner(map);
		
//			FileWriter stringsWriter = new FileWriter("strings.txt");
			for (FileType typeA : map.keySet()) {
				String original = map.get(typeA).getOriginal();
				if (FileType.JAVA.equals(typeA)) {
					original = original.replaceFirst(" uroboros ", " Final ");
				}
				for (FileType typeB : map.keySet()) {
					original = original.replaceAll(typeB.getReplacer(), map.get(typeB).getOneLine());
				}
//				stringsWriter.write(typeA.name() + (typeA.name().length() < 3
//						? ":\t\t" : ":\t") + map.get(typeA).getOneLine() + "\n");
				FileWriter finalWriter = new FileWriter("Final." + typeA.getExt());
				finalWriter.write(original);
				finalWriter.close();
			}
//			stringsWriter.close();
			
		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		System.out.println("Operation successful.");
    }
	
	public static void contents(HashMap<FileType, Language> map) throws IOException {
		
		File files[] = (new File(".")).listFiles();
		for (File file : files) {
			if (file.getName().startsWith("working")) {
				String ext = file.getName().split("\\.")[1];
				byte[] encoded = Files.readAllBytes(file.toPath());
				FileType type = FileType.getByExt(ext);
				map.put(type, new Language(type, new String(encoded, Charset.defaultCharset())));
			}
		}
	}
	
	public static void oneliner(HashMap<FileType, Language> map) {
		for (FileType key : map.keySet()) {
			map.get(key).setOneLine(map.get(key).getOriginal().replaceAll("\"", "\\\\\\\"")
					.replaceAll("\t", "\\t").replaceAll("\n", "\\\n"));
		}
	}
}
