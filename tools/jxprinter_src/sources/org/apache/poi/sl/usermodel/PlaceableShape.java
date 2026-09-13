package org.apache.poi.sl.usermodel;

import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface PlaceableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> {
    Rectangle2D getAnchor();

    boolean getFlipHorizontal();

    boolean getFlipVertical();

    ShapeContainer<S, P> getParent();

    double getRotation();

    Sheet<S, P> getSheet();

    void setAnchor(Rectangle2D rectangle2D);

    void setFlipHorizontal(boolean z6);

    void setFlipVertical(boolean z6);

    void setRotation(double d);
}
