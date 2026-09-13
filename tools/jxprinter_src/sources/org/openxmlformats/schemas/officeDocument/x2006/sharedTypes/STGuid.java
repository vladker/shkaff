package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STGuid extends XmlToken {
    public static final SimpleTypeFactory<STGuid> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STGuid> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stguid3883type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
