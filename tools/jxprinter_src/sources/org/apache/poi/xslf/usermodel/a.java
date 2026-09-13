package org.apache.poi.xslf.usermodel;

import java.util.function.Consumer;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7320a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f7320a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7320a) {
            case 0:
                ((XMLSlideShow) this.b).lambda$getPictureData$2((PackagePart) obj);
                break;
            case 1:
                ((XSLFGroupShape) this.b).removeShape((XSLFShape) obj);
                break;
            default:
                ((XSLFSheet) this.b).lambda$getTheme$1((POIXMLDocumentPart) obj);
                break;
        }
    }
}
