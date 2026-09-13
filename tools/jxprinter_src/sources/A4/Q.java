package A4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Q {
    public static void a(long j6, C0169l c0169l, int i5, List list, int i6, int i7, List list2) {
        int i8;
        int i9;
        List list3;
        long j7;
        int i10;
        int i11 = i5;
        List list4 = list;
        List list5 = list2;
        if (i6 >= i7) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i12 = i6; i12 < i7; i12++) {
            if (((C0173p) list4.get(i12)).size() < i11) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        C0173p c0173p = (C0173p) list.get(i6);
        C0173p c0173p2 = (C0173p) list4.get(i7 - 1);
        if (i11 == c0173p.size()) {
            int iIntValue = ((Number) list5.get(i6)).intValue();
            int i13 = i6 + 1;
            C0173p c0173p3 = (C0173p) list4.get(i13);
            i8 = i13;
            i9 = iIntValue;
            c0173p = c0173p3;
        } else {
            i8 = i6;
            i9 = -1;
        }
        if (c0173p.getByte(i11) == c0173p2.getByte(i11)) {
            int iMin = Math.min(c0173p.size(), c0173p2.size());
            int i14 = 0;
            for (int i15 = i11; i15 < iMin && c0173p.getByte(i15) == c0173p2.getByte(i15); i15++) {
                i14++;
            }
            long j8 = 4;
            long size = (c0169l.size() / j8) + j6 + ((long) 2) + ((long) i14) + 1;
            c0169l.writeInt(-i14);
            c0169l.writeInt(i9);
            int i16 = i11 + i14;
            while (i11 < i16) {
                c0169l.writeInt(c0173p.getByte(i11) & 255);
                i11++;
            }
            if (i8 + 1 == i7) {
                if (i16 != ((C0173p) list4.get(i8)).size()) {
                    throw new IllegalStateException("Check failed.");
                }
                c0169l.writeInt(((Number) list5.get(i8)).intValue());
                return;
            } else {
                C0169l c0169l2 = new C0169l();
                c0169l.writeInt(((int) ((c0169l2.size() / j8) + size)) * (-1));
                a(size, c0169l2, i16, list4, i8, i7, list5);
                c0169l.writeAll(c0169l2);
                return;
            }
        }
        int i17 = 1;
        for (int i18 = i8 + 1; i18 < i7; i18++) {
            if (((C0173p) list4.get(i18 - 1)).getByte(i11) != ((C0173p) list4.get(i18)).getByte(i11)) {
                i17++;
            }
        }
        long j9 = 4;
        long size2 = (c0169l.size() / j9) + j6 + ((long) 2) + ((long) (i17 * 2));
        c0169l.writeInt(i17);
        c0169l.writeInt(i9);
        for (int i19 = i8; i19 < i7; i19++) {
            int i20 = ((C0173p) list4.get(i19)).getByte(i11);
            if (i19 == i8 || i20 != ((C0173p) list4.get(i19 - 1)).getByte(i11)) {
                c0169l.writeInt(i20 & 255);
            }
        }
        C0169l c0169l3 = new C0169l();
        int i21 = i8;
        while (i21 < i7) {
            byte b = ((C0173p) list4.get(i21)).getByte(i11);
            int i22 = i21 + 1;
            int i23 = i22;
            while (true) {
                if (i23 >= i7) {
                    i23 = i7;
                    break;
                } else if (b != ((C0173p) list4.get(i23)).getByte(i11)) {
                    break;
                } else {
                    i23++;
                }
            }
            if (i22 == i23 && i11 + 1 == ((C0173p) list4.get(i21)).size()) {
                c0169l.writeInt(((Number) list5.get(i21)).intValue());
                list3 = list5;
                j7 = size2;
                i10 = i23;
            } else {
                c0169l.writeInt(((int) ((c0169l3.size() / j9) + size2)) * (-1));
                list3 = list5;
                j7 = size2;
                i10 = i23;
                a(j7, c0169l3, i11 + 1, list, i21, i10, list3);
                list4 = list;
            }
            size2 = j7;
            i21 = i10;
            list5 = list3;
        }
        c0169l.writeAll(c0169l3);
    }

    public final S of(C0173p... byteStrings) {
        kotlin.jvm.internal.E.f(byteStrings, "byteStrings");
        int i5 = 0;
        if (byteStrings.length == 0) {
            return new S(new C0173p[0], new int[]{0, -1});
        }
        List mutableList = A3.C.toMutableList(byteStrings);
        A3.N.sort(mutableList);
        ArrayList arrayList = new ArrayList(byteStrings.length);
        for (C0173p c0173p : byteStrings) {
            arrayList.add(-1);
        }
        Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
        List listMutableListOf = A3.I.mutableListOf(Arrays.copyOf(numArr, numArr.length));
        int length = byteStrings.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            listMutableListOf.set(A3.I.binarySearch((List<? extends C0173p>) mutableList, byteStrings[i6], 0, mutableList.size()), Integer.valueOf(i7));
            i6++;
            i7++;
        }
        if (((C0173p) mutableList.get(0)).size() <= 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i8 = 0;
        while (i8 < mutableList.size()) {
            C0173p c0173p2 = (C0173p) mutableList.get(i8);
            int i9 = i8 + 1;
            int i10 = i9;
            while (i10 < mutableList.size()) {
                C0173p c0173p3 = (C0173p) mutableList.get(i10);
                if (!c0173p3.startsWith(c0173p2)) {
                    break;
                }
                if (c0173p3.size() == c0173p2.size()) {
                    throw new IllegalArgumentException(("duplicate option: " + c0173p3).toString());
                }
                if (((Number) listMutableListOf.get(i10)).intValue() > ((Number) listMutableListOf.get(i8)).intValue()) {
                    mutableList.remove(i10);
                    listMutableListOf.remove(i10);
                } else {
                    i10++;
                }
            }
            i8 = i9;
        }
        C0169l c0169l = new C0169l();
        a(0L, c0169l, 0, mutableList, 0, mutableList.size(), listMutableListOf);
        int[] iArr = new int[(int) (c0169l.size() / ((long) 4))];
        while (!c0169l.exhausted()) {
            iArr[i5] = c0169l.readInt();
            i5++;
        }
        Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
        kotlin.jvm.internal.E.e(objArrCopyOf, "copyOf(this, size)");
        return new S((C0173p[]) objArrCopyOf, iArr);
    }
}
