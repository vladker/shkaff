package C5;

import android.app.Activity;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f139a;
    public final /* synthetic */ b b;

    public /* synthetic */ a(b bVar, int i5) {
        this.f139a = i5;
        this.b = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activityD;
        switch (this.f139a) {
            case 0:
                this.b.f140a.a(true);
                break;
            default:
                b bVar = this.b;
                if (bVar.f140a.f8974a.e() && (activityD = F5.c.d(bVar.getContext())) != null && !activityD.isFinishing()) {
                    activityD.setRequestedOrientation(1);
                    bVar.f140a.c();
                    break;
                }
                break;
        }
    }
}
