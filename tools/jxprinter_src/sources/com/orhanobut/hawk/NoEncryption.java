package com.orhanobut.hawk;

import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class NoEncryption implements Encryption {
    public byte[] decodeBase64(String str) {
        return Base64.decode(str, 0);
    }

    @Override // com.orhanobut.hawk.Encryption
    public String decrypt(String str, String str2) {
        return new String(decodeBase64(str2));
    }

    public String encodeBase64(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    @Override // com.orhanobut.hawk.Encryption
    public String encrypt(String str, String str2) {
        return encodeBase64(str2.getBytes());
    }

    @Override // com.orhanobut.hawk.Encryption
    public boolean init() {
        return true;
    }
}
