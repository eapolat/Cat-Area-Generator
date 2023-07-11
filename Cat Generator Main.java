import java.util.ArrayList;
import java.util.Random;

public class Lab06 {
    
    public static void main(String[] args) {
        
        ArrayList<String> names = CatInfoGenerator.getRandomNameList(10);

        ArrayList<String> locations = CatInfoGenerator.getRandomLocationList(10);
        
        ArrayList<Integer> number_of_months = CatInfoGenerator.getRandomMonthList(10);

        System.out.println("Before moving the cats: ");

        displayIntersections(names, locations, number_of_months);

        moveCats(locations, number_of_months);

        System.out.println("After moving the cats: ");

        displayIntersections(names, locations, number_of_months);
    }

    public static boolean doesIntersect(String location_1, String location_2) {

        int index_comma_1 = location_1.indexOf(',');
        int index_comma_2 = location_2.indexOf(',');

        double x_1 = Double.valueOf(location_1.substring(0, index_comma_1));
        double y_1 = Double.valueOf(location_1.substring(index_comma_1+1));

        double x_2 = Double.valueOf(location_2.substring(0, index_comma_2));
        double y_2 = Double.valueOf(location_2.substring(index_comma_2+1));

        double distance = Math.sqrt(((x_2 - x_1) * (x_2 - x_1)) + ((y_2 - y_1) * (y_2 - y_1)));

        double radius_1 = 50.0;
        double radius_2 = 50.0;

        if (distance <= (radius_1 + radius_2)) {

            return true;

        } else {

            return false;

        }
    }

    public static int countIntersecting(String location, ArrayList<String>locations) {

        int count = 0;

        for ( String test_location : locations ) {

            if (doesIntersect(test_location, location)) {

                count++;
            }

        }

        return count;

    }

    public static void displayIntersections(ArrayList<String> names, ArrayList<String> locations, ArrayList<Integer> months) {

        for (int i=0 ; i < names.size() ; i++) {
            
            int num = countIntersecting(locations.get(i), locations);

                if (num > 1) {
            
                    System.out.println( names.get(i) + " at location " + locations.get(i) + " for " + months.get(i) + " months intersects with:");

                    for(int j=0; j < names.size() ; j++) {

                        if (i != j) {

                        if (doesIntersect(locations.get(i), locations.get(j))) {
                        
                            System.out.println("      " + names.get(j) + ", at location " + locations.get(j) + " for " + months.get(j) + " months    ");

                        }
                }
            }
                } else {
                    System.out.printf( names.get(i) + " at location " + locations.get(i) + " for " + months.get(i) + " months intersects with: NO CATS %n %n");
                }

        }
    }

    public static int findMinMonthsAtLocation(String location, ArrayList<String> locations, ArrayList<Integer> number_of_months) {

        int min_month = 60;

                for(int j=0; j < locations.size() ; j++) {

                    if (doesIntersect(location, locations.get(j))) {
        
                        if (number_of_months.get(j) <= min_month) {

                            min_month = number_of_months.get(j);

                        }

                    }
                }

        return number_of_months.indexOf(min_month);
    }

    public static String findRandomLocation () {

        Random rand = new Random();

        String x = Integer.toString(rand.nextInt(0,250));
        String y = Integer.toString(rand.nextInt(0,250));
        String location = x + "," + y;

        return location;

    }

    public static void moveCats(ArrayList<String> locations, ArrayList<Integer> months) {

        for (String location : locations) {

            if (countIntersecting(location, locations) > 2) {

                int index_of_cattomove = findMinMonthsAtLocation(location, locations, months);

                if (index_of_cattomove < locations.size() && index_of_cattomove >= 0) {
                        
                    String random_location = " ";

                    do {
            
                        random_location = findRandomLocation();

                    } while(countIntersecting(random_location, locations) >= 1);
            
                    locations.set(index_of_cattomove, random_location);

                }
            }
    }

    }

}
