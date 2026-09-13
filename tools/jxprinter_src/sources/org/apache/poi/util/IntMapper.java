package org.apache.poi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import org.apache.poi.common.Duplicatable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IntMapper<T> implements Duplicatable, Iterable<T> {
    private static final int _default_size = 10;
    private final List<T> elements;
    private final Map<T, Integer> valueKeyMap;

    public IntMapper() {
        this(10);
    }

    public boolean add(T t6) {
        int size = this.elements.size();
        this.elements.add(t6);
        this.valueKeyMap.put(t6, Integer.valueOf(size));
        return true;
    }

    public T get(int i5) {
        return this.elements.get(i5);
    }

    public List<T> getElements() {
        return this.elements;
    }

    public int getIndex(T t6) {
        return this.valueKeyMap.getOrDefault(t6, -1).intValue();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }

    public int size() {
        return this.elements.size();
    }

    @Override // java.lang.Iterable
    public Spliterator<T> spliterator() {
        return this.elements.spliterator();
    }

    public IntMapper(int i5) {
        this.elements = new ArrayList(i5);
        this.valueKeyMap = new HashMap(i5);
    }

    @Override // org.apache.poi.common.Duplicatable
    public IntMapper<T> copy() {
        return new IntMapper<>(this);
    }

    public IntMapper(IntMapper<T> intMapper) {
        this.elements = new ArrayList(intMapper.elements);
        this.valueKeyMap = new HashMap(intMapper.valueKeyMap);
    }
}
