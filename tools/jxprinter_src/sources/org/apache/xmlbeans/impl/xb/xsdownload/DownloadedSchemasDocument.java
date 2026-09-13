package org.apache.xmlbeans.impl.xb.xsdownload;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface DownloadedSchemasDocument extends XmlObject {
    public static final DocumentFactory<DownloadedSchemasDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface DownloadedSchemas extends XmlObject {
        public static final ElementFactory<DownloadedSchemas> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<DownloadedSchemas> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "downloadedschemasb3efelemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        DownloadedSchemaEntry addNewEntry();

        String getDefaultDirectory();

        DownloadedSchemaEntry getEntryArray(int i5);

        DownloadedSchemaEntry[] getEntryArray();

        List<DownloadedSchemaEntry> getEntryList();

        DownloadedSchemaEntry insertNewEntry(int i5);

        boolean isSetDefaultDirectory();

        void removeEntry(int i5);

        void setDefaultDirectory(String str);

        void setEntryArray(int i5, DownloadedSchemaEntry downloadedSchemaEntry);

        void setEntryArray(DownloadedSchemaEntry[] downloadedSchemaEntryArr);

        int sizeOfEntryArray();

        void unsetDefaultDirectory();

        XmlToken xgetDefaultDirectory();

        void xsetDefaultDirectory(XmlToken xmlToken);
    }

    static {
        DocumentFactory<DownloadedSchemasDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "downloadedschemas2dd7doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    DownloadedSchemas addNewDownloadedSchemas();

    DownloadedSchemas getDownloadedSchemas();

    void setDownloadedSchemas(DownloadedSchemas downloadedSchemas);
}
