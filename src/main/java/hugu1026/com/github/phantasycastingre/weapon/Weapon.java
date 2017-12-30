package hugu1026.com.github.phantasycastingre.weapon;

public abstract class Weapon {

    private double speed;
    private double attackSpeed;
    private int power_defend;
    private int sharp_durability;

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
}