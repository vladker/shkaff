package xyz.doikki.videoplayer.controller;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class d extends b implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f8975A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f8976C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f8977D;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f8978G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f8979H;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public GestureDetector f8980q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AudioManager f8981r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f8982s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f8983t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f8984u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8985v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8986w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f8987x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f8988y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f8989z;

    public d(@NonNull Context context) {
        super(context);
        this.f8982s = true;
        this.f8985v = -1;
        this.f8975A = true;
        this.f8979H = true;
    }

    @Override // xyz.doikki.videoplayer.controller.b
    public void h() {
        super.h();
        this.f8981r = (AudioManager) getContext().getSystemService("audio");
        this.f8980q = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }

    public final boolean m() {
        int i5;
        return (this.f8962a == null || (i5 = this.f8978G) == -1 || i5 == 0 || i5 == 1 || i5 == 2 || i5 == 8 || i5 == 5) ? false : true;
    }

    public final void n() {
        Iterator it = this.f8968k.entrySet().iterator();
        while (it.hasNext()) {
            e eVar = (e) ((Map.Entry) it.next()).getKey();
            if (eVar instanceof f) {
                C5.f fVar = (C5.f) ((f) eVar);
                fVar.e.animate().alpha(0.0f).setDuration(300L).setListener(new C5.e(fVar, 0)).start();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f8979H || this.c || !m()) {
            return true;
        }
        c cVar = this.f8962a;
        if (cVar.f8974a.h()) {
            cVar.pause();
            return true;
        }
        cVar.start();
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        if (m() && this.f8982s && !F5.c.c(motionEvent, getContext())) {
            this.f8983t = this.f8981r.getStreamVolume(3);
            Activity activityD = F5.c.d(getContext());
            if (activityD == null) {
                this.f8984u = 0.0f;
            } else {
                this.f8984u = activityD.getWindow().getAttributes().screenBrightness;
            }
            this.f8986w = true;
            this.f8987x = false;
            this.f8988y = false;
            this.f8989z = false;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        float f8;
        if (m() && this.f8982s && this.f8977D && !this.c && !F5.c.c(motionEvent, getContext())) {
            float x6 = motionEvent.getX() - motionEvent2.getX();
            float y6 = motionEvent.getY() - motionEvent2.getY();
            boolean z6 = this.f8986w;
            LinkedHashMap linkedHashMap = this.f8968k;
            if (z6) {
                boolean z7 = Math.abs(f6) >= Math.abs(f7);
                this.f8987x = z7;
                if (!z7) {
                    Context context = getContext();
                    if (motionEvent2.getX() > (F5.c.b(context) + context.getResources().getDisplayMetrics().widthPixels) / 2) {
                        this.f8989z = true;
                    } else {
                        this.f8988y = true;
                    }
                }
                if (this.f8987x) {
                    this.f8987x = this.f8975A;
                }
                if (this.f8987x || this.f8988y || this.f8989z) {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        e eVar = (e) ((Map.Entry) it.next()).getKey();
                        if (eVar instanceof f) {
                            C5.f fVar = (C5.f) ((f) eVar);
                            fVar.f144a.hide();
                            LinearLayout linearLayout = fVar.e;
                            linearLayout.setVisibility(0);
                            linearLayout.setAlpha(1.0f);
                        }
                    }
                }
                this.f8986w = false;
            }
            if (this.f8987x) {
                int measuredWidth = getMeasuredWidth();
                int duration = (int) this.f8962a.f8974a.getDuration();
                int currentPosition = (int) this.f8962a.f8974a.getCurrentPosition();
                int i5 = (int) ((((-x6) / measuredWidth) * 120000.0f) + currentPosition);
                if (i5 > duration) {
                    i5 = duration;
                }
                int i6 = i5 >= 0 ? i5 : 0;
                Iterator it2 = linkedHashMap.entrySet().iterator();
                while (it2.hasNext()) {
                    e eVar2 = (e) ((Map.Entry) it2.next()).getKey();
                    if (eVar2 instanceof f) {
                        C5.f fVar2 = (C5.f) ((f) eVar2);
                        ImageView imageView = fVar2.b;
                        fVar2.c.setVisibility(8);
                        if (i6 > currentPosition) {
                            imageView.setImageResource(B5.a.dkplayer_ic_action_fast_forward);
                        } else {
                            imageView.setImageResource(B5.a.dkplayer_ic_action_fast_rewind);
                        }
                        fVar2.d.setText(F5.c.e(i6) + PackagingURIHelper.FORWARD_SLASH_STRING + F5.c.e(duration));
                    }
                }
                this.f8985v = i6;
                return true;
            }
            if (this.f8988y) {
                Activity activityD = F5.c.d(getContext());
                if (activityD != null) {
                    Window window = activityD.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    int measuredHeight = getMeasuredHeight();
                    if (this.f8984u == -1.0f) {
                        this.f8984u = 0.5f;
                    }
                    float f9 = ((y6 * 2.0f) / measuredHeight) + this.f8984u;
                    f8 = f9 >= 0.0f ? f9 : 0.0f;
                    float f10 = f8 <= 1.0f ? f8 : 1.0f;
                    int i7 = (int) (100.0f * f10);
                    attributes.screenBrightness = f10;
                    window.setAttributes(attributes);
                    Iterator it3 = linkedHashMap.entrySet().iterator();
                    while (it3.hasNext()) {
                        e eVar3 = (e) ((Map.Entry) it3.next()).getKey();
                        if (eVar3 instanceof f) {
                            C5.f fVar3 = (C5.f) ((f) eVar3);
                            ProgressBar progressBar = fVar3.c;
                            progressBar.setVisibility(0);
                            fVar3.b.setImageResource(B5.a.dkplayer_ic_action_brightness);
                            fVar3.d.setText(i7 + "%");
                            progressBar.setProgress(i7);
                        }
                    }
                }
            } else if (this.f8989z) {
                float streamMaxVolume = this.f8981r.getStreamMaxVolume(3);
                float measuredHeight2 = this.f8983t + (((y6 * 2.0f) / getMeasuredHeight()) * streamMaxVolume);
                if (measuredHeight2 > streamMaxVolume) {
                    measuredHeight2 = streamMaxVolume;
                }
                f8 = measuredHeight2 >= 0.0f ? measuredHeight2 : 0.0f;
                int i8 = (int) ((f8 / streamMaxVolume) * 100.0f);
                this.f8981r.setStreamVolume(3, (int) f8, 0);
                Iterator it4 = linkedHashMap.entrySet().iterator();
                while (it4.hasNext()) {
                    e eVar4 = (e) ((Map.Entry) it4.next()).getKey();
                    if (eVar4 instanceof f) {
                        C5.f fVar4 = (C5.f) ((f) eVar4);
                        ImageView imageView2 = fVar4.b;
                        ProgressBar progressBar2 = fVar4.c;
                        progressBar2.setVisibility(0);
                        if (i8 <= 0) {
                            imageView2.setImageResource(B5.a.dkplayer_ic_action_volume_off);
                        } else {
                            imageView2.setImageResource(B5.a.dkplayer_ic_action_volume_up);
                        }
                        fVar4.d.setText(i8 + "%");
                        progressBar2.setProgress(i8);
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (!m()) {
            return true;
        }
        c cVar = this.f8962a;
        if (cVar.b.isShowing()) {
            cVar.hide();
            return true;
        }
        cVar.show();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f8980q.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f8980q.onTouchEvent(motionEvent)) {
            int action = motionEvent.getAction();
            if (action == 1) {
                n();
                int i5 = this.f8985v;
                if (i5 >= 0) {
                    this.f8962a.seekTo(i5);
                    this.f8985v = -1;
                }
            } else if (action == 3) {
                n();
                this.f8985v = -1;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCanChangePosition(boolean z6) {
        this.f8975A = z6;
    }

    public void setDoubleTapTogglePlayEnabled(boolean z6) {
        this.f8979H = z6;
    }

    public void setEnableInNormal(boolean z6) {
        this.f8976C = z6;
    }

    public void setGestureEnabled(boolean z6) {
        this.f8982s = z6;
    }

    @Override // xyz.doikki.videoplayer.controller.b
    public void setPlayState(int i5) {
        super.setPlayState(i5);
        this.f8978G = i5;
    }

    @Override // xyz.doikki.videoplayer.controller.b
    public void setPlayerState(int i5) {
        super.setPlayerState(i5);
        if (i5 == 10) {
            this.f8977D = this.f8976C;
        } else if (i5 == 11) {
            this.f8977D = true;
        }
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8982s = true;
        this.f8985v = -1;
        this.f8975A = true;
        this.f8979H = true;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f8982s = true;
        this.f8985v = -1;
        this.f8975A = true;
        this.f8979H = true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }
}
