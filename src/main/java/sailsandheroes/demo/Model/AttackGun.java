package sailsandheroes.demo.Model;

import java.awt.*;

public class AttackGun {
    //Can only be done every second round

    public Point shotPosition;

    public void checkIfShot(){
        //Check at et given skib ikke har skudt i sidste runde, ellers kan den ikke skyde igen!
        //TODO måske lav en boolean der starter med falsk og bliver ændret til true når den kommer ind igen og false anden vej
        //TODO giv besked at man ikke kan skyde, eller kald en skudsmetode.
    }
    public void changeAmmo(){
        // Lader et skib ændre sin ammo og springe skydefasen over

    }
    public void shoot(){
        // Vælger et hex (position) at skyde sit main skudsalve (40%), hvorefter de 6 hex udenom laver et (10%) skade.
        // TODO vælg en position enten ved at trykke eller indtaste position.
        shotPosition = value;
    }
}
