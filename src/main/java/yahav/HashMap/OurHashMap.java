package yahav.HashMap;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class OurHashMap<K,V> implements Map<K,V> {

    private final int SIZE = 16;

    class Entry<K,V> { //Object with key and value defining features
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Entry> values[] = new List[SIZE]; //values is list of objects

    //returns # of key-values
    @Override
    public int size() {
        int size = 0;
        for(List<Entry> list : values){
            if (list != null) {
                size += list.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (List<Entry> list : values) {
            if(list != null){
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean containsKey(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List list = values[index];
        for (Entry<K,V> entry : (List<Entry<K,V>>) list){
            if(entry.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<Entry> list : values){
            if (list != null) {
                for(Entry entry: list){
                    if (entry.value.equals(value)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if (list == null) {
            return null;
        }
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return (V) entry.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List list = values[index];
        if (list == null) {
            list = new ArrayList<Entry>();
            values[index] = list;
        }

        for (Entry<K,V> entry : (List<Entry<K,V>>) list) {
            if (entry.key.equals(key)) {
                V saved = entry.value;
                entry.value = value;
                return saved;
            }
        }

        Entry entry = new Entry(key,value);
        list.add(entry);
        return null;
    }

    //given the key removes the key and value
    @Override
    public V remove(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if (list != null)
            for (Entry entry : list) {
                    if (entry.key == key) {
                        V value = (V) entry.value;
                        list.remove(entry);
                        return value;
                    }
            }
        return null;
    }

    //given Map m go through this map and put them all in a second map.
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
            for (K key : m.keySet())
            {
                put(key, m.get(key));
            }
    }

    //remove all keys and values
    @Override
    public void clear() {
        for(List<Entry> list : values){
            if(list != null){
                list.clear();
            }
        }
    }

    @Override
    public Set keySet() {
        Set<K> keySet = new HashSet<>();
        for(List<Entry> list : values){
            if(list != null){
                for(Entry entry : list) {
                    keySet.add((K)entry.key);
                }
            }
        }
        return keySet;
    }

    //print all values in the map
    @Override
    public Collection values() {
        Collection<V> valueCollection = new HashSet<>();
        for(List<Entry> list : values) {
            if (list != null) {
                for (Entry entry : list) {
                    valueCollection.add((V) entry.value);
                }
            }
        }
        return valueCollection;
    }

    @Override
    public Set<java.util.Map.Entry<K,V>> entrySet() {
        return null;
    }
}

