package okhttp3;

import A4.C0169l;
import A4.C0173p;
import A4.InterfaceC0170m;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class E extends Q {
    public static final B e = B.a("multipart/mixed");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final B f6486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f6487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f6488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f6489i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0173p f6490a;
    public final B b;
    public final List c;
    public long d = -1;

    static {
        B.a("multipart/alternative");
        B.a("multipart/digest");
        B.a("multipart/parallel");
        f6486f = B.a(ShareTarget.ENCODING_TYPE_MULTIPART);
        f6487g = new byte[]{Ref3DPtg.sid, 32};
        f6488h = new byte[]{13, 10};
        f6489i = new byte[]{45, 45};
    }

    public E(C0173p c0173p, B b, ArrayList arrayList) {
        this.f6490a = c0173p;
        this.b = B.a(b + "; boundary=" + c0173p.utf8());
        this.c = p107s4.d.i(arrayList);
    }

    public static void a(String str, StringBuilder sb) {
        sb.append(Chars.DQUOTE);
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt != '\"') {
                sb.append(cCharAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append(Chars.DQUOTE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long writeOrCountBytes(InterfaceC0170m interfaceC0170m, boolean z6) throws EOFException {
        C0169l c0169l;
        InterfaceC0170m c0169l2;
        if (z6) {
            c0169l2 = new C0169l();
            c0169l = c0169l2;
        } else {
            c0169l = 0;
            c0169l2 = interfaceC0170m;
        }
        List list = this.c;
        int size = list.size();
        long j6 = 0;
        int i5 = 0;
        while (true) {
            C0173p c0173p = this.f6490a;
            byte[] bArr = f6489i;
            byte[] bArr2 = f6488h;
            if (i5 >= size) {
                c0169l2.write(bArr);
                c0169l2.write(c0173p);
                c0169l2.write(bArr);
                c0169l2.write(bArr2);
                if (!z6) {
                    return j6;
                }
                long size2 = c0169l.size() + j6;
                c0169l.a();
                return size2;
            }
            D d = (D) list.get(i5);
            C1376w c1376w = d.headers;
            Q q6 = d.f6485a;
            c0169l2.write(bArr);
            c0169l2.write(c0173p);
            c0169l2.write(bArr2);
            if (c1376w != null) {
                int iF = c1376w.f();
                for (int i6 = 0; i6 < iF; i6++) {
                    c0169l2.writeUtf8(c1376w.c(i6)).write(f6487g).writeUtf8(c1376w.g(i6)).write(bArr2);
                }
            }
            B bContentType = q6.contentType();
            if (bContentType != null) {
                c0169l2.writeUtf8("Content-Type: ").writeUtf8(bContentType.f6483a).write(bArr2);
            }
            long jContentLength = q6.contentLength();
            if (jContentLength != -1) {
                c0169l2.writeUtf8("Content-Length: ").writeDecimalLong(jContentLength).write(bArr2);
            } else if (z6) {
                c0169l.a();
                return -1L;
            }
            c0169l2.write(bArr2);
            if (z6) {
                j6 += jContentLength;
            } else {
                q6.writeTo(c0169l2);
            }
            c0169l2.write(bArr2);
            i5++;
        }
    }

    @Override // okhttp3.Q
    public long contentLength() throws EOFException {
        long j6 = this.d;
        if (j6 != -1) {
            return j6;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.d = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.Q
    public final B contentType() {
        return this.b;
    }

    @Override // okhttp3.Q
    public void writeTo(InterfaceC0170m interfaceC0170m) throws EOFException {
        writeOrCountBytes(interfaceC0170m, false);
    }
}
