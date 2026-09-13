package org.apache.commons.io.output;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(String str, String str2) {
        this(new File(str), str2, false);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:31:? A[SYNTHETIC] */
    private static Writer initWriter(File file, Object obj, boolean z6) throws Throwable {
        Objects.requireNonNull(file, Constants.FILE);
        Objects.requireNonNull(obj, "encoding");
        boolean zExists = file.exists();
        try {
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(file.toPath(), z6 ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
            if (obj instanceof Charset) {
                return new OutputStreamWriter(outputStreamNewOutputStream, (Charset) obj);
            }
            return obj instanceof CharsetEncoder ? new OutputStreamWriter(outputStreamNewOutputStream, (CharsetEncoder) obj) : new OutputStreamWriter(outputStreamNewOutputStream, (String) obj);
        } catch (IOException e) {
            e = e;
            try {
                IOUtils.close((Closeable) null);
            } catch (IOException e6) {
                e.addSuppressed(e6);
            }
            if (!zExists) {
                throw e;
            }
            FileUtils.deleteQuietly(file);
            throw e;
        } catch (RuntimeException e7) {
            e = e7;
            IOUtils.close((Closeable) null);
            if (!zExists) {
                throw e;
            }
            FileUtils.deleteQuietly(file);
            throw e;
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.Writer
    public void write(int i5) throws IOException {
        this.out.write(i5);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z6) {
        this(new File(str), str2, z6);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    public FileWriterWithEncoding(String str, Charset charset) {
        this(new File(str), charset, false);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) throws IOException {
        this.out.write(cArr, i5, i6);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z6) {
        this(new File(str), charset, z6);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.out.write(str);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) {
        this(new File(str), charsetEncoder, false);
    }

    @Override // java.io.Writer
    public void write(String str, int i5, int i6) throws IOException {
        this.out.write(str, i5, i6);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z6) {
        this(new File(str), charsetEncoder, z6);
    }

    public FileWriterWithEncoding(File file, String str) {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z6) {
        this.out = initWriter(file, str, z6);
    }

    public FileWriterWithEncoding(File file, Charset charset) {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z6) {
        this.out = initWriter(file, charset, z6);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z6) {
        this.out = initWriter(file, charsetEncoder, z6);
    }
}
