package org.apache.xmlbeans.impl.regex;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
final class RangeToken extends Token implements Serializable {
    private static final int MAPSIZE = 256;
    boolean compacted;
    RangeToken icaseCache;
    int[] map;
    int nonMapIndex;
    int[] ranges;
    boolean sorted;

    public RangeToken(int i5) {
        super(i5);
        this.icaseCache = null;
        this.map = null;
        setSorted(false);
    }

    public static Token complementRanges(Token token) {
        int i5 = token.type;
        if (i5 != 4 && i5 != 5) {
            throw new IllegalArgumentException("Token#complementRanges(): must be RANGE: " + token.type);
        }
        RangeToken rangeToken = (RangeToken) token;
        rangeToken.sortRanges();
        rangeToken.compactRanges();
        int[] iArr = rangeToken.ranges;
        int length = iArr.length;
        int i6 = length + 2;
        int i7 = 0;
        if (iArr[0] != 0) {
            length = i6;
        }
        int i8 = iArr[iArr.length - 1];
        if (i8 == 1114111) {
            length -= 2;
        }
        RangeToken rangeTokenCreateRange = Token.createRange();
        int[] iArr2 = new int[length];
        rangeTokenCreateRange.ranges = iArr2;
        int[] iArr3 = rangeToken.ranges;
        if (iArr3[0] > 0) {
            iArr2[0] = 0;
            iArr2[1] = iArr3[0] - 1;
            i7 = 2;
        }
        int i9 = 1;
        while (true) {
            int[] iArr4 = rangeToken.ranges;
            if (i9 >= iArr4.length - 2) {
                break;
            }
            int[] iArr5 = rangeTokenCreateRange.ranges;
            int i10 = i7 + 1;
            iArr5[i7] = iArr4[i9] + 1;
            i7 += 2;
            iArr5[i10] = iArr4[i9 + 1] - 1;
            i9 += 2;
        }
        if (i8 != 1114111) {
            int[] iArr6 = rangeTokenCreateRange.ranges;
            iArr6[i7] = i8 + 1;
            iArr6[i7 + 1] = 1114111;
        }
        rangeTokenCreateRange.setCompacted();
        return rangeTokenCreateRange;
    }

    private void createMap() {
        int[] iArr = new int[8];
        int length = this.ranges.length;
        int i5 = 0;
        for (int i6 = 0; i6 < 8; i6++) {
            iArr[i6] = 0;
        }
        while (true) {
            int[] iArr2 = this.ranges;
            if (i5 >= iArr2.length) {
                break;
            }
            int i7 = iArr2[i5];
            int i8 = iArr2[i5 + 1];
            if (i7 < 256) {
                while (i7 <= i8 && i7 < 256) {
                    int i9 = i7 / 32;
                    iArr[i9] = iArr[i9] | (1 << (i7 & 31));
                    i7++;
                }
                if (i8 < 256) {
                    i5 += 2;
                }
            }
            length = i5;
            break;
        }
        this.nonMapIndex = length;
        this.map = iArr;
    }

    private static String escapeCharInCharClass(int i5) {
        if (i5 == 9) {
            return "\\t";
        }
        if (i5 == 10) {
            return "\\n";
        }
        if (i5 == 12) {
            return "\\f";
        }
        if (i5 == 13) {
            return "\\r";
        }
        if (i5 == 27) {
            return "\\e";
        }
        if (i5 != 44 && i5 != 45) {
            switch (i5) {
                case 91:
                case 92:
                case 93:
                case 94:
                    break;
                default:
                    if (i5 < 32) {
                        String str = "0" + Integer.toHexString(i5);
                        return "\\x" + str.substring(str.length() - 2);
                    }
                    if (i5 < 65536) {
                        return "" + ((char) i5);
                    }
                    String str2 = "0" + Integer.toHexString(i5);
                    return "\\v" + str2.substring(str2.length() - 6);
            }
        }
        return "\\" + ((char) i5);
    }

    private boolean isCompacted() {
        return this.compacted;
    }

    private boolean isSorted() {
        return this.sorted;
    }

    private void setCompacted() {
        this.compacted = true;
    }

    private void setSorted(boolean z6) {
        this.sorted = z6;
        if (z6) {
            return;
        }
        this.compacted = false;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void addRange(int i5, int i6) {
        this.icaseCache = null;
        if (i5 > i6) {
            i6 = i5;
            i5 = i6;
        }
        int[] iArr = this.ranges;
        if (iArr == null) {
            this.ranges = new int[]{i5, i6};
            setSorted(true);
            return;
        }
        int length = iArr.length;
        int i7 = length - 1;
        if (iArr[i7] + 1 == i5) {
            iArr[i7] = i6;
            return;
        }
        int[] iArr2 = new int[length + 2];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.ranges = iArr2;
        if (iArr2[i7] >= i5) {
            setSorted(false);
        }
        int[] iArr3 = this.ranges;
        iArr3[length] = i5;
        iArr3[length + 1] = i6;
        if (this.sorted) {
            return;
        }
        sortRanges();
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void compactRanges() {
        int i5;
        int i6;
        int[] iArr = this.ranges;
        if (iArr == null || iArr.length <= 2 || isCompacted()) {
            return;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[] iArr2 = this.ranges;
            if (i7 >= iArr2.length) {
                if (i8 != iArr2.length) {
                    int[] iArr3 = new int[i8];
                    System.arraycopy(iArr2, 0, iArr3, 0, i8);
                    this.ranges = iArr3;
                }
                setCompacted();
                return;
            }
            if (i8 != i7) {
                int i9 = i7 + 1;
                iArr2[i8] = iArr2[i7];
                i7 += 2;
                iArr2[i8 + 1] = iArr2[i9];
            } else {
                i7 += 2;
            }
            int i10 = i8 + 1;
            int i11 = iArr2[i10];
            while (true) {
                int[] iArr4 = this.ranges;
                if (i7 >= iArr4.length || (i5 = i11 + 1) < (i6 = iArr4[i7])) {
                    break;
                }
                if (i5 == i6) {
                    i11 = iArr4[i7 + 1];
                    iArr4[i10] = i11;
                } else {
                    int i12 = i7 + 1;
                    int i13 = iArr4[i12];
                    if (i11 < i13) {
                        if (i11 >= i13) {
                            StringBuilder sb = new StringBuilder("Token#compactRanges(): Internel Error: [");
                            sb.append(this.ranges[i8]);
                            sb.append(",");
                            sb.append(this.ranges[i10]);
                            sb.append("] [");
                            sb.append(this.ranges[i7]);
                            sb.append(",");
                            throw new RuntimeException(AbstractC0157z.l("]", this.ranges[i12], sb));
                        }
                        iArr4[i10] = i13;
                        i7 += 2;
                        i11 = i13;
                    }
                }
                i7 += 2;
            }
            i8 += 2;
        }
    }

    public synchronized RangeToken getCaseInsensitiveToken() {
        try {
            RangeToken rangeToken = this.icaseCache;
            if (rangeToken != null) {
                return rangeToken;
            }
            RangeToken rangeTokenCreateRange = this.type == 4 ? Token.createRange() : Token.createNRange();
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int[] iArr = this.ranges;
                if (i6 >= iArr.length) {
                    break;
                }
                for (int i7 = iArr[i6]; i7 <= this.ranges[i6 + 1]; i7++) {
                    if (i7 > 65535) {
                        rangeTokenCreateRange.addRange(i7, i7);
                    } else {
                        char upperCase = Character.toUpperCase((char) i7);
                        rangeTokenCreateRange.addRange(upperCase, upperCase);
                    }
                }
                i6 += 2;
            }
            RangeToken rangeTokenCreateRange2 = this.type == 4 ? Token.createRange() : Token.createNRange();
            while (true) {
                int[] iArr2 = rangeTokenCreateRange.ranges;
                if (i5 >= iArr2.length) {
                    rangeTokenCreateRange2.mergeRanges(rangeTokenCreateRange);
                    rangeTokenCreateRange2.mergeRanges(this);
                    rangeTokenCreateRange2.compactRanges();
                    this.icaseCache = rangeTokenCreateRange2;
                    return rangeTokenCreateRange2;
                }
                for (int i8 = iArr2[i5]; i8 <= rangeTokenCreateRange.ranges[i5 + 1]; i8++) {
                    if (i8 > 65535) {
                        rangeTokenCreateRange2.addRange(i8, i8);
                    } else {
                        char upperCase2 = Character.toUpperCase((char) i8);
                        rangeTokenCreateRange2.addRange(upperCase2, upperCase2);
                    }
                }
                i5 += 2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void intersectRanges(Token token) {
        RangeToken rangeToken = (RangeToken) token;
        if (rangeToken.ranges == null || this.ranges == null) {
            return;
        }
        this.icaseCache = null;
        sortRanges();
        compactRanges();
        rangeToken.sortRanges();
        rangeToken.compactRanges();
        int[] iArr = new int[this.ranges.length + rangeToken.ranges.length];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr2 = this.ranges;
            if (i5 >= iArr2.length) {
                break;
            }
            int[] iArr3 = rangeToken.ranges;
            if (i6 >= iArr3.length) {
                break;
            }
            int i8 = iArr2[i5];
            int i9 = i5 + 1;
            int i10 = iArr2[i9];
            int i11 = iArr3[i6];
            int i12 = i6 + 1;
            int i13 = iArr3[i12];
            if (i10 >= i11) {
                if (i10 < i11 || i8 > i13) {
                    if (i13 >= i8) {
                        StringBuilder sb = new StringBuilder("Token#intersectRanges(): Internal Error: [");
                        sb.append(this.ranges[i5]);
                        sb.append(",");
                        sb.append(this.ranges[i9]);
                        sb.append("] & [");
                        sb.append(rangeToken.ranges[i6]);
                        sb.append(",");
                        throw new RuntimeException(AbstractC0157z.l("]", rangeToken.ranges[i12], sb));
                    }
                    i6 += 2;
                } else if (i11 <= i8 && i10 <= i13) {
                    int i14 = i7 + 1;
                    iArr[i7] = i8;
                    i7 += 2;
                    iArr[i14] = i10;
                } else if (i11 <= i8) {
                    int i15 = i7 + 1;
                    iArr[i7] = i8;
                    i7 += 2;
                    iArr[i15] = i13;
                    iArr2[i5] = i13 + 1;
                    i6 += 2;
                } else if (i10 <= i13) {
                    int i16 = i7 + 1;
                    iArr[i7] = i11;
                    i7 += 2;
                    iArr[i16] = i10;
                } else {
                    int i17 = i7 + 1;
                    iArr[i7] = i11;
                    i7 += 2;
                    iArr[i17] = i13;
                    iArr2[i5] = i13 + 1;
                }
            }
            i5 += 2;
        }
        while (true) {
            int[] iArr4 = this.ranges;
            if (i5 >= iArr4.length) {
                int[] iArr5 = new int[i7];
                this.ranges = iArr5;
                System.arraycopy(iArr, 0, iArr5, 0, i7);
                return;
            } else {
                int i18 = i7 + 1;
                int i19 = i5 + 1;
                iArr[i7] = iArr4[i5];
                i7 += 2;
                i5 += 2;
                iArr[i18] = iArr4[i19];
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public boolean match(int i5) {
        if (this.map == null) {
            createMap();
        }
        if (this.type == 4) {
            if (i5 < 256) {
                return ((1 << (i5 & 31)) & this.map[i5 / 32]) != 0;
            }
            int i6 = this.nonMapIndex;
            while (true) {
                int[] iArr = this.ranges;
                if (i6 >= iArr.length) {
                    return false;
                }
                if (iArr[i6] <= i5 && i5 <= iArr[i6 + 1]) {
                    return true;
                }
                i6 += 2;
            }
        } else {
            if (i5 < 256) {
                return ((1 << (i5 & 31)) & this.map[i5 / 32]) == 0;
            }
            int i7 = this.nonMapIndex;
            while (true) {
                int[] iArr2 = this.ranges;
                if (i7 >= iArr2.length) {
                    return true;
                }
                if (iArr2[i7] <= i5 && i5 <= iArr2[i7 + 1]) {
                    return false;
                }
                i7 += 2;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void mergeRanges(Token token) {
        RangeToken rangeToken = (RangeToken) token;
        sortRanges();
        rangeToken.sortRanges();
        if (rangeToken.ranges == null) {
            return;
        }
        this.icaseCache = null;
        setSorted(true);
        int[] iArr = this.ranges;
        int i5 = 0;
        if (iArr == null) {
            int[] iArr2 = new int[rangeToken.ranges.length];
            this.ranges = iArr2;
            int[] iArr3 = rangeToken.ranges;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            return;
        }
        int[] iArr4 = new int[iArr.length + rangeToken.ranges.length];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr5 = this.ranges;
            if (i5 >= iArr5.length && i6 >= rangeToken.ranges.length) {
                this.ranges = iArr4;
                return;
            }
            if (i5 >= iArr5.length) {
                int i8 = i7 + 1;
                int[] iArr6 = rangeToken.ranges;
                int i9 = i6 + 1;
                iArr4[i7] = iArr6[i6];
                i7 += 2;
                i6 += 2;
                iArr4[i8] = iArr6[i9];
            } else {
                int[] iArr7 = rangeToken.ranges;
                if (i6 >= iArr7.length) {
                    int i10 = i7 + 1;
                    int i11 = i5 + 1;
                    iArr4[i7] = iArr5[i5];
                    i7 += 2;
                    i5 += 2;
                    iArr4[i10] = iArr5[i11];
                } else {
                    int i12 = iArr7[i6];
                    int i13 = iArr5[i5];
                    if (i12 < i13 || (i12 == i13 && iArr7[i6 + 1] < iArr5[i5 + 1])) {
                        int i14 = i7 + 1;
                        int i15 = i6 + 1;
                        iArr4[i7] = i12;
                        i7 += 2;
                        i6 += 2;
                        iArr4[i14] = iArr7[i15];
                    } else {
                        int i16 = i7 + 1;
                        int i17 = i5 + 1;
                        iArr4[i7] = i13;
                        i7 += 2;
                        i5 += 2;
                        iArr4[i16] = iArr5[i17];
                    }
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void sortRanges() {
        int[] iArr;
        if (isSorted() || (iArr = this.ranges) == null) {
            return;
        }
        for (int length = iArr.length - 4; length >= 0; length -= 2) {
            int i5 = 0;
            while (i5 <= length) {
                int[] iArr2 = this.ranges;
                int i6 = iArr2[i5];
                int i7 = i5 + 2;
                int i8 = iArr2[i7];
                if (i6 > i8 || (i6 == i8 && iArr2[i5 + 1] > iArr2[i5 + 3])) {
                    iArr2[i7] = i6;
                    iArr2[i5] = i8;
                    int i9 = i5 + 3;
                    int i10 = iArr2[i9];
                    int i11 = i5 + 1;
                    iArr2[i9] = iArr2[i11];
                    iArr2[i11] = i10;
                }
                i5 = i7;
            }
        }
        setSorted(true);
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void subtractRanges(Token token) {
        if (token.type == 5) {
            intersectRanges(token);
            return;
        }
        RangeToken rangeToken = (RangeToken) token;
        if (rangeToken.ranges == null || this.ranges == null) {
            return;
        }
        this.icaseCache = null;
        sortRanges();
        compactRanges();
        rangeToken.sortRanges();
        rangeToken.compactRanges();
        int[] iArr = new int[this.ranges.length + rangeToken.ranges.length];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr2 = this.ranges;
            if (i5 >= iArr2.length) {
                break;
            }
            int[] iArr3 = rangeToken.ranges;
            if (i6 >= iArr3.length) {
                break;
            }
            int i8 = iArr2[i5];
            int i9 = i5 + 1;
            int i10 = iArr2[i9];
            int i11 = iArr3[i6];
            int i12 = i6 + 1;
            int i13 = iArr3[i12];
            if (i10 < i11) {
                int i14 = i7 + 1;
                iArr[i7] = i8;
                i7 += 2;
                i5 += 2;
                iArr[i14] = iArr2[i9];
            } else if (i10 < i11 || i8 > i13) {
                if (i13 >= i8) {
                    StringBuilder sb = new StringBuilder("Token#subtractRanges(): Internal Error: [");
                    sb.append(this.ranges[i5]);
                    sb.append(",");
                    sb.append(this.ranges[i9]);
                    sb.append("] - [");
                    sb.append(rangeToken.ranges[i6]);
                    sb.append(",");
                    throw new RuntimeException(AbstractC0157z.l("]", rangeToken.ranges[i12], sb));
                }
                i6 += 2;
            } else {
                if (i11 > i8 || i10 > i13) {
                    if (i11 <= i8) {
                        iArr2[i5] = i13 + 1;
                    } else if (i10 <= i13) {
                        int i15 = i7 + 1;
                        iArr[i7] = i8;
                        i7 += 2;
                        iArr[i15] = i11 - 1;
                    } else {
                        int i16 = i7 + 1;
                        iArr[i7] = i8;
                        i7 += 2;
                        iArr[i16] = i11 - 1;
                        iArr2[i5] = i13 + 1;
                    }
                    i6 += 2;
                }
                i5 += 2;
            }
        }
        while (true) {
            int[] iArr4 = this.ranges;
            if (i5 >= iArr4.length) {
                int[] iArr5 = new int[i7];
                this.ranges = iArr5;
                System.arraycopy(iArr, 0, iArr5, 0, i7);
                return;
            } else {
                int i17 = i7 + 1;
                int i18 = i5 + 1;
                iArr[i7] = iArr4[i5];
                i7 += 2;
                i5 += 2;
                iArr[i17] = iArr4[i18];
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public String toString(int i5) {
        int i6 = 0;
        if (this.type != 4) {
            if (this == Token.token_not_0to9) {
                return "\\D";
            }
            if (this == Token.token_not_wordchars) {
                return "\\W";
            }
            if (this == Token.token_not_spaces) {
                return "\\S";
            }
            StringBuilder sb = new StringBuilder("[^");
            while (i6 < this.ranges.length) {
                if ((i5 & 1024) != 0 && i6 > 0) {
                    sb.append(",");
                }
                int[] iArr = this.ranges;
                int i7 = iArr[i6];
                int i8 = i6 + 1;
                if (i7 == iArr[i8]) {
                    sb.append(escapeCharInCharClass(i7));
                } else {
                    sb.append(escapeCharInCharClass(i7));
                    sb.append('-');
                    sb.append(escapeCharInCharClass(this.ranges[i8]));
                }
                i6 += 2;
            }
            sb.append("]");
            return sb.toString();
        }
        if (this == Token.token_dot) {
            return Consts.DOT;
        }
        if (this == Token.token_0to9) {
            return "\\d";
        }
        if (this == Token.token_wordchars) {
            return "\\w";
        }
        if (this == Token.token_spaces) {
            return "\\s";
        }
        StringBuilder sb2 = new StringBuilder("[");
        while (i6 < this.ranges.length) {
            if ((i5 & 1024) != 0 && i6 > 0) {
                sb2.append(",");
            }
            int[] iArr2 = this.ranges;
            int i9 = iArr2[i6];
            int i10 = i6 + 1;
            if (i9 == iArr2[i10]) {
                sb2.append(escapeCharInCharClass(i9));
            } else {
                sb2.append(escapeCharInCharClass(i9));
                sb2.append('-');
                sb2.append(escapeCharInCharClass(this.ranges[i10]));
            }
            i6 += 2;
        }
        sb2.append("]");
        return sb2.toString();
    }
}
