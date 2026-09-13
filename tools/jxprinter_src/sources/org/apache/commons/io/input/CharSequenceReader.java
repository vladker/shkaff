package org.apache.commons.io.input;

import A3.AbstractC0157z;
import java.io.Reader;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CharSequenceReader extends Reader implements Serializable {
    private static final long serialVersionUID = 3724187752191401220L;
    private final CharSequence charSequence;
    private final Integer end;
    private int idx;
    private int mark;
    private final int start;

    public CharSequenceReader(CharSequence charSequence) {
        this(charSequence, 0);
    }

    private int end() {
        int length = this.charSequence.length();
        Integer num = this.end;
        return Math.min(length, num == null ? Integer.MAX_VALUE : num.intValue());
    }

    private int start() {
        return Math.min(this.charSequence.length(), this.start);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i5 = this.start;
        this.idx = i5;
        this.mark = i5;
    }

    @Override // java.io.Reader
    public void mark(int i5) {
        this.mark = this.idx;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        if (this.idx >= end()) {
            return -1;
        }
        CharSequence charSequence = this.charSequence;
        int i5 = this.idx;
        this.idx = i5 + 1;
        return charSequence.charAt(i5);
    }

    @Override // java.io.Reader
    public boolean ready() {
        return this.idx < end();
    }

    @Override // java.io.Reader
    public void reset() {
        this.idx = this.mark;
    }

    @Override // java.io.Reader
    public long skip(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "Number of characters to skip is less than zero: "));
        }
        if (this.idx >= end()) {
            return 0L;
        }
        int iMin = (int) Math.min(end(), ((long) this.idx) + j6);
        int i5 = iMin - this.idx;
        this.idx = iMin;
        return i5;
    }

    public String toString() {
        return this.charSequence.subSequence(start(), end()).toString();
    }

    public CharSequenceReader(CharSequence charSequence, int i5) {
        this(charSequence, i5, Integer.MAX_VALUE);
    }

    public CharSequenceReader(String str, int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Start index is less than zero: "));
        }
        if (i6 >= i5) {
            this.charSequence = str == null ? "" : str;
            this.start = i5;
            this.end = Integer.valueOf(i6);
            this.idx = i5;
            this.mark = i5;
            return;
        }
        throw new IllegalArgumentException(androidx.collection.a.h(i5, i6, "End index is less than start ", ": "));
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i5, int i6) {
        if (this.idx >= end()) {
            return -1;
        }
        Objects.requireNonNull(cArr, "array");
        if (i6 >= 0 && i5 >= 0 && i5 + i6 <= cArr.length) {
            CharSequence charSequence = this.charSequence;
            if (charSequence instanceof String) {
                int iMin = Math.min(i6, end() - this.idx);
                String str = (String) this.charSequence;
                int i7 = this.idx;
                str.getChars(i7, i7 + iMin, cArr, i5);
                this.idx += iMin;
                return iMin;
            }
            if (charSequence instanceof StringBuilder) {
                int iMin2 = Math.min(i6, end() - this.idx);
                StringBuilder sb = (StringBuilder) this.charSequence;
                int i8 = this.idx;
                sb.getChars(i8, i8 + iMin2, cArr, i5);
                this.idx += iMin2;
                return iMin2;
            }
            if (charSequence instanceof StringBuffer) {
                int iMin3 = Math.min(i6, end() - this.idx);
                StringBuffer stringBuffer = (StringBuffer) this.charSequence;
                int i9 = this.idx;
                stringBuffer.getChars(i9, i9 + iMin3, cArr, i5);
                this.idx += iMin3;
                return iMin3;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                int i12 = read();
                if (i12 == -1) {
                    break;
                }
                cArr[i5 + i11] = (char) i12;
                i10++;
            }
            return i10;
        }
        StringBuilder sb2 = new StringBuilder("Array Size=");
        androidx.exifinterface.media.a.y(sb2, cArr.length, ", offset=", i5, ", length=");
        sb2.append(i6);
        throw new IndexOutOfBoundsException(sb2.toString());
    }
}
