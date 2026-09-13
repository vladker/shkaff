package androidx.webkit;

import androidx.annotation.IntRange;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@Profile.ExperimentalUrlPrefetch
public class SpeculativeLoadingConfig {
    private final int mMaxPrefetches;
    private final int mMaxPrerenders;
    private final int mPrefetchTTLSeconds;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Profile.ExperimentalUrlPrefetch
    public static final class Builder {
        private int mMaxPrefetches;
        private int mMaxPrerenders;
        private int mPrefetchTTLSeconds;

        @Profile.ExperimentalUrlPrefetch
        public SpeculativeLoadingConfig build() {
            return new SpeculativeLoadingConfig(this.mPrefetchTTLSeconds, this.mMaxPrefetches, this.mMaxPrerenders);
        }

        public Builder setMaxPrefetches(@IntRange(from = 1) int i5) {
            if (i5 < 1) {
                throw new IllegalArgumentException("Max prefetches must be greater than 0");
            }
            this.mMaxPrefetches = i5;
            return this;
        }

        public Builder setMaxPrerenders(@IntRange(from = 1) int i5) {
            if (i5 < 1) {
                throw new IllegalArgumentException("Max prerenders must be greater than 0");
            }
            this.mMaxPrerenders = i5;
            return this;
        }

        public Builder setPrefetchTtlSeconds(@IntRange(from = 1) int i5) {
            if (i5 <= 0) {
                throw new IllegalArgumentException("Prefetch TTL must be greater than 0");
            }
            this.mPrefetchTTLSeconds = i5;
            return this;
        }
    }

    @IntRange(from = 1)
    public int getMaxPrefetches() {
        return this.mMaxPrefetches;
    }

    @IntRange(from = 1)
    @Profile.ExperimentalUrlPrefetch
    public int getMaxPrerenders() {
        return this.mMaxPrerenders;
    }

    @IntRange(from = 1)
    public int getPrefetchTtlSeconds() {
        return this.mPrefetchTTLSeconds;
    }

    private SpeculativeLoadingConfig(int i5, int i6, int i7) {
        this.mPrefetchTTLSeconds = i5;
        this.mMaxPrefetches = i6;
        this.mMaxPrerenders = i7;
    }
}
