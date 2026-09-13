package org.apache.poi.ss.formula.udf;

import java.util.HashMap;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class IndexedUDFFinder extends AggregatingUDFFinder {
    private final HashMap<Integer, String> _funcMap;

    public IndexedUDFFinder(UDFFinder... uDFFinderArr) {
        super(uDFFinderArr);
        this._funcMap = new HashMap<>();
    }

    @Override // org.apache.poi.ss.formula.udf.AggregatingUDFFinder, org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        FreeRefFunction freeRefFunctionFindFunction = super.findFunction(str);
        if (freeRefFunctionFindFunction != null) {
            this._funcMap.put(Integer.valueOf(getFunctionIndex(str)), str);
        }
        return freeRefFunctionFindFunction;
    }

    public int getFunctionIndex(String str) {
        return str.hashCode();
    }

    public String getFunctionName(int i5) {
        return this._funcMap.get(Integer.valueOf(i5));
    }
}
