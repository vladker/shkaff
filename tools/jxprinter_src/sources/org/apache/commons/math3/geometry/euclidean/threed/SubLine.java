package org.apache.commons.math3.geometry.euclidean.threed;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Region;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SubLine {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private final Line line;
    private final IntervalsSet remainingRegion;

    public SubLine(Line line, IntervalsSet intervalsSet) {
        this.line = line;
        this.remainingRegion = intervalsSet;
    }

    private static IntervalsSet buildIntervalSet(Vector3D vector3D, Vector3D vector3D2, double d) {
        Line line = new Line(vector3D, vector3D2, d);
        return new IntervalsSet(line.toSubSpace((Point<Euclidean3D>) vector3D).getX(), line.toSubSpace((Point<Euclidean3D>) vector3D2).getX(), d);
    }

    public List<Segment> getSegments() {
        List<Interval> listAsList = this.remainingRegion.asList();
        ArrayList arrayList = new ArrayList(listAsList.size());
        for (Interval interval : listAsList) {
            arrayList.add(new Segment(this.line.toSpace((Point<Euclidean1D>) new Vector1D(interval.getInf())), this.line.toSpace((Point<Euclidean1D>) new Vector1D(interval.getSup())), this.line));
        }
        return arrayList;
    }

    public Vector3D intersection(SubLine subLine, boolean z6) {
        Vector3D vector3DIntersection = this.line.intersection(subLine.line);
        if (vector3DIntersection == null) {
            return null;
        }
        Region.Location locationCheckPoint = this.remainingRegion.checkPoint((Point) this.line.toSubSpace((Point<Euclidean3D>) vector3DIntersection));
        Region.Location locationCheckPoint2 = subLine.remainingRegion.checkPoint((Point) subLine.line.toSubSpace((Point<Euclidean3D>) vector3DIntersection));
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
        return vector3DIntersection;
    }

    public SubLine(Vector3D vector3D, Vector3D vector3D2, double d) {
        this(new Line(vector3D, vector3D2, d), buildIntervalSet(vector3D, vector3D2, d));
    }

    public SubLine(Vector3D vector3D, Vector3D vector3D2) {
        this(vector3D, vector3D2, 1.0E-10d);
    }

    public SubLine(Segment segment) {
        this(segment.getLine(), buildIntervalSet(segment.getStart(), segment.getEnd(), segment.getLine().getTolerance()));
    }
}
