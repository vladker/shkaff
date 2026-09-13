package p007a4;

/* JADX INFO: renamed from: a4.r0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0299r0 extends AbstractC0288l0 {
    public abstract Thread getThread();

    public void reschedule(long j6, AbstractRunnableC0294o0 abstractRunnableC0294o0) {
        T.INSTANCE.schedule(j6, abstractRunnableC0294o0);
    }
}
