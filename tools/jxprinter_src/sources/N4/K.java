package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RestrictionDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class K implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f510a;
    public final /* synthetic */ RestrictionDocumentImpl.RestrictionImpl b;

    public /* synthetic */ K(RestrictionDocumentImpl.RestrictionImpl restrictionImpl, int i5) {
        this.f510a = i5;
        this.b = restrictionImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfPatternArray;
        switch (this.f510a) {
            case 0:
                iSizeOfPatternArray = this.b.sizeOfPatternArray();
                break;
            case 1:
                iSizeOfPatternArray = this.b.sizeOfTotalDigitsArray();
                break;
            case 2:
                iSizeOfPatternArray = this.b.sizeOfLengthArray();
                break;
            case 3:
                iSizeOfPatternArray = this.b.sizeOfFractionDigitsArray();
                break;
            case 4:
                iSizeOfPatternArray = this.b.sizeOfMinInclusiveArray();
                break;
            case 5:
                iSizeOfPatternArray = this.b.sizeOfMaxLengthArray();
                break;
            case 6:
                iSizeOfPatternArray = this.b.sizeOfMinExclusiveArray();
                break;
            case 7:
                iSizeOfPatternArray = this.b.sizeOfEnumerationArray();
                break;
            case 8:
                iSizeOfPatternArray = this.b.sizeOfWhiteSpaceArray();
                break;
            case 9:
                iSizeOfPatternArray = this.b.sizeOfMaxExclusiveArray();
                break;
            case 10:
                iSizeOfPatternArray = this.b.sizeOfMinLengthArray();
                break;
            default:
                iSizeOfPatternArray = this.b.sizeOfMaxInclusiveArray();
                break;
        }
        return Integer.valueOf(iSizeOfPatternArray);
    }
}
