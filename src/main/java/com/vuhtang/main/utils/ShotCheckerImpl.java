package com.vuhtang.main.utils;

import com.vuhtang.main.Shot;

import java.util.Date;

public class ShotCheckerImpl implements ShotChecker {
    private int id = 0;
    @Override
    public Shot takeShot(Double x, Double y, Double r) {
        long start = System.nanoTime();
        String RESULT = check(x, y, r) ? "HIT" : "MISS";
        Long EXEC_TIME = System.nanoTime() - start;
        Date CURR_TIME = new Date(System.currentTimeMillis());
        this.id++;
        return new Shot(id, x, y, r, CURR_TIME, EXEC_TIME, RESULT);
    }

    private boolean check(Double x, Double y, Double r) {
        return (x >= 0 && y >= 0 && x <= r / 2 && y <= r)
                || (x <= 0 && y <= 0 && x <= r && y <= r && y >= -x - r)
                || (x >= 0 && y <= 0 && x * x + y * y <= r * r);
    }
}
