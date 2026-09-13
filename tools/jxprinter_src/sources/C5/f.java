package C5;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class f extends FrameLayout implements xyz.doikki.videoplayer.controller.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xyz.doikki.videoplayer.controller.c f144a;
    public final ImageView b;
    public final ProgressBar c;
    public final TextView d;
    public final LinearLayout e;

    public f(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(B5.b.iv_icon);
        this.c = (ProgressBar) findViewById(B5.b.pro_percent);
        this.d = (TextView) findViewById(B5.b.tv_percent);
        this.e = (LinearLayout) findViewById(B5.b.center_container);
    }

    @Override // xyz.doikki.videoplayer.controller.f, xyz.doikki.videoplayer.controller.e
    public void attach(@NonNull xyz.doikki.videoplayer.controller.c cVar) {
        this.f144a = cVar;
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void e(int i5) {
        if (i5 == 0 || i5 == 8 || i5 == 1 || i5 == 2 || i5 == -1 || i5 == 5) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(B5.b.iv_icon);
        this.c = (ProgressBar) findViewById(B5.b.pro_percent);
        this.d = (TextView) findViewById(B5.b.tv_percent);
        this.e = (LinearLayout) findViewById(B5.b.center_container);
    }

    public f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(B5.b.iv_icon);
        this.c = (ProgressBar) findViewById(B5.b.pro_percent);
        this.d = (TextView) findViewById(B5.b.tv_percent);
        this.e = (LinearLayout) findViewById(B5.b.center_container);
    }

    @Override // xyz.doikki.videoplayer.controller.f, xyz.doikki.videoplayer.controller.e
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
