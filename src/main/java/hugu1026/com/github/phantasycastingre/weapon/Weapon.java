package hugu1026.com.github.phantasycastingre.weapon;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Weapon {

    private static ArrayList<Integer> referenceValueList = new ArrayList<>();

    static {
        Collections.addAll(referenceValueList, 10, 30, 50, 75, 100, 150, 200, 250, 300, 400, 500, 650, 800, 1000, 1250, 1500);
    }

    private double speed;
    private double attackSpeed;
    private int power_defend;
    private int sharp_durability;
    private ArrayList<Integer> correctionValueList = new ArrayList<>();

    protected abstract int PowerDefendCalc(int original_power, int melting);

    protected abstract int SharpDurabilityCalc(int original_sharpness, int polishing);

    public double getSpeed() {
        return speed;
    }

    void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getPower_defend() {
        return power_defend;
    }

    void setPower_defend(int power_defend) {
        this.power_defend = power_defend;
    }

    public int getSharp_durability() {
        return sharp_durability;
    }

    void setSharp_durability(int sharp_durability) {
        this.sharp_durability = sharp_durability;
    }

    private ArrayList<Integer> getReferenceValueList() {
        return referenceValueList;
    }

    void setCorrectionValueList(int... values) {
        for (int value : values) {
            Collections.addAll(this.correctionValueList, value);
        }
    }

    int makeValueToFair(int power_defend) {
        for (int i = 1; i <= getReferenceValueList().size(); i = i + 1) {
            if (i != referenceValueList.size()) {
                if (referenceValueList.get(i) <= power_defend && power_defend <= referenceValueList.get(i + 1)) {
                    return power_defend + this.correctionValueList.get(i);
                }
            } else {
                return power_defend + this.correctionValueList.get(i - 1);
            }
        }
        return 5;
    }
}
