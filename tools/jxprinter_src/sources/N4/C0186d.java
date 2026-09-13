package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.AnnotationDocumentImpl;

/* JADX INFO: renamed from: N4.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0186d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f523a;
    public final /* synthetic */ AnnotationDocumentImpl.AnnotationImpl b;

    public /* synthetic */ C0186d(AnnotationDocumentImpl.AnnotationImpl annotationImpl, int i5) {
        this.f523a = i5;
        this.b = annotationImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfDocumentationArray;
        switch (this.f523a) {
            case 0:
                iSizeOfDocumentationArray = this.b.sizeOfDocumentationArray();
                break;
            default:
                iSizeOfDocumentationArray = this.b.sizeOfAppinfoArray();
                break;
        }
        return Integer.valueOf(iSizeOfDocumentationArray);
    }
}
