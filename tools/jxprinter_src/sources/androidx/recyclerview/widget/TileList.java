package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        public Tile(@NonNull Class<T> cls, int i5) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i5));
        }

        public boolean containsPosition(int i5) {
            int i6 = this.mStartPosition;
            return i6 <= i5 && i5 < i6 + this.mItemCount;
        }

        public T getByPosition(int i5) {
            return this.mItems[i5 - this.mStartPosition];
        }
    }

    public TileList(int i5) {
        this.mTileSize = i5;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int iIndexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (iIndexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> tileValueAt = this.mTiles.valueAt(iIndexOfKey);
        this.mTiles.setValueAt(iIndexOfKey, tile);
        if (this.mLastAccessedTile == tileValueAt) {
            this.mLastAccessedTile = tile;
        }
        return tileValueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i5) {
        if (i5 < 0 || i5 >= this.mTiles.size()) {
            return null;
        }
        return this.mTiles.valueAt(i5);
    }

    public T getItemAt(int i5) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i5)) {
            int iIndexOfKey = this.mTiles.indexOfKey(i5 - (i5 % this.mTileSize));
            if (iIndexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(iIndexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i5);
    }

    public Tile<T> removeAtPos(int i5) {
        Tile<T> tile = this.mTiles.get(i5);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i5);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
