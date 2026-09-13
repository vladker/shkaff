package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STUnsignedDecimalNumber extends XmlUnsignedLong {
    public static final SimpleTypeFactory<STUnsignedDecimalNumber> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STUnsignedDecimalNumber> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stunsigneddecimalnumber7db5type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
