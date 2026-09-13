package p114u0;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8709a;

    public b(d dVar) {
        this.f8709a = dVar;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (i5 != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        d dVar = this.f8709a;
        dVar.c();
        if (dVar.c.getParent() == null && !dVar.f8714h) {
            return false;
        }
        dVar.a();
        return true;
    }
}
