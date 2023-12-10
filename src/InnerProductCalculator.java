import java.util.*;

public class InnerProductCalculator {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String[]> corpus = new ArrayList<>();
    String[] query;
    double numberOfRecords;
    Map<String, Double> result = new HashMap<>();

    public void insertDocuments() {
        System.out.print("How many records would you like to enter: ");
        numberOfRecords = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numberOfRecords; i++) {
            System.out.println("Enter record number " + i + ": ");
            String[] userInput = scanner.nextLine().split(" ");
            corpus.add(userInput);
        }
    }

    public void insertQuery() {
        System.out.println("Enter your query");
        query = scanner.nextLine().split(" ");
    }

    public void printQuery() {
        for (String i : query) {
            System.out.println(i);
        }
    }

    public void printDocuments() {
        for (String[] array : corpus) {
            System.out.println(Arrays.toString(array));
        }
    }


    public void innerProductFunction() {
        //Map<String, Double> idfResults;
        //List<Double> weights
        //for(idfForWord=gold, value=0.176 : map)
        /*{
           for (int i = 0; i < numberOfRecords; i++) {
            count = countValues(idfForWord)
            weight = count * value
            oldSimi = weights.get(i)
            weights.set(i, oldSimi + weight * value)
           }
          }
          Collections.sort(weights, 1)
          print(weights)
        */

        double idfValue;
        for (int i = 0; i < numberOfRecords; i++) {
            double similarity = 0;
            for (String queryWord : Arrays.asList(query)) {
                idfValue = idfCalculator(queryWord);
                double docWeight = countValues(queryWord, i) * idfValue;
                double queryWeight = countValues(queryWord) * idfValue;
                similarity += (docWeight * queryWeight);
            }
            result.put("D" + (i + 1), similarity);
            similarity = 0;

        }
        System.out.println(result);
        rank(result);
    }

    public double idfCalculator(String word) {
        double mentionedRecords = 0;
        for (String[] record : corpus) {
            if (Arrays.asList(record).contains(word)) {
                mentionedRecords++;
            }
        }
        if (mentionedRecords == 0) {
            return 0;
        }
        return Math.log10(numberOfRecords / mentionedRecords);
    }

    public int countValues(String search, int i) {

        int count = Collections.frequency(Arrays.asList(corpus.get(i)), search.trim());
        return count;
    }

    public int countValues(String search) {

        int count = Collections.frequency(Arrays.asList(query), search.trim());
        return count;
    }

    private void rank(Map<String, Double> unsortedMap) {
        List<Map.Entry<String, Double>> entryList = new ArrayList<>(result.entrySet());

        Collections.sort(entryList, Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("\nSorted by Values:");
        for (Map.Entry<String, Double> entry : entryList) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println(".");
    }

}
