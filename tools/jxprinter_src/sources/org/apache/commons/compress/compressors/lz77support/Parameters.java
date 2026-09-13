package org.apache.commons.compress.compressors.lz77support;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Parameters {
    public static final int TRUE_MIN_BACK_REFERENCE_LENGTH = 3;
    private final boolean lazyMatching;
    private final int lazyThreshold;
    private final int maxBackReferenceLength;
    private final int maxCandidates;
    private final int maxLiteralLength;
    private final int maxOffset;
    private final int minBackReferenceLength;
    private final int niceBackReferenceLength;
    private final int windowSize;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Builder {
        private Boolean lazyMatches;
        private Integer lazyThreshold;
        private int maxBackReferenceLength;
        private Integer maxCandidates;
        private int maxLiteralLength;
        private int maxOffset;
        private int minBackReferenceLength;
        private Integer niceBackReferenceLength;
        private final int windowSize;

        public Parameters build() {
            int iIntValue;
            int i5;
            Integer num = this.niceBackReferenceLength;
            int iIntValue2 = num != null ? num.intValue() : Math.max(this.minBackReferenceLength, this.maxBackReferenceLength / 2);
            Integer num2 = this.maxCandidates;
            int iIntValue3 = num2 != null ? num2.intValue() : Math.max(256, this.windowSize / 128);
            Boolean bool = this.lazyMatches;
            boolean z6 = bool == null || bool.booleanValue();
            if (z6) {
                Integer num3 = this.lazyThreshold;
                if (num3 != null) {
                    iIntValue = num3.intValue();
                } else {
                    i5 = iIntValue2;
                }
                return new Parameters(this.windowSize, this.minBackReferenceLength, this.maxBackReferenceLength, this.maxOffset, this.maxLiteralLength, iIntValue2, iIntValue3, z6, i5);
            }
            iIntValue = this.minBackReferenceLength;
            i5 = iIntValue;
            return new Parameters(this.windowSize, this.minBackReferenceLength, this.maxBackReferenceLength, this.maxOffset, this.maxLiteralLength, iIntValue2, iIntValue3, z6, i5);
        }

        public Builder tunedForCompressionRatio() {
            Integer numValueOf = Integer.valueOf(this.maxBackReferenceLength);
            this.lazyThreshold = numValueOf;
            this.niceBackReferenceLength = numValueOf;
            this.maxCandidates = Integer.valueOf(Math.max(32, this.windowSize / 16));
            this.lazyMatches = Boolean.TRUE;
            return this;
        }

        public Builder tunedForSpeed() {
            this.niceBackReferenceLength = Integer.valueOf(Math.max(this.minBackReferenceLength, this.maxBackReferenceLength / 8));
            this.maxCandidates = Integer.valueOf(Math.max(32, this.windowSize / 1024));
            this.lazyMatches = Boolean.FALSE;
            this.lazyThreshold = Integer.valueOf(this.minBackReferenceLength);
            return this;
        }

        public Builder withLazyMatching(boolean z6) {
            this.lazyMatches = Boolean.valueOf(z6);
            return this;
        }

        public Builder withLazyThreshold(int i5) {
            this.lazyThreshold = Integer.valueOf(i5);
            return this;
        }

        public Builder withMaxBackReferenceLength(int i5) {
            int iMin = this.minBackReferenceLength;
            if (i5 >= iMin) {
                iMin = Math.min(i5, this.windowSize - 1);
            }
            this.maxBackReferenceLength = iMin;
            return this;
        }

        public Builder withMaxLiteralLength(int i5) {
            this.maxLiteralLength = i5 < 1 ? this.windowSize : Math.min(i5, this.windowSize);
            return this;
        }

        public Builder withMaxNumberOfCandidates(int i5) {
            this.maxCandidates = Integer.valueOf(i5);
            return this;
        }

        public Builder withMaxOffset(int i5) {
            this.maxOffset = i5 < 1 ? this.windowSize - 1 : Math.min(i5, this.windowSize - 1);
            return this;
        }

        public Builder withMinBackReferenceLength(int i5) {
            int iMax = Math.max(3, i5);
            this.minBackReferenceLength = iMax;
            if (this.windowSize < iMax) {
                throw new IllegalArgumentException("minBackReferenceLength can't be bigger than windowSize");
            }
            if (this.maxBackReferenceLength < iMax) {
                this.maxBackReferenceLength = iMax;
            }
            return this;
        }

        public Builder withNiceBackReferenceLength(int i5) {
            this.niceBackReferenceLength = Integer.valueOf(i5);
            return this;
        }

        private Builder(int i5) {
            if (i5 < 2 || !Parameters.isPowerOfTwo(i5)) {
                throw new IllegalArgumentException("windowSize must be a power of two");
            }
            this.windowSize = i5;
            this.minBackReferenceLength = 3;
            int i6 = i5 - 1;
            this.maxBackReferenceLength = i6;
            this.maxOffset = i6;
            this.maxLiteralLength = i5;
        }
    }

    public static Builder builder(int i5) {
        return new Builder(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPowerOfTwo(int i5) {
        return (i5 & (i5 + (-1))) == 0;
    }

    public boolean getLazyMatching() {
        return this.lazyMatching;
    }

    public int getLazyMatchingThreshold() {
        return this.lazyThreshold;
    }

    public int getMaxBackReferenceLength() {
        return this.maxBackReferenceLength;
    }

    public int getMaxCandidates() {
        return this.maxCandidates;
    }

    public int getMaxLiteralLength() {
        return this.maxLiteralLength;
    }

    public int getMaxOffset() {
        return this.maxOffset;
    }

    public int getMinBackReferenceLength() {
        return this.minBackReferenceLength;
    }

    public int getNiceBackReferenceLength() {
        return this.niceBackReferenceLength;
    }

    public int getWindowSize() {
        return this.windowSize;
    }

    private Parameters(int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z6, int i12) {
        this.windowSize = i5;
        this.minBackReferenceLength = i6;
        this.maxBackReferenceLength = i7;
        this.maxOffset = i8;
        this.maxLiteralLength = i9;
        this.niceBackReferenceLength = i10;
        this.maxCandidates = i11;
        this.lazyMatching = z6;
        this.lazyThreshold = i12;
    }
}
