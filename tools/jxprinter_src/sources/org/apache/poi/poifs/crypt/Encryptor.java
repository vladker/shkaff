package org.apache.poi.poifs.crypt;

import java.io.OutputStream;
import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.SecretKey;
import l5.b2;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Encryptor implements GenericRecord {
    protected static final String DEFAULT_POIFS_ENTRY = "EncryptedPackage";
    private EncryptionInfo encryptionInfo;
    private SecretKey secretKey;

    public Encryptor() {
    }

    public static Encryptor getInstance(EncryptionInfo encryptionInfo) {
        return encryptionInfo.getEncryptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getGenericProperties$0() {
        return null;
    }

    public abstract void confirmPassword(String str);

    public abstract void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public abstract Encryptor copy();

    public abstract OutputStream getDataStream(DirectoryNode directoryNode);

    public OutputStream getDataStream(POIFSFileSystem pOIFSFileSystem) {
        return getDataStream(pOIFSFileSystem.getRoot());
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.encryptionInfo;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        SecretKey secretKey = this.secretKey;
        return GenericRecordUtil.getGenericProperties("secretKey", secretKey == null ? new androidx.emoji2.text.flatbuffer.a(29) : new b2(secretKey, 10));
    }

    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    public void setChunkSize(int i5) {
        throw new EncryptedDocumentException("this decryptor doesn't support changing the chunk size");
    }

    public void setEncryptionInfo(EncryptionInfo encryptionInfo) {
        this.encryptionInfo = encryptionInfo;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public Encryptor(Encryptor encryptor) {
        this.encryptionInfo = encryptor.encryptionInfo;
        this.secretKey = encryptor.secretKey;
    }

    public ChunkedCipherOutputStream getDataStream(OutputStream outputStream, int i5) {
        throw new EncryptedDocumentException("this decryptor doesn't support writing directly to a stream");
    }
}
