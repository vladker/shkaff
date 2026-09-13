package org.apache.xmlbeans.impl.inst2xsd.util;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TypeSystemHolder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Map<QName, Element> _globalElements = new LinkedHashMap();
    Map<QName, Attribute> _globalAttributes = new LinkedHashMap();
    Map<QName, Type> _globalTypes = new LinkedHashMap();

    private void fillUpAttributesInComplexTypesComplexContent(Type type, ComplexType complexType, String str) {
        for (int i5 = 0; i5 < type.getAttributes().size(); i5++) {
            fillUpLocalAttribute(type.getAttributes().get(i5), complexType.addNewAttribute(), str);
        }
    }

    private void fillUpAttributesInComplexTypesSimpleContent(Type type, SimpleExtensionType simpleExtensionType, String str) {
        for (int i5 = 0; i5 < type.getAttributes().size(); i5++) {
            fillUpLocalAttribute(type.getAttributes().get(i5), simpleExtensionType.addNewAttribute(), str);
        }
    }

    private static void fillUpElementDocumentation(org.apache.xmlbeans.impl.xb.xsdschema.Element element, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        element.addNewAnnotation().addNewDocumentation().set(XmlString.Factory.newValue(str));
    }

    private void fillUpEnumeration(Type type, org.apache.xmlbeans.impl.xb.xsdschema.Element element) {
        RestrictionDocument.Restriction restrictionAddNewRestriction = element.addNewSimpleType().addNewRestriction();
        restrictionAddNewRestriction.setBase(type.getName());
        int i5 = 0;
        if (!type.isQNameEnumeration()) {
            while (i5 < type.getEnumerationValues().size()) {
                restrictionAddNewRestriction.addNewEnumeration().setValue(XmlString.Factory.newValue(type.getEnumerationValues().get(i5)));
                i5++;
            }
            return;
        }
        while (i5 < type.getEnumerationQNames().size()) {
            QName qName = type.getEnumerationQNames().get(i5);
            XmlObjectFactory<XmlQName> xmlObjectFactory = XmlQName.Factory;
            xmlObjectFactory.newValue(qName);
            NoFixedFacet noFixedFacetAddNewEnumeration = restrictionAddNewRestriction.addNewEnumeration();
            XmlCursor xmlCursorNewCursor = noFixedFacetAddNewEnumeration.newCursor();
            try {
                String strPrefixForNamespace = xmlCursorNewCursor.prefixForNamespace(qName.getNamespaceURI());
                xmlCursorNewCursor.close();
                noFixedFacetAddNewEnumeration.setValue(xmlObjectFactory.newValue(new QName(qName.getNamespaceURI(), qName.getLocalPart(), strPrefixForNamespace)));
                i5++;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    private void fillUpGlobalAttribute(Attribute attribute, SchemaDocument schemaDocument, String str) {
        TopLevelAttribute topLevelAttributeAddNewAttribute = getTopLevelSchemaElement(schemaDocument, str).addNewAttribute();
        topLevelAttributeAddNewAttribute.setName(attribute.getName().getLocalPart());
        Type type = attribute.getType();
        if (type.getContentType() != 1) {
            throw new IllegalStateException();
        }
        topLevelAttributeAddNewAttribute.setType(type.getName());
    }

    private void fillUpGlobalElement(Element element, SchemaDocument schemaDocument, String str) {
        TopLevelElement topLevelElementAddNewElement = getTopLevelSchemaElement(schemaDocument, str).addNewElement();
        topLevelElementAddNewElement.setName(element.getName().getLocalPart());
        if (element.isNillable()) {
            topLevelElementAddNewElement.setNillable(element.isNillable());
        }
        fillUpElementDocumentation(topLevelElementAddNewElement, element.getComment());
        fillUpTypeOnElement(element.getType(), topLevelElementAddNewElement, str);
    }

    private void fillUpGlobalType(Type type, SchemaDocument schemaDocument, String str) {
        TopLevelComplexType topLevelComplexTypeAddNewComplexType = getTopLevelSchemaElement(schemaDocument, str).addNewComplexType();
        topLevelComplexTypeAddNewComplexType.setName(type.getName().getLocalPart());
        fillUpContentForComplexType(type, topLevelComplexTypeAddNewComplexType, str);
    }

    private void fillUpTypeOnElement(Type type, org.apache.xmlbeans.impl.xb.xsdschema.Element element, String str) {
        if (type.isGlobal()) {
            element.setType(type.getName());
            return;
        }
        if (type.getContentType() != 1) {
            fillUpContentForComplexType(type, element.addNewComplexType(), str);
        } else if (type.isEnumeration()) {
            fillUpEnumeration(type, element);
        } else {
            element.setType(type.getName());
        }
    }

    private static SchemaDocument getSchemaDocumentForTNS(Map<String, SchemaDocument> map, String str) {
        SchemaDocument schemaDocument = map.get(str);
        if (schemaDocument != null) {
            return schemaDocument;
        }
        SchemaDocument schemaDocumentNewInstance = SchemaDocument.Factory.newInstance();
        map.put(str, schemaDocumentNewInstance);
        return schemaDocumentNewInstance;
    }

    private static SchemaDocument.Schema getTopLevelSchemaElement(SchemaDocument schemaDocument, String str) {
        SchemaDocument.Schema schema = schemaDocument.getSchema();
        if (schema != null) {
            return schema;
        }
        SchemaDocument.Schema schemaAddNewSchema = schemaDocument.addNewSchema();
        schemaAddNewSchema.setAttributeFormDefault(FormChoice.Enum.forString("unqualified"));
        schemaAddNewSchema.setElementFormDefault(FormChoice.Enum.forString("qualified"));
        if (!str.equals("")) {
            schemaAddNewSchema.setTargetNamespace(str);
        }
        return schemaAddNewSchema;
    }

    public void addGlobalAttribute(Attribute attribute) {
        this._globalAttributes.put(attribute.getName(), attribute);
    }

    public void addGlobalElement(Element element) {
        this._globalElements.put(element.getName(), element);
    }

    public void addGlobalType(Type type) {
        this._globalTypes.put(type.getName(), type);
    }

    public void fillUpContentForComplexType(Type type, ComplexType complexType, String str) {
        ExplicitGroup explicitGroupAddNewChoice;
        if (type.getContentType() == 2) {
            SimpleExtensionType simpleExtensionTypeAddNewExtension = complexType.addNewSimpleContent().addNewExtension();
            simpleExtensionTypeAddNewExtension.setBase(type.getExtensionType().getName());
            fillUpAttributesInComplexTypesSimpleContent(type, simpleExtensionTypeAddNewExtension, str);
            return;
        }
        if (type.getContentType() == 4) {
            complexType.setMixed(true);
        }
        if (type.getContentType() == 5) {
            explicitGroupAddNewChoice = null;
        } else if (type.getTopParticleForComplexOrMixedContent() == 1) {
            explicitGroupAddNewChoice = complexType.addNewSequence();
        } else {
            if (type.getTopParticleForComplexOrMixedContent() != 2) {
                throw new IllegalStateException("Unknown particle type in complex and mixed content");
            }
            explicitGroupAddNewChoice = complexType.addNewChoice();
            explicitGroupAddNewChoice.setMaxOccurs("unbounded");
            explicitGroupAddNewChoice.setMinOccurs(new BigInteger("0"));
        }
        for (int i5 = 0; i5 < type.getElements().size(); i5++) {
            fillUpLocalElement(type.getElements().get(i5), explicitGroupAddNewChoice.addNewElement(), str);
        }
        fillUpAttributesInComplexTypesComplexContent(type, complexType, str);
    }

    public void fillUpLocalAttribute(Attribute attribute, org.apache.xmlbeans.impl.xb.xsdschema.Attribute attribute2, String str) {
        if (attribute.isRef()) {
            attribute2.setRef(attribute.getRef().getName());
            return;
        }
        attribute2.setType(attribute.getType().getName());
        attribute2.setName(attribute.getName().getLocalPart());
        if (attribute.isOptional()) {
            attribute2.setUse(org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use.OPTIONAL);
        }
    }

    public void fillUpLocalElement(Element element, LocalElement localElement, String str) {
        fillUpElementDocumentation(localElement, element.getComment());
        if (element.isRef()) {
            localElement.setRef(element.getName());
        } else {
            fillUpTypeOnElement(element.getType(), localElement, str);
            localElement.setName(element.getName().getLocalPart());
        }
        if (element.getMaxOccurs() == -1) {
            localElement.setMaxOccurs("unbounded");
        }
        if (element.getMinOccurs() != 1) {
            localElement.setMinOccurs(new BigInteger("" + element.getMinOccurs()));
        }
        if (element.isNillable()) {
            localElement.setNillable(element.isNillable());
        }
    }

    public Attribute getGlobalAttribute(QName qName) {
        return this._globalAttributes.get(qName);
    }

    public Attribute[] getGlobalAttributes() {
        Collection<Attribute> collectionValues = this._globalAttributes.values();
        return (Attribute[]) collectionValues.toArray(new Attribute[collectionValues.size()]);
    }

    public Element getGlobalElement(QName qName) {
        return this._globalElements.get(qName);
    }

    public Element[] getGlobalElements() {
        Collection<Element> collectionValues = this._globalElements.values();
        return (Element[]) collectionValues.toArray(new Element[collectionValues.size()]);
    }

    public Type getGlobalType(QName qName) {
        return this._globalTypes.get(qName);
    }

    public Type[] getGlobalTypes() {
        Collection<Type> collectionValues = this._globalTypes.values();
        return (Type[]) collectionValues.toArray(new Type[collectionValues.size()]);
    }

    public SchemaDocument[] getSchemaDocuments() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (QName qName : this._globalElements.keySet()) {
            String namespaceURI = qName.getNamespaceURI();
            fillUpGlobalElement(this._globalElements.get(qName), getSchemaDocumentForTNS(linkedHashMap, namespaceURI), namespaceURI);
        }
        for (QName qName2 : this._globalAttributes.keySet()) {
            String namespaceURI2 = qName2.getNamespaceURI();
            fillUpGlobalAttribute(this._globalAttributes.get(qName2), getSchemaDocumentForTNS(linkedHashMap, namespaceURI2), namespaceURI2);
        }
        for (QName qName3 : this._globalTypes.keySet()) {
            String namespaceURI3 = qName3.getNamespaceURI();
            fillUpGlobalType(this._globalTypes.get(qName3), getSchemaDocumentForTNS(linkedHashMap, namespaceURI3), namespaceURI3);
        }
        Collection collectionValues = linkedHashMap.values();
        return (SchemaDocument[]) collectionValues.toArray(new SchemaDocument[collectionValues.size()]);
    }

    public String toString() {
        return "TypeSystemHolder{\n\n_globalElements=" + this._globalElements + "\n\n_globalAttributes=" + this._globalAttributes + "\n\n_globalTypes=" + this._globalTypes + "\n}";
    }
}
