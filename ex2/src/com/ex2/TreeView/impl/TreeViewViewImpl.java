package com.ex2.TreeView.impl;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

import com.ex2.TreeView.TreeViewView;
import com.ex2.model.GroupGarage;

public class TreeViewViewImpl implements TreeViewView {
  JTree jTree;
  JFrame frame;
  
  
  public TreeViewViewImpl() {
    this.jTree = new JTree();
    this.frame = new JFrame();
  }
  
  @Override
  public void initView() {
    this.frame.setTitle("JTree");
    frame.setLocationRelativeTo(null);
    frame.setSize(300, 400);
    frame.add(new JScrollPane(jTree));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
  
  @Override
  public void draw(GroupGarage groupGarage) {
    
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        
      }
      
    });
  }
}
