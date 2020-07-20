import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
public class ReplaceString {

	
	
	 BufferedReader reader = null;
	public static void main(String[] args) throws IOException {
		 File folder = new File("D:\\change_jquery\\views");
		
		ReplaceString replaceString = new ReplaceString();
		//reading files Java8 - Using Files.walk() method
		replaceString.listAllFiles(folder.toString());

	}
	
	 // Uses Files.walk method   
    public void listAllFiles(String path){
     
       
    	try(Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {
                        readContent(filePath);
                    } catch (Exception e) {
                       
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
          
            e.printStackTrace();
        } 
    }
	
    public void readContent(Path filePath) throws IOException{
    	String newContent=new String();
    	String oldContent=new String();
    	System.out.println("read file " + filePath);
    	
    	File yourFile = new File("D:\\change_jquery\\change\\"+filePath.getFileName());
    	yourFile.createNewFile(); // if file already exists will do nothing 
    	FileOutputStream output = new FileOutputStream(yourFile, false); 
    	// BufferedWriter output = new BufferedWriter(yourFile);
 	         
        List<String> fileList = Files.readAllLines(filePath);
        try{
       for(String line:fileList){
        
        	 oldContent = oldContent + line + System.lineSeparator();
        	
        }
        
       
            newContent = oldContent.replaceAll("utf-8", "UTF-8");
            newContent = newContent.replaceAll("ISO-8859-1", "UTF-8");
           
       output.write(newContent.getBytes());
        output.close();
       
       
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       
    }

}
