package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextParagraphImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class k2 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6017a;
    public final /* synthetic */ CTTextParagraphImpl b;

    public /* synthetic */ k2(CTTextParagraphImpl cTTextParagraphImpl, int i5) {
        this.f6017a = i5;
        this.b = cTTextParagraphImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfRArray;
        switch (this.f6017a) {
            case 0:
                iSizeOfRArray = this.b.sizeOfRArray();
                break;
            case 1:
                iSizeOfRArray = this.b.sizeOfFldArray();
                break;
            default:
                iSizeOfRArray = this.b.sizeOfBrArray();
                break;
        }
        return Integer.valueOf(iSizeOfRArray);
    }
}
