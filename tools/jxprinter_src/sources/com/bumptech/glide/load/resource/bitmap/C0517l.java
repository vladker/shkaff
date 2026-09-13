package com.bumptech.glide.load.resource.bitmap;

import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0517l implements InterfaceC0519n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f3112a;

    public C0517l(ByteBuffer byteBuffer) {
        this.f3112a = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0519n
    public int getUInt16() {
        return (getUInt8() << 8) | getUInt8();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0519n
    public short getUInt8() throws C0518m {
        ByteBuffer byteBuffer = this.f3112a;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & UnsignedBytes.MAX_VALUE);
        }
        throw new C0518m();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0519n
    public final int read(byte[] bArr, int i5) {
        ByteBuffer byteBuffer = this.f3112a;
        int iMin = Math.min(i5, byteBuffer.remaining());
        if (iMin == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, iMin);
        return iMin;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.InterfaceC0519n
    public final long skip(long j6) {
        ByteBuffer byteBuffer = this.f3112a;
        int iMin = (int) Math.min(byteBuffer.remaining(), j6);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }
}
