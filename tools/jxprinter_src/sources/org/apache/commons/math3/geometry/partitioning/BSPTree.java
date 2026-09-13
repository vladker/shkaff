package org.apache.commons.math3.geometry.partitioning;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BSPTree<S extends Space> {
    private Object attribute;
    private SubHyperplane<S> cut;
    private BSPTree<S> minus;
    private BSPTree<S> parent;
    private BSPTree<S> plus;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.BSPTree$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order;
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
            int[] iArr2 = new int[BSPTreeVisitor.Order.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order = iArr2;
            try {
                iArr2[BSPTreeVisitor.Order.PLUS_MINUS_SUB.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.PLUS_SUB_MINUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.MINUS_PLUS_SUB.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.MINUS_SUB_PLUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.SUB_PLUS_MINUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[BSPTreeVisitor.Order.SUB_MINUS_PLUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface LeafMerger<S extends Space> {
        BSPTree<S> merge(BSPTree<S> bSPTree, BSPTree<S> bSPTree2, BSPTree<S> bSPTree3, boolean z6, boolean z7);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface VanishingCutHandler<S extends Space> {
        BSPTree<S> fixNode(BSPTree<S> bSPTree);
    }

    public BSPTree() {
        this.cut = null;
        this.plus = null;
        this.minus = null;
        this.parent = null;
        this.attribute = null;
    }

    private void chopOffMinus(Hyperplane<S> hyperplane, VanishingCutHandler<S> vanishingCutHandler) {
        SubHyperplane<S> subHyperplane = this.cut;
        if (subHyperplane != null) {
            this.cut = (SubHyperplane<S>) subHyperplane.split(hyperplane).getPlus();
            this.plus.chopOffMinus(hyperplane, vanishingCutHandler);
            this.minus.chopOffMinus(hyperplane, vanishingCutHandler);
            if (this.cut == null) {
                BSPTree<S> bSPTreeFixNode = vanishingCutHandler.fixNode(this);
                this.cut = bSPTreeFixNode.cut;
                this.plus = bSPTreeFixNode.plus;
                this.minus = bSPTreeFixNode.minus;
                this.attribute = bSPTreeFixNode.attribute;
            }
        }
    }

    private void chopOffPlus(Hyperplane<S> hyperplane, VanishingCutHandler<S> vanishingCutHandler) {
        SubHyperplane<S> subHyperplane = this.cut;
        if (subHyperplane != null) {
            this.cut = (SubHyperplane<S>) subHyperplane.split(hyperplane).getMinus();
            this.plus.chopOffPlus(hyperplane, vanishingCutHandler);
            this.minus.chopOffPlus(hyperplane, vanishingCutHandler);
            if (this.cut == null) {
                BSPTree<S> bSPTreeFixNode = vanishingCutHandler.fixNode(this);
                this.cut = bSPTreeFixNode.cut;
                this.plus = bSPTreeFixNode.plus;
                this.minus = bSPTreeFixNode.minus;
                this.attribute = bSPTreeFixNode.attribute;
            }
        }
    }

    private void condense() {
        if (this.cut != null) {
            BSPTree<S> bSPTree = this.plus;
            if (bSPTree.cut == null) {
                BSPTree<S> bSPTree2 = this.minus;
                if (bSPTree2.cut == null) {
                    Object obj = bSPTree.attribute;
                    if (!(obj == null && bSPTree2.attribute == null) && (obj == null || !obj.equals(bSPTree2.attribute))) {
                        return;
                    }
                    Object obj2 = this.plus.attribute;
                    if (obj2 == null) {
                        obj2 = this.minus.attribute;
                    }
                    this.attribute = obj2;
                    this.cut = null;
                    this.plus = null;
                    this.minus = null;
                }
            }
        }
    }

    private SubHyperplane<S> fitToCell(SubHyperplane<S> subHyperplane) {
        BSPTree<S> bSPTree = this;
        while (true) {
            BSPTree<S> bSPTree2 = bSPTree.parent;
            if (bSPTree2 == null || subHyperplane == null) {
                break;
            }
            subHyperplane = bSPTree == bSPTree2.plus ? subHyperplane.split(bSPTree2.cut.getHyperplane()).getPlus() : subHyperplane.split(bSPTree2.cut.getHyperplane()).getMinus();
            bSPTree = bSPTree.parent;
        }
        return subHyperplane;
    }

    private void recurseCloseCuts(Point<S> point, double d, List<BSPTree<S>> list) {
        SubHyperplane<S> subHyperplane = this.cut;
        if (subHyperplane != null) {
            double offset = subHyperplane.getHyperplane().getOffset(point);
            if (offset < (-d)) {
                this.minus.recurseCloseCuts(point, d, list);
            } else {
                if (offset > d) {
                    this.plus.recurseCloseCuts(point, d, list);
                    return;
                }
                list.add(this);
                this.minus.recurseCloseCuts(point, d, list);
                this.plus.recurseCloseCuts(point, d, list);
            }
        }
    }

    public BSPTree<S> copySelf() {
        SubHyperplane<S> subHyperplane = this.cut;
        return subHyperplane == null ? new BSPTree<>(this.attribute) : new BSPTree<>(subHyperplane.copySelf(), this.plus.copySelf(), this.minus.copySelf(), this.attribute);
    }

    public Object getAttribute() {
        return this.attribute;
    }

    @Deprecated
    public BSPTree<S> getCell(Vector<S> vector) {
        return getCell(vector, 1.0E-10d);
    }

    public List<BSPTree<S>> getCloseCuts(Point<S> point, double d) {
        ArrayList arrayList = new ArrayList();
        recurseCloseCuts(point, d, arrayList);
        return arrayList;
    }

    public SubHyperplane<S> getCut() {
        return this.cut;
    }

    public BSPTree<S> getMinus() {
        return this.minus;
    }

    public BSPTree<S> getParent() {
        return this.parent;
    }

    public BSPTree<S> getPlus() {
        return this.plus;
    }

    public boolean insertCut(Hyperplane<S> hyperplane) {
        if (this.cut != null) {
            this.plus.parent = null;
            this.minus.parent = null;
        }
        SubHyperplane<S> subHyperplaneFitToCell = fitToCell(hyperplane.wholeHyperplane());
        if (subHyperplaneFitToCell == null || subHyperplaneFitToCell.isEmpty()) {
            this.cut = null;
            this.plus = null;
            this.minus = null;
            return false;
        }
        this.cut = subHyperplaneFitToCell;
        BSPTree<S> bSPTree = new BSPTree<>();
        this.plus = bSPTree;
        bSPTree.parent = this;
        BSPTree<S> bSPTree2 = new BSPTree<>();
        this.minus = bSPTree2;
        bSPTree2.parent = this;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void insertInTree(BSPTree<S> bSPTree, boolean z6) {
        insertInTree(bSPTree, z6, new VanishingCutHandler<S>() { // from class: org.apache.commons.math3.geometry.partitioning.BSPTree.1
            @Override // org.apache.commons.math3.geometry.partitioning.BSPTree.VanishingCutHandler
            public BSPTree<S> fixNode(BSPTree<S> bSPTree2) {
                throw new MathIllegalStateException(LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
            }
        });
    }

    public BSPTree<S> merge(BSPTree<S> bSPTree, LeafMerger<S> leafMerger) {
        return merge(bSPTree, leafMerger, null, false);
    }

    public BSPTree<S> pruneAroundConvexCell(Object obj, Object obj2, Object obj3) {
        BSPTree<S> bSPTree = new BSPTree<>(obj);
        BSPTree<S> bSPTree2 = this;
        while (true) {
            BSPTree<S> bSPTree3 = bSPTree2.parent;
            if (bSPTree3 == null) {
                return bSPTree;
            }
            SubHyperplane<S> subHyperplaneCopySelf = bSPTree3.cut.copySelf();
            BSPTree bSPTree4 = new BSPTree(obj2);
            bSPTree = bSPTree2 == bSPTree2.parent.plus ? new BSPTree<>(subHyperplaneCopySelf, bSPTree, bSPTree4, obj3) : new BSPTree<>(subHyperplaneCopySelf, bSPTree4, bSPTree, obj3);
            bSPTree2 = bSPTree2.parent;
        }
    }

    public void setAttribute(Object obj) {
        this.attribute = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public BSPTree<S> split(SubHyperplane<S> subHyperplane) {
        SubHyperplane<S> subHyperplane2 = this.cut;
        if (subHyperplane2 == null) {
            return new BSPTree<>(subHyperplane, copySelf(), new BSPTree(this.attribute), null);
        }
        Hyperplane<S> hyperplane = subHyperplane2.getHyperplane();
        Hyperplane<S> hyperplane2 = subHyperplane.getHyperplane();
        SubHyperplane.SplitSubHyperplane<S> splitSubHyperplaneSplit = subHyperplane.split(hyperplane);
        int i5 = AnonymousClass2.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[splitSubHyperplaneSplit.getSide().ordinal()];
        if (i5 == 1) {
            BSPTree<S> bSPTreeSplit = this.plus.split(subHyperplane);
            if (this.cut.split(hyperplane2).getSide() == Side.PLUS) {
                BSPTree<S> bSPTree = new BSPTree<>(this.cut.copySelf(), bSPTreeSplit.plus, this.minus.copySelf(), this.attribute);
                bSPTreeSplit.plus = bSPTree;
                bSPTree.condense();
                bSPTreeSplit.plus.parent = bSPTreeSplit;
                return bSPTreeSplit;
            }
            BSPTree<S> bSPTree2 = new BSPTree<>(this.cut.copySelf(), bSPTreeSplit.minus, this.minus.copySelf(), this.attribute);
            bSPTreeSplit.minus = bSPTree2;
            bSPTree2.condense();
            bSPTreeSplit.minus.parent = bSPTreeSplit;
            return bSPTreeSplit;
        }
        if (i5 == 2) {
            BSPTree<S> bSPTreeSplit2 = this.minus.split(subHyperplane);
            if (this.cut.split(hyperplane2).getSide() == Side.PLUS) {
                BSPTree<S> bSPTree3 = new BSPTree<>(this.cut.copySelf(), this.plus.copySelf(), bSPTreeSplit2.plus, this.attribute);
                bSPTreeSplit2.plus = bSPTree3;
                bSPTree3.condense();
                bSPTreeSplit2.plus.parent = bSPTreeSplit2;
                return bSPTreeSplit2;
            }
            BSPTree<S> bSPTree4 = new BSPTree<>(this.cut.copySelf(), this.plus.copySelf(), bSPTreeSplit2.minus, this.attribute);
            bSPTreeSplit2.minus = bSPTree4;
            bSPTree4.condense();
            bSPTreeSplit2.minus.parent = bSPTreeSplit2;
            return bSPTreeSplit2;
        }
        if (i5 != 3) {
            return hyperplane.sameOrientationAs(hyperplane2) ? new BSPTree<>(subHyperplane, this.plus.copySelf(), this.minus.copySelf(), this.attribute) : new BSPTree<>(subHyperplane, this.minus.copySelf(), this.plus.copySelf(), this.attribute);
        }
        SubHyperplane.SplitSubHyperplane<S> splitSubHyperplaneSplit2 = this.cut.split(hyperplane2);
        BSPTree<S> bSPTree5 = new BSPTree<>(subHyperplane, this.plus.split(splitSubHyperplaneSplit.getPlus()), this.minus.split(splitSubHyperplaneSplit.getMinus()), null);
        bSPTree5.plus.cut = (SubHyperplane<S>) splitSubHyperplaneSplit2.getPlus();
        bSPTree5.minus.cut = (SubHyperplane<S>) splitSubHyperplaneSplit2.getMinus();
        BSPTree<S> bSPTree6 = bSPTree5.plus;
        BSPTree<S> bSPTree7 = bSPTree6.minus;
        BSPTree<S> bSPTree8 = bSPTree5.minus.plus;
        bSPTree6.minus = bSPTree8;
        bSPTree8.parent = bSPTree6;
        BSPTree<S> bSPTree9 = bSPTree5.minus;
        bSPTree9.plus = bSPTree7;
        bSPTree7.parent = bSPTree9;
        bSPTree5.plus.condense();
        bSPTree5.minus.condense();
        return bSPTree5;
    }

    public void visit(BSPTreeVisitor<S> bSPTreeVisitor) {
        if (this.cut == null) {
            bSPTreeVisitor.visitLeafNode(this);
            return;
        }
        switch (AnonymousClass2.$SwitchMap$org$apache$commons$math3$geometry$partitioning$BSPTreeVisitor$Order[bSPTreeVisitor.visitOrder(this).ordinal()]) {
            case 1:
                this.plus.visit(bSPTreeVisitor);
                this.minus.visit(bSPTreeVisitor);
                bSPTreeVisitor.visitInternalNode(this);
                return;
            case 2:
                this.plus.visit(bSPTreeVisitor);
                bSPTreeVisitor.visitInternalNode(this);
                this.minus.visit(bSPTreeVisitor);
                return;
            case 3:
                this.minus.visit(bSPTreeVisitor);
                this.plus.visit(bSPTreeVisitor);
                bSPTreeVisitor.visitInternalNode(this);
                return;
            case 4:
                this.minus.visit(bSPTreeVisitor);
                bSPTreeVisitor.visitInternalNode(this);
                this.plus.visit(bSPTreeVisitor);
                return;
            case 5:
                bSPTreeVisitor.visitInternalNode(this);
                this.plus.visit(bSPTreeVisitor);
                this.minus.visit(bSPTreeVisitor);
                return;
            case 6:
                bSPTreeVisitor.visitInternalNode(this);
                this.minus.visit(bSPTreeVisitor);
                this.plus.visit(bSPTreeVisitor);
                return;
            default:
                throw new MathInternalError();
        }
    }

    private BSPTree<S> merge(BSPTree<S> bSPTree, LeafMerger<S> leafMerger, BSPTree<S> bSPTree2, boolean z6) {
        SubHyperplane<S> subHyperplane = this.cut;
        if (subHyperplane == null) {
            return leafMerger.merge(this, bSPTree, bSPTree2, z6, true);
        }
        if (bSPTree.cut == null) {
            return leafMerger.merge(bSPTree, this, bSPTree2, z6, false);
        }
        BSPTree<S> bSPTreeSplit = bSPTree.split(subHyperplane);
        if (bSPTree2 != null) {
            bSPTreeSplit.parent = bSPTree2;
            if (z6) {
                bSPTree2.plus = bSPTreeSplit;
            } else {
                bSPTree2.minus = bSPTreeSplit;
            }
        }
        this.plus.merge(bSPTreeSplit.plus, leafMerger, bSPTreeSplit, true);
        this.minus.merge(bSPTreeSplit.minus, leafMerger, bSPTreeSplit, false);
        bSPTreeSplit.condense();
        SubHyperplane<S> subHyperplane2 = bSPTreeSplit.cut;
        if (subHyperplane2 != null) {
            bSPTreeSplit.cut = bSPTreeSplit.fitToCell(subHyperplane2.getHyperplane().wholeHyperplane());
        }
        return bSPTreeSplit;
    }

    public BSPTree<S> getCell(Point<S> point, double d) {
        SubHyperplane<S> subHyperplane = this.cut;
        if (subHyperplane != null) {
            double offset = subHyperplane.getHyperplane().getOffset(point);
            if (FastMath.abs(offset) >= d) {
                return offset <= 0.0d ? this.minus.getCell(point, d) : this.plus.getCell(point, d);
            }
        }
        return this;
    }

    public void insertInTree(BSPTree<S> bSPTree, boolean z6, VanishingCutHandler<S> vanishingCutHandler) {
        this.parent = bSPTree;
        if (bSPTree != null) {
            if (z6) {
                bSPTree.plus = this;
            } else {
                bSPTree.minus = this;
            }
        }
        if (this.cut != null) {
            BSPTree<S> bSPTree2 = this;
            while (true) {
                BSPTree<S> bSPTree3 = bSPTree2.parent;
                if (bSPTree3 == null) {
                    break;
                }
                Hyperplane<S> hyperplane = bSPTree3.cut.getHyperplane();
                if (bSPTree2 == bSPTree2.parent.plus) {
                    this.cut = (SubHyperplane<S>) this.cut.split(hyperplane).getPlus();
                    this.plus.chopOffMinus(hyperplane, vanishingCutHandler);
                    this.minus.chopOffMinus(hyperplane, vanishingCutHandler);
                } else {
                    this.cut = (SubHyperplane<S>) this.cut.split(hyperplane).getMinus();
                    this.plus.chopOffPlus(hyperplane, vanishingCutHandler);
                    this.minus.chopOffPlus(hyperplane, vanishingCutHandler);
                }
                if (this.cut == null) {
                    BSPTree<S> bSPTreeFixNode = vanishingCutHandler.fixNode(this);
                    SubHyperplane<S> subHyperplane = bSPTreeFixNode.cut;
                    this.cut = subHyperplane;
                    this.plus = bSPTreeFixNode.plus;
                    this.minus = bSPTreeFixNode.minus;
                    this.attribute = bSPTreeFixNode.attribute;
                    if (subHyperplane == null) {
                        break;
                    }
                }
                bSPTree2 = bSPTree2.parent;
            }
            condense();
        }
    }

    public BSPTree(Object obj) {
        this.cut = null;
        this.plus = null;
        this.minus = null;
        this.parent = null;
        this.attribute = obj;
    }

    public BSPTree(SubHyperplane<S> subHyperplane, BSPTree<S> bSPTree, BSPTree<S> bSPTree2, Object obj) {
        this.cut = subHyperplane;
        this.plus = bSPTree;
        this.minus = bSPTree2;
        this.parent = null;
        this.attribute = obj;
        bSPTree.parent = this;
        bSPTree2.parent = this;
    }
}
