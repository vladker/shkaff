package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class FlutterTextUtils {
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    private final FlutterJNI flutterJNI;

    public FlutterTextUtils(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public int getOffsetAfter(CharSequence charSequence, int i5) {
        int iCharCount;
        int iCharCount2;
        int iCharCount3;
        int length = charSequence.length();
        int i6 = length - 1;
        if (i5 >= i6) {
            return length;
        }
        int iCodePointAt = Character.codePointAt(charSequence, i5);
        int iCharCount4 = Character.charCount(iCodePointAt);
        int iCharCount5 = i5 + iCharCount4;
        int i7 = 0;
        if (iCharCount5 == 0) {
            return 0;
        }
        if (iCodePointAt == 10) {
            if (Character.codePointAt(charSequence, iCharCount5) == 13) {
                iCharCount4++;
            }
            return i5 + iCharCount4;
        }
        if (isRegionalIndicatorSymbol(iCodePointAt)) {
            if (iCharCount5 >= i6 || !isRegionalIndicatorSymbol(Character.codePointAt(charSequence, iCharCount5))) {
                return iCharCount5;
            }
            int iCharCount6 = i5;
            while (iCharCount6 > 0 && isRegionalIndicatorSymbol(Character.codePointBefore(charSequence, i5))) {
                iCharCount6 -= Character.charCount(Character.codePointBefore(charSequence, i5));
                i7++;
            }
            if (i7 % 2 == 0) {
                iCharCount4 += 2;
            }
            return i5 + iCharCount4;
        }
        if (isKeycapBase(iCodePointAt)) {
            iCharCount4 += Character.charCount(iCodePointAt);
        }
        if (iCodePointAt == 8419) {
            int iCodePointBefore = Character.codePointBefore(charSequence, iCharCount5);
            int iCharCount7 = Character.charCount(iCodePointBefore) + iCharCount5;
            if (iCharCount7 < length && isVariationSelector(iCodePointBefore)) {
                int iCodePointAt2 = Character.codePointAt(charSequence, iCharCount7);
                if (isKeycapBase(iCodePointAt2)) {
                    iCharCount3 = Character.charCount(iCodePointAt2) + Character.charCount(iCodePointBefore);
                    iCharCount4 += iCharCount3;
                }
            } else if (isKeycapBase(iCodePointBefore)) {
                iCharCount3 = Character.charCount(iCodePointBefore);
                iCharCount4 += iCharCount3;
            }
            return i5 + iCharCount4;
        }
        if (isEmoji(iCodePointAt)) {
            boolean z6 = false;
            int i8 = 0;
            do {
                if (z6) {
                    iCharCount4 = Character.charCount(iCodePointAt) + i8 + 1 + iCharCount4;
                    z6 = false;
                }
                if (isEmojiModifier(iCodePointAt)) {
                    break;
                }
                if (iCharCount5 < length) {
                    iCodePointAt = Character.codePointAt(charSequence, iCharCount5);
                    int iCharCount8 = Character.charCount(iCodePointAt) + iCharCount5;
                    if (iCodePointAt != 8419) {
                        if (!isEmojiModifier(iCodePointAt)) {
                            if (!isVariationSelector(iCodePointAt)) {
                                if (iCodePointAt == 8205) {
                                    iCodePointAt = Character.codePointAt(charSequence, iCharCount8);
                                    iCharCount5 = Character.charCount(iCodePointAt) + iCharCount8;
                                    if (iCharCount5 >= length || !isVariationSelector(iCodePointAt)) {
                                        i8 = 0;
                                    } else {
                                        iCodePointAt = Character.codePointAt(charSequence, iCharCount5);
                                        int iCharCount9 = Character.charCount(iCodePointAt);
                                        iCharCount5 = Character.charCount(iCodePointAt) + iCharCount5;
                                        i8 = iCharCount9;
                                    }
                                    z6 = true;
                                } else {
                                    iCharCount5 = iCharCount8;
                                    i8 = 0;
                                }
                                if (iCharCount5 < length || !z6) {
                                    break;
                                }
                            } else {
                                iCharCount2 = Character.charCount(iCodePointAt);
                            }
                        } else {
                            iCharCount2 = Character.charCount(iCodePointAt);
                        }
                        iCharCount4 += iCharCount2;
                        break;
                    }
                    int iCodePointBefore2 = Character.codePointBefore(charSequence, iCharCount8);
                    int iCharCount10 = Character.charCount(iCodePointBefore2) + iCharCount8;
                    if (iCharCount10 < length && isVariationSelector(iCodePointBefore2)) {
                        int iCodePointAt3 = Character.codePointAt(charSequence, iCharCount10);
                        if (isKeycapBase(iCodePointAt3)) {
                            iCharCount = Character.charCount(iCodePointAt3) + Character.charCount(iCodePointBefore2);
                            iCharCount4 += iCharCount;
                        }
                    } else if (isKeycapBase(iCodePointBefore2)) {
                        iCharCount = Character.charCount(iCodePointBefore2);
                        iCharCount4 += iCharCount;
                    }
                    return i5 + iCharCount4;
                }
                i8 = 0;
                if (iCharCount5 < length) {
                    break;
                }
            } while (isEmoji(iCodePointAt));
        }
        return i5 + iCharCount4;
    }

    /* JADX WARN: Code duplicated, block: B:91:0x0149 A[PHI: r2 r4
  0x0149: PHI (r2v6 int) = (r2v3 int), (r2v8 int) binds: [B:81:0x0117, B:83:0x0124] A[DONT_GENERATE, DONT_INLINE]
  0x0149: PHI (r4v5 int) = (r4v3 int), (r4v7 int) binds: [B:81:0x0117, B:83:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    public int getOffsetBefore(CharSequence charSequence, int i5) {
        int iCodePointBefore;
        int iCharCount;
        int iCharCount2;
        int iCharCount3;
        int iCharCount4 = 0;
        int i6 = 1;
        if (i5 <= 1 || (iCharCount2 = i5 - (iCharCount = Character.charCount((iCodePointBefore = Character.codePointBefore(charSequence, i5))))) == 0) {
            return 0;
        }
        if (iCodePointBefore == 10) {
            if (Character.codePointBefore(charSequence, iCharCount2) == 13) {
                iCharCount++;
            }
            return i5 - iCharCount;
        }
        if (isRegionalIndicatorSymbol(iCodePointBefore)) {
            int iCodePointBefore2 = Character.codePointBefore(charSequence, iCharCount2);
            int iCharCount5 = iCharCount2 - Character.charCount(iCodePointBefore2);
            while (iCharCount5 > 0 && isRegionalIndicatorSymbol(iCodePointBefore2)) {
                iCodePointBefore2 = Character.codePointBefore(charSequence, iCharCount5);
                iCharCount5 -= Character.charCount(iCodePointBefore2);
                i6++;
            }
            if (i6 % 2 == 0) {
                iCharCount += 2;
            }
            return i5 - iCharCount;
        }
        if (iCodePointBefore == 8419) {
            int iCodePointBefore3 = Character.codePointBefore(charSequence, iCharCount2);
            int iCharCount6 = iCharCount2 - Character.charCount(iCodePointBefore3);
            if (iCharCount6 > 0 && isVariationSelector(iCodePointBefore3)) {
                int iCodePointBefore4 = Character.codePointBefore(charSequence, iCharCount6);
                if (isKeycapBase(iCodePointBefore4)) {
                    iCharCount3 = Character.charCount(iCodePointBefore4) + Character.charCount(iCodePointBefore3);
                    iCharCount += iCharCount3;
                }
            } else if (isKeycapBase(iCodePointBefore3)) {
                iCharCount3 = Character.charCount(iCodePointBefore3);
                iCharCount += iCharCount3;
            }
            return i5 - iCharCount;
        }
        if (iCodePointBefore == 917631) {
            iCodePointBefore = Character.codePointBefore(charSequence, iCharCount2);
            int iCharCount7 = Character.charCount(iCodePointBefore);
            while (true) {
                iCharCount2 -= iCharCount7;
                if (iCharCount2 <= 0 || !isTagSpecChar(iCodePointBefore)) {
                    break;
                }
                iCharCount += Character.charCount(iCodePointBefore);
                iCodePointBefore = Character.codePointBefore(charSequence, iCharCount2);
                iCharCount7 = Character.charCount(iCodePointBefore);
            }
            if (!isEmoji(iCodePointBefore)) {
                return i5 - 2;
            }
            iCharCount += Character.charCount(iCodePointBefore);
        }
        if (isVariationSelector(iCodePointBefore)) {
            iCodePointBefore = Character.codePointBefore(charSequence, iCharCount2);
            if (!isEmoji(iCodePointBefore)) {
                return i5 - iCharCount;
            }
            iCharCount += Character.charCount(iCodePointBefore);
            iCharCount2 -= iCharCount;
        }
        if (isEmoji(iCodePointBefore)) {
            boolean z6 = false;
            int i7 = 0;
            do {
                if (z6) {
                    iCharCount = Character.charCount(iCodePointBefore) + i7 + 1 + iCharCount;
                    z6 = false;
                }
                if (!isEmojiModifier(iCodePointBefore)) {
                    if (iCharCount2 > 0) {
                        iCodePointBefore = Character.codePointBefore(charSequence, iCharCount2);
                        iCharCount2 -= Character.charCount(iCodePointBefore);
                        if (iCodePointBefore == 8205) {
                            iCodePointBefore = Character.codePointBefore(charSequence, iCharCount2);
                            iCharCount2 -= Character.charCount(iCodePointBefore);
                            if (iCharCount2 <= 0 || !isVariationSelector(iCodePointBefore)) {
                                i7 = 0;
                            } else {
                                iCodePointBefore = Character.codePointBefore(charSequence, iCharCount2);
                                int iCharCount8 = Character.charCount(iCodePointBefore);
                                iCharCount2 -= Character.charCount(iCodePointBefore);
                                i7 = iCharCount8;
                            }
                            z6 = true;
                        } else {
                            i7 = 0;
                        }
                    } else {
                        i7 = 0;
                    }
                    if (iCharCount2 == 0 || !z6) {
                        break;
                    }
                } else {
                    int iCodePointBefore5 = Character.codePointBefore(charSequence, iCharCount2);
                    int iCharCount9 = iCharCount2 - Character.charCount(iCodePointBefore5);
                    if (iCharCount9 > 0 && isVariationSelector(iCodePointBefore5)) {
                        iCodePointBefore5 = Character.codePointBefore(charSequence, iCharCount9);
                        if (!isEmoji(iCodePointBefore5)) {
                            return i5 - iCharCount;
                        }
                        iCharCount4 = Character.charCount(iCodePointBefore5);
                        Character.charCount(iCodePointBefore5);
                    }
                    if (!isEmojiModifierBase(iCodePointBefore5)) {
                        break;
                    }
                    iCharCount += Character.charCount(iCodePointBefore5) + iCharCount4;
                    break;
                }
            } while (isEmoji(iCodePointBefore));
        }
        return i5 - iCharCount;
    }

    public boolean isEmoji(int i5) {
        return this.flutterJNI.isCodePointEmoji(i5);
    }

    public boolean isEmojiModifier(int i5) {
        return this.flutterJNI.isCodePointEmojiModifier(i5);
    }

    public boolean isEmojiModifierBase(int i5) {
        return this.flutterJNI.isCodePointEmojiModifierBase(i5);
    }

    public boolean isKeycapBase(int i5) {
        return (48 <= i5 && i5 <= 57) || i5 == 35 || i5 == 42;
    }

    public boolean isRegionalIndicatorSymbol(int i5) {
        return this.flutterJNI.isCodePointRegionalIndicator(i5);
    }

    public boolean isTagSpecChar(int i5) {
        return 917536 <= i5 && i5 <= 917630;
    }

    public boolean isVariationSelector(int i5) {
        return this.flutterJNI.isCodePointVariantSelector(i5);
    }
}
