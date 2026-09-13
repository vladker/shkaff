package okhttp3.internal.http2;

import A4.C0173p;
import java.util.Locale;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: renamed from: okhttp3.internal.http2.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1359c {
    public static final C0173p d = C0173p.encodeUtf8(ParameterizedMessage.ERROR_MSG_SEPARATOR);
    public static final C0173p e = C0173p.encodeUtf8(":status");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0173p f6600f = C0173p.encodeUtf8(":method");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0173p f6601g = C0173p.encodeUtf8(":path");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0173p f6602h = C0173p.encodeUtf8(":scheme");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0173p f6603i = C0173p.encodeUtf8(":authority");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0173p f6604a;
    public final C0173p b;
    public final int c;

    public C1359c(String str, String str2) {
        this(C0173p.encodeUtf8(str), C0173p.encodeUtf8(str2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1359c) {
            C1359c c1359c = (C1359c) obj;
            if (this.f6604a.equals(c1359c.f6604a) && this.b.equals(c1359c.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + ((this.f6604a.hashCode() + 527) * 31);
    }

    public final String toString() {
        String strUtf8 = this.f6604a.utf8();
        String strUtf9 = this.b.utf8();
        byte[] bArr = p107s4.d.f8235a;
        Locale locale = Locale.US;
        return androidx.collection.a.o(strUtf8, ": ", strUtf9);
    }

    public C1359c(String str, C0173p c0173p) {
        this(c0173p, C0173p.encodeUtf8(str));
    }

    public C1359c(C0173p c0173p, C0173p c0173p2) {
        this.f6604a = c0173p;
        this.b = c0173p2;
        this.c = c0173p2.size() + c0173p.size() + 32;
    }
}
