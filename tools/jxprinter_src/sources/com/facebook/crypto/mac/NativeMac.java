package com.facebook.crypto.mac;

import java.io.IOException;
import p104s1.a;
import p115u1.b;
import p115u1.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@a
public class NativeMac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3256a = 1;
    public final b b;

    @a
    private long mCtxPtr;

    public NativeMac(b bVar) {
        this.b = bVar;
    }

    private native int nativeDestroy();

    private native byte[] nativeDoFinal();

    private static native int nativeFailure();

    private native int nativeGetMacLength();

    private native int nativeInit(byte[] bArr, int i5);

    private native int nativeUpdate(byte b);

    private native int nativeUpdate(byte[] bArr, int i5, int i6);

    public final int a() {
        return nativeGetMacLength();
    }

    public void destroy() throws IOException {
        p115u1.a.a(this.f3256a == 3, "Mac has not been finalized");
        if (nativeDestroy() == nativeFailure()) {
            throw new IOException("Failure");
        }
        this.f3256a = 1;
    }

    public byte[] doFinal() throws IOException {
        p115u1.a.a(this.f3256a == 2, "Mac has not been initialized");
        this.f3256a = 3;
        byte[] bArrNativeDoFinal = nativeDoFinal();
        if (bArrNativeDoFinal != null) {
            return bArrNativeDoFinal;
        }
        throw new IOException("Failure");
    }

    public void init(byte[] bArr, int i5) throws IOException {
        p115u1.a.a(this.f3256a == 1, "Mac has already been initialized");
        ((d) this.b).ensureCryptoLoaded();
        if (nativeInit(bArr, i5) == nativeFailure()) {
            throw new IOException("Failure");
        }
        this.f3256a = 2;
    }

    public void update(byte b) throws IOException {
        p115u1.a.a(this.f3256a == 2, "Mac has not been initialized");
        if (nativeUpdate(b) == nativeFailure()) {
            throw new IOException("Failure");
        }
    }

    public void update(byte[] bArr, int i5, int i6) throws IOException {
        p115u1.a.a(this.f3256a == 2, "Mac has not been initialized");
        if (nativeUpdate(bArr, i5, i6) == nativeFailure()) {
            throw new IOException("Failure");
        }
    }
}
