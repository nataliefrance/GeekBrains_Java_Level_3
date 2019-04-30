package Lesson8;

import java.util.ArrayList;
import java.util.List;

class Human {
    int id;
    int entityId;
    int parentId;
    String name;
    List<Human> children;
    boolean isChecked;

    Human(int id, int entityId, int parentId, String name) {
        this.id = id;
        this.entityId = entityId;
        this.parentId = parentId;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
