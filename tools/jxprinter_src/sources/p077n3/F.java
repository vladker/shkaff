package p077n3;

import io.reactivex.V;
import io.reactivex.internal.operators.observable.T0;
import p027e3.o;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f6265a;
    public static final /* synthetic */ F[] b;

    static {
        F f6 = new F("INSTANCE", 0);
        f6265a = f6;
        b = new F[]{f6};
    }

    public static F valueOf(String str) {
        return (F) Enum.valueOf(F.class, str);
    }

    public static F[] values() {
        return (F[]) b.clone();
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        return new T0((V) obj, 6);
    }
}
