package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiKeyMap<K, V> extends AbstractMapDecorator<MultiKey<? extends K>, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public MultiKeyMap() {
        this(new HashedMap());
    }

    public static <K, V> MultiKeyMap<K, V> multiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> abstractHashedMap) {
        if (abstractHashedMap == null) {
            throw new NullPointerException("Map must not be null");
        }
        if (abstractHashedMap.size() <= 0) {
            return new MultiKeyMap<>(abstractHashedMap);
        }
        throw new IllegalArgumentException("Map must be empty");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    public void checkKey(MultiKey<?> multiKey) {
        if (multiKey == null) {
            throw new NullPointerException("Key must not be null");
        }
    }

    public boolean containsKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                return true;
            }
        }
        return false;
    }

    public V get(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public int hash(Object obj, Object obj2) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        int i5 = iHashCode + (~(iHashCode << 9));
        int i6 = i5 ^ (i5 >>> 14);
        int i7 = i6 + (i6 << 4);
        return i7 ^ (i7 >>> 10);
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 2 && (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) && (obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1))));
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public MapIterator<MultiKey<? extends K>, V> mapIterator() {
        return decorated().mapIterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends MultiKey<? extends K>, ? extends V> map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            checkKey((MultiKey) it.next());
        }
        super.putAll(map);
    }

    public boolean removeAll(Object obj) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z6 = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 1) {
                if (obj == null) {
                    if (next.getKey(0) == null) {
                        mapIterator.remove();
                        z6 = true;
                    }
                } else if (obj.equals(next.getKey(0))) {
                    mapIterator.remove();
                    z6 = true;
                }
            }
        }
        return z6;
    }

    public V removeMultiKey(Object obj, Object obj2) {
        int iHash = hash(obj, obj2);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public MultiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> abstractHashedMap) {
        super(abstractHashedMap);
        this.map = abstractHashedMap;
    }

    public MultiKeyMap<K, V> clone() {
        try {
            return (MultiKeyMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public AbstractHashedMap<MultiKey<? extends K>, V> decorated() {
        return (AbstractHashedMap) super.decorated();
    }

    public V put(K k6, K k7, V v6) {
        int iHash = hash(k6, k7);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k6, k7)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v6);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k6, k7), v6);
        return null;
    }

    public int hash(Object obj, Object obj2, Object obj3) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        int i5 = iHashCode + (~(iHashCode << 9));
        int i6 = i5 ^ (i5 >>> 14);
        int i7 = i6 + (i6 << 4);
        return i7 ^ (i7 >>> 10);
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 3 && (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) && ((obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1)))) && (obj3 == key.getKey(2) || (obj3 != null && obj3.equals(key.getKey(2)))));
    }

    public V get(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public int hash(Object obj, Object obj2, Object obj3, Object obj4) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        int i5 = iHashCode + (~(iHashCode << 9));
        int i6 = i5 ^ (i5 >>> 14);
        int i7 = i6 + (i6 << 4);
        return i7 ^ (i7 >>> 10);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x002f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0006 A[SYNTHETIC] */
    public boolean removeAll(Object obj, Object obj2) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z6 = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 2) {
                if (obj == null) {
                    if (next.getKey(0) == null) {
                        if (obj2 == null) {
                            if (next.getKey(1) == null) {
                                mapIterator.remove();
                                z6 = true;
                            }
                        } else if (obj2.equals(next.getKey(1))) {
                            mapIterator.remove();
                            z6 = true;
                        }
                    }
                } else if (obj.equals(next.getKey(0))) {
                    if (obj2 == null) {
                        if (next.getKey(1) == null) {
                            mapIterator.remove();
                            z6 = true;
                        }
                    } else if (obj2.equals(next.getKey(1))) {
                        mapIterator.remove();
                        z6 = true;
                    }
                }
            }
        }
        return z6;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3) {
        int iHash = hash(obj, obj2, obj3);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = null;
        for (AbstractHashedMap.HashEntry<K, V> hashEntry2 = decorated().data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(hashEntry2, obj, obj2, obj3)) {
                V value = hashEntry2.getValue();
                decorated().removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    return true;
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry = hashEntry.next;
            obj = obj5;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
        }
        return false;
    }

    public int hash(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHashCode = obj != null ? obj.hashCode() : 0;
        if (obj2 != null) {
            iHashCode ^= obj2.hashCode();
        }
        if (obj3 != null) {
            iHashCode ^= obj3.hashCode();
        }
        if (obj4 != null) {
            iHashCode ^= obj4.hashCode();
        }
        if (obj5 != null) {
            iHashCode ^= obj5.hashCode();
        }
        int i5 = iHashCode + (~(iHashCode << 9));
        int i6 = i5 ^ (i5 >>> 14);
        int i7 = i6 + (i6 << 4);
        return i7 ^ (i7 >>> 10);
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3, Object obj4) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 4 && (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) && ((obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1)))) && ((obj3 == key.getKey(2) || (obj3 != null && obj3.equals(key.getKey(2)))) && (obj4 == key.getKey(3) || (obj4 != null && obj4.equals(key.getKey(3))))));
    }

    public V put(K k6, K k7, K k8, V v6) {
        int iHash = hash(k6, k7, k8);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k6, k7, k8)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v6);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k6, k7, k8), v6);
        return null;
    }

    public V get(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    return hashEntry.getValue();
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry = hashEntry.next;
            obj = obj5;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj6 = obj;
                if (isEqualKey(hashEntry, obj6, obj2, obj3, obj4, obj5)) {
                    return true;
                }
            } else {
                obj6 = obj;
            }
            hashEntry = hashEntry.next;
            obj = obj6;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x004a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x002f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0006 A[SYNTHETIC] */
    public boolean removeAll(Object obj, Object obj2, Object obj3) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z6 = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 3) {
                if (obj == null) {
                    if (next.getKey(0) == null) {
                        if (obj2 == null) {
                            if (next.getKey(1) == null) {
                                if (obj3 == null) {
                                    if (next.getKey(2) == null) {
                                        mapIterator.remove();
                                        z6 = true;
                                    }
                                } else if (obj3.equals(next.getKey(2))) {
                                    mapIterator.remove();
                                    z6 = true;
                                }
                            }
                        } else if (obj2.equals(next.getKey(1))) {
                            if (obj3 == null) {
                                if (next.getKey(2) == null) {
                                    mapIterator.remove();
                                    z6 = true;
                                }
                            } else if (obj3.equals(next.getKey(2))) {
                                mapIterator.remove();
                                z6 = true;
                            }
                        }
                    }
                } else if (obj.equals(next.getKey(0))) {
                    if (obj2 == null) {
                        if (next.getKey(1) == null) {
                            if (obj3 == null) {
                                if (next.getKey(2) == null) {
                                    mapIterator.remove();
                                    z6 = true;
                                }
                            } else if (obj3.equals(next.getKey(2))) {
                                mapIterator.remove();
                                z6 = true;
                            }
                        }
                    } else if (obj2.equals(next.getKey(1))) {
                        if (obj3 == null) {
                            if (next.getKey(2) == null) {
                                mapIterator.remove();
                                z6 = true;
                            }
                        } else if (obj3.equals(next.getKey(2))) {
                            mapIterator.remove();
                            z6 = true;
                        }
                    }
                }
            }
        }
        return z6;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3, Object obj4) {
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int iHash = hash(obj, obj2, obj3, obj4);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex];
        AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
                if (isEqualKey(hashEntry, obj5, obj6, obj7, obj8)) {
                    V value = hashEntry.getValue();
                    decorated().removeMapping(hashEntry, iHashIndex, hashEntry2);
                    return value;
                }
            } else {
                obj5 = obj;
                obj6 = obj2;
                obj7 = obj3;
                obj8 = obj4;
            }
            hashEntry2 = hashEntry;
            obj2 = obj6;
            obj3 = obj7;
            obj4 = obj8;
            hashEntry = hashEntry.next;
            obj = obj5;
        }
        return null;
    }

    public V get(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object obj6;
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[decorated().hashIndex(iHash, decorated().data.length)];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                obj6 = obj;
                if (isEqualKey(hashEntry, obj6, obj2, obj3, obj4, obj5)) {
                    return hashEntry.getValue();
                }
            } else {
                obj6 = obj;
            }
            hashEntry = hashEntry.next;
            obj = obj6;
        }
        return null;
    }

    public boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        MultiKey<? extends K> key = hashEntry.getKey();
        return key.size() == 5 && (obj == key.getKey(0) || (obj != null && obj.equals(key.getKey(0)))) && ((obj2 == key.getKey(1) || (obj2 != null && obj2.equals(key.getKey(1)))) && ((obj3 == key.getKey(2) || (obj3 != null && obj3.equals(key.getKey(2)))) && ((obj4 == key.getKey(3) || (obj4 != null && obj4.equals(key.getKey(3)))) && (obj5 == key.getKey(4) || (obj5 != null && obj5.equals(key.getKey(4)))))));
    }

    public V put(K k6, K k7, K k8, K k9, V v6) {
        K k10;
        K k11;
        K k12;
        K k13;
        int iHash = hash(k6, k7, k8, k9);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash) {
                k10 = k6;
                k11 = k7;
                k12 = k8;
                k13 = k9;
                if (isEqualKey(hashEntry, k10, k11, k12, k13)) {
                    V value = hashEntry.getValue();
                    decorated().updateEntry(hashEntry, v6);
                    return value;
                }
            } else {
                k10 = k6;
                k11 = k7;
                k12 = k8;
                k13 = k9;
            }
            hashEntry = hashEntry.next;
            k6 = k10;
            k7 = k11;
            k8 = k12;
            k9 = k13;
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k6, k7, k8, k9), v6);
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x004a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x005e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x002f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0006 A[SYNTHETIC] */
    public boolean removeAll(Object obj, Object obj2, Object obj3, Object obj4) {
        MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
        boolean z6 = false;
        while (mapIterator.hasNext()) {
            MultiKey<? extends K> next = mapIterator.next();
            if (next.size() >= 4) {
                if (obj == null) {
                    if (next.getKey(0) == null) {
                        if (obj2 == null) {
                            if (next.getKey(1) == null) {
                                if (obj3 == null) {
                                    if (next.getKey(2) == null) {
                                        if (obj4 == null) {
                                            if (next.getKey(3) == null) {
                                                mapIterator.remove();
                                                z6 = true;
                                            }
                                        } else if (obj4.equals(next.getKey(3))) {
                                            mapIterator.remove();
                                            z6 = true;
                                        }
                                    }
                                } else if (obj3.equals(next.getKey(2))) {
                                    if (obj4 == null) {
                                        if (next.getKey(3) == null) {
                                            mapIterator.remove();
                                            z6 = true;
                                        }
                                    } else if (obj4.equals(next.getKey(3))) {
                                        mapIterator.remove();
                                        z6 = true;
                                    }
                                }
                            }
                        } else if (obj2.equals(next.getKey(1))) {
                            if (obj3 == null) {
                                if (next.getKey(2) == null) {
                                    if (obj4 == null) {
                                        if (next.getKey(3) == null) {
                                            mapIterator.remove();
                                            z6 = true;
                                        }
                                    } else if (obj4.equals(next.getKey(3))) {
                                        mapIterator.remove();
                                        z6 = true;
                                    }
                                }
                            } else if (obj3.equals(next.getKey(2))) {
                                if (obj4 == null) {
                                    if (next.getKey(3) == null) {
                                        mapIterator.remove();
                                        z6 = true;
                                    }
                                } else if (obj4.equals(next.getKey(3))) {
                                    mapIterator.remove();
                                    z6 = true;
                                }
                            }
                        }
                    }
                } else if (obj.equals(next.getKey(0))) {
                    if (obj2 == null) {
                        if (next.getKey(1) == null) {
                            if (obj3 == null) {
                                if (next.getKey(2) == null) {
                                    if (obj4 == null) {
                                        if (next.getKey(3) == null) {
                                            mapIterator.remove();
                                            z6 = true;
                                        }
                                    } else if (obj4.equals(next.getKey(3))) {
                                        mapIterator.remove();
                                        z6 = true;
                                    }
                                }
                            } else if (obj3.equals(next.getKey(2))) {
                                if (obj4 == null) {
                                    if (next.getKey(3) == null) {
                                        mapIterator.remove();
                                        z6 = true;
                                    }
                                } else if (obj4.equals(next.getKey(3))) {
                                    mapIterator.remove();
                                    z6 = true;
                                }
                            }
                        }
                    } else if (obj2.equals(next.getKey(1))) {
                        if (obj3 == null) {
                            if (next.getKey(2) == null) {
                                if (obj4 == null) {
                                    if (next.getKey(3) == null) {
                                        mapIterator.remove();
                                        z6 = true;
                                    }
                                } else if (obj4.equals(next.getKey(3))) {
                                    mapIterator.remove();
                                    z6 = true;
                                }
                            }
                        } else if (obj3.equals(next.getKey(2))) {
                            if (obj4 == null) {
                                if (next.getKey(3) == null) {
                                    mapIterator.remove();
                                    z6 = true;
                                }
                            } else if (obj4.equals(next.getKey(3))) {
                                mapIterator.remove();
                                z6 = true;
                            }
                        }
                    }
                }
            }
        }
        return z6;
    }

    public V removeMultiKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int iHash = hash(obj, obj2, obj3, obj4, obj5);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex];
        AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                V value = hashEntry.getValue();
                decorated().removeMapping(hashEntry, iHashIndex, hashEntry2);
                return value;
            }
            AbstractHashedMap.HashEntry<K, V> hashEntry3 = hashEntry;
            hashEntry = hashEntry.next;
            hashEntry2 = hashEntry3;
        }
        return null;
    }

    public V put(K k6, K k7, K k8, K k9, K k10, V v6) {
        int iHash = hash(k6, k7, k8, k9, k10);
        int iHashIndex = decorated().hashIndex(iHash, decorated().data.length);
        for (AbstractHashedMap.HashEntry<K, V> hashEntry = decorated().data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(hashEntry, k6, k7, k8, k9, k10)) {
                V value = hashEntry.getValue();
                decorated().updateEntry(hashEntry, v6);
                return value;
            }
        }
        decorated().addMapping(iHashIndex, iHash, new MultiKey<>(k6, k7, k8, k9, k10), v6);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(MultiKey<? extends K> multiKey, V v6) {
        checkKey(multiKey);
        return (V) super.put(multiKey, v6);
    }
}
