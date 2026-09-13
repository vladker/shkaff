package org.apache.poi.xdgf.usermodel.shape;

import java.awt.geom.AffineTransform;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeTextVisitor extends ShapeVisitor {
    protected StringBuilder text = new StringBuilder();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TextAcceptor implements ShapeVisitorAcceptor {
        @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitorAcceptor
        public boolean accept(XDGFShape xDGFShape) {
            return xDGFShape.hasText();
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitor
    public ShapeVisitorAcceptor getAcceptor() {
        return new TextAcceptor();
    }

    public String getText() {
        return this.text.toString();
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitor
    public void visit(XDGFShape xDGFShape, AffineTransform affineTransform, int i5) {
        this.text.append(xDGFShape.getText().getTextContent().trim());
        this.text.append('\n');
    }
}
