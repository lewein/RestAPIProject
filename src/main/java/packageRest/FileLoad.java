package packageRest;


import java.io.*;

public class FileLoad {

    public File dir = new File("~/Java/RestAPIProject");
    public FileLoad() {}

    public void writeFile(String name, String text) throws IOException {
        try (FileWriter writer = new FileWriter(name, false)) {
            writer.write(text);
            writer.flush();
        }
    }


    public String readFile(String name){
        String result = "";
        try(FileInputStream fin=new FileInputStream(name)) {
            int i=-1;
            while((i=fin.read())!=-1){
                result +=(char)i;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }


}
