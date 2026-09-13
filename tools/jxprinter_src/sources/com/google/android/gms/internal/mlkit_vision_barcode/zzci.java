package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzci extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    public zzci() {
        zzp(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] zzA() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzC() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public static /* synthetic */ Object zzg(zzci zzciVar, int i5) {
        return zzciVar.zzB()[i5];
    }

    public static /* synthetic */ Object zzi(zzci zzciVar) {
        Object obj = zzciVar.zze;
        Objects.requireNonNull(obj);
        return obj;
    }

    public static /* synthetic */ Object zzj(zzci zzciVar, int i5) {
        return zzciVar.zzC()[i5];
    }

    public static /* synthetic */ void zzn(zzci zzciVar, int i5, Object obj) {
        zzciVar.zzC()[i5] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzw(Object obj) {
        if (zzr()) {
            return -1;
        }
        int iZza = zzck.zza(obj);
        int iZzv = zzv();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int iZzc = zzcj.zzc(obj2, iZza & iZzv);
        if (iZzc != 0) {
            int i5 = ~iZzv;
            int i6 = iZza & i5;
            do {
                int i7 = iZzc - 1;
                int i8 = zzA()[i7];
                if ((i8 & i5) == i6 && zzax.zza(obj, zzB()[i7])) {
                    return i7;
                }
                iZzc = i8 & iZzv;
            } while (iZzc != 0);
        }
        return -1;
    }

    private final int zzx(int i5, int i6, int i7, int i8) {
        int i9 = i6 - 1;
        Object objZzd = zzcj.zzd(i6);
        if (i8 != 0) {
            zzcj.zze(objZzd, i7 & i9, i8 + 1);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        for (int i10 = 0; i10 <= i5; i10++) {
            int iZzc = zzcj.zzc(obj, i10);
            while (iZzc != 0) {
                int i11 = iZzc - 1;
                int i12 = iArrZzA[i11];
                int i13 = ((~i5) & i12) | i10;
                int i14 = i13 & i9;
                int iZzc2 = zzcj.zzc(objZzd, i14);
                zzcj.zze(objZzd, i14, iZzc);
                iArrZzA[i11] = ((~i9) & i13) | (iZzc2 & i9);
                iZzc = i12 & i5;
            }
        }
        this.zze = objZzd;
        zzz(i9);
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzy(Object obj) {
        if (!zzr()) {
            int iZzv = zzv();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int iZzb = zzcj.zzb(obj, null, iZzv, obj2, zzA(), zzB(), null);
            if (iZzb != -1) {
                Object obj3 = zzC()[iZzb];
                zzq(iZzb, iZzv);
                this.zzg--;
                zzo();
                return obj3;
            }
        }
        return zzd;
    }

    private final void zzz(int i5) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i5)) & 31) | (this.zzf & (-32));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzr()) {
            return;
        }
        zzo();
        Map mapZzl = zzl();
        if (mapZzl != null) {
            this.zzf = zzdw.zza(size(), 3, 1073741823);
            mapZzl.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzB(), 0, this.zzg, (Object) null);
        Arrays.fill(zzC(), 0, this.zzg, (Object) null);
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(zzA(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.containsKey(obj);
        }
        return zzw(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.containsValue(obj);
        }
        for (int i5 = 0; i5 < this.zzg; i5++) {
            if (zzax.zza(obj, zzC()[i5])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzcc zzccVar = new zzcc(this);
        this.zzi = zzccVar;
        return zzccVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.get(obj);
        }
        int iZzw = zzw(obj);
        if (iZzw == -1) {
            return null;
        }
        return zzC()[iZzw];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzcf zzcfVar = new zzcf(this);
        this.zzh = zzcfVar;
        return zzcfVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i5;
        if (zzr()) {
            zzaz.zzf(zzr(), "Arrays already allocated");
            int i6 = this.zzf;
            int iMax = Math.max(i6 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzcj.zzd(iMax2);
            zzz(iMax2 - 1);
            this.zza = new int[i6];
            this.zzb = new Object[i6];
            this.zzc = new Object[i6];
        }
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.put(obj, obj2);
        }
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int i7 = this.zzg;
        int i8 = i7 + 1;
        int iZza = zzck.zza(obj);
        int iZzv = zzv();
        int i9 = iZza & iZzv;
        Object obj3 = this.zze;
        Objects.requireNonNull(obj3);
        int iZzc = zzcj.zzc(obj3, i9);
        if (iZzc == 0) {
            if (i8 > iZzv) {
                iZzv = zzx(iZzv, zzcj.zza(iZzv), iZza, i7);
            } else {
                Object obj4 = this.zze;
                Objects.requireNonNull(obj4);
                zzcj.zze(obj4, i9, i8);
            }
            i5 = 1;
        } else {
            int i10 = ~iZzv;
            int i11 = iZza & i10;
            int i12 = 0;
            while (true) {
                int i13 = iZzc - 1;
                int i14 = iArrZzA[i13];
                i5 = 1;
                int i15 = i14 & i10;
                if (i15 == i11 && zzax.zza(obj, objArrZzB[i13])) {
                    Object obj5 = objArrZzC[i13];
                    objArrZzC[i13] = obj2;
                    return obj5;
                }
                int i16 = i14 & iZzv;
                i12++;
                if (i16 == 0) {
                    if (i12 < 9) {
                        if (i8 <= iZzv) {
                            iArrZzA[i13] = (i8 & iZzv) | i15;
                            break;
                        }
                        iZzv = zzx(iZzv, zzcj.zza(iZzv), iZza, i7);
                        break;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                    int iZze = zze();
                    while (iZze >= 0) {
                        linkedHashMap.put(zzB()[iZze], zzC()[iZze]);
                        iZze = zzf(iZze);
                    }
                    this.zze = linkedHashMap;
                    this.zza = null;
                    this.zzb = null;
                    this.zzc = null;
                    zzo();
                    return linkedHashMap.put(obj, obj2);
                }
                iZzc = i16;
            }
        }
        int length = zzA().length;
        if (i8 > length) {
            int i17 = i5;
            int iMin = Math.min(1073741823, (Math.max(i17, length >>> 1) + length) | i17);
            if (iMin != length) {
                this.zza = Arrays.copyOf(zzA(), iMin);
                this.zzb = Arrays.copyOf(zzB(), iMin);
                this.zzc = Arrays.copyOf(zzC(), iMin);
            }
        }
        zzA()[i7] = (~iZzv) & iZza;
        zzB()[i7] = obj;
        zzC()[i7] = obj2;
        this.zzg = i8;
        zzo();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.remove(obj);
        }
        Object objZzy = zzy(obj);
        if (objZzy == zzd) {
            return null;
        }
        return objZzy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzl = zzl();
        return mapZzl != null ? mapZzl.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzch zzchVar = new zzch(this);
        this.zzj = zzchVar;
        return zzchVar;
    }

    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzf(int i5) {
        int i6 = i5 + 1;
        if (i6 < this.zzg) {
            return i6;
        }
        return -1;
    }

    public final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzo() {
        this.zzf += 32;
    }

    public final void zzp(int i5) {
        this.zzf = zzdw.zza(i5, 1, 1073741823);
    }

    public final void zzq(int i5, int i6) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int size = size();
        int i7 = size - 1;
        if (i5 >= i7) {
            objArrZzB[i5] = null;
            objArrZzC[i5] = null;
            iArrZzA[i5] = 0;
            return;
        }
        int i8 = i5 + 1;
        Object obj2 = objArrZzB[i7];
        objArrZzB[i5] = obj2;
        objArrZzC[i5] = objArrZzC[i7];
        objArrZzB[i7] = null;
        objArrZzC[i7] = null;
        iArrZzA[i5] = iArrZzA[i7];
        iArrZzA[i7] = 0;
        int iZza = zzck.zza(obj2) & i6;
        int iZzc = zzcj.zzc(obj, iZza);
        if (iZzc == size) {
            zzcj.zze(obj, iZza, i8);
            return;
        }
        while (true) {
            int i9 = iZzc - 1;
            int i10 = iArrZzA[i9];
            int i11 = i10 & i6;
            if (i11 == size) {
                iArrZzA[i9] = (i10 & (~i6)) | (i6 & i8);
                return;
            }
            iZzc = i11;
        }
    }

    public final boolean zzr() {
        return this.zze == null;
    }

    public zzci(int i5) {
        zzp(12);
    }
}
