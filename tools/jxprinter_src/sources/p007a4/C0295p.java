package p007a4;

import E3.g;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: a4.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0295p extends C0314z {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(C0295p.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public C0295p(g<?> gVar, Throwable th, boolean z6) {
        if (th == null) {
            th = new CancellationException("Continuation " + gVar + " was cancelled normally");
        }
        super(th, z6);
        this._resumed$volatile = 0;
    }
}
