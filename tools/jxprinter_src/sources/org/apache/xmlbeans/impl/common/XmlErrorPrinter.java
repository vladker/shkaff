package org.apache.xmlbeans.impl.common;

import java.net.URI;
import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Iterator;
import org.apache.xmlbeans.XmlError;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlErrorPrinter extends AbstractCollection<XmlError> {
    private final URI _baseURI;
    private final boolean _noisy;

    public XmlErrorPrinter(boolean z6, URI uri) {
        this._noisy = z6;
        this._baseURI = uri;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<XmlError> iterator() {
        return Collections.emptyIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(XmlError xmlError) {
        if (xmlError == null) {
            return false;
        }
        if (xmlError.getSeverity() == 0 || xmlError.getSeverity() == 1) {
            System.err.println(xmlError.toString(this._baseURI));
            return false;
        }
        if (!this._noisy) {
            return false;
        }
        System.out.println(xmlError.toString(this._baseURI));
        return false;
    }
}
