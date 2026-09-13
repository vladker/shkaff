package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zziy {
    public static /* bridge */ /* synthetic */ void zza(byte b, byte b6, byte b7, byte b8, char[] cArr, int i5) throws zzhb {
        if (!zze(b6)) {
            if ((((b6 + 112) + (b << Ascii.FS)) >> 30) == 0 && !zze(b7) && !zze(b8)) {
                int i6 = ((b & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
                cArr[i5] = (char) ((i6 >>> 10) + 55232);
                cArr[i5 + 1] = (char) ((i6 & IEEEDouble.EXPONENT_BIAS) + 56320);
                return;
            }
        }
        throw new zzhb("Protocol message had invalid UTF-8.");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    /* JADX WARN: Code duplicated, block: B:12:0x0016 A[PHI: r2
  0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x001c  */
    public static /* bridge */ /* synthetic */ void zzb(byte b, byte b6, byte b7, char[] cArr, int i5) throws zzhb {
        if (!zze(b6)) {
            if (b != -32) {
                if (b != -19) {
                    if (!zze(b7)) {
                        cArr[i5] = (char) (((b & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
                        return;
                    }
                } else if (b6 < -96) {
                    b = -19;
                    if (!zze(b7)) {
                        cArr[i5] = (char) (((b & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
                        return;
                    }
                }
            } else if (b6 >= -96) {
                b = -32;
                if (b != -19) {
                    if (!zze(b7)) {
                        cArr[i5] = (char) (((b & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
                        return;
                    }
                } else if (b6 < -96) {
                    b = -19;
                    if (!zze(b7)) {
                        cArr[i5] = (char) (((b & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
                        return;
                    }
                }
            }
        }
        throw new zzhb("Protocol message had invalid UTF-8.");
    }

    public static /* bridge */ /* synthetic */ void zzc(byte b, byte b6, char[] cArr, int i5) throws zzhb {
        if (b < -62 || zze(b6)) {
            throw new zzhb("Protocol message had invalid UTF-8.");
        }
        cArr[i5] = (char) (((b & 31) << 6) | (b6 & 63));
    }

    public static /* bridge */ /* synthetic */ boolean zzd(byte b) {
        return b >= 0;
    }

    private static boolean zze(byte b) {
        return b > -65;
    }
}
