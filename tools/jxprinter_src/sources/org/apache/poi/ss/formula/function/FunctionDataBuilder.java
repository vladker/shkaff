package org.apache.poi.ss.formula.function;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class FunctionDataBuilder {
    private final Map<Integer, FunctionMetadata> _functionDataByIndex;
    private final Map<String, FunctionMetadata> _functionDataByName;
    private int _maxFunctionIndex = -1;
    private final Set<Integer> _mutatingFunctionIndexes = new HashSet();

    public FunctionDataBuilder(int i5) {
        int i6 = (i5 * 3) / 2;
        this._functionDataByName = new HashMap(i6);
        this._functionDataByIndex = new HashMap(i6);
    }

    public void add(int i5, String str, int i6, int i7, byte b, byte[] bArr, boolean z6) {
        FunctionMetadata functionMetadata = new FunctionMetadata(i5, str, i6, i7, b, bArr);
        Integer numValueOf = Integer.valueOf(i5);
        if (i5 > this._maxFunctionIndex) {
            this._maxFunctionIndex = i5;
        }
        FunctionMetadata functionMetadata2 = this._functionDataByName.get(str);
        if (functionMetadata2 != null) {
            if (!z6 || !this._mutatingFunctionIndexes.contains(numValueOf)) {
                throw new RuntimeException(AbstractC0157z.o("Multiple entries for function name '", str, "'"));
            }
            this._functionDataByIndex.remove(Integer.valueOf(functionMetadata2.getIndex()));
        }
        FunctionMetadata functionMetadata3 = this._functionDataByIndex.get(numValueOf);
        if (functionMetadata3 != null) {
            if (!z6 || !this._mutatingFunctionIndexes.contains(numValueOf)) {
                throw new RuntimeException(a.i(i5, "Multiple entries for function index (", ")"));
            }
            this._functionDataByName.remove(functionMetadata3.getName());
        }
        if (z6) {
            this._mutatingFunctionIndexes.add(numValueOf);
        }
        this._functionDataByIndex.put(numValueOf, functionMetadata);
        this._functionDataByName.put(str, functionMetadata);
    }

    public FunctionMetadataRegistry build() {
        int size = this._functionDataByName.size();
        FunctionMetadata[] functionMetadataArr = new FunctionMetadata[size];
        this._functionDataByName.values().toArray(functionMetadataArr);
        FunctionMetadata[] functionMetadataArr2 = new FunctionMetadata[this._maxFunctionIndex + 1];
        for (int i5 = 0; i5 < size; i5++) {
            FunctionMetadata functionMetadata = functionMetadataArr[i5];
            functionMetadataArr2[functionMetadata.getIndex()] = functionMetadata;
        }
        return new FunctionMetadataRegistry(functionMetadataArr2, this._functionDataByName);
    }
}
