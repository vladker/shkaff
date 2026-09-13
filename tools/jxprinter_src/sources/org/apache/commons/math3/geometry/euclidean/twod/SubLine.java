package org.apache.commons.math3.geometry.euclidean.twod;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.OrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.SubOrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SubLine extends AbstractSubHyperplane<Euclidean2D, Euclidean1D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;

    public SubLine(Hyperplane<Euclidean2D> hyperplane, Region<Euclidean1D> region) {
        super(hyperplane, region);
    }

    private static IntervalsSet buildIntervalSet(Vector2D vector2D, Vector2D vector2D2, double d) {
        Line line = new Line(vector2D, vector2D2, d);
        return new IntervalsSet(line.toSubSpace((Point<Euclidean2D>) vector2D).getX(), line.toSubSpace((Point<Euclidean2D>) vector2D2).getX(), d);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    public AbstractSubHyperplane<Euclidean2D, Euclidean1D> buildNew(Hyperplane<Euclidean2D> hyperplane, Region<Euclidean1D> region) {
        return new SubLine(hyperplane, region);
    }

    public List<Segment> getSegments() {
        Line line = (Line) getHyperplane();
        List<Interval> listAsList = ((IntervalsSet) getRemainingRegion()).asList();
        ArrayList arrayList = new ArrayList(listAsList.size());
        for (Interval interval : listAsList) {
            arrayList.add(new Segment(line.toSpace((Point<Euclidean1D>) new Vector1D(interval.getInf())), line.toSpace((Point<Euclidean1D>) new Vector1D(interval.getSup())), line));
        }
        return arrayList;
    }

    public Vector2D intersection(SubLine subLine, boolean z6) {
        Line line = (Line) getHyperplane();
        Line line2 = (Line) subLine.getHyperplane();
        Vector2D vector2DIntersection = line.intersection(line2);
        if (vector2DIntersection == null) {
            return null;
        }
        Region.Location locationCheckPoint = getRemainingRegion().checkPoint(line.toSubSpace((Point<Euclidean2D>) vector2DIntersection));
        Region.Location locationCheckPoint2 = subLine.getRemainingRegion().checkPoint(line2.toSubSpace((Point<Euclidean2D>) vector2DIntersection));
        if (z6) {
            Region.Location location = Region.Location.OUTSIDE;
            if (locationCheckPoint == location || locationCheckPoint2 == location) {
                return null;
            }
        } else {
            Region.Location location2 = Region.Location.INSIDE;
            if (locationCheckPoint != location2 || locationCheckPoint2 != location2) {
                return null;
            }
        }
        return vector2DIntersection;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Euclidean2D> split(Hyperplane<Euclidean2D> hyperplane) {
        Line line = (Line) getHyperplane();
        Line line2 = (Line) hyperplane;
        Vector2D vector2DIntersection = line.intersection(line2);
        double tolerance = line.getTolerance();
        if (vector2DIntersection == null) {
            double offset = line2.getOffset(line);
            if (offset < (-tolerance)) {
                return new SubHyperplane.SplitSubHyperplane<>(null, this);
            }
            return offset > tolerance ? new SubHyperplane.SplitSubHyperplane<>(this, null) : new SubHyperplane.SplitSubHyperplane<>(null, null);
        }
        boolean z6 = FastMath.sin(line.getAngle() - line2.getAngle()) < 0.0d;
        Vector1D subSpace = line.toSubSpace((Point<Euclidean2D>) vector2DIntersection);
        SubOrientedPoint subOrientedPointWholeHyperplane = new OrientedPoint(subSpace, !z6, tolerance).wholeHyperplane();
        SubOrientedPoint subOrientedPointWholeHyperplane2 = new OrientedPoint(subSpace, z6, tolerance).wholeHyperplane();
        BSPTree bSPTreeSplit = getRemainingRegion().getTree(false).split(subOrientedPointWholeHyperplane2);
        return new SubHyperplane.SplitSubHyperplane<>(new SubLine(line.copySelf(), new IntervalsSet((BSPTree<Euclidean1D>) (getRemainingRegion().isEmpty(bSPTreeSplit.getPlus()) ? new BSPTree(Boolean.FALSE) : new BSPTree(subOrientedPointWholeHyperplane, new BSPTree(Boolean.FALSE), bSPTreeSplit.getPlus(), null)), tolerance)), new SubLine(line.copySelf(), new IntervalsSet((BSPTree<Euclidean1D>) (getRemainingRegion().isEmpty(bSPTreeSplit.getMinus()) ? new BSPTree(Boolean.FALSE) : new BSPTree(subOrientedPointWholeHyperplane2, new BSPTree(Boolean.FALSE), bSPTreeSplit.getMinus(), null)), tolerance)));
    }

    public SubLine(Vector2D vector2D, Vector2D vector2D2, double d) {
        super(new Line(vector2D, vector2D2, d), buildIntervalSet(vector2D, vector2D2, d));
    }

    @Deprecated
    public SubLine(Vector2D vector2D, Vector2D vector2D2) {
        this(vector2D, vector2D2, 1.0E-10d);
    }

    public SubLine(Segment segment) {
        super(segment.getLine(), buildIntervalSet(segment.getStart(), segment.getEnd(), segment.getLine().getTolerance()));
    }
}
