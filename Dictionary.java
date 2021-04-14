import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {

    
    static Map<String, Set<String>> dict;
    
    public static void main(String[] args) {
        
        dict = new HashMap<>();
        
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Enter command : ");
            String param = scanner.nextLine().toLowerCase();

            if (param.split(" ").length < 1) {
                System.out.println("Invalid command.");
                continue;
            }
            
            String[] arguments = param.split(" ");
            String command = arguments[0];
            
            switch(command.toUpperCase()) {
            case "EXIT":
                break;
                
            case "ADD":
                if (arguments.length < 3) {
                    System.out.println("Invalid command.");
                } else {
                    add(arguments[1], arguments[2]);
                }
                break;
                
            case "REMOVE":
                if (arguments.length < 3) {
                    System.out.println("Invalid command.");
                } else {
                    remove(arguments[1], arguments[2]);
                }
                break;
                
            case "REMOVEALL":
                if (arguments.length < 2) {
                    System.out.println("Invalid command.");
                } else {
                    removeAll(arguments[1]);
                }
                break;
                
            case "CLEAR":
                clear();
                break;
                
            case "KEYS":
                Set<String> keys = keys();
                if (keys.isEmpty()) {
                    System.out.println("Empty set");
                } else {
                    for (String key : keys) {
                        System.out.println(key);
                    }
                }
                break;
                
            case "MEMBERS":
                if (arguments.length < 2) {
                    System.out.println("Invalid command.");
                } else {
                    Set<String> members = members(arguments[1]);
                    if (members == null) {
                        System.out.println("ERROR, key does not exist");
                    } else {
                        for (String member : members) {
                            System.out.println(member);
                        }
                    }
                }
                break;
                
            case "ALLMEMBERS":
                List<String> members = allMembers();
                for (String member : members) {
                    System.out.println(member);
                }
                break;
                
            case "KEYEXISTS":
                if (arguments.length < 2) {
                    System.out.println("Invalid command.");
                } else {
                    System.out.println(keyExists(arguments[1]));
                }
                break;
                
            case "VALUEEXISTS":
                if (arguments.length < 3) {
                    System.out.println("Invalid command.");
                } else {
                    System.out.println(valueExists(arguments[1], arguments[2]));
                }
                break;
                
            case "ITEMS":
                for (Entry<String, Set<String>> pair : dict.entrySet()) {
                    for (String val : pair.getValue()) {
                        System.out.println(pair.getKey() + " : " + val);
                    }
                }
                break;
                
            case "EXPORT":
                try {
                    csvWriter();
                } catch (IOException e) {
                }
                System.out.println("Exported into Dictionary.csv");
                break;
                
            case "HELP":
                System.out.println("Under construction");
                break;
                
            case "SIZE":
                System.out.println(size());
                break;
                
            default:
                System.out.println("Invalid command.");
                break;
            }
            
            if (command.equalsIgnoreCase("exit")) {
                break;
            }

        }

    }
    
    static void add(String key, String val) {
        if (dict.containsKey(key)) {
            if(!dict.get(key).add(val)) {
                System.out.println("ERROR, value already exists");
                return;
            }
        } else {
            Set<String> vals = new HashSet<>();
            vals.add(val);
            dict.put(key, vals);
        }
        System.out.println("Added");
    }
    
    static void remove(String key, String val) {
        if (dict.containsKey(key)) {
            if(dict.get(key).remove(val)) {
                System.out.println("Removed");
                if (dict.get(key).size() == 0) {
                    dict.remove(key);
                }
            } else {
                System.out.println("ERROR, value does not exist");
            }
        } else {
            System.out.println("ERROR, key does not exist");
        }
    }
    
    static void removeAll(String key) {
        if (dict.remove(key) != null) {
            System.out.println("Removed");
        } else {
            System.out.println("ERROR, key does not exist");
        }
    }
    
    static void clear() {
        dict.clear();
        System.out.println("Cleared");
    }

    static boolean keyExists(String key) {
        return dict.containsKey(key);
    }
    
    static boolean valueExists(String key, String val) {
        return dict.get(key) == null ? false : dict.get(key).contains(val);
    }
    
    static Set<String> keys() {
        return dict.keySet();
    }
    
    static Set<String> members(String key) {
        return dict.get(key);
    }
    
    static List<String> allMembers() {
        List<String> members = new ArrayList<>();
        for (Set<String> vals : dict.values()) {
            members.addAll(vals);
        }
        return members;
    }
    
    static int size() {
        return dict.size();
    }
    
    static void csvWriter() throws IOException {

        String eol = System.getProperty("line.separator");

        try (Writer writer = new FileWriter("Dictionary.csv")) {
            for (Entry<String, Set<String>> entry : dict.entrySet()) {
                writer.append(entry.getKey()).append(',').append(entry.getValue().toString()).append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
