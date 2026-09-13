package org.apache.poi.sl.usermodel;

import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Shadow<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> {
    double getAngle();

    double getBlur();

    double getDistance();

    PaintStyle.SolidPaint getFillStyle();

    SimpleShape<S, P> getShadowParent();
}
