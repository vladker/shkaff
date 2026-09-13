package M3;

import L3.z;
import W3.InterfaceC0233q;
import W3.L;
import X3.C0241g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q {
    private static final void appendBytes(Path path, byte[] array) throws IOException {
        E.f(path, "<this>");
        E.f(array, "array");
        Files.write(path, array, StandardOpenOption.APPEND);
    }

    private static final Path appendLines(Path path, Iterable<? extends CharSequence> lines, Charset charset) throws IOException {
        E.f(path, "<this>");
        E.f(lines, "lines");
        E.f(charset, "charset");
        Path pathWrite = Files.write(path, lines, charset, StandardOpenOption.APPEND);
        E.e(pathWrite, "write(...)");
        return pathWrite;
    }

    public static /* synthetic */ Path appendLines$default(Path path, Iterable lines, Charset charset, int i5, Object obj) throws IOException {
        if ((i5 & 2) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(lines, "lines");
        E.f(charset, "charset");
        Path pathWrite = Files.write(path, lines, charset, StandardOpenOption.APPEND);
        E.e(pathWrite, "write(...)");
        return pathWrite;
    }

    public static final void appendText(Path path, CharSequence text, Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(path, "<this>");
        E.f(text, "text");
        E.f(charset, "charset");
        writeText(path, text, charset, StandardOpenOption.APPEND);
    }

    public static /* synthetic */ void appendText$default(Path path, CharSequence charSequence, Charset charset, int i5, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i5 & 2) != 0) {
            charset = C0241g.UTF_8;
        }
        appendText(path, charSequence, charset);
    }

    private static final BufferedReader bufferedReader(Path path, Charset charset, int i5, OpenOption... options) {
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i5);
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(Path path, Charset charset, int i5, OpenOption[] options, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = C0241g.UTF_8;
        }
        if ((i6 & 2) != 0) {
            i5 = 8192;
        }
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i5);
    }

    private static final BufferedWriter bufferedWriter(Path path, Charset charset, int i5, OpenOption... options) {
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i5);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(Path path, Charset charset, int i5, OpenOption[] options, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charset = C0241g.UTF_8;
        }
        if ((i6 & 2) != 0) {
            i5 = 8192;
        }
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i5);
    }

    private static final void forEachLine(Path path, Charset charset, O3.l action) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(action, "action");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        E.e(bufferedReaderNewBufferedReader, "newBufferedReader(...)");
        try {
            Iterator<Object> it = z.lineSequence(bufferedReaderNewBufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                L3.d.closeFinally(bufferedReaderNewBufferedReader, null);
            } else {
                bufferedReaderNewBufferedReader.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    L3.d.closeFinally(bufferedReaderNewBufferedReader, th);
                } else {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    public static /* synthetic */ void forEachLine$default(Path path, Charset charset, O3.l action, int i5, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i5 & 1) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(action, "action");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        E.e(bufferedReaderNewBufferedReader, "newBufferedReader(...)");
        try {
            Iterator<Object> it = z.lineSequence(bufferedReaderNewBufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                L3.d.closeFinally(bufferedReaderNewBufferedReader, null);
            } else {
                bufferedReaderNewBufferedReader.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    L3.d.closeFinally(bufferedReaderNewBufferedReader, th);
                } else {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    private static final InputStream inputStream(Path path, OpenOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        E.e(inputStreamNewInputStream, "newInputStream(...)");
        return inputStreamNewInputStream;
    }

    private static final OutputStream outputStream(Path path, OpenOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        E.e(outputStreamNewOutputStream, "newOutputStream(...)");
        return outputStreamNewOutputStream;
    }

    private static final byte[] readBytes(Path path) throws IOException {
        E.f(path, "<this>");
        byte[] allBytes = Files.readAllBytes(path);
        E.e(allBytes, "readAllBytes(...)");
        return allBytes;
    }

    private static final List<String> readLines(Path path, Charset charset) throws IOException {
        E.f(path, "<this>");
        E.f(charset, "charset");
        List<String> allLines = Files.readAllLines(path, charset);
        E.e(allLines, "readAllLines(...)");
        return allLines;
    }

    public static /* synthetic */ List readLines$default(Path path, Charset charset, int i5, Object obj) throws IOException {
        if ((i5 & 1) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(charset, "charset");
        List<String> allLines = Files.readAllLines(path, charset);
        E.e(allLines, "readAllLines(...)");
        return allLines;
    }

    public static final String readText(Path path, Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(path, "<this>");
        E.f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String text = z.readText(inputStreamReader);
            L3.d.closeFinally(inputStreamReader, null);
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                L3.d.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ String readText$default(Path path, Charset charset, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charset = C0241g.UTF_8;
        }
        return readText(path, charset);
    }

    private static final InputStreamReader reader(Path path, Charset charset, OpenOption... options) {
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(options, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    public static /* synthetic */ InputStreamReader reader$default(Path path, Charset charset, OpenOption[] options, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(options, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    private static final <T> T useLines(Path path, Charset charset, O3.l block) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(block, "block");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        try {
            E.c(bufferedReaderNewBufferedReader);
            T t6 = (T) block.invoke(z.lineSequence(bufferedReaderNewBufferedReader));
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                L3.d.closeFinally(bufferedReaderNewBufferedReader, null);
            } else if (bufferedReaderNewBufferedReader != null) {
                bufferedReaderNewBufferedReader.close();
            }
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    L3.d.closeFinally(bufferedReaderNewBufferedReader, th);
                } else if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    public static /* synthetic */ Object useLines$default(Path path, Charset charset, O3.l block, int i5, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i5 & 1) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(block, "block");
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(path, charset);
        try {
            E.c(bufferedReaderNewBufferedReader);
            Object objInvoke = block.invoke(z.lineSequence(bufferedReaderNewBufferedReader));
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                L3.d.closeFinally(bufferedReaderNewBufferedReader, null);
            } else if (bufferedReaderNewBufferedReader != null) {
                bufferedReaderNewBufferedReader.close();
            }
            return objInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    L3.d.closeFinally(bufferedReaderNewBufferedReader, th);
                } else if (bufferedReaderNewBufferedReader != null) {
                    try {
                        bufferedReaderNewBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    private static final void writeBytes(Path path, byte[] array, OpenOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(array, "array");
        E.f(options, "options");
        Files.write(path, array, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    private static final Path writeLines(Path path, Iterable<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(lines, "lines");
        E.f(charset, "charset");
        E.f(options, "options");
        Path pathWrite = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        E.e(pathWrite, "write(...)");
        return pathWrite;
    }

    public static /* synthetic */ Path writeLines$default(Path path, Iterable lines, Charset charset, OpenOption[] options, int i5, Object obj) throws IOException {
        if ((i5 & 2) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(lines, "lines");
        E.f(charset, "charset");
        E.f(options, "options");
        Path pathWrite = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        E.e(pathWrite, "write(...)");
        return pathWrite;
    }

    public static final void writeText(Path path, CharSequence text, Charset charset, OpenOption... options) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(path, "<this>");
        E.f(text, "text");
        E.f(charset, "charset");
        E.f(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        try {
            if (text instanceof String) {
                E.c(outputStreamNewOutputStream);
                L3.q.writeTextImpl(outputStreamNewOutputStream, (String) text, charset);
            } else {
                CharsetEncoder charsetEncoderNewReplaceEncoder = L3.q.newReplaceEncoder(charset);
                CharBuffer charBufferAsReadOnlyBuffer = text instanceof CharBuffer ? ((CharBuffer) text).asReadOnlyBuffer() : CharBuffer.wrap(text);
                int iMin = Math.min(text.length(), 8192);
                E.c(charsetEncoderNewReplaceEncoder);
                ByteBuffer byteBufferByteBufferForEncoding = L3.q.byteBufferForEncoding(iMin, charsetEncoderNewReplaceEncoder);
                while (charBufferAsReadOnlyBuffer.hasRemaining()) {
                    if (charsetEncoderNewReplaceEncoder.encode(charBufferAsReadOnlyBuffer, byteBufferByteBufferForEncoding, true).isError()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    outputStreamNewOutputStream.write(byteBufferByteBufferForEncoding.array(), 0, byteBufferByteBufferForEncoding.position());
                    byteBufferByteBufferForEncoding.clear();
                }
            }
            L3.d.closeFinally(outputStreamNewOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                L3.d.closeFinally(outputStreamNewOutputStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void writeText$default(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i5, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i5 & 2) != 0) {
            charset = C0241g.UTF_8;
        }
        writeText(path, charSequence, charset, openOptionArr);
    }

    private static final OutputStreamWriter writer(Path path, Charset charset, OpenOption... options) {
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(options, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    public static /* synthetic */ OutputStreamWriter writer$default(Path path, Charset charset, OpenOption[] options, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(charset, "charset");
        E.f(options, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    private static final Path appendLines(Path path, InterfaceC0233q lines, Charset charset) throws IOException {
        E.f(path, "<this>");
        E.f(lines, "lines");
        E.f(charset, "charset");
        Path pathWrite = Files.write(path, L.asIterable(lines), charset, StandardOpenOption.APPEND);
        E.e(pathWrite, "write(...)");
        return pathWrite;
    }

    private static final Path writeLines(Path path, InterfaceC0233q lines, Charset charset, OpenOption... options) throws IOException {
        E.f(path, "<this>");
        E.f(lines, "lines");
        E.f(charset, "charset");
        E.f(options, "options");
        Path pathWrite = Files.write(path, L.asIterable(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        E.e(pathWrite, "write(...)");
        return pathWrite;
    }

    public static /* synthetic */ Path appendLines$default(Path path, InterfaceC0233q lines, Charset charset, int i5, Object obj) throws IOException {
        if ((i5 & 2) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(lines, "lines");
        E.f(charset, "charset");
        Path pathWrite = Files.write(path, L.asIterable(lines), charset, StandardOpenOption.APPEND);
        E.e(pathWrite, "write(...)");
        return pathWrite;
    }

    public static /* synthetic */ Path writeLines$default(Path path, InterfaceC0233q lines, Charset charset, OpenOption[] options, int i5, Object obj) throws IOException {
        if ((i5 & 2) != 0) {
            charset = C0241g.UTF_8;
        }
        E.f(path, "<this>");
        E.f(lines, "lines");
        E.f(charset, "charset");
        E.f(options, "options");
        Path pathWrite = Files.write(path, L.asIterable(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        E.e(pathWrite, "write(...)");
        return pathWrite;
    }
}
