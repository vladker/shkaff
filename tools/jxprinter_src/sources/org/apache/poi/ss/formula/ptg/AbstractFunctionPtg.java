package org.apache.poi.ss.formula.ptg;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractFunctionPtg extends OperationPtg {
    private static final short FUNCTION_INDEX_EXTERNAL = 255;
    public static final String FUNCTION_NAME_IF = "IF";
    private final short _functionIndex;
    private final int _numberOfArgs;
    private final byte[] paramClass;
    private final byte returnClass;

    public AbstractFunctionPtg(int i5, int i6, byte[] bArr, int i7) {
        this._numberOfArgs = i7;
        if (i5 < -32768 || i5 > 32767) {
            throw new RuntimeException(androidx.collection.a.i(i5, "functionIndex ", " cannot be cast to short"));
        }
        this._functionIndex = (short) i5;
        if (i6 < -128 || i6 > 127) {
            throw new RuntimeException(androidx.collection.a.i(i6, "pReturnClass ", " cannot be cast to byte"));
        }
        this.returnClass = (byte) i6;
        this.paramClass = bArr;
    }

    private static void appendArgs(StringBuilder sb, int i5, String[] strArr) {
        sb.append('(');
        for (int i6 = i5; i6 < strArr.length; i6++) {
            if (i6 > i5) {
                sb.append(',');
            }
            sb.append(strArr[i6]);
        }
        sb.append(")");
    }

    public static boolean isBuiltInFunctionName(String str) {
        return FunctionMetadataRegistry.lookupIndexByName(str.toUpperCase(Locale.ROOT)) >= 0;
    }

    public static short lookupIndex(String str) {
        short sLookupIndexByName = FunctionMetadataRegistry.lookupIndexByName(str.toUpperCase(Locale.ROOT));
        if (sLookupIndexByName < 0) {
            return (short) 255;
        }
        return sLookupIndexByName;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg, org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return this.returnClass;
    }

    public final short getFunctionIndex() {
        return this._functionIndex;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.a
            public final /* synthetic */ AbstractFunctionPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getFunctionIndex());
                    case 1:
                        return this.b.getName();
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfOperands());
                    case 3:
                        return Boolean.valueOf(this.b.isExternalFunction());
                    default:
                        return Byte.valueOf(this.b.getDefaultOperandClass());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.a
            public final /* synthetic */ AbstractFunctionPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getFunctionIndex());
                    case 1:
                        return this.b.getName();
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfOperands());
                    case 3:
                        return Boolean.valueOf(this.b.isExternalFunction());
                    default:
                        return Byte.valueOf(this.b.getDefaultOperandClass());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.a
            public final /* synthetic */ AbstractFunctionPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getFunctionIndex());
                    case 1:
                        return this.b.getName();
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfOperands());
                    case 3:
                        return Boolean.valueOf(this.b.isExternalFunction());
                    default:
                        return Byte.valueOf(this.b.getDefaultOperandClass());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.a
            public final /* synthetic */ AbstractFunctionPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getFunctionIndex());
                    case 1:
                        return this.b.getName();
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfOperands());
                    case 3:
                        return Boolean.valueOf(this.b.isExternalFunction());
                    default:
                        return Byte.valueOf(this.b.getDefaultOperandClass());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("functionIndex", supplier, "functionName", supplier2, "numberOfOperands", supplier3, "externalFunction", supplier4, "defaultOperandClass", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.a
            public final /* synthetic */ AbstractFunctionPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getFunctionIndex());
                    case 1:
                        return this.b.getName();
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfOperands());
                    case 3:
                        return Boolean.valueOf(this.b.isExternalFunction());
                    default:
                        return Byte.valueOf(this.b.getDefaultOperandClass());
                }
            }
        });
    }

    public final String getName() {
        return lookupName(this._functionIndex);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public final int getNumberOfOperands() {
        return this._numberOfArgs;
    }

    public final byte getParameterClass(int i5) {
        byte[] bArr = this.paramClass;
        return i5 >= bArr.length ? bArr[bArr.length - 1] : bArr[i5];
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public abstract int getSize();

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return false;
    }

    public final boolean isExternalFunction() {
        return this._functionIndex == 255;
    }

    public String lookupName(short s6) {
        return lookupName(s6, false);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toFormulaString() {
        return getName();
    }

    public final String lookupName(short s6, boolean z6) {
        if (s6 == 255) {
            return "#external#";
        }
        FunctionMetadata cetabFunctionByIndex = z6 ? FunctionMetadataRegistry.getCetabFunctionByIndex(s6) : FunctionMetadataRegistry.getFunctionByIndex(s6);
        if (cetabFunctionByIndex != null) {
            return cetabFunctionByIndex.getName();
        }
        throw new RuntimeException("bad function index (" + ((int) s6) + ", " + z6 + ")");
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (isExternalFunction()) {
            sb.append(strArr[0]);
            appendArgs(sb, 1, strArr);
        } else {
            sb.append(getName());
            appendArgs(sb, 0, strArr);
        }
        return sb.toString();
    }
}
