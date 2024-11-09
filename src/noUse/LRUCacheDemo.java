package noUse;

import java.util.HashMap;
import java.util.Map;

interface Cache{
    void put(String data);
    String get(Integer id);
    void refresh();
}

class CacheNode{
    CacheNode previous;
    CacheNode next;
    String data;

    CacheNode(String obj){
        this.data = obj;
        this.previous = null;
        this.next = null;
    }
}

class CacheNodeList{
    CacheNode front;
    CacheNode rear;
    int currsize = 0;
    int maxsize = 10;
    void insert(CacheNode newnode){
        if(currsize == maxsize){
            deleteLast();
        }
        if(front == null){
            front = newnode;
            currsize++;
        } else {
            front.previous = newnode;
            newnode.next = front;
            front = newnode;
            currsize++;
        }
    }

    void deleteSpecific(CacheNode node){
        CacheNode tempNode = node.next;
        node.previous.next = tempNode;
        node.next.previous = node.previous;
        currsize--;
    }

    void deleteLast(){
        rear = rear.previous;
        currsize--;
    }
}

class LRUCache implements Cache{

    Map<Integer, CacheNode> lruMap = new HashMap<>();
    CacheNodeList list = new CacheNodeList();
    @Override
    public void put(String data) {
        CacheNode node = lruMap.get(data.hashCode());
        if(node == null){
            CacheNode node1 = new CacheNode(data);
            lruMap.put(data.hashCode(), node1);
            list.insert(node1);
        } else {
            list.deleteSpecific(node);
            list.insert(node);
        }
    }

    @Override
    public String get(Integer id) {
        CacheNode node = lruMap.get(id);
        if(node == null) {
            return null;
        }
        else
            return node.data;
    }

    @Override
    public void refresh() {
        // clean
    }
}

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.put("Vaibhav");
        cache.put("Jain");
        System.out.println(cache.get("Vaibhav".hashCode()));
    }
}
