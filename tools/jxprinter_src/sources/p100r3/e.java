package p100r3;

import io.reactivex.I;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0984q;
import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import io.reactivex.plugins.a;
import p011b3.c;
import t5.d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements InterfaceC0984q, I, InterfaceC0988v, S, InterfaceC0679f, d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f7960a;
    public static final /* synthetic */ e[] b;

    static {
        e eVar = new e("INSTANCE", 0);
        f7960a = eVar;
        b = new e[]{eVar};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) b.clone();
    }

    @Override // p011b3.c
    public final boolean e() {
        return true;
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        cVar.dispose();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        dVar.cancel();
    }

    @Override // t5.d
    public final void cancel() {
    }

    @Override // p011b3.c
    public final void dispose() {
    }

    @Override // t5.c
    public final void onComplete() {
    }

    @Override // t5.c
    public final void onNext(Object obj) {
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
    }

    @Override // t5.d
    public final void request(long j6) {
    }
}
