package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(Context context, int i5, int i6) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i5, typedValue, true);
        return typedValue.resourceId != 0 ? i5 : i6;
    }

    public static boolean getBoolean(TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6, boolean z6) {
        return typedArray.getBoolean(i5, typedArray.getBoolean(i6, z6));
    }

    public static Drawable getDrawable(TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        Drawable drawable = typedArray.getDrawable(i5);
        return drawable == null ? typedArray.getDrawable(i6) : drawable;
    }

    public static int getInt(TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6, int i7) {
        return typedArray.getInt(i5, typedArray.getInt(i6, i7));
    }

    public static boolean getNamedBoolean(TypedArray typedArray, XmlPullParser xmlPullParser, String str, @StyleableRes int i5, boolean z6) {
        return !hasAttribute(xmlPullParser, str) ? z6 : typedArray.getBoolean(i5, z6);
    }

    @ColorInt
    public static int getNamedColor(TypedArray typedArray, XmlPullParser xmlPullParser, String str, @StyleableRes int i5, @ColorInt int i6) {
        return !hasAttribute(xmlPullParser, str) ? i6 : typedArray.getColor(i5, i6);
    }

    public static ColorStateList getNamedColorStateList(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, @StyleableRes int i5) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i5, typedValue);
        int i6 = typedValue.type;
        if (i6 != 2) {
            return (i6 < 28 || i6 > 31) ? ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme) : getNamedColorStateListFromInt(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i5 + ": " + typedValue);
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, @StyleableRes int i5, @ColorInt int i6) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i5, typedValue);
            int i7 = typedValue.type;
            if (i7 >= 28 && i7 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat complexColorCompatInflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme);
            if (complexColorCompatInflate != null) {
                return complexColorCompatInflate;
            }
        }
        return ComplexColorCompat.from(i6);
    }

    public static float getNamedFloat(TypedArray typedArray, XmlPullParser xmlPullParser, String str, @StyleableRes int i5, float f6) {
        return !hasAttribute(xmlPullParser, str) ? f6 : typedArray.getFloat(i5, f6);
    }

    public static int getNamedInt(TypedArray typedArray, XmlPullParser xmlPullParser, String str, @StyleableRes int i5, int i6) {
        return !hasAttribute(xmlPullParser, str) ? i6 : typedArray.getInt(i5, i6);
    }

    @AnyRes
    public static int getNamedResourceId(TypedArray typedArray, XmlPullParser xmlPullParser, String str, @StyleableRes int i5, @AnyRes int i6) {
        return !hasAttribute(xmlPullParser, str) ? i6 : typedArray.getResourceId(i5, i6);
    }

    public static String getNamedString(TypedArray typedArray, XmlPullParser xmlPullParser, String str, @StyleableRes int i5) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.getString(i5);
        }
        return null;
    }

    @AnyRes
    public static int getResourceId(TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6, @AnyRes int i7) {
        return typedArray.getResourceId(i5, typedArray.getResourceId(i6, i7));
    }

    public static String getString(TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        String string = typedArray.getString(i5);
        return string == null ? typedArray.getString(i6) : string;
    }

    public static CharSequence getText(TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        CharSequence text = typedArray.getText(i5);
        return text == null ? typedArray.getText(i6) : text;
    }

    public static CharSequence[] getTextArray(TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        CharSequence[] textArray = typedArray.getTextArray(i5);
        return textArray == null ? typedArray.getTextArray(i6) : textArray;
    }

    public static boolean hasAttribute(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue(NAMESPACE, str) != null;
    }

    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue peekNamedValue(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.peekValue(i5);
        }
        return null;
    }
}
