package game.character;

public class CharacterClass {

    private ClassStats classStats;
    /*
    public CharacterClass(int hpl, int mpl, int spl){
        this.classStats = new ClassStats();
        this.classStats.hpPerLevel = hpl;
        this.classStats.manaPerLevel = mpl;
        this.classStats.shieldPerLevel = spl;

        this.classStats.shield = 0;
        this.classStats.hp = 10;
        this.classStats.mana = 0;
        this.classStats.speed = 9.0;
        this.classStats.profBonus = 2;
        this.classStats.actionsPerTurn = 1;
        this.classStats.minorActionsPerTurn = 1;
    }

    public CharacterClass(int hpl, int mpl, int spl, int ac, int shield, int hp, int mana, int speed, int profBonus, int actionsPerTurn, int minorActionsPerTurn){
        this.classStats = new ClassStats();
        this.classStats.hpPerLevel = hpl;
        this.classStats.manaPerLevel = mpl;
        this.classStats.shieldPerLevel = spl;

        this.classStats.ac = 10;
        this.classStats.shield = 0;
        this.classStats.hp = 10;
        this.classStats.mana = 0;

        this.classStats.speed = speed;
        this.classStats.profBonus = profBonus;
        this.classStats.actionsPerTurn = actionsPerTurn;
        this.classStats.minorActionsPerTurn = minorActionsPerTurn;
    }
    public CharacterClass(int hpl, int mpl, int spl, int ac, int shield, int hp, int mana){
        this.classStats = new ClassStats();
        this.classStats.hpPerLevel = hpl;
        this.classStats.manaPerLevel = mpl;
        this.classStats.shieldPerLevel = spl;

        this.classStats.ac = 10;
        this.classStats.shield = 0;
        this.classStats.hp = 10;
        this.classStats.mana = 0;

        this.classStats.speed = 0;
        this.classStats.profBonus = 0;
        this.classStats.actionsPerTurn = 0;
        this.classStats.minorActionsPerTurn = 0;
    }
    public void setClassStats(ClassStats cc){
        cc = this.classStats;
    }

    /*static public void createWarrior(){
        return new CharacterClass(15, 0, 0, 10, 0, 20, 0);
    }*/
}
