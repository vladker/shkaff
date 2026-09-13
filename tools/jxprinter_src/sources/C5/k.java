package C5;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class k extends FrameLayout implements xyz.doikki.videoplayer.controller.e, View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xyz.doikki.videoplayer.controller.c f150a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final LinearLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SeekBar f151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProgressBar f152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f155j;

    public k(@NonNull Context context) {
        super(context);
        this.f155j = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(B5.b.fullscreen);
        this.d = imageView;
        imageView.setOnClickListener(this);
        this.e = (LinearLayout) findViewById(B5.b.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(B5.b.seekBar);
        this.f151f = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.b = (TextView) findViewById(B5.b.total_time);
        this.c = (TextView) findViewById(B5.b.curr_time);
        ImageView imageView2 = (ImageView) findViewById(B5.b.iv_play);
        this.f153h = imageView2;
        imageView2.setOnClickListener(this);
        this.f152g = (ProgressBar) findViewById(B5.b.bottom_progress);
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void a(boolean z6) {
        b(!z6, null);
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public void attach(@NonNull xyz.doikki.videoplayer.controller.c cVar) {
        this.f150a = cVar;
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void b(boolean z6, Animation animation) {
        boolean z7 = this.f155j;
        ProgressBar progressBar = this.f152g;
        LinearLayout linearLayout = this.e;
        if (z6) {
            linearLayout.setVisibility(0);
            if (animation != null) {
                linearLayout.startAnimation(animation);
            }
            if (z7) {
                progressBar.setVisibility(8);
                return;
            }
            return;
        }
        linearLayout.setVisibility(8);
        if (animation != null) {
            linearLayout.startAnimation(animation);
        }
        if (z7) {
            progressBar.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            progressBar.startAnimation(alphaAnimation);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void c(int i5, int i6) {
        if (this.f154i) {
            return;
        }
        SeekBar seekBar = this.f151f;
        if (seekBar != null) {
            ProgressBar progressBar = this.f152g;
            if (i5 > 0) {
                seekBar.setEnabled(true);
                int max = (int) (((((double) i6) * 1.0d) / ((double) i5)) * ((double) seekBar.getMax()));
                seekBar.setProgress(max);
                progressBar.setProgress(max);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferedPercentage = this.f150a.f8974a.getBufferedPercentage();
            if (bufferedPercentage >= 95) {
                seekBar.setSecondaryProgress(seekBar.getMax());
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i7 = bufferedPercentage * 10;
                seekBar.setSecondaryProgress(i7);
                progressBar.setSecondaryProgress(i7);
            }
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(F5.c.e(i5));
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(F5.c.e(i6));
        }
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void d(int i5) {
        ImageView imageView = this.d;
        if (i5 == 10) {
            imageView.setSelected(false);
        } else if (i5 == 11) {
            imageView.setSelected(true);
        }
        Activity activityD = F5.c.d(getContext());
        if (activityD == null || !this.f150a.b.i()) {
            return;
        }
        int requestedOrientation = activityD.getRequestedOrientation();
        int cutoutHeight = this.f150a.b.getCutoutHeight();
        ProgressBar progressBar = this.f152g;
        LinearLayout linearLayout = this.e;
        if (requestedOrientation == 1) {
            linearLayout.setPadding(0, 0, 0, 0);
            progressBar.setPadding(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            linearLayout.setPadding(cutoutHeight, 0, 0, 0);
            progressBar.setPadding(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            linearLayout.setPadding(0, 0, cutoutHeight, 0);
            progressBar.setPadding(0, 0, cutoutHeight, 0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void e(int i5) {
        ProgressBar progressBar = this.f152g;
        ImageView imageView = this.f153h;
        switch (i5) {
            case -1:
            case 1:
            case 2:
            case 8:
                setVisibility(8);
                break;
            case 0:
            case 5:
                setVisibility(8);
                progressBar.setProgress(0);
                progressBar.setSecondaryProgress(0);
                SeekBar seekBar = this.f151f;
                seekBar.setProgress(0);
                seekBar.setSecondaryProgress(0);
                break;
            case 3:
                imageView.setSelected(true);
                boolean z6 = this.f155j;
                LinearLayout linearLayout = this.e;
                if (!z6) {
                    linearLayout.setVisibility(8);
                } else if (this.f150a.b.isShowing()) {
                    progressBar.setVisibility(8);
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                    progressBar.setVisibility(0);
                }
                setVisibility(0);
                this.f150a.g();
                break;
            case 4:
                imageView.setSelected(false);
                break;
            case 6:
                imageView.setSelected(this.f150a.f8974a.h());
                this.f150a.d();
                break;
            case 7:
                imageView.setSelected(this.f150a.f8974a.h());
                this.f150a.g();
                break;
        }
    }

    public int getLayoutId() {
        return B5.c.dkplayer_layout_vod_control_view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id != B5.b.fullscreen) {
            if (id == B5.b.iv_play) {
                xyz.doikki.videoplayer.controller.c cVar = this.f150a;
                if (cVar.f8974a.h()) {
                    cVar.pause();
                    return;
                } else {
                    cVar.start();
                    return;
                }
            }
            return;
        }
        Activity activityD = F5.c.d(getContext());
        xyz.doikki.videoplayer.controller.c cVar2 = this.f150a;
        cVar2.getClass();
        if (activityD == null || activityD.isFinishing()) {
            return;
        }
        if (cVar2.f8974a.e()) {
            activityD.setRequestedOrientation(1);
            cVar2.c();
        } else {
            activityD.setRequestedOrientation(0);
            cVar2.k();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i5, boolean z6) {
        if (z6) {
            long duration = (this.f150a.f8974a.getDuration() * ((long) i5)) / ((long) this.f151f.getMax());
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(F5.c.e((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.f154i = true;
        this.f150a.d();
        this.f150a.j();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.f150a.seekTo((int) ((this.f150a.f8974a.getDuration() * ((long) seekBar.getProgress())) / ((long) this.f151f.getMax())));
        this.f154i = false;
        this.f150a.g();
        this.f150a.f();
    }

    public k(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f155j = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(B5.b.fullscreen);
        this.d = imageView;
        imageView.setOnClickListener(this);
        this.e = (LinearLayout) findViewById(B5.b.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(B5.b.seekBar);
        this.f151f = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.b = (TextView) findViewById(B5.b.total_time);
        this.c = (TextView) findViewById(B5.b.curr_time);
        ImageView imageView2 = (ImageView) findViewById(B5.b.iv_play);
        this.f153h = imageView2;
        imageView2.setOnClickListener(this);
        this.f152g = (ProgressBar) findViewById(B5.b.bottom_progress);
    }

    public k(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f155j = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(B5.b.fullscreen);
        this.d = imageView;
        imageView.setOnClickListener(this);
        this.e = (LinearLayout) findViewById(B5.b.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(B5.b.seekBar);
        this.f151f = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.b = (TextView) findViewById(B5.b.total_time);
        this.c = (TextView) findViewById(B5.b.curr_time);
        ImageView imageView2 = (ImageView) findViewById(B5.b.iv_play);
        this.f153h = imageView2;
        imageView2.setOnClickListener(this);
        this.f152g = (ProgressBar) findViewById(B5.b.bottom_progress);
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public View getView() {
        return this;
    }
}
