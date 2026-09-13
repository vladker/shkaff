package org.apache.commons.collections4.trie;

import androidx.collection.a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractPatriciaTrie<K, V> extends AbstractBitwiseTrie<K, V> {
    private static final long serialVersionUID = 5155253417231339498L;
    private volatile transient Set<Map.Entry<K, V>> entrySet;
    private volatile transient Set<K> keySet;
    protected transient int modCount;
    private transient TrieEntry<K, V> root;
    private transient int size;
    private volatile transient Collection<V> values;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private EntryIterator() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return nextEntry();
            }
        }

        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TrieEntry<K, V> entry;
            return (obj instanceof Map.Entry) && (entry = AbstractPatriciaTrie.this.getEntry(((Map.Entry) obj).getKey())) != null && entry.equals(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !contains(obj)) {
                return false;
            }
            AbstractPatriciaTrie.this.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class KeySet extends AbstractSet<K> {

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public class KeyIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<K> {
            private KeyIterator() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return nextEntry().getKey();
            }
        }

        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AbstractPatriciaTrie.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size = size();
            AbstractPatriciaTrie.this.remove(obj);
            return size != size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class PrefixRangeEntrySet extends AbstractPatriciaTrie<K, V>.RangeEntrySet {
        private final AbstractPatriciaTrie<K, V>.PrefixRangeMap delegate;
        private int expectedModCount;
        private TrieEntry<K, V> prefixStart;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public final class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private boolean lastOne;
            private final int lengthInBits;
            private final int offset;
            private final K prefix;
            private TrieEntry<K, V> subtree;

            public EntryIterator(TrieEntry<K, V> trieEntry, K k6, int i5, int i6) {
                super();
                this.subtree = trieEntry;
                this.next = AbstractPatriciaTrie.this.followLeft(trieEntry);
                this.prefix = k6;
                this.offset = i5;
                this.lengthInBits = i6;
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator
            public TrieEntry<K, V> findNext(TrieEntry<K, V> trieEntry) {
                return AbstractPatriciaTrie.this.nextEntryInSubtree(trieEntry, this.subtree);
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator, java.util.Iterator
            public void remove() {
                TrieEntry<K, V> trieEntry = this.subtree;
                int i5 = trieEntry.bitIndex;
                boolean z6 = this.current == trieEntry;
                super.remove();
                if (i5 != this.subtree.bitIndex || z6) {
                    this.subtree = AbstractPatriciaTrie.this.subtree(this.prefix, this.offset, this.lengthInBits);
                }
                if (this.lengthInBits >= this.subtree.bitIndex) {
                    this.lastOne = true;
                }
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                TrieEntry<K, V> trieEntryNextEntry = nextEntry();
                if (this.lastOne) {
                    this.next = null;
                }
                return trieEntryNextEntry;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public final class SingletonIterator implements Iterator<Map.Entry<K, V>> {
            private final TrieEntry<K, V> entry;
            private int hit = 0;

            public SingletonIterator(TrieEntry<K, V> trieEntry) {
                this.entry = trieEntry;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.hit == 0;
            }

            @Override // java.util.Iterator
            public void remove() {
                int i5 = this.hit;
                if (i5 != 1) {
                    throw new IllegalStateException();
                }
                this.hit = i5 + 1;
                AbstractPatriciaTrie.this.removeEntry(this.entry);
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                int i5 = this.hit;
                if (i5 != 0) {
                    throw new NoSuchElementException();
                }
                this.hit = i5 + 1;
                return this.entry;
            }
        }

        public PrefixRangeEntrySet(AbstractPatriciaTrie<K, V>.PrefixRangeMap prefixRangeMap) {
            super(prefixRangeMap);
            this.expectedModCount = 0;
            this.delegate = prefixRangeMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeEntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            AbstractPatriciaTrie abstractPatriciaTrie = AbstractPatriciaTrie.this;
            if (abstractPatriciaTrie.modCount != this.expectedModCount) {
                this.prefixStart = abstractPatriciaTrie.subtree(((PrefixRangeMap) this.delegate).prefix, ((PrefixRangeMap) this.delegate).offsetInBits, ((PrefixRangeMap) this.delegate).lengthInBits);
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            if (this.prefixStart == null) {
                return Collections.EMPTY_SET.iterator();
            }
            int i5 = ((PrefixRangeMap) this.delegate).lengthInBits;
            TrieEntry<K, V> trieEntry = this.prefixStart;
            return i5 > trieEntry.bitIndex ? new SingletonIterator(trieEntry) : new EntryIterator(trieEntry, ((PrefixRangeMap) this.delegate).prefix, ((PrefixRangeMap) this.delegate).offsetInBits, ((PrefixRangeMap) this.delegate).lengthInBits);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeEntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.delegate.fixup();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class PrefixRangeMap extends AbstractPatriciaTrie<K, V>.RangeMap {
        private transient int expectedModCount;
        private K fromKey;
        private final int lengthInBits;
        private final int offsetInBits;
        private final K prefix;
        private int size;
        private K toKey;

        /* JADX INFO: Access modifiers changed from: private */
        public int fixup() {
            Map.Entry<K, V> next;
            if (this.size == -1 || AbstractPatriciaTrie.this.modCount != this.expectedModCount) {
                Iterator<Map.Entry<K, V>> it = super.entrySet().iterator();
                this.size = 0;
                if (it.hasNext()) {
                    next = it.next();
                    this.size = 1;
                } else {
                    next = null;
                }
                K key = next == null ? null : next.getKey();
                this.fromKey = key;
                if (key != null) {
                    TrieEntry<K, V> trieEntryPreviousEntry = AbstractPatriciaTrie.this.previousEntry((TrieEntry) next);
                    this.fromKey = trieEntryPreviousEntry == null ? null : trieEntryPreviousEntry.getKey();
                }
                this.toKey = this.fromKey;
                while (it.hasNext()) {
                    this.size++;
                    next = it.next();
                }
                K key2 = next == null ? null : next.getKey();
                this.toKey = key2;
                if (key2 != null) {
                    TrieEntry<K, V> trieEntryNextEntry = AbstractPatriciaTrie.this.nextEntry((TrieEntry) next);
                    this.toKey = trieEntryNextEntry != null ? trieEntryNextEntry.getKey() : null;
                }
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            return this.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterator<Map.Entry<K, V>> it = AbstractPatriciaTrie.this.entrySet().iterator();
            Set<K> setKeySet = keySet();
            while (it.hasNext()) {
                if (setKeySet.contains(it.next().getKey())) {
                    it.remove();
                }
            }
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new PrefixRangeEntrySet(this);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public SortedMap<K, V> createRangeMap(K k6, boolean z6, K k7, boolean z7) {
            return new RangeEntryMap(k6, z6, k7, z7);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            fixup();
            K k6 = this.fromKey;
            TrieEntry<K, V> trieEntryFirstEntry = k6 == null ? AbstractPatriciaTrie.this.firstEntry() : AbstractPatriciaTrie.this.higherEntry(k6);
            K key = trieEntryFirstEntry != null ? trieEntryFirstEntry.getKey() : null;
            if (trieEntryFirstEntry == null || !AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key)) {
                throw new NoSuchElementException();
            }
            return key;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getFromKey() {
            return this.fromKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getToKey() {
            return this.toKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inFromRange(K k6, boolean z6) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k6);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inRange(K k6) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k6);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inRange2(K k6) {
            return inRange(k6);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inToRange(K k6, boolean z6) {
            return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k6);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isFromInclusive() {
            return false;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isToInclusive() {
            return false;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            fixup();
            K k6 = this.toKey;
            TrieEntry<K, V> trieEntryLastEntry = k6 == null ? AbstractPatriciaTrie.this.lastEntry() : AbstractPatriciaTrie.this.lowerEntry(k6);
            K key = trieEntryLastEntry != null ? trieEntryLastEntry.getKey() : null;
            if (trieEntryLastEntry == null || !AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key)) {
                throw new NoSuchElementException();
            }
            return key;
        }

        private PrefixRangeMap(K k6, int i5, int i6) {
            super();
            this.fromKey = null;
            this.toKey = null;
            this.expectedModCount = 0;
            this.size = -1;
            this.prefix = k6;
            this.offsetInBits = i5;
            this.lengthInBits = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class RangeEntryMap extends AbstractPatriciaTrie<K, V>.RangeMap {
        private final boolean fromInclusive;
        private final K fromKey;
        private final boolean toInclusive;
        private final K toKey;

        public RangeEntryMap(AbstractPatriciaTrie abstractPatriciaTrie, K k6, K k7) {
            this(k6, true, k7, false);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new RangeEntrySet(this);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public SortedMap<K, V> createRangeMap(K k6, boolean z6, K k7, boolean z7) {
            return new RangeEntryMap(k6, z6, k7, z7);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            TrieEntry<K, V> trieEntryCeilingEntry;
            K k6 = this.fromKey;
            if (k6 == null) {
                trieEntryCeilingEntry = AbstractPatriciaTrie.this.firstEntry();
            } else {
                trieEntryCeilingEntry = this.fromInclusive ? AbstractPatriciaTrie.this.ceilingEntry(k6) : AbstractPatriciaTrie.this.higherEntry(k6);
            }
            K key = trieEntryCeilingEntry != null ? trieEntryCeilingEntry.getKey() : null;
            if (trieEntryCeilingEntry == null || !(this.toKey == null || inToRange(key, false))) {
                throw new NoSuchElementException();
            }
            return key;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getFromKey() {
            return this.fromKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getToKey() {
            return this.toKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isFromInclusive() {
            return this.fromInclusive;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isToInclusive() {
            return this.toInclusive;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            TrieEntry<K, V> trieEntryFloorEntry;
            K k6 = this.toKey;
            if (k6 == null) {
                trieEntryFloorEntry = AbstractPatriciaTrie.this.lastEntry();
            } else {
                trieEntryFloorEntry = this.toInclusive ? AbstractPatriciaTrie.this.floorEntry(k6) : AbstractPatriciaTrie.this.lowerEntry(k6);
            }
            K key = trieEntryFloorEntry != null ? trieEntryFloorEntry.getKey() : null;
            if (trieEntryFloorEntry == null || !(this.fromKey == null || inFromRange(key, false))) {
                throw new NoSuchElementException();
            }
            return key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RangeEntryMap(K k6, boolean z6, K k7, boolean z7) {
            super();
            if (k6 == 0 && k7 == 0) {
                throw new IllegalArgumentException("must have a from or to!");
            }
            if (k6 != 0 && k7 != 0 && AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k6, k7) > 0) {
                throw new IllegalArgumentException("fromKey > toKey");
            }
            this.fromKey = k6;
            this.fromInclusive = z6;
            this.toKey = k7;
            this.toInclusive = z7;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class RangeEntrySet extends AbstractSet<Map.Entry<K, V>> {
        private final AbstractPatriciaTrie<K, V>.RangeMap delegate;
        private transient int expectedModCount;
        private transient int size = -1;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public final class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private final K excludedKey;

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator, java.util.Iterator
            public boolean hasNext() {
                TrieEntry<K, V> trieEntry = this.next;
                return (trieEntry == null || AbstractBitwiseTrie.compare(trieEntry.key, this.excludedKey)) ? false : true;
            }

            private EntryIterator(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2) {
                super(trieEntry);
                this.excludedKey = trieEntry2 != null ? trieEntry2.getKey() : null;
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                TrieEntry<K, V> trieEntry = this.next;
                if (trieEntry == null || AbstractBitwiseTrie.compare(trieEntry.key, this.excludedKey)) {
                    throw new NoSuchElementException();
                }
                return nextEntry();
            }
        }

        public RangeEntrySet(AbstractPatriciaTrie<K, V>.RangeMap rangeMap) {
            if (rangeMap == null) {
                throw new NullPointerException("delegate");
            }
            this.delegate = rangeMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TrieEntry<K, V> entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            Object key = entry2.getKey();
            return this.delegate.inRange((K) key) && (entry = AbstractPatriciaTrie.this.getEntry(key)) != null && AbstractBitwiseTrie.compare(entry.getValue(), entry2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !iterator().hasNext();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            K fromKey = this.delegate.getFromKey();
            K toKey = this.delegate.getToKey();
            return new EntryIterator(fromKey == null ? AbstractPatriciaTrie.this.firstEntry() : AbstractPatriciaTrie.this.ceilingEntry(fromKey), toKey != null ? AbstractPatriciaTrie.this.ceilingEntry(toKey) : null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            TrieEntry<K, V> entry;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            Object key = entry2.getKey();
            if (!this.delegate.inRange((K) key) || (entry = AbstractPatriciaTrie.this.getEntry(key)) == null || !AbstractBitwiseTrie.compare(entry.getValue(), entry2.getValue())) {
                return false;
            }
            AbstractPatriciaTrie.this.removeEntry(entry);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            if (this.size == -1 || this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
                this.size = 0;
                Iterator<Map.Entry<K, V>> it = iterator();
                while (it.hasNext()) {
                    this.size++;
                    it.next();
                }
                this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            }
            return this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public abstract class RangeMap extends AbstractMap<K, V> implements SortedMap<K, V> {
        private volatile transient Set<Map.Entry<K, V>> entrySet;

        private RangeMap() {
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return AbstractPatriciaTrie.this.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return AbstractPatriciaTrie.this.containsKey(obj);
            }
            return false;
        }

        public abstract Set<Map.Entry<K, V>> createEntrySet();

        public abstract SortedMap<K, V> createRangeMap(K k6, boolean z6, K k7, boolean z7);

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = createEntrySet();
            }
            return this.entrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return (V) AbstractPatriciaTrie.this.get(obj);
            }
            return null;
        }

        public abstract K getFromKey();

        public abstract K getToKey();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K k6) {
            if (inRange2(k6)) {
                return createRangeMap(getFromKey(), isFromInclusive(), k6, isToInclusive());
            }
            throw new IllegalArgumentException(a.l(k6, "ToKey is out of range: "));
        }

        public boolean inFromRange(K k6, boolean z6) {
            Object fromKey = getFromKey();
            boolean zIsFromInclusive = isFromInclusive();
            int iCompare = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k6, fromKey);
            if (zIsFromInclusive || z6) {
                return iCompare >= 0;
            }
            return iCompare > 0;
        }

        public boolean inRange(K k6) {
            return (getFromKey() == null || inFromRange(k6, false)) && (getToKey() == null || inToRange(k6, false));
        }

        public boolean inRange2(K k6) {
            return (getFromKey() == null || inFromRange(k6, false)) && (getToKey() == null || inToRange(k6, true));
        }

        public boolean inToRange(K k6, boolean z6) {
            Object toKey = getToKey();
            boolean zIsToInclusive = isToInclusive();
            int iCompare = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(k6, toKey);
            if (zIsToInclusive || z6) {
                return iCompare <= 0;
            }
            return iCompare < 0;
        }

        public abstract boolean isFromInclusive();

        public abstract boolean isToInclusive();

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k6, V v6) {
            if (inRange(k6)) {
                return (V) AbstractPatriciaTrie.this.put(k6, v6);
            }
            throw new IllegalArgumentException(a.l(k6, "Key is out of range: "));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            if (inRange(AbstractPatriciaTrie.this.castKey(obj))) {
                return (V) AbstractPatriciaTrie.this.remove(obj);
            }
            return null;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K k6, K k7) {
            if (!inRange2(k6)) {
                throw new IllegalArgumentException(a.l(k6, "FromKey is out of range: "));
            }
            if (inRange2(k7)) {
                return createRangeMap(k6, isFromInclusive(), k7, isToInclusive());
            }
            throw new IllegalArgumentException(a.l(k7, "ToKey is out of range: "));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K k6) {
            if (inRange2(k6)) {
                return createRangeMap(k6, isFromInclusive(), getToKey(), isToInclusive());
            }
            throw new IllegalArgumentException(a.l(k6, "FromKey is out of range: "));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Reference<E> {
        private E item;

        private Reference() {
        }

        public E get() {
            return this.item;
        }

        public void set(E e) {
            this.item = e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TrieEntry<K, V> extends AbstractBitwiseTrie.BasicEntry<K, V> {
        private static final long serialVersionUID = 4596023148184140013L;
        protected int bitIndex;
        protected TrieEntry<K, V> left;
        protected TrieEntry<K, V> parent;
        protected TrieEntry<K, V> predecessor;
        protected TrieEntry<K, V> right;

        public TrieEntry(K k6, V v6, int i5) {
            super(k6, v6);
            this.bitIndex = i5;
            this.parent = null;
            this.left = this;
            this.right = null;
            this.predecessor = this;
        }

        public boolean isEmpty() {
            return this.key == null;
        }

        public boolean isExternalNode() {
            return !isInternalNode();
        }

        public boolean isInternalNode() {
            return (this.left == this || this.right == this) ? false : true;
        }

        @Override // org.apache.commons.collections4.trie.AbstractBitwiseTrie.BasicEntry
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.bitIndex == -1) {
                sb.append("RootEntry(");
            } else {
                sb.append("Entry(");
            }
            sb.append("key=");
            sb.append(getKey());
            sb.append(" [");
            sb.append(this.bitIndex);
            sb.append("], value=");
            sb.append(getValue());
            sb.append(", ");
            TrieEntry<K, V> trieEntry = this.parent;
            if (trieEntry == null) {
                sb.append("parent=null");
            } else if (trieEntry.bitIndex == -1) {
                sb.append("parent=ROOT");
            } else {
                sb.append("parent=");
                sb.append(this.parent.getKey());
                sb.append(" [");
                sb.append(this.parent.bitIndex);
                sb.append("]");
            }
            sb.append(", ");
            TrieEntry<K, V> trieEntry2 = this.left;
            if (trieEntry2 == null) {
                sb.append("left=null");
            } else if (trieEntry2.bitIndex == -1) {
                sb.append("left=ROOT");
            } else {
                sb.append("left=");
                sb.append(this.left.getKey());
                sb.append(" [");
                sb.append(this.left.bitIndex);
                sb.append("]");
            }
            sb.append(", ");
            TrieEntry<K, V> trieEntry3 = this.right;
            if (trieEntry3 == null) {
                sb.append("right=null");
            } else if (trieEntry3.bitIndex == -1) {
                sb.append("right=ROOT");
            } else {
                sb.append("right=");
                sb.append(this.right.getKey());
                sb.append(" [");
                sb.append(this.right.bitIndex);
                sb.append("]");
            }
            sb.append(", ");
            TrieEntry<K, V> trieEntry4 = this.predecessor;
            if (trieEntry4 != null) {
                if (trieEntry4.bitIndex == -1) {
                    sb.append("predecessor=ROOT");
                } else {
                    sb.append("predecessor=");
                    sb.append(this.predecessor.getKey());
                    sb.append(" [");
                    sb.append(this.predecessor.bitIndex);
                    sb.append("]");
                }
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class TrieMapIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<K> implements OrderedMapIterator<K, V> {
        protected TrieEntry<K, V> previous;

        private TrieMapIterator() {
            super();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            TrieEntry<K, V> trieEntry = this.current;
            if (trieEntry != null) {
                return trieEntry.getKey();
            }
            throw new IllegalStateException();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            TrieEntry<K, V> trieEntry = this.current;
            if (trieEntry != null) {
                return trieEntry.getValue();
            }
            throw new IllegalStateException();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.previous != null;
        }

        @Override // java.util.Iterator, org.apache.commons.collections4.MapIterator
        public K next() {
            return nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator
        public TrieEntry<K, V> nextEntry() {
            TrieEntry<K, V> trieEntryNextEntry = super.nextEntry();
            this.previous = trieEntryNextEntry;
            return trieEntryNextEntry;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return previousEntry().getKey();
        }

        public TrieEntry<K, V> previousEntry() {
            int i5 = this.expectedModCount;
            AbstractPatriciaTrie abstractPatriciaTrie = AbstractPatriciaTrie.this;
            if (i5 != abstractPatriciaTrie.modCount) {
                throw new ConcurrentModificationException();
            }
            TrieEntry<K, V> trieEntry = this.previous;
            if (trieEntry == null) {
                throw new NoSuchElementException();
            }
            this.previous = abstractPatriciaTrie.previousEntry(trieEntry);
            this.next = this.current;
            this.current = trieEntry;
            return trieEntry;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v6) {
            TrieEntry<K, V> trieEntry = this.current;
            if (trieEntry != null) {
                return trieEntry.setValue(v6);
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Values extends AbstractCollection<V> {

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public class ValueIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<V> {
            private ValueIterator() {
                super();
            }

            @Override // java.util.Iterator
            public V next() {
                return nextEntry().getValue();
            }
        }

        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractPatriciaTrie.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractPatriciaTrie.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            Iterator<V> it = iterator();
            while (it.hasNext()) {
                if (AbstractBitwiseTrie.compare(it.next(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractPatriciaTrie.this.size();
        }
    }

    public AbstractPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        super(keyAnalyzer);
        this.root = new TrieEntry<>(null, null, -1);
        this.size = 0;
        this.modCount = 0;
    }

    private SortedMap<K, V> getPrefixMapByBits(K k6, int i5, int i6) {
        int i7 = i5 + i6;
        if (i7 <= lengthInBits(k6)) {
            return i7 == 0 ? this : new PrefixRangeMap(k6, i5, i6);
        }
        throw new IllegalArgumentException(i5 + " + " + i6 + " > " + lengthInBits(k6));
    }

    private void incrementModCount() {
        this.modCount++;
    }

    public static boolean isValidUplink(TrieEntry<?, ?> trieEntry, TrieEntry<?, ?> trieEntry2) {
        return (trieEntry == null || trieEntry.bitIndex > trieEntry2.bitIndex || trieEntry.isEmpty()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.root = new TrieEntry<>(null, null, -1);
        int i5 = objectInputStream.readInt();
        for (int i6 = 0; i6 < i5; i6++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void removeExternalEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry == this.root) {
            throw new IllegalArgumentException("Cannot delete root Entry!");
        }
        if (!trieEntry.isExternalNode()) {
            throw new IllegalArgumentException(trieEntry + " is not an external Entry!");
        }
        TrieEntry<K, V> trieEntry2 = trieEntry.parent;
        TrieEntry<K, V> trieEntry3 = trieEntry.left;
        if (trieEntry3 == trieEntry) {
            trieEntry3 = trieEntry.right;
        }
        if (trieEntry2.left == trieEntry) {
            trieEntry2.left = trieEntry3;
        } else {
            trieEntry2.right = trieEntry3;
        }
        if (trieEntry3.bitIndex > trieEntry2.bitIndex) {
            trieEntry3.parent = trieEntry2;
        } else {
            trieEntry3.predecessor = trieEntry2;
        }
    }

    private void removeInternalEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry == this.root) {
            throw new IllegalArgumentException("Cannot delete root Entry!");
        }
        if (!trieEntry.isInternalNode()) {
            throw new IllegalArgumentException(trieEntry + " is not an internal Entry!");
        }
        TrieEntry<K, V> trieEntry2 = trieEntry.predecessor;
        trieEntry2.bitIndex = trieEntry.bitIndex;
        TrieEntry<K, V> trieEntry3 = trieEntry2.parent;
        TrieEntry<K, V> trieEntry4 = trieEntry2.left;
        if (trieEntry4 == trieEntry) {
            trieEntry4 = trieEntry2.right;
        }
        if (trieEntry2.predecessor == trieEntry2 && trieEntry3 != trieEntry) {
            trieEntry2.predecessor = trieEntry3;
        }
        if (trieEntry3.left == trieEntry2) {
            trieEntry3.left = trieEntry4;
        } else {
            trieEntry3.right = trieEntry4;
        }
        if (trieEntry4.bitIndex > trieEntry3.bitIndex) {
            trieEntry4.parent = trieEntry3;
        }
        TrieEntry<K, V> trieEntry5 = trieEntry.left;
        if (trieEntry5.parent == trieEntry) {
            trieEntry5.parent = trieEntry2;
        }
        TrieEntry<K, V> trieEntry6 = trieEntry.right;
        if (trieEntry6.parent == trieEntry) {
            trieEntry6.parent = trieEntry2;
        }
        TrieEntry<K, V> trieEntry7 = trieEntry.parent;
        if (trieEntry7.left == trieEntry) {
            trieEntry7.left = trieEntry2;
        } else {
            trieEntry7.right = trieEntry2;
        }
        trieEntry2.parent = trieEntry7;
        TrieEntry<K, V> trieEntry8 = trieEntry.left;
        trieEntry2.left = trieEntry8;
        trieEntry2.right = trieEntry.right;
        if (isValidUplink(trieEntry8, trieEntry2)) {
            trieEntry2.left.predecessor = trieEntry2;
        }
        if (isValidUplink(trieEntry2.right, trieEntry2)) {
            trieEntry2.right.predecessor = trieEntry2;
        }
    }

    private boolean selectR(TrieEntry<K, V> trieEntry, int i5, K k6, int i6, Reference<Map.Entry<K, V>> reference) {
        int i7 = trieEntry.bitIndex;
        if (i7 <= i5) {
            if (trieEntry.isEmpty()) {
                return true;
            }
            reference.set(trieEntry);
            return false;
        }
        if (isBitSet(k6, i7, i6)) {
            if (selectR(trieEntry.right, trieEntry.bitIndex, k6, i6, reference)) {
                return selectR(trieEntry.left, trieEntry.bitIndex, k6, i6, reference);
            }
        } else if (selectR(trieEntry.left, trieEntry.bitIndex, k6, i6, reference)) {
            return selectR(trieEntry.right, trieEntry.bitIndex, k6, i6, reference);
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public TrieEntry<K, V> addEntry(TrieEntry<K, V> trieEntry, int i5) {
        TrieEntry<K, V> trieEntry2;
        int i6;
        TrieEntry<K, V> trieEntry3 = this.root;
        TrieEntry<K, V> trieEntry4 = trieEntry3.left;
        while (true) {
            TrieEntry<K, V> trieEntry5 = trieEntry4;
            trieEntry2 = trieEntry3;
            trieEntry3 = trieEntry5;
            int i7 = trieEntry3.bitIndex;
            i6 = trieEntry.bitIndex;
            if (i7 >= i6 || i7 <= trieEntry2.bitIndex) {
                break;
            }
            trieEntry4 = !isBitSet(trieEntry.key, i7, i5) ? trieEntry3.left : trieEntry3.right;
        }
        trieEntry.predecessor = trieEntry;
        if (isBitSet(trieEntry.key, i6, i5)) {
            trieEntry.left = trieEntry3;
            trieEntry.right = trieEntry;
        } else {
            trieEntry.left = trieEntry;
            trieEntry.right = trieEntry3;
        }
        trieEntry.parent = trieEntry2;
        int i8 = trieEntry3.bitIndex;
        if (i8 >= trieEntry.bitIndex) {
            trieEntry3.parent = trieEntry;
        }
        int i9 = trieEntry2.bitIndex;
        if (i8 <= i9) {
            trieEntry3.predecessor = trieEntry;
        }
        if (trieEntry2 == this.root || !isBitSet(trieEntry.key, i9, i5)) {
            trieEntry2.left = trieEntry;
            return trieEntry;
        }
        trieEntry2.right = trieEntry;
        return trieEntry;
    }

    public TrieEntry<K, V> ceilingEntry(K k6) {
        int iLengthInBits = lengthInBits(k6);
        if (iLengthInBits == 0) {
            return !this.root.isEmpty() ? this.root : firstEntry();
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k6, iLengthInBits);
        if (!compareKeys(k6, nearestEntryForKey.key)) {
            int iBitIndex = bitIndex(k6, nearestEntryForKey.key);
            if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
                TrieEntry<K, V> trieEntry = new TrieEntry<>(k6, null, iBitIndex);
                addEntry(trieEntry, iLengthInBits);
                incrementSize();
                TrieEntry<K, V> trieEntryNextEntry = nextEntry(trieEntry);
                removeEntry(trieEntry);
                this.modCount -= 2;
                return trieEntryNextEntry;
            }
            if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
                return !this.root.isEmpty() ? this.root : firstEntry();
            }
            if (!KeyAnalyzer.isEqualBitKey(iBitIndex)) {
                throw new IllegalStateException(a.l(k6, "invalid lookup: "));
            }
        }
        return nearestEntryForKey;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        TrieEntry<K, V> trieEntry = this.root;
        trieEntry.key = null;
        trieEntry.bitIndex = -1;
        trieEntry.value = null;
        trieEntry.parent = null;
        trieEntry.left = trieEntry;
        trieEntry.right = null;
        trieEntry.predecessor = trieEntry;
        this.size = 0;
        incrementModCount();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return getKeyAnalyzer();
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        K kCastKey = castKey(obj);
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(kCastKey, lengthInBits(kCastKey));
        return !nearestEntryForKey.isEmpty() && compareKeys(kCastKey, nearestEntryForKey.key);
    }

    public void decrementSize() {
        this.size--;
        incrementModCount();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet();
        }
        return this.entrySet;
    }

    public TrieEntry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return followLeft(this.root);
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (size() != 0) {
            return firstEntry().getKey();
        }
        throw new NoSuchElementException();
    }

    public TrieEntry<K, V> floorEntry(K k6) {
        int iLengthInBits = lengthInBits(k6);
        if (iLengthInBits == 0) {
            if (this.root.isEmpty()) {
                return null;
            }
            return this.root;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k6, iLengthInBits);
        if (!compareKeys(k6, nearestEntryForKey.key)) {
            int iBitIndex = bitIndex(k6, nearestEntryForKey.key);
            if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
                TrieEntry<K, V> trieEntry = new TrieEntry<>(k6, null, iBitIndex);
                addEntry(trieEntry, iLengthInBits);
                incrementSize();
                TrieEntry<K, V> trieEntryPreviousEntry = previousEntry(trieEntry);
                removeEntry(trieEntry);
                this.modCount -= 2;
                return trieEntryPreviousEntry;
            }
            if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
                if (this.root.isEmpty()) {
                    return null;
                }
                return this.root;
            }
            if (!KeyAnalyzer.isEqualBitKey(iBitIndex)) {
                throw new IllegalStateException(a.l(k6, "invalid lookup: "));
            }
        }
        return nearestEntryForKey;
    }

    public TrieEntry<K, V> followLeft(TrieEntry<K, V> trieEntry) {
        while (true) {
            TrieEntry<K, V> trieEntry2 = trieEntry.left;
            if (trieEntry2.isEmpty()) {
                trieEntry2 = trieEntry.right;
            }
            if (trieEntry2.bitIndex <= trieEntry.bitIndex) {
                return trieEntry2;
            }
            trieEntry = trieEntry2;
        }
    }

    public TrieEntry<K, V> followRight(TrieEntry<K, V> trieEntry) {
        if (trieEntry.right == null) {
            return null;
        }
        while (true) {
            TrieEntry<K, V> trieEntry2 = trieEntry.right;
            if (trieEntry2.bitIndex <= trieEntry.bitIndex) {
                return trieEntry2;
            }
            trieEntry = trieEntry2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        TrieEntry<K, V> entry = getEntry(obj);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public TrieEntry<K, V> getEntry(Object obj) {
        K kCastKey = castKey(obj);
        if (kCastKey == null) {
            return null;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(kCastKey, lengthInBits(kCastKey));
        if (nearestEntryForKey.isEmpty() || !compareKeys(kCastKey, nearestEntryForKey.key)) {
            return null;
        }
        return nearestEntryForKey;
    }

    public TrieEntry<K, V> getNearestEntryForKey(K k6, int i5) {
        TrieEntry<K, V> trieEntry = this.root;
        TrieEntry<K, V> trieEntry2 = trieEntry.left;
        while (true) {
            TrieEntry<K, V> trieEntry3 = trieEntry2;
            TrieEntry<K, V> trieEntry4 = trieEntry;
            trieEntry = trieEntry3;
            int i6 = trieEntry.bitIndex;
            if (i6 <= trieEntry4.bitIndex) {
                return trieEntry;
            }
            trieEntry2 = !isBitSet(k6, i6, i5) ? trieEntry.left : trieEntry.right;
        }
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k6) {
        return new RangeEntryMap(this, null, k6);
    }

    public TrieEntry<K, V> higherEntry(K k6) {
        int iLengthInBits = lengthInBits(k6);
        if (iLengthInBits == 0) {
            if (this.root.isEmpty()) {
                return firstEntry();
            }
            if (size() > 1) {
                return nextEntry(this.root);
            }
            return null;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k6, iLengthInBits);
        if (compareKeys(k6, nearestEntryForKey.key)) {
            return nextEntry(nearestEntryForKey);
        }
        int iBitIndex = bitIndex(k6, nearestEntryForKey.key);
        if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
            TrieEntry<K, V> trieEntry = new TrieEntry<>(k6, null, iBitIndex);
            addEntry(trieEntry, iLengthInBits);
            incrementSize();
            TrieEntry<K, V> trieEntryNextEntry = nextEntry(trieEntry);
            removeEntry(trieEntry);
            this.modCount -= 2;
            return trieEntryNextEntry;
        }
        if (!KeyAnalyzer.isNullBitKey(iBitIndex)) {
            if (KeyAnalyzer.isEqualBitKey(iBitIndex)) {
                return nextEntry(nearestEntryForKey);
            }
            throw new IllegalStateException(a.l(k6, "invalid lookup: "));
        }
        if (!this.root.isEmpty()) {
            return firstEntry();
        }
        if (size() > 1) {
            return nextEntry(firstEntry());
        }
        return null;
    }

    public void incrementSize() {
        this.size++;
        incrementModCount();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet();
        }
        return this.keySet;
    }

    public TrieEntry<K, V> lastEntry() {
        return followRight(this.root.left);
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        TrieEntry<K, V> trieEntryLastEntry = lastEntry();
        if (trieEntryLastEntry != null) {
            return trieEntryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public TrieEntry<K, V> lowerEntry(K k6) {
        int iLengthInBits = lengthInBits(k6);
        if (iLengthInBits == 0) {
            return null;
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k6, iLengthInBits);
        if (compareKeys(k6, nearestEntryForKey.key)) {
            return previousEntry(nearestEntryForKey);
        }
        int iBitIndex = bitIndex(k6, nearestEntryForKey.key);
        if (!KeyAnalyzer.isValidBitIndex(iBitIndex)) {
            if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
                return null;
            }
            if (KeyAnalyzer.isEqualBitKey(iBitIndex)) {
                return previousEntry(nearestEntryForKey);
            }
            throw new IllegalStateException(a.l(k6, "invalid lookup: "));
        }
        TrieEntry<K, V> trieEntry = new TrieEntry<>(k6, null, iBitIndex);
        addEntry(trieEntry, iLengthInBits);
        incrementSize();
        TrieEntry<K, V> trieEntryPreviousEntry = previousEntry(trieEntry);
        removeEntry(trieEntry);
        this.modCount -= 2;
        return trieEntryPreviousEntry;
    }

    public TrieEntry<K, V> nextEntry(TrieEntry<K, V> trieEntry) {
        return trieEntry == null ? firstEntry() : nextEntryImpl(trieEntry.predecessor, trieEntry, null);
    }

    public TrieEntry<K, V> nextEntryImpl(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2, TrieEntry<K, V> trieEntry3) {
        TrieEntry<K, V> trieEntry4;
        TrieEntry<K, V> trieEntry5;
        if (trieEntry2 == null || trieEntry != trieEntry2.predecessor) {
            while (!trieEntry.left.isEmpty() && trieEntry2 != (trieEntry4 = trieEntry.left)) {
                if (isValidUplink(trieEntry4, trieEntry)) {
                    return trieEntry.left;
                }
                trieEntry = trieEntry.left;
            }
        }
        if (trieEntry.isEmpty() || (trieEntry5 = trieEntry.right) == null) {
            return null;
        }
        if (trieEntry2 != trieEntry5) {
            return isValidUplink(trieEntry5, trieEntry) ? trieEntry.right : nextEntryImpl(trieEntry.right, trieEntry2, trieEntry3);
        }
        while (true) {
            TrieEntry<K, V> trieEntry6 = trieEntry.parent;
            TrieEntry<K, V> trieEntry7 = trieEntry6.right;
            if (trieEntry != trieEntry7) {
                if (trieEntry == trieEntry3 || trieEntry7 == null) {
                    return null;
                }
                if (trieEntry2 != trieEntry7 && isValidUplink(trieEntry7, trieEntry6)) {
                    return trieEntry.parent.right;
                }
                TrieEntry<K, V> trieEntry8 = trieEntry.parent;
                TrieEntry<K, V> trieEntry9 = trieEntry8.right;
                if (trieEntry9 == trieEntry8) {
                    return null;
                }
                return nextEntryImpl(trieEntry9, trieEntry2, trieEntry3);
            }
            if (trieEntry == trieEntry3) {
                return null;
            }
            trieEntry = trieEntry6;
        }
    }

    public TrieEntry<K, V> nextEntryInSubtree(TrieEntry<K, V> trieEntry, TrieEntry<K, V> trieEntry2) {
        return trieEntry == null ? firstEntry() : nextEntryImpl(trieEntry.predecessor, trieEntry, trieEntry2);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k6) {
        TrieEntry<K, V> trieEntryNextEntry;
        k6.getClass();
        TrieEntry<K, V> entry = getEntry(k6);
        if (entry == null || (trieEntryNextEntry = nextEntry(entry)) == null) {
            return null;
        }
        return trieEntryNextEntry.getKey();
    }

    @Override // org.apache.commons.collections4.Trie
    public SortedMap<K, V> prefixMap(K k6) {
        return getPrefixMapByBits(k6, 0, lengthInBits(k6));
    }

    public TrieEntry<K, V> previousEntry(TrieEntry<K, V> trieEntry) {
        TrieEntry<K, V> trieEntry2;
        TrieEntry<K, V> trieEntry3 = trieEntry.predecessor;
        if (trieEntry3 == null) {
            throw new IllegalArgumentException("must have come from somewhere!");
        }
        if (trieEntry3.right == trieEntry) {
            return isValidUplink(trieEntry3.left, trieEntry3) ? trieEntry.predecessor.left : followRight(trieEntry.predecessor.left);
        }
        while (true) {
            trieEntry2 = trieEntry3.parent;
            if (trieEntry2 == null || trieEntry3 != trieEntry2.left) {
                break;
            }
            trieEntry3 = trieEntry2;
        }
        if (trieEntry2 == null) {
            return null;
        }
        if (!isValidUplink(trieEntry2.left, trieEntry2)) {
            return followRight(trieEntry3.parent.left);
        }
        TrieEntry<K, V> trieEntry4 = trieEntry3.parent.left;
        TrieEntry<K, V> trieEntry5 = this.root;
        if (trieEntry4 != trieEntry5) {
            return trieEntry4;
        }
        if (trieEntry5.isEmpty()) {
            return null;
        }
        return this.root;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k6) {
        TrieEntry<K, V> trieEntryPreviousEntry;
        k6.getClass();
        TrieEntry<K, V> entry = getEntry(k6);
        if (entry == null || (trieEntryPreviousEntry = previousEntry(entry)) == null) {
            return null;
        }
        return trieEntryPreviousEntry.getKey();
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k6, V v6) {
        if (k6 == null) {
            throw new NullPointerException("Key cannot be null");
        }
        int iLengthInBits = lengthInBits(k6);
        if (iLengthInBits == 0) {
            if (this.root.isEmpty()) {
                incrementSize();
            } else {
                incrementModCount();
            }
            return this.root.setKeyValue(k6, v6);
        }
        TrieEntry<K, V> nearestEntryForKey = getNearestEntryForKey(k6, iLengthInBits);
        if (compareKeys(k6, nearestEntryForKey.key)) {
            if (nearestEntryForKey.isEmpty()) {
                incrementSize();
            } else {
                incrementModCount();
            }
            return nearestEntryForKey.setKeyValue(k6, v6);
        }
        int iBitIndex = bitIndex(k6, nearestEntryForKey.key);
        if (!KeyAnalyzer.isOutOfBoundsIndex(iBitIndex)) {
            if (KeyAnalyzer.isValidBitIndex(iBitIndex)) {
                addEntry(new TrieEntry<>(k6, v6, iBitIndex), iLengthInBits);
                incrementSize();
                return null;
            }
            if (KeyAnalyzer.isNullBitKey(iBitIndex)) {
                if (this.root.isEmpty()) {
                    incrementSize();
                } else {
                    incrementModCount();
                }
                return this.root.setKeyValue(k6, v6);
            }
            if (KeyAnalyzer.isEqualBitKey(iBitIndex) && nearestEntryForKey != this.root) {
                incrementModCount();
                return nearestEntryForKey.setKeyValue(k6, v6);
            }
        }
        throw new IllegalArgumentException("Failed to put: " + k6 + " -> " + v6 + ", " + iBitIndex);
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        K kCastKey = castKey(obj);
        int iLengthInBits = lengthInBits(kCastKey);
        TrieEntry<K, V> trieEntry = this.root;
        TrieEntry<K, V> trieEntry2 = trieEntry.left;
        while (true) {
            TrieEntry<K, V> trieEntry3 = trieEntry2;
            TrieEntry<K, V> trieEntry4 = trieEntry;
            trieEntry = trieEntry3;
            int i5 = trieEntry.bitIndex;
            if (i5 <= trieEntry4.bitIndex) {
                break;
            }
            trieEntry2 = !isBitSet(kCastKey, i5, iLengthInBits) ? trieEntry.left : trieEntry.right;
        }
        if (trieEntry.isEmpty() || !compareKeys(kCastKey, trieEntry.key)) {
            return null;
        }
        return removeEntry(trieEntry);
    }

    public V removeEntry(TrieEntry<K, V> trieEntry) {
        if (trieEntry != this.root) {
            if (trieEntry.isInternalNode()) {
                removeInternalEntry(trieEntry);
            } else {
                removeExternalEntry(trieEntry);
            }
        }
        decrementSize();
        return trieEntry.setKeyValue(null, null);
    }

    public Map.Entry<K, V> select(K k6) {
        int iLengthInBits = lengthInBits(k6);
        Reference<Map.Entry<K, V>> reference = new Reference<>();
        if (selectR(this.root.left, -1, k6, iLengthInBits, reference)) {
            return null;
        }
        return reference.get();
    }

    public K selectKey(K k6) {
        Map.Entry<K, V> entrySelect = select(k6);
        if (entrySelect == null) {
            return null;
        }
        return entrySelect.getKey();
    }

    public V selectValue(K k6) {
        Map.Entry<K, V> entrySelect = select(k6);
        if (entrySelect == null) {
            return null;
        }
        return entrySelect.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.size;
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k6, K k7) {
        return new RangeEntryMap(this, k6, k7);
    }

    public TrieEntry<K, V> subtree(K k6, int i5, int i6) {
        TrieEntry<K, V> trieEntry;
        TrieEntry<K, V> trieEntry2 = this.root;
        TrieEntry<K, V> trieEntry3 = trieEntry2.left;
        while (true) {
            TrieEntry<K, V> trieEntry4 = trieEntry3;
            trieEntry = trieEntry2;
            trieEntry2 = trieEntry4;
            int i7 = trieEntry2.bitIndex;
            if (i7 <= trieEntry.bitIndex || i6 <= i7) {
                break;
            }
            trieEntry3 = !isBitSet(k6, i7 + i5, i5 + i6) ? trieEntry2.left : trieEntry2.right;
        }
        if (trieEntry2.isEmpty()) {
            trieEntry2 = trieEntry;
        }
        if (trieEntry2.isEmpty()) {
            return null;
        }
        int i8 = i5 + i6;
        if (trieEntry2 == this.root && lengthInBits(trieEntry2.getKey()) < i8) {
            return null;
        }
        boolean zIsBitSet = isBitSet(k6, i8 - 1, i8);
        K k7 = trieEntry2.key;
        if (zIsBitSet != isBitSet(k7, i6 - 1, lengthInBits(k7))) {
            return null;
        }
        int iBitIndex = getKeyAnalyzer().bitIndex(k6, i5, i6, trieEntry2.key, 0, lengthInBits(trieEntry2.getKey()));
        if (iBitIndex < 0 || iBitIndex >= i6) {
            return trieEntry2;
        }
        return null;
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k6) {
        return new RangeEntryMap(this, k6, null);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap, org.apache.commons.collections4.Get
    public Collection<V> values() {
        if (this.values == null) {
            this.values = new Values();
        }
        return this.values;
    }

    @Override // org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new TrieMapIterator();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public abstract class TrieIterator<E> implements Iterator<E> {
        protected TrieEntry<K, V> current;
        protected int expectedModCount;
        protected TrieEntry<K, V> next;

        public TrieIterator() {
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            this.next = AbstractPatriciaTrie.this.nextEntry(null);
        }

        public TrieEntry<K, V> findNext(TrieEntry<K, V> trieEntry) {
            return AbstractPatriciaTrie.this.nextEntry(trieEntry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        public TrieEntry<K, V> nextEntry() {
            if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
                throw new ConcurrentModificationException();
            }
            TrieEntry<K, V> trieEntry = this.next;
            if (trieEntry == null) {
                throw new NoSuchElementException();
            }
            this.next = findNext(trieEntry);
            this.current = trieEntry;
            return trieEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            TrieEntry<K, V> trieEntry = this.current;
            if (trieEntry == null) {
                throw new IllegalStateException();
            }
            int i5 = this.expectedModCount;
            AbstractPatriciaTrie abstractPatriciaTrie = AbstractPatriciaTrie.this;
            if (i5 != abstractPatriciaTrie.modCount) {
                throw new ConcurrentModificationException();
            }
            this.current = null;
            abstractPatriciaTrie.removeEntry(trieEntry);
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
        }

        public TrieIterator(TrieEntry<K, V> trieEntry) {
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
            this.next = trieEntry;
        }
    }

    public AbstractPatriciaTrie(KeyAnalyzer<? super K> keyAnalyzer, Map<? extends K, ? extends V> map) {
        super(keyAnalyzer);
        this.root = new TrieEntry<>(null, null, -1);
        this.size = 0;
        this.modCount = 0;
        putAll(map);
    }
}
