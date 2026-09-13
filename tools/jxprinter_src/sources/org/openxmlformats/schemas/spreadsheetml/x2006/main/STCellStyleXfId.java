package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STCellStyleXfId extends XmlUnsignedInt {
    public static final SimpleTypeFactory<STCellStyleXfId> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STCellStyleXfId> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stcellstylexfid70c7type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
