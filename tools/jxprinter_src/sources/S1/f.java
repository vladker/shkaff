package S1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f623a;
    public int b;
    public Object c;

    public f(p061l.a aVar, String str, String str2) {
        if (aVar.f5755n == null) {
            aVar.f5755n = this;
        } else {
            aVar.f5756o.c = this;
        }
        aVar.f5756o = this;
        this.f623a = aVar.d(str);
        this.b = aVar.d(str2);
    }

    public static U1.b b(U1.j jVar, int i5, int i6, int i7) {
        try {
            String strSubstring = "0:n-1".substring(i6, i7);
            if (strSubstring == null) {
                throw new U1.c("Expression string cannot be null.", -1);
            }
            U1.b bVarA = p051j0.a.a(0, strSubstring);
            if (bVarA == null) {
                throw new e("control substring is empty", i6, i7);
            }
            p067m.k kVar = new p067m.k(1);
            U1.b.c(bVarA, kVar);
            int i8 = kVar.f6115a;
            String[] strArr = new String[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                strArr[i9] = (String) kVar.c(i9);
            }
            if (i8 > 1) {
                throw new e("too many variables", i6, i7);
            }
            if (i8 != 1) {
                return bVarA;
            }
            String str = strArr[0];
            double d = i5;
            boolean z6 = jVar.f712a;
            if (str == null) {
                throw new IllegalArgumentException("varName cannot be null");
            }
            int i10 = 0;
            while (true) {
                int i11 = jVar.d;
                if (i10 >= i11) {
                    if (i11 == jVar.b.length) {
                        int i12 = i11 * 2;
                        String[] strArr2 = new String[i12];
                        double[] dArr = new double[i12];
                        for (int i13 = 0; i13 < jVar.d; i13++) {
                            strArr2[i13] = jVar.b[i13];
                            dArr[i13] = jVar.c[i13];
                        }
                        jVar.b = strArr2;
                        jVar.c = dArr;
                    }
                    String[] strArr3 = jVar.b;
                    int i14 = jVar.d;
                    strArr3[i14] = str;
                    jVar.c[i14] = d;
                    jVar.d = i14 + 1;
                    return bVarA;
                }
                if ((z6 && jVar.b[i10].equals(str)) || (!z6 && jVar.b[i10].equalsIgnoreCase(str))) {
                    jVar.c[i10] = d;
                    return bVarA;
                }
                i10++;
            }
        } catch (U1.c e) {
            e eVar = new e();
            eVar.f622a = "error parsing expression";
            eVar.b = i6;
            eVar.c = i7;
            eVar.d = e;
            throw eVar;
        }
    }

    public int a() {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = (int[]) this.c;
            if (i5 >= iArr.length) {
                return i6;
            }
            int i7 = iArr[i5] - iArr[i5 + 1];
            if (i7 < 0) {
                i7 = -i7;
            }
            i6 += i7 + 1;
            i5 += 2;
        }
    }

    public f() {
        this.c = new f[256];
        this.f623a = 0;
        this.b = 0;
    }
}
