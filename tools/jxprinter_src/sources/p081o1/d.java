package p081o1;

import U4.g;
import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p110t1.c;
import p115u1.a;
import p115u1.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6438a;
    public final a b;
    public final int c;

    public d(b bVar, a aVar, int i5) {
        this.f6438a = bVar;
        this.b = aVar;
        this.c = i5;
    }

    private void computeCipherAad(NativeGCMCipher nativeGCMCipher, byte b, byte b6, byte[] bArr) throws g {
        nativeGCMCipher.updateAad(new byte[]{b}, 1);
        nativeGCMCipher.updateAad(new byte[]{b6}, 1);
        nativeGCMCipher.updateAad(bArr, bArr.length);
    }

    @Override // p081o1.c
    public OutputStream wrap(OutputStream outputStream, e eVar, byte[] bArr) throws IOException {
        outputStream.write(1);
        int i5 = this.c;
        outputStream.write(AbstractC1125a.a(i5));
        a aVar = this.b;
        byte[] newIV = aVar.getNewIV();
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.f6438a);
        nativeGCMCipher.encryptInit(aVar.getCipherKey(), newIV);
        outputStream.write(newIV);
        computeCipherAad(nativeGCMCipher, (byte) 1, AbstractC1125a.a(i5), eVar.f6439a);
        if (i5 != 0) {
            return new c(outputStream, nativeGCMCipher, bArr);
        }
        throw null;
    }

    @Override // p081o1.c
    public InputStream wrap(InputStream inputStream, e eVar) throws IOException {
        byte b = (byte) inputStream.read();
        byte b6 = (byte) inputStream.read();
        a.checkArgumentForIO(b == 1, "Unexpected crypto version " + ((int) b));
        int i5 = this.c;
        a.checkArgumentForIO(b6 == AbstractC1125a.a(i5), "Unexpected cipher ID " + ((int) b6));
        if (i5 != 0) {
            byte[] bArr = new byte[12];
            new DataInputStream(inputStream).readFully(bArr);
            NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.f6438a);
            nativeGCMCipher.decryptInit(this.b.getCipherKey(), bArr);
            computeCipherAad(nativeGCMCipher, b, b6, eVar.f6439a);
            if (i5 != 0) {
                return new p110t1.b(inputStream, nativeGCMCipher);
            }
            throw null;
        }
        throw null;
    }
}
