package org.apache.xmlbeans.impl.xb.xsdschema;

import java.math.BigInteger;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Element extends Annotated {
    public static final AbstractDocumentFactory<Element> Factory;
    public static final SchemaType type;

    static {
        AbstractDocumentFactory<Element> abstractDocumentFactory = new AbstractDocumentFactory<>(TypeSystemHolder.typeSystem, "elementd189type");
        Factory = abstractDocumentFactory;
        type = abstractDocumentFactory.getType();
    }

    LocalComplexType addNewComplexType();

    Keybase addNewKey();

    KeyrefDocument.Keyref addNewKeyref();

    LocalSimpleType addNewSimpleType();

    Keybase addNewUnique();

    boolean getAbstract();

    Object getBlock();

    LocalComplexType getComplexType();

    String getDefault();

    Object getFinal();

    String getFixed();

    FormChoice.Enum getForm();

    Keybase getKeyArray(int i5);

    Keybase[] getKeyArray();

    List<Keybase> getKeyList();

    KeyrefDocument.Keyref getKeyrefArray(int i5);

    KeyrefDocument.Keyref[] getKeyrefArray();

    List<KeyrefDocument.Keyref> getKeyrefList();

    Object getMaxOccurs();

    BigInteger getMinOccurs();

    String getName();

    boolean getNillable();

    QName getRef();

    LocalSimpleType getSimpleType();

    QName getSubstitutionGroup();

    QName getType();

    Keybase getUniqueArray(int i5);

    Keybase[] getUniqueArray();

    List<Keybase> getUniqueList();

    Keybase insertNewKey(int i5);

    KeyrefDocument.Keyref insertNewKeyref(int i5);

    Keybase insertNewUnique(int i5);

    boolean isSetAbstract();

    boolean isSetBlock();

    boolean isSetComplexType();

    boolean isSetDefault();

    boolean isSetFinal();

    boolean isSetFixed();

    boolean isSetForm();

    boolean isSetMaxOccurs();

    boolean isSetMinOccurs();

    boolean isSetName();

    boolean isSetNillable();

    boolean isSetRef();

    boolean isSetSimpleType();

    boolean isSetSubstitutionGroup();

    boolean isSetType();

    void removeKey(int i5);

    void removeKeyref(int i5);

    void removeUnique(int i5);

    void setAbstract(boolean z6);

    void setBlock(Object obj);

    void setComplexType(LocalComplexType localComplexType);

    void setDefault(String str);

    void setFinal(Object obj);

    void setFixed(String str);

    void setForm(FormChoice.Enum r6);

    void setKeyArray(int i5, Keybase keybase);

    void setKeyArray(Keybase[] keybaseArr);

    void setKeyrefArray(int i5, KeyrefDocument.Keyref keyref);

    void setKeyrefArray(KeyrefDocument.Keyref[] keyrefArr);

    void setMaxOccurs(Object obj);

    void setMinOccurs(BigInteger bigInteger);

    void setName(String str);

    void setNillable(boolean z6);

    void setRef(QName qName);

    void setSimpleType(LocalSimpleType localSimpleType);

    void setSubstitutionGroup(QName qName);

    void setType(QName qName);

    void setUniqueArray(int i5, Keybase keybase);

    void setUniqueArray(Keybase[] keybaseArr);

    int sizeOfKeyArray();

    int sizeOfKeyrefArray();

    int sizeOfUniqueArray();

    void unsetAbstract();

    void unsetBlock();

    void unsetComplexType();

    void unsetDefault();

    void unsetFinal();

    void unsetFixed();

    void unsetForm();

    void unsetMaxOccurs();

    void unsetMinOccurs();

    void unsetName();

    void unsetNillable();

    void unsetRef();

    void unsetSimpleType();

    void unsetSubstitutionGroup();

    void unsetType();

    XmlBoolean xgetAbstract();

    BlockSet xgetBlock();

    XmlString xgetDefault();

    DerivationSet xgetFinal();

    XmlString xgetFixed();

    FormChoice xgetForm();

    AllNNI xgetMaxOccurs();

    XmlNonNegativeInteger xgetMinOccurs();

    XmlNCName xgetName();

    XmlBoolean xgetNillable();

    XmlQName xgetRef();

    XmlQName xgetSubstitutionGroup();

    XmlQName xgetType();

    void xsetAbstract(XmlBoolean xmlBoolean);

    void xsetBlock(BlockSet blockSet);

    void xsetDefault(XmlString xmlString);

    void xsetFinal(DerivationSet derivationSet);

    void xsetFixed(XmlString xmlString);

    void xsetForm(FormChoice formChoice);

    void xsetMaxOccurs(AllNNI allNNI);

    void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger);

    void xsetName(XmlNCName xmlNCName);

    void xsetNillable(XmlBoolean xmlBoolean);

    void xsetRef(XmlQName xmlQName);

    void xsetSubstitutionGroup(XmlQName xmlQName);

    void xsetType(XmlQName xmlQName);
}
