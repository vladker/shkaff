package org.apache.logging.log4j.util;

import A3.AbstractC0157z;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SortedArrayStringMap implements IndexedStringMap {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final String FROZEN = "Frozen collection cannot be modified";
    private static final int HASHVAL = 31;
    private static final Method getObjectInputFilter;
    private static final Method newObjectInputFilter;
    private static final long serialVersionUID = -5748905872274478116L;
    private static final Method setObjectInputFilter;
    private boolean immutable;
    private transient boolean iterating;
    private transient String[] keys;
    private transient int size;
    private int threshold;
    private transient Object[] values;
    private static final TriConsumer<String, Object, StringMap> PUT_ALL = new c();
    private static final String[] EMPTY = Strings.EMPTY_ARRAY;

    static {
        Method method = null;
        Method method2 = null;
        Method method3 = null;
        for (Method method4 : ObjectInputStream.class.getMethods()) {
            if (method4.getName().equals("setObjectInputFilter")) {
                method2 = method4;
            } else if (method4.getName().equals("getObjectInputFilter")) {
                method3 = method4;
            }
        }
        if (method2 != null) {
            try {
                for (Method method5 : Class.forName("org.apache.logging.log4j.util.internal.DefaultObjectInputFilter").getMethods()) {
                    if (method5.getName().equals("newInstance") && Modifier.isStatic(method5.getModifiers())) {
                        method = method5;
                        break;
                    }
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        newObjectInputFilter = method;
        setObjectInputFilter = method2;
        getObjectInputFilter = method3;
    }

    public SortedArrayStringMap() {
        this(4);
    }

    private void assertNoConcurrentModification() {
        if (this.iterating) {
            throw new ConcurrentModificationException();
        }
    }

    private void assertNotFrozen() {
        if (this.immutable) {
            throw new UnsupportedOperationException(FROZEN);
        }
    }

    private static int ceilingNextPowerOfTwo(int i5) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i5 - 1));
    }

    private void ensureCapacity() {
        int i5 = this.size;
        int i6 = this.threshold;
        if (i5 >= i6) {
            resize(i6 * 2);
        }
    }

    private void handleSerializationException(Throwable th, int i5, String str) {
        StatusLogger.getLogger().warn("Ignoring {} for key[{}] ('{}')", String.valueOf(th), Integer.valueOf(i5), this.keys[i5]);
    }

    private void inflateTable(int i5) {
        this.threshold = i5;
        this.keys = new String[i5];
        this.values = new Object[i5];
    }

    private void initFrom0(SortedArrayStringMap sortedArrayStringMap) {
        int length = this.keys.length;
        int i5 = sortedArrayStringMap.size;
        if (length < i5) {
            int i6 = sortedArrayStringMap.threshold;
            this.keys = new String[i6];
            this.values = new Object[i6];
        }
        System.arraycopy(sortedArrayStringMap.keys, 0, this.keys, 0, i5);
        System.arraycopy(sortedArrayStringMap.values, 0, this.values, 0, sortedArrayStringMap.size);
        this.size = sortedArrayStringMap.size;
        this.threshold = sortedArrayStringMap.threshold;
    }

    private void insertAt(int i5, String str, Object obj) {
        ensureCapacity();
        String[] strArr = this.keys;
        int i6 = i5 + 1;
        System.arraycopy(strArr, i5, strArr, i6, this.size - i5);
        Object[] objArr = this.values;
        System.arraycopy(objArr, i5, objArr, i6, this.size - i5);
        this.keys[i5] = str;
        this.values[i5] = obj;
        this.size++;
    }

    private static byte[] marshall(Object obj) throws IOException {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    objectOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void merge(SortedArrayStringMap sortedArrayStringMap) {
        String[] strArr = this.keys;
        Object[] objArr = this.values;
        int i5 = sortedArrayStringMap.size + this.size;
        int iCeilingNextPowerOfTwo = ceilingNextPowerOfTwo(i5);
        this.threshold = iCeilingNextPowerOfTwo;
        if (this.keys.length < iCeilingNextPowerOfTwo) {
            this.keys = new String[iCeilingNextPowerOfTwo];
            this.values = new Object[iCeilingNextPowerOfTwo];
        }
        boolean z6 = false;
        if (sortedArrayStringMap.size() > size()) {
            System.arraycopy(strArr, 0, this.keys, sortedArrayStringMap.size, this.size);
            System.arraycopy(objArr, 0, this.values, sortedArrayStringMap.size, this.size);
            System.arraycopy(sortedArrayStringMap.keys, 0, this.keys, 0, sortedArrayStringMap.size);
            System.arraycopy(sortedArrayStringMap.values, 0, this.values, 0, sortedArrayStringMap.size);
            this.size = sortedArrayStringMap.size;
        } else {
            System.arraycopy(strArr, 0, this.keys, 0, this.size);
            System.arraycopy(objArr, 0, this.values, 0, this.size);
            System.arraycopy(sortedArrayStringMap.keys, 0, this.keys, this.size, sortedArrayStringMap.size);
            System.arraycopy(sortedArrayStringMap.values, 0, this.values, this.size, sortedArrayStringMap.size);
            z6 = true;
        }
        for (int i6 = this.size; i6 < i5; i6++) {
            int iIndexOfKey = indexOfKey(this.keys[i6]);
            if (iIndexOfKey < 0) {
                insertAt(~iIndexOfKey, this.keys[i6], this.values[i6]);
            } else if (z6) {
                String[] strArr2 = this.keys;
                strArr2[iIndexOfKey] = strArr2[i6];
                Object[] objArr2 = this.values;
                objArr2[iIndexOfKey] = objArr2[i6];
            }
        }
        Arrays.fill(this.keys, this.size, i5, (Object) null);
        Arrays.fill(this.values, this.size, i5, (Object) null);
    }

    private int nullKeyIndex() {
        return (this.size <= 0 || this.keys[0] != null) ? -1 : 0;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        if (!(objectInputStream instanceof FilteredObjectInputStream) && setObjectInputFilter == null) {
            throw new IllegalArgumentException("readObject requires a FilteredObjectInputStream or an ObjectInputStream that accepts an ObjectInputFilter");
        }
        objectInputStream.defaultReadObject();
        String[] strArr = EMPTY;
        this.keys = strArr;
        this.values = strArr;
        int i5 = objectInputStream.readInt();
        if (i5 < 0) {
            throw new InvalidObjectException(AbstractC0157z.k(i5, "Illegal capacity: "));
        }
        int i6 = objectInputStream.readInt();
        if (i6 < 0) {
            throw new InvalidObjectException(AbstractC0157z.k(i6, "Illegal mappings count: "));
        }
        if (i6 > 0) {
            inflateTable(i5);
        } else {
            this.threshold = i5;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            this.keys[i7] = (String) objectInputStream.readObject();
            try {
                byte[] bArr = (byte[]) objectInputStream.readObject();
                this.values[i7] = bArr == null ? null : unmarshall(bArr, objectInputStream);
            } catch (Exception | LinkageError e) {
                handleSerializationException(e, i7, this.keys[i7]);
                this.values[i7] = null;
            }
        }
        this.size = i6;
    }

    private void resize(int i5) {
        String[] strArr = this.keys;
        Object[] objArr = this.values;
        String[] strArr2 = new String[i5];
        this.keys = strArr2;
        this.values = new Object[i5];
        System.arraycopy(strArr, 0, strArr2, 0, this.size);
        System.arraycopy(objArr, 0, this.values, 0, this.size);
        this.threshold = i5;
    }

    private static Object unmarshall(byte[] bArr, ObjectInputStream objectInputStream) throws IOException {
        ObjectInputStream objectInputStream2;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (objectInputStream instanceof FilteredObjectInputStream) {
            objectInputStream2 = new FilteredObjectInputStream(byteArrayInputStream, ((FilteredObjectInputStream) objectInputStream).getAllowedClasses());
        } else {
            try {
                Object objInvoke = newObjectInputFilter.invoke(null, getObjectInputFilter.invoke(objectInputStream, null));
                objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
                setObjectInputFilter.invoke(objectInputStream2, objInvoke);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new StreamCorruptedException("Unable to set ObjectInputFilter on stream");
            }
        }
        try {
            return objectInputStream2.readObject();
        } finally {
            objectInputStream2.close();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        String[] strArr = this.keys;
        if (strArr == EMPTY) {
            objectOutputStream.writeInt(ceilingNextPowerOfTwo(this.threshold));
        } else {
            objectOutputStream.writeInt(strArr.length);
        }
        objectOutputStream.writeInt(this.size);
        if (this.size > 0) {
            for (int i5 = 0; i5 < this.size; i5++) {
                objectOutputStream.writeObject(this.keys[i5]);
                try {
                    objectOutputStream.writeObject(marshall(this.values[i5]));
                } catch (Exception e) {
                    handleSerializationException(e, i5, this.keys[i5]);
                    objectOutputStream.writeObject(null);
                }
            }
        }
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void clear() {
        if (this.keys == EMPTY) {
            return;
        }
        assertNotFrozen();
        assertNoConcurrentModification();
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        this.size = 0;
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public boolean containsKey(String str) {
        return indexOfKey(str) >= 0;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SortedArrayStringMap)) {
            return false;
        }
        SortedArrayStringMap sortedArrayStringMap = (SortedArrayStringMap) obj;
        if (size() != sortedArrayStringMap.size()) {
            return false;
        }
        for (int i5 = 0; i5 < size(); i5++) {
            if (!Objects.equals(this.keys[i5], sortedArrayStringMap.keys[i5]) || !Objects.equals(this.values[i5], sortedArrayStringMap.values[i5])) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V> void forEach(BiConsumer<String, ? super V> biConsumer) {
        this.iterating = true;
        for (int i5 = 0; i5 < this.size; i5++) {
            try {
                biConsumer.accept(this.keys[i5], this.values[i5]);
            } catch (Throwable th) {
                this.iterating = false;
                throw th;
            }
        }
        this.iterating = false;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void freeze() {
        this.immutable = true;
    }

    @Override // org.apache.logging.log4j.util.IndexedReadOnlyStringMap
    public String getKeyAt(int i5) {
        if (i5 < 0 || i5 >= this.size) {
            return null;
        }
        return this.keys[i5];
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V> V getValue(String str) {
        int iIndexOfKey = indexOfKey(str);
        if (iIndexOfKey < 0) {
            return null;
        }
        return (V) this.values[iIndexOfKey];
    }

    @Override // org.apache.logging.log4j.util.IndexedReadOnlyStringMap
    public <V> V getValueAt(int i5) {
        if (i5 < 0 || i5 >= this.size) {
            return null;
        }
        return (V) this.values[i5];
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public int hashCode() {
        int i5 = this.size;
        return ((((1147 + i5) * 31) + hashCode(this.keys, i5)) * 31) + hashCode(this.values, this.size);
    }

    @Override // org.apache.logging.log4j.util.IndexedReadOnlyStringMap
    public int indexOfKey(String str) {
        String[] strArr = this.keys;
        if (strArr == EMPTY) {
            return -1;
        }
        if (str == null) {
            return nullKeyIndex();
        }
        int i5 = this.size;
        int i6 = 0;
        if (i5 > 0 && strArr[0] == null) {
            i6 = 1;
        }
        return Arrays.binarySearch(strArr, i6, i5, str);
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public boolean isFrozen() {
        return this.immutable;
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void putAll(ReadOnlyStringMap readOnlyStringMap) {
        if (readOnlyStringMap == this || readOnlyStringMap == null || readOnlyStringMap.isEmpty()) {
            return;
        }
        assertNotFrozen();
        assertNoConcurrentModification();
        if (!(readOnlyStringMap instanceof SortedArrayStringMap)) {
            readOnlyStringMap.forEach(PUT_ALL, this);
        } else if (this.size == 0) {
            initFrom0((SortedArrayStringMap) readOnlyStringMap);
        } else {
            merge((SortedArrayStringMap) readOnlyStringMap);
        }
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void putValue(String str, Object obj) {
        assertNotFrozen();
        assertNoConcurrentModification();
        if (this.keys == EMPTY) {
            inflateTable(this.threshold);
        }
        int iIndexOfKey = indexOfKey(str);
        if (iIndexOfKey < 0) {
            insertAt(~iIndexOfKey, str, obj);
        } else {
            this.keys[iIndexOfKey] = str;
            this.values[iIndexOfKey] = obj;
        }
    }

    @Override // org.apache.logging.log4j.util.StringMap
    public void remove(String str) {
        int iIndexOfKey;
        if (this.keys != EMPTY && (iIndexOfKey = indexOfKey(str)) >= 0) {
            assertNotFrozen();
            assertNoConcurrentModification();
            String[] strArr = this.keys;
            int i5 = iIndexOfKey + 1;
            System.arraycopy(strArr, i5, strArr, iIndexOfKey, (this.size - 1) - iIndexOfKey);
            Object[] objArr = this.values;
            System.arraycopy(objArr, i5, objArr, iIndexOfKey, (this.size - 1) - iIndexOfKey);
            String[] strArr2 = this.keys;
            int i6 = this.size;
            strArr2[i6 - 1] = null;
            this.values[i6 - 1] = null;
            this.size = i6 - 1;
        }
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public int size() {
        return this.size;
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public Map<String, String> toMap() {
        HashMap map = new HashMap(size());
        for (int i5 = 0; i5 < size(); i5++) {
            Object valueAt = getValueAt(i5);
            map.put(getKeyAt(i5), valueAt == null ? null : String.valueOf(valueAt));
        }
        return map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append('{');
        for (int i5 = 0; i5 < this.size; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(this.keys[i5]);
            sb.append(Chars.EQ);
            Object obj = this.values[i5];
            if (obj == this) {
                obj = "(this map)";
            }
            sb.append(obj);
        }
        sb.append('}');
        return sb.toString();
    }

    public SortedArrayStringMap(int i5) {
        String[] strArr = EMPTY;
        this.keys = strArr;
        this.values = strArr;
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Initial capacity must be at least zero but was "));
        }
        this.threshold = ceilingNextPowerOfTwo(i5 == 0 ? 1 : i5);
    }

    private static int hashCode(Object[] objArr, int i5) {
        int iHashCode = 1;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iHashCode * 31;
            Object obj = objArr[i6];
            iHashCode = i7 + (obj == null ? 0 : obj.hashCode());
        }
        return iHashCode;
    }

    @Override // org.apache.logging.log4j.util.ReadOnlyStringMap
    public <V, T> void forEach(TriConsumer<String, ? super V, T> triConsumer, T t6) {
        this.iterating = true;
        for (int i5 = 0; i5 < this.size; i5++) {
            try {
                triConsumer.accept(this.keys[i5], this.values[i5], t6);
            } catch (Throwable th) {
                this.iterating = false;
                throw th;
            }
        }
        this.iterating = false;
    }

    public SortedArrayStringMap(ReadOnlyStringMap readOnlyStringMap) {
        String[] strArr = EMPTY;
        this.keys = strArr;
        this.values = strArr;
        if (readOnlyStringMap instanceof SortedArrayStringMap) {
            initFrom0((SortedArrayStringMap) readOnlyStringMap);
        } else if (readOnlyStringMap != null) {
            resize(ceilingNextPowerOfTwo(readOnlyStringMap.size()));
            readOnlyStringMap.forEach(PUT_ALL, this);
        }
    }

    public SortedArrayStringMap(Map<String, ?> map) {
        String[] strArr = EMPTY;
        this.keys = strArr;
        this.values = strArr;
        resize(ceilingNextPowerOfTwo(map.size()));
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            putValue(Objects.toString(entry.getKey(), null), entry.getValue());
        }
    }
}
