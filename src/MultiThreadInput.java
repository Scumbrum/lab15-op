import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MultiThreadInput implements InputMethod{
    ArrayList<String> files;

    public MultiThreadInput(ArrayList<String> files) {
        this.files = files;
    }

    @Override
    public String input(){
        return doInput();
    }

    private String doInput() {
        StringBuffer sb = new StringBuffer();

    class RunInput implements Runnable{
        String file;
        public RunInput(String file) {
            this.file=file;
        }
        @Override
        public void run() {
            try (FileReader reader = new FileReader(file);
                 BufferedReader bf = new BufferedReader(reader)){
                synchronized (sb) {
                    String line;
                    while ((line = bf.readLine()) != null) {
                        sb.append(line);
                        sb.append(' ');
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    ArrayList<RunInput> runs = new ArrayList<>();
    ArrayList<Thread> threads = new ArrayList<>();
    for(String file :files) {
        runs.add(new RunInput("E:\\1 курс\\прога\\семестр 2\\лабы\\лаба 12 (2)\\lab15-op\\src\\text\\" + file));
    }
    for (RunInput run:runs){
        threads.add(new Thread(run));
    }
    for(Thread thread:threads){
        thread.start();
    }
    try {
        for (Thread thread:threads){
            thread.join();
        }
    }catch (InterruptedException e){
        System.out.println("Something went wrong");
    }
    return sb.toString();
}
}
