package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d) {
            super(sleepingStopwatch);
            this.maxBurstSeconds = d;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double d, double d6) {
            double d7 = this.maxPermits;
            double d8 = this.maxBurstSeconds * d;
            this.maxPermits = d8;
            if (d7 == Double.POSITIVE_INFINITY) {
                this.storedPermits = d8;
            } else {
                this.storedPermits = d7 != 0.0d ? (this.storedPermits * d8) / d7 : 0.0d;
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double d, double d6) {
            return 0L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j6, TimeUnit timeUnit, double d) {
            super(sleepingStopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(j6);
            this.coldFactor = d;
        }

        private double permitsToTime(double d) {
            return (d * this.slope) + this.stableIntervalMicros;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.warmupPeriodMicros / this.maxPermits;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double d, double d6) {
            double d7 = this.maxPermits;
            double d8 = this.coldFactor * d6;
            long j6 = this.warmupPeriodMicros;
            double d9 = (j6 * 0.5d) / d6;
            this.thresholdPermits = d9;
            double d10 = ((j6 * 2.0d) / (d6 + d8)) + d9;
            this.maxPermits = d10;
            this.slope = (d8 - d6) / (d10 - d9);
            if (d7 == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
                return;
            }
            if (d7 != 0.0d) {
                d10 = (this.storedPermits * d10) / d7;
            }
            this.storedPermits = d10;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double d, double d6) {
            long jPermitsToTime;
            double d7 = d - this.thresholdPermits;
            if (d7 > 0.0d) {
                double dMin = Math.min(d7, d6);
                jPermitsToTime = (long) (((permitsToTime(d7) + permitsToTime(d7 - dMin)) * dMin) / 2.0d);
                d6 -= dMin;
            } else {
                jPermitsToTime = 0;
            }
            return jPermitsToTime + ((long) (this.stableIntervalMicros * d6));
        }
    }

    public abstract double coolDownIntervalMicros();

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros;
    }

    public abstract void doSetRate(double d, double d6);

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void doSetRate(double d, long j6) {
        resync(j6);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d;
        this.stableIntervalMicros = micros;
        doSetRate(d, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long queryEarliestAvailable(long j6) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long reserveEarliestAvailable(int i5, long j6) {
        resync(j6);
        long j7 = this.nextFreeTicketMicros;
        double d = i5;
        double dMin = Math.min(d, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, dMin) + ((long) ((d - dMin) * this.stableIntervalMicros)));
        this.storedPermits -= dMin;
        return j7;
    }

    public void resync(long j6) {
        long j7 = this.nextFreeTicketMicros;
        if (j6 > j7) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((j6 - j7) / coolDownIntervalMicros()));
            this.nextFreeTicketMicros = j6;
        }
    }

    public abstract long storedPermitsToWaitTime(double d, double d6);

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }
}
