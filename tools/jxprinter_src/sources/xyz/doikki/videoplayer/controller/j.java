package xyz.doikki.videoplayer.controller;

import android.view.OrientationEventListener;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class j extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8990a;
    public b b;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i5) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f8990a < 300) {
            return;
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.onOrientationChanged(i5);
        }
        this.f8990a = jCurrentTimeMillis;
    }
}
