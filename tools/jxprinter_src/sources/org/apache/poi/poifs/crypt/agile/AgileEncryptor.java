package org.apache.poi.poifs.crypt.agile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.RandomSingleton;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AgileEncryptor extends Encryptor {
    private byte[] integritySalt;
    private byte[] pwHash;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AgileCipherOutputStream extends ChunkedCipherOutputStream {
        public AgileCipherOutputStream(DirectoryNode directoryNode) {
            super(directoryNode, 4096);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void marshallEncryptionRecord(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            EncryptionInfo encryptionInfo = AgileEncryptor.this.getEncryptionInfo();
            littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
            littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
            littleEndianByteArrayOutputStream.writeInt(encryptionInfo.getEncryptionFlags());
            AgileEncryptor.this.marshallEncryptionDocument(AgileEncryptor.this.createEncryptionDocument(), littleEndianByteArrayOutputStream);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public void calculateChecksum(File file, int i5) throws InvalidKeyException, IOException {
            AgileEncryptor.this.updateIntegrityHMAC(file, i5);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) {
            DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
            DataSpaceMapUtils.createEncryptionEntry(directoryNode, EncryptionInfo.ENCRYPTION_INFO_ENTRY, new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.agile.b
                @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
                public final void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                    this.f7142a.marshallEncryptionRecord(littleEndianByteArrayOutputStream);
                }
            });
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public Cipher initCipherForBlock(Cipher cipher, int i5, boolean z6) {
            return AgileDecryptor.initCipherForBlock(cipher, i5, z6, AgileEncryptor.this.getEncryptionInfo(), AgileEncryptor.this.getSecretKey(), 1);
        }
    }

    public AgileEncryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        int blockSize = agileEncryptionHeader.getBlockSize();
        int keySize = agileEncryptionHeader.getKeySize() / 8;
        int i5 = agileEncryptionHeader.getHashAlgorithm().hashSize;
        int maxRecordLength = CryptoFunctions.getMaxRecordLength();
        long j6 = blockSize;
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(j6, maxRecordLength);
        byte[] bArrSafelyAllocate2 = IOUtils.safelyAllocate(j6, maxRecordLength);
        byte[] bArrSafelyAllocate3 = IOUtils.safelyAllocate(j6, maxRecordLength);
        byte[] bArrSafelyAllocate4 = IOUtils.safelyAllocate(keySize, maxRecordLength);
        byte[] bArrSafelyAllocate5 = IOUtils.safelyAllocate(i5, maxRecordLength);
        SecureRandom randomSingleton = RandomSingleton.getInstance();
        randomSingleton.nextBytes(bArrSafelyAllocate);
        randomSingleton.nextBytes(bArrSafelyAllocate2);
        randomSingleton.nextBytes(bArrSafelyAllocate3);
        randomSingleton.nextBytes(bArrSafelyAllocate4);
        randomSingleton.nextBytes(bArrSafelyAllocate5);
        confirmPassword(str, bArrSafelyAllocate4, bArrSafelyAllocate3, bArrSafelyAllocate, bArrSafelyAllocate2, bArrSafelyAllocate5);
    }

    public EncryptionDocument createEncryptionDocument() {
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) getEncryptionInfo().getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        EncryptionDocument encryptionDocument = new EncryptionDocument();
        KeyData keyData = new KeyData();
        encryptionDocument.setKeyData(keyData);
        KeyEncryptor keyEncryptor = new KeyEncryptor();
        encryptionDocument.getKeyEncryptors().add(keyEncryptor);
        PasswordKeyEncryptor passwordKeyEncryptor = new PasswordKeyEncryptor();
        keyEncryptor.setPasswordKeyEncryptor(passwordKeyEncryptor);
        passwordKeyEncryptor.setSpinCount(Integer.valueOf(agileEncryptionVerifier.getSpinCount()));
        keyData.setSaltSize(Integer.valueOf(agileEncryptionHeader.getBlockSize()));
        passwordKeyEncryptor.setSaltSize(Integer.valueOf(agileEncryptionVerifier.getBlockSize()));
        keyData.setBlockSize(Integer.valueOf(agileEncryptionHeader.getBlockSize()));
        passwordKeyEncryptor.setBlockSize(Integer.valueOf(agileEncryptionVerifier.getBlockSize()));
        keyData.setKeyBits(Integer.valueOf(agileEncryptionHeader.getKeySize()));
        passwordKeyEncryptor.setKeyBits(Integer.valueOf(agileEncryptionVerifier.getKeySize()));
        keyData.setHashSize(Integer.valueOf(agileEncryptionHeader.getHashAlgorithm().hashSize));
        passwordKeyEncryptor.setHashSize(Integer.valueOf(agileEncryptionVerifier.getHashAlgorithm().hashSize));
        if (!agileEncryptionHeader.getCipherAlgorithm().xmlId.equals(agileEncryptionVerifier.getCipherAlgorithm().xmlId)) {
            throw new EncryptedDocumentException("Cipher algorithm of header and verifier have to match");
        }
        keyData.setCipherAlgorithm(agileEncryptionHeader.getCipherAlgorithm());
        passwordKeyEncryptor.setCipherAlgorithm(agileEncryptionHeader.getCipherAlgorithm());
        keyData.setCipherChaining(agileEncryptionHeader.getChainingMode());
        passwordKeyEncryptor.setCipherChaining(agileEncryptionHeader.getChainingMode());
        keyData.setHashAlgorithm(agileEncryptionHeader.getHashAlgorithm());
        passwordKeyEncryptor.setHashAlgorithm(agileEncryptionVerifier.getHashAlgorithm());
        keyData.setSaltValue(agileEncryptionHeader.getKeySalt());
        passwordKeyEncryptor.setSaltValue(agileEncryptionVerifier.getSalt());
        passwordKeyEncryptor.setEncryptedVerifierHashInput(agileEncryptionVerifier.getEncryptedVerifier());
        passwordKeyEncryptor.setEncryptedVerifierHashValue(agileEncryptionVerifier.getEncryptedVerifierHash());
        passwordKeyEncryptor.setEncryptedKeyValue(agileEncryptionVerifier.getEncryptedKey());
        DataIntegrity dataIntegrity = new DataIntegrity();
        encryptionDocument.setDataIntegrity(dataIntegrity);
        dataIntegrity.setEncryptedHmacKey(agileEncryptionHeader.getEncryptedHmacKey());
        dataIntegrity.setEncryptedHmacValue(agileEncryptionHeader.getEncryptedHmacValue());
        return encryptionDocument;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) {
        return new AgileCipherOutputStream(directoryNode);
    }

    public void marshallEncryptionDocument(EncryptionDocument encryptionDocument, LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        Document documentNewDocument = XMLHelper.newDocumentBuilder().newDocument();
        encryptionDocument.write(documentNewDocument);
        try {
            Transformer transformerNewTransformer = XMLHelper.newTransformer();
            transformerNewTransformer.setOutputProperty("method", "xml");
            transformerNewTransformer.setOutputProperty("encoding", "UTF-8");
            transformerNewTransformer.setOutputProperty("indent", "no");
            transformerNewTransformer.setOutputProperty("standalone", "yes");
            transformerNewTransformer.transform(new DOMSource(documentNewDocument), new StreamResult(littleEndianByteArrayOutputStream));
        } catch (TransformerException e) {
            throw new EncryptedDocumentException("error marshalling encryption info document", e);
        }
    }

    public void updateIntegrityHMAC(File file, int i5) throws InvalidKeyException, IOException {
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        int blockSize = agileEncryptionHeader.getBlockSize();
        HashAlgorithm hashAlgorithm = agileEncryptionHeader.getHashAlgorithm();
        Mac mac = CryptoFunctions.getMac(hashAlgorithm);
        byte[] bArr = this.integritySalt;
        mac.init(new SecretKeySpec(CryptoFunctions.getBlock0(bArr, AgileDecryptor.getNextBlockSize(bArr.length, blockSize)), hashAlgorithm.jceHmacId));
        byte[] bArr2 = new byte[1024];
        LittleEndian.putLong(bArr2, 0, i5);
        mac.update(bArr2, 0, 8);
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i6 = fileInputStream.read(bArr2);
                if (i6 == -1) {
                    fileInputStream.close();
                    byte[] bArrDoFinal = mac.doFinal();
                    agileEncryptionHeader.setEncryptedHmacValue(CryptoFunctions.getCipher(getSecretKey(), agileEncryptionHeader.getCipherAlgorithm(), agileEncryptionHeader.getChainingMode(), CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithm(), agileEncryptionHeader.getKeySalt(), AgileDecryptor.kIntegrityValueBlock, blockSize), 1).doFinal(CryptoFunctions.getBlock0(bArrDoFinal, AgileDecryptor.getNextBlockSize(bArrDoFinal.length, blockSize))));
                    return;
                }
                mac.update(bArr2, 0, i6);
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
        }
    }

    public AgileEncryptor(AgileEncryptor agileEncryptor) {
        super(agileEncryptor);
        byte[] bArr = agileEncryptor.integritySalt;
        this.integritySalt = bArr == null ? null : (byte[]) bArr.clone();
        byte[] bArr2 = agileEncryptor.pwHash;
        this.pwHash = bArr2 != null ? (byte[]) bArr2.clone() : null;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public AgileEncryptor copy() {
        return new AgileEncryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) getEncryptionInfo().getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        agileEncryptionVerifier.setSalt(bArr4);
        agileEncryptionHeader.setKeySalt(bArr2);
        int blockSize = agileEncryptionHeader.getBlockSize();
        byte[] bArrHashPassword = CryptoFunctions.hashPassword(str, agileEncryptionVerifier.getHashAlgorithm(), bArr4, agileEncryptionVerifier.getSpinCount());
        this.pwHash = bArrHashPassword;
        agileEncryptionVerifier.setEncryptedVerifier(AgileDecryptor.hashInput(agileEncryptionVerifier, bArrHashPassword, AgileDecryptor.kVerifierInputBlock, bArr3, 1));
        agileEncryptionVerifier.setEncryptedVerifierHash(AgileDecryptor.hashInput(agileEncryptionVerifier, this.pwHash, AgileDecryptor.kHashedVerifierBlock, CryptoFunctions.getMessageDigest(agileEncryptionVerifier.getHashAlgorithm()).digest(bArr3), 1));
        agileEncryptionVerifier.setEncryptedKey(AgileDecryptor.hashInput(agileEncryptionVerifier, this.pwHash, AgileDecryptor.kCryptoKeyBlock, bArr, 1));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, agileEncryptionHeader.getCipherAlgorithm().jceId);
        setSecretKey(secretKeySpec);
        this.integritySalt = (byte[]) bArr5.clone();
        try {
            Cipher cipher = CryptoFunctions.getCipher(secretKeySpec, agileEncryptionHeader.getCipherAlgorithm(), agileEncryptionHeader.getChainingMode(), CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithm(), agileEncryptionHeader.getKeySalt(), AgileDecryptor.kIntegrityKeyBlock, agileEncryptionHeader.getBlockSize()), 1);
            byte[] bArr6 = this.integritySalt;
            agileEncryptionHeader.setEncryptedHmacKey(cipher.doFinal(CryptoFunctions.getBlock0(bArr6, AgileDecryptor.getNextBlockSize(bArr6.length, blockSize))));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }
}
