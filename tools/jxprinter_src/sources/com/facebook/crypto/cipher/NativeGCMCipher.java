package com.facebook.crypto.cipher;

import A3.AbstractC0157z;
import U4.g;
import p104s1.a;
import p115u1.b;
import p115u1.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@a
public class NativeGCMCipher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3255a = 1;
    public final b b;

    @a
    private long mCtxPtr;

    public NativeGCMCipher(b bVar) {
        this.b = bVar;
    }

    private native int nativeDecryptFinal(byte[] bArr, int i5);

    private native int nativeDecryptInit(byte[] bArr, byte[] bArr2);

    private native int nativeDestroy();

    private native int nativeEncryptFinal(byte[] bArr, int i5);

    private native int nativeEncryptInit(byte[] bArr, byte[] bArr2);

    private static native int nativeFailure();

    private native int nativeGetCipherBlockSize();

    private native int nativeUpdate(byte[] bArr, int i5, int i6, byte[] bArr2, int i7);

    private native int nativeUpdateAad(byte[] bArr, int i5);

    public final void a() {
        int i5 = this.f3255a;
        p115u1.a.a(i5 == 3 || i5 == 2, "Cipher has not been initialized");
    }

    public final int b() {
        a();
        return nativeGetCipherBlockSize();
    }

    public void decryptFinal(byte[] bArr, int i5) throws g {
        p115u1.a.a(this.f3255a == 3, "Cipher has not been initialized");
        this.f3255a = 5;
        if (nativeDecryptFinal(bArr, i5) == nativeFailure()) {
            throw new g("The message could not be decrypted successfully.It has either been tampered with or the wrong resource is being decrypted.");
        }
    }

    public void decryptInit(byte[] bArr, byte[] bArr2) throws g {
        p115u1.a.a(this.f3255a == 1, "Cipher has already been initialized");
        ((d) this.b).ensureCryptoLoaded();
        if (nativeDecryptInit(bArr, bArr2) == nativeFailure()) {
            throw new g("decryptInit");
        }
        this.f3255a = 3;
    }

    public void destroy() throws g {
        int i5 = this.f3255a;
        p115u1.a.a(i5 == 5 || i5 == 4, "Cipher has not been finalized");
        if (nativeDestroy() == nativeFailure()) {
            throw new g("destroy");
        }
        this.f3255a = 1;
    }

    public void encryptFinal(byte[] bArr, int i5) throws g {
        p115u1.a.a(this.f3255a == 2, "Cipher has not been initialized");
        this.f3255a = 4;
        if (nativeEncryptFinal(bArr, i5) == nativeFailure()) {
            throw new g(AbstractC0157z.k(i5, "encryptFinal: "));
        }
    }

    public void encryptInit(byte[] bArr, byte[] bArr2) throws g {
        p115u1.a.a(this.f3255a == 1, "Cipher has already been initialized");
        ((d) this.b).ensureCryptoLoaded();
        if (nativeEncryptInit(bArr, bArr2) == nativeFailure()) {
            throw new g("encryptInit");
        }
        this.f3255a = 2;
    }

    public int update(byte[] bArr, int i5, int i6, byte[] bArr2, int i7) throws g {
        a();
        int iNativeUpdate = nativeUpdate(bArr, i5, i6, bArr2, i7);
        if (iNativeUpdate >= 0) {
            return iNativeUpdate;
        }
        StringBuilder sbS = androidx.collection.a.s("update: Offset = ", i5, i6, "; DataLen = ", "; Result = ");
        sbS.append(iNativeUpdate);
        throw new g(sbS.toString());
    }

    public void updateAad(byte[] bArr, int i5) throws g {
        a();
        if (nativeUpdateAad(bArr, i5) < 0) {
            throw new g(AbstractC0157z.k(i5, "updateAAd: DataLen = "));
        }
    }
}
