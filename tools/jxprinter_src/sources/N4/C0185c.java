package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.AnnotationDocumentImpl;

/* JADX INFO: renamed from: N4.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0185c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f522a;
    public final /* synthetic */ AnnotationDocumentImpl.AnnotationImpl b;

    public /* synthetic */ C0185c(AnnotationDocumentImpl.AnnotationImpl annotationImpl, int i5) {
        this.f522a = i5;
        this.b = annotationImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f522a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeDocumentation(iIntValue);
                break;
            default:
                this.b.removeAppinfo(iIntValue);
                break;
        }
    }
}
