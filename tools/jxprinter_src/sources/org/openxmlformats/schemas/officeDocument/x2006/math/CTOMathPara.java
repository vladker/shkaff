package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTOMathPara extends XmlObject {
    public static final DocumentFactory<CTOMathPara> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTOMathPara> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctomathpara8825type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOMath addNewOMath();

    CTOMathParaPr addNewOMathParaPr();

    CTOMath getOMathArray(int i5);

    CTOMath[] getOMathArray();

    List<CTOMath> getOMathList();

    CTOMathParaPr getOMathParaPr();

    CTOMath insertNewOMath(int i5);

    boolean isSetOMathParaPr();

    void removeOMath(int i5);

    void setOMathArray(int i5, CTOMath cTOMath);

    void setOMathArray(CTOMath[] cTOMathArr);

    void setOMathParaPr(CTOMathParaPr cTOMathParaPr);

    int sizeOfOMathArray();

    void unsetOMathParaPr();
}
