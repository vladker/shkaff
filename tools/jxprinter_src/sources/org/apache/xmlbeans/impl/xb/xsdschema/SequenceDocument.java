package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SequenceDocument extends XmlObject {
    public static final DocumentFactory<SequenceDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<SequenceDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "sequencecba2doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    ExplicitGroup addNewSequence();

    ExplicitGroup getSequence();

    void setSequence(ExplicitGroup explicitGroup);
}
