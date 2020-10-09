package sailsandheroes.demo.Utility;

import sailsandheroes.demo.Enums.GameResult;
import sailsandheroes.demo.Enums.TurnResult;

public class PlayerOrderResultMaker {

    public static PlayerOrderResult getPlayerOrderResult (GameResult gameResult, TurnResult turnResult){
        return new PlayerOrderResult(gameResult, turnResult);
    }
}
