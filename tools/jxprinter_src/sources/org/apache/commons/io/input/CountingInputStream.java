package org.apache.commons.io.input;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CountingInputStream extends ProxyInputStream {
    private long count;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    public synchronized void afterRead(int i5) {
        if (i5 != -1) {
            this.count += (long) i5;
        }
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= 2147483647L) {
            return (int) byteCount;
        }
        throw new ArithmeticException(androidx.exifinterface.media.a.k("The byte count ", byteCount, " is too large to be converted to an int"));
    }

    public synchronized long resetByteCount() {
        long j6;
        j6 = this.count;
        this.count = 0L;
        return j6;
    }

    public int resetCount() {
        long jResetByteCount = resetByteCount();
        if (jResetByteCount <= 2147483647L) {
            return (int) jResetByteCount;
        }
        throw new ArithmeticException(androidx.exifinterface.media.a.k("The byte count ", jResetByteCount, " is too large to be converted to an int"));
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j6) {
        long jSkip;
        jSkip = super.skip(j6);
        this.count += jSkip;
        return jSkip;
    }
}
