package org.apache.commons.collections4.multimap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.ListValuedMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractListValuedMap<K, V> extends AbstractMultiValuedMap<K, V> implements ListValuedMap<K, V> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class WrappedList extends AbstractMultiValuedMap<K, V>.WrappedCollection implements List<V> {
        public WrappedList(K k6) {
            super(k6);
        }

        @Override // java.util.List
        public void add(int i5, V v6) {
            List<V> mapping = getMapping();
            if (mapping == null) {
                mapping = AbstractListValuedMap.this.createCollection();
                AbstractListValuedMap.this.getMap().put(this.key, mapping);
            }
            mapping.add(i5, v6);
        }

        @Override // java.util.List
        public boolean addAll(int i5, Collection<? extends V> collection) {
            List<V> mapping = getMapping();
            if (mapping != null) {
                return mapping.addAll(i5, collection);
            }
            List<V> listCreateCollection = AbstractListValuedMap.this.createCollection();
            boolean zAddAll = listCreateCollection.addAll(i5, collection);
            if (zAddAll) {
                AbstractListValuedMap.this.getMap().put(this.key, listCreateCollection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            List<V> mapping = getMapping();
            if (mapping == null) {
                return Collections.EMPTY_LIST.equals(obj);
            }
            if (obj instanceof List) {
                return ListUtils.isEqualList(mapping, (List) obj);
            }
            return false;
        }

        @Override // java.util.List
        public V get(int i5) {
            return (V) ListUtils.emptyIfNull(getMapping()).get(i5);
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            return ListUtils.hashCodeForList(getMapping());
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return ListUtils.emptyIfNull(getMapping()).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return ListUtils.emptyIfNull(getMapping()).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            return new ValuesListIterator(this.key);
        }

        @Override // java.util.List
        public V remove(int i5) {
            List listEmptyIfNull = ListUtils.emptyIfNull(getMapping());
            V v6 = (V) listEmptyIfNull.remove(i5);
            if (listEmptyIfNull.isEmpty()) {
                AbstractListValuedMap.this.remove((Object) this.key);
            }
            return v6;
        }

        @Override // java.util.List
        public V set(int i5, V v6) {
            return (V) ListUtils.emptyIfNull(getMapping()).set(i5, v6);
        }

        @Override // java.util.List
        public List<V> subList(int i5, int i6) {
            return ListUtils.emptyIfNull(getMapping()).subList(i5, i6);
        }

        @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap.WrappedCollection
        public List<V> getMapping() {
            return AbstractListValuedMap.this.getMap().get(this.key);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i5) {
            return new ValuesListIterator(this.key, i5);
        }
    }

    public AbstractListValuedMap() {
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public abstract List<V> createCollection();

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public Map<K, List<V>> getMap() {
        return super.getMap();
    }

    public AbstractListValuedMap(Map<K, ? extends List<V>> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public List<V> get(K k6) {
        return wrappedCollection((Object) k6);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public List<V> remove(Object obj) {
        return ListUtils.emptyIfNull(getMap().remove(obj));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public List<V> wrappedCollection(K k6) {
        return new WrappedList(k6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ValuesListIterator implements ListIterator<V> {
        private ListIterator<V> iterator;
        private final K key;
        private List<V> values;

        public ValuesListIterator(K k6) {
            this.key = k6;
            List<V> listEmptyIfNull = ListUtils.emptyIfNull(AbstractListValuedMap.this.getMap().get(k6));
            this.values = listEmptyIfNull;
            this.iterator = listEmptyIfNull.listIterator();
        }

        @Override // java.util.ListIterator
        public void add(V v6) {
            if (AbstractListValuedMap.this.getMap().get(this.key) == null) {
                List<V> listCreateCollection = AbstractListValuedMap.this.createCollection();
                AbstractListValuedMap.this.getMap().put(this.key, listCreateCollection);
                this.values = listCreateCollection;
                this.iterator = listCreateCollection.listIterator();
            }
            this.iterator.add(v6);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            return this.iterator.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.iterator.nextIndex();
        }

        @Override // java.util.ListIterator
        public V previous() {
            return this.iterator.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.iterator.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty()) {
                AbstractListValuedMap.this.getMap().remove(this.key);
            }
        }

        @Override // java.util.ListIterator
        public void set(V v6) {
            this.iterator.set(v6);
        }

        public ValuesListIterator(K k6, int i5) {
            this.key = k6;
            List<V> listEmptyIfNull = ListUtils.emptyIfNull(AbstractListValuedMap.this.getMap().get(k6));
            this.values = listEmptyIfNull;
            this.iterator = listEmptyIfNull.listIterator(i5);
        }
    }
}
