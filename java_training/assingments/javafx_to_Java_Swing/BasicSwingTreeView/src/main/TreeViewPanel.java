package main;

import java.awt.Dimension;
import java.net.URL;
import java.util.Enumeration;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
@SuppressWarnings("serial")
public class TreeViewPanel extends JPanel  {
	
    protected JTree tree;
    

    public TreeViewPanel() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode chapter1 = new DefaultMutableTreeNode("Chapter 1");
        DefaultMutableTreeNode sub1 = new DefaultMutableTreeNode("1.1");
        DefaultMutableTreeNode sub2 = new DefaultMutableTreeNode("1.2");
        DefaultMutableTreeNode sub3 = new DefaultMutableTreeNode("1.3");
        DefaultMutableTreeNode sub31 = new DefaultMutableTreeNode("1.3.1");
        DefaultMutableTreeNode sub32 = new DefaultMutableTreeNode("1.3.2");

        root.add(chapter1);
        chapter1.add(sub1);
        chapter1.add(sub2);
        chapter1.add(sub3);
        sub3.add(sub31);
        sub3.add(sub32);

        tree = new JTree(root);
        expandTree(tree, false);

        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(400, 400));
    }
    void expandTree(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        expandAll(tree, new TreePath(root), expand);
    }

    private void expandAll(JTree tree, TreePath path, boolean expand) {
        TreeNode node = (TreeNode) path.getLastPathComponent();

        if (node.getChildCount() >= 0) {
            Enumeration enumeration = node.children();
            while (enumeration.hasMoreElements()) {
                TreeNode n = (TreeNode) enumeration.nextElement();
                TreePath p = path.pathByAddingChild(n);

                expandAll(tree, p, expand);
            }
        }

        if (expand) {
            tree.expandPath(path);
        } else {
            tree.collapsePath(path);
        }
    }

    private class BookInfo {
        public String bookName;
        public URL bookURL;

        public BookInfo(String book, String filename) {
            bookName = book;
            bookURL = getClass().getResource(filename);
            if (bookURL == null) {
                System.err.println("Couldn't find file: "
                                   + filename);
            }
        }

        public String toString() {
            return bookName;
        }
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Books for Java Programmers");
        top.add(category);

        //original Tutorial
        book = new DefaultMutableTreeNode(new BookInfo
            ("The Java Tutorial: A Short Course on the Basics",
            "tutorial.html"));
        category.add(book);

        //Tutorial Continued
        book = new DefaultMutableTreeNode(new BookInfo
            ("The Java Tutorial Continued: The Rest of the JDK",
            "tutorialcont.html"));
        category.add(book);

    }

}
