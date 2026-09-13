package N4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.AnnotationDocumentImpl;

/* JADX INFO: renamed from: N4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0184b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f521a;
    public final /* synthetic */ AnnotationDocumentImpl.AnnotationImpl b;

    public /* synthetic */ C0184b(AnnotationDocumentImpl.AnnotationImpl annotationImpl, int i5) {
        this.f521a = i5;
        this.b = annotationImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f521a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setDocumentationArray(iIntValue, (DocumentationDocument.Documentation) obj2);
                break;
            default:
                this.b.setAppinfoArray(iIntValue, (AppinfoDocument.Appinfo) obj2);
                break;
        }
    }
}
