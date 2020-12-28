package System_Design.Object_oriented;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/** 
 * LRU
 * IF NOT PRESENT, ADD AT FRONT
 * IF PRESENT, BRING TO FRONT
 * 
 * also update head and currLast in put
 * 1 a page class, like node of linked list
 * 2 a linked list with head and last;
 * 3 a counter to check 
 * if size < capacity, add a new page at end
 * else remove last and add new at front
*/

class LRUCache{

    class Page{
        int key;
        int value;
        String timeLastAccessed;
        Page(int k, int v){
            this.key = k;
            this.value = v;
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            System.out.println(dateobj);
            this.timeLastAccessed = df.format(dateobj);
        }
    }
    List<Page> list; 
    HashMap<Integer, Page> map; 
    int cacheSize;

    public LRUCache(int capacity) {
        this.list = new ArrayList<>(capacity);
        this.map = new HashMap<>();
        this.cacheSize = capacity;
    }

    // rearrange in get, just add in put
    public int get(int key) {
        if(map.containsKey(key)) {
            list.remove(map.get(key));
            list.add(0, map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    // least recent will be at last, evict if size exceeds
    public void put(int key, int value) {
        if(map.containsKey(key)) return;
        else{
            // if full
            if(this.cacheSize == map.size()){
                Page toBeEvicted = list.get(list.size()-1);
                map.remove(toBeEvicted.key);
                list.remove(list.size()-1);
                list.add(0, new Page(key, value));
                map.put(key, new Page(key, value));
            }
            else{
                map.put(key, new Page(key, value));
                list.add(map.get(key));
            }
        }
    }
}


// how to remove the last page from map?
// link page to map, store key in page also