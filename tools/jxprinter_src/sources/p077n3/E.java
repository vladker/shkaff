package p077n3;

import io.reactivex.V;
import io.reactivex.internal.operators.flowable.C0834z1;
import p027e3.o;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E f6264a;
    public static final /* synthetic */ E[] b;

    static {
        E e = new E("INSTANCE", 0);
        f6264a = e;
        b = new E[]{e};
    }

    public static E valueOf(String str) {
        return (E) Enum.valueOf(E.class, str);
    }

    public static E[] values() {
        return (E[]) b.clone();
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        return new C0834z1((V) obj, 4);
    }
}
