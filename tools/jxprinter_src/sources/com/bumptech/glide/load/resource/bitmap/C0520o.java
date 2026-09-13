package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0520o implements InterfaceC0519n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f3113a;

    public C0520o(InputStream inputStream) {
        this.f3113a = inputStream;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0519n
    public int getUInt16() {
        return (getUInt8() << 8) | getUInt8();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0519n
    public short getUInt8() throws IOException {
        int i5 = this.f3113a.read();
        if (i5 != -1) {
            return (short) i5;
        }
        throw new C0518m();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0519n
    public int read(byte[] bArr, int i5) throws C0518m {
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5 && (i7 = this.f3113a.read(bArr, i6, i5 - i6)) != -1) {
            i6 += i7;
        }
        if (i6 == 0 && i7 == -1) {
            throw new C0518m();
        }
        return i6;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0519n
    public long skip(long j6) throws IOException {
        if (j6 < 0) {
            return 0L;
        }
        long j7 = j6;
        while (j7 > 0) {
            InputStream inputStream = this.f3113a;
            long jSkip = inputStream.skip(j7);
            if (jSkip > 0) {
                j7 -= jSkip;
            } else {
                if (inputStream.read() == -1) {
                    break;
                }
                j7--;
            }
        }
        return j6 - j7;
    }
}
