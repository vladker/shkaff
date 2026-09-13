package com.google.android.gms.internal.play_billing;

import A3.AbstractC0157z;
import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgp;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzgp<MessageType extends zzgp<MessageType, BuilderType>, BuilderType extends zzgl<MessageType, BuilderType>> extends zzfa<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzir zzc = zzir.zzc();

    public static void zzB(Class cls, zzgp zzgpVar) {
        zzgpVar.zzA();
        zzb.put(cls, zzgpVar);
    }

    private final int zza(zzib zzibVar) {
        return zzhy.zza().zzb(getClass()).zza(this);
    }

    private static zzgp zzb(zzgp zzgpVar, byte[] bArr, int i5, int i6, zzgc zzgcVar) throws zzhb {
        if (i6 == 0) {
            return zzgpVar;
        }
        zzgp zzgpVarZzs = zzgpVar.zzs();
        try {
            zzib zzibVarZzb = zzhy.zza().zzb(zzgpVarZzs.getClass());
            zzibVarZzb.zzh(zzgpVarZzs, bArr, 0, i6, new zzfd(zzgcVar));
            zzibVarZzb.zzf(zzgpVarZzs);
            return zzgpVarZzs;
        } catch (zzhb e) {
            throw e;
        } catch (zzip e6) {
            throw e6.zza();
        } catch (IOException e7) {
            if (e7.getCause() instanceof zzhb) {
                throw ((zzhb) e7.getCause());
            }
            throw new zzhb(e7);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzc(zzgp zzgpVar, boolean z6) {
        byte bByteValue = ((Byte) zzgpVar.zzd(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzhy.zza().zzb(zzgpVar.getClass()).zzk(zzgpVar);
        if (z6) {
            zzgpVar.zzd(2, true != zZzk ? null : zzgpVar, null);
        }
        return zZzk;
    }

    public static zzgp zzr(Class cls) {
        Map map = zzb;
        zzgp zzgpVar = (zzgp) map.get(cls);
        if (zzgpVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgpVar = (zzgp) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgpVar != null) {
            return zzgpVar;
        }
        zzgp zzgpVar2 = (zzgp) ((zzgp) zzix.zze(cls)).zzd(6, null, null);
        if (zzgpVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzgpVar2);
        return zzgpVar2;
    }

    public static zzgp zzt(zzgp zzgpVar, byte[] bArr) throws zzhb {
        int length = bArr.length;
        int i5 = zzgc.zzb;
        int i6 = zzfc.zza;
        zzgp zzgpVarZzb = zzb(zzgpVar, bArr, 0, length, zzgc.zza);
        if (zzgpVarZzb == null || zzc(zzgpVarZzb, true)) {
            return zzgpVarZzb;
        }
        throw new zzip(zzgpVarZzb).zza();
    }

    public static zzgt zzu() {
        return zzgq.zzf();
    }

    public static zzgu zzv() {
        return zzhz.zze();
    }

    public static Object zzx(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzy(zzhr zzhrVar, String str, Object[] objArr) {
        return new zzia(zzhrVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhy.zza().zzb(getClass()).zzj(this, (zzgp) obj);
    }

    public final int hashCode() {
        if (zzF()) {
            return zzm();
        }
        int i5 = this.zza;
        if (i5 != 0) {
            return i5;
        }
        int iZzm = zzm();
        this.zza = iZzm;
        return iZzm;
    }

    public final String toString() {
        return zzht.zza(this, super.toString());
    }

    public final void zzA() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzC(int i5) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhr
    public final void zzD(zzfx zzfxVar) {
        zzhy.zza().zzb(getClass()).zzi(this, zzfy.zza(zzfxVar));
    }

    public final boolean zzF() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object zzd(int i5, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.play_billing.zzfa
    public final int zzi(zzib zzibVar) {
        if (zzF()) {
            int iZza = zzibVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(AbstractC0157z.k(iZza, "serialized size must be non-negative, was "));
        }
        int i5 = this.zzd & Integer.MAX_VALUE;
        if (i5 != Integer.MAX_VALUE) {
            return i5;
        }
        int iZza2 = zzibVar.zza(this);
        if (iZza2 < 0) {
            throw new IllegalStateException(AbstractC0157z.k(iZza2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final /* synthetic */ zzhr zzl() {
        return (zzgp) zzd(6, null, null);
    }

    public final int zzm() {
        return zzhy.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhr
    public final int zzn() {
        if (zzF()) {
            int iZza = zza(null);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(AbstractC0157z.k(iZza, "serialized size must be non-negative, was "));
        }
        int i5 = this.zzd & Integer.MAX_VALUE;
        if (i5 != Integer.MAX_VALUE) {
            return i5;
        }
        int iZza2 = zza(null);
        if (iZza2 < 0) {
            throw new IllegalStateException(AbstractC0157z.k(iZza2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final boolean zzo() {
        return zzc(this, true);
    }

    public final zzgl zzp() {
        return (zzgl) zzd(5, null, null);
    }

    public final zzgl zzq() {
        zzgl zzglVar = (zzgl) zzd(5, null, null);
        zzglVar.zzh(this);
        return zzglVar;
    }

    public final zzgp zzs() {
        return (zzgp) zzd(4, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhr
    public final /* synthetic */ zzhq zzw() {
        return (zzgl) zzd(5, null, null);
    }

    public final void zzz() {
        zzhy.zza().zzb(getClass()).zzf(this);
        zzA();
    }
}
