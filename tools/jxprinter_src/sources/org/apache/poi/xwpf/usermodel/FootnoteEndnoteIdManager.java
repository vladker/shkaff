package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FootnoteEndnoteIdManager {
    private XWPFDocument document;

    public FootnoteEndnoteIdManager(XWPFDocument xWPFDocument) {
        this.document = xWPFDocument;
    }

    public BigInteger nextId() {
        ArrayList arrayList = new ArrayList();
        Iterator<XWPFFootnote> it = this.document.getFootnotes().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        Iterator<XWPFEndnote> it2 = this.document.getEndnotes().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getId());
        }
        int size = arrayList.size();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(size);
        while (arrayList.contains(bigIntegerValueOf)) {
            size++;
            bigIntegerValueOf = BigInteger.valueOf(size);
        }
        return bigIntegerValueOf;
    }
}
