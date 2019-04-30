package Lesson8;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private List<Human> listOfHumans;

    public static void main(String[] args) {
        Main main = new Main();
        main.listOfHumans.add(new Human(1, 1, 0, "human1"));
        main.listOfHumans.add(new Human(2, 2, 0, "human2"));
        main.listOfHumans.add(new Human(3, 3, 1, "human3"));
        main.listOfHumans.add(new Human(4, 4, 3, "human4"));
        main.listOfHumans.add(new Human(5, 5, 4, "human5"));
        main.listOfHumans.add(new Human(6, 6, 0, "human6"));

        main.dfs(main.listOfHumans.get(0));
    }

    private void dfs(Human human){
        if (human.isChecked) {
            return;
        }
        human.setChecked(true);
        if (human.parentId > 0){
            listOfHumans.get(human.parentId - 1).children.add(human);
        }

        for (Human next : listOfHumans) {
            dfs(next);
        }
    }

    public Main() {
        this.listOfHumans = new ArrayList<>();
    }
}
