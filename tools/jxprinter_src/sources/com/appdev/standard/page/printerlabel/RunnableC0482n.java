package com.appdev.standard.page.printerlabel;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC0482n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2737a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Serializable c;
    public final /* synthetic */ Object d;

    public /* synthetic */ RunnableC0482n(MaterialLibraryPageActivity materialLibraryPageActivity, String str, MaterialLibraryPageActivity.JumpType jumpType) {
        this.f2737a = 2;
        this.b = materialLibraryPageActivity;
        this.d = str;
        this.c = jumpType;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2737a) {
            case 0:
                ((AttributeTextDataFragment.AnonymousClass3) this.b).lambda$onRequestPermissionSuccess$0((HashMap) this.c, (String) this.d);
                break;
            case 1:
                ((MaterialLibraryPageActivity) this.b).lambda$downloadPrintImage$0((MaterialLibraryPageActivity.JumpType) this.c, (File) this.d);
                break;
            default:
                ((MaterialLibraryPageActivity) this.b).lambda$downloadPrintImage$2((String) this.d, (MaterialLibraryPageActivity.JumpType) this.c);
                break;
        }
    }

    public /* synthetic */ RunnableC0482n(Object obj, Serializable serializable, Object obj2, int i5) {
        this.f2737a = i5;
        this.b = obj;
        this.c = serializable;
        this.d = obj2;
    }
}
