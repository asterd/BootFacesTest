package test.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.bootsfaces.component.tree.event.TreeNodeCheckedEvent;
import net.bootsfaces.component.tree.event.TreeNodeEventListener;
import net.bootsfaces.component.tree.event.TreeNodeSelectionEvent;
import net.bootsfaces.component.tree.model.DefaultNodeImpl;
import net.bootsfaces.component.tree.model.Node;
import net.bootsfaces.component.treeView.model.TreeNode;


@SessionScoped
@ManagedBean(name = "test")
public class TestBean implements TreeNodeEventListener {
	private TreeNode treeModel;
	private Node selectedNode;
	private List<Node> checkedNodes = new ArrayList<Node>();
	
	public TestBean() {
		treeModel = new TreeNode();
		treeModel.setIcon("icon-folder-open");
		treeModel.setName("Root");
		treeModel.setRoot(true);
		
		TreeNode child1 = new TreeNode("Child1", "ok-circle", "http://www.google.it");
		TreeNode child2 = new TreeNode("Child2", "info-sign", "http://www.google.it");
		TreeNode child3 = new TreeNode("Child3", "ok-circle", "http://www.google.it");
		child3.getChildren().add(new TreeNode("Sub-Child-3.1", "comment", "#"));
		TreeNode child4 = new TreeNode("Second Page", "info-sign", "", "/pages/second", "");
		TreeNode child5 = new TreeNode("Action Link", "hand-up", "", "", "#{test.itemClicked}");
		
		treeModel.getChildren().add(child1);
		treeModel.getChildren().add(child2);
		treeModel.getChildren().add(child3);
		treeModel.getChildren().add(child4);
		treeModel.getChildren().add(child5);
		
	}

	public TreeNode getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(TreeNode treeModel) {
		this.treeModel = treeModel;
	}
	
	public String itemClicked() {
		System.out.println("Click on backend!");
		return "";
	}
	
	public List<Node> getJsonModel() {
		List<Node> nodeList = new ArrayList<Node>();
		nodeList.add(new DefaultNodeImpl("Parent1", "user"));
		nodeList.add(new DefaultNodeImpl("Parent2", "envelope"));
		
		List<Node> subNodes = new ArrayList<Node>();
		subNodes.add(new DefaultNodeImpl("Child1", "user"));
		subNodes.add(new DefaultNodeImpl("Child2", "main"));
		subNodes.add(new DefaultNodeImpl("Child3", "arrow-left"));
		subNodes.add(new DefaultNodeImpl("Child4", "arrow-right"));
		
		DefaultNodeImpl child5 = new DefaultNodeImpl("Child5", "arrow-right");
		child5.setColor("#FF0000");
		List<Node> subSubNodes = new ArrayList<Node>();
		subSubNodes.add(new DefaultNodeImpl("GrandChild 1", "play-circle"));
		subSubNodes.add(new DefaultNodeImpl("GrandChild 2", "play-circle"));
		child5.getSubNodes().addAll(subSubNodes);
		subNodes.add(child5);
		
		DefaultNodeImpl parent3 = new DefaultNodeImpl("Parent3", "signal");
		parent3.setExpanded(false);
		parent3.getSubNodes().addAll(subNodes);
		nodeList.add(parent3);
		
		
		return nodeList;
		// return "[{\"text\":\"Parent 1\",\"nodes\":[{\"text\":\"Child 1\",\"nodes\":[{\"text\":\"Grandchild 1\"},{\"text\":\"Grandchild 2\"}]},{\"text\":\"Child 2\"}]},{\"text\":\"Parent 2\"},{\"text\":\"Parent 3\"},{\"text\":\"Parent 4\"},{\"text\":\"Parent 5\"}]";
		
	}

	@Override
	public boolean isValueSelected(Node arg0) {
		if(selectedNode != null) {
			return selectedNode.getText().equalsIgnoreCase(arg0.getText());
		}
		return false;
	}

	@Override
	public void processValueChange(TreeNodeSelectionEvent event) {
		System.out.println("SELEZIONATO NODO:"); 
		System.out.println("NEW TITLE: " + event.getNewSelectedNode().getText());
		if(event.getOldSelectedNode() != null)
			System.out.println("OLD TITLE: " + event.getOldSelectedNode().getText());
		
		selectedNode = event.getNewSelectedNode();
	}

	@Override
	public boolean isValueChecked(Node arg0) {
		return false;
	}

	@Override
	public void processValueChecked(TreeNodeCheckedEvent event) {
		System.out.println("CHECKED NODE:" + event.getNode().getText());
		checkedNodes.add(event.getNode());
	}

	@Override
	public void processValueUnchecked(TreeNodeCheckedEvent event) {
		System.out.println("UNCHECKED NODE:" + event.getNode().getText());
		checkedNodes.remove(event.getNode());
	}
	
}
