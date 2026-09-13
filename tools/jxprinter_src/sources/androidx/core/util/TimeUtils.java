package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i5, int i6, boolean z6, int i7) {
        if (i5 > 99 || (z6 && i7 >= 3)) {
            return i6 + 3;
        }
        if (i5 > 9 || (z6 && i7 >= 2)) {
            return i6 + 2;
        }
        if (z6 || i5 > 0) {
            return i6 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j6, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j6, 0));
        }
    }

    private static int formatDurationLocked(long j6, int i5) {
        char c;
        int i6;
        int i7;
        int i8;
        int i9;
        long j7 = j6;
        if (sFormatStr.length < i5) {
            sFormatStr = new char[i5];
        }
        char[] cArr = sFormatStr;
        if (j7 == 0) {
            int i10 = i5 - 1;
            while (i10 > 0) {
                cArr[0] = Chars.SPACE;
            }
            cArr[0] = '0';
            return 1;
        }
        if (j7 > 0) {
            c = '+';
        } else {
            j7 = -j7;
            c = '-';
        }
        int i11 = (int) (j7 % 1000);
        int iFloor = (int) Math.floor(j7 / 1000);
        if (iFloor > 86400) {
            i6 = iFloor / 86400;
            iFloor -= 86400 * i6;
        } else {
            i6 = 0;
        }
        if (iFloor > SECONDS_PER_HOUR) {
            i7 = iFloor / SECONDS_PER_HOUR;
            iFloor -= i7 * SECONDS_PER_HOUR;
        } else {
            i7 = 0;
        }
        if (iFloor > 60) {
            int i12 = iFloor / 60;
            iFloor -= i12 * 60;
            i8 = i12;
        } else {
            i8 = 0;
        }
        if (i5 != 0) {
            int iAccumField = accumField(i6, 1, false, 0);
            int iAccumField2 = iAccumField + accumField(i7, 1, iAccumField > 0, 2);
            int iAccumField3 = iAccumField2 + accumField(i8, 1, iAccumField2 > 0, 2);
            int iAccumField4 = iAccumField3 + accumField(iFloor, 1, iAccumField3 > 0, 2);
            i9 = 0;
            for (int iAccumField5 = accumField(i11, 2, true, iAccumField4 > 0 ? 3 : 0) + 1 + iAccumField4; iAccumField5 < i5; iAccumField5++) {
                cArr[i9] = Chars.SPACE;
                i9++;
            }
        } else {
            i9 = 0;
        }
        cArr[i9] = c;
        int i13 = i9 + 1;
        boolean z6 = i5 != 0;
        int iPrintField = printField(cArr, i6, 'd', i13, false, 0);
        int iPrintField2 = printField(cArr, i7, 'h', iPrintField, iPrintField != i13, z6 ? 2 : 0);
        int iPrintField3 = printField(cArr, i8, 'm', iPrintField2, iPrintField2 != i13, z6 ? 2 : 0);
        int iPrintField4 = printField(cArr, iFloor, 's', iPrintField3, iPrintField3 != i13, z6 ? 2 : 0);
        int iPrintField5 = printField(cArr, i11, 'm', iPrintField4, true, (!z6 || iPrintField4 == i13) ? 0 : 3);
        cArr[iPrintField5] = 's';
        return iPrintField5 + 1;
    }

    private static int printField(char[] cArr, int i5, char c, int i6, boolean z6, int i7) {
        int i8;
        if (!z6 && i5 <= 0) {
            return i6;
        }
        if ((!z6 || i7 < 3) && i5 <= 99) {
            i8 = i6;
        } else {
            int i9 = i5 / 100;
            cArr[i6] = (char) (i9 + 48);
            i8 = i6 + 1;
            i5 -= i9 * 100;
        }
        if ((z6 && i7 >= 2) || i5 > 9 || i6 != i8) {
            int i10 = i5 / 10;
            cArr[i8] = (char) (i10 + 48);
            i8++;
            i5 -= i10 * 10;
        }
        cArr[i8] = (char) (i5 + 48);
        cArr[i8 + 1] = c;
        return i8 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j6, PrintWriter printWriter, int i5) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j6, i5)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j6, PrintWriter printWriter) {
        formatDuration(j6, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j6, long j7, PrintWriter printWriter) {
        if (j6 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j6 - j7, printWriter, 0);
        }
    }
}
