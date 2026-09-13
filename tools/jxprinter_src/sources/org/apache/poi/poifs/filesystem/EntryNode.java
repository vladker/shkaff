package org.apache.poi.poifs.filesystem;

import org.apache.poi.poifs.property.Property;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EntryNode implements Entry {
    private DirectoryNode _parent;
    private Property _property;

    public EntryNode(Property property, DirectoryNode directoryNode) {
        this._property = property;
        this._parent = directoryNode;
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean delete() {
        if (isRoot() || !isDeleteOK()) {
            return false;
        }
        return this._parent.deleteEntry(this);
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public String getName() {
        return this._property.getName();
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public DirectoryEntry getParent() {
        return this._parent;
    }

    public Property getProperty() {
        return this._property;
    }

    public abstract boolean isDeleteOK();

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean isDirectoryEntry() {
        return false;
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean isDocumentEntry() {
        return false;
    }

    public boolean isRoot() {
        return this._parent == null;
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean renameTo(String str) {
        if (isRoot()) {
            return false;
        }
        return this._parent.changeName(getName(), str);
    }
}
