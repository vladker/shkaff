package com.google.zxing.qrcode.encoder;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    /* JADX INFO: renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Encoder() {
    }

    public static void append8BitBytes(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                bitArray.appendBits(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    public static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i5));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i6 = i5 + 1;
            if (i6 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i6));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i5 += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i5 = i6;
            }
        }
    }

    public static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        int i5 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i5 == 1) {
            appendNumericBytes(str, bitArray);
            return;
        }
        if (i5 == 2) {
            appendAlphanumericBytes(str, bitArray);
            return;
        }
        if (i5 == 3) {
            append8BitBytes(str, bitArray, str2);
        } else if (i5 == 4) {
            appendKanjiBytes(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    public static void appendKanjiBytes(String str, BitArray bitArray) throws WriterException {
        int i5;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i6 = 0; i6 < length; i6 += 2) {
                int i7 = ((bytes[i6] & UnsignedBytes.MAX_VALUE) << 8) | (bytes[i6 + 1] & UnsignedBytes.MAX_VALUE);
                int i8 = 33088;
                if (i7 >= 33088 && i7 <= 40956) {
                    i5 = i7 - i8;
                } else if (i7 < 57408 || i7 > 60351) {
                    i5 = -1;
                } else {
                    i8 = 49472;
                    i5 = i7 - i8;
                }
                if (i5 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.appendBits(((i5 >> 8) * 192) + (i5 & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    public static void appendLengthInfo(int i5, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i6 = 1 << characterCountBits;
        if (i5 < i6) {
            bitArray.appendBits(i5, characterCountBits);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i5);
        sb.append(" is bigger than ");
        throw new WriterException(AbstractC0157z.q(sb, i6, 1));
    }

    public static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    public static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length) {
            int iCharAt = charSequence.charAt(i5) - '0';
            int i6 = i5 + 2;
            if (i6 < length) {
                bitArray.appendBits(((charSequence.charAt(i5 + 1) - '0') * 10) + (iCharAt * 100) + (charSequence.charAt(i6) - '0'), 10);
                i5 += 3;
            } else {
                i5++;
                if (i5 < length) {
                    bitArray.appendBits((iCharAt * 10) + (charSequence.charAt(i5) - '0'), 7);
                    i5 = i6;
                } else {
                    bitArray.appendBits(iCharAt, 4);
                }
            }
        }
    }

    private static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray2.getSize() + mode.getCharacterCountBits(version) + bitArray.getSize();
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i5 = Integer.MAX_VALUE;
        int i6 = -1;
        for (int i7 = 0; i7 < 8; i7++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i7, byteMatrix);
            int iCalculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (iCalculateMaskPenalty < i5) {
                i6 = i7;
                i5 = iCalculateMaskPenalty;
            }
        }
        return i6;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    private static Version chooseVersion(int i5, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i6 = 1; i6 <= 40; i6++) {
            Version versionForNumber = Version.getVersionForNumber(i6);
            if (willFit(i5, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) {
        return encode(str, errorCorrectionLevel, null);
    }

    public static byte[] generateECBytes(byte[] bArr, int i5) {
        int length = bArr.length;
        int[] iArr = new int[length + i5];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = bArr[i6] & UnsignedBytes.MAX_VALUE;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i5);
        byte[] bArr2 = new byte[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            bArr2[i7] = (byte) iArr[length + i7];
        }
        return bArr2;
    }

    public static int getAlphanumericCode(int i5) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i5 < iArr.length) {
            return iArr[i5];
        }
        return -1;
    }

    public static void getNumDataBytesAndNumECBytesForBlockID(int i5, int i6, int i7, int i8, int[] iArr, int[] iArr2) throws WriterException {
        if (i8 >= i7) {
            throw new WriterException("Block ID too large");
        }
        int i9 = i5 % i7;
        int i10 = i7 - i9;
        int i11 = i5 / i7;
        int i12 = i11 + 1;
        int i13 = i6 / i7;
        int i14 = i13 + 1;
        int i15 = i11 - i13;
        int i16 = i12 - i14;
        if (i15 != i16) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i7 != i10 + i9) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i5 != ((i14 + i16) * i9) + ((i13 + i15) * i10)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i8 < i10) {
            iArr[0] = i13;
            iArr2[0] = i15;
        } else {
            iArr[0] = i14;
            iArr2[0] = i16;
        }
    }

    public static BitArray interleaveWithECBytes(BitArray bitArray, int i5, int i6, int i7) throws WriterException {
        if (bitArray.getSizeInBytes() != i6) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        int i9 = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (i8 < i7) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int i10 = i5;
            int i11 = i6;
            int i12 = i7;
            getNumDataBytesAndNumECBytesForBlockID(i10, i11, i12, i8, iArr, iArr2);
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            bitArray.toBytes(i9 << 3, bArr, 0, i13);
            byte[] bArrGenerateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, bArrGenerateECBytes));
            iMax = Math.max(iMax, i13);
            iMax2 = Math.max(iMax2, bArrGenerateECBytes.length);
            i9 += iArr[0];
            i8++;
            i5 = i10;
            i6 = i11;
            i7 = i12;
        }
        int i14 = i5;
        if (i6 != i9) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i15 = 0; i15 < iMax; i15++) {
            int size = arrayList.size();
            int i16 = 0;
            while (i16 < size) {
                Object obj = arrayList.get(i16);
                i16++;
                byte[] dataBytes = ((BlockPair) obj).getDataBytes();
                if (i15 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i15], 8);
                }
            }
        }
        for (int i17 = 0; i17 < iMax2; i17++) {
            int size2 = arrayList.size();
            int i18 = 0;
            while (i18 < size2) {
                Object obj2 = arrayList.get(i18);
                i18++;
                byte[] errorCorrectionBytes = ((BlockPair) obj2).getErrorCorrectionBytes();
                if (i17 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i17], 8);
                }
            }
        }
        if (i14 == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        StringBuilder sbT = AbstractC0157z.t(i14, "Interleaving error: ", " and ");
        sbT.append(bitArray2.getSizeInBytes());
        sbT.append(" differ.");
        throw new WriterException(sbT.toString());
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i5 = 0; i5 < length; i5 += 2) {
                int i6 = bytes[i5] & UnsignedBytes.MAX_VALUE;
                if ((i6 < 129 || i6 > 159) && (i6 < 224 || i6 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void terminateBits(int i5, BitArray bitArray) throws WriterException {
        int i6 = i5 << 3;
        if (bitArray.getSize() > i6) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i6);
        }
        for (int i7 = 0; i7 < 4 && bitArray.getSize() < i6; i7++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i5 - bitArray.getSizeInBytes();
        for (int i8 = 0; i8 < sizeInBytes; i8++) {
            bitArray.appendBits((i8 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i6) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    private static boolean willFit(int i5, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i5 + 7) / 8;
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return Mode.KANJI;
        }
        boolean z6 = false;
        boolean z7 = false;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z7 = true;
            } else {
                if (getAlphanumericCode(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z6 = true;
            }
        }
        if (z6) {
            return Mode.ALPHANUMERIC;
        }
        return z7 ? Mode.NUMERIC : Mode.BYTE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        String string;
        Version versionRecommendVersion;
        CharacterSetECI characterSetECIByName;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                string = map.get(encodeHintType).toString();
            } else {
                string = "ISO-8859-1";
            }
        } else {
            string = "ISO-8859-1";
        }
        Mode modeChooseMode = chooseMode(str, string);
        BitArray bitArray = new BitArray();
        Mode mode = Mode.BYTE;
        if (modeChooseMode == mode && !"ISO-8859-1".equals(string) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(string)) != null) {
            appendECI(characterSetECIByName, bitArray);
        }
        appendModeInfo(modeChooseMode, bitArray);
        BitArray bitArray2 = new BitArray();
        appendBytes(str, modeChooseMode, bitArray2, string);
        if (map != null) {
            EncodeHintType encodeHintType2 = EncodeHintType.QR_VERSION;
            if (map.containsKey(encodeHintType2)) {
                versionRecommendVersion = Version.getVersionForNumber(Integer.parseInt(map.get(encodeHintType2).toString()));
                if (!willFit(calculateBitsNeeded(modeChooseMode, bitArray, bitArray2, versionRecommendVersion), versionRecommendVersion, errorCorrectionLevel)) {
                    throw new WriterException("Data too big for requested version");
                }
            } else {
                versionRecommendVersion = recommendVersion(errorCorrectionLevel, modeChooseMode, bitArray, bitArray2);
            }
        } else {
            versionRecommendVersion = recommendVersion(errorCorrectionLevel, modeChooseMode, bitArray, bitArray2);
        }
        BitArray bitArray3 = new BitArray();
        bitArray3.appendBitArray(bitArray);
        appendLengthInfo(modeChooseMode == mode ? bitArray2.getSizeInBytes() : str.length(), versionRecommendVersion, modeChooseMode, bitArray3);
        bitArray3.appendBitArray(bitArray2);
        Version.ECBlocks eCBlocksForLevel = versionRecommendVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords = versionRecommendVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
        terminateBits(totalCodewords, bitArray3);
        BitArray bitArrayInterleaveWithECBytes = interleaveWithECBytes(bitArray3, versionRecommendVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
        QRCode qRCode = new QRCode();
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(modeChooseMode);
        qRCode.setVersion(versionRecommendVersion);
        int dimensionForVersion = versionRecommendVersion.getDimensionForVersion();
        ByteMatrix byteMatrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
        int iChooseMaskPattern = chooseMaskPattern(bitArrayInterleaveWithECBytes, errorCorrectionLevel, versionRecommendVersion, byteMatrix);
        qRCode.setMaskPattern(iChooseMaskPattern);
        MatrixUtil.buildMatrix(bitArrayInterleaveWithECBytes, errorCorrectionLevel, versionRecommendVersion, iChooseMaskPattern, byteMatrix);
        qRCode.setMatrix(byteMatrix);
        return qRCode;
    }
}
