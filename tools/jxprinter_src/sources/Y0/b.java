package Y0;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f870a;

    public b(WheelView wheelView) {
        this.f870a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i5 = message.what;
        WheelView wheelView = this.f870a;
        if (i5 == 1000) {
            wheelView.invalidate();
            return;
        }
        if (i5 == 2000) {
            wheelView.f(2);
        } else if (i5 == 3000 && wheelView.e != null) {
            wheelView.postDelayed(new H2.c(wheelView, 5), 200L);
        }
    }
}
