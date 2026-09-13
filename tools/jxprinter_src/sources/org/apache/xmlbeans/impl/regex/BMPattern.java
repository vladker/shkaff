package org.apache.xmlbeans.impl.regex;

import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BMPattern {
    boolean ignoreCase;
    char[] pattern;
    int[] shiftTable;

    public BMPattern(String str, boolean z6) {
        this(str, 256, z6);
    }

    public int matches(CharacterIterator characterIterator, int i5, int i6) {
        char index;
        if (this.ignoreCase) {
            return matchesIgnoreCase(characterIterator, i5, i6);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i5;
        }
        int i7 = i5 + length;
        while (i7 <= i6) {
            int i8 = i7 + 1;
            int i9 = length;
            do {
                i7--;
                index = characterIterator.setIndex(i7);
                i9--;
                if (index != this.pattern[i9]) {
                    break;
                }
                if (i9 == 0) {
                    return i7;
                }
            } while (i9 > 0);
            int[] iArr = this.shiftTable;
            int i10 = iArr[index % iArr.length] + 1 + i7;
            i7 = i10 < i8 ? i8 : i10;
        }
        return -1;
    }

    public int matchesIgnoreCase(CharacterIterator characterIterator, int i5, int i6) {
        char index;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i5;
        }
        int i7 = i5 + length;
        while (i7 <= i6) {
            int i8 = i7 + 1;
            int i9 = length;
            do {
                i7--;
                index = characterIterator.setIndex(i7);
                i9--;
                char c = this.pattern[i9];
                if (index != c && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(c)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i9 == 0) {
                    return i7;
                }
            } while (i9 > 0);
            int[] iArr = this.shiftTable;
            int i10 = iArr[index % iArr.length] + 1 + i7;
            i7 = i10 < i8 ? i8 : i10;
        }
        return -1;
    }

    public BMPattern(String str, int i5, boolean z6) {
        char[] charArray = str.toCharArray();
        this.pattern = charArray;
        this.shiftTable = new int[i5];
        this.ignoreCase = z6;
        int length = charArray.length;
        int i6 = 0;
        while (true) {
            int[] iArr = this.shiftTable;
            if (i6 >= iArr.length) {
                break;
            }
            iArr[i6] = length;
            i6++;
        }
        for (int i7 = 0; i7 < length; i7++) {
            char c = this.pattern[i7];
            int i8 = (length - i7) - 1;
            int[] iArr2 = this.shiftTable;
            int length2 = c % iArr2.length;
            if (i8 < iArr2[length2]) {
                iArr2[length2] = i8;
            }
            if (this.ignoreCase) {
                char upperCase = Character.toUpperCase(c);
                int[] iArr3 = this.shiftTable;
                int length3 = upperCase % iArr3.length;
                if (i8 < iArr3[length3]) {
                    iArr3[length3] = i8;
                }
                char lowerCase = Character.toLowerCase(upperCase);
                int[] iArr4 = this.shiftTable;
                int length4 = lowerCase % iArr4.length;
                if (i8 < iArr4[length4]) {
                    iArr4[length4] = i8;
                }
            }
        }
    }

    public int matches(String str, int i5, int i6) {
        char cCharAt;
        if (this.ignoreCase) {
            return matchesIgnoreCase(str, i5, i6);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i5;
        }
        int i7 = i5 + length;
        while (i7 <= i6) {
            int i8 = i7 + 1;
            int i9 = length;
            do {
                i7--;
                cCharAt = str.charAt(i7);
                i9--;
                if (cCharAt != this.pattern[i9]) {
                    break;
                }
                if (i9 == 0) {
                    return i7;
                }
            } while (i9 > 0);
            int[] iArr = this.shiftTable;
            int i10 = iArr[cCharAt % iArr.length] + 1 + i7;
            i7 = i10 < i8 ? i8 : i10;
        }
        return -1;
    }

    public int matchesIgnoreCase(String str, int i5, int i6) {
        char cCharAt;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i5;
        }
        int i7 = i5 + length;
        while (i7 <= i6) {
            int i8 = i7 + 1;
            int i9 = length;
            do {
                i7--;
                cCharAt = str.charAt(i7);
                i9--;
                char c = this.pattern[i9];
                if (cCharAt != c && (upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(c)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i9 == 0) {
                    return i7;
                }
            } while (i9 > 0);
            int[] iArr = this.shiftTable;
            int i10 = iArr[cCharAt % iArr.length] + 1 + i7;
            i7 = i10 < i8 ? i8 : i10;
        }
        return -1;
    }

    public int matches(char[] cArr, int i5, int i6) {
        char c;
        if (this.ignoreCase) {
            return matchesIgnoreCase(cArr, i5, i6);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i5;
        }
        int i7 = i5 + length;
        while (i7 <= i6) {
            int i8 = i7 + 1;
            int i9 = length;
            do {
                i7--;
                c = cArr[i7];
                i9--;
                if (c != this.pattern[i9]) {
                    break;
                }
                if (i9 == 0) {
                    return i7;
                }
            } while (i9 > 0);
            int[] iArr = this.shiftTable;
            int i10 = iArr[c % iArr.length] + 1 + i7;
            i7 = i10 < i8 ? i8 : i10;
        }
        return -1;
    }

    public int matchesIgnoreCase(char[] cArr, int i5, int i6) {
        char c;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i5;
        }
        int i7 = i5 + length;
        while (i7 <= i6) {
            int i8 = i7 + 1;
            int i9 = length;
            do {
                i7--;
                c = cArr[i7];
                i9--;
                char c6 = this.pattern[i9];
                if (c != c6 && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(c6)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i9 == 0) {
                    return i7;
                }
            } while (i9 > 0);
            int[] iArr = this.shiftTable;
            int i10 = iArr[c % iArr.length] + 1 + i7;
            i7 = i10 < i8 ? i8 : i10;
        }
        return -1;
    }
}
