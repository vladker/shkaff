package B4;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A4.AbstractC0159b;
import A4.C0169l;
import A4.C0173p;
import A4.c0;
import A4.e0;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public static final int binarySearch(int[] iArr, int i5, int i6, int i7) {
        E.f(iArr, "<this>");
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i5) {
                i6 = i9 + 1;
            } else {
                if (i10 <= i5) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return (-i6) - 1;
    }

    public static final void commonCopyInto(e0 e0Var, int i5, byte[] target, int i6, int i7) {
        E.f(e0Var, "<this>");
        E.f(target, "target");
        long j6 = i7;
        AbstractC0159b.a(e0Var.size(), i5, j6);
        AbstractC0159b.a(target.length, i6, j6);
        int i8 = i7 + i5;
        int iSegment = segment(e0Var, i5);
        while (i5 < i8) {
            int i9 = iSegment == 0 ? 0 : e0Var.getDirectory$okio()[iSegment - 1];
            int i10 = e0Var.getDirectory$okio()[iSegment] - i9;
            int i11 = e0Var.getDirectory$okio()[e0Var.getSegments$okio().length + iSegment];
            int iMin = Math.min(i8, i10 + i9) - i5;
            int i12 = (i5 - i9) + i11;
            AbstractC0151t.copyInto(e0Var.getSegments$okio()[iSegment], target, i6, i12, i12 + iMin);
            i6 += iMin;
            i5 += iMin;
            iSegment++;
        }
    }

    public static final boolean commonEquals(e0 e0Var, Object obj) {
        E.f(e0Var, "<this>");
        if (obj == e0Var) {
            return true;
        }
        if (obj instanceof C0173p) {
            C0173p c0173p = (C0173p) obj;
            if (c0173p.size() == e0Var.size() && e0Var.rangeEquals(0, c0173p, 0, e0Var.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(e0 e0Var) {
        E.f(e0Var, "<this>");
        return e0Var.getDirectory$okio()[e0Var.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(e0 e0Var) {
        E.f(e0Var, "<this>");
        int i5 = e0Var.f77a;
        if (i5 != 0) {
            return i5;
        }
        int length = e0Var.getSegments$okio().length;
        int i6 = 0;
        int i7 = 1;
        int i8 = 0;
        while (i6 < length) {
            int i9 = e0Var.getDirectory$okio()[length + i6];
            int i10 = e0Var.getDirectory$okio()[i6];
            byte[] bArr = e0Var.getSegments$okio()[i6];
            int i11 = (i10 - i8) + i9;
            while (i9 < i11) {
                i7 = (i7 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i8 = i10;
        }
        e0Var.f77a = i7;
        return i7;
    }

    public static final byte commonInternalGet(e0 e0Var, int i5) {
        E.f(e0Var, "<this>");
        AbstractC0159b.a(e0Var.getDirectory$okio()[e0Var.getSegments$okio().length - 1], i5, 1L);
        int iSegment = segment(e0Var, i5);
        return e0Var.getSegments$okio()[iSegment][(i5 - (iSegment == 0 ? 0 : e0Var.getDirectory$okio()[iSegment - 1])) + e0Var.getDirectory$okio()[e0Var.getSegments$okio().length + iSegment]];
    }

    public static final boolean commonRangeEquals(e0 e0Var, int i5, C0173p other, int i6, int i7) {
        E.f(e0Var, "<this>");
        E.f(other, "other");
        if (i5 < 0 || i5 > e0Var.size() - i7) {
            return false;
        }
        int i8 = i7 + i5;
        int iSegment = segment(e0Var, i5);
        while (i5 < i8) {
            int i9 = iSegment == 0 ? 0 : e0Var.getDirectory$okio()[iSegment - 1];
            int i10 = e0Var.getDirectory$okio()[iSegment] - i9;
            int i11 = e0Var.getDirectory$okio()[e0Var.getSegments$okio().length + iSegment];
            int iMin = Math.min(i8, i10 + i9) - i5;
            if (!other.rangeEquals(i6, e0Var.getSegments$okio()[iSegment], (i5 - i9) + i11, iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iSegment++;
        }
        return true;
    }

    public static final C0173p commonSubstring(e0 e0Var, int i5, int i6) {
        E.f(e0Var, "<this>");
        int iResolveDefaultParameter = AbstractC0159b.resolveDefaultParameter(e0Var, i6);
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "beginIndex=", " < 0").toString());
        }
        if (iResolveDefaultParameter > e0Var.size()) {
            StringBuilder sbT = AbstractC0157z.t(iResolveDefaultParameter, "endIndex=", " > length(");
            sbT.append(e0Var.size());
            sbT.append(')');
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        int i7 = iResolveDefaultParameter - i5;
        if (i7 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.h(iResolveDefaultParameter, i5, "endIndex=", " < beginIndex=").toString());
        }
        if (i5 == 0 && iResolveDefaultParameter == e0Var.size()) {
            return e0Var;
        }
        if (i5 == iResolveDefaultParameter) {
            return C0173p.EMPTY;
        }
        int iSegment = segment(e0Var, i5);
        int iSegment2 = segment(e0Var, iResolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) AbstractC0151t.copyOfRange(e0Var.getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i8 = iSegment;
            int i9 = 0;
            while (true) {
                iArr[i9] = Math.min(e0Var.getDirectory$okio()[i8] - i5, i7);
                int i10 = i9 + 1;
                iArr[i9 + bArr.length] = e0Var.getDirectory$okio()[e0Var.getSegments$okio().length + i8];
                if (i8 == iSegment2) {
                    break;
                }
                i8++;
                i9 = i10;
            }
        }
        int i11 = iSegment != 0 ? e0Var.getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = (i5 - i11) + iArr[length];
        return new e0(bArr, iArr);
    }

    public static final byte[] commonToByteArray(e0 e0Var) {
        E.f(e0Var, "<this>");
        byte[] bArr = new byte[e0Var.size()];
        int length = e0Var.getSegments$okio().length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int i8 = e0Var.getDirectory$okio()[length + i5];
            int i9 = e0Var.getDirectory$okio()[i5];
            int i10 = i9 - i6;
            AbstractC0151t.copyInto(e0Var.getSegments$okio()[i5], bArr, i7, i8, i8 + i10);
            i7 += i10;
            i5++;
            i6 = i9;
        }
        return bArr;
    }

    public static final void commonWrite(e0 e0Var, C0169l buffer, int i5, int i6) {
        E.f(e0Var, "<this>");
        E.f(buffer, "buffer");
        int i7 = i5 + i6;
        int iSegment = segment(e0Var, i5);
        while (i5 < i7) {
            int i8 = iSegment == 0 ? 0 : e0Var.getDirectory$okio()[iSegment - 1];
            int i9 = e0Var.getDirectory$okio()[iSegment] - i8;
            int i10 = e0Var.getDirectory$okio()[e0Var.getSegments$okio().length + iSegment];
            int iMin = Math.min(i7, i9 + i8) - i5;
            int i11 = (i5 - i8) + i10;
            c0 c0Var = new c0(e0Var.getSegments$okio()[iSegment], i11, i11 + iMin, true, false);
            c0 c0Var2 = buffer.head;
            if (c0Var2 == null) {
                c0Var.prev = c0Var;
                c0Var.next = c0Var;
                buffer.head = c0Var;
            } else {
                E.c(c0Var2);
                c0 c0Var3 = c0Var2.prev;
                E.c(c0Var3);
                c0Var3.push(c0Var);
            }
            i5 += iMin;
            iSegment++;
        }
        buffer.f76a = buffer.size() + ((long) i6);
    }

    public static final void forEachSegment(e0 e0Var, O3.q action) {
        E.f(e0Var, "<this>");
        E.f(action, "action");
        int length = e0Var.getSegments$okio().length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = e0Var.getDirectory$okio()[length + i5];
            int i8 = e0Var.getDirectory$okio()[i5];
            action.invoke(e0Var.getSegments$okio()[i5], Integer.valueOf(i7), Integer.valueOf(i8 - i6));
            i5++;
            i6 = i8;
        }
    }

    public static final int segment(e0 e0Var, int i5) {
        E.f(e0Var, "<this>");
        int iBinarySearch = binarySearch(e0Var.getDirectory$okio(), i5 + 1, 0, e0Var.getSegments$okio().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    public static final boolean commonRangeEquals(e0 e0Var, int i5, byte[] other, int i6, int i7) {
        E.f(e0Var, "<this>");
        E.f(other, "other");
        if (i5 < 0 || i5 > e0Var.size() - i7 || i6 < 0 || i6 > other.length - i7) {
            return false;
        }
        int i8 = i7 + i5;
        int iSegment = segment(e0Var, i5);
        while (i5 < i8) {
            int i9 = iSegment == 0 ? 0 : e0Var.getDirectory$okio()[iSegment - 1];
            int i10 = e0Var.getDirectory$okio()[iSegment] - i9;
            int i11 = e0Var.getDirectory$okio()[e0Var.getSegments$okio().length + iSegment];
            int iMin = Math.min(i8, i10 + i9) - i5;
            if (!AbstractC0159b.arrayRangeEquals(e0Var.getSegments$okio()[iSegment], (i5 - i9) + i11, other, i6, iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iSegment++;
        }
        return true;
    }
}
