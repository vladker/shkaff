package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;
    private final int c;
    private final int d;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final long f3430k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private final long f3431k1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;
        private long b;
        private final int c;
        private final int d;
        private long finalM;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        private long f3432v0;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        private long f3433v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        private long f3434v2;

        /* JADX INFO: renamed from: v3, reason: collision with root package name */
        private long f3435v3;

        public SipHasher(int i5, int i6, long j6, long j7) {
            super(8);
            this.b = 0L;
            this.finalM = 0L;
            this.c = i5;
            this.d = i6;
            this.f3432v0 = 8317987319222330741L ^ j6;
            this.f3433v1 = 7237128888997146477L ^ j7;
            this.f3434v2 = 7816392313619706465L ^ j6;
            this.f3435v3 = 8387220255154660723L ^ j7;
        }

        private void processM(long j6) {
            this.f3435v3 ^= j6;
            sipRound(this.c);
            this.f3432v0 = j6 ^ this.f3432v0;
        }

        private void sipRound(int i5) {
            for (int i6 = 0; i6 < i5; i6++) {
                long j6 = this.f3432v0;
                long j7 = this.f3433v1;
                this.f3432v0 = j6 + j7;
                this.f3434v2 += this.f3435v3;
                this.f3433v1 = Long.rotateLeft(j7, 13);
                long jRotateLeft = Long.rotateLeft(this.f3435v3, 16);
                long j8 = this.f3433v1;
                long j9 = this.f3432v0;
                this.f3433v1 = j8 ^ j9;
                this.f3435v3 = jRotateLeft ^ this.f3434v2;
                long jRotateLeft2 = Long.rotateLeft(j9, 32);
                long j10 = this.f3434v2;
                long j11 = this.f3433v1;
                this.f3434v2 = j10 + j11;
                this.f3432v0 = jRotateLeft2 + this.f3435v3;
                this.f3433v1 = Long.rotateLeft(j11, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f3435v3, 21);
                long j12 = this.f3433v1;
                long j13 = this.f3434v2;
                this.f3433v1 = j12 ^ j13;
                this.f3435v3 = jRotateLeft3 ^ this.f3432v0;
                this.f3434v2 = Long.rotateLeft(j13, 32);
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j6 = this.finalM ^ (this.b << 56);
            this.finalM = j6;
            processM(j6);
            this.f3434v2 ^= 255;
            sipRound(this.d);
            return HashCode.fromLong(((this.f3432v0 ^ this.f3433v1) ^ this.f3434v2) ^ this.f3435v3);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            this.b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            this.b += (long) byteBuffer.remaining();
            int i5 = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i5;
                i5 += 8;
            }
        }
    }

    public SipHashFunction(int i5, int i6, long j6, long j7) {
        Preconditions.checkArgument(i5 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i5);
        Preconditions.checkArgument(i6 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i6);
        this.c = i5;
        this.d = i6;
        this.f3430k0 = j6;
        this.f3431k1 = j7;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            if (this.c == sipHashFunction.c && this.d == sipHashFunction.d && this.f3430k0 == sipHashFunction.f3430k0 && this.f3431k1 == sipHashFunction.f3431k1) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.c) ^ this.d)) ^ this.f3430k0) ^ this.f3431k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.c, this.d, this.f3430k0, this.f3431k1);
    }

    public String toString() {
        int i5 = this.c;
        int i6 = this.d;
        long j6 = this.f3430k0;
        long j7 = this.f3431k1;
        StringBuilder sb = new StringBuilder(81);
        sb.append("Hashing.sipHash");
        sb.append(i5);
        sb.append(i6);
        sb.append("(");
        sb.append(j6);
        sb.append(", ");
        sb.append(j7);
        sb.append(")");
        return sb.toString();
    }
}
