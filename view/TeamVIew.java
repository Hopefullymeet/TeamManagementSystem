package team.view;

import sun.security.krb5.internal.crypto.Des;
import team.domain.Architect;
import team.domain.Designer;
import team.domain.Employee;
import team.domain.Programmer;
import team.service.NameListService;
import team.service.TeamService;

public class TeamVIew {

    private NameListService listSvc = new NameListService();
    private TeamService TeamSvc = new TeamService();

    public static void main(String[] args) {

        TeamVIew tv = new TeamVIew();

        tv.ListAllEmployees();

    }

    public void enterMainMenu() {

    }

    public void ListAllEmployees() {

        System.out.println("ID  姓名  年龄  薪水  设备信息1   设备信息2   奖金  股票");

        for(Employee e : listSvc.getAllEmployees()) {

            if(e instanceof Architect) {

                System.out.println(e.getId() + "    " + e.getName() + " " + e.getAge() + "  " + e.getSalary() + "   " + ((Architect) e).getEquipment().getDescription() + " " + ((Architect) e).getBonus() + "  " + ((Architect) e).getStock());

            } else if(e instanceof Designer) {

                System.out.println(e.getId() + "    " + e.getName() + " " + e.getAge() + "  " + e.getSalary() + "   " + ((Designer) e).getEquipment().getDescription() + " " + ((Designer) e).getBonus());

            } else if(e instanceof Programmer) {

                System.out.println(e.getId() + "    " + e.getName() + " " + e.getAge() + "  " + e.getSalary() + "   " + ((Programmer) e).getEquipment().getDescription());

            } else {
                System.out.println(e.getId() + "    " + e.getName() + " " + e.getAge() + "  " + e.getSalary());

            }

        }

    }

    public void getTeam() {

        System.out.println("ID  团队ID    姓名  年龄  薪水  状态  设备信息1   设备信息2   奖金  股票");

        for(Programmer p : TeamSvc.getTeam()) {

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

    }

    public void deleteMember() {

    }

}
