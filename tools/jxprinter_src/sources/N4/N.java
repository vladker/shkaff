package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RestrictionTypeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class N implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f513a;
    public final /* synthetic */ RestrictionTypeImpl b;

    public /* synthetic */ N(RestrictionTypeImpl restrictionTypeImpl, int i5) {
        this.f513a = i5;
        this.b = restrictionTypeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f513a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeEnumeration(iIntValue);
                break;
            case 1:
                this.b.removeMinExclusive(iIntValue);
                break;
            case 2:
                this.b.removeMaxLength(iIntValue);
                break;
            case 3:
                this.b.removeAttributeGroup(iIntValue);
                break;
            case 4:
                this.b.removeMaxInclusive(iIntValue);
                break;
            case 5:
                this.b.removePattern(iIntValue);
                break;
            case 6:
                this.b.removeWhiteSpace(iIntValue);
                break;
            case 7:
                this.b.removeLength(iIntValue);
                break;
            case 8:
                this.b.removeMinInclusive(iIntValue);
                break;
            case 9:
                this.b.removeFractionDigits(iIntValue);
                break;
            case 10:
                this.b.removeMinLength(iIntValue);
                break;
            case 11:
                this.b.removeMaxExclusive(iIntValue);
                break;
            case 12:
                this.b.removeTotalDigits(iIntValue);
                break;
            default:
                this.b.removeAttribute(iIntValue);
                break;
        }
    }
}
