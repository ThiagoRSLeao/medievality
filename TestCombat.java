public class TestCombat {
    public static void main(String[] args){
    System.out.println("Iniciando combate!");
        Character player1 = new Character("Hadryk", 15, 15);
        Weapon dagger = Weapon.forgeSimpleWeapon(1, "Black Dagger");
        player1.setEquip(dagger);

        Character player2 = new Character("Kuilan", 10, 18);
        Weapon rapier = Weapon.forgeSimpleWeapon(3, "Gold Rapier");
        player2.setEquip(rapier);

        Character player3 = new Character("Bentinho Chave", 30, 10);
        Weapon axe = Weapon.forgeSimpleWeapon(4, "Linux");
        player3.setEquip(axe);

        Combat c1 = new Combat();
        c1.insertCombat(player1);
        c1.insertCombat(player2);
        c1.insertCombat(player3);
        c1.run();
    }
}
