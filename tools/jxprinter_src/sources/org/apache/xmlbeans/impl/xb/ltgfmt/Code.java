package org.apache.xmlbeans.impl.xb.ltgfmt;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Code extends XmlObject {
    public static final DocumentFactory<Code> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<Code> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "codef72ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getID();

    boolean isSetID();

    void setID(String str);

    void unsetID();

    XmlToken xgetID();

    void xsetID(XmlToken xmlToken);
}
