package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbvp<T> implements zbvx<T> {
    private static final int[] zba = new int[0];
    private static final Unsafe zbb = zbws.zbg();
    private final int[] zbc;
    private final Object[] zbd;
    private final int zbe;
    private final int zbf;
    private final zbvm zbg;
    private final boolean zbh;
    private final int[] zbi;
    private final int zbj;
    private final int zbk;
    private final zbwl zbl;
    private final zbtq zbm;

    private zbvp(int[] iArr, Object[] objArr, int i5, int i6, zbvm zbvmVar, boolean z6, int[] iArr2, int i7, int i8, zbvs zbvsVar, zbuy zbuyVar, zbwl zbwlVar, zbtq zbtqVar, zbvh zbvhVar) {
        this.zbc = iArr;
        this.zbd = objArr;
        this.zbe = i5;
        this.zbf = i6;
        boolean z7 = false;
        if (zbtqVar != null && (zbvmVar instanceof zbub)) {
            z7 = true;
        }
        this.zbh = z7;
        this.zbi = iArr2;
        this.zbj = i7;
        this.zbk = i8;
        this.zbl = zbwlVar;
        this.zbm = zbtqVar;
        this.zbg = zbvmVar;
    }

    private static void zbA(Object obj) {
        if (!zbL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zbB(Object obj, Object obj2, int i5) {
        if (zbI(obj2, i5)) {
            int iZbs = zbs(i5) & 1048575;
            Unsafe unsafe = zbb;
            long j6 = iZbs;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zbc[i5] + " is present but null: " + obj2.toString());
            }
            zbvx zbvxVarZbv = zbv(i5);
            if (!zbI(obj, i5)) {
                if (zbL(object)) {
                    Object objZbe = zbvxVarZbv.zbe();
                    zbvxVarZbv.zbg(objZbe, object);
                    unsafe.putObject(obj, j6, objZbe);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zbD(obj, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zbL(object2)) {
                Object objZbe2 = zbvxVarZbv.zbe();
                zbvxVarZbv.zbg(objZbe2, object2);
                unsafe.putObject(obj, j6, objZbe2);
                object2 = objZbe2;
            }
            zbvxVarZbv.zbg(object2, object);
        }
    }

    private final void zbC(Object obj, Object obj2, int i5) {
        int i6 = this.zbc[i5];
        if (zbM(obj2, i6, i5)) {
            int iZbs = zbs(i5) & 1048575;
            Unsafe unsafe = zbb;
            long j6 = iZbs;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zbc[i5] + " is present but null: " + obj2.toString());
            }
            zbvx zbvxVarZbv = zbv(i5);
            if (!zbM(obj, i6, i5)) {
                if (zbL(object)) {
                    Object objZbe = zbvxVarZbv.zbe();
                    zbvxVarZbv.zbg(objZbe, object);
                    unsafe.putObject(obj, j6, objZbe);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zbE(obj, i6, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zbL(object2)) {
                Object objZbe2 = zbvxVarZbv.zbe();
                zbvxVarZbv.zbg(objZbe2, object2);
                unsafe.putObject(obj, j6, objZbe2);
                object2 = objZbe2;
            }
            zbvxVarZbv.zbg(object2, object);
        }
    }

    private final void zbD(Object obj, int i5) {
        int iZbp = zbp(i5);
        long j6 = 1048575 & iZbp;
        if (j6 == 1048575) {
            return;
        }
        zbws.zbq(obj, j6, (1 << (iZbp >>> 20)) | zbws.zbc(obj, j6));
    }

    private final void zbE(Object obj, int i5, int i6) {
        zbws.zbq(obj, zbp(i6) & 1048575, i5);
    }

    private final void zbF(Object obj, int i5, Object obj2) {
        zbb.putObject(obj, zbs(i5) & 1048575, obj2);
        zbD(obj, i5);
    }

    private final void zbG(Object obj, int i5, int i6, Object obj2) {
        zbb.putObject(obj, zbs(i6) & 1048575, obj2);
        zbE(obj, i5, i6);
    }

    private final boolean zbH(Object obj, Object obj2, int i5) {
        return zbI(obj, i5) == zbI(obj2, i5);
    }

    private final boolean zbI(Object obj, int i5) {
        int iZbp = zbp(i5);
        long j6 = iZbp & 1048575;
        if (j6 != 1048575) {
            return (zbws.zbc(obj, j6) & (1 << (iZbp >>> 20))) != 0;
        }
        int iZbs = zbs(i5);
        long j7 = iZbs & 1048575;
        switch (zbr(iZbs)) {
            case 0:
                return Double.doubleToRawLongBits(zbws.zba(obj, j7)) != 0;
            case 1:
                return Float.floatToRawIntBits(zbws.zbb(obj, j7)) != 0;
            case 2:
                return zbws.zbd(obj, j7) != 0;
            case 3:
                return zbws.zbd(obj, j7) != 0;
            case 4:
                return zbws.zbc(obj, j7) != 0;
            case 5:
                return zbws.zbd(obj, j7) != 0;
            case 6:
                return zbws.zbc(obj, j7) != 0;
            case 7:
                return zbws.zbw(obj, j7);
            case 8:
                Object objZbf = zbws.zbf(obj, j7);
                if (objZbf instanceof String) {
                    return !((String) objZbf).isEmpty();
                }
                if (objZbf instanceof zbtc) {
                    return !zbtc.zbb.equals(objZbf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zbws.zbf(obj, j7) != null;
            case 10:
                return !zbtc.zbb.equals(zbws.zbf(obj, j7));
            case 11:
                return zbws.zbc(obj, j7) != 0;
            case 12:
                return zbws.zbc(obj, j7) != 0;
            case 13:
                return zbws.zbc(obj, j7) != 0;
            case 14:
                return zbws.zbd(obj, j7) != 0;
            case 15:
                return zbws.zbc(obj, j7) != 0;
            case 16:
                return zbws.zbd(obj, j7) != 0;
            case 17:
                return zbws.zbf(obj, j7) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zbJ(Object obj, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return zbI(obj, i5);
        }
        return (i7 & i8) != 0;
    }

    private static boolean zbK(Object obj, int i5, zbvx zbvxVar) {
        return zbvxVar.zbk(zbws.zbf(obj, i5 & 1048575));
    }

    private static boolean zbL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zbuf) {
            return ((zbuf) obj).zbG();
        }
        return true;
    }

    private final boolean zbM(Object obj, int i5, int i6) {
        return zbws.zbc(obj, (long) (zbp(i6) & 1048575)) == i5;
    }

    private static boolean zbN(Object obj, long j6) {
        return ((Boolean) zbws.zbf(obj, j6)).booleanValue();
    }

    private static final int zbO(byte[] bArr, int i5, int i6, zbww zbwwVar, Class cls, zbsq zbsqVar) {
        zbww zbwwVar2 = zbww.zba;
        switch (zbwwVar.ordinal()) {
            case 0:
                int i7 = i5 + 8;
                zbsqVar.zbc = Double.valueOf(Double.longBitsToDouble(zbsr.zbr(bArr, i5)));
                return i7;
            case 1:
                int i8 = i5 + 4;
                zbsqVar.zbc = Float.valueOf(Float.intBitsToFloat(zbsr.zbc(bArr, i5)));
                return i8;
            case 2:
            case 3:
                int iZbn = zbsr.zbn(bArr, i5, zbsqVar);
                zbsqVar.zbc = Long.valueOf(zbsqVar.zbb);
                return iZbn;
            case 4:
            case 12:
            case 13:
                int iZbk = zbsr.zbk(bArr, i5, zbsqVar);
                zbsqVar.zbc = Integer.valueOf(zbsqVar.zba);
                return iZbk;
            case 5:
            case 15:
                int i9 = i5 + 8;
                zbsqVar.zbc = Long.valueOf(zbsr.zbr(bArr, i5));
                return i9;
            case 6:
            case 14:
                int i10 = i5 + 4;
                zbsqVar.zbc = Integer.valueOf(zbsr.zbc(bArr, i5));
                return i10;
            case 7:
                int iZbn2 = zbsr.zbn(bArr, i5, zbsqVar);
                zbsqVar.zbc = Boolean.valueOf(zbsqVar.zbb != 0);
                return iZbn2;
            case 8:
                return zbsr.zbi(bArr, i5, zbsqVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return zbsr.zbe(zbvu.zba().zbb(cls), bArr, i5, i6, zbsqVar);
            case 11:
                return zbsr.zba(bArr, i5, zbsqVar);
            case 16:
                int iZbk2 = zbsr.zbk(bArr, i5, zbsqVar);
                zbsqVar.zbc = Integer.valueOf(zbtg.zbb(zbsqVar.zba));
                return iZbk2;
            case 17:
                int iZbn3 = zbsr.zbn(bArr, i5, zbsqVar);
                zbsqVar.zbc = Long.valueOf(zbtg.zbc(zbsqVar.zbb));
                return iZbn3;
        }
    }

    private static final void zbP(int i5, Object obj, zbwy zbwyVar) {
        if (obj instanceof String) {
            zbwyVar.zbH(i5, (String) obj);
        } else {
            zbwyVar.zbd(i5, (zbtc) obj);
        }
    }

    public static zbwm zbd(Object obj) {
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVar = zbufVar.zbc;
        if (zbwmVar != zbwm.zbc()) {
            return zbwmVar;
        }
        zbwm zbwmVarZbf = zbwm.zbf();
        zbufVar.zbc = zbwmVarZbf;
        return zbwmVarZbf;
    }

    /* JADX WARN: Code duplicated, block: B:187:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:193:0x03e2  */
    public static zbvp zbl(Class cls, zbvj zbvjVar, zbvs zbvsVar, zbuy zbuyVar, zbwl zbwlVar, zbtq zbtqVar, zbvh zbvhVar) {
        int i5;
        int iCharAt;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr;
        int i11;
        int i12;
        char cCharAt;
        int i13;
        char cCharAt2;
        int i14;
        char cCharAt3;
        int i15;
        char cCharAt4;
        int i16;
        char cCharAt5;
        int i17;
        char cCharAt6;
        int i18;
        char cCharAt7;
        int i19;
        char cCharAt8;
        int i20;
        zbvw zbvwVar;
        int i21;
        Object[] objArr;
        int i22;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        char c;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        Field fieldZbz;
        char cCharAt9;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        Field fieldZbz2;
        Field fieldZbz3;
        int i34;
        char cCharAt10;
        int i35;
        int i36;
        char cCharAt11;
        int i37;
        char cCharAt12;
        int i38;
        char cCharAt13;
        if (!(zbvjVar instanceof zbvw)) {
            throw null;
        }
        zbvw zbvwVar2 = (zbvw) zbvjVar;
        String strZbd = zbvwVar2.zbd();
        int length = strZbd.length();
        char c6 = 55296;
        if (strZbd.charAt(0) >= 55296) {
            int i39 = 1;
            while (true) {
                i5 = i39 + 1;
                if (strZbd.charAt(i39) < 55296) {
                    break;
                }
                i39 = i5;
            }
        } else {
            i5 = 1;
        }
        int i40 = i5 + 1;
        int iCharAt2 = strZbd.charAt(i5);
        if (iCharAt2 >= 55296) {
            int i41 = iCharAt2 & 8191;
            int i42 = 13;
            while (true) {
                i38 = i40 + 1;
                cCharAt13 = strZbd.charAt(i40);
                if (cCharAt13 < 55296) {
                    break;
                }
                i41 |= (cCharAt13 & 8191) << i42;
                i42 += 13;
                i40 = i38;
            }
            iCharAt2 = i41 | (cCharAt13 << i42);
            i40 = i38;
        }
        if (iCharAt2 == 0) {
            i7 = 0;
            i10 = 0;
            iCharAt = 0;
            i6 = 0;
            i8 = 0;
            i9 = 0;
            iArr = zba;
            i11 = 0;
        } else {
            int i43 = i40 + 1;
            int iCharAt3 = strZbd.charAt(i40);
            if (iCharAt3 >= 55296) {
                int i44 = iCharAt3 & 8191;
                int i45 = 13;
                while (true) {
                    i19 = i43 + 1;
                    cCharAt8 = strZbd.charAt(i43);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt8 & 8191) << i45;
                    i45 += 13;
                    i43 = i19;
                }
                iCharAt3 = i44 | (cCharAt8 << i45);
                i43 = i19;
            }
            int i46 = i43 + 1;
            int iCharAt4 = strZbd.charAt(i43);
            if (iCharAt4 >= 55296) {
                int i47 = iCharAt4 & 8191;
                int i48 = 13;
                while (true) {
                    i18 = i46 + 1;
                    cCharAt7 = strZbd.charAt(i46);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt7 & 8191) << i48;
                    i48 += 13;
                    i46 = i18;
                }
                iCharAt4 = i47 | (cCharAt7 << i48);
                i46 = i18;
            }
            int i49 = i46 + 1;
            int iCharAt5 = strZbd.charAt(i46);
            if (iCharAt5 >= 55296) {
                int i50 = iCharAt5 & 8191;
                int i51 = 13;
                while (true) {
                    i17 = i49 + 1;
                    cCharAt6 = strZbd.charAt(i49);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt6 & 8191) << i51;
                    i51 += 13;
                    i49 = i17;
                }
                iCharAt5 = i50 | (cCharAt6 << i51);
                i49 = i17;
            }
            int i52 = i49 + 1;
            int iCharAt6 = strZbd.charAt(i49);
            if (iCharAt6 >= 55296) {
                int i53 = iCharAt6 & 8191;
                int i54 = 13;
                while (true) {
                    i16 = i52 + 1;
                    cCharAt5 = strZbd.charAt(i52);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt5 & 8191) << i54;
                    i54 += 13;
                    i52 = i16;
                }
                iCharAt6 = i53 | (cCharAt5 << i54);
                i52 = i16;
            }
            int i55 = i52 + 1;
            iCharAt = strZbd.charAt(i52);
            if (iCharAt >= 55296) {
                int i56 = iCharAt & 8191;
                int i57 = 13;
                while (true) {
                    i15 = i55 + 1;
                    cCharAt4 = strZbd.charAt(i55);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt4 & 8191) << i57;
                    i57 += 13;
                    i55 = i15;
                }
                iCharAt = i56 | (cCharAt4 << i57);
                i55 = i15;
            }
            int i58 = i55 + 1;
            int iCharAt7 = strZbd.charAt(i55);
            if (iCharAt7 >= 55296) {
                int i59 = iCharAt7 & 8191;
                int i60 = 13;
                while (true) {
                    i14 = i58 + 1;
                    cCharAt3 = strZbd.charAt(i58);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i59 |= (cCharAt3 & 8191) << i60;
                    i60 += 13;
                    i58 = i14;
                }
                iCharAt7 = i59 | (cCharAt3 << i60);
                i58 = i14;
            }
            int i61 = i58 + 1;
            int iCharAt8 = strZbd.charAt(i58);
            if (iCharAt8 >= 55296) {
                int i62 = iCharAt8 & 8191;
                int i63 = 13;
                while (true) {
                    i13 = i61 + 1;
                    cCharAt2 = strZbd.charAt(i61);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i62 |= (cCharAt2 & 8191) << i63;
                    i63 += 13;
                    i61 = i13;
                }
                iCharAt8 = i62 | (cCharAt2 << i63);
                i61 = i13;
            }
            int i64 = i61 + 1;
            int iCharAt9 = strZbd.charAt(i61);
            if (iCharAt9 >= 55296) {
                int i65 = iCharAt9 & 8191;
                int i66 = 13;
                while (true) {
                    i12 = i64 + 1;
                    cCharAt = strZbd.charAt(i64);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i65 |= (cCharAt & 8191) << i66;
                    i66 += 13;
                    i64 = i12;
                }
                iCharAt9 = i65 | (cCharAt << i66);
                i64 = i12;
            }
            int i67 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i68 = iCharAt7;
            i6 = iCharAt5;
            i7 = i68;
            i8 = iCharAt6;
            i9 = iCharAt9;
            i10 = i67;
            iArr = iArr2;
            i11 = iCharAt3;
            i40 = i64;
        }
        Unsafe unsafe = zbb;
        Object[] objArrZbe = zbvwVar2.zbe();
        Class<?> cls2 = zbvwVar2.zba().getClass();
        int i69 = i9 + i7;
        int i70 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr2 = new Object[i70];
        int i71 = i9;
        int i72 = i69;
        int i73 = 0;
        int i74 = 0;
        while (i40 < length) {
            int i75 = i40 + 1;
            int iCharAt10 = strZbd.charAt(i40);
            if (iCharAt10 >= c6) {
                int i76 = iCharAt10 & 8191;
                int i77 = i75;
                int i78 = 13;
                while (true) {
                    i37 = i77 + 1;
                    cCharAt12 = strZbd.charAt(i77);
                    if (cCharAt12 < c6) {
                        break;
                    }
                    i76 |= (cCharAt12 & 8191) << i78;
                    i78 += 13;
                    i77 = i37;
                }
                iCharAt10 = i76 | (cCharAt12 << i78);
                i20 = i37;
            } else {
                i20 = i75;
            }
            int i79 = i20 + 1;
            int iCharAt11 = strZbd.charAt(i20);
            if (iCharAt11 >= c6) {
                int i80 = iCharAt11 & 8191;
                int i81 = i79;
                int i82 = 13;
                while (true) {
                    i36 = i81 + 1;
                    cCharAt11 = strZbd.charAt(i81);
                    zbvwVar = zbvwVar2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i80 |= (cCharAt11 & 8191) << i82;
                    i82 += 13;
                    i81 = i36;
                    zbvwVar2 = zbvwVar;
                }
                iCharAt11 = i80 | (cCharAt11 << i82);
                i21 = i36;
            } else {
                zbvwVar = zbvwVar2;
                i21 = i79;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i74] = i73;
                i74++;
            }
            int i83 = iCharAt11 & 255;
            int i84 = length;
            int i85 = iCharAt11 & 2048;
            if (i83 >= 51) {
                int i86 = i21 + 1;
                int iCharAt12 = strZbd.charAt(i21);
                if (iCharAt12 >= 55296) {
                    int i87 = iCharAt12 & 8191;
                    int i88 = i86;
                    int i89 = 13;
                    while (true) {
                        i34 = i88 + 1;
                        cCharAt10 = strZbd.charAt(i88);
                        i35 = i87;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i87 = i35 | ((cCharAt10 & 8191) << i89);
                        i89 += 13;
                        i88 = i34;
                    }
                    iCharAt12 = i35 | (cCharAt10 << i89);
                    i32 = i34;
                } else {
                    i32 = i86;
                }
                int i90 = iCharAt12;
                int i91 = i83 - 51;
                int i92 = i32;
                if (i91 == 9 || i91 == 17) {
                    objArr2[a.r(i73, 3, 1)] = objArrZbe[i10];
                    i33 = i85;
                    i10++;
                } else if (i91 != 12) {
                    i33 = i85;
                } else if (zbvwVar.zbc() == 1 || i85 != 0) {
                    objArr2[a.r(i73, 3, 1)] = objArrZbe[i10];
                    i10++;
                    i33 = i85;
                } else {
                    i33 = 0;
                }
                int i93 = i90 + i90;
                Object obj = objArrZbe[i93];
                int i94 = i33;
                if (obj instanceof Field) {
                    fieldZbz2 = (Field) obj;
                } else {
                    fieldZbz2 = zbz(cls2, (String) obj);
                    objArrZbe[i93] = fieldZbz2;
                }
                Object[] objArr3 = objArr2;
                int i95 = i10;
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZbz2);
                int i96 = i93 + 1;
                Object obj2 = objArrZbe[i96];
                if (obj2 instanceof Field) {
                    fieldZbz3 = (Field) obj2;
                } else {
                    fieldZbz3 = zbz(cls2, (String) obj2);
                    objArrZbe[i96] = fieldZbz3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZbz3);
                i11 = i11;
                i27 = i95;
                i73 = i73;
                c = 55296;
                iObjectFieldOffset2 = iObjectFieldOffset4;
                i26 = iObjectFieldOffset3;
                i85 = i94;
                i22 = iCharAt10;
                i40 = i92;
                objArr = objArr3;
                i25 = 0;
            } else {
                Object[] objArr4 = objArr2;
                int i97 = i10 + 1;
                objArr = objArr4;
                Field fieldZbz4 = zbz(cls2, (String) objArrZbe[i10]);
                i22 = iCharAt10;
                if (i83 == 9 || i83 == 17) {
                    i11 = i11;
                    objArr[a.r(i73, 3, 1)] = fieldZbz4.getType();
                } else {
                    if (i83 != 27) {
                        if (i83 == 49) {
                            i31 = i10 + 2;
                            i29 = 3;
                            i30 = 1;
                        } else if (i83 == 12 || i83 == 30 || i83 == 44) {
                            i11 = i11;
                            if (zbvwVar.zbc() == 1 || i85 != 0) {
                                i31 = i10 + 2;
                                objArr[a.r(i73, 3, 1)] = objArrZbe[i97];
                                i97 = i31;
                            } else {
                                i73 = i73;
                                i85 = 0;
                            }
                        } else if (i83 == 50) {
                            int i98 = i10 + 2;
                            i71++;
                            iArr[i71] = i73;
                            int i99 = i73 / 3;
                            int i100 = i99 + i99;
                            objArr[i100] = objArrZbe[i97];
                            if (i85 != 0) {
                                i97 = i10 + 3;
                                objArr[i100 + 1] = objArrZbe[i98];
                            } else {
                                i97 = i98;
                                i85 = 0;
                            }
                            i11 = i11;
                        } else {
                            i11 = i11;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZbz4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i83 > 17) {
                            c = 55296;
                            i23 = i21;
                            i24 = 0;
                        } else {
                            int i101 = i21 + 1;
                            int iCharAt13 = strZbd.charAt(i21);
                            if (iCharAt13 >= 55296) {
                                int i102 = iCharAt13 & 8191;
                                int i103 = 13;
                                while (true) {
                                    i28 = i101 + 1;
                                    cCharAt9 = strZbd.charAt(i101);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i102 |= (cCharAt9 & 8191) << i103;
                                    i103 += 13;
                                    i101 = i28;
                                }
                                iCharAt13 = i102 | (cCharAt9 << i103);
                            } else {
                                i28 = i101;
                            }
                            int i104 = (iCharAt13 / 32) + i11 + i11;
                            Object obj3 = objArrZbe[i104];
                            if (obj3 instanceof Field) {
                                fieldZbz = (Field) obj3;
                            } else {
                                fieldZbz = zbz(cls2, (String) obj3);
                                objArrZbe[i104] = fieldZbz;
                            }
                            i24 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZbz);
                            i23 = i28;
                            c = 55296;
                        }
                        if (i83 >= 18 || i83 > 49) {
                            i25 = i24;
                            i26 = iObjectFieldOffset;
                            int i105 = i23;
                            i27 = i97;
                            i40 = i105;
                        } else {
                            int i106 = i72 + 1;
                            iArr[i72] = iObjectFieldOffset;
                            i25 = i24;
                            i26 = iObjectFieldOffset;
                            int i107 = i23;
                            i27 = i97;
                            i40 = i107;
                            i72 = i106;
                        }
                    } else {
                        i29 = 3;
                        i30 = 1;
                        i31 = i10 + 2;
                    }
                    objArr[a.r(i73, i29, i30)] = objArrZbe[i97];
                    i97 = i31;
                }
                i73 = i73;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZbz4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    c = 55296;
                    i23 = i21;
                    i24 = 0;
                } else {
                    c = 55296;
                    i23 = i21;
                    i24 = 0;
                }
                if (i83 >= 18) {
                    i25 = i24;
                    i26 = iObjectFieldOffset;
                    int i108 = i23;
                    i27 = i97;
                    i40 = i108;
                } else {
                    i25 = i24;
                    i26 = iObjectFieldOffset;
                    int i109 = i23;
                    i27 = i97;
                    i40 = i109;
                }
            }
            int i110 = i73 + 1;
            iArr3[i73] = i22;
            int i111 = i73 + 2;
            iArr3[i110] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i85 != 0 ? Integer.MIN_VALUE : 0) | (i83 << 20) | i26;
            iArr3[i111] = (i25 << 20) | iObjectFieldOffset2;
            i73 += 3;
            i10 = i27;
            length = i84;
            c6 = c;
            zbvwVar2 = zbvwVar;
            i11 = i11;
            objArr2 = objArr;
        }
        return new zbvp(iArr3, objArr2, i6, i8, zbvwVar2.zba(), false, iArr, i9, i69, zbvsVar, zbuyVar, zbwlVar, zbtqVar, zbvhVar);
    }

    private static double zbm(Object obj, long j6) {
        return ((Double) zbws.zbf(obj, j6)).doubleValue();
    }

    private static float zbn(Object obj, long j6) {
        return ((Float) zbws.zbf(obj, j6)).floatValue();
    }

    private static int zbo(Object obj, long j6) {
        return ((Integer) zbws.zbf(obj, j6)).intValue();
    }

    private final int zbp(int i5) {
        return this.zbc[i5 + 2];
    }

    private final int zbq(int i5, int i6) {
        int length = (this.zbc.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int i9 = this.zbc[i8];
            if (i5 == i9) {
                return i8;
            }
            if (i5 < i9) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    private static int zbr(int i5) {
        return (i5 >>> 20) & 255;
    }

    private final int zbs(int i5) {
        return this.zbc[i5 + 1];
    }

    private static long zbt(Object obj, long j6) {
        return ((Long) zbws.zbf(obj, j6)).longValue();
    }

    private final zbuj zbu(int i5) {
        int i6 = i5 / 3;
        return (zbuj) this.zbd[i6 + i6 + 1];
    }

    private final zbvx zbv(int i5) {
        Object[] objArr = this.zbd;
        int i6 = i5 / 3;
        int i7 = i6 + i6;
        zbvx zbvxVar = (zbvx) objArr[i7];
        if (zbvxVar != null) {
            return zbvxVar;
        }
        zbvx zbvxVarZbb = zbvu.zba().zbb((Class) objArr[i7 + 1]);
        this.zbd[i7] = zbvxVarZbb;
        return zbvxVarZbb;
    }

    private final Object zbw(int i5) {
        int i6 = i5 / 3;
        return this.zbd[i6 + i6];
    }

    private final Object zbx(Object obj, int i5) {
        zbvx zbvxVarZbv = zbv(i5);
        int iZbs = zbs(i5) & 1048575;
        if (!zbI(obj, i5)) {
            return zbvxVarZbv.zbe();
        }
        Object object = zbb.getObject(obj, iZbs);
        if (zbL(object)) {
            return object;
        }
        Object objZbe = zbvxVarZbv.zbe();
        if (object != null) {
            zbvxVarZbv.zbg(objZbe, object);
        }
        return objZbe;
    }

    private final Object zby(Object obj, int i5, int i6) {
        zbvx zbvxVarZbv = zbv(i6);
        if (!zbM(obj, i5, i6)) {
            return zbvxVarZbv.zbe();
        }
        Object object = zbb.getObject(obj, zbs(i6) & 1048575);
        if (zbL(object)) {
            return object;
        }
        Object objZbe = zbvxVarZbv.zbe();
        if (object != null) {
            zbvxVarZbv.zbg(objZbe, object);
        }
        return objZbe;
    }

    private static Field zbz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sbU = androidx.collection.a.u("Field ", str, " for ", name, " not found. Known fields are ");
            sbU.append(string);
            throw new RuntimeException(sbU.toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:152:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:206:0x0529  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e1  */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zba(Object obj) {
        int i5;
        int iZbD;
        int iZbE;
        int iZbD2;
        int iZbd;
        int iZbD3;
        int iZbh;
        int iZbD4;
        int size;
        int iZbl;
        int iZbD5;
        int iZbd2;
        boolean z6;
        int iZbb;
        int iZbC;
        int iZbD6;
        int iZbD7;
        int size2;
        int iZbk;
        int iZbD8;
        int size3;
        int iZbi;
        int iZbD9;
        int iZba;
        int iZbe;
        int iZbD10;
        int iZbD11;
        int iZbD12;
        int iZbE2;
        zbvp<T> zbvpVar = this;
        Unsafe unsafe = zbb;
        int i6 = 1048575;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        int iA = 0;
        while (i8 < zbvpVar.zbc.length) {
            int iZbs = zbvpVar.zbs(i8);
            int iZbr = zbr(iZbs);
            int[] iArr = zbvpVar.zbc;
            int i10 = iArr[i8];
            int i11 = iArr[i8 + 2];
            int i12 = i11 & i6;
            if (iZbr <= 17) {
                if (i12 != i7) {
                    i9 = i12 == i6 ? 0 : unsafe.getInt(obj, i12);
                    i7 = i12;
                }
                i5 = 1 << (i11 >>> 20);
            } else {
                i5 = 0;
            }
            int i13 = iZbs & i6;
            if (iZbr >= zbtv.zbJ.zba()) {
                zbtv.zbW.zba();
            }
            long j6 = i13;
            switch (iZbr) {
                case 0:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA = a.A(i10 << 3, 8, iA);
                    }
                    break;
                case 1:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA = a.A(i10 << 3, 4, iA);
                    }
                    zbvpVar = this;
                    break;
                case 2:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        long j7 = unsafe.getLong(obj, j6);
                        iZbD = zbtk.zbD(i10 << 3);
                        iZbE = zbtk.zbE(j7);
                        iA += iZbE + iZbD;
                    }
                    zbvpVar = this;
                    break;
                case 3:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        long j8 = unsafe.getLong(obj, j6);
                        iZbD = zbtk.zbD(i10 << 3);
                        iZbE = zbtk.zbE(j8);
                        iA += iZbE + iZbD;
                    }
                    zbvpVar = this;
                    break;
                case 4:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        long j9 = unsafe.getInt(obj, j6);
                        iZbD = zbtk.zbD(i10 << 3);
                        iZbE = zbtk.zbE(j9);
                        iA += iZbE + iZbD;
                    }
                    zbvpVar = this;
                    break;
                case 5:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA = a.A(i10 << 3, 8, iA);
                    }
                    zbvpVar = this;
                    break;
                case 6:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA = a.A(i10 << 3, 4, iA);
                    }
                    zbvpVar = this;
                    break;
                case 7:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA = a.A(i10 << 3, 1, iA);
                    }
                    zbvpVar = this;
                    break;
                case 8:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        int i14 = i10 << 3;
                        Object object = unsafe.getObject(obj, j6);
                        if (object instanceof zbtc) {
                            iZbD2 = zbtk.zbD(i14);
                            iZbd = ((zbtc) object).zbd();
                            iZbD3 = zbtk.zbD(iZbd);
                            iA += iZbD3 + iZbd + iZbD2;
                        } else {
                            iZbD = zbtk.zbD(i14);
                            iZbE = zbtk.zbC((String) object);
                            iA += iZbE + iZbD;
                        }
                    }
                    zbvpVar = this;
                    break;
                case 9:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iZbh = zbvz.zbh(i10, unsafe.getObject(obj, j6), zbvpVar.zbv(i8));
                        iA += iZbh;
                    }
                    break;
                case 10:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        zbtc zbtcVar = (zbtc) unsafe.getObject(obj, j6);
                        iZbD2 = zbtk.zbD(i10 << 3);
                        iZbd = zbtcVar.zbd();
                        iZbD3 = zbtk.zbD(iZbd);
                        iA += iZbD3 + iZbd + iZbD2;
                    }
                    zbvpVar = this;
                    break;
                case 11:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA = a.A(unsafe.getInt(obj, j6), zbtk.zbD(i10 << 3), iA);
                    }
                    zbvpVar = this;
                    break;
                case 12:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        long j10 = unsafe.getInt(obj, j6);
                        iZbD = zbtk.zbD(i10 << 3);
                        iZbE = zbtk.zbE(j10);
                        iA += iZbE + iZbD;
                    }
                    zbvpVar = this;
                    break;
                case 13:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA = a.A(i10 << 3, 4, iA);
                    }
                    zbvpVar = this;
                    break;
                case 14:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA = a.A(i10 << 3, 8, iA);
                    }
                    zbvpVar = this;
                    break;
                case 15:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        int i15 = unsafe.getInt(obj, j6);
                        iA = a.A((i15 >> 31) ^ (i15 + i15), zbtk.zbD(i10 << 3), iA);
                    }
                    zbvpVar = this;
                    break;
                case 16:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        long j11 = unsafe.getLong(obj, j6);
                        iZbD = zbtk.zbD(i10 << 3);
                        iZbE = zbtk.zbE((j11 >> 63) ^ (j11 + j11));
                        iA += iZbE + iZbD;
                    }
                    zbvpVar = this;
                    break;
                case 17:
                    if (zbvpVar.zbJ(obj, i8, i7, i9, i5)) {
                        iA += zbtk.zbz(i10, (zbvm) unsafe.getObject(obj, j6), zbvpVar.zbv(i8));
                    }
                    break;
                case 18:
                    iZbh = zbvz.zbd(i10, (List) unsafe.getObject(obj, j6), false);
                    iA += iZbh;
                    break;
                case 19:
                    iZbh = zbvz.zbb(i10, (List) unsafe.getObject(obj, j6), false);
                    iA += iZbh;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j6);
                    int i16 = zbvz.zba;
                    if (list.size() == 0) {
                        iZbD4 = 0;
                    } else {
                        iZbD4 = (zbtk.zbD(i10 << 3) * list.size()) + zbvz.zbg(list);
                    }
                    iA += iZbD4;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j6);
                    int i17 = zbvz.zba;
                    size = list2.size();
                    if (size == 0) {
                        iZbD4 = 0;
                    } else {
                        iZbl = zbvz.zbl(list2);
                        iZbD5 = zbtk.zbD(i10 << 3);
                        iZbD4 = (iZbD5 * size) + iZbl;
                    }
                    iA += iZbD4;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j6);
                    int i18 = zbvz.zba;
                    size = list3.size();
                    if (size == 0) {
                        iZbD4 = 0;
                    } else {
                        iZbl = zbvz.zbf(list3);
                        iZbD5 = zbtk.zbD(i10 << 3);
                        iZbD4 = (iZbD5 * size) + iZbl;
                    }
                    iA += iZbD4;
                    break;
                case 23:
                    iZbd2 = zbvz.zbd(i10, (List) unsafe.getObject(obj, j6), false);
                    iA += iZbd2;
                    break;
                case 24:
                    z6 = false;
                    iZbb = zbvz.zbb(i10, (List) unsafe.getObject(obj, j6), false);
                    iA += iZbb;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j6);
                    int i19 = zbvz.zba;
                    int size4 = list4.size();
                    if (size4 == 0) {
                        iZbd2 = 0;
                    } else {
                        iZbd2 = size4 * (zbtk.zbD(i10 << 3) + 1);
                    }
                    iA += iZbd2;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j6);
                    int i20 = zbvz.zba;
                    int size5 = list5.size();
                    if (size5 == 0) {
                        iZbC = 0;
                    } else {
                        int iZbD13 = zbtk.zbD(i10 << 3) * size5;
                        if (list5 instanceof zbux) {
                            zbux zbuxVar = (zbux) list5;
                            iZbC = iZbD13;
                            for (int i21 = 0; i21 < size5; i21++) {
                                Object objZba = zbuxVar.zba();
                                if (objZba instanceof zbtc) {
                                    int iZbd3 = ((zbtc) objZba).zbd();
                                    iZbC = a.A(iZbd3, iZbd3, iZbC);
                                } else {
                                    iZbC = zbtk.zbC((String) objZba) + iZbC;
                                }
                            }
                        } else {
                            iZbC = iZbD13;
                            for (int i22 = 0; i22 < size5; i22++) {
                                Object obj2 = list5.get(i22);
                                if (obj2 instanceof zbtc) {
                                    int iZbd4 = ((zbtc) obj2).zbd();
                                    iZbC = a.A(iZbd4, iZbd4, iZbC);
                                } else {
                                    iZbC = zbtk.zbC((String) obj2) + iZbC;
                                }
                            }
                        }
                    }
                    iA += iZbC;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j6);
                    zbvx zbvxVarZbv = zbvpVar.zbv(i8);
                    int i23 = zbvz.zba;
                    int size6 = list6.size();
                    if (size6 == 0) {
                        iZbD6 = 0;
                    } else {
                        iZbD6 = zbtk.zbD(i10 << 3) * size6;
                        for (int i24 = 0; i24 < size6; i24++) {
                            Object obj3 = list6.get(i24);
                            if (obj3 instanceof zbuw) {
                                int iZba2 = ((zbuw) obj3).zba();
                                iZbD6 = a.A(iZba2, iZba2, iZbD6);
                            } else {
                                iZbD6 = zbtk.zbB((zbvm) obj3, zbvxVarZbv) + iZbD6;
                            }
                        }
                    }
                    iA += iZbD6;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j6);
                    int i25 = zbvz.zba;
                    int size7 = list7.size();
                    if (size7 == 0) {
                        iZbD7 = 0;
                    } else {
                        iZbD7 = zbtk.zbD(i10 << 3) * size7;
                        for (int i26 = 0; i26 < list7.size(); i26++) {
                            int iZbd5 = ((zbtc) list7.get(i26)).zbd();
                            iZbD7 = a.A(iZbd5, iZbd5, iZbD7);
                        }
                    }
                    iA += iZbD7;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j6);
                    int i27 = zbvz.zba;
                    size2 = list8.size();
                    if (size2 == 0) {
                        iZbd2 = 0;
                    } else {
                        iZbk = zbvz.zbk(list8);
                        iZbD8 = zbtk.zbD(i10 << 3);
                        iZbd2 = iZbk + (iZbD8 * size2);
                    }
                    iA += iZbd2;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j6);
                    int i28 = zbvz.zba;
                    size2 = list9.size();
                    if (size2 == 0) {
                        iZbd2 = 0;
                    } else {
                        iZbk = zbvz.zba(list9);
                        iZbD8 = zbtk.zbD(i10 << 3);
                        iZbd2 = iZbk + (iZbD8 * size2);
                    }
                    iA += iZbd2;
                    break;
                case 31:
                    iZbd2 = zbvz.zbb(i10, (List) unsafe.getObject(obj, j6), false);
                    iA += iZbd2;
                    break;
                case 32:
                    z6 = false;
                    iZbb = zbvz.zbd(i10, (List) unsafe.getObject(obj, j6), false);
                    iA += iZbb;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j6);
                    int i29 = zbvz.zba;
                    size3 = list10.size();
                    if (size3 == 0) {
                        iZba = 0;
                    } else {
                        iZbi = zbvz.zbi(list10);
                        iZbD9 = zbtk.zbD(i10 << 3);
                        iZba = (iZbD9 * size3) + iZbi;
                    }
                    iA += iZba;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j6);
                    int i30 = zbvz.zba;
                    size3 = list11.size();
                    if (size3 == 0) {
                        iZba = 0;
                    } else {
                        iZbi = zbvz.zbj(list11);
                        iZbD9 = zbtk.zbD(i10 << 3);
                        iZba = (iZbD9 * size3) + iZbi;
                    }
                    iA += iZba;
                    break;
                case 35:
                    iZbe = zbvz.zbe((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 36:
                    iZbe = zbvz.zbc((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 37:
                    iZbe = zbvz.zbg((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 38:
                    iZbe = zbvz.zbl((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 39:
                    iZbe = zbvz.zbf((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 40:
                    iZbe = zbvz.zbe((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 41:
                    iZbe = zbvz.zbc((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j6);
                    int i31 = zbvz.zba;
                    iZbe = list12.size();
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 43:
                    iZbe = zbvz.zbk((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 44:
                    iZbe = zbvz.zba((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 45:
                    iZbe = zbvz.zbc((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 46:
                    iZbe = zbvz.zbe((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 47:
                    iZbe = zbvz.zbi((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 48:
                    iZbe = zbvz.zbj((List) unsafe.getObject(obj, j6));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i10 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j6);
                    zbvx zbvxVarZbv2 = zbvpVar.zbv(i8);
                    int i32 = zbvz.zba;
                    int size8 = list13.size();
                    if (size8 == 0) {
                        iZba = 0;
                    } else {
                        int iZbz = 0;
                        for (int i33 = 0; i33 < size8; i33++) {
                            iZbz += zbtk.zbz(i10, (zbvm) list13.get(i33), zbvxVarZbv2);
                        }
                        iZba = iZbz;
                    }
                    iA += iZba;
                    break;
                case 50:
                    zbvg zbvgVar = (zbvg) unsafe.getObject(obj, j6);
                    zbvf zbvfVar = (zbvf) zbvpVar.zbw(i8);
                    if (zbvgVar.isEmpty()) {
                        iZba = 0;
                    } else {
                        iZba = 0;
                        for (Map.Entry entry : zbvgVar.entrySet()) {
                            iZba += zbvfVar.zba(i10, entry.getKey(), entry.getValue());
                        }
                    }
                    iA += iZba;
                    break;
                case 51:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA = a.A(i10 << 3, 8, iA);
                    }
                    break;
                case 52:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA = a.A(i10 << 3, 4, iA);
                    }
                    break;
                case 53:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        long jZbt = zbt(obj, j6);
                        iZbD12 = zbtk.zbD(i10 << 3);
                        iZbE2 = zbtk.zbE(jZbt);
                        iA += iZbE2 + iZbD12;
                    }
                    break;
                case 54:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        long jZbt2 = zbt(obj, j6);
                        iZbD12 = zbtk.zbD(i10 << 3);
                        iZbE2 = zbtk.zbE(jZbt2);
                        iA += iZbE2 + iZbD12;
                    }
                    break;
                case 55:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        long jZbo = zbo(obj, j6);
                        iZbD12 = zbtk.zbD(i10 << 3);
                        iZbE2 = zbtk.zbE(jZbo);
                        iA += iZbE2 + iZbD12;
                    }
                    break;
                case 56:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA = a.A(i10 << 3, 8, iA);
                    }
                    break;
                case 57:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA = a.A(i10 << 3, 4, iA);
                    }
                    break;
                case 58:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA = a.A(i10 << 3, 1, iA);
                    }
                    break;
                case 59:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        int i34 = i10 << 3;
                        Object object2 = unsafe.getObject(obj, j6);
                        if (object2 instanceof zbtc) {
                            iZbe = zbtk.zbD(i34);
                            iZbD10 = ((zbtc) object2).zbd();
                            iZbD11 = zbtk.zbD(iZbD10);
                            iA += iZbD11 + iZbD10 + iZbe;
                        } else {
                            iZbD12 = zbtk.zbD(i34);
                            iZbE2 = zbtk.zbC((String) object2);
                            iA += iZbE2 + iZbD12;
                        }
                    }
                    break;
                case 60:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iZbd2 = zbvz.zbh(i10, unsafe.getObject(obj, j6), zbvpVar.zbv(i8));
                        iA += iZbd2;
                    }
                    break;
                case 61:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        zbtc zbtcVar2 = (zbtc) unsafe.getObject(obj, j6);
                        iZbe = zbtk.zbD(i10 << 3);
                        iZbD10 = zbtcVar2.zbd();
                        iZbD11 = zbtk.zbD(iZbD10);
                        iA += iZbD11 + iZbD10 + iZbe;
                    }
                    break;
                case 62:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA = a.A(zbo(obj, j6), zbtk.zbD(i10 << 3), iA);
                    }
                    break;
                case 63:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        long jZbo2 = zbo(obj, j6);
                        iZbD12 = zbtk.zbD(i10 << 3);
                        iZbE2 = zbtk.zbE(jZbo2);
                        iA += iZbE2 + iZbD12;
                    }
                    break;
                case 64:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA = a.A(i10 << 3, 4, iA);
                    }
                    break;
                case 65:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA = a.A(i10 << 3, 8, iA);
                    }
                    break;
                case 66:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        int iZbo = zbo(obj, j6);
                        iA = a.A((iZbo >> 31) ^ (iZbo + iZbo), zbtk.zbD(i10 << 3), iA);
                    }
                    break;
                case 67:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        long jZbt3 = zbt(obj, j6);
                        iZbD12 = zbtk.zbD(i10 << 3);
                        iZbE2 = zbtk.zbE((jZbt3 >> 63) ^ (jZbt3 + jZbt3));
                        iA += iZbE2 + iZbD12;
                    }
                    break;
                case 68:
                    if (zbvpVar.zbM(obj, i10, i8)) {
                        iA += zbtk.zbz(i10, (zbvm) unsafe.getObject(obj, j6), zbvpVar.zbv(i8));
                    }
                    break;
                default:
                    break;
            }
            i8 += 3;
            i6 = 1048575;
        }
        int iZbb2 = 0;
        int iZba3 = ((zbuf) obj).zbc.zba() + iA;
        if (!zbvpVar.zbh) {
            return iZba3;
        }
        zbtu zbtuVar = ((zbub) obj).zbb;
        int iZbc = zbtuVar.zba.zbc();
        for (int i35 = 0; i35 < iZbc; i35++) {
            Map.Entry entryZbg = zbtuVar.zba.zbg(i35);
            iZbb2 += zbtu.zbb((zbtt) ((zbwb) entryZbg).zba(), entryZbg.getValue());
        }
        for (Map.Entry entry2 : zbtuVar.zba.zbd()) {
            iZbb2 += zbtu.zbb((zbtt) entry2.getKey(), entry2.getValue());
        }
        return iZba3 + iZbb2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zbb(Object obj) {
        int i5;
        long jDoubleToLongBits;
        int i6;
        int iFloatToIntBits;
        int iZbc;
        int i7;
        int i8 = 0;
        for (int i9 = 0; i9 < this.zbc.length; i9 += 3) {
            int iZbs = zbs(i9);
            int[] iArr = this.zbc;
            int i10 = 1048575 & iZbs;
            int iZbr = zbr(iZbs);
            int i11 = iArr[i9];
            long j6 = i10;
            int iHashCode = 37;
            switch (iZbr) {
                case 0:
                    i5 = i8 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zbws.zba(obj, j6));
                    byte[] bArr = zbuo.zbb;
                    iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZbc;
                    break;
                case 1:
                    i6 = i8 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zbws.zbb(obj, j6));
                    i8 = iFloatToIntBits + i6;
                    break;
                case 2:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j6);
                    byte[] bArr2 = zbuo.zbb;
                    iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZbc;
                    break;
                case 3:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j6);
                    byte[] bArr3 = zbuo.zbb;
                    iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZbc;
                    break;
                case 4:
                    i5 = i8 * 53;
                    iZbc = zbws.zbc(obj, j6);
                    i8 = i5 + iZbc;
                    break;
                case 5:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j6);
                    byte[] bArr4 = zbuo.zbb;
                    iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZbc;
                    break;
                case 6:
                    i5 = i8 * 53;
                    iZbc = zbws.zbc(obj, j6);
                    i8 = i5 + iZbc;
                    break;
                case 7:
                    i6 = i8 * 53;
                    iFloatToIntBits = zbuo.zba(zbws.zbw(obj, j6));
                    i8 = iFloatToIntBits + i6;
                    break;
                case 8:
                    i6 = i8 * 53;
                    iFloatToIntBits = ((String) zbws.zbf(obj, j6)).hashCode();
                    i8 = iFloatToIntBits + i6;
                    break;
                case 9:
                    i7 = i8 * 53;
                    Object objZbf = zbws.zbf(obj, j6);
                    if (objZbf != null) {
                        iHashCode = objZbf.hashCode();
                    }
                    i8 = i7 + iHashCode;
                    break;
                case 10:
                    i6 = i8 * 53;
                    iFloatToIntBits = zbws.zbf(obj, j6).hashCode();
                    i8 = iFloatToIntBits + i6;
                    break;
                case 11:
                    i5 = i8 * 53;
                    iZbc = zbws.zbc(obj, j6);
                    i8 = i5 + iZbc;
                    break;
                case 12:
                    i5 = i8 * 53;
                    iZbc = zbws.zbc(obj, j6);
                    i8 = i5 + iZbc;
                    break;
                case 13:
                    i5 = i8 * 53;
                    iZbc = zbws.zbc(obj, j6);
                    i8 = i5 + iZbc;
                    break;
                case 14:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j6);
                    byte[] bArr5 = zbuo.zbb;
                    iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZbc;
                    break;
                case 15:
                    i5 = i8 * 53;
                    iZbc = zbws.zbc(obj, j6);
                    i8 = i5 + iZbc;
                    break;
                case 16:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j6);
                    byte[] bArr6 = zbuo.zbb;
                    iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZbc;
                    break;
                case 17:
                    i7 = i8 * 53;
                    Object objZbf2 = zbws.zbf(obj, j6);
                    if (objZbf2 != null) {
                        iHashCode = objZbf2.hashCode();
                    }
                    i8 = i7 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i6 = i8 * 53;
                    iFloatToIntBits = zbws.zbf(obj, j6).hashCode();
                    i8 = iFloatToIntBits + i6;
                    break;
                case 50:
                    i6 = i8 * 53;
                    iFloatToIntBits = zbws.zbf(obj, j6).hashCode();
                    i8 = iFloatToIntBits + i6;
                    break;
                case 51:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zbm(obj, j6));
                        byte[] bArr7 = zbuo.zbb;
                        iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZbc;
                    }
                    break;
                case 52:
                    if (zbM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zbn(obj, j6));
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 53:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zbt(obj, j6);
                        byte[] bArr8 = zbuo.zbb;
                        iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZbc;
                    }
                    break;
                case 54:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zbt(obj, j6);
                        byte[] bArr9 = zbuo.zbb;
                        iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZbc;
                    }
                    break;
                case 55:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZbc = zbo(obj, j6);
                        i8 = i5 + iZbc;
                    }
                    break;
                case 56:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zbt(obj, j6);
                        byte[] bArr10 = zbuo.zbb;
                        iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZbc;
                    }
                    break;
                case 57:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZbc = zbo(obj, j6);
                        i8 = i5 + iZbc;
                    }
                    break;
                case 58:
                    if (zbM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = zbuo.zba(zbN(obj, j6));
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 59:
                    if (zbM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = ((String) zbws.zbf(obj, j6)).hashCode();
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 60:
                    if (zbM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = zbws.zbf(obj, j6).hashCode();
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 61:
                    if (zbM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = zbws.zbf(obj, j6).hashCode();
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 62:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZbc = zbo(obj, j6);
                        i8 = i5 + iZbc;
                    }
                    break;
                case 63:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZbc = zbo(obj, j6);
                        i8 = i5 + iZbc;
                    }
                    break;
                case 64:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZbc = zbo(obj, j6);
                        i8 = i5 + iZbc;
                    }
                    break;
                case 65:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zbt(obj, j6);
                        byte[] bArr11 = zbuo.zbb;
                        iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZbc;
                    }
                    break;
                case 66:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZbc = zbo(obj, j6);
                        i8 = i5 + iZbc;
                    }
                    break;
                case 67:
                    if (zbM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zbt(obj, j6);
                        byte[] bArr12 = zbuo.zbb;
                        iZbc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZbc;
                    }
                    break;
                case 68:
                    if (zbM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = zbws.zbf(obj, j6).hashCode();
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
            }
        }
        int iHashCode2 = ((zbuf) obj).zbc.hashCode() + (i8 * 53);
        return this.zbh ? (iHashCode2 * 53) + ((zbub) obj).zbb.zba.hashCode() : iHashCode2;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 40541. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int zbc(java.lang.Object r36, byte[] r37, int r38, int r39, int r40, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsq r41) {
        /*
            Method dump skipped, instruction units count: 4054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp.zbc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsq):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final Object zbe() {
        return ((zbuf) this.zbg).zbt();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbf(Object obj) {
        if (zbL(obj)) {
            if (obj instanceof zbuf) {
                zbuf zbufVar = (zbuf) obj;
                zbufVar.zbE(Integer.MAX_VALUE);
                zbufVar.zba = 0;
                zbufVar.zbC();
            }
            int[] iArr = this.zbc;
            for (int i5 = 0; i5 < iArr.length; i5 += 3) {
                int iZbs = zbs(i5);
                int i6 = 1048575 & iZbs;
                int iZbr = zbr(iZbs);
                long j6 = i6;
                if (iZbr != 9) {
                    if (iZbr != 60 && iZbr != 68) {
                        switch (iZbr) {
                            case 17:
                                if (zbI(obj, i5)) {
                                    zbv(i5).zbf(zbb.getObject(obj, j6));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ((zbun) zbws.zbf(obj, j6)).zbb();
                                break;
                            case 50:
                                Unsafe unsafe = zbb;
                                Object object = unsafe.getObject(obj, j6);
                                if (object != null) {
                                    ((zbvg) object).zbc();
                                    unsafe.putObject(obj, j6, object);
                                }
                                break;
                        }
                    } else if (zbM(obj, this.zbc[i5], i5)) {
                        zbv(i5).zbf(zbb.getObject(obj, j6));
                    }
                } else if (zbI(obj, i5)) {
                    zbv(i5).zbf(zbb.getObject(obj, j6));
                }
            }
            this.zbl.zbb(obj);
            if (this.zbh) {
                this.zbm.zba(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbg(Object obj, Object obj2) {
        zbA(obj);
        obj2.getClass();
        for (int i5 = 0; i5 < this.zbc.length; i5 += 3) {
            int iZbs = zbs(i5);
            int i6 = 1048575 & iZbs;
            int[] iArr = this.zbc;
            int iZbr = zbr(iZbs);
            int i7 = iArr[i5];
            long j6 = i6;
            switch (iZbr) {
                case 0:
                    if (zbI(obj2, i5)) {
                        zbws.zbo(obj, j6, zbws.zba(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 1:
                    if (zbI(obj2, i5)) {
                        zbws.zbp(obj, j6, zbws.zbb(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 2:
                    if (zbI(obj2, i5)) {
                        zbws.zbr(obj, j6, zbws.zbd(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 3:
                    if (zbI(obj2, i5)) {
                        zbws.zbr(obj, j6, zbws.zbd(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 4:
                    if (zbI(obj2, i5)) {
                        zbws.zbq(obj, j6, zbws.zbc(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 5:
                    if (zbI(obj2, i5)) {
                        zbws.zbr(obj, j6, zbws.zbd(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 6:
                    if (zbI(obj2, i5)) {
                        zbws.zbq(obj, j6, zbws.zbc(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 7:
                    if (zbI(obj2, i5)) {
                        zbws.zbm(obj, j6, zbws.zbw(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 8:
                    if (zbI(obj2, i5)) {
                        zbws.zbs(obj, j6, zbws.zbf(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 9:
                    zbB(obj, obj2, i5);
                    break;
                case 10:
                    if (zbI(obj2, i5)) {
                        zbws.zbs(obj, j6, zbws.zbf(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 11:
                    if (zbI(obj2, i5)) {
                        zbws.zbq(obj, j6, zbws.zbc(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 12:
                    if (zbI(obj2, i5)) {
                        zbws.zbq(obj, j6, zbws.zbc(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 13:
                    if (zbI(obj2, i5)) {
                        zbws.zbq(obj, j6, zbws.zbc(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 14:
                    if (zbI(obj2, i5)) {
                        zbws.zbr(obj, j6, zbws.zbd(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 15:
                    if (zbI(obj2, i5)) {
                        zbws.zbq(obj, j6, zbws.zbc(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 16:
                    if (zbI(obj2, i5)) {
                        zbws.zbr(obj, j6, zbws.zbd(obj2, j6));
                        zbD(obj, i5);
                    }
                    break;
                case 17:
                    zbB(obj, obj2, i5);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zbun zbunVarZbd = (zbun) zbws.zbf(obj, j6);
                    zbun zbunVar = (zbun) zbws.zbf(obj2, j6);
                    int size = zbunVarZbd.size();
                    int size2 = zbunVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zbunVarZbd.zbc()) {
                            zbunVarZbd = zbunVarZbd.zbd(size2 + size);
                        }
                        zbunVarZbd.addAll(zbunVar);
                    }
                    if (size > 0) {
                        zbunVar = zbunVarZbd;
                    }
                    zbws.zbs(obj, j6, zbunVar);
                    break;
                case 50:
                    int i8 = zbvz.zba;
                    zbws.zbs(obj, j6, zbvh.zba(zbws.zbf(obj, j6), zbws.zbf(obj2, j6)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zbM(obj2, i7, i5)) {
                        zbws.zbs(obj, j6, zbws.zbf(obj2, j6));
                        zbE(obj, i7, i5);
                    }
                    break;
                case 60:
                    zbC(obj, obj2, i5);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zbM(obj2, i7, i5)) {
                        zbws.zbs(obj, j6, zbws.zbf(obj2, j6));
                        zbE(obj, i7, i5);
                    }
                    break;
                case 68:
                    zbC(obj, obj2, i5);
                    break;
            }
        }
        zbvz.zbp(this.zbl, obj, obj2);
        if (this.zbh) {
            zbvz.zbo(this.zbm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbh(Object obj, byte[] bArr, int i5, int i6, zbsq zbsqVar) {
        zbc(obj, bArr, i5, i6, 0, zbsqVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0212  */
    /* JADX WARN: Code duplicated, block: B:101:0x0223  */
    /* JADX WARN: Code duplicated, block: B:102:0x0234  */
    /* JADX WARN: Code duplicated, block: B:103:0x0245  */
    /* JADX WARN: Code duplicated, block: B:104:0x0256  */
    /* JADX WARN: Code duplicated, block: B:105:0x0267  */
    /* JADX WARN: Code duplicated, block: B:106:0x0278  */
    /* JADX WARN: Code duplicated, block: B:107:0x0289  */
    /* JADX WARN: Code duplicated, block: B:108:0x029a  */
    /* JADX WARN: Code duplicated, block: B:109:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:110:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:111:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:112:0x02de  */
    /* JADX WARN: Code duplicated, block: B:113:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:114:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:115:0x030e  */
    /* JADX WARN: Code duplicated, block: B:116:0x031e  */
    /* JADX WARN: Code duplicated, block: B:117:0x032e  */
    /* JADX WARN: Code duplicated, block: B:118:0x033e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0357  */
    /* JADX WARN: Code duplicated, block: B:130:0x0376 A[LOOP:3: B:128:0x0370->B:130:0x0376, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:131:0x0383  */
    /* JADX WARN: Code duplicated, block: B:136:0x039c  */
    /* JADX WARN: Code duplicated, block: B:137:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:138:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:139:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:140:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:141:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:142:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:143:0x040c  */
    /* JADX WARN: Code duplicated, block: B:144:0x041c  */
    /* JADX WARN: Code duplicated, block: B:146:0x0423  */
    /* JADX WARN: Code duplicated, block: B:147:0x0430  */
    /* JADX WARN: Code duplicated, block: B:149:0x0437  */
    /* JADX WARN: Code duplicated, block: B:151:0x0442  */
    /* JADX WARN: Code duplicated, block: B:153:0x0449  */
    /* JADX WARN: Code duplicated, block: B:154:0x0451  */
    /* JADX WARN: Code duplicated, block: B:156:0x0458  */
    /* JADX WARN: Code duplicated, block: B:157:0x0460  */
    /* JADX WARN: Code duplicated, block: B:159:0x0467  */
    /* JADX WARN: Code duplicated, block: B:160:0x046f  */
    /* JADX WARN: Code duplicated, block: B:162:0x0476  */
    /* JADX WARN: Code duplicated, block: B:163:0x047e  */
    /* JADX WARN: Code duplicated, block: B:165:0x0485  */
    /* JADX WARN: Code duplicated, block: B:166:0x048d  */
    /* JADX WARN: Code duplicated, block: B:168:0x0494  */
    /* JADX WARN: Code duplicated, block: B:169:0x049e  */
    /* JADX WARN: Code duplicated, block: B:171:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:172:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:174:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:175:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:177:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:178:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:180:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:181:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:183:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:184:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:186:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:187:0x0502  */
    /* JADX WARN: Code duplicated, block: B:189:0x0509  */
    /* JADX WARN: Code duplicated, block: B:190:0x0512  */
    /* JADX WARN: Code duplicated, block: B:192:0x0519  */
    /* JADX WARN: Code duplicated, block: B:193:0x0522  */
    /* JADX WARN: Code duplicated, block: B:195:0x0529  */
    /* JADX WARN: Code duplicated, block: B:196:0x0532  */
    /* JADX WARN: Code duplicated, block: B:198:0x0539  */
    /* JADX WARN: Code duplicated, block: B:224:0x0540 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x0540 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x0540 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x009a  */
    /* JADX WARN: Code duplicated, block: B:33:0x009d  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00af  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00df  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:54:0x0103  */
    /* JADX WARN: Code duplicated, block: B:56:0x0109  */
    /* JADX WARN: Code duplicated, block: B:57:0x0113  */
    /* JADX WARN: Code duplicated, block: B:59:0x0119  */
    /* JADX WARN: Code duplicated, block: B:60:0x0126  */
    /* JADX WARN: Code duplicated, block: B:62:0x012c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0135  */
    /* JADX WARN: Code duplicated, block: B:65:0x013b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0144  */
    /* JADX WARN: Code duplicated, block: B:68:0x014a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0153  */
    /* JADX WARN: Code duplicated, block: B:71:0x0159  */
    /* JADX WARN: Code duplicated, block: B:72:0x0162  */
    /* JADX WARN: Code duplicated, block: B:74:0x0168  */
    /* JADX WARN: Code duplicated, block: B:75:0x0171  */
    /* JADX WARN: Code duplicated, block: B:77:0x0177  */
    /* JADX WARN: Code duplicated, block: B:78:0x0180  */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX WARN: Code duplicated, block: B:80:0x0186  */
    /* JADX WARN: Code duplicated, block: B:81:0x018f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0195  */
    /* JADX WARN: Code duplicated, block: B:84:0x019e  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:89:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e3 A[LOOP:2: B:95:0x01dd->B:97:0x01e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:99:0x0201  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbi(Object obj, zbwy zbwyVar) {
        Map.Entry entry;
        Iterator it;
        int i5;
        int i6;
        int i7;
        int i8;
        long j6;
        int i9;
        List list;
        int i10;
        List list2;
        zbvx zbvxVarZbv;
        int i11;
        int i12;
        List list3;
        int i13;
        List list4;
        zbvx zbvxVarZbv2;
        int i14;
        Object object;
        zbvp<T> zbvpVar = this;
        if (zbvpVar.zbh) {
            zbtu zbtuVar = ((zbub) obj).zbb;
            if (zbtuVar.zba.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZbg = zbtuVar.zbg();
                entry = (Map.Entry) itZbg.next();
                it = itZbg;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = zbvpVar.zbc;
        Unsafe unsafe = zbb;
        int i15 = 0;
        int i16 = 1048575;
        int i17 = 0;
        while (i15 < iArr.length) {
            int iZbs = zbvpVar.zbs(i15);
            int[] iArr2 = zbvpVar.zbc;
            int iZbr = zbr(iZbs);
            int i18 = iArr2[i15];
            if (iZbr <= 17) {
                int i19 = iArr2[i15 + 2];
                int i20 = i19 & 1048575;
                if (i20 != i16) {
                    i5 = 1;
                    i17 = i20 == 1048575 ? 0 : unsafe.getInt(obj, i20);
                    i16 = i20;
                } else {
                    i5 = 1;
                }
                i6 = i16;
                i7 = i17;
                i8 = i5 << (i19 >>> 20);
            } else {
                i5 = 1;
                i6 = i16;
                i7 = i17;
                i8 = 0;
            }
            while (entry != null) {
                if (i18 >= 32149011) {
                    zbvpVar.zbm.zbb(zbwyVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                } else {
                    j6 = iZbs & 1048575;
                    switch (iZbr) {
                        case 0:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbf(i18, zbws.zba(obj, j6));
                            }
                            break;
                        case 1:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbo(i18, zbws.zbb(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 2:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbt(i18, unsafe.getLong(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 3:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbL(i18, unsafe.getLong(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 4:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbr(i18, unsafe.getInt(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 5:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbm(i18, unsafe.getLong(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 6:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbk(i18, unsafe.getInt(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 7:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbb(i18, zbws.zbw(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 8:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbP(i18, unsafe.getObject(obj, j6), zbwyVar);
                            }
                            zbvpVar = this;
                            break;
                        case 9:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbw(i18, unsafe.getObject(obj, j6), zbvpVar.zbv(i15));
                            }
                            break;
                        case 10:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbd(i18, (zbtc) unsafe.getObject(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 11:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbJ(i18, unsafe.getInt(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 12:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbi(i18, unsafe.getInt(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 13:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zby(i18, unsafe.getInt(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 14:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbA(i18, unsafe.getLong(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 15:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbC(i18, unsafe.getInt(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 16:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbE(i18, unsafe.getLong(obj, j6));
                            }
                            zbvpVar = this;
                            break;
                        case 17:
                            if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                                zbwyVar.zbq(i18, unsafe.getObject(obj, j6), zbvpVar.zbv(i15));
                            }
                            break;
                        case 18:
                            zbvz.zbr(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 19:
                            zbvz.zbv(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 20:
                            zbvz.zbx(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 21:
                            zbvz.zbD(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 22:
                            zbvz.zbw(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 23:
                            zbvz.zbu(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 24:
                            zbvz.zbt(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 25:
                            zbvz.zbq(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 26:
                            i9 = zbvpVar.zbc[i15];
                            list = (List) unsafe.getObject(obj, j6);
                            int i21 = zbvz.zba;
                            if (list != null && !list.isEmpty()) {
                                zbwyVar.zbI(i9, list);
                            }
                            break;
                        case 27:
                            i10 = zbvpVar.zbc[i15];
                            list2 = (List) unsafe.getObject(obj, j6);
                            zbvxVarZbv = zbvpVar.zbv(i15);
                            int i22 = zbvz.zba;
                            if (list2 != null && !list2.isEmpty()) {
                                for (i11 = 0; i11 < list2.size(); i11++) {
                                    ((zbtl) zbwyVar).zbw(i10, list2.get(i11), zbvxVarZbv);
                                }
                            }
                            break;
                        case 28:
                            i12 = zbvpVar.zbc[i15];
                            list3 = (List) unsafe.getObject(obj, j6);
                            int i23 = zbvz.zba;
                            if (list3 != null && !list3.isEmpty()) {
                                zbwyVar.zbe(i12, list3);
                            }
                            break;
                        case 29:
                            zbvz.zbC(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 30:
                            zbvz.zbs(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 31:
                            zbvz.zby(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 32:
                            zbvz.zbz(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 33:
                            zbvz.zbA(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 34:
                            zbvz.zbB(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                            break;
                        case 35:
                            zbvz.zbr(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 36:
                            zbvz.zbv(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 37:
                            zbvz.zbx(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 38:
                            zbvz.zbD(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 39:
                            zbvz.zbw(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 40:
                            zbvz.zbu(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 41:
                            zbvz.zbt(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 42:
                            zbvz.zbq(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 43:
                            zbvz.zbC(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 44:
                            zbvz.zbs(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 45:
                            zbvz.zby(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 46:
                            zbvz.zbz(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 47:
                            zbvz.zbA(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 48:
                            zbvz.zbB(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                            break;
                        case 49:
                            i13 = zbvpVar.zbc[i15];
                            list4 = (List) unsafe.getObject(obj, j6);
                            zbvxVarZbv2 = zbvpVar.zbv(i15);
                            int i24 = zbvz.zba;
                            if (list4 != null && !list4.isEmpty()) {
                                for (i14 = 0; i14 < list4.size(); i14++) {
                                    ((zbtl) zbwyVar).zbq(i13, list4.get(i14), zbvxVarZbv2);
                                }
                            }
                            break;
                        case 50:
                            object = unsafe.getObject(obj, j6);
                            if (object != null) {
                                zbwyVar.zbv(i18, ((zbvf) zbvpVar.zbw(i15)).zbc(), (zbvg) object);
                            }
                            break;
                        case 51:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbf(i18, zbm(obj, j6));
                            }
                            break;
                        case 52:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbo(i18, zbn(obj, j6));
                            }
                            break;
                        case 53:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbt(i18, zbt(obj, j6));
                            }
                            break;
                        case 54:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbL(i18, zbt(obj, j6));
                            }
                            break;
                        case 55:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbr(i18, zbo(obj, j6));
                            }
                            break;
                        case 56:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbm(i18, zbt(obj, j6));
                            }
                            break;
                        case 57:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbk(i18, zbo(obj, j6));
                            }
                            break;
                        case 58:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbb(i18, zbN(obj, j6));
                            }
                            break;
                        case 59:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbP(i18, unsafe.getObject(obj, j6), zbwyVar);
                            }
                            break;
                        case 60:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbw(i18, unsafe.getObject(obj, j6), zbvpVar.zbv(i15));
                            }
                            break;
                        case 61:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbd(i18, (zbtc) unsafe.getObject(obj, j6));
                            }
                            break;
                        case 62:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbJ(i18, zbo(obj, j6));
                            }
                            break;
                        case 63:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbi(i18, zbo(obj, j6));
                            }
                            break;
                        case 64:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zby(i18, zbo(obj, j6));
                            }
                            break;
                        case 65:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbA(i18, zbt(obj, j6));
                            }
                            break;
                        case 66:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbC(i18, zbo(obj, j6));
                            }
                            break;
                        case 67:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbE(i18, zbt(obj, j6));
                            }
                            break;
                        case 68:
                            if (zbvpVar.zbM(obj, i18, i15)) {
                                zbwyVar.zbq(i18, unsafe.getObject(obj, j6), zbvpVar.zbv(i15));
                            }
                            break;
                        default:
                            break;
                    }
                    i15 += 3;
                    i17 = i7;
                    i16 = i6;
                    entry = entry;
                }
            }
            j6 = iZbs & 1048575;
            switch (iZbr) {
                case 0:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbf(i18, zbws.zba(obj, j6));
                    }
                    break;
                case 1:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbo(i18, zbws.zbb(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 2:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbt(i18, unsafe.getLong(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 3:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbL(i18, unsafe.getLong(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 4:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbr(i18, unsafe.getInt(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 5:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbm(i18, unsafe.getLong(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 6:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbk(i18, unsafe.getInt(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 7:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbb(i18, zbws.zbw(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 8:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbP(i18, unsafe.getObject(obj, j6), zbwyVar);
                    }
                    zbvpVar = this;
                    break;
                case 9:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbw(i18, unsafe.getObject(obj, j6), zbvpVar.zbv(i15));
                    }
                    break;
                case 10:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbd(i18, (zbtc) unsafe.getObject(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 11:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbJ(i18, unsafe.getInt(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 12:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbi(i18, unsafe.getInt(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 13:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zby(i18, unsafe.getInt(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 14:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbA(i18, unsafe.getLong(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 15:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbC(i18, unsafe.getInt(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 16:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbE(i18, unsafe.getLong(obj, j6));
                    }
                    zbvpVar = this;
                    break;
                case 17:
                    if (zbvpVar.zbJ(obj, i15, i6, i7, i8)) {
                        zbwyVar.zbq(i18, unsafe.getObject(obj, j6), zbvpVar.zbv(i15));
                    }
                    break;
                case 18:
                    zbvz.zbr(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 19:
                    zbvz.zbv(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 20:
                    zbvz.zbx(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 21:
                    zbvz.zbD(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 22:
                    zbvz.zbw(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 23:
                    zbvz.zbu(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 24:
                    zbvz.zbt(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 25:
                    zbvz.zbq(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 26:
                    i9 = zbvpVar.zbc[i15];
                    list = (List) unsafe.getObject(obj, j6);
                    int i25 = zbvz.zba;
                    if (list != null) {
                        zbwyVar.zbI(i9, list);
                    }
                    break;
                case 27:
                    i10 = zbvpVar.zbc[i15];
                    list2 = (List) unsafe.getObject(obj, j6);
                    zbvxVarZbv = zbvpVar.zbv(i15);
                    int i26 = zbvz.zba;
                    if (list2 != null) {
                        while (i11 < list2.size()) {
                            ((zbtl) zbwyVar).zbw(i10, list2.get(i11), zbvxVarZbv);
                        }
                    }
                    break;
                case 28:
                    i12 = zbvpVar.zbc[i15];
                    list3 = (List) unsafe.getObject(obj, j6);
                    int i27 = zbvz.zba;
                    if (list3 != null) {
                        zbwyVar.zbe(i12, list3);
                    }
                    break;
                case 29:
                    zbvz.zbC(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 30:
                    zbvz.zbs(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 31:
                    zbvz.zby(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 32:
                    zbvz.zbz(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 33:
                    zbvz.zbA(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 34:
                    zbvz.zbB(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, false);
                    break;
                case 35:
                    zbvz.zbr(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 36:
                    zbvz.zbv(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 37:
                    zbvz.zbx(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 38:
                    zbvz.zbD(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 39:
                    zbvz.zbw(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 40:
                    zbvz.zbu(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 41:
                    zbvz.zbt(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 42:
                    zbvz.zbq(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 43:
                    zbvz.zbC(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 44:
                    zbvz.zbs(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 45:
                    zbvz.zby(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 46:
                    zbvz.zbz(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 47:
                    zbvz.zbA(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 48:
                    zbvz.zbB(zbvpVar.zbc[i15], (List) unsafe.getObject(obj, j6), zbwyVar, i5);
                    break;
                case 49:
                    i13 = zbvpVar.zbc[i15];
                    list4 = (List) unsafe.getObject(obj, j6);
                    zbvxVarZbv2 = zbvpVar.zbv(i15);
                    int i28 = zbvz.zba;
                    if (list4 != null) {
                        while (i14 < list4.size()) {
                            ((zbtl) zbwyVar).zbq(i13, list4.get(i14), zbvxVarZbv2);
                        }
                    }
                    break;
                case 50:
                    object = unsafe.getObject(obj, j6);
                    if (object != null) {
                        zbwyVar.zbv(i18, ((zbvf) zbvpVar.zbw(i15)).zbc(), (zbvg) object);
                    }
                    break;
                case 51:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbf(i18, zbm(obj, j6));
                    }
                    break;
                case 52:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbo(i18, zbn(obj, j6));
                    }
                    break;
                case 53:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbt(i18, zbt(obj, j6));
                    }
                    break;
                case 54:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbL(i18, zbt(obj, j6));
                    }
                    break;
                case 55:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbr(i18, zbo(obj, j6));
                    }
                    break;
                case 56:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbm(i18, zbt(obj, j6));
                    }
                    break;
                case 57:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbk(i18, zbo(obj, j6));
                    }
                    break;
                case 58:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbb(i18, zbN(obj, j6));
                    }
                    break;
                case 59:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbP(i18, unsafe.getObject(obj, j6), zbwyVar);
                    }
                    break;
                case 60:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbw(i18, unsafe.getObject(obj, j6), zbvpVar.zbv(i15));
                    }
                    break;
                case 61:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbd(i18, (zbtc) unsafe.getObject(obj, j6));
                    }
                    break;
                case 62:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbJ(i18, zbo(obj, j6));
                    }
                    break;
                case 63:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbi(i18, zbo(obj, j6));
                    }
                    break;
                case 64:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zby(i18, zbo(obj, j6));
                    }
                    break;
                case 65:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbA(i18, zbt(obj, j6));
                    }
                    break;
                case 66:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbC(i18, zbo(obj, j6));
                    }
                    break;
                case 67:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbE(i18, zbt(obj, j6));
                    }
                    break;
                case 68:
                    if (zbvpVar.zbM(obj, i18, i15)) {
                        zbwyVar.zbq(i18, unsafe.getObject(obj, j6), zbvpVar.zbv(i15));
                    }
                    break;
                default:
                    break;
            }
            i15 += 3;
            i17 = i7;
            i16 = i6;
            entry = entry;
        }
        while (entry != null) {
            zbvpVar.zbm.zbb(zbwyVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        ((zbuf) obj).zbc.zbl(zbwyVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbj(Object obj, Object obj2) {
        boolean zZbE;
        for (int i5 = 0; i5 < this.zbc.length; i5 += 3) {
            int iZbs = zbs(i5);
            long j6 = iZbs & 1048575;
            switch (zbr(iZbs)) {
                case 0:
                    if (!zbH(obj, obj2, i5) || Double.doubleToLongBits(zbws.zba(obj, j6)) != Double.doubleToLongBits(zbws.zba(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zbH(obj, obj2, i5) || Float.floatToIntBits(zbws.zbb(obj, j6)) != Float.floatToIntBits(zbws.zbb(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zbH(obj, obj2, i5) || zbws.zbd(obj, j6) != zbws.zbd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zbH(obj, obj2, i5) || zbws.zbd(obj, j6) != zbws.zbd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zbH(obj, obj2, i5) || zbws.zbc(obj, j6) != zbws.zbc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zbH(obj, obj2, i5) || zbws.zbd(obj, j6) != zbws.zbd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zbH(obj, obj2, i5) || zbws.zbc(obj, j6) != zbws.zbc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zbH(obj, obj2, i5) || zbws.zbw(obj, j6) != zbws.zbw(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zbH(obj, obj2, i5) || !zbvz.zbE(zbws.zbf(obj, j6), zbws.zbf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zbH(obj, obj2, i5) || !zbvz.zbE(zbws.zbf(obj, j6), zbws.zbf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zbH(obj, obj2, i5) || !zbvz.zbE(zbws.zbf(obj, j6), zbws.zbf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zbH(obj, obj2, i5) || zbws.zbc(obj, j6) != zbws.zbc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zbH(obj, obj2, i5) || zbws.zbc(obj, j6) != zbws.zbc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zbH(obj, obj2, i5) || zbws.zbc(obj, j6) != zbws.zbc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zbH(obj, obj2, i5) || zbws.zbd(obj, j6) != zbws.zbd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zbH(obj, obj2, i5) || zbws.zbc(obj, j6) != zbws.zbc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zbH(obj, obj2, i5) || zbws.zbd(obj, j6) != zbws.zbd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zbH(obj, obj2, i5) || !zbvz.zbE(zbws.zbf(obj, j6), zbws.zbf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZbE = zbvz.zbE(zbws.zbf(obj, j6), zbws.zbf(obj2, j6));
                    break;
                case 50:
                    zZbE = zbvz.zbE(zbws.zbf(obj, j6), zbws.zbf(obj2, j6));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZbp = zbp(i5) & 1048575;
                    if (zbws.zbc(obj, jZbp) != zbws.zbc(obj2, jZbp) || !zbvz.zbE(zbws.zbf(obj, j6), zbws.zbf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZbE) {
                return false;
            }
        }
        if (!((zbuf) obj).zbc.equals(((zbuf) obj2).zbc)) {
            return false;
        }
        if (this.zbh) {
            return ((zbub) obj).zbb.equals(((zbub) obj2).zbb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e6 A[LOOP:2: B:53:0x00d5->B:58:0x00e6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00fa A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbk(Object obj) {
        int i5;
        int i6;
        List list;
        zbvx zbvxVarZbv;
        int i7;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i8 < this.zbj) {
            int[] iArr = this.zbi;
            int[] iArr2 = this.zbc;
            int i11 = iArr[i8];
            int i12 = iArr2[i11];
            int iZbs = zbs(i11);
            int i13 = this.zbc[i11 + 2];
            int i14 = i13 & 1048575;
            int i15 = 1 << (i13 >>> 20);
            if (i14 != i10) {
                if (i14 != 1048575) {
                    i9 = zbb.getInt(obj, i14);
                }
                i6 = i9;
                i5 = i14;
            } else {
                i5 = i10;
                i6 = i9;
            }
            Object obj2 = obj;
            if ((268435456 & iZbs) != 0 && !zbJ(obj2, i11, i5, i6, i15)) {
                return false;
            }
            int iZbr = zbr(iZbs);
            if (iZbr == 9 || iZbr == 17) {
                if (zbJ(obj2, i11, i5, i6, i15) && !zbK(obj2, iZbs, zbv(i11))) {
                    return false;
                }
            } else if (iZbr == 27) {
                list = (List) zbws.zbf(obj2, iZbs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zbvxVarZbv = zbv(i11);
                    for (i7 = 0; i7 < list.size(); i7++) {
                        if (!zbvxVarZbv.zbk(list.get(i7))) {
                            return false;
                        }
                    }
                }
            } else if (iZbr == 60 || iZbr == 68) {
                if (zbM(obj2, i12, i11) && !zbK(obj2, iZbs, zbv(i11))) {
                    return false;
                }
            } else if (iZbr == 49) {
                list = (List) zbws.zbf(obj2, iZbs & 1048575);
                if (list.isEmpty()) {
                    zbvxVarZbv = zbv(i11);
                    while (i7 < list.size()) {
                        if (!zbvxVarZbv.zbk(list.get(i7))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZbr != 50) {
                continue;
            } else {
                zbvg zbvgVar = (zbvg) zbws.zbf(obj2, iZbs & 1048575);
                if (!zbvgVar.isEmpty() && ((zbvf) zbw(i11)).zbc().zbc.zbb() == zbwx.MESSAGE) {
                    zbvx zbvxVarZbb = null;
                    for (Object obj3 : zbvgVar.values()) {
                        if (zbvxVarZbb == null) {
                            zbvxVarZbb = zbvu.zba().zbb(obj3.getClass());
                        }
                        if (!zbvxVarZbb.zbk(obj3)) {
                            return false;
                        }
                    }
                }
            }
            i8++;
            obj = obj2;
            i10 = i5;
            i9 = i6;
        }
        return !this.zbh || ((zbub) obj).zbb.zbm();
    }
}
