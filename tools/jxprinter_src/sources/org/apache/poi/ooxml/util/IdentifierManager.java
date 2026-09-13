package org.apache.poi.ooxml.util;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.util.LinkedList;
import java.util.ListIterator;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IdentifierManager {
    public static final long MAX_ID = 9223372036854775806L;
    public static final long MIN_ID = 0;
    private final long lowerbound;
    private LinkedList<Segment> segments;
    private final long upperbound;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Segment {
        private long end;
        private long start;

        public Segment(long j6, long j7) {
            this.start = j6;
            this.end = j7;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.start);
            sb.append(VectorFormat.DEFAULT_SEPARATOR);
            return AbstractC0157z.r(sb, this.end, "]");
        }
    }

    public IdentifierManager(long j6, long j7) {
        if (j6 > j7) {
            StringBuilder sbT = a.t("lowerbound must not be greater than upperbound, had ", j6, " and ");
            sbT.append(j7);
            throw new IllegalArgumentException(sbT.toString());
        }
        if (j6 < 0) {
            throw new IllegalArgumentException("lowerbound must be greater than or equal to " + Long.toString(0L));
        }
        if (j7 > MAX_ID) {
            throw new IllegalArgumentException("upperbound must be less than or equal to " + Long.toString(MAX_ID) + " but had " + j7);
        }
        this.lowerbound = j6;
        this.upperbound = j7;
        LinkedList<Segment> linkedList = new LinkedList<>();
        this.segments = linkedList;
        linkedList.add(new Segment(j6, j7));
    }

    private void verifyIdentifiersLeft() {
        if (this.segments.isEmpty()) {
            throw new IllegalStateException("No identifiers left");
        }
    }

    public long getRemainingIdentifiers() {
        long j6 = 0;
        for (Segment segment : this.segments) {
            j6 = (j6 - segment.start) + segment.end + 1;
        }
        return j6;
    }

    public boolean release(long j6) {
        long j7 = this.lowerbound;
        if (j6 >= j7) {
            long j8 = this.upperbound;
            if (j6 <= j8) {
                if (j6 == j8) {
                    Segment last = this.segments.getLast();
                    long j9 = last.end;
                    long j10 = this.upperbound;
                    if (j9 == j10 - 1) {
                        last.end = j10;
                        return true;
                    }
                    long j11 = last.end;
                    long j12 = this.upperbound;
                    if (j11 == j12) {
                        return false;
                    }
                    this.segments.add(new Segment(j12, j12));
                    return true;
                }
                if (j6 == j7) {
                    Segment first = this.segments.getFirst();
                    long j13 = first.start;
                    long j14 = this.lowerbound;
                    if (j13 == 1 + j14) {
                        first.start = j14;
                        return true;
                    }
                    long j15 = first.start;
                    long j16 = this.lowerbound;
                    if (j15 == j16) {
                        return false;
                    }
                    this.segments.addFirst(new Segment(j16, j16));
                    return true;
                }
                long j17 = j6 + 1;
                long j18 = j6 - 1;
                ListIterator<Segment> listIterator = this.segments.listIterator();
                while (listIterator.hasNext()) {
                    Segment next = listIterator.next();
                    if (next.end >= j18) {
                        if (next.start <= j17) {
                            if (next.start != j17) {
                                if (next.end != j18) {
                                    break;
                                }
                                next.end = j6;
                                if (listIterator.hasNext()) {
                                    Segment next2 = listIterator.next();
                                    if (next2.start == next.end + 1) {
                                        next.end = next2.end;
                                        listIterator.remove();
                                    }
                                }
                                return true;
                            }
                            next.start = j6;
                            return true;
                        }
                        listIterator.previous();
                        listIterator.add(new Segment(j6, j6));
                        return true;
                    }
                }
                return false;
            }
        }
        StringBuilder sbT = a.t("Value for parameter 'id' was out of bounds, had ", j6, ", but should be within [");
        sbT.append(this.lowerbound);
        sbT.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        throw new IllegalArgumentException(AbstractC0157z.r(sbT, this.upperbound, "]"));
    }

    public long reserve(long j6) {
        if (j6 < this.lowerbound || j6 > this.upperbound) {
            StringBuilder sbT = a.t("Value for parameter 'id' was out of bounds, had ", j6, ", but should be within [");
            sbT.append(this.lowerbound);
            sbT.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            throw new IllegalArgumentException(AbstractC0157z.r(sbT, this.upperbound, "]"));
        }
        verifyIdentifiersLeft();
        if (j6 == this.upperbound) {
            Segment last = this.segments.getLast();
            long j7 = last.end;
            long j8 = this.upperbound;
            if (j7 != j8) {
                return reserveNew();
            }
            last.end = j8 - 1;
            if (last.start > last.end) {
                this.segments.removeLast();
                return j6;
            }
        } else {
            if (j6 != this.lowerbound) {
                ListIterator<Segment> listIterator = this.segments.listIterator();
                while (listIterator.hasNext()) {
                    Segment next = listIterator.next();
                    if (next.end >= j6) {
                        if (next.start > j6) {
                            break;
                        }
                        if (next.start == j6) {
                            next.start = 1 + j6;
                            if (next.end < next.start) {
                                listIterator.remove();
                                return j6;
                            }
                        } else {
                            if (next.end != j6) {
                                listIterator.add(new Segment(j6 + 1, next.end));
                                next.end = j6 - 1;
                                return j6;
                            }
                            next.end = j6 - 1;
                            if (next.start > next.end) {
                                listIterator.remove();
                            }
                        }
                    }
                }
                return reserveNew();
            }
            Segment first = this.segments.getFirst();
            long j9 = first.start;
            long j10 = this.lowerbound;
            if (j9 != j10) {
                return reserveNew();
            }
            first.start = j10 + 1;
            if (first.end < first.start) {
                this.segments.removeFirst();
                return j6;
            }
        }
        return j6;
    }

    public long reserveNew() {
        verifyIdentifiersLeft();
        Segment first = this.segments.getFirst();
        long j6 = first.start;
        first.start++;
        if (first.start > first.end) {
            this.segments.removeFirst();
        }
        return j6;
    }
}
