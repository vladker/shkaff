package p044h4;

import E3.g;
import O3.l;
import O3.q;
import p028e4.H;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4038a = 0;
    private static final q DUMMY_PROCESS_RESULT_FUNCTION = q.f4037a;
    private static final H STATE_REG = new H("STATE_REG");
    private static final H STATE_COMPLETED = new H("STATE_COMPLETED");
    private static final H STATE_CANCELLED = new H("STATE_CANCELLED");
    private static final H NO_RESULT = new H("NO_RESULT");
    private static final H PARAM_CLAUSE_0 = new H("PARAM_CLAUSE_0");

    public static final H getPARAM_CLAUSE_0() {
        return PARAM_CLAUSE_0;
    }

    public static final <R> Object select(l lVar, g<? super R> gVar) {
        m mVar = new m(gVar.getContext());
        lVar.invoke(mVar);
        return mVar.doSelect(gVar);
    }

    public static /* synthetic */ void OnCancellationConstructor$annotations() {
    }

    public static /* synthetic */ void ProcessResultFunction$annotations() {
    }

    public static /* synthetic */ void RegistrationFunction$annotations() {
    }
}
