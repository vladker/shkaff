package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SequenceReader extends Reader {
    private Reader reader;
    private Iterator<? extends Reader> readers;

    public SequenceReader(Iterable<? extends Reader> iterable) {
        Objects.requireNonNull(iterable, "readers");
        this.readers = iterable.iterator();
        this.reader = nextReader();
    }

    private Reader nextReader() {
        if (this.readers.hasNext()) {
            return this.readers.next();
        }
        return null;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.readers = null;
        this.reader = null;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        int i5 = -1;
        while (true) {
            Reader reader = this.reader;
            if (reader == null) {
                return i5;
            }
            i5 = reader.read();
            if (i5 != -1) {
                return i5;
            }
            this.reader = nextReader();
        }
    }

    public SequenceReader(Reader... readerArr) {
        this(Arrays.asList(readerArr));
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i5, int i6) throws IOException {
        Objects.requireNonNull(cArr, "cbuf");
        if (i6 < 0 || i5 < 0 || i5 + i6 > cArr.length) {
            StringBuilder sb = new StringBuilder("Array Size=");
            androidx.exifinterface.media.a.y(sb, cArr.length, ", offset=", i5, ", length=");
            sb.append(i6);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int i7 = 0;
        while (true) {
            Reader reader = this.reader;
            if (reader == null) {
                break;
            }
            int i8 = reader.read(cArr, i5, i6);
            if (i8 == -1) {
                this.reader = nextReader();
            } else {
                i7 += i8;
                i5 += i8;
                i6 -= i8;
                if (i6 <= 0) {
                    break;
                }
            }
        }
        if (i7 > 0) {
            return i7;
        }
        return -1;
    }
}
