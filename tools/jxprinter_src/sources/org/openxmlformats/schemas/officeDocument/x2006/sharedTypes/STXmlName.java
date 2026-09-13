package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STXmlName extends XmlNCName {
    public static final SimpleTypeFactory<STXmlName> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STXmlName> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stxmlname13f2type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
