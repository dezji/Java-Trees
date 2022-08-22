// Name: Deziallia Morris

package com.dezji;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;



public class Main {

	public static void main(String[] args) {
		
		HierarchyNode node1 = new HierarchyNode("Finance and Administrative Planner", 3, 10000);
		HierarchyNode node2 = new HierarchyNode("Training Lieutenant Officer", 10, 50000);
		HierarchyNode node3 = new HierarchyNode("Professional Standards Lieutenant", 8, 15000);
		HierarchyNode node4 = new HierarchyNode("Accreditation and Grants Manager", 4, 8500);
		HierarchyNode node5 = new HierarchyNode("Community Service Department Officers", 25, 13400);
		HierarchyNode node6 = new HierarchyNode("Community Services Department Lieutenant", 15, 50000, node5);
		
		HierarchyNode node7 = new HierarchyNode("Communications ECO Manager", 3, 35000);
		HierarchyNode node8 = new HierarchyNode("Communications ECO Supervisors", 10, 25000);
		HierarchyNode node9 = new HierarchyNode("Communications ECO Dispatchers", 25, 45250);
		
		HierarchyNode node10 = new HierarchyNode("Records Manager", 1, 15000);
		HierarchyNode node11 = new HierarchyNode("Records Specialists", 12, 15300);
		
		HierarchyNode node12 = new HierarchyNode("Administrative Division Chief", 1, 25000, node1, node2, node3, node4, node6);
		HierarchyNode node13 = new HierarchyNode("Operations Division Chief", 1, 25000, node7, node8, node9);
		HierarchyNode node14 = new HierarchyNode("Investigations and Support Division Chief", 1, 45000, node10, node11);
		
		HierarchyNode node15 = new HierarchyNode("Senior Staff Assistant", 1, 25000);
		HierarchyNode node16 = new HierarchyNode("General Counsel", 1, 25000);
		
		HierarchyNode node17 = new HierarchyNode("Chief of Police", 1, 150000, node15, node16, node12, node13, node14);
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		String currency = format.format(node17.totalBudget());
		
		
		out.println("The Hierarchy of a Police Department:\n\n");
		for (int i = 0; i < 50; i++) {
			out.print("*");
		}
		out.print("\n");
		node17.PrintSubtree(0);
		
		for (int i = 0; i < 50; i++) {
			out.print("*");
		}
		out.print("\n");
	
		out.print("The total of the budget for this Police Department summed up: " + currency);
		
	}
}



class HierarchyNode {
	String name;
	int employees;
	int budget;
	
	List<HierarchyNode> children = new ArrayList<>();
	
	public HierarchyNode(String name, int employees, int budget, HierarchyNode ... hierarchyNodes) {
		this.name = name;
		this.employees = employees;
		this.budget = budget;
		
		for (HierarchyNode child : hierarchyNodes)
			this.children.add(child);
	}
	
	public void PrintSubtree(int level) {
		for (int i = 0; i < level; i++)
			out.print(" ");
		out.println(name);
		
		for (HierarchyNode child : children)
			child.PrintSubtree(level + 1);
	}
	
	public int totalBudget() {
		 int answer = budget;
		 for (HierarchyNode child : children)
		     answer += child.totalBudget();
		 return answer;
	}
}