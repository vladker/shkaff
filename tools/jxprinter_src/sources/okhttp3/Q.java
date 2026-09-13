package okhttp3;

import A4.C0173p;
import A4.InterfaceC0170m;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Q {
    public static Q create(B b, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (b != null) {
            Charset charset2 = b.charset();
            if (charset2 == null) {
                b = B.parse(b + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(b, str.getBytes(charset));
    }

    public long contentLength() {
        return -1L;
    }

    public abstract B contentType();

    public abstract void writeTo(InterfaceC0170m interfaceC0170m);

    public static Q create(B b, C0173p c0173p) {
        return new N(b, c0173p);
    }

    public static Q create(B b, byte[] bArr) {
        return create(b, bArr, 0, bArr.length);
    }

    public static Q create(B b, byte[] bArr, int i5, int i6) {
        if (bArr != null) {
            long length = bArr.length;
            long j6 = i5;
            long j7 = i6;
            byte[] bArr2 = p107s4.d.f8235a;
            if ((j6 | j7) >= 0 && j6 <= length && length - j6 >= j7) {
                return new O(b, bArr, i6, i5);
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new NullPointerException("content == null");
    }

    public static Q create(B b, File file) {
        if (file != null) {
            return new P(b, file);
        }
        throw new NullPointerException("file == null");
    }
}
