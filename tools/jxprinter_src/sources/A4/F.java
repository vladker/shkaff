package A4;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class F extends AbstractC0182z {
    public static final E Companion = new E();
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(h0 source, MessageDigest digest) {
        super(source);
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    public static final F hmacSha1(h0 h0Var, C0173p c0173p) {
        return Companion.hmacSha1(h0Var, c0173p);
    }

    public static final F hmacSha256(h0 h0Var, C0173p c0173p) {
        return Companion.hmacSha256(h0Var, c0173p);
    }

    public static final F hmacSha512(h0 h0Var, C0173p c0173p) {
        return Companion.hmacSha512(h0Var, c0173p);
    }

    public static final F md5(h0 h0Var) {
        return Companion.md5(h0Var);
    }

    public static final F sha1(h0 h0Var) {
        return Companion.sha1(h0Var);
    }

    public static final F sha256(h0 h0Var) {
        return Companion.sha256(h0Var);
    }

    public static final F sha512(h0 h0Var) {
        return Companion.sha512(h0Var);
    }

    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final C0173p m115deprecated_hash() {
        return hash();
    }

    public final C0173p hash() {
        byte[] result;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            kotlin.jvm.internal.E.c(mac);
            result = mac.doFinal();
        }
        kotlin.jvm.internal.E.e(result, "result");
        return new C0173p(result);
    }

    @Override // A4.AbstractC0182z, A4.h0
    public long read(C0169l sink, long j6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        long j7 = super.read(sink, j6);
        if (j7 != -1) {
            long size = sink.size() - j7;
            long size2 = sink.size();
            c0 c0Var = sink.head;
            kotlin.jvm.internal.E.c(c0Var);
            while (size2 > size) {
                c0Var = c0Var.prev;
                kotlin.jvm.internal.E.c(c0Var);
                size2 -= (long) (c0Var.limit - c0Var.pos);
            }
            while (size2 < sink.size()) {
                int i5 = (int) ((((long) c0Var.pos) + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(c0Var.data, i5, c0Var.limit - i5);
                } else {
                    Mac mac = this.mac;
                    kotlin.jvm.internal.E.c(mac);
                    mac.update(c0Var.data, i5, c0Var.limit - i5);
                }
                size2 += (long) (c0Var.limit - c0Var.pos);
                c0Var = c0Var.next;
                kotlin.jvm.internal.E.c(c0Var);
                size = size2;
            }
        }
        return j7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public F(h0 source, String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        kotlin.jvm.internal.E.e(messageDigest, "getInstance(algorithm)");
        this(source, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(h0 source, Mac mac) {
        super(source);
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public F(h0 source, C0173p key, String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            this(source, mac);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
