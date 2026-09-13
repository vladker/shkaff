package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface SubHyperplane<S extends Space> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SplitSubHyperplane<U extends Space> {
        private final SubHyperplane<U> minus;
        private final SubHyperplane<U> plus;

        public SplitSubHyperplane(SubHyperplane<U> subHyperplane, SubHyperplane<U> subHyperplane2) {
            this.plus = subHyperplane;
            this.minus = subHyperplane2;
        }

        public SubHyperplane<U> getMinus() {
            return this.minus;
        }

        public SubHyperplane<U> getPlus() {
            return this.plus;
        }

        public Side getSide() {
            SubHyperplane<U> subHyperplane = this.plus;
            if (subHyperplane == null || subHyperplane.isEmpty()) {
                SubHyperplane<U> subHyperplane2 = this.minus;
                return (subHyperplane2 == null || subHyperplane2.isEmpty()) ? Side.HYPER : Side.MINUS;
            }
            SubHyperplane<U> subHyperplane3 = this.minus;
            return (subHyperplane3 == null || subHyperplane3.isEmpty()) ? Side.PLUS : Side.BOTH;
        }
    }

    SubHyperplane<S> copySelf();

    Hyperplane<S> getHyperplane();

    double getSize();

    boolean isEmpty();

    SubHyperplane<S> reunite(SubHyperplane<S> subHyperplane);

    @Deprecated
    Side side(Hyperplane<S> hyperplane);

    SplitSubHyperplane<S> split(Hyperplane<S> hyperplane);
}
