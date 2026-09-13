package org.apache.commons.math3.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OpenIntToDoubleHashMap implements Serializable {
    private static final int DEFAULT_EXPECTED_SIZE = 16;
    protected static final byte FREE = 0;
    protected static final byte FULL = 1;
    private static final float LOAD_FACTOR = 0.5f;
    private static final int PERTURB_SHIFT = 5;
    protected static final byte REMOVED = 2;
    private static final int RESIZE_MULTIPLIER = 2;
    private static final long serialVersionUID = -3646337053166149105L;
    private transient int count;
    private int[] keys;
    private int mask;
    private final double missingEntries;
    private int size;
    private byte[] states;
    private double[] values;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Iterator {
        private int current;
        private int next;
        private final int referenceCount;

        public void advance() {
            byte[] bArr;
            int i5;
            if (this.referenceCount != OpenIntToDoubleHashMap.this.count) {
                throw new ConcurrentModificationException();
            }
            this.current = this.next;
            do {
                try {
                    bArr = OpenIntToDoubleHashMap.this.states;
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
            if (this.referenceCount != OpenIntToDoubleHashMap.this.count) {
                throw new ConcurrentModificationException();
            }
            if (this.current >= 0) {
                return OpenIntToDoubleHashMap.this.keys[this.current];
            }
            throw new NoSuchElementException();
        }

        public double value() {
            if (this.referenceCount != OpenIntToDoubleHashMap.this.count) {
                throw new ConcurrentModificationException();
            }
            if (this.current >= 0) {
                return OpenIntToDoubleHashMap.this.values[this.current];
            }
            throw new NoSuchElementException();
        }

        private Iterator() {
            this.referenceCount = OpenIntToDoubleHashMap.this.count;
            this.next = -1;
            try {
                advance();
            } catch (NoSuchElementException unused) {
            }
        }
    }

    public OpenIntToDoubleHashMap() {
        this(16, Double.NaN);
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

    private double doRemove(int i5) {
        this.keys[i5] = 0;
        this.states[i5] = 2;
        double[] dArr = this.values;
        double d = dArr[i5];
        dArr[i5] = this.missingEntries;
        this.size--;
        this.count++;
        return d;
    }

    private int findInsertionIndex(int i5) {
        return findInsertionIndex(this.keys, this.states, i5, this.mask);
    }

    private void growTable() {
        byte[] bArr = this.states;
        int length = bArr.length;
        int[] iArr = this.keys;
        double[] dArr = this.values;
        int i5 = length * 2;
        int[] iArr2 = new int[i5];
        double[] dArr2 = new double[i5];
        byte[] bArr2 = new byte[i5];
        int i6 = i5 - 1;
        for (int i7 = 0; i7 < length; i7++) {
            if (bArr[i7] == 1) {
                int i8 = iArr[i7];
                int iFindInsertionIndex = findInsertionIndex(iArr2, bArr2, i8, i6);
                iArr2[iFindInsertionIndex] = i8;
                dArr2[iFindInsertionIndex] = dArr[i7];
                bArr2[iFindInsertionIndex] = 1;
            }
        }
        this.mask = i6;
        this.keys = iArr2;
        this.values = dArr2;
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

    public double get(int i5) {
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

    public Iterator iterator() {
        return new Iterator();
    }

    public double put(int i5, double d) {
        double d6;
        boolean z6;
        int iFindInsertionIndex = findInsertionIndex(i5);
        double d7 = this.missingEntries;
        if (iFindInsertionIndex < 0) {
            iFindInsertionIndex = changeIndexSign(iFindInsertionIndex);
            d6 = this.values[iFindInsertionIndex];
            z6 = false;
        } else {
            d6 = d7;
            z6 = true;
        }
        this.keys[iFindInsertionIndex] = i5;
        this.states[iFindInsertionIndex] = 1;
        this.values[iFindInsertionIndex] = d;
        if (z6) {
            this.size++;
            if (shouldGrowTable()) {
                growTable();
            }
            this.count++;
        }
        return d6;
    }

    public double remove(int i5) {
        int iHashOf = hashOf(i5);
        int i6 = this.mask & iHashOf;
        if (containsKey(i5, i6)) {
            return doRemove(i6);
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
                return doRemove(i6);
            }
            iPerturb >>= 5;
        }
        return this.missingEntries;
    }

    public int size() {
        return this.size;
    }

    public OpenIntToDoubleHashMap(double d) {
        this(16, d);
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

    public OpenIntToDoubleHashMap(int i5) {
        this(i5, Double.NaN);
    }

    public OpenIntToDoubleHashMap(int i5, double d) {
        int iComputeCapacity = computeCapacity(i5);
        this.keys = new int[iComputeCapacity];
        this.values = new double[iComputeCapacity];
        this.states = new byte[iComputeCapacity];
        this.missingEntries = d;
        this.mask = iComputeCapacity - 1;
    }

    private boolean containsKey(int i5, int i6) {
        return (i5 != 0 || this.states[i6] == 1) && this.keys[i6] == i5;
    }

    public OpenIntToDoubleHashMap(OpenIntToDoubleHashMap openIntToDoubleHashMap) {
        int length = openIntToDoubleHashMap.keys.length;
        int[] iArr = new int[length];
        this.keys = iArr;
        System.arraycopy(openIntToDoubleHashMap.keys, 0, iArr, 0, length);
        double[] dArr = new double[length];
        this.values = dArr;
        System.arraycopy(openIntToDoubleHashMap.values, 0, dArr, 0, length);
        byte[] bArr = new byte[length];
        this.states = bArr;
        System.arraycopy(openIntToDoubleHashMap.states, 0, bArr, 0, length);
        this.missingEntries = openIntToDoubleHashMap.missingEntries;
        this.size = openIntToDoubleHashMap.size;
        this.mask = openIntToDoubleHashMap.mask;
        this.count = openIntToDoubleHashMap.count;
    }
}
