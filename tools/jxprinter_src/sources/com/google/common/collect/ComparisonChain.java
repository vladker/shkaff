package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE = new ComparisonChain() { // from class: com.google.common.collect.ComparisonChain.1
        public ComparisonChain classify(int i5) {
            if (i5 < 0) {
                return ComparisonChain.LESS;
            }
            return i5 > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return classify(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z6, boolean z7) {
            return classify(Booleans.compare(z6, z7));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z6, boolean z7) {
            return classify(Booleans.compare(z7, z6));
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return 0;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T t6, @ParametricNullness T t7, Comparator<T> comparator) {
            return classify(comparator.compare(t6, t7));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i5, int i6) {
            return classify(Ints.compare(i5, i6));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j6, long j7) {
            return classify(Longs.compare(j6, j7));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f6, float f7) {
            return classify(Float.compare(f6, f7));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d, double d6) {
            return classify(Double.compare(d, d6));
        }
    };
    private static final ComparisonChain LESS = new InactiveComparisonChain(-1);
    private static final ComparisonChain GREATER = new InactiveComparisonChain(1);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        public InactiveComparisonChain(int i5) {
            super();
            this.result = i5;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d, double d6) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.result;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f6, float f7) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i5, int i6) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j6, long j7) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T t6, @ParametricNullness T t7, Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z6, boolean z7) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z6, boolean z7) {
            return this;
        }
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(double d, double d6);

    public abstract ComparisonChain compare(float f6, float f7);

    public abstract ComparisonChain compare(int i5, int i6);

    public abstract ComparisonChain compare(long j6, long j7);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(@ParametricNullness T t6, @ParametricNullness T t7, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z6, boolean z7);

    public abstract ComparisonChain compareTrueFirst(boolean z6, boolean z7);

    public abstract int result();

    private ComparisonChain() {
    }
}
