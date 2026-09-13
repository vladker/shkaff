package p039g3;

import io.reactivex.internal.operators.flowable.J3;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4005a;

    public /* synthetic */ t(int i5) {
        this.f4005a = i5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4005a) {
            case 0:
                return null;
            default:
                return new J3(16);
        }
    }
}
