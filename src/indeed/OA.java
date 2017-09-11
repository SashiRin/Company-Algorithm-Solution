package indeed;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : OA
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class OA {

    static class Employee {  // a employee class

        private int id;      // employee's id
        private int managerID;   // employee's manager id
        private int value;   // employee's value

        public Employee(){}


    }

    public static void helper() {

        System.out.println("Please enter: ");
        Scanner scanner = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // Key : managerID  value : employee ID
        int founder = -1; // founder's id
        int id = 0; // employee's id
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            int managerID = scanner.nextInt();
            Employee employee = new Employee();  // create an employee , add all of variable
            employee.id = id;
            employee.value = value;
            employee.managerID = managerID;
            if (map.containsKey(managerID)) {  // add employee id to same manage
                map.get(managerID).add(id);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(id);
                map.put(managerID, temp);
            }
            if (managerID == -1) {  // founder id
                founder = id;
            }
            list.add(employee);
            id++;
        }

        for(Employee value : list) {
            System.out.println("value is: " + value.value);
        }
        System.out.println("---------------------------------");

        Queue<Integer> queue = new LinkedList<>();
        queue.add(founder);
        while (!queue.isEmpty()) {
            int curManager = queue.poll();  // current manage id
            if (map.containsKey(curManager)) {
                int managervalue = list.get(curManager).value;  // current manage value
                for (int employeeID : map.get(curManager)) {  // all of employee of manage
                    if (list.get(employeeID).value > managervalue) {
                        list.get(employeeID).value = managervalue;
                    }
                    queue.offer(employeeID);
                }
            }
        }

        int res = 0;  // result
        for (Employee employee : list) {
            res += employee.value;  // all of employee's value 
        }

        for(Employee value : list) {
            System.out.println("value is: " + value.value);
        }
    }
    // OA 10
    public static void he(){
        System.out.println("Please enter: ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> valueAry = new ArrayList<>();
        List<Integer> midAry = new ArrayList<>();
        Map<Integer, List<Integer>>  map = new HashMap<>();
        int rootId = -1;
        int id = 0;
        while(scanner.hasNextInt()) {
            int curvalue = scanner.nextInt();
            int  managerID = scanner.nextInt();
            valueAry.add(curvalue);
            midAry.add(managerID);
            map.putIfAbsent(managerID, new ArrayList<>());
            map.get(managerID).add(id);
            if(managerID == -1) {
                rootId = id;
            }
            id++;
        }
        scanner.close();

        for(int value : valueAry) {
            System.out.println("value is: " + value);
        }
        System.out.println("---------------------------------");

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootId);
        while(!queue.isEmpty()) {
            int curMager = queue.poll();
            if(map.containsKey(curMager)) {
                int curvalue = valueAry.get(curMager);
                for(int child :  map.get(curMager)) {
                    if(valueAry.get(child) > curvalue) {
                        valueAry.set(child, curvalue);
                    }
                    queue.offer(child);
                }
            }
        }
        for(int value : valueAry) {
            System.out.println("value is: " + value);
        }
    }
    public static void main(String[] argv){
        helper();
        //he();
    }
}
