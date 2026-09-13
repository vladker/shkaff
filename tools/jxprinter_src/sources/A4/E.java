package A4;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class E {
    public final F hmacSha1(h0 source, C0173p key) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(key, "key");
        return new F(source, key, "HmacSHA1");
    }

    public final F hmacSha256(h0 source, C0173p key) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(key, "key");
        return new F(source, key, "HmacSHA256");
    }

    public final F hmacSha512(h0 source, C0173p key) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(key, "key");
        return new F(source, key, "HmacSHA512");
    }

    public final F md5(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        return new F(source, MessageDigestAlgorithms.MD5);
    }

    public final F sha1(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        return new F(source, MessageDigestAlgorithms.SHA_1);
    }

    public final F sha256(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        return new F(source, MessageDigestAlgorithms.SHA_256);
    }

    public final F sha512(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        return new F(source, MessageDigestAlgorithms.SHA_512);
    }
}
