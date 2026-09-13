package p081o1;

import com.facebook.crypto.mac.NativeMac;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p098r1.a;
import p110t1.d;
import p110t1.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6437a;
    public final p115u1.b b;
    public final d c;

    @Deprecated
    public b(a aVar, p115u1.b bVar) {
        this(aVar, bVar, 1);
    }

    private static void computeMacAad(NativeMac nativeMac, byte b, byte b6, byte[] bArr) throws IOException {
        nativeMac.update(new byte[]{b}, 0, 1);
        nativeMac.update(new byte[]{b6}, 0, 1);
        nativeMac.update(bArr, 0, bArr.length);
    }

    public byte[] decrypt(byte[] bArr, e eVar) throws IOException {
        int length = bArr.length;
        InputStream cipherInputStream = getCipherInputStream(new ByteArrayInputStream(bArr), eVar);
        if (this.c.c == 0) {
            throw null;
        }
        p110t1.a aVar = new p110t1.a(length - 30);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i5 = cipherInputStream.read(bArr2);
            if (i5 == -1) {
                cipherInputStream.close();
                return aVar.getBytes();
            }
            aVar.write(bArr2, 0, i5);
        }
    }

    public byte[] encrypt(byte[] bArr, e eVar) throws IOException {
        int length = bArr.length;
        if (this.c.c == 0) {
            throw null;
        }
        p110t1.a aVar = new p110t1.a(length + 30);
        OutputStream cipherOutputStream = getCipherOutputStream(aVar, eVar, null);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return aVar.getBytes();
    }

    public InputStream getCipherInputStream(InputStream inputStream, e eVar) {
        return this.c.wrap(inputStream, eVar);
    }

    public OutputStream getCipherOutputStream(OutputStream outputStream, e eVar) {
        return getCipherOutputStream(outputStream, eVar, null);
    }

    public InputStream getMacInputStream(InputStream inputStream, e eVar) throws IOException {
        byte b = (byte) inputStream.read();
        p115u1.a.checkArgumentForIO(b == 1, "Unexpected mac version " + ((int) b));
        byte b6 = (byte) inputStream.read();
        p115u1.a.checkArgumentForIO(b6 == 1, "Unexpected mac ID " + ((int) b6));
        NativeMac nativeMac = new NativeMac(this.b);
        byte[] macKey = this.f6437a.getMacKey();
        nativeMac.init(macKey, macKey.length);
        computeMacAad(nativeMac, b, (byte) 1, eVar.f6439a);
        return new d(nativeMac, inputStream);
    }

    public OutputStream getMacOutputStream(OutputStream outputStream, e eVar) throws IOException {
        outputStream.write(1);
        outputStream.write(1);
        NativeMac nativeMac = new NativeMac(this.b);
        byte[] macKey = this.f6437a.getMacKey();
        nativeMac.init(macKey, macKey.length);
        computeMacAad(nativeMac, (byte) 1, (byte) 1, eVar.f6439a);
        return new e(nativeMac, outputStream);
    }

    public b(a aVar, p115u1.b bVar, int i5) {
        a aVar2 = new a(aVar, i5);
        this.f6437a = aVar2;
        this.b = bVar;
        this.c = new d(bVar, aVar2, i5);
    }

    public OutputStream getCipherOutputStream(OutputStream outputStream, e eVar, byte[] bArr) {
        return this.c.wrap(outputStream, eVar, bArr);
    }
}
