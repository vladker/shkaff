package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
interface IEvaluationListener {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ICacheEntry {
        ValueEval getValue();
    }

    void onCacheHit(int i5, int i6, int i7, ValueEval valueEval);

    void onChangeFromBlankValue(int i5, int i6, int i7, EvaluationCell evaluationCell, ICacheEntry iCacheEntry);

    void onClearCachedValue(ICacheEntry iCacheEntry);

    void onClearDependentCachedValue(ICacheEntry iCacheEntry, int i5);

    void onClearWholeCache();

    void onEndEvaluate(ICacheEntry iCacheEntry, ValueEval valueEval);

    void onReadPlainValue(int i5, int i6, int i7, ICacheEntry iCacheEntry);

    void onStartEvaluate(EvaluationCell evaluationCell, ICacheEntry iCacheEntry);

    void sortDependentCachedValues(ICacheEntry[] iCacheEntryArr);
}
