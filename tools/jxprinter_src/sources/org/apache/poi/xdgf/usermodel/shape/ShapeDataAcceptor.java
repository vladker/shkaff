package org.apache.poi.xdgf.usermodel.shape;

import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeDataAcceptor implements ShapeVisitorAcceptor {
    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitorAcceptor
    public boolean accept(XDGFShape xDGFShape) {
        if (xDGFShape.isDeleted()) {
            return false;
        }
        if ((xDGFShape.hasText() && xDGFShape.getTextAsString().length() != 0) || xDGFShape.isShape1D()) {
            return true;
        }
        if (!xDGFShape.hasMaster() && !xDGFShape.hasMasterShape()) {
            return true;
        }
        if (!xDGFShape.hasMaster() || xDGFShape.hasMasterShape()) {
            return xDGFShape.hasMasterShape() && xDGFShape.getMasterShape().isTopmost();
        }
        return true;
    }
}
