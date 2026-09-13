package org.apache.poi.hssf.record;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionHeader;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionVerifier;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionHeader;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionVerifier;
import org.apache.poi.poifs.crypt.xor.XOREncryptionHeader;
import org.apache.poi.poifs.crypt.xor.XOREncryptionVerifier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.LittleEndianOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FilePassRecord extends StandardRecord {
    private static final int ENCRYPTION_OTHER = 1;
    private static final int ENCRYPTION_XOR = 0;
    public static final short sid = 47;
    private final EncryptionInfo encryptionInfo;
    private final int encryptionType;

    /* JADX INFO: renamed from: org.apache.poi.hssf.record.FilePassRecord$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode;

        static {
            int[] iArr = new int[EncryptionMode.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode = iArr;
            try {
                iArr[EncryptionMode.xor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[EncryptionMode.binaryRC4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[EncryptionMode.cryptoAPI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private FilePassRecord(FilePassRecord filePassRecord) {
        super(filePassRecord);
        this.encryptionType = filePassRecord.encryptionType;
        this.encryptionInfo = filePassRecord.encryptionInfo.copy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.encryptionType);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        serialize(new LittleEndianOutputStream(unsynchronizedByteArrayOutputStream));
        return unsynchronizedByteArrayOutputStream.size();
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.encryptionInfo;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("type", new Supplier(this) { // from class: org.apache.poi.hssf.record.N
            public final /* synthetic */ FilePassRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getEncryptionInfo();
                }
            }
        }, "encryptionInfo", new Supplier(this) { // from class: org.apache.poi.hssf.record.N
            public final /* synthetic */ FilePassRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getEncryptionInfo();
                }
            }
        });
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 47;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.encryptionType);
        byte[] bArr = new byte[1024];
        try {
            LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, 0);
            try {
                int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[this.encryptionInfo.getEncryptionMode().ordinal()];
                if (i5 == 1) {
                    ((XOREncryptionHeader) this.encryptionInfo.getHeader()).write(littleEndianByteArrayOutputStream);
                    ((XOREncryptionVerifier) this.encryptionInfo.getVerifier()).write(littleEndianByteArrayOutputStream);
                } else if (i5 == 2) {
                    littleEndianOutput.writeShort(this.encryptionInfo.getVersionMajor());
                    littleEndianOutput.writeShort(this.encryptionInfo.getVersionMinor());
                    ((BinaryRC4EncryptionHeader) this.encryptionInfo.getHeader()).write(littleEndianByteArrayOutputStream);
                    ((BinaryRC4EncryptionVerifier) this.encryptionInfo.getVerifier()).write(littleEndianByteArrayOutputStream);
                } else {
                    if (i5 != 3) {
                        throw new EncryptedDocumentException("not supported");
                    }
                    littleEndianOutput.writeShort(this.encryptionInfo.getVersionMajor());
                    littleEndianOutput.writeShort(this.encryptionInfo.getVersionMinor());
                    littleEndianOutput.writeInt(this.encryptionInfo.getEncryptionFlags());
                    ((CryptoAPIEncryptionHeader) this.encryptionInfo.getHeader()).write(littleEndianByteArrayOutputStream);
                    ((CryptoAPIEncryptionVerifier) this.encryptionInfo.getVerifier()).write(littleEndianByteArrayOutputStream);
                }
                littleEndianOutput.write(bArr, 0, littleEndianByteArrayOutputStream.getWriteIndex());
                littleEndianByteArrayOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        littleEndianByteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FILE_PASS;
    }

    public FilePassRecord(EncryptionMode encryptionMode) {
        this.encryptionType = encryptionMode == EncryptionMode.xor ? 0 : 1;
        this.encryptionInfo = new EncryptionInfo(encryptionMode);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public FilePassRecord copy() {
        return new FilePassRecord(this);
    }

    public FilePassRecord(RecordInputStream recordInputStream) {
        EncryptionMode encryptionMode;
        int uShort = recordInputStream.readUShort();
        this.encryptionType = uShort;
        if (uShort == 0) {
            encryptionMode = EncryptionMode.xor;
        } else if (uShort == 1) {
            encryptionMode = EncryptionMode.cryptoAPI;
        } else {
            throw new EncryptedDocumentException("invalid encryption type");
        }
        try {
            this.encryptionInfo = new EncryptionInfo(recordInputStream, encryptionMode);
        } catch (IOException e) {
            throw new EncryptedDocumentException(e);
        }
    }
}
