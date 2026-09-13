package org.apache.poi.xdgf.geom;

import A3.AbstractC0157z;
import S1.d;
import S1.e;
import S1.f;
import S1.g;
import S1.h;
import S1.i;
import S1.k;
import S1.l;
import U1.j;
import V1.a;
import V1.b;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SplineRenderer {
    /* JADX WARN: Code duplicated, block: B:141:0x046b  */
    /* JADX WARN: Code duplicated, block: B:144:0x048b  */
    /* JADX WARN: Code duplicated, block: B:167:0x0528  */
    /* JADX WARN: Code duplicated, block: B:171:0x053a  */
    /* JADX WARN: Code duplicated, block: B:173:0x054a  */
    /* JADX WARN: Code duplicated, block: B:175:0x054e  */
    /* JADX WARN: Code duplicated, block: B:176:0x055c  */
    /* JADX WARN: Code duplicated, block: B:180:0x0582  */
    /* JADX WARN: Code duplicated, block: B:213:0x0536 A[SYNTHETIC] */
    public static k createNurbsSpline(d dVar, l lVar, l lVar2, int i5) {
        double d;
        double d6;
        char c;
        int i6;
        int i7;
        double d7;
        double d8;
        int length;
        int i8;
        int i9;
        int i10;
        double[][] dArrB;
        double[] dArr;
        double[][] dArr2;
        double[] dArr3;
        int i11;
        double d9;
        double[][] dArr4;
        double[][] dArrB2;
        int i12;
        Object obj;
        int i13;
        double[] dArr5;
        int i14;
        double dB = lVar.b(0);
        int i15 = lVar.f633a;
        double dB2 = lVar.b(i15 - 1);
        int i16 = 0;
        while (true) {
            String str = ")";
            if (i16 >= i15) {
                int i17 = dVar.f621a.f6115a + i5 + 1;
                while (true) {
                    d = 1.0d;
                    if (i15 >= i17) {
                        break;
                    }
                    lVar.a(1.0d);
                    i15++;
                }
                int i18 = dVar.f621a.f6115a;
                f fVar = new f();
                fVar.c = null;
                fVar.f623a = 0;
                fVar.b = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 1;
                while (true) {
                    d6 = d;
                    c = ',';
                    i6 = 5;
                    if (i19 >= 5) {
                        break;
                    }
                    char cCharAt = "0:n-1".charAt(i19);
                    if (cCharAt == ',' && i20 == 0) {
                        i21++;
                    } else if (cCharAt == '(') {
                        i20++;
                    } else if (cCharAt == ')') {
                        i20--;
                    }
                    i19++;
                    d = d6;
                }
                if (i20 != 0) {
                    e eVar = new e();
                    eVar.b = -1;
                    eVar.c = -1;
                    eVar.d = null;
                    eVar.f622a = "round brackets do not balance";
                    throw eVar;
                }
                int[] iArr = new int[i21 * 2];
                j jVar = new j();
                jVar.b = new String[2];
                jVar.c = new double[2];
                jVar.d = 0;
                jVar.f712a = true;
                int i22 = 1;
                U1.d dVar2 = new U1.d(0);
                dVar2.c = new String[50];
                dVar2.d = new a[50];
                dVar2.b = 0;
                dVar2.e("min", new P2.a(24));
                dVar2.e("max", new P2.a(23));
                dVar2.e("sum", new b(4));
                dVar2.e("avg", new P2.a(12));
                dVar2.e("pi", new P2.a(26));
                dVar2.e("e", new P2.a(16));
                dVar2.e("rand", new P2.a(28));
                dVar2.e("sin", new b(1));
                dVar2.e("cos", new P2.a(14));
                dVar2.e("tan", new b(5));
                dVar2.e("sqrt", new b(3));
                dVar2.e("abs", new P2.a(5));
                dVar2.e("ceil", new P2.a(13));
                dVar2.e("floor", new P2.a(19));
                dVar2.e("exp", new P2.a(17));
                dVar2.e("lg", new P2.a(20));
                dVar2.e("ln", new P2.a(21));
                dVar2.e("sign", new b(0));
                dVar2.e("round", new P2.a(29));
                dVar2.e("fact", new P2.a(18));
                dVar2.e("cosh", new P2.a(15));
                dVar2.e("sinh", new b(2));
                dVar2.e("tanh", new b(6));
                dVar2.e("acos", new P2.a(6));
                dVar2.e("asin", new P2.a(8));
                dVar2.e("atan", new P2.a(10));
                dVar2.e("acosh", new P2.a(7));
                dVar2.e("asinh", new P2.a(9));
                dVar2.e("atanh", new P2.a(11));
                dVar2.e("pow", new P2.a(27));
                dVar2.e("mod", new P2.a(25));
                dVar2.e("combin", new p075n1.a(4));
                dVar2.e("log", new P2.a(22));
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                int i26 = -1;
                while (i23 <= i6) {
                    int i27 = i20;
                    char cCharAt2 = i23 < i6 ? "0:n-1".charAt(i23) : Chars.SPACE;
                    if (i23 == i6 || (cCharAt2 == c && i27 == 0)) {
                        if (i26 == -1) {
                            int iRound = (int) Math.round(f.b(jVar, i18, i24, i23).b(jVar, dVar2));
                            iArr[i25] = iRound;
                            iArr[i25 + 1] = iRound;
                            i25 += 2;
                        } else {
                            U1.b bVarB = f.b(jVar, i18, i24, i26);
                            int i28 = i25 + 1;
                            iArr[i25] = (int) Math.round(bVarB.b(jVar, dVar2));
                            i25 += 2;
                            iArr[i28] = (int) Math.round(f.b(jVar, i18, i26 + 1, i23).b(jVar, dVar2));
                        }
                        i24 = i23 + 1;
                        i26 = -1;
                    } else {
                        if (cCharAt2 == '(') {
                            i14 = i27 + 1;
                        } else if (cCharAt2 == ')') {
                            i14 = i27 - 1;
                        } else {
                            if (cCharAt2 == ':') {
                                i26 = i23;
                            }
                            str = str;
                        }
                        str = str;
                        i27 = i14;
                    }
                    i23++;
                    str = str;
                    i20 = i27;
                    c = ',';
                    i6 = 5;
                }
                String str2 = str;
                fVar.c = iArr;
                i iVar = new i(dVar, fVar);
                if (i5 <= 0) {
                    throw new IllegalArgumentException("Degree > 0 required.");
                }
                iVar.f618g = i5 + 1;
                iVar.f619h = 2;
                iVar.d = lVar;
                if (lVar2 == null) {
                    iVar.f631m = false;
                } else {
                    iVar.f630l = lVar2;
                }
                k kVar = new k();
                kVar.d = 0.01d;
                f fVar2 = iVar.b;
                int i29 = iVar.f632a.f621a.f6115a;
                int i30 = 0;
                while (true) {
                    int[] iArr2 = (int[]) fVar2.c;
                    if (i30 < iArr2.length) {
                        int i31 = iArr2[i30];
                        if (i31 < 0 || i31 >= i29) {
                            break;
                        }
                        i30++;
                    } else {
                        int iA = iVar.b.a();
                        h hVar = iVar.f629k;
                        if (hVar.f627a.length < iA) {
                            int i32 = iA * 2;
                            hVar.f627a = new double[i32];
                            hVar.b = new double[i32];
                        }
                        if (!iVar.f631m) {
                            for (int i33 = 0; i33 < iA; i33++) {
                                hVar.b[i33] = d6;
                            }
                        } else {
                            if (iVar.f630l.f633a != iA) {
                                throw new IllegalArgumentException("weightVector.size(" + iVar.f630l.f633a + ") != group iterator size(" + iA + str2);
                            }
                            for (int i34 = 0; i34 < iA; i34++) {
                                hVar.b[i34] = iVar.f630l.b(i34);
                                if (hVar.b[i34] < 0.0d) {
                                    throw new IllegalArgumentException("Negative weight not allowed");
                                }
                            }
                        }
                        f fVar3 = iVar.b;
                        int i35 = iVar.f632a.f621a.f6115a;
                        int i36 = 0;
                        while (true) {
                            int[] iArr3 = (int[]) fVar3.c;
                            if (i36 >= iArr3.length) {
                                int iA2 = iVar.b.a();
                                int i37 = iVar.f618g;
                                int i38 = iA2 - i37;
                                if (i38 < 0) {
                                    throw new IllegalArgumentException("group iterator size - degree < 0");
                                }
                                int i39 = iA2 + i37;
                                S1.b bVar = iVar.c;
                                if (bVar.c.length < i39) {
                                    bVar.c = new double[i39 * 2];
                                }
                                int i40 = iVar.f619h;
                                double d10 = iVar.e;
                                if (i40 != 2) {
                                    boolean z6 = iVar.f620i;
                                    if (i40 == 1) {
                                        double d11 = d6 / ((double) (i39 - 1));
                                        for (int i41 = 0; i41 < i39; i41++) {
                                            bVar.c[i41] = ((double) i41) * d11;
                                        }
                                        if (z6) {
                                            i22 = 1;
                                            d8 = ((double) (iVar.f618g - 1)) * d11;
                                            d7 = d6 - d8;
                                        } else {
                                            i22 = 1;
                                            d7 = d10;
                                            d8 = 0.0d;
                                        }
                                        d6 = d7;
                                    } else {
                                        i22 = 1;
                                        if (i40 == 0) {
                                            double d12 = d6 / ((double) (i38 + 1));
                                            int i42 = 0;
                                            while (true) {
                                                i7 = iVar.f618g;
                                                if (i42 >= i7) {
                                                    break;
                                                }
                                                bVar.c[i42] = 0.0d;
                                                i42++;
                                            }
                                            int i43 = 1;
                                            while (i43 <= i38) {
                                                bVar.c[i7] = ((double) i43) * d12;
                                                i43++;
                                                i7++;
                                            }
                                            while (i7 < i39) {
                                                bVar.c[i7] = d6;
                                                i7++;
                                            }
                                            if (!z6) {
                                            }
                                        }
                                        d8 = 0.0d;
                                    }
                                    length = bVar.f615a.length;
                                    i8 = iVar.f618g;
                                    if (length < i8) {
                                        int i44 = i8 * 2;
                                        bVar.f615a = new int[i44];
                                        bVar.b = new int[i44];
                                    }
                                    i9 = kVar.e;
                                    i10 = i9 + 1;
                                    double[] dArr6 = new double[i10];
                                    dArr6[i9] = d8;
                                    iVar.a(dArr6);
                                    kVar.a(dArr6, g.f624f);
                                    if (d8 <= d6) {
                                        throw new IllegalArgumentException("t_min <= t_max required.");
                                    }
                                    dArrB = new double[10][];
                                    dArr = new double[i10];
                                    dArr[i9] = d8;
                                    iVar.a(dArr);
                                    double[] dArr7 = new double[i10];
                                    dArr7[i9] = d6;
                                    iVar.a(dArr7);
                                    dArrB[0] = dArr7;
                                    int i45 = iVar.f617f;
                                    dArr2 = new double[i45][];
                                    double d13 = kVar.d;
                                    double d14 = d13 * d13;
                                    dArr3 = new double[i10];
                                    i11 = i22;
                                    while (true) {
                                        double d15 = (d8 + d6) / 2.0d;
                                        double d16 = d8;
                                        double[] dArr8 = new double[i10];
                                        dArr8[i9] = d15;
                                        iVar.a(dArr8);
                                        d9 = com.bumptech.glide.h.d(dArr, dArrB[i11 - 1], dArr8, dArr3, i9);
                                        if (!!Double.isNaN(d9) || Double.isInfinite(d9)) {
                                            break;
                                        }
                                        if (d9 < d14) {
                                            int i46 = 0;
                                            double d17 = 0.0d;
                                            while (true) {
                                                if (i46 >= i45) {
                                                    dArr4 = dArr2;
                                                    break;
                                                }
                                                d17 = (d16 + d15) / 2.0d;
                                                dArr4 = dArr2;
                                                double[] dArr9 = new double[i10];
                                                dArr4[i46] = dArr9;
                                                dArr9[i9] = d17;
                                                iVar.a(dArr9);
                                                if (com.bumptech.glide.h.d(dArr, dArr8, dArr9, dArr3, i9) >= d14) {
                                                    break;
                                                }
                                                i46++;
                                                d15 = d17;
                                                dArr2 = dArr4;
                                            }
                                            if (i46 == i45) {
                                                dArrB2 = dArrB;
                                                i12 = i22;
                                            } else {
                                                double[][] dArrB3 = com.bumptech.glide.g.b(dArrB, i11);
                                                dArrB3[i11] = dArr8;
                                                i11++;
                                                dArrB2 = dArrB3;
                                                int i47 = 0;
                                                while (i47 <= i46) {
                                                    dArrB2 = com.bumptech.glide.g.b(dArrB2, i11);
                                                    dArrB2[i11] = dArr4[i47];
                                                    i47++;
                                                    i11++;
                                                }
                                                d6 = d17;
                                            }
                                            if (i12 != 0) {
                                                obj = g.f625g;
                                                kVar.a(dArr, obj);
                                                kVar.a(dArr8, obj);
                                                i13 = i11 - 1;
                                                dArr5 = dArrB2[i13];
                                                if (i13 == 0) {
                                                    kVar.a(dArr5, obj);
                                                    return kVar;
                                                }
                                                double d18 = dArrB2[i11 - 2][i9];
                                                i11 = i13;
                                                dArr = dArr5;
                                                d8 = d6;
                                                d6 = d18;
                                            } else {
                                                if (d6 > d15) {
                                                    dArrB = com.bumptech.glide.g.b(dArrB2, i11);
                                                    dArrB[i11] = dArr8;
                                                    i11++;
                                                    d6 = d15;
                                                    d8 = d16;
                                                } else {
                                                    d8 = d16;
                                                }
                                                dArr2 = dArr4;
                                            }
                                            dArrB = dArrB2;
                                            dArr2 = dArr4;
                                        } else {
                                            dArr4 = dArr2;
                                            dArrB2 = dArrB;
                                        }
                                        i12 = 0;
                                        if (i12 != 0) {
                                            obj = g.f625g;
                                            kVar.a(dArr, obj);
                                            kVar.a(dArr8, obj);
                                            i13 = i11 - 1;
                                            dArr5 = dArrB2[i13];
                                            if (i13 == 0) {
                                                kVar.a(dArr5, obj);
                                                return kVar;
                                            }
                                            double d19 = dArrB2[i11 - 2][i9];
                                            i11 = i13;
                                            dArr = dArr5;
                                            d8 = d6;
                                            d6 = d19;
                                        } else {
                                            if (d6 > d15) {
                                                dArrB = com.bumptech.glide.g.b(dArrB2, i11);
                                                dArrB[i11] = dArr8;
                                                i11++;
                                                d6 = d15;
                                                d8 = d16;
                                            } else {
                                                d8 = d16;
                                            }
                                            dArr2 = dArr4;
                                        }
                                        dArrB = dArrB2;
                                        dArr2 = dArr4;
                                    }
                                    throw new RuntimeException("NaN or infinity resulted from calling the eval method of the " + i.class.getName() + " class.");
                                }
                                l lVar3 = iVar.d;
                                if (lVar3.f633a != i39) {
                                    throw new IllegalArgumentException(androidx.exifinterface.media.a.i(") != ", iVar.d.f633a, i39, new StringBuilder("knotVector.size(")));
                                }
                                bVar.c[0] = lVar3.b(0);
                                for (int i48 = 1; i48 < i39; i48++) {
                                    bVar.c[i48] = iVar.d.b(i48);
                                    double[] dArr10 = bVar.c;
                                    if (dArr10[i48] < dArr10[i48 - 1]) {
                                        throw new IllegalArgumentException(androidx.collection.a.m("Knot not in sorted order! (knot[", i48, i48, "] < knot[", "-1])"));
                                    }
                                }
                                d6 = d10;
                                d8 = 0.0d;
                                length = bVar.f615a.length;
                                i8 = iVar.f618g;
                                if (length < i8) {
                                    int i49 = i8 * 2;
                                    bVar.f615a = new int[i49];
                                    bVar.b = new int[i49];
                                }
                                i9 = kVar.e;
                                i10 = i9 + 1;
                                double[] dArr11 = new double[i10];
                                dArr11[i9] = d8;
                                iVar.a(dArr11);
                                kVar.a(dArr11, g.f624f);
                                if (d8 <= d6) {
                                    throw new IllegalArgumentException("t_min <= t_max required.");
                                }
                                dArrB = new double[10][];
                                dArr = new double[i10];
                                dArr[i9] = d8;
                                iVar.a(dArr);
                                double[] dArr12 = new double[i10];
                                dArr12[i9] = d6;
                                iVar.a(dArr12);
                                dArrB[0] = dArr12;
                                int i410 = iVar.f617f;
                                dArr2 = new double[i410][];
                                double d110 = kVar.d;
                                double d111 = d110 * d110;
                                dArr3 = new double[i10];
                                i11 = i22;
                                while (true) {
                                    double d112 = (d8 + d6) / 2.0d;
                                    double d113 = d8;
                                    double[] dArr13 = new double[i10];
                                    dArr13[i9] = d112;
                                    iVar.a(dArr13);
                                    d9 = com.bumptech.glide.h.d(dArr, dArrB[i11 - 1], dArr13, dArr3, i9);
                                    if (!Double.isNaN(d9)) {
                                        break;
                                    }
                                    break;
                                    break;
                                    dArr2 = dArr4;
                                }
                                throw new RuntimeException("NaN or infinity resulted from calling the eval method of the " + i.class.getName() + " class.");
                            }
                            int i50 = iArr3[i36];
                            if (i50 < 0 || i50 >= i35) {
                                throw new IllegalArgumentException("Group iterator not in range");
                            }
                            i36++;
                        }
                    }
                }
                throw new IllegalArgumentException("Group iterator not in range");
            }
            double dB3 = (lVar.b(i16) - dB) / dB2;
            if (i16 < 0 || i16 >= lVar.f633a) {
                throw new IllegalArgumentException(AbstractC0157z.l(")", lVar.f633a, AbstractC0157z.t(i16, "required: (index >= 0 && index < size) but: (index = ", ", size = ")));
            }
            lVar.b[i16] = dB3;
            i16++;
        }
    }
}
