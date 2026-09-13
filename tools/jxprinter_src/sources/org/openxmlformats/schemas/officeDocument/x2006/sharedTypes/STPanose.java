package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STPanose extends XmlHexBinary {
    public static final SimpleTypeFactory<STPanose> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STPanose> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stpanosedb3etype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
