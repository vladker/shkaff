package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface ExtensionType extends Annotated {
    public static final DocumentFactory<ExtensionType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<ExtensionType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "extensiontypeed4ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    All addNewAll();

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    ExplicitGroup addNewChoice();

    GroupRef addNewGroup();

    ExplicitGroup addNewSequence();

    All getAll();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i5);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i5);

    AttributeGroupRef[] getAttributeGroupArray();

    List<AttributeGroupRef> getAttributeGroupList();

    List<Attribute> getAttributeList();

    QName getBase();

    ExplicitGroup getChoice();

    GroupRef getGroup();

    ExplicitGroup getSequence();

    Attribute insertNewAttribute(int i5);

    AttributeGroupRef insertNewAttributeGroup(int i5);

    boolean isSetAll();

    boolean isSetAnyAttribute();

    boolean isSetChoice();

    boolean isSetGroup();

    boolean isSetSequence();

    void removeAttribute(int i5);

    void removeAttributeGroup(int i5);

    void setAll(All all);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i5, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i5, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setBase(QName qName);

    void setChoice(ExplicitGroup explicitGroup);

    void setGroup(GroupRef groupRef);

    void setSequence(ExplicitGroup explicitGroup);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    void unsetAll();

    void unsetAnyAttribute();

    void unsetChoice();

    void unsetGroup();

    void unsetSequence();

    XmlQName xgetBase();

    void xsetBase(XmlQName xmlQName);
}
