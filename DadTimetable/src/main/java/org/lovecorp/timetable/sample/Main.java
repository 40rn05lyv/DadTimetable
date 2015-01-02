package org.lovecorp.timetable.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lovecorp.timetable.domain.Timetable;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Build the Solver
        SolverFactory solverFactory = SolverFactory.createFromXmlResource("org/lovecorp/timetable/sample/timetableSolverConfig.xml");
        Solver solver = solverFactory.buildSolver();

        // Load a problem
        Timetable unsolvedCloudBalance = new TimetableReader().read(new File("D:\\Development\\DadTimetable\\examples\\Example.xls"));

        // Solve the problem
        solver.solve(unsolvedCloudBalance);
        Timetable solvedCloudBalance = (Timetable) solver.getBestSolution();

        // Display the result
        System.out.println("\nSolved cloudBalance with 400 computers and 1200 processes:\n" + solvedCloudBalance.toString());
    }

}
