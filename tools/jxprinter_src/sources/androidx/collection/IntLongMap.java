package androidx.collection;

import A3.AbstractC0157z;
import O3.l;
import O3.p;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntLongMap {
    public int _capacity;
    public int _size;
    public int[] keys;
    public long[] metadata;
    public long[] values;

    public /* synthetic */ IntLongMap(AbstractC1107v abstractC1107v) {
        this();
    }

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
        return intLongMap.joinToString(charSequence, charSequence2, charSequence6, i5, charSequence5);
    }

    public final boolean all(p predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (!((Boolean) predicate.invoke(Integer.valueOf(iArr[i8]), Long.valueOf(jArr[i8]))).booleanValue()) {
                            return false;
                        }
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
        return findKeyIndex(i5) >= 0;
    }

    public final boolean containsKey(int i5) {
        return findKeyIndex(i5) >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0043 A[LOOP:0: B:5:0x000b->B:18:0x0043, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0046 A[SYNTHETIC] */
    public final boolean containsValue(long j6) {
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j7 = jArr2[i5];
                if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j7) < 128 && j6 == jArr[(i5 << 3) + i7]) {
                            return true;
                        }
                        j7 >>= 8;
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

    public final int count() {
        return getSize();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0064 A[LOOP:0: B:14:0x0027->B:26:0x0064, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0067 A[SYNTHETIC] */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntLongMap)) {
            return false;
        }
        IntLongMap intLongMap = (IntLongMap) obj;
        if (intLongMap.getSize() != getSize()) {
            return false;
        }
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j6 = jArr2[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j6) < 128) {
                            int i8 = (i5 << 3) + i7;
                            if (jArr[i8] != intLongMap.get(iArr[i8])) {
                                return false;
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
        return true;
    }

    public final int findKeyIndex(int i5) {
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
                if (this.keys[iNumberOfTrailingZeros] == i5) {
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

    public final void forEach(p block) {
        E.f(block, "block");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        int i8 = (i5 << 3) + i7;
                        block.invoke(Integer.valueOf(iArr[i8]), Long.valueOf(jArr[i8]));
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

    public final void forEachIndexed(l block) {
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

    public final void forEachKey(l block) {
        E.f(block, "block");
        int[] iArr = this.keys;
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

    public final void forEachValue(l block) {
        E.f(block, "block");
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        block.invoke(Long.valueOf(jArr[(i5 << 3) + i7]));
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

    public final long get(int i5) {
        int iFindKeyIndex = findKeyIndex(i5);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        throw new NoSuchElementException(AbstractC0157z.k(i5, "Cannot find value for key "));
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final long getOrDefault(int i5, long j6) {
        int iFindKeyIndex = findKeyIndex(i5);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : j6;
    }

    public final long getOrElse(int i5, O3.a defaultValue) {
        E.f(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(i5);
        return iFindKeyIndex < 0 ? ((Number) defaultValue.invoke()).longValue() : this.values[iFindKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i5 = 0;
        int iHashCode = 0;
        while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j6) < 128) {
                        int i8 = (i5 << 3) + i7;
                        iHashCode += Integer.hashCode(iArr[i8]) ^ Long.hashCode(jArr[i8]);
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
        int i5;
        int i6;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(VectorFormat.DEFAULT_PREFIX);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i7 = 0;
            int i8 = 0;
            while (true) {
                long j6 = jArr2[i7];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((255 & j6) < 128) {
                            int i11 = (i7 << 3) + i10;
                            int i12 = iArr[i11];
                            i6 = i7;
                            long j7 = jArr[i11];
                            sb.append(i12);
                            sb.append("=");
                            sb.append(j7);
                            i8++;
                            if (i8 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i6 = i7;
                        }
                        j6 >>= 8;
                        i10++;
                        i7 = i6;
                    }
                    int i13 = i7;
                    if (i9 != 8) {
                        break;
                    }
                    i5 = i13;
                } else {
                    i5 = i7;
                }
                if (i5 == length) {
                    break;
                }
                i7 = i5 + 1;
            }
        }
        return AbstractC0157z.j('}', "s.append('}').toString()", sb);
    }

    private IntLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0060 A[LOOP:0: B:5:0x0016->B:18:0x0060, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0063 A[SYNTHETIC] */
    public final boolean any(p predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j6 = jArr2[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j6) < 128) {
                            int i8 = (i5 << 3) + i7;
                            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i8]), Long.valueOf(jArr[i8]))).booleanValue()) {
                                return true;
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
        return false;
    }

    public final int count(p predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i5 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        int i9 = (i5 << 3) + i8;
                        if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i9]), Long.valueOf(jArr[i9]))).booleanValue()) {
                            i6++;
                        }
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

    /* JADX WARN: Code duplicated, block: B:21:0x0080 A[DONT_INVERT, PHI: r10
  0x0080: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0030, B:20:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0082 A[LOOP:0: B:5:0x0022->B:22:0x0082, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0085 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence charSequence, p pVar) {
        E.f(separator, "separator");
        StringBuilder sbV = AbstractC0157z.v(charSequence, "prefix", pVar, "transform", charSequence);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            sbV.append((CharSequence) "");
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                if (i5 == length) {
                    sbV.append((CharSequence) "");
                    break;
                }
                i5++;
            } else {
                int i7 = 8;
                int i8 = 8 - ((~(i5 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((j6 & 255) < 128) {
                        int i10 = (i5 << 3) + i9;
                        int i11 = iArr[i10];
                        long j7 = jArr[i10];
                        if (i6 == -1) {
                            sbV.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sbV.append(separator);
                        }
                        sbV.append((CharSequence) pVar.invoke(Integer.valueOf(i11), Long.valueOf(j7)));
                        i6++;
                    }
                    j6 >>= i7;
                    i9++;
                    i7 = i7;
                }
                if (i8 == i7) {
                    if (i5 == length) {
                        i5++;
                    }
                }
                sbV.append((CharSequence) "");
                break;
            }
        }
        String string = sbV.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, p pVar, int i6, Object obj) {
        long[] jArr;
        if (obj == null) {
            CharSequence separator = (i6 & 1) != 0 ? ", " : charSequence;
            CharSequence prefix = (i6 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i6 & 4) == 0 ? charSequence3 : "";
            int i7 = (i6 & 8) != 0 ? -1 : i5;
            CharSequence charSequence5 = (i6 & 16) != 0 ? "..." : charSequence4;
            E.f(separator, "separator");
            E.f(prefix, "prefix");
            E.f(postfix, "postfix");
            StringBuilder sbV = AbstractC0157z.v(charSequence5, "truncated", pVar, "transform", prefix);
            int[] iArr = intLongMap.keys;
            long[] jArr2 = intLongMap.values;
            long[] jArr3 = intLongMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                sbV.append(postfix);
                break;
            }
            int i8 = 0;
            int i9 = 0;
            loop0: while (true) {
                long j6 = jArr3[i8];
                int i10 = i8;
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i10 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j6 & 255) < 128) {
                            int i14 = (i10 << 3) + i13;
                            int i15 = iArr[i14];
                            long j7 = jArr2[i14];
                            if (i9 == i7) {
                                sbV.append(charSequence5);
                                break loop0;
                            }
                            if (i9 != 0) {
                                sbV.append(separator);
                            }
                            sbV.append((CharSequence) pVar.invoke(Integer.valueOf(i15), Long.valueOf(j7)));
                            i9++;
                        }
                        j6 >>= i11;
                        i13++;
                        i11 = i11;
                        jArr3 = jArr3;
                    }
                    jArr = jArr3;
                    if (i12 == i11) {
                    }
                    sbV.append(postfix);
                    break;
                }
                jArr = jArr3;
                if (i10 == length) {
                    sbV.append(postfix);
                    break;
                }
                i8 = i10 + 1;
                jArr3 = jArr;
            }
            String string = sbV.toString();
            E.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
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

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence charSequence2, int i5, p pVar) {
        CharSequence separator = charSequence;
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbV = AbstractC0157z.v(charSequence2, "postfix", pVar, "transform", prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            sbV.append(charSequence2);
            break;
        }
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            long j6 = jArr2[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8;
                int i9 = 8 - ((~(i6 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j6 & 255) < 128) {
                        int i11 = (i6 << 3) + i10;
                        int i12 = iArr[i11];
                        long j7 = jArr[i11];
                        if (i7 == i5) {
                            sbV.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbV.append(separator);
                        }
                        sbV.append((CharSequence) pVar.invoke(Integer.valueOf(i12), Long.valueOf(j7)));
                        i7++;
                    }
                    j6 >>= i8;
                    i10++;
                    separator = charSequence;
                    i8 = i8;
                }
                if (i9 == i8) {
                }
                sbV.append(charSequence2);
                break;
            }
            if (i6 == length) {
                sbV.append(charSequence2);
                break;
            }
            i6++;
            separator = charSequence;
        }
        String string = sbV.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i5, CharSequence charSequence2) {
        int[] iArr;
        long[] jArr;
        long[] jArr2;
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbW = AbstractC0157z.w(charSequence, "postfix", charSequence2, "truncated", prefix);
        int[] iArr2 = this.keys;
        long[] jArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            sbW.append(charSequence);
            break;
        }
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            long j6 = jArr4[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8;
                int i9 = 8 - ((~(i6 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j6 & 255) < 128) {
                        int i11 = (i6 << 3) + i10;
                        int i12 = iArr2[i11];
                        jArr2 = jArr3;
                        long j7 = jArr2[i11];
                        if (i7 == i5) {
                            sbW.append(charSequence2);
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbW.append(separator);
                        }
                        sbW.append(i12);
                        sbW.append(Chars.EQ);
                        sbW.append(j7);
                        i7++;
                    } else {
                        jArr2 = jArr3;
                    }
                    j6 >>= i8;
                    i10++;
                    i8 = i8;
                    iArr2 = iArr2;
                    jArr3 = jArr2;
                }
                iArr = iArr2;
                jArr = jArr3;
                if (i9 == i8) {
                }
                sbW.append(charSequence);
                break;
            }
            iArr = iArr2;
            jArr = jArr3;
            if (i6 == length) {
                sbW.append(charSequence);
                break;
            }
            i6++;
            iArr2 = iArr;
            jArr3 = jArr;
        }
        String string = sbW.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0091 A[DONT_INVERT, PHI: r12
  0x0091: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0042, B:19:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x0093 A[LOOP:0: B:5:0x0030->B:21:0x0093, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x009a A[SYNTHETIC] */
    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, int i5, CharSequence charSequence2, p pVar) {
        CharSequence separator = charSequence;
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        StringBuilder sbV = AbstractC0157z.v(charSequence2, "truncated", pVar, "transform", prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            sbV.append(postfix);
            break;
        }
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            long j6 = jArr2[i6];
            int i8 = i6;
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                if (i8 == length) {
                    sbV.append(postfix);
                    break;
                }
                i6 = i8 + 1;
                separator = charSequence;
            } else {
                int i9 = 8 - ((~(i8 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j6 & 255) < 128) {
                        int i11 = (i8 << 3) + i10;
                        int i12 = iArr[i11];
                        long j7 = jArr[i11];
                        if (i7 == i5) {
                            sbV.append(charSequence2);
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbV.append(separator);
                        }
                        sbV.append((CharSequence) pVar.invoke(Integer.valueOf(i12), Long.valueOf(j7)));
                        i7++;
                    }
                    j6 >>= 8;
                    i10++;
                    separator = charSequence;
                }
                if (i9 == 8) {
                    if (i8 == length) {
                        i6 = i8 + 1;
                        separator = charSequence;
                    }
                }
                sbV.append(postfix);
                break;
            }
        }
        String string = sbV.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008c A[DONT_INVERT, PHI: r11
  0x008c: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003a, B:20:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x008e A[LOOP:0: B:5:0x0029->B:22:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0093 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, p pVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbV = AbstractC0157z.v(charSequence, "postfix", pVar, "transform", prefix);
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            sbV.append(charSequence);
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                if (i5 == length) {
                    sbV.append(charSequence);
                    break;
                }
                i5++;
            } else {
                int i7 = 8;
                int i8 = 8 - ((~(i5 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((j6 & 255) < 128) {
                        int i10 = (i5 << 3) + i9;
                        int i11 = iArr[i10];
                        long j7 = jArr[i10];
                        if (i6 == -1) {
                            sbV.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sbV.append(separator);
                        }
                        sbV.append((CharSequence) pVar.invoke(Integer.valueOf(i11), Long.valueOf(j7)));
                        i6++;
                    }
                    j6 >>= i7;
                    i9++;
                    i7 = i7;
                }
                if (i8 == i7) {
                    if (i5 == length) {
                        i5++;
                    }
                }
                sbV.append(charSequence);
                break;
            }
        }
        String string = sbV.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0087 A[DONT_INVERT, PHI: r11
  0x0087: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0035, B:20:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0089 A[LOOP:0: B:5:0x0024->B:22:0x0089, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x008e A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, p transform) {
        E.f(separator, "separator");
        E.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            sb.append((CharSequence) "");
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                if (i5 == length) {
                    sb.append((CharSequence) "");
                    break;
                }
                i5++;
            } else {
                int i7 = 8;
                int i8 = 8 - ((~(i5 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((j6 & 255) < 128) {
                        int i10 = (i5 << 3) + i9;
                        int i11 = iArr[i10];
                        long j7 = jArr[i10];
                        if (i6 == -1) {
                            sb.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sb.append(separator);
                        }
                        sb.append((CharSequence) transform.invoke(Integer.valueOf(i11), Long.valueOf(j7)));
                        i6++;
                    }
                    j6 >>= i7;
                    i9++;
                    i7 = i7;
                }
                if (i8 == i7) {
                    if (i5 == length) {
                        i5++;
                    }
                }
                sb.append((CharSequence) "");
                break;
            }
        }
        String string = sb.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007d A[DONT_INVERT, PHI: r10
  0x007d: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x002b, B:20:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x007f A[LOOP:0: B:5:0x001d->B:22:0x007f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0082 A[SYNTHETIC] */
    public final String joinToString(p transform) {
        E.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            sb.append((CharSequence) "");
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr2[i5];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                if (i5 == length) {
                    sb.append((CharSequence) "");
                    break;
                }
                i5++;
            } else {
                int i7 = 8;
                int i8 = 8 - ((~(i5 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((j6 & 255) < 128) {
                        int i10 = (i5 << 3) + i9;
                        int i11 = iArr[i10];
                        long j7 = jArr[i10];
                        if (i6 == -1) {
                            sb.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sb.append((CharSequence) ", ");
                        }
                        sb.append((CharSequence) transform.invoke(Integer.valueOf(i11), Long.valueOf(j7)));
                        i6++;
                    }
                    j6 >>= i7;
                    i9++;
                    i7 = i7;
                }
                if (i8 == i7) {
                    if (i5 == length) {
                        i5++;
                    }
                }
                sb.append((CharSequence) "");
                break;
            }
        }
        String string = sb.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
