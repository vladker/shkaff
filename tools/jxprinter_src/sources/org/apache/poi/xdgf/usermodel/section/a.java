package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.util.function.Function;
import org.apache.poi.xdgf.usermodel.section.geometry.ArcTo;
import org.apache.poi.xdgf.usermodel.section.geometry.Ellipse;
import org.apache.poi.xdgf.usermodel.section.geometry.EllipticalArcTo;
import org.apache.poi.xdgf.usermodel.section.geometry.InfiniteLine;
import org.apache.poi.xdgf.usermodel.section.geometry.LineTo;
import org.apache.poi.xdgf.usermodel.section.geometry.MoveTo;
import org.apache.poi.xdgf.usermodel.section.geometry.NURBSTo;
import org.apache.poi.xdgf.usermodel.section.geometry.PolyLineTo;
import org.apache.poi.xdgf.usermodel.section.geometry.RelCubBezTo;
import org.apache.poi.xdgf.usermodel.section.geometry.RelEllipticalArcTo;
import org.apache.poi.xdgf.usermodel.section.geometry.RelLineTo;
import org.apache.poi.xdgf.usermodel.section.geometry.RelMoveTo;
import org.apache.poi.xdgf.usermodel.section.geometry.RelQuadBezTo;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineKnot;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineStart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7277a;

    public /* synthetic */ a(int i5) {
        this.f7277a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7277a) {
            case 0:
                return ((GeometryRowTypes) obj).getRowType();
            case 1:
                return ((XDGFSectionTypes) obj).getSectionType();
            case 2:
                return new ArcTo((RowType) obj);
            case 3:
                return new LineTo((RowType) obj);
            case 4:
                return new MoveTo((RowType) obj);
            case 5:
                return new NURBSTo((RowType) obj);
            case 6:
                return new PolyLineTo((RowType) obj);
            case 7:
                return new RelCubBezTo((RowType) obj);
            case 8:
                return new RelEllipticalArcTo((RowType) obj);
            case 9:
                return new RelLineTo((RowType) obj);
            case 10:
                return new RelMoveTo((RowType) obj);
            case 11:
                return new RelQuadBezTo((RowType) obj);
            case 12:
                return new SplineKnot((RowType) obj);
            case 13:
                return new SplineStart((RowType) obj);
            case 14:
                return new Ellipse((RowType) obj);
            case 15:
                return new EllipticalArcTo((RowType) obj);
            default:
                return new InfiniteLine((RowType) obj);
        }
    }
}
