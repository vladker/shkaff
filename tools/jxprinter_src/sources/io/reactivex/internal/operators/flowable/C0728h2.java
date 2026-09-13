package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0978k;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.h2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0728h2 implements p027e3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.g f4653a;

    public C0728h2(p027e3.g gVar) {
        this.f4653a = gVar;
    }

    @Override // p027e3.c
    public Object apply(Object obj, InterfaceC0978k interfaceC0978k) {
        this.f4653a.accept(interfaceC0978k);
        return obj;
    }
}
