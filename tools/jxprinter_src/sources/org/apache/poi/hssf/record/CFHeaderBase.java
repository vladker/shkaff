package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellRangeUtil;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CFHeaderBase extends StandardRecord {
    private int field_1_numcf;
    private int field_2_need_recalculation_and_id;
    private CellRangeAddress field_3_enclosing_cell_range;
    private CellRangeAddressList field_4_cell_ranges;

    public CFHeaderBase() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public abstract CFHeaderBase copy();

    public void createEmpty() {
        this.field_3_enclosing_cell_range = new CellRangeAddress(0, 0, 0, 0);
        this.field_4_cell_ranges = new CellRangeAddressList();
    }

    public CellRangeAddress[] getCellRanges() {
        return this.field_4_cell_ranges.getCellRangeAddresses();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.field_4_cell_ranges.getSize() + 12;
    }

    public CellRangeAddress getEnclosingCellRange() {
        return this.field_3_enclosing_cell_range;
    }

    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.i
            public final /* synthetic */ CFHeaderBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getID());
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfConditionalFormats());
                    case 2:
                        return Boolean.valueOf(this.b.getNeedRecalculation());
                    case 3:
                        return this.b.getEnclosingCellRange();
                    default:
                        return this.b.getCellRanges();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.i
            public final /* synthetic */ CFHeaderBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getID());
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfConditionalFormats());
                    case 2:
                        return Boolean.valueOf(this.b.getNeedRecalculation());
                    case 3:
                        return this.b.getEnclosingCellRange();
                    default:
                        return this.b.getCellRanges();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.i
            public final /* synthetic */ CFHeaderBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getID());
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfConditionalFormats());
                    case 2:
                        return Boolean.valueOf(this.b.getNeedRecalculation());
                    case 3:
                        return this.b.getEnclosingCellRange();
                    default:
                        return this.b.getCellRanges();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.i
            public final /* synthetic */ CFHeaderBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getID());
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfConditionalFormats());
                    case 2:
                        return Boolean.valueOf(this.b.getNeedRecalculation());
                    case 3:
                        return this.b.getEnclosingCellRange();
                    default:
                        return this.b.getCellRanges();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("id", supplier, "numCF", supplier2, "needRecalculationAndId", supplier3, "enclosingCellRange", supplier4, "cfRanges", new Supplier(this) { // from class: org.apache.poi.hssf.record.i
            public final /* synthetic */ CFHeaderBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getID());
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfConditionalFormats());
                    case 2:
                        return Boolean.valueOf(this.b.getNeedRecalculation());
                    case 3:
                        return this.b.getEnclosingCellRange();
                    default:
                        return this.b.getCellRanges();
                }
            }
        });
    }

    public int getID() {
        return this.field_2_need_recalculation_and_id >> 1;
    }

    public boolean getNeedRecalculation() {
        return (this.field_2_need_recalculation_and_id & 1) == 1;
    }

    public int getNumberOfConditionalFormats() {
        return this.field_1_numcf;
    }

    public abstract String getRecordName();

    public void read(RecordInputStream recordInputStream) {
        this.field_1_numcf = recordInputStream.readShort();
        this.field_2_need_recalculation_and_id = recordInputStream.readShort();
        this.field_3_enclosing_cell_range = new CellRangeAddress(recordInputStream);
        this.field_4_cell_ranges = new CellRangeAddressList(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_numcf);
        littleEndianOutput.writeShort(this.field_2_need_recalculation_and_id);
        this.field_3_enclosing_cell_range.serialize(littleEndianOutput);
        this.field_4_cell_ranges.serialize(littleEndianOutput);
    }

    public void setCellRanges(CellRangeAddress[] cellRangeAddressArr) {
        if (cellRangeAddressArr == null) {
            throw new IllegalArgumentException("cellRanges must not be null");
        }
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
        CellRangeAddress cellRangeAddressCreateEnclosingCellRange = null;
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            cellRangeAddressCreateEnclosingCellRange = CellRangeUtil.createEnclosingCellRange(cellRangeAddress, cellRangeAddressCreateEnclosingCellRange);
            cellRangeAddressList.addCellRangeAddress(cellRangeAddress);
        }
        this.field_3_enclosing_cell_range = cellRangeAddressCreateEnclosingCellRange;
        this.field_4_cell_ranges = cellRangeAddressList;
    }

    public void setEnclosingCellRange(CellRangeAddress cellRangeAddress) {
        this.field_3_enclosing_cell_range = cellRangeAddress;
    }

    public void setID(int i5) {
        boolean needRecalculation = getNeedRecalculation();
        int i6 = i5 << 1;
        this.field_2_need_recalculation_and_id = i6;
        if (needRecalculation) {
            this.field_2_need_recalculation_and_id = i6 + 1;
        }
    }

    public void setNeedRecalculation(boolean z6) {
        if (z6 == getNeedRecalculation()) {
            return;
        }
        if (z6) {
            this.field_2_need_recalculation_and_id++;
        } else {
            this.field_2_need_recalculation_and_id--;
        }
    }

    public void setNumberOfConditionalFormats(int i5) {
        this.field_1_numcf = i5;
    }

    public CFHeaderBase(CFHeaderBase cFHeaderBase) {
        super(cFHeaderBase);
        this.field_1_numcf = cFHeaderBase.field_1_numcf;
        this.field_2_need_recalculation_and_id = cFHeaderBase.field_2_need_recalculation_and_id;
        this.field_3_enclosing_cell_range = cFHeaderBase.field_3_enclosing_cell_range.copy();
        this.field_4_cell_ranges = cFHeaderBase.field_4_cell_ranges.copy();
    }

    public CFHeaderBase(CellRangeAddress[] cellRangeAddressArr, int i5) {
        setCellRanges(CellRangeUtil.mergeCellRanges(cellRangeAddressArr));
        this.field_1_numcf = i5;
    }
}
