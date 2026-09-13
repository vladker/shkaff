package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RestrictionTypeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class L implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f511a;
    public final /* synthetic */ RestrictionTypeImpl b;

    public /* synthetic */ L(RestrictionTypeImpl restrictionTypeImpl, int i5) {
        this.f511a = i5;
        this.b = restrictionTypeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f511a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getWhiteSpaceArray(iIntValue);
            case 1:
                return this.b.getEnumerationArray(iIntValue);
            case 2:
                return this.b.insertNewEnumeration(iIntValue);
            case 3:
                return this.b.getMinExclusiveArray(iIntValue);
            case 4:
                return this.b.insertNewMinExclusive(iIntValue);
            case 5:
                return this.b.getMaxLengthArray(iIntValue);
            case 6:
                return this.b.insertNewMaxLength(iIntValue);
            case 7:
                return this.b.getAttributeGroupArray(iIntValue);
            case 8:
                return this.b.insertNewAttributeGroup(iIntValue);
            case 9:
                return this.b.insertNewWhiteSpace(iIntValue);
            case 10:
                return this.b.getMaxInclusiveArray(iIntValue);
            case 11:
                return this.b.insertNewMaxInclusive(iIntValue);
            case 12:
                return this.b.getPatternArray(iIntValue);
            case 13:
                return this.b.insertNewPattern(iIntValue);
            case 14:
                return this.b.getLengthArray(iIntValue);
            case 15:
                return this.b.insertNewLength(iIntValue);
            case 16:
                return this.b.getMinInclusiveArray(iIntValue);
            case 17:
                return this.b.insertNewMinInclusive(iIntValue);
            case 18:
                return this.b.getFractionDigitsArray(iIntValue);
            case 19:
                return this.b.insertNewFractionDigits(iIntValue);
            case 20:
                return this.b.getMinLengthArray(iIntValue);
            case 21:
                return this.b.insertNewMinLength(iIntValue);
            case 22:
                return this.b.getAttributeArray(iIntValue);
            case 23:
                return this.b.getMaxExclusiveArray(iIntValue);
            case 24:
                return this.b.insertNewMaxExclusive(iIntValue);
            case 25:
                return this.b.getTotalDigitsArray(iIntValue);
            case 26:
                return this.b.insertNewTotalDigits(iIntValue);
            default:
                return this.b.insertNewAttribute(iIntValue);
        }
    }
}
