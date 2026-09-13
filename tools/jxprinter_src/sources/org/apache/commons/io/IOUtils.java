package org.apache.commons.io;

import A3.AbstractC0157z;
import F4.b;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.emoji2.text.flatbuffer.a;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.output.AppendableWriter;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.NullOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.commons.io.output.ThresholdingOutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IOUtils {
    public static final int CR = 13;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final int EOF = -1;
    public static final int LF = 10;
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Deprecated
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String LINE_SEPARATOR_UNIX = StandardLineSeparator.LF.getString();
    public static final String LINE_SEPARATOR_WINDOWS = StandardLineSeparator.CRLF.getString();
    private static final ThreadLocal<byte[]> SKIP_BYTE_BUFFER = ThreadLocal.withInitial(new a(1));
    private static final ThreadLocal<char[]> SKIP_CHAR_BUFFER = ThreadLocal.withInitial(new a(2));

    public static BufferedInputStream buffer(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputStream");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

    public static byte[] byteArray() {
        return byteArray(8192);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char[] charArray() {
        return charArray(8192);
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        closeQuietly(closeable, null);
    }

    public static long consume(InputStream inputStream) {
        return copyLarge(inputStream, NullOutputStream.NULL_OUTPUT_STREAM, getByteArray());
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        int i5;
        int i6;
        if (inputStream == inputStream2) {
            return true;
        }
        if (inputStream == null || inputStream2 == null) {
            return false;
        }
        byte[] byteArray = getByteArray();
        byte[] bArrByteArray = byteArray();
        while (true) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < 8192) {
                if (i8 == i7) {
                    do {
                        i6 = inputStream.read(byteArray, i8, 8192 - i8);
                    } while (i6 == 0);
                    if (i6 == -1) {
                        return i9 == i7 && inputStream2.read() == -1;
                    }
                    i8 += i6;
                }
                if (i9 == i7) {
                    do {
                        i5 = inputStream2.read(bArrByteArray, i9, 8192 - i9);
                    } while (i5 == 0);
                    if (i5 == -1) {
                        return i8 == i7 && inputStream.read() == -1;
                    }
                    i9 += i5;
                }
                if (byteArray[i7] != bArrByteArray[i7]) {
                    return false;
                }
                i7++;
            }
        }
    }

    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) throws IOException {
        if (reader == reader2) {
            return true;
        }
        if ((reader2 == null) ^ (reader == null)) {
            return false;
        }
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        String line = bufferedReader.readLine();
        String line2 = bufferedReader2.readLine();
        while (line != null && line.equals(line2)) {
            line = bufferedReader.readLine();
            line2 = bufferedReader2.readLine();
        }
        return Objects.equals(line, line2);
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        long jCopyLarge = copyLarge(inputStream, outputStream);
        if (jCopyLarge > 2147483647L) {
            return -1;
        }
        return (int) jCopyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream, 8192);
    }

    public static byte[] getByteArray() {
        return SKIP_BYTE_BUFFER.get();
    }

    public static char[] getCharArray() {
        return SKIP_CHAR_BUFFER.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toByteArray$0(ThresholdingOutputStream thresholdingOutputStream) {
        throw new IllegalArgumentException(String.format("Cannot read more than %,d into a byte array", Integer.MAX_VALUE));
    }

    public static int length(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public static LineIterator lineIterator(InputStream inputStream, Charset charset) {
        return new LineIterator(new InputStreamReader(inputStream, Charsets.toCharset(charset)));
    }

    public static int read(InputStream inputStream, byte[] bArr) {
        return read(inputStream, bArr, 0, bArr.length);
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    @Deprecated
    public static List<String> readLines(InputStream inputStream) {
        return readLines(inputStream, Charset.defaultCharset());
    }

    public static byte[] resourceToByteArray(String str) {
        return resourceToByteArray(str, null);
    }

    public static String resourceToString(String str, Charset charset) {
        return resourceToString(str, charset, null);
    }

    public static URL resourceToURL(String str) {
        return resourceToURL(str, null);
    }

    public static long skip(InputStream inputStream, long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "Skip count must be non-negative, actual: "));
        }
        long j7 = j6;
        while (j7 > 0) {
            byte[] byteArray = getByteArray();
            long j8 = inputStream.read(byteArray, 0, (int) Math.min(j7, byteArray.length));
            if (j8 < 0) {
                break;
            }
            j7 -= j8;
        }
        return j6 - j7;
    }

    public static void skipFully(InputStream inputStream, long j6) throws EOFException {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "Bytes to skip must not be negative: "));
        }
        long jSkip = skip(inputStream, j6);
        if (jSkip == j6) {
            return;
        }
        StringBuilder sbT = androidx.collection.a.t("Bytes to skip: ", j6, " actual: ");
        sbT.append(jSkip);
        throw new EOFException(sbT.toString());
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static byte[] toByteArray(InputStream inputStream) {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            ThresholdingOutputStream thresholdingOutputStream = new ThresholdingOutputStream(Integer.MAX_VALUE, new b(1), new Y2.a(unsynchronizedByteArrayOutputStream, 27));
            try {
                copy(inputStream, thresholdingOutputStream);
                byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                thresholdingOutputStream.close();
                unsynchronizedByteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        thresholdingOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    unsynchronizedByteArrayOutputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    @Deprecated
    public static char[] toCharArray(InputStream inputStream) {
        return toCharArray(inputStream, Charset.defaultCharset());
    }

    @Deprecated
    public static InputStream toInputStream(CharSequence charSequence) {
        return toInputStream(charSequence, Charset.defaultCharset());
    }

    @Deprecated
    public static String toString(byte[] bArr) {
        return new String(bArr, Charset.defaultCharset());
    }

    public static void write(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public static void writeChunked(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            int length = bArr.length;
            int i5 = 0;
            while (length > 0) {
                int iMin = Math.min(length, 8192);
                outputStream.write(bArr, i5, iMin);
                length -= iMin;
                i5 += iMin;
            }
        }
    }

    @Deprecated
    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream) throws IOException {
        writeLines(collection, str, outputStream, Charset.defaultCharset());
    }

    public static Writer writer(Appendable appendable) {
        Objects.requireNonNull(appendable, "appendable");
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return appendable instanceof StringBuilder ? new StringBuilderWriter((StringBuilder) appendable) : new AppendableWriter(appendable);
    }

    public static byte[] byteArray(int i5) {
        return new byte[i5];
    }

    private static char[] charArray(int i5) {
        return new char[i5];
    }

    public static void close(Closeable... closeableArr) throws IOException {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                close(closeable);
            }
        }
    }

    public static void closeQuietly(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            closeQuietly(closeable);
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i5) {
        return copyLarge(inputStream, outputStream, byteArray(i5));
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream");
        Objects.requireNonNull(outputStream, "outputStream");
        long j6 = 0;
        while (true) {
            int i5 = inputStream.read(bArr);
            if (-1 == i5) {
                return j6;
            }
            outputStream.write(bArr, 0, i5);
            j6 += (long) i5;
        }
    }

    public static int length(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        return cArr.length;
    }

    public static LineIterator lineIterator(InputStream inputStream, String str) {
        return lineIterator(inputStream, Charsets.toCharset(str));
    }

    public static int read(InputStream inputStream, byte[] bArr, int i5, int i6) throws IOException {
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Length must not be negative: "));
        }
        int i7 = i6;
        while (i7 > 0) {
            int i8 = inputStream.read(bArr, (i6 - i7) + i5, i7);
            if (-1 == i8) {
                break;
            }
            i7 -= i8;
        }
        return i6 - i7;
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i5, int i6) throws IOException {
        int i7 = read(inputStream, bArr, i5, i6);
        if (i7 != i6) {
            throw new EOFException(androidx.collection.a.h(i6, i7, "Length to read: ", " actual: "));
        }
    }

    public static List<String> readLines(InputStream inputStream, Charset charset) {
        return readLines(new InputStreamReader(inputStream, Charsets.toCharset(charset)));
    }

    public static byte[] resourceToByteArray(String str, ClassLoader classLoader) {
        return toByteArray(resourceToURL(str, classLoader));
    }

    public static String resourceToString(String str, Charset charset, ClassLoader classLoader) {
        return toString(resourceToURL(str, classLoader), charset);
    }

    public static URL resourceToURL(String str, ClassLoader classLoader) throws IOException {
        URL resource = classLoader == null ? IOUtils.class.getResource(str) : classLoader.getResource(str);
        if (resource != null) {
            return resource;
        }
        throw new IOException(AbstractC0157z.n("Resource not found: ", str));
    }

    public static InputStream toBufferedInputStream(InputStream inputStream, int i5) {
        return ByteArrayOutputStream.toBufferedInputStream(inputStream, i5);
    }

    public static BufferedReader toBufferedReader(Reader reader, int i5) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i5);
    }

    public static char[] toCharArray(InputStream inputStream, Charset charset) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        copy(inputStream, charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(CharSequence charSequence, Charset charset) {
        return toInputStream(charSequence.toString(), charset);
    }

    public static String toString(byte[] bArr, String str) {
        return new String(bArr, Charsets.toCharset(str));
    }

    @Deprecated
    public static void write(byte[] bArr, Writer writer) throws IOException {
        write(bArr, writer, Charset.defaultCharset());
    }

    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream, Charset charset) throws IOException {
        if (collection == null) {
            return;
        }
        if (str == null) {
            str = System.lineSeparator();
        }
        Charset charset2 = Charsets.toCharset(charset);
        for (Object obj : collection) {
            if (obj != null) {
                outputStream.write(obj.toString().getBytes(charset2));
            }
            outputStream.write(str.getBytes(charset2));
        }
    }

    public static BufferedInputStream buffer(InputStream inputStream, int i5) {
        Objects.requireNonNull(inputStream, "inputStream");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i5);
    }

    @Deprecated
    public static void copy(InputStream inputStream, Writer writer) {
        copy(inputStream, writer, Charset.defaultCharset());
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static LineIterator lineIterator(Reader reader) {
        return new LineIterator(reader);
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) {
        return toInputStream(charSequence, Charsets.toCharset(str));
    }

    @Deprecated
    public static String toString(InputStream inputStream) {
        return toString(inputStream, Charset.defaultCharset());
    }

    public static void write(byte[] bArr, Writer writer, Charset charset) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr, Charsets.toCharset(charset)));
        }
    }

    public static void close(Closeable closeable, IOConsumer<IOException> iOConsumer) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (iOConsumer != null) {
                    iOConsumer.accept(e);
                }
            }
        }
    }

    public static void closeQuietly(Closeable closeable, Consumer<IOException> consumer) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (consumer != null) {
                    consumer.accept(e);
                }
            }
        }
    }

    public static void copy(InputStream inputStream, Writer writer, Charset charset) {
        copy((Reader) new InputStreamReader(inputStream, Charsets.toCharset(charset)), writer);
    }

    public static int length(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public static List<String> readLines(InputStream inputStream, String str) {
        return readLines(inputStream, Charsets.toCharset(str));
    }

    @Deprecated
    public static InputStream toInputStream(String str) {
        return toInputStream(str, Charset.defaultCharset());
    }

    public static String toString(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        try {
            copy(inputStream, stringBuilderWriter, charset);
            String string = stringBuilderWriter.toString();
            stringBuilderWriter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void write(byte[] bArr, Writer writer, String str) throws IOException {
        write(bArr, writer, Charsets.toCharset(str));
    }

    public static void writeChunked(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            int length = cArr.length;
            int i5 = 0;
            while (length > 0) {
                int iMin = Math.min(length, 8192);
                writer.write(cArr, i5, iMin);
                length -= iMin;
                i5 += iMin;
            }
        }
    }

    public static BufferedOutputStream buffer(OutputStream outputStream) {
        Objects.requireNonNull(outputStream, "outputStream");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    public static List<String> readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return arrayList;
            }
            arrayList.add(line);
        }
    }

    public static char[] toCharArray(InputStream inputStream, String str) {
        return toCharArray(inputStream, Charsets.toCharset(str));
    }

    public static InputStream toInputStream(String str, Charset charset) {
        return new ByteArrayInputStream(str.getBytes(Charsets.toCharset(charset)));
    }

    @Deprecated
    public static void write(char[] cArr, OutputStream outputStream) throws IOException {
        write(cArr, outputStream, Charset.defaultCharset());
    }

    public static void close(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        closeQuietly((Closeable) inputStream);
    }

    public static void copy(InputStream inputStream, Writer writer, String str) {
        copy(inputStream, writer, Charsets.toCharset(str));
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j6, long j7) {
        return copyLarge(inputStream, outputStream, j6, j7, getByteArray());
    }

    public static char[] toCharArray(Reader reader) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        copy(reader, (Writer) charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(String str, String str2) {
        return new ByteArrayInputStream(str.getBytes(Charsets.toCharset(str2)));
    }

    public static void write(char[] cArr, OutputStream outputStream, Charset charset) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(Charsets.toCharset(charset)));
        }
    }

    public static BufferedOutputStream buffer(OutputStream outputStream, int i5) {
        Objects.requireNonNull(outputStream, "outputStream");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i5);
    }

    public static void closeQuietly(OutputStream outputStream) {
        closeQuietly((Closeable) outputStream);
    }

    public static long copy(Reader reader, Appendable appendable) {
        return copy(reader, appendable, CharBuffer.allocate(8192));
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, long j6, long j7, byte[] bArr) throws IOException {
        long j8 = 0;
        if (j6 > 0) {
            skipFully(inputStream, j6);
        }
        if (j7 == 0) {
            return 0L;
        }
        int length = bArr.length;
        int iMin = (j7 <= 0 || j7 >= ((long) length)) ? length : (int) j7;
        while (iMin > 0) {
            int i5 = inputStream.read(bArr, 0, iMin);
            if (-1 == i5) {
                break;
            }
            outputStream.write(bArr, 0, i5);
            j8 += (long) i5;
            if (j7 > 0) {
                iMin = (int) Math.min(j7 - j8, length);
            }
        }
        return j8;
    }

    public static void write(char[] cArr, OutputStream outputStream, String str) throws IOException {
        write(cArr, outputStream, Charsets.toCharset(str));
    }

    public static void writeLines(Collection<?> collection, String str, OutputStream outputStream, String str2) throws IOException {
        writeLines(collection, str, outputStream, Charsets.toCharset(str2));
    }

    public static void closeQuietly(Reader reader) {
        closeQuietly((Closeable) reader);
    }

    public static boolean contentEquals(Reader reader, Reader reader2) throws IOException {
        int i5;
        int i6;
        if (reader == reader2) {
            return true;
        }
        if (reader == null || reader2 == null) {
            return false;
        }
        char[] charArray = getCharArray();
        char[] cArrCharArray = charArray();
        while (true) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < 8192) {
                if (i8 == i7) {
                    do {
                        i6 = reader.read(charArray, i8, 8192 - i8);
                    } while (i6 == 0);
                    if (i6 == -1) {
                        return i9 == i7 && reader2.read() == -1;
                    }
                    i8 += i6;
                }
                if (i9 == i7) {
                    do {
                        i5 = reader2.read(cArrCharArray, i9, 8192 - i9);
                    } while (i5 == 0);
                    if (i5 == -1) {
                        return i8 == i7 && reader.read() == -1;
                    }
                    i9 += i5;
                }
                if (charArray[i7] != cArrCharArray[i7]) {
                    return false;
                }
                i7++;
            }
        }
    }

    public static long copy(Reader reader, Appendable appendable, CharBuffer charBuffer) throws IOException {
        long j6 = 0;
        while (true) {
            int i5 = reader.read(charBuffer);
            if (-1 == i5) {
                return j6;
            }
            charBuffer.flip();
            appendable.append(charBuffer, 0, i5);
            j6 += (long) i5;
        }
    }

    public static void write(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            writer.write(cArr);
        }
    }

    public static void writeLines(Collection<?> collection, String str, Writer writer) throws IOException {
        if (collection == null) {
            return;
        }
        if (str == null) {
            str = System.lineSeparator();
        }
        for (Object obj : collection) {
            if (obj != null) {
                writer.write(obj.toString());
            }
            writer.write(str);
        }
    }

    public static BufferedReader buffer(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static void closeQuietly(Selector selector) {
        closeQuietly((Closeable) selector);
    }

    @Deprecated
    public static void write(CharSequence charSequence, OutputStream outputStream) throws IOException {
        write(charSequence, outputStream, Charset.defaultCharset());
    }

    public static BufferedReader buffer(Reader reader, int i5) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i5);
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        closeQuietly((Closeable) serverSocket);
    }

    public static int read(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        while (byteBuffer.remaining() > 0 && -1 != readableByteChannel.read(byteBuffer)) {
        }
        return iRemaining - byteBuffer.remaining();
    }

    public static long skip(ReadableByteChannel readableByteChannel, long j6) throws IOException {
        if (j6 >= 0) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) Math.min(j6, PlaybackStateCompat.ACTION_PLAY_FROM_URI));
            long j7 = j6;
            while (j7 > 0) {
                byteBufferAllocate.position(0);
                byteBufferAllocate.limit((int) Math.min(j7, PlaybackStateCompat.ACTION_PLAY_FROM_URI));
                int i5 = readableByteChannel.read(byteBufferAllocate);
                if (i5 == -1) {
                    break;
                }
                j7 -= (long) i5;
            }
            return j6 - j7;
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j6, "Skip count must be non-negative, actual: "));
    }

    public static byte[] toByteArray(InputStream inputStream, int i5) throws IOException {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Size must be equal or greater than zero: "));
        }
        if (i5 == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArrByteArray = byteArray(i5);
        int i6 = 0;
        while (i6 < i5) {
            int i7 = inputStream.read(bArrByteArray, i6, i5 - i6);
            if (i7 == -1) {
                break;
            }
            i6 += i7;
        }
        if (i6 == i5) {
            return bArrByteArray;
        }
        throw new IOException(androidx.collection.a.h(i6, i5, "Unexpected read size, current: ", ", expected: "));
    }

    public static String toString(InputStream inputStream, String str) {
        return toString(inputStream, Charsets.toCharset(str));
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, Charset charset) throws IOException {
        if (charSequence != null) {
            write(charSequence.toString(), outputStream, charset);
        }
    }

    public static BufferedWriter buffer(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public static void closeQuietly(Socket socket) {
        closeQuietly((Closeable) socket);
    }

    @Deprecated
    public static void copy(Reader reader, OutputStream outputStream) throws IOException {
        copy(reader, outputStream, Charset.defaultCharset());
    }

    public static String toString(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        try {
            copy(reader, (Writer) stringBuilderWriter);
            String string = stringBuilderWriter.toString();
            stringBuilderWriter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, String str) throws IOException {
        write(charSequence, outputStream, Charsets.toCharset(str));
    }

    public static BufferedWriter buffer(Writer writer, int i5) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i5);
    }

    public static void closeQuietly(Writer writer) {
        closeQuietly((Closeable) writer);
    }

    public static void copy(Reader reader, OutputStream outputStream, Charset charset) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, Charsets.toCharset(charset));
        copy(reader, (Writer) outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static long copyLarge(Reader reader, Writer writer) {
        return copyLarge(reader, writer, getCharArray());
    }

    public static byte[] readFully(InputStream inputStream, int i5) throws IOException {
        byte[] bArrByteArray = byteArray(i5);
        readFully(inputStream, bArrByteArray, 0, bArrByteArray.length);
        return bArrByteArray;
    }

    public static void write(CharSequence charSequence, Writer writer) throws IOException {
        if (charSequence != null) {
            write(charSequence.toString(), writer);
        }
    }

    public static long copyLarge(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j6 = 0;
        while (true) {
            int i5 = reader.read(cArr);
            if (-1 == i5) {
                return j6;
            }
            writer.write(cArr, 0, i5);
            j6 += (long) i5;
        }
    }

    @Deprecated
    public static void write(String str, OutputStream outputStream) throws IOException {
        write(str, outputStream, Charset.defaultCharset());
    }

    public static int read(Reader reader, char[] cArr) {
        return read(reader, cArr, 0, cArr.length);
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws EOFException {
        int iRemaining = byteBuffer.remaining();
        int i5 = read(readableByteChannel, byteBuffer);
        if (i5 != iRemaining) {
            throw new EOFException(androidx.collection.a.h(iRemaining, i5, "Length to read: ", " actual: "));
        }
    }

    public static void write(String str, OutputStream outputStream, Charset charset) throws IOException {
        if (str != null) {
            outputStream.write(str.getBytes(Charsets.toCharset(charset)));
        }
    }

    public static void copy(Reader reader, OutputStream outputStream, String str) throws IOException {
        copy(reader, outputStream, Charsets.toCharset(str));
    }

    public static long copyLarge(Reader reader, Writer writer, long j6, long j7) {
        return copyLarge(reader, writer, j6, j7, getCharArray());
    }

    public static int read(Reader reader, char[] cArr, int i5, int i6) throws IOException {
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Length must not be negative: "));
        }
        int i7 = i6;
        while (i7 > 0) {
            int i8 = reader.read(cArr, (i6 - i7) + i5, i7);
            if (-1 == i8) {
                break;
            }
            i7 -= i8;
        }
        return i6 - i7;
    }

    public static void write(String str, OutputStream outputStream, String str2) throws IOException {
        write(str, outputStream, Charsets.toCharset(str2));
    }

    public static int copy(Reader reader, Writer writer) {
        long jCopyLarge = copyLarge(reader, writer);
        if (jCopyLarge > 2147483647L) {
            return -1;
        }
        return (int) jCopyLarge;
    }

    public static long copyLarge(Reader reader, Writer writer, long j6, long j7, char[] cArr) throws IOException {
        long j8 = 0;
        if (j6 > 0) {
            skipFully(reader, j6);
        }
        if (j7 == 0) {
            return 0L;
        }
        int length = cArr.length;
        if (j7 > 0 && j7 < cArr.length) {
            length = (int) j7;
        }
        while (length > 0) {
            int i5 = reader.read(cArr, 0, length);
            if (-1 == i5) {
                break;
            }
            writer.write(cArr, 0, i5);
            j8 += (long) i5;
            if (j7 > 0) {
                length = (int) Math.min(j7 - j8, cArr.length);
            }
        }
        return j8;
    }

    public static void skipFully(ReadableByteChannel readableByteChannel, long j6) throws IOException {
        if (j6 >= 0) {
            long jSkip = skip(readableByteChannel, j6);
            if (jSkip == j6) {
                return;
            }
            StringBuilder sbT = androidx.collection.a.t("Bytes to skip: ", j6, " actual: ");
            sbT.append(jSkip);
            throw new EOFException(sbT.toString());
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j6, "Bytes to skip must not be negative: "));
    }

    public static void write(String str, Writer writer) throws IOException {
        if (str != null) {
            writer.write(str);
        }
    }

    public static long copy(URL url, File file) throws IOException {
        Objects.requireNonNull(file, Constants.FILE);
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
        try {
            long jCopy = copy(url, outputStreamNewOutputStream);
            if (outputStreamNewOutputStream != null) {
                outputStreamNewOutputStream.close();
            }
            return jCopy;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamNewOutputStream != null) {
                    try {
                        outputStreamNewOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static String toString(URI uri) {
        return toString(uri, Charset.defaultCharset());
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream) throws IOException {
        write(stringBuffer, outputStream, (String) null);
    }

    public static String toString(URI uri, Charset charset) {
        return toString(uri.toURL(), Charsets.toCharset(charset));
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, OutputStream outputStream, String str) throws IOException {
        if (stringBuffer != null) {
            outputStream.write(stringBuffer.toString().getBytes(Charsets.toCharset(str)));
        }
    }

    public static String toString(URI uri, String str) {
        return toString(uri, Charsets.toCharset(str));
    }

    @Deprecated
    public static void write(StringBuffer stringBuffer, Writer writer) throws IOException {
        if (stringBuffer != null) {
            writer.write(stringBuffer.toString());
        }
    }

    @Deprecated
    public static String toString(URL url) {
        return toString(url, Charset.defaultCharset());
    }

    public static long skip(Reader reader, long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "Skip count must be non-negative, actual: "));
        }
        long j7 = j6;
        while (j7 > 0) {
            char[] charArray = getCharArray();
            long j8 = reader.read(charArray, 0, (int) Math.min(j7, charArray.length));
            if (j8 < 0) {
                break;
            }
            j7 -= j8;
        }
        return j6 - j7;
    }

    public static String toString(URL url, Charset charset) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            String string = toString(inputStreamOpenStream, charset);
            if (inputStreamOpenStream != null) {
                inputStreamOpenStream.close();
            }
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static long copy(URL url, OutputStream outputStream) throws IOException {
        Objects.requireNonNull(url, "url");
        InputStream inputStreamOpenStream = url.openStream();
        try {
            long jCopyLarge = copyLarge(inputStreamOpenStream, outputStream);
            if (inputStreamOpenStream != null) {
                inputStreamOpenStream.close();
            }
            return jCopyLarge;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void readFully(Reader reader, char[] cArr) throws IOException {
        readFully(reader, cArr, 0, cArr.length);
    }

    public static void readFully(Reader reader, char[] cArr, int i5, int i6) throws IOException {
        int i7 = read(reader, cArr, i5, i6);
        if (i7 != i6) {
            throw new EOFException(androidx.collection.a.h(i6, i7, "Length to read: ", " actual: "));
        }
    }

    public static String toString(URL url, String str) {
        return toString(url, Charsets.toCharset(str));
    }

    public static byte[] toByteArray(InputStream inputStream, long j6) {
        if (j6 <= 2147483647L) {
            return toByteArray(inputStream, (int) j6);
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j6, "Size cannot be greater than Integer max value: "));
    }

    public static void skipFully(Reader reader, long j6) throws EOFException {
        long jSkip = skip(reader, j6);
        if (jSkip == j6) {
            return;
        }
        StringBuilder sbT = androidx.collection.a.t("Chars to skip: ", j6, " actual: ");
        sbT.append(jSkip);
        throw new EOFException(sbT.toString());
    }

    @Deprecated
    public static byte[] toByteArray(Reader reader) {
        return toByteArray(reader, Charset.defaultCharset());
    }

    public static byte[] toByteArray(Reader reader, Charset charset) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(reader, byteArrayOutputStream, charset);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] toByteArray(Reader reader, String str) {
        return toByteArray(reader, Charsets.toCharset(str));
    }

    @Deprecated
    public static byte[] toByteArray(String str) {
        return str.getBytes(Charset.defaultCharset());
    }

    public static byte[] toByteArray(URI uri) {
        return toByteArray(uri.toURL());
    }

    public static byte[] toByteArray(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        try {
            return toByteArray(uRLConnectionOpenConnection);
        } finally {
            close(uRLConnectionOpenConnection);
        }
    }

    public static byte[] toByteArray(URLConnection uRLConnection) throws IOException {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            byte[] byteArray = toByteArray(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ OutputStream lambda$toByteArray$1(UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream, ThresholdingOutputStream thresholdingOutputStream) {
        return unsynchronizedByteArrayOutputStream;
    }
}
