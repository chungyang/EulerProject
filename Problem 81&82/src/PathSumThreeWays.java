import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * Created by chungyang on 10/3/16.
 */
public class PathSumThreeWays {

    public static void main(String[] args){

        int[][] matrix = deSerializeParsedMatrix().getIntMatrix();
        int[] sol = new int[matrix.length];

        //initialise solution
        int gridSize = matrix.length;

        for (int i = 0; i < gridSize; i++) {
            sol[i] = matrix[i][gridSize - 1];
        }
        for (int i = gridSize - 2; i >= 0; i--) {
            // Traverse down
            sol[0] += matrix[0][i];
            for (int j = 1; j < gridSize; j++) {
                sol[j] = Math.min(sol[j - 1] + matrix[j][i], sol[j] + matrix[j][i]);
            }

            //Traverse up
            for (int j = gridSize - 2; j >= 0; j--) {
                sol[j] = Math.min(sol[j], sol[j+1] + matrix[j][i]);
            }
        }

        int lowestCost = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            if(lowestCost > sol[i]){
                lowestCost = sol[i];
            }
        }
        System.out.println(lowestCost);
    }

    private static ParsedMatrix deSerializeParsedMatrix(){
        ParsedMatrix pm = null;
        try{
            FileInputStream fileIn = new FileInputStream("ParsedMatrix4.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pm = (ParsedMatrix) in.readObject();
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

        return pm;
    }
}
