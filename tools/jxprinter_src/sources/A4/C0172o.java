package A4;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: renamed from: A4.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0172o {
    /* JADX INFO: renamed from: -deprecated_decodeBase64, reason: not valid java name */
    public final C0173p m119deprecated_decodeBase64(String string) {
        kotlin.jvm.internal.E.f(string, "string");
        return decodeBase64(string);
    }

    /* JADX INFO: renamed from: -deprecated_decodeHex, reason: not valid java name */
    public final C0173p m120deprecated_decodeHex(String string) {
        kotlin.jvm.internal.E.f(string, "string");
        return decodeHex(string);
    }

    /* JADX INFO: renamed from: -deprecated_encodeString, reason: not valid java name */
    public final C0173p m121deprecated_encodeString(String string, Charset charset) {
        kotlin.jvm.internal.E.f(string, "string");
        kotlin.jvm.internal.E.f(charset, "charset");
        return encodeString(string, charset);
    }

    /* JADX INFO: renamed from: -deprecated_encodeUtf8, reason: not valid java name */
    public final C0173p m122deprecated_encodeUtf8(String string) {
        kotlin.jvm.internal.E.f(string, "string");
        return encodeUtf8(string);
    }

    /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
    public final C0173p m123deprecated_of(ByteBuffer buffer) {
        kotlin.jvm.internal.E.f(buffer, "buffer");
        return of(buffer);
    }

    /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name */
    public final C0173p m125deprecated_read(InputStream inputstream, int i5) {
        kotlin.jvm.internal.E.f(inputstream, "inputstream");
        return read(inputstream, i5);
    }

    public final C0173p decodeBase64(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        byte[] bArrDecodeBase64ToArray = AbstractC0158a.decodeBase64ToArray(str);
        if (bArrDecodeBase64ToArray != null) {
            return new C0173p(bArrDecodeBase64ToArray);
        }
        return null;
    }

    public final C0173p decodeHex(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            bArr[i5] = (byte) (B4.b.b(str.charAt(i6 + 1)) + (B4.b.b(str.charAt(i6)) << 4));
        }
        return new C0173p(bArr);
    }

    public final C0173p encodeString(String str, Charset charset) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        kotlin.jvm.internal.E.e(bytes, "this as java.lang.String).getBytes(charset)");
        return new C0173p(bytes);
    }

    public final C0173p encodeUtf8(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        C0173p c0173p = new C0173p(n0.asUtf8ToByteArray(str));
        c0173p.setUtf8$okio(str);
        return c0173p;
    }

    public final C0173p of(ByteBuffer byteBuffer) {
        kotlin.jvm.internal.E.f(byteBuffer, "<this>");
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new C0173p(bArr);
    }

    public final C0173p read(InputStream inputStream, int i5) {
        kotlin.jvm.internal.E.f(inputStream, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "byteCount < 0: ").toString());
        }
        byte[] bArr = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            int i7 = inputStream.read(bArr, i6, i5 - i6);
            if (i7 == -1) {
                throw new EOFException();
            }
            i6 += i7;
        }
        return new C0173p(bArr);
    }

    /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
    public final C0173p m124deprecated_of(byte[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        return of(array, i5, i6);
    }

    public final C0173p of(byte... data) {
        kotlin.jvm.internal.E.f(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(this, size)");
        return new C0173p(bArrCopyOf);
    }

    public final C0173p of(byte[] bArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(bArr, i6);
        AbstractC0159b.a(bArr.length, i5, iResolveDefaultParameter);
        return new C0173p(AbstractC0151t.copyOfRange(bArr, i5, iResolveDefaultParameter + i5));
    }
}
