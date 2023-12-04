package team.service;

import team.domain.*;

public class NameListService {
    private Employee[] employees;

    public static void main(String[] args) {

        NameListService nls1 = new NameListService();

        System.out.println(nls1.getEmployee(0));
    }

    public NameListService() {
        employees = new Employee[12];

        for(String[] i : Data.EMPLOYEES) {

            int j = Integer.parseInt(i[1]) - 1;  //用于储存当前人物的顺序ID
            int age = Integer.parseInt(i[3]);
            double salary = Double.parseDouble(i[4]);

            if(i[0].equals("10")) {

                employees[j] = new Employee(j + 1, i[2], age, salary);

            } else {
                Equipment e = null;

                //创建Equipment对象
                if(Data.EQUIPMENTS[j][0].equals("21")) {

                    e = new PC(Data.EQUIPMENTS[j][1], Data.EQUIPMENTS[j][2]);

                } else if(Data.EQUIPMENTS[j][0].equals("22")) {

                    double price = Double.parseDouble(Data.EQUIPMENTS[j][2]);

                    e = new NoteBook(Data.EQUIPMENTS[j][1], price);

                } else if(Data.EQUIPMENTS[j][0].equals("23")) {

                    e = new Printer(Data.EQUIPMENTS[j][1], Data.EQUIPMENTS[j][2]);

                }

                if(i[0].equals("11")) {

                    employees[j] = new Programmer(j + 1, i[2], age, salary, e);

                } else if(i[0].equals("12")) {

                    double bonus = Double.parseDouble(i[5]);

                    employees[j] = new Designer(j + 1, i[2], age, salary, e, bonus);

                } else if(i[0].equals("13")) {

                    double bonus = Double.parseDouble(i[5]);
                    int stock = Integer.parseInt(i[6]);

                    employees[j] = new Architect(j + 1, i[2], age, salary, e, bonus, stock);

                }
            }

        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {

        if(id < 1 || id > 12) throw new TeamException("找不到指定的员工");

        return employees[id - 1];
    }
}
