package team.service;

import team.domain.Employee;
import team.domain.Programmer;

public class TeamService {

    private int counter = 1;
    private final int MAX_NUMBER = 5;
    private Programmer[] team = new Programmer[MAX_NUMBER];
    private int total = 0;

    public Programmer[] getTeam() {

        return team;

    }

    public void addMember(Employee e) throws TeamException{

        Programmer p = null;

        if(e instanceof Programmer) {
            p = (Programmer) e;
            p.setMemberId(counter++);
        } else {
            throw new TeamException("添加类型该错误");
        }

        team[total++] = p;

    }

    public void removeMember(int memberId) throws TeamException {

        boolean haveFind = false;

        for (int i = 0; i < total; i++) {

            if(haveFind) {

                team[i - 1] = team[i];

            }

            if (team[i].getMemberId() == memberId) {

                haveFind = true;
                total--;

            }

        }

        if(!haveFind) {
            throw new TeamException("找不到所要删除的TeamID");
        }

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
