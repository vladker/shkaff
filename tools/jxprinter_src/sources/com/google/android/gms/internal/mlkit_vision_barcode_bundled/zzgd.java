package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgd extends zzdf {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzdf zzd;
    private final zzdf zze;
    private final int zzf;
    private final int zzg;

    public static int zzc(int i5) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i5 >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i5];
    }

    public static zzdf zzy(zzdf zzdfVar, zzdf zzdfVar2) {
        if (zzdfVar2.zzd() == 0) {
            return zzdfVar;
        }
        if (zzdfVar.zzd() == 0) {
            return zzdfVar2;
        }
        int iZzd = zzdfVar2.zzd() + zzdfVar.zzd();
        if (iZzd < 128) {
            return zzz(zzdfVar, zzdfVar2);
        }
        if (zzdfVar instanceof zzgd) {
            zzgd zzgdVar = (zzgd) zzdfVar;
            if (zzdfVar2.zzd() + zzgdVar.zze.zzd() < 128) {
                return new zzgd(zzgdVar.zzd, zzz(zzgdVar.zze, zzdfVar2));
            }
            if (zzgdVar.zzd.zzf() > zzgdVar.zze.zzf() && zzgdVar.zzg > zzdfVar2.zzf()) {
                return new zzgd(zzgdVar.zzd, new zzgd(zzgdVar.zze, zzdfVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzdfVar.zzf(), zzdfVar2.zzf()) + 1) ? new zzgd(zzdfVar, zzdfVar2) : zzfz.zza(new zzfz(null), zzdfVar, zzdfVar2);
    }

    private static zzdf zzz(zzdf zzdfVar, zzdf zzdfVar2) {
        int iZzd = zzdfVar.zzd();
        int iZzd2 = zzdfVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzdfVar.zzv(bArr, 0, 0, iZzd);
        zzdfVar2.zzv(bArr, 0, iZzd, iZzd2);
        return new zzde(bArr);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdf)) {
            return false;
        }
        zzdf zzdfVar = (zzdf) obj;
        if (this.zzc != zzdfVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int iZzp = zzp();
        int iZzp2 = zzdfVar.zzp();
        if (iZzp != 0 && iZzp2 != 0 && iZzp != iZzp2) {
            return false;
        }
        zzga zzgaVar = null;
        zzgb zzgbVar = new zzgb(this, zzgaVar);
        zzdd zzddVarZza = zzgbVar.next();
        zzgb zzgbVar2 = new zzgb(zzdfVar, zzgaVar);
        zzdd zzddVarZza2 = zzgbVar2.next();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int iZzd = zzddVarZza.zzd() - i5;
            int iZzd2 = zzddVarZza2.zzd() - i6;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i5 == 0 ? zzddVarZza.zzg(zzddVarZza2, i6, iMin) : zzddVarZza2.zzg(zzddVarZza, i5, iMin))) {
                return false;
            }
            i7 += iMin;
            int i8 = this.zzc;
            if (i7 >= i8) {
                if (i7 == i8) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zzddVarZza = zzgbVar.next();
                i5 = 0;
            } else {
                i5 += iMin;
            }
            if (iMin == iZzd2) {
                zzddVarZza = zzddVarZza;
                zzddVarZza2 = zzgbVar2.next();
                i6 = 0;
            } else {
                zzddVarZza = zzddVarZza;
                i6 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzfx(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zza(int i5) {
        zzdf.zzu(i5, this.zzc);
        return zzb(i5);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte zzb(int i5) {
        int i6 = this.zzf;
        return i5 < i6 ? this.zzd.zzb(i5) : this.zze.zzb(i5 - i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zze(byte[] bArr, int i5, int i6, int i7) {
        int i8 = i5 + i7;
        int i9 = this.zzf;
        if (i8 <= i9) {
            this.zzd.zze(bArr, i5, i6, i7);
        } else {
            if (i5 >= i9) {
                this.zze.zze(bArr, i5 - i9, i6, i7);
                return;
            }
            int i10 = i9 - i5;
            this.zzd.zze(bArr, i5, i6, i10);
            this.zze.zze(bArr, 0, i6 + i10, i7 - i10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzi(int i5, int i6, int i7) {
        int i8 = i6 + i7;
        int i9 = this.zzf;
        if (i8 <= i9) {
            return this.zzd.zzi(i5, i6, i7);
        }
        if (i6 >= i9) {
            return this.zze.zzi(i5, i6 - i9, i7);
        }
        int i10 = i9 - i6;
        return this.zze.zzi(this.zzd.zzi(i5, i6, i10), 0, i7 - i10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int zzj(int i5, int i6, int i7) {
        int i8 = i6 + i7;
        int i9 = this.zzf;
        if (i8 <= i9) {
            return this.zzd.zzj(i5, i6, i7);
        }
        if (i6 >= i9) {
            return this.zze.zzj(i5, i6 - i9, i7);
        }
        int i10 = i9 - i6;
        return this.zze.zzj(this.zzd.zzj(i5, i6, i10), 0, i7 - i10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final zzdf zzk(int i5, int i6) {
        int iZzo = zzdf.zzo(i5, i6, this.zzc);
        if (iZzo == 0) {
            return zzdf.zzb;
        }
        if (iZzo == this.zzc) {
            return this;
        }
        int i7 = this.zzf;
        if (i6 <= i7) {
            return this.zzd.zzk(i5, i6);
        }
        if (i5 >= i7) {
            return this.zze.zzk(i5 - i7, i6 - i7);
        }
        zzdf zzdfVar = this.zzd;
        return new zzgd(zzdfVar.zzk(i5, zzdfVar.zzd()), this.zze.zzk(0, i6 - this.zzf));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final String zzl(Charset charset) {
        return new String(zzw(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void zzm(zzcx zzcxVar) {
        this.zzd.zzm(zzcxVar);
        this.zze.zzm(zzcxVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean zzn() {
        zzdf zzdfVar = this.zzd;
        zzdf zzdfVar2 = this.zze;
        return zzdfVar2.zzj(zzdfVar.zzj(0, 0, this.zzf), 0, zzdfVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    /* JADX INFO: renamed from: zzq */
    public final zzdb iterator() {
        return new zzfx(this);
    }

    private zzgd(zzdf zzdfVar, zzdf zzdfVar2) {
        this.zzd = zzdfVar;
        this.zze = zzdfVar2;
        int iZzd = zzdfVar.zzd();
        this.zzf = iZzd;
        this.zzc = zzdfVar2.zzd() + iZzd;
        this.zzg = Math.max(zzdfVar.zzf(), zzdfVar2.zzf()) + 1;
    }
}
