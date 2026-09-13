package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0979l;
import java.util.List;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.x1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0952x1 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.o f5306a;

    public C0952x1(p027e3.o oVar) {
        this.f5306a = oVar;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        return io.reactivex.B.zipIterable((List) obj, this.f5306a, false, AbstractC0979l.f5366a);
    }
}
