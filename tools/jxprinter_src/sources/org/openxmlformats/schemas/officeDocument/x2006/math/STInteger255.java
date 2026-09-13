package org.openxmlformats.schemas.officeDocument.x2006.math;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STInteger255 extends XmlInteger {
    public static final SimpleTypeFactory<STInteger255> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STInteger255> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stinteger2550f8etype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }

    int getIntValue();

    void setIntValue(int i5);
}
