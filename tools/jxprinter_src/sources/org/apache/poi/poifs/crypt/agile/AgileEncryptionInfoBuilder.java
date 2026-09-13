package org.apache.poi.poifs.crypt.agile;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AgileEncryptionInfoBuilder implements EncryptionInfoBuilder {
    public static EncryptionDocument parseDescriptor(String str) {
        return parseDescriptor(new InputSource(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) {
        EncryptionDocument descriptor = parseDescriptor((InputStream) littleEndianInput);
        encryptionInfo.setHeader(new AgileEncryptionHeader(descriptor));
        encryptionInfo.setVerifier(new AgileEncryptionVerifier(descriptor));
        int versionMajor = encryptionInfo.getVersionMajor();
        EncryptionMode encryptionMode = EncryptionMode.agile;
        if (versionMajor == encryptionMode.versionMajor && encryptionInfo.getVersionMinor() == encryptionMode.versionMinor) {
            AgileDecryptor agileDecryptor = new AgileDecryptor();
            agileDecryptor.setEncryptionInfo(encryptionInfo);
            encryptionInfo.setDecryptor(agileDecryptor);
            AgileEncryptor agileEncryptor = new AgileEncryptor();
            agileEncryptor.setEncryptionInfo(encryptionInfo);
            encryptionInfo.setEncryptor(agileEncryptor);
        }
    }

    public static EncryptionDocument parseDescriptor(InputStream inputStream) {
        return parseDescriptor(new InputSource(inputStream));
    }

    private static EncryptionDocument parseDescriptor(InputSource inputSource) {
        try {
            Document document = XMLHelper.newDocumentBuilder().parse(inputSource);
            EncryptionDocument encryptionDocument = new EncryptionDocument();
            encryptionDocument.parse(document);
            return encryptionDocument;
        } catch (IOException | SAXException e) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor", e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        if (cipherAlgorithm == null) {
            cipherAlgorithm = CipherAlgorithm.aes128;
        }
        CipherAlgorithm cipherAlgorithm2 = cipherAlgorithm;
        if (cipherAlgorithm2 != CipherAlgorithm.rc4) {
            if (hashAlgorithm == null) {
                hashAlgorithm = HashAlgorithm.sha1;
            }
            HashAlgorithm hashAlgorithm2 = hashAlgorithm;
            if (chainingMode == null) {
                chainingMode = ChainingMode.cbc;
            }
            ChainingMode chainingMode2 = chainingMode;
            if (chainingMode2 != ChainingMode.cbc && chainingMode2 != ChainingMode.cfb) {
                throw new EncryptedDocumentException("Agile encryption only supports CBC/CFB chaining.");
            }
            if (i5 == -1) {
                i5 = cipherAlgorithm2.defaultKeySize;
            }
            int i7 = i5;
            if (i6 == -1) {
                i6 = cipherAlgorithm2.blockSize;
            }
            int i8 = i6;
            boolean z6 = false;
            for (int i9 : cipherAlgorithm2.allowedKeySize) {
                z6 |= i9 == i7;
            }
            if (z6) {
                encryptionInfo.setHeader(new AgileEncryptionHeader(cipherAlgorithm2, hashAlgorithm2, i7, i8, chainingMode2));
                encryptionInfo.setVerifier(new AgileEncryptionVerifier(cipherAlgorithm2, hashAlgorithm2, i7, i8, chainingMode2));
                AgileDecryptor agileDecryptor = new AgileDecryptor();
                agileDecryptor.setEncryptionInfo(encryptionInfo);
                encryptionInfo.setDecryptor(agileDecryptor);
                AgileEncryptor agileEncryptor = new AgileEncryptor();
                agileEncryptor.setEncryptionInfo(encryptionInfo);
                encryptionInfo.setEncryptor(agileEncryptor);
                return;
            }
            throw new EncryptedDocumentException("KeySize " + i7 + " not allowed for Cipher " + cipherAlgorithm2);
        }
        throw new EncryptedDocumentException("RC4 must not be used with agile encryption.");
    }
}
