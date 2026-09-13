package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MimeHeaders {
    protected Vector<MimeHeader> headers = new Vector<>();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class MatchingIterator implements Iterator<MimeHeader> {
        private final Iterator<MimeHeader> iterator;
        private final boolean match;
        private final String[] names;
        private MimeHeader nextHeader;

        public MatchingIterator(String[] strArr, boolean z6) {
            this.match = z6;
            this.names = strArr;
            this.iterator = MimeHeaders.this.headers.iterator();
        }

        private MimeHeader nextMatch() {
            while (this.iterator.hasNext()) {
                MimeHeader next = this.iterator.next();
                String[] strArr = this.names;
                if (strArr != null) {
                    int length = strArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            if (this.match) {
                                break;
                            }
                        } else {
                            if (next.getName().equalsIgnoreCase(strArr[i5])) {
                                if (!this.match) {
                                    break;
                                }
                                return next;
                            }
                            i5++;
                        }
                    }
                } else if (this.match) {
                    return null;
                }
                return next;
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextHeader == null) {
                this.nextHeader = nextMatch();
            }
            return this.nextHeader != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // java.util.Iterator
        public MimeHeader next() {
            MimeHeader mimeHeader = this.nextHeader;
            if (mimeHeader != null) {
                this.nextHeader = null;
                return mimeHeader;
            }
            if (hasNext()) {
                return this.nextHeader;
            }
            return null;
        }
    }

    public void addHeader(String str, String str2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Illegal MimeHeader name");
        }
        for (int size = this.headers.size() - 1; size >= 0; size--) {
            if (this.headers.elementAt(size).getName().equalsIgnoreCase(str)) {
                this.headers.insertElementAt(new MimeHeader(str, str2), size + 1);
                return;
            }
        }
        this.headers.addElement(new MimeHeader(str, str2));
    }

    public Iterator<MimeHeader> getAllHeaders() {
        return this.headers.iterator();
    }

    public String[] getHeader(String str) {
        Vector vector = new Vector();
        for (int i5 = 0; i5 < this.headers.size(); i5++) {
            MimeHeader mimeHeaderElementAt = this.headers.elementAt(i5);
            if (mimeHeaderElementAt.getName().equalsIgnoreCase(str) && mimeHeaderElementAt.getValue() != null) {
                vector.addElement(mimeHeaderElementAt.getValue());
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    public Iterator<MimeHeader> getMatchingHeaders(String[] strArr) {
        return new MatchingIterator(strArr, true);
    }

    public Iterator<MimeHeader> getNonMatchingHeaders(String[] strArr) {
        return new MatchingIterator(strArr, false);
    }

    public void removeAllHeaders() {
        this.headers.removeAllElements();
    }

    public void removeHeader(String str) {
        int i5 = 0;
        while (i5 < this.headers.size()) {
            if (this.headers.elementAt(i5).getName().equalsIgnoreCase(str)) {
                this.headers.removeElementAt(i5);
                i5--;
            }
            i5++;
        }
    }

    public void setHeader(String str, String str2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("Illegal MimeHeader name");
        }
        int i5 = 0;
        boolean z6 = false;
        while (i5 < this.headers.size()) {
            MimeHeader mimeHeaderElementAt = this.headers.elementAt(i5);
            if (mimeHeaderElementAt.getName().equalsIgnoreCase(str)) {
                if (z6) {
                    this.headers.removeElementAt(i5);
                    i5--;
                } else {
                    this.headers.setElementAt(new MimeHeader(mimeHeaderElementAt.getName(), str2), i5);
                    z6 = true;
                }
            }
            i5++;
        }
        if (z6) {
            return;
        }
        addHeader(str, str2);
    }
}
