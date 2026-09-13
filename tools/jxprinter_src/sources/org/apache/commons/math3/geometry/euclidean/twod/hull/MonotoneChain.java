package org.apache.commons.math3.geometry.euclidean.twod.hull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MonotoneChain extends AbstractConvexHullGenerator2D {
    public MonotoneChain() {
        this(false);
    }

    private void updateHull(Vector2D vector2D, List<Vector2D> list) {
        double tolerance = getTolerance();
        if (list.size() != 1 || list.get(0).distance((Vector<Euclidean2D>) vector2D) >= tolerance) {
            while (list.size() >= 2) {
                int size = list.size();
                Vector2D vector2D2 = list.get(size - 2);
                int i5 = size - 1;
                Vector2D vector2D3 = list.get(i5);
                double offset = new Line(vector2D2, vector2D3, tolerance).getOffset((Vector<Euclidean2D>) vector2D);
                if (FastMath.abs(offset) >= tolerance) {
                    if (offset <= 0.0d) {
                        break;
                    } else {
                        list.remove(i5);
                    }
                } else {
                    double dDistance = vector2D2.distance((Vector<Euclidean2D>) vector2D);
                    if (dDistance < tolerance || vector2D3.distance((Vector<Euclidean2D>) vector2D) < tolerance) {
                        return;
                    }
                    double dDistance2 = vector2D2.distance((Vector<Euclidean2D>) vector2D3);
                    if (isIncludeCollinearPoints()) {
                        if (dDistance < dDistance2) {
                            size = i5;
                        }
                        list.add(size, vector2D);
                        return;
                    } else {
                        if (dDistance > dDistance2) {
                            list.remove(i5);
                            list.add(vector2D);
                            return;
                        }
                        return;
                    }
                }
            }
            list.add(vector2D);
        }
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.AbstractConvexHullGenerator2D
    public Collection<Vector2D> findHullVertices(Collection<Vector2D> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<Vector2D>() { // from class: org.apache.commons.math3.geometry.euclidean.twod.hull.MonotoneChain.1
            @Override // java.util.Comparator
            public int compare(Vector2D vector2D, Vector2D vector2D2) {
                double tolerance = MonotoneChain.this.getTolerance();
                int iCompareTo = Precision.compareTo(vector2D.getX(), vector2D2.getX(), tolerance);
                return iCompareTo == 0 ? Precision.compareTo(vector2D.getY(), vector2D2.getY(), tolerance) : iCompareTo;
            }
        });
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            updateHull((Vector2D) obj, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            updateHull((Vector2D) arrayList.get(size2), arrayList3);
        }
        ArrayList arrayList4 = new ArrayList((arrayList3.size() + arrayList2.size()) - 2);
        for (int i6 = 0; i6 < arrayList2.size() - 1; i6++) {
            arrayList4.add(arrayList2.get(i6));
        }
        for (int i7 = 0; i7 < arrayList3.size() - 1; i7++) {
            arrayList4.add(arrayList3.get(i7));
        }
        if (arrayList4.isEmpty() && !arrayList2.isEmpty()) {
            arrayList4.add(arrayList2.get(0));
        }
        return arrayList4;
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.AbstractConvexHullGenerator2D, org.apache.commons.math3.geometry.euclidean.twod.hull.ConvexHullGenerator2D, org.apache.commons.math3.geometry.hull.ConvexHullGenerator
    public /* bridge */ /* synthetic */ ConvexHull2D generate(Collection collection) {
        return super.generate((Collection<Vector2D>) collection);
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.AbstractConvexHullGenerator2D
    public /* bridge */ /* synthetic */ double getTolerance() {
        return super.getTolerance();
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.AbstractConvexHullGenerator2D
    public /* bridge */ /* synthetic */ boolean isIncludeCollinearPoints() {
        return super.isIncludeCollinearPoints();
    }

    public MonotoneChain(boolean z6) {
        super(z6);
    }

    public MonotoneChain(boolean z6, double d) {
        super(z6, d);
    }
}
