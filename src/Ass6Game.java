import Environment.AnimationRunner;
import Environment.GameFlow;
import Environment.LevelInformation;
import Levels.DirectHit;
import Levels.Green3;
import Levels.WideEasy;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 6.
 */
public class Ass6Game {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<LevelInformation> levelInformationList = new ArrayList<>();
        if (args.length == 1 && (Integer.parseInt(args[0]) != 1 && Integer.parseInt(args[0]) != 2
                && Integer.parseInt(args[0]) != 3)) {
            //no args or 1 arg wrong
            System.exit(0);
        }
        for (String arg : args) {
            try {
                if (1 == Integer.parseInt(arg)) {
                    levelInformationList.add(new DirectHit());
                } else if (2 == Integer.parseInt(arg)) {
                    levelInformationList.add(new WideEasy());
                } else if (3 == Integer.parseInt(arg)) {
                    levelInformationList.add(new Green3());
                }
            } catch (Exception e) {
                System.out.println();
            }
        }
        AnimationRunner ar = new AnimationRunner();
        KeyboardSensor ks = ar.getGui().getKeyboardSensor();
        GameFlow gf = new GameFlow(ar, ks);
        gf.runLevels(levelInformationList);
    }
}
