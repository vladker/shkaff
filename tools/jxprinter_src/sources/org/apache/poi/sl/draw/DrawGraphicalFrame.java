package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.GraphicalFrame;
import org.apache.poi.sl.usermodel.PictureShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawGraphicalFrame extends DrawShape {
    public DrawGraphicalFrame(GraphicalFrame<?, ?> graphicalFrame) {
        super(graphicalFrame);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        PictureShape<?, ?> fallbackPicture = ((GraphicalFrame) getShape()).getFallbackPicture();
        if (fallbackPicture == null) {
            return;
        }
        DrawFactory.getInstance(graphics2D).getDrawable(fallbackPicture).draw(graphics2D);
    }
}
