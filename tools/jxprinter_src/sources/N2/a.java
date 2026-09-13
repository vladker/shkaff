package N2;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements AppBarLayout.OnOffsetChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ O2.a f498a;

    public a(O2.a aVar) {
        this.f498a = aVar;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i5) {
        boolean z6 = i5 >= 0;
        boolean z7 = appBarLayout.getTotalScrollRange() + i5 <= 0;
        O2.a aVar = this.f498a;
        aVar.f553g = z6;
        aVar.f554h = z7;
    }
}
