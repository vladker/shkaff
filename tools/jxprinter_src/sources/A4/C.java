package A4;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C {
    public final D hmacSha1(f0 sink, C0173p key) {
        kotlin.jvm.internal.E.f(sink, "sink");
        kotlin.jvm.internal.E.f(key, "key");
        return new D(sink, key, "HmacSHA1");
    }

    public final D hmacSha256(f0 sink, C0173p key) {
        kotlin.jvm.internal.E.f(sink, "sink");
        kotlin.jvm.internal.E.f(key, "key");
        return new D(sink, key, "HmacSHA256");
    }

    public final D hmacSha512(f0 sink, C0173p key) {
        kotlin.jvm.internal.E.f(sink, "sink");
        kotlin.jvm.internal.E.f(key, "key");
        return new D(sink, key, "HmacSHA512");
    }

    public final D md5(f0 sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return new D(sink, MessageDigestAlgorithms.MD5);
    }

    public final D sha1(f0 sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return new D(sink, MessageDigestAlgorithms.SHA_1);
    }

    public final D sha256(f0 sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return new D(sink, MessageDigestAlgorithms.SHA_256);
    }

    public final D sha512(f0 sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return new D(sink, MessageDigestAlgorithms.SHA_512);
    }
}
