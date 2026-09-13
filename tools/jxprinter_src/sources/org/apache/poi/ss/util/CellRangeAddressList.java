package org.apache.poi.ss.util;

import A3.AbstractC0157z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellRangeAddressList implements GenericRecord {
    protected final List<CellRangeAddress> _list = new ArrayList();

    public CellRangeAddressList() {
    }

    public static int getEncodedSize(int i5) {
        return CellRangeAddress.getEncodedSize(i5) + 2;
    }

    public void addCellRangeAddress(int i5, int i6, int i7, int i8) {
        addCellRangeAddress(new CellRangeAddress(i5, i7, i6, i8));
    }

    public CellRangeAddressList copy() {
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
        Iterator<CellRangeAddress> it = this._list.iterator();
        while (it.hasNext()) {
            cellRangeAddressList.addCellRangeAddress(it.next().copy());
        }
        return cellRangeAddressList;
    }

    public int countRanges() {
        return this._list.size();
    }

    public CellRangeAddress getCellRangeAddress(int i5) {
        return this._list.get(i5);
    }

    public CellRangeAddress[] getCellRangeAddresses() {
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[this._list.size()];
        this._list.toArray(cellRangeAddressArr);
        return cellRangeAddressArr;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<CellRangeAddress> getGenericChildren() {
        return this._list;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    public int getSize() {
        return getEncodedSize(this._list.size());
    }

    public CellRangeAddress remove(int i5) {
        if (this._list.isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (i5 >= 0 && i5 < this._list.size()) {
            return this._list.remove(i5);
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Range index (", ") is outside allowable range (0..");
        sbT.append(this._list.size() - 1);
        sbT.append(")");
        throw new RuntimeException(sbT.toString());
    }

    public int serialize(int i5, byte[] bArr) {
        int size = getSize();
        try {
            LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i5, size);
            try {
                serialize(littleEndianByteArrayOutputStream);
                littleEndianByteArrayOutputStream.close();
                return size;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        littleEndianByteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public CellRangeAddressList(int i5, int i6, int i7, int i8) {
        addCellRangeAddress(i5, i7, i6, i8);
    }

    public void addCellRangeAddress(CellRangeAddress cellRangeAddress) {
        this._list.add(cellRangeAddress);
    }

    public CellRangeAddressList(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        for (int i5 = 0; i5 < uShort; i5++) {
            this._list.add(new CellRangeAddress(recordInputStream));
        }
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._list.size());
        Iterator<CellRangeAddress> it = this._list.iterator();
        while (it.hasNext()) {
            it.next().serialize(littleEndianOutput);
        }
    }
}
