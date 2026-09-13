package L3;

import W3.InterfaceC0233q;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z {
    private static final BufferedReader buffered(Reader reader, int i5) {
        E.f(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i5);
    }

    public static final long copyTo(Reader reader, Writer out, int i5) throws IOException {
        E.f(reader, "<this>");
        E.f(out, "out");
        char[] cArr = new char[i5];
        int i6 = reader.read(cArr);
        long j6 = 0;
        while (i6 >= 0) {
            out.write(cArr, 0, i6);
            j6 += (long) i6;
            i6 = reader.read(cArr);
        }
        return j6;
    }

    public static final void forEachLine(Reader reader, O3.l action) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(reader, "<this>");
        E.f(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<Object> it = lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            d.closeFinally(bufferedReader, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static final InterfaceC0233q lineSequence(BufferedReader bufferedReader) {
        E.f(bufferedReader, "<this>");
        return W3.z.constrainOnce(new v(bufferedReader));
    }

    public static final byte[] readBytes(URL url) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(url, "<this>");
        InputStream inputStreamOpenStream = url.openStream();
        try {
            E.c(inputStreamOpenStream);
            byte[] bytes = c.readBytes(inputStreamOpenStream);
            d.closeFinally(inputStreamOpenStream, null);
            return bytes;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d.closeFinally(inputStreamOpenStream, th);
                throw th2;
            }
        }
    }

    public static final List<String> readLines(Reader reader) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        forEachLine(reader, new p(arrayList, 1));
        return arrayList;
    }

    public static final String readText(Reader reader) throws IOException {
        E.f(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        copyTo(reader, stringWriter, 8192);
        String string = stringWriter.toString();
        E.e(string, "toString(...)");
        return string;
    }

    private static final StringReader reader(String str) {
        E.f(str, "<this>");
        return new StringReader(str);
    }

    public static final <T> T useLines(Reader reader, O3.l block) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(reader, "<this>");
        E.f(block, "block");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T t6 = (T) block.invoke(lineSequence(bufferedReader));
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                d.closeFinally(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    d.closeFinally(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    private static final BufferedWriter buffered(Writer writer, int i5) {
        E.f(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i5);
    }

    private static final String readText(URL url, Charset charset) {
        E.f(url, "<this>");
        E.f(charset, "charset");
        return new String(readBytes(url), charset);
    }
}
