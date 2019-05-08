package cn.joim.design_patterns.lru_cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现LruCache的几个关键方法:
 * <p>
 * 1. LinkedHashMap & accessOrder;
 * 2. put():移除可能存在的旧value,添加后需要重新精简Map的长度;
 * 3. remove()
 */
public class LurCache<K, V> {

    private final LinkedHashMap<K, V> mCache;

    private int currentSize;

    private int maxSize;

    public LurCache(int maxSize) {
        this.maxSize = maxSize;
        mCache = new LinkedHashMap(0, 0.75F, true);
    }

    public V put(K key, V value) {
        int size = sizeOf(key, value);
        currentSize += size;

        V previous = mCache.put(key, value);
        if (previous != null) {
            entryRemoved(key, previous, value);
        }
        trimToSize(maxSize);
        //mCache.get(key);
        return previous;
    }

    public V get(K key) {
        return mCache.get(key);
    }

    public V remove(K key) {
        V previous = mCache.remove(key);
        currentSize -= sizeOf(key, previous);
        if (previous != null) {
            entryRemoved(key, previous, null);
        }
        return previous;
    }

    private void trimToSize(int size) {
        if (currentSize <= size) {
            return;
        }
        Iterator<Map.Entry<K, V>> iterator = mCache.entrySet().iterator();
        while (iterator.hasNext() && currentSize <= size) {
            Map.Entry<K, V> entry = iterator.next();
            iterator.remove();
            currentSize -= sizeOf(entry.getKey(), entry.getValue());
            entryRemoved(entry.getKey(), entry.getValue(), null);
        }
    }

    protected int sizeOf(K key, V value) {
        return 1;
    }

    protected void entryRemoved(K key, V oldValue, V newValue) {

    }
}
