package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTextNormalAutofit extends XmlObject {
    public static final DocumentFactory<CTTextNormalAutofit> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTextNormalAutofit> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttextnormalautofitbbdftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getFontScale();

    Object getLnSpcReduction();

    boolean isSetFontScale();

    boolean isSetLnSpcReduction();

    void setFontScale(Object obj);

    void setLnSpcReduction(Object obj);

    void unsetFontScale();

    void unsetLnSpcReduction();

    STTextFontScalePercentOrPercentString xgetFontScale();

    STTextSpacingPercentOrPercentString xgetLnSpcReduction();

    void xsetFontScale(STTextFontScalePercentOrPercentString sTTextFontScalePercentOrPercentString);

    void xsetLnSpcReduction(STTextSpacingPercentOrPercentString sTTextSpacingPercentOrPercentString);
}
