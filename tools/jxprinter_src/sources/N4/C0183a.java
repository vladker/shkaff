package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.AnnotationDocumentImpl;

/* JADX INFO: renamed from: N4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0183a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f520a;
    public final /* synthetic */ AnnotationDocumentImpl.AnnotationImpl b;

    public /* synthetic */ C0183a(AnnotationDocumentImpl.AnnotationImpl annotationImpl, int i5) {
        this.f520a = i5;
        this.b = annotationImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f520a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getDocumentationArray(iIntValue);
            case 1:
                return this.b.insertNewDocumentation(iIntValue);
            case 2:
                return this.b.getAppinfoArray(iIntValue);
            default:
                return this.b.insertNewAppinfo(iIntValue);
        }
    }
}
