package org.apache.poi.poifs.crypt.standard;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CipherProvider;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StandardEncryptionHeader extends EncryptionHeader implements EncryptionRecord {
    public StandardEncryptionHeader(StandardEncryptionHeader standardEncryptionHeader) {
        super(standardEncryptionHeader);
    }

    @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
    public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        int writeIndex = littleEndianByteArrayOutputStream.getWriteIndex();
        LittleEndianOutput littleEndianOutputCreateDelayedOutput = littleEndianByteArrayOutputStream.createDelayedOutput(4);
        littleEndianByteArrayOutputStream.writeInt(getFlags());
        littleEndianByteArrayOutputStream.writeInt(0);
        littleEndianByteArrayOutputStream.writeInt(getCipherAlgorithm().ecmaId);
        littleEndianByteArrayOutputStream.writeInt(getHashAlgorithm().ecmaId);
        littleEndianByteArrayOutputStream.writeInt(getKeySize());
        littleEndianByteArrayOutputStream.writeInt(getCipherProvider().ecmaId);
        littleEndianByteArrayOutputStream.writeInt(0);
        littleEndianByteArrayOutputStream.writeInt(0);
        String cspName = getCspName();
        if (cspName == null) {
            cspName = getCipherProvider().cipherProviderName;
        }
        littleEndianByteArrayOutputStream.write(StringUtil.getToUnicodeLE(cspName));
        littleEndianByteArrayOutputStream.writeShort(0);
        littleEndianOutputCreateDelayedOutput.writeInt((littleEndianByteArrayOutputStream.getWriteIndex() - writeIndex) - 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StandardEncryptionHeader(LittleEndianInput littleEndianInput) throws IOException {
        setFlags(littleEndianInput.readInt());
        setSizeExtra(littleEndianInput.readInt());
        setCipherAlgorithm(CipherAlgorithm.fromEcmaId(littleEndianInput.readInt()));
        setHashAlgorithm(HashAlgorithm.fromEcmaId(littleEndianInput.readInt()));
        int i5 = littleEndianInput.readInt();
        setKeySize(i5 == 0 ? 40 : i5);
        setBlockSize(getKeySize());
        setCipherProvider(CipherProvider.fromEcmaId(littleEndianInput.readInt()));
        littleEndianInput.readLong();
        boolean z6 = littleEndianInput instanceof RecordInputStream;
        if (z6) {
            ((RecordInputStream) littleEndianInput).mark(5);
        } else {
            ((InputStream) littleEndianInput).mark(5);
        }
        int i6 = littleEndianInput.readInt();
        if (z6) {
            ((RecordInputStream) littleEndianInput).reset();
        } else {
            ((InputStream) littleEndianInput).reset();
        }
        if (i6 == 16) {
            setCspName("");
        } else {
            StringBuilder sb = new StringBuilder();
            while (true) {
                char c = (char) littleEndianInput.readShort();
                if (c == 0) {
                    break;
                } else {
                    sb.append(c);
                }
            }
            setCspName(sb.toString());
        }
        setChainingMode(ChainingMode.ecb);
        setKeySalt(null);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader, org.apache.poi.common.Duplicatable
    public StandardEncryptionHeader copy() {
        return new StandardEncryptionHeader(this);
    }

    public StandardEncryptionHeader(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        setCipherAlgorithm(cipherAlgorithm);
        setHashAlgorithm(hashAlgorithm);
        setKeySize(i5);
        setBlockSize(i6);
        setCipherProvider(cipherAlgorithm.provider);
        setFlags(EncryptionInfo.flagAES.setBoolean(0, cipherAlgorithm.provider == CipherProvider.aes) | EncryptionInfo.flagCryptoAPI.setBoolean(0, true));
    }
}
