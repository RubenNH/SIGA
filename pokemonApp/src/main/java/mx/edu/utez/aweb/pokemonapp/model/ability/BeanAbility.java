package mx.edu.utez.aweb.pokemonapp.model.ability;

public class BeanAbility {
    private long id;
    private String name;
    private double damage;
    private String abilityType;

    public BeanAbility() {
    }

    public BeanAbility(String name, double damage, String abilityType) {
        this.name = name;
        this.damage = damage;
        this.abilityType = abilityType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public String getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(String abilityType) {
        this.abilityType = abilityType;
    }
}
