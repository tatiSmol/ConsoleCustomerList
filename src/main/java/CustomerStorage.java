import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");

        if (components.length == 4) {
            if (!components[3].matches("\\+7[0-9]{10}")) {
                throw new IllegalArgumentException("""
                        Wrong phone format. Correct format:
                        +79215637722""");
            }
            if (!components[2].matches("[a-z0-9.]+@[a-z0-9]+.[a-z]{2,6}")) {
                throw new IllegalArgumentException("""
                        Wrong email format. Correct format:
                        vasily.petrov@gmail.com""");
            }
        } else {
            throw new IllegalArgumentException("""
                    Wrong command format. Correct format:
                    add Василий Петров vasily.petrov@gmail.com +79215637722""");
        }

        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}