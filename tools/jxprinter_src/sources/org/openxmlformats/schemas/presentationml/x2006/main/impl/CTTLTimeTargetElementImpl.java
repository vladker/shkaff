package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSubShapeId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTLTimeTargetElementImpl extends XmlComplexContentImpl implements CTTLTimeTargetElement {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "sldTgt"), new QName(XSSFRelation.NS_PRESENTATIONML, "sndTgt"), new QName(XSSFRelation.NS_PRESENTATIONML, "spTgt"), new QName(XSSFRelation.NS_PRESENTATIONML, "inkTgt")};
    private static final long serialVersionUID = 1;

    public CTTLTimeTargetElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLSubShapeId addNewInkTgt() {
        CTTLSubShapeId cTTLSubShapeIdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTLSubShapeIdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmpty addNewSldTgt() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmbeddedWAVAudioFile addNewSndTgt() {
        CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedWAVAudioFileAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTEmbeddedWAVAudioFileAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLShapeTargetElement addNewSpTgt() {
        CTTLShapeTargetElement cTTLShapeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLShapeTargetElement = (CTTLShapeTargetElement) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTLShapeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLSubShapeId getInkTgt() {
        CTTLSubShapeId cTTLSubShapeIdFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTLSubShapeIdFind_element_user == null) {
                cTTLSubShapeIdFind_element_user = null;
            }
        }
        return cTTLSubShapeIdFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmpty getSldTgt() {
        CTEmpty cTEmptyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTEmptyFind_element_user == null) {
                cTEmptyFind_element_user = null;
            }
        }
        return cTEmptyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmbeddedWAVAudioFile getSndTgt() {
        CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedWAVAudioFileFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTEmbeddedWAVAudioFileFind_element_user == null) {
                cTEmbeddedWAVAudioFileFind_element_user = null;
            }
        }
        return cTEmbeddedWAVAudioFileFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLShapeTargetElement getSpTgt() {
        CTTLShapeTargetElement cTTLShapeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLShapeTargetElement = (CTTLShapeTargetElement) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTLShapeTargetElement == null) {
                cTTLShapeTargetElement = null;
            }
        }
        return cTTLShapeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetInkTgt() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSldTgt() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSndTgt() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSpTgt() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setInkTgt(CTTLSubShapeId cTTLSubShapeId) {
        generatedSetterHelperImpl(cTTLSubShapeId, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSldTgt(CTEmpty cTEmpty) {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSndTgt(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile) {
        generatedSetterHelperImpl(cTEmbeddedWAVAudioFile, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSpTgt(CTTLShapeTargetElement cTTLShapeTargetElement) {
        generatedSetterHelperImpl(cTTLShapeTargetElement, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetInkTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSldTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSndTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSpTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }
}
