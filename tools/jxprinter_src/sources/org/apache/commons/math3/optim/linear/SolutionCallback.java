package org.apache.commons.math3.optim.linear;

import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SolutionCallback implements OptimizationData {
    private SimplexTableau tableau;

    public PointValuePair getSolution() {
        SimplexTableau simplexTableau = this.tableau;
        if (simplexTableau != null) {
            return simplexTableau.getSolution();
        }
        return null;
    }

    public boolean isSolutionOptimal() {
        SimplexTableau simplexTableau = this.tableau;
        if (simplexTableau != null) {
            return simplexTableau.isOptimal();
        }
        return false;
    }

    public void setTableau(SimplexTableau simplexTableau) {
        this.tableau = simplexTableau;
    }
}
