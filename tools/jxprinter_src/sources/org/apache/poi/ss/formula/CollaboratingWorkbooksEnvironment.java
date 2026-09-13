package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class CollaboratingWorkbooksEnvironment {
    public static final CollaboratingWorkbooksEnvironment EMPTY = new CollaboratingWorkbooksEnvironment();
    private final WorkbookEvaluator[] _evaluators;
    private final Map<String, WorkbookEvaluator> _evaluatorsByName;
    private boolean _unhooked;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class WorkbookNotFoundException extends Exception {
        private static final long serialVersionUID = 8787784539811167941L;

        public WorkbookNotFoundException(String str) {
            super(str);
        }
    }

    private CollaboratingWorkbooksEnvironment() {
        this._evaluatorsByName = Collections.EMPTY_MAP;
        this._evaluators = new WorkbookEvaluator[0];
    }

    private static void hookNewEnvironment(WorkbookEvaluator[] workbookEvaluatorArr, CollaboratingWorkbooksEnvironment collaboratingWorkbooksEnvironment) {
        int length = workbookEvaluatorArr.length;
        IEvaluationListener evaluationListener = workbookEvaluatorArr[0].getEvaluationListener();
        for (WorkbookEvaluator workbookEvaluator : workbookEvaluatorArr) {
            if (evaluationListener != workbookEvaluator.getEvaluationListener()) {
                throw new RuntimeException("Workbook evaluators must all have the same evaluation listener");
            }
        }
        EvaluationCache evaluationCache = new EvaluationCache(evaluationListener);
        for (int i5 = 0; i5 < length; i5++) {
            workbookEvaluatorArr[i5].attachToEnvironment(collaboratingWorkbooksEnvironment, evaluationCache, i5);
        }
    }

    public static void setup(String[] strArr, WorkbookEvaluator[] workbookEvaluatorArr) {
        int length = strArr.length;
        if (workbookEvaluatorArr.length != length) {
            StringBuilder sbT = AbstractC0157z.t(length, "Number of workbook names is ", " but number of evaluators is ");
            sbT.append(workbookEvaluatorArr.length);
            throw new IllegalArgumentException(sbT.toString());
        }
        if (length < 1) {
            throw new IllegalArgumentException("Must provide at least one collaborating worbook");
        }
        new CollaboratingWorkbooksEnvironment(strArr, workbookEvaluatorArr, length);
    }

    public static void setupFormulaEvaluator(Map<String, FormulaEvaluator> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, FormulaEvaluator> entry : map.entrySet()) {
            String key = entry.getKey();
            FormulaEvaluator value = entry.getValue();
            if (!(value instanceof WorkbookEvaluatorProvider)) {
                throw new IllegalArgumentException("Formula Evaluator " + value + " provides no WorkbookEvaluator access");
            }
            map2.put(key, ((WorkbookEvaluatorProvider) value)._getWorkbookEvaluator());
        }
        setup(map2);
    }

    private static Map<String, WorkbookEvaluator> toUniqueMap(String[] strArr, WorkbookEvaluator[] workbookEvaluatorArr, int i5) {
        HashMap map = new HashMap((i5 * 3) / 2);
        for (int i6 = 0; i6 < i5; i6++) {
            String str = strArr[i6];
            WorkbookEvaluator workbookEvaluator = workbookEvaluatorArr[i6];
            if (map.containsKey(str)) {
                throw new IllegalArgumentException(AbstractC0157z.o("Duplicate workbook name '", str, "'"));
            }
            map.put(str, workbookEvaluator);
        }
        return map;
    }

    private void unhook() {
        WorkbookEvaluator[] workbookEvaluatorArr = this._evaluators;
        if (workbookEvaluatorArr.length < 1) {
            return;
        }
        for (WorkbookEvaluator workbookEvaluator : workbookEvaluatorArr) {
            workbookEvaluator.detachFromEnvironment();
        }
        this._unhooked = true;
    }

    private void unhookOldEnvironments(WorkbookEvaluator[] workbookEvaluatorArr) {
        HashSet hashSet = new HashSet();
        for (WorkbookEvaluator workbookEvaluator : workbookEvaluatorArr) {
            hashSet.add(workbookEvaluator.getEnvironment());
        }
        int size = hashSet.size();
        CollaboratingWorkbooksEnvironment[] collaboratingWorkbooksEnvironmentArr = new CollaboratingWorkbooksEnvironment[size];
        hashSet.toArray(collaboratingWorkbooksEnvironmentArr);
        for (int i5 = 0; i5 < size; i5++) {
            collaboratingWorkbooksEnvironmentArr[i5].unhook();
        }
    }

    public WorkbookEvaluator getWorkbookEvaluator(String str) throws WorkbookNotFoundException {
        if (this._unhooked) {
            throw new IllegalStateException("This environment has been unhooked");
        }
        WorkbookEvaluator workbookEvaluator = this._evaluatorsByName.get(str);
        if (workbookEvaluator != null) {
            return workbookEvaluator;
        }
        StringBuilder sb = new StringBuilder(256);
        sb.append("Could not resolve external workbook name '");
        sb.append(str);
        sb.append("'.");
        if (this._evaluators.length >= 1) {
            sb.append(" The following workbook names are valid: (");
            Iterator<String> it = this._evaluatorsByName.keySet().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                int i6 = i5 + 1;
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(Chars.QUOTE);
                sb.append(it.next());
                sb.append("'");
                i5 = i6;
            }
            sb.append(')');
        } else {
            sb.append(" Workbook environment has not been set up.");
        }
        throw new WorkbookNotFoundException(sb.toString());
    }

    private CollaboratingWorkbooksEnvironment(String[] strArr, WorkbookEvaluator[] workbookEvaluatorArr, int i5) {
        this(toUniqueMap(strArr, workbookEvaluatorArr, i5), workbookEvaluatorArr);
    }

    private CollaboratingWorkbooksEnvironment(Map<String, WorkbookEvaluator> map, WorkbookEvaluator[] workbookEvaluatorArr) {
        IdentityHashMap identityHashMap = new IdentityHashMap(workbookEvaluatorArr.length);
        for (Map.Entry<String, WorkbookEvaluator> entry : map.entrySet()) {
            String str = (String) identityHashMap.put(entry.getValue(), entry.getKey());
            if (str != null) {
                throw new IllegalArgumentException(AbstractC0157z.s(AbstractC0157z.y("Attempted to register same workbook under names '", str, "' and '"), entry.getKey(), "'"));
            }
        }
        unhookOldEnvironments(workbookEvaluatorArr);
        hookNewEnvironment(workbookEvaluatorArr, this);
        this._unhooked = false;
        this._evaluators = (WorkbookEvaluator[]) workbookEvaluatorArr.clone();
        this._evaluatorsByName = map;
    }

    public static void setup(Map<String, WorkbookEvaluator> map) {
        if (map.size() >= 1) {
            new CollaboratingWorkbooksEnvironment(map, (WorkbookEvaluator[]) map.values().toArray(new WorkbookEvaluator[0]));
            return;
        }
        throw new IllegalArgumentException("Must provide at least one collaborating worbook");
    }
}
