package p129w3;

import p048i3.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends b {
    private static final long serialVersionUID = 7926949470189395511L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f8819a;

    public e(f fVar) {
        this.f8819a = fVar;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f8819a.f8825j = true;
        return 2;
    }

    @Override // p043h3.j
    public final void clear() {
        this.f8819a.f8820a.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f8819a.e) {
            return;
        }
        this.f8819a.e = true;
        this.f8819a.e();
        this.f8819a.b.lazySet(null);
        if (this.f8819a.f8824i.getAndIncrement() == 0) {
            this.f8819a.b.lazySet(null);
            this.f8819a.f8820a.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f8819a.e;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.f8819a.f8820a.isEmpty();
    }

    @Override // p048i3.b, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        return this.f8819a.f8820a.poll();
    }
}
