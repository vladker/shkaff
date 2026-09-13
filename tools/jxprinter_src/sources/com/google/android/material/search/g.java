package com.google.android.material.search;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3351a;
    public final /* synthetic */ SearchView b;

    public /* synthetic */ g(SearchView searchView, int i5) {
        this.f3351a = i5;
        this.b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3351a) {
            case 0:
                this.b.lambda$clearFocusAndHideKeyboard$9();
                break;
            case 1:
                this.b.lambda$requestFocusAndShowKeyboard$8();
                break;
            case 2:
                this.b.show();
                break;
            default:
                this.b.requestFocusAndShowKeyboardIfNeeded();
                break;
        }
    }
}
