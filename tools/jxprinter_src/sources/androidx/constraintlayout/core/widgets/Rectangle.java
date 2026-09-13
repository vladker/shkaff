package androidx.constraintlayout.core.widgets;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f994x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f995y;

    public boolean contains(int i5, int i6) {
        int i7;
        int i8 = this.f994x;
        return i5 >= i8 && i5 < i8 + this.width && i6 >= (i7 = this.f995y) && i6 < i7 + this.height;
    }

    public int getCenterX() {
        return (this.f994x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f995y + this.height) / 2;
    }

    public void grow(int i5, int i6) {
        this.f994x -= i5;
        this.f995y -= i6;
        this.width = (i5 * 2) + this.width;
        this.height = (i6 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i5;
        int i6;
        int i7 = this.f994x;
        int i8 = rectangle.f994x;
        return i7 >= i8 && i7 < i8 + rectangle.width && (i5 = this.f995y) >= (i6 = rectangle.f995y) && i5 < i6 + rectangle.height;
    }

    public void setBounds(int i5, int i6, int i7, int i8) {
        this.f994x = i5;
        this.f995y = i6;
        this.width = i7;
        this.height = i8;
    }
}
