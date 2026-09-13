package kotlinx.serialization.json.internal;

import java.util.Arrays;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class O implements InterfaceC1147x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5728a;
    private char[] array = C1134j.INSTANCE.take();

    public final void a(int i5, int i6) {
        int i7 = i6 + i5;
        char[] cArr = this.array;
        if (cArr.length <= i7) {
            int i8 = i5 * 2;
            if (i7 < i8) {
                i7 = i8;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i7);
            kotlin.jvm.internal.E.e(cArrCopyOf, "copyOf(...)");
            this.array = cArrCopyOf;
        }
    }

    public final void b() {
        C1134j.INSTANCE.release(this.array);
    }

    public final void c(char c) {
        a(this.f5728a, 1);
        char[] cArr = this.array;
        int i5 = this.f5728a;
        this.f5728a = i5 + 1;
        cArr[i5] = c;
    }

    public String toString() {
        return new String(this.array, 0, this.f5728a);
    }

    @Override // kotlinx.serialization.json.internal.InterfaceC1147x
    public void write(String text) {
        kotlin.jvm.internal.E.f(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        a(this.f5728a, length);
        text.getChars(0, text.length(), this.array, this.f5728a);
        this.f5728a += length;
    }

    @Override // kotlinx.serialization.json.internal.InterfaceC1147x
    public void writeQuoted(String text) {
        byte b;
        kotlin.jvm.internal.E.f(text, "text");
        a(this.f5728a, text.length() + 2);
        char[] cArr = this.array;
        int i5 = this.f5728a;
        int i6 = i5 + 1;
        cArr[i5] = Chars.DQUOTE;
        int length = text.length();
        text.getChars(0, length, cArr, i6);
        int i7 = length + i6;
        int i8 = i6;
        while (i8 < i7) {
            char c = cArr[i8];
            if (c < j0.getESCAPE_MARKERS().length && j0.getESCAPE_MARKERS()[c] != 0) {
                int length2 = text.length();
                for (int i9 = i8 - i6; i9 < length2; i9++) {
                    a(i8, 2);
                    char cCharAt = text.charAt(i9);
                    if (cCharAt >= j0.getESCAPE_MARKERS().length || (b = j0.getESCAPE_MARKERS()[cCharAt]) == 0) {
                        int i10 = i8 + 1;
                        this.array[i8] = cCharAt;
                        i8 = i10;
                    } else if (b == 1) {
                        String str = j0.getESCAPE_STRINGS()[cCharAt];
                        kotlin.jvm.internal.E.c(str);
                        a(i8, str.length());
                        str.getChars(0, str.length(), this.array, i8);
                        int length3 = str.length() + i8;
                        this.f5728a = length3;
                        i8 = length3;
                    } else {
                        char[] cArr2 = this.array;
                        cArr2[i8] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr2[i8 + 1] = (char) b;
                        i8 += 2;
                        this.f5728a = i8;
                    }
                }
                a(i8, 1);
                this.array[i8] = Chars.DQUOTE;
                this.f5728a = i8 + 1;
                return;
            }
            i8++;
        }
        cArr[i7] = Chars.DQUOTE;
        this.f5728a = i7 + 1;
    }
}
