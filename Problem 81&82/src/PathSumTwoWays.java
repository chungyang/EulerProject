import java.io.*;


/**
 * Created by chungyang on 10/3/16.
 */
public class PathSumTwoWays{

    public static void main(String[] args){

        int[][] matrix = deSerializeParsedMatrix().getIntMatrix();
        int[][] cost = new int[matrix.length][matrix.length];
        cost[0][0] = matrix[0][0];

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                //Numbers in the first row
                if (i == 0 && j > 0) {
                    cost[i][j] = matrix[i][j] + cost[i][j - 1];

                }
                //Numbers in the first column excluding the number that's also contained in the first row
                else if (j == 0 && i > 0) {
                    cost[i][j] = matrix[i][j] + cost[i - 1][j];
                }
                else if(j > 0 && i > 0){
                    if (cost[i][j - 1] >= cost[i - 1][j]) {
                        cost[i][j] = matrix[i][j] + cost[i - 1][j];
                    } else {
                        cost[i][j] = matrix[i][j] + cost[i][j - 1];
                    }
                }

            }
        }

        System.out.println(cost[matrix.length - 1][matrix.length - 1]);

    }

    private static ParsedMatrix deSerializeParsedMatrix(){
        ParsedMatrix pm = null;
        try{
            FileInputStream fileIn = new FileInputStream("ParsedMatrix2.ser");
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
