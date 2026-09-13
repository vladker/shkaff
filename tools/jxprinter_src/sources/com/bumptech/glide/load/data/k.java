package com.bumptech.glide.load.data;

import A3.AbstractC0157z;
import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends FilterInputStream {
    public static final byte[] c = {-1, -31, 0, Ascii.FS, 69, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    public static final int d = 31;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f2921a;
    public int b;

    public k(InputStream inputStream, int i5) {
        super(inputStream);
        if (i5 < -1 || i5 > 8) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Cannot add invalid orientation: "));
        }
        this.f2921a = (byte) i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i5;
        int i6;
        int i7 = this.b;
        if (i7 < 2 || i7 > (i6 = d)) {
            i5 = super.read();
        } else {
            i5 = i7 == i6 ? this.f2921a : c[i7 - 2] & UnsignedBytes.MAX_VALUE;
        }
        if (i5 != -1) {
            this.b++;
        }
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) throws IOException {
        long jSkip = super.skip(j6);
        if (jSkip > 0) {
            this.b = (int) (((long) this.b) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i5, int i6) throws IOException {
        int i7;
        int i8 = this.b;
        int i9 = d;
        if (i8 > i9) {
            i7 = super.read(bArr, i5, i6);
        } else if (i8 == i9) {
            bArr[i5] = this.f2921a;
            i7 = 1;
        } else if (i8 < 2) {
            i7 = super.read(bArr, i5, 2 - i8);
        } else {
            int iMin = Math.min(i9 - i8, i6);
            System.arraycopy(c, this.b - 2, bArr, i5, iMin);
            i7 = iMin;
        }
        if (i7 > 0) {
            this.b += i7;
        }
        return i7;
    }
}
