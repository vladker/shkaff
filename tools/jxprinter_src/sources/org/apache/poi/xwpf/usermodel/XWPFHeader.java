package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFHeader extends XWPFHeaderFooter {
    public XWPFHeader() {
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "hdr"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            super._getHdrFtr().save(outputStream, xmlOptions);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.HEADER;
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFHeaderFooter, org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        super.onDocumentRead();
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                CTHdrFtr hdr = HdrDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getHdr();
                this.headerFooter = hdr;
                XmlCursor xmlCursorNewCursor = hdr.newCursor();
                try {
                    xmlCursorNewCursor.selectPath("./*");
                    while (xmlCursorNewCursor.toNextSelection()) {
                        XmlObject object = xmlCursorNewCursor.getObject();
                        if (object instanceof CTP) {
                            XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, this);
                            this.paragraphs.add(xWPFParagraph);
                            this.bodyElements.add(xWPFParagraph);
                        }
                        if (object instanceof CTTbl) {
                            XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                            this.tables.add(xWPFTable);
                            this.bodyElements.add(xWPFTable);
                        }
                        if (object instanceof CTSdtBlock) {
                            this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
                        }
                    }
                    xmlCursorNewCursor.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (xmlCursorNewCursor != null) {
                            try {
                                xmlCursorNewCursor.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    public XWPFHeader(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        super(pOIXMLDocumentPart, packagePart);
    }

    public XWPFHeader(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) {
        super(xWPFDocument, cTHdrFtr);
        XmlCursor xmlCursorNewCursor = this.headerFooter.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTP) {
                    this.paragraphs.add(new XWPFParagraph((CTP) object, this));
                }
                if (object instanceof CTTbl) {
                    this.tables.add(new XWPFTable((CTTbl) object, this));
                }
            }
            xmlCursorNewCursor.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
