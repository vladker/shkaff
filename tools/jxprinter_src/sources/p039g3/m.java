package p039g3;

import java.util.concurrent.Callable;
import p027e3.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements Callable, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3999a;

    public m(Object obj) {
        this.f3999a = obj;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        return this.f3999a;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f3999a;
    }
}
