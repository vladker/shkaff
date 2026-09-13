package X3;

import A3.AbstractC0157z;
import A3.B0;
import A3.C0133b0;
import A3.C0135c0;
import A3.C0152u;
import A3.InterfaceC0131a0;
import A3.j0;
import A3.v0;
import A3.w0;
import W3.InterfaceC0233q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 extends c0 {
    public static final boolean all(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            if (!((Boolean) AbstractC0157z.h(charSequence, i5, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return !(charSequence.length() == 0);
    }

    public static final Iterable<Character> asIterable(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return ((charSequence instanceof String) && charSequence.length() == 0) ? A3.I.emptyList() : new A3.A(charSequence, 11);
    }

    public static final InterfaceC0233q asSequence(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return ((charSequence instanceof String) && charSequence.length() == 0) ? W3.z.emptySequence() : new a0(charSequence, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associate(CharSequence charSequence, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMapCapacity = j0.mapCapacity(charSequence.length());
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            C1938s c1938s = (C1938s) AbstractC0157z.h(charSequence, i5, transform);
            linkedHashMap.put(c1938s.f9134a, c1938s.b);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K> Map<K, Character> associateBy(CharSequence charSequence, O3.l keySelector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        int iMapCapacity = j0.mapCapacity(charSequence.length());
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            linkedHashMap.put(keySelector.invoke(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(CharSequence charSequence, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            destination.put(keySelector.invoke(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(CharSequence charSequence, M destination, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            C1938s c1938s = (C1938s) AbstractC0157z.h(charSequence, i5, transform);
            destination.put(c1938s.f9134a, c1938s.b);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <V> Map<Character, V> associateWith(CharSequence charSequence, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        int length = charSequence.length();
        if (length > 128) {
            length = 128;
        }
        int iMapCapacity = j0.mapCapacity(length);
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            linkedHashMap.put(Character.valueOf(cCharAt), valueSelector.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(CharSequence charSequence, M destination, O3.l valueSelector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(valueSelector, "valueSelector");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            destination.put(Character.valueOf(cCharAt), valueSelector.invoke(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    public static List<String> chunked(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return windowed(charSequence, i5, i5, true);
    }

    public static final InterfaceC0233q chunkedSequence(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return chunkedSequence(charSequence, i5, new S2.l(9));
    }

    private static final int count(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.length();
    }

    public static final CharSequence drop(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested character count ", " is less than zero.").toString());
        }
        int length = charSequence.length();
        if (i5 > length) {
            i5 = length;
        }
        return charSequence.subSequence(i5, charSequence.length());
    }

    public static final CharSequence dropLast(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested character count ", " is less than zero.").toString());
        }
        int length = charSequence.length() - i5;
        if (length < 0) {
            length = 0;
        }
        return take(charSequence, length);
    }

    public static final CharSequence dropLastWhile(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = b0.getLastIndex(charSequence); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.h(charSequence, lastIndex, predicate)).booleanValue()) {
                return charSequence.subSequence(0, lastIndex + 1);
            }
        }
        return "";
    }

    public static final CharSequence dropWhile(CharSequence charSequence, O3.l lVar) {
        int iC = AbstractC0157z.c(charSequence, "<this>", lVar, "predicate");
        for (int i5 = 0; i5 < iC; i5++) {
            if (!((Boolean) AbstractC0157z.h(charSequence, i5, lVar)).booleanValue()) {
                return charSequence.subSequence(i5, charSequence.length());
            }
        }
        return "";
    }

    private static final char elementAtOrElse(CharSequence charSequence, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= charSequence.length()) ? ((Character) defaultValue.invoke(Integer.valueOf(i5))).charValue() : charSequence.charAt(i5);
    }

    private static final Character elementAtOrNull(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return getOrNull(charSequence, i5);
    }

    public static final CharSequence filter(CharSequence charSequence, O3.l predicate) throws IOException {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    public static final CharSequence filterIndexed(CharSequence charSequence, O3.p predicate) throws IOException {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i5);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Character.valueOf(cCharAt))).booleanValue()) {
                sb.append(cCharAt);
            }
            i5++;
            i6 = i7;
        }
        return sb;
    }

    public static final <C extends Appendable> C filterIndexedTo(CharSequence charSequence, C destination, O3.p predicate) throws IOException {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i5);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Character.valueOf(cCharAt))).booleanValue()) {
                destination.append(cCharAt);
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final CharSequence filterNot(CharSequence charSequence, O3.l predicate) throws IOException {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (!((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    public static final <C extends Appendable> C filterNotTo(CharSequence charSequence, C destination, O3.l predicate) throws IOException {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (!((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                destination.append(cCharAt);
            }
        }
        return destination;
    }

    public static final <C extends Appendable> C filterTo(CharSequence charSequence, C destination, O3.l predicate) throws IOException {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                destination.append(cCharAt);
            }
        }
        return destination;
    }

    private static final Character find(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    private static final Character findLast(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            char cCharAt = charSequence.charAt(length);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final char first(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    private static final <R> R firstNotNullOf(CharSequence charSequence, O3.l transform) {
        R r6;
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            r6 = (R) AbstractC0157z.h(charSequence, i5, transform);
            if (r6 != null) {
                if (r6 != null) {
                    return r6;
                }
                throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
            }
        }
        r6 = null;
        if (r6 != null) {
            return r6;
        }
        throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
    }

    private static final <R> R firstNotNullOfOrNull(CharSequence charSequence, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            R r6 = (R) AbstractC0157z.h(charSequence, i5, transform);
            if (r6 != null) {
                return r6;
            }
        }
        return null;
    }

    public static final Character firstOrNull(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    public static final <R> List<R> flatMap(CharSequence charSequence, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            A3.O.addAll(arrayList, (Iterable) AbstractC0157z.h(charSequence, i5, transform));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(CharSequence charSequence, O3.p transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            A3.O.addAll(arrayList, (Iterable) transform.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i5))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(CharSequence charSequence, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            A3.O.addAll(destination, (Iterable) transform.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i5))));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(CharSequence charSequence, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            A3.O.addAll(destination, (Iterable) AbstractC0157z.h(charSequence, i5, transform));
        }
        return destination;
    }

    public static final <R> R fold(CharSequence charSequence, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            r6 = (R) operation.invoke(r6, Character.valueOf(charSequence.charAt(i5)));
        }
        return r6;
    }

    public static final <R> R foldIndexed(CharSequence charSequence, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, Character.valueOf(charSequence.charAt(i5)));
            i5++;
            i6++;
        }
        return r6;
    }

    public static final <R> R foldRight(CharSequence charSequence, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = b0.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Character.valueOf(charSequence.charAt(lastIndex)), r6);
        }
        return r6;
    }

    public static final <R> R foldRightIndexed(CharSequence charSequence, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        for (int lastIndex = b0.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r6 = (R) operation.invoke(Integer.valueOf(lastIndex), Character.valueOf(charSequence.charAt(lastIndex)), r6);
        }
        return r6;
    }

    public static final void forEach(CharSequence charSequence, O3.l action) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            action.invoke(Character.valueOf(charSequence.charAt(i5)));
        }
    }

    public static final void forEachIndexed(CharSequence charSequence, O3.p action) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            action.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i5)));
            i5++;
            i6++;
        }
    }

    private static final char getOrElse(CharSequence charSequence, int i5, O3.l defaultValue) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= charSequence.length()) ? ((Character) defaultValue.invoke(Integer.valueOf(i5))).charValue() : charSequence.charAt(i5);
    }

    public static final Character getOrNull(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i5 < 0 || i5 >= charSequence.length()) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i5));
    }

    public static final <K> Map<K, List<Character>> groupBy(CharSequence charSequence, O3.l keySelector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            Object objInvoke = keySelector.invoke(Character.valueOf(cCharAt));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(CharSequence charSequence, M destination, O3.l keySelector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            Object objInvoke = keySelector.invoke(Character.valueOf(cCharAt));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(Character.valueOf(cCharAt));
        }
        return destination;
    }

    public static final <K> InterfaceC0131a0 groupingBy(CharSequence charSequence, O3.l keySelector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        return new p075n1.a(charSequence, keySelector, 5);
    }

    public static final int indexOfFirst(CharSequence charSequence, O3.l lVar) {
        int iC = AbstractC0157z.c(charSequence, "<this>", lVar, "predicate");
        for (int i5 = 0; i5 < iC; i5++) {
            if (((Boolean) AbstractC0157z.h(charSequence, i5, lVar)).booleanValue()) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfLast(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (((Boolean) AbstractC0157z.h(charSequence, length, predicate)).booleanValue()) {
                    return length;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        return -1;
    }

    public static char last(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(b0.getLastIndex(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final Character lastOrNull(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static final <R> List<R> map(CharSequence charSequence, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            arrayList.add(transform.invoke(Character.valueOf(charSequence.charAt(i5))));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(CharSequence charSequence, O3.p transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            arrayList.add(transform.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i5))));
            i5++;
            i6++;
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexedNotNull(CharSequence charSequence, O3.p transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            int i7 = i6 + 1;
            Object objInvoke = transform.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i5)));
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
            i5++;
            i6 = i7;
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(CharSequence charSequence, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            int i7 = i6 + 1;
            Object objInvoke = transform.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i5)));
            if (objInvoke != null) {
                destination.add(objInvoke);
            }
            i5++;
            i6 = i7;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(CharSequence charSequence, C destination, O3.p transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        int i5 = 0;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            destination.add(transform.invoke(Integer.valueOf(i6), Character.valueOf(charSequence.charAt(i5))));
            i5++;
            i6++;
        }
        return destination;
    }

    public static final <R> List<R> mapNotNull(CharSequence charSequence, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            Object objH = AbstractC0157z.h(charSequence, i5, transform);
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C mapNotNullTo(CharSequence charSequence, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            Object objH = AbstractC0157z.h(charSequence, i5, transform);
            if (objH != null) {
                destination.add(objH);
            }
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(CharSequence charSequence, C destination, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(transform, "transform");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            destination.add(transform.invoke(Character.valueOf(charSequence.charAt(i5))));
        }
        return destination;
    }

    public static final <R extends Comparable<? super R>> Character maxByOrNull(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        Comparable comparable = (Comparable) lVar.invoke(Character.valueOf(cCharAt));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                Comparable comparable2 = (Comparable) lVar.invoke(Character.valueOf(cCharAt2));
                if (comparable.compareTo(comparable2) < 0) {
                    cCharAt = cCharAt2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final <R extends Comparable<? super R>> char maxByOrThrow(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) lVar.invoke(Character.valueOf(cCharAt));
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char cCharAt2 = charSequence.charAt(i5);
                    Comparable comparable2 = (Comparable) lVar.invoke(Character.valueOf(cCharAt2));
                    if (comparable.compareTo(comparable2) < 0) {
                        cCharAt = cCharAt2;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return cCharAt;
    }

    private static final double maxOf(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.h(charSequence, 0, lVar)).doubleValue();
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.h(charSequence, i5, lVar)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.h(charSequence, 0, lVar);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.h(charSequence, i5, lVar);
                if (r6.compareTo(comparable) < 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R> R maxOfWith(CharSequence charSequence, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.h(charSequence, 0, selector);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.h(charSequence, i5, selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R> R maxOfWithOrNull(CharSequence charSequence, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.h(charSequence, 0, selector);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.h(charSequence, i5, selector);
                if (comparator.compare(r6, obj) < 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Character maxOrNull(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                if (kotlin.jvm.internal.E.h(cCharAt, cCharAt2) < 0) {
                    cCharAt = cCharAt2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final char maxOrThrow(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                if (kotlin.jvm.internal.E.h(cCharAt, cCharAt2) < 0) {
                    cCharAt = cCharAt2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return cCharAt;
    }

    public static final Character maxWithOrNull(CharSequence charSequence, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                    cCharAt = cCharAt2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final char maxWithOrThrow(CharSequence charSequence, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                    cCharAt = cCharAt2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return cCharAt;
    }

    public static final <R extends Comparable<? super R>> Character minByOrNull(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        Comparable comparable = (Comparable) lVar.invoke(Character.valueOf(cCharAt));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                Comparable comparable2 = (Comparable) lVar.invoke(Character.valueOf(cCharAt2));
                if (comparable.compareTo(comparable2) > 0) {
                    cCharAt = cCharAt2;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final <R extends Comparable<? super R>> char minByOrThrow(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) lVar.invoke(Character.valueOf(cCharAt));
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    char cCharAt2 = charSequence.charAt(i5);
                    Comparable comparable2 = (Comparable) lVar.invoke(Character.valueOf(cCharAt2));
                    if (comparable.compareTo(comparable2) > 0) {
                        cCharAt = cCharAt2;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return cCharAt;
    }

    private static final double minOf(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) AbstractC0157z.h(charSequence, 0, lVar)).doubleValue();
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.h(charSequence, i5, lVar)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return dDoubleValue;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        R r6 = (R) AbstractC0157z.h(charSequence, 0, lVar);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Comparable comparable = (Comparable) AbstractC0157z.h(charSequence, i5, lVar);
                if (r6.compareTo(comparable) > 0) {
                    r6 = (R) comparable;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R> R minOfWith(CharSequence charSequence, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R r6 = (Object) AbstractC0157z.h(charSequence, 0, selector);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.h(charSequence, i5, selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    private static final <R> R minOfWithOrNull(CharSequence charSequence, Comparator<? super R> comparator, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R r6 = (Object) AbstractC0157z.h(charSequence, 0, selector);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                Object obj = (Object) AbstractC0157z.h(charSequence, i5, selector);
                if (comparator.compare(r6, obj) > 0) {
                    r6 = (R) obj;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return r6;
    }

    public static final Character minOrNull(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                if (kotlin.jvm.internal.E.h(cCharAt, cCharAt2) > 0) {
                    cCharAt = cCharAt2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final char minOrThrow(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                if (kotlin.jvm.internal.E.h(cCharAt, cCharAt2) > 0) {
                    cCharAt = cCharAt2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return cCharAt;
    }

    public static final Character minWithOrNull(CharSequence charSequence, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                    cCharAt = cCharAt2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final char minWithOrThrow(CharSequence charSequence, Comparator<? super Character> comparator) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i5);
                if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                    cCharAt = cCharAt2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return cCharAt;
    }

    public static final boolean none(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    public static final <S extends CharSequence> S onEach(S s6, O3.l action) {
        kotlin.jvm.internal.E.f(s6, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        for (int i5 = 0; i5 < s6.length(); i5++) {
            action.invoke(Character.valueOf(s6.charAt(i5)));
        }
        return s6;
    }

    public static final <S extends CharSequence> S onEachIndexed(S s6, O3.p action) {
        kotlin.jvm.internal.E.f(s6, "<this>");
        kotlin.jvm.internal.E.f(action, "action");
        int i5 = 0;
        int i6 = 0;
        while (i5 < s6.length()) {
            action.invoke(Integer.valueOf(i6), Character.valueOf(s6.charAt(i5)));
            i5++;
            i6++;
        }
        return s6;
    }

    public static final C1938s partition(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        return new C1938s(sb, sb2);
    }

    private static final char random(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return random(charSequence, S3.f.Default);
    }

    private static final Character randomOrNull(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return randomOrNull(charSequence, S3.f.Default);
    }

    public static final char reduce(CharSequence charSequence, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                cCharAt = ((Character) operation.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i5)))).charValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return cCharAt;
    }

    public static final char reduceIndexed(CharSequence charSequence, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                cCharAt = ((Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i5)))).charValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return cCharAt;
    }

    public static final Character reduceIndexedOrNull(CharSequence charSequence, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                cCharAt = ((Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i5)))).charValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character reduceOrNull(CharSequence charSequence, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                cCharAt = ((Character) operation.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i5)))).charValue();
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final char reduceRight(CharSequence charSequence, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(lastIndex);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            cCharAt = ((Character) operation.invoke(Character.valueOf(charSequence.charAt(i5)), Character.valueOf(cCharAt))).charValue();
        }
        return cCharAt;
    }

    public static final char reduceRightIndexed(CharSequence charSequence, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(lastIndex);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            cCharAt = ((Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(charSequence.charAt(i5)), Character.valueOf(cCharAt))).charValue();
        }
        return cCharAt;
    }

    public static final Character reduceRightIndexedOrNull(CharSequence charSequence, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(lastIndex);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            cCharAt = ((Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(charSequence.charAt(i5)), Character.valueOf(cCharAt))).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    public static final Character reduceRightOrNull(CharSequence charSequence, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        int lastIndex = b0.getLastIndex(charSequence);
        if (lastIndex < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(lastIndex);
        for (int i5 = lastIndex - 1; i5 >= 0; i5--) {
            cCharAt = ((Character) operation.invoke(Character.valueOf(charSequence.charAt(i5)), Character.valueOf(cCharAt))).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    public static final CharSequence reversed(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return new StringBuilder(charSequence).reverse();
    }

    public static final <R> List<R> runningFold(CharSequence charSequence, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r6);
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            r6 = (R) operation.invoke(r6, Character.valueOf(charSequence.charAt(i5)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final <R> List<R> runningFoldIndexed(CharSequence charSequence, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r6);
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Character.valueOf(charSequence.charAt(i5)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final List<Character> runningReduce(CharSequence charSequence, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            return A3.I.emptyList();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        int i5 = 1;
        while (i5 < length) {
            Character ch = (Character) operation.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i5)));
            char cCharValue = ch.charValue();
            arrayList.add(ch);
            i5++;
            cCharAt = cCharValue;
        }
        return arrayList;
    }

    public static final List<Character> runningReduceIndexed(CharSequence charSequence, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            return A3.I.emptyList();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        int i5 = 1;
        while (i5 < length) {
            Character ch = (Character) operation.invoke(Integer.valueOf(i5), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i5)));
            char cCharValue = ch.charValue();
            arrayList.add(ch);
            i5++;
            cCharAt = cCharValue;
        }
        return arrayList;
    }

    public static final <R> List<R> scan(CharSequence charSequence, R r6, O3.p operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r6);
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            r6 = (R) operation.invoke(r6, Character.valueOf(charSequence.charAt(i5)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static final <R> List<R> scanIndexed(CharSequence charSequence, R r6, O3.q operation) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        if (charSequence.length() == 0) {
            return A3.G.listOf(r6);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r6);
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            r6 = (R) operation.invoke(Integer.valueOf(i5), r6, Character.valueOf(charSequence.charAt(i5)));
            arrayList.add(r6);
        }
        return arrayList;
    }

    public static char single(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static final Character singleOrNull(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    public static final CharSequence slice(CharSequence charSequence, U3.q indices) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? "" : b0.subSequence(charSequence, indices);
    }

    public static final int sumBy(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            iIntValue += ((Number) AbstractC0157z.h(charSequence, i5, selector)).intValue();
        }
        return iIntValue;
    }

    public static final double sumByDouble(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            dDoubleValue += ((Number) AbstractC0157z.h(charSequence, i5, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    private static final double sumOfDouble(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            dDoubleValue += ((Number) AbstractC0157z.h(charSequence, i5, selector)).doubleValue();
        }
        return dDoubleValue;
    }

    private static final int sumOfInt(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iIntValue = 0;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            iIntValue += ((Number) AbstractC0157z.h(charSequence, i5, selector)).intValue();
        }
        return iIntValue;
    }

    private static final long sumOfLong(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jLongValue = 0;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            jLongValue += ((Number) AbstractC0157z.h(charSequence, i5, selector)).longValue();
        }
        return jLongValue;
    }

    private static final int sumOfUInt(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(0);
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            iM1188constructorimpl = p147z3.G.m1188constructorimpl(iM1188constructorimpl + ((p147z3.G) AbstractC0157z.h(charSequence, i5, selector)).f9124a);
        }
        return iM1188constructorimpl;
    }

    private static final long sumOfULong(CharSequence charSequence, O3.l selector) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(0L);
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            jM1247constructorimpl = p147z3.J.m1247constructorimpl(jM1247constructorimpl + ((p147z3.J) AbstractC0157z.h(charSequence, i5, selector)).f9126a);
        }
        return jM1247constructorimpl;
    }

    public static final CharSequence take(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested character count ", " is less than zero.").toString());
        }
        int length = charSequence.length();
        if (i5 > length) {
            i5 = length;
        }
        return charSequence.subSequence(0, i5);
    }

    public static final CharSequence takeLast(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested character count ", " is less than zero.").toString());
        }
        int length = charSequence.length();
        if (i5 > length) {
            i5 = length;
        }
        return charSequence.subSequence(length - i5, length);
    }

    public static final CharSequence takeLastWhile(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = b0.getLastIndex(charSequence); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) AbstractC0157z.h(charSequence, lastIndex, predicate)).booleanValue()) {
                return charSequence.subSequence(lastIndex + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final CharSequence takeWhile(CharSequence charSequence, O3.l lVar) {
        int iC = AbstractC0157z.c(charSequence, "<this>", lVar, "predicate");
        for (int i5 = 0; i5 < iC; i5++) {
            if (!((Boolean) AbstractC0157z.h(charSequence, i5, lVar)).booleanValue()) {
                return charSequence.subSequence(0, i5);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final <C extends Collection<? super Character>> C toCollection(CharSequence charSequence, C destination) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            destination.add(Character.valueOf(charSequence.charAt(i5)));
        }
        return destination;
    }

    public static final HashSet<Character> toHashSet(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length > 128) {
            length = 128;
        }
        return (HashSet) toCollection(charSequence, new HashSet(j0.mapCapacity(length)));
    }

    public static final List<Character> toList(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            return length != 1 ? toMutableList(charSequence) : A3.G.listOf(Character.valueOf(charSequence.charAt(0)));
        }
        return A3.I.emptyList();
    }

    public static final List<Character> toMutableList(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return (List) toCollection(charSequence, new ArrayList(charSequence.length()));
    }

    public static final Set<Character> toSet(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            return w0.emptySet();
        }
        if (length == 1) {
            return v0.setOf(Character.valueOf(charSequence.charAt(0)));
        }
        int length2 = charSequence.length();
        if (length2 > 128) {
            length2 = 128;
        }
        return (Set) toCollection(charSequence, new LinkedHashSet(j0.mapCapacity(length2)));
    }

    public static final List<String> windowed(CharSequence charSequence, int i5, int i6, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return windowed(charSequence, i5, i6, z6, new S2.l(7));
    }

    public static final InterfaceC0233q windowedSequence(CharSequence charSequence, int i5, int i6, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return windowedSequence(charSequence, i5, i6, z6, new S2.l(8));
    }

    public static final Iterable<C0133b0> withIndex(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        return new C0135c0(new C0152u(charSequence, 7));
    }

    public static final <V> List<V> zip(CharSequence charSequence, CharSequence other, O3.p transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iMin = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(transform.invoke(Character.valueOf(charSequence.charAt(i5)), Character.valueOf(other.charAt(i5))));
        }
        return arrayList;
    }

    public static final <R> List<R> zipWithNext(CharSequence charSequence, O3.p transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return A3.I.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i5 = 0;
        while (i5 < length) {
            Character chValueOf = Character.valueOf(charSequence.charAt(i5));
            i5++;
            arrayList.add(transform.invoke(chValueOf, Character.valueOf(charSequence.charAt(i5))));
        }
        return arrayList;
    }

    public static final boolean any(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            if (((Boolean) AbstractC0157z.h(charSequence, i5, predicate)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <R> List<R> chunked(CharSequence charSequence, int i5, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return windowed(charSequence, i5, i5, true, transform);
    }

    public static final <R> InterfaceC0233q chunkedSequence(CharSequence charSequence, int i5, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        return windowedSequence(charSequence, i5, i5, true, transform);
    }

    public static final int count(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int i5 = 0;
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            if (((Boolean) AbstractC0157z.h(charSequence, i6, predicate)).booleanValue()) {
                i5++;
            }
        }
        return i5;
    }

    public static final Character firstOrNull(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    public static final Character lastOrNull(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i5 = length - 1;
            char cCharAt = charSequence.charAt(length);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
            if (i5 < 0) {
                return null;
            }
            length = i5;
        }
    }

    public static final boolean none(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            if (((Boolean) AbstractC0157z.h(charSequence, i5, predicate)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static char random(CharSequence charSequence, S3.f random) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (charSequence.length() != 0) {
            return charSequence.charAt(random.d(charSequence.length()));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final Character randomOrNull(CharSequence charSequence, S3.f random) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(random.d(charSequence.length())));
    }

    private static final String reversed(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return reversed((CharSequence) str).toString();
    }

    public static final Character singleOrNull(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Character chValueOf = null;
        boolean z6 = false;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                if (z6) {
                    return null;
                }
                chValueOf = Character.valueOf(cCharAt);
                z6 = true;
            }
        }
        if (z6) {
            return chValueOf;
        }
        return null;
    }

    public static final <R> List<R> windowed(CharSequence charSequence, int i5, int i6, boolean z6, O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        B0.a(i5, i6);
        int length = charSequence.length();
        int i7 = 0;
        ArrayList arrayList = new ArrayList((length / i6) + (length % i6 == 0 ? 0 : 1));
        while (i7 >= 0 && i7 < length) {
            int i8 = i7 + i5;
            if (i8 < 0 || i8 > length) {
                if (!z6) {
                    break;
                }
                i8 = length;
            }
            arrayList.add(transform.invoke(charSequence.subSequence(i7, i8)));
            i7 += i6;
        }
        return arrayList;
    }

    public static final <R> InterfaceC0233q windowedSequence(final CharSequence charSequence, final int i5, int i6, boolean z6, final O3.l transform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(transform, "transform");
        B0.a(i5, i6);
        return W3.L.map(A3.T.asSequence(U3.B.step(z6 ? b0.getIndices(charSequence) : U3.B.until(0, (charSequence.length() - i5) + 1), i6)), new O3.l() { // from class: X3.d0
            @Override // O3.l
            public final Object invoke(Object obj) {
                int iIntValue = ((Integer) obj).intValue();
                int length = i5 + iIntValue;
                CharSequence charSequence2 = charSequence;
                if (length < 0 || length > charSequence2.length()) {
                    length = charSequence2.length();
                }
                return transform.invoke(charSequence2.subSequence(iIntValue, length));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(CharSequence charSequence, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            destination.put(keySelector.invoke(Character.valueOf(cCharAt)), valueTransform.invoke(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    public static final String filterNot(String str, O3.l predicate) throws IOException {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (!((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static final String slice(String str, U3.q indices) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return indices.isEmpty() ? "" : b0.substring(str, indices);
    }

    public static final String filterIndexed(String str, O3.p predicate) throws IOException {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        int i6 = 0;
        while (i5 < str.length()) {
            char cCharAt = str.charAt(i5);
            int i7 = i6 + 1;
            if (((Boolean) predicate.invoke(Integer.valueOf(i6), Character.valueOf(cCharAt))).booleanValue()) {
                sb.append(cCharAt);
            }
            i5++;
            i6 = i7;
        }
        return sb.toString();
    }

    public static final char first(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                return cCharAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final char last(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                char cCharAt = charSequence.charAt(length);
                if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                    return cCharAt;
                }
                if (i5 >= 0) {
                    length = i5;
                }
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final List<C1938s> zip(CharSequence charSequence, CharSequence other) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        int iMin = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i5 = 0; i5 < iMin; i5++) {
            arrayList.add(p147z3.A.to(Character.valueOf(charSequence.charAt(i5)), Character.valueOf(other.charAt(i5))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateBy(CharSequence charSequence, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        int iMapCapacity = j0.mapCapacity(charSequence.length());
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            linkedHashMap.put(keySelector.invoke(Character.valueOf(cCharAt)), valueTransform.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    public static final String filter(String str, O3.l predicate) throws IOException {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static final char single(CharSequence charSequence, O3.l predicate) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        Character chValueOf = null;
        boolean z6 = false;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                if (!z6) {
                    chValueOf = Character.valueOf(cCharAt);
                    z6 = true;
                } else {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
            }
        }
        if (z6) {
            kotlin.jvm.internal.E.d(chValueOf, "null cannot be cast to non-null type kotlin.Char");
            return chValueOf.charValue();
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final CharSequence slice(CharSequence charSequence, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        int iCollectionSizeOrDefault = A3.J.collectionSizeOrDefault(indices, 10);
        if (iCollectionSizeOrDefault == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iCollectionSizeOrDefault);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            sb.append(charSequence.charAt(it.next().intValue()));
        }
        return sb;
    }

    public static final List<C1938s> zipWithNext(CharSequence charSequence) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return A3.I.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i5 = 0;
        while (i5 < length) {
            char cCharAt = charSequence.charAt(i5);
            i5++;
            arrayList.add(p147z3.A.to(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i5))));
        }
        return arrayList;
    }

    public static final C1938s partition(String str, O3.l predicate) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (((Boolean) predicate.invoke(Character.valueOf(cCharAt))).booleanValue()) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        return new C1938s(sb.toString(), sb2.toString());
    }

    public static final String dropLastWhile(String str, O3.l predicate) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = b0.getLastIndex(str); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Character.valueOf(str.charAt(lastIndex)))).booleanValue()) {
                String strSubstring = str.substring(0, lastIndex + 1);
                kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return "";
    }

    public static final String takeLastWhile(String str, O3.l predicate) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        for (int lastIndex = b0.getLastIndex(str); -1 < lastIndex; lastIndex--) {
            if (!((Boolean) predicate.invoke(Character.valueOf(str.charAt(lastIndex)))).booleanValue()) {
                String strSubstring = str.substring(lastIndex + 1);
                kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return str;
    }

    public static String drop(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (i5 >= 0) {
            int length = str.length();
            if (i5 > length) {
                i5 = length;
            }
            String strSubstring = str.substring(i5);
            kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested character count ", " is less than zero.").toString());
    }

    public static String dropLast(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (i5 >= 0) {
            int length = str.length() - i5;
            if (length < 0) {
                length = 0;
            }
            return take(str, length);
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested character count ", " is less than zero.").toString());
    }

    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(CharSequence charSequence, M destination, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            Object objInvoke = keySelector.invoke(Character.valueOf(cCharAt));
            Object objA = destination.get(objInvoke);
            if (objA == null) {
                objA = AbstractC0157z.A(destination, objInvoke);
            }
            ((List) objA).add(valueTransform.invoke(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    private static final String slice(String str, Iterable<Integer> indices) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(indices, "indices");
        return slice((CharSequence) str, indices).toString();
    }

    public static final String take(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (i5 >= 0) {
            int length = str.length();
            if (i5 > length) {
                i5 = length;
            }
            String strSubstring = str.substring(0, i5);
            kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested character count ", " is less than zero.").toString());
    }

    public static final <K, V> Map<K, List<V>> groupBy(CharSequence charSequence, O3.l keySelector, O3.l valueTransform) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        kotlin.jvm.internal.E.f(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            char cCharAt = charSequence.charAt(i5);
            Object objInvoke = keySelector.invoke(Character.valueOf(cCharAt));
            Object objZ = linkedHashMap.get(objInvoke);
            if (objZ == null) {
                objZ = AbstractC0157z.z(linkedHashMap, objInvoke);
            }
            ((List) objZ).add(valueTransform.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    public static final String takeLast(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (i5 >= 0) {
            int length = str.length();
            if (i5 > length) {
                i5 = length;
            }
            String strSubstring = str.substring(length - i5);
            kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(androidx.collection.a.i(i5, "Requested character count ", " is less than zero.").toString());
    }

    public static final String dropWhile(String str, O3.l predicate) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!((Boolean) predicate.invoke(Character.valueOf(str.charAt(i5)))).booleanValue()) {
                String strSubstring = str.substring(i5);
                kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return "";
    }

    public static final String takeWhile(String str, O3.l predicate) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(predicate, "predicate");
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!((Boolean) predicate.invoke(Character.valueOf(str.charAt(i5)))).booleanValue()) {
                String strSubstring = str.substring(0, i5);
                kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m878maxOfOrNull(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.h(charSequence, 0, lVar)).doubleValue();
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.max(dDoubleValue, ((Number) AbstractC0157z.h(charSequence, i5, lVar)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m882minOfOrNull(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        double dDoubleValue = ((Number) AbstractC0157z.h(charSequence, 0, lVar)).doubleValue();
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                dDoubleValue = Math.min(dDoubleValue, ((Number) AbstractC0157z.h(charSequence, i5, lVar)).doubleValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final float m876maxOf(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") != 0) {
            float fFloatValue = ((Number) AbstractC0157z.h(charSequence, 0, lVar)).floatValue();
            int lastIndex = b0.getLastIndex(charSequence);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.h(charSequence, i5, lVar)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final float m880minOf(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") != 0) {
            float fFloatValue = ((Number) AbstractC0157z.h(charSequence, 0, lVar)).floatValue();
            int lastIndex = b0.getLastIndex(charSequence);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.h(charSequence, i5, lVar)).floatValue());
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return fFloatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m879maxOfOrNull(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.h(charSequence, 0, lVar)).floatValue();
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.max(fFloatValue, ((Number) AbstractC0157z.h(charSequence, i5, lVar)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m883minOfOrNull(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") == 0) {
            return null;
        }
        float fFloatValue = ((Number) AbstractC0157z.h(charSequence, 0, lVar)).floatValue();
        int lastIndex = b0.getLastIndex(charSequence);
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                fFloatValue = Math.min(fFloatValue, ((Number) AbstractC0157z.h(charSequence, i5, lVar)).floatValue());
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m877maxOf(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") != 0) {
            R r6 = (R) AbstractC0157z.h(charSequence, 0, lVar);
            int lastIndex = b0.getLastIndex(charSequence);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.h(charSequence, i5, lVar);
                    if (r6.compareTo(comparable) < 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m881minOf(CharSequence charSequence, O3.l lVar) {
        if (AbstractC0157z.c(charSequence, "<this>", lVar, "selector") != 0) {
            R r6 = (R) AbstractC0157z.h(charSequence, 0, lVar);
            int lastIndex = b0.getLastIndex(charSequence);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Comparable comparable = (Comparable) AbstractC0157z.h(charSequence, i5, lVar);
                    if (r6.compareTo(comparable) > 0) {
                        r6 = (R) comparable;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            return r6;
        }
        throw new NoSuchElementException();
    }
}
