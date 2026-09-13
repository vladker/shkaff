package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class zzii extends AbstractMap {
    private Object[] zza;
    private int zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzig zze;
    private Map zzf;

    private zzii() {
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }

    private final int zzl(zzgg zzggVar) {
        int i5 = this.zzb;
        int i6 = i5 - 1;
        int i7 = 0;
        if (i6 >= 0) {
            int iCompareTo = zzggVar.compareTo(((zzie) this.zza[i6]).zza());
            if (iCompareTo > 0) {
                return -(i5 + 1);
            }
            if (iCompareTo == 0) {
                return i6;
            }
        }
        while (i7 <= i6) {
            int i8 = (i7 + i6) / 2;
            int iCompareTo2 = zzggVar.compareTo(((zzie) this.zza[i8]).zza());
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
    public final Object zzm(int i5) {
        zzo();
        Object value = ((zzie) this.zza[i5]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i5 + 1, objArr, i5, (this.zzb - i5) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator it = zzn().entrySet().iterator();
            Object[] objArr2 = this.zza;
            int i6 = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i6] = new zzie(this, (zzgg) entry.getKey(), entry.getValue());
            this.zzb++;
            it.remove();
        }
        return value;
    }

    private final SortedMap zzn() {
        zzo();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzo();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        zzgg zzggVar = (zzgg) obj;
        return zzl(zzggVar) >= 0 || this.zzc.containsKey(zzggVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzig(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzii)) {
            return super.equals(obj);
        }
        zzii zziiVar = (zzii) obj;
        int size = size();
        if (size != zziiVar.size()) {
            return false;
        }
        int i5 = this.zzb;
        if (i5 != zziiVar.zzb) {
            return entrySet().equals(zziiVar.entrySet());
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!zzg(i6).equals(zziiVar.zzg(i6))) {
                return false;
            }
        }
        if (i5 != size) {
            return this.zzc.equals(zziiVar.zzc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzgg zzggVar = (zzgg) obj;
        int iZzl = zzl(zzggVar);
        return iZzl >= 0 ? ((zzie) this.zza[iZzl]).getValue() : this.zzc.get(zzggVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i5 = this.zzb;
        int iHashCode = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode += this.zza[i6].hashCode();
        }
        return this.zzc.size() > 0 ? this.zzc.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzo();
        zzgg zzggVar = (zzgg) obj;
        int iZzl = zzl(zzggVar);
        if (iZzl >= 0) {
            return zzm(iZzl);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(zzggVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzc.size() + this.zzb;
    }

    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final Iterable zzd() {
        return this.zzc.isEmpty() ? Collections.EMPTY_SET : this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final Object put(zzgg zzggVar, Object obj) {
        zzo();
        int iZzl = zzl(zzggVar);
        if (iZzl >= 0) {
            return ((zzie) this.zza[iZzl]).setValue(obj);
        }
        zzo();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i5 = -(iZzl + 1);
        if (i5 >= 16) {
            return zzn().put(zzggVar, obj);
        }
        if (this.zzb == 16) {
            zzie zzieVar = (zzie) this.zza[15];
            this.zzb = 15;
            zzn().put(zzieVar.zza(), zzieVar.getValue());
        }
        Object[] objArr = this.zza;
        int length = objArr.length;
        System.arraycopy(objArr, i5, objArr, i5 + 1, 15 - i5);
        this.zza[i5] = new zzie(this, zzggVar, obj);
        this.zzb++;
        return null;
    }

    public final Map.Entry zzg(int i5) {
        if (i5 < this.zzb) {
            return (zzie) this.zza[i5];
        }
        throw new ArrayIndexOutOfBoundsException(i5);
    }

    public final boolean zzj() {
        return this.zzd;
    }

    public /* synthetic */ zzii(zzih zzihVar) {
        Map map = Collections.EMPTY_MAP;
        this.zzc = map;
        this.zzf = map;
    }
}
