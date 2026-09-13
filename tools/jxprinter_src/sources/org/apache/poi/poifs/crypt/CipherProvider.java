package org.apache.poi.poifs.crypt;

import org.apache.poi.EncryptedDocumentException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum CipherProvider {
    rc4("RC4", 1, "Microsoft Base Cryptographic Provider v1.0"),
    aes("AES", 24, "Microsoft Enhanced RSA and AES Cryptographic Provider");

    public final String cipherProviderName;
    public final int ecmaId;
    public final String jceId;

    CipherProvider(String str, int i5, String str2) {
        this.jceId = str;
        this.ecmaId = i5;
        this.cipherProviderName = str2;
    }

    public static CipherProvider fromEcmaId(int i5) {
        for (CipherProvider cipherProvider : values()) {
            if (cipherProvider.ecmaId == i5) {
                return cipherProvider;
            }
        }
        throw new EncryptedDocumentException("cipher provider not found");
    }
}
