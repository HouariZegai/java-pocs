package com.houarizegai.swingdemo.ui;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListDemo extends Panel implements ActionListener {

    JList list;
    ListDemo(){
        String[] label = {"Houari","Zegai","Mohammed","Amine","Abdelkader","Abdullah","Fares","Khalid","Ahmed"};
        list = new JList(label);
        
        JScrollPane pane = new JScrollPane(list);
        
        JButton button = new JButton("Print");
        
        this.add(pane,BorderLayout.CENTER);
        this.add(button,BorderLayout.SOUTH);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int selected[] = list.getSelectedIndices();
        System.out.println("Item Selected IS : ");
        
        for(int select : selected){
            String element = (String) list.getModel().getElementAt(select);
            System.out.print(" "+element);
        }
    }
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Test ListDemo");
        frame.setContentPane(new ListDemo());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}