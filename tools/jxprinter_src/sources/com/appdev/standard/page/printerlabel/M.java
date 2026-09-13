package com.appdev.standard.page.printerlabel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class M implements TemplateEditActivity.UploadImagesEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2722a;
    public final /* synthetic */ TemplateEditActivity b;

    public /* synthetic */ M(TemplateEditActivity templateEditActivity, int i5) {
        this.f2722a = i5;
        this.b = templateEditActivity;
    }

    @Override // com.appdev.standard.page.printerlabel.TemplateEditActivity.UploadImagesEvent
    public final void uploadSuccess() {
        switch (this.f2722a) {
            case 0:
                this.b.lambda$onSaveToPersonalSpaceClick$5();
                break;
            case 1:
                this.b.lambda$onPublishIndustryTemplateClick$9();
                break;
            case 2:
                this.b.lambda$onSaveToCloudLabelClick$6();
                break;
            case 3:
                this.b.lambda$onTemplateEditSaveClick$10();
                break;
            case 4:
                this.b.lambda$onPublishSquareClick$7();
                break;
            default:
                this.b.lambda$onLabelShareClick$8();
                break;
        }
    }
}
