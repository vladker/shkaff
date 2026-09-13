package com.microsoft.schemas.compatibility;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface AlternateContentDocument extends XmlObject {
    public static final DocumentFactory<AlternateContentDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface AlternateContent extends XmlObject {
        public static final ElementFactory<AlternateContent> Factory;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Choice extends XmlObject {
            public static final ElementFactory<Choice> Factory;
            public static final SchemaType type;

            static {
                ElementFactory<Choice> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "choice69c6elemtype");
                Factory = elementFactory;
                type = elementFactory.getType();
            }

            String getIgnorable();

            String getMustUnderstand();

            String getProcessContent();

            String getRequires();

            boolean isSetIgnorable();

            boolean isSetMustUnderstand();

            boolean isSetProcessContent();

            void setIgnorable(String str);

            void setMustUnderstand(String str);

            void setProcessContent(String str);

            void setRequires(String str);

            void unsetIgnorable();

            void unsetMustUnderstand();

            void unsetProcessContent();

            XmlString xgetIgnorable();

            XmlString xgetMustUnderstand();

            XmlString xgetProcessContent();

            XmlString xgetRequires();

            void xsetIgnorable(XmlString xmlString);

            void xsetMustUnderstand(XmlString xmlString);

            void xsetProcessContent(XmlString xmlString);

            void xsetRequires(XmlString xmlString);
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Fallback extends XmlObject {
            public static final ElementFactory<Fallback> Factory;
            public static final SchemaType type;

            static {
                ElementFactory<Fallback> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "fallback4cc7elemtype");
                Factory = elementFactory;
                type = elementFactory.getType();
            }

            String getIgnorable();

            String getMustUnderstand();

            String getProcessContent();

            boolean isSetIgnorable();

            boolean isSetMustUnderstand();

            boolean isSetProcessContent();

            void setIgnorable(String str);

            void setMustUnderstand(String str);

            void setProcessContent(String str);

            void unsetIgnorable();

            void unsetMustUnderstand();

            void unsetProcessContent();

            XmlString xgetIgnorable();

            XmlString xgetMustUnderstand();

            XmlString xgetProcessContent();

            void xsetIgnorable(XmlString xmlString);

            void xsetMustUnderstand(XmlString xmlString);

            void xsetProcessContent(XmlString xmlString);
        }

        static {
            ElementFactory<AlternateContent> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "alternatecontenta8a9elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        Choice addNewChoice();

        Fallback addNewFallback();

        Choice getChoiceArray(int i5);

        Choice[] getChoiceArray();

        List<Choice> getChoiceList();

        Fallback getFallback();

        String getIgnorable();

        String getMustUnderstand();

        String getProcessContent();

        Choice insertNewChoice(int i5);

        boolean isSetFallback();

        boolean isSetIgnorable();

        boolean isSetMustUnderstand();

        boolean isSetProcessContent();

        void removeChoice(int i5);

        void setChoiceArray(int i5, Choice choice);

        void setChoiceArray(Choice[] choiceArr);

        void setFallback(Fallback fallback);

        void setIgnorable(String str);

        void setMustUnderstand(String str);

        void setProcessContent(String str);

        int sizeOfChoiceArray();

        void unsetFallback();

        void unsetIgnorable();

        void unsetMustUnderstand();

        void unsetProcessContent();

        XmlString xgetIgnorable();

        XmlString xgetMustUnderstand();

        XmlString xgetProcessContent();

        void xsetIgnorable(XmlString xmlString);

        void xsetMustUnderstand(XmlString xmlString);

        void xsetProcessContent(XmlString xmlString);
    }

    static {
        DocumentFactory<AlternateContentDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "alternatecontentdd64doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    AlternateContent addNewAlternateContent();

    AlternateContent getAlternateContent();

    void setAlternateContent(AlternateContent alternateContent);
}
