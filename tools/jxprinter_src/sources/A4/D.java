package A4;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class D extends AbstractC0181y {
    public static final C Companion = new C();
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(f0 sink, MessageDigest digest) {
        super(sink);
        kotlin.jvm.internal.E.f(sink, "sink");
        kotlin.jvm.internal.E.f(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    public static final D hmacSha1(f0 f0Var, C0173p c0173p) {
        return Companion.hmacSha1(f0Var, c0173p);
    }

    public static final D hmacSha256(f0 f0Var, C0173p c0173p) {
        return Companion.hmacSha256(f0Var, c0173p);
    }

    public static final D hmacSha512(f0 f0Var, C0173p c0173p) {
        return Companion.hmacSha512(f0Var, c0173p);
    }

    public static final D md5(f0 f0Var) {
        return Companion.md5(f0Var);
    }

    public static final D sha1(f0 f0Var) {
        return Companion.sha1(f0Var);
    }

    public static final D sha256(f0 f0Var) {
        return Companion.sha256(f0Var);
    }

    public static final D sha512(f0 f0Var) {
        return Companion.sha512(f0Var);
    }

    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final C0173p m114deprecated_hash() {
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

    @Override // A4.AbstractC0181y, A4.f0
    public void write(C0169l source, long j6) {
        kotlin.jvm.internal.E.f(source, "source");
        AbstractC0159b.a(source.size(), 0L, j6);
        c0 c0Var = source.head;
        kotlin.jvm.internal.E.c(c0Var);
        long j7 = 0;
        while (j7 < j6) {
            int iMin = (int) Math.min(j6 - j7, c0Var.limit - c0Var.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(c0Var.data, c0Var.pos, iMin);
            } else {
                Mac mac = this.mac;
                kotlin.jvm.internal.E.c(mac);
                mac.update(c0Var.data, c0Var.pos, iMin);
            }
            j7 += (long) iMin;
            c0Var = c0Var.next;
            kotlin.jvm.internal.E.c(c0Var);
        }
        super.write(source, j6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public D(f0 sink, String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.E.f(sink, "sink");
        kotlin.jvm.internal.E.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        kotlin.jvm.internal.E.e(messageDigest, "getInstance(algorithm)");
        this(sink, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(f0 sink, Mac mac) {
        super(sink);
        kotlin.jvm.internal.E.f(sink, "sink");
        kotlin.jvm.internal.E.f(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public D(f0 sink, C0173p key, String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.E.f(sink, "sink");
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            this(sink, mac);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
