package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class QNameCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final float DEFAULT_LOAD = 0.7f;
    private int hashmask;
    private final float loadFactor;
    private int numEntries;
    private QName[] table;
    private int threshold;

    public QNameCache(int i5, float f6) {
        this.numEntries = 0;
        int i6 = 16;
        while (i6 < i5) {
            i6 <<= 1;
        }
        this.loadFactor = f6;
        this.hashmask = i6 - 1;
        this.threshold = (int) (i6 * f6);
        this.table = new QName[i6];
    }

    private static boolean equals(QName qName, String str, String str2, String str3) {
        return qName.getLocalPart().equals(str2) && qName.getNamespaceURI().equals(str) && qName.getPrefix().equals(str3);
    }

    private static int hash(String str, String str2, String str3) {
        return str2.hashCode() + (str3.hashCode() << 10) + (str.hashCode() << 5);
    }

    private void rehash() {
        int i5;
        int length = this.table.length * 2;
        QName[] qNameArr = new QName[length];
        int i6 = length - 1;
        int i7 = 0;
        while (true) {
            QName[] qNameArr2 = this.table;
            if (i7 >= qNameArr2.length) {
                this.table = qNameArr;
                this.hashmask = i6;
                this.threshold = (int) (length * this.loadFactor);
                return;
            }
            QName qName = qNameArr2[i7];
            if (qName != null) {
                int iHash = hash(qName.getNamespaceURI(), qName.getLocalPart(), qName.getPrefix());
                while (true) {
                    i5 = iHash & i6;
                    if (qNameArr[i5] == null) {
                        break;
                    } else {
                        iHash = i5 - 1;
                    }
                }
                qNameArr[i5] = qName;
            }
            i7++;
        }
    }

    public QName getName(String str, String str2) {
        return getName(str, str2, "");
    }

    public QName getName(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        int iHash = hash(str, str2, str3);
        int i5 = this.hashmask;
        while (true) {
            int i6 = iHash & i5;
            QName qName = this.table[i6];
            if (qName == null) {
                int i7 = this.numEntries + 1;
                this.numEntries = i7;
                if (i7 >= this.threshold) {
                    rehash();
                }
                QName[] qNameArr = this.table;
                QName qName2 = new QName(str, str2, str3);
                qNameArr[i6] = qName2;
                return qName2;
            }
            if (equals(qName, str, str2, str3)) {
                return qName;
            }
            iHash = i6 - 1;
            i5 = this.hashmask;
        }
    }

    public QNameCache(int i5) {
        this(i5, DEFAULT_LOAD);
    }
}
