package androidx.core.content.res;

import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1004a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, int i5, int i6) {
        this.f1004a = i6;
        this.c = obj;
        this.b = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1004a) {
            case 0:
                ((ResourcesCompat.FontCallback) this.c).lambda$callbackFailAsync$1(this.b);
                break;
            default:
                ((SideSheetBehavior) this.c).lambda$setState$0(this.b);
                break;
        }
    }
}
