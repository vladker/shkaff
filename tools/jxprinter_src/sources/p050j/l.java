package p050j;

import A3.AbstractC0157z;
import J0.f;
import M2.a;
import S4.h;
import U1.d;
import java.io.Serializable;
import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.Chars;
import p096r.e;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5386a;
    public int b;
    public char c;
    public int d;

    public l(String str) {
        this.f5386a = str;
        d();
    }

    public static boolean b(char c) {
        if (c == '-' || c == '+') {
            return true;
        }
        return c >= '0' && c <= '9';
    }

    public final void a(char c) {
        if (this.c == c) {
            if (c()) {
                return;
            }
            d();
        } else {
            throw new s("expect '" + c + ", but '" + this.c + "'");
        }
    }

    public final boolean c() {
        return this.b >= this.f5386a.length();
    }

    public final void d() {
        int i5 = this.b;
        this.b = i5 + 1;
        this.c = this.f5386a.charAt(i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.io.Serializable, java.lang.Object[], java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.io.Serializable, long[]] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Serializable, java.lang.Long[]] */
    public final p e(boolean z6) {
        Object[] objArr;
        int i5;
        int i6;
        Class<?> cls;
        int i7;
        String str;
        String[] strArr;
        String str2;
        String str3;
        int i8;
        double d;
        char c;
        int i9;
        p oVar;
        p hVar;
        char c6;
        if (z6) {
            a('[');
        }
        int i10 = 0;
        if (this.c == '?') {
            d();
            a('(');
            if (this.c == '@') {
                d();
                a('.');
            }
            objArr = true;
        } else {
            objArr = false;
        }
        String str4 = this.f5386a;
        if (objArr == false) {
            char c7 = this.c;
            boolean[] zArr = e.d;
            if (c7 >= zArr.length || !zArr[c7]) {
                int i11 = this.b - 1;
                while (true) {
                    char c8 = this.c;
                    if (c8 == ']' || c8 == '/' || c() || !((c6 = this.c) != '.' || objArr == true || objArr == true)) {
                        break;
                    }
                    if (c6 == '\\') {
                        d();
                    }
                    d();
                }
                if (z6 || (c = this.c) == '/' || c == '.') {
                    int i12 = this.b;
                    i9 = i12 - 1;
                } else {
                    i9 = this.b;
                }
                String strSubstring = str4.substring(i11, i9);
                if (strSubstring.indexOf("\\.") != -1) {
                    return new a(strSubstring.replaceAll("\\\\\\.", "\\."), false);
                }
                int length = strSubstring.length();
                char cCharAt = strSubstring.charAt(0);
                int i13 = length - 1;
                char cCharAt2 = strSubstring.charAt(i13);
                int iIndexOf = strSubstring.indexOf(44);
                if (strSubstring.length() <= 2 || cCharAt != '\'' || cCharAt2 != '\'') {
                    int iIndexOf2 = strSubstring.indexOf(58);
                    if (iIndexOf == -1 && iIndexOf2 == -1) {
                        oVar = j.z(strSubstring) ? new f(Integer.parseInt(strSubstring)) : new a(strSubstring, false);
                    } else if (iIndexOf != -1) {
                        String[] strArrSplit = strSubstring.split(",");
                        int[] iArr = new int[strArrSplit.length];
                        while (i10 < strArrSplit.length) {
                            iArr[i10] = Integer.parseInt(strArrSplit[i10]);
                            i10++;
                        }
                        hVar = new h(iArr, 10);
                        oVar = hVar;
                    } else {
                        if (iIndexOf2 == -1) {
                            throw new UnsupportedOperationException();
                        }
                        String[] strArrSplit2 = strSubstring.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                        int length2 = strArrSplit2.length;
                        int[] iArr2 = new int[length2];
                        for (int i14 = 0; i14 < strArrSplit2.length; i14++) {
                            String str5 = strArrSplit2[i14];
                            if (str5.length() != 0) {
                                iArr2[i14] = Integer.parseInt(str5);
                            } else {
                                if (i14 != 0) {
                                    throw new UnsupportedOperationException();
                                }
                                iArr2[i14] = 0;
                            }
                        }
                        int i15 = iArr2[0];
                        int i16 = length2 > 1 ? iArr2[1] : -1;
                        int i17 = length2 == 3 ? iArr2[2] : 1;
                        if (i16 >= 0 && i16 < i15) {
                            throw new UnsupportedOperationException(androidx.collection.a.h(i15, i16, "end must greater than or equals start. start ", ",  end "));
                        }
                        if (i17 <= 0) {
                            throw new UnsupportedOperationException(AbstractC0157z.k(i17, "step must greater than zero : "));
                        }
                        oVar = new o(i15, i16, i17);
                    }
                } else if (iIndexOf == -1) {
                    oVar = new a(strSubstring.substring(1, i13), false);
                } else {
                    String[] strArrSplit3 = strSubstring.split(",");
                    String[] strArr2 = new String[strArrSplit3.length];
                    while (i10 < strArrSplit3.length) {
                        strArr2[i10] = androidx.collection.a.g(1, 1, strArrSplit3[i10]);
                        i10++;
                    }
                    hVar = new p075n1.a(strArr2, 10);
                    oVar = hVar;
                }
                if (z6 && !c()) {
                    a(']');
                }
                return oVar;
            }
        }
        String strG = g();
        j();
        if (objArr == true && this.c == ')') {
            d();
            if (z6) {
                a(']');
            }
            return new p075n1.a(new h(strG, 11), 9);
        }
        if (z6 && this.c == ']') {
            d();
            return new p075n1.a(new h(strG, 11), 9);
        }
        char c9 = this.c;
        if (c9 == '=') {
            d();
            i5 = 1;
        } else if (c9 == '!') {
            d();
            a(Chars.EQ);
            i5 = 2;
        } else if (c9 == '<') {
            d();
            if (this.c == '=') {
                d();
                i5 = 6;
            } else {
                i5 = 5;
            }
        } else if (c9 == '>') {
            d();
            if (this.c == '=') {
                d();
                i5 = 4;
            } else {
                i5 = 3;
            }
        } else {
            i5 = 0;
        }
        if (i5 == 0) {
            String strG2 = g();
            i6 = 1;
            if ("not".equalsIgnoreCase(strG2)) {
                j();
                String strG3 = g();
                if ("like".equalsIgnoreCase(strG3)) {
                    i5 = 8;
                } else if ("rlike".equalsIgnoreCase(strG3)) {
                    i5 = 10;
                } else if ("in".equalsIgnoreCase(strG3)) {
                    i5 = 12;
                } else {
                    if (!"between".equalsIgnoreCase(strG3)) {
                        throw new UnsupportedOperationException();
                    }
                    i5 = 14;
                }
            } else if ("like".equalsIgnoreCase(strG2)) {
                i5 = 7;
            } else if ("rlike".equalsIgnoreCase(strG2)) {
                i5 = 9;
            } else if ("in".equalsIgnoreCase(strG2)) {
                i5 = 11;
            } else {
                if (!"between".equalsIgnoreCase(strG2)) {
                    throw new UnsupportedOperationException();
                }
                i5 = 13;
            }
        } else {
            i6 = 1;
        }
        j();
        if (i5 == 13 || i5 == 14) {
            boolean z7 = i6;
            if (i5 != 14) {
                z7 = 0;
            }
            Object objI = i();
            if (!"and".equalsIgnoreCase(g())) {
                throw new s(str4);
            }
            Object objI2 = i();
            if (objI == null || objI2 == null) {
                throw new s(str4);
            }
            Class<?> cls2 = objI.getClass();
            if ((cls2 == Byte.class || cls2 == Short.class || cls2 == Integer.class || cls2 == Long.class) && ((cls = objI2.getClass()) == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class)) {
                return new p075n1.a(new i(strG, ((Number) objI).longValue(), ((Number) objI2).longValue(), z7), 9);
            }
            throw new s(str4);
        }
        if (i5 == 11 || i5 == 12) {
            boolean z8 = i5 == 12;
            a('(');
            b bVar = new b();
            bVar.add(i());
            while (true) {
                j();
                if (this.c != ',') {
                    break;
                }
                d();
                bVar.add(i());
            }
            a(')');
            if (objArr != false) {
                a(')');
            }
            if (z6) {
                a(']');
            }
            ArrayList arrayList = bVar.f5377j;
            int size = arrayList.size();
            boolean z9 = true;
            boolean z10 = true;
            boolean z11 = true;
            int i18 = 0;
            while (i18 < size) {
                Object obj = arrayList.get(i18);
                i18++;
                if (obj != null) {
                    Class<?> cls3 = obj.getClass();
                    if (z11 && cls3 != Byte.class && cls3 != Short.class && cls3 != Integer.class && cls3 != Long.class) {
                        z10 = false;
                        z11 = false;
                    }
                    if (z9 && cls3 != String.class) {
                        z9 = false;
                    }
                } else if (z11) {
                    z11 = false;
                }
            }
            if (arrayList.size() == 1 && arrayList.get(0) == null) {
                return z8 ? new p075n1.a(new h(strG, 11), 9) : new p075n1.a(new p075n1.a(strG, 11), 9);
            }
            if (z11) {
                if (arrayList.size() == 1) {
                    return new p075n1.a(new k(strG, ((Number) arrayList.get(0)).longValue(), z8 ? 2 : 1), 9);
                }
                int size2 = arrayList.size();
                ?? r6 = new long[size2];
                for (int i19 = 0; i19 < size2; i19++) {
                    r6[i19] = ((Number) arrayList.get(i19)).longValue();
                }
                return new p075n1.a(new j(strG, (Serializable) r6, z8, 0), 9);
            }
            if (z9) {
                if (arrayList.size() == 1) {
                    return new p075n1.a(new d(strG, (String) arrayList.get(0), z8 ? 2 : 1), 9);
                }
                ?? r7 = new String[arrayList.size()];
                bVar.toArray((Object[]) r7);
                return new p075n1.a(new j(strG, (Serializable) r7, z8, 3), 9);
            }
            if (!z10) {
                throw new UnsupportedOperationException();
            }
            int size3 = arrayList.size();
            ?? r8 = new Long[size3];
            for (int i20 = 0; i20 < size3; i20++) {
                Number number = (Number) arrayList.get(i20);
                if (number != null) {
                    r8[i20] = Long.valueOf(number.longValue());
                }
            }
            return new p075n1.a(new j(strG, (Serializable) r8, z8, 1), 9);
        }
        char c10 = this.c;
        if (c10 != '\'' && c10 != '\"') {
            if (b(c10)) {
                long jF = f();
                if (this.c == '.') {
                    int i21 = this.b - 1;
                    d();
                    while (true) {
                        char c11 = this.c;
                        if (c11 < '0' || c11 > '9') {
                            break;
                        }
                        d();
                    }
                    d = Double.parseDouble(str4.substring(i21, this.b - 1)) + jF;
                } else {
                    d = 0.0d;
                }
                if (objArr != false) {
                    a(')');
                }
                if (z6) {
                    a(']');
                }
                return d == 0.0d ? new p075n1.a(new k(strG, jF, i5), 9) : new p075n1.a(new g(d, i5, strG), 9);
            }
            char c12 = this.c;
            if (c12 == 'n') {
                if (AbstractC1127c.NULL.equals(g())) {
                    if (objArr != false) {
                        a(')');
                    }
                    a(']');
                    if (i5 == i6) {
                        return new p075n1.a(new p075n1.a(strG, 11), 9);
                    }
                    if (i5 == 2) {
                        return new p075n1.a(new h(strG, 11), 9);
                    }
                    throw new UnsupportedOperationException();
                }
            } else if (c12 == 't') {
                if ("true".equals(g())) {
                    if (objArr != false) {
                        a(')');
                    }
                    a(']');
                    if (i5 == 1) {
                        return new p075n1.a(new j(strG, (Serializable) Boolean.TRUE, true, 4), 9);
                    }
                    if (i5 == 2) {
                        return new p075n1.a(new j(strG, (Serializable) Boolean.TRUE, false, 4), 9);
                    }
                    throw new UnsupportedOperationException();
                }
            } else if (c12 == 'f' && "false".equals(g())) {
                if (objArr != false) {
                    a(')');
                }
                a(']');
                if (i5 == 1) {
                    return new p075n1.a(new j(strG, (Serializable) Boolean.FALSE, true, 4), 9);
                }
                if (i5 == 2) {
                    return new p075n1.a(new j(strG, (Serializable) Boolean.FALSE, false, 4), 9);
                }
                throw new UnsupportedOperationException();
            }
            throw new UnsupportedOperationException();
        }
        String strH = h();
        if (objArr != false) {
            a(')');
        }
        if (z6) {
            a(']');
        }
        if (i5 == 9) {
            return new p075n1.a(new j(strG, strH, false), 9);
        }
        if (i5 == 10) {
            return new p075n1.a(new j(strG, strH, true), 9);
        }
        if (i5 != 7) {
            i7 = 8;
            if (i5 != 8) {
                i8 = i5;
            }
            return new p075n1.a(new d(strG, strH, i8), 9);
        }
        i7 = 8;
        while (strH.indexOf("%%") != -1) {
            strH = strH.replaceAll("%%", "%");
        }
        boolean z12 = i5 == i7;
        int iIndexOf3 = strH.indexOf(37);
        if (iIndexOf3 == -1) {
            i8 = i5 == 7 ? 1 : 2;
            return new p075n1.a(new d(strG, strH, i8), 9);
        }
        String[] strArrSplit4 = strH.split("%");
        String[] strArr3 = null;
        String str6 = null;
        strArr3 = null;
        strArr3 = null;
        if (iIndexOf3 == 0) {
            if (strH.charAt(strH.length() - 1) == '%') {
                int length3 = strArrSplit4.length - 1;
                String[] strArr4 = new String[length3];
                System.arraycopy(strArrSplit4, 1, strArr4, 0, length3);
                str2 = null;
                strArr3 = strArr4;
                str3 = null;
            } else {
                str = strArrSplit4[strArrSplit4.length - 1];
                if (strArrSplit4.length > 2) {
                    int length4 = strArrSplit4.length - 2;
                    strArr = new String[length4];
                    System.arraycopy(strArrSplit4, 1, strArr, 0, length4);
                    str2 = str;
                    str3 = str6;
                    strArr3 = strArr;
                } else {
                    str2 = str;
                    str3 = null;
                }
            }
        } else if (strH.charAt(strH.length() - 1) == '%') {
            str3 = null;
            str2 = null;
            strArr3 = strArrSplit4;
        } else if (strArrSplit4.length == 1) {
            str3 = strArrSplit4[0];
            str2 = null;
        } else if (strArrSplit4.length == 2) {
            String str7 = strArrSplit4[0];
            str2 = strArrSplit4[1];
            str3 = str7;
        } else {
            str6 = strArrSplit4[0];
            str = strArrSplit4[strArrSplit4.length - 1];
            int length5 = strArrSplit4.length - 2;
            strArr = new String[length5];
            System.arraycopy(strArrSplit4, 1, strArr, 0, length5);
            str2 = str;
            str3 = str6;
            strArr3 = strArr;
        }
        return new p075n1.a(new m(strG, str3, str2, strArr3, z12), 9);
    }

    public final long f() {
        int i5 = this.b - 1;
        char c = this.c;
        if (c == '+' || c == '-') {
            d();
        }
        while (true) {
            char c6 = this.c;
            if (c6 < '0' || c6 > '9') {
                break;
            }
            d();
        }
        return Long.parseLong(this.f5386a.substring(i5, this.b - 1));
    }

    public final String g() {
        j();
        char c = this.c;
        if (c != '\\') {
            boolean[] zArr = e.d;
            if (c >= zArr.length || !zArr[c]) {
                throw new s("illeal jsonpath syntax. " + this.f5386a);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!c()) {
            char c6 = this.c;
            if (c6 == '\\') {
                d();
                sb.append(this.c);
                if (c()) {
                    break;
                }
                d();
            } else {
                boolean[] zArr2 = e.e;
                if (c6 >= zArr2.length || !zArr2[c6]) {
                    break;
                }
                sb.append(c6);
                d();
            }
        }
        if (c()) {
            char c7 = this.c;
            boolean[] zArr3 = e.e;
            if (c7 < zArr3.length && zArr3[c7]) {
                sb.append(c7);
            }
        }
        return sb.toString();
    }

    public final String h() {
        char c = this.c;
        d();
        int i5 = this.b - 1;
        while (this.c != c && !c()) {
            d();
        }
        String strSubstring = this.f5386a.substring(i5, c() ? this.b : this.b - 1);
        a(c);
        return strSubstring;
    }

    public final Object i() {
        j();
        if (b(this.c)) {
            return Long.valueOf(f());
        }
        char c = this.c;
        if (c == '\"' || c == '\'') {
            return h();
        }
        if (c != 'n') {
            throw new UnsupportedOperationException();
        }
        if (AbstractC1127c.NULL.equals(g())) {
            return null;
        }
        throw new s(this.f5386a);
    }

    public final void j() {
        while (true) {
            char c = this.c;
            if (c > ' ') {
                return;
            }
            if (c != ' ' && c != '\r' && c != '\n' && c != '\t' && c != '\f' && c != '\b') {
                return;
            } else {
                d();
            }
        }
    }
}
