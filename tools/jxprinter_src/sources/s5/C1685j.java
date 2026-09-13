package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBdoContentRunImpl;

/* JADX INFO: renamed from: s5.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1685j implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8425a;
    public final /* synthetic */ CTBdoContentRunImpl b;

    public /* synthetic */ C1685j(CTBdoContentRunImpl cTBdoContentRunImpl, int i5) {
        this.f8425a = i5;
        this.b = cTBdoContentRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlInsRangeEndArray;
        switch (this.f8425a) {
            case 0:
                iSizeOfCustomXmlInsRangeEndArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 1:
                iSizeOfCustomXmlInsRangeEndArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 2:
                iSizeOfCustomXmlInsRangeEndArray = this.b.sizeOfRArray();
                break;
            default:
                iSizeOfCustomXmlInsRangeEndArray = this.b.sizeOfOMathArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlInsRangeEndArray);
    }
}
