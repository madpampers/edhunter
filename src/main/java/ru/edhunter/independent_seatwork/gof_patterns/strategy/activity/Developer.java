package ru.edhunter.independent_seatwork.gof_patterns.strategy.activity;

/**
 * Class that uses algorithms
 * */
public class Developer {
    Activity activity;

    public void setActivity(Activity activity){
        this.activity = activity;
    }

    public void executeActivity(){
        activity.justDoIt();
    }
}
