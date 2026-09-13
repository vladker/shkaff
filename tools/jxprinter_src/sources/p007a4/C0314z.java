package p007a4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: a4.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0314z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f960a = AtomicIntegerFieldUpdater.newUpdater(C0314z.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;
    public final Throwable cause;

    public C0314z(Throwable th, boolean z6) {
        this.cause = th;
        this._handled$volatile = z6 ? 1 : 0;
    }

    public String toString() {
        return S.getClassSimpleName(this) + '[' + this.cause + ']';
    }
}
