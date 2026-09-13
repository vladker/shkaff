package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.InputStream;
import javax.crypto.Cipher;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class CryptoAPIDocumentOutputStream extends ByteArrayOutputStream {
    private final Cipher cipher;
    private final CryptoAPIEncryptor encryptor;
    private final byte[] oneByte = {0};

    public CryptoAPIDocumentOutputStream(CryptoAPIEncryptor cryptoAPIEncryptor) {
        this.encryptor = cryptoAPIEncryptor;
        this.cipher = cryptoAPIEncryptor.initCipherForBlock(null, 0);
    }

    public void setBlock(int i5) {
        this.encryptor.initCipherForBlock(this.cipher, i5);
    }

    public void setSize(int i5) {
        this.count = i5;
    }

    public InputStream toInputStream(long j6) {
        return new BoundedInputStream(toInputStream(), j6);
    }

    @Override // org.apache.commons.io.output.ByteArrayOutputStream, org.apache.commons.io.output.AbstractByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i5) {
        try {
            byte[] bArr = this.oneByte;
            bArr[0] = (byte) i5;
            this.cipher.update(bArr, 0, 1, bArr, 0);
            super.write(this.oneByte);
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.commons.io.output.ByteArrayOutputStream, org.apache.commons.io.output.AbstractByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i5, int i6) {
        try {
            this.cipher.update(bArr, i5, i6, bArr, i5);
            super.write(bArr, i5, i6);
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }
}
