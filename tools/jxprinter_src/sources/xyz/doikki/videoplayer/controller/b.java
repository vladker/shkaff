package xyz.doikki.videoplayer.controller;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import xyz.doikki.videoplayer.player.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends FrameLayout implements g, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f8962a;
    public boolean b;
    public boolean c;
    public int d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f8963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f8965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f8968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AlphaAnimation f8969l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AlphaAnimation f8970m;

    @Nullable
    protected Activity mActivity;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f8971n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f8972o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8973p;

    public b(@NonNull Context context) {
        this(context, null);
    }

    public final void a(e... eVarArr) {
        for (e eVar : eVarArr) {
            this.f8968k.put(eVar, Boolean.FALSE);
            c cVar = this.f8962a;
            if (cVar != null) {
                eVar.attach(cVar);
            }
            View view = eVar.getView();
            if (view != null) {
                addView(view, 0);
            }
        }
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final boolean b() {
        return this.c;
    }

    public final void c(int i5) {
        Iterator it = this.f8968k.entrySet().iterator();
        while (it.hasNext()) {
            ((e) ((Map.Entry) it.next()).getKey()).d(i5);
        }
        onPlayerStateChanged(i5);
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void d() {
        if (this.f8967j) {
            removeCallbacks(this.f8972o);
            this.f8967j = false;
        }
    }

    public final void e(boolean z6, AlphaAnimation alphaAnimation) {
        if (!this.c) {
            Iterator it = this.f8968k.entrySet().iterator();
            while (it.hasNext()) {
                ((e) ((Map.Entry) it.next()).getKey()).b(z6, alphaAnimation);
            }
        }
        l(z6, alphaAnimation);
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void f() {
        j();
        postDelayed(this.f8971n, this.d);
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void g() {
        if (this.f8967j) {
            return;
        }
        post(this.f8972o);
        this.f8967j = true;
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public int getCutoutHeight() {
        return this.f8966i;
    }

    public abstract int getLayoutId();

    public void h() {
        if (getLayoutId() != 0) {
            LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        }
        this.f8963f = new j(getContext().getApplicationContext());
        l.a().getClass();
        this.e = false;
        l.a().getClass();
        this.f8964g = true;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f8969l = alphaAnimation;
        alphaAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.f8970m = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.mActivity = F5.c.d(getContext());
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void hide() {
        if (this.b) {
            j();
            e(false, this.f8970m);
            this.b = false;
        }
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final boolean i() {
        Boolean bool = this.f8965h;
        return bool != null && bool.booleanValue();
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final boolean isShowing() {
        return this.b;
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void j() {
        removeCallbacks(this.f8971n);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8964g) {
            Activity activity = this.mActivity;
            if (activity != null && this.f8965h == null) {
                boolean zB = F5.a.b(activity);
                this.f8965h = Boolean.valueOf(zB);
                if (zB) {
                    Activity activity2 = this.mActivity;
                    int identifier = activity2.getResources().getIdentifier("status_bar_height_portrait", "dimen", "android");
                    this.f8966i = identifier > 0 ? activity2.getResources().getDimensionPixelSize(identifier) : 0;
                }
            }
            int i5 = F5.b.f276a;
        }
    }

    @Override // xyz.doikki.videoplayer.controller.i
    @CallSuper
    public void onOrientationChanged(int i5) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        int i6 = this.f8973p;
        if (i5 == -1) {
            this.f8973p = -1;
            return;
        }
        if (i5 > 350 || i5 < 10) {
            if ((this.mActivity.getRequestedOrientation() == 0 && i6 == 0) || this.f8973p == 0) {
                return;
            }
            this.f8973p = 0;
            Activity activity2 = this.mActivity;
            if (!this.c && this.e) {
                activity2.setRequestedOrientation(1);
                this.f8962a.c();
                return;
            }
            return;
        }
        if (i5 > 80 && i5 < 100) {
            if ((this.mActivity.getRequestedOrientation() == 1 && i6 == 90) || this.f8973p == 90) {
                return;
            }
            this.f8973p = 90;
            this.mActivity.setRequestedOrientation(8);
            if (this.f8962a.f8974a.e()) {
                c(11);
                return;
            } else {
                this.f8962a.k();
                return;
            }
        }
        if (i5 <= 260 || i5 >= 280) {
            return;
        }
        if ((this.mActivity.getRequestedOrientation() == 1 && i6 == 270) || this.f8973p == 270) {
            return;
        }
        this.f8973p = 270;
        this.mActivity.setRequestedOrientation(0);
        if (this.f8962a.f8974a.e()) {
            c(11);
        } else {
            this.f8962a.k();
        }
    }

    @CallSuper
    public void onPlayStateChanged(int i5) {
        if (i5 == -1) {
            this.b = false;
            return;
        }
        if (i5 != 0) {
            if (i5 != 5) {
                return;
            }
            this.c = false;
            this.b = false;
            return;
        }
        this.f8963f.disable();
        this.f8973p = 0;
        this.c = false;
        this.b = false;
        Iterator it = this.f8968k.entrySet().iterator();
        while (it.hasNext()) {
            if (((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                it.remove();
            }
        }
    }

    @CallSuper
    public void onPlayerStateChanged(int i5) {
        switch (i5) {
            case 10:
                if (this.e) {
                    this.f8963f.enable();
                } else {
                    this.f8963f.disable();
                }
                if (i()) {
                    F5.a.a(getContext(), false);
                }
                break;
            case 11:
                this.f8963f.enable();
                if (i()) {
                    F5.a.a(getContext(), true);
                }
                break;
            case 12:
                this.f8963f.disable();
                break;
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z6) {
        super.onWindowFocusChanged(z6);
        if (this.f8962a.f8974a.h()) {
            if (this.e || this.f8962a.f8974a.e()) {
                if (z6) {
                    postDelayed(new a(this, 2), 800L);
                } else {
                    this.f8963f.disable();
                }
            }
        }
    }

    public void setAdaptCutout(boolean z6) {
        this.f8964g = z6;
    }

    public void setDismissTimeout(int i5) {
        if (i5 > 0) {
            this.d = i5;
        }
    }

    public void setEnableOrientation(boolean z6) {
        this.e = z6;
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public void setLocked(boolean z6) {
        this.c = z6;
        Iterator it = this.f8968k.entrySet().iterator();
        while (it.hasNext()) {
            ((e) ((Map.Entry) it.next()).getKey()).a(z6);
        }
        k(z6);
    }

    @CallSuper
    public void setMediaPlayer(h hVar) {
        this.f8962a = new c(hVar, this);
        Iterator it = this.f8968k.entrySet().iterator();
        while (it.hasNext()) {
            ((e) ((Map.Entry) it.next()).getKey()).attach(this.f8962a);
        }
        this.f8963f.b = this;
    }

    @CallSuper
    public void setPlayState(int i5) {
        Iterator it = this.f8968k.entrySet().iterator();
        while (it.hasNext()) {
            ((e) ((Map.Entry) it.next()).getKey()).e(i5);
        }
        onPlayStateChanged(i5);
    }

    @CallSuper
    public void setPlayerState(int i5) {
        c(i5);
    }

    @Override // xyz.doikki.videoplayer.controller.g
    public final void show() {
        if (this.b) {
            return;
        }
        e(true, this.f8969l);
        f();
        this.b = true;
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        super(context, attributeSet, i5);
        this.d = 4000;
        this.f8968k = new LinkedHashMap();
        this.f8971n = new a(this, 0);
        this.f8972o = new a(this, 1);
        this.f8973p = 0;
        h();
    }

    public void k(boolean z6) {
    }

    public void l(boolean z6, Animation animation) {
    }
}
