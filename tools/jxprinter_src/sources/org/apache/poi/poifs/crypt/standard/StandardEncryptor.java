package org.apache.poi.poifs.crypt.standard;

import M1.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.poifs.filesystem.POIFSWriterListener;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutputStream;
import org.apache.poi.util.RandomSingleton;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StandardEncryptor extends Encryptor {
    private static final Logger LOG = LogManager.getLogger((Class<?>) StandardEncryptor.class);

    public StandardEncryptor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cipher getCipher(SecretKey secretKey, String str) {
        EncryptionVerifier verifier = getEncryptionInfo().getVerifier();
        return CryptoFunctions.getCipher(secretKey, verifier.getCipherAlgorithm(), verifier.getChainingMode(), null, 1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createEncryptionInfoEntry$0(EncryptionInfo encryptionInfo, StandardEncryptionHeader standardEncryptionHeader, StandardEncryptionVerifier standardEncryptionVerifier, LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
        littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
        littleEndianByteArrayOutputStream.writeInt(encryptionInfo.getEncryptionFlags());
        standardEncryptionHeader.write(littleEndianByteArrayOutputStream);
        standardEncryptionVerifier.write(littleEndianByteArrayOutputStream);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        SecureRandom randomSingleton = RandomSingleton.getInstance();
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        randomSingleton.nextBytes(bArr);
        randomSingleton.nextBytes(bArr2);
        confirmPassword(str, null, null, bArr, bArr2, null);
    }

    public void createEncryptionInfoEntry(DirectoryNode directoryNode) {
        EncryptionInfo encryptionInfo = getEncryptionInfo();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, EncryptionInfo.ENCRYPTION_INFO_ENTRY, new b(encryptionInfo, 5, (StandardEncryptionHeader) encryptionInfo.getHeader(), (StandardEncryptionVerifier) encryptionInfo.getVerifier()));
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) {
        createEncryptionInfoEntry(directoryNode);
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        return new StandardCipherOutputStream(this, directoryNode);
    }

    public int getKeySizeInBytes() {
        return getEncryptionInfo().getHeader().getKeySize() / 8;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class StandardCipherOutputStream extends FilterOutputStream implements POIFSWriterListener {
        protected long countBytes;
        protected final boolean deleteFile;
        protected final DirectoryNode dir;
        protected final File fileOut;

        private StandardCipherOutputStream(DirectoryNode directoryNode, File file, boolean z6) {
            super(new CipherOutputStream(new FileOutputStream(file), StandardEncryptor.this.getCipher(StandardEncryptor.this.getSecretKey(), "PKCS5Padding")));
            this.deleteFile = z6;
            this.fileOut = file;
            this.dir = directoryNode;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            File file;
            super.close();
            writeToPOIFS();
            if (!this.deleteFile || (file = this.fileOut) == null) {
                return;
            }
            file.delete();
        }

        @Override // org.apache.poi.poifs.filesystem.POIFSWriterListener
        public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
            try {
                LittleEndianOutputStream littleEndianOutputStream = new LittleEndianOutputStream(pOIFSWriterEvent.getStream());
                littleEndianOutputStream.writeLong(this.countBytes);
                FileInputStream fileInputStream = new FileInputStream(this.fileOut);
                try {
                    IOUtils.copy(fileInputStream, littleEndianOutputStream);
                    fileInputStream.close();
                    if (!this.fileOut.delete()) {
                        StandardEncryptor.LOG.atError().log("Can't delete temporary encryption file: {}", this.fileOut);
                    }
                    littleEndianOutputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e) {
                throw new EncryptedDocumentException(e);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) throws IOException {
            ((FilterOutputStream) this).out.write(bArr, i5, i6);
            this.countBytes += (long) i6;
        }

        public void writeToPOIFS() {
            this.dir.createDocument(Decryptor.DEFAULT_POIFS_ENTRY, (int) (this.fileOut.length() + 8), this);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i5) throws IOException {
            ((FilterOutputStream) this).out.write(i5);
            this.countBytes++;
        }

        public StandardCipherOutputStream(StandardEncryptor standardEncryptor, DirectoryNode directoryNode) {
            this(directoryNode, TempFile.createTempFile("encrypted_package", "crypt"), true);
        }
    }

    public StandardEncryptor(StandardEncryptor standardEncryptor) {
        super(standardEncryptor);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public StandardEncryptor copy() {
        return new StandardEncryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        StandardEncryptionVerifier standardEncryptionVerifier = (StandardEncryptionVerifier) getEncryptionInfo().getVerifier();
        standardEncryptionVerifier.setSalt(bArr4);
        SecretKey secretKeyGenerateSecretKey = StandardDecryptor.generateSecretKey(str, standardEncryptionVerifier, getKeySizeInBytes());
        setSecretKey(secretKeyGenerateSecretKey);
        Cipher cipher = getCipher(secretKeyGenerateSecretKey, null);
        try {
            byte[] bArrDoFinal = cipher.doFinal(bArr3);
            byte[] bArrDoFinal2 = cipher.doFinal(Arrays.copyOf(CryptoFunctions.getMessageDigest(standardEncryptionVerifier.getHashAlgorithm()).digest(bArr3), standardEncryptionVerifier.getCipherAlgorithm().encryptedVerifierHashLength));
            standardEncryptionVerifier.setEncryptedVerifier(bArrDoFinal);
            standardEncryptionVerifier.setEncryptedVerifierHash(bArrDoFinal2);
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Password confirmation failed", e);
        }
    }
}
