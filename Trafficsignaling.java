import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Street {
    private int startIId = -1;
    private int endIId = -1;
    private int L = -1;
    private String name = "";

    Street(int startIId, int endIId, String name, int L) {
        this.startIId = startIId;
        this.endIId = endIId;
        this.name = name;
        this.L = L;
    }
}

public class Trafficsignaling {
    public static int D, // duration
                    I, // the number of intersections
                    S, // the number of streets,
                    V, // thenumberofcars
                    F; // bonus point

    static Map<Integer, Street> streets;  // storage for all streets

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String fileName = "a.txt";//sc.nextLine();                  // get the name of the input file
        streets = new HashMap<Integer, Street>();

        // ----------- Reading The File -----------
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineCount = 0;
            line = br.readLine();

            String[] read = line.split(" ");
            D = Integer.parseInt(read[0]);
            I = Integer.parseInt(read[1]);
            S = Integer.parseInt(read[2]);
            V = Integer.parseInt(read[3]);
            F = Integer.parseInt(read[4]);

            for(int i = 0; i < S; i++){
                read = line.split(" ");
                streets.put(i, new Street(Integer.parseInt(read[0]),
                                    Integer.parseInt(read[1]),
                                    read[2],
                        Integer.parseInt(read[3])));
            }
            for(int i = 0; i < V; i++){

            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
        // ----------- End Reading The File -----------
    }
}
