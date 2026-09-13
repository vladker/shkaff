package p058k2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class c extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f5474a;

    public c(k kVar) {
        this.f5474a = kVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        k kVar = this.f5474a;
        View.OnLongClickListener onLongClickListener = kVar.f5492p;
        if (onLongClickListener != null) {
            onLongClickListener.onLongClick(kVar.h());
        }
    }
}
