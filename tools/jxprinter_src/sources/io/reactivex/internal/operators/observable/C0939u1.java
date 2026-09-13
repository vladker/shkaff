package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0978k;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.u1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0939u1 implements p027e3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.b f5286a;

    public C0939u1(p027e3.b bVar) {
        this.f5286a = bVar;
    }

    @Override // p027e3.c
    public Object apply(Object obj, InterfaceC0978k interfaceC0978k) {
        this.f5286a.accept(obj, interfaceC0978k);
        return obj;
    }
}
