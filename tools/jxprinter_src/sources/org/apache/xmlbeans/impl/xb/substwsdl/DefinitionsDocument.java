package org.apache.xmlbeans.impl.xb.substwsdl;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface DefinitionsDocument extends XmlObject {
    public static final DocumentFactory<DefinitionsDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Definitions extends XmlObject {
        public static final ElementFactory<Definitions> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Definitions> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "definitions05ddelemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        XmlObject addNewBinding();

        TImport addNewImport();

        XmlObject addNewMessage();

        XmlObject addNewPortType();

        XmlObject addNewService();

        XmlObject addNewTypes();

        XmlObject getBindingArray(int i5);

        XmlObject[] getBindingArray();

        List<XmlObject> getBindingList();

        TImport getImportArray(int i5);

        TImport[] getImportArray();

        List<TImport> getImportList();

        XmlObject getMessageArray(int i5);

        XmlObject[] getMessageArray();

        List<XmlObject> getMessageList();

        XmlObject getPortTypeArray(int i5);

        XmlObject[] getPortTypeArray();

        List<XmlObject> getPortTypeList();

        XmlObject getServiceArray(int i5);

        XmlObject[] getServiceArray();

        List<XmlObject> getServiceList();

        XmlObject getTypesArray(int i5);

        XmlObject[] getTypesArray();

        List<XmlObject> getTypesList();

        XmlObject insertNewBinding(int i5);

        TImport insertNewImport(int i5);

        XmlObject insertNewMessage(int i5);

        XmlObject insertNewPortType(int i5);

        XmlObject insertNewService(int i5);

        XmlObject insertNewTypes(int i5);

        void removeBinding(int i5);

        void removeImport(int i5);

        void removeMessage(int i5);

        void removePortType(int i5);

        void removeService(int i5);

        void removeTypes(int i5);

        void setBindingArray(int i5, XmlObject xmlObject);

        void setBindingArray(XmlObject[] xmlObjectArr);

        void setImportArray(int i5, TImport tImport);

        void setImportArray(TImport[] tImportArr);

        void setMessageArray(int i5, XmlObject xmlObject);

        void setMessageArray(XmlObject[] xmlObjectArr);

        void setPortTypeArray(int i5, XmlObject xmlObject);

        void setPortTypeArray(XmlObject[] xmlObjectArr);

        void setServiceArray(int i5, XmlObject xmlObject);

        void setServiceArray(XmlObject[] xmlObjectArr);

        void setTypesArray(int i5, XmlObject xmlObject);

        void setTypesArray(XmlObject[] xmlObjectArr);

        int sizeOfBindingArray();

        int sizeOfImportArray();

        int sizeOfMessageArray();

        int sizeOfPortTypeArray();

        int sizeOfServiceArray();

        int sizeOfTypesArray();
    }

    static {
        DocumentFactory<DefinitionsDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "definitionsc7f1doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Definitions addNewDefinitions();

    Definitions getDefinitions();

    void setDefinitions(Definitions definitions);
}
