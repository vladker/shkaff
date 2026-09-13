package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Murmur3_128Hasher extends AbstractStreamingHasher {

        /* JADX INFO: renamed from: C1, reason: collision with root package name */
        private static final long f3425C1 = -8663945395140668459L;

        /* JADX INFO: renamed from: C2, reason: collision with root package name */
        private static final long f3426C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;
        private long h1;

        /* JADX INFO: renamed from: h2, reason: collision with root package name */
        private long f3427h2;
        private int length;

        public Murmur3_128Hasher(int i5) {
            super(16);
            long j6 = i5;
            this.h1 = j6;
            this.f3427h2 = j6;
            this.length = 0;
        }

        private void bmix64(long j6, long j7) {
            long jMixK1 = mixK1(j6) ^ this.h1;
            this.h1 = jMixK1;
            long jRotateLeft = Long.rotateLeft(jMixK1, 27);
            long j8 = this.f3427h2;
            this.h1 = ((jRotateLeft + j8) * 5) + 1390208809;
            long jMixK2 = mixK2(j7) ^ j8;
            this.f3427h2 = jMixK2;
            this.f3427h2 = ((Long.rotateLeft(jMixK2, 31) + this.h1) * 5) + 944331445;
        }

        private static long fmix64(long j6) {
            long j7 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
            long j8 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
            return j8 ^ (j8 >>> 33);
        }

        private static long mixK1(long j6) {
            return Long.rotateLeft(j6 * f3425C1, 31) * f3426C2;
        }

        private static long mixK2(long j6) {
            return Long.rotateLeft(j6 * f3426C2, 33) * f3425C1;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j6 = this.h1;
            int i5 = this.length;
            long j7 = j6 ^ ((long) i5);
            long j8 = this.f3427h2 ^ ((long) i5);
            long j9 = j7 + j8;
            this.h1 = j9;
            this.f3427h2 = j8 + j9;
            this.h1 = fmix64(j9);
            long jFmix64 = fmix64(this.f3427h2);
            long j10 = this.h1 + jFmix64;
            this.h1 = j10;
            this.f3427h2 = jFmix64 + j10;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.h1).putLong(this.f3427h2).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            this.length = byteBuffer.remaining() + this.length;
            long j13 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j6 = 0;
                    j12 = j6 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 2:
                    j7 = 0;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j12 = j6 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 3:
                    j8 = 0;
                    j7 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j8;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j12 = j6 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 4:
                    j9 = 0;
                    j8 = j9 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j7 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j8;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j12 = j6 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 5:
                    j10 = 0;
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j8 = j9 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j7 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j8;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j12 = j6 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 6:
                    j11 = 0;
                    j10 = (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40) ^ j11;
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j8 = j9 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j7 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j8;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j12 = j6 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 7:
                    j11 = ((long) UnsignedBytes.toInt(byteBuffer.get(6))) << 48;
                    j10 = (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40) ^ j11;
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j8 = j9 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j7 = (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16) ^ j8;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j12 = j6 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(0)));
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 8:
                    j12 = byteBuffer.getLong();
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 9:
                    j13 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 10:
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j13 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 11:
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j13 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 12:
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j13 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 13:
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j13 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 14:
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j13 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                case 15:
                    j13 = ((long) UnsignedBytes.toInt(byteBuffer.get(14))) << 48;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16;
                    j13 ^= ((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8;
                    j13 ^= (long) UnsignedBytes.toInt(byteBuffer.get(8));
                    j12 = byteBuffer.getLong();
                    this.h1 = mixK1(j12) ^ this.h1;
                    this.f3427h2 ^= mixK2(j13);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    public Murmur3_128HashFunction(int i5) {
        this.seed = i5;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        int i5 = this.seed;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Hashing.murmur3_128(");
        sb.append(i5);
        sb.append(")");
        return sb.toString();
    }
}
