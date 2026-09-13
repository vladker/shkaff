package Y4;

import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.jsoup.parser.P;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class r {
    public static final String[] d = {",", ">", "+", "~", " "};
    public static final String[] e = {"=", "!=", "^=", "$=", "*=", "~="};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f890f = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f891g = Pattern.compile("([+-])?(\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P f892a;
    public final String b;
    public final ArrayList c = new ArrayList();

    public r(String str) {
        V4.h.notEmpty(str);
        String strTrim = str.trim();
        this.b = strTrim;
        this.f892a = new P(strTrim);
    }

    public static p h(String str) {
        try {
            return new r(str).g();
        } catch (IllegalArgumentException e6) {
            throw new s(e6.getMessage(), new Object[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x009f  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00df  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:45:0x0107  */
    /* JADX WARN: Code duplicated, block: B:46:0x011a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0130  */
    /* JADX WARN: Code duplicated, block: B:49:0x013c  */
    public final void a(char c) {
        p cVar;
        Object obj;
        boolean z6;
        c cVar2;
        e eVar;
        P p6 = this.f892a;
        p6.f();
        StringBuilder sbB = W4.b.b();
        while (!p6.g()) {
            if (p6.i("(")) {
                sbB.append("(");
                sbB.append(p6.a('(', ')'));
                sbB.append(")");
            } else if (p6.i("[")) {
                sbB.append("[");
                sbB.append(p6.a('[', ']'));
                sbB.append("]");
            } else if (!p6.k(d)) {
                sbB.append(p6.b());
            } else if (sbB.length() > 0) {
                break;
            } else {
                p6.b();
            }
        }
        p pVarH = h(W4.b.g(sbB));
        ArrayList arrayList = this.c;
        int i5 = 1;
        int i6 = 0;
        if (arrayList.size() == 1) {
            cVar = (p) arrayList.get(0);
            if ((cVar instanceof d) && c != ',') {
                obj = cVar;
                cVar = ((d) cVar).rightMostEvaluator();
                z6 = true;
            }
            arrayList.clear();
            if (c != ' ') {
                v vVar = new v(3);
                vVar.f893a = cVar;
                cVar2 = new c(vVar, pVarH);
            } else if (c != '>') {
                v vVar2 = new v(i6);
                vVar2.f893a = cVar;
                cVar2 = new c(vVar2, pVarH);
            } else {
                if (c != '~') {
                    if (c != '+') {
                        v vVar3 = new v(i5);
                        vVar3.f893a = cVar;
                        cVar2 = new c(vVar3, pVarH);
                    } else {
                        if (c == ',') {
                            throw new s(androidx.exifinterface.media.a.h("Unknown combinator: ", c), new Object[0]);
                        }
                        if (cVar instanceof d) {
                            eVar = (d) cVar;
                        } else {
                            d dVar = new d();
                            ArrayList arrayList2 = dVar.f882a;
                            arrayList2.add(cVar);
                            dVar.b = arrayList2.size();
                            eVar = dVar;
                        }
                        ArrayList arrayList3 = eVar.f882a;
                        arrayList3.add(pVarH);
                        eVar.b = arrayList3.size();
                    }
                    if (z6) {
                        d dVar2 = (d) obj;
                        dVar2.f882a.set(dVar2.b - 1, eVar);
                    } else {
                        obj = eVar;
                    }
                    arrayList.add(obj);
                }
                v vVar4 = new v(4);
                vVar4.f893a = cVar;
                cVar2 = new c(vVar4, pVarH);
            }
            eVar = cVar2;
            if (z6) {
                d dVar3 = (d) obj;
                dVar3.f882a.set(dVar3.b - 1, eVar);
            } else {
                obj = eVar;
            }
            arrayList.add(obj);
        }
        cVar = new c(arrayList);
        obj = cVar;
        z6 = false;
        arrayList.clear();
        if (c != ' ') {
            v vVar5 = new v(3);
            vVar5.f893a = cVar;
            cVar2 = new c(vVar5, pVarH);
        } else if (c != '>') {
            v vVar6 = new v(i6);
            vVar6.f893a = cVar;
            cVar2 = new c(vVar6, pVarH);
        } else {
            if (c != '~') {
                if (c != '+') {
                    v vVar7 = new v(i5);
                    vVar7.f893a = cVar;
                    cVar2 = new c(vVar7, pVarH);
                } else {
                    if (c == ',') {
                        throw new s(androidx.exifinterface.media.a.h("Unknown combinator: ", c), new Object[0]);
                    }
                    if (cVar instanceof d) {
                        eVar = (d) cVar;
                    } else {
                        d dVar4 = new d();
                        ArrayList arrayList4 = dVar4.f882a;
                        arrayList4.add(cVar);
                        dVar4.b = arrayList4.size();
                        eVar = dVar4;
                    }
                    ArrayList arrayList5 = eVar.f882a;
                    arrayList5.add(pVarH);
                    eVar.b = arrayList5.size();
                }
                if (z6) {
                    d dVar5 = (d) obj;
                    dVar5.f882a.set(dVar5.b - 1, eVar);
                } else {
                    obj = eVar;
                }
                arrayList.add(obj);
            }
            v vVar8 = new v(4);
            vVar8.f893a = cVar;
            cVar2 = new c(vVar8, pVarH);
        }
        eVar = cVar2;
        if (z6) {
            d dVar6 = (d) obj;
            dVar6.f882a.set(dVar6.b - 1, eVar);
        } else {
            obj = eVar;
        }
        arrayList.add(obj);
    }

    public final int b() {
        P p6 = this.f892a;
        String strE = p6.e(")");
        p6.h(")");
        String strTrim = strE.trim();
        String[] strArr = W4.b.f830a;
        boolean z6 = false;
        if (strTrim != null && strTrim.length() != 0) {
            int length = strTrim.length();
            for (int i5 = 0; i5 < length; i5++) {
                if (Character.isDigit(strTrim.codePointAt(i5))) {
                }
            }
            z6 = true;
        }
        V4.h.a("Index must be numeric", z6);
        return Integer.parseInt(strTrim);
    }

    public final void c(boolean z6) {
        String str = z6 ? ":containsOwn" : ":contains";
        P p6 = this.f892a;
        p6.c(str);
        String strN = P.n(p6.a('(', ')'));
        V4.h.notEmpty(strN, ":contains(text) query must not be empty");
        ArrayList arrayList = this.c;
        if (z6) {
            arrayList.add(new h(strN, 4));
        } else {
            arrayList.add(new h(strN, 5));
        }
    }

    public final void d(boolean z6, boolean z7) {
        P p6 = this.f892a;
        String strE = p6.e(")");
        p6.h(")");
        String strJ = p051j0.i.j(strE);
        Matcher matcher = f890f.matcher(strJ);
        Matcher matcher2 = f891g.matcher(strJ);
        int i5 = 2;
        int i6 = 1;
        if (!"odd".equals(strJ)) {
            if ("even".equals(strJ)) {
                i6 = 0;
            } else if (matcher.matches()) {
                int i7 = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                i6 = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
                i5 = i7;
            } else {
                if (!matcher2.matches()) {
                    throw new s("Could not parse nth-index '%s': unexpected format", strJ);
                }
                i6 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i5 = 0;
            }
        }
        ArrayList arrayList = this.c;
        if (z7) {
            if (z6) {
                arrayList.add(new n(i5, i6, 2));
                return;
            } else {
                arrayList.add(new n(i5, i6, 3));
                return;
            }
        }
        if (z6) {
            arrayList.add(new n(i5, i6, 1));
        } else {
            arrayList.add(new n(i5, i6, 0));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        P p6 = this.f892a;
        boolean zH = p6.h("#");
        int i5 = 6;
        boolean z6 = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        ArrayList arrayList = this.c;
        if (zH) {
            String strD = p6.d();
            V4.h.notEmpty(strD);
            arrayList.add(new h(strD, i5, z6));
            return;
        }
        int i6 = 2;
        if (p6.h(Consts.DOT)) {
            String strD2 = p6.d();
            V4.h.notEmpty(strD2);
            arrayList.add(new h(strD2.trim(), i6, objArr7 == true ? 1 : 0));
            return;
        }
        int i7 = 7;
        int i8 = 1;
        if (p6.l() || p6.i("*|")) {
            int i9 = p6.b;
            while (!p6.g() && (p6.l() || p6.k("*|", "|", "_", ProcessIdUtil.DEFAULT_PROCESSID))) {
                p6.b++;
            }
            String strJ = p051j0.i.j(p6.f7561a.substring(i9, p6.b));
            V4.h.notEmpty(strJ);
            if (!strJ.startsWith("*|")) {
                if (strJ.contains("|")) {
                    strJ = strJ.replace("|", ParameterizedMessage.ERROR_MSG_SEPARATOR);
                }
                arrayList.add(new h(strJ, i7, objArr == true ? 1 : 0));
                return;
            }
            List listAsList = Arrays.asList(new h(strJ.substring(2), i7, objArr3 == true ? 1 : 0), new h(strJ.replace("*|", ParameterizedMessage.ERROR_MSG_SEPARATOR), 8, objArr2 == true ? 1 : 0));
            d dVar = new d();
            int i10 = dVar.b;
            ArrayList arrayList2 = dVar.f882a;
            if (i10 > 1) {
                arrayList2.add(new c(listAsList));
            } else {
                arrayList2.addAll(listAsList);
            }
            dVar.b = arrayList2.size();
            arrayList.add(dVar);
            return;
        }
        boolean zI = p6.i("[");
        int i11 = 4;
        int i12 = 3;
        String str = this.b;
        if (zI) {
            P p7 = new P(p6.a('[', ']'));
            int i13 = p7.b;
            while (!p7.g() && !p7.k(e)) {
                p7.b++;
            }
            String strSubstring = p7.f7561a.substring(i13, p7.b);
            V4.h.notEmpty(strSubstring);
            p7.f();
            if (p7.g()) {
                if (strSubstring.startsWith("^")) {
                    arrayList.add(new h(strSubstring.substring(1), 1));
                    return;
                } else {
                    arrayList.add(new h(strSubstring, objArr6 == true ? 1 : 0, objArr5 == true ? 1 : 0));
                    return;
                }
            }
            if (p7.h("=")) {
                arrayList.add(new i(strSubstring, p7.m(), true, 0));
                return;
            }
            if (p7.h("!=")) {
                arrayList.add(new i(strSubstring, p7.m(), true, 3));
                return;
            }
            if (p7.h("^=")) {
                arrayList.add(new i(strSubstring, p7.m(), false, 4));
                return;
            }
            if (p7.h("$=")) {
                arrayList.add(new i(strSubstring, p7.m(), false, 2));
                return;
            }
            if (p7.h("*=")) {
                arrayList.add(new i(strSubstring, p7.m(), true, 1));
                return;
            }
            if (!p7.h("~=")) {
                throw new s("Could not parse attribute query '%s': unexpected token at '%s'", str, p7.m());
            }
            Pattern patternCompile = Pattern.compile(p7.m());
            j jVar = new j();
            jVar.f886a = p051j0.i.j(strSubstring);
            jVar.b = patternCompile;
            arrayList.add(jVar);
            return;
        }
        if (p6.h(ProxyConfig.MATCH_ALL_SCHEMES)) {
            arrayList.add(new g(objArr4 == true ? 1 : 0));
            return;
        }
        if (p6.h(":lt(")) {
            arrayList.add(new k(b(), 2));
            return;
        }
        if (p6.h(":gt(")) {
            arrayList.add(new k(b(), 1));
            return;
        }
        if (p6.h(":eq(")) {
            arrayList.add(new k(b(), 0));
            return;
        }
        if (p6.i(":has(")) {
            p6.c(":has");
            String strA = p6.a('(', ')');
            V4.h.notEmpty(strA, ":has(selector) subselect must not be empty");
            arrayList.add(new u(h(strA)));
            return;
        }
        if (p6.i(":contains(")) {
            c(false);
            return;
        }
        if (p6.i(":containsOwn(")) {
            c(true);
            return;
        }
        if (p6.i(":containsData(")) {
            p6.c(":containsData");
            String strN = P.n(p6.a('(', ')'));
            V4.h.notEmpty(strN, ":containsData(text) query must not be empty");
            arrayList.add(new h(strN, 3));
            return;
        }
        if (p6.i(":matches(")) {
            f(false);
            return;
        }
        if (p6.i(":matchesOwn(")) {
            f(true);
            return;
        }
        if (p6.i(":not(")) {
            p6.c(":not");
            String strA2 = p6.a('(', ')');
            V4.h.notEmpty(strA2, ":not(selector) subselect must not be empty");
            p pVarH = h(strA2);
            v vVar = new v(i6);
            vVar.f893a = pVarH;
            arrayList.add(vVar);
            return;
        }
        if (p6.h(":nth-child(")) {
            d(false, false);
            return;
        }
        if (p6.h(":nth-last-child(")) {
            d(true, false);
            return;
        }
        if (p6.h(":nth-of-type(")) {
            d(false, true);
            return;
        }
        if (p6.h(":nth-last-of-type(")) {
            d(true, true);
            return;
        }
        if (p6.h(":first-child")) {
            arrayList.add(new g(i6));
            return;
        }
        if (p6.h(":last-child")) {
            arrayList.add(new g(i12));
            return;
        }
        if (p6.h(":first-of-type")) {
            arrayList.add(new l(0, 1, 3));
            return;
        }
        if (p6.h(":last-of-type")) {
            arrayList.add(new m(0, 1, 2));
            return;
        }
        if (p6.h(":only-child")) {
            arrayList.add(new g(i11));
            return;
        }
        if (p6.h(":only-of-type")) {
            arrayList.add(new g(5));
            return;
        }
        if (p6.h(":empty")) {
            arrayList.add(new g(i8));
        } else if (p6.h(":root")) {
            arrayList.add(new g(i5));
        } else {
            if (!p6.h(":matchText")) {
                throw new s("Could not parse query '%s': unexpected token at '%s'", str, p6.m());
            }
            arrayList.add(new g(i7));
        }
    }

    public final void f(boolean z6) {
        String str = z6 ? ":matchesOwn" : ":matches";
        P p6 = this.f892a;
        p6.c(str);
        String strA = p6.a('(', ')');
        V4.h.notEmpty(strA, ":matches(regex) query must not be empty");
        ArrayList arrayList = this.c;
        if (z6) {
            arrayList.add(new o(Pattern.compile(strA), 1));
        } else {
            arrayList.add(new o(Pattern.compile(strA), 0));
        }
    }

    public final p g() {
        P p6 = this.f892a;
        p6.f();
        String[] strArr = d;
        boolean zK = p6.k(strArr);
        ArrayList arrayList = this.c;
        if (zK) {
            arrayList.add(new g(8));
            a(p6.b());
        } else {
            e();
        }
        while (!p6.g()) {
            boolean zF = p6.f();
            if (p6.k(strArr)) {
                a(p6.b());
            } else if (zF) {
                a(Chars.SPACE);
            } else {
                e();
            }
        }
        return arrayList.size() == 1 ? (p) arrayList.get(0) : new c(arrayList);
    }

    public final String toString() {
        return this.b;
    }
}
