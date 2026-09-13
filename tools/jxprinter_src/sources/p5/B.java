package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class B implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7771a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ B(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7771a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7771a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 1:
                return this.b.insertNewPermEnd(iIntValue);
            case 2:
                return this.b.getOMathArray(iIntValue);
            case 3:
                return this.b.insertNewOMath(iIntValue);
            case 4:
                return this.b.getCustomXmlArray(iIntValue);
            case 5:
                return this.b.insertNewCustomXml(iIntValue);
            case 6:
                return this.b.getEqArrArray(iIntValue);
            case 7:
                return this.b.insertNewEqArr(iIntValue);
            case 8:
                return this.b.getSSubSupArray(iIntValue);
            default:
                return this.b.insertNewSSubSup(iIntValue);
        }
    }
}
