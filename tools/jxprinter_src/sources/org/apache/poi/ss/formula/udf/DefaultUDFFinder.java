package org.apache.poi.ss.formula.udf;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultUDFFinder implements UDFFinder {
    private final Map<String, FreeRefFunction> _functionsByName;

    public DefaultUDFFinder(String[] strArr, FreeRefFunction[] freeRefFunctionArr) {
        int length = strArr.length;
        if (freeRefFunctionArr.length != length) {
            throw new IllegalArgumentException("Mismatch in number of function names and implementations");
        }
        HashMap map = new HashMap((length * 3) / 2);
        for (int i5 = 0; i5 < freeRefFunctionArr.length; i5++) {
            map.put(strArr[i5].toUpperCase(Locale.ROOT), freeRefFunctionArr[i5]);
        }
        this._functionsByName = map;
    }

    @Override // org.apache.poi.ss.formula.udf.UDFFinder
    public FreeRefFunction findFunction(String str) {
        return this._functionsByName.get(str.toUpperCase(Locale.ROOT));
    }
}
