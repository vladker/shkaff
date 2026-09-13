package org.apache.commons.math3.geometry.euclidean.twod.hull;

import java.io.Serializable;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Segment;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.hull.ConvexHull;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ConvexHull2D implements ConvexHull<Euclidean2D, Vector2D>, Serializable {
    private static final long serialVersionUID = 20140129;
    private transient Segment[] lineSegments;
    private final double tolerance;
    private final Vector2D[] vertices;

    public ConvexHull2D(Vector2D[] vector2DArr, double d) {
        this.tolerance = d;
        if (!isConvex(vector2DArr)) {
            throw new MathIllegalArgumentException(LocalizedFormats.NOT_CONVEX, new Object[0]);
        }
        this.vertices = (Vector2D[]) vector2DArr.clone();
    }

    private boolean isConvex(Vector2D[] vector2DArr) {
        if (vector2DArr.length < 3) {
            return true;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < vector2DArr.length) {
            Vector2D vector2D = vector2DArr[i5 == 0 ? vector2DArr.length - 1 : i5 - 1];
            Vector2D vector2D2 = vector2DArr[i5];
            Vector2D vector2D3 = vector2DArr[i5 == vector2DArr.length - 1 ? 0 : i5 + 1];
            Vector2D vector2DSubtract = vector2D2.subtract((Vector<Euclidean2D>) vector2D);
            Vector2D vector2DSubtract2 = vector2D3.subtract((Vector<Euclidean2D>) vector2D2);
            int iCompareTo = Precision.compareTo(MathArrays.linearCombination(vector2DSubtract.getX(), vector2DSubtract2.getY(), -vector2DSubtract.getY(), vector2DSubtract2.getX()), 0.0d, this.tolerance);
            if (iCompareTo != 0.0d) {
                if (i6 != 0.0d && iCompareTo != i6) {
                    return false;
                }
                i6 = iCompareTo;
            }
            i5++;
        }
        return true;
    }

    private Segment[] retrieveLineSegments() {
        if (this.lineSegments == null) {
            Vector2D[] vector2DArr = this.vertices;
            int length = vector2DArr.length;
            int i5 = 0;
            if (length <= 1) {
                this.lineSegments = new Segment[0];
            } else if (length == 2) {
                this.lineSegments = new Segment[]{new Segment(vector2D, vector2D, new Line(vector2D, vector2D, this.tolerance))};
                Vector2D vector2D = vector2DArr[0];
                Vector2D vector2D2 = vector2DArr[1];
            } else {
                this.lineSegments = new Segment[length];
                int length2 = vector2DArr.length;
                Vector2D vector2D3 = null;
                Vector2D vector2D4 = null;
                int i6 = 0;
                while (i5 < length2) {
                    Vector2D vector2D5 = vector2DArr[i5];
                    if (vector2D3 == null) {
                        vector2D4 = vector2D5;
                    } else {
                        this.lineSegments[i6] = new Segment(vector2D3, vector2D5, new Line(vector2D3, vector2D5, this.tolerance));
                        i6++;
                    }
                    i5++;
                    vector2D3 = vector2D5;
                }
                this.lineSegments[i6] = new Segment(vector2D3, vector2D4, new Line(vector2D3, vector2D4, this.tolerance));
            }
        }
        return this.lineSegments;
    }

    @Override // org.apache.commons.math3.geometry.hull.ConvexHull
    public Region<Euclidean2D> createRegion() {
        if (this.vertices.length < 3) {
            throw new InsufficientDataException();
        }
        RegionFactory regionFactory = new RegionFactory();
        Segment[] segmentArrRetrieveLineSegments = retrieveLineSegments();
        Line[] lineArr = new Line[segmentArrRetrieveLineSegments.length];
        for (int i5 = 0; i5 < segmentArrRetrieveLineSegments.length; i5++) {
            lineArr[i5] = segmentArrRetrieveLineSegments[i5].getLine();
        }
        return regionFactory.buildConvex(lineArr);
    }

    public Segment[] getLineSegments() {
        return (Segment[]) retrieveLineSegments().clone();
    }

    @Override // org.apache.commons.math3.geometry.hull.ConvexHull
    public Vector2D[] getVertices() {
        return (Vector2D[]) this.vertices.clone();
    }
}
