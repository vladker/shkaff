package org.apache.poi.poifs.crypt;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DataSpaceMapUtils {
    public static void addDefaultDataSpace(DirectoryEntry directoryEntry) {
        createEncryptionEntry(directoryEntry, "\u0006DataSpaces/DataSpaceMap", new DataSpaceMap(new DataSpaceMapEntry[]{new DataSpaceMapEntry(new int[]{0}, new String[]{Decryptor.DEFAULT_POIFS_ENTRY}, "StrongEncryptionDataSpace")}));
        createEncryptionEntry(directoryEntry, "\u0006DataSpaces/DataSpaceInfo/StrongEncryptionDataSpace", new DataSpaceDefinition(new String[]{"StrongEncryptionTransform"}));
        createEncryptionEntry(directoryEntry, "\u0006DataSpaces/TransformInfo/StrongEncryptionTransform/\u0006Primary", new IRMDSTransformInfo(new TransformInfoHeader(1, "{FF9A3F03-56EF-4613-BDD5-5A41C1D07246}", "Microsoft.Container.EncryptionTransform", 1, 0, 1, 0, 1, 0), 0, null));
        createEncryptionEntry(directoryEntry, "\u0006DataSpaces/Version", new DataSpaceVersionInfo("Microsoft.Container.DataSpaces", 1, 0, 1, 0, 1, 0));
    }

    public static DocumentEntry createEncryptionEntry(DirectoryEntry directoryEntry, String str, EncryptionRecord encryptionRecord) {
        String[] strArrSplit = str.split(PackagingURIHelper.FORWARD_SLASH_STRING);
        for (int i5 = 0; i5 < strArrSplit.length - 1; i5++) {
            directoryEntry = directoryEntry.hasEntry(strArrSplit[i5]) ? (DirectoryEntry) directoryEntry.getEntry(strArrSplit[i5]) : directoryEntry.createDirectory(strArrSplit[i5]);
        }
        byte[] bArr = new byte[5000];
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, 0);
        encryptionRecord.write(littleEndianByteArrayOutputStream);
        String str2 = strArrSplit[strArrSplit.length - 1];
        if (directoryEntry.hasEntry(str2)) {
            directoryEntry.getEntry(str2).delete();
        }
        return directoryEntry.createDocument(str2, littleEndianByteArrayOutputStream.getWriteIndex(), new a(bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createEncryptionEntry$0(byte[] bArr, POIFSWriterEvent pOIFSWriterEvent) {
        try {
            pOIFSWriterEvent.getStream().write(bArr, 0, pOIFSWriterEvent.getLimit());
        } catch (IOException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public static String readUnicodeLPP4(LittleEndianInput littleEndianInput) {
        int i5 = littleEndianInput.readInt();
        if (i5 % 2 != 0) {
            throw new EncryptedDocumentException("UNICODE-LP-P4 structure is a multiple of 4 bytes. If Padding is present, it MUST be exactly 2 bytes long");
        }
        String unicodeLE = StringUtil.readUnicodeLE(littleEndianInput, i5 / 2);
        if (i5 % 4 == 2) {
            littleEndianInput.readShort();
        }
        return unicodeLE;
    }

    public static String readUtf8LPP4(LittleEndianInput littleEndianInput) {
        int i5 = littleEndianInput.readInt();
        if (i5 == 0 || i5 == 4) {
            littleEndianInput.readInt();
            if (i5 == 0) {
                return null;
            }
            return "";
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, CryptoFunctions.MAX_RECORD_LENGTH);
        littleEndianInput.readFully(bArrSafelyAllocate);
        int i6 = i5 % 4;
        if (i6 > 0) {
            for (int i7 = 0; i7 < 4 - i6; i7++) {
                littleEndianInput.readByte();
            }
        }
        return new String(bArrSafelyAllocate, 0, bArrSafelyAllocate.length, StandardCharsets.UTF_8);
    }

    public static void writeUnicodeLPP4(LittleEndianOutput littleEndianOutput, String str) {
        byte[] toUnicodeLE = StringUtil.getToUnicodeLE(str);
        littleEndianOutput.writeInt(toUnicodeLE.length);
        littleEndianOutput.write(toUnicodeLE);
        if (toUnicodeLE.length % 4 == 2) {
            littleEndianOutput.writeShort(0);
        }
    }

    public static void writeUtf8LPP4(LittleEndianOutput littleEndianOutput, String str) {
        if (str == null || str.isEmpty()) {
            littleEndianOutput.writeInt(str == null ? 0 : 4);
            littleEndianOutput.writeInt(0);
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        littleEndianOutput.writeInt(bytes.length);
        littleEndianOutput.write(bytes);
        int length = bytes.length % 4;
        if (length > 0) {
            for (int i5 = 0; i5 < 4 - length; i5++) {
                littleEndianOutput.writeByte(0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataSpaceDefinition implements EncryptionRecord {
        String[] transformer;

        public DataSpaceDefinition(String[] strArr) {
            this.transformer = (String[]) strArr.clone();
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            littleEndianByteArrayOutputStream.writeInt(8);
            littleEndianByteArrayOutputStream.writeInt(this.transformer.length);
            for (String str : this.transformer) {
                DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, str);
            }
        }

        public DataSpaceDefinition(LittleEndianInput littleEndianInput) {
            littleEndianInput.readInt();
            int i5 = littleEndianInput.readInt();
            this.transformer = new String[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                this.transformer[i6] = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataSpaceMap implements EncryptionRecord {
        DataSpaceMapEntry[] entries;

        public DataSpaceMap(DataSpaceMapEntry[] dataSpaceMapEntryArr) {
            this.entries = (DataSpaceMapEntry[]) dataSpaceMapEntryArr.clone();
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            littleEndianByteArrayOutputStream.writeInt(8);
            littleEndianByteArrayOutputStream.writeInt(this.entries.length);
            for (DataSpaceMapEntry dataSpaceMapEntry : this.entries) {
                dataSpaceMapEntry.write(littleEndianByteArrayOutputStream);
            }
        }

        public DataSpaceMap(LittleEndianInput littleEndianInput) {
            littleEndianInput.readInt();
            int i5 = littleEndianInput.readInt();
            this.entries = new DataSpaceMapEntry[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                this.entries[i6] = new DataSpaceMapEntry(littleEndianInput);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataSpaceMapEntry implements EncryptionRecord {
        final String dataSpaceName;
        final String[] referenceComponent;
        final int[] referenceComponentType;

        public DataSpaceMapEntry(int[] iArr, String[] strArr, String str) {
            this.referenceComponentType = (int[]) iArr.clone();
            this.referenceComponent = (String[]) strArr.clone();
            this.dataSpaceName = str;
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            int writeIndex = littleEndianByteArrayOutputStream.getWriteIndex();
            LittleEndianOutput littleEndianOutputCreateDelayedOutput = littleEndianByteArrayOutputStream.createDelayedOutput(4);
            littleEndianByteArrayOutputStream.writeInt(this.referenceComponent.length);
            for (int i5 = 0; i5 < this.referenceComponent.length; i5++) {
                littleEndianByteArrayOutputStream.writeInt(this.referenceComponentType[i5]);
                DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.referenceComponent[i5]);
            }
            DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.dataSpaceName);
            littleEndianOutputCreateDelayedOutput.writeInt(littleEndianByteArrayOutputStream.getWriteIndex() - writeIndex);
        }

        public DataSpaceMapEntry(LittleEndianInput littleEndianInput) {
            littleEndianInput.readInt();
            int i5 = littleEndianInput.readInt();
            this.referenceComponentType = new int[i5];
            this.referenceComponent = new String[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                this.referenceComponentType[i6] = littleEndianInput.readInt();
                this.referenceComponent[i6] = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            }
            this.dataSpaceName = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class IRMDSTransformInfo implements EncryptionRecord {
        int extensibilityHeader;
        TransformInfoHeader transformInfoHeader;
        String xrMLLicense;

        public IRMDSTransformInfo(TransformInfoHeader transformInfoHeader, int i5, String str) {
            this.transformInfoHeader = transformInfoHeader;
            this.extensibilityHeader = i5;
            this.xrMLLicense = str;
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            this.transformInfoHeader.write(littleEndianByteArrayOutputStream);
            littleEndianByteArrayOutputStream.writeInt(this.extensibilityHeader);
            DataSpaceMapUtils.writeUtf8LPP4(littleEndianByteArrayOutputStream, this.xrMLLicense);
            littleEndianByteArrayOutputStream.writeInt(4);
        }

        public IRMDSTransformInfo(LittleEndianInput littleEndianInput) {
            this.transformInfoHeader = new TransformInfoHeader(littleEndianInput);
            this.extensibilityHeader = littleEndianInput.readInt();
            this.xrMLLicense = DataSpaceMapUtils.readUtf8LPP4(littleEndianInput);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TransformInfoHeader implements EncryptionRecord {
        int readerVersionMajor;
        int readerVersionMinor;
        int transformType;
        String transformerId;
        String transformerName;
        int updaterVersionMajor;
        int updaterVersionMinor;
        int writerVersionMajor;
        int writerVersionMinor;

        public TransformInfoHeader(int i5, String str, String str2, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.transformType = i5;
            this.transformerId = str;
            this.transformerName = str2;
            this.readerVersionMajor = i6;
            this.readerVersionMinor = i7;
            this.updaterVersionMajor = i8;
            this.updaterVersionMinor = i9;
            this.writerVersionMajor = i10;
            this.writerVersionMinor = i11;
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            int writeIndex = littleEndianByteArrayOutputStream.getWriteIndex();
            LittleEndianOutput littleEndianOutputCreateDelayedOutput = littleEndianByteArrayOutputStream.createDelayedOutput(4);
            littleEndianByteArrayOutputStream.writeInt(this.transformType);
            DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.transformerId);
            littleEndianOutputCreateDelayedOutput.writeInt(littleEndianByteArrayOutputStream.getWriteIndex() - writeIndex);
            DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.transformerName);
            littleEndianByteArrayOutputStream.writeShort(this.readerVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.readerVersionMinor);
            littleEndianByteArrayOutputStream.writeShort(this.updaterVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.updaterVersionMinor);
            littleEndianByteArrayOutputStream.writeShort(this.writerVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.writerVersionMinor);
        }

        public TransformInfoHeader(LittleEndianInput littleEndianInput) {
            this.readerVersionMajor = 1;
            this.updaterVersionMajor = 1;
            this.writerVersionMajor = 1;
            littleEndianInput.readInt();
            this.transformType = littleEndianInput.readInt();
            this.transformerId = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            this.transformerName = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            this.readerVersionMajor = littleEndianInput.readShort();
            this.readerVersionMinor = littleEndianInput.readShort();
            this.updaterVersionMajor = littleEndianInput.readShort();
            this.updaterVersionMinor = littleEndianInput.readShort();
            this.writerVersionMajor = littleEndianInput.readShort();
            this.writerVersionMinor = littleEndianInput.readShort();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataSpaceVersionInfo implements EncryptionRecord {
        String featureIdentifier;
        int readerVersionMajor;
        int readerVersionMinor;
        int updaterVersionMajor;
        int updaterVersionMinor;
        int writerVersionMajor;
        int writerVersionMinor;

        public DataSpaceVersionInfo(LittleEndianInput littleEndianInput) {
            this.readerVersionMajor = 1;
            this.updaterVersionMajor = 1;
            this.writerVersionMajor = 1;
            this.featureIdentifier = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            this.readerVersionMajor = littleEndianInput.readShort();
            this.readerVersionMinor = littleEndianInput.readShort();
            this.updaterVersionMajor = littleEndianInput.readShort();
            this.updaterVersionMinor = littleEndianInput.readShort();
            this.writerVersionMajor = littleEndianInput.readShort();
            this.writerVersionMinor = littleEndianInput.readShort();
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.featureIdentifier);
            littleEndianByteArrayOutputStream.writeShort(this.readerVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.readerVersionMinor);
            littleEndianByteArrayOutputStream.writeShort(this.updaterVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.updaterVersionMinor);
            littleEndianByteArrayOutputStream.writeShort(this.writerVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.writerVersionMinor);
        }

        public DataSpaceVersionInfo(String str, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.featureIdentifier = str;
            this.readerVersionMajor = i5;
            this.readerVersionMinor = i6;
            this.updaterVersionMajor = i7;
            this.updaterVersionMinor = i8;
            this.writerVersionMajor = i9;
            this.writerVersionMinor = i10;
        }
    }
}
