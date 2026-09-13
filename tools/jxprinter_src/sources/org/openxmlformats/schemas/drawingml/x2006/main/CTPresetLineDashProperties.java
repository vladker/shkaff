package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPresetLineDashProperties extends XmlObject {
    public static final DocumentFactory<CTPresetLineDashProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPresetLineDashProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpresetlinedashproperties4553type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STPresetLineDashVal.Enum getVal();

    boolean isSetVal();

    void setVal(STPresetLineDashVal.Enum r6);

    void unsetVal();

    STPresetLineDashVal xgetVal();

    void xsetVal(STPresetLineDashVal sTPresetLineDashVal);
}
