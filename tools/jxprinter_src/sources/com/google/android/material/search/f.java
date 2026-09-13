package com.google.android.material.search;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3350a;
    public final /* synthetic */ SearchView b;

    public /* synthetic */ f(SearchView searchView, int i5) {
        this.f3350a = i5;
        this.b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3350a) {
            case 0:
                this.b.lambda$setUpBackButton$1(view);
                break;
            case 1:
                this.b.lambda$setUpClearButton$2(view);
                break;
            default:
                this.b.lambda$setupWithSearchBar$7(view);
                break;
        }
    }
}
