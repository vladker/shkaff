package U1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends h {
    public p067m.k d;
    public double[] e;

    @Override // U1.b
    public final double b(j jVar, d dVar) {
        p067m.k kVar = this.d;
        int i5 = kVar.f6115a;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            this.e[i7] = ((b) kVar.c(i7)).b(jVar, dVar);
        }
        while (true) {
            int i8 = dVar.b;
            String str = this.b;
            if (i6 >= i8) {
                throw new RuntimeException("function not found: " + str + " " + i5);
            }
            if (((V1.a[]) dVar.d)[i6].e(i5) && ((String[]) dVar.c)[i6].equalsIgnoreCase(str)) {
                double dG = ((V1.a[]) dVar.d)[i6].g(this.e, i5);
                return this.c ? -dG : dG;
            }
            i6++;
        }
    }
}
