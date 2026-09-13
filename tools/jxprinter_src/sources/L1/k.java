package L1;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.view.WheelView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f419a = 0;
    public final Object b;

    public k(WheelView wheelView) {
        this.b = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        switch (this.f419a) {
            case 0:
                ((p) this.b).getClass();
                return false;
            default:
                WheelView wheelView = (WheelView) this.b;
                wheelView.a();
                wheelView.f3227i = wheelView.f3226h.scheduleWithFixedDelay(new Y0.a(wheelView, f7), 0L, 5L, TimeUnit.MILLISECONDS);
                return true;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        switch (this.f419a) {
            case 0:
                p pVar = (p) this.b;
                View.OnLongClickListener onLongClickListener = pVar.f438q;
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClick(pVar.f429h);
                }
                break;
            default:
                super.onLongPress(motionEvent);
                break;
        }
    }

    public k(p pVar) {
        this.b = pVar;
    }
}
