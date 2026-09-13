package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class zzak extends zzai implements List {
    final /* synthetic */ zzal zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzak(zzal zzalVar, Object obj, List list, zzai zzaiVar) {
        super(zzalVar, obj, list, zzaiVar);
        this.zzf = zzalVar;
    }

    @Override // java.util.List
    public final void add(int i5, Object obj) {
        zzb();
        boolean zIsEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i5, obj);
        this.zzf.zzb++;
        if (zIsEmpty) {
            zza();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i5, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.zzb).addAll(i5, collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = this.zzb.size();
        this.zzf.zzb += size2 - size;
        if (size != 0) {
            return zAddAll;
        }
        zza();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        zzb();
        return ((List) this.zzb).get(i5);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zzb();
        return new zzaj(this);
    }

    @Override // java.util.List
    public final Object remove(int i5) {
        zzb();
        Object objRemove = ((List) this.zzb).remove(i5);
        this.zzf.zzb--;
        zzc();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i5, Object obj) {
        zzb();
        return ((List) this.zzb).set(i5, obj);
    }

    @Override // java.util.List
    public final List subList(int i5, int i6) {
        zzb();
        List listSubList = ((List) this.zzb).subList(i5, i6);
        zzai zzaiVar = this.zzc;
        if (zzaiVar == null) {
            zzaiVar = this;
        }
        return this.zzf.zzf(this.zza, listSubList, zzaiVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i5) {
        zzb();
        return new zzaj(this, i5);
    }
}
