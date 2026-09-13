package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DocumentFactory<T> extends AbstractDocumentFactory<T> {
    public DocumentFactory(SchemaTypeSystem schemaTypeSystem, String str) {
        super(schemaTypeSystem, str);
    }

    @Override // org.apache.xmlbeans.impl.schema.ElementFactory
    public T newInstance() {
        return (T) getTypeLoader().newInstance(getType(), null);
    }

    @Override // org.apache.xmlbeans.impl.schema.ElementFactory
    public T newInstance(XmlOptions xmlOptions) {
        return (T) getTypeLoader().newInstance(getType(), xmlOptions);
    }
}
