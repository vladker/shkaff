package org.apache.poi.poifs.crypt;

import java.io.InputStream;
import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import l5.b2;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Decryptor implements GenericRecord {
    public static final String DEFAULT_PASSWORD = "VelvetSweatshop";
    public static final String DEFAULT_POIFS_ENTRY = "EncryptedPackage";
    protected EncryptionInfo encryptionInfo;
    private byte[] integrityHmacKey;
    private byte[] integrityHmacValue;
    private SecretKey secretKey;
    private byte[] verifier;

    public Decryptor() {
    }

    public static Decryptor getInstance(EncryptionInfo encryptionInfo) {
        Decryptor decryptor = encryptionInfo.getDecryptor();
        if (decryptor != null) {
            return decryptor;
        }
        throw new EncryptedDocumentException("Unsupported version");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getGenericProperties$0() {
        return null;
    }

    public abstract Decryptor copy();

    public int getBlockSizeInBytes() {
        return this.encryptionInfo.getHeader().getBlockSize();
    }

    public InputStream getDataStream(InputStream inputStream, int i5, int i6) {
        throw new EncryptedDocumentException("this decryptor doesn't support reading from a stream");
    }

    public abstract InputStream getDataStream(DirectoryNode directoryNode);

    public EncryptionInfo getEncryptionInfo() {
        return this.encryptionInfo;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        SecretKey secretKey = this.secretKey;
        Supplier aVar = secretKey == null ? new androidx.emoji2.text.flatbuffer.a(23) : new b2(secretKey, 10);
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.poifs.crypt.b
            public final /* synthetic */ Decryptor b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getVerifier();
                    case 1:
                        return this.b.getIntegrityHmacKey();
                    default:
                        return this.b.getIntegrityHmacValue();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.poifs.crypt.b
            public final /* synthetic */ Decryptor b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getVerifier();
                    case 1:
                        return this.b.getIntegrityHmacKey();
                    default:
                        return this.b.getIntegrityHmacValue();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("secretKey", aVar, "verifier", supplier, "integrityHmacKey", supplier2, "integrityHmacValue", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.b
            public final /* synthetic */ Decryptor b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.getVerifier();
                    case 1:
                        return this.b.getIntegrityHmacKey();
                    default:
                        return this.b.getIntegrityHmacValue();
                }
            }
        });
    }

    public byte[] getIntegrityHmacKey() {
        return this.integrityHmacKey;
    }

    public byte[] getIntegrityHmacValue() {
        return this.integrityHmacValue;
    }

    public int getKeySizeInBytes() {
        return this.encryptionInfo.getHeader().getKeySize() / 8;
    }

    public abstract long getLength();

    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    public byte[] getVerifier() {
        return this.verifier;
    }

    public Cipher initCipherForBlock(Cipher cipher, int i5) {
        throw new EncryptedDocumentException("this decryptor doesn't support initCipherForBlock");
    }

    public void setChunkSize(int i5) {
        throw new EncryptedDocumentException("this decryptor doesn't support changing the chunk size");
    }

    public void setEncryptionInfo(EncryptionInfo encryptionInfo) {
        this.encryptionInfo = encryptionInfo;
    }

    public void setIntegrityHmacKey(byte[] bArr) {
        this.integrityHmacKey = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setIntegrityHmacValue(byte[] bArr) {
        this.integrityHmacValue = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public void setVerifier(byte[] bArr) {
        this.verifier = bArr == null ? null : (byte[]) bArr.clone();
    }

    public abstract boolean verifyPassword(String str);

    public Decryptor(Decryptor decryptor) {
        this.encryptionInfo = decryptor.encryptionInfo;
        this.secretKey = decryptor.secretKey;
        byte[] bArr = decryptor.verifier;
        this.verifier = bArr == null ? null : (byte[]) bArr.clone();
        byte[] bArr2 = decryptor.integrityHmacKey;
        this.integrityHmacKey = bArr2 == null ? null : (byte[]) bArr2.clone();
        byte[] bArr3 = decryptor.integrityHmacValue;
        this.integrityHmacValue = bArr3 != null ? (byte[]) bArr3.clone() : null;
    }

    public InputStream getDataStream(POIFSFileSystem pOIFSFileSystem) {
        return getDataStream(pOIFSFileSystem.getRoot());
    }
}
