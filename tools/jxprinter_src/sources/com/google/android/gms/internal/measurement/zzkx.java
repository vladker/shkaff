package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkx {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i5, zzkw zzkwVar) {
        int i6 = i5 + 1;
        byte b = bArr[i5];
        if (b < 0) {
            return zzb(b, bArr, i6, zzkwVar);
        }
        zzkwVar.zza = b;
        return i6;
    }

    public static int zzb(int i5, byte[] bArr, int i6, zzkw zzkwVar) {
        byte b = bArr[i6];
        int i7 = i6 + 1;
        int i8 = i5 & 127;
        if (b >= 0) {
            zzkwVar.zza = i8 | (b << 7);
            return i7;
        }
        int i9 = i8 | ((b & Ascii.DEL) << 7);
        int i10 = i6 + 2;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzkwVar.zza = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & Ascii.DEL) << 14);
        int i12 = i6 + 3;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            zzkwVar.zza = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & Ascii.DEL) << 21);
        int i14 = i6 + 4;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            zzkwVar.zza = i13 | (b8 << Ascii.FS);
            return i14;
        }
        int i15 = i13 | ((b8 & Ascii.DEL) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] >= 0) {
                zzkwVar.zza = i15;
                return i16;
            }
            i14 = i16;
        }
    }

    public static int zzc(byte[] bArr, int i5, zzkw zzkwVar) {
        long j6 = bArr[i5];
        int i6 = i5 + 1;
        if (j6 >= 0) {
            zzkwVar.zzb = j6;
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
        zzkwVar.zzb = j7;
        return i7;
    }

    public static int zzd(byte[] bArr, int i5) {
        int i6 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        int i7 = bArr[i5 + 1] & UnsignedBytes.MAX_VALUE;
        int i8 = bArr[i5 + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (i7 << 8) | i6 | (i8 << 16);
    }

    public static long zze(byte[] bArr, int i5) {
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48) | ((((long) bArr[i5 + 7]) & 255) << 56);
    }

    public static int zzf(byte[] bArr, int i5, zzkw zzkwVar) throws zzmr {
        int i6;
        int iZza = zza(bArr, i5, zzkwVar);
        int i7 = zzkwVar.zza;
        if (i7 < 0) {
            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i7 == 0) {
            zzkwVar.zzc = "";
            return iZza;
        }
        int i8 = zzos.zza;
        int length = bArr.length;
        if ((((length - iZza) - i7) | iZza | i7) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZza), Integer.valueOf(i7)));
        }
        int i9 = iZza + i7;
        char[] cArr = new char[i7];
        int i10 = 0;
        while (iZza < i9) {
            byte b = bArr[iZza];
            if (!zzoq.zza(b)) {
                break;
            }
            iZza++;
            cArr[i10] = (char) b;
            i10++;
        }
        int i11 = i10;
        while (iZza < i9) {
            int i12 = iZza + 1;
            byte b6 = bArr[iZza];
            if (zzoq.zza(b6)) {
                cArr[i11] = (char) b6;
                i11++;
                iZza = i12;
                while (iZza < i9) {
                    byte b7 = bArr[iZza];
                    if (!zzoq.zza(b7)) {
                        break;
                    }
                    iZza++;
                    cArr[i11] = (char) b7;
                    i11++;
                }
            } else {
                if (b6 < -32) {
                    if (i12 >= i9) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    i6 = i11 + 1;
                    iZza += 2;
                    zzoq.zzb(b6, bArr[i12], cArr, i11);
                } else if (b6 < -16) {
                    if (i12 >= i9 - 1) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    i6 = i11 + 1;
                    int i13 = iZza + 2;
                    iZza += 3;
                    zzoq.zzc(b6, bArr[i12], bArr[i13], cArr, i11);
                } else {
                    if (i12 >= i9 - 2) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    byte b8 = bArr[i12];
                    int i14 = iZza + 3;
                    byte b9 = bArr[iZza + 2];
                    iZza += 4;
                    zzoq.zzd(b6, b8, b9, bArr[i14], cArr, i11);
                    i11 += 2;
                }
                i11 = i6;
            }
        }
        zzkwVar.zzc = new String(cArr, 0, i11);
        return i9;
    }

    public static int zzg(byte[] bArr, int i5, zzkw zzkwVar) throws zzmr {
        int iZza = zza(bArr, i5, zzkwVar);
        int i6 = zzkwVar.zza;
        if (i6 < 0) {
            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i6 > bArr.length - iZza) {
            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i6 == 0) {
            zzkwVar.zzc = zzlh.zzb;
            return iZza;
        }
        zzkwVar.zzc = zzlh.zzh(bArr, iZza, i6);
        return iZza + i6;
    }

    public static int zzh(zznx zznxVar, byte[] bArr, int i5, int i6, zzkw zzkwVar) throws zzmr {
        Object objZza = zznxVar.zza();
        int iZzj = zzj(objZza, zznxVar, bArr, i5, i6, zzkwVar);
        zznxVar.zzj(objZza);
        zzkwVar.zzc = objZza;
        return iZzj;
    }

    public static int zzi(zznx zznxVar, byte[] bArr, int i5, int i6, int i7, zzkw zzkwVar) throws zzmr {
        Object objZza = zznxVar.zza();
        int iZzk = zzk(objZza, zznxVar, bArr, i5, i6, i7, zzkwVar);
        zznxVar.zzj(objZza);
        zzkwVar.zzc = objZza;
        return iZzk;
    }

    public static int zzj(Object obj, zznx zznxVar, byte[] bArr, int i5, int i6, zzkw zzkwVar) throws zzmr {
        int iZzb = i5 + 1;
        int i7 = bArr[i5];
        if (i7 < 0) {
            iZzb = zzb(i7, bArr, iZzb, zzkwVar);
            i7 = zzkwVar.zza;
        }
        int i8 = iZzb;
        if (i7 < 0 || i7 > i6 - i8) {
            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i9 = zzkwVar.zze + 1;
        zzkwVar.zze = i9;
        zzq(i9);
        int i10 = i8 + i7;
        zznxVar.zzi(obj, bArr, i8, i10, zzkwVar);
        zzkwVar.zze--;
        zzkwVar.zzc = obj;
        return i10;
    }

    public static int zzk(Object obj, zznx zznxVar, byte[] bArr, int i5, int i6, int i7, zzkw zzkwVar) throws zzmr {
        int i8 = zzkwVar.zze + 1;
        zzkwVar.zze = i8;
        zzq(i8);
        int iZzh = ((zznp) zznxVar).zzh(obj, bArr, i5, i6, i7, zzkwVar);
        zzkwVar.zze--;
        zzkwVar.zzc = obj;
        return iZzh;
    }

    public static int zzl(int i5, byte[] bArr, int i6, int i7, zzmo zzmoVar, zzkw zzkwVar) {
        zzmg zzmgVar = (zzmg) zzmoVar;
        int iZza = zza(bArr, i6, zzkwVar);
        zzmgVar.zzh(zzkwVar.zza);
        while (iZza < i7) {
            int iZza2 = zza(bArr, iZza, zzkwVar);
            if (i5 != zzkwVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzkwVar);
            zzmgVar.zzh(zzkwVar.zza);
        }
        return iZza;
    }

    public static int zzm(byte[] bArr, int i5, zzmo zzmoVar, zzkw zzkwVar) throws zzmr {
        zzmg zzmgVar = (zzmg) zzmoVar;
        int iZza = zza(bArr, i5, zzkwVar);
        int i6 = zzkwVar.zza + iZza;
        while (iZza < i6) {
            iZza = zza(bArr, iZza, zzkwVar);
            zzmgVar.zzh(zzkwVar.zza);
        }
        if (iZza == i6) {
            return iZza;
        }
        throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzn(zznx zznxVar, int i5, byte[] bArr, int i6, int i7, zzmo zzmoVar, zzkw zzkwVar) throws zzmr {
        int iZzh = zzh(zznxVar, bArr, i6, i7, zzkwVar);
        zzmoVar.add(zzkwVar.zzc);
        while (iZzh < i7) {
            int iZza = zza(bArr, iZzh, zzkwVar);
            if (i5 != zzkwVar.zza) {
                break;
            }
            iZzh = zzh(zznxVar, bArr, iZza, i7, zzkwVar);
            zzmoVar.add(zzkwVar.zzc);
        }
        return iZzh;
    }

    public static int zzo(int i5, byte[] bArr, int i6, int i7, zzoj zzojVar, zzkw zzkwVar) throws zzmr {
        if ((i5 >>> 3) == 0) {
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            int iZzc = zzc(bArr, i6, zzkwVar);
            zzojVar.zzk(i5, Long.valueOf(zzkwVar.zzb));
            return iZzc;
        }
        if (i8 == 1) {
            zzojVar.zzk(i5, Long.valueOf(zze(bArr, i6)));
            return i6 + 8;
        }
        if (i8 == 2) {
            int iZza = zza(bArr, i6, zzkwVar);
            int i9 = zzkwVar.zza;
            if (i9 < 0) {
                throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i9 > bArr.length - iZza) {
                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i9 == 0) {
                zzojVar.zzk(i5, zzlh.zzb);
            } else {
                zzojVar.zzk(i5, zzlh.zzh(bArr, iZza, i9));
            }
            return iZza + i9;
        }
        if (i8 != 3) {
            if (i8 != 5) {
                throw new zzmr("Protocol message contained an invalid tag (zero).");
            }
            zzojVar.zzk(i5, Integer.valueOf(zzd(bArr, i6)));
            return i6 + 4;
        }
        int i10 = (i5 & (-8)) | 4;
        zzoj zzojVarZzb = zzoj.zzb();
        int i11 = zzkwVar.zze + 1;
        zzkwVar.zze = i11;
        zzq(i11);
        int i12 = 0;
        while (i6 < i7) {
            int iZza2 = zza(bArr, i6, zzkwVar);
            int i13 = zzkwVar.zza;
            if (i13 == i10) {
                i12 = i13;
                i6 = iZza2;
                break;
            }
            i6 = zzo(i13, bArr, iZza2, i7, zzojVarZzb, zzkwVar);
            i12 = i13;
        }
        zzkwVar.zze--;
        if (i6 > i7 || i12 != i10) {
            throw new zzmr("Failed to parse the message.");
        }
        zzojVar.zzk(i5, zzojVarZzb);
        return i6;
    }

    public static int zzp(int i5, byte[] bArr, int i6, int i7, zzkw zzkwVar) throws zzmr {
        if ((i5 >>> 3) == 0) {
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            return zzc(bArr, i6, zzkwVar);
        }
        if (i8 == 1) {
            return i6 + 8;
        }
        if (i8 == 2) {
            return zza(bArr, i6, zzkwVar) + zzkwVar.zza;
        }
        if (i8 != 3) {
            if (i8 == 5) {
                return i6 + 4;
            }
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i9 = (i5 & (-8)) | 4;
        int i10 = 0;
        while (i6 < i7) {
            i6 = zza(bArr, i6, zzkwVar);
            i10 = zzkwVar.zza;
            if (i10 == i9) {
                break;
            }
            i6 = zzp(i10, bArr, i6, i7, zzkwVar);
        }
        if (i6 > i7 || i10 != i9) {
            throw new zzmr("Failed to parse the message.");
        }
        return i6;
    }

    private static void zzq(int i5) throws zzmr {
        if (i5 >= zzb) {
            throw new zzmr("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
