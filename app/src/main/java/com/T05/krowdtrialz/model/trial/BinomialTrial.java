package com.T05.krowdtrialz.model.trial;

import android.location.Location;

import com.T05.krowdtrialz.model.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * the BinomialTrial maintains a count of the number of
 * "passes" and "fails" in a trial. For instance, the number
 * of heads and tails for 5 coin flips. Definition of "pass"
 * and "fail" are maintained by the experiment.
 * */
public class BinomialTrial extends Trial {
    private int passCount, failCount;

    public BinomialTrial() {
        super();
    }

    public BinomialTrial(User user) {
        super(user);
    }

    public BinomialTrial(User user, double longitude, double latitude) {
        super(user, longitude, latitude);
    }

    public BinomialTrial(User user, double longitude, double latitude, String dateCreated) {
        super(user, longitude, latitude, dateCreated);
    }

    public int getPassCount() {
        return passCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }
}
