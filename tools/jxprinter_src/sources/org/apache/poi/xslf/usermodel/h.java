package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements XSLFTextParagraph.Procedure {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7327a;
    public final /* synthetic */ CTTextParagraphProperties b;

    public /* synthetic */ h(CTTextParagraphProperties cTTextParagraphProperties, int i5) {
        this.f7327a = i5;
        this.b = cTTextParagraphProperties;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextParagraph.Procedure
    public final void accept() {
        switch (this.f7327a) {
            case 0:
                this.b.unsetSpcBef();
                break;
            case 1:
                this.b.unsetLnSpc();
                break;
            default:
                this.b.unsetSpcAft();
                break;
        }
    }
}
