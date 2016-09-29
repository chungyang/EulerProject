import java.util.*;
import java.io.*;

public class ParseTriangle implements Serializable{
    
    private ArrayList<Node> nodeTree = new ArrayList<>();
    private static final long serialVersionUID = 1L;
	private int nlevels = 0;

    private ParseTriangle(){
	
    }
    public static void main(String[] args) throws IOException{
	
	ParseTriangle triangle = new ParseTriangle();
	triangle.parse();
	
	
	try{
	    FileOutputStream fileOut = new FileOutputStream("../ParsedTriangle.ser");
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(triangle);
	    out.close();
	    System.out.println("parsed triangle saved in ParsedTriangle.ser");
	}
	catch(IOException i){
	    i.printStackTrace();
	}
	
    }

    private void parse() throws IOException{

		FileReader input = new FileReader("../Triangle.txt");
		BufferedReader bufRead = new BufferedReader(input);
		String numbersInRow;
		int id = 0;
	   
        for(int j = 1; (numbersInRow = bufRead.readLine()) != null;j++) {

			String[] numbers = numbersInRow.split(" ");
			nlevels++;

			for (int i = 0; i < numbers.length; i++) {
				nodeTree.add(Node.getNode(Integer.parseInt(numbers[i]), id));
				nodeTree.get(id).setRow(j);
				System.out.print(nodeTree.get(id).getValue() + ","+nodeTree.get(id).getRow()+","+nodeTree.get(id).getID() + " ");
				id++;
			}
			System.out.println("");
		}
    }

    public ArrayList<Node> getTriangle(){
    	return nodeTree;
	}
	public int getNlevels(){
		return nlevels;
	}
}

class Node implements Serializable {
    
    private int value, id,row;
	private long cost = 0;
    private static final long serialVersionUID = 2L;

    private Node(int v, int i){
	this.value = v;
	this.id = i;
    }

    public static Node getNode(int v, int i){
	return new Node(v,i);
    }

    public void setRow(int r){
	this.row = r;
    }

    public int getValue(){
	return value;
    }
    
    public int getID(){
	return id;
    }
    public int getRow(){
	return row;
    }
    public long getCost(){
    	return cost;
	}
	public void setCost(long c){
		this.cost = c;
	}
}