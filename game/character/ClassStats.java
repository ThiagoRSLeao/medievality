package game.character;

public class ClassStats extends Stats {

    private int xp;
    private int level;
    protected int hpPerLevel;
    protected int manaPerLevel;
    protected int shieldPerLevel;

    public ClassStats(){     
        this.xp = 0;           
        this.level = 1;
    }
    public void levelUp() {
        this.level += 1;
        this.hp += this.hpPerLevel*this.level;
        this.mana += this.manaPerLevel*this.level;
        this.shield += this.shieldPerLevel*this.level;
    }
    public void setLevel(int level) {
        this.level = level;
        this.hp = this.hpPerLevel*this.level;
        this.mana = this.manaPerLevel*this.level;
        this.shield = this.shieldPerLevel*this.level;
    }
}
