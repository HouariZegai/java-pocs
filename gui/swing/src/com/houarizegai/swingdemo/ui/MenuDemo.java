package com.houarizegai.swingdemo.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuDemo extends JMenuBar implements ActionListener {
    
    public MenuDemo(){
        String[] fileItems = new String[]{"New","Open","Save","Exit"};
        String[] editItems = new String[]{"Undo","Redo","Copy","Cut","Paste"};
        
        char[] fileShortcut = {'N','O','S','E'};        
        char[] editShortcut = {'U','R','C','X','P'};        
        
        JMenu fileMenu, editMenu, otherMenu, subMenu, subMenu2;
        
        fileMenu     = new JMenu("File");
        editMenu     = new JMenu("Edit");
        otherMenu    = new JMenu("OtherMenu");
        subMenu      = new JMenu("SubMenu");
        subMenu2     = new JMenu("SubMenu2");
        
        JMenuItem item;
        // File Menus
        for(int i=0;i<fileItems.length;i++){
            item = new JMenuItem(fileItems[i],fileShortcut[i]);
            item.addActionListener(this);
            fileMenu.add(item); 
        }
        // Edit Menus Keyboard
        for(int i=0;i<editItems.length;i++){
            item = new JMenuItem(editItems[i],editShortcut[i]);
            item.setAccelerator(KeyStroke.getKeyStroke(editShortcut[i],java.awt.Event.CTRL_MASK,false));
            item.addActionListener(this);
            editMenu.add(item); 
        }
        
        editMenu.insertSeparator(1);
                
        subMenu2.add(item = new JMenuItem("Extra 2"));
        item.addActionListener(this);
        
        subMenu.add(item = new JMenuItem("Extra 1"));
        item.addActionListener(this);
        
        subMenu.add(subMenu2);
        
        otherMenu.add(subMenu);
        otherMenu.add(item = new JCheckBoxMenuItem("Check Me"));
        item.addActionListener(this);
        
        otherMenu.addSeparator();
        
        ButtonGroup bg = new ButtonGroup();
        
        otherMenu.add(item = new JRadioButtonMenuItem("Radio1"));
        item.addActionListener(this);
        
        bg.add(item);
        
        otherMenu.add(item = new JRadioButtonMenuItem("Radio2"));
        item.addActionListener(this);
        
        bg.add(item);
        
        otherMenu.addSeparator();
        
        otherMenu.add(item = new JMenuItem("Facebook",new ImageIcon("src/Facebook.png")));
        item.addActionListener(this);

        this.add(fileMenu);
        this.add(editMenu);
        this.add(otherMenu);
    }
   
    
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("MenuDemo["+event.getActionCommand()+"] Was Checked !");
    }
    
    public static void main(String[] args) {
        JMenuBar menuBar = new MenuDemo();

        JFrame frame = new JFrame("My MenuDemo");
        frame.setJMenuBar(menuBar);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}