import java.util.Scanner;


public class doublelinkedlist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node nodeA= new Node();
		Node nodeB= new Node();
		Node nodeC= new Node();
		Node nodeD= new Node();
		nodeA.setData(1);
		nodeB.setData(2);
		nodeC.setData(3);
		nodeD.setData(4);
		nodeA.setPreviousNode(null);
		nodeA.setNextNode(nodeB);
		nodeB.setNextNode(nodeC);
		nodeB.setPreviousNode(nodeA);
		nodeC.setPreviousNode(nodeB);
		nodeC.setNextNode(nodeD);
		nodeD.setPreviousNode(nodeC);
		nodeD.setNextNode(null);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter node position");
		int pos=sc.nextInt();
		//INSERT NODE WILL RETURN HEAD AND PRINT NODE DATA WILL PRINT IT
		printNodeData(insertNode(nodeA,pos));		
		
		
		
	}
	
	// ADD DATA TO THE NODES
	public static Node insertNode(Node list, int pos){
		
		Node nodeHead= new Node();
		nodeHead=list;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Node Data");
		int data=sc.nextInt();
		int length=length(list);
		if(pos==1){
			Node node=new Node();
			node.setData(data);
			node.setPreviousNode(null);
			node.setNextNode(list);
			list.setPreviousNode(node.getNextNode());
			nodeHead=node;
		}
		else if(pos==length+1){
			Node node=new Node();
			node.setData(data);
			nodeHead=list;
			while(list.getNextNode()!=null){
				list=list.getNextNode();
			}
			node.setNextNode(null);
			list.setNextNode(node);
			node.setPreviousNode(list);
			
		}
		//assuming all the positions are well within the limits
		else if(pos<=length){
			Node node=new Node();
			int i=2;
			node.setData(data);
			while(pos!=i){
				list=list.getNextNode();
				i++;
			}
			node.setNextNode(list.getNextNode());
			list.setNextNode(node);
			node.setPreviousNode(list);
		}
		return nodeHead;
	}

	
	public static int length(Node list){
		int length=0;
		while (list!=null){
			list=list.getNextNode();
			length++;
		}
		return length;
	}
	
	public static void printNodeData(Node list){
		
		while(list!=null){
			System.out.println(list.getData());
			list=list.getNextNode();
			
		}
		
	}

}
