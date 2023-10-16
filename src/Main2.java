public class Main2 {
    public static void main(String[] args) {
        String[] names = {"Tatiana", "Julius", "Vasiliy"};

        try {
            System.out.println(names[5]);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println("hey");
    }
}
