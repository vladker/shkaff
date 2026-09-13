package androidx.collection;

import A3.AbstractC0157z;
import O3.l;
import O3.p;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ObjectIntMap<K> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public int[] values;

    public /* synthetic */ ObjectIntMap(AbstractC1107v abstractC1107v) {
        this();
    }

    public static /* synthetic */ String joinToString$default(ObjectIntMap objectIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
        return objectIntMap.joinToString(charSequence, charSequence2, charSequence6, i5, charSequence5);
    }

    public final boolean all(p predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                    if ((255 & j6) < 128) {
                        int i8 = (i5 << 3) + i7;
                        if (!((Boolean) predicate.invoke(objArr[i8], Integer.valueOf(iArr[i8]))).booleanValue()) {
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

    public final boolean contains(K k6) {
        return findKeyIndex(k6) >= 0;
    }

    public final boolean containsKey(K k6) {
        return findKeyIndex(k6) >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0041 A[LOOP:0: B:5:0x000b->B:18:0x0041, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[SYNTHETIC] */
    public final boolean containsValue(int i5) {
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j6 = jArr[i6];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j6) < 128 && i5 == iArr[(i6 << 3) + i8]) {
                            return true;
                        }
                        j6 >>= 8;
                    }
                    if (i7 == 8) {
                        if (i6 != length) {
                            i6++;
                        }
                    }
                } else if (i6 != length) {
                    i6++;
                }
            }
        }
        return false;
    }

    public final int count() {
        return getSize();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0062 A[LOOP:0: B:14:0x0027->B:26:0x0062, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectIntMap)) {
            return false;
        }
        ObjectIntMap objectIntMap = (ObjectIntMap) obj;
        if (objectIntMap.getSize() != getSize()) {
            return false;
        }
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                            int i8 = (i5 << 3) + i7;
                            if (iArr[i8] != objectIntMap.get(objArr[i8])) {
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

    public final int findKeyIndex(K k6) {
        int i5 = 0;
        int iHashCode = (k6 != null ? k6.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i6 = iHashCode ^ (iHashCode << 16);
        int i7 = i6 & 127;
        int i8 = this._capacity;
        int i9 = i6 >>> 7;
        while (true) {
            int i10 = i9 & i8;
            long[] jArr = this.metadata;
            int i11 = i10 >> 3;
            int i12 = (i10 & 7) << 3;
            long j6 = ((jArr[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr[i11] >>> i12);
            long j7 = (((long) i7) * ScatterMapKt.BitmaskLsb) ^ j6;
            for (long j8 = (~j7) & (j7 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j8 != 0; j8 &= j8 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j8) >> 3) + i10) & i8;
                if (E.a(this.keys[iNumberOfTrailingZeros], k6)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j6 & ((~j6) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i5 += 8;
            i9 = i10 + i5;
        }
    }

    public final void forEach(p block) {
        E.f(block, "block");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                        int i8 = (i5 << 3) + i7;
                        block.invoke(objArr[i8], Integer.valueOf(iArr[i8]));
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
        Object[] objArr = this.keys;
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
                        block.invoke(objArr[(i5 << 3) + i7]);
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
        int[] iArr = this.values;
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

    public final int get(K k6) {
        int iFindKeyIndex = findKeyIndex(k6);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        throw new NoSuchElementException("There is no key " + k6 + " in the map");
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getOrDefault(K k6, int i5) {
        int iFindKeyIndex = findKeyIndex(k6);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : i5;
    }

    public final int getOrElse(K k6, O3.a defaultValue) {
        E.f(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(k6);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : ((Number) defaultValue.invoke()).intValue();
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                        int i8 = (i5 << 3) + i7;
                        Object obj = objArr[i8];
                        iHashCode += Integer.hashCode(iArr[i8]) ^ (obj != null ? obj.hashCode() : 0);
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

    /* JADX WARN: Code duplicated, block: B:23:0x006e A[DONT_INVERT, PHI: r8
  0x006e: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x0030, B:22:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x0070 A[LOOP:0: B:9:0x0022->B:24:0x0070, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0073 A[EDGE_INSN: B:28:0x0073->B:25:0x0073 BREAK  A[LOOP:0: B:9:0x0022->B:24:0x0070], SYNTHETIC] */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(VectorFormat.DEFAULT_PREFIX);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                long j6 = jArr[i5];
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i5 != length) {
                        break;
                        break;
                    }
                    i5++;
                } else {
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j6) < 128) {
                            int i9 = (i5 << 3) + i8;
                            Object obj = objArr[i9];
                            int i10 = iArr[i9];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append("=");
                            sb.append(i10);
                            i6++;
                            if (i6 < this._size) {
                                sb.append(", ");
                            }
                        }
                        j6 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                    if (i5 != length) {
                        break;
                    }
                    i5++;
                }
            }
        }
        return AbstractC0157z.j('}', "s.append('}').toString()", sb);
    }

    private ObjectIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = IntSetKt.getEmptyIntArray();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x005c A[LOOP:0: B:5:0x0016->B:18:0x005c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x005f A[SYNTHETIC] */
    public final boolean any(p predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                            int i8 = (i5 << 3) + i7;
                            if (((Boolean) predicate.invoke(objArr[i8], Integer.valueOf(iArr[i8]))).booleanValue()) {
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
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                    if ((255 & j6) < 128) {
                        int i9 = (i5 << 3) + i8;
                        if (((Boolean) predicate.invoke(objArr[i9], Integer.valueOf(iArr[i9]))).booleanValue()) {
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

    /* JADX WARN: Code duplicated, block: B:21:0x007c A[DONT_INVERT, PHI: r10
  0x007c: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0030, B:20:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x007e A[LOOP:0: B:5:0x0022->B:22:0x007e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0081 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence charSequence, p pVar) {
        E.f(separator, "separator");
        StringBuilder sbV = AbstractC0157z.v(charSequence, "prefix", pVar, "transform", charSequence);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbV.append((CharSequence) "");
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr[i5];
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
                        Object obj = objArr[i10];
                        int i11 = iArr[i10];
                        if (i6 == -1) {
                            sbV.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sbV.append(separator);
                        }
                        sbV.append((CharSequence) pVar.invoke(obj, Integer.valueOf(i11)));
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

    public static /* synthetic */ String joinToString$default(ObjectIntMap objectIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, p pVar, int i6, Object obj) {
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
            Object[] objArr = objectIntMap.keys;
            int[] iArr = objectIntMap.values;
            long[] jArr2 = objectIntMap.metadata;
            int length = jArr2.length - 2;
            if (length < 0) {
                sbV.append(postfix);
                break;
            }
            int i8 = 0;
            int i9 = 0;
            loop0: while (true) {
                long j6 = jArr2[i8];
                int i10 = i8;
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i10 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j6 & 255) < 128) {
                            int i14 = (i10 << 3) + i13;
                            Object obj2 = objArr[i14];
                            int i15 = iArr[i14];
                            if (i9 == i7) {
                                sbV.append(charSequence5);
                                break loop0;
                            }
                            if (i9 != 0) {
                                sbV.append(separator);
                            }
                            sbV.append((CharSequence) pVar.invoke(obj2, Integer.valueOf(i15)));
                            i9++;
                        }
                        j6 >>= i11;
                        i13++;
                        i11 = i11;
                        jArr2 = jArr2;
                    }
                    jArr = jArr2;
                    if (i12 == i11) {
                    }
                    sbV.append(postfix);
                    break;
                }
                jArr = jArr2;
                if (i10 == length) {
                    sbV.append(postfix);
                    break;
                }
                i8 = i10 + 1;
                jArr2 = jArr;
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

    /* JADX WARN: Code duplicated, block: B:21:0x0089 A[DONT_INVERT, PHI: r11
  0x0089: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003a, B:20:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x008b A[LOOP:0: B:5:0x0029->B:22:0x008b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0090 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i5, p pVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbV = AbstractC0157z.v(charSequence, "postfix", pVar, "transform", prefix);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbV.append(charSequence);
            break;
        }
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                if (i6 == length) {
                    sbV.append(charSequence);
                    break;
                }
                i6++;
            } else {
                int i8 = 8;
                int i9 = 8 - ((~(i6 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j6 & 255) < 128) {
                        int i11 = (i6 << 3) + i10;
                        Object obj = objArr[i11];
                        int i12 = iArr[i11];
                        if (i7 == i5) {
                            sbV.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbV.append(separator);
                        }
                        sbV.append((CharSequence) pVar.invoke(obj, Integer.valueOf(i12)));
                        i7++;
                    }
                    j6 >>= i8;
                    i10++;
                    i8 = i8;
                }
                if (i9 == i8) {
                    if (i6 == length) {
                        i6++;
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

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i5, CharSequence charSequence2) {
        Object[] objArr;
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbW = AbstractC0157z.w(charSequence, "postfix", charSequence2, "truncated", prefix);
        Object[] objArr2 = this.keys;
        int[] iArr = this.values;
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
                        int i11 = (i6 << 3) + i10;
                        Object obj = objArr2[i11];
                        int i12 = iArr[i11];
                        if (i7 == i5) {
                            sbW.append(charSequence2);
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbW.append(separator);
                        }
                        sbW.append(obj);
                        sbW.append(Chars.EQ);
                        sbW.append(i12);
                        i7++;
                    }
                    j6 >>= i8;
                    i10++;
                    objArr2 = objArr2;
                    i8 = i8;
                }
                objArr = objArr2;
                if (i9 == i8) {
                }
                sbW.append(charSequence);
                break;
            }
            objArr = objArr2;
            if (i6 == length) {
                sbW.append(charSequence);
                break;
            }
            i6++;
            objArr2 = objArr;
        }
        String string = sbW.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, int i5, CharSequence charSequence2, p pVar) {
        Object[] objArr;
        CharSequence separator = charSequence;
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        StringBuilder sbV = AbstractC0157z.v(charSequence2, "truncated", pVar, "transform", prefix);
        Object[] objArr2 = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbV.append(postfix);
            break;
        }
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            long j6 = jArr[i6];
            int i8 = i6;
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i9 = 8 - ((~(i8 - length)) >>> 31);
                int i10 = 0;
                while (i10 < i9) {
                    if ((j6 & 255) < 128) {
                        int i11 = (i8 << 3) + i10;
                        Object obj = objArr2[i11];
                        int i12 = iArr[i11];
                        if (i7 == i5) {
                            sbV.append(charSequence2);
                            break loop0;
                        }
                        if (i7 != 0) {
                            sbV.append(separator);
                        }
                        sbV.append((CharSequence) pVar.invoke(obj, Integer.valueOf(i12)));
                        i7++;
                    }
                    j6 >>= 8;
                    i10++;
                    separator = charSequence;
                    objArr2 = objArr2;
                }
                objArr = objArr2;
                if (i9 == 8) {
                }
                sbV.append(postfix);
                break;
            }
            objArr = objArr2;
            if (i8 == length) {
                sbV.append(postfix);
                break;
            }
            i6 = i8 + 1;
            separator = charSequence;
            objArr2 = objArr;
        }
        String string = sbV.toString();
        E.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0088 A[DONT_INVERT, PHI: r11
  0x0088: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003a, B:20:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x008a A[LOOP:0: B:5:0x0029->B:22:0x008a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x008f A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, p pVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbV = AbstractC0157z.v(charSequence, "postfix", pVar, "transform", prefix);
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            sbV.append(charSequence);
            break;
        }
        int i5 = 0;
        int i6 = 0;
        loop0: while (true) {
            long j6 = jArr[i5];
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
                        Object obj = objArr[i10];
                        int i11 = iArr[i10];
                        if (i6 == -1) {
                            sbV.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sbV.append(separator);
                        }
                        sbV.append((CharSequence) pVar.invoke(obj, Integer.valueOf(i11)));
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

    /* JADX WARN: Code duplicated, block: B:21:0x0083 A[DONT_INVERT, PHI: r11
  0x0083: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0035, B:20:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0085 A[LOOP:0: B:5:0x0024->B:22:0x0085, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x008a A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, p transform) {
        E.f(separator, "separator");
        E.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                        Object obj = objArr[i10];
                        int i11 = iArr[i10];
                        if (i6 == -1) {
                            sb.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sb.append(separator);
                        }
                        sb.append((CharSequence) transform.invoke(obj, Integer.valueOf(i11)));
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

    /* JADX WARN: Code duplicated, block: B:21:0x0079 A[DONT_INVERT, PHI: r10
  0x0079: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x002b, B:20:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x007b A[LOOP:0: B:5:0x001d->B:22:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x007e A[SYNTHETIC] */
    public final String joinToString(p transform) {
        E.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        Object[] objArr = this.keys;
        int[] iArr = this.values;
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
                        Object obj = objArr[i10];
                        int i11 = iArr[i10];
                        if (i6 == -1) {
                            sb.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i6 != 0) {
                            sb.append((CharSequence) ", ");
                        }
                        sb.append((CharSequence) transform.invoke(obj, Integer.valueOf(i11)));
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
