package org.apache.commons.codec.digest;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MurmurHash3 {

    /* JADX INFO: renamed from: C1, reason: collision with root package name */
    private static final long f6683C1 = -8663945395140668459L;
    private static final int C1_32 = -862048943;

    /* JADX INFO: renamed from: C2, reason: collision with root package name */
    private static final long f6684C2 = 5545529020109919103L;
    private static final int C2_32 = 461845907;
    public static final int DEFAULT_SEED = 104729;
    static final int INTEGER_BYTES = 4;
    static final int LONG_BYTES = 8;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static final int f6685M = 5;
    private static final int M_32 = 5;

    /* JADX INFO: renamed from: N1, reason: collision with root package name */
    private static final int f6686N1 = 1390208809;

    /* JADX INFO: renamed from: N2, reason: collision with root package name */
    private static final int f6687N2 = 944331445;

    @Deprecated
    public static final long NULL_HASHCODE = 2862933555777941757L;
    private static final int N_32 = -430675100;

    /* JADX INFO: renamed from: R1, reason: collision with root package name */
    private static final int f6688R1 = 31;
    private static final int R1_32 = 15;

    /* JADX INFO: renamed from: R2, reason: collision with root package name */
    private static final int f6689R2 = 27;
    private static final int R2_32 = 13;

    /* JADX INFO: renamed from: R3, reason: collision with root package name */
    private static final int f6690R3 = 33;
    static final int SHORT_BYTES = 2;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Deprecated
    public static class IncrementalHash32 extends IncrementalHash32x86 {
        @Override // org.apache.commons.codec.digest.MurmurHash3.IncrementalHash32x86
        @Deprecated
        public int finalise(int i5, int i6, byte[] bArr, int i7) {
            int i8;
            int i9;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        i9 = bArr[2] << 16;
                    }
                    return MurmurHash3.fmix32(i5 ^ i7);
                }
                i9 = 0;
                i8 = i9 ^ (bArr[1] << 8);
            } else {
                i8 = 0;
            }
            i5 ^= Integer.rotateLeft((i8 ^ bArr[0]) * (-862048943), 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i5 ^ i7);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class IncrementalHash32x86 {
        private static final int BLOCK_SIZE = 4;
        private int hash;
        private int totalLen;
        private final byte[] unprocessed = new byte[3];
        private int unprocessedLength;

        private static int orBytes(byte b, byte b6, byte b7, byte b8) {
            return (b & UnsignedBytes.MAX_VALUE) | ((b6 & UnsignedBytes.MAX_VALUE) << 8) | ((b7 & UnsignedBytes.MAX_VALUE) << 16) | ((b8 & UnsignedBytes.MAX_VALUE) << 24);
        }

        public final void add(byte[] bArr, int i5, int i6) {
            int iOrBytes;
            if (i6 <= 0) {
                return;
            }
            this.totalLen += i6;
            int i7 = this.unprocessedLength;
            if ((i7 + i6) - 4 < 0) {
                System.arraycopy(bArr, i5, this.unprocessed, i7, i6);
                this.unprocessedLength += i6;
                return;
            }
            if (i7 > 0) {
                if (i7 == 1) {
                    iOrBytes = orBytes(this.unprocessed[0], bArr[i5], bArr[i5 + 1], bArr[i5 + 2]);
                } else if (i7 == 2) {
                    byte[] bArr2 = this.unprocessed;
                    iOrBytes = orBytes(bArr2[0], bArr2[1], bArr[i5], bArr[i5 + 1]);
                } else {
                    if (i7 != 3) {
                        throw new IllegalStateException("Unprocessed length should be 1, 2, or 3: " + this.unprocessedLength);
                    }
                    byte[] bArr3 = this.unprocessed;
                    iOrBytes = orBytes(bArr3[0], bArr3[1], bArr3[2], bArr[i5]);
                }
                this.hash = MurmurHash3.mix32(iOrBytes, this.hash);
                int i8 = 4 - this.unprocessedLength;
                i5 += i8;
                i6 -= i8;
            }
            int i9 = i6 >> 2;
            for (int i10 = 0; i10 < i9; i10++) {
                this.hash = MurmurHash3.mix32(MurmurHash3.getLittleEndianInt(bArr, (i10 << 2) + i5), this.hash);
            }
            int i11 = i9 << 2;
            int i12 = i6 - i11;
            this.unprocessedLength = i12;
            if (i12 != 0) {
                System.arraycopy(bArr, i5 + i11, this.unprocessed, 0, i12);
            }
        }

        public final int end() {
            return finalise(this.hash, this.unprocessedLength, this.unprocessed, this.totalLen);
        }

        public int finalise(int i5, int i6, byte[] bArr, int i7) {
            int i8;
            int i9;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        i9 = (bArr[2] & UnsignedBytes.MAX_VALUE) << 16;
                    }
                    return MurmurHash3.fmix32(i5 ^ i7);
                }
                i9 = 0;
                i8 = i9 ^ ((bArr[1] & UnsignedBytes.MAX_VALUE) << 8);
            } else {
                i8 = 0;
            }
            i5 ^= Integer.rotateLeft((i8 ^ (bArr[0] & UnsignedBytes.MAX_VALUE)) * (-862048943), 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i5 ^ i7);
        }

        public final void start(int i5) {
            this.totalLen = 0;
            this.unprocessedLength = 0;
            this.hash = i5;
        }
    }

    private MurmurHash3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int fmix32(int i5) {
        int i6 = (i5 ^ (i5 >>> 16)) * (-2048144789);
        int i7 = (i6 ^ (i6 >>> 13)) * (-1028477387);
        return i7 ^ (i7 >>> 16);
    }

    private static long fmix64(long j6) {
        long j7 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
        long j8 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
        return j8 ^ (j8 >>> 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLittleEndianInt(byte[] bArr, int i5) {
        return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i5] & UnsignedBytes.MAX_VALUE) | ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    private static long getLittleEndianLong(byte[] bArr, int i5) {
        return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
    }

    public static long[] hash128(byte[] bArr) {
        return hash128(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    public static long[] hash128x64(byte[] bArr) {
        return hash128x64(bArr, 0, bArr.length, 0);
    }

    private static long[] hash128x64Internal(byte[] bArr, int i5, int i6, long j6) {
        char c;
        char c6;
        int i7 = i6 >> 4;
        long jRotateLeft = j6;
        long jRotateLeft2 = jRotateLeft;
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = i5 + (i8 << 4);
            long littleEndianLong = getLittleEndianLong(bArr, i9);
            long littleEndianLong2 = getLittleEndianLong(bArr, i9 + 8);
            jRotateLeft = ((Long.rotateLeft(jRotateLeft ^ (Long.rotateLeft(littleEndianLong * f6683C1, 31) * f6684C2), 27) + jRotateLeft2) * 5) + 1390208809;
            jRotateLeft2 = ((Long.rotateLeft(jRotateLeft2 ^ (Long.rotateLeft(littleEndianLong2 * f6684C2, 33) * f6683C1), 31) + jRotateLeft) * 5) + 944331445;
        }
        int i10 = i5 + (i7 << 4);
        long j7 = 0;
        switch ((i5 + i6) - i10) {
            case 3:
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
            case 2:
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
            case 1:
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 4:
                c = 24;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 5:
                c = 24;
                c6 = Chars.SPACE;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 6:
                c = 24;
                c6 = Chars.SPACE;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 7:
                c = 24;
                c6 = Chars.SPACE;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 8:
                c = 24;
                c6 = Chars.SPACE;
                j7 = (((long) bArr[i10 + 7]) & 255) << 56;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 9:
                c = 24;
                c6 = Chars.SPACE;
                jRotateLeft2 ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10 + 8] & UnsignedBytes.MAX_VALUE))) * f6684C2, 33) * f6683C1;
                j7 = (((long) bArr[i10 + 7]) & 255) << 56;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 10:
                c = 24;
                c6 = Chars.SPACE;
                j7 ^= (((long) bArr[i10 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10 + 8] & UnsignedBytes.MAX_VALUE))) * f6684C2, 33) * f6683C1;
                j7 = (((long) bArr[i10 + 7]) & 255) << 56;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 11:
                c = 24;
                c6 = Chars.SPACE;
                j7 ^= (((long) bArr[i10 + 10]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10 + 8] & UnsignedBytes.MAX_VALUE))) * f6684C2, 33) * f6683C1;
                j7 = (((long) bArr[i10 + 7]) & 255) << 56;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 12:
                c = 24;
                c6 = Chars.SPACE;
                j7 ^= (((long) bArr[i10 + 11]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 10]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10 + 8] & UnsignedBytes.MAX_VALUE))) * f6684C2, 33) * f6683C1;
                j7 = (((long) bArr[i10 + 7]) & 255) << 56;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 13:
                c = 24;
                c6 = Chars.SPACE;
                j7 ^= (((long) bArr[i10 + 12]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 11]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 10]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10 + 8] & UnsignedBytes.MAX_VALUE))) * f6684C2, 33) * f6683C1;
                j7 = (((long) bArr[i10 + 7]) & 255) << 56;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 14:
                c = 24;
                c6 = Chars.SPACE;
                j7 ^= (((long) bArr[i10 + 13]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 12]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 11]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 10]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10 + 8] & UnsignedBytes.MAX_VALUE))) * f6684C2, 33) * f6683C1;
                j7 = (((long) bArr[i10 + 7]) & 255) << 56;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
            case 15:
                byte b = bArr[i10 + 14];
                c = 24;
                c6 = Chars.SPACE;
                j7 = (((long) b) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 13]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 12]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 11]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 10]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10 + 8] & UnsignedBytes.MAX_VALUE))) * f6684C2, 33) * f6683C1;
                j7 = (((long) bArr[i10 + 7]) & 255) << 56;
                j7 ^= (((long) bArr[i10 + 6]) & 255) << 48;
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << c6;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << c;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j7 ^ ((long) (bArr[i10] & UnsignedBytes.MAX_VALUE))) * f6683C1, 31) * f6684C2;
                break;
        }
        long j8 = i6;
        long j9 = jRotateLeft ^ j8;
        long j10 = j8 ^ jRotateLeft2;
        long j11 = j9 + j10;
        long j12 = j10 + j11;
        long jFmix64 = fmix64(j11);
        long jFmix65 = fmix64(j12);
        long j13 = jFmix64 + jFmix65;
        return new long[]{j13, jFmix65 + j13};
    }

    public static int hash32(long j6, long j7) {
        return hash32(j6, j7, DEFAULT_SEED);
    }

    public static int hash32x86(byte[] bArr) {
        return hash32x86(bArr, 0, bArr.length, 0);
    }

    @Deprecated
    public static long hash64(long j6) {
        return fmix64(((Long.rotateLeft((Long.rotateLeft(Long.reverseBytes(j6) * f6683C1, 31) * f6684C2) ^ 104729, 27) * 5) + 1390208809) ^ 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mix32(int i5, int i6) {
        return (Integer.rotateLeft((Integer.rotateLeft(i5 * (-862048943), 15) * C2_32) ^ i6, 13) * 5) + N_32;
    }

    @Deprecated
    public static long[] hash128(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash128(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    public static long[] hash128x64(byte[] bArr, int i5, int i6, int i7) {
        return hash128x64Internal(bArr, i5, i6, ((long) i7) & KeyboardMap.kValueMask);
    }

    public static int hash32(long j6, long j7, int i5) {
        long jReverseBytes = Long.reverseBytes(j6);
        long jReverseBytes2 = Long.reverseBytes(j7);
        int i6 = (int) jReverseBytes2;
        return fmix32(mix32((int) (jReverseBytes2 >>> 32), mix32(i6, mix32((int) (jReverseBytes >>> 32), mix32((int) jReverseBytes, i5)))) ^ 16);
    }

    public static int hash32x86(byte[] bArr, int i5, int i6, int i7) {
        int i8 = i6 >> 2;
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            i7 = mix32(getLittleEndianInt(bArr, (i10 << 2) + i5), i7);
        }
        int i11 = (i8 << 2) + i5;
        int i12 = (i5 + i6) - i11;
        if (i12 == 1) {
            i7 ^= Integer.rotateLeft(((bArr[i11] & UnsignedBytes.MAX_VALUE) ^ i9) * (-862048943), 15) * C2_32;
        } else {
            if (i12 != 2) {
                i9 = i12 == 3 ? (bArr[i11 + 2] & UnsignedBytes.MAX_VALUE) << 16 : 0;
            }
            i9 ^= (bArr[i11 + 1] & UnsignedBytes.MAX_VALUE) << 8;
            i7 ^= Integer.rotateLeft(((bArr[i11] & UnsignedBytes.MAX_VALUE) ^ i9) * (-862048943), 15) * C2_32;
        }
        return fmix32(i7 ^ i6);
    }

    @Deprecated
    public static long[] hash128(byte[] bArr, int i5, int i6, int i7) {
        return hash128x64Internal(bArr, i5, i6, i7);
    }

    @Deprecated
    public static long hash64(int i5) {
        return fmix64((Long.rotateLeft((((long) Integer.reverseBytes(i5)) & KeyboardMap.kValueMask) * f6683C1, 31) * f6684C2) ^ 104733);
    }

    @Deprecated
    public static long hash64(short s6) {
        return fmix64((Long.rotateLeft((((((long) s6) & 255) << 8) ^ (255 & ((long) ((s6 & 65280) >> 8)))) * f6683C1, 31) * f6684C2) ^ 104731);
    }

    public static int hash32(long j6) {
        return hash32(j6, DEFAULT_SEED);
    }

    public static int hash32(long j6, int i5) {
        long jReverseBytes = Long.reverseBytes(j6);
        return fmix32(mix32((int) (jReverseBytes >>> 32), mix32((int) jReverseBytes, i5)) ^ 8);
    }

    @Deprecated
    public static long hash64(byte[] bArr) {
        return hash64(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static long hash64(byte[] bArr, int i5, int i6) {
        return hash64(bArr, i5, i6, DEFAULT_SEED);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0042. Please report as an issue. */
    @Deprecated
    public static long hash64(byte[] bArr, int i5, int i6, int i7) {
        long j6;
        long jRotateLeft = i7;
        int i8 = i6 >> 3;
        int i9 = 0;
        while (true) {
            j6 = f6684C2;
            if (i9 >= i8) {
                break;
            }
            jRotateLeft = (Long.rotateLeft(jRotateLeft ^ (Long.rotateLeft(getLittleEndianLong(bArr, i5 + (i9 << 3)) * f6683C1, 31) * f6684C2), 27) * 5) + 1390208809;
            i9++;
        }
        int i10 = i5 + (i8 << 3);
        long j7 = 0;
        switch ((i5 + i6) - i10) {
            case 1:
                j6 = 5545529020109919103L;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i10]) & 255) ^ j7) * f6683C1, 31) * j6;
                break;
            case 2:
                j6 = 5545529020109919103L;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i10]) & 255) ^ j7) * f6683C1, 31) * j6;
                break;
            case 3:
                j6 = 5545529020109919103L;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i10]) & 255) ^ j7) * f6683C1, 31) * j6;
                break;
            case 4:
                j6 = 5545529020109919103L;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << 24;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i10]) & 255) ^ j7) * f6683C1, 31) * j6;
                break;
            case 5:
                j7 ^= (((long) bArr[i10 + 4]) & 255) << 32;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << 24;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i10]) & 255) ^ j7) * f6683C1, 31) * j6;
                break;
            case 7:
                j7 = (((long) bArr[i10 + 6]) & 255) << 48;
            case 6:
                j7 ^= (((long) bArr[i10 + 5]) & 255) << 40;
                j7 ^= (((long) bArr[i10 + 4]) & 255) << 32;
                j7 ^= (((long) bArr[i10 + 3]) & 255) << 24;
                j7 ^= (((long) bArr[i10 + 2]) & 255) << 16;
                j7 ^= (((long) bArr[i10 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i10]) & 255) ^ j7) * f6683C1, 31) * j6;
                break;
        }
        return fmix64(((long) i6) ^ jRotateLeft);
    }

    @Deprecated
    public static int hash32(byte[] bArr) {
        return hash32(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash32(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i5) {
        return hash32(bArr, i5, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i5, int i6) {
        return hash32(bArr, 0, i5, i6);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i5, int i6, int i7) {
        int i8 = i6 >> 2;
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            i7 = mix32(getLittleEndianInt(bArr, (i10 << 2) + i5), i7);
        }
        int i11 = (i8 << 2) + i5;
        int i12 = (i5 + i6) - i11;
        if (i12 != 1) {
            if (i12 != 2) {
                i9 = i12 == 3 ? bArr[i11 + 2] << 16 : 0;
            }
            i9 ^= bArr[i11 + 1] << 8;
            i7 ^= Integer.rotateLeft((bArr[i11] ^ i9) * (-862048943), 15) * C2_32;
        } else {
            i7 ^= Integer.rotateLeft((bArr[i11] ^ i9) * (-862048943), 15) * C2_32;
        }
        return fmix32(i7 ^ i6);
    }
}
