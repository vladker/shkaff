package org.apache.xmlbeans.impl.xb.xsdownload;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface DownloadedSchemaEntry extends XmlObject {
    public static final DocumentFactory<DownloadedSchemaEntry> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<DownloadedSchemaEntry> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "downloadedschemaentry1c75type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    XmlAnyURI addNewSchemaLocation();

    void addSchemaLocation(String str);

    String getFilename();

    String getNamespace();

    String getSchemaLocationArray(int i5);

    String[] getSchemaLocationArray();

    List<String> getSchemaLocationList();

    String getSha1();

    XmlAnyURI insertNewSchemaLocation(int i5);

    void insertSchemaLocation(int i5, String str);

    boolean isSetNamespace();

    void removeSchemaLocation(int i5);

    void setFilename(String str);

    void setNamespace(String str);

    void setSchemaLocationArray(int i5, String str);

    void setSchemaLocationArray(String[] strArr);

    void setSha1(String str);

    int sizeOfSchemaLocationArray();

    void unsetNamespace();

    XmlToken xgetFilename();

    XmlAnyURI xgetNamespace();

    XmlAnyURI xgetSchemaLocationArray(int i5);

    XmlAnyURI[] xgetSchemaLocationArray();

    List<XmlAnyURI> xgetSchemaLocationList();

    XmlToken xgetSha1();

    void xsetFilename(XmlToken xmlToken);

    void xsetNamespace(XmlAnyURI xmlAnyURI);

    void xsetSchemaLocationArray(int i5, XmlAnyURI xmlAnyURI);

    void xsetSchemaLocationArray(XmlAnyURI[] xmlAnyURIArr);

    void xsetSha1(XmlToken xmlToken);
}
