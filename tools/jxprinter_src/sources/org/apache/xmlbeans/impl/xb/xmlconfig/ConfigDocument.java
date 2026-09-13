package org.apache.xmlbeans.impl.xb.xmlconfig;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface ConfigDocument extends XmlObject {
    public static final DocumentFactory<ConfigDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Config extends XmlObject {
        public static final ElementFactory<Config> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Config> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "configf467elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        Extensionconfig addNewExtension();

        Nsconfig addNewNamespace();

        Qnameconfig addNewQname();

        Usertypeconfig addNewUsertype();

        Extensionconfig getExtensionArray(int i5);

        Extensionconfig[] getExtensionArray();

        List<Extensionconfig> getExtensionList();

        Nsconfig getNamespaceArray(int i5);

        Nsconfig[] getNamespaceArray();

        List<Nsconfig> getNamespaceList();

        Qnameconfig getQnameArray(int i5);

        Qnameconfig[] getQnameArray();

        List<Qnameconfig> getQnameList();

        Usertypeconfig getUsertypeArray(int i5);

        Usertypeconfig[] getUsertypeArray();

        List<Usertypeconfig> getUsertypeList();

        Extensionconfig insertNewExtension(int i5);

        Nsconfig insertNewNamespace(int i5);

        Qnameconfig insertNewQname(int i5);

        Usertypeconfig insertNewUsertype(int i5);

        void removeExtension(int i5);

        void removeNamespace(int i5);

        void removeQname(int i5);

        void removeUsertype(int i5);

        void setExtensionArray(int i5, Extensionconfig extensionconfig);

        void setExtensionArray(Extensionconfig[] extensionconfigArr);

        void setNamespaceArray(int i5, Nsconfig nsconfig);

        void setNamespaceArray(Nsconfig[] nsconfigArr);

        void setQnameArray(int i5, Qnameconfig qnameconfig);

        void setQnameArray(Qnameconfig[] qnameconfigArr);

        void setUsertypeArray(int i5, Usertypeconfig usertypeconfig);

        void setUsertypeArray(Usertypeconfig[] usertypeconfigArr);

        int sizeOfExtensionArray();

        int sizeOfNamespaceArray();

        int sizeOfQnameArray();

        int sizeOfUsertypeArray();
    }

    static {
        DocumentFactory<ConfigDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "config4185doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Config addNewConfig();

    Config getConfig();

    void setConfig(Config config);
}
