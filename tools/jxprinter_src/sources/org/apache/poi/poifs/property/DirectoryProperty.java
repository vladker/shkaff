package org.apache.poi.poifs.property;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DirectoryProperty extends Property implements Parent, Iterable<Property> {
    private final List<Property> _children;
    private final Set<String> _children_names;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PropertyComparator implements Comparator<Property>, Serializable {
        @Override // java.util.Comparator
        public int compare(Property property, Property property2) {
            String name = property.getName();
            String name2 = property2.getName();
            int length = name.length() - name2.length();
            if (length != 0) {
                return length;
            }
            if (name.compareTo("_VBA_PROJECT") == 0) {
                return 1;
            }
            if (name2.compareTo("_VBA_PROJECT") == 0) {
                return -1;
            }
            if (name.startsWith("__") && name2.startsWith("__")) {
                return name.compareToIgnoreCase(name2);
            }
            if (name.startsWith("__")) {
                return 1;
            }
            if (name2.startsWith("__")) {
                return -1;
            }
            return name.compareToIgnoreCase(name2);
        }
    }

    public DirectoryProperty(String str) {
        this._children = new ArrayList();
        this._children_names = new HashSet();
        setName(str);
        setSize(0);
        setPropertyType((byte) 1);
        setStartBlock(0);
        setNodeColor((byte) 1);
    }

    @Override // org.apache.poi.poifs.property.Parent
    public void addChild(Property property) {
        String name = property.getName();
        if (this._children_names.contains(name)) {
            throw new IOException(AbstractC0157z.o("Duplicate name \"", name, "\""));
        }
        this._children_names.add(name);
        this._children.add(property);
    }

    public boolean changeName(Property property, String str) {
        String name = property.getName();
        property.setName(str);
        String name2 = property.getName();
        if (this._children_names.contains(name2)) {
            property.setName(name);
            return false;
        }
        this._children_names.add(name2);
        this._children_names.remove(name);
        return true;
    }

    public boolean deleteChild(Property property) {
        boolean zRemove = this._children.remove(property);
        if (zRemove) {
            this._children_names.remove(property.getName());
        }
        return zRemove;
    }

    @Override // org.apache.poi.poifs.property.Parent
    public Iterator<Property> getChildren() {
        return this._children.iterator();
    }

    @Override // org.apache.poi.poifs.property.Property
    public boolean isDirectory() {
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<Property> iterator() {
        return getChildren();
    }

    @Override // org.apache.poi.poifs.property.Property
    public void preWrite() {
        if (this._children.isEmpty()) {
            return;
        }
        Child[] childArr = (Property[]) this._children.toArray(new Property[0]);
        Arrays.sort(childArr, new PropertyComparator());
        int length = childArr.length / 2;
        setChildProperty(childArr[length].getIndex());
        childArr[0].setPreviousChild(null);
        childArr[0].setNextChild(null);
        for (int i5 = 1; i5 < length; i5++) {
            childArr[i5].setPreviousChild(childArr[i5 - 1]);
            childArr[i5].setNextChild(null);
        }
        if (length != 0) {
            childArr[length].setPreviousChild(childArr[length - 1]);
        }
        if (length == childArr.length - 1) {
            childArr[length].setNextChild(null);
            return;
        }
        Property property = childArr[length];
        int i6 = length + 1;
        property.setNextChild(childArr[i6]);
        while (i6 < childArr.length - 1) {
            childArr[i6].setPreviousChild(null);
            Child child = childArr[i6];
            i6++;
            child.setNextChild(childArr[i6]);
        }
        childArr[childArr.length - 1].setPreviousChild(null);
        childArr[childArr.length - 1].setNextChild(null);
    }

    @Override // java.lang.Iterable
    public Spliterator<Property> spliterator() {
        return this._children.spliterator();
    }

    public DirectoryProperty(int i5, byte[] bArr, int i6) {
        super(i5, bArr, i6);
        this._children = new ArrayList();
        this._children_names = new HashSet();
    }
}
