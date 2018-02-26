package hugu1026.com.github.phantasycastingre.weapon;

import java.util.function.IntBinaryOperator;

public class Rapier extends Weapon {

    private double speed = 0.1;
    private double attackSpeed = 1.1;
    private int power_defend;
    private int sharp_durability;

    public Rapier(int original_power, int melting, int original_sharpness, int polishing) {

        IntBinaryOperator func1 = this::PowerDefendCalc;
        IntBinaryOperator func2 = this::SharpDurabilityCalc;
        power_defend = func1.applyAsInt(original_power, melting);
        sharp_durability = func2.applyAsInt(original_sharpness, polishing);

        setSpeed(speed);
        setAttackSpeed(attackSpeed);
        setPower_defend(power_defend);
        setSharp_durability(sharp_durability);
    }

    @Override
    protected int PowerDefendCalc(int original_power, int melting) {
        //変域外
        if (melting <= 0 || melting >= 1000) {
            power_defend = 30;
        } //変域内
        else {
            power_defend = (int) (-10 + 0.12 * melting + -1.2e-04 * Math.pow(melting, 2)) + original_power;
        }

        //計算結果が負
        if (power_defend < 0) {
            power_defend = 30;
        }
        return power_defend;
    }

    @Override
    protected int SharpDurabilityCalc(int original_sharpness, int polishing) {

        if (polishing <= 0 || polishing >= 1500) {
            sharp_durability = 30;
        } else {
            sharp_durability = (int) (0 + 0.08 * polishing + -5.33e-05 * Math.pow(polishing, 2)) + original_sharpness;
        }
        if (sharp_durability < 0) {
            sharp_durability = 30;
        }
        return sharp_durability;
    }
}