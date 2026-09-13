package S4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f691a;
    public i b;

    public final synchronized void a(i iVar) {
        try {
            i iVar2 = this.b;
            if (iVar2 != null) {
                iVar2.c = iVar;
                this.b = iVar;
            } else {
                if (this.f691a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.b = iVar;
                this.f691a = iVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized i b() {
        i iVar;
        iVar = this.f691a;
        if (iVar != null) {
            i iVar2 = iVar.c;
            this.f691a = iVar2;
            if (iVar2 == null) {
                this.b = null;
            }
        }
        return iVar;
    }

    public synchronized i poll(int i5) {
        try {
            if (this.f691a == null) {
                wait(i5);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }
}
