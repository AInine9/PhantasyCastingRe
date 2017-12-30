package hugu1026.com.github.phantasycastingre.weapon;

import java.util.function.IntBinaryOperator;

public class CrumblyChunk extends Weapon {

    private double speed = 1;
    private double attackSpeed = 1;
    private int power_defend;
    private int sharp_durability;

    public CrumblyChunk(int original_power, int melting, int original_sharpness, int polishing) {

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
        return 1;
    }

    @Override
    protected int SharpDurabilityCalc(int original_sharpness, int polishing) {
        return 1;
    }
}