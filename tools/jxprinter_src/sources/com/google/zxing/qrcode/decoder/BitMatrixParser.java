package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }

    private int copyBit(int i5, int i6, int i7) {
        return this.mirror ? this.bitMatrix.get(i6, i5) : this.bitMatrix.get(i5, i6) ? (i7 << 1) | 1 : i7 << 1;
    }

    public void mirror() {
        int i5 = 0;
        while (i5 < this.bitMatrix.getWidth()) {
            int i6 = i5 + 1;
            for (int i7 = i6; i7 < this.bitMatrix.getHeight(); i7++) {
                if (this.bitMatrix.get(i5, i7) != this.bitMatrix.get(i7, i5)) {
                    this.bitMatrix.flip(i7, i5);
                    this.bitMatrix.flip(i5, i7);
                }
            }
            i5 = i6;
        }
    }

    public byte[] readCodewords() throws FormatException {
        FormatInformation formatInformation = readFormatInformation();
        Version version = readVersion();
        DataMask dataMask = DataMask.values()[formatInformation.getDataMask()];
        int height = this.bitMatrix.getHeight();
        dataMask.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix bitMatrixBuildFunctionPattern = version.buildFunctionPattern();
        byte[] bArr = new byte[version.getTotalCodewords()];
        int i5 = height - 1;
        boolean z6 = true;
        int i6 = i5;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 > 0) {
            if (i6 == 6) {
                i6--;
            }
            for (int i10 = 0; i10 < height; i10++) {
                int i11 = z6 ? i5 - i10 : i10;
                for (int i12 = 0; i12 < 2; i12++) {
                    int i13 = i6 - i12;
                    if (!bitMatrixBuildFunctionPattern.get(i13, i11)) {
                        i8++;
                        i9 <<= 1;
                        if (this.bitMatrix.get(i13, i11)) {
                            i9 |= 1;
                        }
                        if (i8 == 8) {
                            bArr[i7] = (byte) i9;
                            i7++;
                            i8 = 0;
                            i9 = 0;
                        }
                    }
                }
            }
            z6 = !z6;
            i6 -= 2;
        }
        if (i7 == version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public FormatInformation readFormatInformation() throws FormatException {
        FormatInformation formatInformation = this.parsedFormatInfo;
        if (formatInformation != null) {
            return formatInformation;
        }
        int iCopyBit = 0;
        int iCopyBit2 = 0;
        for (int i5 = 0; i5 < 6; i5++) {
            iCopyBit2 = copyBit(i5, 8, iCopyBit2);
        }
        int iCopyBit3 = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, iCopyBit2)));
        for (int i6 = 5; i6 >= 0; i6--) {
            iCopyBit3 = copyBit(8, i6, iCopyBit3);
        }
        int height = this.bitMatrix.getHeight();
        int i7 = height - 7;
        for (int i8 = height - 1; i8 >= i7; i8--) {
            iCopyBit = copyBit(8, i8, iCopyBit);
        }
        for (int i9 = height - 8; i9 < height; i9++) {
            iCopyBit = copyBit(i9, 8, iCopyBit);
        }
        FormatInformation formatInformationDecodeFormatInformation = FormatInformation.decodeFormatInformation(iCopyBit3, iCopyBit);
        this.parsedFormatInfo = formatInformationDecodeFormatInformation;
        if (formatInformationDecodeFormatInformation != null) {
            return formatInformationDecodeFormatInformation;
        }
        throw FormatException.getFormatInstance();
    }

    public Version readVersion() throws FormatException {
        Version version = this.parsedVersion;
        if (version != null) {
            return version;
        }
        int height = this.bitMatrix.getHeight();
        int i5 = (height - 17) / 4;
        if (i5 <= 6) {
            return Version.getVersionForNumber(i5);
        }
        int i6 = height - 11;
        int iCopyBit = 0;
        int iCopyBit2 = 0;
        for (int i7 = 5; i7 >= 0; i7--) {
            for (int i8 = height - 9; i8 >= i6; i8--) {
                iCopyBit2 = copyBit(i8, i7, iCopyBit2);
            }
        }
        Version versionDecodeVersionInformation = Version.decodeVersionInformation(iCopyBit2);
        if (versionDecodeVersionInformation != null && versionDecodeVersionInformation.getDimensionForVersion() == height) {
            this.parsedVersion = versionDecodeVersionInformation;
            return versionDecodeVersionInformation;
        }
        for (int i9 = 5; i9 >= 0; i9--) {
            for (int i10 = height - 9; i10 >= i6; i10--) {
                iCopyBit = copyBit(i9, i10, iCopyBit);
            }
        }
        Version versionDecodeVersionInformation2 = Version.decodeVersionInformation(iCopyBit);
        if (versionDecodeVersionInformation2 == null || versionDecodeVersionInformation2.getDimensionForVersion() != height) {
            throw FormatException.getFormatInstance();
        }
        this.parsedVersion = versionDecodeVersionInformation2;
        return versionDecodeVersionInformation2;
    }

    public void remask() {
        if (this.parsedFormatInfo == null) {
            return;
        }
        DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
    }

    public void setMirror(boolean z6) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z6;
    }
}
