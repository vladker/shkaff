package p033f3;

import io.reactivex.I;
import io.reactivex.S;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements p043h3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f3970a;
    public static final e b;
    public static final /* synthetic */ e[] c;

    static {
        e eVar = new e("INSTANCE", 0);
        f3970a = eVar;
        e eVar2 = new e("NEVER", 1);
        b = eVar2;
        c = new e[]{eVar, eVar2};
    }

    public static void a(Throwable th, I i5) {
        i5.onSubscribe(f3970a);
        i5.onError(th);
    }

    public static void f(Throwable th, S s6) {
        s6.onSubscribe(f3970a);
        s6.onError(th);
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) c.clone();
    }

    @Override // p043h3.f
    public final int c(int i5) {
        return 2;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this == f3970a;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return true;
    }

    @Override // p043h3.e, p043h3.f, p043h3.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        return null;
    }

    @Override // p043h3.e, p043h3.f, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p043h3.j
    public final void clear() {
    }

    @Override // p011b3.c
    public final void dispose() {
    }
}
