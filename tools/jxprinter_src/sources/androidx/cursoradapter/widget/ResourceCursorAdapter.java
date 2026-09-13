package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i5, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = i5;
        this.mLayout = i5;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i5) {
        this.mDropDownLayout = i5;
    }

    public void setViewResource(int i5) {
        this.mLayout = i5;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i5, Cursor cursor, boolean z6) {
        super(context, cursor, z6);
        this.mDropDownLayout = i5;
        this.mLayout = i5;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i5, Cursor cursor, int i6) {
        super(context, cursor, i6);
        this.mDropDownLayout = i5;
        this.mLayout = i5;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
