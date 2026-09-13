package org.apache.poi.ss.formula.eval;

import java.util.function.BiFunction;
import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7201a;
    public final /* synthetic */ Fixed2ArgFunction b;

    public /* synthetic */ b(Fixed2ArgFunction fixed2ArgFunction, int i5) {
        this.f7201a = i5;
        this.b = fixed2ArgFunction;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f7201a) {
            case 0:
                return ((RelationalOperationEval) this.b).lambda$evaluateArray$0((ValueEval) obj, (ValueEval) obj2);
            default:
                return ((TwoOperandNumericOperation) this.b).lambda$evaluateArray$0((ValueEval) obj, (ValueEval) obj2);
        }
    }
}
