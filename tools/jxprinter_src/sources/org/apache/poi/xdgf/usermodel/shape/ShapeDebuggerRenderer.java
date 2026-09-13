package org.apache.poi.xdgf.usermodel.shape;

import A3.AbstractC0157z;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeDebuggerRenderer extends ShapeRenderer {
    ShapeVisitorAcceptor _debugAcceptor;

    public ShapeDebuggerRenderer() {
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeRenderer
    public Path2D drawPath(XDGFShape xDGFShape) {
        float f6;
        Path2D path2DDrawPath = super.drawPath(xDGFShape);
        ShapeVisitorAcceptor shapeVisitorAcceptor = this._debugAcceptor;
        if (shapeVisitorAcceptor != null && !shapeVisitorAcceptor.accept(xDGFShape)) {
            return path2DDrawPath;
        }
        Font font = this._graphics.getFont();
        this._graphics.scale(1.0d, -1.0d);
        this._graphics.setFont(font.deriveFont(0.05f));
        String string = "" + xDGFShape.getID();
        if (xDGFShape.hasMasterShape()) {
            StringBuilder sbX = AbstractC0157z.x(string, " MS:");
            sbX.append(xDGFShape.getMasterShape().getID());
            string = sbX.toString();
            f6 = -0.25f;
        } else {
            f6 = -0.1f;
        }
        this._graphics.drawString(string, f6, 0.0f);
        this._graphics.setFont(font);
        this._graphics.scale(1.0d, -1.0d);
        return path2DDrawPath;
    }

    public void setDebugAcceptor(ShapeVisitorAcceptor shapeVisitorAcceptor) {
        this._debugAcceptor = shapeVisitorAcceptor;
    }

    public ShapeDebuggerRenderer(Graphics2D graphics2D) {
        super(graphics2D);
    }
}
