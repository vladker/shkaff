package androidx.activity;

import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporterKt {

    /* JADX INFO: renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @G3.f(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", i = {0}, l = {173}, m = "reportWhenComplete", n = {"$this$reportWhenComplete"}, s = {"L$0"})
    public static final class AnonymousClass1 extends G3.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(E3.g<? super AnonymousClass1> gVar) {
            super(gVar);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, z3.Q] */
    public static final Object reportWhenComplete(FullyDrawnReporter fullyDrawnReporter, O3.l lVar, E3.g<? super Q> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FullyDrawnReporter fullyDrawnReporter2;
        if (gVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) gVar;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(gVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(gVar);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                fullyDrawnReporter.addReporter();
                if (fullyDrawnReporter.isFullyDrawnReported()) {
                    return Q.INSTANCE;
                }
                anonymousClass1.L$0 = fullyDrawnReporter;
                anonymousClass1.label = 1;
                if (lVar.invoke(anonymousClass1) == coroutine_suspended) {
                    fullyDrawnReporter2 = fullyDrawnReporter;
                    return coroutine_suspended;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FullyDrawnReporter fullyDrawnReporter3 = (FullyDrawnReporter) anonymousClass1.L$0;
                v.throwOnFailure(obj);
                fullyDrawnReporter2 = fullyDrawnReporter3;
            }
            fullyDrawnReporter2 = fullyDrawnReporter;
            fullyDrawnReporter2.removeReporter();
            fullyDrawnReporter = Q.INSTANCE;
            return fullyDrawnReporter;
        } catch (Throwable th) {
            fullyDrawnReporter.removeReporter();
            throw th;
        }
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, O3.l lVar, E3.g<? super Q> gVar) {
        fullyDrawnReporter.addReporter();
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return Q.INSTANCE;
        }
        try {
            lVar.invoke(gVar);
            return Q.INSTANCE;
        } finally {
            fullyDrawnReporter.removeReporter();
        }
    }
}
