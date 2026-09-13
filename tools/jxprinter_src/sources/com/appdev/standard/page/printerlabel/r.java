package com.appdev.standard.page.printerlabel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2741a;
    public final /* synthetic */ AttributeTextFontFragment.AnonymousClass5.AnonymousClass1 b;

    public /* synthetic */ r(AttributeTextFontFragment.AnonymousClass5.AnonymousClass1 anonymousClass1, int i5) {
        this.f2741a = i5;
        this.b = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2741a) {
            case 0:
                this.b.lambda$onError$0();
                break;
            default:
                this.b.lambda$onStart$1();
                break;
        }
    }
}
