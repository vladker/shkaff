package A3;

import W3.InterfaceC0233q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: A3.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0157z {
    public static ArrayList A(Map map, Object obj) {
        ArrayList arrayList = new ArrayList();
        map.put(obj, arrayList);
        return arrayList;
    }

    public static Iterator B(InterfaceC0233q interfaceC0233q, String str, O3.l lVar, String str2) {
        kotlin.jvm.internal.E.f(interfaceC0233q, str);
        kotlin.jvm.internal.E.f(lVar, str2);
        return interfaceC0233q.iterator();
    }

    public static Iterator C(Iterable iterable, String str, O3.l lVar, String str2) {
        kotlin.jvm.internal.E.f(iterable, str);
        kotlin.jvm.internal.E.f(lVar, str2);
        return iterable.iterator();
    }

    public static void D(int i5, int i6, O3.l lVar) {
        lVar.invoke(Integer.valueOf(i5 + i6));
    }

    public static float a(float f6, float f7, float f8, float f9) {
        return ((f6 - f7) * f8) + f9;
    }

    public static int b(int i5, int i6, int i7, int i8) {
        return ((i5 - i6) / i7) + i8;
    }

    public static int c(CharSequence charSequence, String str, O3.l lVar, String str2) {
        kotlin.jvm.internal.E.f(charSequence, str);
        kotlin.jvm.internal.E.f(lVar, str2);
        return charSequence.length();
    }

    public static Object d(byte b, O3.l lVar) {
        return lVar.invoke(p147z3.D.a(p147z3.D.m1131constructorimpl(b)));
    }

    public static Object e(int i5, O3.l lVar) {
        return lVar.invoke(p147z3.G.a(p147z3.G.m1188constructorimpl(i5)));
    }

    public static Object f(int i5, List list) {
        return list.get(list.size() - i5);
    }

    public static Object g(long j6, O3.l lVar) {
        return lVar.invoke(p147z3.J.a(p147z3.J.m1247constructorimpl(j6)));
    }

    public static Object h(CharSequence charSequence, int i5, O3.l lVar) {
        return lVar.invoke(Character.valueOf(charSequence.charAt(i5)));
    }

    public static Object i(short s6, O3.l lVar) {
        return lVar.invoke(p147z3.N.a(p147z3.N.m1306constructorimpl(s6)));
    }

    public static String j(char c, String str, StringBuilder sb) {
        sb.append(c);
        String string = sb.toString();
        kotlin.jvm.internal.E.e(string, str);
        return string;
    }

    public static String k(int i5, String str) {
        return str + i5;
    }

    public static String l(String str, int i5, StringBuilder sb) {
        sb.append(i5);
        sb.append(str);
        return sb.toString();
    }

    public static String m(String str, A4.V v6) {
        return str + v6;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(StringBuilder sb, int i5, char c) {
        sb.append(i5);
        sb.append(c);
        return sb.toString();
    }

    public static String q(StringBuilder sb, int i5, int i6) {
        sb.append(i5 - i6);
        return sb.toString();
    }

    public static String r(StringBuilder sb, long j6, String str) {
        sb.append(j6);
        sb.append(str);
        return sb.toString();
    }

    public static String s(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder t(int i5, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i5);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder u(CharSequence charSequence, String str, O3.l lVar, String str2, CharSequence charSequence2) {
        kotlin.jvm.internal.E.f(charSequence, str);
        kotlin.jvm.internal.E.f(lVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder v(CharSequence charSequence, String str, O3.p pVar, String str2, CharSequence charSequence2) {
        kotlin.jvm.internal.E.f(charSequence, str);
        kotlin.jvm.internal.E.f(pVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder w(CharSequence charSequence, String str, CharSequence charSequence2, String str2, CharSequence charSequence3) {
        kotlin.jvm.internal.E.f(charSequence, str);
        kotlin.jvm.internal.E.f(charSequence2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence3);
        return sb;
    }

    public static StringBuilder x(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder y(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static ArrayList z(LinkedHashMap linkedHashMap, Object obj) {
        ArrayList arrayList = new ArrayList();
        linkedHashMap.put(obj, arrayList);
        return arrayList;
    }
}
