package datastructure;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// convery hashmap into list
public class ConvertHashMapIntoList {
    public static void main(String [] arg){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(7,5);
        map.put(5,6);
        map.put(6,7);
        map.put(null,0);

        List<Map.Entry<Integer, Integer>> list =map.entrySet().stream().toList();

        System.out.println("List :"+list);

    }
}
