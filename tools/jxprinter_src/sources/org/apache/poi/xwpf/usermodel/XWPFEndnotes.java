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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFtnEdn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFEndnotes extends XWPFAbstractFootnotesEndnotes {
    protected CTEndnotes ctEndnotes;

    public XWPFEndnotes() {
    }

    public void addEndnote(XWPFEndnote xWPFEndnote) {
        this.listFootnote.add(xWPFEndnote);
        this.ctEndnotes.addNewEndnote().set(xWPFEndnote.getCTFtnEdn());
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTEndnotes.type.getName().getNamespaceURI(), "endnotes"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.ctEndnotes.save(outputStream, xmlOptions);
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

    public XWPFEndnote createEndnote() {
        CTFtnEdn cTFtnEdnNewInstance = CTFtnEdn.Factory.newInstance();
        cTFtnEdnNewInstance.setType(STFtnEdn.NORMAL);
        XWPFEndnote xWPFEndnoteAddEndnote = addEndnote(cTFtnEdnNewInstance);
        xWPFEndnoteAddEndnote.getCTFtnEdn().setId(getIdManager().nextId());
        return xWPFEndnoteAddEndnote;
    }

    public List<XWPFEndnote> getEndnotesList() {
        ArrayList arrayList = new ArrayList();
        Iterator<XWPFAbstractFootnoteEndnote> it = this.listFootnote.iterator();
        while (it.hasNext()) {
            arrayList.add((XWPFEndnote) it.next());
        }
        return arrayList;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                this.ctEndnotes = EndnotesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getEndnotes();
                if (inputStream != null) {
                    inputStream.close();
                }
                Iterator<CTFtnEdn> it = this.ctEndnotes.getEndnoteList().iterator();
                while (it.hasNext()) {
                    this.listFootnote.add(new XWPFEndnote(it.next(), this));
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

    public boolean removeEndnote(int i5) {
        if (this.ctEndnotes.sizeOfEndnoteArray() < i5 - 1) {
            return false;
        }
        this.ctEndnotes.removeEndnote(i5);
        this.listFootnote.remove(i5);
        return true;
    }

    public boolean removeFootnote(int i5) {
        if (this.ctEndnotes.sizeOfEndnoteArray() < i5 - 1) {
            return false;
        }
        this.ctEndnotes.removeEndnote(i5);
        this.listFootnote.remove(i5);
        return true;
    }

    @Internal
    public void setEndnotes(CTEndnotes cTEndnotes) {
        this.ctEndnotes = cTEndnotes;
    }

    public XWPFEndnotes(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFAbstractFootnotesEndnotes
    public XWPFEndnote getFootnoteById(int i5) {
        return (XWPFEndnote) super.getFootnoteById(i5);
    }

    @Internal
    public XWPFEndnote addEndnote(CTFtnEdn cTFtnEdn) {
        CTFtnEdn cTFtnEdnAddNewEndnote = this.ctEndnotes.addNewEndnote();
        cTFtnEdnAddNewEndnote.set(cTFtnEdn);
        XWPFEndnote xWPFEndnote = new XWPFEndnote(cTFtnEdnAddNewEndnote, this);
        this.listFootnote.add(xWPFEndnote);
        return xWPFEndnote;
    }
}
