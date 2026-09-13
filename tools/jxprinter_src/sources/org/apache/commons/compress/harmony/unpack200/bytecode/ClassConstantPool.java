package org.apache.commons.compress.harmony.unpack200.bytecode;

import I4.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClassConstantPool {
    protected Map indexCache;
    private boolean resolved;
    protected HashSet entriesContainsSet = new HashSet();
    protected HashSet othersContainsSet = new HashSet();
    private final HashSet mustStartClassPool = new HashSet();
    private final List others = new ArrayList(Videoio.CAP_QT);
    private final List entries = new ArrayList(Videoio.CAP_QT);

    private void initialSort() {
        TreeSet treeSet = new TreeSet(new a(20));
        TreeSet treeSet2 = new TreeSet(new a(21));
        TreeSet treeSet3 = new TreeSet(new a(22));
        for (int i5 = 0; i5 < this.entries.size(); i5++) {
            ConstantPoolEntry constantPoolEntry = (ConstantPoolEntry) this.entries.get(i5);
            if (constantPoolEntry.getGlobalIndex() != -1) {
                treeSet.add(constantPoolEntry);
            } else if (constantPoolEntry instanceof CPUTF8) {
                treeSet2.add(constantPoolEntry);
            } else {
                if (!(constantPoolEntry instanceof CPClass)) {
                    throw new Error("error");
                }
                treeSet3.add(constantPoolEntry);
            }
        }
        this.entries.clear();
        this.entries.addAll(treeSet);
        this.entries.addAll(treeSet2);
        this.entries.addAll(treeSet3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$initialSort$0(Object obj, Object obj2) {
        return ((ConstantPoolEntry) obj).getGlobalIndex() - ((ConstantPoolEntry) obj2).getGlobalIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$initialSort$1(Object obj, Object obj2) {
        return ((CPUTF8) obj).underlyingString().compareTo(((CPUTF8) obj2).underlyingString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$initialSort$2(Object obj, Object obj2) {
        return ((CPClass) obj).getName().compareTo(((CPClass) obj2).getName());
    }

    public ClassFileEntry add(ClassFileEntry classFileEntry) {
        if (classFileEntry instanceof ByteCode) {
            return null;
        }
        if (classFileEntry instanceof ConstantPoolEntry) {
            if (this.entriesContainsSet.add(classFileEntry)) {
                this.entries.add(classFileEntry);
                return classFileEntry;
            }
        } else if (this.othersContainsSet.add(classFileEntry)) {
            this.others.add(classFileEntry);
        }
        return classFileEntry;
    }

    public void addNestedEntries() {
        ArrayList arrayList = new ArrayList(512);
        ArrayList arrayList2 = new ArrayList(512);
        arrayList.addAll(this.entries);
        arrayList.addAll(this.others);
        boolean z6 = true;
        while (true) {
            if (!z6 && arrayList.size() <= 0) {
                return;
            }
            arrayList2.clear();
            int size = this.entries.size();
            int size2 = this.others.size();
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                ClassFileEntry classFileEntry = (ClassFileEntry) arrayList.get(i5);
                ClassFileEntry[] nestedClassFileEntries = classFileEntry.getNestedClassFileEntries();
                arrayList2.addAll(Arrays.asList(nestedClassFileEntries));
                if ((classFileEntry instanceof ByteCode) && ((ByteCode) classFileEntry).nestedMustStartClassPool()) {
                    this.mustStartClassPool.addAll(Arrays.asList(nestedClassFileEntries));
                }
                add(classFileEntry);
            }
            z6 = (this.entries.size() == size && this.others.size() == size2) ? false : true;
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
    }

    public ClassFileEntry addWithNestedEntries(ClassFileEntry classFileEntry) {
        add(classFileEntry);
        for (ClassFileEntry classFileEntry2 : classFileEntry.getNestedClassFileEntries()) {
            addWithNestedEntries(classFileEntry2);
        }
        return classFileEntry;
    }

    public List entries() {
        return Collections.unmodifiableList(this.entries);
    }

    public ClassFileEntry get(int i5) {
        if (this.resolved) {
            return (ClassFileEntry) this.entries.get(i5 - 1);
        }
        throw new IllegalStateException("Constant pool is not yet resolved; this does not make any sense");
    }

    public int indexOf(ClassFileEntry classFileEntry) {
        if (!this.resolved) {
            throw new IllegalStateException("Constant pool is not yet resolved; this does not make any sense");
        }
        Map map = this.indexCache;
        if (map == null) {
            throw new IllegalStateException("Index cache is not initialized!");
        }
        Integer num = (Integer) map.get(classFileEntry);
        if (num != null) {
            return num.intValue() + 1;
        }
        return -1;
    }

    public void resolve(Segment segment) {
        initialSort();
        sortClassPool();
        this.resolved = true;
        for (int i5 = 0; i5 < this.entries.size(); i5++) {
            ((ClassFileEntry) this.entries.get(i5)).resolve(this);
        }
        for (int i6 = 0; i6 < this.others.size(); i6++) {
            ((ClassFileEntry) this.others.get(i6)).resolve(this);
        }
    }

    public int size() {
        return this.entries.size();
    }

    public void sortClassPool() {
        ArrayList arrayList = new ArrayList(this.entries.size());
        ArrayList arrayList2 = new ArrayList(this.entries.size());
        for (int i5 = 0; i5 < this.entries.size(); i5++) {
            ClassFileEntry classFileEntry = (ClassFileEntry) this.entries.get(i5);
            if (this.mustStartClassPool.contains(classFileEntry)) {
                arrayList.add(classFileEntry);
            } else {
                arrayList2.add(classFileEntry);
            }
        }
        this.indexCache = new HashMap(this.entries.size());
        this.entries.clear();
        int i6 = 0;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            ClassFileEntry classFileEntry2 = (ClassFileEntry) arrayList.get(i7);
            this.indexCache.put(classFileEntry2, Integer.valueOf(i6));
            if ((classFileEntry2 instanceof CPLong) || (classFileEntry2 instanceof CPDouble)) {
                this.entries.add(classFileEntry2);
                this.entries.add(classFileEntry2);
                i6 += 2;
            } else {
                this.entries.add(classFileEntry2);
                i6++;
            }
        }
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            ClassFileEntry classFileEntry3 = (ClassFileEntry) arrayList2.get(i8);
            this.indexCache.put(classFileEntry3, Integer.valueOf(i6));
            if ((classFileEntry3 instanceof CPLong) || (classFileEntry3 instanceof CPDouble)) {
                this.entries.add(classFileEntry3);
                this.entries.add(classFileEntry3);
                i6 += 2;
            } else {
                this.entries.add(classFileEntry3);
                i6++;
            }
        }
    }
}
