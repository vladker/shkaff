package S4;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f669a = new j();
    public final d b;
    public volatile boolean c;

    public a(d dVar) {
        this.b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    i iVarPoll = this.f669a.poll(1000);
                    if (iVarPoll == null) {
                        synchronized (this) {
                            iVarPoll = this.f669a.b();
                            if (iVarPoll == null) {
                                this.c = false;
                                this.c = false;
                                return;
                            }
                        }
                    }
                    this.b.c(iVarPoll);
                } catch (InterruptedException e) {
                    this.b.f686p.b(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.c = false;
                    return;
                }
            } catch (Throwable th) {
                this.c = false;
                throw th;
            }
        }
    }
}
