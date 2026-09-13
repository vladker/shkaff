package N4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RestrictionDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class I implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f508a;
    public final /* synthetic */ RestrictionDocumentImpl.RestrictionImpl b;

    public /* synthetic */ I(RestrictionDocumentImpl.RestrictionImpl restrictionImpl, int i5) {
        this.f508a = i5;
        this.b = restrictionImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f508a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setPatternArray(iIntValue, (PatternDocument.Pattern) obj2);
                break;
            case 1:
                this.b.setTotalDigitsArray(iIntValue, (TotalDigitsDocument.TotalDigits) obj2);
                break;
            case 2:
                this.b.setWhiteSpaceArray(iIntValue, (WhiteSpaceDocument.WhiteSpace) obj2);
                break;
            case 3:
                this.b.setLengthArray(iIntValue, (NumFacet) obj2);
                break;
            case 4:
                this.b.setFractionDigitsArray(iIntValue, (NumFacet) obj2);
                break;
            case 5:
                this.b.setMinInclusiveArray(iIntValue, (Facet) obj2);
                break;
            case 6:
                this.b.setMaxLengthArray(iIntValue, (NumFacet) obj2);
                break;
            case 7:
                this.b.setMinExclusiveArray(iIntValue, (Facet) obj2);
                break;
            case 8:
                this.b.setEnumerationArray(iIntValue, (NoFixedFacet) obj2);
                break;
            case 9:
                this.b.setMaxExclusiveArray(iIntValue, (Facet) obj2);
                break;
            case 10:
                this.b.setMinLengthArray(iIntValue, (NumFacet) obj2);
                break;
            default:
                this.b.setMaxInclusiveArray(iIntValue, (Facet) obj2);
                break;
        }
    }
}
