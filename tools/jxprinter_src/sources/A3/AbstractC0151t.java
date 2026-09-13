package A3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: renamed from: A3.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0151t extends AbstractC0146n {
    public static <T> List<T> asList(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        List<T> listAsList = Arrays.asList(tArr);
        kotlin.jvm.internal.E.e(listAsList, "asList(...)");
        return listAsList;
    }

    public static /* synthetic */ void b(int[] iArr, int[] iArr2, int i5, int i6, int i7) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = iArr.length;
        }
        copyInto(iArr, iArr2, i5, 0, i6);
    }

    public static final <T> int binarySearch(T[] tArr, T t6, Comparator<? super T> comparator, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return Arrays.binarySearch(tArr, i5, i6, t6, comparator);
    }

    public static /* synthetic */ void c(Object[] objArr, Object[] objArr2, int i5, int i6, int i7, int i8) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = objArr.length;
        }
        copyInto(objArr, objArr2, i5, i6, i7);
    }

    private static final <T> boolean contentDeepEqualsInline(T[] tArr, T[] other) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        return I3.c.apiVersionIsAtLeast(1, 3, 0) ? AbstractC0146n.contentDeepEquals(tArr, other) : Arrays.deepEquals(tArr, other);
    }

    private static final <T> boolean contentDeepEqualsNullable(T[] tArr, T[] tArr2) {
        return I3.c.apiVersionIsAtLeast(1, 3, 0) ? AbstractC0146n.contentDeepEquals(tArr, tArr2) : Arrays.deepEquals(tArr, tArr2);
    }

    private static final <T> int contentDeepHashCodeInline(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return I3.c.apiVersionIsAtLeast(1, 3, 0) ? AbstractC0145m.contentDeepHashCode(tArr) : Arrays.deepHashCode(tArr);
    }

    private static final <T> int contentDeepHashCodeNullable(T[] tArr) {
        return I3.c.apiVersionIsAtLeast(1, 3, 0) ? AbstractC0145m.contentDeepHashCode(tArr) : Arrays.deepHashCode(tArr);
    }

    private static final <T> String contentDeepToStringInline(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return AbstractC0146n.contentDeepToString(tArr);
        }
        String strDeepToString = Arrays.deepToString(tArr);
        kotlin.jvm.internal.E.e(strDeepToString, "deepToString(...)");
        return strDeepToString;
    }

    private static final <T> String contentDeepToStringNullable(T[] tArr) {
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return AbstractC0146n.contentDeepToString(tArr);
        }
        String strDeepToString = Arrays.deepToString(tArr);
        kotlin.jvm.internal.E.e(strDeepToString, "deepToString(...)");
        return strDeepToString;
    }

    private static final <T> boolean contentEquals(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    private static final <T> int contentHashCode(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    private static final <T> String contentToString(T[] tArr) {
        String string = Arrays.toString(tArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static <T> T[] copyInto(T[] tArr, T[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(tArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final <T> T[] copyOf(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.E.e(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i5, i6);
        kotlin.jvm.internal.E.e(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    private static final <T> T[] copyOfRangeInline(T[] tArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return (T[]) copyOfRange(tArr, i5, i6);
        }
        if (i6 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i5, i6);
            kotlin.jvm.internal.E.c(tArr2);
            return tArr2;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(tArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    private static final <T> T elementAt(T[] tArr, int i5) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return tArr[i5];
    }

    public static <T> void fill(T[] tArr, T t6, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        Arrays.fill(tArr, i5, i6, t6);
    }

    public static final <R> List<R> filterIsInstance(Object[] objArr, Class<R> klass) {
        kotlin.jvm.internal.E.f(objArr, "<this>");
        kotlin.jvm.internal.E.f(klass, "klass");
        return (List) filterIsInstanceTo(objArr, new ArrayList(), klass);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Object[] objArr, C destination, Class<R> klass) {
        kotlin.jvm.internal.E.f(objArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        kotlin.jvm.internal.E.f(klass, "klass");
        for (Object obj : objArr) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final /* synthetic */ Double max(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return C.maxOrNull(dArr);
    }

    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t6 = tArr[0];
        int lastIndex = C.getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t6);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t7 = tArr[i5];
                    Comparable comparable2 = (Comparable) selector.invoke(t7);
                    if (comparable.compareTo(comparable2) < 0) {
                        t6 = t7;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return t6;
    }

    public static final /* synthetic */ Object maxWith(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(objArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(objArr, comparator);
    }

    public static final /* synthetic */ Double min(Double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return C.minOrNull(dArr);
    }

    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t6 = tArr[0];
        int lastIndex = C.getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) selector.invoke(t6);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    T t7 = tArr[i5];
                    Comparable comparable2 = (Comparable) selector.invoke(t7);
                    if (comparable.compareTo(comparable2) > 0) {
                        t6 = t7;
                        comparable = comparable2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return t6;
    }

    public static final /* synthetic */ Object minWith(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(objArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(objArr, comparator);
    }

    public static final <T> T[] plus(T[] tArr, T t6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t6;
        return tArr2;
    }

    private static final <T> T[] plusElement(T[] tArr, T t6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return (T[]) plus(tArr, t6);
    }

    public static final void sort(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    private static final <T> BigDecimal sumOfBigDecimal(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (T t6 : tArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(t6));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final <T> BigInteger sumOfBigInteger(T[] tArr, O3.l selector) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (T t6 : tArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(t6));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return (SortedSet) C.toCollection(tArr, new TreeSet());
    }

    public static final Byte[] toTypedArray(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            bArr2[i5] = Byte.valueOf(bArr[i5]);
        }
        return bArr2;
    }

    public static final <T> int binarySearch(T[] tArr, T t6, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        return Arrays.binarySearch(tArr, i5, i6, t6);
    }

    private static final boolean contentEquals(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    private static final int contentHashCode(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    private static final String contentToString(byte[] bArr) {
        String string = Arrays.toString(bArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static byte[] copyInto(byte[] bArr, byte[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(bArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final byte[] copyOf(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    private static final byte elementAt(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return bArr[i5];
    }

    public static void fill(byte[] bArr, byte b, int i5, int i6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        Arrays.fill(bArr, i5, i6, b);
    }

    public static final /* synthetic */ Float max(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return C.maxOrNull(fArr);
    }

    public static final /* synthetic */ Byte maxWith(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(bArr, (Comparator<? super Byte>) comparator);
    }

    public static final /* synthetic */ Float min(Float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return C.minOrNull(fArr);
    }

    public static final /* synthetic */ Byte minWith(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(bArr, (Comparator<? super Byte>) comparator);
    }

    public static final void sort(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        Arrays.sort(tArr, i5, i6, comparator);
    }

    public static final SortedSet<Byte> toSortedSet(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return (SortedSet) C.toCollection(bArr, new TreeSet());
    }

    public static final List<Byte> asList(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return new C0147o(bArr, 0);
    }

    public static final int binarySearch(byte[] bArr, byte b, int i5, int i6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return Arrays.binarySearch(bArr, i5, i6, b);
    }

    private static final boolean contentEquals(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    private static final int contentHashCode(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    private static final String contentToString(short[] sArr) {
        String string = Arrays.toString(sArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static short[] copyInto(short[] sArr, short[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(sArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final short[] copyOf(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.E.e(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    public static byte[] copyOfRange(byte[] bArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5, i6);
        kotlin.jvm.internal.E.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    private static final short elementAt(short[] sArr, int i5) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return sArr[i5];
    }

    public static void fill(short[] sArr, short s6, int i5, int i6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        Arrays.fill(sArr, i5, i6, s6);
    }

    public static final /* synthetic */ Comparable max(Comparable[] comparableArr) {
        kotlin.jvm.internal.E.f(comparableArr, "<this>");
        return C.maxOrNull(comparableArr);
    }

    public static final /* synthetic */ Short maxWith(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(sArr, (Comparator<? super Short>) comparator);
    }

    public static final /* synthetic */ Comparable min(Comparable[] comparableArr) {
        kotlin.jvm.internal.E.f(comparableArr, "<this>");
        return C.minOrNull(comparableArr);
    }

    public static final /* synthetic */ Short minWith(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(sArr, (Comparator<? super Short>) comparator);
    }

    public static final void sort(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    public static final SortedSet<Short> toSortedSet(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return (SortedSet) C.toCollection(sArr, new TreeSet());
    }

    public static final List<Short> asList(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return new C0148p(sArr, 0);
    }

    public static final int binarySearch(short[] sArr, short s6, int i5, int i6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return Arrays.binarySearch(sArr, i5, i6, s6);
    }

    private static final boolean contentEquals(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    private static final int contentHashCode(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    private static final String contentToString(int[] iArr) {
        String string = Arrays.toString(iArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static int[] copyInto(int[] iArr, int[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(iArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final int[] copyOf(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.E.e(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    private static final int elementAt(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return iArr[i5];
    }

    public static void fill(int[] iArr, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        Arrays.fill(iArr, i6, i7, i5);
    }

    public static final /* synthetic */ Byte max(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return C.maxOrNull(bArr);
    }

    public static final /* synthetic */ Integer maxWith(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(iArr, (Comparator<? super Integer>) comparator);
    }

    public static final /* synthetic */ Byte min(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return C.minOrNull(bArr);
    }

    public static final /* synthetic */ Integer minWith(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(iArr, (Comparator<? super Integer>) comparator);
    }

    public static byte[] plus(byte[] bArr, byte b) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + 1);
        bArrCopyOf[length] = b;
        return bArrCopyOf;
    }

    public static final void sort(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    private static final BigDecimal sumOfBigDecimal(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (byte b : bArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Byte.valueOf(b)));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (byte b : bArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Byte.valueOf(b)));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final SortedSet<Integer> toSortedSet(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return (SortedSet) C.toCollection(iArr, new TreeSet());
    }

    public static final Short[] toTypedArray(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            shArr[i5] = Short.valueOf(sArr[i5]);
        }
        return shArr;
    }

    public static final List<Integer> asList(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return new C0149q(iArr, 0);
    }

    public static final int binarySearch(int[] iArr, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return Arrays.binarySearch(iArr, i6, i7, i5);
    }

    private static final boolean contentEquals(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    private static final int contentHashCode(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    private static final String contentToString(long[] jArr) {
        String string = Arrays.toString(jArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static long[] copyInto(long[] jArr, long[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(jArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final long[] copyOf(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.E.e(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    public static short[] copyOfRange(short[] sArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, sArr.length);
        short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i5, i6);
        kotlin.jvm.internal.E.e(sArrCopyOfRange, "copyOfRange(...)");
        return sArrCopyOfRange;
    }

    private static final long elementAt(long[] jArr, int i5) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return jArr[i5];
    }

    public static void fill(long[] jArr, long j6, int i5, int i6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        Arrays.fill(jArr, i5, i6, j6);
    }

    public static final /* synthetic */ Short max(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return C.maxOrNull(sArr);
    }

    public static final /* synthetic */ Long maxWith(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(jArr, (Comparator<? super Long>) comparator);
    }

    public static final /* synthetic */ Short min(short[] sArr) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        return C.minOrNull(sArr);
    }

    public static final /* synthetic */ Long minWith(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(jArr, (Comparator<? super Long>) comparator);
    }

    public static final void sort(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    public static final SortedSet<Long> toSortedSet(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return (SortedSet) C.toCollection(jArr, new TreeSet());
    }

    public static final List<Long> asList(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return new r(jArr, 0);
    }

    public static final int binarySearch(long[] jArr, long j6, int i5, int i6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return Arrays.binarySearch(jArr, i5, i6, j6);
    }

    private static final boolean contentEquals(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    private static final int contentHashCode(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    private static final String contentToString(float[] fArr) {
        String string = Arrays.toString(fArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static float[] copyInto(float[] fArr, float[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(fArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final float[] copyOf(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.E.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    private static final float elementAt(float[] fArr, int i5) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return fArr[i5];
    }

    public static final void fill(float[] fArr, float f6, int i5, int i6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        Arrays.fill(fArr, i5, i6, f6);
    }

    public static final /* synthetic */ Integer max(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return C.maxOrNull(iArr);
    }

    public static final /* synthetic */ Float maxWith(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(fArr, (Comparator<? super Float>) comparator);
    }

    public static final /* synthetic */ Integer min(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        return C.minOrNull(iArr);
    }

    public static final /* synthetic */ Float minWith(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(fArr, (Comparator<? super Float>) comparator);
    }

    public static final void sort(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    public static final SortedSet<Float> toSortedSet(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return (SortedSet) C.toCollection(fArr, new TreeSet());
    }

    public static final List<Float> asList(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return new C0150s(fArr, 0);
    }

    public static final int binarySearch(float[] fArr, float f6, int i5, int i6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return Arrays.binarySearch(fArr, i5, i6, f6);
    }

    private static final boolean contentEquals(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    private static final int contentHashCode(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    private static final String contentToString(double[] dArr) {
        String string = Arrays.toString(dArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static final double[] copyInto(double[] dArr, double[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(dArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final double[] copyOf(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.E.e(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    public static int[] copyOfRange(int[] iArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, iArr.length);
        int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i5, i6);
        kotlin.jvm.internal.E.e(iArrCopyOfRange, "copyOfRange(...)");
        return iArrCopyOfRange;
    }

    private static final double elementAt(double[] dArr, int i5) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return dArr[i5];
    }

    public static final void fill(double[] dArr, double d, int i5, int i6) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        Arrays.fill(dArr, i5, i6, d);
    }

    public static final /* synthetic */ Long max(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return C.maxOrNull(jArr);
    }

    public static final /* synthetic */ Double maxWith(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(dArr, (Comparator<? super Double>) comparator);
    }

    public static final /* synthetic */ Long min(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        return C.minOrNull(jArr);
    }

    public static final /* synthetic */ Double minWith(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(dArr, (Comparator<? super Double>) comparator);
    }

    public static short[] plus(short[] sArr, short s6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + 1);
        sArrCopyOf[length] = s6;
        return sArrCopyOf;
    }

    public static final void sort(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    private static final BigDecimal sumOfBigDecimal(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (short s6 : sArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Short.valueOf(s6)));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (short s6 : sArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Short.valueOf(s6)));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final SortedSet<Double> toSortedSet(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return (SortedSet) C.toCollection(dArr, new TreeSet());
    }

    public static final Integer[] toTypedArray(int[] iArr) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            numArr[i5] = Integer.valueOf(iArr[i5]);
        }
        return numArr;
    }

    public static final List<Double> asList(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return new C0150s(dArr, 1);
    }

    public static final int binarySearch(double[] dArr, double d, int i5, int i6) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return Arrays.binarySearch(dArr, i5, i6, d);
    }

    private static final boolean contentEquals(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    private static final int contentHashCode(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    private static final String contentToString(boolean[] zArr) {
        String string = Arrays.toString(zArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static final boolean[] copyInto(boolean[] zArr, boolean[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(zArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final boolean[] copyOf(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, zArr.length);
        kotlin.jvm.internal.E.e(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    private static final boolean elementAt(boolean[] zArr, int i5) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return zArr[i5];
    }

    public static final void fill(boolean[] zArr, boolean z6, int i5, int i6) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        Arrays.fill(zArr, i5, i6, z6);
    }

    public static final /* synthetic */ Float max(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return C.maxOrNull(fArr);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Byte maxBy(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = C.getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b);
        }
        Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b6 = bArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b6));
                if (comparable.compareTo(comparable2) < 0) {
                    b = b6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(b);
    }

    public static final /* synthetic */ Boolean maxWith(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(zArr, (Comparator<? super Boolean>) comparator);
    }

    public static final /* synthetic */ Float min(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        return C.minOrNull(fArr);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Byte minBy(byte[] bArr, O3.l selector) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = C.getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b);
        }
        Comparable comparable = (Comparable) selector.invoke(Byte.valueOf(b));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte b6 = bArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Byte.valueOf(b6));
                if (comparable.compareTo(comparable2) > 0) {
                    b = b6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Byte.valueOf(b);
    }

    public static final /* synthetic */ Boolean minWith(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(zArr, (Comparator<? super Boolean>) comparator);
    }

    private static final <T extends Comparable<? super T>> void sort(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        sort((Object[]) tArr);
    }

    public static final SortedSet<Boolean> toSortedSet(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return (SortedSet) C.toCollection(zArr, new TreeSet());
    }

    public static final List<Boolean> asList(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        return new C0150s(zArr, 2);
    }

    public static final int binarySearch(char[] cArr, char c, int i5, int i6) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return Arrays.binarySearch(cArr, i5, i6, c);
    }

    private static final boolean contentEquals(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    private static final int contentHashCode(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    private static final String contentToString(char[] cArr) {
        String string = Arrays.toString(cArr);
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static char[] copyInto(char[] cArr, char[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        System.arraycopy(cArr, i6, destination, i5, i7 - i6);
        return destination;
    }

    private static final char[] copyOf(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.E.e(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    public static long[] copyOfRange(long[] jArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, jArr.length);
        long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i5, i6);
        kotlin.jvm.internal.E.e(jArrCopyOfRange, "copyOfRange(...)");
        return jArrCopyOfRange;
    }

    private static final char elementAt(char[] cArr, int i5) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return cArr[i5];
    }

    public static void fill(char[] cArr, char c, int i5, int i6) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        Arrays.fill(cArr, i5, i6, c);
    }

    public static final /* synthetic */ Double max(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return C.maxOrNull(dArr);
    }

    public static final /* synthetic */ Character maxWith(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.maxWithOrNull(cArr, (Comparator<? super Character>) comparator);
    }

    public static final /* synthetic */ Double min(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        return C.minOrNull(dArr);
    }

    public static final /* synthetic */ Character minWith(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return C.minWithOrNull(cArr, (Comparator<? super Character>) comparator);
    }

    public static final <T> void sort(T[] tArr) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final SortedSet<Character> toSortedSet(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return (SortedSet) C.toCollection(cArr, new TreeSet());
    }

    public static final List<Character> asList(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return new C0150s(cArr, 3);
    }

    private static final byte[] copyOf(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static final /* synthetic */ Character max(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return C.maxOrNull(cArr);
    }

    public static final /* synthetic */ Character min(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return C.minOrNull(cArr);
    }

    public static int[] plus(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i5;
        return iArrCopyOf;
    }

    public static final <T extends Comparable<? super T>> void sort(T[] tArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        Arrays.sort(tArr, i5, i6);
    }

    private static final BigDecimal sumOfBigDecimal(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (int i5 : iArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Integer.valueOf(i5)));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (int i5 : iArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Integer.valueOf(i5)));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T> SortedSet<T> toSortedSet(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        return (SortedSet) C.toCollection(tArr, new TreeSet(comparator));
    }

    public static final Long[] toTypedArray(long[] jArr) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            lArr[i5] = Long.valueOf(jArr[i5]);
        }
        return lArr;
    }

    private static final short[] copyOf(short[] sArr, int i5) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, i5);
        kotlin.jvm.internal.E.e(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    public static final float[] copyOfRange(float[] fArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i5, i6);
        kotlin.jvm.internal.E.e(fArrCopyOfRange, "copyOfRange(...)");
        return fArrCopyOfRange;
    }

    public static final void sort(byte[] bArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        Arrays.sort(bArr, i5, i6);
    }

    private static final int[] copyOf(int[] iArr, int i5) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
        kotlin.jvm.internal.E.e(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    public static final void sort(short[] sArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        Arrays.sort(sArr, i5, i6);
    }

    private static final long[] copyOf(long[] jArr, int i5) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, i5);
        kotlin.jvm.internal.E.e(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    public static final double[] copyOfRange(double[] dArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, dArr.length);
        double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i5, i6);
        kotlin.jvm.internal.E.e(dArrCopyOfRange, "copyOfRange(...)");
        return dArrCopyOfRange;
    }

    private static final byte[] copyOfRangeInline(byte[] bArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(bArr, i5, i6);
        }
        if (i6 <= bArr.length) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5, i6);
            kotlin.jvm.internal.E.c(bArrCopyOfRange);
            return bArrCopyOfRange;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(bArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static long[] plus(long[] jArr, long j6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + 1);
        jArrCopyOf[length] = j6;
        return jArrCopyOf;
    }

    public static void sort(int[] iArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        Arrays.sort(iArr, i5, i6);
    }

    private static final BigDecimal sumOfBigDecimal(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (long j6 : jArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Long.valueOf(j6)));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (long j6 : jArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Long.valueOf(j6)));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final Float[] toTypedArray(float[] fArr) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            fArr2[i5] = Float.valueOf(fArr[i5]);
        }
        return fArr2;
    }

    private static final float[] copyOf(float[] fArr, int i5) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, i5);
        kotlin.jvm.internal.E.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    public static void sort(long[] jArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        Arrays.sort(jArr, i5, i6);
    }

    private static final double[] copyOf(double[] dArr, int i5) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, i5);
        kotlin.jvm.internal.E.e(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    public static final boolean[] copyOfRange(boolean[] zArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, zArr.length);
        boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i5, i6);
        kotlin.jvm.internal.E.e(zArrCopyOfRange, "copyOfRange(...)");
        return zArrCopyOfRange;
    }

    public static void sort(float[] fArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        Arrays.sort(fArr, i5, i6);
    }

    private static final boolean[] copyOf(boolean[] zArr, int i5) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, i5);
        kotlin.jvm.internal.E.e(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    public static final float[] plus(float[] fArr, float f6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + 1);
        fArrCopyOf[length] = f6;
        return fArrCopyOf;
    }

    public static final void sort(double[] dArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        Arrays.sort(dArr, i5, i6);
    }

    private static final BigDecimal sumOfBigDecimal(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (float f6 : fArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Float.valueOf(f6)));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (float f6 : fArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Float.valueOf(f6)));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final Double[] toTypedArray(double[] dArr) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            dArr2[i5] = Double.valueOf(dArr[i5]);
        }
        return dArr2;
    }

    private static final char[] copyOf(char[] cArr, int i5) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, i5);
        kotlin.jvm.internal.E.e(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    public static final char[] copyOfRange(char[] cArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        AbstractC0145m.copyOfRangeToIndexCheck(i6, cArr.length);
        char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i5, i6);
        kotlin.jvm.internal.E.e(cArrCopyOfRange, "copyOfRange(...)");
        return cArrCopyOfRange;
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Short maxBy(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s6 = sArr[0];
        int lastIndex = C.getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s6);
        }
        Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s7 = sArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s7));
                if (comparable.compareTo(comparable2) < 0) {
                    s6 = s7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(s6);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Short minBy(short[] sArr, O3.l selector) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s6 = sArr[0];
        int lastIndex = C.getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s6);
        }
        Comparable comparable = (Comparable) selector.invoke(Short.valueOf(s6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                short s7 = sArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Short.valueOf(s7));
                if (comparable.compareTo(comparable2) > 0) {
                    s6 = s7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Short.valueOf(s6);
    }

    public static final void sort(char[] cArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        Arrays.sort(cArr, i5, i6);
    }

    private static final <T> T[] copyOf(T[] tArr, int i5) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i5);
        kotlin.jvm.internal.E.e(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <T> void sort(T[] tArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        Arrays.sort(tArr, i5, i6);
    }

    public static final double[] plus(double[] dArr, double d) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + 1);
        dArrCopyOf[length] = d;
        return dArrCopyOf;
    }

    private static final BigDecimal sumOfBigDecimal(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (double d : dArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Double.valueOf(d)));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (double d : dArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Double.valueOf(d)));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final Boolean[] toTypedArray(boolean[] zArr) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            boolArr[i5] = Boolean.valueOf(zArr[i5]);
        }
        return boolArr;
    }

    public static final boolean[] plus(boolean[] zArr, boolean z6) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + 1);
        zArrCopyOf[length] = z6;
        return zArrCopyOf;
    }

    private static final BigDecimal sumOfBigDecimal(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (boolean z6 : zArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Boolean.valueOf(z6)));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (boolean z6 : zArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Boolean.valueOf(z6)));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final Character[] toTypedArray(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            chArr[i5] = Character.valueOf(cArr[i5]);
        }
        return chArr;
    }

    private static final short[] copyOfRangeInline(short[] sArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(sArr, i5, i6);
        }
        if (i6 <= sArr.length) {
            short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i5, i6);
            kotlin.jvm.internal.E.c(sArrCopyOfRange);
            return sArrCopyOfRange;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(sArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static final char[] plus(char[] cArr, char c) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + 1);
        cArrCopyOf[length] = c;
        return cArrCopyOf;
    }

    private static final BigDecimal sumOfBigDecimal(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.E.e(bigDecimalValueOf, "valueOf(...)");
        for (char c : cArr) {
            bigDecimalValueOf = bigDecimalValueOf.add((BigDecimal) selector.invoke(Character.valueOf(c)));
            kotlin.jvm.internal.E.e(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    private static final BigInteger sumOfBigInteger(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.E.e(bigIntegerValueOf, "valueOf(...)");
        for (char c : cArr) {
            bigIntegerValueOf = bigIntegerValueOf.add((BigInteger) selector.invoke(Character.valueOf(c)));
            kotlin.jvm.internal.E.e(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Integer maxBy(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i5 = iArr[0];
        int lastIndex = C.getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i5);
        }
        Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i5));
        int i6 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i7 = iArr[i6];
                Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i7));
                if (comparable.compareTo(comparable2) < 0) {
                    i5 = i7;
                    comparable = comparable2;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        return Integer.valueOf(i5);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Integer minBy(int[] iArr, O3.l selector) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i5 = iArr[0];
        int lastIndex = C.getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i5);
        }
        Comparable comparable = (Comparable) selector.invoke(Integer.valueOf(i5));
        int i6 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int i7 = iArr[i6];
                Comparable comparable2 = (Comparable) selector.invoke(Integer.valueOf(i7));
                if (comparable.compareTo(comparable2) > 0) {
                    i5 = i7;
                    comparable = comparable2;
                }
                if (i6 == lastIndex) {
                    break;
                }
                i6++;
            }
        }
        return Integer.valueOf(i5);
    }

    public static final <T> T[] plus(T[] tArr, Collection<? extends T> elements) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, elements.size() + length);
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        kotlin.jvm.internal.E.c(tArr2);
        return tArr2;
    }

    public static final byte[] plus(byte[] bArr, Collection<Byte> elements) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, elements.size() + length);
        Iterator<Byte> it = elements.iterator();
        while (it.hasNext()) {
            bArrCopyOf[length] = it.next().byteValue();
            length++;
        }
        kotlin.jvm.internal.E.c(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Long maxBy(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int lastIndex = C.getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j6);
        }
        Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j7 = jArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j7));
                if (comparable.compareTo(comparable2) < 0) {
                    j6 = j7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Long minBy(long[] jArr, O3.l selector) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j6 = jArr[0];
        int lastIndex = C.getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j6);
        }
        Comparable comparable = (Comparable) selector.invoke(Long.valueOf(j6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                long j7 = jArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Long.valueOf(j7));
                if (comparable.compareTo(comparable2) > 0) {
                    j6 = j7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Long.valueOf(j6);
    }

    public static final short[] plus(short[] sArr, Collection<Short> elements) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, elements.size() + length);
        Iterator<Short> it = elements.iterator();
        while (it.hasNext()) {
            sArrCopyOf[length] = it.next().shortValue();
            length++;
        }
        kotlin.jvm.internal.E.c(sArrCopyOf);
        return sArrCopyOf;
    }

    private static final int[] copyOfRangeInline(int[] iArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(iArr, i5, i6);
        }
        if (i6 <= iArr.length) {
            int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i5, i6);
            kotlin.jvm.internal.E.c(iArrCopyOfRange);
            return iArrCopyOfRange;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(iArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static final int[] plus(int[] iArr, Collection<Integer> elements) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, elements.size() + length);
        Iterator<Integer> it = elements.iterator();
        while (it.hasNext()) {
            iArrCopyOf[length] = it.next().intValue();
            length++;
        }
        kotlin.jvm.internal.E.c(iArrCopyOf);
        return iArrCopyOf;
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Float maxBy(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int lastIndex = C.getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f6);
        }
        Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f7 = fArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f7));
                if (comparable.compareTo(comparable2) < 0) {
                    f6 = f7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(f6);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Float minBy(float[] fArr, O3.l selector) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f6 = fArr[0];
        int lastIndex = C.getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f6);
        }
        Comparable comparable = (Comparable) selector.invoke(Float.valueOf(f6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                float f7 = fArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Float.valueOf(f7));
                if (comparable.compareTo(comparable2) > 0) {
                    f6 = f7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Float.valueOf(f6);
    }

    public static final long[] plus(long[] jArr, Collection<Long> elements) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, elements.size() + length);
        Iterator<Long> it = elements.iterator();
        while (it.hasNext()) {
            jArrCopyOf[length] = it.next().longValue();
            length++;
        }
        kotlin.jvm.internal.E.c(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final float[] plus(float[] fArr, Collection<Float> elements) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, elements.size() + length);
        Iterator<Float> it = elements.iterator();
        while (it.hasNext()) {
            fArrCopyOf[length] = it.next().floatValue();
            length++;
        }
        kotlin.jvm.internal.E.c(fArrCopyOf);
        return fArrCopyOf;
    }

    private static final long[] copyOfRangeInline(long[] jArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(jArr, i5, i6);
        }
        if (i6 <= jArr.length) {
            long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i5, i6);
            kotlin.jvm.internal.E.c(jArrCopyOfRange);
            return jArrCopyOfRange;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(jArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static final double[] plus(double[] dArr, Collection<Double> elements) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, elements.size() + length);
        Iterator<Double> it = elements.iterator();
        while (it.hasNext()) {
            dArrCopyOf[length] = it.next().doubleValue();
            length++;
        }
        kotlin.jvm.internal.E.c(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Double maxBy(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = C.getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d);
        }
        Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d6 = dArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d6));
                if (comparable.compareTo(comparable2) < 0) {
                    d = d6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(d);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Double minBy(double[] dArr, O3.l selector) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = C.getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d);
        }
        Comparable comparable = (Comparable) selector.invoke(Double.valueOf(d));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                double d6 = dArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Double.valueOf(d6));
                if (comparable.compareTo(comparable2) > 0) {
                    d = d6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Double.valueOf(d);
    }

    public static final boolean[] plus(boolean[] zArr, Collection<Boolean> elements) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, elements.size() + length);
        Iterator<Boolean> it = elements.iterator();
        while (it.hasNext()) {
            zArrCopyOf[length] = it.next().booleanValue();
            length++;
        }
        kotlin.jvm.internal.E.c(zArrCopyOf);
        return zArrCopyOf;
    }

    public static final char[] plus(char[] cArr, Collection<Character> elements) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, elements.size() + length);
        Iterator<Character> it = elements.iterator();
        while (it.hasNext()) {
            cArrCopyOf[length] = it.next().charValue();
            length++;
        }
        kotlin.jvm.internal.E.c(cArrCopyOf);
        return cArrCopyOf;
    }

    private static final float[] copyOfRangeInline(float[] fArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(fArr, i5, i6);
        }
        if (i6 <= fArr.length) {
            float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i5, i6);
            kotlin.jvm.internal.E.c(fArrCopyOfRange);
            return fArrCopyOfRange;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(fArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean maxBy(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z6 = zArr[0];
        int lastIndex = C.getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z6);
        }
        Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z7 = zArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z7));
                if (comparable.compareTo(comparable2) < 0) {
                    z6 = z7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Boolean.valueOf(z6);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean minBy(boolean[] zArr, O3.l selector) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z6 = zArr[0];
        int lastIndex = C.getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z6);
        }
        Comparable comparable = (Comparable) selector.invoke(Boolean.valueOf(z6));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                boolean z7 = zArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Boolean.valueOf(z7));
                if (comparable.compareTo(comparable2) > 0) {
                    z6 = z7;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Boolean.valueOf(z6);
    }

    public static final <T> T[] plus(T[] tArr, T[] elements) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        kotlin.jvm.internal.E.c(tArr2);
        return tArr2;
    }

    public static byte[] plus(byte[] bArr, byte[] elements) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, bArrCopyOf, length, length2);
        kotlin.jvm.internal.E.c(bArrCopyOf);
        return bArrCopyOf;
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Character maxBy(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = C.getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c);
        }
        Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c6 = cArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c6));
                if (comparable.compareTo(comparable2) < 0) {
                    c = c6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(c);
    }

    public static final /* synthetic */ <R extends Comparable<? super R>> Character minBy(char[] cArr, O3.l selector) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = C.getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c);
        }
        Comparable comparable = (Comparable) selector.invoke(Character.valueOf(c));
        int i5 = 1;
        if (1 <= lastIndex) {
            while (true) {
                char c6 = cArr[i5];
                Comparable comparable2 = (Comparable) selector.invoke(Character.valueOf(c6));
                if (comparable.compareTo(comparable2) > 0) {
                    c = c6;
                    comparable = comparable2;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return Character.valueOf(c);
    }

    private static final double[] copyOfRangeInline(double[] dArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(dArr, i5, i6);
        }
        if (i6 <= dArr.length) {
            double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i5, i6);
            kotlin.jvm.internal.E.c(dArrCopyOfRange);
            return dArrCopyOfRange;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(dArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static short[] plus(short[] sArr, short[] elements) {
        kotlin.jvm.internal.E.f(sArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = sArr.length;
        int length2 = elements.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(elements, 0, sArrCopyOf, length, length2);
        kotlin.jvm.internal.E.c(sArrCopyOf);
        return sArrCopyOf;
    }

    public static int[] plus(int[] iArr, int[] elements) {
        kotlin.jvm.internal.E.f(iArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, iArrCopyOf, length, length2);
        kotlin.jvm.internal.E.c(iArrCopyOf);
        return iArrCopyOf;
    }

    public static long[] plus(long[] jArr, long[] elements) {
        kotlin.jvm.internal.E.f(jArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, jArrCopyOf, length, length2);
        kotlin.jvm.internal.E.c(jArrCopyOf);
        return jArrCopyOf;
    }

    private static final boolean[] copyOfRangeInline(boolean[] zArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(zArr, i5, i6);
        }
        if (i6 <= zArr.length) {
            boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i5, i6);
            kotlin.jvm.internal.E.c(zArrCopyOfRange);
            return zArrCopyOfRange;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(zArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static final float[] plus(float[] fArr, float[] elements) {
        kotlin.jvm.internal.E.f(fArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, fArrCopyOf, length, length2);
        kotlin.jvm.internal.E.c(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final double[] plus(double[] dArr, double[] elements) {
        kotlin.jvm.internal.E.f(dArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = dArr.length;
        int length2 = elements.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(elements, 0, dArrCopyOf, length, length2);
        kotlin.jvm.internal.E.c(dArrCopyOf);
        return dArrCopyOf;
    }

    private static final char[] copyOfRangeInline(char[] cArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        if (I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(cArr, i5, i6);
        }
        if (i6 <= cArr.length) {
            char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i5, i6);
            kotlin.jvm.internal.E.c(cArrCopyOfRange);
            return cArrCopyOfRange;
        }
        StringBuilder sbT = AbstractC0157z.t(i6, "toIndex: ", ", size: ");
        sbT.append(cArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static final boolean[] plus(boolean[] zArr, boolean[] elements) {
        kotlin.jvm.internal.E.f(zArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, zArrCopyOf, length, length2);
        kotlin.jvm.internal.E.c(zArrCopyOf);
        return zArrCopyOf;
    }

    public static final char[] plus(char[] cArr, char[] elements) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        kotlin.jvm.internal.E.f(elements, "elements");
        int length = cArr.length;
        int length2 = elements.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(elements, 0, cArrCopyOf, length, length2);
        kotlin.jvm.internal.E.c(cArrCopyOf);
        return cArrCopyOf;
    }
}
