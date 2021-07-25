
import java.util.List;
import java.util.Random;
import java.lang.annotation.Target;
import java.util.ArrayList; 
import java.util.Scanner;

import game.item.Backpack;
import game.item.Inventory;
import game.item.attachable.Lantern;
import game.item.equipment.Weapon;
import game.character.Character;
import game.mechanics.Combat; 
import game.meta.DataEnhancement; 

//import game.*;
// Java program to illustrate the 
// concept of Association
class Game {
    public static void main(String[] args){

        /*System.out.println("Iniciando!");

        Inventory comp = new Inventory(25, 150);
        Backpack bag = new Backpack("Mochila de Andarilho", comp, 1, 0, 0);
        Lantern c = new Lantern();
        Lantern r = new Lantern("Lanterna de Caveira", 3.5, "vermelho-sangue", 250, 13.5);
        Lantern l = new Lantern("Olhos de Deus", 3.0, "dourada", 1000, 36.0);
        c.switchTurnOn();
        c.turnedTurns(10);
        r.turnedTurns(10);
        l.switchTurnOn();
        l.turnedTurns(932);
        System.out.println(c.getName() + " é uma lanterna com alcance de " + c.getRadius() + " metros, emite uma luz " + c.getColor() + ". (" + c.getRemainingTime() + ")");
        System.out.println(r.getName() + " é uma lanterna com alcance de " + r.getRadius() + " metros, emite uma luz " + r.getColor() + ". (" + r.getRemainingTime() + ")");
        System.out.println(l.getName() + " é uma lanterna com alcance de " + l.getRadius() + " metros, emite uma luz " + l.getColor() + ". (" + l.getRemainingTime() + ")");

        bag.put(c);
        bag.put(r);
        bag.put(l);
        System.out.println("a mochila '" + bag.getName() + "' carrega ateh " + bag.getMaxSlots() + " tipos de item  diferentes e " + bag.getMaxWeight() + " de peso, possui tambem:\n - " + bag.getLanternSocketsNum() + " encaixes para lanterna.\n - " + bag.getTrinketSocketsNum() + " encaixes para amuletos.\n - " + bag.getExtraSocketsNum() + " encaixes para extras.");
        System.out.println("Sua lista de itens atuais eh: ");
        for(int count = 0; count < bag.getItems().size(); count++)
        {
            System.out.println(" - " + bag.getItems().get(count).getName());
        }
        System.out.println("Carregando atualmente " + bag.getUsedWeight() + " de peso com " + bag.getUsedSlots() + " tipos de item diferentes. ");
        */

        System.out.println("Criação de Personagem...");
        DataEnhancement s = new DataEnhancement();
        System.out.println("Nome:");
        String name = s.scanf();

        System.out.println("Você tem os seguintes atributos: 15 14 13 12 10 8");
        ArrayList<String> attributes = new ArrayList<String>();
        ArrayList<Integer> values = new ArrayList<Integer>();

        attributes.add("STR");attributes.add("DEX");attributes.add("CON");attributes.add("INT");attributes.add("WIS");attributes.add("CHA");
        values.add(15);values.add(14);values.add(13);values.add(12);values.add(10);values.add(8);
        int[] atts = {10, 10, 10, 10, 10, 10};
        for(int count = 0; count < attributes.size();count++){
            System.out.println("Defina sua " + attributes.get(count) + ": ");
            for(int counter = 0; counter < values.size();counter++){                
                System.out.println(counter+" - " + values.get(counter));
            }
            int x = Integer.parseInt(s.scanf());
            atts[count] = values.get(x);
            values.remove(x);
        }
        Character player1 = new Character(name, atts);//0 strength, 1 dexterity, 2 constitution, 3 inteligence, 4 wisdom, 5 charisma

        //Weapon dagger = Weapon.forgeSimpleWeapon(1, "Black Dagger");
       // player1.setEquip(dagger);


        System.out.println("Iniciando combate!");

        Character player2 = new Character("Kuilan");
        Weapon rapier = Weapon.forgeSimpleWeapon(3, "Gold Rapier");
        player2.setEquip(rapier);

        Character player3 = new Character("Bentinho Chave");
        Weapon axe = Weapon.forgeSimpleWeapon(4, "Linux");
        player3.setEquip(axe);

        Combat c1 = new Combat();
        c1.insertCombat(player1);
        c1.insertCombat(player2);
        c1.insertCombat(player3);
        c1.run();
    }
}



     /*
        //CharacterGeneratorDefiner

        CLASS CharacterGenerator
        Base - Atributos Escolhidos,
        Raça - Atributos de Raça,
        Classe - Level, Casting Mod, SpellTree,
        



        TODO 
        Adicionar "COSTAS" no equipamento e poder colocar mochila lá!

        Automatizar criação de personagems, permitir escolher entre o array padrão. 
        Permitir o agrupamento deles.
        Gerar equipamentos (Armaduras, arcos e escudos).
        Criar Magias, escolas de magia e etc.
        Permitir outras ações alem de atacar, como consumir poções, fugir ou mover-se.
        Adicionar combates consecutivos, como npcs (story line).
        Adicionar progressão por nível.
        Adicionar efeitos positivos/negativos em itens de maneira aleatória.
        Adicionar IA para os inimigos.

        CRIAR SISTEMA DE ATRIBUTOS PARA O PERSONAGEM (BASE, ATRIBUTOS PROVENIENTES DE EFEITOS E DE ITENS)
        */

        





/*
class PlayableCharacter extends Character{

}
class NonPlayableCharacter extends Character{

}*/

//DADOS

