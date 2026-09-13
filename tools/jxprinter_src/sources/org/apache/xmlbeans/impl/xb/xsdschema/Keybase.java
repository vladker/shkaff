package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Keybase extends Annotated {
    public static final DocumentFactory<Keybase> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<Keybase> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "keybase3955type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    FieldDocument.Field addNewField();

    SelectorDocument.Selector addNewSelector();

    FieldDocument.Field getFieldArray(int i5);

    FieldDocument.Field[] getFieldArray();

    List<FieldDocument.Field> getFieldList();

    String getName();

    SelectorDocument.Selector getSelector();

    FieldDocument.Field insertNewField(int i5);

    void removeField(int i5);

    void setFieldArray(int i5, FieldDocument.Field field);

    void setFieldArray(FieldDocument.Field[] fieldArr);

    void setName(String str);

    void setSelector(SelectorDocument.Selector selector);

    int sizeOfFieldArray();

    XmlNCName xgetName();

    void xsetName(XmlNCName xmlNCName);
}
