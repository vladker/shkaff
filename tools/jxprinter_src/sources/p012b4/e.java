package p012b4;

import android.view.Choreographer;
import p007a4.C0276f0;
import p007a4.C0289m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0289m f1090a;

    public /* synthetic */ e(C0289m c0289m) {
        this.f1090a = c0289m;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j6) {
        this.f1090a.resumeUndispatched(C0276f0.getMain(), Long.valueOf(j6));
    }
}
