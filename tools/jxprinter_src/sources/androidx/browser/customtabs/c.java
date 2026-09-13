package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f991a;
    public final /* synthetic */ EngagementSignalsCallback b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Bundle d;

    public /* synthetic */ c(EngagementSignalsCallback engagementSignalsCallback, int i5, Bundle bundle, int i6) {
        this.f991a = i6;
        this.b = engagementSignalsCallback;
        this.c = i5;
        this.d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f991a) {
            case 0:
                this.b.onGreatestScrollPercentageIncreased(this.c, this.d);
                break;
            default:
                this.b.onGreatestScrollPercentageIncreased(this.c, this.d);
                break;
        }
    }
}
