package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
enum GeometryRowTypes {
    ARC_TO("ArcTo", new a(2)),
    ELLIPSE("Ellipse", new a(14)),
    ELLIPTICAL_ARC_TO("EllipticalArcTo", new a(15)),
    INFINITE_LINE("InfiniteLine", new a(16)),
    LINE_TO("LineTo", new a(3)),
    MOVE_TO("MoveTo", new a(4)),
    NURBS_TO("NURBSTo", new a(5)),
    POLYLINE_TO("PolylineTo", new a(6)),
    REL_CUB_BEZ_TO("RelCubBezTo", new a(7)),
    REL_ELLIPTICAL_ARC_TO("RelEllipticalArcTo", new a(8)),
    REL_LINE_TO("RelLineTo", new a(9)),
    REL_MOVE_TO("RelMoveTo", new a(10)),
    REL_QUAD_BEZ_TO("RelQuadBezTo", new a(11)),
    SPLINE_KNOT("SplineKnot", new a(12)),
    SPLINE_START("SplineStart", new a(13));

    private static final Map<String, GeometryRowTypes> LOOKUP = (Map) Stream.of((Object[]) values()).collect(Collectors.toMap(new a(0), Function.identity()));
    private final Function<RowType, ? extends GeometryRow> constructor;
    private final String rowType;

    GeometryRowTypes(String str, Function function) {
        this.rowType = str;
        this.constructor = function;
    }

    public static GeometryRow load(RowType rowType) {
        String t6 = rowType.getT();
        GeometryRowTypes geometryRowTypes = LOOKUP.get(t6);
        if (geometryRowTypes != null) {
            return geometryRowTypes.constructor.apply(rowType);
        }
        throw new POIXMLException(androidx.collection.a.p("Invalid '", rowType.schemaType().getName().getLocalPart(), "' name '", t6, "'"));
    }

    public String getRowType() {
        return this.rowType;
    }
}
