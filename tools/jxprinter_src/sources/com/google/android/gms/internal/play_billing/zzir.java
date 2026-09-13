package com.google.android.gms.internal.play_billing;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzir {
    private static final zzir zza = new zzir(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzir(int i5, int[] iArr, Object[] objArr, boolean z6) {
        this.zze = -1;
        this.zzb = i5;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z6;
    }

    public static zzir zzc() {
        return zza;
    }

    public static zzir zze(zzir zzirVar, zzir zzirVar2) {
        int i5 = zzirVar.zzb + zzirVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzirVar.zzc, i5);
        System.arraycopy(zzirVar2.zzc, 0, iArrCopyOf, zzirVar.zzb, zzirVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzirVar.zzd, i5);
        System.arraycopy(zzirVar2.zzd, 0, objArrCopyOf, zzirVar.zzb, zzirVar2.zzb);
        return new zzir(i5, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzir zzf() {
        return new zzir(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i5) {
        int[] iArr = this.zzc;
        if (i5 > iArr.length) {
            int i6 = this.zzb;
            int i7 = (i6 / 2) + i6;
            if (i7 >= i5) {
                i5 = i7;
            }
            if (i5 < 8) {
                i5 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i5);
            this.zzd = Arrays.copyOf(this.zzd, i5);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzir)) {
            return false;
        }
        zzir zzirVar = (zzir) obj;
        int i5 = this.zzb;
        if (i5 == zzirVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzirVar.zzc;
            for (int i6 = 0; i6 < i5; i6++) {
                if (iArr[i6] == iArr2[i6]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzirVar.zzd;
            int i7 = this.zzb;
            for (int i8 = 0; i8 < i7; i8++) {
                if (objArr[i8].equals(objArr2[i8])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.zzb;
        int i6 = i5 + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i5; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = ((i6 * 31) + i7) * 31;
        Object[] objArr = this.zzd;
        int i10 = this.zzb;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return i9 + iHashCode;
    }

    public final int zza() {
        int iZzy;
        int iZzz;
        int iZzy2;
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int iC = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 == 2) {
                        int i10 = i8 << 3;
                        zzfp zzfpVar = (zzfp) this.zzd[i6];
                        int iZzy3 = zzfx.zzy(i10);
                        int iZzd = zzfpVar.zzd();
                        iC = a.c(iZzd, iZzd, iZzy3, iC);
                    } else if (i9 == 3) {
                        int iZzy4 = zzfx.zzy(i8 << 3);
                        iZzy = iZzy4 + iZzy4;
                        iZzz = ((zzir) this.zzd[i6]).zza();
                    } else {
                        if (i9 != 5) {
                            throw new IllegalStateException(new zzha("Protocol message tag had invalid wire type."));
                        }
                        ((Integer) this.zzd[i6]).getClass();
                        iZzy2 = zzfx.zzy(i8 << 3) + 4;
                    }
                } else {
                    ((Long) this.zzd[i6]).getClass();
                    iZzy2 = zzfx.zzy(i8 << 3) + 8;
                }
                iC = iZzy2 + iC;
            } else {
                int i11 = i8 << 3;
                long jLongValue = ((Long) this.zzd[i6]).longValue();
                iZzy = zzfx.zzy(i11);
                iZzz = zzfx.zzz(jLongValue);
            }
            iC = iZzz + iZzy + iC;
        }
        this.zze = iC;
        return iC;
    }

    public final int zzb() {
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int iC = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6] >>> 3;
            zzfp zzfpVar = (zzfp) this.zzd[i6];
            int iZzy = zzfx.zzy(8);
            int iZzy2 = zzfx.zzy(i7) + zzfx.zzy(16);
            int iZzy3 = zzfx.zzy(24);
            int iZzd = zzfpVar.zzd();
            iC += iZzy + iZzy + iZzy2 + a.C(iZzd, iZzd, iZzy3);
        }
        this.zze = iC;
        return iC;
    }

    public final zzir zzd(zzir zzirVar) {
        if (zzirVar.equals(zza)) {
            return this;
        }
        zzg();
        int i5 = this.zzb + zzirVar.zzb;
        zzm(i5);
        System.arraycopy(zzirVar.zzc, 0, this.zzc, this.zzb, zzirVar.zzb);
        System.arraycopy(zzirVar.zzd, 0, this.zzd, this.zzb, zzirVar.zzb);
        this.zzb = i5;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzht.zzb(sb, i5, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    public final void zzj(int i5, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i5;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    public final void zzk(zzji zzjiVar) {
        for (int i5 = 0; i5 < this.zzb; i5++) {
            zzjiVar.zzx(this.zzc[i5] >>> 3, this.zzd[i5]);
        }
    }

    public final void zzl(zzji zzjiVar) {
        if (this.zzb != 0) {
            for (int i5 = 0; i5 < this.zzb; i5++) {
                int i6 = this.zzc[i5];
                Object obj = this.zzd[i5];
                int i7 = i6 >>> 3;
                int i8 = i6 & 7;
                if (i8 == 0) {
                    zzjiVar.zzt(i7, ((Long) obj).longValue());
                } else if (i8 == 1) {
                    zzjiVar.zzm(i7, ((Long) obj).longValue());
                } else if (i8 == 2) {
                    zzjiVar.zzd(i7, (zzfp) obj);
                } else if (i8 == 3) {
                    zzjiVar.zzG(i7);
                    ((zzir) obj).zzl(zzjiVar);
                    zzjiVar.zzh(i7);
                } else {
                    if (i8 != 5) {
                        throw new RuntimeException(new zzha("Protocol message tag had invalid wire type."));
                    }
                    zzjiVar.zzk(i7, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzir() {
        this(0, new int[8], new Object[8], true);
    }
}
