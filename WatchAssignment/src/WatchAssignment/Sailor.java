package WatchAssignment;

/**
 * Created by Ben Halligan
 * 5/10/2018
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * Ben Halligan wrote this file.  As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me a beer in return.   Poul-Henning Kamp
 * ----------------------------------------------------------------------------
 **/

public class Sailor {
    private String name;
    private Watch watch1;
    private Watch watch2;

    public Sailor(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addFirstWatch(Watch watch){
        watch1 =watch;
    }
    public void addSecondWatch(Watch watch){
        watch2 =watch;
    }

    public String[] getWatches() {
        String[] out = {name, watch1.getName(), watch2.getName()};
        return out;
    }
}
