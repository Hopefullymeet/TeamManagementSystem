package team.view;

import sun.security.krb5.internal.crypto.Des;
import team.domain.Architect;
import team.domain.Designer;
import team.domain.Employee;
import team.domain.Programmer;
import team.service.NameListService;
import team.service.TeamException;
import team.service.TeamService;

public class TeamVIew {

    private NameListService listSvc = new NameListService();
    private TeamService TeamSvc = new TeamService();

    public static void main(String[] args) {

        TeamVIew tv = new TeamVIew();

        tv.enterMainMenu();

    }

    public void enterMainMenu() {

        System.out.println("                 欢迎进入团队管理系统");
        System.out.println("--------------------------------------------------");

        ListAllEmployees();

        System.out.println("--------------------------------------------------");

        System.out.println("1. 向团队中添加成员 2. 从团队中删除成员 3. 展示所有团队成员 4. 展示所有员工  输入 -1 以退出");

        while(true) {

            try {

                System.out.print("请给出你要进行的操作：");
                int op = Input.getOperation();

                switch(op) {
                    case 1 :
                        addMember();
                        break;

                    case 2 :
                        deleteMember();
                        break;

                    case 3 :
                        getTeam();
                        break;

                    case 4 :
                        ListAllEmployees();
                        break;

                    default :
                        break;
                }

                if(op == -1) {

                    System.out.println("成功退出！");

                    break;

                }

            } catch(OutOfBoundException e) {

                System.out.println(e.getMessage());

            }

        }

    }

    public void ListAllEmployees() {

        System.out.println("ID  姓名  年龄  薪水  设备信息1   设备信息2   奖金  股票");

        for(Employee e : listSvc.getAllEmployees()) {

            if(e instanceof Architect) {

                System.out.println(e.getId() + "   " + e.getName() + "  " + e.getAge() + "  " + e.getSalary() + "   " + ((Architect) e).getEquipment().getDescription() + " " + ((Architect) e).getBonus() + "  " + ((Architect) e).getStock());

            } else if(e instanceof Designer) {

                System.out.println(e.getId() + "   " + e.getName() + "  " + e.getAge() + "  " + e.getSalary() + "   " + ((Designer) e).getEquipment().getDescription() + " " + ((Designer) e).getBonus());

            } else if(e instanceof Programmer) {

                System.out.println(e.getId() + "   " + e.getName() + "  " + e.getAge() + "  " + e.getSalary() + "   " + ((Programmer) e).getEquipment().getDescription());

            } else {
                System.out.println(e.getId() + "   " + e.getName() + "  " + e.getAge() + "  " + e.getSalary());

            }

        }

    }

    public void getTeam() {

        System.out.println("ID  团队ID    姓名  年龄  薪水  状态  设备信息1   设备信息2   奖金  股票");

        for(int i = 0; i < TeamSvc.getTotal(); i++) {

            Programmer p = TeamSvc.getTeam()[i];

            if(p instanceof Architect) {

                System.out.println(p.getId() + "    " + p.getMemberId() + " " + p.getName() + " " + p.getAge() + "  " + p.getSalary() + "   "  + p.getStatus() + p.getEquipment().getDescription() + "  " + ((Architect) p).getBonus() + "  " + ((Architect) p).getStock());

            } else if(p instanceof Designer) {

                System.out.println(p.getId() + "    " + p.getMemberId() + " " + p.getName() + " " + p.getAge() + "  " + p.getSalary() + "   "  + p.getStatus() + p.getEquipment().getDescription() + "  " + ((Designer) p).getBonus());

            } else {

                System.out.println(p.getId() + "    " + p.getMemberId() + " " + p.getName() + " " + p.getAge() + "  " + p.getSalary() + "   "  + p.getStatus() + p.getEquipment().getDescription());

            }

        }

    }

    public void addMember() {

        while (true) {

            System.out.print("请输入你所要添加人员的ID：");

            int toAddId = Input.getId();

            try {

                TeamSvc.addMember(listSvc.getEmployee(toAddId));
                System.out.println("添加成功！");
                getTeam();

                break;

            } catch(TeamException e) {

                System.out.println(e.getMessage());

            }

        }


    }

    public void deleteMember() {

        while(true) {

            System.out.print("请输入索要删除人员的团队ID：");

            int toDeleteTeamId = Input.getId();

            try {

                TeamSvc.removeMember(toDeleteTeamId);
                System.out.println("删除成功！");
                getTeam();

                break;

            } catch(TeamException e) {

                System.out.println(e.getMessage());

            }

        }

    }

}
