package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface UnionDocument extends XmlObject {
    public static final DocumentFactory<UnionDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Union extends Annotated {
        public static final ElementFactory<Union> Factory;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface MemberTypes extends XmlAnySimpleType {
            public static final ElementFactory<MemberTypes> Factory;
            public static final SchemaType type;

            static {
                ElementFactory<MemberTypes> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "membertypes2404attrtype");
                Factory = elementFactory;
                type = elementFactory.getType();
            }

            List getListValue();

            void setListValue(List<?> list);

            List xgetListValue();
        }

        static {
            ElementFactory<Union> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "union498belemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        LocalSimpleType addNewSimpleType();

        List getMemberTypes();

        LocalSimpleType getSimpleTypeArray(int i5);

        LocalSimpleType[] getSimpleTypeArray();

        List<LocalSimpleType> getSimpleTypeList();

        LocalSimpleType insertNewSimpleType(int i5);

        boolean isSetMemberTypes();

        void removeSimpleType(int i5);

        void setMemberTypes(List list);

        void setSimpleTypeArray(int i5, LocalSimpleType localSimpleType);

        void setSimpleTypeArray(LocalSimpleType[] localSimpleTypeArr);

        int sizeOfSimpleTypeArray();

        void unsetMemberTypes();

        MemberTypes xgetMemberTypes();

        void xsetMemberTypes(MemberTypes memberTypes);
    }

    static {
        DocumentFactory<UnionDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "union5866doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Union addNewUnion();

    Union getUnion();

    void setUnion(Union union);
}
