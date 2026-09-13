package com.google.zxing.pdf417.encoder;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import org.apache.poi.ss.formula.ptg.RefNPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED;
    private static final int NUMERIC_COMPACTION = 2;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 38, 13, 9, RefNPtg.sid, Ref3DPtg.sid, 35, 45, 46, RefPtg.sid, 47, AreaErrPtg.sid, 37, RefErrorPtg.sid, DeletedArea3DPtg.sid, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {Area3DPtg.sid, DeletedRef3DPtg.sid, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, RefNPtg.sid, Ref3DPtg.sid, 10, 45, 46, RefPtg.sid, 47, 34, 124, RefErrorPtg.sid, 40, MemFuncPtg.sid, 63, 123, 125, 39, 0};
    private static final byte[] PUNCTUATION = new byte[128];
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[128];
        MIXED = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            byte[] bArr2 = TEXT_MIXED_RAW;
            if (i6 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i6];
            if (b > 0) {
                MIXED[b] = (byte) i6;
            }
            i6++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr3 = TEXT_PUNCTUATION_RAW;
            if (i5 >= bArr3.length) {
                return;
            }
            byte b6 = bArr3[i5];
            if (b6 > 0) {
                PUNCTUATION[b6] = (byte) i5;
            }
            i5++;
        }
    }

    private PDF417HighLevelEncoder() {
    }

    private static int determineConsecutiveBinaryCount(String str, int i5, Charset charset) throws WriterException {
        int i6;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i7 = i5;
        while (i7 < length) {
            char cCharAt = str.charAt(i7);
            int i8 = 0;
            while (i8 < 13 && isDigit(cCharAt) && (i6 = i7 + (i8 = i8 + 1)) < length) {
                cCharAt = str.charAt(i6);
            }
            if (i8 >= 13) {
                return i7 - i5;
            }
            char cCharAt2 = str.charAt(i7);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new WriterException("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i7++;
        }
        return i7 - i5;
    }

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        if (i5 < length) {
            char cCharAt = charSequence.charAt(i5);
            while (isDigit(cCharAt) && i5 < length) {
                i6++;
                i5++;
                if (i5 < length) {
                    cCharAt = charSequence.charAt(i5);
                }
            }
        }
        return i6;
    }

    private static int determineConsecutiveTextCount(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = i5;
        while (i6 < length) {
            char cCharAt = charSequence.charAt(i6);
            int i7 = 0;
            while (i7 < 13 && isDigit(cCharAt) && i6 < length) {
                i7++;
                i6++;
                if (i6 < length) {
                    cCharAt = charSequence.charAt(i6);
                }
            }
            if (i7 < 13) {
                if (i7 <= 0) {
                    if (!isText(charSequence.charAt(i6))) {
                        break;
                    }
                    i6++;
                }
            } else {
                return (i6 - i5) - i7;
            }
        }
        return i6 - i5;
    }

    private static void encodeBinary(byte[] bArr, int i5, int i6, int i7, StringBuilder sb) {
        int i8;
        if (i6 == 1 && i7 == 0) {
            sb.append((char) 913);
        } else if (i6 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i6 >= 6) {
            char[] cArr = new char[5];
            i8 = i5;
            while ((i5 + i6) - i8 >= 6) {
                long j6 = 0;
                for (int i9 = 0; i9 < 6; i9++) {
                    j6 = (j6 << 8) + ((long) (bArr[i8 + i9] & UnsignedBytes.MAX_VALUE));
                }
                for (int i10 = 0; i10 < 5; i10++) {
                    cArr[i10] = (char) (j6 % 900);
                    j6 /= 900;
                }
                for (int i11 = 4; i11 >= 0; i11--) {
                    sb.append(cArr[i11]);
                }
                i8 += 6;
            }
        } else {
            i8 = i5;
        }
        while (i8 < i5 + i6) {
            sb.append((char) (bArr[i8] & UnsignedBytes.MAX_VALUE));
            i8++;
        }
    }

    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
            encodingECI(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        if (compaction == Compaction.TEXT) {
            encodeText(str, 0, length, sb, 0);
        } else if (compaction == Compaction.BYTE) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (compaction == Compaction.NUMERIC) {
            sb.append((char) 902);
            encodeNumeric(str, 0, length, sb);
        } else {
            int i5 = 0;
            int iEncodeText = 0;
            int i6 = 0;
            while (i5 < length) {
                int iDetermineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i5);
                if (iDetermineConsecutiveDigitCount >= 13) {
                    sb.append((char) 902);
                    encodeNumeric(str, i5, iDetermineConsecutiveDigitCount, sb);
                    i5 += iDetermineConsecutiveDigitCount;
                    i6 = 2;
                    iEncodeText = 0;
                } else {
                    int iDetermineConsecutiveTextCount = determineConsecutiveTextCount(str, i5);
                    if (iDetermineConsecutiveTextCount >= 5 || iDetermineConsecutiveDigitCount == length) {
                        if (i6 != 0) {
                            sb.append((char) 900);
                            iEncodeText = 0;
                            i6 = 0;
                        }
                        iEncodeText = encodeText(str, i5, iDetermineConsecutiveTextCount, sb, iEncodeText);
                        i5 += iDetermineConsecutiveTextCount;
                    } else {
                        int iDetermineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i5, charset);
                        if (iDetermineConsecutiveBinaryCount == 0) {
                            iDetermineConsecutiveBinaryCount = 1;
                        }
                        int i7 = iDetermineConsecutiveBinaryCount + i5;
                        byte[] bytes2 = str.substring(i5, i7).getBytes(charset);
                        if (bytes2.length == 1 && i6 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i6, sb);
                            iEncodeText = 0;
                            i6 = 1;
                        }
                        i5 = i7;
                    }
                }
            }
        }
        return sb.toString();
    }

    private static void encodeNumeric(String str, int i5, int i6, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i6 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i7 = 0;
        while (i7 < i6) {
            sb2.setLength(0);
            int iMin = Math.min(44, i6 - i7);
            StringBuilder sb3 = new StringBuilder("1");
            int i8 = i5 + i7;
            sb3.append(str.substring(i8, i8 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i7 += iMin;
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x00f4 A[EDGE_INSN: B:73:0x00f4->B:55:0x00f4 BREAK  A[LOOP:0: B:3:0x000f->B:90:0x000f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x000f A[SYNTHETIC] */
    private static int encodeText(CharSequence charSequence, int i5, int i6, StringBuilder sb, int i7) {
        StringBuilder sb2 = new StringBuilder(i6);
        int i8 = i7;
        int i9 = 0;
        while (true) {
            int i10 = i5 + i9;
            char cCharAt = charSequence.charAt(i10);
            if (i8 == 0) {
                if (isAlphaUpper(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'A'));
                    }
                } else if (isAlphaLower(cCharAt)) {
                    sb2.append((char) 27);
                    i8 = 1;
                } else if (isMixed(cCharAt)) {
                    sb2.append((char) 28);
                    i8 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) PUNCTUATION[cCharAt]);
                }
                i9++;
                if (i9 >= i6) {
                    break;
                    break;
                }
            } else {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (isPunctuation(cCharAt)) {
                            sb2.append((char) PUNCTUATION[cCharAt]);
                        } else {
                            sb2.append((char) 29);
                            i8 = 0;
                        }
                    } else if (isMixed(cCharAt)) {
                        sb2.append((char) MIXED[cCharAt]);
                    } else if (isAlphaUpper(cCharAt)) {
                        sb2.append((char) 28);
                        i8 = 0;
                    } else if (isAlphaLower(cCharAt)) {
                        sb2.append((char) 27);
                        i8 = 1;
                    } else {
                        int i11 = i10 + 1;
                        if (i11 >= i6 || !isPunctuation(charSequence.charAt(i11))) {
                            sb2.append((char) 29);
                            sb2.append((char) PUNCTUATION[cCharAt]);
                        } else {
                            sb2.append((char) 25);
                            i8 = 3;
                        }
                    }
                } else if (isAlphaLower(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'a'));
                    }
                } else if (isAlphaUpper(cCharAt)) {
                    sb2.append((char) 27);
                    sb2.append((char) (cCharAt - 'A'));
                } else if (isMixed(cCharAt)) {
                    sb2.append((char) 28);
                    i8 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) PUNCTUATION[cCharAt]);
                }
                i9++;
                if (i9 >= i6) {
                    break;
                }
            }
        }
        int length = sb2.length();
        char cCharAt2 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (i12 % 2 != 0) {
                cCharAt2 = (char) (sb2.charAt(i12) + (cCharAt2 * 30));
                sb.append(cCharAt2);
            } else {
                cCharAt2 = sb2.charAt(i12);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((cCharAt2 * 30) + 29));
        }
        return i8;
    }

    private static void encodingECI(int i5, StringBuilder sb) throws WriterException {
        if (i5 >= 0 && i5 < 900) {
            sb.append((char) 927);
            sb.append((char) i5);
        } else if (i5 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i5 / 900) - 1));
            sb.append((char) (i5 % 900));
        } else {
            if (i5 >= 811800) {
                throw new WriterException(AbstractC0157z.k(i5, "ECI number not in valid range from 0..811799, but was "));
            }
            sb.append((char) 925);
            sb.append((char) (810900 - i5));
        }
    }

    private static boolean isAlphaLower(char c) {
        if (c != ' ') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    private static boolean isAlphaUpper(char c) {
        if (c != ' ') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isMixed(char c) {
        return MIXED[c] != -1;
    }

    private static boolean isPunctuation(char c) {
        return PUNCTUATION[c] != -1;
    }

    private static boolean isText(char c) {
        if (c == '\t' || c == '\n' || c == '\r') {
            return true;
        }
        return c >= ' ' && c <= '~';
    }
}
