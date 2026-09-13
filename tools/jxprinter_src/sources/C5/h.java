package C5;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class h extends FrameLayout implements xyz.doikki.videoplayer.controller.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xyz.doikki.videoplayer.controller.c f146a;
    public final ImageView b;
    public final ImageView c;
    public final ProgressBar d;
    public final FrameLayout e;

    public h(@NonNull Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_prepare_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(B5.b.thumb);
        this.c = (ImageView) findViewById(B5.b.start_play);
        this.d = (ProgressBar) findViewById(B5.b.loading);
        this.e = (FrameLayout) findViewById(B5.b.net_warning_layout);
        findViewById(B5.b.status_btn).setOnClickListener(new g(this, 0));
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public void attach(@NonNull xyz.doikki.videoplayer.controller.c cVar) {
        this.f146a = cVar;
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void e(int i5) {
        ProgressBar progressBar = this.d;
        ImageView imageView = this.c;
        FrameLayout frameLayout = this.e;
        switch (i5) {
            case -1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                setVisibility(8);
                break;
            case 0:
                setVisibility(0);
                bringToFront();
                progressBar.setVisibility(8);
                frameLayout.setVisibility(8);
                imageView.setVisibility(0);
                this.b.setVisibility(0);
                break;
            case 1:
                bringToFront();
                setVisibility(0);
                imageView.setVisibility(8);
                frameLayout.setVisibility(8);
                progressBar.setVisibility(0);
                break;
            case 8:
                setVisibility(0);
                frameLayout.setVisibility(0);
                frameLayout.bringToFront();
                break;
        }
    }

    public h(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_prepare_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(B5.b.thumb);
        this.c = (ImageView) findViewById(B5.b.start_play);
        this.d = (ProgressBar) findViewById(B5.b.loading);
        this.e = (FrameLayout) findViewById(B5.b.net_warning_layout);
        findViewById(B5.b.status_btn).setOnClickListener(new g(this, 0));
    }

    public h(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_prepare_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(B5.b.thumb);
        this.c = (ImageView) findViewById(B5.b.start_play);
        this.d = (ProgressBar) findViewById(B5.b.loading);
        this.e = (FrameLayout) findViewById(B5.b.net_warning_layout);
        findViewById(B5.b.status_btn).setOnClickListener(new g(this, 0));
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
