package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import io.flutter.embedding.android.KeyboardMap;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {

    /* JADX INFO: renamed from: C1, reason: collision with root package name */
    private static final int f3428C1 = -862048943;

    /* JADX INFO: renamed from: C2, reason: collision with root package name */
    private static final int f3429C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0, false);
    static final HashFunction MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
    static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED, true);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @CanIgnoreReturnValue
    public static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;
        private int h1;
        private int shift;
        private int length = 0;
        private boolean isDone = false;

        public Murmur3_32Hasher(int i5) {
            this.h1 = i5;
        }

        private void update(int i5, long j6) {
            long j7 = this.buffer;
            long j8 = j6 & KeyboardMap.kValueMask;
            int i6 = this.shift;
            long j9 = (j8 << i6) | j7;
            this.buffer = j9;
            int i7 = (i5 * 8) + i6;
            this.shift = i7;
            this.length += i5;
            if (i7 >= 32) {
                this.h1 = Murmur3_32HashFunction.mixH1(this.h1, Murmur3_32HashFunction.mixK1((int) j9));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int iMixK1 = this.h1 ^ Murmur3_32HashFunction.mixK1((int) this.buffer);
            this.h1 = iMixK1;
            return Murmur3_32HashFunction.fmix(iMixK1, this.length);
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte b) {
            update(1, b & UnsignedBytes.MAX_VALUE);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char c) {
            update(2, c);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int i5) {
            update(4, i5);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long j6) {
            update(4, (int) j6);
            update(4, j6 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return super.putString(charSequence, charset);
            }
            int length = charSequence.length();
            int i5 = 0;
            while (true) {
                int i6 = i5 + 4;
                if (i6 > length) {
                    break;
                }
                char cCharAt = charSequence.charAt(i5);
                char cCharAt2 = charSequence.charAt(i5 + 1);
                char cCharAt3 = charSequence.charAt(i5 + 2);
                char cCharAt4 = charSequence.charAt(i5 + 3);
                if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                    break;
                }
                update(4, (cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24));
                i5 = i6;
            }
            while (i5 < length) {
                char cCharAt5 = charSequence.charAt(i5);
                if (cCharAt5 < 128) {
                    update(1, cCharAt5);
                } else if (cCharAt5 < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(cCharAt5));
                } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(cCharAt5));
                } else {
                    int iCodePointAt = Character.codePointAt(charSequence, i5);
                    if (iCodePointAt == cCharAt5) {
                        putBytes(charSequence.subSequence(i5, length).toString().getBytes(charset));
                        return this;
                    }
                    i5++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(iCodePointAt));
                }
                i5++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] bArr, int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i5 + i6, bArr.length);
            int i7 = 0;
            while (true) {
                int i8 = i7 + 4;
                if (i8 > i6) {
                    break;
                }
                update(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i7 + i5));
                i7 = i8;
            }
            while (i7 < i6) {
                putByte(bArr[i5 + i7]);
                i7++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder byteOrderOrder = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(byteOrderOrder);
            return this;
        }
    }

    public Murmur3_32HashFunction(int i5, boolean z6) {
        this.seed = i5;
        this.supplementaryPlaneFix = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c) {
        return ((long) (c >>> '\f')) | 224 | ((long) ((((c >>> 6) & 63) | 128) << 8)) | ((long) (((c & '?') | 128) << 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c) {
        return ((long) (c >>> 6)) | 192 | ((long) (((c & '?') | 128) << 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i5) {
        return ((long) (i5 >>> 18)) | 240 | ((((long) ((i5 >>> 12) & 63)) | 128) << 8) | ((((long) ((i5 >>> 6) & 63)) | 128) << 16) | ((((long) (i5 & 63)) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode fmix(int i5, int i6) {
        int i7 = i5 ^ i6;
        int i8 = (i7 ^ (i7 >>> 16)) * (-2048144789);
        int i9 = (i8 ^ (i8 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i9 ^ (i9 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i5) {
        return Ints.fromBytes(bArr[i5 + 3], bArr[i5 + 2], bArr[i5 + 1], bArr[i5]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixH1(int i5, int i6) {
        return (Integer.rotateLeft(i5 ^ i6, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixK1(int i5) {
        return Integer.rotateLeft(i5 * (-862048943), 15) * f3429C2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Murmur3_32HashFunction) {
            Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction) obj;
            if (this.seed == murmur3_32HashFunction.seed && this.supplementaryPlaneFix == murmur3_32HashFunction.supplementaryPlaneFix) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i5, int i6) {
        Preconditions.checkPositionIndexes(i5, i5 + i6, bArr.length);
        int iMixH1 = this.seed;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i8 + 4;
            if (i9 > i6) {
                break;
            }
            iMixH1 = mixH1(iMixH1, mixK1(getIntLittleEndian(bArr, i8 + i5)));
            i8 = i9;
        }
        int i10 = i8;
        int i11 = 0;
        while (i10 < i6) {
            i7 ^= UnsignedBytes.toInt(bArr[i5 + i10]) << i11;
            i10++;
            i11 += 8;
        }
        return fmix(mixK1(i7) ^ iMixH1, i6);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int i5) {
        return fmix(mixH1(this.seed, mixK1(i5)), 4);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long j6) {
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j6)), mixK1((int) (j6 >>> 32))), 8);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int iMixH1 = this.seed;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = i6 + 4;
            if (i8 > length) {
                break;
            }
            char cCharAt = charSequence.charAt(i6);
            char cCharAt2 = charSequence.charAt(i6 + 1);
            char cCharAt3 = charSequence.charAt(i6 + 2);
            char cCharAt4 = charSequence.charAt(i6 + 3);
            if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                break;
            }
            iMixH1 = mixH1(iMixH1, mixK1((cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24)));
            i7 += 4;
            i6 = i8;
        }
        long jCharToThreeUtf8Bytes = 0;
        while (i6 < length) {
            char cCharAt5 = charSequence.charAt(i6);
            if (cCharAt5 < 128) {
                jCharToThreeUtf8Bytes |= ((long) cCharAt5) << i5;
                i5 += 8;
                i7++;
            } else if (cCharAt5 < 2048) {
                jCharToThreeUtf8Bytes |= charToTwoUtf8Bytes(cCharAt5) << i5;
                i5 += 16;
                i7 += 2;
            } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                jCharToThreeUtf8Bytes |= charToThreeUtf8Bytes(cCharAt5) << i5;
                i5 += 24;
                i7 += 3;
            } else {
                int iCodePointAt = Character.codePointAt(charSequence, i6);
                if (iCodePointAt == cCharAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i6++;
                jCharToThreeUtf8Bytes |= codePointToFourUtf8Bytes(iCodePointAt) << i5;
                if (this.supplementaryPlaneFix) {
                    i5 += 32;
                }
                i7 += 4;
            }
            if (i5 >= 32) {
                iMixH1 = mixH1(iMixH1, mixK1((int) jCharToThreeUtf8Bytes));
                jCharToThreeUtf8Bytes >>>= 32;
                i5 -= 32;
            }
            i6++;
        }
        return fmix(mixK1((int) jCharToThreeUtf8Bytes) ^ iMixH1, i7);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int iMixK1 = this.seed;
        for (int i5 = 1; i5 < charSequence.length(); i5 += 2) {
            iMixK1 = mixH1(iMixK1, mixK1(charSequence.charAt(i5 - 1) | (charSequence.charAt(i5) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            iMixK1 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(iMixK1, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        int i5 = this.seed;
        StringBuilder sb = new StringBuilder(31);
        sb.append("Hashing.murmur3_32(");
        sb.append(i5);
        sb.append(")");
        return sb.toString();
    }
}
