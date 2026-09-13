package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CompositeMap<K, V> extends AbstractIterableMap<K, V> implements Serializable {
    private static final long serialVersionUID = -6096931280583808322L;
    private Map<K, V>[] composite;
    private MapMutator<K, V> mutator;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface MapMutator<K, V> extends Serializable {
        V put(CompositeMap<K, V> compositeMap, Map<K, V>[] mapArr, K k6, V v6);

        void putAll(CompositeMap<K, V> compositeMap, Map<K, V>[] mapArr, Map<? extends K, ? extends V> map);

        void resolveCollision(CompositeMap<K, V> compositeMap, Map<K, V> map, Map<K, V> map2, Collection<K> collection);
    }

    public CompositeMap() {
        this(new Map[0], (MapMutator) null);
    }

    public synchronized void addComposited(Map<K, V> map) {
        if (map != null) {
            try {
                for (int length = this.composite.length - 1; length >= 0; length--) {
                    Collection<K> collectionIntersection = CollectionUtils.intersection(this.composite[length].keySet(), map.keySet());
                    if (collectionIntersection.size() != 0) {
                        MapMutator<K, V> mapMutator = this.mutator;
                        if (mapMutator == null) {
                            throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
                        }
                        mapMutator.resolveCollision(this, this.composite[length], map, collectionIntersection);
                    }
                }
                Map<K, V>[] mapArr = this.composite;
                int length2 = mapArr.length;
                Map<K, V>[] mapArr2 = new Map[length2 + 1];
                System.arraycopy(mapArr, 0, mapArr2, 0, mapArr.length);
                mapArr2[length2] = map;
                this.composite = mapArr2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            this.composite[length].clear();
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.composite[length].entrySet());
        }
        return compositeSet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].get(obj);
            }
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (!this.composite[length].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.composite[length].keySet());
        }
        return compositeSet;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k6, V v6) {
        MapMutator<K, V> mapMutator = this.mutator;
        if (mapMutator != null) {
            return mapMutator.put(this, this.composite, k6, v6);
        }
        throw new UnsupportedOperationException("No mutator specified");
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        MapMutator<K, V> mapMutator = this.mutator;
        if (mapMutator == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
        mapMutator.putAll(this, this.composite, map);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].remove(obj);
            }
        }
        return null;
    }

    public synchronized Map<K, V> removeComposited(Map<K, V> map) {
        int length = this.composite.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (this.composite[i5].equals(map)) {
                Map<K, V>[] mapArr = new Map[length - 1];
                System.arraycopy(this.composite, 0, mapArr, 0, i5);
                System.arraycopy(this.composite, i5 + 1, mapArr, i5, (length - i5) - 1);
                this.composite = mapArr;
                return map;
            }
        }
        return null;
    }

    public void setMutator(MapMutator<K, V> mapMutator) {
        this.mutator = mapMutator;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        int size = 0;
        for (int length = this.composite.length - 1; length >= 0; length--) {
            size += this.composite[length].size();
        }
        return size;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        CompositeCollection compositeCollection = new CompositeCollection();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeCollection.addComposited(this.composite[length].values());
        }
        return compositeCollection;
    }

    public CompositeMap(Map<K, V> map, Map<K, V> map2) {
        this(new Map[]{map, map2}, (MapMutator) null);
    }

    public CompositeMap(Map<K, V> map, Map<K, V> map2, MapMutator<K, V> mapMutator) {
        this(new Map[]{map, map2}, mapMutator);
    }

    public CompositeMap(Map<K, V>... mapArr) {
        this(mapArr, (MapMutator) null);
    }

    public CompositeMap(Map<K, V>[] mapArr, MapMutator<K, V> mapMutator) {
        this.mutator = mapMutator;
        this.composite = new Map[0];
        for (int length = mapArr.length - 1; length >= 0; length--) {
            addComposited(mapArr[length]);
        }
    }
}
