package org.apache.poi.ss.formula.eval;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RefListEval implements ValueEval {
    private final List<ValueEval> list = new ArrayList();

    public RefListEval(ValueEval valueEval, ValueEval valueEval2) {
        add(valueEval);
        add(valueEval2);
    }

    private void add(ValueEval valueEval) {
        if (valueEval instanceof RefListEval) {
            this.list.addAll(((RefListEval) valueEval).list);
        } else {
            this.list.add(valueEval);
        }
    }

    public List<ValueEval> getList() {
        return this.list;
    }
}
