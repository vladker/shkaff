package org.apache.commons.math3.dfp;

import org.apache.commons.math3.analysis.RealFieldUnivariateFunction;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BracketingNthOrderBrentSolverDFP extends FieldBracketingNthOrderBrentSolver<Dfp> {
    public BracketingNthOrderBrentSolverDFP(Dfp dfp, Dfp dfp2, Dfp dfp3, int i5) {
        super(dfp, dfp2, dfp3, i5);
    }

    public Dfp solve(int i5, UnivariateDfpFunction univariateDfpFunction, Dfp dfp, Dfp dfp2, AllowedSolution allowedSolution) {
        return solve(i5, univariateDfpFunction, dfp, dfp2, dfp.add(dfp2).divide(2), allowedSolution);
    }

    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public Dfp getAbsoluteAccuracy() {
        return (Dfp) super.getAbsoluteAccuracy();
    }

    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public Dfp getFunctionValueAccuracy() {
        return (Dfp) super.getFunctionValueAccuracy();
    }

    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public Dfp getRelativeAccuracy() {
        return (Dfp) super.getRelativeAccuracy();
    }

    public Dfp solve(int i5, final UnivariateDfpFunction univariateDfpFunction, Dfp dfp, Dfp dfp2, Dfp dfp3, AllowedSolution allowedSolution) {
        MathUtils.checkNotNull(univariateDfpFunction);
        return solve(i5, new RealFieldUnivariateFunction<Dfp>() { // from class: org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.1
            @Override // org.apache.commons.math3.analysis.RealFieldUnivariateFunction
            public Dfp value(Dfp dfp4) {
                return univariateDfpFunction.value(dfp4);
            }
        }, dfp, dfp2, dfp3, allowedSolution);
    }
}
