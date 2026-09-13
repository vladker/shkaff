package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    private static final long f3418K0 = -4348849565147123417L;

    /* JADX INFO: renamed from: K1, reason: collision with root package name */
    private static final long f3419K1 = -5435081209227447693L;

    /* JADX INFO: renamed from: K2, reason: collision with root package name */
    private static final long f3420K2 = -7286425919675154353L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i5, int i6) {
        if (i6 <= 32) {
            return i6 <= 16 ? hashLength0to16(bArr, i5, i6) : hashLength17to32(bArr, i5, i6);
        }
        return i6 <= 64 ? hashLength33To64(bArr, i5, i6) : hashLength65Plus(bArr, i5, i6);
    }

    private static long hashLength0to16(byte[] bArr, int i5, int i6) {
        if (i6 >= 8) {
            long j6 = ((long) (i6 * 2)) + f3420K2;
            long jLoad64 = LittleEndianByteArray.load64(bArr, i5) + f3420K2;
            long jLoad65 = LittleEndianByteArray.load64(bArr, (i5 + i6) - 8);
            return hashLength16((Long.rotateRight(jLoad65, 37) * j6) + jLoad64, (Long.rotateRight(jLoad64, 25) + jLoad65) * j6, j6);
        }
        if (i6 >= 4) {
            return hashLength16(((long) i6) + ((((long) LittleEndianByteArray.load32(bArr, i5)) & KeyboardMap.kValueMask) << 3), ((long) LittleEndianByteArray.load32(bArr, (i5 + i6) - 4)) & KeyboardMap.kValueMask, ((long) (i6 * 2)) + f3420K2);
        }
        if (i6 <= 0) {
            return f3420K2;
        }
        return shiftMix((((long) ((bArr[i5] & UnsignedBytes.MAX_VALUE) + ((bArr[(i6 >> 1) + i5] & UnsignedBytes.MAX_VALUE) << 8))) * f3420K2) ^ (((long) (i6 + ((bArr[(i6 - 1) + i5] & 255) << 2))) * f3418K0)) * f3420K2;
    }

    private static long hashLength16(long j6, long j7, long j8) {
        long j9 = (j6 ^ j7) * j8;
        long j10 = ((j9 ^ (j9 >>> 47)) ^ j7) * j8;
        return (j10 ^ (j10 >>> 47)) * j8;
    }

    private static long hashLength17to32(byte[] bArr, int i5, int i6) {
        long j6 = ((long) (i6 * 2)) + f3420K2;
        long jLoad64 = LittleEndianByteArray.load64(bArr, i5) * f3419K1;
        long jLoad65 = LittleEndianByteArray.load64(bArr, i5 + 8);
        int i7 = i5 + i6;
        long jLoad66 = LittleEndianByteArray.load64(bArr, i7 - 8) * j6;
        return hashLength16(Long.rotateRight(jLoad66, 30) + Long.rotateRight(jLoad64 + jLoad65, 43) + (LittleEndianByteArray.load64(bArr, i7 - 16) * f3420K2), Long.rotateRight(jLoad65 + f3420K2, 18) + jLoad64 + jLoad66, j6);
    }

    private static long hashLength33To64(byte[] bArr, int i5, int i6) {
        long j6 = ((long) (i6 * 2)) + f3420K2;
        long jLoad64 = LittleEndianByteArray.load64(bArr, i5) * f3420K2;
        long jLoad65 = LittleEndianByteArray.load64(bArr, i5 + 8);
        int i7 = i5 + i6;
        long jLoad66 = LittleEndianByteArray.load64(bArr, i7 - 8) * j6;
        long jRotateRight = Long.rotateRight(jLoad66, 30) + Long.rotateRight(jLoad64 + jLoad65, 43) + (LittleEndianByteArray.load64(bArr, i7 - 16) * f3420K2);
        long jHashLength16 = hashLength16(jRotateRight, jLoad66 + Long.rotateRight(jLoad65 + f3420K2, 18) + jLoad64, j6);
        long jLoad67 = LittleEndianByteArray.load64(bArr, i5 + 16) * j6;
        long jLoad68 = LittleEndianByteArray.load64(bArr, i5 + 24);
        long jLoad69 = (jRotateRight + LittleEndianByteArray.load64(bArr, i7 - 32)) * j6;
        return hashLength16(Long.rotateRight(jLoad69, 30) + Long.rotateRight(jLoad67 + jLoad68, 43) + ((jHashLength16 + LittleEndianByteArray.load64(bArr, i7 - 24)) * j6), Long.rotateRight(jLoad68 + jLoad64, 18) + jLoad67 + jLoad69, j6);
    }

    private static long hashLength65Plus(byte[] bArr, int i5, int i6) {
        long j6 = 81;
        long j7 = f3419K1;
        long j8 = (j6 * f3419K1) + 113;
        long jShiftMix = shiftMix((j8 * f3420K2) + 113) * f3420K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        char c = 1;
        int i7 = i6 - 1;
        int i8 = ((i7 / 64) * 64) + i5;
        int i9 = i7 & 63;
        int i10 = i8 + i9;
        int i11 = i10 - 63;
        long j9 = j8;
        long jLoad64 = (j6 * f3420K2) + LittleEndianByteArray.load64(bArr, i5);
        int i12 = i5;
        while (true) {
            long j10 = j7;
            long jRotateRight = Long.rotateRight(jLoad64 + j9 + jArr[0] + LittleEndianByteArray.load64(bArr, i12 + 8), 37) * j10;
            long jRotateRight2 = Long.rotateRight(j9 + jArr[c] + LittleEndianByteArray.load64(bArr, i12 + 48), 42) * j10;
            long j11 = jRotateRight ^ jArr2[c];
            char c6 = c;
            long jLoad65 = jArr[0] + LittleEndianByteArray.load64(bArr, i12 + 40) + jRotateRight2;
            long jRotateRight3 = Long.rotateRight(jShiftMix + jArr2[0], 33) * j10;
            weakHashLength32WithSeeds(bArr, i12, jArr[c6] * j10, j11 + jArr2[0], jArr);
            int i13 = i12;
            long[] jArr3 = jArr;
            weakHashLength32WithSeeds(bArr, i13 + 32, jArr2[c6] + jRotateRight3, jLoad65 + LittleEndianByteArray.load64(bArr, i13 + 16), jArr2);
            i12 = i13 + 64;
            if (i12 == i8) {
                long j12 = ((j11 & 255) << c6) + j10;
                long j13 = jArr2[0] + ((long) i9);
                jArr2[0] = j13;
                long j14 = jArr3[0] + j13;
                jArr3[0] = j14;
                jArr2[0] = jArr2[0] + j14;
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jLoad65 + jArr3[0] + LittleEndianByteArray.load64(bArr, i10 - 55), 37) * j12;
                long jRotateRight5 = Long.rotateRight(jLoad65 + jArr3[c6] + LittleEndianByteArray.load64(bArr, i10 - 15), 42) * j12;
                long j15 = jRotateRight4 ^ (jArr2[c6] * 9);
                long jLoad66 = (jArr3[0] * 9) + LittleEndianByteArray.load64(bArr, i10 - 23) + jRotateRight5;
                long jRotateRight6 = Long.rotateRight(j11 + jArr2[0], 33) * j12;
                weakHashLength32WithSeeds(bArr, i11, jArr3[c6] * j12, jArr2[0] + j15, jArr3);
                weakHashLength32WithSeeds(bArr, i10 - 31, jArr2[c6] + jRotateRight6, LittleEndianByteArray.load64(bArr, i10 - 47) + jLoad66, jArr2);
                return hashLength16((shiftMix(jLoad66) * f3418K0) + hashLength16(jArr3[0], jArr2[0], j12) + j15, hashLength16(jArr3[c6], jArr2[c6], j12) + jRotateRight6, j12);
            }
            jLoad64 = jRotateRight3;
            j7 = j10;
            jShiftMix = j11;
            c = c6;
            j9 = jLoad65;
            jArr = jArr3;
        }
    }

    private static long shiftMix(long j6) {
        return j6 ^ (j6 >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i5, long j6, long j7, long[] jArr) {
        long jLoad64 = LittleEndianByteArray.load64(bArr, i5);
        long jLoad65 = LittleEndianByteArray.load64(bArr, i5 + 8);
        long jLoad66 = LittleEndianByteArray.load64(bArr, i5 + 16);
        long jLoad67 = LittleEndianByteArray.load64(bArr, i5 + 24);
        long j8 = j6 + jLoad64;
        long j9 = jLoad65 + j8 + jLoad66;
        long jRotateRight = Long.rotateRight(j9, 44) + Long.rotateRight(j7 + j8 + jLoad67, 21);
        jArr[0] = j9 + jLoad67;
        jArr[1] = jRotateRight + j8;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i5, int i6) {
        Preconditions.checkPositionIndexes(i5, i5 + i6, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i5, i6));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
