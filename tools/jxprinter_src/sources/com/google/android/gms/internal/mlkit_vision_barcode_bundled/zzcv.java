package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcv {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i5, zzcu zzcuVar) throws zzer {
        int iZzj = zzj(bArr, i5, zzcuVar);
        int i6 = zzcuVar.zza;
        if (i6 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i6 > bArr.length - iZzj) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i6 == 0) {
            zzcuVar.zzc = zzdf.zzb;
            return iZzj;
        }
        zzcuVar.zzc = zzdf.zzr(bArr, iZzj, i6);
        return iZzj + i6;
    }

    public static int zzb(int i5, byte[] bArr, int i6, int i7, zzed zzedVar, zzef zzefVar, zzgs zzgsVar, zzcu zzcuVar) throws zzer {
        zzdx zzdxVar = zzedVar.zzb;
        zzhf zzhfVar = zzefVar.zzb.zzb;
        Object objValueOf = null;
        if (zzhfVar == zzhf.zzn) {
            zzj(bArr, i6, zzcuVar);
            throw null;
        }
        switch (zzhfVar.ordinal()) {
            case 0:
                i6 += 8;
                objValueOf = Double.valueOf(Double.longBitsToDouble(zzq(bArr, i6)));
                break;
            case 1:
                i6 += 4;
                objValueOf = Float.valueOf(Float.intBitsToFloat(zzc(bArr, i6)));
                break;
            case 2:
            case 3:
                i6 = zzm(bArr, i6, zzcuVar);
                objValueOf = Long.valueOf(zzcuVar.zzb);
                break;
            case 4:
            case 12:
                i6 = zzj(bArr, i6, zzcuVar);
                objValueOf = Integer.valueOf(zzcuVar.zza);
                break;
            case 5:
            case 15:
                i6 += 8;
                objValueOf = Long.valueOf(zzq(bArr, i6));
                break;
            case 6:
            case 14:
                i6 += 4;
                objValueOf = Integer.valueOf(zzc(bArr, i6));
                break;
            case 7:
                i6 = zzm(bArr, i6, zzcuVar);
                objValueOf = Boolean.valueOf(zzcuVar.zzb != 0);
                break;
            case 8:
                i6 = zzh(bArr, i6, zzcuVar);
                objValueOf = zzcuVar.zzc;
                break;
            case 9:
                int i8 = ((i5 >>> 3) << 3) | 4;
                zzge zzgeVarZzb = zzfu.zza().zzb(zzefVar.zza.getClass());
                Object objZze = zzdxVar.zze(zzefVar.zzb);
                if (objZze == null) {
                    objZze = zzgeVarZzb.zze();
                    zzdxVar.zzi(zzefVar.zzb, objZze);
                }
                return zzn(objZze, zzgeVarZzb, bArr, i6, i7, i8, zzcuVar);
            case 10:
                zzge zzgeVarZzb2 = zzfu.zza().zzb(zzefVar.zza.getClass());
                Object objZze2 = zzdxVar.zze(zzefVar.zzb);
                if (objZze2 == null) {
                    objZze2 = zzgeVarZzb2.zze();
                    zzdxVar.zzi(zzefVar.zzb, objZze2);
                }
                return zzo(objZze2, zzgeVarZzb2, bArr, i6, i7, zzcuVar);
            case 11:
                i6 = zza(bArr, i6, zzcuVar);
                objValueOf = zzcuVar.zzc;
                break;
            case 13:
                throw new IllegalStateException("Shouldn't reach here.");
            case 16:
                i6 = zzj(bArr, i6, zzcuVar);
                objValueOf = Integer.valueOf(zzdj.zzb(zzcuVar.zza));
                break;
            case 17:
                i6 = zzm(bArr, i6, zzcuVar);
                objValueOf = Long.valueOf(zzdj.zzc(zzcuVar.zzb));
                break;
        }
        zzdxVar.zzi(zzefVar.zzb, objValueOf);
        return i6;
    }

    public static int zzc(byte[] bArr, int i5) {
        int i6 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        int i7 = bArr[i5 + 1] & UnsignedBytes.MAX_VALUE;
        int i8 = bArr[i5 + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (i7 << 8) | i6 | (i8 << 16);
    }

    public static int zzd(zzge zzgeVar, byte[] bArr, int i5, int i6, int i7, zzcu zzcuVar) throws zzer {
        Object objZze = zzgeVar.zze();
        int iZzn = zzn(objZze, zzgeVar, bArr, i5, i6, i7, zzcuVar);
        zzgeVar.zzf(objZze);
        zzcuVar.zzc = objZze;
        return iZzn;
    }

    public static int zze(zzge zzgeVar, byte[] bArr, int i5, int i6, zzcu zzcuVar) throws zzer {
        Object objZze = zzgeVar.zze();
        int iZzo = zzo(objZze, zzgeVar, bArr, i5, i6, zzcuVar);
        zzgeVar.zzf(objZze);
        zzcuVar.zzc = objZze;
        return iZzo;
    }

    public static int zzf(zzge zzgeVar, int i5, byte[] bArr, int i6, int i7, zzeo zzeoVar, zzcu zzcuVar) throws zzer {
        int iZze = zze(zzgeVar, bArr, i6, i7, zzcuVar);
        zzeoVar.add(zzcuVar.zzc);
        while (iZze < i7) {
            int iZzj = zzj(bArr, iZze, zzcuVar);
            if (i5 != zzcuVar.zza) {
                break;
            }
            iZze = zze(zzgeVar, bArr, iZzj, i7, zzcuVar);
            zzeoVar.add(zzcuVar.zzc);
        }
        return iZze;
    }

    public static int zzg(byte[] bArr, int i5, zzeo zzeoVar, zzcu zzcuVar) throws zzer {
        zzei zzeiVar = (zzei) zzeoVar;
        int iZzj = zzj(bArr, i5, zzcuVar);
        int i6 = zzcuVar.zza + iZzj;
        while (iZzj < i6) {
            iZzj = zzj(bArr, iZzj, zzcuVar);
            zzeiVar.zzg(zzcuVar.zza);
        }
        if (iZzj == i6) {
            return iZzj;
        }
        throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzh(byte[] bArr, int i5, zzcu zzcuVar) throws zzer {
        int iZzj = zzj(bArr, i5, zzcuVar);
        int i6 = zzcuVar.zza;
        if (i6 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i6 == 0) {
            zzcuVar.zzc = "";
            return iZzj;
        }
        zzcuVar.zzc = new String(bArr, iZzj, i6, zzep.zza);
        return iZzj + i6;
    }

    public static int zzi(int i5, byte[] bArr, int i6, int i7, zzgt zzgtVar, zzcu zzcuVar) throws zzer {
        if ((i5 >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            int iZzm = zzm(bArr, i6, zzcuVar);
            zzgtVar.zzj(i5, Long.valueOf(zzcuVar.zzb));
            return iZzm;
        }
        if (i8 == 1) {
            zzgtVar.zzj(i5, Long.valueOf(zzq(bArr, i6)));
            return i6 + 8;
        }
        if (i8 == 2) {
            int iZzj = zzj(bArr, i6, zzcuVar);
            int i9 = zzcuVar.zza;
            if (i9 < 0) {
                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i9 > bArr.length - iZzj) {
                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i9 == 0) {
                zzgtVar.zzj(i5, zzdf.zzb);
            } else {
                zzgtVar.zzj(i5, zzdf.zzr(bArr, iZzj, i9));
            }
            return iZzj + i9;
        }
        if (i8 != 3) {
            if (i8 != 5) {
                throw new zzer("Protocol message contained an invalid tag (zero).");
            }
            zzgtVar.zzj(i5, Integer.valueOf(zzc(bArr, i6)));
            return i6 + 4;
        }
        int i10 = (i5 & (-8)) | 4;
        zzgt zzgtVarZzf = zzgt.zzf();
        int i11 = zzcuVar.zze + 1;
        zzcuVar.zze = i11;
        zzr(i11);
        int i12 = 0;
        while (i6 < i7) {
            int iZzj2 = zzj(bArr, i6, zzcuVar);
            int i13 = zzcuVar.zza;
            if (i13 == i10) {
                i12 = i13;
                i6 = iZzj2;
                break;
            }
            i6 = zzi(i13, bArr, iZzj2, i7, zzgtVarZzf, zzcuVar);
            i12 = i13;
        }
        zzcuVar.zze--;
        if (i6 > i7 || i12 != i10) {
            throw new zzer("Failed to parse the message.");
        }
        zzgtVar.zzj(i5, zzgtVarZzf);
        return i6;
    }

    public static int zzj(byte[] bArr, int i5, zzcu zzcuVar) {
        int i6 = i5 + 1;
        byte b = bArr[i5];
        if (b < 0) {
            return zzk(b, bArr, i6, zzcuVar);
        }
        zzcuVar.zza = b;
        return i6;
    }

    public static int zzk(int i5, byte[] bArr, int i6, zzcu zzcuVar) {
        byte b = bArr[i6];
        int i7 = i6 + 1;
        int i8 = i5 & 127;
        if (b >= 0) {
            zzcuVar.zza = i8 | (b << 7);
            return i7;
        }
        int i9 = i8 | ((b & Ascii.DEL) << 7);
        int i10 = i6 + 2;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzcuVar.zza = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & Ascii.DEL) << 14);
        int i12 = i6 + 3;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            zzcuVar.zza = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & Ascii.DEL) << 21);
        int i14 = i6 + 4;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            zzcuVar.zza = i13 | (b8 << Ascii.FS);
            return i14;
        }
        int i15 = i13 | ((b8 & Ascii.DEL) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] >= 0) {
                zzcuVar.zza = i15;
                return i16;
            }
            i14 = i16;
        }
    }

    public static int zzl(int i5, byte[] bArr, int i6, int i7, zzeo zzeoVar, zzcu zzcuVar) {
        zzei zzeiVar = (zzei) zzeoVar;
        int iZzj = zzj(bArr, i6, zzcuVar);
        zzeiVar.zzg(zzcuVar.zza);
        while (iZzj < i7) {
            int iZzj2 = zzj(bArr, iZzj, zzcuVar);
            if (i5 != zzcuVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzcuVar);
            zzeiVar.zzg(zzcuVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i5, zzcu zzcuVar) {
        long j6 = bArr[i5];
        int i6 = i5 + 1;
        if (j6 >= 0) {
            zzcuVar.zzb = j6;
            return i6;
        }
        int i7 = i5 + 2;
        byte b = bArr[i6];
        long j7 = (j6 & 127) | (((long) (b & Ascii.DEL)) << 7);
        int i8 = 7;
        while (b < 0) {
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            i8 += 7;
            j7 |= ((long) (b6 & Ascii.DEL)) << i8;
            b = b6;
            i7 = i9;
        }
        zzcuVar.zzb = j7;
        return i7;
    }

    public static int zzn(Object obj, zzge zzgeVar, byte[] bArr, int i5, int i6, int i7, zzcu zzcuVar) throws zzer {
        int i8 = zzcuVar.zze + 1;
        zzcuVar.zze = i8;
        zzr(i8);
        int iZzc = ((zzfp) zzgeVar).zzc(obj, bArr, i5, i6, i7, zzcuVar);
        zzcuVar.zze--;
        zzcuVar.zzc = obj;
        return iZzc;
    }

    public static int zzo(Object obj, zzge zzgeVar, byte[] bArr, int i5, int i6, zzcu zzcuVar) throws zzer {
        int iZzk = i5 + 1;
        int i7 = bArr[i5];
        if (i7 < 0) {
            iZzk = zzk(i7, bArr, iZzk, zzcuVar);
            i7 = zzcuVar.zza;
        }
        int i8 = iZzk;
        if (i7 < 0 || i7 > i6 - i8) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i9 = zzcuVar.zze + 1;
        zzcuVar.zze = i9;
        zzr(i9);
        int i10 = i8 + i7;
        zzgeVar.zzh(obj, bArr, i8, i10, zzcuVar);
        zzcuVar.zze--;
        zzcuVar.zzc = obj;
        return i10;
    }

    public static int zzp(int i5, byte[] bArr, int i6, int i7, zzcu zzcuVar) throws zzer {
        if ((i5 >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            return zzm(bArr, i6, zzcuVar);
        }
        if (i8 == 1) {
            return i6 + 8;
        }
        if (i8 == 2) {
            return zzj(bArr, i6, zzcuVar) + zzcuVar.zza;
        }
        if (i8 != 3) {
            if (i8 == 5) {
                return i6 + 4;
            }
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i9 = (i5 & (-8)) | 4;
        int i10 = 0;
        while (i6 < i7) {
            i6 = zzj(bArr, i6, zzcuVar);
            i10 = zzcuVar.zza;
            if (i10 == i9) {
                break;
            }
            i6 = zzp(i10, bArr, i6, i7, zzcuVar);
        }
        if (i6 > i7 || i10 != i9) {
            throw new zzer("Failed to parse the message.");
        }
        return i6;
    }

    public static long zzq(byte[] bArr, int i5) {
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48) | ((((long) bArr[i5 + 7]) & 255) << 56);
    }

    private static void zzr(int i5) throws zzer {
        if (i5 >= zzb) {
            throw new zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
