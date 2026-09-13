package com.google.common.hash;

import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@ParametricNullness T t6, Funnel<? super T> funnel, int i5, LockFreeBitArray lockFreeBitArray) {
            long jBitSize = lockFreeBitArray.bitSize();
            long jAsLong = Hashing.murmur3_128().hashObject(t6, funnel).asLong();
            int i6 = (int) jAsLong;
            int i7 = (int) (jAsLong >>> 32);
            for (int i8 = 1; i8 <= i5; i8++) {
                int i9 = (i8 * i7) + i6;
                if (i9 < 0) {
                    i9 = ~i9;
                }
                if (!lockFreeBitArray.get(((long) i9) % jBitSize)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@ParametricNullness T t6, Funnel<? super T> funnel, int i5, LockFreeBitArray lockFreeBitArray) {
            long jBitSize = lockFreeBitArray.bitSize();
            long jAsLong = Hashing.murmur3_128().hashObject(t6, funnel).asLong();
            int i6 = (int) jAsLong;
            int i7 = (int) (jAsLong >>> 32);
            boolean z6 = false;
            for (int i8 = 1; i8 <= i5; i8++) {
                int i9 = (i8 * i7) + i6;
                if (i9 < 0) {
                    i9 = ~i9;
                }
                z6 |= lockFreeBitArray.set(((long) i9) % jBitSize);
            }
            return z6;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@ParametricNullness T t6, Funnel<? super T> funnel, int i5, LockFreeBitArray lockFreeBitArray) {
            long jBitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t6, funnel).getBytesInternal();
            long jLowerEight = lowerEight(bytesInternal);
            long jUpperEight = upperEight(bytesInternal);
            for (int i6 = 0; i6 < i5; i6++) {
                if (!lockFreeBitArray.get((LocationRequestCompat.PASSIVE_INTERVAL & jLowerEight) % jBitSize)) {
                    return false;
                }
                jLowerEight += jUpperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@ParametricNullness T t6, Funnel<? super T> funnel, int i5, LockFreeBitArray lockFreeBitArray) {
            long jBitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t6, funnel).getBytesInternal();
            long jLowerEight = lowerEight(bytesInternal);
            long jUpperEight = upperEight(bytesInternal);
            boolean z6 = false;
            for (int i6 = 0; i6 < i5; i6++) {
                z6 |= lockFreeBitArray.set((LocationRequestCompat.PASSIVE_INTERVAL & jLowerEight) % jBitSize);
                jLowerEight += jUpperEight;
            }
            return z6;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        private final LongAddable bitCount;
        final AtomicLongArray data;

        public LockFreeBitArray(long j6) {
            Preconditions.checkArgument(j6 > 0, "data length is zero!");
            this.data = new AtomicLongArray(Ints.checkedCast(LongMath.divide(j6, 64L, RoundingMode.CEILING)));
            this.bitCount = LongAddables.create();
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i5 = 0; i5 < length; i5++) {
                jArr[i5] = atomicLongArray.get(i5);
            }
            return jArr;
        }

        public long bitCount() {
            return this.bitCount.sum();
        }

        public long bitSize() {
            return ((long) this.data.length()) * 64;
        }

        public LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        public int dataLength() {
            return this.data.length();
        }

        public boolean equals(Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) obj).data));
            }
            return false;
        }

        public boolean get(long j6) {
            return ((1 << ((int) j6)) & this.data.get((int) (j6 >>> 6))) != 0;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }

        public void putAll(LockFreeBitArray lockFreeBitArray) {
            Preconditions.checkArgument(this.data.length() == lockFreeBitArray.data.length(), "BitArrays must be of equal length (%s != %s)", this.data.length(), lockFreeBitArray.data.length());
            for (int i5 = 0; i5 < this.data.length(); i5++) {
                putData(i5, lockFreeBitArray.data.get(i5));
            }
        }

        public void putData(int i5, long j6) {
            while (true) {
                long j7 = this.data.get(i5);
                long j8 = j7 | j6;
                if (j7 == j8) {
                    return;
                }
                int i6 = i5;
                if (this.data.compareAndSet(i6, j7, j8)) {
                    this.bitCount.add(Long.bitCount(j8) - Long.bitCount(j7));
                    return;
                }
                i5 = i6;
            }
        }

        public boolean set(long j6) {
            long j7;
            long j8;
            if (get(j6)) {
                return false;
            }
            int i5 = (int) (j6 >>> 6);
            long j9 = 1 << ((int) j6);
            do {
                j7 = this.data.get(i5);
                j8 = j7 | j9;
                if (j7 == j8) {
                    return false;
                }
            } while (!this.data.compareAndSet(i5, j7, j8));
            this.bitCount.increment();
            return true;
        }

        public LockFreeBitArray(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(jArr);
            this.bitCount = LongAddables.create();
            long jBitCount = 0;
            for (long j6 : jArr) {
                jBitCount += (long) Long.bitCount(j6);
            }
            this.bitCount.add(jBitCount);
        }
    }
}
