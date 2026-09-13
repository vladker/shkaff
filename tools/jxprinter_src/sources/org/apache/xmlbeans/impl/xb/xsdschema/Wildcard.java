package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Wildcard extends Annotated {
    public static final DocumentFactory<Wildcard> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ProcessContents extends XmlNMTOKEN {
        public static final ElementFactory<ProcessContents> Factory;
        public static final int INT_LAX = 2;
        public static final int INT_SKIP = 1;
        public static final int INT_STRICT = 3;
        public static final Enum LAX;
        public static final Enum SKIP;
        public static final Enum STRICT;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_LAX = 2;
            static final int INT_SKIP = 1;
            static final int INT_STRICT = 3;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("skip", 1), new Enum("lax", 2), new Enum("strict", 3)});

            private Enum(String str, int i5) {
                super(str, i5);
            }

            public static Enum forInt(int i5) {
                return (Enum) table.forInt(i5);
            }

            public static Enum forString(String str) {
                return (Enum) table.forString(str);
            }

            private Object readResolve() {
                return forInt(intValue());
            }
        }

        static {
            ElementFactory<ProcessContents> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "processcontents864aattrtype");
            Factory = elementFactory;
            type = elementFactory.getType();
            SKIP = Enum.forString("skip");
            LAX = Enum.forString("lax");
            STRICT = Enum.forString("strict");
        }

        StringEnumAbstractBase getEnumValue();

        void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
    }

    static {
        DocumentFactory<Wildcard> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "wildcarde0b9type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getNamespace();

    ProcessContents.Enum getProcessContents();

    boolean isSetNamespace();

    boolean isSetProcessContents();

    void setNamespace(Object obj);

    void setProcessContents(ProcessContents.Enum r6);

    void unsetNamespace();

    void unsetProcessContents();

    NamespaceList xgetNamespace();

    ProcessContents xgetProcessContents();

    void xsetNamespace(NamespaceList namespaceList);

    void xsetProcessContents(ProcessContents processContents);
}
