package com.google.android.gms.internal.measurement;

import A3.AbstractC0157z;
import com.google.android.gms.auth.api.accounttransfer.a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zznp<T> implements zznx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzop.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznm zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoi zzl;
    private final zzls zzm;

    private zznp(int[] iArr, Object[] objArr, int i5, int i6, zznm zznmVar, boolean z6, int[] iArr2, int i7, int i8, zznr zznrVar, zzmy zzmyVar, zzoi zzoiVar, zzls zzlsVar, zznh zznhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i5;
        this.zzf = i6;
        boolean z7 = false;
        if (zzlsVar != null && (zznmVar instanceof zzmc)) {
            z7 = true;
        }
        this.zzh = z7;
        this.zzi = iArr2;
        this.zzj = i7;
        this.zzk = i8;
        this.zzl = zzoiVar;
        this.zzm = zzlsVar;
        this.zzg = zznmVar;
    }

    private static boolean zzA(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzmf) {
            return ((zzmf) obj).zzcf();
        }
        return true;
    }

    private static void zzB(Object obj) {
        if (!zzA(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private static double zzC(Object obj, long j6) {
        return ((Double) zzop.zzn(obj, j6)).doubleValue();
    }

    private static float zzD(Object obj, long j6) {
        return ((Float) zzop.zzn(obj, j6)).floatValue();
    }

    private static int zzE(Object obj, long j6) {
        return ((Integer) zzop.zzn(obj, j6)).intValue();
    }

    private static long zzF(Object obj, long j6) {
        return ((Long) zzop.zzn(obj, j6)).longValue();
    }

    private static boolean zzG(Object obj, long j6) {
        return ((Boolean) zzop.zzn(obj, j6)).booleanValue();
    }

    private final boolean zzH(Object obj, Object obj2, int i5) {
        return zzJ(obj, i5) == zzJ(obj2, i5);
    }

    private final boolean zzI(Object obj, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return zzJ(obj, i5);
        }
        return (i7 & i8) != 0;
    }

    private final boolean zzJ(Object obj, int i5) {
        int iZzy = zzy(i5);
        long j6 = iZzy & 1048575;
        if (j6 != 1048575) {
            return (zzop.zzd(obj, j6) & (1 << (iZzy >>> 20))) != 0;
        }
        int iZzx = zzx(i5);
        long j7 = iZzx & 1048575;
        switch (zzz(iZzx)) {
            case 0:
                return Double.doubleToRawLongBits(zzop.zzl(obj, j7)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzop.zzj(obj, j7)) != 0;
            case 2:
                return zzop.zzf(obj, j7) != 0;
            case 3:
                return zzop.zzf(obj, j7) != 0;
            case 4:
                return zzop.zzd(obj, j7) != 0;
            case 5:
                return zzop.zzf(obj, j7) != 0;
            case 6:
                return zzop.zzd(obj, j7) != 0;
            case 7:
                return zzop.zzh(obj, j7);
            case 8:
                Object objZzn = zzop.zzn(obj, j7);
                if (objZzn instanceof String) {
                    return !((String) objZzn).isEmpty();
                }
                if (objZzn instanceof zzlh) {
                    return !zzlh.zzb.equals(objZzn);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzop.zzn(obj, j7) != null;
            case 10:
                return !zzlh.zzb.equals(zzop.zzn(obj, j7));
            case 11:
                return zzop.zzd(obj, j7) != 0;
            case 12:
                return zzop.zzd(obj, j7) != 0;
            case 13:
                return zzop.zzd(obj, j7) != 0;
            case 14:
                return zzop.zzf(obj, j7) != 0;
            case 15:
                return zzop.zzd(obj, j7) != 0;
            case 16:
                return zzop.zzf(obj, j7) != 0;
            case 17:
                return zzop.zzn(obj, j7) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzK(Object obj, int i5) {
        int iZzy = zzy(i5);
        long j6 = 1048575 & iZzy;
        if (j6 == 1048575) {
            return;
        }
        zzop.zze(obj, j6, (1 << (iZzy >>> 20)) | zzop.zzd(obj, j6));
    }

    private final boolean zzL(Object obj, int i5, int i6) {
        return zzop.zzd(obj, (long) (zzy(i6) & 1048575)) == i5;
    }

    private final void zzM(Object obj, int i5, int i6) {
        zzop.zze(obj, zzy(i6) & 1048575, i5);
    }

    private final int zzN(int i5, int i6) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int i9 = iArr[i8];
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

    private static final int zzO(byte[] bArr, int i5, int i6, zzot zzotVar, Class cls, zzkw zzkwVar) {
        zzot zzotVar2 = zzot.zza;
        switch (zzotVar.ordinal()) {
            case 0:
                int i7 = i5 + 8;
                zzkwVar.zzc = Double.valueOf(Double.longBitsToDouble(zzkx.zze(bArr, i5)));
                return i7;
            case 1:
                int i8 = i5 + 4;
                zzkwVar.zzc = Float.valueOf(Float.intBitsToFloat(zzkx.zzd(bArr, i5)));
                return i8;
            case 2:
            case 3:
                int iZzc = zzkx.zzc(bArr, i5, zzkwVar);
                zzkwVar.zzc = Long.valueOf(zzkwVar.zzb);
                return iZzc;
            case 4:
            case 12:
            case 13:
                int iZza = zzkx.zza(bArr, i5, zzkwVar);
                zzkwVar.zzc = Integer.valueOf(zzkwVar.zza);
                return iZza;
            case 5:
            case 15:
                int i9 = i5 + 8;
                zzkwVar.zzc = Long.valueOf(zzkx.zze(bArr, i5));
                return i9;
            case 6:
            case 14:
                int i10 = i5 + 4;
                zzkwVar.zzc = Integer.valueOf(zzkx.zzd(bArr, i5));
                return i10;
            case 7:
                int iZzc2 = zzkx.zzc(bArr, i5, zzkwVar);
                zzkwVar.zzc = Boolean.valueOf(zzkwVar.zzb != 0);
                return iZzc2;
            case 8:
                return zzkx.zzf(bArr, i5, zzkwVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return zzkx.zzh(zznu.zza().zzb(cls), bArr, i5, i6, zzkwVar);
            case 11:
                return zzkx.zzg(bArr, i5, zzkwVar);
            case 16:
                int iZza2 = zzkx.zza(bArr, i5, zzkwVar);
                zzkwVar.zzc = Integer.valueOf(zzlj.zzb(zzkwVar.zza));
                return iZza2;
            case 17:
                int iZzc3 = zzkx.zzc(bArr, i5, zzkwVar);
                zzkwVar.zzc = Long.valueOf(zzlj.zzc(zzkwVar.zzb));
                return iZzc3;
        }
    }

    private static final void zzP(int i5, Object obj, zzov zzovVar) {
        if (obj instanceof String) {
            zzovVar.zzm(i5, (String) obj);
        } else {
            zzovVar.zzn(i5, (zzlh) obj);
        }
    }

    public static zzoj zzg(Object obj) {
        zzmf zzmfVar = (zzmf) obj;
        zzoj zzojVar = zzmfVar.zzc;
        if (zzojVar != zzoj.zza()) {
            return zzojVar;
        }
        zzoj zzojVarZzb = zzoj.zzb();
        zzmfVar.zzc = zzojVarZzb;
        return zzojVarZzb;
    }

    /* JADX WARN: Code duplicated, block: B:187:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:193:0x03e2  */
    public static zznp zzl(Class cls, zznj zznjVar, zznr zznrVar, zzmy zzmyVar, zzoi zzoiVar, zzls zzlsVar, zznh zznhVar) {
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
        zznw zznwVar;
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
        Field fieldZzm;
        char cCharAt9;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        Field fieldZzm2;
        Field fieldZzm3;
        int i34;
        char cCharAt10;
        int i35;
        int i36;
        char cCharAt11;
        int i37;
        char cCharAt12;
        int i38;
        char cCharAt13;
        if (!(zznjVar instanceof zznw)) {
            throw null;
        }
        zznw zznwVar2 = (zznw) zznjVar;
        String strZzd = zznwVar2.zzd();
        int length = strZzd.length();
        char c6 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i39 = 1;
            while (true) {
                i5 = i39 + 1;
                if (strZzd.charAt(i39) < 55296) {
                    break;
                }
                i39 = i5;
            }
        } else {
            i5 = 1;
        }
        int i40 = i5 + 1;
        int iCharAt2 = strZzd.charAt(i5);
        if (iCharAt2 >= 55296) {
            int i41 = iCharAt2 & 8191;
            int i42 = 13;
            while (true) {
                i38 = i40 + 1;
                cCharAt13 = strZzd.charAt(i40);
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
            iArr = zza;
            i11 = 0;
        } else {
            int i43 = i40 + 1;
            int iCharAt3 = strZzd.charAt(i40);
            if (iCharAt3 >= 55296) {
                int i44 = iCharAt3 & 8191;
                int i45 = 13;
                while (true) {
                    i19 = i43 + 1;
                    cCharAt8 = strZzd.charAt(i43);
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
            int iCharAt4 = strZzd.charAt(i43);
            if (iCharAt4 >= 55296) {
                int i47 = iCharAt4 & 8191;
                int i48 = 13;
                while (true) {
                    i18 = i46 + 1;
                    cCharAt7 = strZzd.charAt(i46);
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
            int iCharAt5 = strZzd.charAt(i46);
            if (iCharAt5 >= 55296) {
                int i50 = iCharAt5 & 8191;
                int i51 = 13;
                while (true) {
                    i17 = i49 + 1;
                    cCharAt6 = strZzd.charAt(i49);
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
            int iCharAt6 = strZzd.charAt(i49);
            if (iCharAt6 >= 55296) {
                int i53 = iCharAt6 & 8191;
                int i54 = 13;
                while (true) {
                    i16 = i52 + 1;
                    cCharAt5 = strZzd.charAt(i52);
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
            iCharAt = strZzd.charAt(i52);
            if (iCharAt >= 55296) {
                int i56 = iCharAt & 8191;
                int i57 = 13;
                while (true) {
                    i15 = i55 + 1;
                    cCharAt4 = strZzd.charAt(i55);
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
            int iCharAt7 = strZzd.charAt(i55);
            if (iCharAt7 >= 55296) {
                int i59 = iCharAt7 & 8191;
                int i60 = 13;
                while (true) {
                    i14 = i58 + 1;
                    cCharAt3 = strZzd.charAt(i58);
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
            int iCharAt8 = strZzd.charAt(i58);
            if (iCharAt8 >= 55296) {
                int i62 = iCharAt8 & 8191;
                int i63 = 13;
                while (true) {
                    i13 = i61 + 1;
                    cCharAt2 = strZzd.charAt(i61);
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
            int iCharAt9 = strZzd.charAt(i61);
            if (iCharAt9 >= 55296) {
                int i65 = iCharAt9 & 8191;
                int i66 = 13;
                while (true) {
                    i12 = i64 + 1;
                    cCharAt = strZzd.charAt(i64);
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
        Unsafe unsafe = zzb;
        Object[] objArrZze = zznwVar2.zze();
        Class<?> cls2 = zznwVar2.zzb().getClass();
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
            int iCharAt10 = strZzd.charAt(i40);
            if (iCharAt10 >= c6) {
                int i76 = iCharAt10 & 8191;
                int i77 = i75;
                int i78 = 13;
                while (true) {
                    i37 = i77 + 1;
                    cCharAt12 = strZzd.charAt(i77);
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
            int iCharAt11 = strZzd.charAt(i20);
            if (iCharAt11 >= c6) {
                int i80 = iCharAt11 & 8191;
                int i81 = i79;
                int i82 = 13;
                while (true) {
                    i36 = i81 + 1;
                    cCharAt11 = strZzd.charAt(i81);
                    zznwVar = zznwVar2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i80 |= (cCharAt11 & 8191) << i82;
                    i82 += 13;
                    i81 = i36;
                    zznwVar2 = zznwVar;
                }
                iCharAt11 = i80 | (cCharAt11 << i82);
                i21 = i36;
            } else {
                zznwVar = zznwVar2;
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
                int iCharAt12 = strZzd.charAt(i21);
                if (iCharAt12 >= 55296) {
                    int i87 = iCharAt12 & 8191;
                    int i88 = i86;
                    int i89 = 13;
                    while (true) {
                        i34 = i88 + 1;
                        cCharAt10 = strZzd.charAt(i88);
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
                    objArr2[a.r(i73, 3, 1)] = objArrZze[i10];
                    i33 = i85;
                    i10++;
                } else if (i91 != 12) {
                    i33 = i85;
                } else if (zznwVar.zzc() == 1 || i85 != 0) {
                    objArr2[a.r(i73, 3, 1)] = objArrZze[i10];
                    i10++;
                    i33 = i85;
                } else {
                    i33 = 0;
                }
                int i93 = i90 + i90;
                Object obj = objArrZze[i93];
                int i94 = i33;
                if (obj instanceof Field) {
                    fieldZzm2 = (Field) obj;
                } else {
                    fieldZzm2 = zzm(cls2, (String) obj);
                    objArrZze[i93] = fieldZzm2;
                }
                Object[] objArr3 = objArr2;
                int i95 = i10;
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzm2);
                int i96 = i93 + 1;
                Object obj2 = objArrZze[i96];
                if (obj2 instanceof Field) {
                    fieldZzm3 = (Field) obj2;
                } else {
                    fieldZzm3 = zzm(cls2, (String) obj2);
                    objArrZze[i96] = fieldZzm3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzm3);
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
                Field fieldZzm4 = zzm(cls2, (String) objArrZze[i10]);
                i22 = iCharAt10;
                if (i83 == 9 || i83 == 17) {
                    i11 = i11;
                    objArr[a.r(i73, 3, 1)] = fieldZzm4.getType();
                } else {
                    if (i83 != 27) {
                        if (i83 == 49) {
                            i31 = i10 + 2;
                            i29 = 3;
                            i30 = 1;
                        } else if (i83 == 12 || i83 == 30 || i83 == 44) {
                            i11 = i11;
                            if (zznwVar.zzc() == 1 || i85 != 0) {
                                i31 = i10 + 2;
                                objArr[a.r(i73, 3, 1)] = objArrZze[i97];
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
                            objArr[i100] = objArrZze[i97];
                            if (i85 != 0) {
                                i97 = i10 + 3;
                                objArr[i100 + 1] = objArrZze[i98];
                            } else {
                                i97 = i98;
                                i85 = 0;
                            }
                            i11 = i11;
                        } else {
                            i11 = i11;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzm4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i83 > 17) {
                            c = 55296;
                            i23 = i21;
                            i24 = 0;
                        } else {
                            int i101 = i21 + 1;
                            int iCharAt13 = strZzd.charAt(i21);
                            if (iCharAt13 >= 55296) {
                                int i102 = iCharAt13 & 8191;
                                int i103 = 13;
                                while (true) {
                                    i28 = i101 + 1;
                                    cCharAt9 = strZzd.charAt(i101);
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
                            Object obj3 = objArrZze[i104];
                            if (obj3 instanceof Field) {
                                fieldZzm = (Field) obj3;
                            } else {
                                fieldZzm = zzm(cls2, (String) obj3);
                                objArrZze[i104] = fieldZzm;
                            }
                            i24 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzm);
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
                    objArr[a.r(i73, i29, i30)] = objArrZze[i97];
                    i97 = i31;
                }
                i73 = i73;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzm4);
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
            zznwVar2 = zznwVar;
            i11 = i11;
            objArr2 = objArr;
        }
        return new zznp(iArr3, objArr2, i6, i8, zznwVar2.zzb(), false, iArr, i9, i69, zznrVar, zzmyVar, zzoiVar, zzlsVar, zznhVar);
    }

    private static Field zzm(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(androidx.exifinterface.media.a.b(11, str) + name.length() + 29 + String.valueOf(string).length());
            androidx.collection.a.y(sb, "Field ", str, " for ", name);
            throw new RuntimeException(AbstractC0157z.s(sb, " not found. Known fields are ", string), e);
        }
    }

    private final void zzn(Object obj, Object obj2, int i5) {
        if (zzJ(obj2, i5)) {
            int iZzx = zzx(i5) & 1048575;
            Unsafe unsafe = zzb;
            long j6 = iZzx;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                int i6 = this.zzc[i5];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i6);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zznx zznxVarZzp = zzp(i5);
            if (!zzJ(obj, i5)) {
                if (zzA(object)) {
                    Object objZza = zznxVarZzp.zza();
                    zznxVarZzp.zzd(objZza, object);
                    unsafe.putObject(obj, j6, objZza);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zzK(obj, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzA(object2)) {
                Object objZza2 = zznxVarZzp.zza();
                zznxVarZzp.zzd(objZza2, object2);
                unsafe.putObject(obj, j6, objZza2);
                object2 = objZza2;
            }
            zznxVarZzp.zzd(object2, object);
        }
    }

    private final void zzo(Object obj, Object obj2, int i5) {
        int[] iArr = this.zzc;
        int i6 = iArr[i5];
        if (zzL(obj2, i6, i5)) {
            int iZzx = zzx(i5) & 1048575;
            Unsafe unsafe = zzb;
            long j6 = iZzx;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                int i7 = iArr[i5];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i7);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zznx zznxVarZzp = zzp(i5);
            if (!zzL(obj, i6, i5)) {
                if (zzA(object)) {
                    Object objZza = zznxVarZzp.zza();
                    zznxVarZzp.zzd(objZza, object);
                    unsafe.putObject(obj, j6, objZza);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zzM(obj, i6, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzA(object2)) {
                Object objZza2 = zznxVarZzp.zza();
                zznxVarZzp.zzd(objZza2, object2);
                unsafe.putObject(obj, j6, objZza2);
                object2 = objZza2;
            }
            zznxVarZzp.zzd(object2, object);
        }
    }

    private final zznx zzp(int i5) {
        Object[] objArr = this.zzd;
        int i6 = i5 / 3;
        int i7 = i6 + i6;
        zznx zznxVar = (zznx) objArr[i7];
        if (zznxVar != null) {
            return zznxVar;
        }
        zznx zznxVarZzb = zznu.zza().zzb((Class) objArr[i7 + 1]);
        objArr[i7] = zznxVarZzb;
        return zznxVarZzb;
    }

    private final Object zzq(int i5) {
        int i6 = i5 / 3;
        return this.zzd[i6 + i6];
    }

    private final zzmk zzr(int i5) {
        int i6 = i5 / 3;
        return (zzmk) this.zzd[i6 + i6 + 1];
    }

    private final Object zzs(Object obj, int i5) {
        zznx zznxVarZzp = zzp(i5);
        int iZzx = zzx(i5) & 1048575;
        if (!zzJ(obj, i5)) {
            return zznxVarZzp.zza();
        }
        Object object = zzb.getObject(obj, iZzx);
        if (zzA(object)) {
            return object;
        }
        Object objZza = zznxVarZzp.zza();
        if (object != null) {
            zznxVarZzp.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzt(Object obj, int i5, Object obj2) {
        zzb.putObject(obj, zzx(i5) & 1048575, obj2);
        zzK(obj, i5);
    }

    private final Object zzu(Object obj, int i5, int i6) {
        zznx zznxVarZzp = zzp(i6);
        if (!zzL(obj, i5, i6)) {
            return zznxVarZzp.zza();
        }
        Object object = zzb.getObject(obj, zzx(i6) & 1048575);
        if (zzA(object)) {
            return object;
        }
        Object objZza = zznxVarZzp.zza();
        if (object != null) {
            zznxVarZzp.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzv(Object obj, int i5, int i6, Object obj2) {
        zzb.putObject(obj, zzx(i6) & 1048575, obj2);
        zzM(obj, i5, i6);
    }

    private static boolean zzw(Object obj, int i5, zznx zznxVar) {
        return zznxVar.zzk(zzop.zzn(obj, i5 & 1048575));
    }

    private final int zzx(int i5) {
        return this.zzc[i5 + 1];
    }

    private final int zzy(int i5) {
        return this.zzc[i5 + 2];
    }

    private static int zzz(int i5) {
        return (i5 >>> 20) & 255;
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final Object zza() {
        return ((zzmf) this.zzg).zzch();
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final boolean zzb(Object obj, Object obj2) {
        boolean zZzB;
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int iZzx = zzx(i5);
            long j6 = iZzx & 1048575;
            switch (zzz(iZzx)) {
                case 0:
                    if (!zzH(obj, obj2, i5) || Double.doubleToLongBits(zzop.zzl(obj, j6)) != Double.doubleToLongBits(zzop.zzl(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i5) || Float.floatToIntBits(zzop.zzj(obj, j6)) != Float.floatToIntBits(zzop.zzj(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i5) || zzop.zzf(obj, j6) != zzop.zzf(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i5) || zzop.zzf(obj, j6) != zzop.zzf(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i5) || zzop.zzd(obj, j6) != zzop.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i5) || zzop.zzf(obj, j6) != zzop.zzf(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i5) || zzop.zzd(obj, j6) != zzop.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i5) || zzop.zzh(obj, j6) != zzop.zzh(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i5) || !zznz.zzB(zzop.zzn(obj, j6), zzop.zzn(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i5) || !zznz.zzB(zzop.zzn(obj, j6), zzop.zzn(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i5) || !zznz.zzB(zzop.zzn(obj, j6), zzop.zzn(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i5) || zzop.zzd(obj, j6) != zzop.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i5) || zzop.zzd(obj, j6) != zzop.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i5) || zzop.zzd(obj, j6) != zzop.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i5) || zzop.zzf(obj, j6) != zzop.zzf(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i5) || zzop.zzd(obj, j6) != zzop.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i5) || zzop.zzf(obj, j6) != zzop.zzf(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i5) || !zznz.zzB(zzop.zzn(obj, j6), zzop.zzn(obj2, j6))) {
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
                    zZzB = zznz.zzB(zzop.zzn(obj, j6), zzop.zzn(obj2, j6));
                    break;
                case 50:
                    zZzB = zznz.zzB(zzop.zzn(obj, j6), zzop.zzn(obj2, j6));
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
                    long jZzy = zzy(i5) & 1048575;
                    if (zzop.zzd(obj, jZzy) != zzop.zzd(obj2, jZzy) || !zznz.zzB(zzop.zzn(obj, j6), zzop.zzn(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzB) {
                return false;
            }
        }
        if (!((zzmf) obj).zzc.equals(((zzmf) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzmc) obj).zzb.equals(((zzmc) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final int zzc(Object obj) {
        int i5;
        long jDoubleToLongBits;
        int i6;
        int iFloatToIntBits;
        int iZzd;
        int i7;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i8 >= iArr.length) {
                int iHashCode = ((zzmf) obj).zzc.hashCode() + (i9 * 53);
                return this.zzh ? (iHashCode * 53) + ((zzmc) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzx = zzx(i8);
            int i10 = 1048575 & iZzx;
            int iZzz = zzz(iZzx);
            int i11 = iArr[i8];
            long j6 = i10;
            int iHashCode2 = 37;
            switch (iZzz) {
                case 0:
                    i5 = i9 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzop.zzl(obj, j6));
                    byte[] bArr = zzmp.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i9 = i5 + iZzd;
                    break;
                case 1:
                    i6 = i9 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzop.zzj(obj, j6));
                    i9 = iFloatToIntBits + i6;
                    break;
                case 2:
                    i5 = i9 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j6);
                    byte[] bArr2 = zzmp.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i9 = i5 + iZzd;
                    break;
                case 3:
                    i5 = i9 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j6);
                    byte[] bArr3 = zzmp.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i9 = i5 + iZzd;
                    break;
                case 4:
                    i5 = i9 * 53;
                    iZzd = zzop.zzd(obj, j6);
                    i9 = i5 + iZzd;
                    break;
                case 5:
                    i5 = i9 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j6);
                    byte[] bArr4 = zzmp.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i9 = i5 + iZzd;
                    break;
                case 6:
                    i5 = i9 * 53;
                    iZzd = zzop.zzd(obj, j6);
                    i9 = i5 + iZzd;
                    break;
                case 7:
                    i6 = i9 * 53;
                    iFloatToIntBits = zzmp.zzb(zzop.zzh(obj, j6));
                    i9 = iFloatToIntBits + i6;
                    break;
                case 8:
                    i6 = i9 * 53;
                    iFloatToIntBits = ((String) zzop.zzn(obj, j6)).hashCode();
                    i9 = iFloatToIntBits + i6;
                    break;
                case 9:
                    i7 = i9 * 53;
                    Object objZzn = zzop.zzn(obj, j6);
                    if (objZzn != null) {
                        iHashCode2 = objZzn.hashCode();
                    }
                    i9 = i7 + iHashCode2;
                    break;
                case 10:
                    i6 = i9 * 53;
                    iFloatToIntBits = zzop.zzn(obj, j6).hashCode();
                    i9 = iFloatToIntBits + i6;
                    break;
                case 11:
                    i5 = i9 * 53;
                    iZzd = zzop.zzd(obj, j6);
                    i9 = i5 + iZzd;
                    break;
                case 12:
                    i5 = i9 * 53;
                    iZzd = zzop.zzd(obj, j6);
                    i9 = i5 + iZzd;
                    break;
                case 13:
                    i5 = i9 * 53;
                    iZzd = zzop.zzd(obj, j6);
                    i9 = i5 + iZzd;
                    break;
                case 14:
                    i5 = i9 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j6);
                    byte[] bArr5 = zzmp.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i9 = i5 + iZzd;
                    break;
                case 15:
                    i5 = i9 * 53;
                    iZzd = zzop.zzd(obj, j6);
                    i9 = i5 + iZzd;
                    break;
                case 16:
                    i5 = i9 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j6);
                    byte[] bArr6 = zzmp.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i9 = i5 + iZzd;
                    break;
                case 17:
                    i7 = i9 * 53;
                    Object objZzn2 = zzop.zzn(obj, j6);
                    if (objZzn2 != null) {
                        iHashCode2 = objZzn2.hashCode();
                    }
                    i9 = i7 + iHashCode2;
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
                    i6 = i9 * 53;
                    iFloatToIntBits = zzop.zzn(obj, j6).hashCode();
                    i9 = iFloatToIntBits + i6;
                    break;
                case 50:
                    i6 = i9 * 53;
                    iFloatToIntBits = zzop.zzn(obj, j6).hashCode();
                    i9 = iFloatToIntBits + i6;
                    break;
                case 51:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzC(obj, j6));
                        byte[] bArr7 = zzmp.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i9 = i5 + iZzd;
                    }
                    break;
                case 52:
                    if (zzL(obj, i11, i8)) {
                        i6 = i9 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzD(obj, j6));
                        i9 = iFloatToIntBits + i6;
                    }
                    break;
                case 53:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        jDoubleToLongBits = zzF(obj, j6);
                        byte[] bArr8 = zzmp.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i9 = i5 + iZzd;
                    }
                    break;
                case 54:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        jDoubleToLongBits = zzF(obj, j6);
                        byte[] bArr9 = zzmp.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i9 = i5 + iZzd;
                    }
                    break;
                case 55:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        iZzd = zzE(obj, j6);
                        i9 = i5 + iZzd;
                    }
                    break;
                case 56:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        jDoubleToLongBits = zzF(obj, j6);
                        byte[] bArr10 = zzmp.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i9 = i5 + iZzd;
                    }
                    break;
                case 57:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        iZzd = zzE(obj, j6);
                        i9 = i5 + iZzd;
                    }
                    break;
                case 58:
                    if (zzL(obj, i11, i8)) {
                        i6 = i9 * 53;
                        iFloatToIntBits = zzmp.zzb(zzG(obj, j6));
                        i9 = iFloatToIntBits + i6;
                    }
                    break;
                case 59:
                    if (zzL(obj, i11, i8)) {
                        i6 = i9 * 53;
                        iFloatToIntBits = ((String) zzop.zzn(obj, j6)).hashCode();
                        i9 = iFloatToIntBits + i6;
                    }
                    break;
                case 60:
                    if (zzL(obj, i11, i8)) {
                        i6 = i9 * 53;
                        iFloatToIntBits = zzop.zzn(obj, j6).hashCode();
                        i9 = iFloatToIntBits + i6;
                    }
                    break;
                case 61:
                    if (zzL(obj, i11, i8)) {
                        i6 = i9 * 53;
                        iFloatToIntBits = zzop.zzn(obj, j6).hashCode();
                        i9 = iFloatToIntBits + i6;
                    }
                    break;
                case 62:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        iZzd = zzE(obj, j6);
                        i9 = i5 + iZzd;
                    }
                    break;
                case 63:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        iZzd = zzE(obj, j6);
                        i9 = i5 + iZzd;
                    }
                    break;
                case 64:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        iZzd = zzE(obj, j6);
                        i9 = i5 + iZzd;
                    }
                    break;
                case 65:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        jDoubleToLongBits = zzF(obj, j6);
                        byte[] bArr11 = zzmp.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i9 = i5 + iZzd;
                    }
                    break;
                case 66:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        iZzd = zzE(obj, j6);
                        i9 = i5 + iZzd;
                    }
                    break;
                case 67:
                    if (zzL(obj, i11, i8)) {
                        i5 = i9 * 53;
                        jDoubleToLongBits = zzF(obj, j6);
                        byte[] bArr12 = zzmp.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i9 = i5 + iZzd;
                    }
                    break;
                case 68:
                    if (zzL(obj, i11, i8)) {
                        i6 = i9 * 53;
                        iFloatToIntBits = zzop.zzn(obj, j6).hashCode();
                        i9 = iFloatToIntBits + i6;
                    }
                    break;
            }
            i8 += 3;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final void zzd(Object obj, Object obj2) {
        zzB(obj);
        obj2.getClass();
        int i5 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i5 >= iArr.length) {
                zznz.zzD(this.zzl, obj, obj2);
                if (this.zzh) {
                    zznz.zzC(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int iZzx = zzx(i5);
            int i6 = 1048575 & iZzx;
            int iZzz = zzz(iZzx);
            int i7 = iArr[i5];
            long j6 = i6;
            switch (iZzz) {
                case 0:
                    if (zzJ(obj2, i5)) {
                        zzop.zzm(obj, j6, zzop.zzl(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 1:
                    if (zzJ(obj2, i5)) {
                        zzop.zzk(obj, j6, zzop.zzj(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 2:
                    if (zzJ(obj2, i5)) {
                        zzop.zzg(obj, j6, zzop.zzf(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 3:
                    if (zzJ(obj2, i5)) {
                        zzop.zzg(obj, j6, zzop.zzf(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 4:
                    if (zzJ(obj2, i5)) {
                        zzop.zze(obj, j6, zzop.zzd(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 5:
                    if (zzJ(obj2, i5)) {
                        zzop.zzg(obj, j6, zzop.zzf(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 6:
                    if (zzJ(obj2, i5)) {
                        zzop.zze(obj, j6, zzop.zzd(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 7:
                    if (zzJ(obj2, i5)) {
                        zzop.zzi(obj, j6, zzop.zzh(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 8:
                    if (zzJ(obj2, i5)) {
                        zzop.zzo(obj, j6, zzop.zzn(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 9:
                    zzn(obj, obj2, i5);
                    break;
                case 10:
                    if (zzJ(obj2, i5)) {
                        zzop.zzo(obj, j6, zzop.zzn(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 11:
                    if (zzJ(obj2, i5)) {
                        zzop.zze(obj, j6, zzop.zzd(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 12:
                    if (zzJ(obj2, i5)) {
                        zzop.zze(obj, j6, zzop.zzd(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 13:
                    if (zzJ(obj2, i5)) {
                        zzop.zze(obj, j6, zzop.zzd(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 14:
                    if (zzJ(obj2, i5)) {
                        zzop.zzg(obj, j6, zzop.zzf(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 15:
                    if (zzJ(obj2, i5)) {
                        zzop.zze(obj, j6, zzop.zzd(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 16:
                    if (zzJ(obj2, i5)) {
                        zzop.zzg(obj, j6, zzop.zzf(obj2, j6));
                        zzK(obj, i5);
                    }
                    break;
                case 17:
                    zzn(obj, obj2, i5);
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
                    zzmo zzmoVarZzg = (zzmo) zzop.zzn(obj, j6);
                    zzmo zzmoVar = (zzmo) zzop.zzn(obj2, j6);
                    int size = zzmoVarZzg.size();
                    int size2 = zzmoVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzmoVarZzg.zza()) {
                            zzmoVarZzg = zzmoVarZzg.zzg(size2 + size);
                        }
                        zzmoVarZzg.addAll(zzmoVar);
                    }
                    if (size > 0) {
                        zzmoVar = zzmoVarZzg;
                    }
                    zzop.zzo(obj, j6, zzmoVar);
                    break;
                case 50:
                    int i8 = zznz.zza;
                    zzop.zzo(obj, j6, zznh.zza(zzop.zzn(obj, j6), zzop.zzn(obj2, j6)));
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
                    if (zzL(obj2, i7, i5)) {
                        zzop.zzo(obj, j6, zzop.zzn(obj2, j6));
                        zzM(obj, i7, i5);
                    }
                    break;
                case 60:
                    zzo(obj, obj2, i5);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzL(obj2, i7, i5)) {
                        zzop.zzo(obj, j6, zzop.zzn(obj2, j6));
                        zzM(obj, i7, i5);
                    }
                    break;
                case 68:
                    zzo(obj, obj2, i5);
                    break;
            }
            i5 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:196:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e5  */
    @Override // com.google.android.gms.internal.measurement.zznx
    public final int zze(Object obj) {
        int i5;
        int iZzz;
        int iZzA;
        int iZzz2;
        int iZzc;
        int iZzz3;
        int iZzz4;
        int iZzG;
        int iZzz5;
        int size;
        int iZzp;
        int iZzz6;
        int iZzz7;
        int iZzz8;
        int iZzx;
        int iZzz9;
        int iZzz10;
        int iZzG2;
        int iZzz11;
        int iZzA2;
        zznp<T> zznpVar = this;
        Unsafe unsafe = zzb;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int iB = 0;
        int i9 = 1048575;
        while (true) {
            int[] iArr = zznpVar.zzc;
            if (i7 >= iArr.length) {
                int iZzi = ((zzmf) obj).zzc.zzi() + iB;
                if (!zznpVar.zzh) {
                    return iZzi;
                }
                zzoe zzoeVar = ((zzmc) obj).zzb.zza;
                int iZzc2 = zzoeVar.zzc();
                int iZzj = 0;
                for (int i10 = 0; i10 < iZzc2; i10++) {
                    Map.Entry entryZzd = zzoeVar.zzd(i10);
                    iZzj += zzlw.zzj((zzlv) ((zzob) entryZzd).zza(), entryZzd.getValue());
                }
                for (Map.Entry entry : zzoeVar.zze()) {
                    iZzj += zzlw.zzj((zzlv) entry.getKey(), entry.getValue());
                }
                return iZzi + iZzj;
            }
            int iZzx2 = zznpVar.zzx(i7);
            int iZzz12 = zzz(iZzx2);
            int i11 = iArr[i7];
            int i12 = iArr[i7 + 2];
            int i13 = i12 & i6;
            if (iZzz12 <= 17) {
                if (i13 != i9) {
                    i8 = i13 == i6 ? 0 : unsafe.getInt(obj, i13);
                    i9 = i13;
                }
                i5 = 1 << (i12 >>> 20);
            } else {
                i5 = 0;
            }
            int i14 = iZzx2 & i6;
            if (iZzz12 >= zzlx.zzJ.zza()) {
                zzlx.zzW.zza();
            }
            long j6 = i14;
            switch (iZzz12) {
                case 0:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iB = a.b(i11 << 3, 8, iB);
                    }
                    break;
                case 1:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iB = a.b(i11 << 3, 4, iB);
                    }
                    zznpVar = this;
                    break;
                case 2:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        long j7 = unsafe.getLong(obj, j6);
                        iZzz = zzlm.zzz(i11 << 3);
                        iZzA = zzlm.zzA(j7);
                        iB += iZzA + iZzz;
                    }
                    zznpVar = this;
                    break;
                case 3:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        long j8 = unsafe.getLong(obj, j6);
                        iZzz = zzlm.zzz(i11 << 3);
                        iZzA = zzlm.zzA(j8);
                        iB += iZzA + iZzz;
                    }
                    zznpVar = this;
                    break;
                case 4:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        long j9 = unsafe.getInt(obj, j6);
                        iZzz = zzlm.zzz(i11 << 3);
                        iZzA = zzlm.zzA(j9);
                        iB += iZzA + iZzz;
                    }
                    zznpVar = this;
                    break;
                case 5:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iB = a.b(i11 << 3, 8, iB);
                    }
                    zznpVar = this;
                    break;
                case 6:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iB = a.b(i11 << 3, 4, iB);
                    }
                    zznpVar = this;
                    break;
                case 7:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iB = a.b(i11 << 3, 1, iB);
                    }
                    zznpVar = this;
                    break;
                case 8:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        int i15 = i11 << 3;
                        Object object = unsafe.getObject(obj, j6);
                        if (object instanceof zzlh) {
                            iZzz2 = zzlm.zzz(i15);
                            iZzc = ((zzlh) object).zzc();
                            iZzz3 = zzlm.zzz(iZzc);
                            iB += iZzz3 + iZzc + iZzz2;
                        } else {
                            iZzz = zzlm.zzz(i15);
                            iZzA = zzlm.zzB((String) object);
                            iB += iZzA + iZzz;
                        }
                    }
                    zznpVar = this;
                    break;
                case 9:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iZzz4 = zznz.zzz(i11, unsafe.getObject(obj, j6), zznpVar.zzp(i7));
                        iB += iZzz4;
                    }
                    break;
                case 10:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        zzlh zzlhVar = (zzlh) unsafe.getObject(obj, j6);
                        iZzz2 = zzlm.zzz(i11 << 3);
                        iZzc = zzlhVar.zzc();
                        iZzz3 = zzlm.zzz(iZzc);
                        iB += iZzz3 + iZzc + iZzz2;
                    }
                    zznpVar = this;
                    break;
                case 11:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iB = a.b(unsafe.getInt(obj, j6), zzlm.zzz(i11 << 3), iB);
                    }
                    zznpVar = this;
                    break;
                case 12:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        long j10 = unsafe.getInt(obj, j6);
                        iZzz = zzlm.zzz(i11 << 3);
                        iZzA = zzlm.zzA(j10);
                        iB += iZzA + iZzz;
                    }
                    zznpVar = this;
                    break;
                case 13:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iB = a.b(i11 << 3, 4, iB);
                    }
                    zznpVar = this;
                    break;
                case 14:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iB = a.b(i11 << 3, 8, iB);
                    }
                    zznpVar = this;
                    break;
                case 15:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        int i16 = unsafe.getInt(obj, j6);
                        iB = a.b((i16 >> 31) ^ (i16 + i16), zzlm.zzz(i11 << 3), iB);
                    }
                    zznpVar = this;
                    break;
                case 16:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        long j11 = unsafe.getLong(obj, j6);
                        iZzz = zzlm.zzz(i11 << 3);
                        iZzA = zzlm.zzA((j11 >> 63) ^ (j11 + j11));
                        iB += iZzA + iZzz;
                    }
                    zznpVar = this;
                    break;
                case 17:
                    if (zznpVar.zzI(obj, i7, i9, i8, i5)) {
                        iZzG = zzlm.zzG(i11, (zznm) unsafe.getObject(obj, j6), zznpVar.zzp(i7));
                        iB += iZzG;
                    }
                    break;
                case 18:
                    iZzz4 = zznz.zzy(i11, (List) unsafe.getObject(obj, j6), false);
                    iB += iZzz4;
                    break;
                case 19:
                    iZzz4 = zznz.zzw(i11, (List) unsafe.getObject(obj, j6), false);
                    iB += iZzz4;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j6);
                    int i17 = zznz.zza;
                    if (list.size() == 0) {
                        iZzz5 = 0;
                    } else {
                        iZzz5 = (zzlm.zzz(i11 << 3) * list.size()) + zznz.zzo(list);
                    }
                    iB += iZzz5;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j6);
                    int i18 = zznz.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzz7 = 0;
                    } else {
                        iZzp = zznz.zzp(list2);
                        iZzz6 = zzlm.zzz(i11 << 3);
                        iZzz7 = (iZzz6 * size) + iZzp;
                    }
                    iB += iZzz7;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j6);
                    int i19 = zznz.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzz7 = 0;
                    } else {
                        iZzp = zznz.zzs(list3);
                        iZzz6 = zzlm.zzz(i11 << 3);
                        iZzz7 = (iZzz6 * size) + iZzp;
                    }
                    iB += iZzz7;
                    break;
                case 23:
                    iZzz4 = zznz.zzy(i11, (List) unsafe.getObject(obj, j6), false);
                    iB += iZzz4;
                    break;
                case 24:
                    iZzz4 = zznz.zzw(i11, (List) unsafe.getObject(obj, j6), false);
                    iB += iZzz4;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j6);
                    int i20 = zznz.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzz5 = 0;
                    } else {
                        iZzz5 = (zzlm.zzz(i11 << 3) + 1) * size2;
                    }
                    iB += iZzz5;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j6);
                    int i21 = zznz.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzz7 = 0;
                    } else {
                        iZzz7 = zzlm.zzz(i11 << 3) * size3;
                        if (list5 instanceof zzmx) {
                            zzmx zzmxVar = (zzmx) list5;
                            for (int i22 = 0; i22 < size3; i22++) {
                                Object objZzc = zzmxVar.zzc();
                                if (objZzc instanceof zzlh) {
                                    int iZzc3 = ((zzlh) objZzc).zzc();
                                    iZzz7 = a.b(iZzc3, iZzc3, iZzz7);
                                } else {
                                    iZzz7 = zzlm.zzB((String) objZzc) + iZzz7;
                                }
                            }
                        } else {
                            for (int i23 = 0; i23 < size3; i23++) {
                                Object obj2 = list5.get(i23);
                                if (obj2 instanceof zzlh) {
                                    int iZzc4 = ((zzlh) obj2).zzc();
                                    iZzz7 = a.b(iZzc4, iZzc4, iZzz7);
                                } else {
                                    iZzz7 = zzlm.zzB((String) obj2) + iZzz7;
                                }
                            }
                        }
                    }
                    iB += iZzz7;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j6);
                    zznx zznxVarZzp = zznpVar.zzp(i7);
                    int i24 = zznz.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzz8 = 0;
                    } else {
                        iZzz8 = zzlm.zzz(i11 << 3) * size4;
                        for (int i25 = 0; i25 < size4; i25++) {
                            Object obj3 = list6.get(i25);
                            if (obj3 instanceof zzmw) {
                                int iZzb = ((zzmw) obj3).zzb();
                                iZzz8 = a.b(iZzb, iZzb, iZzz8);
                            } else {
                                iZzz8 = zzlm.zzD((zznm) obj3, zznxVarZzp) + iZzz8;
                            }
                        }
                    }
                    iB += iZzz8;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j6);
                    int i26 = zznz.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzz7 = 0;
                    } else {
                        iZzz7 = zzlm.zzz(i11 << 3) * size5;
                        for (int i27 = 0; i27 < list7.size(); i27++) {
                            int iZzc5 = ((zzlh) list7.get(i27)).zzc();
                            iZzz7 = a.b(iZzc5, iZzc5, iZzz7);
                        }
                    }
                    iB += iZzz7;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j6);
                    int i28 = zznz.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzz7 = 0;
                    } else {
                        iZzp = zznz.zzt(list8);
                        iZzz6 = zzlm.zzz(i11 << 3);
                        iZzz7 = (iZzz6 * size) + iZzp;
                    }
                    iB += iZzz7;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j6);
                    int i29 = zznz.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzz7 = 0;
                    } else {
                        iZzp = zznz.zzr(list9);
                        iZzz6 = zzlm.zzz(i11 << 3);
                        iZzz7 = (iZzz6 * size) + iZzp;
                    }
                    iB += iZzz7;
                    break;
                case 31:
                    iZzz4 = zznz.zzw(i11, (List) unsafe.getObject(obj, j6), false);
                    iB += iZzz4;
                    break;
                case 32:
                    iZzz4 = zznz.zzy(i11, (List) unsafe.getObject(obj, j6), false);
                    iB += iZzz4;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j6);
                    int i30 = zznz.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzz7 = 0;
                    } else {
                        iZzp = zznz.zzu(list10);
                        iZzz6 = zzlm.zzz(i11 << 3);
                        iZzz7 = (iZzz6 * size) + iZzp;
                    }
                    iB += iZzz7;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j6);
                    int i31 = zznz.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzz7 = 0;
                    } else {
                        iZzp = zznz.zzq(list11);
                        iZzz6 = zzlm.zzz(i11 << 3);
                        iZzz7 = (iZzz6 * size) + iZzp;
                    }
                    iB += iZzz7;
                    break;
                case 35:
                    iZzx = zznz.zzx((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 36:
                    iZzx = zznz.zzv((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 37:
                    iZzx = zznz.zzo((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 38:
                    iZzx = zznz.zzp((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 39:
                    iZzx = zznz.zzs((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 40:
                    iZzx = zznz.zzx((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 41:
                    iZzx = zznz.zzv((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j6);
                    int i32 = zznz.zza;
                    iZzx = list12.size();
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 43:
                    iZzx = zznz.zzt((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 44:
                    iZzx = zznz.zzr((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 45:
                    iZzx = zznz.zzv((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 46:
                    iZzx = zznz.zzx((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 47:
                    iZzx = zznz.zzu((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 48:
                    iZzx = zznz.zzq((List) unsafe.getObject(obj, j6));
                    if (iZzx > 0) {
                        iZzz9 = zzlm.zzz(i11 << 3);
                        iZzz10 = zzlm.zzz(iZzx);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j6);
                    zznx zznxVarZzp2 = zznpVar.zzp(i7);
                    int i33 = zznz.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzG2 = 0;
                    } else {
                        iZzG2 = 0;
                        for (int i34 = 0; i34 < size6; i34++) {
                            iZzG2 += zzlm.zzG(i11, (zznm) list13.get(i34), zznxVarZzp2);
                        }
                    }
                    iB += iZzG2;
                    break;
                case 50:
                    zzng zzngVar = (zzng) unsafe.getObject(obj, j6);
                    zznf zznfVar = (zznf) zznpVar.zzq(i7);
                    if (zzngVar.isEmpty()) {
                        iZzz7 = 0;
                    } else {
                        iZzz7 = 0;
                        for (Map.Entry entry2 : zzngVar.entrySet()) {
                            iZzz7 += zznfVar.zzd(i11, entry2.getKey(), entry2.getValue());
                        }
                    }
                    iB += iZzz7;
                    break;
                case 51:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iB = a.b(i11 << 3, 8, iB);
                    }
                    break;
                case 52:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iB = a.b(i11 << 3, 4, iB);
                    }
                    break;
                case 53:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        long jZzF = zzF(obj, j6);
                        iZzz11 = zzlm.zzz(i11 << 3);
                        iZzA2 = zzlm.zzA(jZzF);
                        iB += iZzA2 + iZzz11;
                    }
                    break;
                case 54:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        long jZzF2 = zzF(obj, j6);
                        iZzz11 = zzlm.zzz(i11 << 3);
                        iZzA2 = zzlm.zzA(jZzF2);
                        iB += iZzA2 + iZzz11;
                    }
                    break;
                case 55:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        long jZzE = zzE(obj, j6);
                        iZzz11 = zzlm.zzz(i11 << 3);
                        iZzA2 = zzlm.zzA(jZzE);
                        iB += iZzA2 + iZzz11;
                    }
                    break;
                case 56:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iB = a.b(i11 << 3, 8, iB);
                    }
                    break;
                case 57:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iB = a.b(i11 << 3, 4, iB);
                    }
                    break;
                case 58:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iB = a.b(i11 << 3, 1, iB);
                    }
                    break;
                case 59:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        int i35 = i11 << 3;
                        Object object2 = unsafe.getObject(obj, j6);
                        if (object2 instanceof zzlh) {
                            iZzx = zzlm.zzz(i35);
                            iZzz9 = ((zzlh) object2).zzc();
                            iZzz10 = zzlm.zzz(iZzz9);
                            iB += iZzz10 + iZzz9 + iZzx;
                        } else {
                            iZzz11 = zzlm.zzz(i35);
                            iZzA2 = zzlm.zzB((String) object2);
                            iB += iZzA2 + iZzz11;
                        }
                    }
                    break;
                case 60:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iZzz4 = zznz.zzz(i11, unsafe.getObject(obj, j6), zznpVar.zzp(i7));
                        iB += iZzz4;
                    }
                    break;
                case 61:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        zzlh zzlhVar2 = (zzlh) unsafe.getObject(obj, j6);
                        iZzx = zzlm.zzz(i11 << 3);
                        iZzz9 = zzlhVar2.zzc();
                        iZzz10 = zzlm.zzz(iZzz9);
                        iB += iZzz10 + iZzz9 + iZzx;
                    }
                    break;
                case 62:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iB = a.b(zzE(obj, j6), zzlm.zzz(i11 << 3), iB);
                    }
                    break;
                case 63:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        long jZzE2 = zzE(obj, j6);
                        iZzz11 = zzlm.zzz(i11 << 3);
                        iZzA2 = zzlm.zzA(jZzE2);
                        iB += iZzA2 + iZzz11;
                    }
                    break;
                case 64:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iB = a.b(i11 << 3, 4, iB);
                    }
                    break;
                case 65:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iB = a.b(i11 << 3, 8, iB);
                    }
                    break;
                case 66:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        int iZzE = zzE(obj, j6);
                        iB = a.b((iZzE >> 31) ^ (iZzE + iZzE), zzlm.zzz(i11 << 3), iB);
                    }
                    break;
                case 67:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        long jZzF3 = zzF(obj, j6);
                        iZzz11 = zzlm.zzz(i11 << 3);
                        iZzA2 = zzlm.zzA((jZzF3 >> 63) ^ (jZzF3 + jZzF3));
                        iB += iZzA2 + iZzz11;
                    }
                    break;
                case 68:
                    if (zznpVar.zzL(obj, i11, i7)) {
                        iZzG = zzlm.zzG(i11, (zznm) unsafe.getObject(obj, j6), zznpVar.zzp(i7));
                        iB += iZzG;
                    }
                    break;
            }
            i7 += 3;
            i6 = 1048575;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.measurement.zznx
    public final void zzf(Object obj, zzov zzovVar) {
        Map.Entry entry;
        int i5;
        zznp<T> zznpVar = this;
        if (zznpVar.zzh) {
            zzlw zzlwVar = ((zzmc) obj).zzb;
            if (zzlwVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzlwVar.zzc().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = zznpVar.zzc;
        Unsafe unsafe = zzb;
        int i6 = 1048575;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i8 < iArr.length) {
            int iZzx = zznpVar.zzx(i8);
            int iZzz = zzz(iZzx);
            int i10 = iArr[i8];
            if (iZzz <= 17) {
                int i11 = iArr[i8 + 2];
                int i12 = i11 & i6;
                if (i12 != i7) {
                    i9 = i12 == i6 ? 0 : unsafe.getInt(obj, i12);
                    i7 = i12;
                }
                i5 = 1 << (i11 >>> 20);
            } else {
                i5 = 0;
            }
            if (entry != null) {
                throw null;
            }
            long j6 = iZzx & i6;
            switch (iZzz) {
                case 0:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzf(i10, zzop.zzl(obj, j6));
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 1:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zze(i10, zzop.zzj(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 2:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzc(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 3:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzh(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 4:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzi(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 5:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzj(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 6:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzk(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 7:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzl(i10, zzop.zzh(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 8:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzP(i10, unsafe.getObject(obj, j6), zzovVar);
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 9:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzr(i10, unsafe.getObject(obj, j6), zznpVar.zzp(i8));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 10:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzn(i10, (zzlh) unsafe.getObject(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 11:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzo(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 12:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzg(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 13:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzb(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 14:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzd(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 15:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzp(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 16:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzq(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 17:
                    if (zznpVar.zzI(obj, i8, i7, i9, i5)) {
                        zzovVar.zzs(i10, unsafe.getObject(obj, j6), zznpVar.zzp(i8));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 18:
                    zznz.zza(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 19:
                    zznz.zzb(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 20:
                    zznz.zzc(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 21:
                    zznz.zzd(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 22:
                    zznz.zzh(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 23:
                    zznz.zzf(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 24:
                    zznz.zzk(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 25:
                    zznz.zzn(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 26:
                    int i13 = iArr[i8];
                    List list = (List) unsafe.getObject(obj, j6);
                    int i14 = zznz.zza;
                    if (list != null && !list.isEmpty()) {
                        zzovVar.zzF(i13, list);
                    }
                    break;
                case 27:
                    int i15 = iArr[i8];
                    List list2 = (List) unsafe.getObject(obj, j6);
                    zznx zznxVarZzp = zznpVar.zzp(i8);
                    int i16 = zznz.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i17 = 0; i17 < list2.size(); i17++) {
                            ((zzln) zzovVar).zzr(i15, list2.get(i17), zznxVarZzp);
                        }
                    }
                    break;
                case 28:
                    int i18 = iArr[i8];
                    List list3 = (List) unsafe.getObject(obj, j6);
                    int i19 = zznz.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzovVar.zzG(i18, list3);
                    }
                    break;
                case 29:
                    zznz.zzi(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 30:
                    zznz.zzm(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 31:
                    zznz.zzl(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 32:
                    zznz.zzg(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 33:
                    zznz.zzj(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 34:
                    zznz.zze(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zznpVar = this;
                    break;
                case 35:
                    zznz.zza(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 36:
                    zznz.zzb(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 37:
                    zznz.zzc(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 38:
                    zznz.zzd(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 39:
                    zznz.zzh(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 40:
                    zznz.zzf(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 41:
                    zznz.zzk(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 42:
                    zznz.zzn(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 43:
                    zznz.zzi(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 44:
                    zznz.zzm(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 45:
                    zznz.zzl(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 46:
                    zznz.zzg(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 47:
                    zznz.zzj(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 48:
                    zznz.zze(iArr[i8], (List) unsafe.getObject(obj, j6), zzovVar, true);
                    break;
                case 49:
                    int i20 = iArr[i8];
                    List list4 = (List) unsafe.getObject(obj, j6);
                    zznx zznxVarZzp2 = zznpVar.zzp(i8);
                    int i21 = zznz.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i22 = 0; i22 < list4.size(); i22++) {
                            ((zzln) zzovVar).zzs(i20, list4.get(i22), zznxVarZzp2);
                        }
                    }
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j6);
                    if (object != null) {
                        zzovVar.zzM(i10, ((zznf) zznpVar.zzq(i8)).zze(), (zzng) object);
                    }
                    break;
                case 51:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzf(i10, zzC(obj, j6));
                    }
                    break;
                case 52:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zze(i10, zzD(obj, j6));
                    }
                    break;
                case 53:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzc(i10, zzF(obj, j6));
                    }
                    break;
                case 54:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzh(i10, zzF(obj, j6));
                    }
                    break;
                case 55:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzi(i10, zzE(obj, j6));
                    }
                    break;
                case 56:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzj(i10, zzF(obj, j6));
                    }
                    break;
                case 57:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzk(i10, zzE(obj, j6));
                    }
                    break;
                case 58:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzl(i10, zzG(obj, j6));
                    }
                    break;
                case 59:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzP(i10, unsafe.getObject(obj, j6), zzovVar);
                    }
                    break;
                case 60:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzr(i10, unsafe.getObject(obj, j6), zznpVar.zzp(i8));
                    }
                    break;
                case 61:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzn(i10, (zzlh) unsafe.getObject(obj, j6));
                    }
                    break;
                case 62:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzo(i10, zzE(obj, j6));
                    }
                    break;
                case 63:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzg(i10, zzE(obj, j6));
                    }
                    break;
                case 64:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzb(i10, zzE(obj, j6));
                    }
                    break;
                case 65:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzd(i10, zzF(obj, j6));
                    }
                    break;
                case 66:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzp(i10, zzE(obj, j6));
                    }
                    break;
                case 67:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzq(i10, zzF(obj, j6));
                    }
                    break;
                case 68:
                    if (zznpVar.zzL(obj, i10, i8)) {
                        zzovVar.zzs(i10, unsafe.getObject(obj, j6), zznpVar.zzp(i8));
                    }
                    break;
            }
            i8 += 3;
            i6 = 1048575;
            zznpVar = this;
        }
        if (entry != null) {
            throw null;
        }
        ((zzmf) obj).zzc.zzg(zzovVar);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 41641. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int zzh(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.measurement.zzkw r40) {
        /*
            Method dump skipped, instruction units count: 4164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zznp.zzh(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzkw):int");
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final void zzi(Object obj, byte[] bArr, int i5, int i6, zzkw zzkwVar) {
        zzh(obj, bArr, i5, i6, 0, zzkwVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zznx
    public final void zzj(Object obj) {
        if (zzA(obj)) {
            if (obj instanceof zzmf) {
                zzmf zzmfVar = (zzmf) obj;
                zzmfVar.zzcm(Integer.MAX_VALUE);
                zzmfVar.zza = 0;
                zzmfVar.zzcg();
            }
            int[] iArr = this.zzc;
            for (int i5 = 0; i5 < iArr.length; i5 += 3) {
                int iZzx = zzx(i5);
                int i6 = 1048575 & iZzx;
                int iZzz = zzz(iZzx);
                long j6 = i6;
                if (iZzz != 9) {
                    if (iZzz != 60 && iZzz != 68) {
                        switch (iZzz) {
                            case 17:
                                if (zzJ(obj, i5)) {
                                    zzp(i5).zzj(zzb.getObject(obj, j6));
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
                                ((zzmo) zzop.zzn(obj, j6)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j6);
                                if (object != null) {
                                    ((zzng) object).zzd();
                                    unsafe.putObject(obj, j6, object);
                                }
                                break;
                        }
                    } else if (zzL(obj, iArr[i5], i5)) {
                        zzp(i5).zzj(zzb.getObject(obj, j6));
                    }
                } else if (zzJ(obj, i5)) {
                    zzp(i5).zzj(zzb.getObject(obj, j6));
                }
            }
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e6 A[LOOP:2: B:53:0x00d5->B:58:0x00e6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00fc A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zznx
    public final boolean zzk(Object obj) {
        int i5;
        int i6;
        List list;
        zznx zznxVarZzp;
        int i7;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i9 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i11 = iArr[i9];
            int i12 = iArr2[i11];
            int iZzx = zzx(i11);
            int i13 = iArr2[i11 + 2];
            int i14 = i13 & 1048575;
            int i15 = 1 << (i13 >>> 20);
            if (i14 != i10) {
                if (i14 != 1048575) {
                    i8 = zzb.getInt(obj, i14);
                }
                i6 = i8;
                i5 = i14;
            } else {
                int i16 = i8;
                i5 = i10;
                i6 = i16;
            }
            if ((268435456 & iZzx) != 0 && !zzI(obj, i11, i5, i6, i15)) {
                return false;
            }
            int iZzz = zzz(iZzx);
            if (iZzz == 9 || iZzz == 17) {
                if (zzI(obj, i11, i5, i6, i15) && !zzw(obj, iZzx, zzp(i11))) {
                    return false;
                }
            } else if (iZzz == 27) {
                list = (List) zzop.zzn(obj, iZzx & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zznxVarZzp = zzp(i11);
                    for (i7 = 0; i7 < list.size(); i7++) {
                        if (!zznxVarZzp.zzk(list.get(i7))) {
                            return false;
                        }
                    }
                }
            } else if (iZzz == 60 || iZzz == 68) {
                if (zzL(obj, i12, i11) && !zzw(obj, iZzx, zzp(i11))) {
                    return false;
                }
            } else if (iZzz == 49) {
                list = (List) zzop.zzn(obj, iZzx & 1048575);
                if (list.isEmpty()) {
                    zznxVarZzp = zzp(i11);
                    while (i7 < list.size()) {
                        if (!zznxVarZzp.zzk(list.get(i7))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzz != 50) {
                continue;
            } else {
                zzng zzngVar = (zzng) zzop.zzn(obj, iZzx & 1048575);
                if (!zzngVar.isEmpty() && ((zznf) zzq(i11)).zze().zzc.zza() == zzou.MESSAGE) {
                    zznx zznxVarZzb = null;
                    for (Object obj2 : zzngVar.values()) {
                        if (zznxVarZzb == null) {
                            zznxVarZzb = zznu.zza().zzb(obj2.getClass());
                        }
                        if (!zznxVarZzb.zzk(obj2)) {
                            return false;
                        }
                    }
                }
            }
            i9++;
            i10 = i5;
            i8 = i6;
        }
        return !this.zzh || ((zzmc) obj).zzb.zze();
    }
}
