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
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTCommentListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTCommentListImpl extends XmlComplexContentImpl implements CTCommentList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "cm")};
    private static final long serialVersionUID = 1;

    public CTCommentListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public CTComment addNewCm() {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public CTComment[] getCmArray() {
        return (CTComment[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTComment[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public List<CTComment> getCmList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: q5.b
                public final /* synthetic */ CTCommentListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCmArray(iIntValue);
                        default:
                            return this.b.insertNewCm(iIntValue);
                    }
                }
            }, new g2(this, 12), new Function(this) { // from class: q5.b
                public final /* synthetic */ CTCommentListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCmArray(iIntValue);
                        default:
                            return this.b.insertNewCm(iIntValue);
                    }
                }
            }, new d2(this, 19), new b2(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public CTComment insertNewCm(int i5) {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public void removeCm(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public void setCmArray(CTComment[] cTCommentArr) {
        check_orphaned();
        arraySetterHelper(cTCommentArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public int sizeOfCmArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public CTComment getCmArray(int i5) {
        CTComment cTComment;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTComment = (CTComment) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTComment == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public void setCmArray(int i5, CTComment cTComment) {
        generatedSetterHelperImpl(cTComment, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
