package p112t3;

import io.reactivex.I;
import p011b3.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8664a;
    public static final /* synthetic */ f[] b;

    static {
        f fVar = new f("INSTANCE", 0);
        f8664a = fVar;
        b = new f[]{fVar};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) b.clone();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
    }
}
