package sailsandheroes.demo.Utility;

import sailsandheroes.demo.Enums.GameResult;
import sailsandheroes.demo.Enums.TurnResult;
// Mads og Michael
public class PlayerOrderResultMaker {

    public static PlayerOrderResult getPlayerOrderResult (GameResult gameResult, TurnResult turnResult){
        return new PlayerOrderResult(gameResult, turnResult);
    }
}
