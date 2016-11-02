import java.io.*;

/**
 * Created by chungyang on 10/3/16.
 */
public class ParsedMatrix implements Serializable{

    private int[][] matrix;

    private ParsedMatrix(){

    }

    public static ParsedMatrix getParsedMatrix(){
        return new ParsedMatrix();
    }

    public static void main(String[] args) throws IOException {

        ParsedMatrix pm = ParsedMatrix.getParsedMatrix();
        pm.parse();

        try{
            FileOutputStream fileOut = new FileOutputStream("../ParsedMatrix4.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pm);
            out.close();
            System.out.println("parsed matrix saved in ParsedMatrix.ser");
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }

    private void parse() throws IOException {

        FileReader input = new FileReader("../matrix4.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String numbersInRow;
        boolean isMatrixAllocated = false;

        for(int j = 0; (numbersInRow = bufRead.readLine()) != null;j++) {


            String[] numbers = numbersInRow.split(",");

            if(!isMatrixAllocated){
                matrix = new int[numbers.length][numbers.length];
                isMatrixAllocated = true;
            }

            for (int i = 0; i < numbers.length; i++) {
                matrix[j][i] = Integer.parseInt(numbers[i]);
            }

        }
    }

    public int[][] getIntMatrix(){
        return matrix;
    }
}
