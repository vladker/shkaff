package A3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends AbstractC0134c {
    public int b;
    public int c;
    public final /* synthetic */ u0 d;

    public t0(u0 u0Var) {
        this.d = u0Var;
        this.b = u0Var.c;
        this.c = u0Var.b;
    }

    @Override // A3.AbstractC0134c
    public final void b() {
        if (this.b == 0) {
            this.f37a = 2;
            return;
        }
        u0 u0Var = this.d;
        c(u0Var.buffer[this.c]);
        this.c = (this.c + 1) % u0Var.f50a;
        this.b--;
    }
}
