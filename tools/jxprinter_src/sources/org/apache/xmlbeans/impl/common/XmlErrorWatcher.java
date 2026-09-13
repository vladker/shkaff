package org.apache.xmlbeans.impl.common;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.apache.xmlbeans.XmlError;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlErrorWatcher extends AbstractCollection<XmlError> {
    private XmlError _firstError;
    private final Collection<XmlError> _underlying;

    public XmlErrorWatcher(Collection<XmlError> collection) {
        this._underlying = collection;
    }

    public XmlError firstError() {
        return this._firstError;
    }

    public boolean hasError() {
        return this._firstError != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<XmlError> iterator() {
        Collection<XmlError> collection = this._underlying;
        return collection == null ? Collections.emptyIterator() : collection.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        Collection<XmlError> collection = this._underlying;
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(XmlError xmlError) {
        if (this._firstError == null && xmlError != null && xmlError.getSeverity() == 0) {
            this._firstError = xmlError;
        }
        Collection<XmlError> collection = this._underlying;
        if (collection == null) {
            return false;
        }
        return collection.add(xmlError);
    }
}
