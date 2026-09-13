package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfe {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i5, zzfd zzfdVar) throws zzhb {
        int iZzi = zzi(bArr, i5, zzfdVar);
        int i6 = zzfdVar.zza;
        if (i6 < 0) {
            throw new zzhb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i6 > bArr.length - iZzi) {
            throw new zzhb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i6 == 0) {
            zzfdVar.zzc = zzfp.zza;
            return iZzi;
        }
        zzfdVar.zzc = zzfp.zzk(bArr, iZzi, i6);
        return iZzi + i6;
    }

    public static int zzb(byte[] bArr, int i5) {
        int i6 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        int i7 = bArr[i5 + 1] & UnsignedBytes.MAX_VALUE;
        int i8 = bArr[i5 + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (i7 << 8) | i6 | (i8 << 16);
    }

    public static int zzc(zzib zzibVar, byte[] bArr, int i5, int i6, int i7, zzfd zzfdVar) throws zzhb {
        Object objZze = zzibVar.zze();
        int iZzm = zzm(objZze, zzibVar, bArr, i5, i6, i7, zzfdVar);
        zzibVar.zzf(objZze);
        zzfdVar.zzc = objZze;
        return iZzm;
    }

    public static int zzd(zzib zzibVar, byte[] bArr, int i5, int i6, zzfd zzfdVar) throws zzhb {
        Object objZze = zzibVar.zze();
        int iZzn = zzn(objZze, zzibVar, bArr, i5, i6, zzfdVar);
        zzibVar.zzf(objZze);
        zzfdVar.zzc = objZze;
        return iZzn;
    }

    public static int zze(zzib zzibVar, int i5, byte[] bArr, int i6, int i7, zzgu zzguVar, zzfd zzfdVar) throws zzhb {
        int iZzd = zzd(zzibVar, bArr, i6, i7, zzfdVar);
        zzguVar.add(zzfdVar.zzc);
        while (iZzd < i7) {
            int iZzi = zzi(bArr, iZzd, zzfdVar);
            if (i5 != zzfdVar.zza) {
                break;
            }
            iZzd = zzd(zzibVar, bArr, iZzi, i7, zzfdVar);
            zzguVar.add(zzfdVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i5, zzgu zzguVar, zzfd zzfdVar) throws zzhb {
        zzgq zzgqVar = (zzgq) zzguVar;
        int iZzi = zzi(bArr, i5, zzfdVar);
        int i6 = zzfdVar.zza;
        if (i6 < 0) {
            throw new zzhb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i6 > bArr.length - iZzi) {
            throw new zzhb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i7 = i6 + iZzi;
        while (iZzi < i7) {
            iZzi = zzi(bArr, iZzi, zzfdVar);
            zzgqVar.zzh(zzfdVar.zza);
        }
        if (iZzi == i7) {
            return iZzi;
        }
        throw new zzhb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzg(byte[] bArr, int i5, zzfd zzfdVar) throws zzhb {
        int i6;
        int iZzi = zzi(bArr, i5, zzfdVar);
        int i7 = zzfdVar.zza;
        if (i7 < 0) {
            throw new zzhb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i7 == 0) {
            zzfdVar.zzc = "";
            return iZzi;
        }
        int i8 = zzjc.zza;
        int length = bArr.length;
        if ((((length - iZzi) - i7) | iZzi | i7) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzi), Integer.valueOf(i7)));
        }
        int i9 = iZzi + i7;
        char[] cArr = new char[i7];
        int i10 = 0;
        while (iZzi < i9) {
            byte b = bArr[iZzi];
            if (!zziy.zzd(b)) {
                break;
            }
            iZzi++;
            cArr[i10] = (char) b;
            i10++;
        }
        int i11 = i10;
        while (iZzi < i9) {
            int i12 = iZzi + 1;
            byte b6 = bArr[iZzi];
            if (zziy.zzd(b6)) {
                cArr[i11] = (char) b6;
                i11++;
                iZzi = i12;
                while (iZzi < i9) {
                    byte b7 = bArr[iZzi];
                    if (!zziy.zzd(b7)) {
                        break;
                    }
                    iZzi++;
                    cArr[i11] = (char) b7;
                    i11++;
                }
            } else {
                if (b6 < -32) {
                    if (i12 >= i9) {
                        throw new zzhb("Protocol message had invalid UTF-8.");
                    }
                    i6 = i11 + 1;
                    iZzi += 2;
                    zziy.zzc(b6, bArr[i12], cArr, i11);
                } else if (b6 < -16) {
                    if (i12 >= i9 - 1) {
                        throw new zzhb("Protocol message had invalid UTF-8.");
                    }
                    i6 = i11 + 1;
                    int i13 = iZzi + 2;
                    iZzi += 3;
                    zziy.zzb(b6, bArr[i12], bArr[i13], cArr, i11);
                } else {
                    if (i12 >= i9 - 2) {
                        throw new zzhb("Protocol message had invalid UTF-8.");
                    }
                    byte b8 = bArr[i12];
                    int i14 = iZzi + 3;
                    byte b9 = bArr[iZzi + 2];
                    iZzi += 4;
                    zziy.zza(b6, b8, b9, bArr[i14], cArr, i11);
                    i11 += 2;
                }
                i11 = i6;
            }
        }
        zzfdVar.zzc = new String(cArr, 0, i11);
        return i9;
    }

    public static int zzh(int i5, byte[] bArr, int i6, int i7, zzir zzirVar, zzfd zzfdVar) throws zzhb {
        if ((i5 >>> 3) == 0) {
            throw new zzhb("Protocol message contained an invalid tag (zero).");
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            int iZzl = zzl(bArr, i6, zzfdVar);
            zzirVar.zzj(i5, Long.valueOf(zzfdVar.zzb));
            return iZzl;
        }
        if (i8 == 1) {
            zzirVar.zzj(i5, Long.valueOf(zzp(bArr, i6)));
            return i6 + 8;
        }
        if (i8 == 2) {
            int iZzi = zzi(bArr, i6, zzfdVar);
            int i9 = zzfdVar.zza;
            if (i9 < 0) {
                throw new zzhb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i9 > bArr.length - iZzi) {
                throw new zzhb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i9 == 0) {
                zzirVar.zzj(i5, zzfp.zza);
            } else {
                zzirVar.zzj(i5, zzfp.zzk(bArr, iZzi, i9));
            }
            return iZzi + i9;
        }
        if (i8 != 3) {
            if (i8 != 5) {
                throw new zzhb("Protocol message contained an invalid tag (zero).");
            }
            zzirVar.zzj(i5, Integer.valueOf(zzb(bArr, i6)));
            return i6 + 4;
        }
        int i10 = (i5 & (-8)) | 4;
        zzir zzirVarZzf = zzir.zzf();
        int i11 = zzfdVar.zze + 1;
        zzfdVar.zze = i11;
        zzq(i11);
        int i12 = 0;
        while (i6 < i7) {
            int iZzi2 = zzi(bArr, i6, zzfdVar);
            int i13 = zzfdVar.zza;
            if (i13 == i10) {
                i12 = i13;
                i6 = iZzi2;
                break;
            }
            i6 = zzh(i13, bArr, iZzi2, i7, zzirVarZzf, zzfdVar);
            i12 = i13;
        }
        zzfdVar.zze--;
        if (i6 > i7 || i12 != i10) {
            throw new zzhb("Failed to parse the message.");
        }
        zzirVar.zzj(i5, zzirVarZzf);
        return i6;
    }

    public static int zzi(byte[] bArr, int i5, zzfd zzfdVar) {
        int i6 = i5 + 1;
        byte b = bArr[i5];
        if (b < 0) {
            return zzj(b, bArr, i6, zzfdVar);
        }
        zzfdVar.zza = b;
        return i6;
    }

    public static int zzj(int i5, byte[] bArr, int i6, zzfd zzfdVar) {
        byte b = bArr[i6];
        int i7 = i6 + 1;
        int i8 = i5 & 127;
        if (b >= 0) {
            zzfdVar.zza = i8 | (b << 7);
            return i7;
        }
        int i9 = i8 | ((b & Ascii.DEL) << 7);
        int i10 = i6 + 2;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zzfdVar.zza = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & Ascii.DEL) << 14);
        int i12 = i6 + 3;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            zzfdVar.zza = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & Ascii.DEL) << 21);
        int i14 = i6 + 4;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            zzfdVar.zza = i13 | (b8 << Ascii.FS);
            return i14;
        }
        int i15 = i13 | ((b8 & Ascii.DEL) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] >= 0) {
                zzfdVar.zza = i15;
                return i16;
            }
            i14 = i16;
        }
    }

    public static int zzk(int i5, byte[] bArr, int i6, int i7, zzgu zzguVar, zzfd zzfdVar) {
        zzgq zzgqVar = (zzgq) zzguVar;
        int iZzi = zzi(bArr, i6, zzfdVar);
        zzgqVar.zzh(zzfdVar.zza);
        while (iZzi < i7) {
            int iZzi2 = zzi(bArr, iZzi, zzfdVar);
            if (i5 != zzfdVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zzfdVar);
            zzgqVar.zzh(zzfdVar.zza);
        }
        return iZzi;
    }

    public static int zzl(byte[] bArr, int i5, zzfd zzfdVar) {
        long j6 = bArr[i5];
        int i6 = i5 + 1;
        if (j6 >= 0) {
            zzfdVar.zzb = j6;
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
        zzfdVar.zzb = j7;
        return i7;
    }

    public static int zzm(Object obj, zzib zzibVar, byte[] bArr, int i5, int i6, int i7, zzfd zzfdVar) throws zzhb {
        int i8 = zzfdVar.zze + 1;
        zzfdVar.zze = i8;
        zzq(i8);
        int iZzc = ((zzhu) zzibVar).zzc(obj, bArr, i5, i6, i7, zzfdVar);
        zzfdVar.zze--;
        zzfdVar.zzc = obj;
        return iZzc;
    }

    public static int zzn(Object obj, zzib zzibVar, byte[] bArr, int i5, int i6, zzfd zzfdVar) throws zzhb {
        int iZzj = i5 + 1;
        int i7 = bArr[i5];
        if (i7 < 0) {
            iZzj = zzj(i7, bArr, iZzj, zzfdVar);
            i7 = zzfdVar.zza;
        }
        int i8 = iZzj;
        if (i7 < 0 || i7 > i6 - i8) {
            throw new zzhb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i9 = zzfdVar.zze + 1;
        zzfdVar.zze = i9;
        zzq(i9);
        int i10 = i8 + i7;
        zzibVar.zzh(obj, bArr, i8, i10, zzfdVar);
        zzfdVar.zze--;
        zzfdVar.zzc = obj;
        return i10;
    }

    public static int zzo(int i5, byte[] bArr, int i6, int i7, zzfd zzfdVar) throws zzhb {
        if ((i5 >>> 3) == 0) {
            throw new zzhb("Protocol message contained an invalid tag (zero).");
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            return zzl(bArr, i6, zzfdVar);
        }
        if (i8 == 1) {
            return i6 + 8;
        }
        if (i8 == 2) {
            return zzi(bArr, i6, zzfdVar) + zzfdVar.zza;
        }
        if (i8 != 3) {
            if (i8 == 5) {
                return i6 + 4;
            }
            throw new zzhb("Protocol message contained an invalid tag (zero).");
        }
        int i9 = (i5 & (-8)) | 4;
        int i10 = zzfdVar.zze + 1;
        zzfdVar.zze = i10;
        zzq(i10);
        int i11 = 0;
        while (i6 < i7) {
            i6 = zzi(bArr, i6, zzfdVar);
            i11 = zzfdVar.zza;
            if (i11 == i9) {
                break;
            }
            i6 = zzo(i11, bArr, i6, i7, zzfdVar);
        }
        zzfdVar.zze--;
        if (i6 > i7 || i11 != i9) {
            throw new zzhb("Failed to parse the message.");
        }
        return i6;
    }

    public static long zzp(byte[] bArr, int i5) {
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48) | ((((long) bArr[i5 + 7]) & 255) << 56);
    }

    private static void zzq(int i5) throws zzhb {
        if (i5 >= zzb) {
            throw new zzhb("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
