package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class zbwh extends AbstractMap {
    private Object[] zba;
    private int zbb;
    private Map zbc;
    private boolean zbd;
    private volatile zbwf zbe;
    private Map zbf;

    private zbwh() {
        Map map = Collections.EMPTY_MAP;
        this.zbc = map;
        this.zbf = map;
    }

    private final int zbl(Comparable comparable) {
        int i5 = this.zbb;
        int i6 = i5 - 1;
        int i7 = 0;
        if (i6 >= 0) {
            int iCompareTo = comparable.compareTo(((zbwb) this.zba[i6]).zba());
            if (iCompareTo > 0) {
                return -(i5 + 1);
            }
            if (iCompareTo == 0) {
                return i6;
            }
        }
        while (i7 <= i6) {
            int i8 = (i7 + i6) / 2;
            int iCompareTo2 = comparable.compareTo(((zbwb) this.zba[i8]).zba());
            if (iCompareTo2 < 0) {
                i6 = i8 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i8;
                }
                i7 = i8 + 1;
            }
        }
        return -(i7 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zbm(int i5) {
        zbo();
        Object value = ((zbwb) this.zba[i5]).getValue();
        Object[] objArr = this.zba;
        System.arraycopy(objArr, i5 + 1, objArr, i5, (this.zbb - i5) - 1);
        this.zbb--;
        if (!this.zbc.isEmpty()) {
            Iterator it = zbn().entrySet().iterator();
            Object[] objArr2 = this.zba;
            int i6 = this.zbb;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i6] = new zbwb(this, (Comparable) entry.getKey(), entry.getValue());
            this.zbb++;
            it.remove();
        }
        return value;
    }

    private final SortedMap zbn() {
        zbo();
        if (this.zbc.isEmpty() && !(this.zbc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zbc = treeMap;
            this.zbf = treeMap.descendingMap();
        }
        return (SortedMap) this.zbc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zbo() {
        if (this.zbd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zbo();
        if (this.zbb != 0) {
            this.zba = null;
            this.zbb = 0;
        }
        if (this.zbc.isEmpty()) {
            return;
        }
        this.zbc.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zbl(comparable) >= 0 || this.zbc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zbe == null) {
            this.zbe = new zbwf(this, null);
        }
        return this.zbe;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zbwh)) {
            return super.equals(obj);
        }
        zbwh zbwhVar = (zbwh) obj;
        int size = size();
        if (size != zbwhVar.size()) {
            return false;
        }
        int i5 = this.zbb;
        if (i5 != zbwhVar.zbb) {
            return entrySet().equals(zbwhVar.entrySet());
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!zbg(i6).equals(zbwhVar.zbg(i6))) {
                return false;
            }
        }
        if (i5 != size) {
            return this.zbc.equals(zbwhVar.zbc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZbl = zbl(comparable);
        return iZbl >= 0 ? ((zbwb) this.zba[iZbl]).getValue() : this.zbc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i5 = this.zbb;
        int iHashCode = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode += this.zba[i6].hashCode();
        }
        return this.zbc.size() > 0 ? this.zbc.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zbo();
        Comparable comparable = (Comparable) obj;
        int iZbl = zbl(comparable);
        if (iZbl >= 0) {
            return zbm(iZbl);
        }
        if (this.zbc.isEmpty()) {
            return null;
        }
        return this.zbc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zbc.size() + this.zbb;
    }

    public void zba() {
        if (this.zbd) {
            return;
        }
        this.zbc = this.zbc.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zbc);
        this.zbf = this.zbf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zbf);
        this.zbd = true;
    }

    public final int zbc() {
        return this.zbb;
    }

    public final Iterable zbd() {
        return this.zbc.isEmpty() ? Collections.EMPTY_SET : this.zbc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zbf, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zbo();
        int iZbl = zbl(comparable);
        if (iZbl >= 0) {
            return ((zbwb) this.zba[iZbl]).setValue(obj);
        }
        zbo();
        if (this.zba == null) {
            this.zba = new Object[16];
        }
        int i5 = -(iZbl + 1);
        if (i5 >= 16) {
            return zbn().put(comparable, obj);
        }
        if (this.zbb == 16) {
            zbwb zbwbVar = (zbwb) this.zba[15];
            this.zbb = 15;
            zbn().put(zbwbVar.zba(), zbwbVar.getValue());
        }
        Object[] objArr = this.zba;
        int length = objArr.length;
        System.arraycopy(objArr, i5, objArr, i5 + 1, 15 - i5);
        this.zba[i5] = new zbwb(this, comparable, obj);
        this.zbb++;
        return null;
    }

    public final Map.Entry zbg(int i5) {
        if (i5 < this.zbb) {
            return (zbwb) this.zba[i5];
        }
        throw new ArrayIndexOutOfBoundsException(i5);
    }

    public final boolean zbj() {
        return this.zbd;
    }

    public /* synthetic */ zbwh(zbwg zbwgVar) {
        Map map = Collections.EMPTY_MAP;
        this.zbc = map;
        this.zbf = map;
    }
}
