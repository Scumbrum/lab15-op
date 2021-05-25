import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SimplyThreadInput implements InputMethod{
    StringBuffer sb = new StringBuffer();
    ArrayList<String> files;

    public SimplyThreadInput(ArrayList<String> files) {

        this.files=files;
    }

    @Override
    public String input() {
        for (String file:files) {
            inputFromFile("E:\\1 курс\\прога\\семестр 2\\лабы\\лаба 12 (2)\\lab15-op\\src\\text\\" + file);
        }
        return sb.toString();
    }
    private void inputFromFile(String file){
        try (FileReader reader = new FileReader(file);
             BufferedReader bf = new BufferedReader(reader)){
                String line;
                while ((line = bf.readLine()) != null) {
                    sb.append(line);
                    sb.append(' ');
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
