package androidx.constraintlayout.core.state;

import A3.AbstractC0157z;
import androidx.annotation.NonNull;
import androidx.collection.a;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.core.os.EnvironmentCompat;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class WidgetFrame {
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    private final HashMap<String, CustomVariable> mCustom;
    TypedBundle mMotionProperties;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
    }

    private static void add(StringBuilder sb, String str, int i5) {
        sb.append(str);
        sb.append(": ");
        sb.append(i5);
        sb.append(",\n");
    }

    public static void interpolate(int i5, int i6, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f6) {
        int i7;
        int i8;
        float f7;
        int i9;
        float f8;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f9 = 100.0f * f6;
        int i15 = (int) f9;
        int i16 = widgetFrame2.left;
        int i17 = widgetFrame2.top;
        int i18 = widgetFrame3.left;
        int i19 = widgetFrame3.top;
        int i20 = widgetFrame2.right - i16;
        int i21 = widgetFrame2.bottom - i17;
        int i22 = widgetFrame3.right - i18;
        int i23 = widgetFrame3.bottom - i19;
        int i24 = i16;
        float f10 = widgetFrame2.alpha;
        float f11 = widgetFrame3.alpha;
        if (widgetFrame2.visibility == 8) {
            int i25 = i24 - ((int) (i22 / 2.0f));
            i8 = i17 - ((int) (i23 / 2.0f));
            if (Float.isNaN(f10)) {
                i24 = i25;
                i7 = i22;
                f7 = 0.0f;
            } else {
                i24 = i25;
                i7 = i22;
                f7 = f10;
            }
        } else {
            i23 = i21;
            i7 = i20;
            i8 = i17;
            f7 = f10;
        }
        if (widgetFrame3.visibility == 8) {
            i18 -= (int) (i7 / 2.0f);
            i19 -= (int) (i23 / 2.0f);
            if (Float.isNaN(f11)) {
                i9 = i23;
                i22 = i7;
                f11 = 0.0f;
            } else {
                i9 = i23;
                i22 = i7;
            }
        } else {
            i9 = i23;
        }
        if (Float.isNaN(f7) && !Float.isNaN(f11)) {
            f7 = 1.0f;
        }
        if (!Float.isNaN(f7) && Float.isNaN(f11)) {
            f11 = 1.0f;
        }
        int i26 = i18;
        float f12 = widgetFrame2.visibility == 4 ? 0.0f : f7;
        int i27 = i19;
        float f13 = widgetFrame3.visibility == 4 ? 0.0f : f11;
        if (widgetFrame.widget == null || !transition.hasPositionKeyframes()) {
            f8 = f6;
            i10 = i26;
            i11 = i27;
            i12 = i8;
        } else {
            Transition.KeyPosition keyPositionFindPreviousPosition = transition.findPreviousPosition(widgetFrame.widget.stringId, i15);
            int i28 = i8;
            Transition.KeyPosition keyPositionFindNextPosition = transition.findNextPosition(widgetFrame.widget.stringId, i15);
            if (keyPositionFindPreviousPosition == keyPositionFindNextPosition) {
                keyPositionFindNextPosition = null;
            }
            if (keyPositionFindPreviousPosition != null) {
                i24 = (int) (keyPositionFindPreviousPosition.mX * i5);
                i12 = (int) (keyPositionFindPreviousPosition.mY * i6);
                i13 = keyPositionFindPreviousPosition.mFrame;
            } else {
                i13 = 0;
                i12 = i28;
            }
            if (keyPositionFindNextPosition != null) {
                i10 = (int) (keyPositionFindNextPosition.mX * i5);
                i11 = (int) (keyPositionFindNextPosition.mY * i6);
                i14 = keyPositionFindNextPosition.mFrame;
            } else {
                i14 = 100;
                i10 = i26;
                i11 = i27;
            }
            f8 = (f9 - i13) / (i14 - i13);
        }
        int i29 = i24;
        widgetFrame.widget = widgetFrame2.widget;
        int i30 = (int) (((i10 - i29) * f8) + i29);
        widgetFrame.left = i30;
        int i31 = (int) ((f8 * (i11 - i12)) + i12);
        widgetFrame.top = i31;
        float f14 = 1.0f - f6;
        widgetFrame.right = i30 + ((int) ((i22 * f6) + (i7 * f14)));
        widgetFrame.bottom = i31 + ((int) ((i9 * f6) + (f14 * i23)));
        widgetFrame.pivotX = interpolate(widgetFrame2.pivotX, widgetFrame3.pivotX, 0.5f, f6);
        widgetFrame.pivotY = interpolate(widgetFrame2.pivotY, widgetFrame3.pivotY, 0.5f, f6);
        widgetFrame.rotationX = interpolate(widgetFrame2.rotationX, widgetFrame3.rotationX, 0.0f, f6);
        widgetFrame.rotationY = interpolate(widgetFrame2.rotationY, widgetFrame3.rotationY, 0.0f, f6);
        widgetFrame.rotationZ = interpolate(widgetFrame2.rotationZ, widgetFrame3.rotationZ, 0.0f, f6);
        widgetFrame.scaleX = interpolate(widgetFrame2.scaleX, widgetFrame3.scaleX, 1.0f, f6);
        widgetFrame.scaleY = interpolate(widgetFrame2.scaleY, widgetFrame3.scaleY, 1.0f, f6);
        widgetFrame.translationX = interpolate(widgetFrame2.translationX, widgetFrame3.translationX, 0.0f, f6);
        widgetFrame.translationY = interpolate(widgetFrame2.translationY, widgetFrame3.translationY, 0.0f, f6);
        widgetFrame.translationZ = interpolate(widgetFrame2.translationZ, widgetFrame3.translationZ, 0.0f, f6);
        widgetFrame.alpha = interpolate(f12, f13, 1.0f, f6);
        Set<String> setKeySet = widgetFrame3.mCustom.keySet();
        widgetFrame.mCustom.clear();
        for (String str : setKeySet) {
            if (widgetFrame2.mCustom.containsKey(str)) {
                CustomVariable customVariable = widgetFrame2.mCustom.get(str);
                CustomVariable customVariable2 = widgetFrame3.mCustom.get(str);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame.mCustom.put(str, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue(Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f6)));
                } else {
                    int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[iNumberOfInterpolatedValues];
                    float[] fArr2 = new float[iNumberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i32 = 0; i32 < iNumberOfInterpolatedValues; i32++) {
                        fArr[i32] = interpolate(fArr[i32], fArr2[i32], 0.0f, f6);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    private void serializeAnchor(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor == null || anchor.mTarget == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(type.name());
        sb.append(": ['");
        String str = anchor.mTarget.getOwner().stringId;
        if (str == null) {
            str = "#PARENT";
        }
        sb.append(str);
        sb.append("', '");
        sb.append(anchor.mTarget.getType().name());
        sb.append("', '");
        sb.append(anchor.mMargin);
        sb.append("'],\n");
    }

    public void addCustomColor(String str, int i5) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, i5);
    }

    public void addCustomFloat(String str, float f6) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_FLOAT, f6);
    }

    public float centerX() {
        int i5 = this.left;
        return ((this.right - i5) / 2.0f) + i5;
    }

    public float centerY() {
        int i5 = this.top;
        return ((this.bottom - i5) / 2.0f) + i5;
    }

    public boolean containsCustom(@NonNull String str) {
        return this.mCustom.containsKey(str);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        return constraintWidget == null ? EnvironmentCompat.MEDIA_UNKNOWN : constraintWidget.stringId;
    }

    public TypedBundle getMotionProperties() {
        return this.mMotionProperties;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        return Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha);
    }

    public void logv(String str) {
        String strN;
        StackTraceElement stackTraceElement = a.z()[1];
        StringBuilder sbX = AbstractC0157z.x(".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName(), " ");
        sbX.append(hashCode() % 1000);
        String string = sbX.toString();
        if (this.widget != null) {
            StringBuilder sbX2 = AbstractC0157z.x(string, PackagingURIHelper.FORWARD_SLASH_STRING);
            sbX2.append(this.widget.hashCode() % 1000);
            strN = sbX2.toString();
        } else {
            strN = a.n(string, "/NULL");
        }
        System.out.println(strN + " " + str);
    }

    public void parseCustom(CLElement cLElement) {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i5 = 0; i5 < size; i5++) {
            CLElement value = ((CLKey) cLObject.get(i5)).getValue();
            String strContent = value.content();
            if (strContent.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_COLOR, Integer.parseInt(strContent.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_FLOAT, value.getFloat());
            } else {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_STRING, strContent);
            }
        }
    }

    public void printCustomAttributes() {
        String strN;
        StackTraceElement stackTraceElement = a.z()[1];
        StringBuilder sbX = AbstractC0157z.x(".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName(), " ");
        sbX.append(hashCode() % 1000);
        String string = sbX.toString();
        if (this.widget != null) {
            StringBuilder sbX2 = AbstractC0157z.x(string, PackagingURIHelper.FORWARD_SLASH_STRING);
            sbX2.append(this.widget.hashCode() % 1000);
            sbX2.append(" ");
            strN = sbX2.toString();
        } else {
            strN = a.n(string, "/NULL ");
        }
        HashMap<String, CustomVariable> map = this.mCustom;
        if (map != null) {
            for (String str : map.keySet()) {
                PrintStream printStream = System.out;
                StringBuilder sbR = a.r(strN);
                sbR.append(this.mCustom.get(str).toString());
                printStream.println(sbR.toString());
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public void setCustomAttribute(String str, int i5, float f6) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f6);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i5, f6));
        }
    }

    public void setMotionAttributes(TypedBundle typedBundle) {
        this.mMotionProperties = typedBundle;
    }

    public boolean setValue(String str, CLElement cLElement) {
        str.getClass();
        switch (str) {
            case "phone_orientation":
                phone_orientation = cLElement.getFloat();
                return true;
            case "bottom":
                this.bottom = cLElement.getInt();
                return true;
            case "custom":
                parseCustom(cLElement);
                return true;
            case "rotationX":
                this.rotationX = cLElement.getFloat();
                return true;
            case "rotationY":
                this.rotationY = cLElement.getFloat();
                return true;
            case "rotationZ":
                this.rotationZ = cLElement.getFloat();
                return true;
            case "translationX":
                this.translationX = cLElement.getFloat();
                return true;
            case "translationY":
                this.translationY = cLElement.getFloat();
                return true;
            case "translationZ":
                this.translationZ = cLElement.getFloat();
                return true;
            case "pivotX":
                this.pivotX = cLElement.getFloat();
                return true;
            case "pivotY":
                this.pivotY = cLElement.getFloat();
                return true;
            case "scaleX":
                this.scaleX = cLElement.getFloat();
                return true;
            case "scaleY":
                this.scaleY = cLElement.getFloat();
                return true;
            case "top":
                this.top = cLElement.getInt();
                return true;
            case "left":
                this.left = cLElement.getInt();
                return true;
            case "alpha":
                this.alpha = cLElement.getFloat();
                return true;
            case "right":
                this.right = cLElement.getInt();
                return true;
            case "interpolatedPos":
                this.interpolatedPos = cLElement.getFloat();
                return true;
            default:
                return false;
        }
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        if (widgetFrame == null) {
            return;
        }
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        setMotionAttributes(widgetFrame.mMotionProperties);
        this.mCustom.clear();
        for (CustomVariable customVariable : widgetFrame.mCustom.values()) {
            this.mCustom.put(customVariable.getName(), customVariable.copy());
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z6) {
        sb.append("{\n");
        add(sb, "left", this.left);
        add(sb, "top", this.top);
        add(sb, "right", this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, "rotationX", this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, "rotationZ", this.rotationZ);
        add(sb, "translationX", this.translationX);
        add(sb, "translationY", this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, "scaleX", this.scaleX);
        add(sb, "scaleY", this.scaleY);
        add(sb, "alpha", this.alpha);
        add(sb, "visibility", this.visibility);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb, type);
            }
        }
        if (z6) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z6) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case 900:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR /* 902 */:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING /* 903 */:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i5, int i6) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i6);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i5, i6));
        }
    }

    private static void add(StringBuilder sb, String str, float f6) {
        if (Float.isNaN(f6)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f6);
        sb.append(",\n");
    }

    public void setCustomAttribute(String str, int i5, boolean z6) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z6);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i5, z6));
        }
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void setCustomAttribute(String str, int i5, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i5, str2));
        }
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = constraintWidget;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    private static float interpolate(float f6, float f7, float f8, float f9) {
        boolean zIsNaN = Float.isNaN(f6);
        boolean zIsNaN2 = Float.isNaN(f7);
        if (zIsNaN && zIsNaN2) {
            return Float.NaN;
        }
        if (zIsNaN) {
            f6 = f8;
        }
        if (zIsNaN2) {
            f7 = f8;
        }
        return AbstractC0157z.a(f7, f6, f9, f6);
    }
}
