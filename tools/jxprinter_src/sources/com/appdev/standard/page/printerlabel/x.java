package com.appdev.standard.page.printerlabel;

import android.net.Uri;
import androidx.activity.result.ActivityResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2821a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Comparable c;

    public /* synthetic */ x(Object obj, Comparable comparable, int i5) {
        this.f2821a = i5;
        this.b = obj;
        this.c = comparable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2821a) {
            case 0:
                ElementAllFragment.AnonymousClass6.lambda$onRequestPermissionSuccess$0((ActivityResult) this.b, (String) this.c);
                break;
            case 1:
                ((AttributeTextDataFragment) this.b).lambda$selectPicture$6((Uri) this.c);
                break;
            default:
                ((MaterialLibraryPageActivity) this.b).lambda$downloadAndSaveImage$6((String) this.c);
                break;
        }
    }
}
