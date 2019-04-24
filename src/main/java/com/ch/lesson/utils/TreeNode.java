package com.ch.lesson.utils;

import java.util.ArrayList;


public class TreeNode {
	private Integer Id;
	private Integer Pid;
	private String Name;
	private String Router;
	private Integer Position;
	private ArrayList<TreeNode> children = new ArrayList<TreeNode>();

	public TreeNode(Integer id, Integer pid, String name, String router, Integer position) {
		Id = id;
		Pid = pid;
		Name = name;
		Router = router;
		Position = position;
	}

	public void add(TreeNode node) {
		if ("0".equals(node.Pid)) {
			//this.children.add(node);
		} else if (node.Pid.equals(this.Id)) {//是子节点
			this.children.add(node);
		} else {//不是子节点又不是跟节点
			for (TreeNode tmp_node : children) {
				tmp_node.add(node);
			}
		}
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getPid() {
		return Pid;
	}

	public void setPid(Integer pid) {
		Pid = pid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRouter() {
		return Router;
	}

	public void setRouter(String router) {
		Router = router;
	}

	public Integer getPosition() {
		return Position;
	}

	public void setPosition(Integer position) {
		Position = position;
	}

	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<TreeNode> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"Id='" + Id + '\'' +
				", Pid='" + Pid + '\'' +
				", Name='" + Name + '\'' +
				", Router='" + Router + '\'' +
				", Position='" + Position + '\'' +
				", children=" + children +
				'}';
	}
}
