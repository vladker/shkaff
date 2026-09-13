package S1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f628n = new a(1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l f630l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f631m;

    public i(d dVar, f fVar) {
        super(dVar, fVar);
        this.f629k = (h) f628n.get();
        this.f630l = new l(new double[]{1.0d, 1.0d, 1.0d, 1.0d}, 4);
        this.f631m = true;
    }

    public final void a(double[] dArr) {
        h hVar;
        int i5;
        double[] dArr2;
        double d;
        int i6;
        double d6;
        i iVar = this;
        char c = 1;
        int length = dArr.length - 1;
        double d7 = dArr[length];
        int iA = iVar.b.a();
        int i7 = 0;
        double d8 = 0.0d;
        while (true) {
            hVar = iVar.f629k;
            if (i7 >= iA) {
                break;
            }
            char c6 = c;
            double[] dArr3 = hVar.f627a;
            int i8 = 0;
            while (true) {
                int i9 = iVar.f618g;
                if (i8 >= i9) {
                    dArr2 = dArr3;
                    d = 0.0d;
                    break;
                }
                b bVar = iVar.c;
                double[] dArr4 = bVar.c;
                int i10 = i7 + i8;
                double d9 = dArr4[i10];
                double d10 = dArr4[i10 + 1];
                if (d7 < d9 || d7 > d10 || d9 == d10) {
                    i8++;
                    dArr3 = dArr3;
                } else {
                    int i11 = i9 - 2;
                    for (int i12 = (i9 - i8) - 1; i12 >= 0; i12--) {
                        bVar.f615a[i12] = 0;
                    }
                    if (i8 > 0) {
                        for (int i13 = 0; i13 < i8; i13++) {
                            bVar.b[i13] = i13;
                        }
                        bVar.b[i8] = Integer.MAX_VALUE;
                    } else {
                        int[] iArr = bVar.b;
                        iArr[0] = i11;
                        iArr[c6] = iVar.f618g;
                    }
                    d = 0.0d;
                    int i14 = 0;
                    while (true) {
                        int[] iArr2 = bVar.b;
                        int i15 = i14 + 1;
                        if (iArr2[i14] < iArr2[i15] - 1) {
                            int i16 = 0;
                            int i17 = i11 - i8;
                            double d11 = 1.0d;
                            int i18 = i8 - 1;
                            int i19 = iVar.f618g;
                            int i20 = i11;
                            while (i20 >= 0) {
                                double[] dArr5 = dArr3;
                                if (i18 < 0 || bVar.b[i18] != i20) {
                                    int i21 = bVar.f615a[i17] + i7;
                                    double[] dArr6 = bVar.c;
                                    double d12 = dArr6[i21];
                                    d6 = ((d7 - d12) / (dArr6[(i21 + i19) - 1] - d12)) * d11;
                                    i17--;
                                } else {
                                    int i22 = i7 + i16;
                                    double[] dArr7 = bVar.c;
                                    double d13 = dArr7[i22 + i19];
                                    d6 = ((d13 - d7) / (d13 - dArr7[i22 + 1])) * d11;
                                    i16++;
                                    i18--;
                                }
                                d11 = d6;
                                i20--;
                                i19--;
                                dArr3 = dArr5;
                            }
                            dArr2 = dArr3;
                            if (i8 > 0) {
                                int i23 = 0;
                                char c7 = 0;
                                while (true) {
                                    int[] iArr3 = bVar.f615a;
                                    i6 = i23;
                                    int i24 = iArr3[i23] + 1;
                                    iArr3[i6] = i24;
                                    if (i24 <= i8) {
                                        break;
                                    }
                                    i23 = i6 + 1;
                                    c7 = c6;
                                }
                                if (c7 != 0) {
                                    for (int i25 = i6 - 1; i25 >= 0; i25--) {
                                        int[] iArr4 = bVar.f615a;
                                        iArr4[i25] = iArr4[i6];
                                    }
                                }
                            }
                            d += d11;
                            int[] iArr5 = bVar.b;
                            int i26 = iArr5[i14] + 1;
                            iArr5[i14] = i26;
                            if (i26 > i11) {
                                break;
                            }
                            for (int i27 = 0; i27 < i14; i27++) {
                                bVar.b[i27] = i27;
                            }
                            i14 = 0;
                            dArr3 = dArr2;
                        } else {
                            i14 = i15;
                        }
                    }
                }
            }
            dArr2[i7] = d * hVar.b[i7];
            d8 += hVar.f627a[i7];
            i7++;
            c = c6;
        }
        int i28 = 0;
        if (d8 == 0.0d) {
            d8 = 1.0d;
        }
        int i29 = 0;
        while (i29 < length) {
            f fVar = iVar.b;
            fVar.getClass();
            int i30 = i28;
            fVar.f623a = i30;
            fVar.b = i30;
            double d14 = 0.0d;
            int i31 = 0;
            while (i31 < iA) {
                double d15 = hVar.f627a[i31];
                d dVar = iVar.f632a;
                f fVar2 = iVar.b;
                int[] iArr6 = (int[]) fVar2.c;
                int i32 = fVar2.f623a;
                int i33 = iArr6[i32];
                int i34 = iArr6[i32 + 1];
                if (i33 <= i34) {
                    int i35 = fVar2.b;
                    i5 = i33 + i35;
                    if (i5 >= i34) {
                        fVar2.b = 0;
                        fVar2.f623a = i32 + 2;
                    } else {
                        fVar2.b = i35 + 1;
                    }
                } else {
                    int i36 = fVar2.b;
                    i5 = i33 - i36;
                    if (i5 <= i34) {
                        fVar2.b = 0;
                        fVar2.f623a = i32 + 2;
                    } else {
                        fVar2.b = i36 + 1;
                    }
                }
                d14 += d15 * ((T1.a) dVar.f621a.c(i5)).f701a[i29];
                i31++;
                iVar = this;
            }
            dArr[i29] = d14 / d8;
            i29++;
            iVar = this;
            i28 = 0;
        }
    }
}
