package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFNumbering extends POIXMLDocumentPart {
    protected List<XWPFAbstractNum> abstractNums;
    private CTNumbering ctNumbering;
    boolean isNew;
    protected List<XWPFNum> nums;

    public XWPFNumbering(PackagePart packagePart) {
        super(packagePart);
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.isNew = true;
    }

    private BigInteger findNextAbstractNumberingId() {
        Iterator<XWPFAbstractNum> it = this.abstractNums.iterator();
        long jMax = 0;
        while (it.hasNext()) {
            jMax = Math.max(jMax, it.next().getAbstractNum().getAbstractNumId().longValue());
        }
        return BigInteger.valueOf(jMax + 1);
    }

    public BigInteger addAbstractNum(XWPFAbstractNum xWPFAbstractNum) {
        int size = this.abstractNums.size();
        if (xWPFAbstractNum.getAbstractNum() != null) {
            CTAbstractNum cTAbstractNumAddNewAbstractNum = this.ctNumbering.addNewAbstractNum();
            cTAbstractNumAddNewAbstractNum.set(xWPFAbstractNum.getAbstractNum());
            xWPFAbstractNum.setCtAbstractNum(cTAbstractNumAddNewAbstractNum);
        } else {
            xWPFAbstractNum.setCtAbstractNum(this.ctNumbering.addNewAbstractNum());
            xWPFAbstractNum.getAbstractNum().setAbstractNumId(findNextAbstractNumberingId());
            this.ctNumbering.setAbstractNumArray(size, xWPFAbstractNum.getAbstractNum());
            xWPFAbstractNum.setCtAbstractNum(this.ctNumbering.getAbstractNumArray(size));
        }
        this.abstractNums.add(xWPFAbstractNum);
        return xWPFAbstractNum.getCTAbstractNum().getAbstractNumId();
    }

    public BigInteger addNum(XWPFNum xWPFNum) {
        this.ctNumbering.addNewNum();
        this.ctNumbering.setNumArray(this.ctNumbering.sizeOfNumArray() - 1, xWPFNum.getCTNum());
        this.nums.add(xWPFNum);
        return xWPFNum.getCTNum().getNumId();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "numbering"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.ctNumbering.save(outputStream, xmlOptions);
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

    public XWPFAbstractNum getAbstractNum(BigInteger bigInteger) {
        for (XWPFAbstractNum xWPFAbstractNum : this.abstractNums) {
            if (xWPFAbstractNum.getAbstractNum().getAbstractNumId().equals(bigInteger)) {
                return xWPFAbstractNum;
            }
        }
        return null;
    }

    public BigInteger getAbstractNumID(BigInteger bigInteger) {
        XWPFNum num = getNum(bigInteger);
        if (num == null || num.getCTNum() == null || num.getCTNum().getAbstractNumId() == null) {
            return null;
        }
        return num.getCTNum().getAbstractNumId().getVal();
    }

    public List<XWPFAbstractNum> getAbstractNums() {
        return Collections.unmodifiableList(this.abstractNums);
    }

    public BigInteger getIdOfAbstractNum(XWPFAbstractNum xWPFAbstractNum) {
        XWPFAbstractNum xWPFAbstractNum2 = new XWPFAbstractNum((CTAbstractNum) xWPFAbstractNum.getCTAbstractNum().copy(), this);
        for (int i5 = 0; i5 < this.abstractNums.size(); i5++) {
            xWPFAbstractNum2.getCTAbstractNum().setAbstractNumId(BigInteger.valueOf(i5));
            xWPFAbstractNum2.setNumbering(this);
            if (xWPFAbstractNum2.getCTAbstractNum().valueEquals(this.abstractNums.get(i5).getCTAbstractNum())) {
                return xWPFAbstractNum2.getCTAbstractNum().getAbstractNumId();
            }
        }
        return null;
    }

    public XWPFNum getNum(BigInteger bigInteger) {
        for (XWPFNum xWPFNum : this.nums) {
            if (xWPFNum.getCTNum().getNumId().equals(bigInteger)) {
                return xWPFNum;
            }
        }
        return null;
    }

    public List<XWPFNum> getNums() {
        return Collections.unmodifiableList(this.nums);
    }

    public boolean numExist(BigInteger bigInteger) {
        Iterator<XWPFNum> it = this.nums.iterator();
        while (it.hasNext()) {
            if (it.next().getCTNum().getNumId().equals(bigInteger)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() throws IOException {
        InputStream inputStream = getPackagePart().getInputStream();
        try {
            try {
                CTNumbering numbering = NumberingDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNumbering();
                this.ctNumbering = numbering;
                for (CTNum cTNum : numbering.getNumArray()) {
                    this.nums.add(new XWPFNum(cTNum, this));
                }
                for (CTAbstractNum cTAbstractNum : this.ctNumbering.getAbstractNumArray()) {
                    this.abstractNums.add(new XWPFAbstractNum(cTAbstractNum, this));
                }
                this.isNew = false;
                inputStream.close();
            } catch (XmlException unused) {
                throw new POIXMLException();
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public boolean removeAbstractNum(BigInteger bigInteger) {
        for (XWPFAbstractNum xWPFAbstractNum : this.abstractNums) {
            if (bigInteger.equals(xWPFAbstractNum.getAbstractNum().getAbstractNumId())) {
                this.abstractNums.remove(xWPFAbstractNum);
                break;
            }
        }
        for (int i5 = 0; i5 < this.ctNumbering.sizeOfAbstractNumArray(); i5++) {
            if (bigInteger.equals(this.ctNumbering.getAbstractNumArray(i5).getAbstractNumId())) {
                this.ctNumbering.removeAbstractNum(i5);
                return true;
            }
        }
        return false;
    }

    public void setNumbering(CTNumbering cTNumbering) {
        this.ctNumbering = cTNumbering;
    }

    public XWPFNumbering() {
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.isNew = true;
    }

    public BigInteger addNum(BigInteger bigInteger) {
        CTNum cTNumAddNewNum = this.ctNumbering.addNewNum();
        cTNumAddNewNum.addNewAbstractNumId();
        cTNumAddNewNum.getAbstractNumId().setVal(bigInteger);
        cTNumAddNewNum.setNumId(BigInteger.valueOf(((long) this.nums.size()) + 1));
        this.nums.add(new XWPFNum(cTNumAddNewNum, this));
        return cTNumAddNewNum.getNumId();
    }

    public void addNum(BigInteger bigInteger, BigInteger bigInteger2) {
        CTNum cTNumAddNewNum = this.ctNumbering.addNewNum();
        cTNumAddNewNum.addNewAbstractNumId();
        cTNumAddNewNum.getAbstractNumId().setVal(bigInteger);
        cTNumAddNewNum.setNumId(bigInteger2);
        this.nums.add(new XWPFNum(cTNumAddNewNum, this));
    }
}
