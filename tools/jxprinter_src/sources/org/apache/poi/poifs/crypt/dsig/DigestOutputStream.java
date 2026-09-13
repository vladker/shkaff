package org.apache.poi.poifs.crypt.dsig;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.PrivateKey;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class DigestOutputStream extends OutputStream {
    final HashAlgorithm algo;
    final PrivateKey key;
    private MessageDigest md;

    public DigestOutputStream(HashAlgorithm hashAlgorithm, PrivateKey privateKey) {
        this.algo = hashAlgorithm;
        this.key = privateKey;
    }

    public static boolean isMSCapi(PrivateKey privateKey) {
        return privateKey != null && privateKey.getClass().getName().contains("mscapi");
    }

    public byte[] getHashMagic() {
        try {
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            try {
                byte[] der = new Oid(this.algo.rsaOid).getDER();
                unsynchronizedByteArrayOutputStream.write(48);
                unsynchronizedByteArrayOutputStream.write(this.algo.hashSize + der.length + 6);
                unsynchronizedByteArrayOutputStream.write(48);
                unsynchronizedByteArrayOutputStream.write(der.length + 2);
                unsynchronizedByteArrayOutputStream.write(der);
                unsynchronizedByteArrayOutputStream.write(new byte[]{5, 0, 4});
                unsynchronizedByteArrayOutputStream.write(this.algo.hashSize);
                byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                unsynchronizedByteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        unsynchronizedByteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException | GSSException e) {
            throw new IllegalStateException(e);
        }
    }

    public void init() {
        if (!isMSCapi(this.key)) {
            this.md = CryptoFunctions.getMessageDigest(this.algo);
            return;
        }
        throw new EncryptedDocumentException("Windows keystore entries can't be signed with the " + this.algo + " hash. Please use one digest algorithm of sha1 / sha256 / sha384 / sha512.");
    }

    public byte[] sign() {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            unsynchronizedByteArrayOutputStream.write(getHashMagic());
            unsynchronizedByteArrayOutputStream.write(this.md.digest());
            byte[] bArrDoFinal = CryptoFunctions.getCipher(this.key, CipherAlgorithm.rsa, ChainingMode.ecb, null, 1, "PKCS1Padding").doFinal(unsynchronizedByteArrayOutputStream.toByteArray());
            unsynchronizedByteArrayOutputStream.close();
            return bArrDoFinal;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    unsynchronizedByteArrayOutputStream.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i5) {
        this.md.update((byte) i5);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        this.md.update(bArr, i5, i6);
    }
}
