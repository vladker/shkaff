package L3;

import A3.AbstractC0151t;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends o {
    public static final void appendBytes(File file, byte[] array) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            d.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void appendText(File file, String text, Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(text, "text");
        E.f(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            writeTextImpl(fileOutputStream, text, charset);
            d.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    private static final BufferedReader bufferedReader(File file, Charset charset, int i5) {
        E.f(file, "<this>");
        E.f(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i5);
    }

    private static final BufferedWriter bufferedWriter(File file, Charset charset, int i5) {
        E.f(file, "<this>");
        E.f(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i5);
    }

    public static ByteBuffer byteBufferForEncoding(int i5, CharsetEncoder encoder) {
        E.f(encoder, "encoder");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i5 * ((int) Math.ceil(encoder.maxBytesPerChar())));
        E.e(byteBufferAllocate, "allocate(...)");
        return byteBufferAllocate;
    }

    public static final void forEachBlock(File file, O3.p action) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(action, "action");
        forEachBlock(file, 4096, action);
    }

    public static final void forEachLine(File file, Charset charset, O3.l action) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(charset, "charset");
        E.f(action, "action");
        z.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    private static final FileInputStream inputStream(File file) {
        E.f(file, "<this>");
        return new FileInputStream(file);
    }

    public static CharsetEncoder newReplaceEncoder(Charset charset) {
        E.f(charset, "<this>");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        return charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
    }

    private static final FileOutputStream outputStream(File file) {
        E.f(file, "<this>");
        return new FileOutputStream(file);
    }

    private static final PrintWriter printWriter(File file, Charset charset) {
        E.f(file, "<this>");
        E.f(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    public static final byte[] readBytes(File file) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i5 = (int) length;
            byte[] bArrCopyInto = new byte[i5];
            int i6 = i5;
            int i7 = 0;
            while (i6 > 0) {
                int i8 = fileInputStream.read(bArrCopyInto, i7, i6);
                if (i8 < 0) {
                    break;
                }
                i6 -= i8;
                i7 += i8;
            }
            if (i6 > 0) {
                bArrCopyInto = Arrays.copyOf(bArrCopyInto, i7);
                E.e(bArrCopyInto, "copyOf(...)");
            } else {
                int i9 = fileInputStream.read();
                if (i9 != -1) {
                    e eVar = new e(8193);
                    eVar.write(i9);
                    c.copyTo(fileInputStream, eVar, 8192);
                    int size = eVar.size() + i5;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] buffer = eVar.getBuffer();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrCopyInto, size);
                    E.e(bArrCopyOf, "copyOf(...)");
                    bArrCopyInto = AbstractC0151t.copyInto(buffer, bArrCopyOf, i5, 0, eVar.size());
                }
            }
            d.closeFinally(fileInputStream, null);
            return bArrCopyInto;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final List<String> readLines(File file, Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(charset, "charset");
        ArrayList arrayList = new ArrayList();
        forEachLine(file, charset, new p(arrayList, 0));
        return arrayList;
    }

    public static final String readText(File file, Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String text = z.readText(inputStreamReader);
            d.closeFinally(inputStreamReader, null);
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    private static final InputStreamReader reader(File file, Charset charset) {
        E.f(file, "<this>");
        E.f(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T useLines(File file, Charset charset, O3.l block) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(charset, "charset");
        E.f(block, "block");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            T t6 = (T) block.invoke(z.lineSequence(bufferedReader));
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

    public static void writeBytes(File file, byte[] array) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            d.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void writeText(File file, String text, Charset charset) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(text, "text");
        E.f(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            writeTextImpl(fileOutputStream, text, charset);
            d.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static void writeTextImpl(OutputStream outputStream, String text, Charset charset) throws IOException {
        E.f(outputStream, "<this>");
        E.f(text, "text");
        E.f(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            E.e(bytes, "getBytes(...)");
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewReplaceEncoder = newReplaceEncoder(charset);
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        E.c(charsetEncoderNewReplaceEncoder);
        ByteBuffer byteBufferByteBufferForEncoding = byteBufferForEncoding(8192, charsetEncoderNewReplaceEncoder);
        int i5 = 0;
        int i6 = 0;
        while (i5 < text.length()) {
            int iMin = Math.min(8192 - i6, text.length() - i5);
            int i7 = i5 + iMin;
            char[] cArrArray = charBufferAllocate.array();
            E.e(cArrArray, "array(...)");
            text.getChars(i5, i7, cArrArray, i6);
            charBufferAllocate.limit(iMin + i6);
            i6 = 1;
            if (!charsetEncoderNewReplaceEncoder.encode(charBufferAllocate, byteBufferByteBufferForEncoding, i7 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            outputStream.write(byteBufferByteBufferForEncoding.array(), 0, byteBufferByteBufferForEncoding.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i6 = 0;
            }
            charBufferAllocate.clear();
            byteBufferByteBufferForEncoding.clear();
            i5 = i7;
        }
    }

    private static final OutputStreamWriter writer(File file, Charset charset) {
        E.f(file, "<this>");
        E.f(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static final void forEachBlock(File file, int i5, O3.p action) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(action, "action");
        if (i5 < 512) {
            i5 = 512;
        }
        byte[] bArr = new byte[i5];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i6 = fileInputStream.read(bArr);
                if (i6 <= 0) {
                    d.closeFinally(fileInputStream, null);
                    return;
                }
                action.invoke(bArr, Integer.valueOf(i6));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    d.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        }
    }
}
