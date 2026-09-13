package X3;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import W3.InterfaceC0233q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 extends W {
    public static final C1938s b(CharSequence charSequence, Collection collection, int i5, boolean z6, boolean z7) {
        U3.n nVarDownTo;
        Object next;
        String str;
        Object next2;
        String str2;
        if (z6 || collection.size() != 1) {
            if (z7) {
                int lastIndex = getLastIndex(charSequence);
                nVarDownTo = U3.B.downTo(i5 > lastIndex ? lastIndex : i5, 0);
            } else {
                nVarDownTo = new U3.q(i5 < 0 ? 0 : i5, charSequence.length(), 1);
            }
            if (charSequence instanceof String) {
                int i6 = nVarDownTo.f732a;
                int i7 = nVarDownTo.b;
                int i8 = nVarDownTo.c;
                if ((i8 > 0 && i6 <= i7) || (i8 < 0 && i7 <= i6)) {
                    int i9 = i6;
                    while (true) {
                        Iterator it = collection.iterator();
                        do {
                            if (!it.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it.next();
                            str2 = (String) next2;
                        } while (!W.regionMatches(str2, 0, (String) charSequence, i9, str2.length(), z6));
                        String str3 = (String) next2;
                        if (str3 != null) {
                            return p147z3.A.to(Integer.valueOf(i9), str3);
                        }
                        if (i9 != i7) {
                            i9 += i8;
                        }
                    }
                }
            } else {
                int i10 = nVarDownTo.f732a;
                int i11 = nVarDownTo.b;
                int i12 = nVarDownTo.c;
                if ((i12 > 0 && i10 <= i11) || (i12 < 0 && i11 <= i10)) {
                    int i13 = i10;
                    while (true) {
                        Iterator it2 = collection.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                            str = (String) next;
                        } while (!regionMatchesImpl(str, 0, charSequence, i13, str.length(), z6));
                        String str4 = (String) next;
                        if (str4 != null) {
                            return p147z3.A.to(Integer.valueOf(i13), str4);
                        }
                        if (i13 != i11) {
                            i13 += i12;
                        }
                    }
                }
            }
        } else {
            String str5 = (String) A3.T.single(collection);
            int iE = !z7 ? e(charSequence, str5, i5, false, 4) : g(str5, i5, 4, charSequence);
            if (iE >= 0) {
                return p147z3.A.to(Integer.valueOf(iE), str5);
            }
        }
        return null;
    }

    public static final int c(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z6, boolean z7) {
        U3.n nVarDownTo;
        if (z7) {
            int lastIndex = getLastIndex(charSequence);
            if (i5 > lastIndex) {
                i5 = lastIndex;
            }
            if (i6 < 0) {
                i6 = 0;
            }
            nVarDownTo = U3.B.downTo(i5, i6);
        } else {
            if (i5 < 0) {
                i5 = 0;
            }
            int length = charSequence.length();
            if (i6 > length) {
                i6 = length;
            }
            nVarDownTo = new U3.q(i5, i6, 1);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int i7 = nVarDownTo.f732a;
            int i8 = nVarDownTo.b;
            int i9 = nVarDownTo.c;
            if ((i9 <= 0 || i7 > i8) && (i9 >= 0 || i8 > i7)) {
                return -1;
            }
            int i10 = i7;
            while (true) {
                String str = (String) charSequence2;
                boolean z8 = z6;
                if (W.regionMatches(str, 0, (String) charSequence, i10, str.length(), z8)) {
                    return i10;
                }
                if (i10 == i8) {
                    return -1;
                }
                i10 += i9;
                z6 = z8;
            }
        } else {
            boolean z9 = z6;
            int i11 = nVarDownTo.f732a;
            int i12 = nVarDownTo.b;
            int i13 = nVarDownTo.c;
            if ((i13 <= 0 || i11 > i12) && (i13 >= 0 || i12 > i11)) {
                return -1;
            }
            int i14 = i11;
            while (true) {
                boolean z10 = z9;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z9 = z10;
                if (regionMatchesImpl(charSequence4, 0, charSequence3, i14, charSequence2.length(), z10)) {
                    return i14;
                }
                if (i14 == i12) {
                    return -1;
                }
                i14 += i13;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static final String commonPrefixWith(CharSequence charSequence, CharSequence other, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(charSequence.length(), other.length());
        int i5 = 0;
        while (i5 < iMin && AbstractC0240f.b(charSequence.charAt(i5), other.charAt(i5), z6)) {
            i5++;
        }
        int i6 = i5 - 1;
        if (hasSurrogatePairAt(charSequence, i6) || hasSurrogatePairAt(other, i6)) {
            i5--;
        }
        return charSequence.subSequence(0, i5).toString();
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence other, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int length = charSequence.length();
        int length2 = other.length();
        int iMin = Math.min(length, length2);
        int i5 = 0;
        while (i5 < iMin && AbstractC0240f.b(charSequence.charAt((length - i5) - 1), other.charAt((length2 - i5) - 1), z6)) {
            i5++;
        }
        if (hasSurrogatePairAt(charSequence, (length - i5) - 1) || hasSurrogatePairAt(other, (length2 - i5) - 1)) {
            i5--;
        }
        return charSequence.subSequence(length - i5, length).toString();
    }

    public static boolean contains(CharSequence charSequence, CharSequence other, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        if (other instanceof String) {
            if (e(charSequence, (String) other, 0, z6, 2) >= 0) {
                return true;
            }
        } else if (c(charSequence, other, 0, charSequence.length(), z6, false) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return W.equals((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!AbstractC0240f.b(charSequence.charAt(i5), charSequence2.charAt(i5), true)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (charSequence.charAt(i5) != charSequence2.charAt(i5)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ int d(CharSequence charSequence, char c, int i5, boolean z6, int i6) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z6 = false;
        }
        return indexOf(charSequence, c, i5, z6);
    }

    public static /* synthetic */ int e(CharSequence charSequence, String str, int i5, boolean z6, int i6) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z6 = false;
        }
        return indexOf(charSequence, str, i5, z6);
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC0240f.b(charSequence.charAt(getLastIndex(charSequence)), c, z6);
    }

    public static /* synthetic */ int f(String str, char c) {
        return lastIndexOf((CharSequence) str, c, getLastIndex(str), false);
    }

    public static final C1938s findAnyOf(CharSequence charSequence, Collection<String> strings, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(strings, "strings");
        return b(charSequence, strings, i5, z6, false);
    }

    public static final C1938s findLastAnyOf(CharSequence charSequence, Collection<String> strings, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(strings, "strings");
        return b(charSequence, strings, i5, z6, true);
    }

    public static /* synthetic */ int g(String str, int i5, int i6, CharSequence charSequence) {
        if ((i6 & 2) != 0) {
            i5 = getLastIndex(charSequence);
        }
        return lastIndexOf(charSequence, str, i5, false);
    }

    public static final U3.q getIndices(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return new U3.q(0, charSequence.length() - 1, 1);
    }

    public static int getLastIndex(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static C0243i h(CharSequence charSequence, char[] cArr, boolean z6, int i5) {
        j(i5);
        return new C0243i(charSequence, 0, i5, new Y(0, cArr, z6));
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return i5 >= 0 && i5 <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i5)) && Character.isLowSurrogate(charSequence.charAt(i5 + 1));
    }

    public static C0243i i(CharSequence charSequence, String[] strArr, boolean z6, int i5) {
        j(i5);
        return new C0243i(charSequence, 0, i5, new Y(1, AbstractC0151t.asList(strArr), z6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifBlank(C c, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return isBlank(c) ? (R) defaultValue.invoke() : c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifEmpty(C c, O3.a defaultValue) {
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return c.length() == 0 ? (R) defaultValue.invoke() : c;
    }

    public static final int indexOf(CharSequence charSequence, char c, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return (z6 || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c}, i5, z6) : ((String) charSequence).indexOf(c, i5);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] chars, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(chars, "chars");
        if (!z6 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(A3.C.single(chars), i5);
        }
        if (i5 < 0) {
            i5 = 0;
        }
        int lastIndex = getLastIndex(charSequence);
        if (i5 > lastIndex) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i5);
            for (char c : chars) {
                if (AbstractC0240f.b(c, cCharAt, z6)) {
                    return i5;
                }
            }
            if (i5 == lastIndex) {
                return -1;
            }
            i5++;
        }
    }

    public static boolean isBlank(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            if (!AbstractC0239e.a(charSequence.charAt(i5))) {
                return false;
            }
        }
        return true;
    }

    private static final boolean isEmpty(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    private static final boolean isNotBlank(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return !isBlank(charSequence);
    }

    private static final boolean isNotEmpty(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.length() > 0;
    }

    private static final boolean isNullOrBlank(CharSequence charSequence) {
        return charSequence == null || isBlank(charSequence);
    }

    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static final A3.F iterator(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return new Z(charSequence);
    }

    public static final void j(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List k(CharSequence charSequence, String str, int i5, boolean z6) {
        j(i5);
        int length = 0;
        int iIndexOf = indexOf(charSequence, str, 0, z6);
        if (iIndexOf == -1 || i5 == 1) {
            return A3.G.listOf(charSequence.toString());
        }
        boolean z7 = i5 > 0;
        int i6 = 10;
        if (z7 && i5 <= 10) {
            i6 = i5;
        }
        ArrayList arrayList = new ArrayList(i6);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z7 && arrayList.size() == i5 - 1) {
                break;
            }
            iIndexOf = indexOf(charSequence, str, length, z6);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return (z6 || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c}, i5, z6) : ((String) charSequence).lastIndexOf(c, i5);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] chars, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(chars, "chars");
        if (!z6 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(A3.C.single(chars), i5);
        }
        int lastIndex = getLastIndex(charSequence);
        if (i5 > lastIndex) {
            i5 = lastIndex;
        }
        while (-1 < i5) {
            char cCharAt = charSequence.charAt(i5);
            for (char c : chars) {
                if (AbstractC0240f.b(c, cCharAt, z6)) {
                    return i5;
                }
            }
            i5--;
        }
        return -1;
    }

    public static final InterfaceC0233q lineSequence(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return new a0(charSequence, 0);
    }

    public static final List<String> lines(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return W3.L.toList(lineSequence(charSequence));
    }

    private static final boolean matches(CharSequence charSequence, G regex) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(regex, "regex");
        return regex.matches(charSequence);
    }

    private static final String orEmpty(String str) {
        return str == null ? "" : str;
    }

    public static final CharSequence padEnd(CharSequence charSequence, int i5, char c) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Desired length ", " is less than zero."));
        }
        if (i5 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i5);
        sb.append(charSequence);
        int length = i5 - charSequence.length();
        int i6 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        return sb;
    }

    public static final CharSequence padStart(CharSequence charSequence, int i5, char c) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Desired length ", " is less than zero."));
        }
        if (i5 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i5);
        int length = i5 - charSequence.length();
        int i6 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i5, CharSequence other, int i6, int i7, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        if (i6 < 0 || i5 < 0 || i5 > charSequence.length() - i7 || i6 > other.length() - i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!AbstractC0240f.b(charSequence.charAt(i5 + i8), other.charAt(i6 + i8), z6)) {
                return false;
            }
        }
        return true;
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence prefix) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        return startsWith(charSequence, prefix, false) ? charSequence.subSequence(prefix.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeRange(CharSequence charSequence, int i5, int i6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i6 < i5) {
            throw new IndexOutOfBoundsException(androidx.collection.a.m("End index (", i6, i5, ") is less than start index (", ")."));
        }
        if (i6 == i5) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i6 - i5));
        sb.append(charSequence, 0, i5);
        sb.append(charSequence, i6, charSequence.length());
        return sb;
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence suffix) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(suffix, "suffix");
        return endsWith(charSequence, suffix, false) ? charSequence.subSequence(0, charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence prefix, CharSequence suffix) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(suffix, "suffix");
        return (charSequence.length() >= suffix.length() + prefix.length() && startsWith(charSequence, prefix, false) && endsWith(charSequence, suffix, false)) ? charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    private static final String replace(CharSequence charSequence, G regex, String replacement) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(regex, "regex");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        return regex.replace(charSequence, replacement);
    }

    public static final String replaceAfter(String str, char c, String replacement, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iD = d(str, c, 0, false, 6);
        return iD == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, iD + 1, str.length(), (CharSequence) replacement).toString();
    }

    public static final String replaceAfterLast(String str, String delimiter, String replacement, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iG = g(delimiter, 0, 6, str);
        return iG == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, delimiter.length() + iG, str.length(), (CharSequence) replacement).toString();
    }

    public static final String replaceBefore(String str, char c, String replacement, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iD = d(str, c, 0, false, 6);
        return iD == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, 0, iD, (CharSequence) replacement).toString();
    }

    public static final String replaceBeforeLast(String str, char c, String replacement, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iF = f(str, c);
        return iF == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, 0, iF, (CharSequence) replacement).toString();
    }

    private static final String replaceFirst(CharSequence charSequence, G regex, String replacement) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(regex, "regex");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        return regex.replaceFirst(charSequence, replacement);
    }

    private static final String replaceFirstCharWithChar(String str, O3.l transform) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        if (str.length() <= 0) {
            return str;
        }
        char cCharValue = ((Character) transform.invoke(Character.valueOf(str.charAt(0)))).charValue();
        String strSubstring = str.substring(1);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return cCharValue + strSubstring;
    }

    private static final String replaceFirstCharWithCharSequence(String str, O3.l transform) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(transform.invoke(Character.valueOf(str.charAt(0))));
        String strSubstring = str.substring(1);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i5, int i6, CharSequence replacement) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        if (i6 < i5) {
            throw new IndexOutOfBoundsException(androidx.collection.a.m("End index (", i6, i5, ") is less than start index (", ")."));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence, 0, i5);
        sb.append(replacement);
        sb.append(charSequence, i6, charSequence.length());
        return sb;
    }

    public static final List<String> split(CharSequence charSequence, String[] delimiters, boolean z6, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return k(charSequence, str, i5, z6);
            }
        }
        Iterable iterableAsIterable = W3.L.asIterable(i(charSequence, delimiters, z6, i5));
        ArrayList arrayList = new ArrayList(A3.J.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (U3.q) it.next()));
        }
        return arrayList;
    }

    public static final InterfaceC0233q splitToSequence(CharSequence charSequence, String[] delimiters, boolean z6, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(delimiters, "delimiters");
        return W3.L.map(i(charSequence, delimiters, z6, i5), new X(charSequence, 1));
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC0240f.b(charSequence.charAt(0), c, z6);
    }

    public static final CharSequence subSequence(CharSequence charSequence, U3.q range) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static final String substring(String str, U3.q range) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        String strSubstring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String substringAfter(String str, char c, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iD = d(str, c, 0, false, 6);
        if (iD == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iD + 1, str.length());
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String substringAfterLast(String str, char c, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iF = f(str, c);
        if (iF == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iF + 1, str.length());
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String substringBefore(String str, char c, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iD = d(str, c, 0, false, 6);
        if (iD == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iD);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String substringBeforeLast(String str, char c, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iF = f(str, c);
        if (iF == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iF);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean toBooleanStrict(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (str.equals("true")) {
            return true;
        }
        if (str.equals("false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: ".concat(str));
    }

    public static Boolean toBooleanStrictOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (str.equals("true")) {
            return Boolean.TRUE;
        }
        if (str.equals("false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final CharSequence trim(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z6 = false;
        while (i5 <= length) {
            boolean zBooleanValue = ((Boolean) AbstractC0157z.h(charSequence, !z6 ? i5 : length, predicate)).booleanValue();
            if (z6) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i5++;
            } else {
                z6 = true;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i5 = length - 1;
            if (!((Boolean) AbstractC0157z.h(charSequence, length, predicate)).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i5 < 0) {
                return "";
            }
            length = i5;
        }
    }

    public static final CharSequence trimStart(CharSequence charSequence, O3.l lVar) {
        int iC = AbstractC0157z.c(charSequence, "<this>", lVar, "predicate");
        for (int i5 = 0; i5 < iC; i5++) {
            if (!((Boolean) AbstractC0157z.h(charSequence, i5, lVar)).booleanValue()) {
                return charSequence.subSequence(i5, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence suffix, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(suffix, "suffix");
        return (!z6 && (charSequence instanceof String) && (suffix instanceof String)) ? W.endsWith((String) charSequence, (String) suffix, false) : regionMatchesImpl(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z6);
    }

    private static final String replace(CharSequence charSequence, G regex, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(regex, "regex");
        kotlin.jvm.internal.E.f(transform, "transform");
        return regex.replace(charSequence, transform);
    }

    public static final InterfaceC0233q splitToSequence(CharSequence charSequence, char[] delimiters, boolean z6, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(delimiters, "delimiters");
        return W3.L.map(h(charSequence, delimiters, z6, i5), new X(charSequence, 0));
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence prefix, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        return (!z6 && (charSequence instanceof String) && (prefix instanceof String)) ? W.startsWith((String) charSequence, (String) prefix, false) : regionMatchesImpl(charSequence, 0, prefix, 0, prefix.length(), z6);
    }

    private static final CharSequence subSequence(String str, int i5, int i6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return str.subSequence(i5, i6);
    }

    private static final String substring(CharSequence charSequence, int i5, int i6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.subSequence(i5, i6).toString();
    }

    public static final String replaceAfter(String str, String delimiter, String replacement, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iE = e(str, delimiter, 0, false, 6);
        return iE == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, delimiter.length() + iE, str.length(), (CharSequence) replacement).toString();
    }

    public static final String replaceAfterLast(String str, char c, String replacement, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iF = f(str, c);
        return iF == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, iF + 1, str.length(), (CharSequence) replacement).toString();
    }

    public static final String replaceBefore(String str, String delimiter, String replacement, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iE = e(str, delimiter, 0, false, 6);
        return iE == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, 0, iE, (CharSequence) replacement).toString();
    }

    public static final String replaceBeforeLast(String str, String delimiter, String replacement, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iG = g(delimiter, 0, 6, str);
        return iG == -1 ? missingDelimiterValue : replaceRange((CharSequence) str, 0, iG, (CharSequence) replacement).toString();
    }

    private static final InterfaceC0233q splitToSequence(CharSequence charSequence, G regex, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(regex, "regex");
        return regex.splitToSequence(charSequence, i5);
    }

    public static final String substring(CharSequence charSequence, U3.q range) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substringAfter(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iE = e(str, delimiter, 0, false, 6);
        if (iE == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(delimiter.length() + iE, str.length());
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String substringAfterLast(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iG = g(delimiter, 0, 6, str);
        if (iG == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(delimiter.length() + iG, str.length());
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String substringBefore(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iE = e(str, delimiter, 0, false, 6);
        if (iE == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iE);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String substringBeforeLast(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        kotlin.jvm.internal.E.f(missingDelimiterValue, "missingDelimiterValue");
        int iG = g(delimiter, 0, 6, str);
        if (iG == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iG);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int indexOf(CharSequence charSequence, String string, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(string, "string");
        if (!z6 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i5);
        }
        return c(charSequence, string, i5, charSequence.length(), z6, false);
    }

    public static final int lastIndexOf(CharSequence charSequence, String string, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(string, "string");
        if (!z6 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i5);
        }
        return c(charSequence, string, i5, 0, z6, true);
    }

    public static String removePrefix(String str, CharSequence prefix) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        if (!startsWith((CharSequence) str, prefix, false)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String removeSuffix(String str, CharSequence suffix) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(suffix, "suffix");
        if (!endsWith((CharSequence) str, suffix, false)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return d(charSequence, c, 0, z6, 2) >= 0;
    }

    private static final boolean contains(CharSequence charSequence, G regex) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(regex, "regex");
        return regex.containsMatchIn(charSequence);
    }

    public static final String removeSurrounding(String str, CharSequence prefix, CharSequence suffix) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        kotlin.jvm.internal.E.f(suffix, "suffix");
        if (str.length() < suffix.length() + prefix.length() || !startsWith((CharSequence) str, prefix, false) || !endsWith((CharSequence) str, suffix, false)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length(), str.length() - suffix.length());
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence prefix, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        if (!z6 && (charSequence instanceof String) && (prefix instanceof String)) {
            return W.startsWith((String) charSequence, (String) prefix, i5, false);
        }
        return regionMatchesImpl(charSequence, i5, prefix, 0, prefix.length(), z6);
    }

    public static final int indexOfAny(CharSequence charSequence, Collection<String> strings, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(strings, "strings");
        C1938s c1938sB = b(charSequence, strings, i5, z6, false);
        if (c1938sB != null) {
            return ((Number) c1938sB.f9134a).intValue();
        }
        return -1;
    }

    public static final int lastIndexOfAny(CharSequence charSequence, Collection<String> strings, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(strings, "strings");
        C1938s c1938sB = b(charSequence, strings, i5, z6, true);
        if (c1938sB != null) {
            return ((Number) c1938sB.f9134a).intValue();
        }
        return -1;
    }

    private static final String trim(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return trim((CharSequence) str).toString();
    }

    public static final String trim(String str, O3.l predicate) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = str.length() - 1;
        int i5 = 0;
        boolean z6 = false;
        while (i5 <= length) {
            boolean zBooleanValue = ((Boolean) predicate.invoke(Character.valueOf(str.charAt(!z6 ? i5 : length)))).booleanValue();
            if (z6) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i5++;
            } else {
                z6 = true;
            }
        }
        return str.subSequence(i5, length + 1).toString();
    }

    private static final String trimEnd(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return trimEnd((CharSequence) str).toString();
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence delimiter) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        return removeSurrounding(charSequence, delimiter, delimiter);
    }

    public static final String trimEnd(String str, O3.l predicate) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = str.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i5 = length - 1;
            if (!((Boolean) predicate.invoke(Character.valueOf(str.charAt(length)))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
            if (i5 < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i5;
        }
        return charSequenceSubSequence.toString();
    }

    public static final String removeSurrounding(String str, CharSequence delimiter) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(delimiter, "delimiter");
        return removeSurrounding(str, delimiter, delimiter);
    }

    public static final List<String> split(CharSequence charSequence, char[] delimiters, boolean z6, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return k(charSequence, String.valueOf(delimiters[0]), i5, z6);
        }
        Iterable iterableAsIterable = W3.L.asIterable(h(charSequence, delimiters, z6, i5));
        ArrayList arrayList = new ArrayList(A3.J.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (U3.q) it.next()));
        }
        return arrayList;
    }

    private static final String trimStart(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return trimStart((CharSequence) str).toString();
    }

    public static final CharSequence trim(CharSequence charSequence, char... chars) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(chars, "chars");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z6 = false;
        while (i5 <= length) {
            boolean zContains = A3.C.contains(chars, charSequence.charAt(!z6 ? i5 : length));
            if (z6) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i5++;
            } else {
                z6 = true;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static final String trimStart(String str, O3.l predicate) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!((Boolean) predicate.invoke(Character.valueOf(str.charAt(i5)))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(i5, str.length());
                return charSequenceSubSequence.toString();
            }
        }
        charSequenceSubSequence = "";
        return charSequenceSubSequence.toString();
    }

    public static final String padEnd(String str, int i5, char c) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return padEnd((CharSequence) str, i5, c).toString();
    }

    public static String padStart(String str, int i5, char c) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return padStart((CharSequence) str, i5, c).toString();
    }

    private static final String removeRange(String str, int i5, int i6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return removeRange((CharSequence) str, i5, i6).toString();
    }

    private static final String replaceRange(String str, int i5, int i6, CharSequence replacement) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        return replaceRange((CharSequence) str, i5, i6, replacement).toString();
    }

    public static final CharSequence trimEnd(CharSequence charSequence, char... chars) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(chars, "chars");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i5 = length - 1;
            if (!A3.C.contains(chars, charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i5 < 0) {
                return "";
            }
            length = i5;
        }
    }

    public static final CharSequence removeRange(CharSequence charSequence, U3.q range) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        return removeRange(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    public static final CharSequence replaceRange(CharSequence charSequence, U3.q range, CharSequence replacement) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        return replaceRange(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    private static final String removeRange(String str, U3.q range) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        return removeRange((CharSequence) str, range).toString();
    }

    private static final String replaceRange(String str, U3.q range, CharSequence replacement) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        return replaceRange((CharSequence) str, range, replacement).toString();
    }

    public static final String trim(String str, char... chars) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(chars, "chars");
        int length = str.length() - 1;
        int i5 = 0;
        boolean z6 = false;
        while (i5 <= length) {
            boolean zContains = A3.C.contains(chars, str.charAt(!z6 ? i5 : length));
            if (z6) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i5++;
            } else {
                z6 = true;
            }
        }
        return str.subSequence(i5, length + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence charSequence, char... chars) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(chars, "chars");
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!A3.C.contains(chars, charSequence.charAt(i5))) {
                return charSequence.subSequence(i5, charSequence.length());
            }
        }
        return "";
    }

    private static final List<String> split(CharSequence charSequence, G regex, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(regex, "regex");
        return regex.split(charSequence, i5);
    }

    public static final String trimEnd(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(chars, "chars");
        int length = str.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i5 = length - 1;
            if (!A3.C.contains(chars, str.charAt(length))) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
            if (i5 < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i5;
        }
        return charSequenceSubSequence.toString();
    }

    public static CharSequence trim(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z6 = false;
        while (i5 <= length) {
            boolean zA = AbstractC0239e.a(charSequence.charAt(!z6 ? i5 : length));
            if (z6) {
                if (!zA) {
                    break;
                }
                length--;
            } else if (zA) {
                i5++;
            } else {
                z6 = true;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static final String trimStart(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(chars, "chars");
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!A3.C.contains(chars, str.charAt(i5))) {
                charSequenceSubSequence = str.subSequence(i5, str.length());
                return charSequenceSubSequence.toString();
            }
        }
        charSequenceSubSequence = "";
        return charSequenceSubSequence.toString();
    }

    public static final CharSequence trimEnd(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i5 = length - 1;
            if (!AbstractC0239e.a(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i5 < 0) {
                return "";
            }
            length = i5;
        }
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!AbstractC0239e.a(charSequence.charAt(i5))) {
                return charSequence.subSequence(i5, charSequence.length());
            }
        }
        return "";
    }
}
