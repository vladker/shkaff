package org.apache.poi.xdgf.usermodel.shape;

import java.awt.geom.AffineTransform;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ShapeVisitor {
    protected ShapeVisitorAcceptor _acceptor = getAcceptor();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAcceptor$0(XDGFShape xDGFShape) {
        return !xDGFShape.isDeleted();
    }

    public boolean accept(XDGFShape xDGFShape) {
        return this._acceptor.accept(xDGFShape);
    }

    public ShapeVisitorAcceptor getAcceptor() {
        return new a(3);
    }

    public void setAcceptor(ShapeVisitorAcceptor shapeVisitorAcceptor) {
        this._acceptor = shapeVisitorAcceptor;
    }

    public abstract void visit(XDGFShape xDGFShape, AffineTransform affineTransform, int i5);
}
