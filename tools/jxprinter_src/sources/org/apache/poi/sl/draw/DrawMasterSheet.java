package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.sl.usermodel.Slide;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawMasterSheet extends DrawSheet {
    public DrawMasterSheet(MasterSheet<?, ?> masterSheet) {
        super(masterSheet);
    }

    @Override // org.apache.poi.sl.draw.DrawSheet
    public boolean canDraw(Graphics2D graphics2D, Shape<?, ?> shape) {
        Slide slide = (Slide) graphics2D.getRenderingHint(Drawable.CURRENT_SLIDE);
        if (shape instanceof SimpleShape) {
            SimpleShape<?, ?> simpleShape = (SimpleShape) shape;
            if (simpleShape.getPlaceholder() != null) {
                return slide.getDisplayPlaceholder(simpleShape);
            }
        }
        return slide.getFollowMasterGraphics();
    }
}
