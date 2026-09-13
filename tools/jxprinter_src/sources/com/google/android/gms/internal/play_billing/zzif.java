package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzif implements Iterator {
    final /* synthetic */ zzii zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzif(zzii zziiVar, zzih zzihVar) {
        Objects.requireNonNull(zziiVar);
        this.zza = zziiVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5 = this.zzb + 1;
        zzii zziiVar = this.zza;
        if (i5 >= zziiVar.zzb) {
            return !zziiVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i5 = this.zzb + 1;
        this.zzb = i5;
        zzii zziiVar = this.zza;
        return i5 < zziiVar.zzb ? (zzie) zziiVar.zza[i5] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzii zziiVar = this.zza;
        zziiVar.zzo();
        int i5 = this.zzb;
        if (i5 >= zziiVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i5 - 1;
            zziiVar.zzm(i5);
        }
    }
}
