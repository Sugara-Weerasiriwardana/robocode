import robocode.*;
import java.awt.Color;
import java.awt.*;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;



public class Prime_movers extends CharlieBot
{

boolean peek;
    double moveAmount;
    boolean movingForward;

    public void run() {
    
        setBodyColor(Color.green);
        setGunColor(Color.green);
        setRadarColor(Color.green);
        setBulletColor(Color.green);
        setScanColor(Color.green);
    
        moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        
        peek = false;

        
        turnLeft(getHeading() % 90);
        ahead(moveAmount);
    
        peek = true;
        turnGunRight(90);
        turnRight(90);

        while (true) {
            
            peek = true;
        
            ahead(moveAmount);
            
            peek = false;
        
            turnRight(90);
        }
    }
public void onRobotDetected(ScannedRobotEvent e) {
    turnGunRight(180);
    fire(10);
	turnRadarLeft(180);
     turnGunRight(-180);
	 fire(10);
	
	  turnGunRight(-180);
	 fire(10);
	  
    if (peek) {
            scan();
        }
}
public void reverseDirection() {
        if (movingForward) {
            back(40000);
            movingForward = false;
        } else {
            ahead(40000);
            movingForward = true;
        }
    }
public void onHitRobot(HitRobotEvent e) {
        
        if (e.isMyFault()) {
            reverseDirection();
        }
    }

    public void onHitByBullet(HitByBulletEvent e) {
    
        back(200);
    }
    


}
