package U1;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends h {
    @Override // U1.b
    public final double b(j jVar, d dVar) {
        boolean z6 = jVar.f712a;
        int i5 = 0;
        while (true) {
            int i6 = jVar.d;
            String str = this.b;
            if (i5 >= i6) {
                throw new RuntimeException(AbstractC0157z.n("variable value has not been set: ", str));
            }
            if ((z6 && jVar.b[i5].equals(str)) || (!z6 && jVar.b[i5].equalsIgnoreCase(str))) {
                break;
            }
            i5++;
        }
        double d = jVar.c[i5];
        return this.c ? -d : d;
    }
}
