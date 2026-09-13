package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdo implements zzhh {
    private final zzdn zza;

    private zzdo(zzdn zzdnVar) {
        byte[] bArr = zzep.zzb;
        this.zza = zzdnVar;
        zzdnVar.zza = this;
    }

    public static zzdo zza(zzdn zzdnVar) {
        zzdo zzdoVar = zzdnVar.zza;
        return zzdoVar != null ? zzdoVar : new zzdo(zzdnVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzA(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzfb)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Long) list.get(i8)).getClass();
                i7 += 8;
            }
            this.zza.zzt(i7);
            while (i6 < list.size()) {
                this.zza.zzi(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z6) {
            while (i6 < zzfbVar.size()) {
                this.zza.zzh(i5, zzfbVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzfbVar.size(); i10++) {
            zzfbVar.zze(i10);
            i9 += 8;
        }
        this.zza.zzt(i9);
        while (i6 < zzfbVar.size()) {
            this.zza.zzi(zzfbVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzB(int i5, int i6) {
        this.zza.zzs(i5, (i6 >> 31) ^ (i6 + i6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzC(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzei)) {
            if (!z6) {
                while (i6 < list.size()) {
                    zzdn zzdnVar = this.zza;
                    int iIntValue = ((Integer) list.get(i6)).intValue();
                    zzdnVar.zzs(i5, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int iZzA = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int iIntValue2 = ((Integer) list.get(i7)).intValue();
                iZzA += zzdn.zzA((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzt(iZzA);
            while (i6 < list.size()) {
                zzdn zzdnVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i6)).intValue();
                zzdnVar2.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i6++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z6) {
            while (i6 < zzeiVar.size()) {
                zzdn zzdnVar3 = this.zza;
                int iZze = zzeiVar.zze(i6);
                zzdnVar3.zzs(i5, (iZze >> 31) ^ (iZze + iZze));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int iZzA2 = 0;
        for (int i8 = 0; i8 < zzeiVar.size(); i8++) {
            int iZze2 = zzeiVar.zze(i8);
            iZzA2 += zzdn.zzA((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzt(iZzA2);
        while (i6 < zzeiVar.size()) {
            zzdn zzdnVar4 = this.zza;
            int iZze3 = zzeiVar.zze(i6);
            zzdnVar4.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzD(int i5, long j6) {
        this.zza.zzu(i5, (j6 >> 63) ^ (j6 + j6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzE(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzfb)) {
            if (!z6) {
                while (i6 < list.size()) {
                    zzdn zzdnVar = this.zza;
                    long jLongValue = ((Long) list.get(i6)).longValue();
                    zzdnVar.zzu(i5, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int iZzB = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long jLongValue2 = ((Long) list.get(i7)).longValue();
                iZzB += zzdn.zzB((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzt(iZzB);
            while (i6 < list.size()) {
                zzdn zzdnVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i6)).longValue();
                zzdnVar2.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i6++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z6) {
            while (i6 < zzfbVar.size()) {
                zzdn zzdnVar3 = this.zza;
                long jZze = zzfbVar.zze(i6);
                zzdnVar3.zzu(i5, (jZze >> 63) ^ (jZze + jZze));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int iZzB2 = 0;
        for (int i8 = 0; i8 < zzfbVar.size(); i8++) {
            long jZze2 = zzfbVar.zze(i8);
            iZzB2 += zzdn.zzB((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzt(iZzB2);
        while (i6 < zzfbVar.size()) {
            zzdn zzdnVar4 = this.zza;
            long jZze3 = zzfbVar.zze(i6);
            zzdnVar4.zzv((jZze3 >> 63) ^ (jZze3 + jZze3));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    @Deprecated
    public final void zzF(int i5) {
        this.zza.zzr(i5, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzG(int i5, String str) {
        this.zza.zzp(i5, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzH(int i5, List list) {
        int i6 = 0;
        if (!(list instanceof zzey)) {
            while (i6 < list.size()) {
                this.zza.zzp(i5, (String) list.get(i6));
                i6++;
            }
            return;
        }
        zzey zzeyVar = (zzey) list;
        while (i6 < list.size()) {
            Object objZza = zzeyVar.zza();
            if (objZza instanceof String) {
                this.zza.zzp(i5, (String) objZza);
            } else {
                this.zza.zze(i5, (zzdf) objZza);
            }
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzI(int i5, int i6) {
        this.zza.zzs(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzJ(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzei)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzs(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int iZzA = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzA += zzdn.zzA(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i6 < list.size()) {
                this.zza.zzt(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z6) {
            while (i6 < zzeiVar.size()) {
                this.zza.zzs(i5, zzeiVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int iZzA2 = 0;
        for (int i8 = 0; i8 < zzeiVar.size(); i8++) {
            iZzA2 += zzdn.zzA(zzeiVar.zze(i8));
        }
        this.zza.zzt(iZzA2);
        while (i6 < zzeiVar.size()) {
            this.zza.zzt(zzeiVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzK(int i5, long j6) {
        this.zza.zzu(i5, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzL(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzfb)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzu(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int iZzB = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzB += zzdn.zzB(((Long) list.get(i7)).longValue());
            }
            this.zza.zzt(iZzB);
            while (i6 < list.size()) {
                this.zza.zzv(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z6) {
            while (i6 < zzfbVar.size()) {
                this.zza.zzu(i5, zzfbVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int iZzB2 = 0;
        for (int i8 = 0; i8 < zzfbVar.size(); i8++) {
            iZzB2 += zzdn.zzB(zzfbVar.zze(i8));
        }
        this.zza.zzt(iZzB2);
        while (i6 < zzfbVar.size()) {
            this.zza.zzv(zzfbVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzb(int i5, boolean z6) {
        this.zza.zzd(i5, z6);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzc(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzcw)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzd(i5, ((Boolean) list.get(i6)).booleanValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Boolean) list.get(i8)).getClass();
                i7++;
            }
            this.zza.zzt(i7);
            while (i6 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : (byte) 0);
                i6++;
            }
            return;
        }
        zzcw zzcwVar = (zzcw) list;
        if (!z6) {
            while (i6 < zzcwVar.size()) {
                this.zza.zzd(i5, zzcwVar.zzf(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzcwVar.size(); i10++) {
            zzcwVar.zzf(i10);
            i9++;
        }
        this.zza.zzt(i9);
        while (i6 < zzcwVar.size()) {
            this.zza.zzb(zzcwVar.zzf(i6) ? (byte) 1 : (byte) 0);
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzd(int i5, zzdf zzdfVar) {
        this.zza.zze(i5, zzdfVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zze(int i5, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.zza.zze(i5, (zzdf) list.get(i6));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzf(int i5, double d) {
        this.zza.zzh(i5, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzg(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzdp)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Double) list.get(i8)).getClass();
                i7 += 8;
            }
            this.zza.zzt(i7);
            while (i6 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                i6++;
            }
            return;
        }
        zzdp zzdpVar = (zzdp) list;
        if (!z6) {
            while (i6 < zzdpVar.size()) {
                this.zza.zzh(i5, Double.doubleToRawLongBits(zzdpVar.zze(i6)));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzdpVar.size(); i10++) {
            zzdpVar.zze(i10);
            i9 += 8;
        }
        this.zza.zzt(i9);
        while (i6 < zzdpVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzdpVar.zze(i6)));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    @Deprecated
    public final void zzh(int i5) {
        this.zza.zzr(i5, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzi(int i5, int i6) {
        this.zza.zzj(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzj(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzei)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzj(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int iZzB = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzB += zzdn.zzB(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzt(iZzB);
            while (i6 < list.size()) {
                this.zza.zzk(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z6) {
            while (i6 < zzeiVar.size()) {
                this.zza.zzj(i5, zzeiVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int iZzB2 = 0;
        for (int i8 = 0; i8 < zzeiVar.size(); i8++) {
            iZzB2 += zzdn.zzB(zzeiVar.zze(i8));
        }
        this.zza.zzt(iZzB2);
        while (i6 < zzeiVar.size()) {
            this.zza.zzk(zzeiVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzk(int i5, int i6) {
        this.zza.zzf(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzl(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzei)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzf(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).getClass();
                i7 += 4;
            }
            this.zza.zzt(i7);
            while (i6 < list.size()) {
                this.zza.zzg(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z6) {
            while (i6 < zzeiVar.size()) {
                this.zza.zzf(i5, zzeiVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzeiVar.size(); i10++) {
            zzeiVar.zze(i10);
            i9 += 4;
        }
        this.zza.zzt(i9);
        while (i6 < zzeiVar.size()) {
            this.zza.zzg(zzeiVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzm(int i5, long j6) {
        this.zza.zzh(i5, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzn(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzfb)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Long) list.get(i8)).getClass();
                i7 += 8;
            }
            this.zza.zzt(i7);
            while (i6 < list.size()) {
                this.zza.zzi(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z6) {
            while (i6 < zzfbVar.size()) {
                this.zza.zzh(i5, zzfbVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzfbVar.size(); i10++) {
            zzfbVar.zze(i10);
            i9 += 8;
        }
        this.zza.zzt(i9);
        while (i6 < zzfbVar.size()) {
            this.zza.zzi(zzfbVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzo(int i5, float f6) {
        this.zza.zzf(i5, Float.floatToRawIntBits(f6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzp(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzdz)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzf(i5, Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Float) list.get(i8)).getClass();
                i7 += 4;
            }
            this.zza.zzt(i7);
            while (i6 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                i6++;
            }
            return;
        }
        zzdz zzdzVar = (zzdz) list;
        if (!z6) {
            while (i6 < zzdzVar.size()) {
                this.zza.zzf(i5, Float.floatToRawIntBits(zzdzVar.zze(i6)));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzdzVar.size(); i10++) {
            zzdzVar.zze(i10);
            i9 += 4;
        }
        this.zza.zzt(i9);
        while (i6 < zzdzVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzdzVar.zze(i6)));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzq(int i5, Object obj, zzge zzgeVar) {
        zzdn zzdnVar = this.zza;
        zzdnVar.zzr(i5, 3);
        zzgeVar.zzi((zzfm) obj, zzdnVar.zza);
        zzdnVar.zzr(i5, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzr(int i5, int i6) {
        this.zza.zzj(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzs(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzei)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzj(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int iZzB = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzB += zzdn.zzB(((Integer) list.get(i7)).intValue());
            }
            this.zza.zzt(iZzB);
            while (i6 < list.size()) {
                this.zza.zzk(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z6) {
            while (i6 < zzeiVar.size()) {
                this.zza.zzj(i5, zzeiVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int iZzB2 = 0;
        for (int i8 = 0; i8 < zzeiVar.size(); i8++) {
            iZzB2 += zzdn.zzB(zzeiVar.zze(i8));
        }
        this.zza.zzt(iZzB2);
        while (i6 < zzeiVar.size()) {
            this.zza.zzk(zzeiVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzt(int i5, long j6) {
        this.zza.zzu(i5, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzu(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzfb)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzu(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int iZzB = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzB += zzdn.zzB(((Long) list.get(i7)).longValue());
            }
            this.zza.zzt(iZzB);
            while (i6 < list.size()) {
                this.zza.zzv(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z6) {
            while (i6 < zzfbVar.size()) {
                this.zza.zzu(i5, zzfbVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int iZzB2 = 0;
        for (int i8 = 0; i8 < zzfbVar.size(); i8++) {
            iZzB2 += zzdn.zzB(zzfbVar.zze(i8));
        }
        this.zza.zzt(iZzB2);
        while (i6 < zzfbVar.size()) {
            this.zza.zzv(zzfbVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzv(int i5, Object obj, zzge zzgeVar) {
        this.zza.zzm(i5, (zzfm) obj, zzgeVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzw(int i5, Object obj) {
        if (obj instanceof zzdf) {
            this.zza.zzo(i5, (zzdf) obj);
        } else {
            this.zza.zzn(i5, (zzfm) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzx(int i5, int i6) {
        this.zza.zzf(i5, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzy(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzei)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzf(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            this.zza.zzr(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).getClass();
                i7 += 4;
            }
            this.zza.zzt(i7);
            while (i6 < list.size()) {
                this.zza.zzg(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z6) {
            while (i6 < zzeiVar.size()) {
                this.zza.zzf(i5, zzeiVar.zze(i6));
                i6++;
            }
            return;
        }
        this.zza.zzr(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzeiVar.size(); i10++) {
            zzeiVar.zze(i10);
            i9 += 4;
        }
        this.zza.zzt(i9);
        while (i6 < zzeiVar.size()) {
            this.zza.zzg(zzeiVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzz(int i5, long j6) {
        this.zza.zzh(i5, j6);
    }
}
