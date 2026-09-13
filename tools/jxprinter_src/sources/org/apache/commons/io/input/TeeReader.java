package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TeeReader extends ProxyReader {
    private final Writer branch;
    private final boolean closeBranch;

    public TeeReader(Reader reader, Writer writer) {
        this(reader, writer, false);
    }

    @Override // org.apache.commons.io.input.ProxyReader, java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (this.closeBranch) {
                this.branch.close();
            }
        }
    }

    @Override // org.apache.commons.io.input.ProxyReader, java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        int i5 = super.read();
        if (i5 != -1) {
            this.branch.write(i5);
        }
        return i5;
    }

    public TeeReader(Reader reader, Writer writer, boolean z6) {
        super(reader);
        this.branch = writer;
        this.closeBranch = z6;
    }

    @Override // org.apache.commons.io.input.ProxyReader, java.io.Reader
    public int read(char[] cArr) throws IOException {
        int i5 = super.read(cArr);
        if (i5 != -1) {
            this.branch.write(cArr, 0, i5);
        }
        return i5;
    }

    @Override // org.apache.commons.io.input.ProxyReader, java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i5, int i6) throws IOException {
        int i7 = super.read(cArr, i5, i6);
        if (i7 != -1) {
            this.branch.write(cArr, i5, i7);
        }
        return i7;
    }

    @Override // org.apache.commons.io.input.ProxyReader, java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        int iPosition = charBuffer.position();
        int i5 = super.read(charBuffer);
        if (i5 == -1) {
            return i5;
        }
        int iPosition2 = charBuffer.position();
        int iLimit = charBuffer.limit();
        try {
            charBuffer.position(iPosition).limit(iPosition2);
            this.branch.append((CharSequence) charBuffer);
            return i5;
        } finally {
            charBuffer.position(iPosition2).limit(iLimit);
        }
    }
}
