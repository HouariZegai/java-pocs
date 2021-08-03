package com.houarizegai.swingdemo.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableDemo extends JFrame {

	JTable table;
	private static final String[] TABLE_HEADER = {"ID", "Name", "Age"};

	public TableDemo(){
		String[][] dataOfTable = {{"1", "Houari", "21"},
                                    {"2", "Mohamed", "53"},
                                    {"3", "Abdelkader", "25"}};
		
		table = new JTable(dataOfTable, TABLE_HEADER);
		table.setBounds(40,50,300,400);

		// add row to table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{"4", "jojo", "madrid"});

		JScrollPane jsp = new JScrollPane(table); // pour faire le Scroll si la fenètre petite
		
		this.add(jsp);
		this.setSize(500, 500);
		// Il Existe pas setLayout(null); car il Existe ScrollPane
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // si On va fermer la Fenetre le Program sera Terminer
	}
	
	public static void main(String[] args) {
		new TableDemo();
	}

}
