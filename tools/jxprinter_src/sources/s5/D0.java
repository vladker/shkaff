package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTHyperlinkImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class D0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8258a;
    public final /* synthetic */ CTHyperlinkImpl b;

    public /* synthetic */ D0(CTHyperlinkImpl cTHyperlinkImpl, int i5) {
        this.f8258a = i5;
        this.b = cTHyperlinkImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfFldSimpleArray;
        switch (this.f8258a) {
            case 0:
                iSizeOfFldSimpleArray = this.b.sizeOfFldSimpleArray();
                break;
            case 1:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveToArray();
                break;
            case 2:
                iSizeOfFldSimpleArray = this.b.sizeOfOMathParaArray();
                break;
            default:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlArray();
                break;
        }
        return Integer.valueOf(iSizeOfFldSimpleArray);
    }
}
