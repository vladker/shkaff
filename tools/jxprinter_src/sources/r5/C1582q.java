package r5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCfRuleImpl;

/* JADX INFO: renamed from: r5.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1582q implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8069a;
    public final /* synthetic */ CTCfRuleImpl b;

    public /* synthetic */ C1582q(CTCfRuleImpl cTCfRuleImpl, int i5) {
        this.f8069a = i5;
        this.b = cTCfRuleImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8069a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setFormulaArray(iIntValue, (String) obj2);
                break;
            case 1:
                this.b.insertFormula(iIntValue, (String) obj2);
                break;
            default:
                this.b.xsetFormulaArray(iIntValue, (STFormula) obj2);
                break;
        }
    }
}
