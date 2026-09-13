package androidx.collection;

import A3.AbstractC0151t;
import O3.p;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableLongFloatMap extends LongFloatMap {
    private int growthLimit;

    public MutableLongFloatMap() {
        this(0, 1, null);
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || Long.compareUnsigned(a.d(this._size, 32L), a.d(this._capacity, 25L)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    private final int findFirstAvailableSlot(int i5) {
        int i6 = this._capacity;
        int i7 = i5 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j6 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j7 = j6 & ((~j6) << 7) & (-9187201950435737472L);
            if (j7 != 0) {
                return (i7 + (Long.numberOfTrailingZeros(j7) >> 3)) & i6;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
        }
    }

    private final int findInsertIndex(long j6) {
        int iHashCode = Long.hashCode(j6) * ScatterMapKt.MurmurHashC1;
        int i5 = iHashCode ^ (iHashCode << 16);
        int i6 = i5 >>> 7;
        int i7 = i5 & 127;
        int i8 = this._capacity;
        int i9 = i6 & i8;
        int i10 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j7 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j8 = i7;
            int i13 = i10;
            long j9 = j7 ^ (j8 * ScatterMapKt.BitmaskLsb);
            for (long j10 = (~j9) & (j9 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i9) & i8;
                if (this.keys[iNumberOfTrailingZeros] == j6) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j7) << 6) & j7 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                }
                this._size++;
                int i14 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i15 = iFindFirstAvailableSlot >> 3;
                long j11 = jArr2[i15];
                int i16 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i14 - (((j11 >> i16) & 255) == 128 ? 1 : 0);
                jArr2[i15] = (j11 & (~(255 << i16))) | (j8 << i16);
                int i17 = this._capacity;
                int i18 = ((iFindFirstAvailableSlot - 7) & i17) + (i17 & 7);
                int i19 = i18 >> 3;
                int i20 = (i18 & 7) << 3;
                jArr2[i19] = ((~(255 << i20)) & jArr2[i19]) | (j8 << i20);
                return ~iFindFirstAvailableSlot;
            }
            i10 = i13 + 8;
            i9 = (i9 + i10) & i8;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    private final void initializeMetadata(int i5) {
        long[] jArr;
        if (i5 == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            int i6 = ((i5 + 15) & (-8)) >> 3;
            long[] jArr2 = new long[i6];
            AbstractC0151t.fill(jArr2, -9187201950435737472L, 0, i6);
            jArr = jArr2;
        }
        this.metadata = jArr;
        int i7 = i5 >> 3;
        long j6 = 255 << ((i5 & 7) << 3);
        jArr[i7] = (jArr[i7] & (~j6)) | j6;
        initializeGrowth();
    }

    private final void initializeStorage(int i5) {
        int iMax = i5 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i5)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.keys = new long[iMax];
        this.values = new float[iMax];
    }

    private final void removeDeletedMarkers() {
        long[] jArr = this.metadata;
        int i5 = this._capacity;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 >> 3;
            int i9 = (i7 & 7) << 3;
            if (((jArr[i8] >> i9) & 255) == 254) {
                long[] jArr2 = this.metadata;
                jArr2[i8] = (128 << i9) | (jArr2[i8] & (~(255 << i9)));
                int i10 = this._capacity;
                int i11 = ((i7 - 7) & i10) + (i10 & 7);
                int i12 = i11 >> 3;
                int i13 = (i11 & 7) << 3;
                jArr2[i12] = ((~(255 << i13)) & jArr2[i12]) | (128 << i13);
                i6++;
            }
        }
        this.growthLimit += i6;
    }

    private final void resizeStorage(int i5) {
        MutableLongFloatMap mutableLongFloatMap = this;
        long[] jArr = mutableLongFloatMap.metadata;
        long[] jArr2 = mutableLongFloatMap.keys;
        float[] fArr = mutableLongFloatMap.values;
        int i6 = mutableLongFloatMap._capacity;
        initializeStorage(i5);
        long[] jArr3 = mutableLongFloatMap.keys;
        float[] fArr2 = mutableLongFloatMap.values;
        int i7 = 0;
        while (i7 < i6) {
            if (((jArr[i7 >> 3] >> ((i7 & 7) << 3)) & 255) < 128) {
                long j6 = jArr2[i7];
                int iHashCode = Long.hashCode(j6) * ScatterMapKt.MurmurHashC1;
                int i8 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = mutableLongFloatMap.findFirstAvailableSlot(i8 >>> 7);
                long j7 = i8 & 127;
                long[] jArr4 = mutableLongFloatMap.metadata;
                int i9 = iFindFirstAvailableSlot >> 3;
                int i10 = (iFindFirstAvailableSlot & 7) << 3;
                jArr4[i9] = (jArr4[i9] & (~(255 << i10))) | (j7 << i10);
                int i11 = mutableLongFloatMap._capacity;
                int i12 = ((iFindFirstAvailableSlot - 7) & i11) + (i11 & 7);
                int i13 = i12 >> 3;
                int i14 = (i12 & 7) << 3;
                jArr4[i13] = (jArr4[i13] & (~(255 << i14))) | (j7 << i14);
                jArr3[iFindFirstAvailableSlot] = j6;
                fArr2[iFindFirstAvailableSlot] = fArr[i7];
            }
            i7++;
            mutableLongFloatMap = this;
            jArr = jArr;
        }
    }

    private final void writeMetadata(int i5, long j6) {
        long[] jArr = this.metadata;
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (jArr[i6] & (~(255 << i7))) | (j6 << i7);
        int i8 = this._capacity;
        int i9 = ((i5 - 7) & i8) + (i8 & 7);
        int i10 = i9 >> 3;
        int i11 = (i9 & 7) << 3;
        jArr[i10] = (j6 << i11) | (jArr[i10] & (~(255 << i11)));
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            AbstractC0151t.fill(jArr, -9187201950435737472L, 0, jArr.length);
            long[] jArr2 = this.metadata;
            int i5 = this._capacity;
            int i6 = i5 >> 3;
            long j6 = 255 << ((i5 & 7) << 3);
            jArr2[i6] = (jArr2[i6] & (~j6)) | j6;
        }
        initializeGrowth();
    }

    public final float getOrPut(long j6, O3.a defaultValue) {
        E.f(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(j6);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        float fFloatValue = ((Number) defaultValue.invoke()).floatValue();
        put(j6, fFloatValue);
        return fFloatValue;
    }

    public final void minusAssign(long j6) {
        remove(j6);
    }

    public final void plusAssign(LongFloatMap from) {
        E.f(from, "from");
        putAll(from);
    }

    public final void put(long j6, float f6) {
        set(j6, f6);
    }

    public final void putAll(LongFloatMap from) {
        E.f(from, "from");
        long[] jArr = from.keys;
        float[] fArr = from.values;
        long[] jArr2 = from.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        int i8 = (i5 << 3) + i7;
                        set(jArr[i8], fArr[i8]);
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final void remove(long j6) {
        int iFindKeyIndex = findKeyIndex(j6);
        if (iFindKeyIndex >= 0) {
            removeValueAt(iFindKeyIndex);
        }
    }

    public final void removeIf(p predicate) {
        E.f(predicate, "predicate");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (((Boolean) predicate.invoke(Long.valueOf(this.keys[i8]), Float.valueOf(this.values[i8]))).booleanValue()) {
                            removeValueAt(i8);
                        }
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final void removeValueAt(int i5) {
        this._size--;
        long[] jArr = this.metadata;
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (jArr[i6] & (~(255 << i7))) | (254 << i7);
        int i8 = this._capacity;
        int i9 = ((i5 - 7) & i8) + (i8 & 7);
        int i10 = i9 >> 3;
        int i11 = (i9 & 7) << 3;
        jArr[i10] = (jArr[i10] & (~(255 << i11))) | (254 << i11);
    }

    public final void set(long j6, float f6) {
        int iFindInsertIndex = findInsertIndex(j6);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        }
        this.keys[iFindInsertIndex] = j6;
        this.values[iFindInsertIndex] = f6;
    }

    public final int trim() {
        int i5 = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i5) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i5 - this._capacity;
    }

    public /* synthetic */ MutableLongFloatMap(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 6 : i5);
    }

    public final void minusAssign(long[] keys) {
        E.f(keys, "keys");
        for (long j6 : keys) {
            remove(j6);
        }
    }

    public final float put(long j6, float f6, float f7) {
        int iFindInsertIndex = findInsertIndex(j6);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        } else {
            f7 = this.values[iFindInsertIndex];
        }
        this.keys[iFindInsertIndex] = j6;
        this.values[iFindInsertIndex] = f6;
        return f7;
    }

    public MutableLongFloatMap(int i5) {
        super(null);
        if (i5 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i5));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(long j6, float f6) {
        int iFindKeyIndex = findKeyIndex(j6);
        if (iFindKeyIndex < 0 || this.values[iFindKeyIndex] != f6) {
            return false;
        }
        removeValueAt(iFindKeyIndex);
        return true;
    }

    public final void minusAssign(LongSet keys) {
        E.f(keys, "keys");
        long[] jArr = keys.elements;
        long[] jArr2 = keys.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        remove(jArr[(i5 << 3) + i7]);
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final void minusAssign(LongList keys) {
        E.f(keys, "keys");
        long[] jArr = keys.content;
        int i5 = keys._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(jArr[i6]);
        }
    }
}
