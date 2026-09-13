package com.orhanobut.hawk;

import android.content.Context;
import android.util.Base64;
import p075n1.a;
import p075n1.d;
import p081o1.b;
import p081o1.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class ConcealEncryption implements Encryption {
    private final b crypto;

    public ConcealEncryption(Context context) {
        a aVar;
        d dVar = new d(context, 2);
        synchronized (a.class) {
            try {
                if (a.c == null) {
                    a.c = new a(0);
                }
                aVar = a.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.crypto = new b(dVar, (p115u1.d) aVar.b, 2);
    }

    @Override // com.orhanobut.hawk.Encryption
    public String decrypt(String str, String str2) {
        byte[] bytes = str.getBytes(e.c);
        e eVar = new e();
        eVar.f6439a = bytes;
        return new String(this.crypto.decrypt(Base64.decode(str2, 2), eVar));
    }

    @Override // com.orhanobut.hawk.Encryption
    public String encrypt(String str, String str2) {
        byte[] bytes = str.getBytes(e.c);
        e eVar = new e();
        eVar.f6439a = bytes;
        return Base64.encodeToString(this.crypto.encrypt(str2.getBytes(), eVar), 2);
    }

    @Override // com.orhanobut.hawk.Encryption
    public boolean init() {
        b bVar = this.crypto;
        bVar.getClass();
        try {
            ((p115u1.d) bVar.b).ensureCryptoLoaded();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
