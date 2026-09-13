package org.apache.poi.xdgf.usermodel.shape;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.XDGFText;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeRenderer extends ShapeVisitor {
    protected Graphics2D _graphics;

    public ShapeRenderer() {
        this._graphics = null;
    }

    public Path2D drawPath(XDGFShape xDGFShape) {
        Path2D.Double path = xDGFShape.getPath();
        if (path != null) {
            this._graphics.setColor(xDGFShape.getLineColor());
            this._graphics.setStroke(xDGFShape.getStroke());
            this._graphics.draw(path);
        }
        return path;
    }

    public void drawText(XDGFShape xDGFShape) {
        XDGFText text = xDGFShape.getText();
        if (text != null) {
            if (text.getTextContent().equals("Header")) {
                text.getTextBounds();
            }
            Font font = this._graphics.getFont();
            this._graphics.setFont(font.deriveFont(xDGFShape.getFontSize().floatValue()));
            this._graphics.setColor(xDGFShape.getFontColor());
            text.draw(this._graphics);
            this._graphics.setFont(font);
        }
    }

    public void setGraphics(Graphics2D graphics2D) {
        this._graphics = graphics2D;
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitor
    public void visit(XDGFShape xDGFShape, AffineTransform affineTransform, int i5) {
        AffineTransform transform = this._graphics.getTransform();
        this._graphics.transform(affineTransform);
        drawPath(xDGFShape);
        drawText(xDGFShape);
        this._graphics.setTransform(transform);
    }

    public ShapeRenderer(Graphics2D graphics2D) {
        this._graphics = graphics2D;
    }
}
