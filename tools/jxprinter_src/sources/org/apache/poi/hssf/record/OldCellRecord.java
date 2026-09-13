package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OldCellRecord implements GenericRecord {
    private final int field_1_row;
    private final short field_2_column;
    private int field_3_cell_attrs;
    private short field_3_xf_index;
    private final boolean isBiff2;
    private final short sid;

    public OldCellRecord(RecordInputStream recordInputStream, boolean z6) {
        this.sid = recordInputStream.getSid();
        this.isBiff2 = z6;
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_column = recordInputStream.readShort();
        if (!z6) {
            this.field_3_xf_index = recordInputStream.readShort();
            return;
        }
        int uShort = recordInputStream.readUShort() << 8;
        this.field_3_cell_attrs = uShort;
        this.field_3_cell_attrs = recordInputStream.readUByte() + uShort;
    }

    public int getCellAttrs() {
        return this.field_3_cell_attrs;
    }

    public final short getColumn() {
        return this.field_2_column;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.r0
            public final /* synthetic */ OldCellRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Boolean.valueOf(this.b.isBiff2());
                    case 3:
                        return Integer.valueOf(this.b.getCellAttrs());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.r0
            public final /* synthetic */ OldCellRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Boolean.valueOf(this.b.isBiff2());
                    case 3:
                        return Integer.valueOf(this.b.getCellAttrs());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.r0
            public final /* synthetic */ OldCellRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Boolean.valueOf(this.b.isBiff2());
                    case 3:
                        return Integer.valueOf(this.b.getCellAttrs());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.r0
            public final /* synthetic */ OldCellRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Boolean.valueOf(this.b.isBiff2());
                    case 3:
                        return Integer.valueOf(this.b.getCellAttrs());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("row", supplier, "column", supplier2, "biff2", supplier3, "biff2CellAttrs", supplier4, "xfIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.r0
            public final /* synthetic */ OldCellRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Boolean.valueOf(this.b.isBiff2());
                    case 3:
                        return Integer.valueOf(this.b.getCellAttrs());
                    default:
                        return Short.valueOf(this.b.getXFIndex());
                }
            }
        });
    }

    public final int getRow() {
        return this.field_1_row;
    }

    public short getSid() {
        return this.sid;
    }

    public final short getXFIndex() {
        return this.field_3_xf_index;
    }

    public boolean isBiff2() {
        return this.isBiff2;
    }

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
