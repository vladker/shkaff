package p077n3;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f6263a;
    public static final /* synthetic */ D[] b;

    static {
        D d = new D("INSTANCE", 0);
        f6263a = d;
        b = new D[]{d};
    }

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) b.clone();
    }

    @Override // java.util.concurrent.Callable
    public NoSuchElementException call() {
        return new NoSuchElementException();
    }
}
