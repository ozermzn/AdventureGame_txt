public class Inventory {

    private boolean crown;
    private String weaponName;
    private String armorName;
    private int damage;
    private int armor;


    Inventory(){


        this.setCrown(false);
        this.setDamage(0);
        this.setArmor(0);
        this.setWeaponName(null);
        this.setArmorName(null);

    }

    public boolean isCrown() {
        return crown;
    }

    public void setCrown(boolean crown) {
        this.crown = crown;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }




}
