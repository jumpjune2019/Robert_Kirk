package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

@SuppressWarnings("serial")
public class TreeView extends JFrame implements TreeSelectionListener, ActionListener {

	//JTreeUtil util = new JTreeUtil();
	
	JLabel broadcaster;

	JLabel locationBroadcaster;
	
	TreeViewPanel tree = new TreeViewPanel();
	JPanel dashBoard;
	JButton button;

	TreeView(String string) {
		super(string);
	}

	public void addComponentsToPane() {
		
		JTree viewableTree = tree.tree;
		viewableTree.addTreeSelectionListener(this);
		getContentPane().add(viewableTree, BorderLayout.CENTER);
		
		dashBoard = new JPanel();
		
		broadcaster = new JLabel("Item Selected");
		
		locationBroadcaster = new JLabel("Location in tree of item selected");
		broadcaster.setText("Location in Tree");
		
		button = new JButton("Collapse Control");
		button.setText("Expeand All");
		button.addActionListener(this);
		dashBoard.setLayout(new BoxLayout(dashBoard,1));
		
		dashBoard.add(this.broadcaster, BorderLayout.NORTH);
		dashBoard.add(this.locationBroadcaster,BorderLayout.CENTER);
		dashBoard.add(this.button,BorderLayout.SOUTH);
		getContentPane().add(dashBoard, BorderLayout.SOUTH);
		

	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		this.broadcaster.setText(e.getPath().getLastPathComponent().toString());
		String path = "";
		int count = 0;
		for(TreePath s : e.getPaths()) {
			path+= s.toString();
			if(count!= e.getPaths().length-1) {
				path+= ", ";
			}
		}
		this.locationBroadcaster.setText(path);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(button.getText().equals("Collapse All")) {
			button.setText("Expand All");
			tree.expandTree(tree.tree, false);
			
		} else {
			button.setText("Collapse All");
			tree.expandTree(tree.tree, true);
			
		}
	}

}
