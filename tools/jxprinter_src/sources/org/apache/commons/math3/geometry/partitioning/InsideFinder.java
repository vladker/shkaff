package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class InsideFinder<S extends Space> {
    private final Region<S> region;
    private boolean plusFound = false;
    private boolean minusFound = false;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.InsideFinder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side;

        static {
            int[] iArr = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = iArr;
            try {
                iArr[Side.PLUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public InsideFinder(Region<S> region) {
        this.region = region;
    }

    public boolean minusFound() {
        return this.minusFound;
    }

    public boolean plusFound() {
        return this.plusFound;
    }

    public void recurseSides(BSPTree<S> bSPTree, SubHyperplane<S> subHyperplane) {
        if (bSPTree.getCut() == null) {
            if (((Boolean) bSPTree.getAttribute()).booleanValue()) {
                this.plusFound = true;
                this.minusFound = true;
                return;
            }
            return;
        }
        SubHyperplane.SplitSubHyperplane<S> splitSubHyperplaneSplit = subHyperplane.split(bSPTree.getCut().getHyperplane());
        int i5 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[splitSubHyperplaneSplit.getSide().ordinal()];
        if (i5 == 1) {
            if (bSPTree.getCut().split(subHyperplane.getHyperplane()).getSide() == Side.PLUS) {
                if (!this.region.isEmpty(bSPTree.getMinus())) {
                    this.plusFound = true;
                }
            } else if (!this.region.isEmpty(bSPTree.getMinus())) {
                this.minusFound = true;
            }
            if (this.plusFound && this.minusFound) {
                return;
            }
            recurseSides(bSPTree.getPlus(), subHyperplane);
            return;
        }
        if (i5 == 2) {
            if (bSPTree.getCut().split(subHyperplane.getHyperplane()).getSide() == Side.PLUS) {
                if (!this.region.isEmpty(bSPTree.getPlus())) {
                    this.plusFound = true;
                }
            } else if (!this.region.isEmpty(bSPTree.getPlus())) {
                this.minusFound = true;
            }
            if (this.plusFound && this.minusFound) {
                return;
            }
            recurseSides(bSPTree.getMinus(), subHyperplane);
            return;
        }
        if (i5 == 3) {
            recurseSides(bSPTree.getPlus(), splitSubHyperplaneSplit.getPlus());
            if (this.plusFound && this.minusFound) {
                return;
            }
            recurseSides(bSPTree.getMinus(), splitSubHyperplaneSplit.getMinus());
            return;
        }
        if (bSPTree.getCut().getHyperplane().sameOrientationAs(subHyperplane.getHyperplane())) {
            if (bSPTree.getPlus().getCut() != null || ((Boolean) bSPTree.getPlus().getAttribute()).booleanValue()) {
                this.plusFound = true;
            }
            if (bSPTree.getMinus().getCut() != null || ((Boolean) bSPTree.getMinus().getAttribute()).booleanValue()) {
                this.minusFound = true;
                return;
            }
            return;
        }
        if (bSPTree.getPlus().getCut() != null || ((Boolean) bSPTree.getPlus().getAttribute()).booleanValue()) {
            this.minusFound = true;
        }
        if (bSPTree.getMinus().getCut() != null || ((Boolean) bSPTree.getMinus().getAttribute()).booleanValue()) {
            this.plusFound = true;
        }
    }
}
