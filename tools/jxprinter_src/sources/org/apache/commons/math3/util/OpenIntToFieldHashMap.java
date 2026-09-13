package org.apache.commons.math3.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OpenIntToFieldHashMap<T extends FieldElement<T>> implements Serializable {
    private static final int DEFAULT_EXPECTED_SIZE = 16;
    protected static final byte FREE = 0;
    protected static final byte FULL = 1;
    private static final float LOAD_FACTOR = 0.5f;
    private static final int PERTURB_SHIFT = 5;
    protected static final byte REMOVED = 2;
    private static final int RESIZE_MULTIPLIER = 2;
    private static final long serialVersionUID = -9179080286849120720L;
    private transient int count;
    private final Field<T> field;
    private int[] keys;
    private int mask;
    private final T missingEntries;
    private int size;
    private byte[] states;
    private T[] values;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Iterator {
        private int current;
        private int next;
        private final int referenceCount;

        public void advance() {
            byte[] bArr;
            int i5;
            if (this.referenceCount != OpenIntToFieldHashMap.this.count) {
                throw new ConcurrentModificationException();
            }
            this.current = this.next;
            do {
                try {
                    bArr = OpenIntToFieldHashMap.this.states;
                    i5 = this.next + 1;
                    this.next = i5;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    this.next = -2;
                    if (this.current < 0) {
                        throw new NoSuchElementException();
                    }
                    return;
                }
            } while (bArr[i5] != 1);
        }

        public boolean hasNext() {
            return this.next >= 0;
        }

        public int key() {
            if (this.referenceCount != OpenIntToFieldHashMap.this.count) {
                throw new ConcurrentModificationException();
            }
            if (this.current >= 0) {
                return OpenIntToFieldHashMap.this.keys[this.current];
            }
            throw new NoSuchElementException();
        }

        public T value() {
            if (this.referenceCount != OpenIntToFieldHashMap.this.count) {
                throw new ConcurrentModificationException();
            }
            if (this.current >= 0) {
                return (T) OpenIntToFieldHashMap.this.values[this.current];
            }
            throw new NoSuchElementException();
        }

        private Iterator() {
            this.referenceCount = OpenIntToFieldHashMap.this.count;
            this.next = -1;
            try {
                advance();
            } catch (NoSuchElementException unused) {
            }
        }
    }

    public OpenIntToFieldHashMap(Field<T> field) {
        this(field, 16, field.getZero());
    }

    private T[] buildArray(int i5) {
        return (T[]) ((FieldElement[]) Array.newInstance(this.field.getRuntimeClass(), i5));
    }

    private static int changeIndexSign(int i5) {
        return (-i5) - 1;
    }

    private static int computeCapacity(int i5) {
        if (i5 == 0) {
            return 1;
        }
        int iCeil = (int) FastMath.ceil(i5 / 0.5f);
        return Integer.highestOneBit(iCeil) == iCeil ? iCeil : nextPowerOfTwo(iCeil);
    }

    private T doRemove(int i5) {
        this.keys[i5] = 0;
        this.states[i5] = 2;
        T[] tArr = this.values;
        T t6 = tArr[i5];
        tArr[i5] = this.missingEntries;
        this.size--;
        this.count++;
        return t6;
    }

    private int findInsertionIndex(int i5) {
        return findInsertionIndex(this.keys, this.states, i5, this.mask);
    }

    private void growTable() {
        byte[] bArr = this.states;
        int length = bArr.length;
        int[] iArr = this.keys;
        T[] tArr = this.values;
        int i5 = length * 2;
        int[] iArr2 = new int[i5];
        T[] tArr2 = (T[]) buildArray(i5);
        byte[] bArr2 = new byte[i5];
        int i6 = i5 - 1;
        for (int i7 = 0; i7 < length; i7++) {
            if (bArr[i7] == 1) {
                int i8 = iArr[i7];
                int iFindInsertionIndex = findInsertionIndex(iArr2, bArr2, i8, i6);
                iArr2[iFindInsertionIndex] = i8;
                tArr2[iFindInsertionIndex] = tArr[i7];
                bArr2[iFindInsertionIndex] = 1;
            }
        }
        this.mask = i6;
        this.keys = iArr2;
        this.values = tArr2;
        this.states = bArr2;
    }

    private static int hashOf(int i5) {
        int i6 = i5 ^ ((i5 >>> 20) ^ (i5 >>> 12));
        return (i6 >>> 4) ^ ((i6 >>> 7) ^ i6);
    }

    private static int nextPowerOfTwo(int i5) {
        return Integer.highestOneBit(i5) << 1;
    }

    private static int perturb(int i5) {
        return i5 & Integer.MAX_VALUE;
    }

    private static int probe(int i5, int i6) {
        return (i6 << 2) + i6 + i5 + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.count = 0;
    }

    private boolean shouldGrowTable() {
        return ((float) this.size) > ((float) (this.mask + 1)) * 0.5f;
    }

    public boolean containsKey(int i5) {
        int iHashOf = hashOf(i5);
        int i6 = this.mask & iHashOf;
        if (containsKey(i5, i6)) {
            return true;
        }
        if (this.states[i6] == 0) {
            return false;
        }
        int iPerturb = perturb(iHashOf);
        int iProbe = i6;
        while (this.states[i6] != 0) {
            iProbe = probe(iPerturb, iProbe);
            i6 = this.mask & iProbe;
            if (containsKey(i5, i6)) {
                return true;
            }
            iPerturb >>= 5;
        }
        return false;
    }

    public T get(int i5) {
        int iHashOf = hashOf(i5);
        int i6 = this.mask & iHashOf;
        if (containsKey(i5, i6)) {
            return this.values[i6];
        }
        if (this.states[i6] == 0) {
            return this.missingEntries;
        }
        int iPerturb = perturb(iHashOf);
        int iProbe = i6;
        while (this.states[i6] != 0) {
            iProbe = probe(iPerturb, iProbe);
            i6 = this.mask & iProbe;
            if (containsKey(i5, i6)) {
                return this.values[i6];
            }
            iPerturb >>= 5;
        }
        return this.missingEntries;
    }

    public OpenIntToFieldHashMap<T>.Iterator iterator() {
        return new Iterator();
    }

    public T put(int i5, T t6) {
        boolean z6;
        int iFindInsertionIndex = findInsertionIndex(i5);
        T t7 = this.missingEntries;
        if (iFindInsertionIndex < 0) {
            iFindInsertionIndex = changeIndexSign(iFindInsertionIndex);
            t7 = this.values[iFindInsertionIndex];
            z6 = false;
        } else {
            z6 = true;
        }
        this.keys[iFindInsertionIndex] = i5;
        this.states[iFindInsertionIndex] = 1;
        this.values[iFindInsertionIndex] = t6;
        if (z6) {
            this.size++;
            if (shouldGrowTable()) {
                growTable();
            }
            this.count++;
        }
        return t7;
    }

    public T remove(int i5) {
        int iHashOf = hashOf(i5);
        int i6 = this.mask & iHashOf;
        if (containsKey(i5, i6)) {
            return (T) doRemove(i6);
        }
        if (this.states[i6] == 0) {
            return this.missingEntries;
        }
        int iPerturb = perturb(iHashOf);
        int iProbe = i6;
        while (this.states[i6] != 0) {
            iProbe = probe(iPerturb, iProbe);
            i6 = this.mask & iProbe;
            if (containsKey(i5, i6)) {
                return (T) doRemove(i6);
            }
            iPerturb >>= 5;
        }
        return this.missingEntries;
    }

    public int size() {
        return this.size;
    }

    public OpenIntToFieldHashMap(Field<T> field, T t6) {
        this(field, 16, t6);
    }

    private static int findInsertionIndex(int[] iArr, byte[] bArr, int i5, int i6) {
        int iProbe;
        int i7;
        int iHashOf = hashOf(i5);
        int iProbe2 = iHashOf & i6;
        byte b = bArr[iProbe2];
        if (b == 0) {
            return iProbe2;
        }
        if (b == 1 && iArr[iProbe2] == i5) {
            return changeIndexSign(iProbe2);
        }
        int iPerturb = perturb(iHashOf);
        if (bArr[iProbe2] == 1) {
            do {
                iProbe2 = probe(iPerturb, iProbe2);
                i7 = iProbe2 & i6;
                iPerturb >>= 5;
                if (bArr[i7] != 1) {
                    break;
                }
            } while (iArr[i7] != i5);
            iProbe = iProbe2;
            iProbe2 = i7;
        } else {
            iProbe = iProbe2;
        }
        byte b6 = bArr[iProbe2];
        if (b6 != 0) {
            if (b6 == 1) {
                return changeIndexSign(iProbe2);
            }
            while (true) {
                iProbe = probe(iPerturb, iProbe);
                int i8 = iProbe & i6;
                byte b7 = bArr[i8];
                if (b7 == 0) {
                    break;
                }
                if (b7 == 1 && iArr[i8] == i5) {
                    return changeIndexSign(i8);
                }
                iPerturb >>= 5;
            }
        }
        return iProbe2;
    }

    public OpenIntToFieldHashMap(Field<T> field, int i5) {
        this(field, i5, field.getZero());
    }

    public OpenIntToFieldHashMap(Field<T> field, int i5, T t6) {
        this.field = field;
        int iComputeCapacity = computeCapacity(i5);
        this.keys = new int[iComputeCapacity];
        this.values = (T[]) buildArray(iComputeCapacity);
        this.states = new byte[iComputeCapacity];
        this.missingEntries = t6;
        this.mask = iComputeCapacity - 1;
    }

    private boolean containsKey(int i5, int i6) {
        return (i5 != 0 || this.states[i6] == 1) && this.keys[i6] == i5;
    }

    public OpenIntToFieldHashMap(OpenIntToFieldHashMap<T> openIntToFieldHashMap) {
        this.field = openIntToFieldHashMap.field;
        int length = openIntToFieldHashMap.keys.length;
        int[] iArr = new int[length];
        this.keys = iArr;
        System.arraycopy(openIntToFieldHashMap.keys, 0, iArr, 0, length);
        T[] tArr = (T[]) buildArray(length);
        this.values = tArr;
        System.arraycopy(openIntToFieldHashMap.values, 0, tArr, 0, length);
        byte[] bArr = new byte[length];
        this.states = bArr;
        System.arraycopy(openIntToFieldHashMap.states, 0, bArr, 0, length);
        this.missingEntries = openIntToFieldHashMap.missingEntries;
        this.size = openIntToFieldHashMap.size;
        this.mask = openIntToFieldHashMap.mask;
        this.count = openIntToFieldHashMap.count;
    }
}
