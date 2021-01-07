package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    public void setCorralGates(Gate[] gate, Random rand){
        int randomInt;
        for(int i = 0; i < gate.length; ++i){
            randomInt = rand.nextInt(3)-1;
            gate[i].setSwing(randomInt);
            mOut.println("Gate " + i + ": " + gate[i].toString());
        }
    }

    public boolean anyCorralAvailable(Gate[] corral){
        for(Gate input: corral){
            if(input.getSwingDirection()==Gate.IN){
                return true;
            }
        }
        return false;
    }

    public int corralSnails(Gate[] corral, Random rand){
        int pasture = 5;
        int randomGate;
        int randomSnailCount;
        int attempts = 0;
        while(pasture > 0){
            randomGate = rand.nextInt(corral.length);
            randomSnailCount = rand.nextInt(pasture)+1;
            mOut.println(randomSnailCount + " are trying to move through corral " + randomGate);
            pasture-=corral[randomGate].thru(randomSnailCount);
            attempts++;
        }
        mOut.println("It took " + attempts + " attempts to corral all of the snails");
        return attempts;
    }

    // TODO -- Fill your code in here
    
}
