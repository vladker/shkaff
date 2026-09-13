package com.appdev.standard.page.printerlabel;

import android.net.Uri;
import com.appdev.standard.page.printerlabel.util.DataCreateUtil;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class H implements DataCreateUtil.CreateBitmapEventListener, TemplateEditActivity.UploadImagesEvent, p056k0.j, LineProgressWidget.OnRangeUpListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2717a;
    public final /* synthetic */ Object b;

    public /* synthetic */ H(Object obj, int i5) {
        this.f2717a = i5;
        this.b = obj;
    }

    @Override // com.appdev.standard.page.printerlabel.util.DataCreateUtil.CreateBitmapEventListener
    public void onComplete(byte[] bArr) {
        ((PrintPageActivity.AnonymousClass5) this.b).lambda$run$0(bArr);
    }

    @Override // p056k0.j
    public void onImagePicked(Uri uri) {
        switch (this.f2717a) {
            case 2:
                ((AttributeMaterialDataFragment) this.b).lambda$selectPicture$0(uri);
                break;
            default:
                ((PicturePrintActivity) this.b).lambda$onAddImageClick$0(uri);
                break;
        }
    }

    @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
    public void onRangeUp(float f6) {
        ((AttributeTextStyleFragment) this.b).lambda$refreshUI$0(f6);
    }

    @Override // com.appdev.standard.page.printerlabel.TemplateEditActivity.UploadImagesEvent
    public void uploadSuccess() {
        ((TemplateEditActivity.AnonymousClass33) this.b).lambda$onSave$0();
    }
}
