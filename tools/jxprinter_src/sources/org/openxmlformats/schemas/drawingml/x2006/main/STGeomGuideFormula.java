package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STGeomGuideFormula extends XmlString {
    public static final SimpleTypeFactory<STGeomGuideFormula> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STGeomGuideFormula> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stgeomguideformula4b51type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
