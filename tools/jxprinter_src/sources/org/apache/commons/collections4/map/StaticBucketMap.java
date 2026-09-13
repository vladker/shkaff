package org.apache.commons.collections4.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StaticBucketMap<K, V> extends AbstractIterableMap<K, V> {
    private static final int DEFAULT_BUCKETS = 255;
    private final Node<K, V>[] buckets;
    private final Lock[] locks;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BaseIterator {
        private int bucket;
        private final ArrayList<Map.Entry<K, V>> current;
        private Map.Entry<K, V> last;

        private BaseIterator() {
            this.current = new ArrayList<>();
        }

        public boolean hasNext() {
            if (this.current.size() > 0) {
                return true;
            }
            while (this.bucket < StaticBucketMap.this.buckets.length) {
                synchronized (StaticBucketMap.this.locks[this.bucket]) {
                    try {
                        for (Node<K, V> node = StaticBucketMap.this.buckets[this.bucket]; node != null; node = node.next) {
                            this.current.add(node);
                        }
                        this.bucket++;
                        if (this.current.size() > 0) {
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return false;
        }

        public Map.Entry<K, V> nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ArrayList<Map.Entry<K, V>> arrayList = this.current;
            Map.Entry<K, V> entryRemove = arrayList.remove(arrayList.size() - 1);
            this.last = entryRemove;
            return entryRemove;
        }

        public void remove() {
            Map.Entry<K, V> entry = this.last;
            if (entry == null) {
                throw new IllegalStateException();
            }
            StaticBucketMap.this.remove(entry.getKey());
            this.last = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class EntryIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                try {
                    for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                        if (node.equals(entry)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                try {
                    for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                        if (node.equals(entry)) {
                            StaticBucketMap.this.remove(node.getKey());
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class KeyIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int hash = StaticBucketMap.this.getHash(obj);
            synchronized (StaticBucketMap.this.locks[hash]) {
                try {
                    for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                        K key = node.getKey();
                        if (key != obj && (key == null || !key.equals(obj))) {
                        }
                        StaticBucketMap.this.remove(key);
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Lock {
        public int size;

        private Lock() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Node<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        protected K key;
        protected Node<K, V> next;
        protected V value;

        private Node() {
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k6 = this.key;
            if (k6 != null ? k6.equals(entry.getKey()) : entry.getKey() == null) {
                V v6 = this.value;
                if (v6 != null ? v6.equals(entry.getValue()) : entry.getValue() == null) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k6 = this.key;
            int iHashCode = k6 == null ? 0 : k6.hashCode();
            V v6 = this.value;
            return iHashCode ^ (v6 != null ? v6.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v6) {
            V v7 = this.value;
            this.value = v6;
            return v7;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ValueIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    public StaticBucketMap() {
        this(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        int iHashCode = obj.hashCode();
        int i5 = iHashCode + (~(iHashCode << 15));
        int i6 = i5 ^ (i5 >>> 10);
        int i7 = i6 + (i6 << 3);
        int i8 = i7 ^ (i7 >>> 6);
        int i9 = i8 + (~(i8 << 11));
        int length = (i9 ^ (i9 >>> 16)) % this.buckets.length;
        return length < 0 ? length * (-1) : length;
    }

    public void atomic(Runnable runnable) {
        runnable.getClass();
        atomic(runnable, 0);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        for (int i5 = 0; i5 < this.buckets.length; i5++) {
            Lock lock = this.locks[i5];
            synchronized (lock) {
                this.buckets[i5] = null;
                lock.size = 0;
            }
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            try {
                for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                    K k6 = node.key;
                    if (k6 != obj && (k6 == null || !k6.equals(obj))) {
                    }
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        for (int i5 = 0; i5 < this.buckets.length; i5++) {
            synchronized (this.locks[i5]) {
                try {
                    for (Node<K, V> node = this.buckets[i5]; node != null; node = node.next) {
                        V v6 = node.value;
                        if (v6 != obj && (v6 == null || !v6.equals(obj))) {
                        }
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            try {
                for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                    K k6 = node.key;
                    if (k6 != obj && (k6 == null || !k6.equals(obj))) {
                    }
                    return node.value;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        int iHashCode = 0;
        for (int i5 = 0; i5 < this.buckets.length; i5++) {
            synchronized (this.locks[i5]) {
                try {
                    for (Node<K, V> node = this.buckets[i5]; node != null; node = node.next) {
                        iHashCode += node.hashCode();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return iHashCode;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return new KeySet();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k6, V v6) {
        int hash = getHash(k6);
        synchronized (this.locks[hash]) {
            try {
                Node<K, V> node = this.buckets[hash];
                if (node == null) {
                    Node<K, V> node2 = new Node<>();
                    node2.key = k6;
                    node2.value = v6;
                    this.buckets[hash] = node2;
                    this.locks[hash].size++;
                    return null;
                }
                Node<K, V> node3 = node;
                while (node != null) {
                    K k7 = node.key;
                    if (k7 != k6 && (k7 == null || !k7.equals(k6))) {
                        node3 = node;
                        node = node.next;
                    }
                    V v7 = node.value;
                    node.value = v6;
                    return v7;
                }
                Node<K, V> node4 = new Node<>();
                node4.key = k6;
                node4.value = v6;
                node3.next = node4;
                this.locks[hash].size++;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            try {
                Node<K, V> node = null;
                for (Node<K, V> node2 = this.buckets[hash]; node2 != null; node2 = node2.next) {
                    K k6 = node2.key;
                    if (k6 != obj && (k6 == null || !k6.equals(obj))) {
                        node = node2;
                    }
                    if (node == null) {
                        this.buckets[hash] = node2.next;
                    } else {
                        node.next = node2.next;
                    }
                    this.locks[hash].size--;
                    return node2.value;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        int i5 = 0;
        for (int i6 = 0; i6 < this.buckets.length; i6++) {
            synchronized (this.locks[i6]) {
                i5 += this.locks[i6].size;
            }
        }
        return i5;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return new Values();
    }

    public StaticBucketMap(int i5) {
        int iMax = Math.max(17, i5);
        iMax = iMax % 2 == 0 ? iMax - 1 : iMax;
        this.buckets = new Node[iMax];
        this.locks = new Lock[iMax];
        for (int i6 = 0; i6 < iMax; i6++) {
            this.locks[i6] = new Lock();
        }
    }

    private void atomic(Runnable runnable, int i5) {
        if (i5 >= this.buckets.length) {
            runnable.run();
            return;
        }
        synchronized (this.locks[i5]) {
            atomic(runnable, i5 + 1);
        }
    }
}
