package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfp<T> implements zzge<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfm zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzgs zzl;
    private final zzdt zzm;

    private zzfp(int[] iArr, Object[] objArr, int i5, int i6, zzfm zzfmVar, boolean z6, int[] iArr2, int i7, int i8, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i5;
        this.zzf = i6;
        boolean z7 = false;
        if (zzdtVar != null && (zzfmVar instanceof zzed)) {
            z7 = true;
        }
        this.zzh = z7;
        this.zzi = iArr2;
        this.zzj = i7;
        this.zzk = i8;
        this.zzl = zzgsVar;
        this.zzm = zzdtVar;
        this.zzg = zzfmVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i5) {
        if (zzI(obj2, i5)) {
            int iZzs = zzs(i5) & 1048575;
            Unsafe unsafe = zzb;
            long j6 = iZzs;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i5);
            if (!zzI(obj, i5)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j6, objZze);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zzD(obj, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j6, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i5) {
        int i6 = this.zzc[i5];
        if (zzM(obj2, i6, i5)) {
            int iZzs = zzs(i5) & 1048575;
            Unsafe unsafe = zzb;
            long j6 = iZzs;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i5);
            if (!zzM(obj, i6, i5)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j6, objZze);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zzE(obj, i6, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j6, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i5) {
        int iZzp = zzp(i5);
        long j6 = 1048575 & iZzp;
        if (j6 == 1048575) {
            return;
        }
        zzgz.zzq(obj, j6, (1 << (iZzp >>> 20)) | zzgz.zzc(obj, j6));
    }

    private final void zzE(Object obj, int i5, int i6) {
        zzgz.zzq(obj, zzp(i6) & 1048575, i5);
    }

    private final void zzF(Object obj, int i5, Object obj2) {
        zzb.putObject(obj, zzs(i5) & 1048575, obj2);
        zzD(obj, i5);
    }

    private final void zzG(Object obj, int i5, int i6, Object obj2) {
        zzb.putObject(obj, zzs(i6) & 1048575, obj2);
        zzE(obj, i5, i6);
    }

    private final boolean zzH(Object obj, Object obj2, int i5) {
        return zzI(obj, i5) == zzI(obj2, i5);
    }

    private final boolean zzI(Object obj, int i5) {
        int iZzp = zzp(i5);
        long j6 = iZzp & 1048575;
        if (j6 != 1048575) {
            return (zzgz.zzc(obj, j6) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i5);
        long j7 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzgz.zza(obj, j7)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzgz.zzb(obj, j7)) != 0;
            case 2:
                return zzgz.zzd(obj, j7) != 0;
            case 3:
                return zzgz.zzd(obj, j7) != 0;
            case 4:
                return zzgz.zzc(obj, j7) != 0;
            case 5:
                return zzgz.zzd(obj, j7) != 0;
            case 6:
                return zzgz.zzc(obj, j7) != 0;
            case 7:
                return zzgz.zzw(obj, j7);
            case 8:
                Object objZzf = zzgz.zzf(obj, j7);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzdf) {
                    return !zzdf.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(obj, j7) != null;
            case 10:
                return !zzdf.zzb.equals(zzgz.zzf(obj, j7));
            case 11:
                return zzgz.zzc(obj, j7) != 0;
            case 12:
                return zzgz.zzc(obj, j7) != 0;
            case 13:
                return zzgz.zzc(obj, j7) != 0;
            case 14:
                return zzgz.zzd(obj, j7) != 0;
            case 15:
                return zzgz.zzc(obj, j7) != 0;
            case 16:
                return zzgz.zzd(obj, j7) != 0;
            case 17:
                return zzgz.zzf(obj, j7) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return zzI(obj, i5);
        }
        return (i7 & i8) != 0;
    }

    private static boolean zzK(Object obj, int i5, zzge zzgeVar) {
        return zzgeVar.zzk(zzgz.zzf(obj, i5 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzY();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i5, int i6) {
        return zzgz.zzc(obj, (long) (zzp(i6) & 1048575)) == i5;
    }

    private static boolean zzN(Object obj, long j6) {
        return ((Boolean) zzgz.zzf(obj, j6)).booleanValue();
    }

    private static final void zzO(int i5, Object obj, zzhh zzhhVar) {
        if (obj instanceof String) {
            zzhhVar.zzG(i5, (String) obj);
        } else {
            zzhhVar.zzd(i5, (zzdf) obj);
        }
    }

    public static zzgt zzd(Object obj) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        if (zzgtVar != zzgt.zzc()) {
            return zzgtVar;
        }
        zzgt zzgtVarZzf = zzgt.zzf();
        zzehVar.zzc = zzgtVarZzf;
        return zzgtVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:187:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:193:0x03e2  */
    public static zzfp zzl(Class cls, zzfj zzfjVar, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
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
        zzfw zzfwVar;
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
        Field fieldZzz;
        char cCharAt9;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        Field fieldZzz2;
        Field fieldZzz3;
        int i34;
        char cCharAt10;
        int i35;
        int i36;
        char cCharAt11;
        int i37;
        char cCharAt12;
        int i38;
        char cCharAt13;
        if (!(zzfjVar instanceof zzfw)) {
            throw null;
        }
        zzfw zzfwVar2 = (zzfw) zzfjVar;
        String strZzd = zzfwVar2.zzd();
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
        Object[] objArrZze = zzfwVar2.zze();
        Class<?> cls2 = zzfwVar2.zza().getClass();
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
                    zzfwVar = zzfwVar2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i80 |= (cCharAt11 & 8191) << i82;
                    i82 += 13;
                    i81 = i36;
                    zzfwVar2 = zzfwVar;
                }
                iCharAt11 = i80 | (cCharAt11 << i82);
                i21 = i36;
            } else {
                zzfwVar = zzfwVar2;
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
                } else if (zzfwVar.zzc() == 1 || i85 != 0) {
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
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i93] = fieldZzz2;
                }
                Object[] objArr3 = objArr2;
                int i95 = i10;
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz2);
                int i96 = i93 + 1;
                Object obj2 = objArrZze[i96];
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i96] = fieldZzz3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzz3);
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
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i10]);
                i22 = iCharAt10;
                if (i83 == 9 || i83 == 17) {
                    i11 = i11;
                    objArr[a.r(i73, 3, 1)] = fieldZzz4.getType();
                } else {
                    if (i83 != 27) {
                        if (i83 == 49) {
                            i31 = i10 + 2;
                            i29 = 3;
                            i30 = 1;
                        } else if (i83 == 12 || i83 == 30 || i83 == 44) {
                            i11 = i11;
                            if (zzfwVar.zzc() == 1 || i85 != 0) {
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
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
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
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i104] = fieldZzz;
                            }
                            i24 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz);
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
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
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
            zzfwVar2 = zzfwVar;
            i11 = i11;
            objArr2 = objArr;
        }
        return new zzfp(iArr3, objArr2, i6, i8, zzfwVar2.zza(), false, iArr, i9, i69, zzfsVar, zzezVar, zzgsVar, zzdtVar, zzfhVar);
    }

    private static double zzm(Object obj, long j6) {
        return ((Double) zzgz.zzf(obj, j6)).doubleValue();
    }

    private static float zzn(Object obj, long j6) {
        return ((Float) zzgz.zzf(obj, j6)).floatValue();
    }

    private static int zzo(Object obj, long j6) {
        return ((Integer) zzgz.zzf(obj, j6)).intValue();
    }

    private final int zzp(int i5) {
        return this.zzc[i5 + 2];
    }

    private final int zzq(int i5, int i6) {
        int length = (this.zzc.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int i9 = this.zzc[i8];
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

    private static int zzr(int i5) {
        return (i5 >>> 20) & 255;
    }

    private final int zzs(int i5) {
        return this.zzc[i5 + 1];
    }

    private static long zzt(Object obj, long j6) {
        return ((Long) zzgz.zzf(obj, j6)).longValue();
    }

    private final zzel zzu(int i5) {
        int i6 = i5 / 3;
        return (zzel) this.zzd[i6 + i6 + 1];
    }

    private final zzge zzv(int i5) {
        Object[] objArr = this.zzd;
        int i6 = i5 / 3;
        int i7 = i6 + i6;
        zzge zzgeVar = (zzge) objArr[i7];
        if (zzgeVar != null) {
            return zzgeVar;
        }
        zzge zzgeVarZzb = zzfu.zza().zzb((Class) objArr[i7 + 1]);
        this.zzd[i7] = zzgeVarZzb;
        return zzgeVarZzb;
    }

    private final Object zzw(int i5) {
        int i6 = i5 / 3;
        return this.zzd[i6 + i6];
    }

    private final Object zzx(Object obj, int i5) {
        zzge zzgeVarZzv = zzv(i5);
        int iZzs = zzs(i5) & 1048575;
        if (!zzI(obj, i5)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i5, int i6) {
        zzge zzgeVarZzv = zzv(i6);
        if (!zzM(obj, i5, i6)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i6) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
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
    /* JADX WARN: Code duplicated, block: B:152:0x03df  */
    /* JADX WARN: Code duplicated, block: B:206:0x0522  */
    /* JADX WARN: Code duplicated, block: B:90:0x0211  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        int i5;
        int iZzA;
        int iZzB;
        int iZzA2;
        int iZzd;
        int iZzA3;
        int iZzh;
        int iZzA4;
        int size;
        int iZzl;
        int iZzA5;
        int iZzd2;
        boolean z6;
        int iZzb;
        int iZzz;
        int iZzA6;
        int iZzA7;
        int size2;
        int iZzk;
        int iZzA8;
        int size3;
        int iZzi;
        int iZzA9;
        int i6;
        int iZze;
        int iZzA10;
        int iZzA11;
        int iZzA12;
        int iZzB2;
        zzfp<T> zzfpVar = this;
        Unsafe unsafe = zzb;
        int i7 = 1048575;
        int i8 = 1048575;
        int i9 = 0;
        int i10 = 0;
        int iW = 0;
        while (i9 < zzfpVar.zzc.length) {
            int iZzs = zzfpVar.zzs(i9);
            int iZzr = zzr(iZzs);
            int[] iArr = zzfpVar.zzc;
            int i11 = iArr[i9];
            int i12 = iArr[i9 + 2];
            int i13 = i12 & i7;
            if (iZzr <= 17) {
                if (i13 != i8) {
                    i10 = i13 == i7 ? 0 : unsafe.getInt(obj, i13);
                    i8 = i13;
                }
                i5 = 1 << (i12 >>> 20);
            } else {
                i5 = 0;
            }
            int i14 = iZzs & i7;
            if (iZzr >= zzdy.zzJ.zza()) {
                zzdy.zzW.zza();
            }
            long j6 = i14;
            switch (iZzr) {
                case 0:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW = a.w(i11 << 3, 8, iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 1:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW = a.w(i11 << 3, 4, iW);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 2:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        long j7 = unsafe.getLong(obj, j6);
                        iZzA = zzdn.zzA(i11 << 3);
                        iZzB = zzdn.zzB(j7);
                        iW += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 3:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        long j8 = unsafe.getLong(obj, j6);
                        iZzA = zzdn.zzA(i11 << 3);
                        iZzB = zzdn.zzB(j8);
                        iW += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 4:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        long j9 = unsafe.getInt(obj, j6);
                        iZzA = zzdn.zzA(i11 << 3);
                        iZzB = zzdn.zzB(j9);
                        iW += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 5:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW = a.w(i11 << 3, 8, iW);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 6:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW = a.w(i11 << 3, 4, iW);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 7:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW = a.w(i11 << 3, 1, iW);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 8:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        int i15 = i11 << 3;
                        Object object = unsafe.getObject(obj, j6);
                        if (object instanceof zzdf) {
                            iZzA2 = zzdn.zzA(i15);
                            iZzd = ((zzdf) object).zzd();
                            iZzA3 = zzdn.zzA(iZzd);
                            iW += iZzA3 + iZzd + iZzA2;
                        } else {
                            iZzA = zzdn.zzA(i15);
                            iZzB = zzdn.zzz((String) object);
                            iW += iZzB + iZzA;
                        }
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 9:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iZzh = zzgg.zzh(i11, unsafe.getObject(obj, j6), zzfpVar.zzv(i9));
                        iW += iZzh;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 10:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        zzdf zzdfVar = (zzdf) unsafe.getObject(obj, j6);
                        iZzA2 = zzdn.zzA(i11 << 3);
                        iZzd = zzdfVar.zzd();
                        iZzA3 = zzdn.zzA(iZzd);
                        iW += iZzA3 + iZzd + iZzA2;
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 11:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW = a.w(unsafe.getInt(obj, j6), zzdn.zzA(i11 << 3), iW);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 12:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        long j10 = unsafe.getInt(obj, j6);
                        iZzA = zzdn.zzA(i11 << 3);
                        iZzB = zzdn.zzB(j10);
                        iW += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 13:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW = a.w(i11 << 3, 4, iW);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 14:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW = a.w(i11 << 3, 8, iW);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 15:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        int i16 = unsafe.getInt(obj, j6);
                        iW = a.w((i16 >> 31) ^ (i16 + i16), zzdn.zzA(i11 << 3), iW);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 16:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        long j11 = unsafe.getLong(obj, j6);
                        iZzA = zzdn.zzA(i11 << 3);
                        iZzB = zzdn.zzB((j11 >> 63) ^ (j11 + j11));
                        iW += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 17:
                    if (zzfpVar.zzJ(obj, i9, i8, i10, i5)) {
                        iW += zzdn.zzw(i11, (zzfm) unsafe.getObject(obj, j6), zzfpVar.zzv(i9));
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 18:
                    iZzh = zzgg.zzd(i11, (List) unsafe.getObject(obj, j6), false);
                    iW += iZzh;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 19:
                    iZzh = zzgg.zzb(i11, (List) unsafe.getObject(obj, j6), false);
                    iW += iZzh;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j6);
                    int i17 = zzgg.zza;
                    if (list.size() == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzA4 = (zzdn.zzA(i11 << 3) * list.size()) + zzgg.zzg(list);
                    }
                    iW += iZzA4;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j6);
                    int i18 = zzgg.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzl = zzgg.zzl(list2);
                        iZzA5 = zzdn.zzA(i11 << 3);
                        iZzA4 = (iZzA5 * size) + iZzl;
                    }
                    iW += iZzA4;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j6);
                    int i19 = zzgg.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzl = zzgg.zzf(list3);
                        iZzA5 = zzdn.zzA(i11 << 3);
                        iZzA4 = (iZzA5 * size) + iZzl;
                    }
                    iW += iZzA4;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 23:
                    iZzd2 = zzgg.zzd(i11, (List) unsafe.getObject(obj, j6), false);
                    iW += iZzd2;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 24:
                    z6 = false;
                    iZzb = zzgg.zzb(i11, (List) unsafe.getObject(obj, j6), false);
                    iW += iZzb;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j6);
                    int i20 = zzgg.zza;
                    int size4 = list4.size();
                    if (size4 == 0) {
                        iZzd2 = 0;
                    } else {
                        iZzd2 = size4 * (zzdn.zzA(i11 << 3) + 1);
                    }
                    iW += iZzd2;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j6);
                    int i21 = zzgg.zza;
                    int size5 = list5.size();
                    if (size5 == 0) {
                        iZzz = 0;
                    } else {
                        int iZzA13 = zzdn.zzA(i11 << 3) * size5;
                        if (list5 instanceof zzey) {
                            zzey zzeyVar = (zzey) list5;
                            iZzz = iZzA13;
                            for (int i22 = 0; i22 < size5; i22++) {
                                Object objZza = zzeyVar.zza();
                                if (objZza instanceof zzdf) {
                                    int iZzd3 = ((zzdf) objZza).zzd();
                                    iZzz = a.w(iZzd3, iZzd3, iZzz);
                                } else {
                                    iZzz = zzdn.zzz((String) objZza) + iZzz;
                                }
                            }
                        } else {
                            iZzz = iZzA13;
                            for (int i23 = 0; i23 < size5; i23++) {
                                Object obj2 = list5.get(i23);
                                if (obj2 instanceof zzdf) {
                                    int iZzd4 = ((zzdf) obj2).zzd();
                                    iZzz = a.w(iZzd4, iZzd4, iZzz);
                                } else {
                                    iZzz = zzdn.zzz((String) obj2) + iZzz;
                                }
                            }
                        }
                    }
                    iW += iZzz;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j6);
                    zzge zzgeVarZzv = zzfpVar.zzv(i9);
                    int i24 = zzgg.zza;
                    int size6 = list6.size();
                    if (size6 == 0) {
                        iZzA6 = 0;
                    } else {
                        iZzA6 = zzdn.zzA(i11 << 3) * size6;
                        for (int i25 = 0; i25 < size6; i25++) {
                            Object obj3 = list6.get(i25);
                            if (obj3 instanceof zzex) {
                                int iZza = ((zzex) obj3).zza();
                                iZzA6 = a.w(iZza, iZza, iZzA6);
                            } else {
                                iZzA6 = zzdn.zzy((zzfm) obj3, zzgeVarZzv) + iZzA6;
                            }
                        }
                    }
                    iW += iZzA6;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j6);
                    int i26 = zzgg.zza;
                    int size7 = list7.size();
                    if (size7 == 0) {
                        iZzA7 = 0;
                    } else {
                        iZzA7 = zzdn.zzA(i11 << 3) * size7;
                        for (int i27 = 0; i27 < list7.size(); i27++) {
                            int iZzd5 = ((zzdf) list7.get(i27)).zzd();
                            iZzA7 = a.w(iZzd5, iZzd5, iZzA7);
                        }
                    }
                    iW += iZzA7;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j6);
                    int i28 = zzgg.zza;
                    size2 = list8.size();
                    if (size2 == 0) {
                        iZzd2 = 0;
                    } else {
                        iZzk = zzgg.zzk(list8);
                        iZzA8 = zzdn.zzA(i11 << 3);
                        iZzd2 = iZzk + (iZzA8 * size2);
                    }
                    iW += iZzd2;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j6);
                    int i29 = zzgg.zza;
                    size2 = list9.size();
                    if (size2 == 0) {
                        iZzd2 = 0;
                    } else {
                        iZzk = zzgg.zza(list9);
                        iZzA8 = zzdn.zzA(i11 << 3);
                        iZzd2 = iZzk + (iZzA8 * size2);
                    }
                    iW += iZzd2;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 31:
                    iZzd2 = zzgg.zzb(i11, (List) unsafe.getObject(obj, j6), false);
                    iW += iZzd2;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 32:
                    z6 = false;
                    iZzb = zzgg.zzd(i11, (List) unsafe.getObject(obj, j6), false);
                    iW += iZzb;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j6);
                    int i30 = zzgg.zza;
                    size3 = list10.size();
                    if (size3 == 0) {
                        i6 = 0;
                    } else {
                        iZzi = zzgg.zzi(list10);
                        iZzA9 = zzdn.zzA(i11 << 3);
                        i6 = (iZzA9 * size3) + iZzi;
                    }
                    iW += i6;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j6);
                    int i31 = zzgg.zza;
                    size3 = list11.size();
                    if (size3 == 0) {
                        i6 = 0;
                    } else {
                        iZzi = zzgg.zzj(list11);
                        iZzA9 = zzdn.zzA(i11 << 3);
                        i6 = (iZzA9 * size3) + iZzi;
                    }
                    iW += i6;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 35:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 36:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 37:
                    iZze = zzgg.zzg((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 38:
                    iZze = zzgg.zzl((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 39:
                    iZze = zzgg.zzf((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 40:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 41:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j6);
                    int i32 = zzgg.zza;
                    iZze = list12.size();
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 43:
                    iZze = zzgg.zzk((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 44:
                    iZze = zzgg.zza((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 45:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 46:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 47:
                    iZze = zzgg.zzi((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 48:
                    iZze = zzgg.zzj((List) unsafe.getObject(obj, j6));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i11 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j6);
                    zzge zzgeVarZzv2 = zzfpVar.zzv(i9);
                    int i33 = zzgg.zza;
                    int size8 = list13.size();
                    if (size8 == 0) {
                        i6 = 0;
                    } else {
                        int iZzw = 0;
                        for (int i34 = 0; i34 < size8; i34++) {
                            iZzw += zzdn.zzw(i11, (zzfm) list13.get(i34), zzgeVarZzv2);
                        }
                        i6 = iZzw;
                    }
                    iW += i6;
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 50:
                    zzfg zzfgVar = (zzfg) unsafe.getObject(obj, j6);
                    if (!zzfgVar.isEmpty()) {
                        Iterator it = zzfgVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 51:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW = a.w(i11 << 3, 8, iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 52:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW = a.w(i11 << 3, 4, iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 53:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        long jZzt = zzt(obj, j6);
                        iZzA12 = zzdn.zzA(i11 << 3);
                        iZzB2 = zzdn.zzB(jZzt);
                        iW += iZzB2 + iZzA12;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 54:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        long jZzt2 = zzt(obj, j6);
                        iZzA12 = zzdn.zzA(i11 << 3);
                        iZzB2 = zzdn.zzB(jZzt2);
                        iW += iZzB2 + iZzA12;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 55:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        long jZzo = zzo(obj, j6);
                        iZzA12 = zzdn.zzA(i11 << 3);
                        iZzB2 = zzdn.zzB(jZzo);
                        iW += iZzB2 + iZzA12;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 56:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW = a.w(i11 << 3, 8, iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 57:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW = a.w(i11 << 3, 4, iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 58:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW = a.w(i11 << 3, 1, iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 59:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        int i35 = i11 << 3;
                        Object object2 = unsafe.getObject(obj, j6);
                        if (object2 instanceof zzdf) {
                            iZze = zzdn.zzA(i35);
                            iZzA10 = ((zzdf) object2).zzd();
                            iZzA11 = zzdn.zzA(iZzA10);
                            iW += iZzA11 + iZzA10 + iZze;
                        } else {
                            iZzA12 = zzdn.zzA(i35);
                            iZzB2 = zzdn.zzz((String) object2);
                            iW += iZzB2 + iZzA12;
                        }
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 60:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iZzd2 = zzgg.zzh(i11, unsafe.getObject(obj, j6), zzfpVar.zzv(i9));
                        iW += iZzd2;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 61:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        zzdf zzdfVar2 = (zzdf) unsafe.getObject(obj, j6);
                        iZze = zzdn.zzA(i11 << 3);
                        iZzA10 = zzdfVar2.zzd();
                        iZzA11 = zzdn.zzA(iZzA10);
                        iW += iZzA11 + iZzA10 + iZze;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 62:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW = a.w(zzo(obj, j6), zzdn.zzA(i11 << 3), iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 63:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        long jZzo2 = zzo(obj, j6);
                        iZzA12 = zzdn.zzA(i11 << 3);
                        iZzB2 = zzdn.zzB(jZzo2);
                        iW += iZzB2 + iZzA12;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 64:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW = a.w(i11 << 3, 4, iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 65:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW = a.w(i11 << 3, 8, iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 66:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        int iZzo = zzo(obj, j6);
                        iW = a.w((iZzo >> 31) ^ (iZzo + iZzo), zzdn.zzA(i11 << 3), iW);
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 67:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        long jZzt3 = zzt(obj, j6);
                        iZzA12 = zzdn.zzA(i11 << 3);
                        iZzB2 = zzdn.zzB((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        iW += iZzB2 + iZzA12;
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                case 68:
                    if (zzfpVar.zzM(obj, i11, i9)) {
                        iW += zzdn.zzw(i11, (zzfm) unsafe.getObject(obj, j6), zzfpVar.zzv(i9));
                    }
                    i9 += 3;
                    i7 = 1048575;
                    break;
                default:
                    i9 += 3;
                    i7 = 1048575;
                    break;
            }
        }
        int iZza2 = 0;
        int iZza3 = ((zzeh) obj).zzc.zza() + iW;
        if (!zzfpVar.zzh) {
            return iZza3;
        }
        zzdx zzdxVar = ((zzed) obj).zzb;
        int iZzc = zzdxVar.zza.zzc();
        for (int i36 = 0; i36 < iZzc; i36++) {
            Map.Entry entryZzg = zzdxVar.zza.zzg(i36);
            iZza2 += zzdx.zza((zzdw) ((zzgi) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry2 : zzdxVar.zza.zzd()) {
            iZza2 += zzdx.zza((zzdw) entry2.getKey(), entry2.getValue());
        }
        return iZza3 + iZza2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int i5;
        long jDoubleToLongBits;
        int i6;
        int iFloatToIntBits;
        int iZzc;
        int i7;
        int i8 = 0;
        for (int i9 = 0; i9 < this.zzc.length; i9 += 3) {
            int iZzs = zzs(i9);
            int[] iArr = this.zzc;
            int i10 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i11 = iArr[i9];
            long j6 = i10;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i5 = i8 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzgz.zza(obj, j6));
                    byte[] bArr = zzep.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZzc;
                    break;
                case 1:
                    i6 = i8 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzgz.zzb(obj, j6));
                    i8 = iFloatToIntBits + i6;
                    break;
                case 2:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j6);
                    byte[] bArr2 = zzep.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZzc;
                    break;
                case 3:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j6);
                    byte[] bArr3 = zzep.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZzc;
                    break;
                case 4:
                    i5 = i8 * 53;
                    iZzc = zzgz.zzc(obj, j6);
                    i8 = i5 + iZzc;
                    break;
                case 5:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j6);
                    byte[] bArr4 = zzep.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZzc;
                    break;
                case 6:
                    i5 = i8 * 53;
                    iZzc = zzgz.zzc(obj, j6);
                    i8 = i5 + iZzc;
                    break;
                case 7:
                    i6 = i8 * 53;
                    iFloatToIntBits = zzep.zza(zzgz.zzw(obj, j6));
                    i8 = iFloatToIntBits + i6;
                    break;
                case 8:
                    i6 = i8 * 53;
                    iFloatToIntBits = ((String) zzgz.zzf(obj, j6)).hashCode();
                    i8 = iFloatToIntBits + i6;
                    break;
                case 9:
                    i7 = i8 * 53;
                    Object objZzf = zzgz.zzf(obj, j6);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i8 = i7 + iHashCode;
                    break;
                case 10:
                    i6 = i8 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j6).hashCode();
                    i8 = iFloatToIntBits + i6;
                    break;
                case 11:
                    i5 = i8 * 53;
                    iZzc = zzgz.zzc(obj, j6);
                    i8 = i5 + iZzc;
                    break;
                case 12:
                    i5 = i8 * 53;
                    iZzc = zzgz.zzc(obj, j6);
                    i8 = i5 + iZzc;
                    break;
                case 13:
                    i5 = i8 * 53;
                    iZzc = zzgz.zzc(obj, j6);
                    i8 = i5 + iZzc;
                    break;
                case 14:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j6);
                    byte[] bArr5 = zzep.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZzc;
                    break;
                case 15:
                    i5 = i8 * 53;
                    iZzc = zzgz.zzc(obj, j6);
                    i8 = i5 + iZzc;
                    break;
                case 16:
                    i5 = i8 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j6);
                    byte[] bArr6 = zzep.zzb;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i8 = i5 + iZzc;
                    break;
                case 17:
                    i7 = i8 * 53;
                    Object objZzf2 = zzgz.zzf(obj, j6);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
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
                    iFloatToIntBits = zzgz.zzf(obj, j6).hashCode();
                    i8 = iFloatToIntBits + i6;
                    break;
                case 50:
                    i6 = i8 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j6).hashCode();
                    i8 = iFloatToIntBits + i6;
                    break;
                case 51:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j6));
                        byte[] bArr7 = zzep.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZzc;
                    }
                    break;
                case 52:
                    if (zzM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j6));
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 53:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zzt(obj, j6);
                        byte[] bArr8 = zzep.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZzc;
                    }
                    break;
                case 54:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zzt(obj, j6);
                        byte[] bArr9 = zzep.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZzc;
                    }
                    break;
                case 55:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZzc = zzo(obj, j6);
                        i8 = i5 + iZzc;
                    }
                    break;
                case 56:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zzt(obj, j6);
                        byte[] bArr10 = zzep.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZzc;
                    }
                    break;
                case 57:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZzc = zzo(obj, j6);
                        i8 = i5 + iZzc;
                    }
                    break;
                case 58:
                    if (zzM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = zzep.zza(zzN(obj, j6));
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 59:
                    if (zzM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = ((String) zzgz.zzf(obj, j6)).hashCode();
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 60:
                    if (zzM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j6).hashCode();
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 61:
                    if (zzM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j6).hashCode();
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
                case 62:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZzc = zzo(obj, j6);
                        i8 = i5 + iZzc;
                    }
                    break;
                case 63:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZzc = zzo(obj, j6);
                        i8 = i5 + iZzc;
                    }
                    break;
                case 64:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZzc = zzo(obj, j6);
                        i8 = i5 + iZzc;
                    }
                    break;
                case 65:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zzt(obj, j6);
                        byte[] bArr11 = zzep.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZzc;
                    }
                    break;
                case 66:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        iZzc = zzo(obj, j6);
                        i8 = i5 + iZzc;
                    }
                    break;
                case 67:
                    if (zzM(obj, i11, i9)) {
                        i5 = i8 * 53;
                        jDoubleToLongBits = zzt(obj, j6);
                        byte[] bArr12 = zzep.zzb;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i8 = i5 + iZzc;
                    }
                    break;
                case 68:
                    if (zzM(obj, i11, i9)) {
                        i6 = i8 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j6).hashCode();
                        i8 = iFloatToIntBits + i6;
                    }
                    break;
            }
        }
        int iHashCode2 = ((zzeh) obj).zzc.hashCode() + (i8 * 53);
        return this.zzh ? (iHashCode2 * 53) + ((zzed) obj).zzb.zza.hashCode() : iHashCode2;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 39141. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu r39) {
        /*
            Method dump skipped, instruction units count: 3914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        return ((zzeh) this.zzg).zzK();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzeh) {
                zzeh zzehVar = (zzeh) obj;
                zzehVar.zzW(Integer.MAX_VALUE);
                zzehVar.zza = 0;
                zzehVar.zzU();
            }
            int[] iArr = this.zzc;
            for (int i5 = 0; i5 < iArr.length; i5 += 3) {
                int iZzs = zzs(i5);
                int i6 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j6 = i6;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i5)) {
                                    zzv(i5).zzf(zzb.getObject(obj, j6));
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
                                ((zzeo) zzgz.zzf(obj, j6)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j6);
                                if (object != null) {
                                    ((zzfg) object).zzc();
                                    unsafe.putObject(obj, j6, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, this.zzc[i5], i5)) {
                        zzv(i5).zzf(zzb.getObject(obj, j6));
                    }
                } else if (zzI(obj, i5)) {
                    zzv(i5).zzf(zzb.getObject(obj, j6));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int iZzs = zzs(i5);
            int i6 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i7 = iArr[i5];
            long j6 = i6;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i5)) {
                        zzgz.zzo(obj, j6, zzgz.zza(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i5)) {
                        zzgz.zzp(obj, j6, zzgz.zzb(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i5)) {
                        zzgz.zzr(obj, j6, zzgz.zzd(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i5)) {
                        zzgz.zzr(obj, j6, zzgz.zzd(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i5)) {
                        zzgz.zzq(obj, j6, zzgz.zzc(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i5)) {
                        zzgz.zzr(obj, j6, zzgz.zzd(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i5)) {
                        zzgz.zzq(obj, j6, zzgz.zzc(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i5)) {
                        zzgz.zzm(obj, j6, zzgz.zzw(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i5)) {
                        zzgz.zzs(obj, j6, zzgz.zzf(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i5);
                    break;
                case 10:
                    if (zzI(obj2, i5)) {
                        zzgz.zzs(obj, j6, zzgz.zzf(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i5)) {
                        zzgz.zzq(obj, j6, zzgz.zzc(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i5)) {
                        zzgz.zzq(obj, j6, zzgz.zzc(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i5)) {
                        zzgz.zzq(obj, j6, zzgz.zzc(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i5)) {
                        zzgz.zzr(obj, j6, zzgz.zzd(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i5)) {
                        zzgz.zzq(obj, j6, zzgz.zzc(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i5)) {
                        zzgz.zzr(obj, j6, zzgz.zzd(obj2, j6));
                        zzD(obj, i5);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i5);
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
                    zzeo zzeoVarZzd = (zzeo) zzgz.zzf(obj, j6);
                    zzeo zzeoVar = (zzeo) zzgz.zzf(obj2, j6);
                    int size = zzeoVarZzd.size();
                    int size2 = zzeoVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzeoVarZzd.zzc()) {
                            zzeoVarZzd = zzeoVarZzd.zzd(size2 + size);
                        }
                        zzeoVarZzd.addAll(zzeoVar);
                    }
                    if (size > 0) {
                        zzeoVar = zzeoVarZzd;
                    }
                    zzgz.zzs(obj, j6, zzeoVar);
                    break;
                case 50:
                    int i8 = zzgg.zza;
                    zzgz.zzs(obj, j6, zzfh.zza(zzgz.zzf(obj, j6), zzgz.zzf(obj2, j6)));
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
                    if (zzM(obj2, i7, i5)) {
                        zzgz.zzs(obj, j6, zzgz.zzf(obj2, j6));
                        zzE(obj, i7, i5);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i5);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i7, i5)) {
                        zzgz.zzs(obj, j6, zzgz.zzf(obj2, j6));
                        zzE(obj, i7, i5);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i5);
                    break;
            }
        }
        zzgg.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zzgg.zzo(this.zzm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzh(Object obj, byte[] bArr, int i5, int i6, zzcu zzcuVar) {
        zzc(obj, bArr, i5, i6, 0, zzcuVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzhh zzhhVar) {
        Map.Entry entry;
        Iterator it;
        int i5;
        int i6;
        int i7;
        int i8;
        zzfp<T> zzfpVar = this;
        if (zzfpVar.zzh) {
            zzdx zzdxVar = ((zzed) obj).zzb;
            if (zzdxVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzdxVar.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = zzfpVar.zzc;
        Unsafe unsafe = zzb;
        int i9 = 0;
        int i10 = 1048575;
        int i11 = 0;
        while (i9 < iArr.length) {
            int iZzs = zzfpVar.zzs(i9);
            int[] iArr2 = zzfpVar.zzc;
            int iZzr = zzr(iZzs);
            int i12 = iArr2[i9];
            if (iZzr <= 17) {
                int i13 = iArr2[i9 + 2];
                int i14 = i13 & 1048575;
                if (i14 != i10) {
                    i5 = 1;
                    i11 = i14 == 1048575 ? 0 : unsafe.getInt(obj, i14);
                    i10 = i14;
                } else {
                    i5 = 1;
                }
                i6 = i10;
                i7 = i11;
                i8 = i5 << (i13 >>> 20);
            } else {
                i5 = 1;
                i6 = i10;
                i7 = i11;
                i8 = 0;
            }
            while (entry != null && ((zzee) entry.getKey()).zza <= i12) {
                zzfpVar.zzm.zzb(zzhhVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j6 = iZzs & 1048575;
            switch (iZzr) {
                case 0:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzf(i12, zzgz.zza(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 1:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzo(i12, zzgz.zzb(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 2:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzt(i12, unsafe.getLong(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 3:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzK(i12, unsafe.getLong(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 4:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzr(i12, unsafe.getInt(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 5:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzm(i12, unsafe.getLong(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 6:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzk(i12, unsafe.getInt(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 7:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzb(i12, zzgz.zzw(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 8:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzO(i12, unsafe.getObject(obj, j6), zzhhVar);
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 9:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzv(i12, unsafe.getObject(obj, j6), zzfpVar.zzv(i9));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 10:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzd(i12, (zzdf) unsafe.getObject(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 11:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzI(i12, unsafe.getInt(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 12:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzi(i12, unsafe.getInt(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 13:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzx(i12, unsafe.getInt(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 14:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzz(i12, unsafe.getLong(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 15:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzB(i12, unsafe.getInt(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 16:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzD(i12, unsafe.getLong(obj, j6));
                    }
                    zzfpVar = this;
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 17:
                    if (zzfpVar.zzJ(obj, i9, i6, i7, i8)) {
                        zzhhVar.zzq(i12, unsafe.getObject(obj, j6), zzfpVar.zzv(i9));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 18:
                    zzgg.zzr(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 19:
                    zzgg.zzv(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 20:
                    zzgg.zzx(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 21:
                    zzgg.zzD(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 22:
                    zzgg.zzw(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 23:
                    zzgg.zzu(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 24:
                    zzgg.zzt(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 25:
                    zzgg.zzq(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 26:
                    int i15 = zzfpVar.zzc[i9];
                    List list = (List) unsafe.getObject(obj, j6);
                    int i16 = zzgg.zza;
                    if (list != null && !list.isEmpty()) {
                        zzhhVar.zzH(i15, list);
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 27:
                    int i17 = zzfpVar.zzc[i9];
                    List list2 = (List) unsafe.getObject(obj, j6);
                    zzge zzgeVarZzv = zzfpVar.zzv(i9);
                    int i18 = zzgg.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i19 = 0; i19 < list2.size(); i19++) {
                            ((zzdo) zzhhVar).zzv(i17, list2.get(i19), zzgeVarZzv);
                        }
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 28:
                    int i20 = zzfpVar.zzc[i9];
                    List list3 = (List) unsafe.getObject(obj, j6);
                    int i21 = zzgg.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzhhVar.zze(i20, list3);
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 29:
                    zzgg.zzC(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 30:
                    zzgg.zzs(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 31:
                    zzgg.zzy(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 32:
                    zzgg.zzz(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 33:
                    zzgg.zzA(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 34:
                    zzgg.zzB(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, false);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 35:
                    zzgg.zzr(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 36:
                    zzgg.zzv(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 37:
                    zzgg.zzx(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 38:
                    zzgg.zzD(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 39:
                    zzgg.zzw(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 40:
                    zzgg.zzu(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 41:
                    zzgg.zzt(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 42:
                    zzgg.zzq(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 43:
                    zzgg.zzC(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 44:
                    zzgg.zzs(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 45:
                    zzgg.zzy(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 46:
                    zzgg.zzz(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 47:
                    zzgg.zzA(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 48:
                    zzgg.zzB(zzfpVar.zzc[i9], (List) unsafe.getObject(obj, j6), zzhhVar, i5);
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 49:
                    int i22 = zzfpVar.zzc[i9];
                    List list4 = (List) unsafe.getObject(obj, j6);
                    zzge zzgeVarZzv2 = zzfpVar.zzv(i9);
                    int i23 = zzgg.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i24 = 0; i24 < list4.size(); i24++) {
                            ((zzdo) zzhhVar).zzq(i22, list4.get(i24), zzgeVarZzv2);
                        }
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j6) != null) {
                        throw null;
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 51:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzf(i12, zzm(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 52:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzo(i12, zzn(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 53:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzt(i12, zzt(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 54:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzK(i12, zzt(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 55:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzr(i12, zzo(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 56:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzm(i12, zzt(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 57:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzk(i12, zzo(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 58:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzb(i12, zzN(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 59:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzO(i12, unsafe.getObject(obj, j6), zzhhVar);
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 60:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzv(i12, unsafe.getObject(obj, j6), zzfpVar.zzv(i9));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 61:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzd(i12, (zzdf) unsafe.getObject(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 62:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzI(i12, zzo(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 63:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzi(i12, zzo(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 64:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzx(i12, zzo(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 65:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzz(i12, zzt(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 66:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzB(i12, zzo(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 67:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzD(i12, zzt(obj, j6));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                case 68:
                    if (zzfpVar.zzM(obj, i12, i9)) {
                        zzhhVar.zzq(i12, unsafe.getObject(obj, j6), zzfpVar.zzv(i9));
                    }
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
                default:
                    i9 += 3;
                    i11 = i7;
                    i10 = i6;
                    entry = entry;
                    break;
            }
        }
        while (entry != null) {
            zzfpVar.zzm.zzb(zzhhVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        ((zzeh) obj).zzc.zzl(zzhhVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int iZzs = zzs(i5);
            long j6 = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i5) || Double.doubleToLongBits(zzgz.zza(obj, j6)) != Double.doubleToLongBits(zzgz.zza(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i5) || Float.floatToIntBits(zzgz.zzb(obj, j6)) != Float.floatToIntBits(zzgz.zzb(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i5) || zzgz.zzd(obj, j6) != zzgz.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i5) || zzgz.zzd(obj, j6) != zzgz.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i5) || zzgz.zzc(obj, j6) != zzgz.zzc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i5) || zzgz.zzd(obj, j6) != zzgz.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i5) || zzgz.zzc(obj, j6) != zzgz.zzc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i5) || zzgz.zzw(obj, j6) != zzgz.zzw(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i5) || !zzgg.zzE(zzgz.zzf(obj, j6), zzgz.zzf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i5) || !zzgg.zzE(zzgz.zzf(obj, j6), zzgz.zzf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i5) || !zzgg.zzE(zzgz.zzf(obj, j6), zzgz.zzf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i5) || zzgz.zzc(obj, j6) != zzgz.zzc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i5) || zzgz.zzc(obj, j6) != zzgz.zzc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i5) || zzgz.zzc(obj, j6) != zzgz.zzc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i5) || zzgz.zzd(obj, j6) != zzgz.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i5) || zzgz.zzc(obj, j6) != zzgz.zzc(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i5) || zzgz.zzd(obj, j6) != zzgz.zzd(obj2, j6)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i5) || !zzgg.zzE(zzgz.zzf(obj, j6), zzgz.zzf(obj2, j6))) {
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
                    zZzE = zzgg.zzE(zzgz.zzf(obj, j6), zzgz.zzf(obj2, j6));
                    break;
                case 50:
                    zZzE = zzgg.zzE(zzgz.zzf(obj, j6), zzgz.zzf(obj2, j6));
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
                    long jZzp = zzp(i5) & 1048575;
                    if (zzgz.zzc(obj, jZzp) != zzgz.zzc(obj2, jZzp) || !zzgg.zzE(zzgz.zzf(obj, j6), zzgz.zzf(obj2, j6))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2 A[LOOP:1: B:45:0x00a1->B:50:0x00b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        int i5;
        int i6;
        List list;
        zzge zzgeVarZzv;
        int i7;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i8 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i11 = iArr[i8];
            int i12 = iArr2[i11];
            int iZzs = zzs(i11);
            int i13 = this.zzc[i11 + 2];
            int i14 = i13 & 1048575;
            int i15 = 1 << (i13 >>> 20);
            if (i14 != i10) {
                if (i14 != 1048575) {
                    i9 = zzb.getInt(obj, i14);
                }
                i6 = i9;
                i5 = i14;
            } else {
                i5 = i10;
                i6 = i9;
            }
            Object obj2 = obj;
            if ((268435456 & iZzs) != 0 && !zzJ(obj2, i11, i5, i6, i15)) {
                return false;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzJ(obj2, i11, i5, i6, i15) && !zzK(obj2, iZzs, zzv(i11))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzgz.zzf(obj2, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgeVarZzv = zzv(i11);
                    for (i7 = 0; i7 < list.size(); i7++) {
                        if (!zzgeVarZzv.zzk(list.get(i7))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj2, i12, i11) && !zzK(obj2, iZzs, zzv(i11))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzgz.zzf(obj2, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzgeVarZzv = zzv(i11);
                    while (i7 < list.size()) {
                        if (!zzgeVarZzv.zzk(list.get(i7))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzfg) zzgz.zzf(obj2, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i8++;
            obj = obj2;
            i10 = i5;
            i9 = i6;
        }
        return !this.zzh || ((zzed) obj).zzb.zzk();
    }
}
