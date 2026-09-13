package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SoapEncSchemaTypeSystem extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    public static final String ARRAY_TYPE = "arrayType";
    private static final String ATTR_HREF = "href";
    private static final String ATTR_ID = "id";
    private static final String ATTR_OFFSET = "offset";
    public static final String SOAPENC = "http://schemas.xmlsoap.org/soap/encoding/";
    public static final String SOAP_ARRAY = "Array";
    private final Map<String, SchemaComponent> _handlesToObjects;
    private final SchemaGlobalAttributeImpl arrayType;
    private final SchemaTypeImpl soapArray;
    private final String soapArrayHandle;
    private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
    private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
    private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
    private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
    private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
    private static final SoapEncSchemaTypeSystem _global = new SoapEncSchemaTypeSystem();

    private SoapEncSchemaTypeSystem() {
        HashMap map = new HashMap();
        this._handlesToObjects = map;
        SchemaContainer schemaContainer = new SchemaContainer("http://schemas.xmlsoap.org/soap/encoding/");
        schemaContainer.setTypeSystem(this);
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(schemaContainer, true);
        this.soapArray = schemaTypeImpl;
        schemaContainer.addGlobalType(schemaTypeImpl.getRef());
        schemaTypeImpl.setName(new QName("http://schemas.xmlsoap.org/soap/encoding/", SOAP_ARRAY));
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.ROOT;
        sb.append(SOAP_ARRAY.toLowerCase(locale));
        sb.append("type");
        String string = sb.toString();
        this.soapArrayHandle = string;
        schemaTypeImpl.setComplexTypeVariety(3);
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        schemaTypeImpl.setBaseDepth(1);
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setSimpleTypeVariety(0);
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(3);
        BigInteger bigInteger = BigInteger.ZERO;
        schemaParticleImpl.setMinOccurs(bigInteger);
        schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
        QNameSet qNameSet = QNameSet.ALL;
        schemaParticleImpl.setTransitionRules(qNameSet, true);
        schemaParticleImpl.setParticleChildren(new SchemaParticleImpl[]{schemaParticleImpl});
        SchemaParticleImpl schemaParticleImpl2 = new SchemaParticleImpl();
        schemaParticleImpl2.setParticleType(5);
        schemaParticleImpl2.setWildcardSet(qNameSet);
        schemaParticleImpl2.setWildcardProcess(2);
        schemaParticleImpl2.setMinOccurs(bigInteger);
        schemaParticleImpl2.setMaxOccurs(null);
        schemaParticleImpl2.setTransitionRules(qNameSet, true);
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        schemaAttributeModelImpl.setWildcardProcess(2);
        HashSet hashSet = new HashSet();
        hashSet.add("http://schemas.xmlsoap.org/soap/encoding/");
        Set set = Collections.EMPTY_SET;
        schemaAttributeModelImpl.setWildcardSet(QNameSet.forSets(hashSet, null, set, set));
        SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl.init(new QName("", ATTR_ID), BuiltinSchemaTypeSystem.ST_ID.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl2 = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl2.init(new QName("", ATTR_HREF), BuiltinSchemaTypeSystem.ST_ANY_URI.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl2);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl3 = new SchemaLocalAttributeImpl();
        QName qName = new QName("http://schemas.xmlsoap.org/soap/encoding/", ARRAY_TYPE);
        SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_STRING;
        schemaLocalAttributeImpl3.init(qName, schemaTypeImpl2.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl3);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl4 = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl4.init(new QName("http://schemas.xmlsoap.org/soap/encoding/", "offset"), schemaTypeImpl2.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl4);
        Map<QName, SchemaProperty> map2 = Collections.EMPTY_MAP;
        schemaTypeImpl.setContentModel(schemaParticleImpl, schemaAttributeModelImpl, map2, map2, false);
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(schemaContainer);
        this.arrayType = schemaGlobalAttributeImpl;
        schemaContainer.addGlobalAttribute(schemaGlobalAttributeImpl.getRef());
        schemaGlobalAttributeImpl.init(new QName("http://schemas.xmlsoap.org/soap/encoding/", ARRAY_TYPE), schemaTypeImpl2.getRef(), 2, null, null, null, false, null, null, null);
        map.put(string, schemaTypeImpl);
        map.put(ARRAY_TYPE.toLowerCase(locale) + "attribute", schemaGlobalAttributeImpl);
        schemaContainer.setImmutable();
    }

    public static SchemaTypeSystem get() {
        return _global;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAnnotation[] annotations() {
        return EMPTY_SCHEMAANNOTATION_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAttributeGroup[] attributeGroups() {
        return EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] attributeTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] documentTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName qName) {
        if ("http://schemas.xmlsoap.org/soap/encoding/".equals(qName.getNamespaceURI()) && ARRAY_TYPE.equals(qName.getLocalPart())) {
            return this.arrayType;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup findAttributeGroup(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = findAttribute(qName);
        if (schemaGlobalAttributeFindAttribute == null) {
            return null;
        }
        return schemaGlobalAttributeFindAttribute.getRef();
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup findModelGroup(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName qName) {
        if ("http://schemas.xmlsoap.org/soap/encoding/".equals(qName.getNamespaceURI()) && SOAP_ARRAY.equals(qName.getLocalPart())) {
            return this.soapArray;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        SchemaType schemaTypeFindType = findType(qName);
        if (schemaTypeFindType == null) {
            return null;
        }
        return schemaTypeFindType.getRef();
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public ClassLoader getClassLoader() {
        return SoapEncSchemaTypeSystem.class.getClassLoader();
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public String getName() {
        return "schema.typesystem.soapenc.builtin";
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalAttribute[] globalAttributes() {
        return new SchemaGlobalAttribute[]{this.arrayType};
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalElement[] globalElements() {
        return EMPTY_SCHEMAELEMENT_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] globalTypes() {
        return new SchemaType[]{this.soapArray};
    }

    public String handleForType(SchemaType schemaType) {
        if (this.soapArray.equals(schemaType)) {
            return this.soapArrayHandle;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        return "http://schemas.xmlsoap.org/soap/encoding/".equals(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaModelGroup[] modelGroups() {
        return EMPTY_SCHEMAMODELGROUP_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String str) {
        return this._handlesToObjects.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void save(Filer filer) {
        throw new UnsupportedOperationException("The builtin soap encoding schema type system cannot be saved.");
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void saveToDirectory(File file) {
        throw new UnsupportedOperationException("The builtin soap encoding schema type system cannot be saved.");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String str) {
        return (SchemaType) this._handlesToObjects.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void resolve() {
    }
}
