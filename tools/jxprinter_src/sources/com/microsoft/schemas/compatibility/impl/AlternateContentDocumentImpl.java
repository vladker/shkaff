package com.microsoft.schemas.compatibility.impl;

import com.microsoft.schemas.compatibility.AlternateContentDocument;
import com.microsoft.schemas.compatibility.impl.AlternateContentDocumentImpl;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.b2;
import l5.d2;
import l5.g2;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class AlternateContentDocumentImpl extends XmlComplexContentImpl implements AlternateContentDocument {
    private static final QName[] PROPERTY_QNAME = {new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "AlternateContent")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AlternateContentImpl extends XmlComplexContentImpl implements AlternateContentDocument.AlternateContent {
        private static final QName[] PROPERTY_QNAME = {new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "Choice"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "Fallback"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "Ignorable"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "MustUnderstand"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "ProcessContent")};
        private static final long serialVersionUID = 1;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class ChoiceImpl extends XmlComplexContentImpl implements AlternateContentDocument.AlternateContent.Choice {
            private static final QName[] PROPERTY_QNAME = {new QName("", "Requires"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "Ignorable"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "MustUnderstand"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "ProcessContent")};
            private static final long serialVersionUID = 1;

            public ChoiceImpl(SchemaType schemaType) {
                super(schemaType);
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public String getIgnorable() {
                String stringValue;
                synchronized (monitor()) {
                    check_orphaned();
                    SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
                    stringValue = simpleValue == null ? null : simpleValue.getStringValue();
                }
                return stringValue;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public String getMustUnderstand() {
                String stringValue;
                synchronized (monitor()) {
                    check_orphaned();
                    SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
                    stringValue = simpleValue == null ? null : simpleValue.getStringValue();
                }
                return stringValue;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public String getProcessContent() {
                String stringValue;
                synchronized (monitor()) {
                    check_orphaned();
                    SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
                    stringValue = simpleValue == null ? null : simpleValue.getStringValue();
                }
                return stringValue;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public String getRequires() {
                String stringValue;
                synchronized (monitor()) {
                    check_orphaned();
                    SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
                    stringValue = simpleValue == null ? null : simpleValue.getStringValue();
                }
                return stringValue;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public boolean isSetIgnorable() {
                boolean z6;
                synchronized (monitor()) {
                    check_orphaned();
                    z6 = true;
                    if (get_store().find_attribute_user(PROPERTY_QNAME[1]) == null) {
                        z6 = false;
                    }
                }
                return z6;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public boolean isSetMustUnderstand() {
                boolean z6;
                synchronized (monitor()) {
                    check_orphaned();
                    z6 = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
                }
                return z6;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public boolean isSetProcessContent() {
                boolean z6;
                synchronized (monitor()) {
                    check_orphaned();
                    z6 = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
                }
                return z6;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void setIgnorable(String str) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                        if (simpleValue == null) {
                            simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                        }
                        simpleValue.setStringValue(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void setMustUnderstand(String str) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                        if (simpleValue == null) {
                            simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                        }
                        simpleValue.setStringValue(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void setProcessContent(String str) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                        if (simpleValue == null) {
                            simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                        }
                        simpleValue.setStringValue(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void setRequires(String str) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                        if (simpleValue == null) {
                            simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                        }
                        simpleValue.setStringValue(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void unsetIgnorable() {
                synchronized (monitor()) {
                    check_orphaned();
                    get_store().remove_attribute(PROPERTY_QNAME[1]);
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void unsetMustUnderstand() {
                synchronized (monitor()) {
                    check_orphaned();
                    get_store().remove_attribute(PROPERTY_QNAME[2]);
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void unsetProcessContent() {
                synchronized (monitor()) {
                    check_orphaned();
                    get_store().remove_attribute(PROPERTY_QNAME[3]);
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public XmlString xgetIgnorable() {
                XmlString xmlString;
                synchronized (monitor()) {
                    check_orphaned();
                    xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[1]);
                }
                return xmlString;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public XmlString xgetMustUnderstand() {
                XmlString xmlString;
                synchronized (monitor()) {
                    check_orphaned();
                    xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[2]);
                }
                return xmlString;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public XmlString xgetProcessContent() {
                XmlString xmlString;
                synchronized (monitor()) {
                    check_orphaned();
                    xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[3]);
                }
                return xmlString;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public XmlString xgetRequires() {
                XmlString xmlString;
                synchronized (monitor()) {
                    check_orphaned();
                    xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[0]);
                }
                return xmlString;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void xsetIgnorable(XmlString xmlString) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[1]);
                        if (xmlString2 == null) {
                            xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[1]);
                        }
                        xmlString2.set(xmlString);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void xsetMustUnderstand(XmlString xmlString) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[2]);
                        if (xmlString2 == null) {
                            xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[2]);
                        }
                        xmlString2.set(xmlString);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void xsetProcessContent(XmlString xmlString) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[3]);
                        if (xmlString2 == null) {
                            xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[3]);
                        }
                        xmlString2.set(xmlString);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice
            public void xsetRequires(XmlString xmlString) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[0]);
                        if (xmlString2 == null) {
                            xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[0]);
                        }
                        xmlString2.set(xmlString);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class FallbackImpl extends XmlComplexContentImpl implements AlternateContentDocument.AlternateContent.Fallback {
            private static final QName[] PROPERTY_QNAME = {new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "Ignorable"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "MustUnderstand"), new QName(PackageNamespaces.MARKUP_COMPATIBILITY, "ProcessContent")};
            private static final long serialVersionUID = 1;

            public FallbackImpl(SchemaType schemaType) {
                super(schemaType);
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public String getIgnorable() {
                String stringValue;
                synchronized (monitor()) {
                    check_orphaned();
                    SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
                    stringValue = simpleValue == null ? null : simpleValue.getStringValue();
                }
                return stringValue;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public String getMustUnderstand() {
                String stringValue;
                synchronized (monitor()) {
                    check_orphaned();
                    SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
                    stringValue = simpleValue == null ? null : simpleValue.getStringValue();
                }
                return stringValue;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public String getProcessContent() {
                String stringValue;
                synchronized (monitor()) {
                    check_orphaned();
                    SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
                    stringValue = simpleValue == null ? null : simpleValue.getStringValue();
                }
                return stringValue;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public boolean isSetIgnorable() {
                boolean z6;
                synchronized (monitor()) {
                    check_orphaned();
                    z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
                }
                return z6;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public boolean isSetMustUnderstand() {
                boolean z6;
                synchronized (monitor()) {
                    check_orphaned();
                    z6 = true;
                    if (get_store().find_attribute_user(PROPERTY_QNAME[1]) == null) {
                        z6 = false;
                    }
                }
                return z6;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public boolean isSetProcessContent() {
                boolean z6;
                synchronized (monitor()) {
                    check_orphaned();
                    z6 = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
                }
                return z6;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void setIgnorable(String str) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                        if (simpleValue == null) {
                            simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                        }
                        simpleValue.setStringValue(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void setMustUnderstand(String str) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                        if (simpleValue == null) {
                            simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                        }
                        simpleValue.setStringValue(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void setProcessContent(String str) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                        if (simpleValue == null) {
                            simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                        }
                        simpleValue.setStringValue(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void unsetIgnorable() {
                synchronized (monitor()) {
                    check_orphaned();
                    get_store().remove_attribute(PROPERTY_QNAME[0]);
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void unsetMustUnderstand() {
                synchronized (monitor()) {
                    check_orphaned();
                    get_store().remove_attribute(PROPERTY_QNAME[1]);
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void unsetProcessContent() {
                synchronized (monitor()) {
                    check_orphaned();
                    get_store().remove_attribute(PROPERTY_QNAME[2]);
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public XmlString xgetIgnorable() {
                XmlString xmlString;
                synchronized (monitor()) {
                    check_orphaned();
                    xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[0]);
                }
                return xmlString;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public XmlString xgetMustUnderstand() {
                XmlString xmlString;
                synchronized (monitor()) {
                    check_orphaned();
                    xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[1]);
                }
                return xmlString;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public XmlString xgetProcessContent() {
                XmlString xmlString;
                synchronized (monitor()) {
                    check_orphaned();
                    xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[2]);
                }
                return xmlString;
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void xsetIgnorable(XmlString xmlString) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[0]);
                        if (xmlString2 == null) {
                            xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[0]);
                        }
                        xmlString2.set(xmlString);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void xsetMustUnderstand(XmlString xmlString) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[1]);
                        if (xmlString2 == null) {
                            xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[1]);
                        }
                        xmlString2.set(xmlString);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback
            public void xsetProcessContent(XmlString xmlString) {
                synchronized (monitor()) {
                    try {
                        check_orphaned();
                        TypeStore typeStore = get_store();
                        QName[] qNameArr = PROPERTY_QNAME;
                        XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[2]);
                        if (xmlString2 == null) {
                            xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[2]);
                        }
                        xmlString2.set(xmlString);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public AlternateContentImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public AlternateContentDocument.AlternateContent.Choice addNewChoice() {
            AlternateContentDocument.AlternateContent.Choice choice;
            synchronized (monitor()) {
                check_orphaned();
                choice = (AlternateContentDocument.AlternateContent.Choice) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return choice;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public AlternateContentDocument.AlternateContent.Fallback addNewFallback() {
            AlternateContentDocument.AlternateContent.Fallback fallback;
            synchronized (monitor()) {
                check_orphaned();
                fallback = (AlternateContentDocument.AlternateContent.Fallback) get_store().add_element_user(PROPERTY_QNAME[1]);
            }
            return fallback;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public AlternateContentDocument.AlternateContent.Choice[] getChoiceArray() {
            return (AlternateContentDocument.AlternateContent.Choice[]) getXmlObjectArray(PROPERTY_QNAME[0], new AlternateContentDocument.AlternateContent.Choice[0]);
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public List<AlternateContentDocument.AlternateContent.Choice> getChoiceList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                final int i5 = 0;
                final int i6 = 1;
                javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: p2.a
                    public final /* synthetic */ AlternateContentDocumentImpl.AlternateContentImpl b;

                    {
                        this.b = this;
                    }

                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i7 = i5;
                        int iIntValue = ((Integer) obj).intValue();
                        switch (i7) {
                            case 0:
                                return this.b.getChoiceArray(iIntValue);
                            default:
                                return this.b.insertNewChoice(iIntValue);
                        }
                    }
                }, new g2(this, 5), new Function(this) { // from class: p2.a
                    public final /* synthetic */ AlternateContentDocumentImpl.AlternateContentImpl b;

                    {
                        this.b = this;
                    }

                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i7 = i6;
                        int iIntValue = ((Integer) obj).intValue();
                        switch (i7) {
                            case 0:
                                return this.b.getChoiceArray(iIntValue);
                            default:
                                return this.b.insertNewChoice(iIntValue);
                        }
                    }
                }, new d2(this, 12), new b2(this, 12));
            }
            return javaListXmlObject;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public AlternateContentDocument.AlternateContent.Fallback getFallback() {
            AlternateContentDocument.AlternateContent.Fallback fallback;
            synchronized (monitor()) {
                check_orphaned();
                fallback = (AlternateContentDocument.AlternateContent.Fallback) get_store().find_element_user(PROPERTY_QNAME[1], 0);
                if (fallback == null) {
                    fallback = null;
                }
            }
            return fallback;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public String getIgnorable() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public String getMustUnderstand() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public String getProcessContent() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public AlternateContentDocument.AlternateContent.Choice insertNewChoice(int i5) {
            AlternateContentDocument.AlternateContent.Choice choice;
            synchronized (monitor()) {
                check_orphaned();
                choice = (AlternateContentDocument.AlternateContent.Choice) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
            }
            return choice;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public boolean isSetFallback() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = true;
                if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                    z6 = false;
                }
            }
            return z6;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public boolean isSetIgnorable() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
            }
            return z6;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public boolean isSetMustUnderstand() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
            }
            return z6;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public boolean isSetProcessContent() {
            boolean z6;
            synchronized (monitor()) {
                check_orphaned();
                z6 = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
            }
            return z6;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void removeChoice(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i5);
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void setChoiceArray(AlternateContentDocument.AlternateContent.Choice[] choiceArr) {
            check_orphaned();
            arraySetterHelper(choiceArr, PROPERTY_QNAME[0]);
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void setFallback(AlternateContentDocument.AlternateContent.Fallback fallback) {
            generatedSetterHelperImpl(fallback, PROPERTY_QNAME[1], 0, (short) 1);
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void setIgnorable(String str) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                    if (simpleValue == null) {
                        simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                    }
                    simpleValue.setStringValue(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void setMustUnderstand(String str) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                    if (simpleValue == null) {
                        simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                    }
                    simpleValue.setStringValue(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void setProcessContent(String str) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                    if (simpleValue == null) {
                        simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
                    }
                    simpleValue.setStringValue(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public int sizeOfChoiceArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void unsetFallback() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[1], 0);
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void unsetIgnorable() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[2]);
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void unsetMustUnderstand() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[3]);
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void unsetProcessContent() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[4]);
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public XmlString xgetIgnorable() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            }
            return xmlString;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public XmlString xgetMustUnderstand() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            }
            return xmlString;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public XmlString xgetProcessContent() {
            XmlString xmlString;
            synchronized (monitor()) {
                check_orphaned();
                xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            }
            return xmlString;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void xsetIgnorable(XmlString xmlString) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[2]);
                    if (xmlString2 == null) {
                        xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[2]);
                    }
                    xmlString2.set(xmlString);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void xsetMustUnderstand(XmlString xmlString) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[3]);
                    if (xmlString2 == null) {
                        xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[3]);
                    }
                    xmlString2.set(xmlString);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void xsetProcessContent(XmlString xmlString) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName[] qNameArr = PROPERTY_QNAME;
                    XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[4]);
                    if (xmlString2 == null) {
                        xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[4]);
                    }
                    xmlString2.set(xmlString);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public AlternateContentDocument.AlternateContent.Choice getChoiceArray(int i5) {
            AlternateContentDocument.AlternateContent.Choice choice;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    choice = (AlternateContentDocument.AlternateContent.Choice) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                    if (choice == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return choice;
        }

        @Override // com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent
        public void setChoiceArray(int i5, AlternateContentDocument.AlternateContent.Choice choice) {
            generatedSetterHelperImpl(choice, PROPERTY_QNAME[0], i5, (short) 2);
        }
    }

    public AlternateContentDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.compatibility.AlternateContentDocument
    public AlternateContentDocument.AlternateContent addNewAlternateContent() {
        AlternateContentDocument.AlternateContent alternateContent;
        synchronized (monitor()) {
            check_orphaned();
            alternateContent = (AlternateContentDocument.AlternateContent) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return alternateContent;
    }

    @Override // com.microsoft.schemas.compatibility.AlternateContentDocument
    public AlternateContentDocument.AlternateContent getAlternateContent() {
        AlternateContentDocument.AlternateContent alternateContent;
        synchronized (monitor()) {
            check_orphaned();
            alternateContent = (AlternateContentDocument.AlternateContent) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (alternateContent == null) {
                alternateContent = null;
            }
        }
        return alternateContent;
    }

    @Override // com.microsoft.schemas.compatibility.AlternateContentDocument
    public void setAlternateContent(AlternateContentDocument.AlternateContent alternateContent) {
        generatedSetterHelperImpl(alternateContent, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
