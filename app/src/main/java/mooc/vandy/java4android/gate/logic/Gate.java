package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    static final int IN = 1;
    static final int OUT = -1;
    static final int CLOSED = 0;
    private int mSwing;

    public Gate(){
        this.mSwing = CLOSED;
    }

    public boolean setSwing(int direction){
        if(direction > -2 && direction < 2){
            this.mSwing = direction;
            return true;
        }
        return false;
    }

    public boolean open(int direction){
        if(direction==IN || direction==OUT){
            return setSwing(direction);
        }
        return false;
    }

    public void close(){
        setSwing(0);
    }

    public int getSwingDirection(){
        return mSwing;
    }

    public int thru(int count){
        if(mSwing==IN){
            return count;
        }
        else if(mSwing==OUT){
            return -count;
        }
        return 0;
    }
    @Override
    public String toString(){
        if(mSwing==CLOSED){
            return "This gate is closed";
        }
        else if(mSwing==IN){
            return "This gate is open and swings to enter the pen only";
        }
        else if(mSwing==OUT){
            return "This gate is open and swings to exit the pen only";
        }
        else{
            return "This gate has an invalid swing direction";
        }
    }
    // TODO -- Fill in your code here


}

