package org.apache.poi.xslf.usermodel;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7325a;
    public final /* synthetic */ CTTextParagraphProperties b;

    public /* synthetic */ f(CTTextParagraphProperties cTTextParagraphProperties, int i5) {
        this.f7325a = i5;
        this.b = cTTextParagraphProperties;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7325a) {
            case 0:
                return this.b.addNewSpcBef();
            case 1:
                return this.b.addNewLnSpc();
            case 2:
                return this.b.getSpcBef();
            case 3:
                return this.b.getSpcAft();
            case 4:
                return this.b.addNewSpcAft();
            default:
                return this.b.getLnSpc();
        }
    }
}
