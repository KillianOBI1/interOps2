package com.ex2.TreeView.impl;

import com.ex2.TreeView.TreeViewController;
import com.ex2.TreeView.TreeViewView;
import com.ex2.model.GroupGarage;

public class TreeViewControllerImpl implements TreeViewController {
  protected TreeViewModel treeViewModel;
  protected TreeViewView treeViewView;
  
  public TreeViewControllerImpl() {
    this.treeViewModel = new TreeViewModel();
    this.treeViewView = new TreeViewViewImpl();
  }
  
  @Override
  public void init() {
    this.treeViewView.initView();
  }
  
  @Override
  public void registerData(GroupGarage groupGarage) {
    this.treeViewModel.groupGarage = groupGarage;
    this.sendDataToView(this.treeViewModel.groupGarage);
  }
  
  public void sendDataToView(GroupGarage groupGarage) {
    this.treeViewView.draw(groupGarage);
  }

 
}
