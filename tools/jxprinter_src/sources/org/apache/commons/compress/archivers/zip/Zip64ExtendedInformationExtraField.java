package org.apache.commons.compress.archivers.zip;

import A3.AbstractC0157z;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Zip64ExtendedInformationExtraField implements ZipExtraField {
    static final ZipShort HEADER_ID = new ZipShort(1);
    private static final String LFH_MUST_HAVE_BOTH_SIZES_MSG = "Zip64 extended information must contain both size values in the local file header.";
    private ZipEightByteInteger compressedSize;
    private ZipLong diskStart;
    private byte[] rawCentralDirectoryData;
    private ZipEightByteInteger relativeHeaderOffset;
    private ZipEightByteInteger size;

    public Zip64ExtendedInformationExtraField() {
    }

    private int addSizes(byte[] bArr) {
        int i5;
        ZipEightByteInteger zipEightByteInteger = this.size;
        if (zipEightByteInteger != null) {
            System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, 0, 8);
            i5 = 8;
        } else {
            i5 = 0;
        }
        ZipEightByteInteger zipEightByteInteger2 = this.compressedSize;
        if (zipEightByteInteger2 == null) {
            return i5;
        }
        System.arraycopy(zipEightByteInteger2.getBytes(), 0, bArr, i5, 8);
        return i5 + 8;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] bArr = new byte[getCentralDirectoryLength().getValue()];
        int iAddSizes = addSizes(bArr);
        ZipEightByteInteger zipEightByteInteger = this.relativeHeaderOffset;
        if (zipEightByteInteger != null) {
            System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, iAddSizes, 8);
            iAddSizes += 8;
        }
        ZipLong zipLong = this.diskStart;
        if (zipLong != null) {
            System.arraycopy(zipLong.getBytes(), 0, bArr, iAddSizes, 4);
        }
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return new ZipShort((this.size != null ? 8 : 0) + (this.compressedSize != null ? 8 : 0) + (this.relativeHeaderOffset == null ? 0 : 8) + (this.diskStart != null ? 4 : 0));
    }

    public ZipEightByteInteger getCompressedSize() {
        return this.compressedSize;
    }

    public ZipLong getDiskStartNumber() {
        return this.diskStart;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        ZipEightByteInteger zipEightByteInteger = this.size;
        if (zipEightByteInteger == null && this.compressedSize == null) {
            return ByteUtils.EMPTY_BYTE_ARRAY;
        }
        if (zipEightByteInteger == null || this.compressedSize == null) {
            throw new IllegalArgumentException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
        }
        byte[] bArr = new byte[16];
        addSizes(bArr);
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.size != null ? 16 : 0);
    }

    public ZipEightByteInteger getRelativeHeaderOffset() {
        return this.relativeHeaderOffset;
    }

    public ZipEightByteInteger getSize() {
        return this.size;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i5, int i6) throws ZipException {
        byte[] bArr2 = new byte[i6];
        this.rawCentralDirectoryData = bArr2;
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        if (i6 >= 28) {
            parseFromLocalFileData(bArr, i5, i6);
            return;
        }
        if (i6 == 24) {
            this.size = new ZipEightByteInteger(bArr, i5);
            this.compressedSize = new ZipEightByteInteger(bArr, i5 + 8);
            this.relativeHeaderOffset = new ZipEightByteInteger(bArr, i5 + 16);
        } else if (i6 % 8 == 4) {
            this.diskStart = new ZipLong(bArr, (i5 + i6) - 4);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i5, int i6) throws ZipException {
        if (i6 == 0) {
            return;
        }
        if (i6 < 16) {
            throw new ZipException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
        }
        this.size = new ZipEightByteInteger(bArr, i5);
        this.compressedSize = new ZipEightByteInteger(bArr, i5 + 8);
        int i7 = i5 + 16;
        int i8 = i6 - 16;
        if (i8 >= 8) {
            this.relativeHeaderOffset = new ZipEightByteInteger(bArr, i7);
            i7 = i5 + 24;
            i8 = i6 - 24;
        }
        if (i8 >= 4) {
            this.diskStart = new ZipLong(bArr, i7);
        }
    }

    public void reparseCentralDirectoryData(boolean z6, boolean z7, boolean z8, boolean z9) {
        byte[] bArr = this.rawCentralDirectoryData;
        if (bArr != null) {
            int i5 = 0;
            int i6 = (z6 ? 8 : 0) + (z7 ? 8 : 0) + (z8 ? 8 : 0) + (z9 ? 4 : 0);
            if (bArr.length < i6) {
                StringBuilder sbT = AbstractC0157z.t(i6, "Central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length ", " but is ");
                sbT.append(this.rawCentralDirectoryData.length);
                throw new ZipException(sbT.toString());
            }
            if (z6) {
                this.size = new ZipEightByteInteger(this.rawCentralDirectoryData, 0);
                i5 = 8;
            }
            if (z7) {
                this.compressedSize = new ZipEightByteInteger(this.rawCentralDirectoryData, i5);
                i5 += 8;
            }
            if (z8) {
                this.relativeHeaderOffset = new ZipEightByteInteger(this.rawCentralDirectoryData, i5);
                i5 += 8;
            }
            if (z9) {
                this.diskStart = new ZipLong(this.rawCentralDirectoryData, i5);
            }
        }
    }

    public void setCompressedSize(ZipEightByteInteger zipEightByteInteger) {
        this.compressedSize = zipEightByteInteger;
    }

    public void setDiskStartNumber(ZipLong zipLong) {
        this.diskStart = zipLong;
    }

    public void setRelativeHeaderOffset(ZipEightByteInteger zipEightByteInteger) {
        this.relativeHeaderOffset = zipEightByteInteger;
    }

    public void setSize(ZipEightByteInteger zipEightByteInteger) {
        this.size = zipEightByteInteger;
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger zipEightByteInteger, ZipEightByteInteger zipEightByteInteger2) {
        this(zipEightByteInteger, zipEightByteInteger2, null, null);
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger zipEightByteInteger, ZipEightByteInteger zipEightByteInteger2, ZipEightByteInteger zipEightByteInteger3, ZipLong zipLong) {
        this.size = zipEightByteInteger;
        this.compressedSize = zipEightByteInteger2;
        this.relativeHeaderOffset = zipEightByteInteger3;
        this.diskStart = zipLong;
    }
}
