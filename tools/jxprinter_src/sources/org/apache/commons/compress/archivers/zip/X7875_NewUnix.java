package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class X7875_NewUnix implements ZipExtraField, Cloneable, Serializable {
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version = 1;
    private static final ZipShort HEADER_ID = new ZipShort(30837);
    private static final ZipShort ZERO = new ZipShort(0);
    private static final BigInteger ONE_THOUSAND = BigInteger.valueOf(1000);

    public X7875_NewUnix() {
        reset();
    }

    private void reset() {
        BigInteger bigInteger = ONE_THOUSAND;
        this.uid = bigInteger;
        this.gid = bigInteger;
    }

    public static byte[] trimLeadingZeroesForceMinLength(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        int length = bArr.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length && bArr[i6] == 0; i6++) {
            i5++;
        }
        int iMax = Math.max(1, bArr.length - i5);
        byte[] bArr2 = new byte[iMax];
        int length2 = iMax - (bArr.length - i5);
        System.arraycopy(bArr, i5, bArr2, length2, iMax - length2);
        return bArr2;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj instanceof X7875_NewUnix) {
            X7875_NewUnix x7875_NewUnix = (X7875_NewUnix) obj;
            if (this.version == x7875_NewUnix.version && this.uid.equals(x7875_NewUnix.uid) && this.gid.equals(x7875_NewUnix.gid)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return ZERO;
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] byteArray = this.uid.toByteArray();
        byte[] byteArray2 = this.gid.toByteArray();
        byte[] bArrTrimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(byteArray);
        int length = bArrTrimLeadingZeroesForceMinLength != null ? bArrTrimLeadingZeroesForceMinLength.length : 0;
        byte[] bArrTrimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(byteArray2);
        int length2 = bArrTrimLeadingZeroesForceMinLength2 != null ? bArrTrimLeadingZeroesForceMinLength2.length : 0;
        byte[] bArr = new byte[length + 3 + length2];
        if (bArrTrimLeadingZeroesForceMinLength != null) {
            ZipUtil.reverse(bArrTrimLeadingZeroesForceMinLength);
        }
        if (bArrTrimLeadingZeroesForceMinLength2 != null) {
            ZipUtil.reverse(bArrTrimLeadingZeroesForceMinLength2);
        }
        bArr[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        bArr[1] = ZipUtil.unsignedIntToSignedByte(length);
        if (bArrTrimLeadingZeroesForceMinLength != null) {
            System.arraycopy(bArrTrimLeadingZeroesForceMinLength, 0, bArr, 2, length);
        }
        int i5 = 2 + length;
        int i6 = length + 3;
        bArr[i5] = ZipUtil.unsignedIntToSignedByte(length2);
        if (bArrTrimLeadingZeroesForceMinLength2 != null) {
            System.arraycopy(bArrTrimLeadingZeroesForceMinLength2, 0, bArr, i6, length2);
        }
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        byte[] bArrTrimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(this.uid.toByteArray());
        int length = bArrTrimLeadingZeroesForceMinLength == null ? 0 : bArrTrimLeadingZeroesForceMinLength.length;
        byte[] bArrTrimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(this.gid.toByteArray());
        return new ZipShort(length + 3 + (bArrTrimLeadingZeroesForceMinLength2 != null ? bArrTrimLeadingZeroesForceMinLength2.length : 0));
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public int hashCode() {
        return (Integer.rotateLeft(this.uid.hashCode(), 16) ^ (this.version * (-1234567))) ^ this.gid.hashCode();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i5, int i6) throws ZipException {
        reset();
        if (i6 < 3) {
            throw new ZipException(androidx.collection.a.i(i6, "X7875_NewUnix length is too short, only ", " bytes"));
        }
        int i7 = i5 + 1;
        this.version = ZipUtil.signedByteToUnsignedInt(bArr[i5]);
        int i8 = i5 + 2;
        int iSignedByteToUnsignedInt = ZipUtil.signedByteToUnsignedInt(bArr[i7]);
        int i9 = iSignedByteToUnsignedInt + 3;
        if (i9 > i6) {
            throw new ZipException(androidx.collection.a.m("X7875_NewUnix invalid: uidSize ", iSignedByteToUnsignedInt, i6, " doesn't fit into ", " bytes"));
        }
        int i10 = iSignedByteToUnsignedInt + i8;
        this.uid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(bArr, i8, i10)));
        int i11 = i10 + 1;
        int iSignedByteToUnsignedInt2 = ZipUtil.signedByteToUnsignedInt(bArr[i10]);
        if (i9 + iSignedByteToUnsignedInt2 > i6) {
            throw new ZipException(androidx.collection.a.m("X7875_NewUnix invalid: gidSize ", iSignedByteToUnsignedInt2, i6, " doesn't fit into ", " bytes"));
        }
        this.gid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(bArr, i11, iSignedByteToUnsignedInt2 + i11)));
    }

    public void setGID(long j6) {
        this.gid = ZipUtil.longToBig(j6);
    }

    public void setUID(long j6) {
        this.uid = ZipUtil.longToBig(j6);
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i5, int i6) {
    }
}
