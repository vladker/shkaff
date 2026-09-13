package org.apache.xmlbeans.impl.xb.substwsdl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface TImport extends XmlObject {
    public static final DocumentFactory<TImport> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<TImport> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "timport22datype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getLocation();

    String getNamespace();

    void setLocation(String str);

    void setNamespace(String str);

    XmlAnyURI xgetLocation();

    XmlAnyURI xgetNamespace();

    void xsetLocation(XmlAnyURI xmlAnyURI);

    void xsetNamespace(XmlAnyURI xmlAnyURI);
}
