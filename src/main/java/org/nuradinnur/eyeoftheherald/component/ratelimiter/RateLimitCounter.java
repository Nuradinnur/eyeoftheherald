package org.nuradinnur.eyeoftheherald.component.ratelimiter;

class RateLimitCounter {

    private int count;
    private int limit;
    private int period;
    private long periodStartTime;

    RateLimitCounter(int count, int period) {
        this.count = count;
        this.period = period;
    }

    boolean incrementCount() {
        if (count >= limit) {
            if (System.nanoTime() - getPeriodEndNanoseconds() > 0) {
                resetCount();
            }
            else {
                return false;
            }
        }
        count++;
        return true;
    }

    int resetCount() {
        count = 0;
        return count;
    }

    int getCount() {
        return count;
    }

    boolean setCount(int c) {
        if (count >= limit) {
            return false;
        }
        count = c;
        return true;
    }

    int getLimit() {
        return limit;
    }

    void setLimit(int l) {
        limit = l - 1;
    }

    int getPeriod() {
        return period;
    }

    void setPeriod(int p) {
        period = p;
    }

    long getPeriodStartTimeMilliseconds() {
        return getPeriodStartTimeNanoseconds() / 1_000_000;
    }

    long getPeriodStartTimeNanoseconds() {
        return periodStartTime;
    }

    long setPeriodStartTimeNanoseconds(long s) {
        periodStartTime = s;
        return periodStartTime;
    }

    long getPeriodEndSeconds() {
        return getPeriodEndNanoseconds() / 1_000_000_000L;
    }

    long getPeriodEndNanoseconds() {
        return periodStartTime + period * 1_000_000_000L;
    }

    long getTimeToNextPeriodSeconds() {
        return getTimeToNextPeriodNanoseconds() / 1_000_000_000L;
    }

    long getTimeToNextPeriodNanoseconds() {
        return getPeriodEndNanoseconds() - System.nanoTime() > 0 ?
                getPeriodEndNanoseconds() - System.nanoTime() : 0;
    }

    @Override
    public String toString() {
        return count + "/" + limit + " per " + period + " seconds.";
    }
}
