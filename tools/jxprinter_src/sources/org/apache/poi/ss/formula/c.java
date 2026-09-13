package org.apache.poi.ss.formula;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements OperatorEnum.CompareOp, IStabilityClassifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7198a;

    public /* synthetic */ c(int i5) {
        this.f7198a = i5;
    }

    @Override // org.apache.poi.ss.formula.IStabilityClassifier
    public boolean isCellFinal(int i5, int i6, int i7) {
        return IStabilityClassifier.lambda$static$0(i5, i6, i7);
    }

    @Override // org.apache.poi.ss.formula.OperatorEnum.CompareOp
    public boolean isValid(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        switch (this.f7198a) {
            case 0:
                return OperatorEnum.noComp(comparable, comparable2, comparable3);
            case 1:
                return OperatorEnum.between(comparable, comparable2, comparable3);
            case 2:
                return OperatorEnum.notBetween(comparable, comparable2, comparable3);
            case 3:
                return OperatorEnum.equalCheck(comparable, comparable2, comparable3);
            case 4:
                return OperatorEnum.notEqual(comparable, comparable2, comparable3);
            case 5:
                return OperatorEnum.greaterThan(comparable, comparable2, comparable3);
            case 6:
                return OperatorEnum.lessThan(comparable, comparable2, comparable3);
            case 7:
                return OperatorEnum.greaterOrEqual(comparable, comparable2, comparable3);
            default:
                return OperatorEnum.lessOrEqual(comparable, comparable2, comparable3);
        }
    }
}
