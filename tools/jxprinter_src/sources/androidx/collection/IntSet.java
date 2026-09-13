package androidx.collection;

import A3.AbstractC0157z;
import O3.l;
import androidx.annotation.IntRange;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntSet {
    public int _capacity;
    public int _size;
    public int[] elements;
    public long[] metadata;

    public /* synthetic */ IntSet(AbstractC1107v abstractC1107v) {
        this();
    }

    public static /* synthetic */ String joinToString$default(IntSet intSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return intSet.joinToString(charSequence, charSequence2, charSequence6, i5, charSequence5);
    }

    public final boolean all(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128 && !((Boolean) predicate.invoke(Integer.valueOf(iArr[(i5 << 3) + i7]))).booleanValue()) {
                        return false;
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return true;
                }
            }
            if (i5 == length) {
                return true;
            }
            i5++;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean contains(int i5) {
        int iNumberOfTrailingZeros;
        int iHashCode = Integer.hashCode(i5) * ScatterMapKt.MurmurHashC1;
        int i6 = iHashCode ^ (iHashCode << 16);
        int i7 = i6 & 127;
        int i8 = this._capacity;
        int i9 = (i6 >>> 7) & i8;
        int i10 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j6 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j7 = (((long) i7) * ScatterMapKt.BitmaskLsb) ^ j6;
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j8 != 0; j8 &= j8 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i9) & i8;
                if (this.elements[iNumberOfTrailingZeros] == i5) {
                    break loop0;
                }
            }
            if ((j6 & ((~j6) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
        }
        return iNumberOfTrailingZeros >= 0;
    }

    @IntRange(from = 0)
    public final int count() {
        return this._size;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x005a A[LOOP:0: B:14:0x0021->B:26:0x005a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x005d A[SYNTHETIC] */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntSet)) {
            return false;
        }
        IntSet intSet = (IntSet) obj;
        if (intSet._size != this._size) {
            return false;
        }
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j6 = jArr[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j6) < 128 && !intSet.contains(iArr[(i5 << 3) + i7])) {
                            return false;
                        }
                        j6 >>= 8;
                    }
                    if (i6 == 8) {
                        if (i5 != length) {
                            i5++;
                        }
                    }
                } else if (i5 != length) {
                    i5++;
                }
            }
        }
        return true;
    }

    public final int findElementIndex$collection(int i5) {
        int iHashCode = Integer.hashCode(i5) * ScatterMapKt.MurmurHashC1;
        int i6 = iHashCode ^ (iHashCode << 16);
        int i7 = i6 & 127;
        int i8 = this._capacity;
        int i9 = (i6 >>> 7) & i8;
        int i10 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j6 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j7 = (((long) i7) * ScatterMapKt.BitmaskLsb) ^ j6;
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j8 != 0; j8 &= j8 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i9) & i8;
                if (this.elements[iNumberOfTrailingZeros] == i5) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j6 & ((~j6) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x003e A[LOOP:0: B:5:0x000b->B:16:0x003e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0041 A[SYNTHETIC] */
    public final int first() {
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j6 = jArr[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j6) < 128) {
                            return iArr[(i5 << 3) + i7];
                        }
                        j6 >>= 8;
                    }
                    if (i6 == 8) {
                        if (i5 != length) {
                            i5++;
                        }
                    }
                } else if (i5 != length) {
                    i5++;
                }
            }
        }
        throw new NoSuchElementException("The IntSet is empty");
    }

    public final void forEach(l block) {
        E.f(block, "block");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        block.invoke(Integer.valueOf(iArr[(i5 << 3) + i7]));
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final void forEachIndex(l block) {
        E.f(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        AbstractC0157z.D(i5 << 3, i7, block);
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    @IntRange(from = 0)
    public final int getCapacity() {
        return this._capacity;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i5 = 0;
        int iHashCode = 0;
        while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        iHashCode = Integer.hashCode(iArr[(i5 << 3) + i7]) + iHashCode;
                    }
                    j6 >>= 8;
                }
                if (i6 != 8) {
                    return iHashCode;
                }
            }
            if (i5 == length) {
                return iHashCode;
            }
            i5++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    private IntSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = IntSetKt.getEmptyIntArray();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0054 A[LOOP:0: B:5:0x0010->B:18:0x0054, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0057 A[SYNTHETIC] */
    public final boolean any(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j6 = jArr[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j6) < 128 && ((Boolean) predicate.invoke(Integer.valueOf(iArr[(i5 << 3) + i7]))).booleanValue()) {
                            return true;
                        }
                        j6 >>= 8;
                    }
                    if (i6 == 8) {
                        if (i5 != length) {
                            i5++;
                        }
                    }
                } else if (i5 != length) {
                    i5++;
                }
            }
        }
        return false;
    }

    @IntRange(from = 0)
    public final int count(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128 && ((Boolean) predicate.invoke(Integer.valueOf(iArr[(i5 << 3) + i8]))).booleanValue()) {
                        i6++;
                    }
                    j6 >>= 8;
                }
                if (i7 != 8) {
                    return i6;
                }
            }
            if (i5 == length) {
                return i6;
            }
            i5++;
        }
    }

    public final String joinToString(CharSequence separator) {
        E.f(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006d A[DONT_INVERT, PHI: r9
  0x006d: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x002e, B:18:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x006f A[LOOP:0: B:5:0x0020->B:20:0x006f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0072 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence charSequence, l lVar) {
        E.f(separator, "separator");
        StringBuilder sbU = AbstractC0157z.u(charSequence, "prefix", lVar, "transform", charSequence);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbU.append((CharSequence) "");
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        int i9 = iArr[(i5 << 3) + i8];
                        if (i6 == -1) {
                            sbU.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sbU.append(separator);
                        }
                        sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i9)));
                        i6++;
                    }
                    j6 >>= 8;
                }
                if (i7 == 8) {
                    if (i5 == length) {
                        i5++;
                    }
                }
                sbU.append((CharSequence) "");
                break;
            }
            if (i5 == length) {
                sbU.append((CharSequence) "");
                break;
            }
            i5++;
        }
        String string = sbU.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00ab A[DONT_INVERT, PHI: r11
  0x00ab: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:28:0x0064, B:42:0x00a9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad A[LOOP:0: B:27:0x0053->B:44:0x00ad, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00b0 A[SYNTHETIC] */
    public static /* synthetic */ String joinToString$default(IntSet intSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if (obj == null) {
            CharSequence separator = (i6 & 1) != 0 ? ", " : charSequence;
            CharSequence prefix = (i6 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i6 & 4) == 0 ? charSequence3 : "";
            int i7 = (i6 & 8) != 0 ? -1 : i5;
            CharSequence charSequence5 = (i6 & 16) != 0 ? "..." : charSequence4;
            E.f(separator, "separator");
            E.f(prefix, "prefix");
            E.f(postfix, "postfix");
            StringBuilder sbU = AbstractC0157z.u(charSequence5, "truncated", lVar, "transform", prefix);
            int[] iArr = intSet.elements;
            long[] jArr = intSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                sbU.append(postfix);
                break;
            }
            int i8 = 0;
            int i9 = 0;
            loop0: while (true) {
                long j6 = jArr[i8];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i8 == length) {
                        sbU.append(postfix);
                        break;
                    }
                    i8++;
                } else {
                    int i10 = 8;
                    int i11 = 8 - ((~(i8 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j6 & 255) < 128) {
                            int i13 = iArr[(i8 << 3) + i12];
                            if (i9 == i7) {
                                sbU.append(charSequence5);
                                break loop0;
                            }
                            if (i9 != 0) {
                                sbU.append(separator);
                            }
                            sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i13)));
                            i9++;
                        }
                        j6 >>= i10;
                        i12++;
                        i10 = i10;
                    }
                    if (i11 == i10) {
                        if (i8 == length) {
                            i8++;
                        }
                    }
                    sbU.append(postfix);
                    break;
                }
            }
            String string = sbU.toString();
            E.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0053 A[LOOP:0: B:5:0x0010->B:17:0x0053, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:20:0x0056 A[SYNTHETIC] */
    public final int first(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j6 = jArr[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j6) < 128) {
                            int i8 = iArr[(i5 << 3) + i7];
                            if (((Boolean) predicate.invoke(Integer.valueOf(i8))).booleanValue()) {
                                return i8;
                            }
                        }
                        j6 >>= 8;
                    }
                    if (i6 == 8) {
                        if (i5 != length) {
                            i5++;
                        }
                    }
                } else if (i5 != length) {
                    i5++;
                }
            }
        }
        throw new NoSuchElementException("Could not find a match");
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i5) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i5, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i5, l lVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbU = AbstractC0157z.u(charSequence, "postfix", lVar, "transform", prefix);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbU.append(charSequence);
            break;
        }
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8;
                int i9 = 8 - ((~(i6 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j6 & 255) < 128) {
                        int i11 = iArr[(i6 << 3) + i10];
                        if (i7 == i5) {
                            sbU.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbU.append(separator);
                        }
                        sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i11)));
                        i7++;
                    }
                    j6 >>= i8;
                    i10++;
                    i8 = i8;
                }
                if (i9 == i8) {
                }
                sbU.append(charSequence);
                break;
            }
            if (i6 == length) {
                sbU.append(charSequence);
                break;
            }
            i6++;
        }
        String string = sbU.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i5, CharSequence charSequence2) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbW = AbstractC0157z.w(charSequence, "postfix", charSequence2, "truncated", prefix);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbW.append(charSequence);
            break;
        }
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8;
                int i9 = 8 - ((~(i6 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j6 & 255) < 128) {
                        int i11 = iArr[(i6 << 3) + i10];
                        if (i7 == i5) {
                            sbW.append(charSequence2);
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbW.append(separator);
                        }
                        sbW.append(i11);
                        i7++;
                    }
                    j6 >>= i8;
                    i10++;
                    i8 = i8;
                }
                if (i9 == i8) {
                }
                sbW.append(charSequence);
                break;
            }
            if (i6 == length) {
                sbW.append(charSequence);
                break;
            }
            i6++;
        }
        String string = sbW.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence charSequence, l lVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        StringBuilder sbU = AbstractC0157z.u(charSequence, "truncated", lVar, "transform", prefix);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbU.append(postfix);
            break;
        }
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8;
                int i9 = 8 - ((~(i6 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j6 & 255) < 128) {
                        int i11 = iArr[(i6 << 3) + i10];
                        if (i7 == i5) {
                            sbU.append(charSequence);
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbU.append(separator);
                        }
                        sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i11)));
                        i7++;
                    }
                    j6 >>= i8;
                    i10++;
                    i8 = i8;
                }
                if (i9 == i8) {
                }
                sbU.append(postfix);
                break;
            }
            if (i6 == length) {
                sbU.append(postfix);
                break;
            }
            i6++;
        }
        String string = sbU.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0076 A[DONT_INVERT, PHI: r10
  0x0076: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0035, B:18:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0078 A[LOOP:0: B:5:0x0027->B:20:0x0078, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x007b A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, l lVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbU = AbstractC0157z.u(charSequence, "postfix", lVar, "transform", prefix);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbU.append(charSequence);
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((j6 & 255) < 128) {
                        int i9 = iArr[(i5 << 3) + i8];
                        if (i6 == -1) {
                            sbU.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sbU.append(separator);
                        }
                        sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i9)));
                        i6++;
                    }
                    j6 >>= 8;
                }
                if (i7 == 8) {
                    if (i5 == length) {
                        i5++;
                    }
                }
                sbU.append(charSequence);
                break;
            }
            if (i5 == length) {
                sbU.append(charSequence);
                break;
            }
            i5++;
        }
        String string = sbU.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0071 A[DONT_INVERT, PHI: r10
  0x0071: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0030, B:18:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0073 A[LOOP:0: B:5:0x0022->B:20:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0076 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, l transform) {
        E.f(separator, "separator");
        E.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sb.append((CharSequence) "");
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((j6 & 255) < 128) {
                        int i9 = iArr[(i5 << 3) + i8];
                        if (i6 == -1) {
                            sb.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sb.append(separator);
                        }
                        sb.append((CharSequence) transform.invoke(Integer.valueOf(i9)));
                        i6++;
                    }
                    j6 >>= 8;
                }
                if (i7 == 8) {
                    if (i5 == length) {
                        i5++;
                    }
                }
                sb.append((CharSequence) "");
                break;
            }
            if (i5 == length) {
                sb.append((CharSequence) "");
                break;
            }
            i5++;
        }
        String string = sb.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006a A[DONT_INVERT, PHI: r9
  0x006a: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x0029, B:18:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x006c A[LOOP:0: B:5:0x001b->B:20:0x006c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x006f A[SYNTHETIC] */
    public final String joinToString(l transform) {
        E.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sb.append((CharSequence) "");
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        int i9 = iArr[(i5 << 3) + i8];
                        if (i6 == -1) {
                            sb.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sb.append((CharSequence) ", ");
                        }
                        sb.append((CharSequence) transform.invoke(Integer.valueOf(i9)));
                        i6++;
                    }
                    j6 >>= 8;
                }
                if (i7 == 8) {
                    if (i5 == length) {
                        i5++;
                    }
                }
                sb.append((CharSequence) "");
                break;
            }
            if (i5 == length) {
                sb.append((CharSequence) "");
                break;
            }
            i5++;
        }
        String string = sb.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
