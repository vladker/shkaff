package p102s;

import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final BaseControlView getCurView() {
        return k.curView;
    }

    public final void setCurView(BaseControlView baseControlView) {
        k.curView = baseControlView;
    }

    public final void setCurrentView(BaseControlView view) {
        E.f(view, "view");
        setCurView(view);
    }
}
