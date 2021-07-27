import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Random;
import java.awt.Dimension;
import java.lang.annotation.Target;
import java.util.ArrayList; 
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import game.item.Backpack;
import game.item.Inventory;
import game.item.attachable.Lantern;
import game.item.equipment.Weapon;
import game.character.Character;
import game.mechanics.Combat; 
import game.meta.DataEnhancement;

public class GameGUI {
    static private int mousePressedX;
    static private int mousePressedY;
    public static void main(String[] args) {
        System.out.println("Iniciando!");

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
        
        //Visual - Main

        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(800,600));        
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

        //Interface Panels
        JPanel inventoryPanel = new JPanel(new GridBagLayout());
        
        inventoryPanel.setSize(new Dimension(600, 450));
        inventoryPanel.setLocation(200,100);
        inventoryPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        inventoryPanel.addMouseListener(new MouseInputAdapter(){
            
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                mousePressedX = e.getX();
                mousePressedY = e.getY();
            }

        });
        inventoryPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = (int) MouseInfo.getPointerInfo().getLocation().getX() - mousePressedX;
                int y = (int) MouseInfo.getPointerInfo().getLocation().getY() - mousePressedY;
                inventoryPanel.setLocation(x, y);
            }
        });

        //INVENTORY CLOSE BUTTON
        JButton inventoryCloseButton = new JButton("X");
        inventoryCloseButton.setBorder(BorderFactory.createLineBorder(Color.gray));
        inventoryCloseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inventoryCloseButton.setBackground(Color.red);
        inventoryCloseButton.addActionListener(new ActionListener() {            

            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryPanel.setVisible(false);
            }

        });

        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.ipadx = 15;
        constraints.ipady = 10;

        JButton inventoryDragButton = new JButton("D");
        inventoryDragButton.setBorder(BorderFactory.createLineBorder(Color.gray));
        inventoryDragButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inventoryDragButton.setBackground(Color.red);

        constraints2.anchor = GridBagConstraints.FIRST_LINE_END;
        constraints2.weightx = 0;
        constraints2.weighty = 0.1;
        constraints2.ipadx = 15;
        constraints2.ipady = 10;

        inventoryPanel.add(inventoryDragButton, constraints2); 
        inventoryPanel.add(inventoryCloseButton, constraints);           


        //Acess menu
        JPanel accessMenu = new JPanel();
        accessMenu.setMaximumSize( accessMenu.getPreferredSize() );
        accessMenu.setBorder(BorderFactory.createLineBorder(Color.gray));
        accessMenu.setPreferredSize(new Dimension(100,512));

        JButton bagButton = new JButton(new ImageIcon("game/src/item/icon/common_bag.png"));
        bagButton.setSize(new Dimension(64,64));
        bagButton.setBorder(BorderFactory.createLineBorder(Color.black));
        bagButton.setLocation(0, 0);
        bagButton.setVisible(true);
        bagButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bagButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryPanel.setVisible(!inventoryPanel.isVisible());
            }

        });


        accessMenu.add(bagButton, BorderLayout.EAST);
        accessMenu.setVisible(true);

        frame.add(inventoryPanel);
        frame.add(accessMenu);
        inventoryPanel.setVisible(false);
        frame.setVisible(true);
        //f.getContentPane().add(scroll);
        //f.pack();
        
    }    
}
