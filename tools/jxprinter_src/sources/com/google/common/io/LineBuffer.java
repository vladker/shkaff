package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    @CanIgnoreReturnValue
    private boolean finishLine(boolean z6) {
        String str;
        if (this.sawReturn) {
            str = z6 ? "\r\n" : "\r";
        } else {
            str = z6 ? "\n" : "";
        }
        handleLine(this.line.toString(), str);
        this.line = new StringBuilder();
        this.sawReturn = false;
        return z6;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    public void add(char[] cArr, int i5, int i6) {
        int i7;
        if (!this.sawReturn || i6 <= 0) {
            i7 = i5;
        } else {
            if (finishLine(cArr[i5] == '\n')) {
                i7 = i5 + 1;
            } else {
                i7 = i5;
            }
        }
        int i8 = i5 + i6;
        int i9 = i7;
        while (i7 < i8) {
            char c = cArr[i7];
            if (c != '\n') {
                if (c == '\r') {
                    this.line.append(cArr, i9, i7 - i9);
                    this.sawReturn = true;
                    int i10 = i7 + 1;
                    if (i10 < i8) {
                        if (finishLine(cArr[i10] == '\n')) {
                            i7 = i10;
                        }
                    }
                }
                i7++;
            } else {
                this.line.append(cArr, i9, i7 - i9);
                finishLine(true);
            }
            i9 = i7 + 1;
            i7++;
        }
        this.line.append(cArr, i9, i8 - i9);
    }

    public void finish() {
        if (this.sawReturn || this.line.length() > 0) {
            finishLine(false);
        }
    }

    public abstract void handleLine(String str, String str2);
}
