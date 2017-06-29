package innopolis.studentsapp.managers;

import java.util.ArrayList;
import java.util.List;

import innopolis.studentsapp.entities.Group;

/**
 * Created by davlet on 6/29/17.
 */

public class GroupManager {
    private List<Group> groups;

    public GroupManager() {
        this.groups = new ArrayList<>();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Group findGroupById(Long id){
        for (Group group : getGroups()){
            if (id.equals(group.getId())){
                return group;
            }
        }
        return null;
    }
}
