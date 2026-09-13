package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f990a;
    public final /* synthetic */ EngagementSignalsCallback b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Bundle d;

    public /* synthetic */ b(EngagementSignalsCallback engagementSignalsCallback, boolean z6, Bundle bundle, int i5) {
        this.f990a = i5;
        this.b = engagementSignalsCallback;
        this.c = z6;
        this.d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f990a) {
            case 0:
                this.b.onSessionEnded(this.c, this.d);
                break;
            case 1:
                this.b.onVerticalScrollEvent(this.c, this.d);
                break;
            case 2:
                this.b.onVerticalScrollEvent(this.c, this.d);
                break;
            default:
                this.b.onSessionEnded(this.c, this.d);
                break;
        }
    }
}
