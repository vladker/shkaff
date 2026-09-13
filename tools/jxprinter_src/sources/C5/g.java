package C5;

import android.view.View;
import xyz.doikki.videoplayer.player.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f145a;
    public final /* synthetic */ h b;

    public /* synthetic */ g(h hVar, int i5) {
        this.f145a = i5;
        this.b = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f145a) {
            case 0:
                h hVar = this.b;
                hVar.e.setVisibility(8);
                l.b().f9009a = true;
                hVar.f146a.start();
                break;
            default:
                this.b.f146a.start();
                break;
        }
    }
}
