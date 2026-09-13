package p084o4;

import N3.a;
import O3.l;
import V3.c;
import kotlin.jvm.internal.E;
import p060k4.b;

/* JADX INFO: renamed from: o4.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1334t implements R0 {
    private final C1342x classValue;
    private final l compute;

    public C1334t(l compute) {
        E.f(compute, "compute");
        this.compute = compute;
        this.classValue = new C1342x();
    }

    @Override // p084o4.R0
    public b get(c key) {
        E.f(key, "key");
        Object obj = this.classValue.get(a.getJavaClass(key));
        E.e(obj, "get(...)");
        C1330q0 c1330q0 = (C1330q0) obj;
        Object orSetWithLock = c1330q0.reference.get();
        if (orSetWithLock == null) {
            orSetWithLock = c1330q0.getOrSetWithLock(new C1332s(this, key));
        }
        return ((C1321m) orSetWithLock).serializer;
    }

    public final l getCompute() {
        return this.compute;
    }

    @Override // p084o4.R0
    public boolean isStored(c key) {
        E.f(key, "key");
        return this.classValue.isStored(a.getJavaClass(key));
    }
}
