package p084o4;

import O3.a;
import V3.c;
import p060k4.b;

/* JADX INFO: renamed from: o4.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1332s implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1334t f6472a;
    public final /* synthetic */ c b;

    public C1332s(C1334t c1334t, c cVar) {
        this.f6472a = c1334t;
        this.b = cVar;
    }

    @Override // O3.a
    public final Object invoke() {
        return new C1321m((b) this.f6472a.getCompute().invoke(this.b));
    }
}
