package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.b2;
import l5.d2;
import l5.g2;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTEmbeddedFontListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTEmbeddedFontListImpl extends XmlComplexContentImpl implements CTEmbeddedFontList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "embeddedFont")};
    private static final long serialVersionUID = 1;

    public CTEmbeddedFontListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public CTEmbeddedFontListEntry addNewEmbeddedFont() {
        CTEmbeddedFontListEntry cTEmbeddedFontListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontListEntry = (CTEmbeddedFontListEntry) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEmbeddedFontListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public CTEmbeddedFontListEntry[] getEmbeddedFontArray() {
        return (CTEmbeddedFontListEntry[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTEmbeddedFontListEntry[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public List<CTEmbeddedFontListEntry> getEmbeddedFontList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: q5.e
                public final /* synthetic */ CTEmbeddedFontListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getEmbeddedFontArray(iIntValue);
                        default:
                            return this.b.insertNewEmbeddedFont(iIntValue);
                    }
                }
            }, new g2(this, 13), new Function(this) { // from class: q5.e
                public final /* synthetic */ CTEmbeddedFontListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getEmbeddedFontArray(iIntValue);
                        default:
                            return this.b.insertNewEmbeddedFont(iIntValue);
                    }
                }
            }, new d2(this, 21), new b2(this, 21));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public CTEmbeddedFontListEntry insertNewEmbeddedFont(int i5) {
        CTEmbeddedFontListEntry cTEmbeddedFontListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedFontListEntry = (CTEmbeddedFontListEntry) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTEmbeddedFontListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public void removeEmbeddedFont(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public void setEmbeddedFontArray(CTEmbeddedFontListEntry[] cTEmbeddedFontListEntryArr) {
        check_orphaned();
        arraySetterHelper(cTEmbeddedFontListEntryArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public int sizeOfEmbeddedFontArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public CTEmbeddedFontListEntry getEmbeddedFontArray(int i5) {
        CTEmbeddedFontListEntry cTEmbeddedFontListEntry;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEmbeddedFontListEntry = (CTEmbeddedFontListEntry) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTEmbeddedFontListEntry == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEmbeddedFontListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontList
    public void setEmbeddedFontArray(int i5, CTEmbeddedFontListEntry cTEmbeddedFontListEntry) {
        generatedSetterHelperImpl(cTEmbeddedFontListEntry, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
