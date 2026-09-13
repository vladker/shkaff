package org.apache.poi.sl.draw.geom;

import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ArcToCommandIf extends PathCommand {
    @Override // org.apache.poi.sl.draw.geom.PathCommand
    default void execute(Path2D.Double r23, Context context) {
        double value = context.getValue(getWR());
        double value2 = context.getValue(getHR());
        double value3 = context.getValue(getStAng()) / 60000.0d;
        double value4 = context.getValue(getSwAng()) / 60000.0d;
        double dConvertOoxml2AwtAngle = ArcToCommand.convertOoxml2AwtAngle(value3, value, value2);
        double dConvertOoxml2AwtAngle2 = ArcToCommand.convertOoxml2AwtAngle(value3 + value4, value, value2) - dConvertOoxml2AwtAngle;
        double radians = Math.toRadians(value3);
        double dAtan2 = Math.atan2(Math.sin(radians) * value, Math.cos(radians) * value2);
        Point2D currentPoint = r23.getCurrentPoint();
        r23.append(new Arc2D.Double((currentPoint.getX() - (Math.cos(dAtan2) * value)) - value, (currentPoint.getY() - (Math.sin(dAtan2) * value2)) - value2, value * 2.0d, value2 * 2.0d, dConvertOoxml2AwtAngle, dConvertOoxml2AwtAngle2, 0), true);
    }

    String getHR();

    String getStAng();

    String getSwAng();

    String getWR();

    void setHR(String str);

    void setStAng(String str);

    void setSwAng(String str);

    void setWR(String str);
}
