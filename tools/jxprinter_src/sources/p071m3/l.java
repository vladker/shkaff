package p071m3;

import p117u3.b;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.b f6148a;
    public final int b;
    public final int c;

    public l(t5.b bVar, int i5, int i6) {
        this.f6148a = bVar;
        this.b = i5;
        this.c = i6;
    }

    @Override // p117u3.b
    public final int a() {
        return this.b;
    }

    @Override // p117u3.b
    public final void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            this.f6148a.subscribe(new k(cVarArr, this.c));
        }
    }
}
