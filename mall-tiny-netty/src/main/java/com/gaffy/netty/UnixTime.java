package com.gaffy.netty;

import java.util.Date;

public class UnixTime {

    private final long time;

    public UnixTime(long time) {
        this.time = time;
    }

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return new Date((getTime() - 2208988800L) * 1000L).toString();
    }
}
