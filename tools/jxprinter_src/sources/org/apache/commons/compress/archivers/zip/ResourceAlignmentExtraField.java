package org.apache.commons.compress.archivers.zip;

import A3.AbstractC0157z;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ResourceAlignmentExtraField implements ZipExtraField {
    private static final int ALLOW_METHOD_MESSAGE_CHANGE_FLAG = 32768;
    public static final int BASE_SIZE = 2;
    public static final ZipShort ID = new ZipShort(41246);
    private short alignment;
    private boolean allowMethodChange;
    private int padding;

    public ResourceAlignmentExtraField() {
    }

    public boolean allowMethodChange() {
        return this.allowMethodChange;
    }

    public short getAlignment() {
        return this.alignment;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return ZipShort.getBytes(this.alignment | (this.allowMethodChange ? Short.MIN_VALUE : (short) 0));
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return new ZipShort(2);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] bArr = new byte[this.padding + 2];
        ZipShort.putShort(this.alignment | (this.allowMethodChange ? Short.MIN_VALUE : (short) 0), bArr, 0);
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.padding + 2);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i5, int i6) throws ZipException {
        if (i6 < 2) {
            throw new ZipException(AbstractC0157z.k(i6, "Too short content for ResourceAlignmentExtraField (0xa11e): "));
        }
        int value = ZipShort.getValue(bArr, i5);
        this.alignment = (short) (value & 32767);
        this.allowMethodChange = (value & 32768) != 0;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i5, int i6) throws ZipException {
        parseFromCentralDirectoryData(bArr, i5, i6);
        this.padding = i6 - 2;
    }

    public ResourceAlignmentExtraField(int i5) {
        this(i5, false);
    }

    public ResourceAlignmentExtraField(int i5, boolean z6) {
        this(i5, z6, 0);
    }

    public ResourceAlignmentExtraField(int i5, boolean z6, int i6) {
        if (i5 < 0 || i5 > 32767) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Alignment must be between 0 and 0x7fff, was: "));
        }
        if (i6 >= 0) {
            this.alignment = (short) i5;
            this.allowMethodChange = z6;
            this.padding = i6;
            return;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i6, "Padding must not be negative, was: "));
    }
}
