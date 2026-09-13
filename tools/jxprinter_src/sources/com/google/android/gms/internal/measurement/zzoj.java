package com.google.android.gms.internal.measurement;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoj {
    private static final zzoj zza = new zzoj(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzoj(int i5, int[] iArr, Object[] objArr, boolean z6) {
        this.zze = -1;
        this.zzb = i5;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z6;
    }

    public static zzoj zza() {
        return zza;
    }

    public static zzoj zzb() {
        return new zzoj(0, new int[8], new Object[8], true);
    }

    public static zzoj zzc(zzoj zzojVar, zzoj zzojVar2) {
        int i5 = zzojVar.zzb + zzojVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzojVar.zzc, i5);
        System.arraycopy(zzojVar2.zzc, 0, iArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzojVar.zzd, i5);
        System.arraycopy(zzojVar2.zzd, 0, objArrCopyOf, zzojVar.zzb, zzojVar2.zzb);
        return new zzoj(i5, iArrCopyOf, objArrCopyOf, true);
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
        if (obj == null || !(obj instanceof zzoj)) {
            return false;
        }
        zzoj zzojVar = (zzoj) obj;
        int i5 = this.zzb;
        if (i5 == zzojVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzojVar.zzc;
            for (int i6 = 0; i6 < i5; i6++) {
                if (iArr[i6] == iArr2[i6]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzojVar.zzd;
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

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzf(zzov zzovVar) {
        for (int i5 = 0; i5 < this.zzb; i5++) {
            zzovVar.zzv(this.zzc[i5] >>> 3, this.zzd[i5]);
        }
    }

    public final void zzg(zzov zzovVar) {
        if (this.zzb != 0) {
            for (int i5 = 0; i5 < this.zzb; i5++) {
                int i6 = this.zzc[i5];
                Object obj = this.zzd[i5];
                int i7 = i6 & 7;
                int i8 = i6 >>> 3;
                if (i7 == 0) {
                    zzovVar.zzc(i8, ((Long) obj).longValue());
                } else if (i7 == 1) {
                    zzovVar.zzj(i8, ((Long) obj).longValue());
                } else if (i7 == 2) {
                    zzovVar.zzn(i8, (zzlh) obj);
                } else if (i7 == 3) {
                    zzovVar.zzt(i8);
                    ((zzoj) obj).zzg(zzovVar);
                    zzovVar.zzu(i8);
                } else {
                    if (i7 != 5) {
                        throw new RuntimeException(new zzmq("Protocol message tag had invalid wire type."));
                    }
                    zzovVar.zzk(i8, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int iB = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6] >>> 3;
            zzlh zzlhVar = (zzlh) this.zzd[i6];
            int iZzz = zzlm.zzz(8);
            int iZzz2 = zzlm.zzz(i7) + zzlm.zzz(16);
            int iZzz3 = zzlm.zzz(24);
            int iZzc = zzlhVar.zzc();
            iB += iZzz + iZzz + iZzz2 + a.b(iZzc, iZzc, iZzz3);
        }
        this.zze = iB;
        return iB;
    }

    public final int zzi() {
        int iZzz;
        int iZzA;
        int iZzz2;
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int iZzz3 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 == 2) {
                        int i10 = i8 << 3;
                        zzlh zzlhVar = (zzlh) this.zzd[i6];
                        int iZzz4 = zzlm.zzz(i10);
                        int iZzc = zzlhVar.zzc();
                        iZzz3 = zzlm.zzz(iZzc) + iZzc + iZzz4 + iZzz3;
                    } else if (i9 == 3) {
                        int iZzz5 = zzlm.zzz(i8 << 3);
                        iZzz = iZzz5 + iZzz5;
                        iZzA = ((zzoj) this.zzd[i6]).zzi();
                    } else {
                        if (i9 != 5) {
                            throw new IllegalStateException(new zzmq("Protocol message tag had invalid wire type."));
                        }
                        ((Integer) this.zzd[i6]).getClass();
                        iZzz2 = zzlm.zzz(i8 << 3) + 4;
                    }
                } else {
                    ((Long) this.zzd[i6]).getClass();
                    iZzz2 = zzlm.zzz(i8 << 3) + 8;
                }
                iZzz3 = iZzz2 + iZzz3;
            } else {
                int i11 = i8 << 3;
                long jLongValue = ((Long) this.zzd[i6]).longValue();
                iZzz = zzlm.zzz(i11);
                iZzA = zzlm.zzA(jLongValue);
            }
            iZzz3 = iZzA + iZzz + iZzz3;
        }
        this.zze = iZzz3;
        return iZzz3;
    }

    public final void zzj(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zzno.zzb(sb, i5, String.valueOf(this.zzc[i6] >>> 3), this.zzd[i6]);
        }
    }

    public final void zzk(int i5, Object obj) {
        zze();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i6 = this.zzb;
        iArr[i6] = i5;
        this.zzd[i6] = obj;
        this.zzb = i6 + 1;
    }

    public final zzoj zzl(zzoj zzojVar) {
        if (zzojVar.equals(zza)) {
            return this;
        }
        zze();
        int i5 = this.zzb + zzojVar.zzb;
        zzm(i5);
        System.arraycopy(zzojVar.zzc, 0, this.zzc, this.zzb, zzojVar.zzb);
        System.arraycopy(zzojVar.zzd, 0, this.zzd, this.zzb, zzojVar.zzb);
        this.zzb = i5;
        return this;
    }

    private zzoj() {
        this(0, new int[8], new Object[8], true);
    }
}
