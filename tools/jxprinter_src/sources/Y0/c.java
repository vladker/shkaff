package Y0;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f871a = Integer.MAX_VALUE;
    public int b = 0;
    public final int c;
    public final WheelView d;

    public c(WheelView wheelView, int i5) {
        this.d = wheelView;
        this.c = i5;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f871a == Integer.MAX_VALUE) {
            this.f871a = this.c;
        }
        int i5 = this.f871a;
        int i6 = (int) (i5 * 0.1f);
        this.b = i6;
        if (i6 == 0) {
            if (i5 < 0) {
                this.b = -1;
            } else {
                this.b = 1;
            }
        }
        int iAbs = Math.abs(i5);
        WheelView wheelView = this.d;
        if (iAbs <= 1) {
            wheelView.a();
            wheelView.getHandler().sendEmptyMessage(3000);
            return;
        }
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.b);
        if (!wheelView.f3254z) {
            float itemHeight = wheelView.getItemHeight();
            float f6 = (-wheelView.getInitPosition()) * itemHeight;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView.getInitPosition()) * itemHeight;
            if (wheelView.getTotalScrollY() <= f6 || wheelView.getTotalScrollY() >= itemsCount) {
                wheelView.setTotalScrollY(wheelView.getTotalScrollY() - this.b);
                wheelView.a();
                wheelView.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        wheelView.getHandler().sendEmptyMessage(1000);
        this.f871a -= this.b;
    }
}
