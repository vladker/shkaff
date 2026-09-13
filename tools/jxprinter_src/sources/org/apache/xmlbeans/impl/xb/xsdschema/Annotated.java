package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Annotated extends OpenAttrs {
    public static final DocumentFactory<Annotated> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<Annotated> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "annotateda52dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    AnnotationDocument.Annotation addNewAnnotation();

    AnnotationDocument.Annotation getAnnotation();

    String getId();

    boolean isSetAnnotation();

    boolean isSetId();

    void setAnnotation(AnnotationDocument.Annotation annotation);

    void setId(String str);

    void unsetAnnotation();

    void unsetId();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
