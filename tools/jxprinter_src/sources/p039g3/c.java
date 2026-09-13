package p039g3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3990a;

    public c(int i5) {
        this.f3990a = i5;
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() {
        return new ArrayList(this.f3990a);
    }
}
