package org.apache.poi.ss.formula.function;

import A3.AbstractC0157z;
import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FunctionMetadata {
    private static final short FUNCTION_MAX_PARAMS = 30;
    private final int _index;
    private final int _maxParams;
    private final int _minParams;
    private final String _name;
    private final byte[] _parameterClassCodes;
    private final byte _returnClassCode;

    public FunctionMetadata(int i5, String str, int i6, int i7, byte b, byte[] bArr) {
        this._index = i5;
        this._name = str;
        this._minParams = i6;
        this._maxParams = i7;
        this._returnClassCode = b;
        this._parameterClassCodes = bArr == null ? null : (byte[]) bArr.clone();
    }

    public int getIndex() {
        return this._index;
    }

    public int getMaxParams() {
        return this._maxParams;
    }

    public int getMinParams() {
        return this._minParams;
    }

    public String getName() {
        return this._name;
    }

    public byte[] getParameterClassCodes() {
        return (byte[]) this._parameterClassCodes.clone();
    }

    public byte getReturnClassCode() {
        return this._returnClassCode;
    }

    public boolean hasFixedArgsLength() {
        return this._minParams == this._maxParams;
    }

    public boolean hasUnlimitedVarags() {
        return 30 == this._maxParams;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a.w(FunctionMetadata.class, sb, " [");
        sb.append(this._index);
        sb.append(" ");
        return AbstractC0157z.s(sb, this._name, "]");
    }
}
