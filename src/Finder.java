import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Finder {
    public static ArrayList<String> find(InputMethod method){
        ArrayList<String> words = separator(method.input());
        Map<String, Integer> map = new HashMap<>();
        int max =0;
        ArrayList<String> oftenWord = null;
        for(String word : words){
            if(map.get(word)!=null){
                map.put(word,map.get(word)+1);
            } else {
                map.put(word,1);
            }
            if(max<map.get(word)){
                max = map.get(word);
                oftenWord=new ArrayList<>();
                oftenWord.add(word);
            } else if(max==map.get(word)){
                oftenWord.add(word);
            }
        }
        return oftenWord;
    }
    private static ArrayList<String> separator(String string){
        StringBuffer temp=new StringBuffer();
        ArrayList<String> list = new ArrayList<>();
        for(int i= 0;i<string.length();i++){
            if(string.charAt(i)==' '){
                list.add(temp.toString());
                temp = new StringBuffer();
                continue;
            }
            temp.append(string.charAt(i));
        }
        return list;
    }
}
