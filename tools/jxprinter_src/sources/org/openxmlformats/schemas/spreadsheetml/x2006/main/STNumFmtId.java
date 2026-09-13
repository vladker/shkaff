package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STNumFmtId extends XmlUnsignedInt {
    public static final SimpleTypeFactory<STNumFmtId> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STNumFmtId> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stnumfmtid76fbtype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
