package p064l2;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import p058k2.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f5784a;
    public float b;
    public float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f5785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ScaleGestureDetector f5789j;

    public b(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.d = viewConfiguration.getScaledTouchSlop();
        this.f5787h = -1;
        this.f5788i = 0;
        this.f5789j = new ScaleGestureDetector(context, new a(this));
    }

    public final float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f5788i);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f5788i);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }
}
