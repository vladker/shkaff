package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFComments extends POIXMLDocumentPart {
    private final CmLstDocument doc;

    public XSLFComments() {
        this.doc = CmLstDocument.Factory.newInstance();
    }

    public CTCommentList getCTCommentsList() {
        return this.doc.getCmLst();
    }

    public CTComment getCommentAt(int i5) {
        return this.doc.getCmLst().getCmArray(i5);
    }

    public int getNumberOfComments() {
        return this.doc.getCmLst().sizeOfCmArray();
    }

    public XSLFComments(PackagePart packagePart) throws IOException {
        super(packagePart);
        InputStream inputStream = getPackagePart().getInputStream();
        try {
            this.doc = CmLstDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
