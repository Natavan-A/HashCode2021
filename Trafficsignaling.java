import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


class Vehicle {
    private int numberOfPaths;
    private LinkedList pathNames;
    private int startInteractionId;
    private int endInteractionIdL;

    public Vehicle(int numberOfPaths, LinkedList pathNames, int startInteractionId, int endInteractionIdL) {
        this.numberOfPaths = numberOfPaths;
        this.pathNames = pathNames;
        this.startInteractionId = startInteractionId;
        this.endInteractionIdL = endInteractionIdL;
    }

    public int getNumberOfPaths() {
        return numberOfPaths;
    }

    public LinkedList getPathNames() {
        return pathNames;
    }

    public int getStartInteractionId() {
        return startInteractionId;
    }

    public int getEndInteractionIdL() {
        return endInteractionIdL;
    }
}


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

    public int getStartIId() {
        return startIId;
    }

    public int getEndIId() {
        return endIId;
    }

    public int getL() {
        return L;
    }

    public String getName() {
        return name;
    }
}

public class Trafficsignaling {
    public static int D, // duration
            I, // the number of intersections
            S, // the number of streets,
            V, // thenumberofcars
            F; // bonus point

    static Map<String, Street> streets;  // storage for all streets
    static Map<int, Vehicle> vehicles; // storage for all vehicles

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String fileName = "a.txt";//sc.nextLine();                  // get the name of the input file
        streets = new HashMap<String, Street>();

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
                streets.put(read[2], new Street(Integer.parseInt(read[0]),
                        Integer.parseInt(read[1]),
                        read[2],
                        Integer.parseInt(read[3])));
            }
            for(int i = 0; i < V; i++){
                read = line.split(" ");
                int pathLength = (int)read[0]

                LinkedList<String> paths = new LinkedList<String>()
                for (int j = 1; j <= pathLength; j++)
                {
                    paths.add(read[j]);
                }

                startInteraction = streets.get(paths.getFirst())[1];
                endInteraction = streets.get(paths.getFirst())[0];
                vehicles.put(pathLength, new Vehicle(pathLength, paths, startInteraction, endInteraction))

            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
        // ----------- End Reading The File -----------
    }
}