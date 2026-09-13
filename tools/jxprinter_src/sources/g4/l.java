package g4;

import p007a4.S;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends k {
    public final Runnable block;

    public l(Runnable runnable, long j6, boolean z6) {
        super(j6, z6);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.block.run();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        sb.append(S.getClassSimpleName(this.block));
        sb.append('@');
        sb.append(S.getHexAddress(this.block));
        sb.append(", ");
        sb.append(this.submissionTime);
        sb.append(", ");
        boolean z6 = this.taskContext;
        String str = m.DEFAULT_SCHEDULER_NAME;
        return androidx.collection.a.f(']', z6 ? "Blocking" : "Non-blocking", sb);
    }
}
