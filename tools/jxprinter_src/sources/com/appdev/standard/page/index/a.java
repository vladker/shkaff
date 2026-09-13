package com.appdev.standard.page.index;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2697a;
    public final /* synthetic */ IndexFragment b;

    public /* synthetic */ a(IndexFragment indexFragment, int i5) {
        this.f2697a = i5;
        this.b = indexFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2697a) {
            case 0:
                this.b.lambda$resetViewPagerToFirstPage$2();
                break;
            case 1:
                this.b.lambda$onViewCreated$0();
                break;
            default:
                this.b.lambda$onResume$3();
                break;
        }
    }
}
