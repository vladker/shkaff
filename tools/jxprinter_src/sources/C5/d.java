package C5;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class d extends LinearLayout implements xyz.doikki.videoplayer.controller.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f142a;
    public float b;
    public xyz.doikki.videoplayer.controller.c c;

    public d(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_error_view, (ViewGroup) this, true);
        findViewById(B5.b.status_btn).setOnClickListener(new c(this, 0));
        setClickable(true);
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public void attach(@NonNull xyz.doikki.videoplayer.controller.c cVar) {
        this.c = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f142a = motionEvent.getX();
            this.b = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - this.f142a);
            float fAbs2 = Math.abs(motionEvent.getY() - this.b);
            if (fAbs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || fAbs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void e(int i5) {
        if (i5 == -1) {
            bringToFront();
            setVisibility(0);
        } else if (i5 == 0) {
            setVisibility(8);
        }
    }

    public d(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_error_view, (ViewGroup) this, true);
        findViewById(B5.b.status_btn).setOnClickListener(new c(this, 0));
        setClickable(true);
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public View getView() {
        return this;
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void a(boolean z6) {
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void d(int i5) {
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void b(boolean z6, Animation animation) {
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void c(int i5, int i6) {
    }
}
