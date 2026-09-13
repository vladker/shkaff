package org.apache.poi.hssf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
import org.apache.poi.hssf.record.cf.ColorGradientThreshold;
import org.apache.poi.hssf.record.cf.DataBarFormatting;
import org.apache.poi.hssf.record.cf.DataBarThreshold;
import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
import org.apache.poi.hssf.record.cf.IconMultiStateThreshold;
import org.apache.poi.hssf.record.cf.Threshold;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.hssf.record.common.FutureRecord;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CFRule12Record extends CFRuleBase implements FutureRecord {
    public static final short sid = 2170;
    private ColorGradientFormatting color_gradient;
    private DataBarFormatting data_bar;
    private byte[] ext_formatting_data;
    private int ext_formatting_length;
    private byte ext_opts;
    private byte[] filter_data;
    private Formula formula_scale;
    private FtrHeader futureHeader;
    private IconMultiStateFormatting multistate;
    private int priority;
    private byte template_param_length;
    private byte[] template_params;
    private int template_type;

    public CFRule12Record(CFRule12Record cFRule12Record) {
        super(cFRule12Record);
        FtrHeader ftrHeader = cFRule12Record.futureHeader;
        this.futureHeader = ftrHeader == null ? null : ftrHeader.copy();
        this.ext_formatting_length = Math.min(cFRule12Record.ext_formatting_length, cFRule12Record.ext_formatting_data.length);
        this.ext_formatting_data = (byte[]) cFRule12Record.ext_formatting_data.clone();
        this.formula_scale = cFRule12Record.formula_scale.copy();
        this.ext_opts = cFRule12Record.ext_opts;
        this.priority = cFRule12Record.priority;
        this.template_type = cFRule12Record.template_type;
        this.template_param_length = cFRule12Record.template_param_length;
        byte[] bArr = cFRule12Record.template_params;
        this.template_params = bArr == null ? null : (byte[]) bArr.clone();
        ColorGradientFormatting colorGradientFormatting = cFRule12Record.color_gradient;
        this.color_gradient = colorGradientFormatting == null ? null : colorGradientFormatting.copy();
        IconMultiStateFormatting iconMultiStateFormatting = cFRule12Record.multistate;
        this.multistate = iconMultiStateFormatting == null ? null : iconMultiStateFormatting.copy();
        DataBarFormatting dataBarFormatting = cFRule12Record.data_bar;
        this.data_bar = dataBarFormatting == null ? null : dataBarFormatting.copy();
        byte[] bArr2 = cFRule12Record.filter_data;
        this.filter_data = bArr2 != null ? (byte[]) bArr2.clone() : null;
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, String str) {
        return new CFRule12Record((byte) 2, (byte) 0, CFRuleBase.parseFormula(str, hSSFSheet), null, null);
    }

    public static CFRule12Record createColorScale(HSSFSheet hSSFSheet) {
        ExtendedColor[] extendedColorArr = new ExtendedColor[3];
        ColorGradientThreshold[] colorGradientThresholdArr = new ColorGradientThreshold[3];
        for (int i5 = 0; i5 < 3; i5++) {
            colorGradientThresholdArr[i5] = new ColorGradientThreshold();
            extendedColorArr[i5] = new ExtendedColor();
        }
        CFRule12Record cFRule12Record = new CFRule12Record((byte) 3, (byte) 0);
        ColorGradientFormatting colorGradientFormattingCreateColorGradientFormatting = cFRule12Record.createColorGradientFormatting();
        colorGradientFormattingCreateColorGradientFormatting.setNumControlPoints(3);
        colorGradientFormattingCreateColorGradientFormatting.setThresholds(colorGradientThresholdArr);
        colorGradientFormattingCreateColorGradientFormatting.setColors(extendedColorArr);
        return cFRule12Record;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.ext_formatting_length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this.ext_formatting_data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Byte.valueOf(this.ext_opts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Integer.valueOf(this.template_type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return this.template_params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$5() {
        return this.filter_data;
    }

    private void setDefaults() {
        FtrHeader ftrHeader = new FtrHeader();
        this.futureHeader = ftrHeader;
        ftrHeader.setRecordType(sid);
        this.ext_formatting_length = 0;
        this.ext_formatting_data = new byte[4];
        this.formula_scale = Formula.create(Ptg.EMPTY_PTG_ARRAY);
        this.ext_opts = (byte) 0;
        this.priority = 0;
        this.template_type = getConditionType();
        this.template_param_length = (byte) 16;
        this.template_params = IOUtils.safelyAllocate(16, HSSFWorkbook.getMaxRecordLength());
    }

    public boolean containsColorGradientBlock() {
        return this.color_gradient != null;
    }

    public boolean containsDataBarBlock() {
        return this.data_bar != null;
    }

    public boolean containsMultiStateBlock() {
        return this.multistate != null;
    }

    public ColorGradientFormatting createColorGradientFormatting() {
        ColorGradientFormatting colorGradientFormatting = this.color_gradient;
        if (colorGradientFormatting != null) {
            return colorGradientFormatting;
        }
        setConditionType((byte) 3);
        ColorGradientFormatting colorGradientFormatting2 = new ColorGradientFormatting();
        this.color_gradient = colorGradientFormatting2;
        return colorGradientFormatting2;
    }

    public DataBarFormatting createDataBarFormatting() {
        DataBarFormatting dataBarFormatting = this.data_bar;
        if (dataBarFormatting != null) {
            return dataBarFormatting;
        }
        setConditionType((byte) 4);
        DataBarFormatting dataBarFormatting2 = new DataBarFormatting();
        this.data_bar = dataBarFormatting2;
        return dataBarFormatting2;
    }

    public IconMultiStateFormatting createMultiStateFormatting() {
        IconMultiStateFormatting iconMultiStateFormatting = this.multistate;
        if (iconMultiStateFormatting != null) {
            return iconMultiStateFormatting;
        }
        setConditionType((byte) 6);
        IconMultiStateFormatting iconMultiStateFormatting2 = new IconMultiStateFormatting();
        this.multistate = iconMultiStateFormatting2;
        return iconMultiStateFormatting2;
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public CellRangeAddress getAssociatedRange() {
        return this.futureHeader.getAssociatedRange();
    }

    public ColorGradientFormatting getColorGradientFormatting() {
        return this.color_gradient;
    }

    public DataBarFormatting getDataBarFormatting() {
        return this.data_bar;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int dataLength;
        int dataSize = FtrHeader.getDataSize();
        int length = this.template_params.length + 6 + CFRuleBase.getFormulaSize(this.formula_scale) + 2 + CFRuleBase.getFormulaSize(getFormula2()) + CFRuleBase.getFormulaSize(getFormula1()) + (this.ext_formatting_length == 0 ? dataSize + 12 : getFormattingBlockSize() + 4 + this.ext_formatting_data.length + dataSize + 6);
        byte conditionType = getConditionType();
        if (conditionType == 3) {
            dataLength = this.color_gradient.getDataLength();
        } else if (conditionType == 4) {
            dataLength = this.data_bar.getDataLength();
        } else {
            if (conditionType == 5) {
                return length + this.filter_data.length;
            }
            if (conditionType != 6) {
                return length;
            }
            dataLength = this.multistate.getDataLength();
        }
        return dataLength + length;
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public FtrHeader getFutureHeader() {
        return this.futureHeader;
    }

    @Override // org.apache.poi.hssf.record.common.FutureRecord
    public short getFutureRecordType() {
        return this.futureHeader.getRecordType();
    }

    @Override // org.apache.poi.hssf.record.CFRuleBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(super.getGenericProperties());
        final int i5 = 0;
        linkedHashMap.put("dxFn12Length", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i6 = 5;
        linkedHashMap.put("futureHeader", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i7 = 6;
        linkedHashMap.put("dxFn12Ext", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i8 = 7;
        linkedHashMap.put("formulaScale", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i9 = 8;
        linkedHashMap.put("extOptions", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i10 = 9;
        linkedHashMap.put("priority", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i11 = 10;
        linkedHashMap.put("templateType", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i12 = 11;
        linkedHashMap.put("templateParams", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i13 = 1;
        linkedHashMap.put("filterData", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i14 = 2;
        linkedHashMap.put("dataBar", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i15 = 3;
        linkedHashMap.put("multiState", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        final int i16 = 4;
        linkedHashMap.put("colorGradient", new Supplier(this) { // from class: org.apache.poi.hssf.record.j
            public final /* synthetic */ CFRule12Record b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i16) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$5();
                    case 2:
                        return this.b.getDataBarFormatting();
                    case 3:
                        return this.b.getMultiStateFormatting();
                    case 4:
                        return this.b.getColorGradientFormatting();
                    case 5:
                        return this.b.getFutureHeader();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.getParsedExpressionScale();
                    case 8:
                        return this.b.lambda$getGenericProperties$2();
                    case 9:
                        return Integer.valueOf(this.b.getPriority());
                    case 10:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public IconMultiStateFormatting getMultiStateFormatting() {
        return this.multistate;
    }

    public Ptg[] getParsedExpressionScale() {
        return this.formula_scale.getTokens();
    }

    public int getPriority() {
        return this.priority;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this.futureHeader.serialize(littleEndianOutput);
        int formulaSize = CFRuleBase.getFormulaSize(getFormula1());
        int formulaSize2 = CFRuleBase.getFormulaSize(getFormula2());
        littleEndianOutput.writeByte(getConditionType());
        littleEndianOutput.writeByte(getComparisonOperation());
        littleEndianOutput.writeShort(formulaSize);
        littleEndianOutput.writeShort(formulaSize2);
        int i5 = this.ext_formatting_length;
        if (i5 == 0) {
            littleEndianOutput.writeInt(0);
            littleEndianOutput.writeShort(0);
        } else {
            littleEndianOutput.writeInt(i5);
            serializeFormattingBlock(littleEndianOutput);
            littleEndianOutput.write(this.ext_formatting_data);
        }
        getFormula1().serializeTokens(littleEndianOutput);
        getFormula2().serializeTokens(littleEndianOutput);
        littleEndianOutput.writeShort(CFRuleBase.getFormulaSize(this.formula_scale));
        this.formula_scale.serializeTokens(littleEndianOutput);
        littleEndianOutput.writeByte(this.ext_opts);
        littleEndianOutput.writeShort(this.priority);
        littleEndianOutput.writeShort(this.template_type);
        littleEndianOutput.writeByte(this.template_param_length);
        littleEndianOutput.write(this.template_params);
        byte conditionType = getConditionType();
        if (conditionType == 3) {
            this.color_gradient.serialize(littleEndianOutput);
            return;
        }
        if (conditionType == 4) {
            this.data_bar.serialize(littleEndianOutput);
        } else if (conditionType == 5) {
            littleEndianOutput.write(this.filter_data);
        } else if (conditionType == 6) {
            this.multistate.serialize(littleEndianOutput);
        }
    }

    public void setParsedExpressionScale(Ptg[] ptgArr) {
        this.formula_scale = Formula.create(ptgArr);
    }

    public void setPriority(int i5) {
        this.priority = i5;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CF_RULE_12;
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, byte b, String str, String str2) {
        return new CFRule12Record((byte) 1, b, CFRuleBase.parseFormula(str, hSSFSheet), CFRuleBase.parseFormula(str2, hSSFSheet), null);
    }

    @Override // org.apache.poi.hssf.record.CFRuleBase, org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public CFRule12Record copy() {
        return new CFRule12Record(this);
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, byte b, String str, String str2, String str3) {
        return new CFRule12Record((byte) 1, b, CFRuleBase.parseFormula(str, hSSFSheet), CFRuleBase.parseFormula(str2, hSSFSheet), CFRuleBase.parseFormula(str3, hSSFSheet));
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, ExtendedColor extendedColor) {
        CFRule12Record cFRule12Record = new CFRule12Record((byte) 4, (byte) 0);
        DataBarFormatting dataBarFormattingCreateDataBarFormatting = cFRule12Record.createDataBarFormatting();
        dataBarFormattingCreateDataBarFormatting.setColor(extendedColor);
        dataBarFormattingCreateDataBarFormatting.setPercentMin((byte) 0);
        dataBarFormattingCreateDataBarFormatting.setPercentMax((byte) 100);
        DataBarThreshold dataBarThreshold = new DataBarThreshold();
        dataBarThreshold.setType(ConditionalFormattingThreshold.RangeType.MIN.id);
        dataBarFormattingCreateDataBarFormatting.setThresholdMin(dataBarThreshold);
        DataBarThreshold dataBarThreshold2 = new DataBarThreshold();
        dataBarThreshold2.setType(ConditionalFormattingThreshold.RangeType.MAX.id);
        dataBarFormattingCreateDataBarFormatting.setThresholdMax(dataBarThreshold2);
        return cFRule12Record;
    }

    private CFRule12Record(byte b, byte b6) {
        super(b, b6);
        setDefaults();
    }

    private CFRule12Record(byte b, byte b6, Ptg[] ptgArr, Ptg[] ptgArr2, Ptg[] ptgArr3) {
        super(b, b6, ptgArr, ptgArr2);
        setDefaults();
        this.formula_scale = Formula.create(ptgArr3);
    }

    public CFRule12Record(RecordInputStream recordInputStream) {
        this.futureHeader = new FtrHeader(recordInputStream);
        setConditionType(recordInputStream.readByte());
        setComparisonOperation(recordInputStream.readByte());
        int uShort = recordInputStream.readUShort();
        int uShort2 = recordInputStream.readUShort();
        int i5 = recordInputStream.readInt();
        this.ext_formatting_length = i5;
        this.ext_formatting_data = new byte[0];
        if (i5 == 0) {
            recordInputStream.readUShort();
        } else {
            long formatOptions = readFormatOptions(recordInputStream);
            int i6 = this.ext_formatting_length;
            if (formatOptions < i6) {
                byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(((long) i6) - formatOptions, HSSFWorkbook.getMaxRecordLength());
                this.ext_formatting_data = bArrSafelyAllocate;
                recordInputStream.readFully(bArrSafelyAllocate);
            }
        }
        setFormula1(Formula.read(uShort, recordInputStream));
        setFormula2(Formula.read(uShort2, recordInputStream));
        this.formula_scale = Formula.read(recordInputStream.readUShort(), recordInputStream);
        this.ext_opts = recordInputStream.readByte();
        this.priority = recordInputStream.readUShort();
        this.template_type = recordInputStream.readUShort();
        byte b = recordInputStream.readByte();
        this.template_param_length = b;
        if (b != 0 && b != 16) {
            CFRuleBase.LOG.atWarn().log("CF Rule v12 template params length should be 0 or 16, found {}", Unbox.box(this.template_param_length));
            recordInputStream.readRemainder();
        } else {
            byte[] bArrSafelyAllocate2 = IOUtils.safelyAllocate(b, HSSFWorkbook.getMaxRecordLength());
            this.template_params = bArrSafelyAllocate2;
            recordInputStream.readFully(bArrSafelyAllocate2);
        }
        byte conditionType = getConditionType();
        if (conditionType == 3) {
            this.color_gradient = new ColorGradientFormatting(recordInputStream);
            return;
        }
        if (conditionType == 4) {
            this.data_bar = new DataBarFormatting(recordInputStream);
        } else if (conditionType == 5) {
            this.filter_data = recordInputStream.readRemainder();
        } else if (conditionType == 6) {
            this.multistate = new IconMultiStateFormatting(recordInputStream);
        }
    }

    public static CFRule12Record create(HSSFSheet hSSFSheet, org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet) {
        int i5 = iconSet.num;
        Threshold[] thresholdArr = new Threshold[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            thresholdArr[i6] = new IconMultiStateThreshold();
        }
        CFRule12Record cFRule12Record = new CFRule12Record((byte) 6, (byte) 0);
        IconMultiStateFormatting iconMultiStateFormattingCreateMultiStateFormatting = cFRule12Record.createMultiStateFormatting();
        iconMultiStateFormattingCreateMultiStateFormatting.setIconSet(iconSet);
        iconMultiStateFormattingCreateMultiStateFormatting.setThresholds(thresholdArr);
        return cFRule12Record;
    }
}
