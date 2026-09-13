package p044h4;

import O3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements j {
    private final Object clauseObject;
    private final q onCancellationConstructor;
    private final q processResFunc;
    private final q regFunc;

    public k(Object obj, q qVar, q qVar2, q qVar3) {
        this.clauseObject = obj;
        this.regFunc = qVar;
        this.processResFunc = qVar2;
        this.onCancellationConstructor = qVar3;
    }

    @Override // p044h4.j, p044h4.l
    public Object getClauseObject() {
        return this.clauseObject;
    }

    @Override // p044h4.j, p044h4.l
    public q getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    @Override // p044h4.j, p044h4.l
    public q getProcessResFunc() {
        return this.processResFunc;
    }

    @Override // p044h4.j, p044h4.l
    public q getRegFunc() {
        return this.regFunc;
    }
}
