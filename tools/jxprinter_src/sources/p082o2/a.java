package p082o2;

import android.view.View;
import com.library.base.view.refreshlayout.RefreshLayout;
import com.library.base.widget.AutoNullDisplayView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoNullDisplayView f6440a;

    public a(AutoNullDisplayView autoNullDisplayView) {
        this.f6440a = autoNullDisplayView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RefreshLayout refreshLayout = this.f6440a.e;
        if (refreshLayout != null) {
            refreshLayout.getClass();
        }
    }
}
