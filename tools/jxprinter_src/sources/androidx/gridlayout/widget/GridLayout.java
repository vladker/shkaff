package androidx.gridlayout.widget;

import A3.AbstractC0157z;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.exifinterface.media.a;
import androidx.gridlayout.R;
import androidx.legacy.widget.Space;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class GridLayout extends ViewGroup {
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE;
    public static final Alignment BOTTOM;
    static final int CAN_STRETCH = 2;
    public static final Alignment CENTER;
    private static final int DEFAULT_ALIGNMENT_MODE = 1;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    private static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    static final boolean DEFAULT_ORDER_PRESERVED = true;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final Alignment END;
    public static final Alignment FILL;
    public static final int HORIZONTAL = 0;
    static final int INFLEXIBLE = 0;
    private static final Alignment LEADING;
    public static final Alignment LEFT;
    static final int MAX_SIZE = 100000;
    public static final Alignment RIGHT;
    public static final Alignment START;
    public static final Alignment TOP;
    private static final Alignment TRAILING;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH = 0;
    public static final int VERTICAL = 1;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;
    static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    static final Printer NO_PRINTER = new Printer() { // from class: androidx.gridlayout.widget.GridLayout.1
        @Override // android.util.Printer
        public void println(String str) {
        }
    };
    private static final int ORIENTATION = R.styleable.GridLayout_orientation;
    private static final int ROW_COUNT = R.styleable.GridLayout_rowCount;
    private static final int COLUMN_COUNT = R.styleable.GridLayout_columnCount;
    private static final int USE_DEFAULT_MARGINS = R.styleable.GridLayout_useDefaultMargins;
    private static final int ALIGNMENT_MODE = R.styleable.GridLayout_alignmentMode;
    private static final int ROW_ORDER_PRESERVED = R.styleable.GridLayout_rowOrderPreserved;
    private static final int COLUMN_ORDER_PRESERVED = R.styleable.GridLayout_columnOrderPreserved;
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.2
        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int i5, int i6) {
            return Integer.MIN_VALUE;
        }

        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        public String getDebugString() {
            return "UNDEFINED";
        }

        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        public int getGravityOffset(View view, int i5) {
            return Integer.MIN_VALUE;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Arc {
        public final Interval span;
        public boolean valid = true;
        public final MutableInt value;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.span = interval;
            this.value = mutableInt;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.span);
            sb.append(" ");
            sb.append(!this.valid ? "+>" : "->");
            sb.append(" ");
            sb.append(this.value);
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        public static <K, V> Assoc<K, V> of(Class<K> cls, Class<V> cls2) {
            return new Assoc<>(cls, cls2);
        }

        public PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.valueType, size);
            for (int i5 = 0; i5 < size; i5++) {
                objArr[i5] = get(i5).first;
                objArr2[i5] = get(i5).second;
            }
            return new PackedMap<>(objArr, objArr2);
        }

        public void put(K k6, V v6) {
            add(Pair.create(k6, v6));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class Axis {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int COMPLETE = 2;
        static final int NEW = 0;
        static final int PENDING = 1;
        public Arc[] arcs;
        PackedMap<Interval, MutableInt> backwardLinks;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean hasWeights;
        public final boolean horizontal;
        public int[] leadingMargins;
        public int[] locations;
        public int[] trailingMargins;
        public int definedCount = Integer.MIN_VALUE;
        private int maxIndex = Integer.MIN_VALUE;
        public boolean groupBoundsValid = false;
        public boolean forwardLinksValid = false;
        public boolean backwardLinksValid = false;
        public boolean leadingMarginsValid = false;
        public boolean trailingMarginsValid = false;
        public boolean arcsValid = false;
        public boolean locationsValid = false;
        public boolean hasWeightsValid = false;
        boolean orderPreserved = true;
        private MutableInt parentMin = new MutableInt(0);
        private MutableInt parentMax = new MutableInt(-100000);

        public Axis(boolean z6) {
            this.horizontal = z6;
        }

        private void addComponentSizes(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            int i5 = 0;
            while (true) {
                Interval[] intervalArr = packedMap.keys;
                if (i5 >= intervalArr.length) {
                    return;
                }
                include(list, intervalArr[i5], packedMap.values[i5], false);
                i5++;
            }
        }

        private String arcsToString(List<Arc> list) {
            StringBuilder sb;
            String string;
            String str = this.horizontal ? "x" : "y";
            StringBuilder sb2 = new StringBuilder();
            boolean z6 = true;
            for (Arc arc : list) {
                if (z6) {
                    z6 = false;
                } else {
                    sb2.append(", ");
                }
                Interval interval = arc.span;
                int i5 = interval.min;
                int i6 = interval.max;
                int i7 = arc.value.value;
                if (i5 < i6) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i6);
                    sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                    sb.append(str);
                    sb.append(i5);
                    string = a.q(sb, ">=", i7);
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(i5);
                    sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                    sb.append(str);
                    sb.append(i6);
                    sb.append("<=");
                    sb.append(-i7);
                    string = sb.toString();
                }
                sb2.append(string);
            }
            return sb2.toString();
        }

        private int calculateMaxIndex() {
            int childCount = GridLayout.this.getChildCount();
            int iMax = -1;
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i5));
                Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                iMax = Math.max(Math.max(Math.max(iMax, interval.min), interval.max), interval.size());
            }
            if (iMax == -1) {
                return Integer.MIN_VALUE;
            }
            return iMax;
        }

        private float calculateTotalWeight() {
            int childCount = GridLayout.this.getChildCount();
            float f6 = 0.0f;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = GridLayout.this.getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    f6 += (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                }
            }
            return f6;
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        private void computeGroupBounds() {
            for (Bounds bounds : this.groupBounds.values) {
                bounds.reset();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = GridLayout.this.getChildAt(i5);
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                boolean z6 = this.horizontal;
                Spec spec = z6 ? layoutParams.columnSpec : layoutParams.rowSpec;
                this.groupBounds.getValue(i5).include(GridLayout.this, childAt, spec, this, GridLayout.this.getMeasurementIncludingMargin(childAt, z6) + (spec.weight == 0.0f ? 0 : getDeltas()[i5]));
            }
        }

        private boolean computeHasWeights() {
            int childCount = GridLayout.this.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = GridLayout.this.getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    if ((this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight != 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void computeLinks(PackedMap<Interval, MutableInt> packedMap, boolean z6) {
            for (MutableInt mutableInt : packedMap.values) {
                mutableInt.reset();
            }
            Bounds[] boundsArr = getGroupBounds().values;
            for (int i5 = 0; i5 < boundsArr.length; i5++) {
                int size = boundsArr[i5].size(z6);
                MutableInt value = packedMap.getValue(i5);
                int i6 = value.value;
                if (!z6) {
                    size = -size;
                }
                value.value = Math.max(i6, size);
            }
        }

        private void computeLocations(int[] iArr) {
            if (hasWeights()) {
                solveAndDistributeSpace(iArr);
            } else {
                solve(iArr);
            }
            if (this.orderPreserved) {
                return;
            }
            int i5 = iArr[0];
            int length = iArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = iArr[i6] - i5;
            }
        }

        private void computeMargins(boolean z6) {
            int[] iArr = z6 ? this.leadingMargins : this.trailingMargins;
            int childCount = GridLayout.this.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = GridLayout.this.getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    boolean z7 = this.horizontal;
                    Interval interval = (z7 ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                    int i6 = z6 ? interval.min : interval.max;
                    iArr[i6] = Math.max(iArr[i6], GridLayout.this.getMargin1(childAt, z7, z6));
                }
            }
        }

        private Arc[] createArcs() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            addComponentSizes(arrayList, getForwardLinks());
            addComponentSizes(arrayList2, getBackwardLinks());
            if (this.orderPreserved) {
                int i5 = 0;
                while (i5 < getCount()) {
                    int i6 = i5 + 1;
                    include(arrayList, new Interval(i5, i6), new MutableInt(0));
                    i5 = i6;
                }
            }
            int count = getCount();
            include(arrayList, new Interval(0, count), this.parentMin, false);
            include(arrayList2, new Interval(count, 0), this.parentMax, false);
            return (Arc[]) GridLayout.append(topologicalSort(arrayList), topologicalSort(arrayList2));
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc assocOf = Assoc.of(Spec.class, Bounds.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i5));
                boolean z6 = this.horizontal;
                Spec spec = z6 ? layoutParams.columnSpec : layoutParams.rowSpec;
                assocOf.put(spec, spec.getAbsoluteAlignment(z6).getBounds());
            }
            return assocOf.pack();
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean z6) {
            Assoc assocOf = Assoc.of(Interval.class, MutableInt.class);
            Spec[] specArr = getGroupBounds().keys;
            int length = specArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                assocOf.put(z6 ? specArr[i5].span : specArr[i5].span.inverse(), new MutableInt());
            }
            return assocOf.pack();
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = true;
            }
            return this.backwardLinks;
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(true);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, true);
                this.forwardLinksValid = true;
            }
            return this.forwardLinks;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        private int getMeasure(int i5, int i6) {
            setParentConstraints(i5, i6);
            return size(getLocations());
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = true;
            }
            return this.hasWeights;
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z6) {
            if (interval.size() == 0) {
                return;
            }
            if (z6) {
                Iterator<Arc> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().span.equals(interval)) {
                        return;
                    }
                }
            }
            list.add(new Arc(interval, mutableInt));
        }

        private void init(int[] iArr) {
            Arrays.fill(iArr, 0);
        }

        private void logError(String str, Arc[] arcArr, boolean[] zArr) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i5 = 0; i5 < arcArr.length; i5++) {
                Arc arc = arcArr[i5];
                if (zArr[i5]) {
                    arrayList.add(arc);
                }
                if (!arc.valid) {
                    arrayList2.add(arc);
                }
            }
            Printer printer = GridLayout.this.mPrinter;
            StringBuilder sbX = AbstractC0157z.x(str, " constraints: ");
            sbX.append(arcsToString(arrayList));
            sbX.append(" are inconsistent; permanently removing: ");
            sbX.append(arcsToString(arrayList2));
            sbX.append(". ");
            printer.println(sbX.toString());
        }

        private boolean relax(int[] iArr, Arc arc) {
            if (!arc.valid) {
                return false;
            }
            Interval interval = arc.span;
            int i5 = interval.min;
            int i6 = interval.max;
            int i7 = iArr[i5] + arc.value.value;
            if (i7 <= iArr[i6]) {
                return false;
            }
            iArr[i6] = i7;
            return true;
        }

        private void setParentConstraints(int i5, int i6) {
            this.parentMin.value = i5;
            this.parentMax.value = -i6;
            this.locationsValid = false;
        }

        private void shareOutDelta(int i5, float f6) {
            Arrays.fill(this.deltas, 0);
            int childCount = GridLayout.this.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = GridLayout.this.getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    float f7 = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                    if (f7 != 0.0f) {
                        int iRound = Math.round((i5 * f7) / f6);
                        this.deltas[i6] = iRound;
                        i5 -= iRound;
                        f6 -= f7;
                    }
                }
            }
        }

        private int size(int[] iArr) {
            return iArr[getCount()];
        }

        private boolean solve(Arc[] arcArr, int[] iArr) {
            return solve(arcArr, iArr, true);
        }

        private void solveAndDistributeSpace(int[] iArr) {
            Arrays.fill(getDeltas(), 0);
            solve(iArr);
            boolean z6 = true;
            int childCount = (GridLayout.this.getChildCount() * this.parentMin.value) + 1;
            if (childCount < 2) {
                return;
            }
            float fCalculateTotalWeight = calculateTotalWeight();
            int i5 = -1;
            int i6 = 0;
            while (i6 < childCount) {
                int i7 = (int) ((((long) i6) + ((long) childCount)) / 2);
                invalidateValues();
                shareOutDelta(i7, fCalculateTotalWeight);
                boolean zSolve = solve(getArcs(), iArr, false);
                if (zSolve) {
                    i6 = i7 + 1;
                    i5 = i7;
                } else {
                    childCount = i7;
                }
                z6 = zSolve;
            }
            if (i5 <= 0 || z6) {
                return;
            }
            invalidateValues();
            shareOutDelta(i5, fCalculateTotalWeight);
            solve(iArr);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.gridlayout.widget.GridLayout$Axis$1] */
        private Arc[] topologicalSort(Arc[] arcArr) {
            return new Object(arcArr) { // from class: androidx.gridlayout.widget.GridLayout.Axis.1
                static final /* synthetic */ boolean $assertionsDisabled = false;
                Arc[][] arcsByVertex;
                int cursor;
                Arc[] result;
                final /* synthetic */ Arc[] val$arcs;
                int[] visited;

                {
                    this.val$arcs = arcArr;
                    Arc[] arcArr2 = new Arc[arcArr.length];
                    this.result = arcArr2;
                    this.cursor = arcArr2.length - 1;
                    this.arcsByVertex = Axis.this.groupArcsByFirstVertex(arcArr);
                    this.visited = new int[Axis.this.getCount() + 1];
                }

                public Arc[] sort() {
                    int length = this.arcsByVertex.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        walk(i5);
                    }
                    return this.result;
                }

                public void walk(int i5) {
                    int[] iArr = this.visited;
                    if (iArr[i5] != 0) {
                        return;
                    }
                    iArr[i5] = 1;
                    for (Arc arc : this.arcsByVertex[i5]) {
                        walk(arc.span.max);
                        Arc[] arcArr2 = this.result;
                        int i6 = this.cursor;
                        this.cursor = i6 - 1;
                        arcArr2[i6] = arc;
                    }
                    this.visited[i5] = 2;
                }
            }.sort();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = true;
            }
            return this.arcs;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = true;
            }
            return this.groupBounds;
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[getCount() + 1];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(true);
                this.leadingMarginsValid = true;
            }
            return this.leadingMargins;
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[getCount() + 1];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = true;
            }
            return this.locations;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[getCount() + 1];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = true;
            }
            return this.trailingMargins;
        }

        public Arc[][] groupArcsByFirstVertex(Arc[] arcArr) {
            int count = getCount() + 1;
            Arc[][] arcArr2 = new Arc[count][];
            int[] iArr = new int[count];
            for (Arc arc : arcArr) {
                int i5 = arc.span.min;
                iArr[i5] = iArr[i5] + 1;
            }
            for (int i6 = 0; i6 < count; i6++) {
                arcArr2[i6] = new Arc[iArr[i6]];
            }
            Arrays.fill(iArr, 0);
            for (Arc arc2 : arcArr) {
                int i7 = arc2.span.min;
                Arc[] arcArr3 = arcArr2[i7];
                int i8 = iArr[i7];
                iArr[i7] = i8 + 1;
                arcArr3[i8] = arc2;
            }
            return arcArr2;
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void layout(int i5) {
            setParentConstraints(i5, i5);
            getLocations();
        }

        public void setCount(int i5) {
            if (i5 != Integer.MIN_VALUE && i5 < getMaxIndex()) {
                GridLayout.handleInvalidParams((this.horizontal ? "column" : "row").concat("Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child"));
            }
            this.definedCount = i5;
        }

        public void setOrderPreserved(boolean z6) {
            this.orderPreserved = z6;
            invalidateStructure();
        }

        private boolean solve(Arc[] arcArr, int[] iArr, boolean z6) {
            String str = this.horizontal ? "horizontal" : "vertical";
            int count = getCount() + 1;
            boolean[] zArr = null;
            for (int i5 = 0; i5 < arcArr.length; i5++) {
                init(iArr);
                for (int i6 = 0; i6 < count; i6++) {
                    boolean zRelax = false;
                    for (Arc arc : arcArr) {
                        zRelax |= relax(iArr, arc);
                    }
                    if (!zRelax) {
                        if (zArr != null) {
                            logError(str, arcArr, zArr);
                        }
                        return true;
                    }
                }
                if (!z6) {
                    return false;
                }
                boolean[] zArr2 = new boolean[arcArr.length];
                for (int i7 = 0; i7 < count; i7++) {
                    int length = arcArr.length;
                    for (int i8 = 0; i8 < length; i8++) {
                        zArr2[i8] = zArr2[i8] | relax(iArr, arcArr[i8]);
                    }
                }
                if (i5 == 0) {
                    zArr = zArr2;
                }
                for (int i9 = 0; i9 < arcArr.length; i9++) {
                    if (zArr2[i9]) {
                        Arc arc2 = arcArr[i9];
                        Interval interval = arc2.span;
                        if (interval.min >= interval.max) {
                            arc2.valid = false;
                            break;
                        }
                    }
                }
            }
            return true;
        }

        private Arc[] topologicalSort(List<Arc> list) {
            return topologicalSort((Arc[]) list.toArray(new Arc[list.size()]));
        }

        public int getMeasure(int i5) {
            int mode = View.MeasureSpec.getMode(i5);
            int size = View.MeasureSpec.getSize(i5);
            if (mode == Integer.MIN_VALUE) {
                return getMeasure(0, size);
            }
            if (mode == 0) {
                return getMeasure(0, 100000);
            }
            if (mode != 1073741824) {
                return 0;
            }
            return getMeasure(size, size);
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt) {
            include(list, interval, mutableInt, true);
        }

        private boolean solve(int[] iArr) {
            return solve(getArcs(), iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Interval {
        public final int max;
        public final int min;

        public Interval(int i5, int i6) {
            this.min = i5;
            this.max = i6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Interval.class != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.max == interval.max && this.min == interval.min;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        public Interval inverse() {
            return new Interval(this.max, this.min);
        }

        public int size() {
            return this.max - this.min;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.min);
            sb.append(", ");
            return AbstractC0157z.l("]", this.max, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        public PackedMap(K[] kArr, V[] vArr) {
            int[] iArrCreateIndex = createIndex(kArr);
            this.index = iArrCreateIndex;
            this.keys = (K[]) compact(kArr, iArrCreateIndex);
            this.values = (V[]) compact(vArr, iArrCreateIndex);
        }

        private static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + 1));
            for (int i5 = 0; i5 < length; i5++) {
                kArr2[iArr[i5]] = kArr[i5];
            }
            return kArr2;
        }

        private static <K> int[] createIndex(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            HashMap map = new HashMap();
            for (int i5 = 0; i5 < length; i5++) {
                K k6 = kArr[i5];
                Integer numValueOf = (Integer) map.get(k6);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(map.size());
                    map.put(k6, numValueOf);
                }
                iArr[i5] = numValueOf.intValue();
            }
            return iArr;
        }

        public V getValue(int i5) {
            return this.values[this.index[i5]];
        }
    }

    static {
        Alignment alignment = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.3
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i5, int i6) {
                return 0;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "LEADING";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i5) {
                return 0;
            }
        };
        LEADING = alignment;
        Alignment alignment2 = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.4
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "TRAILING";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i5) {
                return i5;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i5, int i6) {
                return i5;
            }
        };
        TRAILING = alignment2;
        TOP = alignment;
        BOTTOM = alignment2;
        START = alignment;
        END = alignment2;
        LEFT = createSwitchingAlignment(alignment, alignment2);
        RIGHT = createSwitchingAlignment(alignment2, alignment);
        CENTER = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.6
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i5, int i6) {
                return i5 >> 1;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "CENTER";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i5) {
                return i5 >> 1;
            }
        };
        BASELINE = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.7
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i5, int i6) {
                if (view.getVisibility() == 8) {
                    return 0;
                }
                int baseline = view.getBaseline();
                if (baseline == -1) {
                    return Integer.MIN_VALUE;
                }
                return baseline;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public Bounds getBounds() {
                return new Bounds() { // from class: androidx.gridlayout.widget.GridLayout.7.1
                    private int size;

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    public int getOffset(GridLayout gridLayout, View view, Alignment alignment3, int i5, boolean z6) {
                        return Math.max(0, super.getOffset(gridLayout, view, alignment3, i5, z6));
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    public void include(int i5, int i6) {
                        super.include(i5, i6);
                        this.size = Math.max(this.size, i5 + i6);
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    public void reset() {
                        super.reset();
                        this.size = Integer.MIN_VALUE;
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    public int size(boolean z6) {
                        return Math.max(super.size(z6), this.size);
                    }
                };
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "BASELINE";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i5) {
                return 0;
            }
        };
        FILL = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.8
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i5, int i6) {
                return Integer.MIN_VALUE;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "FILL";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i5) {
                return 0;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getSizeInCell(View view, int i5, int i6) {
                return i6;
            }
        };
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(R.dimen.default_gap);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout);
        try {
            setRowCount(typedArrayObtainStyledAttributes.getInt(ROW_COUNT, Integer.MIN_VALUE));
            setColumnCount(typedArrayObtainStyledAttributes.getInt(COLUMN_COUNT, Integer.MIN_VALUE));
            setOrientation(typedArrayObtainStyledAttributes.getInt(ORIENTATION, 0));
            setUseDefaultMargins(typedArrayObtainStyledAttributes.getBoolean(USE_DEFAULT_MARGINS, false));
            setAlignmentMode(typedArrayObtainStyledAttributes.getInt(ALIGNMENT_MODE, 1));
            setRowOrderPreserved(typedArrayObtainStyledAttributes.getBoolean(ROW_ORDER_PRESERVED, true));
            setColumnOrderPreserved(typedArrayObtainStyledAttributes.getBoolean(COLUMN_ORDER_PRESERVED, true));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int adjust(int i5, int i6) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6 + i5), View.MeasureSpec.getMode(i5));
    }

    public static <T> T[] append(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static boolean canStretch(int i5) {
        return (i5 & 2) != 0;
    }

    private void checkLayoutParams(LayoutParams layoutParams, boolean z6) {
        String str = z6 ? "column" : "row";
        Interval interval = (z6 ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        int i5 = interval.min;
        if (i5 != Integer.MIN_VALUE && i5 < 0) {
            handleInvalidParams(str.concat(" indices must be positive"));
        }
        int i6 = (z6 ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i6 != Integer.MIN_VALUE) {
            if (interval.max > i6) {
                handleInvalidParams(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (interval.size() > i6) {
                handleInvalidParams(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    private static int clip(Interval interval, boolean z6, int i5) {
        int size = interval.size();
        if (i5 == 0) {
            return size;
        }
        return Math.min(size, i5 - (z6 ? Math.min(interval.min, i5) : 0));
    }

    private int computeLayoutParamsHashCode() {
        int childCount = getChildCount();
        int iHashCode = 1;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                iHashCode = ((LayoutParams) childAt.getLayoutParams()).hashCode() + (iHashCode * 31);
            }
        }
        return iHashCode;
    }

    private void consistencyCheck() {
        int i5 = this.mLastLayoutParamsHashCode;
        if (i5 == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (i5 != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    private static Alignment createSwitchingAlignment(final Alignment alignment, final Alignment alignment2) {
        return new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.5
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i5, int i6) {
                return (ViewCompat.getLayoutDirection(view) == 1 ? alignment2 : alignment).getAlignmentValue(view, i5, i6);
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "SWITCHING[L:" + alignment.getDebugString() + ", R:" + alignment2.getDebugString() + "]";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i5) {
                return (ViewCompat.getLayoutDirection(view) == 1 ? alignment2 : alignment).getGravityOffset(view, i5);
            }
        };
    }

    private void drawLine(Canvas canvas, int i5, int i6, int i7, int i8, Paint paint) {
        if (!isLayoutRtlCompat()) {
            canvas.drawLine(i5, i6, i7, i8, paint);
        } else {
            int width = getWidth();
            canvas.drawLine(width - i5, i6, width - i7, i8, paint);
        }
    }

    private static boolean fits(int[] iArr, int i5, int i6, int i7) {
        if (i7 > iArr.length) {
            return false;
        }
        while (i6 < i7) {
            if (iArr[i6] > i5) {
                return false;
            }
            i6++;
        }
        return true;
    }

    public static Alignment getAlignment(int i5, boolean z6) {
        int i6 = (i5 & (z6 ? 7 : 112)) >> (z6 ? 0 : 4);
        if (i6 == 1) {
            return CENTER;
        }
        if (i6 == 3) {
            return z6 ? LEFT : TOP;
        }
        if (i6 == 5) {
            return z6 ? RIGHT : BOTTOM;
        }
        if (i6 == 7) {
            return FILL;
        }
        if (i6 != 8388611) {
            return i6 != 8388613 ? UNDEFINED_ALIGNMENT : END;
        }
        return START;
    }

    private int getDefaultMargin(View view, boolean z6, boolean z7) {
        if (view.getClass() == Space.class || view.getClass() == android.widget.Space.class) {
            return 0;
        }
        return this.mDefaultGap / 2;
    }

    private int getMargin(View view, boolean z6, boolean z7) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, z6, z7);
        }
        Axis axis = z6 ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] leadingMargins = z7 ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams layoutParams = getLayoutParams(view);
        Interval interval = (z6 ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        return leadingMargins[z7 ? interval.min : interval.max];
    }

    private int getMeasurement(View view, boolean z6) {
        return z6 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int getTotalMargin(View view, boolean z6) {
        return getMargin(view, z6, true) + getMargin(view, z6, false);
    }

    public static void handleInvalidParams(String str) {
        throw new IllegalArgumentException(androidx.collection.a.n(str, ". "));
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        Axis axis = this.mHorizontalAxis;
        if (axis != null) {
            axis.invalidateStructure();
        }
        Axis axis2 = this.mVerticalAxis;
        if (axis2 != null) {
            axis2.invalidateStructure();
        }
        invalidateValues();
    }

    private void invalidateValues() {
        Axis axis = this.mHorizontalAxis;
        if (axis == null || this.mVerticalAxis == null) {
            return;
        }
        axis.invalidateValues();
        this.mVerticalAxis.invalidateValues();
    }

    private boolean isLayoutRtlCompat() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public static int max2(int[] iArr, int i5) {
        for (int i6 : iArr) {
            i5 = Math.max(i5, i6);
        }
        return i5;
    }

    private void measureChildWithMargins2(View view, int i5, int i6, int i7, int i8) {
        view.measure(ViewGroup.getChildMeasureSpec(i5, getTotalMargin(view, true), i7), ViewGroup.getChildMeasureSpec(i6, getTotalMargin(view, false), i8));
    }

    private void measureChildrenWithMargins(int i5, int i6, boolean z6) {
        int i7;
        int i8;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                i7 = i5;
                i8 = i6;
            } else {
                LayoutParams layoutParams = getLayoutParams(childAt);
                if (z6) {
                    i7 = i5;
                    i8 = i6;
                    measureChildWithMargins2(childAt, i7, i8, ((ViewGroup.MarginLayoutParams) layoutParams).width, ((ViewGroup.MarginLayoutParams) layoutParams).height);
                } else {
                    i7 = i5;
                    i8 = i6;
                    boolean z7 = this.mOrientation == 0;
                    Spec spec = z7 ? layoutParams.columnSpec : layoutParams.rowSpec;
                    if (spec.getAbsoluteAlignment(z7) == FILL) {
                        Interval interval = spec.span;
                        int[] locations = (z7 ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                        int totalMargin = (locations[interval.max] - locations[interval.min]) - getTotalMargin(childAt, z7);
                        if (z7) {
                            measureChildWithMargins2(childAt, i7, i8, totalMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height);
                        } else {
                            measureChildWithMargins2(childAt, i7, i8, ((ViewGroup.MarginLayoutParams) layoutParams).width, totalMargin);
                        }
                    }
                }
            }
            i9++;
            i5 = i7;
            i6 = i8;
        }
    }

    private static void procrusteanFill(int[] iArr, int i5, int i6, int i7) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i5, length), Math.min(i6, length), i7);
    }

    private static void setCellGroup(LayoutParams layoutParams, int i5, int i6, int i7, int i8) {
        layoutParams.setRowSpecSpan(new Interval(i5, i6 + i5));
        layoutParams.setColumnSpecSpan(new Interval(i7, i8 + i7));
    }

    public static Spec spec(int i5, int i6, Alignment alignment, float f6) {
        return new Spec(i5 != Integer.MIN_VALUE, i5, i6, alignment, f6);
    }

    private void validateLayoutParams() {
        boolean z6 = this.mOrientation == 0;
        int i5 = (z6 ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i5 == Integer.MIN_VALUE) {
            i5 = 0;
        }
        int[] iArr = new int[i5];
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i8).getLayoutParams();
            Spec spec = z6 ? layoutParams.rowSpec : layoutParams.columnSpec;
            Interval interval = spec.span;
            boolean z7 = spec.startDefined;
            int size = interval.size();
            if (z7) {
                i6 = interval.min;
            }
            Spec spec2 = z6 ? layoutParams.columnSpec : layoutParams.rowSpec;
            Interval interval2 = spec2.span;
            boolean z8 = spec2.startDefined;
            int iClip = clip(interval2, z8, i5);
            if (z8) {
                i7 = interval2.min;
            }
            if (i5 != 0) {
                if (!z7 || !z8) {
                    while (true) {
                        int i9 = i7 + iClip;
                        if (fits(iArr, i6, i7, i9)) {
                            break;
                        }
                        if (z8) {
                            i6++;
                        } else if (i9 <= i5) {
                            i7++;
                        } else {
                            i6++;
                            i7 = 0;
                        }
                    }
                }
                procrusteanFill(iArr, i7, i7 + iClip, i6 + size);
            }
            if (z6) {
                setCellGroup(layoutParams, i6, size, i7, iClip);
            } else {
                setCellGroup(layoutParams, i7, iClip, i6, size);
            }
            i7 += iClip;
        }
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    public final LayoutParams getLayoutParams(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    public int getMargin1(View view, boolean z6, boolean z7) {
        int i5;
        LayoutParams layoutParams = getLayoutParams(view);
        if (z6) {
            i5 = z7 ? ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin : ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i5 = z7 ? ((ViewGroup.MarginLayoutParams) layoutParams).topMargin : ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i5 == Integer.MIN_VALUE ? getDefaultMargin(view, layoutParams, z6, z7) : i5;
    }

    public final int getMeasurementIncludingMargin(View view, boolean z6) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return getMeasurement(view, z6) + getTotalMargin(view, z6);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        GridLayout gridLayout = this;
        gridLayout.consistencyCheck();
        int i12 = i7 - i5;
        int paddingLeft = gridLayout.getPaddingLeft();
        int paddingTop = gridLayout.getPaddingTop();
        int paddingRight = gridLayout.getPaddingRight();
        int paddingBottom = gridLayout.getPaddingBottom();
        gridLayout.mHorizontalAxis.layout((i12 - paddingLeft) - paddingRight);
        gridLayout.mVerticalAxis.layout(((i8 - i6) - paddingTop) - paddingBottom);
        int[] locations = gridLayout.mHorizontalAxis.getLocations();
        int[] locations2 = gridLayout.mVerticalAxis.getLocations();
        int childCount = gridLayout.getChildCount();
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = gridLayout.getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                i9 = i12;
                i10 = paddingLeft;
                i11 = paddingTop;
            } else {
                LayoutParams layoutParams = gridLayout.getLayoutParams(childAt);
                Spec spec = layoutParams.columnSpec;
                Spec spec2 = layoutParams.rowSpec;
                Interval interval = spec.span;
                Interval interval2 = spec2.span;
                int i14 = locations[interval.min];
                int i15 = locations2[interval2.min];
                int i16 = locations[interval.max] - i14;
                int i17 = locations2[interval2.max] - i15;
                int measurement = gridLayout.getMeasurement(childAt, true);
                i9 = i12;
                int measurement2 = gridLayout.getMeasurement(childAt, false);
                Alignment absoluteAlignment = spec.getAbsoluteAlignment(true);
                Alignment absoluteAlignment2 = spec2.getAbsoluteAlignment(false);
                Bounds value = gridLayout.mHorizontalAxis.getGroupBounds().getValue(i13);
                Bounds value2 = gridLayout.mVerticalAxis.getGroupBounds().getValue(i13);
                i10 = paddingLeft;
                int gravityOffset = absoluteAlignment.getGravityOffset(childAt, i16 - value.size(true));
                int gravityOffset2 = absoluteAlignment2.getGravityOffset(childAt, i17 - value2.size(true));
                int margin = gridLayout.getMargin(childAt, true, true);
                int margin2 = gridLayout.getMargin(childAt, false, true);
                int margin3 = gridLayout.getMargin(childAt, true, false);
                int i18 = margin + margin3;
                int margin4 = margin2 + gridLayout.getMargin(childAt, false, false);
                int offset = value.getOffset(gridLayout, childAt, absoluteAlignment, measurement + i18, true);
                i11 = paddingTop;
                int offset2 = value2.getOffset(this, childAt, absoluteAlignment2, measurement2 + margin4, false);
                int sizeInCell = absoluteAlignment.getSizeInCell(childAt, measurement, i16 - i18);
                int sizeInCell2 = absoluteAlignment2.getSizeInCell(childAt, measurement2, i17 - margin4);
                int i19 = i14 + gravityOffset + offset;
                int i20 = !isLayoutRtlCompat() ? i10 + margin + i19 : (((i9 - sizeInCell) - paddingRight) - margin3) - i19;
                int i21 = i11 + i15 + gravityOffset2 + offset2 + margin2;
                if (sizeInCell != childAt.getMeasuredWidth() || sizeInCell2 != childAt.getMeasuredHeight()) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(sizeInCell, 1073741824), View.MeasureSpec.makeMeasureSpec(sizeInCell2, 1073741824));
                }
                childAt.layout(i20, i21, sizeInCell + i20, sizeInCell2 + i21);
            }
            i13++;
            gridLayout = this;
            paddingTop = i11;
            i12 = i9;
            paddingLeft = i10;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        int measure;
        int measure2;
        consistencyCheck();
        invalidateValues();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iAdjust = adjust(i5, -paddingRight);
        int iAdjust2 = adjust(i6, -paddingBottom);
        measureChildrenWithMargins(iAdjust, iAdjust2, true);
        if (this.mOrientation == 0) {
            measure = this.mHorizontalAxis.getMeasure(iAdjust);
            measureChildrenWithMargins(iAdjust, iAdjust2, false);
            measure2 = this.mVerticalAxis.getMeasure(iAdjust2);
        } else {
            int measure3 = this.mVerticalAxis.getMeasure(iAdjust2);
            measureChildrenWithMargins(iAdjust, iAdjust2, false);
            measure = this.mHorizontalAxis.getMeasure(iAdjust);
            measure2 = measure3;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(measure + paddingRight, getSuggestedMinimumWidth()), i5, 0), View.resolveSizeAndState(Math.max(measure2 + paddingBottom, getSuggestedMinimumHeight()), i6, 0));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        invalidateStructure();
    }

    public void setAlignmentMode(int i5) {
        this.mAlignmentMode = i5;
        requestLayout();
    }

    public void setColumnCount(int i5) {
        this.mHorizontalAxis.setCount(i5);
        invalidateStructure();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z6) {
        this.mHorizontalAxis.setOrderPreserved(z6);
        invalidateStructure();
        requestLayout();
    }

    public void setOrientation(int i5) {
        if (this.mOrientation != i5) {
            this.mOrientation = i5;
            invalidateStructure();
            requestLayout();
        }
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = NO_PRINTER;
        }
        this.mPrinter = printer;
    }

    public void setRowCount(int i5) {
        this.mVerticalAxis.setCount(i5);
        invalidateStructure();
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z6) {
        this.mVerticalAxis.setOrderPreserved(z6);
        invalidateStructure();
        requestLayout();
    }

    public void setUseDefaultMargins(boolean z6) {
        this.mUseDefaultMargins = z6;
        requestLayout();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        public Bounds() {
            reset();
        }

        public int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i5, boolean z6) {
            return this.before - alignment.getAlignmentValue(view, i5, ViewGroupCompat.getLayoutMode(gridLayout));
        }

        public void include(int i5, int i6) {
            this.before = Math.max(this.before, i5);
            this.after = Math.max(this.after, i6);
        }

        public void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        public int size(boolean z6) {
            if (z6 || !GridLayout.canStretch(this.flexibility)) {
                return this.before + this.after;
            }
            return 100000;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Bounds{before=");
            sb.append(this.before);
            sb.append(", after=");
            return AbstractC0157z.p(sb, this.after, '}');
        }

        public final void include(GridLayout gridLayout, View view, Spec spec, Axis axis, int i5) {
            this.flexibility &= spec.getFlexibility();
            int alignmentValue = spec.getAbsoluteAlignment(axis.horizontal).getAlignmentValue(view, i5, ViewGroupCompat.getLayoutMode(gridLayout));
            include(alignmentValue, i5 - alignmentValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.value);
        }

        public MutableInt(int i5) {
            this.value = i5;
        }
    }

    public static Spec spec(int i5, Alignment alignment, float f6) {
        return spec(i5, 1, alignment, f6);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public static Spec spec(int i5, int i6, float f6) {
        return spec(i5, i6, UNDEFINED_ALIGNMENT, f6);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private int getDefaultMargin(View view, boolean z6, boolean z7, boolean z8) {
        return getDefaultMargin(view, z7, z8);
    }

    public static Spec spec(int i5, float f6) {
        return spec(i5, 1, f6);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Spec {
        static final float DEFAULT_WEIGHT = 0.0f;
        static final Spec UNDEFINED = GridLayout.spec(Integer.MIN_VALUE);
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        final float weight;

        private Spec(boolean z6, Interval interval, Alignment alignment, float f6) {
            this.startDefined = z6;
            this.span = interval;
            this.alignment = alignment;
            this.weight = f6;
        }

        public final Spec copyWriteAlignment(Alignment alignment) {
            return new Spec(this.startDefined, this.span, alignment, this.weight);
        }

        public final Spec copyWriteSpan(Interval interval) {
            return new Spec(this.startDefined, interval, this.alignment, this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Spec spec = (Spec) obj;
            return this.alignment.equals(spec.alignment) && this.span.equals(spec.span);
        }

        public Alignment getAbsoluteAlignment(boolean z6) {
            Alignment alignment = this.alignment;
            if (alignment != GridLayout.UNDEFINED_ALIGNMENT) {
                return alignment;
            }
            if (this.weight == 0.0f) {
                return z6 ? GridLayout.START : GridLayout.BASELINE;
            }
            return GridLayout.FILL;
        }

        public final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public int hashCode() {
            return this.alignment.hashCode() + (this.span.hashCode() * 31);
        }

        public Spec(boolean z6, int i5, int i6, Alignment alignment, float f6) {
            this(z6, new Interval(i5, i6 + i5), alignment, f6);
        }
    }

    private int getDefaultMargin(View view, LayoutParams layoutParams, boolean z6, boolean z7) {
        boolean z8;
        boolean z9 = false;
        if (!this.mUseDefaultMargins) {
            return 0;
        }
        Spec spec = z6 ? layoutParams.columnSpec : layoutParams.rowSpec;
        Axis axis = z6 ? this.mHorizontalAxis : this.mVerticalAxis;
        Interval interval = spec.span;
        if (z6 && isLayoutRtlCompat()) {
            z8 = !z7;
        } else {
            z8 = z7;
        }
        if (!z8 ? interval.max == axis.getCount() : interval.min == 0) {
            z9 = true;
        }
        return getDefaultMargin(view, z9, z6, z7);
    }

    public static Spec spec(int i5, int i6, Alignment alignment) {
        return spec(i5, i6, alignment, 0.0f);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int BOTTOM_MARGIN;
        private static final int COLUMN;
        private static final int COLUMN_SPAN;
        private static final int COLUMN_WEIGHT;
        private static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        private static final int DEFAULT_HEIGHT = -2;
        private static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        private static final int DEFAULT_ROW = Integer.MIN_VALUE;
        private static final Interval DEFAULT_SPAN;
        private static final int DEFAULT_SPAN_SIZE;
        private static final int DEFAULT_WIDTH = -2;
        private static final int GRAVITY;
        private static final int LEFT_MARGIN;
        private static final int MARGIN;
        private static final int RIGHT_MARGIN;
        private static final int ROW;
        private static final int ROW_SPAN;
        private static final int ROW_WEIGHT;
        private static final int TOP_MARGIN;
        public Spec columnSpec;
        public Spec rowSpec;

        static {
            Interval interval = new Interval(Integer.MIN_VALUE, -2147483647);
            DEFAULT_SPAN = interval;
            DEFAULT_SPAN_SIZE = interval.size();
            MARGIN = R.styleable.GridLayout_Layout_android_layout_margin;
            LEFT_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginLeft;
            TOP_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginTop;
            RIGHT_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginRight;
            BOTTOM_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginBottom;
            COLUMN = R.styleable.GridLayout_Layout_layout_column;
            COLUMN_SPAN = R.styleable.GridLayout_Layout_layout_columnSpan;
            COLUMN_WEIGHT = R.styleable.GridLayout_Layout_layout_columnWeight;
            ROW = R.styleable.GridLayout_Layout_layout_row;
            ROW_SPAN = R.styleable.GridLayout_Layout_layout_rowSpan;
            ROW_WEIGHT = R.styleable.GridLayout_Layout_layout_rowWeight;
            GRAVITY = R.styleable.GridLayout_Layout_layout_gravity;
        }

        private LayoutParams(int i5, int i6, int i7, int i8, int i9, int i10, Spec spec, Spec spec2) {
            super(i5, i6);
            Spec spec3 = Spec.UNDEFINED;
            this.rowSpec = spec3;
            this.columnSpec = spec3;
            setMargins(i7, i8, i9, i10);
            this.rowSpec = spec;
            this.columnSpec = spec2;
        }

        private void init(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int i5 = typedArrayObtainStyledAttributes.getInt(GRAVITY, 0);
                int i6 = typedArrayObtainStyledAttributes.getInt(COLUMN, Integer.MIN_VALUE);
                int i7 = COLUMN_SPAN;
                int i8 = DEFAULT_SPAN_SIZE;
                this.columnSpec = GridLayout.spec(i6, typedArrayObtainStyledAttributes.getInt(i7, i8), GridLayout.getAlignment(i5, true), typedArrayObtainStyledAttributes.getFloat(COLUMN_WEIGHT, 0.0f));
                this.rowSpec = GridLayout.spec(typedArrayObtainStyledAttributes.getInt(ROW, Integer.MIN_VALUE), typedArrayObtainStyledAttributes.getInt(ROW_SPAN, i8), GridLayout.getAlignment(i5, false), typedArrayObtainStyledAttributes.getFloat(ROW_WEIGHT, 0.0f));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        private void reInitSuper(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(MARGIN, Integer.MIN_VALUE);
                ((ViewGroup.MarginLayoutParams) this).leftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(LEFT_MARGIN, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(TOP_MARGIN, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(RIGHT_MARGIN, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(BOTTOM_MARGIN, dimensionPixelSize);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            return this.columnSpec.equals(layoutParams.columnSpec) && this.rowSpec.equals(layoutParams.rowSpec);
        }

        public int hashCode() {
            return this.columnSpec.hashCode() + (this.rowSpec.hashCode() * 31);
        }

        @Override // android.view.ViewGroup.LayoutParams
        public void setBaseAttributes(TypedArray typedArray, int i5, int i6) {
            ((ViewGroup.MarginLayoutParams) this).width = typedArray.getLayoutDimension(i5, -2);
            ((ViewGroup.MarginLayoutParams) this).height = typedArray.getLayoutDimension(i6, -2);
        }

        public final void setColumnSpecSpan(Interval interval) {
            this.columnSpec = this.columnSpec.copyWriteSpan(interval);
        }

        public void setGravity(int i5) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(i5, false));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(i5, true));
        }

        public final void setRowSpecSpan(Interval interval) {
            this.rowSpec = this.rowSpec.copyWriteSpan(interval);
        }

        public LayoutParams(Spec spec, Spec spec2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, spec, spec2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public LayoutParams() {
            Spec spec = Spec.UNDEFINED;
            this(spec, spec);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            this.rowSpec = layoutParams.rowSpec;
            this.columnSpec = layoutParams.columnSpec;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            reInitSuper(context, attributeSet);
            init(context, attributeSet);
        }
    }

    public static Spec spec(int i5, Alignment alignment) {
        return spec(i5, 1, alignment);
    }

    public static Spec spec(int i5, int i6) {
        return spec(i5, i6, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int i5) {
        return spec(i5, 1);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        checkLayoutParams(layoutParams2, true);
        checkLayoutParams(layoutParams2, false);
        return true;
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Alignment {
        public abstract int getAlignmentValue(View view, int i5, int i6);

        public Bounds getBounds() {
            return new Bounds();
        }

        public abstract String getDebugString();

        public abstract int getGravityOffset(View view, int i5);

        public String toString() {
            return "Alignment:" + getDebugString();
        }

        public int getSizeInCell(View view, int i5, int i6) {
            return i5;
        }
    }
}
