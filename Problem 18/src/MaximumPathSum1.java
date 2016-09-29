import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by chungyang on 9/29/16.
 */

public class MaximumPathSum1 {

    public static void main(String[] args){

        ParseTriangle t = deSerializeParsedTriangle();
        ArrayList<Node> nodeTree = t.getTriangle();
        long longestRoute = 0;

        for(int i = 0; i < t.getTriangle().size();i++){

            Node n = nodeTree.get(i);
            if(n.getRow() < t.getNlevels()) {

                Node leftChild = nodeTree.get(n.getID() + n.getRow());
                Node rightChild = nodeTree.get(n.getID() + n.getRow() + 1);


                if(i == 0){
                    n.setCost(n.getValue());
                    leftChild.setCost(n.getCost() + leftChild.getValue());
                    rightChild.setCost(n.getCost() + rightChild.getValue());
//                    System.out.println("leftChild cost: " + leftChild.getCost());
//                    System.out.println("rightChild cost: " + rightChild.getCost());

                }
                else{
                    if(leftChild.getCost() < n.getCost() + leftChild.getValue()) {
                        leftChild.setCost(n.getCost() + leftChild.getValue());
//                        System.out.println("leftChild cost: " + leftChild.getCost());

                    }
                    if(rightChild.getCost() < n.getCost() + rightChild.getValue()){
                        rightChild.setCost(n.getCost() + rightChild.getValue());
//                        System.out.println("rightChild cost: " + rightChild.getCost());
                    }


                    if(longestRoute < leftChild.getCost()){
                        longestRoute = leftChild.getCost();
                    }
                    if(longestRoute < rightChild.getCost()){
                        longestRoute = rightChild.getCost();
                    }
                }
            }

        }

        System.out.println(longestRoute);

    }

    private static ParseTriangle deSerializeParsedTriangle(){

        ParseTriangle t = null;
        try{
            FileInputStream fileIn = new FileInputStream("ParsedTriangle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            t = (ParseTriangle) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i){
            i.printStackTrace();
        }
        catch(ClassNotFoundException c){
            System.out.println("ParseTriangle class not found");
            c.printStackTrace();
        }

        return t;
    }

}
