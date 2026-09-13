package B5;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class e extends xyz.doikki.videoplayer.controller.d implements View.OnClickListener {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ImageView f118I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ProgressBar f119J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f120K;

    public e(@NonNull Context context) {
        this(context, null);
    }

    @Override // xyz.doikki.videoplayer.controller.b
    public int getLayoutId() {
        return c.dkplayer_layout_standard_controller;
    }

    @Override // xyz.doikki.videoplayer.controller.d, xyz.doikki.videoplayer.controller.b
    public final void h() {
        super.h();
        ImageView imageView = (ImageView) findViewById(b.lock);
        this.f118I = imageView;
        imageView.setOnClickListener(this);
        this.f119J = (ProgressBar) findViewById(b.loading);
    }

    @Override // xyz.doikki.videoplayer.controller.b
    public final void k(boolean z6) {
        if (z6) {
            this.f118I.setSelected(true);
            Toast.makeText(getContext(), d.dkplayer_locked, 0).show();
        } else {
            this.f118I.setSelected(false);
            Toast.makeText(getContext(), d.dkplayer_unlocked, 0).show();
        }
    }

    @Override // xyz.doikki.videoplayer.controller.b
    public final void l(boolean z6, Animation animation) {
        if (this.f8962a.f8974a.e()) {
            if (!z6) {
                this.f118I.setVisibility(8);
                if (animation != null) {
                    this.f118I.startAnimation(animation);
                    return;
                }
                return;
            }
            if (this.f118I.getVisibility() == 8) {
                this.f118I.setVisibility(0);
                if (animation != null) {
                    this.f118I.startAnimation(animation);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == b.lock) {
            xyz.doikki.videoplayer.controller.c cVar = this.f8962a;
            cVar.setLocked(!cVar.b.b());
        }
    }

    @Override // xyz.doikki.videoplayer.controller.b
    public final void onPlayStateChanged(int i5) {
        super.onPlayStateChanged(i5);
        switch (i5) {
            case -1:
            case 2:
            case 3:
            case 4:
            case 7:
                if (i5 == 7) {
                    this.f120K = false;
                }
                if (!this.f120K) {
                    this.f119J.setVisibility(8);
                }
                break;
            case 0:
                this.f118I.setSelected(false);
                this.f119J.setVisibility(8);
                break;
            case 1:
            case 6:
                this.f119J.setVisibility(0);
                if (i5 == 6) {
                    this.f120K = true;
                }
                break;
            case 5:
                this.f119J.setVisibility(8);
                this.f118I.setVisibility(8);
                this.f118I.setSelected(false);
                break;
        }
    }

    @Override // xyz.doikki.videoplayer.controller.b
    public final void onPlayerStateChanged(int i5) {
        super.onPlayerStateChanged(i5);
        if (i5 == 10) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f118I.setVisibility(8);
        } else if (i5 == 11) {
            if (this.b) {
                this.f118I.setVisibility(0);
            } else {
                this.f118I.setVisibility(8);
            }
        }
        if (this.mActivity == null || !i()) {
            return;
        }
        int requestedOrientation = this.mActivity.getRequestedOrientation();
        int iApplyDimension = (int) TypedValue.applyDimension(1, 24.0f, getContext().getResources().getDisplayMetrics());
        int cutoutHeight = getCutoutHeight();
        if (requestedOrientation == 1) {
            ((FrameLayout.LayoutParams) this.f118I.getLayoutParams()).setMargins(iApplyDimension, 0, iApplyDimension, 0);
            return;
        }
        if (requestedOrientation == 0) {
            int i6 = iApplyDimension + cutoutHeight;
            ((FrameLayout.LayoutParams) this.f118I.getLayoutParams()).setMargins(i6, 0, i6, 0);
        } else if (requestedOrientation == 8) {
            ((FrameLayout.LayoutParams) this.f118I.getLayoutParams()).setMargins(iApplyDimension, 0, iApplyDimension, 0);
        }
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        super(context, attributeSet, i5);
    }
}
