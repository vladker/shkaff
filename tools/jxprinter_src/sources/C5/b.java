package C5;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class b extends FrameLayout implements xyz.doikki.videoplayer.controller.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xyz.doikki.videoplayer.controller.c f140a;
    public final ImageView b;

    public b(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(B5.b.iv_replay).setOnClickListener(new a(this, 0));
        ImageView imageView = (ImageView) findViewById(B5.b.stop_fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(new a(this, 1));
        setClickable(true);
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public void attach(@NonNull xyz.doikki.videoplayer.controller.c cVar) {
        this.f140a = cVar;
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void d(int i5) {
        ImageView imageView = this.b;
        if (i5 == 11) {
            imageView.setVisibility(0);
        } else if (i5 == 10) {
            imageView.setVisibility(8);
        }
        Activity activityD = F5.c.d(getContext());
        if (activityD == null || !this.f140a.b.i()) {
            return;
        }
        int requestedOrientation = activityD.getRequestedOrientation();
        int cutoutHeight = this.f140a.b.getCutoutHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        if (requestedOrientation == 1) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            layoutParams.setMargins(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            layoutParams.setMargins(0, 0, 0, 0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void e(int i5) {
        if (i5 != 5) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.b.setVisibility(this.f140a.f8974a.e() ? 0 : 8);
        bringToFront();
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(B5.b.iv_replay).setOnClickListener(new a(this, 0));
        ImageView imageView = (ImageView) findViewById(B5.b.stop_fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(new a(this, 1));
        setClickable(true);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(B5.b.iv_replay).setOnClickListener(new a(this, 0));
        ImageView imageView = (ImageView) findViewById(B5.b.stop_fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(new a(this, 1));
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
    public final void b(boolean z6, Animation animation) {
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void c(int i5, int i6) {
    }
}
