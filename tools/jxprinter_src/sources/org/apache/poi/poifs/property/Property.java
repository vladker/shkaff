package org.apache.poi.poifs.property;

import androidx.collection.a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.util.ByteField;
import org.apache.poi.util.IntegerField;
import org.apache.poi.util.ShortField;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Property implements Child, POIFSViewable {
    protected static final byte _NODE_BLACK = 1;
    protected static final byte _NODE_RED = 0;
    protected static final int _NO_INDEX = -1;
    private static final int _big_block_minimum_bytes = 4096;
    private static final int _child_property_offset = 76;
    private static final int _days_1_offset = 104;
    private static final int _days_2_offset = 112;
    private static final byte _default_fill = 0;
    private static final int _max_name_length = 31;
    private static final int _name_size_offset = 64;
    private static final int _next_property_offset = 72;
    private static final int _node_color_offset = 67;
    private static final int _previous_property_offset = 68;
    private static final int _seconds_1_offset = 100;
    private static final int _seconds_2_offset = 108;
    private static final int _size_offset = 120;
    private static final int _start_block_offset = 116;
    private static final int _storage_clsid_offset = 80;
    private static final int _user_flags_offset = 96;
    private IntegerField _child_property;
    private IntegerField _days_1;
    private IntegerField _days_2;
    private int _index;
    private String _name;
    private ShortField _name_size;
    private Child _next_child;
    private IntegerField _next_property;
    private ByteField _node_color;
    private Child _previous_child;
    private IntegerField _previous_property;
    private ByteField _property_type;
    private byte[] _raw_data;
    private IntegerField _seconds_1;
    private IntegerField _seconds_2;
    private IntegerField _size;
    private IntegerField _start_block;
    private ClassID _storage_clsid;
    private IntegerField _user_flags;

    public Property() {
        byte[] bArr = new byte[128];
        this._raw_data = bArr;
        Arrays.fill(bArr, (byte) 0);
        this._name_size = new ShortField(64);
        this._property_type = new ByteField(66);
        this._node_color = new ByteField(67);
        this._previous_property = new IntegerField(68, -1, this._raw_data);
        this._next_property = new IntegerField(72, -1, this._raw_data);
        this._child_property = new IntegerField(76, -1, this._raw_data);
        this._storage_clsid = new ClassID(this._raw_data, 80);
        this._user_flags = new IntegerField(96, 0, this._raw_data);
        this._seconds_1 = new IntegerField(100, 0, this._raw_data);
        this._days_1 = new IntegerField(104, 0, this._raw_data);
        this._seconds_2 = new IntegerField(108, 0, this._raw_data);
        this._days_2 = new IntegerField(112, 0, this._raw_data);
        this._start_block = new IntegerField(116);
        this._size = new IntegerField(120, 0, this._raw_data);
        this._index = -1;
        setName("");
        setNextChild(null);
        setPreviousChild(null);
    }

    public static boolean isSmall(int i5) {
        return i5 < 4096;
    }

    public static boolean isValidIndex(int i5) {
        return i5 != -1;
    }

    public int getChildIndex() {
        return this._child_property.get();
    }

    public int getIndex() {
        return this._index;
    }

    public String getName() {
        return this._name;
    }

    @Override // org.apache.poi.poifs.property.Child
    public Child getNextChild() {
        return this._next_child;
    }

    public int getNextChildIndex() {
        return this._next_property.get();
    }

    @Override // org.apache.poi.poifs.property.Child
    public Child getPreviousChild() {
        return this._previous_child;
    }

    public int getPreviousChildIndex() {
        return this._previous_property.get();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return "Property: \"" + getName() + "\"";
    }

    public int getSize() {
        return this._size.get();
    }

    public int getStartBlock() {
        return this._start_block.get();
    }

    public ClassID getStorageClsid() {
        return this._storage_clsid;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return new Object[]{"Name          = \"" + getName() + "\"", "Property Type = " + ((int) this._property_type.get()), "Node Color    = " + ((int) this._node_color.get()), a.j((((long) this._days_1.get()) << 32) + (((long) this._seconds_1.get()) & 65535), "Time 1        = "), a.j((((long) this._days_2.get()) << 32) + (((long) this._seconds_2.get()) & 65535), "Time 2        = "), "Size          = " + getSize()};
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        return Collections.emptyIterator();
    }

    public abstract boolean isDirectory();

    public abstract void preWrite();

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return true;
    }

    public void setChildProperty(int i5) {
        this._child_property.set(i5, this._raw_data);
    }

    public void setIndex(int i5) {
        this._index = i5;
    }

    public void setName(String str) {
        char[] charArray = str.toCharArray();
        int iMin = Math.min(charArray.length, 31);
        this._name = new String(charArray, 0, iMin);
        int i5 = 0;
        short s6 = 0;
        while (i5 < iMin) {
            new ShortField(s6, (short) charArray[i5], this._raw_data);
            s6 = (short) (s6 + 2);
            i5++;
        }
        while (i5 < 32) {
            new ShortField(s6, (short) 0, this._raw_data);
            s6 = (short) (s6 + 2);
            i5++;
        }
        this._name_size.set((short) ((iMin + 1) * 2), this._raw_data);
    }

    @Override // org.apache.poi.poifs.property.Child
    public void setNextChild(Child child) {
        this._next_child = child;
        this._next_property.set(child == null ? -1 : ((Property) child).getIndex(), this._raw_data);
    }

    public void setNodeColor(byte b) {
        this._node_color.set(b, this._raw_data);
    }

    @Override // org.apache.poi.poifs.property.Child
    public void setPreviousChild(Child child) {
        this._previous_child = child;
        this._previous_property.set(child == null ? -1 : ((Property) child).getIndex(), this._raw_data);
    }

    public void setPropertyType(byte b) {
        this._property_type.set(b, this._raw_data);
    }

    public void setSize(int i5) {
        this._size.set(i5, this._raw_data);
    }

    public void setStartBlock(int i5) {
        this._start_block.set(i5, this._raw_data);
    }

    public void setStorageClsid(ClassID classID) {
        this._storage_clsid = classID;
        if (classID == null) {
            Arrays.fill(this._raw_data, 80, 96, (byte) 0);
        } else {
            classID.write(this._raw_data, 80);
        }
    }

    public boolean shouldUseSmallBlocks() {
        return isSmall(this._size.get());
    }

    public void writeData(OutputStream outputStream) throws IOException {
        outputStream.write(this._raw_data);
    }

    public Property(int i5, byte[] bArr, int i6) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i6, i6 + 128);
        this._raw_data = bArrCopyOfRange;
        this._name_size = new ShortField(64, bArrCopyOfRange);
        this._property_type = new ByteField(66, this._raw_data);
        this._node_color = new ByteField(67, this._raw_data);
        this._previous_property = new IntegerField(68, this._raw_data);
        this._next_property = new IntegerField(72, this._raw_data);
        this._child_property = new IntegerField(76, this._raw_data);
        this._storage_clsid = new ClassID(this._raw_data, 80);
        this._user_flags = new IntegerField(96, 0, this._raw_data);
        this._seconds_1 = new IntegerField(100, this._raw_data);
        this._days_1 = new IntegerField(104, this._raw_data);
        this._seconds_2 = new IntegerField(108, this._raw_data);
        this._days_2 = new IntegerField(112, this._raw_data);
        this._start_block = new IntegerField(116, this._raw_data);
        this._size = new IntegerField(120, this._raw_data);
        this._index = i5;
        int i7 = (this._name_size.get() / 2) - 1;
        if (i7 < 1) {
            this._name = "";
        } else {
            char[] cArr = new char[i7];
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                cArr[i9] = (char) new ShortField(i8, this._raw_data).get();
                i8 += 2;
            }
            this._name = new String(cArr, 0, i7);
        }
        this._next_child = null;
        this._previous_child = null;
    }
}
