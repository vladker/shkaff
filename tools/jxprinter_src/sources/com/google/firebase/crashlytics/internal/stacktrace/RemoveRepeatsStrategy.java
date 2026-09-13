package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {
    private final int maxRepetitions;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    private static boolean isRepeatingSequence(StackTraceElement[] stackTraceElementArr, int i5, int i6) {
        int i7 = i6 - i5;
        if (i6 + i7 > stackTraceElementArr.length) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!stackTraceElementArr[i5 + i8].equals(stackTraceElementArr[i6 + i8])) {
                return false;
            }
        }
        return true;
    }

    private static StackTraceElement[] trimRepeats(StackTraceElement[] stackTraceElementArr, int i5) {
        int i6;
        HashMap map = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        while (i7 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i7];
            Integer num = (Integer) map.get(stackTraceElement);
            if (num == null || !isRepeatingSequence(stackTraceElementArr, num.intValue(), i7)) {
                stackTraceElementArr2[i8] = stackTraceElementArr[i7];
                i8++;
                i9 = 1;
                i6 = i7;
            } else {
                int iIntValue = i7 - num.intValue();
                if (i9 < i5) {
                    System.arraycopy(stackTraceElementArr, i7, stackTraceElementArr2, i8, iIntValue);
                    i8 += iIntValue;
                    i9++;
                }
                i6 = (iIntValue - 1) + i7;
            }
            map.put(stackTraceElement, Integer.valueOf(i7));
            i7 = i6 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i8];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i8);
        return stackTraceElementArr3;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTraceElementArrTrimRepeats = trimRepeats(stackTraceElementArr, this.maxRepetitions);
        return stackTraceElementArrTrimRepeats.length < stackTraceElementArr.length ? stackTraceElementArrTrimRepeats : stackTraceElementArr;
    }

    public RemoveRepeatsStrategy(int i5) {
        this.maxRepetitions = i5;
    }
}
