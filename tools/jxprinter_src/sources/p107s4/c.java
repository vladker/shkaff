package p107s4;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8234a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ c(String str, boolean z6) {
        this.f8234a = str;
        this.b = z6;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f8234a);
        thread.setDaemon(this.b);
        return thread;
    }
}
