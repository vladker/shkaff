package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Public extends XmlToken {
    public static final SimpleTypeFactory<Public> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<Public> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "publicf3catype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
