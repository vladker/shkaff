package org.apache.poi.sl.draw;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.Background;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.Sheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawBackground extends DrawShape {
    public DrawBackground(Background<?, ?> background) {
        super(background);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Dimension pageSize = this.shape.getSheet().getSlideShow().getPageSize();
        final Rectangle2D.Double r6 = new Rectangle2D.Double(0.0d, 0.0d, pageSize.getWidth(), pageSize.getHeight());
        Paint paint = DrawFactory.getInstance(graphics2D).getPaint(new PlaceableShape() { // from class: org.apache.poi.sl.draw.DrawBackground.1
            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public Rectangle2D getAnchor() {
                return r6;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public boolean getFlipHorizontal() {
                return false;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public boolean getFlipVertical() {
                return false;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public ShapeContainer<?, ?> getParent() {
                return null;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public double getRotation() {
                return 0.0d;
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public Sheet<?, ?> getSheet() {
                return DrawBackground.this.shape.getSheet();
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setAnchor(Rectangle2D rectangle2D) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setFlipHorizontal(boolean z6) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setFlipVertical(boolean z6) {
            }

            @Override // org.apache.poi.sl.usermodel.PlaceableShape
            public void setRotation(double d) {
            }
        }).getPaint(graphics2D, getShape().getFillStyle().getPaint());
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, (Rectangle2D) r6);
        if (paint != null) {
            graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, r6);
            graphics2D.setPaint(paint);
            DrawPaint.fillPaintWorkaround(graphics2D, anchor);
        }
    }

    @Override // org.apache.poi.sl.draw.DrawShape
    public Background<?, ?> getShape() {
        return (Background) this.shape;
    }
}
