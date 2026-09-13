package p100r3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import p027e3.o;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Callable, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7958a;
    public static final /* synthetic */ b[] b;

    static {
        b bVar = new b("INSTANCE", 0);
        f7958a = bVar;
        b = new b[]{bVar};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) b.clone();
    }

    @Override // p027e3.o
    public List<Object> apply(Object obj) {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() {
        return new ArrayList();
    }
}
