package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STUcharHexNumber extends XmlHexBinary {
    public static final SimpleTypeFactory<STUcharHexNumber> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STUcharHexNumber> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stucharhexnumber4efftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
