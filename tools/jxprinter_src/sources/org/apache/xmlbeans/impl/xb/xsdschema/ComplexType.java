package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface ComplexType extends Annotated {
    public static final AbstractDocumentFactory<ComplexType> Factory;
    public static final SchemaType type;

    static {
        AbstractDocumentFactory<ComplexType> abstractDocumentFactory = new AbstractDocumentFactory<>(TypeSystemHolder.typeSystem, "complextype5dbbtype");
        Factory = abstractDocumentFactory;
        type = abstractDocumentFactory.getType();
    }

    All addNewAll();

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    ExplicitGroup addNewChoice();

    ComplexContentDocument.ComplexContent addNewComplexContent();

    GroupRef addNewGroup();

    ExplicitGroup addNewSequence();

    SimpleContentDocument.SimpleContent addNewSimpleContent();

    boolean getAbstract();

    All getAll();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i5);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i5);

    AttributeGroupRef[] getAttributeGroupArray();

    List<AttributeGroupRef> getAttributeGroupList();

    List<Attribute> getAttributeList();

    Object getBlock();

    ExplicitGroup getChoice();

    ComplexContentDocument.ComplexContent getComplexContent();

    Object getFinal();

    GroupRef getGroup();

    boolean getMixed();

    String getName();

    ExplicitGroup getSequence();

    SimpleContentDocument.SimpleContent getSimpleContent();

    Attribute insertNewAttribute(int i5);

    AttributeGroupRef insertNewAttributeGroup(int i5);

    boolean isSetAbstract();

    boolean isSetAll();

    boolean isSetAnyAttribute();

    boolean isSetBlock();

    boolean isSetChoice();

    boolean isSetComplexContent();

    boolean isSetFinal();

    boolean isSetGroup();

    boolean isSetMixed();

    boolean isSetName();

    boolean isSetSequence();

    boolean isSetSimpleContent();

    void removeAttribute(int i5);

    void removeAttributeGroup(int i5);

    void setAbstract(boolean z6);

    void setAll(All all);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i5, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i5, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setBlock(Object obj);

    void setChoice(ExplicitGroup explicitGroup);

    void setComplexContent(ComplexContentDocument.ComplexContent complexContent);

    void setFinal(Object obj);

    void setGroup(GroupRef groupRef);

    void setMixed(boolean z6);

    void setName(String str);

    void setSequence(ExplicitGroup explicitGroup);

    void setSimpleContent(SimpleContentDocument.SimpleContent simpleContent);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    void unsetAbstract();

    void unsetAll();

    void unsetAnyAttribute();

    void unsetBlock();

    void unsetChoice();

    void unsetComplexContent();

    void unsetFinal();

    void unsetGroup();

    void unsetMixed();

    void unsetName();

    void unsetSequence();

    void unsetSimpleContent();

    XmlBoolean xgetAbstract();

    DerivationSet xgetBlock();

    DerivationSet xgetFinal();

    XmlBoolean xgetMixed();

    XmlNCName xgetName();

    void xsetAbstract(XmlBoolean xmlBoolean);

    void xsetBlock(DerivationSet derivationSet);

    void xsetFinal(DerivationSet derivationSet);

    void xsetMixed(XmlBoolean xmlBoolean);

    void xsetName(XmlNCName xmlNCName);
}
