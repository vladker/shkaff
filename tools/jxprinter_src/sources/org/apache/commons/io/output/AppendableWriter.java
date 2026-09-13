package org.apache.commons.io.output;

import androidx.exifinterface.media.a;
import java.io.IOException;
import java.io.Writer;
import java.lang.Appendable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AppendableWriter<T extends Appendable> extends Writer {
    private final T appendable;

    public AppendableWriter(T t6) {
        this.appendable = t6;
    }

    public T getAppendable() {
        return this.appendable;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) throws IOException {
        Objects.requireNonNull(cArr, "Character array is missing");
        if (i6 < 0 || i5 + i6 > cArr.length) {
            StringBuilder sb = new StringBuilder("Array Size=");
            a.y(sb, cArr.length, ", offset=", i5, ", length=");
            sb.append(i6);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        for (int i7 = 0; i7 < i6; i7++) {
            this.appendable.append(cArr[i5 + i7]);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        this.appendable.append(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        this.appendable.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i5, int i6) throws IOException {
        this.appendable.append(charSequence, i5, i6);
        return this;
    }

    @Override // java.io.Writer
    public void write(int i5) throws IOException {
        this.appendable.append((char) i5);
    }

    @Override // java.io.Writer
    public void write(String str, int i5, int i6) throws IOException {
        Objects.requireNonNull(str, "String is missing");
        this.appendable.append(str, i5, i6 + i5);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }
}
