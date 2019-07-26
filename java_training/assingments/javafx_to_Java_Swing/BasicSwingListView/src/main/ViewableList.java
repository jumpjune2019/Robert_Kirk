package main;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ViewableList extends JFrame implements ActionListener {
	DefaultListModel<String> dm = new DefaultListModel<String>();
	JList<String> namesJList;
	String[] names = {"Robert Kirk", "Elbert", "Dave", "Claude"};
	String selectedVal;
	
	JButton addItemBtn;
	JButton removeItemBtn;
	JPanel buttonPanel;
	JLabel broadcaster;
	
	ViewableList(String string){
		super(string);
	}
	
	void createJList() {
		this.namesJList = new JList<String>();

		this.namesJList.setModel(dm);

		dm.addAll(Arrays.asList(names));

		this.namesJList.addListSelectionListener(this.listSelectionListener);

	}
	ListSelectionListener listSelectionListener = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			selectedVal = namesJList.getSelectedValue();
			broadcaster.setText("Name Selected: " +selectedVal);
			// System.out.println(s);
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Add Item to List":
			String s = names[(int)(Math.random()*this.names.length)];
			this.dm.addElement(s);
			break;
		case "Remove Selected Item":
			this.dm.removeElementAt(this.namesJList.getSelectedIndex());
		}
		
	}

	public void addComponentsToPane() {
		
		this.broadcaster = new JLabel();
		this.broadcaster.setText("Name not selected");
		
		this.addItemBtn = new JButton("Add Item to List");
		this.addItemBtn.addActionListener(this);
		
		this.removeItemBtn = new JButton("Remove Selected Item");
		this.removeItemBtn.addActionListener(this);
		this.buttonPanel = new JPanel();
		this.buttonPanel.add(addItemBtn);
		this.buttonPanel.add(removeItemBtn);
//		JPanel listPanel = new JPanel();
//		listPanel.add(namesJList);
		ScrollPane pan = new ScrollPane();
		pan.add(namesJList);
		getContentPane().add(pan, BorderLayout.LINE_START);
		getContentPane().add(this.broadcaster, BorderLayout.CENTER);
		getContentPane().add(this.buttonPanel, BorderLayout.SOUTH);


	}
	

}
