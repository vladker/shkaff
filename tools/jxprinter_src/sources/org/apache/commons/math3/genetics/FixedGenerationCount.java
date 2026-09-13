package org.apache.commons.math3.genetics;

import org.apache.commons.math3.exception.NumberIsTooSmallException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FixedGenerationCount implements StoppingCondition {
    private final int maxGenerations;
    private int numGenerations = 0;

    public FixedGenerationCount(int i5) {
        if (i5 <= 0) {
            throw new NumberIsTooSmallException(Integer.valueOf(i5), 1, true);
        }
        this.maxGenerations = i5;
    }

    public int getNumGenerations() {
        return this.numGenerations;
    }

    @Override // org.apache.commons.math3.genetics.StoppingCondition
    public boolean isSatisfied(Population population) {
        int i5 = this.numGenerations;
        if (i5 >= this.maxGenerations) {
            return true;
        }
        this.numGenerations = i5 + 1;
        return false;
    }
}
