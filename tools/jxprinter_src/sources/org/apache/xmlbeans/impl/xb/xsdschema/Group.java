package org.apache.xmlbeans.impl.xb.xsdschema;

import java.math.BigInteger;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Group extends Annotated {
    public static final AbstractDocumentFactory<Group> Factory;
    public static final SchemaType type;

    static {
        AbstractDocumentFactory<Group> abstractDocumentFactory = new AbstractDocumentFactory<>(TypeSystemHolder.typeSystem, "group7ca6type");
        Factory = abstractDocumentFactory;
        type = abstractDocumentFactory.getType();
    }

    All addNewAll();

    AnyDocument.Any addNewAny();

    ExplicitGroup addNewChoice();

    LocalElement addNewElement();

    GroupRef addNewGroup();

    ExplicitGroup addNewSequence();

    All getAllArray(int i5);

    All[] getAllArray();

    List<All> getAllList();

    AnyDocument.Any getAnyArray(int i5);

    AnyDocument.Any[] getAnyArray();

    List<AnyDocument.Any> getAnyList();

    ExplicitGroup getChoiceArray(int i5);

    ExplicitGroup[] getChoiceArray();

    List<ExplicitGroup> getChoiceList();

    LocalElement getElementArray(int i5);

    LocalElement[] getElementArray();

    List<LocalElement> getElementList();

    GroupRef getGroupArray(int i5);

    GroupRef[] getGroupArray();

    List<GroupRef> getGroupList();

    Object getMaxOccurs();

    BigInteger getMinOccurs();

    String getName();

    QName getRef();

    ExplicitGroup getSequenceArray(int i5);

    ExplicitGroup[] getSequenceArray();

    List<ExplicitGroup> getSequenceList();

    All insertNewAll(int i5);

    AnyDocument.Any insertNewAny(int i5);

    ExplicitGroup insertNewChoice(int i5);

    LocalElement insertNewElement(int i5);

    GroupRef insertNewGroup(int i5);

    ExplicitGroup insertNewSequence(int i5);

    boolean isSetMaxOccurs();

    boolean isSetMinOccurs();

    boolean isSetName();

    boolean isSetRef();

    void removeAll(int i5);

    void removeAny(int i5);

    void removeChoice(int i5);

    void removeElement(int i5);

    void removeGroup(int i5);

    void removeSequence(int i5);

    void setAllArray(int i5, All all);

    void setAllArray(All[] allArr);

    void setAnyArray(int i5, AnyDocument.Any any);

    void setAnyArray(AnyDocument.Any[] anyArr);

    void setChoiceArray(int i5, ExplicitGroup explicitGroup);

    void setChoiceArray(ExplicitGroup[] explicitGroupArr);

    void setElementArray(int i5, LocalElement localElement);

    void setElementArray(LocalElement[] localElementArr);

    void setGroupArray(int i5, GroupRef groupRef);

    void setGroupArray(GroupRef[] groupRefArr);

    void setMaxOccurs(Object obj);

    void setMinOccurs(BigInteger bigInteger);

    void setName(String str);

    void setRef(QName qName);

    void setSequenceArray(int i5, ExplicitGroup explicitGroup);

    void setSequenceArray(ExplicitGroup[] explicitGroupArr);

    int sizeOfAllArray();

    int sizeOfAnyArray();

    int sizeOfChoiceArray();

    int sizeOfElementArray();

    int sizeOfGroupArray();

    int sizeOfSequenceArray();

    void unsetMaxOccurs();

    void unsetMinOccurs();

    void unsetName();

    void unsetRef();

    AllNNI xgetMaxOccurs();

    XmlNonNegativeInteger xgetMinOccurs();

    XmlNCName xgetName();

    XmlQName xgetRef();

    void xsetMaxOccurs(AllNNI allNNI);

    void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger);

    void xsetName(XmlNCName xmlNCName);

    void xsetRef(XmlQName xmlQName);
}
