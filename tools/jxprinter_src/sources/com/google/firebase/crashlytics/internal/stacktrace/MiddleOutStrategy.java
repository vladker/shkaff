package com.google.firebase.crashlytics.internal.stacktrace;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class MiddleOutStrategy implements StackTraceTrimmingStrategy {
    private final int trimmedSize;

    public MiddleOutStrategy(int i5) {
        this.trimmedSize = i5;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i5 = this.trimmedSize;
        if (length <= i5) {
            return stackTraceElementArr;
        }
        int i6 = i5 / 2;
        int i7 = i5 - i6;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i5];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i7);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i6, stackTraceElementArr2, i7, i6);
        return stackTraceElementArr2;
    }
}
