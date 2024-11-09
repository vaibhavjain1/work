package noUse;

import java.net.Inet4Address;
import java.util.LinkedHashMap;
import java.util.Map;

interface CacheNew{
    Object getObject(Integer i);
    void putObject(Integer i, String j);
}

public class LRUNew implements CacheNew{
    int maxSize = 10;

    LinkedHashMap<Integer, String> cacheMap = new LinkedHashMap<>();

    @Override
    public Object getObject(Integer i) {
        String object = cacheMap.remove(i);
        if(object!=null)
            cacheMap.put(i, object);
        return object;
    }

    @Override
    public void putObject(Integer i, String j) {
        if(cacheMap.size() == maxSize){
            int count = 0;
            Integer entrytodelete = null;
            for (Map.Entry<Integer, String> entry: cacheMap.entrySet()){
                if(count == maxSize){
                    entrytodelete = entry.getKey();
                }
            }
            cacheMap.remove(entrytodelete);
        }
        cacheMap.put(i, j);
    }

    public static void main(String[] args) {

    }
}
