package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTGeomGuide extends XmlObject {
    public static final DocumentFactory<CTGeomGuide> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTGeomGuide> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgeomguidef191type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getFmla();

    String getName();

    void setFmla(String str);

    void setName(String str);

    STGeomGuideFormula xgetFmla();

    STGeomGuideName xgetName();

    void xsetFmla(STGeomGuideFormula sTGeomGuideFormula);

    void xsetName(STGeomGuideName sTGeomGuideName);
}
