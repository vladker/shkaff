package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface RedefineDocument extends XmlObject {
    public static final DocumentFactory<RedefineDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Redefine extends OpenAttrs {
        public static final ElementFactory<Redefine> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Redefine> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "redefine9e9felemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        AnnotationDocument.Annotation addNewAnnotation();

        NamedAttributeGroup addNewAttributeGroup();

        TopLevelComplexType addNewComplexType();

        NamedGroup addNewGroup();

        TopLevelSimpleType addNewSimpleType();

        AnnotationDocument.Annotation getAnnotationArray(int i5);

        AnnotationDocument.Annotation[] getAnnotationArray();

        List<AnnotationDocument.Annotation> getAnnotationList();

        NamedAttributeGroup getAttributeGroupArray(int i5);

        NamedAttributeGroup[] getAttributeGroupArray();

        List<NamedAttributeGroup> getAttributeGroupList();

        TopLevelComplexType getComplexTypeArray(int i5);

        TopLevelComplexType[] getComplexTypeArray();

        List<TopLevelComplexType> getComplexTypeList();

        NamedGroup getGroupArray(int i5);

        NamedGroup[] getGroupArray();

        List<NamedGroup> getGroupList();

        String getId();

        String getSchemaLocation();

        TopLevelSimpleType getSimpleTypeArray(int i5);

        TopLevelSimpleType[] getSimpleTypeArray();

        List<TopLevelSimpleType> getSimpleTypeList();

        AnnotationDocument.Annotation insertNewAnnotation(int i5);

        NamedAttributeGroup insertNewAttributeGroup(int i5);

        TopLevelComplexType insertNewComplexType(int i5);

        NamedGroup insertNewGroup(int i5);

        TopLevelSimpleType insertNewSimpleType(int i5);

        boolean isSetId();

        void removeAnnotation(int i5);

        void removeAttributeGroup(int i5);

        void removeComplexType(int i5);

        void removeGroup(int i5);

        void removeSimpleType(int i5);

        void setAnnotationArray(int i5, AnnotationDocument.Annotation annotation);

        void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr);

        void setAttributeGroupArray(int i5, NamedAttributeGroup namedAttributeGroup);

        void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr);

        void setComplexTypeArray(int i5, TopLevelComplexType topLevelComplexType);

        void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr);

        void setGroupArray(int i5, NamedGroup namedGroup);

        void setGroupArray(NamedGroup[] namedGroupArr);

        void setId(String str);

        void setSchemaLocation(String str);

        void setSimpleTypeArray(int i5, TopLevelSimpleType topLevelSimpleType);

        void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr);

        int sizeOfAnnotationArray();

        int sizeOfAttributeGroupArray();

        int sizeOfComplexTypeArray();

        int sizeOfGroupArray();

        int sizeOfSimpleTypeArray();

        void unsetId();

        XmlID xgetId();

        XmlAnyURI xgetSchemaLocation();

        void xsetId(XmlID xmlID);

        void xsetSchemaLocation(XmlAnyURI xmlAnyURI);
    }

    static {
        DocumentFactory<RedefineDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "redefine3f55doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Redefine addNewRedefine();

    Redefine getRedefine();

    void setRedefine(Redefine redefine);
}
