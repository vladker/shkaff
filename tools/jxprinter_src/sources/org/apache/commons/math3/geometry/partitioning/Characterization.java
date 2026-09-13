package org.apache.commons.math3.geometry.partitioning;

import androidx.exifinterface.media.a;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class Characterization<S extends Space> {
    private SubHyperplane<S> outsideTouching = null;
    private SubHyperplane<S> insideTouching = null;
    private final NodesSet<S> outsideSplitters = new NodesSet<>();
    private final NodesSet<S> insideSplitters = new NodesSet<>();

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.Characterization$1, reason: invalid class name */
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

    public Characterization(BSPTree<S> bSPTree, SubHyperplane<S> subHyperplane) {
        characterize(bSPTree, subHyperplane, new ArrayList());
    }

    private void addInsideTouching(SubHyperplane<S> subHyperplane, List<BSPTree<S>> list) {
        SubHyperplane<S> subHyperplane2 = this.insideTouching;
        if (subHyperplane2 == null) {
            this.insideTouching = subHyperplane;
        } else {
            this.insideTouching = subHyperplane2.reunite(subHyperplane);
        }
        this.insideSplitters.addAll(list);
    }

    private void addOutsideTouching(SubHyperplane<S> subHyperplane, List<BSPTree<S>> list) {
        SubHyperplane<S> subHyperplane2 = this.outsideTouching;
        if (subHyperplane2 == null) {
            this.outsideTouching = subHyperplane;
        } else {
            this.outsideTouching = subHyperplane2.reunite(subHyperplane);
        }
        this.outsideSplitters.addAll(list);
    }

    private void characterize(BSPTree<S> bSPTree, SubHyperplane<S> subHyperplane, List<BSPTree<S>> list) {
        if (bSPTree.getCut() == null) {
            if (((Boolean) bSPTree.getAttribute()).booleanValue()) {
                addInsideTouching(subHyperplane, list);
                return;
            } else {
                addOutsideTouching(subHyperplane, list);
                return;
            }
        }
        SubHyperplane.SplitSubHyperplane<S> splitSubHyperplaneSplit = subHyperplane.split(bSPTree.getCut().getHyperplane());
        int i5 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[splitSubHyperplaneSplit.getSide().ordinal()];
        if (i5 == 1) {
            characterize(bSPTree.getPlus(), subHyperplane, list);
            return;
        }
        if (i5 == 2) {
            characterize(bSPTree.getMinus(), subHyperplane, list);
        } else {
            if (i5 != 3) {
                throw new MathInternalError();
            }
            list.add(bSPTree);
            characterize(bSPTree.getPlus(), splitSubHyperplaneSplit.getPlus(), list);
            characterize(bSPTree.getMinus(), splitSubHyperplaneSplit.getMinus(), list);
            a.w(1, list);
        }
    }

    public NodesSet<S> getInsideSplitters() {
        return this.insideSplitters;
    }

    public NodesSet<S> getOutsideSplitters() {
        return this.outsideSplitters;
    }

    public SubHyperplane<S> insideTouching() {
        return this.insideTouching;
    }

    public SubHyperplane<S> outsideTouching() {
        return this.outsideTouching;
    }

    public boolean touchInside() {
        SubHyperplane<S> subHyperplane = this.insideTouching;
        return (subHyperplane == null || subHyperplane.isEmpty()) ? false : true;
    }

    public boolean touchOutside() {
        SubHyperplane<S> subHyperplane = this.outsideTouching;
        return (subHyperplane == null || subHyperplane.isEmpty()) ? false : true;
    }
}
