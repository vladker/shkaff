package L1;

import android.content.Context;
import android.widget.OverScroller;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f425a;
    public int b;
    public int c;
    public final /* synthetic */ p d;

    public o(p pVar, Context context) {
        this.d = pVar;
        this.f425a = new OverScroller(context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        OverScroller overScroller = this.f425a;
        if (!overScroller.isFinished() && overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            p pVar = this.d;
            pVar.f434m.postTranslate(this.b - currX, this.c - currY);
            pVar.a();
            this.b = currX;
            this.c = currY;
            a.a(pVar.f429h, this);
        }
    }
}
