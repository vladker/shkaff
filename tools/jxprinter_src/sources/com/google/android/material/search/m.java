package com.google.android.material.search;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3356a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m(Object obj, int i5) {
        this.f3356a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3356a) {
            case 0:
                ((SearchViewAnimationHelper) this.b).lambda$startShowAnimationExpand$0();
                break;
            case 1:
                ((SearchViewAnimationHelper) this.b).lambda$startShowAnimationTranslate$1();
                break;
            default:
                ((SearchBar) this.b).lambda$startOnLoadAnimation$1();
                break;
        }
    }
}
