package com.appdev.standard.page.printerlabel;

import android.content.DialogInterface;
import com.library.base.frame.MvpActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class A implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2710a;
    public final /* synthetic */ MvpActivity b;

    public /* synthetic */ A(MvpActivity mvpActivity, int i5) {
        this.f2710a = i5;
        this.b = mvpActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.f2710a) {
            case 0:
                ((PDFPrintActivity) this.b).lambda$startModelDownloadWithProgress$0(dialogInterface);
                break;
            default:
                ((PicturePrintActivity) this.b).lambda$startModelDownloadWithProgress$1(dialogInterface);
                break;
        }
    }
}
