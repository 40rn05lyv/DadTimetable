package org.lovecorp.timetable.domain;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class TimetableEasyScoreCalculator implements EasyScoreCalculator<Timetable> {

    public Score calculateScore(Timetable solution) {
        if (solution.getRooms().size() == 2){ 
            return null;
        }
        return null;
    }

}
