package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFtnEdn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFFootnotes extends XWPFAbstractFootnotesEndnotes {
    protected CTFootnotes ctFootnotes;

    public XWPFFootnotes(PackagePart packagePart) {
        super(packagePart);
    }

    public void addFootnote(XWPFFootnote xWPFFootnote) {
        this.listFootnote.add(xWPFFootnote);
        this.ctFootnotes.addNewFootnote().set(xWPFFootnote.getCTFtnEdn());
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTFootnotes.type.getName().getNamespaceURI(), "footnotes"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.ctFootnotes.save(outputStream, xmlOptions);
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

    public XWPFFootnote createFootnote() {
        CTFtnEdn cTFtnEdnNewInstance = CTFtnEdn.Factory.newInstance();
        cTFtnEdnNewInstance.setType(STFtnEdn.NORMAL);
        XWPFFootnote xWPFFootnoteAddFootnote = addFootnote(cTFtnEdnNewInstance);
        xWPFFootnoteAddFootnote.getCTFtnEdn().setId(getIdManager().nextId());
        return xWPFFootnoteAddFootnote;
    }

    public List<XWPFFootnote> getFootnotesList() {
        ArrayList arrayList = new ArrayList();
        Iterator<XWPFAbstractFootnoteEndnote> it = this.listFootnote.iterator();
        while (it.hasNext()) {
            arrayList.add((XWPFFootnote) it.next());
        }
        return arrayList;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                this.ctFootnotes = FootnotesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getFootnotes();
                if (inputStream != null) {
                    inputStream.close();
                }
                Iterator<CTFtnEdn> it = this.ctFootnotes.getFootnoteList().iterator();
                while (it.hasNext()) {
                    this.listFootnote.add(new XWPFFootnote(it.next(), this));
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
        } catch (XmlException unused) {
            throw new POIXMLException();
        }
    }

    public boolean removeFootnote(int i5) {
        if (this.ctFootnotes.sizeOfFootnoteArray() < i5 - 1) {
            return false;
        }
        this.ctFootnotes.removeFootnote(i5);
        this.listFootnote.remove(i5);
        return true;
    }

    @Internal
    public void setFootnotes(CTFootnotes cTFootnotes) {
        this.ctFootnotes = cTFootnotes;
    }

    public XWPFFootnotes() {
    }

    @Internal
    public XWPFFootnote addFootnote(CTFtnEdn cTFtnEdn) {
        CTFtnEdn cTFtnEdnAddNewFootnote = this.ctFootnotes.addNewFootnote();
        cTFtnEdnAddNewFootnote.set(cTFtnEdn);
        XWPFFootnote xWPFFootnote = new XWPFFootnote(cTFtnEdnAddNewFootnote, this);
        this.listFootnote.add(xWPFFootnote);
        return xWPFFootnote;
    }
}
