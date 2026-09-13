package org.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: org.jsoup.parser.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class C1465a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f7577a;
    public Reader b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f7580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7583k;
    private String lastIcSeq;
    private ArrayList<Integer> newlinePositions;

    public C1465a(Reader reader, int i5) {
        this.f7579g = -1;
        this.f7580h = new String[512];
        this.newlinePositions = null;
        this.f7581i = 1;
        V4.h.notNull(reader);
        V4.h.b(reader.markSupported());
        this.b = reader;
        this.f7577a = new char[Math.min(i5, 32768)];
        b();
    }

    public static String c(char[] cArr, String[] strArr, int i5, int i6) {
        if (i6 > 12) {
            return new String(cArr, i5, i6);
        }
        if (i6 < 1) {
            return "";
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i6; i9++) {
            i8 = (i8 * 31) + cArr[i5 + i9];
        }
        int i10 = i8 & 511;
        String str = strArr[i10];
        if (str != null && i6 == str.length()) {
            int i11 = i5;
            int i12 = i6;
            while (true) {
                int i13 = i12 - 1;
                if (i12 == 0) {
                    return str;
                }
                int i14 = i11 + 1;
                int i15 = i7 + 1;
                if (cArr[i11] == str.charAt(i7)) {
                    i11 = i14;
                    i12 = i13;
                    i7 = i15;
                }
            }
        }
        String str2 = new String(cArr, i5, i6);
        strArr[i10] = str2;
        return str2;
    }

    public final void a() {
        this.e++;
    }

    public final void b() {
        int i5;
        int i6;
        boolean z6;
        if (this.f7582j || (i5 = this.e) < this.d) {
            return;
        }
        int i7 = this.f7579g;
        if (i7 != -1) {
            i6 = i5 - i7;
            i5 = i7;
        } else {
            i6 = 0;
        }
        try {
            long j6 = i5;
            long jSkip = this.b.skip(j6);
            this.b.mark(32768);
            int i8 = 0;
            while (true) {
                z6 = true;
                if (i8 > 1024) {
                    break;
                }
                Reader reader = this.b;
                char[] cArr = this.f7577a;
                int i9 = reader.read(cArr, i8, cArr.length - i8);
                if (i9 == -1) {
                    this.f7582j = true;
                }
                if (i9 <= 0) {
                    break;
                } else {
                    i8 += i9;
                }
            }
            this.b.reset();
            if (i8 > 0) {
                if (jSkip != j6) {
                    z6 = false;
                }
                V4.h.b(z6);
                this.c = i8;
                this.f7578f += i5;
                this.e = i6;
                if (this.f7579g != -1) {
                    this.f7579g = 0;
                }
                this.d = Math.min(i8, CpioConstants.C_ISBLK);
            }
            x();
            this.lastIcSeq = null;
        } catch (IOException e) {
            throw new U4.j(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        Reader reader = this.b;
        if (reader == null) {
            return;
        }
        try {
            reader.close();
        } catch (IOException unused) {
        } finally {
            this.b = null;
            this.f7577a = null;
            this.f7580h = null;
        }
    }

    public final char e() {
        b();
        int i5 = this.e;
        char c = i5 >= this.c ? (char) 65535 : this.f7577a[i5];
        this.e = i5 + 1;
        return c;
    }

    public final String f(boolean z6) {
        int i5 = this.e;
        int i6 = this.c;
        char[] cArr = this.f7577a;
        int i7 = i5;
        while (i7 < i6) {
            char c = cArr[i7];
            if (c == 0) {
                break;
            }
            if (c != '\"') {
                if (c == '&') {
                    break;
                }
                if (c == '\'') {
                    if (!z6) {
                        break;
                    }
                    break;
                }
                continue;
                i7++;
            }
            if (!z6) {
                break;
            }
            i7++;
        }
        this.e = i7;
        return i7 > i5 ? c(this.f7577a, this.f7580h, i5, i7 - i5) : "";
    }

    public final String g() {
        int i5 = this.e;
        int i6 = this.c;
        char[] cArr = this.f7577a;
        int i7 = i5;
        while (i7 < i6) {
            char c = cArr[i7];
            if (c == 0 || c == '&' || c == '<') {
                break;
            }
            i7++;
        }
        this.e = i7;
        return i7 > i5 ? c(this.f7577a, this.f7580h, i5, i7 - i5) : "";
    }

    public final String h() {
        char c;
        b();
        int i5 = this.e;
        while (true) {
            int i6 = this.e;
            if (i6 >= this.c || (((c = this.f7577a[i6]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.e++;
        }
        return c(this.f7577a, this.f7580h, i5, this.e - i5);
    }

    public final String i(char c) {
        int i5;
        b();
        int i6 = this.e;
        while (true) {
            if (i6 >= this.c) {
                i5 = -1;
                break;
            }
            if (c == this.f7577a[i6]) {
                i5 = i6 - this.e;
                break;
            }
            i6++;
        }
        if (i5 != -1) {
            String strC = c(this.f7577a, this.f7580h, this.e, i5);
            this.e += i5;
            return strC;
        }
        b();
        char[] cArr = this.f7577a;
        String[] strArr = this.f7580h;
        int i7 = this.e;
        String strC2 = c(cArr, strArr, i7, this.c - i7);
        this.e = this.c;
        return strC2;
    }

    public final String j(char... cArr) {
        b();
        int i5 = this.e;
        int i6 = this.c;
        char[] cArr2 = this.f7577a;
        int i7 = i5;
        loop0: while (i7 < i6) {
            for (char c : cArr) {
                if (cArr2[i7] == c) {
                    break loop0;
                }
            }
            i7++;
        }
        this.e = i7;
        return i7 > i5 ? c(this.f7577a, this.f7580h, i5, i7 - i5) : "";
    }

    public final String k(char... cArr) {
        b();
        int i5 = this.e;
        int i6 = this.c;
        char[] cArr2 = this.f7577a;
        int i7 = i5;
        while (i7 < i6 && Arrays.binarySearch(cArr, cArr2[i7]) < 0) {
            i7++;
        }
        this.e = i7;
        return i7 > i5 ? c(this.f7577a, this.f7580h, i5, i7 - i5) : "";
    }

    public final boolean l(String str) {
        if (str.equals(this.lastIcSeq)) {
            int i5 = this.f7583k;
            if (i5 == -1) {
                return false;
            }
            if (i5 >= this.e) {
                return true;
            }
        }
        this.lastIcSeq = str;
        Locale locale = Locale.ENGLISH;
        int iV = v(str.toLowerCase(locale));
        if (iV > -1) {
            this.f7583k = this.e + iV;
            return true;
        }
        int iV2 = v(str.toUpperCase(locale));
        boolean z6 = iV2 > -1;
        this.f7583k = z6 ? this.e + iV2 : -1;
        return z6;
    }

    public final char m() {
        b();
        int i5 = this.e;
        if (i5 >= this.c) {
            return (char) 65535;
        }
        return this.f7577a[i5];
    }

    public final String n() {
        int iAbs;
        int i5;
        int i6;
        int iIntValue;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = this.newlinePositions;
        if (arrayList != null) {
            int iBinarySearch = arrayList != null ? Collections.binarySearch(arrayList, Integer.valueOf(this.f7578f + this.e)) : 0;
            if (iBinarySearch == -1) {
                iAbs = this.f7581i;
            } else {
                iAbs = iBinarySearch < 0 ? (Math.abs(iBinarySearch) + this.f7581i) - 1 : iBinarySearch + this.f7581i + 1;
            }
        } else {
            iAbs = 1;
        }
        sb.append(iAbs);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        ArrayList<Integer> arrayList2 = this.newlinePositions;
        if (arrayList2 != null) {
            int iBinarySearch2 = arrayList2 != null ? Collections.binarySearch(arrayList2, Integer.valueOf(this.f7578f + this.e)) : 0;
            if (iBinarySearch2 == -1) {
                i5 = this.f7578f;
                i6 = this.e;
            } else {
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = Math.abs(iBinarySearch2) - 2;
                }
                iIntValue = (this.f7578f + this.e) - this.newlinePositions.get(iBinarySearch2).intValue();
            }
            sb.append(iIntValue + 1);
            return sb.toString();
        }
        i5 = this.f7578f;
        i6 = this.e;
        iIntValue = i5 + i6;
        sb.append(iIntValue + 1);
        return sb.toString();
    }

    public final boolean o() {
        b();
        return this.e >= this.c;
    }

    public final boolean p(String str) {
        b();
        b();
        int length = str.length();
        if (length <= this.c - this.e) {
            for (int i5 = 0; i5 < length; i5++) {
                if (str.charAt(i5) == this.f7577a[this.e + i5]) {
                }
            }
            this.e = str.length() + this.e;
            return true;
        }
        return false;
    }

    public final boolean q(String str) {
        b();
        int length = str.length();
        if (length <= this.c - this.e) {
            for (int i5 = 0; i5 < length; i5++) {
                if (Character.toUpperCase(str.charAt(i5)) == Character.toUpperCase(this.f7577a[this.e + i5])) {
                }
            }
            this.e = str.length() + this.e;
            return true;
        }
        return false;
    }

    public final boolean r(char c) {
        return !o() && this.f7577a[this.e] == c;
    }

    public final boolean s(char... cArr) {
        if (!o()) {
            b();
            char c = this.f7577a[this.e];
            for (char c6 : cArr) {
                if (c6 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean t() {
        if (o()) {
            return false;
        }
        char c = this.f7577a[this.e];
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public final String toString() {
        int i5 = this.c;
        int i6 = this.e;
        return i5 - i6 < 0 ? "" : new String(this.f7577a, i6, i5 - i6);
    }

    public final boolean u() {
        if (o()) {
            return false;
        }
        char c = this.f7577a[this.e];
        if (c < 'A' || c > 'Z') {
            return (c >= 'a' && c <= 'z') || Character.isLetter(c);
        }
        return true;
    }

    public final int v(String str) {
        b();
        char cCharAt = str.charAt(0);
        int i5 = this.e;
        while (i5 < this.c) {
            if (cCharAt != this.f7577a[i5]) {
                do {
                    i5++;
                    if (i5 >= this.c) {
                        break;
                    }
                } while (cCharAt != this.f7577a[i5]);
            }
            int i6 = i5 + 1;
            int length = (str.length() + i6) - 1;
            int i7 = this.c;
            if (i5 < i7 && length <= i7) {
                int i8 = i6;
                for (int i9 = 1; i8 < length && str.charAt(i9) == this.f7577a[i8]; i9++) {
                    i8++;
                }
                if (i8 == length) {
                    return i5 - this.e;
                }
            }
            i5 = i6;
        }
        return -1;
    }

    public final void w() {
        int i5 = this.f7579g;
        if (i5 == -1) {
            throw new U4.j(new IOException("Mark invalid"));
        }
        this.e = i5;
        this.f7579g = -1;
    }

    public final void x() {
        ArrayList<Integer> arrayList = this.newlinePositions;
        if (arrayList != null) {
            this.f7581i = arrayList.size() + this.f7581i;
            int iIntValue = this.newlinePositions.size() > 0 ? ((Integer) androidx.collection.a.e(this.newlinePositions, 1)).intValue() : -1;
            this.newlinePositions.clear();
            if (iIntValue != -1) {
                this.newlinePositions.add(Integer.valueOf(iIntValue));
                this.f7581i--;
            }
            for (int i5 = this.e; i5 < this.c; i5++) {
                if (this.f7577a[i5] == '\n') {
                    this.newlinePositions.add(Integer.valueOf(this.f7578f + 1 + i5));
                }
            }
        }
    }

    public final void y(boolean z6) {
        if (z6 && this.newlinePositions == null) {
            this.newlinePositions = new ArrayList<>(Videoio.CAP_PROP_XI_GPO_SELECTOR);
            x();
        } else {
            if (z6) {
                return;
            }
            this.newlinePositions = null;
        }
    }

    public final void z() {
        int i5 = this.e;
        if (i5 < 1) {
            throw new U4.j(new IOException("WTF: No buffer left to unconsume."));
        }
        this.e = i5 - 1;
    }

    public C1465a(String str) {
        this(new StringReader(str), str.length());
    }
}
