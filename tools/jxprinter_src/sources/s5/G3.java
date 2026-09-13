package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSmartTagRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class G3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8276a;
    public final /* synthetic */ CTSmartTagRunImpl b;

    public /* synthetic */ G3(CTSmartTagRunImpl cTSmartTagRunImpl, int i5) {
        this.f8276a = i5;
        this.b = cTSmartTagRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlMoveToRangeEndArray;
        switch (this.f8276a) {
            case 0:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 1:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfInsArray();
                break;
            case 2:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfSmartTagArray();
                break;
            default:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfDelArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlMoveToRangeEndArray);
    }
}
