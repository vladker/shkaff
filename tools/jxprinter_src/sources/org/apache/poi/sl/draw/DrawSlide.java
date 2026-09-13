package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.Background;
import org.apache.poi.sl.usermodel.Slide;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawSlide extends DrawSheet {
    public DrawSlide(Slide<?, ?> slide) {
        super(slide);
    }

    @Override // org.apache.poi.sl.draw.DrawSheet, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Drawable.DrawableHint drawableHint = Drawable.CURRENT_SLIDE;
        graphics2D.setRenderingHint(drawableHint, this.sheet);
        Background<S, P> background = this.sheet.getBackground();
        if (background != 0) {
            DrawFactory.getInstance(graphics2D).getDrawable((Background<?, ?>) background).draw(graphics2D);
        }
        super.draw(graphics2D);
        graphics2D.setRenderingHint(drawableHint, (Object) null);
    }
}
