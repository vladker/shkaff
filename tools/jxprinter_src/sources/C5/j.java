package C5;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class j extends FrameLayout implements xyz.doikki.videoplayer.controller.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xyz.doikki.videoplayer.controller.c f148a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;
    public final i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f149f;

    public j(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(B5.b.title_container);
        ((ImageView) findViewById(B5.b.back)).setOnClickListener(new c(this, 1));
        this.c = (TextView) findViewById(B5.b.title);
        this.d = (TextView) findViewById(B5.b.sys_time);
        this.e = new i((ImageView) findViewById(B5.b.iv_battery));
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void a(boolean z6) {
        if (z6) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.d.setText(F5.c.a());
        }
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public void attach(@NonNull xyz.doikki.videoplayer.controller.c cVar) {
        this.f148a = cVar;
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void b(boolean z6, Animation animation) {
        if (this.f148a.f8974a.e()) {
            if (!z6) {
                if (getVisibility() == 0) {
                    setVisibility(8);
                    if (animation != null) {
                        startAnimation(animation);
                        return;
                    }
                    return;
                }
                return;
            }
            if (getVisibility() == 8) {
                this.d.setText(F5.c.a());
                setVisibility(0);
                if (animation != null) {
                    startAnimation(animation);
                }
            }
        }
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void d(int i5) {
        TextView textView = this.c;
        if (i5 == 11) {
            if (this.f148a.b.isShowing() && !this.f148a.b.b()) {
                setVisibility(0);
                this.d.setText(F5.c.a());
            }
            textView.setSelected(true);
        } else {
            setVisibility(8);
            textView.setSelected(false);
        }
        Activity activityD = F5.c.d(getContext());
        if (activityD == null || !this.f148a.b.i()) {
            return;
        }
        int requestedOrientation = activityD.getRequestedOrientation();
        int cutoutHeight = this.f148a.b.getCutoutHeight();
        LinearLayout linearLayout = this.b;
        if (requestedOrientation == 1) {
            linearLayout.setPadding(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            linearLayout.setPadding(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            linearLayout.setPadding(0, 0, cutoutHeight, 0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void e(int i5) {
        if (i5 == -1 || i5 == 0 || i5 == 1 || i5 == 2 || i5 == 5 || i5 == 8) {
            setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f149f) {
            return;
        }
        getContext().registerReceiver(this.e, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f149f = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f149f) {
            getContext().unregisterReceiver(this.e);
            this.f149f = false;
        }
    }

    public void setTitle(String str) {
        this.c.setText(str);
    }

    public j(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(B5.b.title_container);
        ((ImageView) findViewById(B5.b.back)).setOnClickListener(new c(this, 1));
        this.c = (TextView) findViewById(B5.b.title);
        this.d = (TextView) findViewById(B5.b.sys_time);
        this.e = new i((ImageView) findViewById(B5.b.iv_battery));
    }

    public j(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(B5.c.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(B5.b.title_container);
        ((ImageView) findViewById(B5.b.back)).setOnClickListener(new c(this, 1));
        this.c = (TextView) findViewById(B5.b.title);
        this.d = (TextView) findViewById(B5.b.sys_time);
        this.e = new i((ImageView) findViewById(B5.b.iv_battery));
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public View getView() {
        return this;
    }

    @Override // xyz.doikki.videoplayer.controller.e
    public final void c(int i5, int i6) {
    }
}
