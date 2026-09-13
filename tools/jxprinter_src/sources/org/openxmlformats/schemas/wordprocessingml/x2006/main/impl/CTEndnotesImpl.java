package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTEndnotesImpl;
import p105s2.i;
import p105s2.j;
import r5.B0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTEndnotesImpl extends XmlComplexContentImpl implements CTEndnotes {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "endnote")};
    private static final long serialVersionUID = 1;

    public CTEndnotesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn addNewEndnote() {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdn = (CTFtnEdn) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn[] getEndnoteArray() {
        return (CTFtnEdn[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTFtnEdn[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public List<CTFtnEdn> getEndnoteList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: s5.X
                public final /* synthetic */ CTEndnotesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getEndnoteArray(iIntValue);
                        default:
                            return this.b.insertNewEndnote(iIntValue);
                    }
                }
            }, new B0(this, 22), new Function(this) { // from class: s5.X
                public final /* synthetic */ CTEndnotesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getEndnoteArray(iIntValue);
                        default:
                            return this.b.insertNewEndnote(iIntValue);
                    }
                }
            }, new i(this, 7), new j(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn insertNewEndnote(int i5) {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdn = (CTFtnEdn) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void removeEndnote(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void setEndnoteArray(CTFtnEdn[] cTFtnEdnArr) {
        check_orphaned();
        arraySetterHelper(cTFtnEdnArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public int sizeOfEndnoteArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn getEndnoteArray(int i5) {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFtnEdn = (CTFtnEdn) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTFtnEdn == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void setEndnoteArray(int i5, CTFtnEdn cTFtnEdn) {
        generatedSetterHelperImpl(cTFtnEdn, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
