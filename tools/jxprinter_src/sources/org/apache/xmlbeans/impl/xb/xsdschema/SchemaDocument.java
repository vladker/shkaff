package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SchemaDocument extends XmlObject {
    public static final DocumentFactory<SchemaDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Schema extends OpenAttrs {
        public static final ElementFactory<Schema> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Schema> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "schemad77felemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        AnnotationDocument.Annotation addNewAnnotation();

        TopLevelAttribute addNewAttribute();

        NamedAttributeGroup addNewAttributeGroup();

        TopLevelComplexType addNewComplexType();

        TopLevelElement addNewElement();

        NamedGroup addNewGroup();

        ImportDocument.Import addNewImport();

        IncludeDocument.Include addNewInclude();

        NotationDocument.Notation addNewNotation();

        RedefineDocument.Redefine addNewRedefine();

        TopLevelSimpleType addNewSimpleType();

        AnnotationDocument.Annotation getAnnotationArray(int i5);

        AnnotationDocument.Annotation[] getAnnotationArray();

        List<AnnotationDocument.Annotation> getAnnotationList();

        TopLevelAttribute getAttributeArray(int i5);

        TopLevelAttribute[] getAttributeArray();

        FormChoice.Enum getAttributeFormDefault();

        NamedAttributeGroup getAttributeGroupArray(int i5);

        NamedAttributeGroup[] getAttributeGroupArray();

        List<NamedAttributeGroup> getAttributeGroupList();

        List<TopLevelAttribute> getAttributeList();

        Object getBlockDefault();

        TopLevelComplexType getComplexTypeArray(int i5);

        TopLevelComplexType[] getComplexTypeArray();

        List<TopLevelComplexType> getComplexTypeList();

        TopLevelElement getElementArray(int i5);

        TopLevelElement[] getElementArray();

        FormChoice.Enum getElementFormDefault();

        List<TopLevelElement> getElementList();

        Object getFinalDefault();

        NamedGroup getGroupArray(int i5);

        NamedGroup[] getGroupArray();

        List<NamedGroup> getGroupList();

        String getId();

        ImportDocument.Import getImportArray(int i5);

        ImportDocument.Import[] getImportArray();

        List<ImportDocument.Import> getImportList();

        IncludeDocument.Include getIncludeArray(int i5);

        IncludeDocument.Include[] getIncludeArray();

        List<IncludeDocument.Include> getIncludeList();

        String getLang();

        NotationDocument.Notation getNotationArray(int i5);

        NotationDocument.Notation[] getNotationArray();

        List<NotationDocument.Notation> getNotationList();

        RedefineDocument.Redefine getRedefineArray(int i5);

        RedefineDocument.Redefine[] getRedefineArray();

        List<RedefineDocument.Redefine> getRedefineList();

        TopLevelSimpleType getSimpleTypeArray(int i5);

        TopLevelSimpleType[] getSimpleTypeArray();

        List<TopLevelSimpleType> getSimpleTypeList();

        String getTargetNamespace();

        String getVersion();

        AnnotationDocument.Annotation insertNewAnnotation(int i5);

        TopLevelAttribute insertNewAttribute(int i5);

        NamedAttributeGroup insertNewAttributeGroup(int i5);

        TopLevelComplexType insertNewComplexType(int i5);

        TopLevelElement insertNewElement(int i5);

        NamedGroup insertNewGroup(int i5);

        ImportDocument.Import insertNewImport(int i5);

        IncludeDocument.Include insertNewInclude(int i5);

        NotationDocument.Notation insertNewNotation(int i5);

        RedefineDocument.Redefine insertNewRedefine(int i5);

        TopLevelSimpleType insertNewSimpleType(int i5);

        boolean isSetAttributeFormDefault();

        boolean isSetBlockDefault();

        boolean isSetElementFormDefault();

        boolean isSetFinalDefault();

        boolean isSetId();

        boolean isSetLang();

        boolean isSetTargetNamespace();

        boolean isSetVersion();

        void removeAnnotation(int i5);

        void removeAttribute(int i5);

        void removeAttributeGroup(int i5);

        void removeComplexType(int i5);

        void removeElement(int i5);

        void removeGroup(int i5);

        void removeImport(int i5);

        void removeInclude(int i5);

        void removeNotation(int i5);

        void removeRedefine(int i5);

        void removeSimpleType(int i5);

        void setAnnotationArray(int i5, AnnotationDocument.Annotation annotation);

        void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr);

        void setAttributeArray(int i5, TopLevelAttribute topLevelAttribute);

        void setAttributeArray(TopLevelAttribute[] topLevelAttributeArr);

        void setAttributeFormDefault(FormChoice.Enum r6);

        void setAttributeGroupArray(int i5, NamedAttributeGroup namedAttributeGroup);

        void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr);

        void setBlockDefault(Object obj);

        void setComplexTypeArray(int i5, TopLevelComplexType topLevelComplexType);

        void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr);

        void setElementArray(int i5, TopLevelElement topLevelElement);

        void setElementArray(TopLevelElement[] topLevelElementArr);

        void setElementFormDefault(FormChoice.Enum r6);

        void setFinalDefault(Object obj);

        void setGroupArray(int i5, NamedGroup namedGroup);

        void setGroupArray(NamedGroup[] namedGroupArr);

        void setId(String str);

        void setImportArray(int i5, ImportDocument.Import r6);

        void setImportArray(ImportDocument.Import[] importArr);

        void setIncludeArray(int i5, IncludeDocument.Include include);

        void setIncludeArray(IncludeDocument.Include[] includeArr);

        void setLang(String str);

        void setNotationArray(int i5, NotationDocument.Notation notation);

        void setNotationArray(NotationDocument.Notation[] notationArr);

        void setRedefineArray(int i5, RedefineDocument.Redefine redefine);

        void setRedefineArray(RedefineDocument.Redefine[] redefineArr);

        void setSimpleTypeArray(int i5, TopLevelSimpleType topLevelSimpleType);

        void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr);

        void setTargetNamespace(String str);

        void setVersion(String str);

        int sizeOfAnnotationArray();

        int sizeOfAttributeArray();

        int sizeOfAttributeGroupArray();

        int sizeOfComplexTypeArray();

        int sizeOfElementArray();

        int sizeOfGroupArray();

        int sizeOfImportArray();

        int sizeOfIncludeArray();

        int sizeOfNotationArray();

        int sizeOfRedefineArray();

        int sizeOfSimpleTypeArray();

        void unsetAttributeFormDefault();

        void unsetBlockDefault();

        void unsetElementFormDefault();

        void unsetFinalDefault();

        void unsetId();

        void unsetLang();

        void unsetTargetNamespace();

        void unsetVersion();

        FormChoice xgetAttributeFormDefault();

        BlockSet xgetBlockDefault();

        FormChoice xgetElementFormDefault();

        FullDerivationSet xgetFinalDefault();

        XmlID xgetId();

        LangAttribute.Lang xgetLang();

        XmlAnyURI xgetTargetNamespace();

        XmlToken xgetVersion();

        void xsetAttributeFormDefault(FormChoice formChoice);

        void xsetBlockDefault(BlockSet blockSet);

        void xsetElementFormDefault(FormChoice formChoice);

        void xsetFinalDefault(FullDerivationSet fullDerivationSet);

        void xsetId(XmlID xmlID);

        void xsetLang(LangAttribute.Lang lang);

        void xsetTargetNamespace(XmlAnyURI xmlAnyURI);

        void xsetVersion(XmlToken xmlToken);
    }

    static {
        DocumentFactory<SchemaDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "schema0782doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Schema addNewSchema();

    Schema getSchema();

    void setSchema(Schema schema);
}
