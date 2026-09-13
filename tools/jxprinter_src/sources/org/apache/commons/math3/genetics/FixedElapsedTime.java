package org.apache.commons.math3.genetics;

import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FixedElapsedTime implements StoppingCondition {
    private long endTime;
    private final long maxTimePeriod;

    public FixedElapsedTime(long j6) {
        this(j6, TimeUnit.SECONDS);
    }

    @Override // org.apache.commons.math3.genetics.StoppingCondition
    public boolean isSatisfied(Population population) {
        if (this.endTime < 0) {
            this.endTime = System.nanoTime() + this.maxTimePeriod;
        }
        return System.nanoTime() >= this.endTime;
    }

    public FixedElapsedTime(long j6, TimeUnit timeUnit) {
        this.endTime = -1L;
        if (j6 < 0) {
            throw new NumberIsTooSmallException(Long.valueOf(j6), 0, true);
        }
        this.maxTimePeriod = timeUnit.toNanos(j6);
    }
}
