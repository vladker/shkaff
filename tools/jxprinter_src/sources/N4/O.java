package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RestrictionTypeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class O implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f514a;
    public final /* synthetic */ RestrictionTypeImpl b;

    public /* synthetic */ O(RestrictionTypeImpl restrictionTypeImpl, int i5) {
        this.f514a = i5;
        this.b = restrictionTypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfEnumerationArray;
        switch (this.f514a) {
            case 0:
                iSizeOfEnumerationArray = this.b.sizeOfEnumerationArray();
                break;
            case 1:
                iSizeOfEnumerationArray = this.b.sizeOfMinExclusiveArray();
                break;
            case 2:
                iSizeOfEnumerationArray = this.b.sizeOfMaxLengthArray();
                break;
            case 3:
                iSizeOfEnumerationArray = this.b.sizeOfAttributeGroupArray();
                break;
            case 4:
                iSizeOfEnumerationArray = this.b.sizeOfMaxInclusiveArray();
                break;
            case 5:
                iSizeOfEnumerationArray = this.b.sizeOfPatternArray();
                break;
            case 6:
                iSizeOfEnumerationArray = this.b.sizeOfLengthArray();
                break;
            case 7:
                iSizeOfEnumerationArray = this.b.sizeOfMinInclusiveArray();
                break;
            case 8:
                iSizeOfEnumerationArray = this.b.sizeOfWhiteSpaceArray();
                break;
            case 9:
                iSizeOfEnumerationArray = this.b.sizeOfFractionDigitsArray();
                break;
            case 10:
                iSizeOfEnumerationArray = this.b.sizeOfMinLengthArray();
                break;
            case 11:
                iSizeOfEnumerationArray = this.b.sizeOfMaxExclusiveArray();
                break;
            case 12:
                iSizeOfEnumerationArray = this.b.sizeOfTotalDigitsArray();
                break;
            default:
                iSizeOfEnumerationArray = this.b.sizeOfAttributeArray();
                break;
        }
        return Integer.valueOf(iSizeOfEnumerationArray);
    }
}
