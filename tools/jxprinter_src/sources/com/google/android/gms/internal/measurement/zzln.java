package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzln implements zzov {
    private final zzlm zza;

    private zzln(zzlm zzlmVar) {
        byte[] bArr = zzmp.zzb;
        this.zza = zzlmVar;
        zzlmVar.zza = this;
    }

    public static zzln zza(zzlm zzlmVar) {
        zzln zzlnVar = zzlmVar.zza;
        return zzlnVar != null ? zzlnVar : new zzln(zzlmVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzA(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzna)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzf(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Long) list.get(i8)).getClass();
                i7 += 8;
            }
            zzlmVar.zzr(i7);
            while (i6 < list.size()) {
                zzlmVar.zzu(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z6) {
            while (i6 < zznaVar.size()) {
                this.zza.zzf(i5, zznaVar.zzc(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zznaVar.size(); i10++) {
            zznaVar.zzc(i10);
            i9 += 8;
        }
        zzlmVar2.zzr(i9);
        while (i6 < zznaVar.size()) {
            zzlmVar2.zzu(zznaVar.zzc(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzB(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzly)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzd(i5, Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Float) list.get(i8)).getClass();
                i7 += 4;
            }
            zzlmVar.zzr(i7);
            while (i6 < list.size()) {
                zzlmVar.zzs(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                i6++;
            }
            return;
        }
        zzly zzlyVar = (zzly) list;
        if (!z6) {
            while (i6 < zzlyVar.size()) {
                this.zza.zzd(i5, Float.floatToRawIntBits(zzlyVar.zze(i6)));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzlyVar.size(); i10++) {
            zzlyVar.zze(i10);
            i9 += 4;
        }
        zzlmVar2.zzr(i9);
        while (i6 < zzlyVar.size()) {
            zzlmVar2.zzs(Float.floatToRawIntBits(zzlyVar.zze(i6)));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzC(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzlo)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzf(i5, Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Double) list.get(i8)).getClass();
                i7 += 8;
            }
            zzlmVar.zzr(i7);
            while (i6 < list.size()) {
                zzlmVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
                i6++;
            }
            return;
        }
        zzlo zzloVar = (zzlo) list;
        if (!z6) {
            while (i6 < zzloVar.size()) {
                this.zza.zzf(i5, Double.doubleToRawLongBits(zzloVar.zze(i6)));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzloVar.size(); i10++) {
            zzloVar.zze(i10);
            i9 += 8;
        }
        zzlmVar2.zzr(i9);
        while (i6 < zzloVar.size()) {
            zzlmVar2.zzu(Double.doubleToRawLongBits(zzloVar.zze(i6)));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzD(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzmg)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzb(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int iZzA = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzA += zzlm.zzA(((Integer) list.get(i7)).intValue());
            }
            zzlmVar.zzr(iZzA);
            while (i6 < list.size()) {
                zzlmVar.zzq(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z6) {
            while (i6 < zzmgVar.size()) {
                this.zza.zzb(i5, zzmgVar.zzf(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int iZzA2 = 0;
        for (int i8 = 0; i8 < zzmgVar.size(); i8++) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i8));
        }
        zzlmVar2.zzr(iZzA2);
        while (i6 < zzmgVar.size()) {
            zzlmVar2.zzq(zzmgVar.zzf(i6));
            i6++;
        }
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
    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzE(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzky)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzg(i5, ((Boolean) list.get(i6)).booleanValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Boolean) list.get(i8)).getClass();
                i7++;
            }
            zzlmVar.zzr(i7);
            while (i6 < list.size()) {
                zzlmVar.zzp(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : (byte) 0);
                i6++;
            }
            return;
        }
        zzky zzkyVar = (zzky) list;
        if (!z6) {
            while (i6 < zzkyVar.size()) {
                this.zza.zzg(i5, zzkyVar.zze(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzkyVar.size(); i10++) {
            zzkyVar.zze(i10);
            i9++;
        }
        zzlmVar2.zzr(i9);
        while (i6 < zzkyVar.size()) {
            zzlmVar2.zzp(zzkyVar.zze(i6) ? (byte) 1 : (byte) 0);
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzF(int i5, List list) {
        int i6 = 0;
        if (!(list instanceof zzmx)) {
            while (i6 < list.size()) {
                this.zza.zzh(i5, (String) list.get(i6));
                i6++;
            }
            return;
        }
        zzmx zzmxVar = (zzmx) list;
        while (i6 < list.size()) {
            Object objZzc = zzmxVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzh(i5, (String) objZzc);
            } else {
                this.zza.zzi(i5, (zzlh) objZzc);
            }
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzG(int i5, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.zza.zzi(i5, (zzlh) list.get(i6));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzH(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzmg)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzc(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int iZzz = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzz += zzlm.zzz(((Integer) list.get(i7)).intValue());
            }
            zzlmVar.zzr(iZzz);
            while (i6 < list.size()) {
                zzlmVar.zzr(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z6) {
            while (i6 < zzmgVar.size()) {
                this.zza.zzc(i5, zzmgVar.zzf(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int iZzz2 = 0;
        for (int i8 = 0; i8 < zzmgVar.size(); i8++) {
            iZzz2 += zzlm.zzz(zzmgVar.zzf(i8));
        }
        zzlmVar2.zzr(iZzz2);
        while (i6 < zzmgVar.size()) {
            zzlmVar2.zzr(zzmgVar.zzf(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzI(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzmg)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzd(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).getClass();
                i7 += 4;
            }
            zzlmVar.zzr(i7);
            while (i6 < list.size()) {
                zzlmVar.zzs(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z6) {
            while (i6 < zzmgVar.size()) {
                this.zza.zzd(i5, zzmgVar.zzf(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzmgVar.size(); i10++) {
            zzmgVar.zzf(i10);
            i9 += 4;
        }
        zzlmVar2.zzr(i9);
        while (i6 < zzmgVar.size()) {
            zzlmVar2.zzs(zzmgVar.zzf(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzJ(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzna)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzf(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Long) list.get(i8)).getClass();
                i7 += 8;
            }
            zzlmVar.zzr(i7);
            while (i6 < list.size()) {
                zzlmVar.zzu(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z6) {
            while (i6 < zznaVar.size()) {
                this.zza.zzf(i5, zznaVar.zzc(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zznaVar.size(); i10++) {
            zznaVar.zzc(i10);
            i9 += 8;
        }
        zzlmVar2.zzr(i9);
        while (i6 < zznaVar.size()) {
            zzlmVar2.zzu(zznaVar.zzc(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzK(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzmg)) {
            if (!z6) {
                while (i6 < list.size()) {
                    zzlm zzlmVar = this.zza;
                    int iIntValue = ((Integer) list.get(i6)).intValue();
                    zzlmVar.zzc(i5, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i6++;
                }
                return;
            }
            zzlm zzlmVar2 = this.zza;
            zzlmVar2.zza(i5, 2);
            int iZzz = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int iIntValue2 = ((Integer) list.get(i7)).intValue();
                iZzz += zzlm.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzlmVar2.zzr(iZzz);
            while (i6 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i6)).intValue();
                zzlmVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i6++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z6) {
            while (i6 < zzmgVar.size()) {
                zzlm zzlmVar3 = this.zza;
                int iZzf = zzmgVar.zzf(i6);
                zzlmVar3.zzc(i5, (iZzf >> 31) ^ (iZzf + iZzf));
                i6++;
            }
            return;
        }
        zzlm zzlmVar4 = this.zza;
        zzlmVar4.zza(i5, 2);
        int iZzz2 = 0;
        for (int i8 = 0; i8 < zzmgVar.size(); i8++) {
            int iZzf2 = zzmgVar.zzf(i8);
            iZzz2 += zzlm.zzz((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzlmVar4.zzr(iZzz2);
        while (i6 < zzmgVar.size()) {
            int iZzf3 = zzmgVar.zzf(i6);
            zzlmVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzL(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzna)) {
            if (!z6) {
                while (i6 < list.size()) {
                    zzlm zzlmVar = this.zza;
                    long jLongValue = ((Long) list.get(i6)).longValue();
                    zzlmVar.zze(i5, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i6++;
                }
                return;
            }
            zzlm zzlmVar2 = this.zza;
            zzlmVar2.zza(i5, 2);
            int iZzA = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                long jLongValue2 = ((Long) list.get(i7)).longValue();
                iZzA += zzlm.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzlmVar2.zzr(iZzA);
            while (i6 < list.size()) {
                long jLongValue3 = ((Long) list.get(i6)).longValue();
                zzlmVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i6++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z6) {
            while (i6 < zznaVar.size()) {
                zzlm zzlmVar3 = this.zza;
                long jZzc = zznaVar.zzc(i6);
                zzlmVar3.zze(i5, (jZzc >> 63) ^ (jZzc + jZzc));
                i6++;
            }
            return;
        }
        zzlm zzlmVar4 = this.zza;
        zzlmVar4.zza(i5, 2);
        int iZzA2 = 0;
        for (int i8 = 0; i8 < zznaVar.size(); i8++) {
            long jZzc2 = zznaVar.zzc(i8);
            iZzA2 += zzlm.zzA((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzlmVar4.zzr(iZzA2);
        while (i6 < zznaVar.size()) {
            long jZzc3 = zznaVar.zzc(i6);
            zzlmVar4.zzt((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzM(int i5, zzne zzneVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            zzlmVar.zzr(zznf.zzc(zzneVar, entry.getKey(), entry.getValue()));
            zznf.zzb(zzlmVar, zzneVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzb(int i5, int i6) {
        this.zza.zzd(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzc(int i5, long j6) {
        this.zza.zze(i5, j6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzd(int i5, long j6) {
        this.zza.zzf(i5, j6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zze(int i5, float f6) {
        this.zza.zzd(i5, Float.floatToRawIntBits(f6));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzf(int i5, double d) {
        this.zza.zzf(i5, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzg(int i5, int i6) {
        this.zza.zzb(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzh(int i5, long j6) {
        this.zza.zze(i5, j6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzi(int i5, int i6) {
        this.zza.zzb(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzj(int i5, long j6) {
        this.zza.zzf(i5, j6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzk(int i5, int i6) {
        this.zza.zzd(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzl(int i5, boolean z6) {
        this.zza.zzg(i5, z6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzm(int i5, String str) {
        this.zza.zzh(i5, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzn(int i5, zzlh zzlhVar) {
        this.zza.zzi(i5, zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzo(int i5, int i6) {
        this.zza.zzc(i5, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzp(int i5, int i6) {
        this.zza.zzc(i5, (i6 >> 31) ^ (i6 + i6));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzq(int i5, long j6) {
        this.zza.zze(i5, (j6 >> 63) ^ (j6 + j6));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzr(int i5, Object obj, zznx zznxVar) {
        this.zza.zzl(i5, (zznm) obj, zznxVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzs(int i5, Object obj, zznx zznxVar) {
        zzlm zzlmVar = this.zza;
        zzlmVar.zza(i5, 3);
        zznxVar.zzf((zznm) obj, zzlmVar.zza);
        zzlmVar.zza(i5, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    @Deprecated
    public final void zzt(int i5) {
        this.zza.zza(i5, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    @Deprecated
    public final void zzu(int i5) {
        this.zza.zza(i5, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzv(int i5, Object obj) {
        if (obj instanceof zzlh) {
            this.zza.zzn(i5, (zzlh) obj);
        } else {
            this.zza.zzm(i5, (zznm) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzw(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzmg)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzb(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int iZzA = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzA += zzlm.zzA(((Integer) list.get(i7)).intValue());
            }
            zzlmVar.zzr(iZzA);
            while (i6 < list.size()) {
                zzlmVar.zzq(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z6) {
            while (i6 < zzmgVar.size()) {
                this.zza.zzb(i5, zzmgVar.zzf(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int iZzA2 = 0;
        for (int i8 = 0; i8 < zzmgVar.size(); i8++) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i8));
        }
        zzlmVar2.zzr(iZzA2);
        while (i6 < zzmgVar.size()) {
            zzlmVar2.zzq(zzmgVar.zzf(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzx(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzmg)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zzd(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).getClass();
                i7 += 4;
            }
            zzlmVar.zzr(i7);
            while (i6 < list.size()) {
                zzlmVar.zzs(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z6) {
            while (i6 < zzmgVar.size()) {
                this.zza.zzd(i5, zzmgVar.zzf(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < zzmgVar.size(); i10++) {
            zzmgVar.zzf(i10);
            i9 += 4;
        }
        zzlmVar2.zzr(i9);
        while (i6 < zzmgVar.size()) {
            zzlmVar2.zzs(zzmgVar.zzf(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzy(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzna)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zze(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int iZzA = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzA += zzlm.zzA(((Long) list.get(i7)).longValue());
            }
            zzlmVar.zzr(iZzA);
            while (i6 < list.size()) {
                zzlmVar.zzt(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z6) {
            while (i6 < zznaVar.size()) {
                this.zza.zze(i5, zznaVar.zzc(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int iZzA2 = 0;
        for (int i8 = 0; i8 < zznaVar.size(); i8++) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i8));
        }
        zzlmVar2.zzr(iZzA2);
        while (i6 < zznaVar.size()) {
            zzlmVar2.zzt(zznaVar.zzc(i6));
            i6++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzz(int i5, List list, boolean z6) {
        int i6 = 0;
        if (!(list instanceof zzna)) {
            if (!z6) {
                while (i6 < list.size()) {
                    this.zza.zze(i5, ((Long) list.get(i6)).longValue());
                    i6++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i5, 2);
            int iZzA = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iZzA += zzlm.zzA(((Long) list.get(i7)).longValue());
            }
            zzlmVar.zzr(iZzA);
            while (i6 < list.size()) {
                zzlmVar.zzt(((Long) list.get(i6)).longValue());
                i6++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z6) {
            while (i6 < zznaVar.size()) {
                this.zza.zze(i5, zznaVar.zzc(i6));
                i6++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i5, 2);
        int iZzA2 = 0;
        for (int i8 = 0; i8 < zznaVar.size(); i8++) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i8));
        }
        zzlmVar2.zzr(iZzA2);
        while (i6 < zznaVar.size()) {
            zzlmVar2.zzt(zznaVar.zzc(i6));
            i6++;
        }
    }
}
