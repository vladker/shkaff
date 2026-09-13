package B3;

import A3.AbstractC0139g;
import A3.C0136d;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.E;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Map, Serializable, P3.d {
    public static final g Companion = new g();
    private static final m Empty;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f96a;
    public int b;
    public int c;
    public int d;
    public int e;
    private n entriesView;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f97f;
    private int[] hashArray;
    private Object[] keysArray;
    private o keysView;
    private int[] presenceArray;
    private Object[] valuesArray;
    private p valuesView;

    static {
        m mVar = new m(0);
        mVar.f97f = true;
        Empty = mVar;
    }

    public m() {
        this(8);
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.f97f) {
            return new t(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final Map<Object, Object> build() {
        h();
        this.f97f = true;
        if (this.e > 0) {
            return this;
        }
        m mVar = Empty;
        E.d(mVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mVar;
    }

    @Override // java.util.Map
    public final void clear() {
        h();
        int i5 = this.b - 1;
        if (i5 >= 0) {
            int i6 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i7 = iArr[i6];
                if (i7 >= 0) {
                    this.hashArray[i7] = 0;
                    iArr[i6] = -1;
                }
                if (i6 == i5) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        f.resetRange(this.keysArray, 0, this.b);
        Object[] objArr = this.valuesArray;
        if (objArr != null) {
            f.resetRange(objArr, 0, this.b);
        }
        this.e = 0;
        this.b = 0;
        this.d++;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m6) {
        E.f(m6, "m");
        for (Object obj : m6) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<Object, Object> entry) {
        E.f(entry, "entry");
        int iK = k(entry.getKey());
        if (iK < 0) {
            return false;
        }
        Object[] objArr = this.valuesArray;
        E.c(objArr);
        return E.a(objArr[iK], entry.getValue());
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return k(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return l(obj) >= 0;
    }

    public final h entriesIterator$kotlin_stdlib() {
        return new h(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.e == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    public final int f(Object obj) {
        h();
        while (true) {
            int iM = m(obj);
            int i5 = this.f96a * 2;
            int length = this.hashArray.length / 2;
            if (i5 > length) {
                i5 = length;
            }
            int i6 = 0;
            while (true) {
                int[] iArr = this.hashArray;
                int i7 = iArr[iM];
                if (i7 <= 0) {
                    int i8 = this.b;
                    Object[] objArr = this.keysArray;
                    if (i8 >= objArr.length) {
                        j(1);
                        break;
                    }
                    int i9 = i8 + 1;
                    this.b = i9;
                    objArr[i8] = obj;
                    this.presenceArray[i8] = iM;
                    iArr[iM] = i9;
                    this.e++;
                    this.d++;
                    if (i6 > this.f96a) {
                        this.f96a = i6;
                    }
                    return i8;
                }
                if (E.a(this.keysArray[i7 - 1], obj)) {
                    return -i7;
                }
                i6++;
                if (i6 > i5) {
                    n(this.hashArray.length * 2);
                    break;
                }
                iM = iM == 0 ? this.hashArray.length - 1 : iM - 1;
            }
        }
    }

    public final Object[] g() {
        Object[] objArr = this.valuesArray;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArrArrayOfUninitializedElements = f.arrayOfUninitializedElements(this.keysArray.length);
        this.valuesArray = objArrArrayOfUninitializedElements;
        return objArrArrayOfUninitializedElements;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int iK = k(obj);
        if (iK < 0) {
            return null;
        }
        Object[] objArr = this.valuesArray;
        E.c(objArr);
        return objArr[iK];
    }

    public Set<Map.Entry<Object, Object>> getEntries() {
        n nVar = this.entriesView;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this);
        this.entriesView = nVar2;
        return nVar2;
    }

    public Set<Object> getKeys() {
        o oVar = this.keysView;
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(this);
        this.keysView = oVar2;
        return oVar2;
    }

    public Collection<Object> getValues() {
        p pVar = this.valuesView;
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this);
        this.valuesView = pVar2;
        return pVar2;
    }

    public final void h() {
        if (this.f97f) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        h hVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i5 = 0;
        while (hVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (hVarEntriesIterator$kotlin_stdlib.f95a >= hVarEntriesIterator$kotlin_stdlib.getMap$kotlin_stdlib().b) {
                throw new NoSuchElementException();
            }
            int i6 = hVarEntriesIterator$kotlin_stdlib.f95a;
            hVarEntriesIterator$kotlin_stdlib.f95a = i6 + 1;
            hVarEntriesIterator$kotlin_stdlib.b = i6;
            Object obj = hVarEntriesIterator$kotlin_stdlib.getMap$kotlin_stdlib().keysArray[hVarEntriesIterator$kotlin_stdlib.b];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = hVarEntriesIterator$kotlin_stdlib.getMap$kotlin_stdlib().valuesArray;
            E.c(objArr);
            Object obj2 = objArr[hVarEntriesIterator$kotlin_stdlib.b];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            hVarEntriesIterator$kotlin_stdlib.c();
            i5 += iHashCode ^ iHashCode2;
        }
        return i5;
    }

    public final void i(boolean z6) {
        int i5;
        Object[] objArr = this.valuesArray;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i5 = this.b;
            if (i6 >= i5) {
                break;
            }
            int[] iArr = this.presenceArray;
            int i8 = iArr[i6];
            if (i8 >= 0) {
                Object[] objArr2 = this.keysArray;
                objArr2[i7] = objArr2[i6];
                if (objArr != null) {
                    objArr[i7] = objArr[i6];
                }
                if (z6) {
                    iArr[i7] = i8;
                    this.hashArray[i8] = i7 + 1;
                }
                i7++;
            }
            i6++;
        }
        f.resetRange(this.keysArray, i7, i5);
        if (objArr != null) {
            f.resetRange(objArr, i7, this.b);
        }
        this.b = i7;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.e == 0;
    }

    public final void j(int i5) {
        Object[] objArr = this.keysArray;
        int length = objArr.length;
        int i6 = this.b;
        int i7 = length - i6;
        int i8 = i6 - this.e;
        if (i7 < i5 && i7 + i8 >= i5 && i8 >= objArr.length / 4) {
            i(true);
            return;
        }
        int i9 = i6 + i5;
        if (i9 < 0) {
            throw new OutOfMemoryError();
        }
        if (i9 > objArr.length) {
            C0136d c0136d = AbstractC0139g.Companion;
            int length2 = objArr.length;
            c0136d.getClass();
            int iE = C0136d.e(length2, i9);
            this.keysArray = f.copyOfUninitializedElements(this.keysArray, iE);
            Object[] objArr2 = this.valuesArray;
            this.valuesArray = objArr2 != null ? f.copyOfUninitializedElements(objArr2, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iE);
            E.e(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            Companion.getClass();
            int iHighestOneBit = Integer.highestOneBit((iE >= 1 ? iE : 1) * 3);
            if (iHighestOneBit > this.hashArray.length) {
                n(iHighestOneBit);
            }
        }
    }

    public final int k(Object obj) {
        int iM = m(obj);
        int i5 = this.f96a;
        while (true) {
            int i6 = this.hashArray[iM];
            if (i6 == 0) {
                return -1;
            }
            if (i6 > 0) {
                int i7 = i6 - 1;
                if (E.a(this.keysArray[i7], obj)) {
                    return i7;
                }
            }
            i5--;
            if (i5 < 0) {
                return -1;
            }
            iM = iM == 0 ? this.hashArray.length - 1 : iM - 1;
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return getKeys();
    }

    public final k keysIterator$kotlin_stdlib() {
        return new k(this);
    }

    public final int l(Object obj) {
        int i5 = this.b;
        while (true) {
            i5--;
            if (i5 < 0) {
                return -1;
            }
            if (this.presenceArray[i5] >= 0) {
                Object[] objArr = this.valuesArray;
                E.c(objArr);
                if (E.a(objArr[i5], obj)) {
                    return i5;
                }
            }
        }
    }

    public final int m(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.c;
    }

    public final void n(int i5) {
        int[] iArr;
        this.d++;
        int i6 = 0;
        if (this.b > this.e) {
            i(false);
        }
        this.hashArray = new int[i5];
        Companion.getClass();
        this.c = Integer.numberOfLeadingZeros(i5) + 1;
        while (i6 < this.b) {
            int i7 = i6 + 1;
            int iM = m(this.keysArray[i6]);
            int i8 = this.f96a;
            while (true) {
                iArr = this.hashArray;
                if (iArr[iM] == 0) {
                    break;
                }
                i8--;
                if (i8 < 0) {
                    throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                }
                iM = iM == 0 ? iArr.length - 1 : iM - 1;
            }
            iArr[iM] = i7;
            this.presenceArray[i6] = iM;
            i6 = i7;
        }
    }

    public final void o(int i5) {
        f.resetAt(this.keysArray, i5);
        Object[] objArr = this.valuesArray;
        if (objArr != null) {
            f.resetAt(objArr, i5);
        }
        int length = this.presenceArray[i5];
        int i6 = this.f96a * 2;
        int length2 = this.hashArray.length / 2;
        if (i6 > length2) {
            i6 = length2;
        }
        int i7 = i6;
        int i8 = 0;
        int i9 = length;
        do {
            length = length == 0 ? this.hashArray.length - 1 : length - 1;
            i8++;
            if (i8 > this.f96a) {
                this.hashArray[i9] = 0;
            } else {
                int[] iArr = this.hashArray;
                int i10 = iArr[length];
                if (i10 == 0) {
                    iArr[i9] = 0;
                } else {
                    if (i10 < 0) {
                        iArr[i9] = -1;
                    } else {
                        int i11 = i10 - 1;
                        int iM = m(this.keysArray[i11]) - length;
                        int[] iArr2 = this.hashArray;
                        if ((iM & (iArr2.length - 1)) >= i8) {
                            iArr2[i9] = i10;
                            this.presenceArray[i11] = i9;
                        }
                        i7--;
                    }
                    i9 = length;
                    i8 = 0;
                    i7--;
                }
            }
            this.presenceArray[i5] = -1;
            this.e--;
            this.d++;
        } while (i7 >= 0);
        this.hashArray[i9] = -1;
        this.presenceArray[i5] = -1;
        this.e--;
        this.d++;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        h();
        int iF = f(obj);
        Object[] objArrG = g();
        if (iF >= 0) {
            objArrG[iF] = obj2;
            return null;
        }
        int i5 = (-iF) - 1;
        Object obj3 = objArrG[i5];
        objArrG[i5] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public void putAll(Map<Object, Object> from) {
        E.f(from, "from");
        h();
        Set<Map.Entry<Object, Object>> setEntrySet = from.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        j(setEntrySet.size());
        for (Map.Entry<Object, Object> entry : setEntrySet) {
            int iF = f(entry.getKey());
            Object[] objArrG = g();
            if (iF >= 0) {
                objArrG[iF] = entry.getValue();
            } else {
                int i5 = (-iF) - 1;
                if (!E.a(entry.getValue(), objArrG[i5])) {
                    objArrG[i5] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        h();
        int iK = k(obj);
        if (iK < 0) {
            return null;
        }
        Object[] objArr = this.valuesArray;
        E.c(objArr);
        Object obj2 = objArr[iK];
        o(iK);
        return obj2;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<Object, Object> entry) {
        E.f(entry, "entry");
        h();
        int iK = k(entry.getKey());
        if (iK < 0) {
            return false;
        }
        Object[] objArr = this.valuesArray;
        E.c(objArr);
        if (!E.a(objArr[iK], entry.getValue())) {
            return false;
        }
        o(iK);
        return true;
    }

    @Override // java.util.Map
    public final int size() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.e * 3) + 2);
        sb.append(VectorFormat.DEFAULT_PREFIX);
        h hVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i5 = 0;
        while (hVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i5 > 0) {
                sb.append(", ");
            }
            hVarEntriesIterator$kotlin_stdlib.nextAppendString(sb);
            i5++;
        }
        sb.append(VectorFormat.DEFAULT_SUFFIX);
        String string = sb.toString();
        E.e(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }

    public final l valuesIterator$kotlin_stdlib() {
        return new l(this);
    }

    public m(int i5) {
        Object[] objArrArrayOfUninitializedElements = f.arrayOfUninitializedElements(i5);
        int[] iArr = new int[i5];
        Companion.getClass();
        int iHighestOneBit = Integer.highestOneBit((i5 < 1 ? 1 : i5) * 3);
        this.keysArray = objArrArrayOfUninitializedElements;
        this.valuesArray = null;
        this.presenceArray = iArr;
        this.hashArray = new int[iHighestOneBit];
        this.f96a = 2;
        this.b = 0;
        this.c = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
