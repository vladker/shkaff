package org.opencv.imgproc;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat4;
import org.opencv.core.MatOfFloat6;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Subdiv2D {
    public static final int NEXT_AROUND_DST = 34;
    public static final int NEXT_AROUND_LEFT = 19;
    public static final int NEXT_AROUND_ORG = 0;
    public static final int NEXT_AROUND_RIGHT = 49;
    public static final int PREV_AROUND_DST = 51;
    public static final int PREV_AROUND_LEFT = 32;
    public static final int PREV_AROUND_ORG = 17;
    public static final int PREV_AROUND_RIGHT = 2;
    public static final int PTLOC_ERROR = -2;
    public static final int PTLOC_INSIDE = 0;
    public static final int PTLOC_ON_EDGE = 2;
    public static final int PTLOC_OUTSIDE_RECT = -1;
    public static final int PTLOC_VERTEX = 1;
    protected final long nativeObj;

    public Subdiv2D(long j6) {
        this.nativeObj = j6;
    }

    private static native long Subdiv2D_0();

    private static native long Subdiv2D_1(int i5, int i6, int i7, int i8);

    public static Subdiv2D __fromPtr__(long j6) {
        return new Subdiv2D(j6);
    }

    private static native void delete(long j6);

    private static native int edgeDst_0(long j6, int i5, double[] dArr);

    private static native int edgeDst_1(long j6, int i5);

    private static native int edgeOrg_0(long j6, int i5, double[] dArr);

    private static native int edgeOrg_1(long j6, int i5);

    private static native int findNearest_0(long j6, double d, double d6, double[] dArr);

    private static native int findNearest_1(long j6, double d, double d6);

    private static native void getEdgeList_0(long j6, long j7);

    private static native int getEdge_0(long j6, int i5, int i6);

    private static native void getLeadingEdgeList_0(long j6, long j7);

    private static native void getTriangleList_0(long j6, long j7);

    private static native double[] getVertex_0(long j6, int i5, double[] dArr);

    private static native double[] getVertex_1(long j6, int i5);

    private static native void getVoronoiFacetList_0(long j6, long j7, long j8, long j9);

    private static native void initDelaunay_0(long j6, int i5, int i6, int i7, int i8);

    private static native int insert_0(long j6, double d, double d6);

    private static native void insert_1(long j6, long j7);

    private static native int locate_0(long j6, double d, double d6, double[] dArr, double[] dArr2);

    private static native int nextEdge_0(long j6, int i5);

    private static native int rotateEdge_0(long j6, int i5, int i6);

    private static native int symEdge_0(long j6, int i5);

    public int edgeDst(int i5, Point point) {
        double[] dArr = new double[2];
        int iEdgeDst_0 = edgeDst_0(this.nativeObj, i5, dArr);
        if (point != null) {
            point.f7681x = dArr[0];
            point.f7682y = dArr[1];
        }
        return iEdgeDst_0;
    }

    public int edgeOrg(int i5, Point point) {
        double[] dArr = new double[2];
        int iEdgeOrg_0 = edgeOrg_0(this.nativeObj, i5, dArr);
        if (point != null) {
            point.f7681x = dArr[0];
            point.f7682y = dArr[1];
        }
        return iEdgeOrg_0;
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public int findNearest(Point point, Point point2) {
        double[] dArr = new double[2];
        int iFindNearest_0 = findNearest_0(this.nativeObj, point.f7681x, point.f7682y, dArr);
        if (point2 != null) {
            point2.f7681x = dArr[0];
            point2.f7682y = dArr[1];
        }
        return iFindNearest_0;
    }

    public int getEdge(int i5, int i6) {
        return getEdge_0(this.nativeObj, i5, i6);
    }

    public void getEdgeList(MatOfFloat4 matOfFloat4) {
        getEdgeList_0(this.nativeObj, matOfFloat4.nativeObj);
    }

    public void getLeadingEdgeList(MatOfInt matOfInt) {
        getLeadingEdgeList_0(this.nativeObj, matOfInt.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public void getTriangleList(MatOfFloat6 matOfFloat6) {
        getTriangleList_0(this.nativeObj, matOfFloat6.nativeObj);
    }

    public Point getVertex(int i5, int[] iArr) {
        double[] dArr = new double[1];
        Point point = new Point(getVertex_0(this.nativeObj, i5, dArr));
        if (iArr != null) {
            iArr[0] = (int) dArr[0];
        }
        return point;
    }

    public void getVoronoiFacetList(MatOfInt matOfInt, List<MatOfPoint2f> list, MatOfPoint2f matOfPoint2f) {
        Mat mat = new Mat();
        getVoronoiFacetList_0(this.nativeObj, matOfInt.nativeObj, mat.nativeObj, matOfPoint2f.nativeObj);
        Converters.Mat_to_vector_vector_Point2f(mat, list);
        mat.release();
    }

    public void initDelaunay(Rect rect) {
        initDelaunay_0(this.nativeObj, rect.f7686x, rect.f7687y, rect.width, rect.height);
    }

    public int insert(Point point) {
        return insert_0(this.nativeObj, point.f7681x, point.f7682y);
    }

    public int locate(Point point, int[] iArr, int[] iArr2) {
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        int iLocate_0 = locate_0(this.nativeObj, point.f7681x, point.f7682y, dArr, dArr2);
        if (iArr != null) {
            iArr[0] = (int) dArr[0];
        }
        if (iArr2 != null) {
            iArr2[0] = (int) dArr2[0];
        }
        return iLocate_0;
    }

    public int nextEdge(int i5) {
        return nextEdge_0(this.nativeObj, i5);
    }

    public int rotateEdge(int i5, int i6) {
        return rotateEdge_0(this.nativeObj, i5, i6);
    }

    public int symEdge(int i5) {
        return symEdge_0(this.nativeObj, i5);
    }

    public Subdiv2D() {
        this.nativeObj = Subdiv2D_0();
    }

    public void insert(MatOfPoint2f matOfPoint2f) {
        insert_1(this.nativeObj, matOfPoint2f.nativeObj);
    }

    public Subdiv2D(Rect rect) {
        this.nativeObj = Subdiv2D_1(rect.f7686x, rect.f7687y, rect.width, rect.height);
    }

    public int edgeDst(int i5) {
        return edgeDst_1(this.nativeObj, i5);
    }

    public int edgeOrg(int i5) {
        return edgeOrg_1(this.nativeObj, i5);
    }

    public int findNearest(Point point) {
        return findNearest_1(this.nativeObj, point.f7681x, point.f7682y);
    }

    public Point getVertex(int i5) {
        return new Point(getVertex_1(this.nativeObj, i5));
    }
}
