package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface PatternDocument extends XmlObject {
    public static final DocumentFactory<PatternDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Pattern extends NoFixedFacet {
        public static final ElementFactory<Pattern> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Pattern> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "pattern6809elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }
    }

    static {
        DocumentFactory<PatternDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "pattern9585doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Pattern addNewPattern();

    Pattern getPattern();

    void setPattern(Pattern pattern);
}
