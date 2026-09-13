package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbsr {
    public static final /* synthetic */ int zba = 0;
    private static volatile int zbb = 100;

    public static int zba(byte[] bArr, int i5, zbsq zbsqVar) throws zbuq {
        int iZbk = zbk(bArr, i5, zbsqVar);
        int i6 = zbsqVar.zba;
        if (i6 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i6 > bArr.length - iZbk) {
            throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i6 == 0) {
            zbsqVar.zbc = zbtc.zbb;
            return iZbk;
        }
        zbsqVar.zbc = zbtc.zbj(bArr, iZbk, i6);
        return iZbk + i6;
    }

    public static int zbb(int i5, byte[] bArr, int i6, int i7, zbub zbubVar, zbud zbudVar, zbwl zbwlVar, zbsq zbsqVar) throws zbuq {
        zbtu zbtuVar = zbubVar.zbb;
        zbww zbwwVar = zbudVar.zbb.zbb;
        Object objValueOf = null;
        if (zbwwVar == zbww.zbn) {
            zbk(bArr, i6, zbsqVar);
            throw null;
        }
        switch (zbwwVar.ordinal()) {
            case 0:
                i6 += 8;
                objValueOf = Double.valueOf(Double.longBitsToDouble(zbr(bArr, i6)));
                break;
            case 1:
                i6 += 4;
                objValueOf = Float.valueOf(Float.intBitsToFloat(zbc(bArr, i6)));
                break;
            case 2:
            case 3:
                i6 = zbn(bArr, i6, zbsqVar);
                objValueOf = Long.valueOf(zbsqVar.zbb);
                break;
            case 4:
            case 12:
                i6 = zbk(bArr, i6, zbsqVar);
                objValueOf = Integer.valueOf(zbsqVar.zba);
                break;
            case 5:
            case 15:
                i6 += 8;
                objValueOf = Long.valueOf(zbr(bArr, i6));
                break;
            case 6:
            case 14:
                i6 += 4;
                objValueOf = Integer.valueOf(zbc(bArr, i6));
                break;
            case 7:
                i6 = zbn(bArr, i6, zbsqVar);
                objValueOf = Boolean.valueOf(zbsqVar.zbb != 0);
                break;
            case 8:
                i6 = zbh(bArr, i6, zbsqVar);
                objValueOf = zbsqVar.zbc;
                break;
            case 9:
                int i8 = ((i5 >>> 3) << 3) | 4;
                zbvx zbvxVarZbb = zbvu.zba().zbb(zbudVar.zba.getClass());
                Object objZbf = zbtuVar.zbf(zbudVar.zbb);
                if (objZbf == null) {
                    objZbf = zbvxVarZbb.zbe();
                    zbtuVar.zbj(zbudVar.zbb, objZbf);
                }
                return zbo(objZbf, zbvxVarZbb, bArr, i6, i7, i8, zbsqVar);
            case 10:
                zbvx zbvxVarZbb2 = zbvu.zba().zbb(zbudVar.zba.getClass());
                Object objZbf2 = zbtuVar.zbf(zbudVar.zbb);
                if (objZbf2 == null) {
                    objZbf2 = zbvxVarZbb2.zbe();
                    zbtuVar.zbj(zbudVar.zbb, objZbf2);
                }
                return zbp(objZbf2, zbvxVarZbb2, bArr, i6, i7, zbsqVar);
            case 11:
                i6 = zba(bArr, i6, zbsqVar);
                objValueOf = zbsqVar.zbc;
                break;
            case 13:
                throw new IllegalStateException("Shouldn't reach here.");
            case 16:
                i6 = zbk(bArr, i6, zbsqVar);
                objValueOf = Integer.valueOf(zbtg.zbb(zbsqVar.zba));
                break;
            case 17:
                i6 = zbn(bArr, i6, zbsqVar);
                objValueOf = Long.valueOf(zbtg.zbc(zbsqVar.zbb));
                break;
        }
        zbtuVar.zbj(zbudVar.zbb, objValueOf);
        return i6;
    }

    public static int zbc(byte[] bArr, int i5) {
        int i6 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        int i7 = bArr[i5 + 1] & UnsignedBytes.MAX_VALUE;
        int i8 = bArr[i5 + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (i7 << 8) | i6 | (i8 << 16);
    }

    public static int zbd(zbvx zbvxVar, byte[] bArr, int i5, int i6, int i7, zbsq zbsqVar) throws zbuq {
        Object objZbe = zbvxVar.zbe();
        int iZbo = zbo(objZbe, zbvxVar, bArr, i5, i6, i7, zbsqVar);
        zbvxVar.zbf(objZbe);
        zbsqVar.zbc = objZbe;
        return iZbo;
    }

    public static int zbe(zbvx zbvxVar, byte[] bArr, int i5, int i6, zbsq zbsqVar) throws zbuq {
        Object objZbe = zbvxVar.zbe();
        int iZbp = zbp(objZbe, zbvxVar, bArr, i5, i6, zbsqVar);
        zbvxVar.zbf(objZbe);
        zbsqVar.zbc = objZbe;
        return iZbp;
    }

    public static int zbf(zbvx zbvxVar, int i5, byte[] bArr, int i6, int i7, zbun zbunVar, zbsq zbsqVar) throws zbuq {
        int iZbe = zbe(zbvxVar, bArr, i6, i7, zbsqVar);
        zbunVar.add(zbsqVar.zbc);
        while (iZbe < i7) {
            int iZbk = zbk(bArr, iZbe, zbsqVar);
            if (i5 != zbsqVar.zba) {
                break;
            }
            iZbe = zbe(zbvxVar, bArr, iZbk, i7, zbsqVar);
            zbunVar.add(zbsqVar.zbc);
        }
        return iZbe;
    }

    public static int zbg(byte[] bArr, int i5, zbun zbunVar, zbsq zbsqVar) throws zbuq {
        zbug zbugVar = (zbug) zbunVar;
        int iZbk = zbk(bArr, i5, zbsqVar);
        int i6 = zbsqVar.zba + iZbk;
        while (iZbk < i6) {
            iZbk = zbk(bArr, iZbk, zbsqVar);
            zbugVar.zbg(zbsqVar.zba);
        }
        if (iZbk == i6) {
            return iZbk;
        }
        throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zbh(byte[] bArr, int i5, zbsq zbsqVar) throws zbuq {
        int iZbk = zbk(bArr, i5, zbsqVar);
        int i6 = zbsqVar.zba;
        if (i6 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i6 == 0) {
            zbsqVar.zbc = "";
            return iZbk;
        }
        zbsqVar.zbc = new String(bArr, iZbk, i6, zbuo.zba);
        return iZbk + i6;
    }

    public static int zbi(byte[] bArr, int i5, zbsq zbsqVar) throws zbuq {
        int i6;
        int iZbk = zbk(bArr, i5, zbsqVar);
        int i7 = zbsqVar.zba;
        if (i7 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i7 == 0) {
            zbsqVar.zbc = "";
            return iZbk;
        }
        int i8 = zbwv.zba;
        int length = bArr.length;
        if ((((length - iZbk) - i7) | iZbk | i7) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZbk), Integer.valueOf(i7)));
        }
        int i9 = iZbk + i7;
        char[] cArr = new char[i7];
        int i10 = 0;
        while (iZbk < i9) {
            byte b = bArr[iZbk];
            if (!zbwt.zbd(b)) {
                break;
            }
            iZbk++;
            cArr[i10] = (char) b;
            i10++;
        }
        int i11 = i10;
        while (iZbk < i9) {
            int i12 = iZbk + 1;
            byte b6 = bArr[iZbk];
            if (zbwt.zbd(b6)) {
                cArr[i11] = (char) b6;
                i11++;
                iZbk = i12;
                while (iZbk < i9) {
                    byte b7 = bArr[iZbk];
                    if (!zbwt.zbd(b7)) {
                        break;
                    }
                    iZbk++;
                    cArr[i11] = (char) b7;
                    i11++;
                }
            } else {
                if (b6 < -32) {
                    if (i12 >= i9) {
                        throw new zbuq("Protocol message had invalid UTF-8.");
                    }
                    i6 = i11 + 1;
                    iZbk += 2;
                    zbwt.zbc(b6, bArr[i12], cArr, i11);
                } else if (b6 < -16) {
                    if (i12 >= i9 - 1) {
                        throw new zbuq("Protocol message had invalid UTF-8.");
                    }
                    i6 = i11 + 1;
                    int i13 = iZbk + 2;
                    iZbk += 3;
                    zbwt.zbb(b6, bArr[i12], bArr[i13], cArr, i11);
                } else {
                    if (i12 >= i9 - 2) {
                        throw new zbuq("Protocol message had invalid UTF-8.");
                    }
                    byte b8 = bArr[i12];
                    int i14 = iZbk + 3;
                    byte b9 = bArr[iZbk + 2];
                    iZbk += 4;
                    zbwt.zba(b6, b8, b9, bArr[i14], cArr, i11);
                    i11 += 2;
                }
                i11 = i6;
            }
        }
        zbsqVar.zbc = new String(cArr, 0, i11);
        return i9;
    }

    public static int zbj(int i5, byte[] bArr, int i6, int i7, zbwm zbwmVar, zbsq zbsqVar) throws zbuq {
        if ((i5 >>> 3) == 0) {
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            int iZbn = zbn(bArr, i6, zbsqVar);
            zbwmVar.zbj(i5, Long.valueOf(zbsqVar.zbb));
            return iZbn;
        }
        if (i8 == 1) {
            zbwmVar.zbj(i5, Long.valueOf(zbr(bArr, i6)));
            return i6 + 8;
        }
        if (i8 == 2) {
            int iZbk = zbk(bArr, i6, zbsqVar);
            int i9 = zbsqVar.zba;
            if (i9 < 0) {
                throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i9 > bArr.length - iZbk) {
                throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i9 == 0) {
                zbwmVar.zbj(i5, zbtc.zbb);
            } else {
                zbwmVar.zbj(i5, zbtc.zbj(bArr, iZbk, i9));
            }
            return iZbk + i9;
        }
        if (i8 != 3) {
            if (i8 != 5) {
                throw new zbuq("Protocol message contained an invalid tag (zero).");
            }
            zbwmVar.zbj(i5, Integer.valueOf(zbc(bArr, i6)));
            return i6 + 4;
        }
        int i10 = (i5 & (-8)) | 4;
        zbwm zbwmVarZbf = zbwm.zbf();
        int i11 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i11;
        zbs(i11);
        int i12 = 0;
        while (i6 < i7) {
            int iZbk2 = zbk(bArr, i6, zbsqVar);
            int i13 = zbsqVar.zba;
            if (i13 == i10) {
                i12 = i13;
                i6 = iZbk2;
                break;
            }
            i6 = zbj(i13, bArr, iZbk2, i7, zbwmVarZbf, zbsqVar);
            i12 = i13;
        }
        zbsqVar.zbe--;
        if (i6 > i7 || i12 != i10) {
            throw new zbuq("Failed to parse the message.");
        }
        zbwmVar.zbj(i5, zbwmVarZbf);
        return i6;
    }

    public static int zbk(byte[] bArr, int i5, zbsq zbsqVar) {
        int i6 = i5 + 1;
        byte b = bArr[i5];
        if (b < 0) {
            return zbl(b, bArr, i6, zbsqVar);
        }
        zbsqVar.zba = b;
        return i6;
    }

    public static int zbl(int i5, byte[] bArr, int i6, zbsq zbsqVar) {
        byte b = bArr[i6];
        int i7 = i6 + 1;
        int i8 = i5 & 127;
        if (b >= 0) {
            zbsqVar.zba = i8 | (b << 7);
            return i7;
        }
        int i9 = i8 | ((b & Ascii.DEL) << 7);
        int i10 = i6 + 2;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            zbsqVar.zba = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & Ascii.DEL) << 14);
        int i12 = i6 + 3;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            zbsqVar.zba = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & Ascii.DEL) << 21);
        int i14 = i6 + 4;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            zbsqVar.zba = i13 | (b8 << Ascii.FS);
            return i14;
        }
        int i15 = i13 | ((b8 & Ascii.DEL) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] >= 0) {
                zbsqVar.zba = i15;
                return i16;
            }
            i14 = i16;
        }
    }

    public static int zbm(int i5, byte[] bArr, int i6, int i7, zbun zbunVar, zbsq zbsqVar) {
        zbug zbugVar = (zbug) zbunVar;
        int iZbk = zbk(bArr, i6, zbsqVar);
        zbugVar.zbg(zbsqVar.zba);
        while (iZbk < i7) {
            int iZbk2 = zbk(bArr, iZbk, zbsqVar);
            if (i5 != zbsqVar.zba) {
                break;
            }
            iZbk = zbk(bArr, iZbk2, zbsqVar);
            zbugVar.zbg(zbsqVar.zba);
        }
        return iZbk;
    }

    public static int zbn(byte[] bArr, int i5, zbsq zbsqVar) {
        long j6 = bArr[i5];
        int i6 = i5 + 1;
        if (j6 >= 0) {
            zbsqVar.zbb = j6;
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
        zbsqVar.zbb = j7;
        return i7;
    }

    public static int zbo(Object obj, zbvx zbvxVar, byte[] bArr, int i5, int i6, int i7, zbsq zbsqVar) throws zbuq {
        int i8 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i8;
        zbs(i8);
        int iZbc = ((zbvp) zbvxVar).zbc(obj, bArr, i5, i6, i7, zbsqVar);
        zbsqVar.zbe--;
        zbsqVar.zbc = obj;
        return iZbc;
    }

    public static int zbp(Object obj, zbvx zbvxVar, byte[] bArr, int i5, int i6, zbsq zbsqVar) throws zbuq {
        int iZbl = i5 + 1;
        int i7 = bArr[i5];
        if (i7 < 0) {
            iZbl = zbl(i7, bArr, iZbl, zbsqVar);
            i7 = zbsqVar.zba;
        }
        int i8 = iZbl;
        if (i7 < 0 || i7 > i6 - i8) {
            throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i9 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i9;
        zbs(i9);
        int i10 = i8 + i7;
        zbvxVar.zbh(obj, bArr, i8, i10, zbsqVar);
        zbsqVar.zbe--;
        zbsqVar.zbc = obj;
        return i10;
    }

    public static int zbq(int i5, byte[] bArr, int i6, int i7, zbsq zbsqVar) throws zbuq {
        if ((i5 >>> 3) == 0) {
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            return zbn(bArr, i6, zbsqVar);
        }
        if (i8 == 1) {
            return i6 + 8;
        }
        if (i8 == 2) {
            return zbk(bArr, i6, zbsqVar) + zbsqVar.zba;
        }
        if (i8 != 3) {
            if (i8 == 5) {
                return i6 + 4;
            }
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i9 = (i5 & (-8)) | 4;
        int i10 = 0;
        while (i6 < i7) {
            i6 = zbk(bArr, i6, zbsqVar);
            i10 = zbsqVar.zba;
            if (i10 == i9) {
                break;
            }
            i6 = zbq(i10, bArr, i6, i7, zbsqVar);
        }
        if (i6 > i7 || i10 != i9) {
            throw new zbuq("Failed to parse the message.");
        }
        return i6;
    }

    public static long zbr(byte[] bArr, int i5) {
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48) | ((((long) bArr[i5 + 7]) & 255) << 56);
    }

    private static void zbs(int i5) throws zbuq {
        if (i5 >= zbb) {
            throw new zbuq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
