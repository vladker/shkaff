package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    static final HashFunction FINGERPRINT_2011 = new Fingerprint2011();

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    private static final long f3421K0 = -6505348102511208375L;

    /* JADX INFO: renamed from: K1, reason: collision with root package name */
    private static final long f3422K1 = -8261664234251669945L;

    /* JADX INFO: renamed from: K2, reason: collision with root package name */
    private static final long f3423K2 = -4288712594273399085L;

    /* JADX INFO: renamed from: K3, reason: collision with root package name */
    private static final long f3424K3 = -4132994306676758123L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i5, int i6) {
        long jHashLength33To64;
        if (i6 <= 32) {
            jHashLength33To64 = murmurHash64WithSeed(bArr, i5, i6, -1397348546323613475L);
        } else {
            jHashLength33To64 = i6 <= 64 ? hashLength33To64(bArr, i5, i6) : fullFingerprint(bArr, i5, i6);
        }
        long jLoad64 = f3421K0;
        long jLoad65 = i6 >= 8 ? LittleEndianByteArray.load64(bArr, i5) : -6505348102511208375L;
        if (i6 >= 9) {
            jLoad64 = LittleEndianByteArray.load64(bArr, (i5 + i6) - 8);
        }
        long jHash128to64 = hash128to64(jHashLength33To64 + jLoad64, jLoad65);
        return (jHash128to64 == 0 || jHash128to64 == 1) ? jHash128to64 - 2 : jHash128to64;
    }

    private static long fullFingerprint(byte[] bArr, int i5, int i6) {
        byte[] bArr2 = bArr;
        long jLoad64 = LittleEndianByteArray.load64(bArr, i5);
        int i7 = i5 + i6;
        long jLoad65 = LittleEndianByteArray.load64(bArr2, i7 - 16) ^ f3422K1;
        long jLoad66 = f3421K0 ^ LittleEndianByteArray.load64(bArr2, i7 - 56);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j6 = i6;
        weakHashLength32WithSeeds(bArr2, i7 - 64, j6, jLoad65, jArr);
        weakHashLength32WithSeeds(bArr2, i7 - 32, j6 * f3422K1, f3421K0, jArr2);
        long[] jArr3 = jArr2;
        long jShiftMix = (shiftMix(jArr[1]) * f3422K1) + jLoad66;
        long jRotateRight = Long.rotateRight(jLoad64 + jShiftMix, 39) * f3422K1;
        int i8 = (i6 - 1) & (-64);
        long jRotateRight2 = Long.rotateRight(jLoad65, 33) * f3422K1;
        long j7 = jRotateRight;
        long j8 = jShiftMix;
        int i9 = i5;
        while (true) {
            long jRotateRight3 = Long.rotateRight(j7 + jRotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr2, i9 + 16), 37) * f3422K1;
            long jRotateRight4 = Long.rotateRight(jRotateRight2 + jArr[1] + LittleEndianByteArray.load64(bArr2, i9 + 48), 42) * f3422K1;
            long j9 = jArr3[1] ^ jRotateRight3;
            long j10 = jRotateRight4 ^ jArr[0];
            long jRotateRight5 = Long.rotateRight(j8 ^ jArr3[0], 33);
            weakHashLength32WithSeeds(bArr2, i9, jArr[1] * f3422K1, jArr3[0] + j9, jArr);
            int i10 = i9;
            long[] jArr4 = jArr3;
            weakHashLength32WithSeeds(bArr, i10 + 32, jRotateRight5 + jArr3[1], j10, jArr4);
            i9 = i10 + 64;
            i8 -= 64;
            if (i8 == 0) {
                return hash128to64((shiftMix(j10) * f3422K1) + hash128to64(jArr[0], jArr4[0]) + j9, hash128to64(jArr[1], jArr4[1]) + jRotateRight5);
            }
            bArr2 = bArr;
            jArr3 = jArr4;
            j8 = j9;
            jRotateRight2 = j10;
            j7 = jRotateRight5;
        }
    }

    @VisibleForTesting
    public static long hash128to64(long j6, long j7) {
        long j8 = (j7 ^ j6) * f3424K3;
        long j9 = (j6 ^ (j8 ^ (j8 >>> 47))) * f3424K3;
        return (j9 ^ (j9 >>> 47)) * f3424K3;
    }

    private static long hashLength33To64(byte[] bArr, int i5, int i6) {
        long jLoad64 = LittleEndianByteArray.load64(bArr, i5 + 24);
        int i7 = i5 + i6;
        int i8 = i7 - 16;
        long jLoad65 = ((((long) i6) + LittleEndianByteArray.load64(bArr, i8)) * f3421K0) + LittleEndianByteArray.load64(bArr, i5);
        long jRotateRight = Long.rotateRight(jLoad65 + jLoad64, 52);
        long jRotateRight2 = Long.rotateRight(jLoad65, 37);
        long jLoad66 = jLoad65 + LittleEndianByteArray.load64(bArr, i5 + 8);
        long jRotateRight3 = Long.rotateRight(jLoad66, 7) + jRotateRight2;
        int i9 = i5 + 16;
        long jLoad67 = jLoad66 + LittleEndianByteArray.load64(bArr, i9);
        long j6 = jLoad64 + jLoad67;
        long jRotateRight4 = Long.rotateRight(jLoad67, 31) + jRotateRight + jRotateRight3;
        long jLoad68 = LittleEndianByteArray.load64(bArr, i9) + LittleEndianByteArray.load64(bArr, i7 - 32);
        long jLoad69 = LittleEndianByteArray.load64(bArr, i7 - 8);
        long jRotateRight5 = Long.rotateRight(jLoad68 + jLoad69, 52);
        long jRotateRight6 = Long.rotateRight(jLoad68, 37);
        long jLoad610 = jLoad68 + LittleEndianByteArray.load64(bArr, i7 - 24);
        long jRotateRight7 = Long.rotateRight(jLoad610, 7) + jRotateRight6;
        long jLoad611 = jLoad610 + LittleEndianByteArray.load64(bArr, i8);
        return shiftMix((shiftMix(((jLoad611 + jLoad69 + jRotateRight4) * f3421K0) + ((Long.rotateRight(jLoad611, 31) + jRotateRight5 + jRotateRight7 + j6) * f3423K2)) * f3421K0) + jRotateRight4) * f3423K2;
    }

    @VisibleForTesting
    public static long murmurHash64WithSeed(byte[] bArr, int i5, int i6, long j6) {
        int i7 = i6 & (-8);
        int i8 = i6 & 7;
        long jLoad64Safely = j6 ^ (((long) i6) * f3424K3);
        for (int i9 = 0; i9 < i7; i9 += 8) {
            jLoad64Safely = (jLoad64Safely ^ (shiftMix(LittleEndianByteArray.load64(bArr, i5 + i9) * f3424K3) * f3424K3)) * f3424K3;
        }
        if (i8 != 0) {
            jLoad64Safely = (LittleEndianByteArray.load64Safely(bArr, i5 + i7, i8) ^ jLoad64Safely) * f3424K3;
        }
        return shiftMix(shiftMix(jLoad64Safely) * f3424K3);
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
        long jRotateRight = Long.rotateRight(j9, 23) + Long.rotateRight(j7 + j8 + jLoad67, 51);
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
        return "Hashing.fingerprint2011()";
    }
}
