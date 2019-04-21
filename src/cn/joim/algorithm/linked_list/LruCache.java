package cn.joim.algorithm.linked_list;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * implement LRU cache。
 * 1. use LinkedHashMap;
 * 2. trimToSize while put();
 * 3. release old Value while put new item;
 * 4. manage item size.
 */
public class LruCache<Key, Value> {

    private final LinkedHashMap<Key, Value> map;

    private int currentSize;
    private int maxSize;

    public LruCache(int capacity) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        maxSize = capacity;
        map = new LinkedHashMap<Key, Value>(capacity, 0.75f, true);
    }

    /**
     * @return previous value of key or null.
     */
    public Value put(Key key, Value value) {
        if (key == null || value == null) {
            return null;
        }
        currentSize += sizeOf(key, value);
        Value previousItem = map.put(key, value);
        if (previousItem != null) {
            currentSize -= sizeOf(key, previousItem);
        }
        trimToSize(maxSize);
        return previousItem;
    }

    public Value get(Key key) {
        return map.get(key);
    }

    protected int sizeOf(Key key, Value value) {
        return 1;
    }

    protected void trimToSize(int size) {
        if (currentSize > size) {
            Iterator<Map.Entry<Key, Value>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Key, Value> item = iterator.next();

                currentSize -= sizeOf(item.getKey(), item.getValue());
                iterator.remove();
                if (currentSize <= size) {
                    break;
                }
            }
        }
    }
}
