package org.apache.xmlbeans.impl.xb.xmlconfig;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface JavaName extends XmlToken {
    public static final SimpleTypeFactory<JavaName> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<JavaName> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "javanamee640type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
