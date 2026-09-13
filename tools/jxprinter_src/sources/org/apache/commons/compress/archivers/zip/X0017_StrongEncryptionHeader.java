package org.apache.commons.compress.archivers.zip;

import A3.AbstractC0157z;
import java.util.Arrays;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class X0017_StrongEncryptionHeader extends PKWareExtraHeader {
    private PKWareExtraHeader.EncryptionAlgorithm algId;
    private int bitlen;
    private byte[] erdData;
    private int flags;
    private int format;
    private PKWareExtraHeader.HashAlgorithm hashAlg;
    private int hashSize;
    private byte[] ivData;
    private byte[] keyBlob;
    private long rcount;
    private byte[] recipientKeyHash;
    private byte[] vCRC32;
    private byte[] vData;

    public X0017_StrongEncryptionHeader() {
        super(new ZipShort(23));
    }

    private void assertDynamicLengthFits(String str, int i5, int i6, int i7) throws ZipException {
        if (i6 + i5 <= i7) {
            return;
        }
        StringBuilder sb = new StringBuilder("Invalid X0017_StrongEncryptionHeader: ");
        sb.append(str);
        sb.append(" ");
        sb.append(i5);
        sb.append(" doesn't fit into ");
        throw new ZipException(androidx.exifinterface.media.a.i(" bytes of data at position ", i7, i6, sb));
    }

    public PKWareExtraHeader.EncryptionAlgorithm getEncryptionAlgorithm() {
        return this.algId;
    }

    public PKWareExtraHeader.HashAlgorithm getHashAlgorithm() {
        return this.hashAlg;
    }

    public long getRecordCount() {
        return this.rcount;
    }

    public void parseCentralDirectoryFormat(byte[] bArr, int i5, int i6) throws ZipException {
        assertMinimalLength(12, i6);
        this.format = ZipShort.getValue(bArr, i5);
        this.algId = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i5 + 2));
        this.bitlen = ZipShort.getValue(bArr, i5 + 4);
        this.flags = ZipShort.getValue(bArr, i5 + 6);
        long value = ZipLong.getValue(bArr, i5 + 8);
        this.rcount = value;
        if (value > 0) {
            assertMinimalLength(16, i6);
            this.hashAlg = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i5 + 12));
            this.hashSize = ZipShort.getValue(bArr, i5 + 14);
        }
    }

    public void parseFileFormat(byte[] bArr, int i5, int i6) throws ZipException {
        assertMinimalLength(4, i6);
        int value = ZipShort.getValue(bArr, i5);
        assertDynamicLengthFits("ivSize", value, 4, i6);
        int i7 = i5 + 4;
        assertMinimalLength(i7, value);
        this.ivData = Arrays.copyOfRange(bArr, i7, value);
        int i8 = value + 16;
        assertMinimalLength(i8, i6);
        int i9 = i5 + value;
        this.format = ZipShort.getValue(bArr, i9 + 6);
        this.algId = PKWareExtraHeader.EncryptionAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i9 + 8));
        this.bitlen = ZipShort.getValue(bArr, i9 + 10);
        this.flags = ZipShort.getValue(bArr, i9 + 12);
        int value2 = ZipShort.getValue(bArr, i9 + 14);
        assertDynamicLengthFits("erdSize", value2, i8, i6);
        int i10 = i9 + 16;
        assertMinimalLength(i10, value2);
        this.erdData = Arrays.copyOfRange(bArr, i10, value2);
        int i11 = value + 20 + value2;
        assertMinimalLength(i11, i6);
        long value3 = ZipLong.getValue(bArr, i10 + value2);
        this.rcount = value3;
        if (value3 == 0) {
            assertMinimalLength(i11 + 2, i6);
            int value4 = ZipShort.getValue(bArr, i9 + 20 + value2);
            assertDynamicLengthFits("vSize", value4, value + 22 + value2, i6);
            if (value4 < 4) {
                throw new ZipException(androidx.collection.a.i(value4, "Invalid X0017_StrongEncryptionHeader: vSize ", " is too small to hold CRC"));
            }
            int i12 = i9 + 22 + value2;
            int i13 = value4 - 4;
            assertMinimalLength(i12, i13);
            this.vData = Arrays.copyOfRange(bArr, i12, i13);
            int i14 = (i12 + value4) - 4;
            assertMinimalLength(i14, 4);
            this.vCRC32 = Arrays.copyOfRange(bArr, i14, 4);
            return;
        }
        assertMinimalLength(i11 + 6, i6);
        this.hashAlg = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i9 + 20 + value2));
        int i15 = i9 + 22 + value2;
        this.hashSize = ZipShort.getValue(bArr, i15);
        int i16 = i9 + 24 + value2;
        int value5 = ZipShort.getValue(bArr, i16);
        int i17 = this.hashSize;
        if (value5 < i17) {
            StringBuilder sbT = AbstractC0157z.t(value5, "Invalid X0017_StrongEncryptionHeader: resize ", " is too small to hold hashSize");
            sbT.append(this.hashSize);
            throw new ZipException(sbT.toString());
        }
        this.recipientKeyHash = new byte[i17];
        this.keyBlob = new byte[value5 - i17];
        assertDynamicLengthFits("resize", value5, value + 24 + value2, i6);
        System.arraycopy(bArr, i16, this.recipientKeyHash, 0, this.hashSize);
        int i18 = this.hashSize;
        System.arraycopy(bArr, i16 + i18, this.keyBlob, 0, value5 - i18);
        assertMinimalLength(value + 26 + value2 + value5 + 2, i6);
        int value6 = ZipShort.getValue(bArr, i9 + 26 + value2 + value5);
        if (value6 < 4) {
            throw new ZipException(androidx.collection.a.i(value6, "Invalid X0017_StrongEncryptionHeader: vSize ", " is too small to hold CRC"));
        }
        assertDynamicLengthFits("vSize", value6, value + 22 + value2 + value5, i6);
        int i19 = value6 - 4;
        byte[] bArr2 = new byte[i19];
        this.vData = bArr2;
        this.vCRC32 = new byte[4];
        int i20 = i15 + value5;
        System.arraycopy(bArr, i20, bArr2, 0, i19);
        System.arraycopy(bArr, (i20 + value6) - 4, this.vCRC32, 0, 4);
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i5, int i6) throws ZipException {
        super.parseFromCentralDirectoryData(bArr, i5, i6);
        parseCentralDirectoryFormat(bArr, i5, i6);
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i5, int i6) throws ZipException {
        super.parseFromLocalFileData(bArr, i5, i6);
        parseFileFormat(bArr, i5, i6);
    }
}
