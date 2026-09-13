package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CryptoAPIDecryptor extends Decryptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int chunkSize;
    private long length;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class CryptoAPICipherInputStream extends ChunkedCipherInputStream {
        public CryptoAPICipherInputStream(InputStream inputStream, long j6, int i5) {
            super(inputStream, j6, CryptoAPIDecryptor.this.chunkSize, i5);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public Cipher initCipherForBlock(Cipher cipher, int i5) {
            return CryptoAPIDecryptor.this.initCipherForBlock(cipher, i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StreamDescriptorEntry {
        static final BitField flagStream = BitFieldFactory.getInstance(1);
        int block;
        int flags;
        int reserved2;
        String streamName;
        int streamOffset;
        int streamSize;
    }

    public CryptoAPIDecryptor() {
        this.length = -1L;
        this.chunkSize = -1;
    }

    public static SecretKey generateSecretKey(String str, EncryptionVerifier encryptionVerifier) {
        if (str.length() > 255) {
            str = str.substring(0, 255);
        }
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(encryptionVerifier.getHashAlgorithm());
        messageDigest.update(encryptionVerifier.getSalt());
        return new SecretKeySpec(messageDigest.digest(StringUtil.getToUnicodeLE(str)), encryptionVerifier.getCipherAlgorithm().jceId);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public long getLength() {
        long j6 = this.length;
        if (j6 != -1) {
            return j6;
        }
        throw new IllegalStateException("Decryptor.getDataStream() was not called");
    }

    public POIFSFileSystem getSummaryEntries(DirectoryNode directoryNode, String str) throws GeneralSecurityException, IOException {
        POIFSFileSystem pOIFSFileSystem;
        Throwable th;
        POIFSFileSystem pOIFSFileSystem2 = null;
        try {
            DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(directoryNode.getEntry(str));
            try {
                try {
                    CryptoAPIDocumentInputStream cryptoAPIDocumentInputStream = new CryptoAPIDocumentInputStream(this, IOUtils.toByteArray(documentInputStreamCreateDocumentInputStream));
                    try {
                        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(cryptoAPIDocumentInputStream);
                        try {
                            int uInt = (int) littleEndianInputStream.readUInt();
                            littleEndianInputStream.readUInt();
                            long j6 = ((long) uInt) - 8;
                            if (cryptoAPIDocumentInputStream.skip(j6) < j6) {
                                throw new EOFException("buffer underrun");
                            }
                            cryptoAPIDocumentInputStream.setBlock(0);
                            int uInt2 = (int) littleEndianInputStream.readUInt();
                            StreamDescriptorEntry[] streamDescriptorEntryArr = new StreamDescriptorEntry[uInt2];
                            for (int i5 = 0; i5 < uInt2; i5++) {
                                StreamDescriptorEntry streamDescriptorEntry = new StreamDescriptorEntry();
                                streamDescriptorEntryArr[i5] = streamDescriptorEntry;
                                streamDescriptorEntry.streamOffset = (int) littleEndianInputStream.readUInt();
                                streamDescriptorEntry.streamSize = (int) littleEndianInputStream.readUInt();
                                streamDescriptorEntry.block = littleEndianInputStream.readUShort();
                                int uByte = littleEndianInputStream.readUByte();
                                streamDescriptorEntry.flags = littleEndianInputStream.readUByte();
                                streamDescriptorEntry.reserved2 = littleEndianInputStream.readInt();
                                streamDescriptorEntry.streamName = StringUtil.readUnicodeLE(littleEndianInputStream, uByte);
                                littleEndianInputStream.readShort();
                            }
                            pOIFSFileSystem = new POIFSFileSystem();
                            for (int i6 = 0; i6 < uInt2; i6++) {
                                try {
                                    StreamDescriptorEntry streamDescriptorEntry2 = streamDescriptorEntryArr[i6];
                                    cryptoAPIDocumentInputStream.seek(streamDescriptorEntry2.streamOffset);
                                    cryptoAPIDocumentInputStream.setBlock(streamDescriptorEntry2.block);
                                    BoundedInputStream boundedInputStream = new BoundedInputStream(cryptoAPIDocumentInputStream, streamDescriptorEntry2.streamSize);
                                    try {
                                        pOIFSFileSystem.createDocument(boundedInputStream, streamDescriptorEntry2.streamName);
                                        boundedInputStream.close();
                                    } catch (Throwable th2) {
                                        try {
                                            throw th2;
                                        } catch (Throwable th3) {
                                            try {
                                                boundedInputStream.close();
                                            } catch (Throwable th4) {
                                                th2.addSuppressed(th4);
                                            }
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    pOIFSFileSystem2 = pOIFSFileSystem;
                                    try {
                                        throw th;
                                    } catch (Throwable th6) {
                                        try {
                                            littleEndianInputStream.close();
                                        } catch (Throwable th7) {
                                            th.addSuppressed(th7);
                                        }
                                        throw th6;
                                    }
                                }
                            }
                            try {
                                littleEndianInputStream.close();
                                cryptoAPIDocumentInputStream.close();
                                if (documentInputStreamCreateDocumentInputStream == null) {
                                    return pOIFSFileSystem;
                                }
                                try {
                                    documentInputStreamCreateDocumentInputStream.close();
                                    return pOIFSFileSystem;
                                } catch (Exception e) {
                                    e = e;
                                    pOIFSFileSystem2 = pOIFSFileSystem;
                                    IOUtils.closeQuietly(pOIFSFileSystem2);
                                    if (e instanceof GeneralSecurityException) {
                                        throw ((GeneralSecurityException) e);
                                    }
                                    if (e instanceof IOException) {
                                        throw ((IOException) e);
                                    }
                                    throw new IOException("summary entries can't be read", e);
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                try {
                                    throw th;
                                } catch (Throwable th9) {
                                    try {
                                        cryptoAPIDocumentInputStream.close();
                                    } catch (Throwable th10) {
                                        th.addSuppressed(th10);
                                    }
                                    throw th9;
                                }
                            }
                        } catch (Throwable th11) {
                            th = th11;
                        }
                    } catch (Throwable th12) {
                        pOIFSFileSystem = pOIFSFileSystem2;
                        th = th12;
                        throw th;
                    }
                } catch (Throwable th13) {
                    th = th13;
                    pOIFSFileSystem2 = pOIFSFileSystem;
                    try {
                        throw th;
                    } catch (Throwable th14) {
                        if (documentInputStreamCreateDocumentInputStream != null) {
                            try {
                                documentInputStreamCreateDocumentInputStream.close();
                            } catch (Throwable th15) {
                                th.addSuppressed(th15);
                            }
                        }
                        throw th14;
                    }
                }
            } catch (Throwable th16) {
                th = th16;
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public Cipher initCipherForBlock(Cipher cipher, int i5) {
        return initCipherForBlock(cipher, i5, getEncryptionInfo(), getSecretKey(), 2);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public void setChunkSize(int i5) {
        this.chunkSize = i5;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) {
        EncryptionVerifier verifier = getEncryptionInfo().getVerifier();
        SecretKey secretKeyGenerateSecretKey = generateSecretKey(str, verifier);
        try {
            Cipher cipherInitCipherForBlock = initCipherForBlock(null, 0, getEncryptionInfo(), secretKeyGenerateSecretKey, 2);
            byte[] encryptedVerifier = verifier.getEncryptedVerifier();
            byte[] bArr = new byte[encryptedVerifier.length];
            cipherInitCipherForBlock.update(encryptedVerifier, 0, encryptedVerifier.length, bArr);
            setVerifier(bArr);
            if (!Arrays.equals(CryptoFunctions.getMessageDigest(verifier.getHashAlgorithm()).digest(bArr), cipherInitCipherForBlock.doFinal(verifier.getEncryptedVerifierHash()))) {
                return false;
            }
            setSecretKey(secretKeyGenerateSecretKey);
            return true;
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public CryptoAPIDecryptor copy() {
        return new CryptoAPIDecryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode directoryNode) throws IOException {
        throw new IOException("not supported");
    }

    public CryptoAPIDecryptor(CryptoAPIDecryptor cryptoAPIDecryptor) {
        super(cryptoAPIDecryptor);
        this.length = -1L;
        this.chunkSize = -1;
        this.length = cryptoAPIDecryptor.length;
        this.chunkSize = cryptoAPIDecryptor.chunkSize;
    }

    public static Cipher initCipherForBlock(Cipher cipher, int i5, EncryptionInfo encryptionInfo, SecretKey secretKey, int i6) throws InvalidKeyException {
        HashAlgorithm hashAlgorithm = encryptionInfo.getVerifier().getHashAlgorithm();
        byte[] bArr = new byte[4];
        LittleEndian.putUInt(bArr, 0, i5);
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
        messageDigest.update(secretKey.getEncoded());
        byte[] bArrDigest = messageDigest.digest(bArr);
        EncryptionHeader header = encryptionInfo.getHeader();
        int keySize = header.getKeySize();
        byte[] block0 = CryptoFunctions.getBlock0(bArrDigest, keySize / 8);
        if (keySize == 40) {
            block0 = CryptoFunctions.getBlock0(block0, 16);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(block0, secretKey.getAlgorithm());
        if (cipher == null) {
            return CryptoFunctions.getCipher(secretKeySpec, header.getCipherAlgorithm(), null, null, i6);
        }
        cipher.init(i6, secretKeySpec);
        return cipher;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(InputStream inputStream, int i5, int i6) {
        return new CryptoAPICipherInputStream(inputStream, i5, i6);
    }
}
