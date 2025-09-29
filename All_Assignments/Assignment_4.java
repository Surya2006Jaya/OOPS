public class EtlSingleFile {
    public static void main(String[] args) {
    	System.out.println("JAYA SURYA S");
   	 	System.out.println("2117240070126");
   	 	System.out.println("----------------");
        // Hardcoded sample data
        Object[][] data = {
                {1, "Alice", "Engineering", 50000.0},
                {2, "Bob", "HR", 40000.0},
                {3, "Charlie", "Finance", 45000.0}
        };

        // Loop through data and apply transformations
        for (Object[] row : data) {
            int id = (int) row[0];
            String name = ((String) row[1]).toUpperCase(); // transform: uppercase name
            String dept = (String) row[2];
            double salary = ((double) row[3]) * 1.1;       // transform: +10% salary

            // Print "inserted" result
            
            System.out.println("Inserted: " + id + ", " + name + ", " + dept + ", " + salary);
        }

        System.out.println("Data inserted successfully!");
    }
}
