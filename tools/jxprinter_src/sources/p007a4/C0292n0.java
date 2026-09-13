package p007a4;

/* JADX INFO: renamed from: a4.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0292n0 extends AbstractRunnableC0294o0 {
    private final Runnable block;

    public C0292n0(long j6, Runnable runnable) {
        super(j6);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.block.run();
    }

    @Override // p007a4.AbstractRunnableC0294o0
    public String toString() {
        return super.toString() + this.block;
    }
}
