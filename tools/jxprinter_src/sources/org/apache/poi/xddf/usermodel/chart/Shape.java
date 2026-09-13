package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum Shape {
    BOX(STShape.BOX),
    CONE(STShape.CONE),
    CONE_TO_MAX(STShape.CONE_TO_MAX),
    CYLINDER(STShape.CYLINDER),
    PYRAMID(STShape.PYRAMID),
    PYRAMID_TO_MAX(STShape.PYRAMID_TO_MAX);

    private static final HashMap<STShape.Enum, Shape> reverse = new HashMap<>();
    final STShape.Enum underlying;

    static {
        for (Shape shape : values()) {
            reverse.put(shape.underlying, shape);
        }
    }

    Shape(STShape.Enum r6) {
        this.underlying = r6;
    }

    public static Shape valueOf(STShape.Enum r6) {
        return reverse.get(r6);
    }
}
