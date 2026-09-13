package p044h4;

import O3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements f {
    private final Object clauseObject;
    private final q onCancellationConstructor;
    private final q processResFunc = r.DUMMY_PROCESS_RESULT_FUNCTION;
    private final q regFunc;

    public g(Object obj, q qVar, q qVar2) {
        this.clauseObject = obj;
        this.regFunc = qVar;
        this.onCancellationConstructor = qVar2;
    }

    @Override // p044h4.f, p044h4.l
    public Object getClauseObject() {
        return this.clauseObject;
    }

    @Override // p044h4.f, p044h4.l
    public q getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    @Override // p044h4.f, p044h4.l
    public q getProcessResFunc() {
        return this.processResFunc;
    }

    @Override // p044h4.f, p044h4.l
    public q getRegFunc() {
        return this.regFunc;
    }
}
