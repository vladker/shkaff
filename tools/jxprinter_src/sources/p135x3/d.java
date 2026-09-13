package p135x3;

import io.reactivex.InterfaceC0984q;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements InterfaceC0984q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8957a;
    public static final /* synthetic */ d[] b;

    static {
        d dVar = new d("INSTANCE", 0);
        f8957a = dVar;
        b = new d[]{dVar};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) b.clone();
    }

    @Override // t5.c
    public final void onComplete() {
    }

    @Override // t5.c
    public final void onError(Throwable th) {
    }

    @Override // t5.c
    public final void onNext(Object obj) {
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
    }
}
