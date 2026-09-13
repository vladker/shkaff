package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ColorsType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSheetType;
import com.microsoft.schemas.office.visio.x2012.main.EventListType;
import com.microsoft.schemas.office.visio.x2012.main.FaceNamesType;
import com.microsoft.schemas.office.visio.x2012.main.HeaderFooterType;
import com.microsoft.schemas.office.visio.x2012.main.PublishSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType;
import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class VisioDocumentTypeImpl extends XmlComplexContentImpl implements VisioDocumentType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "DocumentSettings"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "Colors"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "FaceNames"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "StyleSheets"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "DocumentSheet"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "EventList"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "HeaderFooter"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "PublishSettings")};
    private static final long serialVersionUID = 1;

    public VisioDocumentTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public ColorsType addNewColors() {
        ColorsType colorsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            colorsTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return colorsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public DocumentSettingsType addNewDocumentSettings() {
        DocumentSettingsType documentSettingsType;
        synchronized (monitor()) {
            check_orphaned();
            documentSettingsType = (DocumentSettingsType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return documentSettingsType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public DocumentSheetType addNewDocumentSheet() {
        DocumentSheetType documentSheetTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            documentSheetTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return documentSheetTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public EventListType addNewEventList() {
        EventListType eventListTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            eventListTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return eventListTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public FaceNamesType addNewFaceNames() {
        FaceNamesType faceNamesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            faceNamesTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return faceNamesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public HeaderFooterType addNewHeaderFooter() {
        HeaderFooterType headerFooterTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            headerFooterTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return headerFooterTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public PublishSettingsType addNewPublishSettings() {
        PublishSettingsType publishSettingsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            publishSettingsTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return publishSettingsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public StyleSheetsType addNewStyleSheets() {
        StyleSheetsType styleSheetsType;
        synchronized (monitor()) {
            check_orphaned();
            styleSheetsType = (StyleSheetsType) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return styleSheetsType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public ColorsType getColors() {
        ColorsType colorsTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            colorsTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (colorsTypeFind_element_user == null) {
                colorsTypeFind_element_user = null;
            }
        }
        return colorsTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public DocumentSettingsType getDocumentSettings() {
        DocumentSettingsType documentSettingsType;
        synchronized (monitor()) {
            check_orphaned();
            documentSettingsType = (DocumentSettingsType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (documentSettingsType == null) {
                documentSettingsType = null;
            }
        }
        return documentSettingsType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public DocumentSheetType getDocumentSheet() {
        DocumentSheetType documentSheetTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            documentSheetTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (documentSheetTypeFind_element_user == null) {
                documentSheetTypeFind_element_user = null;
            }
        }
        return documentSheetTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public EventListType getEventList() {
        EventListType eventListTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            eventListTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (eventListTypeFind_element_user == null) {
                eventListTypeFind_element_user = null;
            }
        }
        return eventListTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public FaceNamesType getFaceNames() {
        FaceNamesType faceNamesTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            faceNamesTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (faceNamesTypeFind_element_user == null) {
                faceNamesTypeFind_element_user = null;
            }
        }
        return faceNamesTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public HeaderFooterType getHeaderFooter() {
        HeaderFooterType headerFooterTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            headerFooterTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (headerFooterTypeFind_element_user == null) {
                headerFooterTypeFind_element_user = null;
            }
        }
        return headerFooterTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public PublishSettingsType getPublishSettings() {
        PublishSettingsType publishSettingsTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            publishSettingsTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (publishSettingsTypeFind_element_user == null) {
                publishSettingsTypeFind_element_user = null;
            }
        }
        return publishSettingsTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public StyleSheetsType getStyleSheets() {
        StyleSheetsType styleSheetsType;
        synchronized (monitor()) {
            check_orphaned();
            styleSheetsType = (StyleSheetsType) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (styleSheetsType == null) {
                styleSheetsType = null;
            }
        }
        return styleSheetsType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetColors() {
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetDocumentSettings() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetDocumentSheet() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetEventList() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetFaceNames() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetHeaderFooter() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetPublishSettings() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetStyleSheets() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setColors(ColorsType colorsType) {
        generatedSetterHelperImpl(colorsType, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setDocumentSettings(DocumentSettingsType documentSettingsType) {
        generatedSetterHelperImpl(documentSettingsType, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setDocumentSheet(DocumentSheetType documentSheetType) {
        generatedSetterHelperImpl(documentSheetType, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setEventList(EventListType eventListType) {
        generatedSetterHelperImpl(eventListType, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setFaceNames(FaceNamesType faceNamesType) {
        generatedSetterHelperImpl(faceNamesType, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setHeaderFooter(HeaderFooterType headerFooterType) {
        generatedSetterHelperImpl(headerFooterType, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setPublishSettings(PublishSettingsType publishSettingsType) {
        generatedSetterHelperImpl(publishSettingsType, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setStyleSheets(StyleSheetsType styleSheetsType) {
        generatedSetterHelperImpl(styleSheetsType, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetDocumentSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetDocumentSheet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetEventList() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetFaceNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetPublishSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetStyleSheets() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }
}
