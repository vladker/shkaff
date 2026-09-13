package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STDrawingElementId extends XmlUnsignedInt {
    public static final SimpleTypeFactory<STDrawingElementId> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STDrawingElementId> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stdrawingelementid75a4type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
