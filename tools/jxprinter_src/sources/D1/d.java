package D1;

import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PDFView f166a;
    public ValueAnimator b;
    public OverScroller c;
    public boolean d;
    public boolean e;

    public final void a() {
        this.f166a.getScrollHandle();
    }

    public final void b(float f6, float f7) {
        e();
        this.b = ValueAnimator.ofFloat(f6, f7);
        a aVar = new a(this);
        this.b.setInterpolator(new DecelerateInterpolator());
        this.b.addUpdateListener(aVar);
        this.b.addListener(aVar);
        this.b.setDuration(400L);
        this.b.start();
    }

    public final void c(float f6, float f7) {
        e();
        this.b = ValueAnimator.ofFloat(f6, f7);
        b bVar = new b(this);
        this.b.setInterpolator(new DecelerateInterpolator());
        this.b.addUpdateListener(bVar);
        this.b.addListener(bVar);
        this.b.setDuration(400L);
        this.b.start();
    }

    public final void d(float f6, float f7, float f8, float f9) {
        e();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f8, f9);
        this.b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        c cVar = new c(this, f6, f7);
        this.b.addUpdateListener(cVar);
        this.b.addListener(cVar);
        this.b.setDuration(400L);
        this.b.start();
    }

    public final void e() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.b = null;
        }
        this.d = false;
        this.c.forceFinished(true);
    }
}
