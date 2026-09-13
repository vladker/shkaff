package org.apache.commons.compress.harmony.unpack200;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SegmentUtils {
    public static int countArgs(String str) {
        return countArgs(str, 1);
    }

    public static int countBit16(int[] iArr) {
        int i5 = 0;
        for (int i6 : iArr) {
            if ((i6 & 65536) != 0) {
                i5++;
            }
        }
        return i5;
    }

    public static int countInvokeInterfaceArgs(String str) {
        return countArgs(str, 2);
    }

    public static int countMatches(long[] jArr, IMatcher iMatcher) {
        int i5 = 0;
        for (long j6 : jArr) {
            if (iMatcher.matches(j6)) {
                i5++;
            }
        }
        return i5;
    }

    public static int countArgs(String str, int i5) {
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(41);
        if (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 < iIndexOf) {
            throw new IllegalArgumentException("No arguments");
        }
        int i6 = 0;
        boolean z6 = false;
        boolean z7 = false;
        for (int i7 = iIndexOf + 1; i7 < iIndexOf2; i7++) {
            char cCharAt = str.charAt(i7);
            if (z6 && cCharAt == ';') {
                z6 = false;
                z7 = false;
            } else if (!z6 && cCharAt == 'L') {
                i6++;
                z6 = true;
            } else if (cCharAt == '[') {
                z7 = true;
            } else if (!z6) {
                if (z7) {
                    i6++;
                    z7 = false;
                } else {
                    i6 = (cCharAt == 'D' || cCharAt == 'J') ? i6 + i5 : i6 + 1;
                }
            }
        }
        return i6;
    }

    public static int countBit16(long[] jArr) {
        int i5 = 0;
        for (long j6 : jArr) {
            if ((j6 & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                i5++;
            }
        }
        return i5;
    }

    public static int countMatches(long[][] jArr, IMatcher iMatcher) {
        int iCountMatches = 0;
        for (long[] jArr2 : jArr) {
            iCountMatches += countMatches(jArr2, iMatcher);
        }
        return iCountMatches;
    }

    public static int countBit16(long[][] jArr) {
        int i5 = 0;
        for (long[] jArr2 : jArr) {
            int i6 = 0;
            while (true) {
                if (i6 < jArr2.length) {
                    if ((jArr2[i6] & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                        i5++;
                    }
                    i6++;
                }
            }
        }
        return i5;
    }
}
