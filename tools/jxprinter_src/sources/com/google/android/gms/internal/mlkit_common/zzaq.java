package com.google.android.gms.internal.mlkit_common;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaq extends zzai {
    static final zzai zza = new zzaq(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzaq(Object obj, Object[] objArr, int i5) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i5;
    }

    /* JADX WARN: Code duplicated, block: B:81:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ee  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    public static zzaq zzg(int i5, Object[] objArr, zzah zzahVar) {
        int iHighestOneBit;
        boolean z6;
        int i6;
        char c;
        ?? r6;
        char c6;
        short[] sArr;
        boolean z7;
        int i7;
        ?? r16;
        boolean z8;
        ?? r7;
        Object[] objArr2;
        zzag zzagVar;
        boolean z9;
        int i8 = i5;
        Object[] objArrCopyOf = objArr;
        if (i8 == 0) {
            return (zzaq) zza;
        }
        zzag zzagVar2 = null;
        ?? r8 = 0;
        zzag zzagVar3 = null;
        zzag zzagVar4 = null;
        boolean z10 = false;
        int i9 = 1;
        if (i8 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            zzw.zza(obj, obj2);
            return new zzaq(null, objArrCopyOf, 1);
        }
        zzt.zzb(i8, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        char c7 = 2;
        int iMax = Math.max(i8, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i8 != 1) {
            int i10 = iHighestOneBit - 1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i11 = 0;
                int i12 = 0;
                while (i11 < i8) {
                    int i13 = i12 + i12;
                    int i14 = i11 + i11;
                    Object obj3 = objArrCopyOf[i14];
                    Objects.requireNonNull(obj3);
                    Object obj4 = objArrCopyOf[i14 ^ i9];
                    Objects.requireNonNull(obj4);
                    zzw.zza(obj3, obj4);
                    int iZza = zzy.zza(obj3.hashCode());
                    while (true) {
                        int i15 = iZza & i10;
                        z7 = z10;
                        i7 = i9;
                        int i16 = bArr[i15] & UnsignedBytes.MAX_VALUE;
                        if (i16 == 255) {
                            bArr[i15] = (byte) i13;
                            if (i12 < i11) {
                                objArrCopyOf[i13] = obj3;
                                objArrCopyOf[i13 ^ 1] = obj4;
                            }
                            i12++;
                            break;
                        }
                        if (obj3.equals(objArrCopyOf[i16 == true ? 1 : 0])) {
                            int i17 = ~i16;
                            Object obj5 = objArrCopyOf[i17 == true ? 1 : 0];
                            Objects.requireNonNull(obj5);
                            zzag zzagVar5 = new zzag(obj3, obj4, obj5);
                            objArrCopyOf[i17 == true ? 1 : 0] = obj4;
                            zzagVar3 = zzagVar5;
                            break;
                        }
                        iZza = i15 + 1;
                        z10 = z7;
                        i9 = i7;
                    }
                    i11++;
                    z10 = z7;
                    i9 = i7;
                }
                z6 = z10;
                i6 = i9;
                if (i12 == i8) {
                    c = 2;
                    r6 = bArr;
                    r16 = z6;
                } else {
                    sArr = new Object[3];
                    sArr[z6 ? 1 : 0] = bArr;
                    sArr[i6] = Integer.valueOf(i12);
                    sArr[2] = zzagVar3;
                    r8 = sArr;
                    z9 = z6;
                }
            } else {
                z6 = false;
                i6 = 1;
                if (iHighestOneBit <= 32768) {
                    sArr = new short[iHighestOneBit];
                    Arrays.fill(sArr, (short) -1);
                    int i18 = 0;
                    for (int i19 = 0; i19 < i8; i19++) {
                        int i20 = i18 + i18;
                        int i21 = i19 + i19;
                        Object obj6 = objArrCopyOf[i21];
                        Objects.requireNonNull(obj6);
                        Object obj7 = objArrCopyOf[i21 ^ 1];
                        Objects.requireNonNull(obj7);
                        zzw.zza(obj6, obj7);
                        int iZza2 = zzy.zza(obj6.hashCode());
                        while (true) {
                            int i22 = iZza2 & i10;
                            char c8 = (char) sArr[i22];
                            if (c8 == 65535) {
                                sArr[i22] = (short) i20;
                                if (i18 < i19) {
                                    objArrCopyOf[i20] = obj6;
                                    objArrCopyOf[i20 ^ 1] = obj7;
                                }
                                i18++;
                                break;
                            }
                            if (obj6.equals(objArrCopyOf[c8])) {
                                int i23 = c8 ^ 1;
                                Object obj8 = objArrCopyOf[i23 == true ? 1 : 0];
                                Objects.requireNonNull(obj8);
                                zzag zzagVar6 = new zzag(obj6, obj7, obj8);
                                objArrCopyOf[i23 == true ? 1 : 0] = obj7;
                                zzagVar4 = zzagVar6;
                                break;
                            }
                            iZza2 = i22 + 1;
                        }
                    }
                    if (i18 == i8) {
                        r8 = sArr;
                        z9 = z6;
                    } else {
                        r8 = new Object[]{sArr, Integer.valueOf(i18), zzagVar4};
                        z9 = z6;
                    }
                } else {
                    int[] iArr = new int[iHighestOneBit];
                    Arrays.fill(iArr, -1);
                    int i24 = 0;
                    int i25 = 0;
                    while (i24 < i8) {
                        int i26 = i25 + i25;
                        int i27 = i24 + i24;
                        Object obj9 = objArrCopyOf[i27];
                        Objects.requireNonNull(obj9);
                        Object obj10 = objArrCopyOf[i27 ^ 1];
                        Objects.requireNonNull(obj10);
                        zzw.zza(obj9, obj10);
                        int iZza3 = zzy.zza(obj9.hashCode());
                        while (true) {
                            int i28 = iZza3 & i10;
                            int i29 = iArr[i28];
                            if (i29 == -1) {
                                iArr[i28] = i26;
                                if (i25 < i24) {
                                    objArrCopyOf[i26] = obj9;
                                    objArrCopyOf[i26 ^ 1] = obj10;
                                }
                                i25++;
                                c6 = c7;
                                break;
                            }
                            c6 = c7;
                            if (obj9.equals(objArrCopyOf[i29])) {
                                int i30 = i29 ^ 1;
                                Object obj11 = objArrCopyOf[i30];
                                Objects.requireNonNull(obj11);
                                zzag zzagVar7 = new zzag(obj9, obj10, obj11);
                                objArrCopyOf[i30] = obj10;
                                zzagVar2 = zzagVar7;
                                break;
                            }
                            iZza3 = i28 + 1;
                            c7 = c6;
                        }
                        i24++;
                        c7 = c6;
                    }
                    c = c7;
                    if (i25 == i8) {
                        r6 = iArr;
                        r16 = z6;
                    } else {
                        Object[] objArr3 = new Object[3];
                        objArr3[0] = iArr;
                        objArr3[1] = Integer.valueOf(i25);
                        objArr3[c] = zzagVar2;
                        r6 = objArr3;
                        r16 = z6;
                    }
                }
            }
            z8 = r6 instanceof Object[];
            r7 = r6;
            if (z8) {
                objArr2 = (Object[]) r6;
                zzagVar = (zzag) objArr2[c];
                if (zzahVar != null) {
                    throw zzagVar.zza();
                }
                zzahVar.zzc = zzagVar;
                Object obj12 = objArr2[r16];
                int iIntValue = ((Integer) objArr2[i6]).intValue();
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
                r7 = obj12;
                i8 = iIntValue;
            }
            return new zzaq(r7, objArrCopyOf, i8);
        }
        Object obj13 = objArrCopyOf[0];
        Objects.requireNonNull(obj13);
        Object obj14 = objArrCopyOf[1];
        Objects.requireNonNull(obj14);
        zzw.zza(obj13, obj14);
        z9 = false;
        i8 = 1;
        i6 = 1;
        c = 2;
        r6 = r8;
        r16 = z9;
        z8 = r6 instanceof Object[];
        r7 = r6;
        if (z8) {
            objArr2 = (Object[]) r6;
            zzagVar = (zzag) objArr2[c];
            if (zzahVar != null) {
                throw zzagVar.zza();
            }
            zzahVar.zzc = zzagVar;
            Object obj15 = objArr2[r16];
            int iIntValue2 = ((Integer) objArr2[i6]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue2 + iIntValue2);
            r7 = obj15;
            i8 = iIntValue2;
        }
        return new zzaq(r7, objArrCopyOf, i8);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.mlkit_common.zzai, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i5 = this.zzd;
            Object[] objArr = this.zzb;
            if (i5 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                } else {
                    obj2 = null;
                }
            } else {
                Object obj4 = this.zzc;
                if (obj4 == null) {
                    obj2 = null;
                } else if (obj4 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj4;
                    int length = bArr.length - 1;
                    int iZza = zzy.zza(obj.hashCode());
                    while (true) {
                        int i6 = iZza & length;
                        int i7 = bArr[i6] & UnsignedBytes.MAX_VALUE;
                        if (i7 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i7])) {
                            obj2 = objArr[i7 ^ 1];
                        } else {
                            iZza = i6 + 1;
                        }
                    }
                    obj2 = null;
                } else if (obj4 instanceof short[]) {
                    short[] sArr = (short[]) obj4;
                    int length2 = sArr.length - 1;
                    int iZza2 = zzy.zza(obj.hashCode());
                    while (true) {
                        int i8 = iZza2 & length2;
                        char c = (char) sArr[i8];
                        if (c == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c])) {
                            obj2 = objArr[c ^ 1];
                        } else {
                            iZza2 = i8 + 1;
                        }
                    }
                    obj2 = null;
                } else {
                    int[] iArr = (int[]) obj4;
                    int length3 = iArr.length - 1;
                    int iZza3 = zzy.zza(obj.hashCode());
                    while (true) {
                        int i9 = iZza3 & length3;
                        int i10 = iArr[i9];
                        if (i10 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i10])) {
                            obj2 = objArr[i10 ^ 1];
                        } else {
                            iZza3 = i9 + 1;
                        }
                    }
                    obj2 = null;
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    public final zzab zza() {
        return new zzap(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    public final zzaj zzd() {
        return new zzan(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    public final zzaj zze() {
        return new zzao(this, new zzap(this.zzb, 0, this.zzd));
    }
}
