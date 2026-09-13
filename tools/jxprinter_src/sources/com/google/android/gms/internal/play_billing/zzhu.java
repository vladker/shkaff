package com.google.android.gms.internal.play_billing;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhu<T> implements zzib<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzix.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhr zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zziq zzl;
    private final zzgd zzm;

    private zzhu(int[] iArr, Object[] objArr, int i5, int i6, zzhr zzhrVar, boolean z6, int[] iArr2, int i7, int i8, zzhw zzhwVar, zzhe zzheVar, zziq zziqVar, zzgd zzgdVar, zzhn zzhnVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i5;
        this.zzf = i6;
        boolean z7 = false;
        if (zzgdVar != null && (zzhrVar instanceof zzgm)) {
            z7 = true;
        }
        this.zzh = z7;
        this.zzi = iArr2;
        this.zzj = i7;
        this.zzk = i8;
        this.zzl = zziqVar;
        this.zzm = zzgdVar;
        this.zzg = zzhrVar;
    }

    private final void zzA(Object obj, Object obj2, int i5) {
        if (zzH(obj2, i5)) {
            int iZzq = zzq(i5) & 1048575;
            Unsafe unsafe = zzb;
            long j6 = iZzq;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i5] + " is present but null: " + obj2.toString());
            }
            zzib zzibVarZzt = zzt(i5);
            if (!zzH(obj, i5)) {
                if (zzK(object)) {
                    Object objZze = zzibVarZzt.zze();
                    zzibVarZzt.zzg(objZze, object);
                    unsafe.putObject(obj, j6, objZze);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zzC(obj, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzK(object2)) {
                Object objZze2 = zzibVarZzt.zze();
                zzibVarZzt.zzg(objZze2, object2);
                unsafe.putObject(obj, j6, objZze2);
                object2 = objZze2;
            }
            zzibVarZzt.zzg(object2, object);
        }
    }

    private final void zzB(Object obj, Object obj2, int i5) {
        int[] iArr = this.zzc;
        int i6 = iArr[i5];
        if (zzM(obj2, i6, i5)) {
            int iZzq = zzq(i5) & 1048575;
            Unsafe unsafe = zzb;
            long j6 = iZzq;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i5] + " is present but null: " + obj2.toString());
            }
            zzib zzibVarZzt = zzt(i5);
            if (!zzM(obj, i6, i5)) {
                if (zzK(object)) {
                    Object objZze = zzibVarZzt.zze();
                    zzibVarZzt.zzg(objZze, object);
                    unsafe.putObject(obj, j6, objZze);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zzD(obj, i6, i5);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzK(object2)) {
                Object objZze2 = zzibVarZzt.zze();
                zzibVarZzt.zzg(objZze2, object2);
                unsafe.putObject(obj, j6, objZze2);
                object2 = objZze2;
            }
            zzibVarZzt.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, int i5) {
        int iZzn = zzn(i5);
        long j6 = 1048575 & iZzn;
        if (j6 == 1048575) {
            return;
        }
        zzix.zzn(obj, j6, (1 << (iZzn >>> 20)) | zzix.zzc(obj, j6));
    }

    private final void zzD(Object obj, int i5, int i6) {
        zzix.zzn(obj, zzn(i6) & 1048575, i5);
    }

    private final void zzE(Object obj, int i5, Object obj2) {
        zzb.putObject(obj, zzq(i5) & 1048575, obj2);
        zzC(obj, i5);
    }

    private final void zzF(Object obj, int i5, int i6, Object obj2) {
        zzb.putObject(obj, zzq(i6) & 1048575, obj2);
        zzD(obj, i5, i6);
    }

    private final boolean zzG(Object obj, Object obj2, int i5) {
        return zzH(obj, i5) == zzH(obj2, i5);
    }

    private final boolean zzH(Object obj, int i5) {
        int iZzn = zzn(i5);
        long j6 = iZzn & 1048575;
        if (j6 != 1048575) {
            return (zzix.zzc(obj, j6) & (1 << (iZzn >>> 20))) != 0;
        }
        int iZzq = zzq(i5);
        long j7 = iZzq & 1048575;
        switch (zzp(iZzq)) {
            case 0:
                return Double.doubleToRawLongBits(zzix.zza(obj, j7)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzix.zzb(obj, j7)) != 0;
            case 2:
                return zzix.zzd(obj, j7) != 0;
            case 3:
                return zzix.zzd(obj, j7) != 0;
            case 4:
                return zzix.zzc(obj, j7) != 0;
            case 5:
                return zzix.zzd(obj, j7) != 0;
            case 6:
                return zzix.zzc(obj, j7) != 0;
            case 7:
                return zzix.zzt(obj, j7);
            case 8:
                Object objZzf = zzix.zzf(obj, j7);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzfp) {
                    return !zzfp.zza.equals(objZzf);
                }
                return zzN();
            case 9:
                return zzix.zzf(obj, j7) != null;
            case 10:
                return !zzfp.zza.equals(zzix.zzf(obj, j7));
            case 11:
                return zzix.zzc(obj, j7) != 0;
            case 12:
                return zzix.zzc(obj, j7) != 0;
            case 13:
                return zzix.zzc(obj, j7) != 0;
            case 14:
                return zzix.zzd(obj, j7) != 0;
            case 15:
                return zzix.zzc(obj, j7) != 0;
            case 16:
                return zzix.zzd(obj, j7) != 0;
            case 17:
                return zzix.zzf(obj, j7) != null;
            default:
                return zzN();
        }
    }

    private final boolean zzI(Object obj, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return zzH(obj, i5);
        }
        return (i7 & i8) != 0;
    }

    private static boolean zzJ(Object obj, int i5, zzib zzibVar) {
        return zzibVar.zzk(zzix.zzf(obj, i5 & 1048575));
    }

    private static boolean zzK(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgp) {
            return ((zzgp) obj).zzF();
        }
        return true;
    }

    private final boolean zzL(Object obj, Object obj2, int i5) {
        long jZzn = zzn(i5) & 1048575;
        return zzix.zzc(obj, jZzn) == zzix.zzc(obj2, jZzn);
    }

    private final boolean zzM(Object obj, int i5, int i6) {
        return zzix.zzc(obj, (long) (zzn(i6) & 1048575)) == i5;
    }

    private boolean zzN() {
        throw new IllegalArgumentException();
    }

    private static final int zzO(byte[] bArr, int i5, int i6, zzjg zzjgVar, Class cls, zzfd zzfdVar) {
        zzjg zzjgVar2 = zzjg.zza;
        switch (zzjgVar.ordinal()) {
            case 0:
                int i7 = i5 + 8;
                zzfdVar.zzc = Double.valueOf(Double.longBitsToDouble(zzfe.zzp(bArr, i5)));
                return i7;
            case 1:
                int i8 = i5 + 4;
                zzfdVar.zzc = Float.valueOf(Float.intBitsToFloat(zzfe.zzb(bArr, i5)));
                return i8;
            case 2:
            case 3:
                int iZzl = zzfe.zzl(bArr, i5, zzfdVar);
                zzfdVar.zzc = Long.valueOf(zzfdVar.zzb);
                return iZzl;
            case 4:
            case 12:
            case 13:
                int iZzi = zzfe.zzi(bArr, i5, zzfdVar);
                zzfdVar.zzc = Integer.valueOf(zzfdVar.zza);
                return iZzi;
            case 5:
            case 15:
                int i9 = i5 + 8;
                zzfdVar.zzc = Long.valueOf(zzfe.zzp(bArr, i5));
                return i9;
            case 6:
            case 14:
                int i10 = i5 + 4;
                zzfdVar.zzc = Integer.valueOf(zzfe.zzb(bArr, i5));
                return i10;
            case 7:
                int iZzl2 = zzfe.zzl(bArr, i5, zzfdVar);
                zzfdVar.zzc = Boolean.valueOf(zzfdVar.zzb != 0);
                return iZzl2;
            case 8:
                return zzfe.zzg(bArr, i5, zzfdVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return zzfe.zzd(zzhy.zza().zzb(cls), bArr, i5, i6, zzfdVar);
            case 11:
                return zzfe.zza(bArr, i5, zzfdVar);
            case 16:
                int iZzi2 = zzfe.zzi(bArr, i5, zzfdVar);
                zzfdVar.zzc = Integer.valueOf(zzft.zzb(zzfdVar.zza));
                return iZzi2;
            case 17:
                int iZzl3 = zzfe.zzl(bArr, i5, zzfdVar);
                zzfdVar.zzc = Long.valueOf(zzft.zzc(zzfdVar.zzb));
                return iZzl3;
        }
    }

    private static final void zzP(int i5, Object obj, zzji zzjiVar) {
        if (obj instanceof String) {
            zzjiVar.zzH(i5, (String) obj);
        } else {
            zzjiVar.zzd(i5, (zzfp) obj);
        }
    }

    public static zzir zzd(Object obj) {
        zzgp zzgpVar = (zzgp) obj;
        zzir zzirVar = zzgpVar.zzc;
        if (zzirVar != zzir.zzc()) {
            return zzirVar;
        }
        zzir zzirVarZzf = zzir.zzf();
        zzgpVar.zzc = zzirVarZzf;
        return zzirVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:187:0x03b5  */
    public static zzhu zzl(Class cls, zzhp zzhpVar, zzhw zzhwVar, zzhe zzheVar, zziq zziqVar, zzgd zzgdVar, zzhn zzhnVar) {
        int i5;
        int iCharAt;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        char cCharAt;
        int i12;
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
        int i20;
        int i21;
        int i22;
        int i23;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        char c;
        int i24;
        int i25;
        Field fieldZzy;
        int i26;
        char cCharAt8;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Field fieldZzy2;
        Field fieldZzy3;
        int i32;
        char cCharAt9;
        int i33;
        char cCharAt10;
        int i34;
        char cCharAt11;
        int i35;
        char cCharAt12;
        Unsafe unsafe = zzb;
        if (unsafe == null) {
            throw new RuntimeException("Lite gencode is primarily intended for Android use and uses sun.misc.Unsafe which is not available in the current environment. To run in this environment, you may need to switch to standard gencode.");
        }
        if (!(zzhpVar instanceof zzia)) {
            throw null;
        }
        zzia zziaVar = (zzia) zzhpVar;
        String strZzd = zziaVar.zzd();
        int length = strZzd.length();
        int i36 = 0;
        char c6 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i37 = 1;
            while (true) {
                i5 = i37 + 1;
                if (strZzd.charAt(i37) < 55296) {
                    break;
                }
                i37 = i5;
            }
        } else {
            i5 = 1;
        }
        int i38 = i5 + 1;
        int iCharAt2 = strZzd.charAt(i5);
        if (iCharAt2 >= 55296) {
            int i39 = iCharAt2 & 8191;
            int i40 = 13;
            while (true) {
                i35 = i38 + 1;
                cCharAt12 = strZzd.charAt(i38);
                if (cCharAt12 < 55296) {
                    break;
                }
                i39 |= (cCharAt12 & 8191) << i40;
                i40 += 13;
                i38 = i35;
            }
            iCharAt2 = i39 | (cCharAt12 << i40);
            i38 = i35;
        }
        if (iCharAt2 == 0) {
            iCharAt = 0;
            i9 = 0;
            i10 = 0;
            i6 = 0;
            i8 = 0;
            iArr = zza;
            i7 = 0;
        } else {
            int i41 = i38 + 1;
            int iCharAt3 = strZzd.charAt(i38);
            if (iCharAt3 >= 55296) {
                int i42 = iCharAt3 & 8191;
                int i43 = 13;
                while (true) {
                    i18 = i41 + 1;
                    cCharAt7 = strZzd.charAt(i41);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt7 & 8191) << i43;
                    i43 += 13;
                    i41 = i18;
                }
                iCharAt3 = i42 | (cCharAt7 << i43);
                i41 = i18;
            }
            int i44 = i41 + 1;
            int iCharAt4 = strZzd.charAt(i41);
            if (iCharAt4 >= 55296) {
                int i45 = iCharAt4 & 8191;
                int i46 = 13;
                while (true) {
                    i17 = i44 + 1;
                    cCharAt6 = strZzd.charAt(i44);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt6 & 8191) << i46;
                    i46 += 13;
                    i44 = i17;
                }
                iCharAt4 = i45 | (cCharAt6 << i46);
                i44 = i17;
            }
            int i47 = i44 + 1;
            int iCharAt5 = strZzd.charAt(i44);
            if (iCharAt5 >= 55296) {
                int i48 = iCharAt5 & 8191;
                int i49 = 13;
                while (true) {
                    i16 = i47 + 1;
                    cCharAt5 = strZzd.charAt(i47);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt5 & 8191) << i49;
                    i49 += 13;
                    i47 = i16;
                }
                iCharAt5 = i48 | (cCharAt5 << i49);
                i47 = i16;
            }
            int i50 = i47 + 1;
            int iCharAt6 = strZzd.charAt(i47);
            if (iCharAt6 >= 55296) {
                int i51 = iCharAt6 & 8191;
                int i52 = 13;
                while (true) {
                    i15 = i50 + 1;
                    cCharAt4 = strZzd.charAt(i50);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt4 & 8191) << i52;
                    i52 += 13;
                    i50 = i15;
                }
                iCharAt6 = i51 | (cCharAt4 << i52);
                i50 = i15;
            }
            int i53 = i50 + 1;
            iCharAt = strZzd.charAt(i50);
            if (iCharAt >= 55296) {
                int i54 = iCharAt & 8191;
                int i55 = 13;
                while (true) {
                    i14 = i53 + 1;
                    cCharAt3 = strZzd.charAt(i53);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt3 & 8191) << i55;
                    i55 += 13;
                    i53 = i14;
                }
                iCharAt = i54 | (cCharAt3 << i55);
                i53 = i14;
            }
            int i56 = i53 + 1;
            int iCharAt7 = strZzd.charAt(i53);
            if (iCharAt7 >= 55296) {
                int i57 = iCharAt7 & 8191;
                int i58 = 13;
                while (true) {
                    i13 = i56 + 1;
                    cCharAt2 = strZzd.charAt(i56);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt2 & 8191) << i58;
                    i58 += 13;
                    i56 = i13;
                }
                iCharAt7 = i57 | (cCharAt2 << i58);
                i56 = i13;
            }
            int i59 = i56 + 1;
            if (strZzd.charAt(i56) >= 55296) {
                while (true) {
                    i12 = i59 + 1;
                    if (strZzd.charAt(i59) < 55296) {
                        break;
                    }
                    i59 = i12;
                }
                i59 = i12;
            }
            int i60 = i59 + 1;
            int iCharAt8 = strZzd.charAt(i59);
            if (iCharAt8 >= 55296) {
                int i61 = iCharAt8 & 8191;
                int i62 = 13;
                while (true) {
                    i11 = i60 + 1;
                    cCharAt = strZzd.charAt(i60);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i61 |= (cCharAt & 8191) << i62;
                    i62 += 13;
                    i60 = i11;
                }
                iCharAt8 = i61 | (cCharAt << i62);
                i60 = i11;
            }
            i6 = iCharAt3 + iCharAt3 + iCharAt4;
            i36 = iCharAt3;
            iArr = new int[iCharAt8 + iCharAt7 + iCharAt3];
            i7 = iCharAt7;
            i38 = i60;
            i8 = iCharAt8;
            i9 = iCharAt5;
            i10 = iCharAt6;
        }
        Object[] objArrZze = zziaVar.zze();
        Class<?> cls2 = zziaVar.zza().getClass();
        int i63 = i8 + i7;
        int i64 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i64];
        int i65 = i8;
        int i66 = i63;
        int i67 = 0;
        int i68 = 0;
        while (i38 < length) {
            int i69 = i38 + 1;
            int iCharAt9 = strZzd.charAt(i38);
            if (iCharAt9 >= c6) {
                int i70 = iCharAt9 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i34 = i71 + 1;
                    cCharAt11 = strZzd.charAt(i71);
                    if (cCharAt11 < c6) {
                        break;
                    }
                    i70 |= (cCharAt11 & 8191) << i72;
                    i72 += 13;
                    i71 = i34;
                }
                iCharAt9 = i70 | (cCharAt11 << i72);
                i19 = i34;
            } else {
                i19 = i69;
            }
            int i73 = i19 + 1;
            int iCharAt10 = strZzd.charAt(i19);
            if (iCharAt10 >= c6) {
                int i74 = iCharAt10 & 8191;
                int i75 = i73;
                int i76 = 13;
                while (true) {
                    i33 = i75 + 1;
                    cCharAt10 = strZzd.charAt(i75);
                    if (cCharAt10 < c6) {
                        break;
                    }
                    i74 |= (cCharAt10 & 8191) << i76;
                    i76 += 13;
                    i75 = i33;
                }
                iCharAt10 = i74 | (cCharAt10 << i76);
                i20 = i33;
            } else {
                i20 = i73;
            }
            if ((iCharAt10 & 1024) != 0) {
                iArr[i68] = i67;
                i68++;
            }
            int i77 = iCharAt10 & 255;
            zzia zziaVar2 = zziaVar;
            int i78 = iCharAt10 & 2048;
            if (i77 >= 51) {
                int i79 = i20 + 1;
                int iCharAt11 = strZzd.charAt(i20);
                char c7 = 55296;
                if (iCharAt11 >= 55296) {
                    int i80 = iCharAt11 & 8191;
                    int i81 = i79;
                    int i82 = 13;
                    while (true) {
                        i32 = i81 + 1;
                        cCharAt9 = strZzd.charAt(i81);
                        if (cCharAt9 < c7) {
                            break;
                        }
                        i80 |= (cCharAt9 & 8191) << i82;
                        i82 += 13;
                        i81 = i32;
                        c7 = 55296;
                    }
                    iCharAt11 = i80 | (cCharAt9 << i82);
                    i30 = i32;
                } else {
                    i30 = i79;
                }
                int i83 = i30;
                int i84 = i77 - 51;
                i21 = length;
                if (i84 == 9 || i84 == 17) {
                    objArr[a.r(i67, 3, 1)] = objArrZze[i6];
                    i31 = i78;
                    i6++;
                } else if (i84 != 12) {
                    i31 = i78;
                } else if (zziaVar2.zzc() == 1 || i78 != 0) {
                    objArr[a.r(i67, 3, 1)] = objArrZze[i6];
                    i6++;
                    i31 = i78;
                } else {
                    i31 = 0;
                }
                int i85 = iCharAt11 + iCharAt11;
                Object obj = objArrZze[i85];
                int i86 = i31;
                if (obj instanceof Field) {
                    fieldZzy2 = (Field) obj;
                } else {
                    fieldZzy2 = zzy(cls2, (String) obj);
                    objArrZze[i85] = fieldZzy2;
                    iArr[i66] = i67;
                    i66++;
                }
                int i87 = i36;
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzy2);
                int i88 = i85 + 1;
                Object obj2 = objArrZze[i88];
                i22 = i87;
                if (obj2 instanceof Field) {
                    fieldZzy3 = (Field) obj2;
                } else {
                    fieldZzy3 = zzy(cls2, (String) obj2);
                    objArrZze[i88] = fieldZzy3;
                }
                i20 = i83;
                i25 = 0;
                c = 55296;
                i23 = i6;
                iCharAt9 = iCharAt9;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzy3);
                iObjectFieldOffset = iObjectFieldOffset3;
                i24 = i86;
            } else {
                i21 = length;
                i22 = i36;
                int i89 = i6 + 1;
                Field fieldZzy4 = zzy(cls2, (String) objArrZze[i6]);
                if (i77 == 9 || i77 == 17) {
                    i23 = i89;
                    objArr[a.r(i67, 3, 1)] = fieldZzy4.getType();
                } else {
                    if (i77 != 27) {
                        if (i77 == 49) {
                            i29 = i6 + 2;
                            i27 = 1;
                            i28 = 3;
                        } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                            i23 = i89;
                            if (zziaVar2.zzc() == 1 || i78 != 0) {
                                i29 = i6 + 2;
                                objArr[a.r(i67, 3, 1)] = objArrZze[i23];
                                i23 = i29;
                            } else {
                                i78 = 0;
                            }
                        } else if (i77 == 50) {
                            int i90 = i6 + 2;
                            int i91 = i65 + 1;
                            iArr[i65] = i67;
                            int i92 = i67 / 3;
                            int i93 = i92 + i92;
                            objArr[i93] = objArrZze[i89];
                            if (i78 != 0) {
                                objArr[i93 + 1] = objArrZze[i90];
                                i65 = i91;
                                i23 = i6 + 3;
                            } else {
                                i65 = i91;
                                i78 = 0;
                                i23 = i90;
                            }
                        } else {
                            i23 = i89;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzy4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt10 & 4096) != 0 || i77 > 17) {
                            c = 55296;
                            i24 = i78;
                            i25 = 0;
                        } else {
                            int i94 = i20 + 1;
                            int iCharAt12 = strZzd.charAt(i20);
                            if (iCharAt12 >= 55296) {
                                int i95 = iCharAt12 & 8191;
                                int i96 = 13;
                                while (true) {
                                    i26 = i94 + 1;
                                    cCharAt8 = strZzd.charAt(i94);
                                    if (cCharAt8 < 55296) {
                                        break;
                                    }
                                    i95 |= (cCharAt8 & 8191) << i96;
                                    i96 += 13;
                                    i94 = i26;
                                }
                                iCharAt12 = i95 | (cCharAt8 << i96);
                                i94 = i26;
                            }
                            int i97 = (iCharAt12 / 32) + i22 + i22;
                            Object obj3 = objArrZze[i97];
                            if (obj3 instanceof Field) {
                                fieldZzy = (Field) obj3;
                            } else {
                                fieldZzy = zzy(cls2, (String) obj3);
                                objArrZze[i97] = fieldZzy;
                            }
                            int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzy);
                            i20 = i94;
                            i25 = iCharAt12 % 32;
                            i24 = i78;
                            c = 55296;
                            iObjectFieldOffset2 = iObjectFieldOffset4;
                            iObjectFieldOffset = iObjectFieldOffset;
                        }
                    } else {
                        i27 = 1;
                        i28 = 3;
                        i29 = i6 + 2;
                    }
                    objArr[a.r(i67, i28, i27)] = objArrZze[i89];
                    i23 = i29;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzy4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt10 & 4096) != 0) {
                    c = 55296;
                    i24 = i78;
                    i25 = 0;
                } else {
                    c = 55296;
                    i24 = i78;
                    i25 = 0;
                }
            }
            int i98 = i67 + 1;
            iArr2[i67] = iCharAt9;
            int i99 = i67 + 2;
            iArr2[i98] = ((iCharAt10 & 512) != 0 ? 536870912 : 0) | ((iCharAt10 & 256) != 0 ? 268435456 : 0) | (i24 != 0 ? Integer.MIN_VALUE : 0) | (i77 << 20) | iObjectFieldOffset;
            i67 += 3;
            iArr2[i99] = (i25 << 20) | iObjectFieldOffset2;
            i38 = i20;
            strZzd = strZzd;
            zziaVar = zziaVar2;
            i6 = i23;
            c6 = c;
            length = i21;
            i36 = i22;
        }
        return new zzhu(iArr2, objArr, i9, i10, zziaVar.zza(), false, iArr, i8, i63, zzhwVar, zzheVar, zziqVar, zzgdVar, zzhnVar);
    }

    private static int zzm(Object obj, long j6) {
        return ((Integer) zzix.zzf(obj, j6)).intValue();
    }

    private final int zzn(int i5) {
        return this.zzc[i5 + 2];
    }

    private final int zzo(int i5, int i6) {
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

    private static int zzp(int i5) {
        return (i5 >>> 20) & 255;
    }

    private final int zzq(int i5) {
        return this.zzc[i5 + 1];
    }

    private static long zzr(Object obj, long j6) {
        return ((Long) zzix.zzf(obj, j6)).longValue();
    }

    private final zzgs zzs(int i5) {
        int i6 = i5 / 3;
        return (zzgs) this.zzd[i6 + i6 + 1];
    }

    private final zzib zzt(int i5) {
        Object[] objArr = this.zzd;
        int i6 = i5 / 3;
        int i7 = i6 + i6;
        zzib zzibVar = (zzib) objArr[i7];
        if (zzibVar != null) {
            return zzibVar;
        }
        zzib zzibVarZzb = zzhy.zza().zzb((Class) objArr[i7 + 1]);
        objArr[i7] = zzibVarZzb;
        return zzibVarZzb;
    }

    private final Object zzu(Object obj, int i5, Object obj2, zziq zziqVar, Object obj3) {
        zzgs zzgsVarZzs;
        int i6 = this.zzc[i5];
        Object objZzf = zzix.zzf(obj, zzq(i5) & 1048575);
        if (objZzf == null || (zzgsVarZzs = zzs(i5)) == null) {
            return obj2;
        }
        zzhk zzhkVarZzc = ((zzhl) zzv(i5)).zzc();
        Iterator it = ((zzhm) objZzf).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzgsVarZzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzis.zza(obj3);
                }
                int iZzb = zzhl.zzb(zzhkVarZzc, entry.getKey(), entry.getValue());
                zzfp zzfpVar = zzfp.zza;
                byte[] bArr = new byte[iZzb];
                zzfu zzfuVar = new zzfu(bArr, 0, iZzb);
                try {
                    zzhl.zze(zzfuVar, zzhkVarZzc, entry.getKey(), entry.getValue());
                    ((zzir) obj2).zzj((i6 << 3) | 2, zzfl.zza(zzfuVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private final Object zzv(int i5) {
        int i6 = i5 / 3;
        return this.zzd[i6 + i6];
    }

    private final Object zzw(Object obj, int i5) {
        zzib zzibVarZzt = zzt(i5);
        int iZzq = zzq(i5) & 1048575;
        if (!zzH(obj, i5)) {
            return zzibVarZzt.zze();
        }
        Object object = zzb.getObject(obj, iZzq);
        if (zzK(object)) {
            return object;
        }
        Object objZze = zzibVarZzt.zze();
        if (object != null) {
            zzibVarZzt.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzx(Object obj, int i5, int i6) {
        zzib zzibVarZzt = zzt(i6);
        if (!zzM(obj, i5, i6)) {
            return zzibVarZzt.zze();
        }
        Object object = zzb.getObject(obj, zzq(i6) & 1048575);
        if (zzK(object)) {
            return object;
        }
        Object objZze = zzibVarZzt.zze();
        if (object != null) {
            zzibVarZzt.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzy(Class cls, String str) {
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
            StringBuilder sbU = androidx.collection.a.u("Field ", str, " for ", name, " not found. Known fields are ");
            sbU.append(string);
            throw new RuntimeException(sbU.toString(), e);
        }
    }

    private static void zzz(Object obj) {
        if (!zzK(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:190:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:81:0x01f6  */
    @Override // com.google.android.gms.internal.play_billing.zzib
    public final int zza(Object obj) {
        int i5;
        int iZzy;
        int iZzz;
        int iZza;
        int iZzy2;
        int size;
        int iZzl;
        int iZzy3;
        int iZzy4;
        int iZzy5;
        int iZza2;
        int iZzy6;
        int iZzz2;
        zzhu<T> zzhuVar = this;
        Unsafe unsafe = zzb;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int iC = 0;
        int i9 = 1048575;
        while (true) {
            int[] iArr = zzhuVar.zzc;
            if (i7 >= iArr.length) {
                int iZza3 = ((zzgp) obj).zzc.zza() + iC;
                if (!zzhuVar.zzh) {
                    return iZza3;
                }
                zzii zziiVar = ((zzgm) obj).zzb.zza;
                int iZzc = zziiVar.zzc();
                int iZzc2 = 0;
                for (int i10 = 0; i10 < iZzc; i10++) {
                    Map.Entry entryZzg = zziiVar.zzg(i10);
                    iZzc2 += zzgh.zzc(((zzie) entryZzg).zza(), entryZzg.getValue());
                }
                for (Map.Entry entry : zziiVar.zzd()) {
                    iZzc2 += zzgh.zzc((zzgg) entry.getKey(), entry.getValue());
                }
                return iZza3 + iZzc2;
            }
            int iZzq = zzhuVar.zzq(i7);
            int iZzp = zzp(iZzq);
            int i11 = iArr[i7];
            int i12 = iArr[i7 + 2];
            int i13 = i12 & i6;
            if (iZzp <= 17) {
                if (i13 != i9) {
                    i8 = i13 == i6 ? 0 : unsafe.getInt(obj, i13);
                    i9 = i13;
                }
                i5 = 1 << (i12 >>> 20);
            } else {
                i5 = 0;
            }
            int i14 = iZzq & i6;
            if (iZzp >= zzgi.zzJ.zza()) {
                zzgi.zzW.zza();
            }
            long j6 = i14;
            switch (iZzp) {
                case 0:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iC = a.C(i11 << 3, 8, iC);
                    }
                    break;
                case 1:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iC = a.C(i11 << 3, 4, iC);
                    }
                    zzhuVar = this;
                    break;
                case 2:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        long j7 = unsafe.getLong(obj, j6);
                        iZzy = zzfx.zzy(i11 << 3);
                        iZzz = zzfx.zzz(j7);
                        iC += iZzz + iZzy;
                    }
                    zzhuVar = this;
                    break;
                case 3:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        long j8 = unsafe.getLong(obj, j6);
                        iZzy = zzfx.zzy(i11 << 3);
                        iZzz = zzfx.zzz(j8);
                        iC += iZzz + iZzy;
                    }
                    zzhuVar = this;
                    break;
                case 4:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        long j9 = unsafe.getInt(obj, j6);
                        iZzy = zzfx.zzy(i11 << 3);
                        iZzz = zzfx.zzz(j9);
                        iC += iZzz + iZzy;
                    }
                    zzhuVar = this;
                    break;
                case 5:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iC = a.C(i11 << 3, 8, iC);
                    }
                    zzhuVar = this;
                    break;
                case 6:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iC = a.C(i11 << 3, 4, iC);
                    }
                    zzhuVar = this;
                    break;
                case 7:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iC = a.C(i11 << 3, 1, iC);
                    }
                    zzhuVar = this;
                    break;
                case 8:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        int i15 = i11 << 3;
                        Object object = unsafe.getObject(obj, j6);
                        if (object instanceof zzfp) {
                            int iZzy7 = zzfx.zzy(i15);
                            int iZzd = ((zzfp) object).zzd();
                            iC = a.c(iZzd, iZzd, iZzy7, iC);
                        } else {
                            int iZzy8 = zzfx.zzy(i15);
                            int i16 = zzjc.zza;
                            int iZzb = zziz.zzb((String) object);
                            iC = a.c(iZzb, iZzb, iZzy8, iC);
                        }
                    }
                    zzhuVar = this;
                    break;
                case 9:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        Object object2 = unsafe.getObject(obj, j6);
                        zzib zzibVarZzt = zzhuVar.zzt(i7);
                        int i17 = zzic.zza;
                        int iZzy9 = zzfx.zzy(i11 << 3);
                        int iZzi = ((zzfa) object2).zzi(zzibVarZzt);
                        iC = a.c(iZzi, iZzi, iZzy9, iC);
                    }
                    break;
                case 10:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        zzfp zzfpVar = (zzfp) unsafe.getObject(obj, j6);
                        int iZzy10 = zzfx.zzy(i11 << 3);
                        int iZzd2 = zzfpVar.zzd();
                        iC = a.c(iZzd2, iZzd2, iZzy10, iC);
                    }
                    zzhuVar = this;
                    break;
                case 11:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iC = a.C(unsafe.getInt(obj, j6), zzfx.zzy(i11 << 3), iC);
                    }
                    zzhuVar = this;
                    break;
                case 12:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        long j10 = unsafe.getInt(obj, j6);
                        iZzy = zzfx.zzy(i11 << 3);
                        iZzz = zzfx.zzz(j10);
                        iC += iZzz + iZzy;
                    }
                    zzhuVar = this;
                    break;
                case 13:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iC = a.C(i11 << 3, 4, iC);
                    }
                    zzhuVar = this;
                    break;
                case 14:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iC = a.C(i11 << 3, 8, iC);
                    }
                    zzhuVar = this;
                    break;
                case 15:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        int i18 = unsafe.getInt(obj, j6);
                        iC = a.C((i18 >> 31) ^ (i18 + i18), zzfx.zzy(i11 << 3), iC);
                    }
                    zzhuVar = this;
                    break;
                case 16:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        long j11 = unsafe.getLong(obj, j6);
                        iZzy = zzfx.zzy(i11 << 3);
                        iZzz = zzfx.zzz((j11 >> 63) ^ (j11 + j11));
                        iC += iZzz + iZzy;
                    }
                    zzhuVar = this;
                    break;
                case 17:
                    if (zzhuVar.zzI(obj, i7, i9, i8, i5)) {
                        iZza = zzic.zza(i11, (zzhr) unsafe.getObject(obj, j6), zzhuVar.zzt(i7));
                        iC += iZza;
                    }
                    break;
                case 18:
                    iZza = zzic.zze(i11, (List) unsafe.getObject(obj, j6), false);
                    iC += iZza;
                    break;
                case 19:
                    iZza = zzic.zzc(i11, (List) unsafe.getObject(obj, j6), false);
                    iC += iZza;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j6);
                    int i19 = zzic.zza;
                    if (list.size() == 0) {
                        iZzy2 = 0;
                    } else {
                        iZzy2 = (zzfx.zzy(i11 << 3) * list.size()) + zzic.zzh(list);
                    }
                    iC += iZzy2;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j6);
                    int i20 = zzic.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzy4 = 0;
                    } else {
                        iZzl = zzic.zzl(list2);
                        iZzy3 = zzfx.zzy(i11 << 3);
                        iZzy4 = (iZzy3 * size) + iZzl;
                    }
                    iC += iZzy4;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j6);
                    int i21 = zzic.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzy4 = 0;
                    } else {
                        iZzl = zzic.zzg(list3);
                        iZzy3 = zzfx.zzy(i11 << 3);
                        iZzy4 = (iZzy3 * size) + iZzl;
                    }
                    iC += iZzy4;
                    break;
                case 23:
                    iZza = zzic.zze(i11, (List) unsafe.getObject(obj, j6), false);
                    iC += iZza;
                    break;
                case 24:
                    iZza = zzic.zzc(i11, (List) unsafe.getObject(obj, j6), false);
                    iC += iZza;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j6);
                    int i22 = zzic.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzy2 = 0;
                    } else {
                        iZzy2 = (zzfx.zzy(i11 << 3) + 1) * size2;
                    }
                    iC += iZzy2;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j6);
                    int i23 = zzic.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzy4 = 0;
                    } else {
                        iZzy4 = zzfx.zzy(i11 << 3) * size3;
                        if (list5 instanceof zzhd) {
                            zzhd zzhdVar = (zzhd) list5;
                            for (int i24 = 0; i24 < size3; i24++) {
                                Object objZza = zzhdVar.zza();
                                if (objZza instanceof zzfp) {
                                    int iZzd3 = ((zzfp) objZza).zzd();
                                    iZzy4 = a.C(iZzd3, iZzd3, iZzy4);
                                } else {
                                    int i25 = zzjc.zza;
                                    int iZzb2 = zziz.zzb((String) objZza);
                                    iZzy4 = a.C(iZzb2, iZzb2, iZzy4);
                                }
                            }
                        } else {
                            for (int i26 = 0; i26 < size3; i26++) {
                                Object obj2 = list5.get(i26);
                                if (obj2 instanceof zzfp) {
                                    int iZzd4 = ((zzfp) obj2).zzd();
                                    iZzy4 = a.C(iZzd4, iZzd4, iZzy4);
                                } else {
                                    int i27 = zzjc.zza;
                                    int iZzb3 = zziz.zzb((String) obj2);
                                    iZzy4 = a.C(iZzb3, iZzb3, iZzy4);
                                }
                            }
                        }
                    }
                    iC += iZzy4;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j6);
                    zzib zzibVarZzt2 = zzhuVar.zzt(i7);
                    int i28 = zzic.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzy5 = 0;
                    } else {
                        iZzy5 = zzfx.zzy(i11 << 3) * size4;
                        for (int i29 = 0; i29 < size4; i29++) {
                            int iZzi2 = ((zzfa) list6.get(i29)).zzi(zzibVarZzt2);
                            iZzy5 = a.C(iZzi2, iZzi2, iZzy5);
                        }
                    }
                    iC += iZzy5;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j6);
                    int i30 = zzic.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzy4 = 0;
                    } else {
                        iZzy4 = zzfx.zzy(i11 << 3) * size5;
                        for (int i31 = 0; i31 < list7.size(); i31++) {
                            int iZzd5 = ((zzfp) list7.get(i31)).zzd();
                            iZzy4 = a.C(iZzd5, iZzd5, iZzy4);
                        }
                    }
                    iC += iZzy4;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j6);
                    int i32 = zzic.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzy4 = 0;
                    } else {
                        iZzl = zzic.zzk(list8);
                        iZzy3 = zzfx.zzy(i11 << 3);
                        iZzy4 = (iZzy3 * size) + iZzl;
                    }
                    iC += iZzy4;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j6);
                    int i33 = zzic.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzy4 = 0;
                    } else {
                        iZzl = zzic.zzb(list9);
                        iZzy3 = zzfx.zzy(i11 << 3);
                        iZzy4 = (iZzy3 * size) + iZzl;
                    }
                    iC += iZzy4;
                    break;
                case 31:
                    iZza = zzic.zzc(i11, (List) unsafe.getObject(obj, j6), false);
                    iC += iZza;
                    break;
                case 32:
                    iZza = zzic.zze(i11, (List) unsafe.getObject(obj, j6), false);
                    iC += iZza;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j6);
                    int i34 = zzic.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzy4 = 0;
                    } else {
                        iZzl = zzic.zzi(list10);
                        iZzy3 = zzfx.zzy(i11 << 3);
                        iZzy4 = (iZzy3 * size) + iZzl;
                    }
                    iC += iZzy4;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j6);
                    int i35 = zzic.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzy4 = 0;
                    } else {
                        iZzl = zzic.zzj(list11);
                        iZzy3 = zzfx.zzy(i11 << 3);
                        iZzy4 = (iZzy3 * size) + iZzl;
                    }
                    iC += iZzy4;
                    break;
                case 35:
                    int iZzf = zzic.zzf((List) unsafe.getObject(obj, j6));
                    if (iZzf > 0) {
                        iC = a.c(iZzf, zzfx.zzy(i11 << 3), iZzf, iC);
                    }
                    break;
                case 36:
                    int iZzd6 = zzic.zzd((List) unsafe.getObject(obj, j6));
                    if (iZzd6 > 0) {
                        iC = a.c(iZzd6, zzfx.zzy(i11 << 3), iZzd6, iC);
                    }
                    break;
                case 37:
                    int iZzh = zzic.zzh((List) unsafe.getObject(obj, j6));
                    if (iZzh > 0) {
                        iC = a.c(iZzh, zzfx.zzy(i11 << 3), iZzh, iC);
                    }
                    break;
                case 38:
                    int iZzl2 = zzic.zzl((List) unsafe.getObject(obj, j6));
                    if (iZzl2 > 0) {
                        iC = a.c(iZzl2, zzfx.zzy(i11 << 3), iZzl2, iC);
                    }
                    break;
                case 39:
                    int iZzg = zzic.zzg((List) unsafe.getObject(obj, j6));
                    if (iZzg > 0) {
                        iC = a.c(iZzg, zzfx.zzy(i11 << 3), iZzg, iC);
                    }
                    break;
                case 40:
                    int iZzf2 = zzic.zzf((List) unsafe.getObject(obj, j6));
                    if (iZzf2 > 0) {
                        iC = a.c(iZzf2, zzfx.zzy(i11 << 3), iZzf2, iC);
                    }
                    break;
                case 41:
                    int iZzd7 = zzic.zzd((List) unsafe.getObject(obj, j6));
                    if (iZzd7 > 0) {
                        iC = a.c(iZzd7, zzfx.zzy(i11 << 3), iZzd7, iC);
                    }
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j6);
                    int i36 = zzic.zza;
                    int size6 = list12.size();
                    if (size6 > 0) {
                        iC = a.c(size6, zzfx.zzy(i11 << 3), size6, iC);
                    }
                    break;
                case 43:
                    int iZzk = zzic.zzk((List) unsafe.getObject(obj, j6));
                    if (iZzk > 0) {
                        iC = a.c(iZzk, zzfx.zzy(i11 << 3), iZzk, iC);
                    }
                    break;
                case 44:
                    int iZzb4 = zzic.zzb((List) unsafe.getObject(obj, j6));
                    if (iZzb4 > 0) {
                        iC = a.c(iZzb4, zzfx.zzy(i11 << 3), iZzb4, iC);
                    }
                    break;
                case 45:
                    int iZzd8 = zzic.zzd((List) unsafe.getObject(obj, j6));
                    if (iZzd8 > 0) {
                        iC = a.c(iZzd8, zzfx.zzy(i11 << 3), iZzd8, iC);
                    }
                    break;
                case 46:
                    int iZzf3 = zzic.zzf((List) unsafe.getObject(obj, j6));
                    if (iZzf3 > 0) {
                        iC = a.c(iZzf3, zzfx.zzy(i11 << 3), iZzf3, iC);
                    }
                    break;
                case 47:
                    int iZzi3 = zzic.zzi((List) unsafe.getObject(obj, j6));
                    if (iZzi3 > 0) {
                        iC = a.c(iZzi3, zzfx.zzy(i11 << 3), iZzi3, iC);
                    }
                    break;
                case 48:
                    int iZzj = zzic.zzj((List) unsafe.getObject(obj, j6));
                    if (iZzj > 0) {
                        iC = a.c(iZzj, zzfx.zzy(i11 << 3), iZzj, iC);
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j6);
                    zzib zzibVarZzt3 = zzhuVar.zzt(i7);
                    int i37 = zzic.zza;
                    int size7 = list13.size();
                    if (size7 == 0) {
                        iZza2 = 0;
                    } else {
                        iZza2 = 0;
                        for (int i38 = 0; i38 < size7; i38++) {
                            iZza2 += zzic.zza(i11, (zzhr) list13.get(i38), zzibVarZzt3);
                        }
                    }
                    iC += iZza2;
                    break;
                case 50:
                    zzhm zzhmVar = (zzhm) unsafe.getObject(obj, j6);
                    zzhl zzhlVar = (zzhl) zzhuVar.zzv(i7);
                    if (zzhmVar.isEmpty()) {
                        iZzy4 = 0;
                    } else {
                        iZzy4 = 0;
                        for (Map.Entry entry2 : zzhmVar.entrySet()) {
                            iZzy4 += zzhlVar.zza(i11, entry2.getKey(), entry2.getValue());
                        }
                    }
                    iC += iZzy4;
                    break;
                case 51:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iC = a.C(i11 << 3, 8, iC);
                    }
                    break;
                case 52:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iC = a.C(i11 << 3, 4, iC);
                    }
                    break;
                case 53:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        long jZzr = zzr(obj, j6);
                        iZzy6 = zzfx.zzy(i11 << 3);
                        iZzz2 = zzfx.zzz(jZzr);
                        iC += iZzz2 + iZzy6;
                    }
                    break;
                case 54:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        long jZzr2 = zzr(obj, j6);
                        iZzy6 = zzfx.zzy(i11 << 3);
                        iZzz2 = zzfx.zzz(jZzr2);
                        iC += iZzz2 + iZzy6;
                    }
                    break;
                case 55:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        long jZzm = zzm(obj, j6);
                        iZzy6 = zzfx.zzy(i11 << 3);
                        iZzz2 = zzfx.zzz(jZzm);
                        iC += iZzz2 + iZzy6;
                    }
                    break;
                case 56:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iC = a.C(i11 << 3, 8, iC);
                    }
                    break;
                case 57:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iC = a.C(i11 << 3, 4, iC);
                    }
                    break;
                case 58:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iC = a.C(i11 << 3, 1, iC);
                    }
                    break;
                case 59:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        int i39 = i11 << 3;
                        Object object3 = unsafe.getObject(obj, j6);
                        if (object3 instanceof zzfp) {
                            int iZzy11 = zzfx.zzy(i39);
                            int iZzd9 = ((zzfp) object3).zzd();
                            iC = a.c(iZzd9, iZzd9, iZzy11, iC);
                        } else {
                            int iZzy12 = zzfx.zzy(i39);
                            int i40 = zzjc.zza;
                            int iZzb5 = zziz.zzb((String) object3);
                            iC = a.c(iZzb5, iZzb5, iZzy12, iC);
                        }
                    }
                    break;
                case 60:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        Object object4 = unsafe.getObject(obj, j6);
                        zzib zzibVarZzt4 = zzhuVar.zzt(i7);
                        int i41 = zzic.zza;
                        int iZzy13 = zzfx.zzy(i11 << 3);
                        int iZzi4 = ((zzfa) object4).zzi(zzibVarZzt4);
                        iC = a.c(iZzi4, iZzi4, iZzy13, iC);
                    }
                    break;
                case 61:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        zzfp zzfpVar2 = (zzfp) unsafe.getObject(obj, j6);
                        int iZzy14 = zzfx.zzy(i11 << 3);
                        int iZzd10 = zzfpVar2.zzd();
                        iC = a.c(iZzd10, iZzd10, iZzy14, iC);
                    }
                    break;
                case 62:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iC = a.C(zzm(obj, j6), zzfx.zzy(i11 << 3), iC);
                    }
                    break;
                case 63:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        long jZzm2 = zzm(obj, j6);
                        iZzy6 = zzfx.zzy(i11 << 3);
                        iZzz2 = zzfx.zzz(jZzm2);
                        iC += iZzz2 + iZzy6;
                    }
                    break;
                case 64:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iC = a.C(i11 << 3, 4, iC);
                    }
                    break;
                case 65:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iC = a.C(i11 << 3, 8, iC);
                    }
                    break;
                case 66:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        int iZzm = zzm(obj, j6);
                        iC = a.C((iZzm >> 31) ^ (iZzm + iZzm), zzfx.zzy(i11 << 3), iC);
                    }
                    break;
                case 67:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        long jZzr3 = zzr(obj, j6);
                        iZzy6 = zzfx.zzy(i11 << 3);
                        iZzz2 = zzfx.zzz((jZzr3 >> 63) ^ (jZzr3 + jZzr3));
                        iC += iZzz2 + iZzy6;
                    }
                    break;
                case 68:
                    if (zzhuVar.zzM(obj, i11, i7)) {
                        iZza = zzic.zza(i11, (zzhr) unsafe.getObject(obj, j6), zzhuVar.zzt(i7));
                        iC += iZza;
                    }
                    break;
            }
            i7 += 3;
            i6 = 1048575;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final int zzb(Object obj) {
        int i5;
        long jDoubleToLongBits;
        int i6;
        int iFloatToIntBits;
        int iZzc;
        int i7;
        int iHashCode = 0;
        for (int i8 = 0; i8 < this.zzc.length; i8 += 3) {
            int iZzq = zzq(i8);
            int iZzp = zzp(iZzq);
            if (iZzp <= 50 || iZzp >= 69) {
                long j6 = iZzq & 1048575;
                int iHashCode2 = 37;
                switch (iZzp) {
                    case 0:
                        i5 = iHashCode * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzix.zza(obj, j6));
                        byte[] bArr = zzgv.zza;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i5 + iZzc;
                        break;
                    case 1:
                        i6 = iHashCode * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzix.zzb(obj, j6));
                        iHashCode = i6 + iFloatToIntBits;
                        break;
                    case 2:
                        i5 = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j6);
                        byte[] bArr2 = zzgv.zza;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i5 + iZzc;
                        break;
                    case 3:
                        i5 = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j6);
                        byte[] bArr3 = zzgv.zza;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i5 + iZzc;
                        break;
                    case 4:
                        i5 = iHashCode * 53;
                        iZzc = zzix.zzc(obj, j6);
                        iHashCode = i5 + iZzc;
                        break;
                    case 5:
                        i5 = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j6);
                        byte[] bArr4 = zzgv.zza;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i5 + iZzc;
                        break;
                    case 6:
                        i5 = iHashCode * 53;
                        iZzc = zzix.zzc(obj, j6);
                        iHashCode = i5 + iZzc;
                        break;
                    case 7:
                        i6 = iHashCode * 53;
                        iFloatToIntBits = zzgv.zza(zzix.zzt(obj, j6));
                        iHashCode = i6 + iFloatToIntBits;
                        break;
                    case 8:
                        i6 = iHashCode * 53;
                        iFloatToIntBits = ((String) zzix.zzf(obj, j6)).hashCode();
                        iHashCode = i6 + iFloatToIntBits;
                        break;
                    case 9:
                        i7 = iHashCode * 53;
                        Object objZzf = zzix.zzf(obj, j6);
                        if (objZzf != null) {
                            iHashCode2 = objZzf.hashCode();
                        }
                        iHashCode = i7 + iHashCode2;
                        break;
                    case 10:
                        i6 = iHashCode * 53;
                        iFloatToIntBits = zzix.zzf(obj, j6).hashCode();
                        iHashCode = i6 + iFloatToIntBits;
                        break;
                    case 11:
                        i5 = iHashCode * 53;
                        iZzc = zzix.zzc(obj, j6);
                        iHashCode = i5 + iZzc;
                        break;
                    case 12:
                        i5 = iHashCode * 53;
                        iZzc = zzix.zzc(obj, j6);
                        iHashCode = i5 + iZzc;
                        break;
                    case 13:
                        i5 = iHashCode * 53;
                        iZzc = zzix.zzc(obj, j6);
                        iHashCode = i5 + iZzc;
                        break;
                    case 14:
                        i5 = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j6);
                        byte[] bArr5 = zzgv.zza;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i5 + iZzc;
                        break;
                    case 15:
                        i5 = iHashCode * 53;
                        iZzc = zzix.zzc(obj, j6);
                        iHashCode = i5 + iZzc;
                        break;
                    case 16:
                        i5 = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j6);
                        byte[] bArr6 = zzgv.zza;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i5 + iZzc;
                        break;
                    case 17:
                        i7 = iHashCode * 53;
                        Object objZzf2 = zzix.zzf(obj, j6);
                        if (objZzf2 != null) {
                            iHashCode2 = objZzf2.hashCode();
                        }
                        iHashCode = i7 + iHashCode2;
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
                        i6 = iHashCode * 53;
                        iFloatToIntBits = zzix.zzf(obj, j6).hashCode();
                        iHashCode = i6 + iFloatToIntBits;
                        break;
                    case 50:
                        i6 = iHashCode * 53;
                        iFloatToIntBits = zzix.zzf(obj, j6).hashCode();
                        iHashCode = i6 + iFloatToIntBits;
                        break;
                }
            }
        }
        int i9 = this.zzk;
        while (true) {
            int[] iArr = this.zzi;
            if (i9 >= iArr.length) {
                int iHashCode3 = ((zzgp) obj).zzc.hashCode() + (iHashCode * 53);
                return this.zzh ? (iHashCode3 * 53) + ((zzgm) obj).zzb.zza.hashCode() : iHashCode3;
            }
            int i10 = iArr[i9];
            if (!zzM(obj, 0, i10)) {
                iHashCode = zzix.zzf(obj, zzq(i10) & 1048575).hashCode() + (iHashCode * 53);
            }
            i9++;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 41141. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.play_billing.zzfd r39) {
        /*
            Method dump skipped, instruction units count: 4114
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzhu.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzfd):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final Object zze() {
        return ((zzgp) this.zzg).zzs();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzf(Object obj) {
        if (zzK(obj)) {
            if (obj instanceof zzgp) {
                zzgp zzgpVar = (zzgp) obj;
                zzgpVar.zzC(Integer.MAX_VALUE);
                zzgpVar.zza = 0;
                zzgpVar.zzA();
            }
            int[] iArr = this.zzc;
            for (int i5 = 0; i5 < iArr.length; i5 += 3) {
                int iZzq = zzq(i5);
                int i6 = 1048575 & iZzq;
                int iZzp = zzp(iZzq);
                long j6 = i6;
                if (iZzp != 9) {
                    if (iZzp != 60 && iZzp != 68) {
                        switch (iZzp) {
                            case 17:
                                if (zzH(obj, i5)) {
                                    zzt(i5).zzf(zzb.getObject(obj, j6));
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
                                ((zzgu) zzix.zzf(obj, j6)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j6);
                                if (object != null) {
                                    ((zzhm) object).zzc();
                                    unsafe.putObject(obj, j6, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, iArr[i5], i5)) {
                        zzt(i5).zzf(zzb.getObject(obj, j6));
                    }
                } else if (zzH(obj, i5)) {
                    zzt(i5).zzf(zzb.getObject(obj, j6));
                }
            }
            ((zzgp) obj).zzc.zzh();
            if (this.zzh) {
                ((zzgm) obj).zzb.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzg(Object obj, Object obj2) {
        zzz(obj);
        obj2.getClass();
        int i5 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i5 >= iArr.length) {
                zzic.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzic.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int iZzq = zzq(i5);
            int i6 = 1048575 & iZzq;
            int iZzp = zzp(iZzq);
            int i7 = iArr[i5];
            long j6 = i6;
            switch (iZzp) {
                case 0:
                    if (zzH(obj2, i5)) {
                        zzix.zzl(obj, j6, zzix.zza(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 1:
                    if (zzH(obj2, i5)) {
                        zzix.zzm(obj, j6, zzix.zzb(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 2:
                    if (zzH(obj2, i5)) {
                        zzix.zzo(obj, j6, zzix.zzd(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 3:
                    if (zzH(obj2, i5)) {
                        zzix.zzo(obj, j6, zzix.zzd(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 4:
                    if (zzH(obj2, i5)) {
                        zzix.zzn(obj, j6, zzix.zzc(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 5:
                    if (zzH(obj2, i5)) {
                        zzix.zzo(obj, j6, zzix.zzd(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 6:
                    if (zzH(obj2, i5)) {
                        zzix.zzn(obj, j6, zzix.zzc(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 7:
                    if (zzH(obj2, i5)) {
                        zzix.zzk(obj, j6, zzix.zzt(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 8:
                    if (zzH(obj2, i5)) {
                        zzix.zzp(obj, j6, zzix.zzf(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 9:
                    zzA(obj, obj2, i5);
                    break;
                case 10:
                    if (zzH(obj2, i5)) {
                        zzix.zzp(obj, j6, zzix.zzf(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 11:
                    if (zzH(obj2, i5)) {
                        zzix.zzn(obj, j6, zzix.zzc(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 12:
                    if (zzH(obj2, i5)) {
                        zzix.zzn(obj, j6, zzix.zzc(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 13:
                    if (zzH(obj2, i5)) {
                        zzix.zzn(obj, j6, zzix.zzc(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 14:
                    if (zzH(obj2, i5)) {
                        zzix.zzo(obj, j6, zzix.zzd(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 15:
                    if (zzH(obj2, i5)) {
                        zzix.zzn(obj, j6, zzix.zzc(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 16:
                    if (zzH(obj2, i5)) {
                        zzix.zzo(obj, j6, zzix.zzd(obj2, j6));
                        zzC(obj, i5);
                    }
                    break;
                case 17:
                    zzA(obj, obj2, i5);
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
                    zzgu zzguVarZzd = (zzgu) zzix.zzf(obj, j6);
                    zzgu zzguVar = (zzgu) zzix.zzf(obj2, j6);
                    int size = zzguVarZzd.size();
                    int size2 = zzguVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzguVarZzd.zzc()) {
                            zzguVarZzd = zzguVarZzd.zzd(size2 + size);
                        }
                        zzguVarZzd.addAll(zzguVar);
                    }
                    if (size > 0) {
                        zzguVar = zzguVarZzd;
                    }
                    zzix.zzp(obj, j6, zzguVar);
                    break;
                case 50:
                    int i8 = zzic.zza;
                    zzix.zzp(obj, j6, zzhn.zza(zzix.zzf(obj, j6), zzix.zzf(obj2, j6)));
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
                        zzix.zzp(obj, j6, zzix.zzf(obj2, j6));
                        zzD(obj, i7, i5);
                    }
                    break;
                case 60:
                    zzB(obj, obj2, i5);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i7, i5)) {
                        zzix.zzp(obj, j6, zzix.zzf(obj2, j6));
                        zzD(obj, i7, i5);
                    }
                    break;
                case 68:
                    zzB(obj, obj2, i5);
                    break;
            }
            i5 += 3;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzh(Object obj, byte[] bArr, int i5, int i6, zzfd zzfdVar) {
        zzc(obj, bArr, i5, i6, 0, zzfdVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzi(Object obj, zzji zzjiVar) {
        Map.Entry entry;
        int i5;
        zzhu<T> zzhuVar = this;
        if (zzhuVar.zzh) {
            zzgh zzghVar = ((zzgm) obj).zzb;
            if (zzghVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzghVar.zzf().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = zzhuVar.zzc;
        Unsafe unsafe = zzb;
        int i6 = 1048575;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i8 < iArr.length) {
            int iZzq = zzhuVar.zzq(i8);
            int iZzp = zzp(iZzq);
            int i10 = iArr[i8];
            if (iZzp <= 17) {
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
            long j6 = iZzq & i6;
            switch (iZzp) {
                case 0:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzf(i10, zzix.zza(obj, j6));
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 1:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzo(i10, zzix.zzb(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 2:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzt(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 3:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzL(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 4:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzr(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 5:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzm(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 6:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzk(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 7:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzb(i10, zzix.zzt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 8:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzP(i10, unsafe.getObject(obj, j6), zzjiVar);
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 9:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzw(i10, unsafe.getObject(obj, j6), zzhuVar.zzt(i8));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 10:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzd(i10, (zzfp) unsafe.getObject(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 11:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzJ(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 12:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzi(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 13:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzy(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 14:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzA(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 15:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzC(i10, unsafe.getInt(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 16:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzE(i10, unsafe.getLong(obj, j6));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 17:
                    if (zzhuVar.zzI(obj, i8, i7, i9, i5)) {
                        zzjiVar.zzq(i10, unsafe.getObject(obj, j6), zzhuVar.zzt(i8));
                    } else {
                        continue;
                    }
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 18:
                    zzic.zzr(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 19:
                    zzic.zzv(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 20:
                    zzic.zzx(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 21:
                    zzic.zzD(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 22:
                    zzic.zzw(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 23:
                    zzic.zzu(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 24:
                    zzic.zzt(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 25:
                    zzic.zzq(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 26:
                    int i13 = iArr[i8];
                    List list = (List) unsafe.getObject(obj, j6);
                    int i14 = zzic.zza;
                    if (list != null && !list.isEmpty()) {
                        zzjiVar.zzI(i13, list);
                    }
                    break;
                case 27:
                    int i15 = iArr[i8];
                    List list2 = (List) unsafe.getObject(obj, j6);
                    zzib zzibVarZzt = zzhuVar.zzt(i8);
                    int i16 = zzic.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i17 = 0; i17 < list2.size(); i17++) {
                            ((zzfy) zzjiVar).zzw(i15, list2.get(i17), zzibVarZzt);
                        }
                    }
                    break;
                case 28:
                    int i18 = iArr[i8];
                    List list3 = (List) unsafe.getObject(obj, j6);
                    int i19 = zzic.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzjiVar.zze(i18, list3);
                    }
                    break;
                case 29:
                    zzic.zzC(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 30:
                    zzic.zzs(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 31:
                    zzic.zzy(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 32:
                    zzic.zzz(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 33:
                    zzic.zzA(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 34:
                    zzic.zzB(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, false);
                    continue;
                    i8 += 3;
                    i6 = 1048575;
                    zzhuVar = this;
                    break;
                case 35:
                    zzic.zzr(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 36:
                    zzic.zzv(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 37:
                    zzic.zzx(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 38:
                    zzic.zzD(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 39:
                    zzic.zzw(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 40:
                    zzic.zzu(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 41:
                    zzic.zzt(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 42:
                    zzic.zzq(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 43:
                    zzic.zzC(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 44:
                    zzic.zzs(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 45:
                    zzic.zzy(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 46:
                    zzic.zzz(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 47:
                    zzic.zzA(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 48:
                    zzic.zzB(iArr[i8], (List) unsafe.getObject(obj, j6), zzjiVar, true);
                    break;
                case 49:
                    int i20 = iArr[i8];
                    List list4 = (List) unsafe.getObject(obj, j6);
                    zzib zzibVarZzt2 = zzhuVar.zzt(i8);
                    int i21 = zzic.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i22 = 0; i22 < list4.size(); i22++) {
                            ((zzfy) zzjiVar).zzq(i20, list4.get(i22), zzibVarZzt2);
                        }
                    }
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j6);
                    if (object != null) {
                        zzjiVar.zzv(i10, ((zzhl) zzhuVar.zzv(i8)).zzc(), (zzhm) object);
                    }
                    break;
                case 51:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzf(i10, ((Double) zzix.zzf(obj, j6)).doubleValue());
                    }
                    break;
                case 52:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzo(i10, ((Float) zzix.zzf(obj, j6)).floatValue());
                    }
                    break;
                case 53:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzt(i10, zzr(obj, j6));
                    }
                    break;
                case 54:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzL(i10, zzr(obj, j6));
                    }
                    break;
                case 55:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzr(i10, zzm(obj, j6));
                    }
                    break;
                case 56:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzm(i10, zzr(obj, j6));
                    }
                    break;
                case 57:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzk(i10, zzm(obj, j6));
                    }
                    break;
                case 58:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzb(i10, ((Boolean) zzix.zzf(obj, j6)).booleanValue());
                    }
                    break;
                case 59:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzP(i10, unsafe.getObject(obj, j6), zzjiVar);
                    }
                    break;
                case 60:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzw(i10, unsafe.getObject(obj, j6), zzhuVar.zzt(i8));
                    }
                    break;
                case 61:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzd(i10, (zzfp) unsafe.getObject(obj, j6));
                    }
                    break;
                case 62:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzJ(i10, zzm(obj, j6));
                    }
                    break;
                case 63:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzi(i10, zzm(obj, j6));
                    }
                    break;
                case 64:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzy(i10, zzm(obj, j6));
                    }
                    break;
                case 65:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzA(i10, zzr(obj, j6));
                    }
                    break;
                case 66:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzC(i10, zzm(obj, j6));
                    }
                    break;
                case 67:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzE(i10, zzr(obj, j6));
                    }
                    break;
                case 68:
                    if (zzhuVar.zzM(obj, i10, i8)) {
                        zzjiVar.zzq(i10, unsafe.getObject(obj, j6), zzhuVar.zzt(i8));
                    }
                    break;
            }
            i8 += 3;
            i6 = 1048575;
            zzhuVar = this;
        }
        if (entry != null) {
            throw null;
        }
        ((zzgp) obj).zzc.zzl(zzjiVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int iZzq = zzq(i5);
            int iZzp = zzp(iZzq);
            if (iZzp <= 50 || iZzp >= 69) {
                long j6 = iZzq & 1048575;
                switch (iZzp) {
                    case 0:
                        if (!zzG(obj, obj2, i5) || Double.doubleToLongBits(zzix.zza(obj, j6)) != Double.doubleToLongBits(zzix.zza(obj2, j6))) {
                            return false;
                        }
                        continue;
                        break;
                    case 1:
                        if (!zzG(obj, obj2, i5) || Float.floatToIntBits(zzix.zzb(obj, j6)) != Float.floatToIntBits(zzix.zzb(obj2, j6))) {
                            return false;
                        }
                        continue;
                        break;
                    case 2:
                        if (!zzG(obj, obj2, i5) || zzix.zzd(obj, j6) != zzix.zzd(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 3:
                        if (!zzG(obj, obj2, i5) || zzix.zzd(obj, j6) != zzix.zzd(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 4:
                        if (!zzG(obj, obj2, i5) || zzix.zzc(obj, j6) != zzix.zzc(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 5:
                        if (!zzG(obj, obj2, i5) || zzix.zzd(obj, j6) != zzix.zzd(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 6:
                        if (!zzG(obj, obj2, i5) || zzix.zzc(obj, j6) != zzix.zzc(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 7:
                        if (!zzG(obj, obj2, i5) || zzix.zzt(obj, j6) != zzix.zzt(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 8:
                        if (!zzG(obj, obj2, i5) || !zzic.zzE(zzix.zzf(obj, j6), zzix.zzf(obj2, j6))) {
                            return false;
                        }
                        continue;
                        break;
                    case 9:
                        if (!zzG(obj, obj2, i5) || !zzic.zzE(zzix.zzf(obj, j6), zzix.zzf(obj2, j6))) {
                            return false;
                        }
                        continue;
                        break;
                    case 10:
                        if (!zzG(obj, obj2, i5) || !zzic.zzE(zzix.zzf(obj, j6), zzix.zzf(obj2, j6))) {
                            return false;
                        }
                        continue;
                        break;
                    case 11:
                        if (!zzG(obj, obj2, i5) || zzix.zzc(obj, j6) != zzix.zzc(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 12:
                        if (!zzG(obj, obj2, i5) || zzix.zzc(obj, j6) != zzix.zzc(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 13:
                        if (!zzG(obj, obj2, i5) || zzix.zzc(obj, j6) != zzix.zzc(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 14:
                        if (!zzG(obj, obj2, i5) || zzix.zzd(obj, j6) != zzix.zzd(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 15:
                        if (!zzG(obj, obj2, i5) || zzix.zzc(obj, j6) != zzix.zzc(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 16:
                        if (!zzG(obj, obj2, i5) || zzix.zzd(obj, j6) != zzix.zzd(obj2, j6)) {
                            return false;
                        }
                        continue;
                        break;
                    case 17:
                        if (!zzG(obj, obj2, i5) || !zzic.zzE(zzix.zzf(obj, j6), zzix.zzf(obj2, j6))) {
                            return false;
                        }
                        continue;
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
                        zZzE = zzic.zzE(zzix.zzf(obj, j6), zzix.zzf(obj2, j6));
                        break;
                    case 50:
                        zZzE = zzic.zzE(zzix.zzf(obj, j6), zzix.zzf(obj2, j6));
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
                        if (!zzL(obj, obj2, i5) || !zzic.zzE(zzix.zzf(obj, j6), zzix.zzf(obj2, j6))) {
                            return false;
                        }
                        continue;
                        break;
                    default:
                        continue;
                }
                if (!zZzE) {
                    return false;
                }
            }
        }
        int i6 = this.zzk;
        while (true) {
            int[] iArr = this.zzi;
            if (i6 >= iArr.length) {
                if (!((zzgp) obj).zzc.equals(((zzgp) obj2).zzc)) {
                    return false;
                }
                if (this.zzh) {
                    return ((zzgm) obj).zzb.equals(((zzgm) obj2).zzb);
                }
                return true;
            }
            int i7 = iArr[i6];
            if (!zzL(obj, obj2, i7)) {
                return false;
            }
            if (!zzM(obj, 0, i7)) {
                long jZzq = zzq(i7) & 1048575;
                if (!zzic.zzE(zzix.zzf(obj, jZzq), zzix.zzf(obj2, jZzq))) {
                    return false;
                }
            }
            i6++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00be  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e3 A[LOOP:2: B:52:0x00d2->B:57:0x00e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00f7 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzib
    public final boolean zzk(Object obj) {
        int i5;
        int i6;
        List list;
        zzib zzibVarZzt;
        int i7;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i8 < this.zzj) {
            int i11 = this.zzi[i8];
            int iZzq = zzq(i11);
            int[] iArr = this.zzc;
            int i12 = iArr[i11 + 2];
            int i13 = i12 & 1048575;
            int i14 = 1 << (i12 >>> 20);
            if (i13 != i10) {
                if (i13 != 1048575) {
                    i9 = zzb.getInt(obj, i13);
                }
                i6 = i9;
                i5 = i13;
            } else {
                i5 = i10;
                i6 = i9;
            }
            Object obj2 = obj;
            if ((268435456 & iZzq) != 0 && !zzI(obj2, i11, i5, i6, i14)) {
                return false;
            }
            int iZzp = zzp(iZzq);
            if (iZzp == 9 || iZzp == 17) {
                if (zzI(obj2, i11, i5, i6, i14) && !zzJ(obj2, iZzq, zzt(i11))) {
                    return false;
                }
            } else if (iZzp == 27) {
                list = (List) zzix.zzf(obj2, iZzq & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzibVarZzt = zzt(i11);
                    for (i7 = 0; i7 < list.size(); i7++) {
                        if (!zzibVarZzt.zzk(list.get(i7))) {
                            return false;
                        }
                    }
                }
            } else if (iZzp == 60 || iZzp == 68) {
                if (zzM(obj2, iArr[i11], i11) && !zzJ(obj2, iZzq, zzt(i11))) {
                    return false;
                }
            } else if (iZzp == 49) {
                list = (List) zzix.zzf(obj2, iZzq & 1048575);
                if (list.isEmpty()) {
                    zzibVarZzt = zzt(i11);
                    while (i7 < list.size()) {
                        if (!zzibVarZzt.zzk(list.get(i7))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzp != 50) {
                continue;
            } else {
                zzhm zzhmVar = (zzhm) zzix.zzf(obj2, iZzq & 1048575);
                if (!zzhmVar.isEmpty() && ((zzhl) zzv(i11)).zzc().zzc.zzb() == zzjh.MESSAGE) {
                    zzib zzibVarZzb = null;
                    for (Object obj3 : zzhmVar.values()) {
                        if (zzibVarZzb == null) {
                            zzibVarZzb = zzhy.zza().zzb(obj3.getClass());
                        }
                        if (!zzibVarZzb.zzk(obj3)) {
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
        return !this.zzh || ((zzgm) obj).zzb.zzj();
    }
}
