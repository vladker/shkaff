package X1;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f835a;
    public long b;

    public b() {
        this.f835a = new byte[4];
    }

    public String read(a aVar) throws EOFException {
        byte tTFByte = aVar.readTTFByte();
        byte[] bArr = this.f835a;
        bArr[0] = tTFByte;
        bArr[1] = aVar.readTTFByte();
        bArr[2] = aVar.readTTFByte();
        bArr[3] = aVar.readTTFByte();
        aVar.skip(4L);
        this.b = aVar.readTTFULong();
        aVar.readTTFULong();
        return new String(bArr, "ISO-8859-1");
    }

    public b(int i5) {
        this.f835a = new byte[4];
        this.b = 0L;
    }
}
