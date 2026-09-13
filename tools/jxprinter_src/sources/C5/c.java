package C5;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.widget.BottomTabWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f141a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f141a = i5;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i5 = this.f141a;
        Object obj = this.b;
        switch (i5) {
            case 0:
                d dVar = (d) obj;
                dVar.setVisibility(8);
                dVar.c.a(false);
                break;
            case 1:
                j jVar = (j) obj;
                Activity activityD = F5.c.d(jVar.getContext());
                if (activityD != null && jVar.f148a.f8974a.e()) {
                    activityD.setRequestedOrientation(1);
                    jVar.f148a.c();
                    break;
                }
                break;
            case 2:
                U0.c cVar = (U0.c) obj;
                if (cVar.getLoadMoreStatus() == T0.b.c) {
                    cVar.b();
                } else if (cVar.getLoadMoreStatus() != T0.b.f700a) {
                    cVar.getClass();
                } else {
                    cVar.b();
                }
                break;
            case 3:
                if (view instanceof LinearLayout) {
                    int i6 = BottomTabWidget.f2849k;
                    ((BottomTabWidget) obj).b((LinearLayout) view);
                }
                break;
            default:
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_MATERIAL_LIBRARY_PAGE).withString("path", (String) obj).navigation();
                break;
        }
    }
}
