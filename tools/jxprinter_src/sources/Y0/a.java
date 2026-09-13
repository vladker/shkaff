package Y0;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f869a = 2.1474836E9f;
    public final float b;
    public final WheelView c;

    public a(WheelView wheelView, float f6) {
        this.c = wheelView;
        this.b = f6;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f869a == 2.1474836E9f) {
            float f6 = this.b;
            if (Math.abs(f6) > 2000.0f) {
                this.f869a = f6 <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f869a = f6;
            }
        }
        float fAbs = Math.abs(this.f869a);
        WheelView wheelView = this.c;
        if (fAbs >= 0.0f && Math.abs(this.f869a) <= 20.0f) {
            wheelView.a();
            wheelView.getHandler().sendEmptyMessage(2000);
            return;
        }
        float f7 = (int) (this.f869a / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f7);
        if (!wheelView.f3254z) {
            float itemHeight = wheelView.getItemHeight();
            float totalScrollY = (-wheelView.getInitPosition()) * itemHeight;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView.getInitPosition()) * itemHeight;
            double d = ((double) itemHeight) * 0.25d;
            if (((double) wheelView.getTotalScrollY()) - d < totalScrollY) {
                totalScrollY = wheelView.getTotalScrollY() + f7;
            } else if (((double) wheelView.getTotalScrollY()) + d > itemsCount) {
                itemsCount = wheelView.getTotalScrollY() + f7;
            }
            if (wheelView.getTotalScrollY() <= totalScrollY) {
                this.f869a = 40.0f;
                wheelView.setTotalScrollY((int) totalScrollY);
            } else if (wheelView.getTotalScrollY() >= itemsCount) {
                wheelView.setTotalScrollY((int) itemsCount);
                this.f869a = -40.0f;
            }
        }
        float f8 = this.f869a;
        if (f8 < 0.0f) {
            this.f869a = f8 + 20.0f;
        } else {
            this.f869a = f8 - 20.0f;
        }
        wheelView.getHandler().sendEmptyMessage(1000);
    }
}
