package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCfRuleImpl;

/* JADX INFO: renamed from: r5.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1580p implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8067a;
    public final /* synthetic */ CTCfRuleImpl b;

    public /* synthetic */ C1580p(CTCfRuleImpl cTCfRuleImpl, int i5) {
        this.f8067a = i5;
        this.b = cTCfRuleImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8067a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getFormulaArray(iIntValue);
            case 1:
                return this.b.xgetFormulaArray(iIntValue);
            default:
                return this.b.insertNewFormula(iIntValue);
        }
    }
}
