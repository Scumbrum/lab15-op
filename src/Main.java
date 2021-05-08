import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> files  = new ArrayList<>();
        files.add("first.txt");
        files.add("second.txt");
        files.add("third.txt");
        System.out.println("Результати");
        System.out.println("За допомогою багатьох потоків");
        SimplyThreadInput first = new SimplyThreadInput(files);
        System.out.println(Finder.find(first));
        System.out.println("За допомогою одного потока");
        MultiThreadInput second = new MultiThreadInput(files);
        System.out.println(Finder.find(second));
        System.out.println("Час для читання за допомогою багатьох потоків");
        System.out.println(Timecounter.count(first::input));
        System.out.println("Час для читання за допомогою одоного потока");
        System.out.println(Timecounter.count(second::input));
    }
}
