package p131x;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import io.reactivex.internal.operators.observable.C0953x2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8837a = 0;

    static {
        SmartRefreshLayout.setDefaultRefreshInitializer(new a());
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new C0953x2(9));
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new C0953x2(10));
    }
}
