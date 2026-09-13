package org.apache.poi.poifs.crypt.cryptoapi;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayInputStream;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class CryptoAPIDocumentInputStream extends ByteArrayInputStream {
    private Cipher cipher;
    private final CryptoAPIDecryptor decryptor;
    private byte[] oneByte;

    public CryptoAPIDocumentInputStream(CryptoAPIDecryptor cryptoAPIDecryptor, byte[] bArr) {
        super(bArr);
        this.oneByte = new byte[]{0};
        this.decryptor = cryptoAPIDecryptor;
        this.cipher = cryptoAPIDecryptor.initCipherForBlock(null, 0);
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream
    public synchronized int read() {
        int i5 = super.read();
        if (i5 == -1) {
            return -1;
        }
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) i5;
        try {
            this.cipher.update(bArr, 0, 1, bArr);
            return this.oneByte[0] & UnsignedBytes.MAX_VALUE;
        } catch (ShortBufferException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public void seek(int i5) {
        if (i5 > ((ByteArrayInputStream) this).count) {
            throw new ArrayIndexOutOfBoundsException(i5);
        }
        ((ByteArrayInputStream) this).pos = i5;
        ((ByteArrayInputStream) this).mark = i5;
    }

    public void setBlock(int i5) {
        this.cipher = this.decryptor.initCipherForBlock(this.cipher, i5);
    }

    @Override // java.io.ByteArrayInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i5, int i6) {
        int i7 = super.read(bArr, i5, i6);
        if (i7 == -1) {
            return -1;
        }
        try {
            this.cipher.update(bArr, i5, i7, bArr, i5);
            return i7;
        } catch (ShortBufferException e) {
            throw new EncryptedDocumentException(e);
        }
    }
}
