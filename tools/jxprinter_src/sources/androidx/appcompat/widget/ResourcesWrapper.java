package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.appcompat.resources.Compatibility;
import androidx.core.content.res.ResourcesCompat;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mResources = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i5) {
        return this.mResources.getAnimation(i5);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i5) {
        return this.mResources.getBoolean(i5);
    }

    @Override // android.content.res.Resources
    public int getColor(int i5) {
        return this.mResources.getColor(i5);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i5) {
        return this.mResources.getColorStateList(i5);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i5) {
        return this.mResources.getDimension(i5);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i5) {
        return this.mResources.getDimensionPixelOffset(i5);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i5) {
        return this.mResources.getDimensionPixelSize(i5);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i5) {
        return this.mResources.getDrawable(i5);
    }

    public final Drawable getDrawableCanonical(int i5) {
        return super.getDrawable(i5);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public Drawable getDrawableForDensity(int i5, int i6) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i5, i6, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i5, int i6, int i7) {
        return this.mResources.getFraction(i5, i6, i7);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.mResources.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i5) {
        return this.mResources.getIntArray(i5);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i5) {
        return this.mResources.getInteger(i5);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i5) {
        return this.mResources.getLayout(i5);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i5) {
        return this.mResources.getMovie(i5);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i5, int i6, Object... objArr) {
        return this.mResources.getQuantityString(i5, i6, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i5, int i6) {
        return this.mResources.getQuantityText(i5, i6);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i5) {
        return this.mResources.getResourceEntryName(i5);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i5) {
        return this.mResources.getResourceName(i5);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i5) {
        return this.mResources.getResourcePackageName(i5);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i5) {
        return this.mResources.getResourceTypeName(i5);
    }

    @Override // android.content.res.Resources
    public String getString(int i5) {
        return this.mResources.getString(i5);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i5) {
        return this.mResources.getStringArray(i5);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i5) {
        return this.mResources.getText(i5);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i5) {
        return this.mResources.getTextArray(i5);
    }

    @Override // android.content.res.Resources
    public void getValue(int i5, TypedValue typedValue, boolean z6) {
        this.mResources.getValue(i5, typedValue, z6);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public void getValueForDensity(int i5, int i6, TypedValue typedValue, boolean z6) {
        Compatibility.Api15Impl.getValueForDensity(this.mResources, i5, i6, typedValue, z6);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i5) {
        return this.mResources.getXml(i5);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mResources.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i5) {
        return this.mResources.obtainTypedArray(i5);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i5) {
        return this.mResources.openRawResource(i5);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i5) {
        return this.mResources.openRawResourceFd(i5);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawable(int i5, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(this.mResources, i5, theme);
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i5, int i6, Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i5, i6, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i5, int i6) {
        return this.mResources.getQuantityString(i5, i6);
    }

    @Override // android.content.res.Resources
    public String getString(int i5, Object... objArr) {
        return this.mResources.getString(i5, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i5, CharSequence charSequence) {
        return this.mResources.getText(i5, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z6) {
        this.mResources.getValue(str, typedValue, z6);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i5, TypedValue typedValue) {
        return this.mResources.openRawResource(i5, typedValue);
    }
}
