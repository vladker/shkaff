package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.Shadow;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFShadow extends XSLFShape implements Shadow<XSLFShape, XSLFTextParagraph> {
    private XSLFSimpleShape _parent;

    public XSLFShadow(CTOuterShadowEffect cTOuterShadowEffect, XSLFSimpleShape xSLFSimpleShape) {
        super(cTOuterShadowEffect, xSLFSimpleShape.getSheet());
        this._parent = xSLFSimpleShape;
    }

    @Override // org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        return this._parent.getAnchor();
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public double getAngle() {
        CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect) getXmlObject();
        if (cTOuterShadowEffect.isSetDir()) {
            return ((double) cTOuterShadowEffect.getDir()) / 60000.0d;
        }
        return 0.0d;
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public double getBlur() {
        CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect) getXmlObject();
        if (cTOuterShadowEffect.isSetBlurRad()) {
            return Units.toPoints(cTOuterShadowEffect.getBlurRad());
        }
        return 0.0d;
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public double getDistance() {
        CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect) getXmlObject();
        if (cTOuterShadowEffect.isSetDist()) {
            return Units.toPoints(cTOuterShadowEffect.getDist());
        }
        return 0.0d;
    }

    public Color getFillColor() {
        PaintStyle.SolidPaint fillStyle = getFillStyle();
        if (fillStyle == null) {
            return null;
        }
        return DrawPaint.applyColorTransform(fillStyle.getSolidColor());
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public PaintStyle.SolidPaint getFillStyle() {
        XSLFTheme theme = getSheet().getTheme();
        CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect) getXmlObject();
        if (cTOuterShadowEffect == null) {
            return null;
        }
        return DrawPaint.createSolidPaint(new XSLFColor(cTOuterShadowEffect, theme, cTOuterShadowEffect.getSchemeClr(), getSheet()).getColorStyle());
    }

    public void setAnchor(Rectangle2D rectangle2D) {
        throw new IllegalStateException("You can't set anchor of a shadow");
    }

    @Override // org.apache.poi.sl.usermodel.Shadow
    public XSLFSimpleShape getShadowParent() {
        return this._parent;
    }
}
