package org.apache.poi.xdgf.geom;

import S1.d;
import S1.l;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineKnot;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineStart;
import p035f5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SplineCollector {
    ArrayList<SplineKnot> _knots = new ArrayList<>();
    SplineStart _start;

    public SplineCollector(SplineStart splineStart) {
        this._start = splineStart;
    }

    public void addKnot(SplineKnot splineKnot) {
        if (splineKnot.getDel()) {
            return;
        }
        this._knots.add(splineKnot);
    }

    public void addToPath(Path2D.Double r14, XDGFShape xDGFShape) {
        Point2D currentPoint = r14.getCurrentPoint();
        d dVar = new d();
        int size = this._knots.size() + 3;
        l lVar = new l();
        int i5 = 0;
        lVar.f633a = 0;
        lVar.b = null;
        lVar.b = new double[size];
        double dDoubleValue = this._start.getB().doubleValue();
        double dDoubleValue2 = this._start.getC().doubleValue();
        int iIntValue = this._start.getD().intValue();
        lVar.a(dDoubleValue);
        lVar.a(this._start.getA().doubleValue());
        dVar.a(b.c(currentPoint.getX(), currentPoint.getY()));
        dVar.a(b.c(this._start.getX().doubleValue(), this._start.getY().doubleValue()));
        ArrayList<SplineKnot> arrayList = this._knots;
        int size2 = arrayList.size();
        while (i5 < size2) {
            SplineKnot splineKnot = arrayList.get(i5);
            i5++;
            SplineKnot splineKnot2 = splineKnot;
            lVar.a(splineKnot2.getA().doubleValue());
            dVar.a(b.c(splineKnot2.getX().doubleValue(), splineKnot2.getY().doubleValue()));
        }
        lVar.a(dDoubleValue2);
        r14.append(SplineRenderer.createNurbsSpline(dVar, lVar, null, iIntValue), true);
    }
}
