package p007a4;

import A3.C0144l;
import androidx.core.location.LocationRequestCompat;
import p028e4.AbstractC0659m;

/* JADX INFO: renamed from: a4.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0288l0 extends F {
    public static final /* synthetic */ int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f953a;
    public boolean b;
    private C0144l unconfinedQueue;

    public final void a(boolean z6) {
        long j6 = this.f953a - (z6 ? 4294967296L : 1L);
        this.f953a = j6;
        if (j6 <= 0 && this.b) {
            shutdown();
        }
    }

    public long c() {
        C0144l c0144l = this.unconfinedQueue;
        if (c0144l == null || c0144l.isEmpty()) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return 0L;
    }

    public final void d(boolean z6) {
        this.f953a = (z6 ? 4294967296L : 1L) + this.f953a;
        if (z6) {
            return;
        }
        this.b = true;
    }

    public final void dispatchUnconfined(AbstractC0267c0 abstractC0267c0) {
        C0144l c0144l = this.unconfinedQueue;
        if (c0144l == null) {
            c0144l = new C0144l();
            this.unconfinedQueue = c0144l;
        }
        c0144l.addLast(abstractC0267c0);
    }

    public final boolean e() {
        return this.f953a >= 4294967296L;
    }

    public final boolean f() {
        C0144l c0144l = this.unconfinedQueue;
        if (c0144l != null) {
            return c0144l.isEmpty();
        }
        return true;
    }

    public abstract long g();

    public final boolean h() {
        AbstractC0267c0 abstractC0267c0;
        C0144l c0144l = this.unconfinedQueue;
        if (c0144l == null || (abstractC0267c0 = (AbstractC0267c0) c0144l.removeFirstOrNull()) == null) {
            return false;
        }
        abstractC0267c0.run();
        return true;
    }

    @Override // p007a4.F
    public final F limitedParallelism(int i5, String str) {
        AbstractC0659m.a(i5);
        return AbstractC0659m.namedOrThis(this, str);
    }

    public abstract void shutdown();
}
