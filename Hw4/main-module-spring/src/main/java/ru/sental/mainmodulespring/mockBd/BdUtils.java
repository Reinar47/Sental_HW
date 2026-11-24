package ru.sental.mainmodulespring.mockBd;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class BdUtils<K, V> {

    private final Map<K, V> table;

    public void insert(K key, V value) {
        table.put(key, value);
    }

    public V get(K key) {
        return table.get(key);
    }

    public V delete(K key) {
        return table.remove(key);
    }

    public List<V> getAll() {
        return new ArrayList<>(table.values());
    }

    public boolean existsById(K id) {
        return table.containsKey(id);
    }
}

