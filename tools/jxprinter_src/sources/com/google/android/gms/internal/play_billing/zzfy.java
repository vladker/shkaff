package com.google.android.gms.internal.play_billing;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfy implements zzji {
    private final zzfx zza;

    private zzfy(zzfx zzfxVar) {
        this.zza = zzfxVar;
        zzfxVar.zza = this;
    }

    public static zzfy zza(zzfx zzfxVar) {
        Object obj = zzfxVar.zza;
        return obj != null ? (zzfy) obj : new zzfy(zzfxVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzA(int i5, long j6) {
        this.zza.zzj(i5, j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzB(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzhj)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzj(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Long) list.get(i8)).getClass();
                i7 += 8;
            }
            zzfxVar.zzu(i7);
            while (i6 < list.size()) {
                zzfxVar.zzk(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z6) {
            while (i6 < zzhjVar.size()) {
                this.zza.zzj(i5, zzhjVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzhjVar.size(); i10++) {
            zzhjVar.zze(i10);
            i9 += 8;
        }
        zzfxVar2.zzu(i9);
        while (i6 < zzhjVar.size()) {
            zzfxVar2.zzk(zzhjVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzC(int i5, int i6) {
        this.zza.zzt(i5, (i6 >> 31) ^ (i6 + i6));
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzD(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzgq)) {
            if (!z6) {
                while (i6 < list.size()) {
                    zzfx zzfxVar = this.zza;
                    int iIntValue = ((Integer) list.get(i6)).intValue();
                    zzfxVar.zzt(i5, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i6++;
                }
                return;
            }
            zzfx zzfxVar2 = this.zza;
            zzfxVar2.zzs(i5, 2);
            int iZzy = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int iIntValue2 = ((Integer) list.get(i7)).intValue();
                iZzy += zzfx.zzy((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzfxVar2.zzu(iZzy);
            while (i6 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i6)).intValue();
                zzfxVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i6++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z6) {
            while (i6 < zzgqVar.size()) {
                zzfx zzfxVar3 = this.zza;
                int iZze = zzgqVar.zze(i6);
                zzfxVar3.zzt(i5, (iZze >> 31) ^ (iZze + iZze));
                i6++;
            }
            return;
        }
        zzfx zzfxVar4 = this.zza;
        zzfxVar4.zzs(i5, 2);
        int iZzy2 = 0;
        for (int i8 = 0; i8 < zzgqVar.size(); i8++) {
            int iZze2 = zzgqVar.zze(i8);
            iZzy2 += zzfx.zzy((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzfxVar4.zzu(iZzy2);
        while (i6 < zzgqVar.size()) {
            int iZze3 = zzgqVar.zze(i6);
            zzfxVar4.zzu((iZze3 >> 31) ^ (iZze3 + iZze3));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzE(int i5, long j6) {
        this.zza.zzv(i5, (j6 >> 63) ^ (j6 + j6));
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzF(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzhj)) {
            if (!z6) {
                while (i6 < list.size()) {
                    zzfx zzfxVar = this.zza;
                    long jLongValue = ((Long) list.get(i6)).longValue();
                    zzfxVar.zzv(i5, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i6++;
                }
                return;
            }
            zzfx zzfxVar2 = this.zza;
            zzfxVar2.zzs(i5, 2);
            int iZzz = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long jLongValue2 = ((Long) list.get(i7)).longValue();
                iZzz += zzfx.zzz((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzfxVar2.zzu(iZzz);
            while (i6 < list.size()) {
                long jLongValue3 = ((Long) list.get(i6)).longValue();
                zzfxVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i6++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z6) {
            while (i6 < zzhjVar.size()) {
                zzfx zzfxVar3 = this.zza;
                long jZze = zzhjVar.zze(i6);
                zzfxVar3.zzv(i5, (jZze >> 63) ^ (jZze + jZze));
                i6++;
            }
            return;
        }
        zzfx zzfxVar4 = this.zza;
        zzfxVar4.zzs(i5, 2);
        int iZzz2 = 0;
        for (int i8 = 0; i8 < zzhjVar.size(); i8++) {
            long jZze2 = zzhjVar.zze(i8);
            iZzz2 += zzfx.zzz((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        zzfxVar4.zzu(iZzz2);
        while (i6 < zzhjVar.size()) {
            long jZze3 = zzhjVar.zze(i6);
            zzfxVar4.zzw((jZze3 >> 63) ^ (jZze3 + jZze3));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    @Deprecated
    public final void zzG(int i5) {
        this.zza.zzs(i5, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzH(int i5, String str) {
        this.zza.zzq(i5, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzI(int i5, List list) {
        int i6 = 0;
        if (!(list instanceof zzhd)) {
            while (i6 < list.size()) {
                this.zza.zzq(i5, (String) list.get(i6));
                i6++;
            }
            return;
        }
        zzhd zzhdVar = (zzhd) list;
        while (i6 < list.size()) {
            Object objZza = zzhdVar.zza();
            if (objZza instanceof String) {
                this.zza.zzq(i5, (String) objZza);
            } else {
                this.zza.zzf(i5, (zzfp) objZza);
            }
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzJ(int i5, int i6) {
        this.zza.zzt(i5, i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzK(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzgq)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzt(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int iZzy = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzy += zzfx.zzy(((Integer) list.get(i7)).intValue());
            }
            zzfxVar.zzu(iZzy);
            while (i6 < list.size()) {
                zzfxVar.zzu(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z6) {
            while (i6 < zzgqVar.size()) {
                this.zza.zzt(i5, zzgqVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int iZzy2 = 0;
        for (int i8 = 0; i8 < zzgqVar.size(); i8++) {
            iZzy2 += zzfx.zzy(zzgqVar.zze(i8));
        }
        zzfxVar2.zzu(iZzy2);
        while (i6 < zzgqVar.size()) {
            zzfxVar2.zzu(zzgqVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzL(int i5, long j6) {
        this.zza.zzv(i5, j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzM(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzhj)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzv(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int iZzz = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzz += zzfx.zzz(((Long) list.get(i7)).longValue());
            }
            zzfxVar.zzu(iZzz);
            while (i6 < list.size()) {
                zzfxVar.zzw(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z6) {
            while (i6 < zzhjVar.size()) {
                this.zza.zzv(i5, zzhjVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int iZzz2 = 0;
        for (int i8 = 0; i8 < zzhjVar.size(); i8++) {
            iZzz2 += zzfx.zzz(zzhjVar.zze(i8));
        }
        zzfxVar2.zzu(iZzz2);
        while (i6 < zzhjVar.size()) {
            zzfxVar2.zzw(zzhjVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzb(int i5, boolean z6) {
        this.zza.zzd(i5, z6);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzc(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzff)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzd(i5, ((Boolean) list.get(i6)).booleanValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Boolean) list.get(i8)).getClass();
                i7++;
            }
            zzfxVar.zzu(i7);
            while (i6 < list.size()) {
                zzfxVar.zzb(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : (byte) 0);
                i6++;
            }
            return;
        }
        zzff zzffVar = (zzff) list;
        if (!z6) {
            while (i6 < zzffVar.size()) {
                this.zza.zzd(i5, zzffVar.zzf(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzffVar.size(); i10++) {
            zzffVar.zzf(i10);
            i9++;
        }
        zzfxVar2.zzu(i9);
        while (i6 < zzffVar.size()) {
            zzfxVar2.zzb(zzffVar.zzf(i6) ? (byte) 1 : (byte) 0);
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzd(int i5, zzfp zzfpVar) {
        this.zza.zzf(i5, zzfpVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zze(int i5, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.zza.zzf(i5, (zzfp) list.get(i6));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzf(int i5, double d) {
        this.zza.zzj(i5, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzg(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzfz)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzj(i5, Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Double) list.get(i8)).getClass();
                i7 += 8;
            }
            zzfxVar.zzu(i7);
            while (i6 < list.size()) {
                zzfxVar.zzk(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                i6++;
            }
            return;
        }
        zzfz zzfzVar = (zzfz) list;
        if (!z6) {
            while (i6 < zzfzVar.size()) {
                this.zza.zzj(i5, Double.doubleToRawLongBits(zzfzVar.zze(i6)));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzfzVar.size(); i10++) {
            zzfzVar.zze(i10);
            i9 += 8;
        }
        zzfxVar2.zzu(i9);
        while (i6 < zzfzVar.size()) {
            zzfxVar2.zzk(Double.doubleToRawLongBits(zzfzVar.zze(i6)));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    @Deprecated
    public final void zzh(int i5) {
        this.zza.zzs(i5, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzi(int i5, int i6) {
        this.zza.zzl(i5, i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzj(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzgq)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzl(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int iZzz = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzz += zzfx.zzz(((Integer) list.get(i7)).intValue());
            }
            zzfxVar.zzu(iZzz);
            while (i6 < list.size()) {
                zzfxVar.zzm(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z6) {
            while (i6 < zzgqVar.size()) {
                this.zza.zzl(i5, zzgqVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int iZzz2 = 0;
        for (int i8 = 0; i8 < zzgqVar.size(); i8++) {
            iZzz2 += zzfx.zzz(zzgqVar.zze(i8));
        }
        zzfxVar2.zzu(iZzz2);
        while (i6 < zzgqVar.size()) {
            zzfxVar2.zzm(zzgqVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzk(int i5, int i6) {
        this.zza.zzh(i5, i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzl(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzgq)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).getClass();
                i7 += 4;
            }
            zzfxVar.zzu(i7);
            while (i6 < list.size()) {
                zzfxVar.zzi(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z6) {
            while (i6 < zzgqVar.size()) {
                this.zza.zzh(i5, zzgqVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzgqVar.size(); i10++) {
            zzgqVar.zze(i10);
            i9 += 4;
        }
        zzfxVar2.zzu(i9);
        while (i6 < zzgqVar.size()) {
            zzfxVar2.zzi(zzgqVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzm(int i5, long j6) {
        this.zza.zzj(i5, j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzn(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzhj)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzj(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Long) list.get(i8)).getClass();
                i7 += 8;
            }
            zzfxVar.zzu(i7);
            while (i6 < list.size()) {
                zzfxVar.zzk(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z6) {
            while (i6 < zzhjVar.size()) {
                this.zza.zzj(i5, zzhjVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzhjVar.size(); i10++) {
            zzhjVar.zze(i10);
            i9 += 8;
        }
        zzfxVar2.zzu(i9);
        while (i6 < zzhjVar.size()) {
            zzfxVar2.zzk(zzhjVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzo(int i5, float f6) {
        this.zza.zzh(i5, Float.floatToRawIntBits(f6));
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzp(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzgj)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Float) list.get(i8)).getClass();
                i7 += 4;
            }
            zzfxVar.zzu(i7);
            while (i6 < list.size()) {
                zzfxVar.zzi(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                i6++;
            }
            return;
        }
        zzgj zzgjVar = (zzgj) list;
        if (!z6) {
            while (i6 < zzgjVar.size()) {
                this.zza.zzh(i5, Float.floatToRawIntBits(zzgjVar.zze(i6)));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzgjVar.size(); i10++) {
            zzgjVar.zze(i10);
            i9 += 4;
        }
        zzfxVar2.zzu(i9);
        while (i6 < zzgjVar.size()) {
            zzfxVar2.zzi(Float.floatToRawIntBits(zzgjVar.zze(i6)));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzq(int i5, Object obj, zzib zzibVar) {
        zzfx zzfxVar = this.zza;
        zzfxVar.zzs(i5, 3);
        zzibVar.zzi((zzfa) obj, this);
        zzfxVar.zzs(i5, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzr(int i5, int i6) {
        this.zza.zzl(i5, i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzs(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzgq)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzl(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int iZzz = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzz += zzfx.zzz(((Integer) list.get(i7)).intValue());
            }
            zzfxVar.zzu(iZzz);
            while (i6 < list.size()) {
                zzfxVar.zzm(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z6) {
            while (i6 < zzgqVar.size()) {
                this.zza.zzl(i5, zzgqVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int iZzz2 = 0;
        for (int i8 = 0; i8 < zzgqVar.size(); i8++) {
            iZzz2 += zzfx.zzz(zzgqVar.zze(i8));
        }
        zzfxVar2.zzu(iZzz2);
        while (i6 < zzgqVar.size()) {
            zzfxVar2.zzm(zzgqVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzt(int i5, long j6) {
        this.zza.zzv(i5, j6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzu(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzhj)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzv(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int iZzz = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzz += zzfx.zzz(((Long) list.get(i7)).longValue());
            }
            zzfxVar.zzu(iZzz);
            while (i6 < list.size()) {
                zzfxVar.zzw(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z6) {
            while (i6 < zzhjVar.size()) {
                this.zza.zzv(i5, zzhjVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int iZzz2 = 0;
        for (int i8 = 0; i8 < zzhjVar.size(); i8++) {
            iZzz2 += zzfx.zzz(zzhjVar.zze(i8));
        }
        zzfxVar2.zzu(iZzz2);
        while (i6 < zzhjVar.size()) {
            zzfxVar2.zzw(zzhjVar.zze(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzv(int i5, zzhk zzhkVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            zzfxVar.zzu(zzhl.zzb(zzhkVar, entry.getKey(), entry.getValue()));
            zzhl.zze(zzfxVar, zzhkVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzw(int i5, Object obj, zzib zzibVar) {
        zzfx zzfxVar = this.zza;
        zzfa zzfaVar = (zzfa) obj;
        zzfxVar.zzs(i5, 2);
        zzfxVar.zzu(zzfaVar.zzi(zzibVar));
        zzibVar.zzi(zzfaVar, this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzx(int i5, Object obj) {
        if (obj instanceof zzfp) {
            this.zza.zzp(i5, (zzfp) obj);
        } else {
            this.zza.zzo(i5, (zzhr) obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzy(int i5, int i6) {
        this.zza.zzh(i5, i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzji
    public final void zzz(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzgq)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzh(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzfx zzfxVar = this.zza;
            zzfxVar.zzs(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).getClass();
                i7 += 4;
            }
            zzfxVar.zzu(i7);
            while (i6 < list.size()) {
                zzfxVar.zzi(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzgq zzgqVar = (zzgq) list;
        if (!z6) {
            while (i6 < zzgqVar.size()) {
                this.zza.zzh(i5, zzgqVar.zze(i6));
                i6++;
            }
            return;
        }
        zzfx zzfxVar2 = this.zza;
        zzfxVar2.zzs(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzgqVar.size(); i10++) {
            zzgqVar.zze(i10);
            i9 += 4;
        }
        zzfxVar2.zzu(i9);
        while (i6 < zzgqVar.size()) {
            zzfxVar2.zzi(zzgqVar.zze(i6));
            i6++;
        }
    }
}
