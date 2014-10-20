package com.hut;

import java.util.TimerTask;

/**
 * Such watch much kill thread
 */
public class WatchDoge extends TimerTask {

    private final Thread watching;

    public WatchDoge(Thread doge){
        watching = doge;
    }

    @Override
    public void run() {
        // Way too lazy to do this properly plus his example uses stop
        watching.stop();
    }
}

