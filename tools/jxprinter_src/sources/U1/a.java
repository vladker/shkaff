package U1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {
    public final b b;
    public final b c;
    public final /* synthetic */ int d;

    public a(b bVar, b bVar2, int i5) {
        this.d = i5;
        this.b = null;
        this.c = null;
        a(bVar);
        b bVar3 = this.b;
        if (bVar3 != null) {
            bVar3.f707a = null;
        }
        bVar.f707a = this;
        this.b = bVar;
        a(bVar2);
        b bVar4 = this.c;
        if (bVar4 != null) {
            bVar4.f707a = null;
        }
        bVar2.f707a = this;
        this.c = bVar2;
    }

    @Override // U1.b
    public final double b(j jVar, d dVar) {
        switch (this.d) {
            case 0:
                return this.c.b(jVar, dVar) + this.b.b(jVar, dVar);
            case 1:
                return this.b.b(jVar, dVar) / this.c.b(jVar, dVar);
            case 2:
                return this.c.b(jVar, dVar) * this.b.b(jVar, dVar);
            case 3:
                return Math.pow(this.b.b(jVar, dVar), this.c.b(jVar, dVar));
            default:
                return this.b.b(jVar, dVar) - this.c.b(jVar, dVar);
        }
    }
}
