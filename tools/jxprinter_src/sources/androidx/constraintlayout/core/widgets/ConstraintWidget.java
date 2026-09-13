package androidx.constraintlayout.core.widgets;

import A3.AbstractC0157z;
import androidx.collection.a;
import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    private static final boolean DO_NOT_USE = false;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    public WidgetFrame frame;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    private boolean mAnimated;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    public float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    private boolean mHasBaseline;
    int mHeight;
    private int mHeightOverride;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    public HorizontalWidgetRun mHorizontalRun;
    private boolean mHorizontalSolvingPass;
    boolean mHorizontalWrapVisited;
    private boolean mInPlaceholder;
    private boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    private boolean mOptimizeWrapO;
    private boolean mOptimizeWrapOnResolved;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    private boolean mResolvedHorizontal;
    public int[] mResolvedMatchConstraintDefault;
    private boolean mResolvedVertical;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    public VerticalWidgetRun mVerticalRun;
    private boolean mVerticalSolvingPass;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    private int mWidthOverride;
    private int mWrapBehaviorInParent;
    protected int mX;
    protected int mY;
    public boolean measured;
    public WidgetRun[] run;
    public String stringId;
    public ChainRun verticalChainRun;
    public int verticalGroup;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.mOptimizeWrapO = false;
        this.mOptimizeWrapOnResolved = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.mHasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f6 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f6;
        this.mVerticalBiasPercent = f6;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Code duplicated, block: B:306:0x0498 A[PHI: r7
  0x0498: PHI (r7v15 int) = (r7v14 int), (r7v19 int), (r7v19 int), (r7v19 int) binds: [B:299:0x0488, B:301:0x048e, B:302:0x0490, B:304:0x0494] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:368:0x0542  */
    private void applyConstraints(LinearSystem linearSystem, boolean z6, boolean z7, boolean z8, boolean z9, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i5, int i6, int i7, int i8, float f6, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i9, int i10, int i11, int i12, float f7, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        int iMin;
        int i13;
        SolverVariable solverVariable3;
        boolean z20;
        boolean z21;
        int i14;
        int i15;
        SolverVariable solverVariableCreateObjectVariable;
        SolverVariable solverVariableCreateObjectVariable2;
        boolean z22;
        ConstraintAnchor constraintAnchor3;
        int i16;
        int i17;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget;
        boolean z27;
        int iMin2;
        int i18;
        boolean z28;
        int i19;
        int i20;
        int i21;
        boolean z29;
        int i22;
        int i23;
        int i24;
        boolean z30;
        ConstraintWidget constraintWidget2;
        int i25;
        ConstraintWidget constraintWidget3;
        linearSystem = linearSystem;
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean zIsConnected = constraintAnchor.isConnected();
        boolean zIsConnected2 = constraintAnchor2.isConnected();
        boolean zIsConnected3 = this.mCenter.isConnected();
        int i26 = zIsConnected2 ? (zIsConnected ? 1 : 0) + 1 : zIsConnected ? 1 : 0;
        if (zIsConnected3) {
            i26++;
        }
        int i27 = z11 ? 3 : i9;
        SolverVariable solverVariable5 = solverVariableCreateObjectVariable6;
        int iOrdinal = dimensionBehaviour.ordinal();
        boolean z31 = (iOrdinal == 0 || iOrdinal == 1 || iOrdinal != 2 || i27 == 4) ? false : true;
        int i28 = this.mWidthOverride;
        if (i28 == -1 || !z6) {
            i28 = i6;
            z17 = z31;
        } else {
            this.mWidthOverride = -1;
            z17 = false;
        }
        int i29 = this.mHeightOverride;
        if (i29 == -1 || z6) {
            z18 = z17;
        } else {
            this.mHeightOverride = -1;
            i28 = i29;
            z18 = false;
        }
        int i30 = i28;
        if (this.mVisibility == 8) {
            z19 = false;
            iMin = 0;
        } else {
            z19 = z18;
            iMin = i30;
        }
        if (z16) {
            if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                linearSystem.addEquality(solverVariableCreateObjectVariable3, i5);
            } else if (zIsConnected && !zIsConnected2) {
                i13 = 8;
                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
            }
            i13 = 8;
        } else {
            i13 = 8;
        }
        if (z19 == 0) {
            if (z10) {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 3);
                if (i7 > 0) {
                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i7, 8);
                }
                if (i8 < Integer.MAX_VALUE) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i8, 8);
                }
            } else {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, i13);
            }
            i15 = i12;
            solverVariable3 = solverVariableCreateObjectVariable4;
            i26 = i26 == true ? 1 : 0;
            solverVariable5 = solverVariable5;
            z20 = z19;
            z21 = z9;
            i14 = i11;
        } else if (i26 == 2 || z11 || !(i27 == 1 || i27 == 0)) {
            int i31 = i11 == -2 ? iMin : i11;
            int i32 = i12 == -2 ? iMin : i12;
            if (iMin > 0 && i27 != 1) {
                iMin = 0;
            }
            if (i31 > 0) {
                linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i31, 8);
                iMin = Math.max(iMin, i31);
            }
            if (i32 > 0) {
                if (!z7 || i27 != 1) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i32, 8);
                }
                iMin = Math.min(iMin, i32);
            }
            if (i27 == 1) {
                if (z7) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                } else if (z13) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                } else {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                }
                solverVariable3 = solverVariableCreateObjectVariable4;
                solverVariable5 = solverVariable5;
                z20 = z19;
                z21 = z9;
                i14 = i31;
                i15 = i32;
                i26 = i26 == true ? 1 : 0;
            } else {
                if (i27 == 2) {
                    ConstraintAnchor.Type type = constraintAnchor.getType();
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                    if (type == type2 || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                        solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                        solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                    } else {
                        solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                        solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                    }
                    SolverVariable solverVariable6 = solverVariableCreateObjectVariable2;
                    solverVariable3 = solverVariableCreateObjectVariable4;
                    linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(solverVariable3, solverVariableCreateObjectVariable3, solverVariable6, solverVariableCreateObjectVariable, f7));
                    if (z7) {
                        z19 = false;
                    }
                    z21 = z9;
                    z20 = z19;
                } else {
                    solverVariable3 = solverVariableCreateObjectVariable4;
                    z20 = z19;
                    z21 = true;
                }
                i14 = i31;
                i15 = i32;
            }
        } else {
            int iMax = Math.max(i11, iMin);
            if (i12 > 0) {
                iMax = Math.min(i12, iMax);
            }
            linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMax, 8);
            i14 = i11;
            i15 = i12;
            solverVariable3 = solverVariableCreateObjectVariable4;
            i26 = i26 == true ? 1 : 0;
            solverVariable5 = solverVariable5;
            z20 = false;
            z21 = z9;
        }
        if (!z16 || z13) {
            if (i26 < 2 && z7 && z21) {
                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 8);
                boolean z32 = z6 || this.mBaseline.mTarget == null;
                if (z6 || (constraintAnchor3 = this.mBaseline.mTarget) == null) {
                    z22 = z32;
                } else {
                    ConstraintWidget constraintWidget4 = constraintAnchor3.mOwner;
                    if (constraintWidget4.mDimensionRatio != 0.0f) {
                        DimensionBehaviour[] dimensionBehaviourArr = constraintWidget4.mListDimensionBehaviors;
                        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[1] == dimensionBehaviour3) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                    } else {
                        z22 = false;
                    }
                }
                if (z22) {
                    linearSystem.addGreaterThan(solverVariable2, solverVariable3, 0, 8);
                    return;
                }
                return;
            }
            return;
        }
        if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
            i19 = 5;
            z27 = z7;
            i25 = i19;
        } else if (!zIsConnected || zIsConnected2) {
            if (zIsConnected || !zIsConnected2) {
                if (zIsConnected && zIsConnected2) {
                    ConstraintWidget constraintWidget5 = constraintAnchor.mTarget.mOwner;
                    ConstraintWidget constraintWidget6 = constraintAnchor2.mTarget.mOwner;
                    ConstraintWidget parent = getParent();
                    int i33 = 6;
                    if (z20) {
                        if (i27 == 0) {
                            if (i15 != 0 || i14 != 0) {
                                z25 = false;
                                i24 = 5;
                                i16 = 5;
                                z30 = true;
                                z24 = true;
                            } else if (solverVariableCreateObjectVariable5.isFinalValue && solverVariable5.isFinalValue) {
                                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
                                linearSystem.addEquality(solverVariable3, solverVariable5, -constraintAnchor2.getMargin(), 8);
                                return;
                            } else {
                                z30 = false;
                                z24 = false;
                                i24 = 8;
                                i16 = 8;
                                z25 = true;
                            }
                            if ((constraintWidget5 instanceof Barrier) || (constraintWidget6 instanceof Barrier)) {
                                i16 = 4;
                            }
                            z23 = z30;
                            i17 = i24;
                            solverVariableCreateObjectVariable5 = solverVariableCreateObjectVariable5;
                            i33 = 6;
                        } else {
                            if (i27 == 2) {
                                i16 = ((constraintWidget5 instanceof Barrier) || (constraintWidget6 instanceof Barrier)) ? 4 : 5;
                                i17 = 5;
                            } else if (i27 == 1) {
                                solverVariableCreateObjectVariable3 = solverVariableCreateObjectVariable3;
                                solverVariable5 = solverVariable5;
                                solverVariableCreateObjectVariable5 = solverVariableCreateObjectVariable5;
                                i33 = 6;
                                i16 = 4;
                                i17 = 8;
                            } else if (i27 == 3) {
                                if (this.mResolvedDimensionRatioSide == -1) {
                                    if (z14) {
                                        linearSystem = linearSystem;
                                        solverVariableCreateObjectVariable3 = solverVariableCreateObjectVariable3;
                                        solverVariable5 = solverVariable5;
                                        solverVariableCreateObjectVariable5 = solverVariableCreateObjectVariable5;
                                        i33 = z7 ? 5 : 4;
                                    } else {
                                        linearSystem = linearSystem;
                                        solverVariableCreateObjectVariable3 = solverVariableCreateObjectVariable3;
                                        solverVariable5 = solverVariable5;
                                        solverVariableCreateObjectVariable5 = solverVariableCreateObjectVariable5;
                                        i33 = 8;
                                    }
                                    i16 = 5;
                                    i17 = 8;
                                } else {
                                    if (z11) {
                                        if (i10 == 2 || i10 == 1) {
                                            i22 = 5;
                                            i23 = 4;
                                        } else {
                                            i22 = 8;
                                            i23 = 5;
                                        }
                                        i17 = i22;
                                        i16 = i23;
                                    } else {
                                        if (i15 > 0) {
                                            i16 = 5;
                                        } else if (i15 != 0 || i14 != 0) {
                                            i16 = 4;
                                        } else if (z14) {
                                            i17 = (constraintWidget5 == parent || constraintWidget6 == parent) ? 5 : 4;
                                            i16 = 4;
                                        } else {
                                            i16 = 8;
                                        }
                                        i17 = 5;
                                    }
                                    z23 = true;
                                    z24 = true;
                                    z25 = true;
                                    linearSystem = linearSystem;
                                }
                                z23 = true;
                                z24 = true;
                                z25 = true;
                            } else {
                                linearSystem = linearSystem;
                                solverVariableCreateObjectVariable3 = solverVariableCreateObjectVariable3;
                                solverVariable5 = solverVariable5;
                                solverVariableCreateObjectVariable5 = solverVariableCreateObjectVariable5;
                                i33 = 6;
                                i16 = 4;
                                i17 = 5;
                                z23 = false;
                                z24 = false;
                                z25 = false;
                            }
                            z23 = true;
                            z24 = true;
                            z25 = false;
                        }
                    } else {
                        if (solverVariableCreateObjectVariable5.isFinalValue && solverVariable5.isFinalValue) {
                            SolverVariable solverVariable7 = solverVariable5;
                            linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), f6, solverVariable7, solverVariable3, constraintAnchor2.getMargin(), 8);
                            if (z7 && z21) {
                                int margin = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
                                if (solverVariable7 != solverVariable2) {
                                    linearSystem.addGreaterThan(solverVariable2, solverVariable3, margin, 5);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        linearSystem = linearSystem;
                        solverVariableCreateObjectVariable3 = solverVariableCreateObjectVariable3;
                        solverVariable5 = solverVariable5;
                        solverVariableCreateObjectVariable5 = solverVariableCreateObjectVariable5;
                        i33 = 6;
                        i16 = 4;
                        i17 = 5;
                        z23 = true;
                        z24 = true;
                        z25 = false;
                    }
                    if (z24 && solverVariableCreateObjectVariable5 == solverVariable5 && constraintWidget5 != parent) {
                        z24 = false;
                        z26 = false;
                    } else {
                        z26 = true;
                    }
                    if (z23) {
                        if (z20 || z12 || z14 || solverVariableCreateObjectVariable5 != solverVariable || solverVariable5 != solverVariable2) {
                            i21 = i33;
                            z29 = z7;
                        } else {
                            i21 = 8;
                            z29 = false;
                            i17 = 8;
                            z26 = false;
                        }
                        solverVariable4 = solverVariable;
                        z7 = z29;
                        constraintWidget = constraintWidget6;
                        SolverVariable solverVariable8 = solverVariable3;
                        linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), f6, solverVariable5, solverVariable8, constraintAnchor2.getMargin(), i21);
                        solverVariable5 = solverVariable5;
                        solverVariable3 = solverVariable8;
                    } else {
                        solverVariable5 = solverVariable5;
                        solverVariable4 = solverVariable;
                        constraintWidget = constraintWidget6;
                    }
                    z27 = z7;
                    if (this.mVisibility == 8 && !constraintAnchor2.hasDependents()) {
                        return;
                    }
                    if (z24) {
                        int i34 = (!z27 || solverVariableCreateObjectVariable5 == solverVariable5 || z20 || !((constraintWidget5 instanceof Barrier) || (constraintWidget instanceof Barrier))) ? i17 : 6;
                        linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), i34);
                        linearSystem.addLowerThan(solverVariable3, solverVariable5, -constraintAnchor2.getMargin(), i34);
                        i17 = i34;
                    }
                    if (!z27 || !z15 || (constraintWidget5 instanceof Barrier) || (constraintWidget instanceof Barrier) || constraintWidget == parent) {
                        iMin2 = i16;
                        i18 = i17;
                        z28 = z26;
                    } else {
                        iMin2 = 6;
                        i18 = 6;
                        z28 = true;
                    }
                    if (z28) {
                        if (z25 && (!z14 || z8)) {
                            if (constraintWidget5 != parent && constraintWidget != parent) {
                                i33 = iMin2;
                            }
                            if ((constraintWidget5 instanceof Guideline) || (constraintWidget instanceof Guideline)) {
                                i33 = 5;
                            }
                            if ((constraintWidget5 instanceof Barrier) || (constraintWidget instanceof Barrier)) {
                                i33 = 5;
                            }
                            iMin2 = Math.max(z14 ? 5 : i33, iMin2);
                        }
                        if (z27) {
                            iMin2 = Math.min(i18, iMin2);
                            if (z11 && !z14 && (constraintWidget5 == parent || constraintWidget == parent)) {
                                i20 = 4;
                            } else {
                                i20 = iMin2;
                            }
                        } else {
                            i20 = iMin2;
                        }
                        linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), i20);
                        linearSystem.addEquality(solverVariable3, solverVariable5, -constraintAnchor2.getMargin(), i20);
                    }
                    if (z27) {
                        int margin2 = solverVariable4 == solverVariableCreateObjectVariable5 ? constraintAnchor.getMargin() : 0;
                        if (solverVariableCreateObjectVariable5 != solverVariable4) {
                            linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable4, margin2, 5);
                        }
                    }
                    if (!z27 || !z20 || i7 != 0 || i14 != 0) {
                        i19 = 5;
                    } else if (z20 && i27 == 3) {
                        linearSystem.addGreaterThan(solverVariable3, solverVariableCreateObjectVariable3, 0, 8);
                        i19 = 5;
                    } else {
                        i19 = 5;
                        linearSystem.addGreaterThan(solverVariable3, solverVariableCreateObjectVariable3, 0, 5);
                    }
                }
                i25 = i19;
            } else {
                linearSystem.addEquality(solverVariable3, solverVariable5, -constraintAnchor2.getMargin(), 8);
                if (z7) {
                    if (this.mOptimizeWrapO && solverVariableCreateObjectVariable3.isFinalValue && (constraintWidget2 = this.mParent) != null) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                        if (z6) {
                            constraintWidgetContainer.addHorizontalWrapMinVariable(constraintAnchor);
                        } else {
                            constraintWidgetContainer.addVerticalWrapMinVariable(constraintAnchor);
                        }
                    } else {
                        i19 = 5;
                        linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 5);
                    }
                }
                z27 = z7;
                i25 = i19;
            }
            i19 = 5;
            z27 = z7;
            i25 = i19;
        } else {
            SolverVariable solverVariable9 = solverVariable5;
            i25 = (z7 && (constraintAnchor.mTarget.mOwner instanceof Barrier)) ? 8 : 5;
            solverVariable5 = solverVariable9;
            z27 = z7;
        }
        if (z27 && z21) {
            int margin3 = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
            if (solverVariable5 != solverVariable2) {
                if (!this.mOptimizeWrapO || !solverVariable3.isFinalValue || (constraintWidget3 = this.mParent) == null) {
                    linearSystem.addGreaterThan(solverVariable2, solverVariable3, margin3, i25);
                    return;
                }
                ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget3;
                if (z6) {
                    constraintWidgetContainer2.addHorizontalWrapMaxVariable(constraintAnchor2);
                } else {
                    constraintWidgetContainer2.addVerticalWrapMaxVariable(constraintAnchor2);
                }
            }
        }
    }

    private boolean isChainHead(int i5) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i6 = i5 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i6];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return (constraintAnchor4 == null || constraintAnchor4.mTarget == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i6 + 1]).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) ? false : true;
    }

    private void serializeAnchor(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("',");
        sb.append(constraintAnchor.mMargin);
        sb.append(",");
        sb.append(constraintAnchor.mGoneMargin);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    private void serializeAttribute(StringBuilder sb, String str, float f6, float f7) {
        if (f6 == f7) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f6);
        sb.append(",\n");
    }

    private void serializeCircle(StringBuilder sb, ConstraintAnchor constraintAnchor, float f6) {
        if (constraintAnchor.mTarget == null || Float.isNaN(f6)) {
            return;
        }
        sb.append("circle : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("',");
        sb.append(constraintAnchor.mMargin);
        sb.append(",");
        sb.append(f6);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    private void serializeDimensionRatio(StringBuilder sb, String str, float f6, int i5) {
        if (f6 == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f6);
        sb.append(",");
        sb.append(i5);
        sb.append("");
        sb.append("],\n");
    }

    private void serializeSize(StringBuilder sb, String str, int i5, int i6, int i7, int i8, int i9, int i10, float f6, float f7) {
        sb.append(str);
        sb.append(" :  {\n");
        serializeAttribute(sb, "size", i5, Integer.MIN_VALUE);
        serializeAttribute(sb, "min", i6, 0);
        serializeAttribute(sb, "max", i7, Integer.MAX_VALUE);
        serializeAttribute(sb, "matchMin", i9, 0);
        serializeAttribute(sb, "matchDef", i10, 0);
        serializeAttribute(sb, "matchPercent", i10, 1);
        serializeAttribute(sb, "matchConstraintPercent", f6, 1.0f);
        serializeAttribute(sb, "weight", f7, 1.0f);
        serializeAttribute(sb, "override", i8, 1);
        sb.append("},\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i5, boolean z6) {
        if (z6) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i5 == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i5, true);
            }
        }
    }

    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARN: Code duplicated, block: B:192:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:194:0x02fb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:196:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:199:0x0303  */
    /* JADX WARN: Code duplicated, block: B:19:0x004d  */
    /* JADX WARN: Code duplicated, block: B:203:0x030d  */
    /* JADX WARN: Code duplicated, block: B:206:0x0319  */
    /* JADX WARN: Code duplicated, block: B:209:0x0320  */
    /* JADX WARN: Code duplicated, block: B:211:0x0324  */
    /* JADX WARN: Code duplicated, block: B:214:0x033f  */
    /* JADX WARN: Code duplicated, block: B:235:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:250:0x0439  */
    /* JADX WARN: Code duplicated, block: B:267:0x048b  */
    /* JADX WARN: Code duplicated, block: B:270:0x049b  */
    /* JADX WARN: Code duplicated, block: B:271:0x049d  */
    /* JADX WARN: Code duplicated, block: B:273:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:310:0x0578  */
    /* JADX WARN: Code duplicated, block: B:312:0x057f  */
    /* JADX WARN: Code duplicated, block: B:314:0x0586  */
    /* JADX WARN: Code duplicated, block: B:315:0x0595  */
    /* JADX WARN: Code duplicated, block: B:316:0x0598  */
    /* JADX WARN: Code duplicated, block: B:319:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:322:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:325:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public void addToSolver(LinearSystem linearSystem, boolean z6) {
        boolean z7;
        boolean z8;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean zIsInHorizontalChain;
        boolean zIsInVerticalChain;
        int i5;
        SolverVariable solverVariable;
        int i6;
        int i7;
        int i8;
        boolean z9;
        int i9;
        boolean z10;
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        boolean z11;
        SolverVariable solverVariable2;
        int i10;
        boolean z12;
        boolean z13;
        boolean z14;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        int i11;
        char c;
        int i12;
        int i13;
        int i14;
        LinearSystem linearSystem2;
        Metrics metrics;
        boolean z15;
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int i15;
        int i16;
        int i17;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun2;
        LinearSystem linearSystem3 = linearSystem;
        SolverVariable solverVariableCreateObjectVariable = linearSystem3.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem3.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem3.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem3.createObjectVariable(this.mBottom);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem3.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget3 = this.mParent;
        if (constraintWidget3 == null) {
            z7 = false;
            z8 = false;
        } else {
            z8 = constraintWidget3 != null && constraintWidget3.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            z7 = constraintWidget3 != null && constraintWidget3.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            int i18 = this.mWrapBehaviorInParent;
            if (i18 == 1) {
                z7 = false;
            } else if (i18 == 2) {
                z8 = false;
            } else if (i18 == 3) {
                z7 = false;
                z8 = false;
            }
        }
        if (this.mVisibility == 8 && !this.mAnimated && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z16 = this.mResolvedHorizontal;
        if (z16 || this.mResolvedVertical) {
            if (z16) {
                linearSystem3.addEquality(solverVariableCreateObjectVariable, this.mX);
                linearSystem3.addEquality(solverVariableCreateObjectVariable2, this.mX + this.mWidth);
                if (z8 && (constraintWidget2 = this.mParent) != null) {
                    if (this.mOptimizeWrapOnResolved) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                        constraintWidgetContainer.addHorizontalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget2.mRight), solverVariableCreateObjectVariable2, 0, 5);
                    }
                }
            }
            if (this.mResolvedVertical) {
                linearSystem3.addEquality(solverVariableCreateObjectVariable3, this.mY);
                linearSystem3.addEquality(solverVariableCreateObjectVariable4, this.mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem3.addEquality(solverVariableCreateObjectVariable5, this.mY + this.mBaselineDistance);
                }
                if (z7 && (constraintWidget = this.mParent) != null) {
                    if (this.mOptimizeWrapOnResolved) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget.mBottom), solverVariableCreateObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.mResolvedHorizontal && this.mResolvedVertical) {
                this.mResolvedHorizontal = false;
                this.mResolvedVertical = false;
                return;
            }
        }
        Metrics metrics2 = LinearSystem.sMetrics;
        if (metrics2 != null) {
            metrics2.widgets++;
        }
        if (z6 && (horizontalWidgetRun2 = this.mHorizontalRun) != null && (verticalWidgetRun2 = this.mVerticalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun2.start;
            if (dependencyNode.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun2.start.resolved && verticalWidgetRun2.end.resolved) {
                if (metrics2 != null) {
                    metrics2.graphSolved++;
                }
                linearSystem3.addEquality(solverVariableCreateObjectVariable, dependencyNode.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable2, this.mHorizontalRun.end.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable3, this.mVerticalRun.start.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable4, this.mVerticalRun.end.value);
                linearSystem3.addEquality(solverVariableCreateObjectVariable5, this.mVerticalRun.baseline.value);
                if (this.mParent != null) {
                    if (z8 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 8);
                    }
                    if (z7 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 8);
                    }
                }
                this.mResolvedHorizontal = false;
                this.mResolvedVertical = false;
                return;
            }
        }
        if (metrics2 != null) {
            metrics2.linearSolved++;
        }
        if (this.mParent != null) {
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                zIsInHorizontalChain = true;
                i17 = 1;
            } else {
                zIsInHorizontalChain = isInHorizontalChain();
                i17 = 1;
            }
            if (isChainHead(i17)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, i17);
                zIsInVerticalChain = true;
            } else {
                zIsInVerticalChain = isInVerticalChain();
            }
            if (!zIsInHorizontalChain && z8 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 1);
            }
            if (!zIsInVerticalChain && z7 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 1);
            }
        } else {
            zIsInHorizontalChain = false;
            zIsInVerticalChain = false;
        }
        int i19 = this.mWidth;
        int i20 = this.mMinWidth;
        if (i19 >= i20) {
            i20 = i19;
        }
        int i21 = this.mHeight;
        int i22 = this.mMinHeight;
        if (i21 >= i22) {
            i22 = i21;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
        SolverVariable solverVariable6 = solverVariableCreateObjectVariable4;
        DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z17 = dimensionBehaviour3 != dimensionBehaviour4;
        DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[1];
        boolean z18 = zIsInHorizontalChain;
        boolean z19 = dimensionBehaviour5 != dimensionBehaviour4;
        boolean z20 = zIsInVerticalChain;
        int i23 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = i23;
        int i24 = i22;
        float f6 = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f6;
        int i25 = this.mMatchConstraintDefaultWidth;
        int i26 = this.mMatchConstraintDefaultHeight;
        if (f6 > 0.0f) {
            i5 = i20;
            if (this.mVisibility != 8) {
                i6 = (dimensionBehaviour3 == dimensionBehaviour4 && i25 == 0) ? 3 : i25;
                int i27 = (dimensionBehaviour5 == dimensionBehaviour4 && i26 == 0) ? 3 : i26;
                if (dimensionBehaviour3 == dimensionBehaviour4 && dimensionBehaviour5 == dimensionBehaviour4) {
                    solverVariable = solverVariableCreateObjectVariable2;
                    i16 = 3;
                    if (i6 == 3 && i27 == 3) {
                        setupDimensionRatio(z8, z7, z17, z19);
                    }
                    i24 = i24;
                    z9 = true;
                    i7 = i27;
                    i8 = i5;
                    int[] iArr = this.mResolvedMatchConstraintDefault;
                    iArr[0] = i6;
                    iArr[1] = i7;
                    this.mResolvedHasRatio = z9;
                    if (z9) {
                        int i28 = this.mResolvedDimensionRatioSide;
                        i9 = -1;
                        boolean z21 = i28 != 0 || i28 == -1;
                        if (z9 || !((i15 = this.mResolvedDimensionRatioSide) == 1 || i15 == i9)) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        dimensionBehaviour = this.mListDimensionBehaviors[0];
                        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                        if (dimensionBehaviour == dimensionBehaviour2 || !(this instanceof ConstraintWidgetContainer)) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (z11) {
                            i8 = 0;
                        }
                        boolean z22 = !this.mCenter.isConnected();
                        boolean[] zArr2 = this.mIsInBarrier;
                        boolean z23 = zArr2[0];
                        boolean z24 = zArr2[1];
                        if (this.mHorizontalResolution != 2 || this.mResolvedHorizontal) {
                            z14 = z8;
                            solverVariable2 = solverVariableCreateObjectVariable3;
                            z13 = z18;
                            z12 = z20;
                            i10 = i6;
                        } else {
                            if (z6 && (horizontalWidgetRun = this.mHorizontalRun) != null) {
                                DependencyNode dependencyNode2 = horizontalWidgetRun.start;
                                if (dependencyNode2.resolved && horizontalWidgetRun.end.resolved) {
                                    if (z6) {
                                        linearSystem3.addEquality(solverVariableCreateObjectVariable, dependencyNode2.value);
                                        SolverVariable solverVariable7 = solverVariable;
                                        linearSystem3.addEquality(solverVariable7, this.mHorizontalRun.end.value);
                                        if (this.mParent != null && z8 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                            linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), solverVariable7, 0, 8);
                                        }
                                        solverVariable = solverVariable7;
                                    }
                                    z14 = z8;
                                    solverVariable2 = solverVariableCreateObjectVariable3;
                                    z13 = z18;
                                    z12 = z20;
                                    i10 = i6;
                                }
                            }
                            SolverVariable solverVariable8 = solverVariable;
                            ConstraintWidget constraintWidget4 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable6 = constraintWidget4 != null ? linearSystem3.createObjectVariable(constraintWidget4.mRight) : null;
                            ConstraintWidget constraintWidget5 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable7 = constraintWidget5 != null ? linearSystem3.createObjectVariable(constraintWidget5.mLeft) : null;
                            boolean z25 = this.isTerminalWidget[0];
                            DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                            DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr2[0];
                            ConstraintAnchor constraintAnchor = this.mLeft;
                            i10 = i6;
                            ConstraintAnchor constraintAnchor2 = this.mRight;
                            z9 = z9;
                            z14 = z8;
                            int i29 = this.mX;
                            boolean z26 = z21;
                            SolverVariable solverVariable9 = solverVariableCreateObjectVariable7;
                            int i30 = this.mMinWidth;
                            int i31 = this.mMaxDimension[0];
                            float f7 = this.mHorizontalBiasPercent;
                            boolean z27 = dimensionBehaviourArr2[1] == dimensionBehaviour4;
                            solverVariableCreateObjectVariable = solverVariableCreateObjectVariable;
                            solverVariable6 = solverVariable6;
                            dimensionBehaviour4 = dimensionBehaviour4;
                            z7 = z7;
                            z13 = z18;
                            z12 = z20;
                            dimensionBehaviour2 = dimensionBehaviour2;
                            solverVariable = solverVariable8;
                            solverVariable2 = solverVariableCreateObjectVariable3;
                            linearSystem3 = linearSystem;
                            applyConstraints(linearSystem3, true, z14, z7, z25, solverVariable9, solverVariableCreateObjectVariable6, dimensionBehaviour6, z11, constraintAnchor, constraintAnchor2, i29, i8, i30, i31, f7, z26, z27, z13, z12, z23, i10, i7, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z22);
                        }
                        if (z6 || (verticalWidgetRun = this.mVerticalRun) == null) {
                            solverVariable3 = solverVariable2;
                            solverVariable4 = solverVariable6;
                            solverVariable5 = r24;
                            i11 = 0;
                            c = 1;
                            i12 = 8;
                            i13 = 1;
                        } else {
                            DependencyNode dependencyNode3 = verticalWidgetRun.start;
                            if (dependencyNode3.resolved && verticalWidgetRun.end.resolved) {
                                int i32 = dependencyNode3.value;
                                solverVariable3 = solverVariable2;
                                linearSystem3.addEquality(solverVariable3, i32);
                                solverVariable4 = solverVariable6;
                                linearSystem3.addEquality(solverVariable4, this.mVerticalRun.end.value);
                                solverVariable5 = solverVariableCreateObjectVariable5;
                                linearSystem3.addEquality(solverVariable5, this.mVerticalRun.baseline.value);
                                ConstraintWidget constraintWidget6 = this.mParent;
                                if (constraintWidget6 == null || z12 || !z7) {
                                    i11 = 0;
                                    c = 1;
                                } else {
                                    c = 1;
                                    if (this.isTerminalWidget[1]) {
                                        i11 = 0;
                                        i12 = 8;
                                        linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(constraintWidget6.mBottom), solverVariable4, 0, 8);
                                    } else {
                                        i11 = 0;
                                    }
                                    i13 = i11;
                                }
                                i12 = 8;
                                i13 = i11;
                            } else {
                                solverVariable3 = solverVariable2;
                                solverVariable4 = solverVariable6;
                                solverVariable5 = r24;
                                i11 = 0;
                                c = 1;
                                i12 = 8;
                                i13 = 1;
                            }
                        }
                        if (this.mVerticalResolution == 2) {
                            i14 = i11;
                        } else {
                            i14 = i13;
                        }
                        if (i14 == 0 && !this.mResolvedVertical) {
                            boolean z28 = (this.mListDimensionBehaviors[c] == dimensionBehaviour2 && (this instanceof ConstraintWidgetContainer)) ? c : i11;
                            int i33 = z28 != 0 ? i11 : i24;
                            ConstraintWidget constraintWidget7 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable8 = constraintWidget7 != null ? linearSystem3.createObjectVariable(constraintWidget7.mBottom) : null;
                            ConstraintWidget constraintWidget8 = this.mParent;
                            SolverVariable solverVariableCreateObjectVariable9 = constraintWidget8 != null ? linearSystem3.createObjectVariable(constraintWidget8.mTop) : null;
                            if (this.mBaselineDistance > 0 || this.mVisibility == i12) {
                                z15 = z22;
                                ConstraintAnchor constraintAnchor3 = this.mBaseline;
                                if (constraintAnchor3.mTarget != null) {
                                    linearSystem3.addEquality(solverVariable5, solverVariable3, getBaselineDistance(), i12);
                                    linearSystem3.addEquality(solverVariable5, linearSystem3.createObjectVariable(this.mBaseline.mTarget), this.mBaseline.getMargin(), i12);
                                    if (z7) {
                                        linearSystem3.addGreaterThan(solverVariableCreateObjectVariable8, linearSystem3.createObjectVariable(this.mBottom), i11, 5);
                                    }
                                    z15 = i11;
                                } else if (this.mVisibility == i12) {
                                    linearSystem3.addEquality(solverVariable5, solverVariable3, constraintAnchor3.getMargin(), i12);
                                    z15 = z22;
                                } else {
                                    linearSystem3.addEquality(solverVariable5, solverVariable3, getBaselineDistance(), i12);
                                    z15 = z22;
                                }
                            }
                            z15 = z22;
                            boolean z29 = this.isTerminalWidget[c];
                            DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
                            int i34 = i11;
                            char c6 = c;
                            applyConstraints(linearSystem, false, z7, z14, z29, solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable8, dimensionBehaviourArr3[c], z28, this.mTop, this.mBottom, this.mY, i33, this.mMinHeight, this.mMaxDimension[c6], this.mVerticalBiasPercent, z10, dimensionBehaviourArr3[i34] == dimensionBehaviour4 ? c6 : i34, z12, z13, z24, i7, i10, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z15);
                        }
                        if (!z9) {
                            linearSystem2 = linearSystem;
                        } else if (this.mResolvedDimensionRatioSide == 1) {
                            linearSystem.addRatio(solverVariable4, solverVariable3, solverVariable, solverVariableCreateObjectVariable, this.mResolvedDimensionRatio, 8);
                            linearSystem2 = linearSystem;
                        } else {
                            linearSystem.addRatio(solverVariable, solverVariableCreateObjectVariable, solverVariable4, solverVariable3, this.mResolvedDimensionRatio, 8);
                            linearSystem2 = linearSystem;
                        }
                        if (this.mCenter.isConnected()) {
                            linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                        }
                        this.mResolvedHorizontal = false;
                        this.mResolvedVertical = false;
                        metrics = LinearSystem.sMetrics;
                        if (metrics != null) {
                            metrics.mEquations = linearSystem2.getNumEquations();
                            LinearSystem.sMetrics.mVariables = linearSystem2.getNumVariables();
                        }
                    }
                    i9 = -1;
                    if (z9) {
                        z10 = false;
                    } else {
                        z10 = false;
                    }
                    dimensionBehaviour = this.mListDimensionBehaviors[0];
                    dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour2) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        i8 = 0;
                    }
                    boolean z210 = !this.mCenter.isConnected();
                    boolean[] zArr3 = this.mIsInBarrier;
                    boolean z211 = zArr3[0];
                    boolean z212 = zArr3[1];
                    if (this.mHorizontalResolution != 2) {
                        z14 = z8;
                        solverVariable2 = solverVariableCreateObjectVariable3;
                        z13 = z18;
                        z12 = z20;
                        i10 = i6;
                    } else {
                        z14 = z8;
                        solverVariable2 = solverVariableCreateObjectVariable3;
                        z13 = z18;
                        z12 = z20;
                        i10 = i6;
                    }
                    if (z6) {
                        solverVariable3 = solverVariable2;
                        solverVariable4 = solverVariable6;
                        solverVariable5 = r24;
                        i11 = 0;
                        c = 1;
                        i12 = 8;
                        i13 = 1;
                    } else {
                        solverVariable3 = solverVariable2;
                        solverVariable4 = solverVariable6;
                        solverVariable5 = r24;
                        i11 = 0;
                        c = 1;
                        i12 = 8;
                        i13 = 1;
                    }
                    if (this.mVerticalResolution == 2) {
                        i14 = i11;
                    } else {
                        i14 = i13;
                    }
                    if (i14 == 0) {
                    }
                    if (!z9) {
                        linearSystem2 = linearSystem;
                    } else if (this.mResolvedDimensionRatioSide == 1) {
                        linearSystem.addRatio(solverVariable4, solverVariable3, solverVariable, solverVariableCreateObjectVariable, this.mResolvedDimensionRatio, 8);
                        linearSystem2 = linearSystem;
                    } else {
                        linearSystem.addRatio(solverVariable, solverVariableCreateObjectVariable, solverVariable4, solverVariable3, this.mResolvedDimensionRatio, 8);
                        linearSystem2 = linearSystem;
                    }
                    if (this.mCenter.isConnected()) {
                        linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                    }
                    this.mResolvedHorizontal = false;
                    this.mResolvedVertical = false;
                    metrics = LinearSystem.sMetrics;
                    if (metrics != null) {
                        metrics.mEquations = linearSystem2.getNumEquations();
                        LinearSystem.sMetrics.mVariables = linearSystem2.getNumVariables();
                    }
                }
                solverVariable = solverVariableCreateObjectVariable2;
                i16 = 3;
                if (dimensionBehaviour3 == dimensionBehaviour4 && i6 == i16) {
                    this.mResolvedDimensionRatioSide = 0;
                    int i35 = (int) (i21 * f6);
                    if (dimensionBehaviour5 != dimensionBehaviour4) {
                        i6 = 4;
                        i7 = i27;
                        i8 = i35;
                    } else {
                        solverVariable6 = solverVariable6;
                        i24 = i24;
                        i7 = i27;
                        i8 = i35;
                        z9 = true;
                    }
                } else {
                    if (dimensionBehaviour5 == dimensionBehaviour4 && i27 == i16) {
                        this.mResolvedDimensionRatioSide = 1;
                        if (i23 == -1) {
                            this.mResolvedDimensionRatio = 1.0f / f6;
                        }
                        i24 = (int) (this.mResolvedDimensionRatio * i19);
                        if (dimensionBehaviour3 != dimensionBehaviour4) {
                            solverVariable6 = solverVariable6;
                            i8 = i5;
                            z9 = false;
                            i7 = 4;
                        }
                    } else {
                        i24 = i24;
                    }
                    z9 = true;
                    i7 = i27;
                    i8 = i5;
                }
                int[] iArr2 = this.mResolvedMatchConstraintDefault;
                iArr2[0] = i6;
                iArr2[1] = i7;
                this.mResolvedHasRatio = z9;
                if (z9) {
                    int i210 = this.mResolvedDimensionRatioSide;
                    i9 = -1;
                    if (i210 != 0) {
                    }
                    if (z9) {
                        z10 = false;
                    } else {
                        z10 = false;
                    }
                    dimensionBehaviour = this.mListDimensionBehaviors[0];
                    dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour2) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        i8 = 0;
                    }
                    boolean z213 = !this.mCenter.isConnected();
                    boolean[] zArr4 = this.mIsInBarrier;
                    boolean z214 = zArr4[0];
                    boolean z215 = zArr4[1];
                    if (this.mHorizontalResolution != 2) {
                        z14 = z8;
                        solverVariable2 = solverVariableCreateObjectVariable3;
                        z13 = z18;
                        z12 = z20;
                        i10 = i6;
                    } else {
                        z14 = z8;
                        solverVariable2 = solverVariableCreateObjectVariable3;
                        z13 = z18;
                        z12 = z20;
                        i10 = i6;
                    }
                    if (z6) {
                        solverVariable3 = solverVariable2;
                        solverVariable4 = solverVariable6;
                        solverVariable5 = r24;
                        i11 = 0;
                        c = 1;
                        i12 = 8;
                        i13 = 1;
                    } else {
                        solverVariable3 = solverVariable2;
                        solverVariable4 = solverVariable6;
                        solverVariable5 = r24;
                        i11 = 0;
                        c = 1;
                        i12 = 8;
                        i13 = 1;
                    }
                    if (this.mVerticalResolution == 2) {
                        i14 = i11;
                    } else {
                        i14 = i13;
                    }
                    if (i14 == 0) {
                    }
                    if (!z9) {
                        linearSystem2 = linearSystem;
                    } else if (this.mResolvedDimensionRatioSide == 1) {
                        linearSystem.addRatio(solverVariable4, solverVariable3, solverVariable, solverVariableCreateObjectVariable, this.mResolvedDimensionRatio, 8);
                        linearSystem2 = linearSystem;
                    } else {
                        linearSystem.addRatio(solverVariable, solverVariableCreateObjectVariable, solverVariable4, solverVariable3, this.mResolvedDimensionRatio, 8);
                        linearSystem2 = linearSystem;
                    }
                    if (this.mCenter.isConnected()) {
                        linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                    }
                    this.mResolvedHorizontal = false;
                    this.mResolvedVertical = false;
                    metrics = LinearSystem.sMetrics;
                    if (metrics != null) {
                        metrics.mEquations = linearSystem2.getNumEquations();
                        LinearSystem.sMetrics.mVariables = linearSystem2.getNumVariables();
                    }
                }
                i9 = -1;
                if (z9) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                dimensionBehaviour = this.mListDimensionBehaviors[0];
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour2) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                if (z11) {
                    i8 = 0;
                }
                boolean z216 = !this.mCenter.isConnected();
                boolean[] zArr5 = this.mIsInBarrier;
                boolean z217 = zArr5[0];
                boolean z218 = zArr5[1];
                if (this.mHorizontalResolution != 2) {
                    z14 = z8;
                    solverVariable2 = solverVariableCreateObjectVariable3;
                    z13 = z18;
                    z12 = z20;
                    i10 = i6;
                } else {
                    z14 = z8;
                    solverVariable2 = solverVariableCreateObjectVariable3;
                    z13 = z18;
                    z12 = z20;
                    i10 = i6;
                }
                if (z6) {
                    solverVariable3 = solverVariable2;
                    solverVariable4 = solverVariable6;
                    solverVariable5 = r24;
                    i11 = 0;
                    c = 1;
                    i12 = 8;
                    i13 = 1;
                } else {
                    solverVariable3 = solverVariable2;
                    solverVariable4 = solverVariable6;
                    solverVariable5 = r24;
                    i11 = 0;
                    c = 1;
                    i12 = 8;
                    i13 = 1;
                }
                if (this.mVerticalResolution == 2) {
                    i14 = i11;
                } else {
                    i14 = i13;
                }
                if (i14 == 0) {
                }
                if (!z9) {
                    linearSystem2 = linearSystem;
                } else if (this.mResolvedDimensionRatioSide == 1) {
                    linearSystem.addRatio(solverVariable4, solverVariable3, solverVariable, solverVariableCreateObjectVariable, this.mResolvedDimensionRatio, 8);
                    linearSystem2 = linearSystem;
                } else {
                    linearSystem.addRatio(solverVariable, solverVariableCreateObjectVariable, solverVariable4, solverVariable3, this.mResolvedDimensionRatio, 8);
                    linearSystem2 = linearSystem;
                }
                if (this.mCenter.isConnected()) {
                    linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                }
                this.mResolvedHorizontal = false;
                this.mResolvedVertical = false;
                metrics = LinearSystem.sMetrics;
                if (metrics != null) {
                    metrics.mEquations = linearSystem2.getNumEquations();
                    LinearSystem.sMetrics.mVariables = linearSystem2.getNumVariables();
                }
            }
            z9 = false;
            int[] iArr3 = this.mResolvedMatchConstraintDefault;
            iArr3[0] = i6;
            iArr3[1] = i7;
            this.mResolvedHasRatio = z9;
            if (z9) {
                int i211 = this.mResolvedDimensionRatioSide;
                i9 = -1;
                if (i211 != 0) {
                }
                if (z9) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                dimensionBehaviour = this.mListDimensionBehaviors[0];
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour2) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                if (z11) {
                    i8 = 0;
                }
                boolean z219 = !this.mCenter.isConnected();
                boolean[] zArr6 = this.mIsInBarrier;
                boolean z2110 = zArr6[0];
                boolean z2111 = zArr6[1];
                if (this.mHorizontalResolution != 2) {
                    z14 = z8;
                    solverVariable2 = solverVariableCreateObjectVariable3;
                    z13 = z18;
                    z12 = z20;
                    i10 = i6;
                } else {
                    z14 = z8;
                    solverVariable2 = solverVariableCreateObjectVariable3;
                    z13 = z18;
                    z12 = z20;
                    i10 = i6;
                }
                if (z6) {
                    solverVariable3 = solverVariable2;
                    solverVariable4 = solverVariable6;
                    solverVariable5 = r24;
                    i11 = 0;
                    c = 1;
                    i12 = 8;
                    i13 = 1;
                } else {
                    solverVariable3 = solverVariable2;
                    solverVariable4 = solverVariable6;
                    solverVariable5 = r24;
                    i11 = 0;
                    c = 1;
                    i12 = 8;
                    i13 = 1;
                }
                if (this.mVerticalResolution == 2) {
                    i14 = i11;
                } else {
                    i14 = i13;
                }
                if (i14 == 0) {
                }
                if (!z9) {
                    linearSystem2 = linearSystem;
                } else if (this.mResolvedDimensionRatioSide == 1) {
                    linearSystem.addRatio(solverVariable4, solverVariable3, solverVariable, solverVariableCreateObjectVariable, this.mResolvedDimensionRatio, 8);
                    linearSystem2 = linearSystem;
                } else {
                    linearSystem.addRatio(solverVariable, solverVariableCreateObjectVariable, solverVariable4, solverVariable3, this.mResolvedDimensionRatio, 8);
                    linearSystem2 = linearSystem;
                }
                if (this.mCenter.isConnected()) {
                    linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                }
                this.mResolvedHorizontal = false;
                this.mResolvedVertical = false;
                metrics = LinearSystem.sMetrics;
                if (metrics != null) {
                    metrics.mEquations = linearSystem2.getNumEquations();
                    LinearSystem.sMetrics.mVariables = linearSystem2.getNumVariables();
                }
            }
            i9 = -1;
            if (z9) {
                z10 = false;
            } else {
                z10 = false;
            }
            dimensionBehaviour = this.mListDimensionBehaviors[0];
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour == dimensionBehaviour2) {
                z11 = false;
            } else {
                z11 = false;
            }
            if (z11) {
                i8 = 0;
            }
            boolean z2112 = !this.mCenter.isConnected();
            boolean[] zArr7 = this.mIsInBarrier;
            boolean z2113 = zArr7[0];
            boolean z2114 = zArr7[1];
            if (this.mHorizontalResolution != 2) {
                z14 = z8;
                solverVariable2 = solverVariableCreateObjectVariable3;
                z13 = z18;
                z12 = z20;
                i10 = i6;
            } else {
                z14 = z8;
                solverVariable2 = solverVariableCreateObjectVariable3;
                z13 = z18;
                z12 = z20;
                i10 = i6;
            }
            if (z6) {
                solverVariable3 = solverVariable2;
                solverVariable4 = solverVariable6;
                solverVariable5 = r24;
                i11 = 0;
                c = 1;
                i12 = 8;
                i13 = 1;
            } else {
                solverVariable3 = solverVariable2;
                solverVariable4 = solverVariable6;
                solverVariable5 = r24;
                i11 = 0;
                c = 1;
                i12 = 8;
                i13 = 1;
            }
            if (this.mVerticalResolution == 2) {
                i14 = i11;
            } else {
                i14 = i13;
            }
            if (i14 == 0) {
            }
            if (!z9) {
                linearSystem2 = linearSystem;
            } else if (this.mResolvedDimensionRatioSide == 1) {
                linearSystem.addRatio(solverVariable4, solverVariable3, solverVariable, solverVariableCreateObjectVariable, this.mResolvedDimensionRatio, 8);
                linearSystem2 = linearSystem;
            } else {
                linearSystem.addRatio(solverVariable, solverVariableCreateObjectVariable, solverVariable4, solverVariable3, this.mResolvedDimensionRatio, 8);
                linearSystem2 = linearSystem;
            }
            if (this.mCenter.isConnected()) {
                linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
            }
            this.mResolvedHorizontal = false;
            this.mResolvedVertical = false;
            metrics = LinearSystem.sMetrics;
            if (metrics != null) {
                metrics.mEquations = linearSystem2.getNumEquations();
                LinearSystem.sMetrics.mVariables = linearSystem2.getNumVariables();
            }
        }
        i5 = i20;
        solverVariable = solverVariableCreateObjectVariable2;
        i6 = i25;
        i7 = i26;
        i8 = i5;
        z9 = false;
        int[] iArr4 = this.mResolvedMatchConstraintDefault;
        iArr4[0] = i6;
        iArr4[1] = i7;
        this.mResolvedHasRatio = z9;
        if (z9) {
            int i212 = this.mResolvedDimensionRatioSide;
            i9 = -1;
            if (i212 != 0) {
            }
            if (z9) {
                z10 = false;
            } else {
                z10 = false;
            }
            dimensionBehaviour = this.mListDimensionBehaviors[0];
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour == dimensionBehaviour2) {
                z11 = false;
            } else {
                z11 = false;
            }
            if (z11) {
                i8 = 0;
            }
            boolean z2115 = !this.mCenter.isConnected();
            boolean[] zArr8 = this.mIsInBarrier;
            boolean z2116 = zArr8[0];
            boolean z2117 = zArr8[1];
            if (this.mHorizontalResolution != 2) {
                z14 = z8;
                solverVariable2 = solverVariableCreateObjectVariable3;
                z13 = z18;
                z12 = z20;
                i10 = i6;
            } else {
                z14 = z8;
                solverVariable2 = solverVariableCreateObjectVariable3;
                z13 = z18;
                z12 = z20;
                i10 = i6;
            }
            if (z6) {
                solverVariable3 = solverVariable2;
                solverVariable4 = solverVariable6;
                solverVariable5 = r24;
                i11 = 0;
                c = 1;
                i12 = 8;
                i13 = 1;
            } else {
                solverVariable3 = solverVariable2;
                solverVariable4 = solverVariable6;
                solverVariable5 = r24;
                i11 = 0;
                c = 1;
                i12 = 8;
                i13 = 1;
            }
            if (this.mVerticalResolution == 2) {
                i14 = i11;
            } else {
                i14 = i13;
            }
            if (i14 == 0) {
            }
            if (!z9) {
                linearSystem2 = linearSystem;
            } else if (this.mResolvedDimensionRatioSide == 1) {
                linearSystem.addRatio(solverVariable4, solverVariable3, solverVariable, solverVariableCreateObjectVariable, this.mResolvedDimensionRatio, 8);
                linearSystem2 = linearSystem;
            } else {
                linearSystem.addRatio(solverVariable, solverVariableCreateObjectVariable, solverVariable4, solverVariable3, this.mResolvedDimensionRatio, 8);
                linearSystem2 = linearSystem;
            }
            if (this.mCenter.isConnected()) {
                linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
            }
            this.mResolvedHorizontal = false;
            this.mResolvedVertical = false;
            metrics = LinearSystem.sMetrics;
            if (metrics != null) {
                metrics.mEquations = linearSystem2.getNumEquations();
                LinearSystem.sMetrics.mVariables = linearSystem2.getNumVariables();
            }
        }
        i9 = -1;
        if (z9) {
            z10 = false;
        } else {
            z10 = false;
        }
        dimensionBehaviour = this.mListDimensionBehaviors[0];
        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z11 = false;
        } else {
            z11 = false;
        }
        if (z11) {
            i8 = 0;
        }
        boolean z2118 = !this.mCenter.isConnected();
        boolean[] zArr9 = this.mIsInBarrier;
        boolean z2119 = zArr9[0];
        boolean z21110 = zArr9[1];
        if (this.mHorizontalResolution != 2) {
            z14 = z8;
            solverVariable2 = solverVariableCreateObjectVariable3;
            z13 = z18;
            z12 = z20;
            i10 = i6;
        } else {
            z14 = z8;
            solverVariable2 = solverVariableCreateObjectVariable3;
            z13 = z18;
            z12 = z20;
            i10 = i6;
        }
        if (z6) {
            solverVariable3 = solverVariable2;
            solverVariable4 = solverVariable6;
            solverVariable5 = r24;
            i11 = 0;
            c = 1;
            i12 = 8;
            i13 = 1;
        } else {
            solverVariable3 = solverVariable2;
            solverVariable4 = solverVariable6;
            solverVariable5 = r24;
            i11 = 0;
            c = 1;
            i12 = 8;
            i13 = 1;
        }
        if (this.mVerticalResolution == 2) {
            i14 = i11;
        } else {
            i14 = i13;
        }
        if (i14 == 0) {
        }
        if (!z9) {
            linearSystem2 = linearSystem;
        } else if (this.mResolvedDimensionRatioSide == 1) {
            linearSystem.addRatio(solverVariable4, solverVariable3, solverVariable, solverVariableCreateObjectVariable, this.mResolvedDimensionRatio, 8);
            linearSystem2 = linearSystem;
        } else {
            linearSystem.addRatio(solverVariable, solverVariableCreateObjectVariable, solverVariable4, solverVariable3, this.mResolvedDimensionRatio, 8);
            linearSystem2 = linearSystem;
        }
        if (this.mCenter.isConnected()) {
            linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
        }
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        metrics = LinearSystem.sMetrics;
        if (metrics != null) {
            metrics.mEquations = linearSystem2.getNumEquations();
            LinearSystem.sMetrics.mVariables = linearSystem2.getNumVariables();
        }
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i5) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i5);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f6, int i5) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i5, 0);
        this.mCircleConstraintAngle = f6;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.mHasBaseline = constraintWidget.mHasBaseline;
        this.mInPlaceholder = constraintWidget.mInPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        this.mParent = this.mParent == null ? null : map.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mAnimated = constraintWidget.mAnimated;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.mVerticalNextWidget;
        this.mVerticalNextWidget = constraintWidget3 != null ? map.get(constraintWidget3) : null;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.mHorizontalRun == null) {
            this.mHorizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.mVerticalRun == null) {
            this.mVerticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i5) {
        if (i5 == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i5 == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i5) {
        if (i5 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i5 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.mHasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i5 = constraintAnchor != null ? constraintAnchor.mMargin : 0;
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i5 + constraintAnchor2.mMargin : i5;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i5) {
        if (i5 == 0) {
            return getWidth();
        }
        if (i5 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i5) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i5 != 0) {
            if (i5 == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getOptimizerWrapHeight() {
        int iMax = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                iMax = Math.max(this.mMatchConstraintMinHeight, iMax);
            } else {
                iMax = this.mMatchConstraintMinHeight;
                if (iMax > 0) {
                    this.mHeight = iMax;
                } else {
                    iMax = 0;
                }
            }
            int i5 = this.mMatchConstraintMaxHeight;
            if (i5 > 0 && i5 < iMax) {
                return i5;
            }
        }
        return iMax;
    }

    public int getOptimizerWrapWidth() {
        int i5 = this.mWidth;
        int iMax = 0;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i5;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            iMax = Math.max(this.mMatchConstraintMinWidth, i5);
        } else {
            int i6 = this.mMatchConstraintMinWidth;
            if (i6 > 0) {
                this.mWidth = i6;
                iMax = i6;
            }
        }
        int i7 = this.mMatchConstraintMaxWidth;
        return (i7 <= 0 || i7 >= iMax) ? iMax : i7;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i5) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i5 != 0) {
            if (i5 == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getRelativePositioning(int i5) {
        if (i5 == 0) {
            return this.mRelX;
        }
        if (i5 == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i5) {
        if (i5 == 0) {
            return this.mHorizontalRun;
        }
        if (i5 == 1) {
            return this.mVerticalRun;
        }
        return null;
    }

    public void getSceneString(StringBuilder sb) {
        sb.append("  " + this.stringId + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.mWidth);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.mHeight);
        sb.append("\n");
        sb.append("    actualLeft:" + this.mX);
        sb.append("\n");
        sb.append("    actualTop:" + this.mY);
        sb.append("\n");
        getSceneString(sb, "left", this.mLeft);
        getSceneString(sb, "top", this.mTop);
        getSceneString(sb, "right", this.mRight);
        getSceneString(sb, "bottom", this.mBottom);
        getSceneString(sb, "baseline", this.mBaseline);
        getSceneString(sb, "centerX", this.mCenterX);
        getSceneString(sb, "centerY", this.mCenterY);
        getSceneString(sb, "    width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mListDimensionBehaviors[0], this.mWeight[0]);
        getSceneString(sb, "    height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mListDimensionBehaviors[1], this.mWeight[1]);
        serializeDimensionRatio(sb, "    dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb, "    horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "    verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "    horizontalChainStyle", this.mHorizontalChainStyle, 0);
        serializeAttribute(sb, "    verticalChainStyle", this.mVerticalChainStyle, 0);
        sb.append("  }");
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i5 = this.mLeft != null ? this.mTop.mMargin : 0;
        return this.mRight != null ? i5 + this.mBottom.mMargin : i5;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapBehaviorInParent() {
        return this.mWrapBehaviorInParent;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mX : ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mY : ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.mHasBaseline;
    }

    public boolean hasDanglingDimension(int i5) {
        if (i5 == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.mAnchors.get(i5).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        return (this.mWidthOverride == -1 && this.mHeightOverride == -1) ? false : true;
    }

    public boolean hasResolvedTargets(int i5, int i6) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i5 == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft.mTarget;
            if (constraintAnchor3 != null && constraintAnchor3.hasFinalValue() && (constraintAnchor2 = this.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) {
                return (this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.getMargin() + this.mLeft.mTarget.getFinalValue()) >= i6;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.mTop.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.hasFinalValue() && (constraintAnchor = this.mBottom.mTarget) != null && constraintAnchor.hasFinalValue()) {
                if ((this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.getMargin() + this.mTop.mTarget.getFinalValue()) >= i6) {
                    return true;
                }
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i5, int i6) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i5, i6, true);
    }

    public boolean isAnimated() {
        return this.mAnimated;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.mHorizontalSolvingPass;
    }

    public boolean isInBarrier(int i5) {
        return this.mIsInBarrier[i5];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.mInPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        if (this.mResolvedHorizontal) {
            return true;
        }
        return this.mLeft.hasFinalValue() && this.mRight.hasFinalValue();
    }

    public boolean isResolvedVertically() {
        if (this.mResolvedVertical) {
            return true;
        }
        return this.mTop.hasFinalValue() && this.mBottom.hasFinalValue();
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.mVerticalSolvingPass;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.mHorizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.mVerticalSolvingPass = true;
    }

    public boolean oppositeDimensionDependsOn(int i5) {
        char c = i5 == 0 ? (char) 1 : (char) 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i5];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = Float.NaN;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f6 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f6;
        this.mVerticalBiasPercent = f6;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
            if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
        } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.mAnchors.get(i5).reset();
        }
    }

    public void resetFinalResolution() {
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        int size = this.mAnchors.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.mAnchors.get(i5).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void resetSolvingPassFlag() {
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
    }

    public StringBuilder serialize(StringBuilder sb) {
        sb.append("{\n");
        serializeAnchor(sb, "left", this.mLeft);
        serializeAnchor(sb, "top", this.mTop);
        serializeAnchor(sb, "right", this.mRight);
        serializeAnchor(sb, "bottom", this.mBottom);
        serializeAnchor(sb, "baseline", this.mBaseline);
        serializeAnchor(sb, "centerX", this.mCenterX);
        serializeAnchor(sb, "centerY", this.mCenterY);
        serializeCircle(sb, this.mCenter, this.mCircleConstraintAngle);
        serializeSize(sb, "width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        serializeSize(sb, "height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(sb, "dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb, "horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb, "verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        sb.append("}\n");
        return sb;
    }

    public void setAnimated(boolean z6) {
        this.mAnimated = z6;
    }

    public void setBaselineDistance(int i5) {
        this.mBaselineDistance = i5;
        this.mHasBaseline = i5 > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i5) {
        if (i5 >= 0) {
            this.mContainerItemSkip = i5;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        solverVariableCreateObjectVariable.setName(str + ".left");
        solverVariableCreateObjectVariable2.setName(str + ".top");
        solverVariableCreateObjectVariable3.setName(str + ".right");
        solverVariableCreateObjectVariable4.setName(str + ".bottom");
        linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
    }

    public void setDimension(int i5, int i6) {
        this.mWidth = i5;
        int i7 = this.mMinWidth;
        if (i5 < i7) {
            this.mWidth = i7;
        }
        this.mHeight = i6;
        int i8 = this.mMinHeight;
        if (i6 < i8) {
            this.mHeight = i8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086 A[PHI: r0
  0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String str) {
        float fAbs;
        int i5 = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i6 = 0;
        int i7 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!strSubstring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                i6 = strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            }
            i7 = i6;
            i6 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i6);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = i5;
                }
            } else {
                String strSubstring3 = str.substring(i6, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = i5;
                } else {
                    float f6 = Float.parseFloat(strSubstring3);
                    float f7 = Float.parseFloat(strSubstring4);
                    if (f6 <= 0.0f || f7 <= 0.0f) {
                        fAbs = i5;
                    } else {
                        fAbs = i7 == 1 ? Math.abs(f7 / f6) : Math.abs(f6 / f7);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i5 = (fAbs > i5 ? 1 : (fAbs == i5 ? 0 : -1));
        if (i5 > 0) {
            this.mDimensionRatio = fAbs;
            this.mDimensionRatioSide = i7;
        }
    }

    public void setFinalBaseline(int i5) {
        if (this.mHasBaseline) {
            int i6 = i5 - this.mBaselineDistance;
            int i7 = this.mHeight + i6;
            this.mY = i6;
            this.mTop.setFinalValue(i6);
            this.mBottom.setFinalValue(i7);
            this.mBaseline.setFinalValue(i5);
            this.mResolvedVertical = true;
        }
    }

    public void setFinalFrame(int i5, int i6, int i7, int i8, int i9, int i10) {
        setFrame(i5, i6, i7, i8);
        setBaselineDistance(i9);
        if (i10 == 0) {
            this.mResolvedHorizontal = true;
            this.mResolvedVertical = false;
        } else if (i10 == 1) {
            this.mResolvedHorizontal = false;
            this.mResolvedVertical = true;
        } else if (i10 == 2) {
            this.mResolvedHorizontal = true;
            this.mResolvedVertical = true;
        } else {
            this.mResolvedHorizontal = false;
            this.mResolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i5, int i6) {
        if (this.mResolvedHorizontal) {
            return;
        }
        this.mLeft.setFinalValue(i5);
        this.mRight.setFinalValue(i6);
        this.mX = i5;
        this.mWidth = i6 - i5;
        this.mResolvedHorizontal = true;
    }

    public void setFinalLeft(int i5) {
        this.mLeft.setFinalValue(i5);
        this.mX = i5;
    }

    public void setFinalTop(int i5) {
        this.mTop.setFinalValue(i5);
        this.mY = i5;
    }

    public void setFinalVertical(int i5, int i6) {
        if (this.mResolvedVertical) {
            return;
        }
        this.mTop.setFinalValue(i5);
        this.mBottom.setFinalValue(i6);
        this.mY = i5;
        this.mHeight = i6 - i5;
        if (this.mHasBaseline) {
            this.mBaseline.setFinalValue(i5 + this.mBaselineDistance);
        }
        this.mResolvedVertical = true;
    }

    public void setFrame(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11 = i7 - i5;
        int i12 = i8 - i6;
        this.mX = i5;
        this.mY = i6;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i11 < (i10 = this.mWidth)) {
            i11 = i10;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i12 < (i9 = this.mHeight)) {
            i12 = i9;
        }
        this.mWidth = i11;
        this.mHeight = i12;
        int i13 = this.mMinHeight;
        if (i12 < i13) {
            this.mHeight = i13;
        }
        int i14 = this.mMinWidth;
        if (i11 < i14) {
            this.mWidth = i14;
        }
        int i15 = this.mMatchConstraintMaxWidth;
        if (i15 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mWidth = Math.min(this.mWidth, i15);
        }
        int i16 = this.mMatchConstraintMaxHeight;
        if (i16 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mHeight = Math.min(this.mHeight, i16);
        }
        int i17 = this.mWidth;
        if (i11 != i17) {
            this.mWidthOverride = i17;
        }
        int i18 = this.mHeight;
        if (i12 != i18) {
            this.mHeightOverride = i18;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i5) {
        int i6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i6 == 1) {
            this.mLeft.mGoneMargin = i5;
            return;
        }
        if (i6 == 2) {
            this.mTop.mGoneMargin = i5;
            return;
        }
        if (i6 == 3) {
            this.mRight.mGoneMargin = i5;
        } else if (i6 == 4) {
            this.mBottom.mGoneMargin = i5;
        } else {
            if (i6 != 5) {
                return;
            }
            this.mBaseline.mGoneMargin = i5;
        }
    }

    public void setHasBaseline(boolean z6) {
        this.mHasBaseline = z6;
    }

    public void setHeight(int i5) {
        this.mHeight = i5;
        int i6 = this.mMinHeight;
        if (i5 < i6) {
            this.mHeight = i6;
        }
    }

    public void setHeightWrapContent(boolean z6) {
        this.mIsHeightWrapContent = z6;
    }

    public void setHorizontalBiasPercent(float f6) {
        this.mHorizontalBiasPercent = f6;
    }

    public void setHorizontalChainStyle(int i5) {
        this.mHorizontalChainStyle = i5;
    }

    public void setHorizontalDimension(int i5, int i6) {
        this.mX = i5;
        int i7 = i6 - i5;
        this.mWidth = i7;
        int i8 = this.mMinWidth;
        if (i7 < i8) {
            this.mWidth = i8;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i5, int i6, int i7, float f6) {
        this.mMatchConstraintDefaultWidth = i5;
        this.mMatchConstraintMinWidth = i6;
        if (i7 == Integer.MAX_VALUE) {
            i7 = 0;
        }
        this.mMatchConstraintMaxWidth = i7;
        this.mMatchConstraintPercentWidth = f6;
        if (f6 <= 0.0f || f6 >= 1.0f || i5 != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f6) {
        this.mWeight[0] = f6;
    }

    public void setInBarrier(int i5, boolean z6) {
        this.mIsInBarrier[i5] = z6;
    }

    public void setInPlaceholder(boolean z6) {
        this.mInPlaceholder = z6;
    }

    public void setInVirtualLayout(boolean z6) {
        this.mInVirtualLayout = z6;
    }

    public void setLastMeasureSpec(int i5, int i6) {
        this.mLastHorizontalMeasureSpec = i5;
        this.mLastVerticalMeasureSpec = i6;
        setMeasureRequested(false);
    }

    public void setLength(int i5, int i6) {
        if (i6 == 0) {
            setWidth(i5);
        } else if (i6 == 1) {
            setHeight(i5);
        }
    }

    public void setMaxHeight(int i5) {
        this.mMaxDimension[1] = i5;
    }

    public void setMaxWidth(int i5) {
        this.mMaxDimension[0] = i5;
    }

    public void setMeasureRequested(boolean z6) {
        this.mMeasureRequested = z6;
    }

    public void setMinHeight(int i5) {
        if (i5 < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i5;
        }
    }

    public void setMinWidth(int i5) {
        if (i5 < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i5;
        }
    }

    public void setOffset(int i5, int i6) {
        this.mOffsetX = i5;
        this.mOffsetY = i6;
    }

    public void setOrigin(int i5, int i6) {
        this.mX = i5;
        this.mY = i6;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setRelativePositioning(int i5, int i6) {
        if (i6 == 0) {
            this.mRelX = i5;
        } else if (i6 == 1) {
            this.mRelY = i5;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f6) {
        this.mVerticalBiasPercent = f6;
    }

    public void setVerticalChainStyle(int i5) {
        this.mVerticalChainStyle = i5;
    }

    public void setVerticalDimension(int i5, int i6) {
        this.mY = i5;
        int i7 = i6 - i5;
        this.mHeight = i7;
        int i8 = this.mMinHeight;
        if (i7 < i8) {
            this.mHeight = i8;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i5, int i6, int i7, float f6) {
        this.mMatchConstraintDefaultHeight = i5;
        this.mMatchConstraintMinHeight = i6;
        if (i7 == Integer.MAX_VALUE) {
            i7 = 0;
        }
        this.mMatchConstraintMaxHeight = i7;
        this.mMatchConstraintPercentHeight = f6;
        if (f6 <= 0.0f || f6 >= 1.0f || i5 != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f6) {
        this.mWeight[1] = f6;
    }

    public void setVisibility(int i5) {
        this.mVisibility = i5;
    }

    public void setWidth(int i5) {
        this.mWidth = i5;
        int i6 = this.mMinWidth;
        if (i5 < i6) {
            this.mWidth = i6;
        }
    }

    public void setWidthWrapContent(boolean z6) {
        this.mIsWidthWrapContent = z6;
    }

    public void setWrapBehaviorInParent(int i5) {
        if (i5 < 0 || i5 > 3) {
            return;
        }
        this.mWrapBehaviorInParent = i5;
    }

    public void setX(int i5) {
        this.mX = i5;
    }

    public void setY(int i5) {
        this.mY = i5;
    }

    public void setupDimensionRatio(boolean z6, boolean z7, boolean z8, boolean z9) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z8 && !z9) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z8 && z9) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i5 = this.mMatchConstraintMinWidth;
            if (i5 > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else {
                if (i5 != 0 || this.mMatchConstraintMinHeight <= 0) {
                    return;
                }
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mType != null ? AbstractC0157z.s(new StringBuilder("type: "), this.mType, " ") : "");
        sb.append(this.mDebugName != null ? AbstractC0157z.s(new StringBuilder("id: "), this.mDebugName, " ") : "");
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        return AbstractC0157z.l(")", this.mHeight, sb);
    }

    public void updateFromRuns(boolean z6, boolean z7) {
        int i5;
        int i6;
        boolean zIsResolved = z6 & this.mHorizontalRun.isResolved();
        boolean zIsResolved2 = z7 & this.mVerticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.mHorizontalRun;
        int i7 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.mVerticalRun;
        int i8 = verticalWidgetRun.start.value;
        int i9 = horizontalWidgetRun.end.value;
        int i10 = verticalWidgetRun.end.value;
        int i11 = i10 - i8;
        if (i9 - i7 < 0 || i11 < 0 || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE) {
            i9 = 0;
            i7 = 0;
            i10 = 0;
            i8 = 0;
        }
        int i12 = i9 - i7;
        int i13 = i10 - i8;
        if (zIsResolved) {
            this.mX = i7;
        }
        if (zIsResolved2) {
            this.mY = i8;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (zIsResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i12 < (i6 = this.mWidth)) {
                i12 = i6;
            }
            this.mWidth = i12;
            int i14 = this.mMinWidth;
            if (i12 < i14) {
                this.mWidth = i14;
            }
        }
        if (zIsResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i13 < (i5 = this.mHeight)) {
                i13 = i5;
            }
            this.mHeight = i13;
            int i15 = this.mMinHeight;
            if (i13 < i15) {
                this.mHeight = i15;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z6) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z6 && (horizontalWidgetRun = this.mHorizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z6 && (verticalWidgetRun = this.mVerticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i5 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i5 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i5) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z6;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 == type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                ConstraintAnchor anchor = getAnchor(type6);
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor anchor2 = getAnchor(type7);
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor anchor3 = getAnchor(type8);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor anchor4 = getAnchor(type9);
                boolean z7 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(type6, constraintWidget, type6, 0);
                    connect(type7, constraintWidget, type7, 0);
                    z6 = true;
                } else {
                    z6 = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(type8, constraintWidget, type8, 0);
                    connect(type9, constraintWidget, type9, 0);
                } else {
                    z7 = false;
                }
                if (z6 && z7) {
                    getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
                    return;
                }
                if (z6) {
                    ConstraintAnchor.Type type10 = ConstraintAnchor.Type.CENTER_X;
                    getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                    return;
                } else {
                    if (z7) {
                        ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_Y;
                        getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor.Type type12 = ConstraintAnchor.Type.LEFT;
            if (type2 != type12 && type2 != ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor.Type type13 = ConstraintAnchor.Type.TOP;
                if (type2 == type13 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(type13, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                return;
            }
            connect(type12, constraintWidget, type2, 0);
            connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(type4);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(type14).connect(anchor6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type3).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(type15).connect(anchor8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            getAnchor(type16).connect(constraintWidget.getAnchor(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            getAnchor(type14).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            getAnchor(type19).connect(constraintWidget.getAnchor(type19), 0);
            getAnchor(type15).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
            } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor13 = getAnchor(type5);
                    if (anchor13.getTarget() != anchor10) {
                        anchor13.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor14 = getAnchor(type14);
                    if (anchor14.isConnected()) {
                        opposite.reset();
                        anchor14.reset();
                    }
                }
            } else {
                ConstraintAnchor anchor15 = getAnchor(type20);
                if (anchor15 != null) {
                    anchor15.reset();
                }
                ConstraintAnchor anchor16 = getAnchor(type5);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                ConstraintAnchor anchor17 = getAnchor(type15);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i5);
        }
    }

    private void serializeAttribute(StringBuilder sb, String str, int i5, int i6) {
        if (i5 == i6) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i5);
        sb.append(",\n");
    }

    private void serializeAttribute(StringBuilder sb, String str, String str2, String str3) {
        if (str3.equals(str2)) {
            return;
        }
        a.y(sb, str, " :   ", str2, ",\n");
    }

    public void setDimensionRatio(float f6, int i5) {
        this.mDimensionRatio = f6;
        this.mDimensionRatioSide = i5;
    }

    public void setFrame(int i5, int i6, int i7) {
        if (i7 == 0) {
            setHorizontalDimension(i5, i6);
        } else if (i7 == 1) {
            setVerticalDimension(i5, i6);
        }
    }

    private void getSceneString(StringBuilder sb, String str, int i5, int i6, int i7, int i8, int i9, int i10, float f6, DimensionBehaviour dimensionBehaviour, float f7) {
        sb.append(str);
        sb.append(" :  {\n");
        serializeAttribute(sb, "      behavior", dimensionBehaviour.toString(), DimensionBehaviour.FIXED.toString());
        serializeAttribute(sb, "      size", i5, 0);
        serializeAttribute(sb, "      min", i6, 0);
        serializeAttribute(sb, "      max", i7, Integer.MAX_VALUE);
        serializeAttribute(sb, "      matchMin", i9, 0);
        serializeAttribute(sb, "      matchDef", i10, 0);
        serializeAttribute(sb, "      matchPercent", f6, 1.0f);
        sb.append("    },\n");
    }

    private void getSceneString(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        a.x(sb, "    ", str, " : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("'");
        if (constraintAnchor.mGoneMargin != Integer.MIN_VALUE || constraintAnchor.mMargin != 0) {
            sb.append(",");
            sb.append(constraintAnchor.mMargin);
            if (constraintAnchor.mGoneMargin != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.mGoneMargin);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.mOptimizeWrapO = false;
        this.mOptimizeWrapOnResolved = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.mHasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f6 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f6;
        this.mVerticalBiasPercent = f6;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i5, int i6, int i7, int i8) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.mHorizontalRun = null;
        this.mVerticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.mOptimizeWrapO = false;
        this.mOptimizeWrapOnResolved = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.mResolvedHorizontal = false;
        this.mResolvedVertical = false;
        this.mHorizontalSolvingPass = false;
        this.mVerticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = Float.NaN;
        this.mHasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f6 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f6;
        this.mVerticalBiasPercent = f6;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i5;
        this.mY = i6;
        this.mWidth = i7;
        this.mHeight = i8;
        addAnchors();
    }

    public ConstraintWidget(String str, int i5, int i6, int i7, int i8) {
        this(i5, i6, i7, i8);
        setDebugName(str);
    }

    public ConstraintWidget(int i5, int i6) {
        this(0, 0, i5, i6);
    }

    public ConstraintWidget(String str, int i5, int i6) {
        this(i5, i6);
        setDebugName(str);
    }
}
