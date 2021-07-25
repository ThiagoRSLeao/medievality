package game.character;

public class ClassStats extends Stats {

    private int xp;
    private int level;
    private double hpPerLevel;
    private double manaPerLevel;
    private double shieldPerLevel;    
    private double evasionPerLevel;

    private double speedPerLevel;
    private double profBonusPerLevel;

    private double physicalDamagePerLevel;
    private double magicalDamagePerLevel;
    private double spiritualDamagePerLevel;

    private double criticalChancePerLevel;
    private double criticalDamagePerLevel;

    private double actionsPerTurnPerLevel;

    public ClassStats(){     
        this.xp = 0;           
        this.setLevel(1);

        this.setOrigin("Classe");
        this.hpPerLevel = 0;
        this.manaPerLevel = 0;
        this.shieldPerLevel = 0;       
        this.evasionPerLevel = 0;

        this.speedPerLevel = 0;
        this.profBonusPerLevel = 0;

        this.physicalDamagePerLevel = 0;
        this.magicalDamagePerLevel = 0;
        this.spiritualDamagePerLevel = 0;  

        this.criticalChancePerLevel = 0;
        this.criticalDamagePerLevel = 0;  

        this.actionsPerTurnPerLevel = 0;
    
    }
    public ClassStats(double hpLvl, double manaLvl, double shieldLvl, double evasionLvl, double speedLvl, double pbLvl, double psDmgLvl, double mgDmgLvl, double spDmgLvl, double critLvl, double critDmgLvl, double actLvl){     
        this.xp = 0;           
        this.setLevel(1);
        
        this.hpPerLevel = hpLvl;
        this.manaPerLevel = manaLvl;
        this.shieldPerLevel = shieldLvl;       
        this.evasionPerLevel = evasionLvl;

        this.speedPerLevel = speedLvl;
        this.profBonusPerLevel = pbLvl;

        this.physicalDamagePerLevel = psDmgLvl;
        this.magicalDamagePerLevel = mgDmgLvl;
        this.spiritualDamagePerLevel = spDmgLvl;  

        this.criticalChancePerLevel = critLvl;
        this.criticalDamagePerLevel = critDmgLvl;  

        this.actionsPerTurnPerLevel = actLvl;
        this.updateStats();
    
    }
    public void levelUp() {
        this.level += 1;
        this.updateStats();
    }
    public void setLevel(int level) {
        this.level = level;
        this.updateStats();
    }
    public void updateStats(){
        this.maxHp = (int) Math.floor(this.hpPerLevel*this.level);
        this.maxMana = (int) Math.floor(this.manaPerLevel*this.level);
        this.maxShield = (int) Math.floor(this.shieldPerLevel*this.level);

        this.evasion = (int) Math.floor(this.evasionPerLevel*this.level);
        this.speed = this.speedPerLevel*this.level;
        this.profBonus = (int) Math.floor(this.profBonusPerLevel*this.level);
        
        this.physicalDamage = (int) Math.floor(this.physicalDamagePerLevel*this.level);
        this.magicalDamage = (int) Math.floor(this.magicalDamagePerLevel*this.level);
        this.spiritualDamage = (int) Math.floor(this.spiritualDamagePerLevel*this.level);
    
        this.criticalChance = (int) Math.floor(this.criticalChancePerLevel*this.level);
        this.criticalDamage = (int) Math.floor(this.criticalDamagePerLevel*this.level);
    
        this.actionsPerTurn = (int) Math.floor(this.actionsPerTurnPerLevel*this.level);

    }
}
