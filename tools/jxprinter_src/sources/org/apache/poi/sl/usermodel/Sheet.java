package org.apache.poi.sl.usermodel;

import java.awt.Graphics2D;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Sheet<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends ShapeContainer<S, P> {
    void draw(Graphics2D graphics2D);

    Background<S, P> getBackground();

    boolean getFollowMasterGraphics();

    MasterSheet<S, P> getMasterSheet();

    PlaceholderDetails getPlaceholderDetails(Placeholder placeholder);

    SlideShow<S, P> getSlideShow();
}
