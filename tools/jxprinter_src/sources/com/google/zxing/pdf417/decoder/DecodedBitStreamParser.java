package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i5 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i5 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i5] = bigIntegerArr2[i5 - 1].multiply(bigIntegerValueOf);
            i5++;
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i5, int[] iArr, Charset charset, int i6, StringBuilder sb) {
        int i7;
        char c;
        char c6;
        int i8;
        int i9;
        int i10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        if (i5 == 901) {
            int[] iArr2 = new int[6];
            int i12 = i6 + 1;
            int i13 = iArr[i6];
            long j6 = 0;
            boolean z6 = false;
            int i14 = 0;
            while (true) {
                i8 = iArr[i11];
                if (i12 >= i8 || z6) {
                    break;
                }
                int i15 = i14 + 1;
                iArr2[i14] = i13;
                int i16 = i11;
                j6 = (j6 * 900) + ((long) i13);
                i12++;
                int i17 = iArr[i12];
                if (i17 == 900 || i17 == 901 || i17 == 902 || i17 == BYTE_COMPACTION_MODE_LATCH_6 || i17 == 928 || i17 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i17 == MACRO_PDF417_TERMINATOR) {
                    i13 = i17;
                    i14 = i15;
                    i11 = i16;
                    z6 = true;
                } else {
                    if (i15 % 5 != 0 || i15 <= 0) {
                        i10 = i17;
                        i14 = i15;
                        i11 = i16;
                    } else {
                        int i18 = i16;
                        while (i18 < 6) {
                            byteArrayOutputStream.write((byte) (j6 >> ((5 - i18) * 8)));
                            i18++;
                            i17 = i17;
                        }
                        i10 = i17;
                        i11 = i16;
                        i14 = i11;
                        j6 = 0;
                    }
                    i13 = i10;
                }
            }
            int i19 = i11;
            if (i12 != i8 || i13 >= 900) {
                i9 = i14;
            } else {
                i9 = i14 + 1;
                iArr2[i14] = i13;
            }
            for (int i20 = i19; i20 < i9; i20++) {
                byteArrayOutputStream.write((byte) iArr2[i20]);
            }
            i7 = i12;
        } else if (i5 == BYTE_COMPACTION_MODE_LATCH_6) {
            i7 = i6;
            boolean z7 = false;
            int i21 = 0;
            long j7 = 0;
            while (i7 < iArr[0] && !z7) {
                int i22 = i7 + 1;
                int i23 = iArr[i7];
                if (i23 < 900) {
                    i21++;
                    j7 = (j7 * 900) + ((long) i23);
                    i7 = i22;
                    c = 923;
                    c6 = 922;
                } else {
                    if (i23 == 900 || i23 == 901 || i23 == 902 || i23 == BYTE_COMPACTION_MODE_LATCH_6 || i23 == 928) {
                        c = 923;
                        c6 = 922;
                    } else {
                        c = 923;
                        c6 = 922;
                        if (i23 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD && i23 != MACRO_PDF417_TERMINATOR) {
                            i7 = i22;
                        }
                    }
                    z7 = true;
                }
                if (i21 % 5 == 0 && i21 > 0) {
                    for (int i24 = 0; i24 < 6; i24++) {
                        byteArrayOutputStream.write((byte) (j7 >> ((5 - i24) * 8)));
                    }
                    i21 = 0;
                    j7 = 0;
                }
            }
        } else {
            i7 = i6;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i7;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    public static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int iTextCompaction;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charsetForName = DEFAULT_ENCODING;
        int i5 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i6 = 2;
        while (i6 < iArr[0]) {
            if (i5 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i5) {
                    case 900:
                        iTextCompaction = textCompaction(iArr, i6, sb);
                        break;
                    case 901:
                        iTextCompaction = byteCompaction(i5, iArr, charsetForName, i6, sb);
                        break;
                    case 902:
                        iTextCompaction = numericCompaction(iArr, i6, sb);
                        break;
                    default:
                        switch (i5) {
                            case MACRO_PDF417_TERMINATOR /* 922 */:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                iTextCompaction = byteCompaction(i5, iArr, charsetForName, i6, sb);
                                break;
                            case ECI_USER_DEFINED /* 925 */:
                                iTextCompaction = i6 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /* 926 */:
                                iTextCompaction = i6 + 2;
                                break;
                            case ECI_CHARSET /* 927 */:
                                iTextCompaction = i6 + 1;
                                charsetForName = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i6]).name());
                                break;
                            case 928:
                                iTextCompaction = decodeMacroBlock(iArr, i6, pDF417ResultMetadata);
                                break;
                            default:
                                iTextCompaction = textCompaction(iArr, i6 - 1, sb);
                                break;
                        }
                        break;
                }
            } else {
                iTextCompaction = i6 + 1;
                sb.append((char) iArr[i6]);
            }
            if (iTextCompaction >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            i6 = iTextCompaction + 1;
            i5 = iArr[iTextCompaction];
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    private static String decodeBase900toBase10(int[] iArr, int i5) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i6 = 0; i6 < i5; i6++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i5 - i6) - 1].multiply(BigInteger.valueOf(iArr[i6])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i5, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i5 + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i6 = 0;
        while (i6 < 2) {
            iArr2[i6] = iArr[i5];
            i6++;
            i5++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iTextCompaction = textCompaction(iArr, i5, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        int i7 = iArr[iTextCompaction];
        if (i7 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            if (i7 != MACRO_PDF417_TERMINATOR) {
                return iTextCompaction;
            }
            pDF417ResultMetadata.setLastSegment(true);
            return iTextCompaction + 1;
        }
        int i8 = iTextCompaction + 1;
        int[] iArr3 = new int[iArr[0] - i8];
        boolean z6 = false;
        int i9 = 0;
        while (i8 < iArr[0] && !z6) {
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            if (i11 < 900) {
                iArr3[i9] = i11;
                i9++;
                i8 = i10;
            } else {
                if (i11 != MACRO_PDF417_TERMINATOR) {
                    throw FormatException.getFormatInstance();
                }
                pDF417ResultMetadata.setLastSegment(true);
                i8 += 2;
                z6 = true;
            }
        }
        pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i9));
        return i8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i5, StringBuilder sb) {
        Mode mode;
        int i6;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = iArr[i7];
            int i9 = AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode2.ordinal()];
            char c = Chars.SPACE;
            switch (i9) {
                case 1:
                    if (i8 < 26) {
                        i6 = i8 + 65;
                        c = (char) i6;
                    } else if (i8 != 26) {
                        if (i8 == 27) {
                            mode2 = Mode.LOWER;
                        } else if (i8 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i8 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                            Mode mode4 = mode;
                            mode3 = mode2;
                            mode2 = mode4;
                        } else if (i8 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            sb.append((char) iArr2[i7]);
                        } else if (i8 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c = 0;
                    }
                    break;
                case 2:
                    if (i8 < 26) {
                        i6 = i8 + 97;
                        c = (char) i6;
                    } else if (i8 != 26) {
                        if (i8 != 27) {
                            if (i8 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i8 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                            } else if (i8 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i7]);
                            } else if (i8 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c = 0;
                        } else {
                            mode = Mode.ALPHA_SHIFT;
                        }
                        Mode mode5 = mode;
                        mode3 = mode2;
                        mode2 = mode5;
                        c = 0;
                    }
                    break;
                case 3:
                    if (i8 < 25) {
                        c = MIXED_CHARS[i8];
                    } else {
                        if (i8 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i8 != 26) {
                            if (i8 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i8 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i8 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                Mode mode6 = mode;
                                mode3 = mode2;
                                mode2 = mode6;
                            } else if (i8 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i7]);
                            } else if (i8 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c = 0;
                    }
                    break;
                case 4:
                    if (i8 < 29) {
                        c = PUNCT_CHARS[i8];
                    } else {
                        if (i8 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i8 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            sb.append((char) iArr2[i7]);
                        } else if (i8 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c = 0;
                    }
                    break;
                case 5:
                    if (i8 < 26) {
                        c = (char) (i8 + 65);
                    } else if (i8 != 26) {
                        if (i8 == 900) {
                            mode2 = Mode.ALPHA;
                            c = 0;
                        }
                        c = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i8 >= 29) {
                        if (i8 == 29) {
                            mode2 = Mode.ALPHA;
                        } else {
                            if (i8 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i7]);
                            } else if (i8 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c = 0;
                        }
                        c = 0;
                    } else {
                        c = PUNCT_CHARS[i8];
                    }
                    mode2 = mode3;
                    break;
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0007 A[SYNTHETIC] */
    private static int numericCompaction(int[] iArr, int i5, StringBuilder sb) {
        int[] iArr2 = new int[15];
        boolean z6 = false;
        int i6 = 0;
        while (true) {
            int i7 = iArr[0];
            if (i5 >= i7 || z6) {
                break;
            }
            int i8 = i5 + 1;
            int i9 = iArr[i5];
            if (i8 == i7) {
                z6 = true;
            }
            if (i9 < 900) {
                iArr2[i6] = i9;
                i6++;
            } else {
                if (i9 == 900 || i9 == 901 || i9 == BYTE_COMPACTION_MODE_LATCH_6 || i9 == 928 || i9 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i9 == MACRO_PDF417_TERMINATOR) {
                    z6 = true;
                }
                if (i6 % 15 != 0 || i9 == 902 || z6) {
                    if (i6 > 0) {
                        sb.append(decodeBase900toBase10(iArr2, i6));
                        i6 = 0;
                    }
                }
            }
            i5 = i8;
            if (i6 % 15 != 0) {
            }
            if (i6 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i6));
                i6 = 0;
            }
        }
        return i5;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0036. Please report as an issue. */
    private static int textCompaction(int[] iArr, int i5, StringBuilder sb) {
        int i6 = iArr[0];
        int[] iArr2 = new int[(i6 - i5) << 1];
        int[] iArr3 = new int[(i6 - i5) << 1];
        boolean z6 = false;
        int i7 = 0;
        while (i5 < iArr[0] && !z6) {
            int i8 = i5 + 1;
            int i9 = iArr[i5];
            if (i9 < 900) {
                iArr2[i7] = i9 / 30;
                iArr2[i7 + 1] = i9 % 30;
                i7 += 2;
            } else if (i9 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i9 != 928) {
                    switch (i9) {
                        case 900:
                            iArr2[i7] = 900;
                            i7++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i9) {
                                case MACRO_PDF417_TERMINATOR /* 922 */:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                }
                z6 = true;
            } else {
                iArr2[i7] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i5 += 2;
                iArr3[i7] = iArr[i8];
                i7++;
            }
            i5 = i8;
        }
        decodeTextCompaction(iArr2, iArr3, i7, sb);
        return i5;
    }
}
