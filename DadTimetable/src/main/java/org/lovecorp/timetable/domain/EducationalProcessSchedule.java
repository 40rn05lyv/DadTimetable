package org.lovecorp.timetable.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EducationalProcessSchedule {

    public enum ActivityType {
        THEORY(true), PRODUCTION(false), PRACTICE(false), HOLIDAYS(false), EXAMS(false);

        private boolean affectsSchedule;

        ActivityType(boolean affectsSchedule) {
            this.affectsSchedule = affectsSchedule;
        }

        public boolean isAffectsSchedule() {
            return affectsSchedule;
        }

    }

    private Map<Group, GroupEducationalProcessSchedule> groupSchedule;
    
    public EducationalProcessSchedule() {
        this.groupSchedule = new HashMap<Group, GroupEducationalProcessSchedule>();
    }

    private class GroupEducationalProcessSchedule {
        private Map<Date, ActivityType> activityMap;

        public GroupEducationalProcessSchedule() {
            this.activityMap = new HashMap<Date, ActivityType>();
        }
        
        public ActivityType getActivutyTypeForDate(Date date) {
            return this.activityMap.get(date);
        }
        
        public void put(Date date, ActivityType activityType) {
            this.activityMap.put(date, activityType);
        }
        
    }
    
    public boolean canHaveLessons(Group group, Date date) {
        return this.groupSchedule.get(group).getActivutyTypeForDate(date).isAffectsSchedule();
    }
    
    public void put(Group group, Date date, ActivityType activityType) {
        GroupEducationalProcessSchedule groupEducationalProcessSchedule = null;
        if (this.groupSchedule.containsKey(group)) {
            groupEducationalProcessSchedule = this.groupSchedule.get(group);
        } else {
            groupEducationalProcessSchedule = new GroupEducationalProcessSchedule();
        }
        groupEducationalProcessSchedule.put(date, activityType);
    }

}
