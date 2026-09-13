package L3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    private static final BufferedInputStream buffered(InputStream inputStream, int i5) {
        E.f(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i5);
    }

    private static final BufferedReader bufferedReader(InputStream inputStream, Charset charset) {
        E.f(inputStream, "<this>");
        E.f(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    private static final BufferedWriter bufferedWriter(OutputStream outputStream, Charset charset) {
        E.f(outputStream, "<this>");
        E.f(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    private static final ByteArrayInputStream byteInputStream(String str, Charset charset) {
        E.f(str, "<this>");
        E.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        E.e(bytes, "getBytes(...)");
        return new ByteArrayInputStream(bytes);
    }

    public static final long copyTo(InputStream inputStream, OutputStream out, int i5) throws IOException {
        E.f(inputStream, "<this>");
        E.f(out, "out");
        byte[] bArr = new byte[i5];
        int i6 = inputStream.read(bArr);
        long j6 = 0;
        while (i6 >= 0) {
            out.write(bArr, 0, i6);
            j6 += (long) i6;
            i6 = inputStream.read(bArr);
        }
        return j6;
    }

    private static final ByteArrayInputStream inputStream(byte[] bArr) {
        E.f(bArr, "<this>");
        return new ByteArrayInputStream(bArr);
    }

    public static final A3.E iterator(BufferedInputStream bufferedInputStream) {
        E.f(bufferedInputStream, "<this>");
        return new b(bufferedInputStream);
    }

    public static final byte[] readBytes(InputStream inputStream, int i5) throws IOException {
        E.f(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i5, inputStream.available()));
        copyTo(inputStream, byteArrayOutputStream, 8192);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        E.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    private static final InputStreamReader reader(InputStream inputStream, Charset charset) {
        E.f(inputStream, "<this>");
        E.f(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    private static final OutputStreamWriter writer(OutputStream outputStream, Charset charset) {
        E.f(outputStream, "<this>");
        E.f(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    private static final BufferedOutputStream buffered(OutputStream outputStream, int i5) {
        E.f(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i5);
    }

    private static final ByteArrayInputStream inputStream(byte[] bArr, int i5, int i6) {
        E.f(bArr, "<this>");
        return new ByteArrayInputStream(bArr, i5, i6);
    }

    public static final byte[] readBytes(InputStream inputStream) throws IOException {
        E.f(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        copyTo(inputStream, byteArrayOutputStream, 8192);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        E.e(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
