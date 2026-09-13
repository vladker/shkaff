package org.apache.poi.poifs.crypt.dsig;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class SignatureOutputStream extends DigestOutputStream {
    Signature signature;

    public SignatureOutputStream(HashAlgorithm hashAlgorithm, PrivateKey privateKey) {
        super(hashAlgorithm, privateKey);
    }

    @Override // org.apache.poi.poifs.crypt.dsig.DigestOutputStream
    public void init() throws InvalidKeyException {
        String str = DigestOutputStream.isMSCapi(this.key) ? "SunMSCAPI" : "SunRsaSign";
        if (Security.getProvider(str) != null) {
            this.signature = Signature.getInstance(this.algo.ecmaString + "withRSA", str);
        } else {
            this.signature = Signature.getInstance(this.algo.ecmaString + "withRSA");
        }
        this.signature.initSign(this.key);
    }

    @Override // org.apache.poi.poifs.crypt.dsig.DigestOutputStream
    public byte[] sign() {
        return this.signature.sign();
    }

    @Override // org.apache.poi.poifs.crypt.dsig.DigestOutputStream, java.io.OutputStream
    public void write(int i5) throws IOException {
        try {
            this.signature.update((byte) i5);
        } catch (SignatureException e) {
            throw new IOException(e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.dsig.DigestOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        try {
            this.signature.update(bArr, i5, i6);
        } catch (SignatureException e) {
            throw new IOException(e);
        }
    }
}
