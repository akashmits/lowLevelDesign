import lombok.Data;
import org.springframework.data.util.Pair;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Set;


@Data
class CustomExpitedKey implements Comparator{
        String key;
        Date time;

    public int compare(CustomExpitedKey o1, CustomExpitedKey o2) {

        if(o1 !=null && o2 !=null){
            return o1.getTime().compareTo(o2.getTime());
        }

        return -1;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
public class HashMapCustom {


    //key add ,ttl over key get expired
    // ttl predefied?
    // ttl , key, value ,ttl , 10 minutes //dynamic
    // type
    //Map<>

    // key, expiredtime // sortedMap
    Set<CustomExpitedKey> customExpiredKey;
    Map<String, Pair<String, Date>> map;

    public HashMapCustom(){

    }

    public void put(String key,String value, int ttl)
    {
        Pair<String, Date> pair= map.get(key);

        if(pair ==null){
           // pair= new Enti
        }

    }


    //get


    //delete


    // 1minute
    //scheduler


    public static void main(String [] arg){

        HashMapCustom cache= new HashMapCustom();

      //  cacheput(); //"akash" , "gwalior", 300

    }

}



