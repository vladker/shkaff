package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.ss.formula.functions.Complex;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Decoder {
    private AztecDetectorResult ddata;
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", Complex.DEFAULT_SUFFIX, Complex.SUPPORTED_SUFFIX, "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", CompressorStreamFactory.f6702Z, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", ProxyConfig.MATCH_ALL_SCHEMES, "+", ",", ProcessIdUtil.DEFAULT_PROCESSID, Consts.DOT, PackagingURIHelper.FORWARD_SLASH_STRING, ParameterizedMessage.ERROR_MSG_SEPARATOR, ";", "<", "=", ">", "?", "[", "]", VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ",", Consts.DOT, "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: com.google.zxing.aztec.decoder.Decoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

        static {
            int[] iArr = new int[Table.values().length];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = readByte(zArr, i5 << 3);
        }
        return bArr;
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        int i5;
        GenericGF genericGF;
        if (this.ddata.getNbLayers() <= 2) {
            genericGF = GenericGF.AZTEC_DATA_6;
            i5 = 6;
        } else {
            i5 = 8;
            if (this.ddata.getNbLayers() <= 8) {
                genericGF = GenericGF.AZTEC_DATA_8;
            } else if (this.ddata.getNbLayers() <= 22) {
                genericGF = GenericGF.AZTEC_DATA_10;
                i5 = 10;
            } else {
                genericGF = GenericGF.AZTEC_DATA_12;
                i5 = 12;
            }
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i5;
        if (length < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i5;
        int[] iArr = new int[length];
        int i6 = 0;
        while (i6 < length) {
            iArr[i6] = readCode(zArr, length2, i5);
            i6++;
            length2 += i5;
        }
        try {
            new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
            int i7 = 1 << i5;
            int i8 = i7 - 1;
            int i9 = 0;
            for (int i10 = 0; i10 < nbDatablocks; i10++) {
                int i11 = iArr[i10];
                if (i11 == 0 || i11 == i8) {
                    throw FormatException.getFormatInstance();
                }
                if (i11 == 1 || i11 == i7 - 2) {
                    i9++;
                }
            }
            boolean[] zArr2 = new boolean[(nbDatablocks * i5) - i9];
            int i12 = 0;
            for (int i13 = 0; i13 < nbDatablocks; i13++) {
                int i14 = iArr[i13];
                if (i14 == 1 || i14 == i7 - 2) {
                    Arrays.fill(zArr2, i12, (i12 + i5) - 1, i14 > 1);
                    i12 = (i5 - 1) + i12;
                } else {
                    int i15 = i5 - 1;
                    while (i15 >= 0) {
                        int i16 = i12 + 1;
                        zArr2[i12] = ((1 << i15) & i14) != 0;
                        i15--;
                        i12 = i16;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException e) {
            throw FormatException.getFormatInstance(e);
        }
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        boolean zIsCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i5 = (zIsCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[i5];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, zIsCompact)];
        int i6 = 2;
        if (zIsCompact) {
            for (int i7 = 0; i7 < i5; i7++) {
                iArr[i7] = i7;
            }
        } else {
            int i8 = i5 / 2;
            int i9 = ((((i8 - 1) / 15) * 2) + (i5 + 1)) / 2;
            for (int i10 = 0; i10 < i8; i10++) {
                int i11 = (i10 / 15) + i10;
                iArr[(i8 - i10) - 1] = (i9 - i11) - 1;
                iArr[i8 + i10] = i11 + i9 + 1;
            }
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < nbLayers) {
            int i14 = ((nbLayers - i12) << i6) + (zIsCompact ? 9 : 12);
            int i15 = i12 << 1;
            int i16 = (i5 - 1) - i15;
            int i17 = 0;
            while (i17 < i14) {
                int i18 = i17 << 1;
                int i19 = 0;
                while (i19 < i6) {
                    int i20 = i15 + i19;
                    int i21 = i15 + i17;
                    zArr[i13 + i18 + i19] = bitMatrix.get(iArr[i20], iArr[i21]);
                    int i22 = i16 - i19;
                    zArr[(i14 * 2) + i13 + i18 + i19] = bitMatrix.get(iArr[i21], iArr[i22]);
                    int i23 = iArr[i22];
                    int i24 = i16 - i17;
                    zArr[(i14 * 4) + i13 + i18 + i19] = bitMatrix.get(i23, iArr[i24]);
                    zArr[(i14 * 6) + i13 + i18 + i19] = bitMatrix.get(iArr[i24], iArr[i20]);
                    i19++;
                    i6 = 2;
                }
                i17++;
                i6 = 2;
            }
            i13 += i14 << 3;
            i12++;
            i6 = 2;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i5) {
        int i6 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i6 == 1) {
            return UPPER_TABLE[i5];
        }
        if (i6 == 2) {
            return LOWER_TABLE[i5];
        }
        if (i6 == 3) {
            return MIXED_TABLE[i5];
        }
        if (i6 == 4) {
            return PUNCT_TABLE[i5];
        }
        if (i6 == 5) {
            return DIGIT_TABLE[i5];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        int i5 = 0;
        while (i5 < length) {
            if (table != Table.BINARY) {
                int i6 = table == Table.DIGIT ? 4 : 5;
                if (length - i5 < i6) {
                    break;
                }
                int code = readCode(zArr, i5, i6);
                i5 += i6;
                String character = getCharacter(table, code);
                if (character.startsWith("CTRL_")) {
                    table2 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb.append(character);
                }
                table = table2;
            } else {
                if (length - i5 < 5) {
                    break;
                }
                int code2 = readCode(zArr, i5, 5);
                int i7 = i5 + 5;
                if (code2 == 0) {
                    if (length - i7 < 11) {
                        break;
                    }
                    code2 = readCode(zArr, i7, 11) + 31;
                    i7 = i5 + 16;
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= code2) {
                        i5 = i7;
                        break;
                    }
                    if (length - i7 < 8) {
                        i5 = length;
                        break;
                    }
                    sb.append((char) readCode(zArr, i7, 8));
                    i7 += 8;
                    i8++;
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    private static Table getTable(char c) {
        if (c == 'B') {
            return Table.BINARY;
        }
        if (c == 'D') {
            return Table.DIGIT;
        }
        if (c == 'P') {
            return Table.PUNCT;
        }
        if (c != 'L') {
            return c != 'M' ? Table.UPPER : Table.MIXED;
        }
        return Table.LOWER;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static byte readByte(boolean[] zArr, int i5) {
        int length = zArr.length - i5;
        return (byte) (length >= 8 ? readCode(zArr, i5, 8) : readCode(zArr, i5, length) << (8 - length));
    }

    private static int readCode(boolean[] zArr, int i5, int i6) {
        int i7 = 0;
        for (int i8 = i5; i8 < i5 + i6; i8++) {
            i7 <<= 1;
            if (zArr[i8]) {
                i7 |= 1;
            }
        }
        return i7;
    }

    private static int totalBitsInLayer(int i5, boolean z6) {
        return ((z6 ? 88 : 112) + (i5 << 4)) * i5;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] zArrCorrectBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(zArrCorrectBits), getEncodedData(zArrCorrectBits), null, null);
        decoderResult.setNumBits(zArrCorrectBits.length);
        return decoderResult;
    }
}
