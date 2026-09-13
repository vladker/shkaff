package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Guideline extends Helper {
    private int mEnd;
    private float mPercent;
    private int mStart;

    public Guideline(String str) {
        super(str, new Helper.HelperType(""));
        this.mStart = Integer.MIN_VALUE;
        this.mEnd = Integer.MIN_VALUE;
        this.mPercent = Float.NaN;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setEnd(int i5) {
        this.mEnd = i5;
        this.configMap.put("end", String.valueOf(i5));
    }

    public void setPercent(float f6) {
        this.mPercent = f6;
        this.configMap.put("percent", String.valueOf(f6));
    }

    public void setStart(int i5) {
        this.mStart = i5;
        this.configMap.put("start", String.valueOf(i5));
    }
}
