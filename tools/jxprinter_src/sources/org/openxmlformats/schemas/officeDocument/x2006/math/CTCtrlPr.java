package org.openxmlformats.schemas.officeDocument.x2006.math;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMathCtrlDel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMathCtrlIns;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTCtrlPr extends XmlObject {
    public static final DocumentFactory<CTCtrlPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCtrlPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctctrlprea05type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTMathCtrlDel addNewDel();

    CTMathCtrlIns addNewIns();

    CTRPr addNewRPr();

    CTMathCtrlDel getDel();

    CTMathCtrlIns getIns();

    CTRPr getRPr();

    boolean isSetDel();

    boolean isSetIns();

    boolean isSetRPr();

    void setDel(CTMathCtrlDel cTMathCtrlDel);

    void setIns(CTMathCtrlIns cTMathCtrlIns);

    void setRPr(CTRPr cTRPr);

    void unsetDel();

    void unsetIns();

    void unsetRPr();
}
