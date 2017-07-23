package GeneticAlgorithm.university_class_scheduling;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * Created by ruhul on 7/15/17.
 */
public class GeneticAlgor {
    private Data data;

    public GeneticAlgor(Data data) {
        this.data = data;
    }
    public Population evolve(Population population){
        return mutatePopulation(crossOverPopulation(population));
    }

    //crossover on elite class population
    Population crossOverPopulation(Population population){
        Population crossOverPopulation = new Population(population.getSchedules().size(), data);
        IntStream.range(0, Driver_schedule.NUMB_OF_ELITE_SCHEDULES).forEach(x ->
            crossOverPopulation.getSchedules().set(x,population.getSchedules().get(x)));
        IntStream.range(Driver_schedule.NUMB_OF_ELITE_SCHEDULES, population.getSchedules().size()
            ).forEach(x -> {
            if (Driver_schedule.CROSSOVER_RATE > Math.random()){
                Schedule schedule1 = selectTournamentPopulation(population).shortByFitness().getSchedules().get(0);
                Schedule schedule2 = selectTournamentPopulation(population).shortByFitness().getSchedules().get(0);
                crossOverPopulation.getSchedules().set(x, crossoverSchedule(schedule1,schedule2));
            }else crossOverPopulation.getSchedules().set(x,population.getSchedules().get(x));
        });
        return crossOverPopulation;
    }
    Schedule crossoverSchedule(Schedule schedule1, Schedule schedule2){
        Schedule crossoverSchedule = new Schedule(data).initialize();
        IntStream.range(0, crossoverSchedule.getClasses().size()).forEach(x -> {
            if (Math.random() > 0.5) crossoverSchedule.getClasses().set(x,schedule1.getClasses().get(x));
            else crossoverSchedule.getClasses().set(x, schedule2.getClasses().get(x));
        });
        return crossoverSchedule;
    }
    Population mutatePopulation(Population population){
        Population mutatePopulation = new Population(population.getSchedules().size(),data);
        ArrayList<Schedule> schedules = mutatePopulation.getSchedules();
        IntStream.range(0, Driver_schedule.NUMB_OF_ELITE_SCHEDULES).forEach(x -> schedules.set(x, population.getSchedules().get(x)));
        IntStream.range(Driver_schedule.NUMB_OF_ELITE_SCHEDULES, population.getSchedules().size())
                .forEach(x -> schedules.set(x, mutateSchedule(population.getSchedules().get(x))));
        return mutatePopulation;
    }
    Schedule mutateSchedule(Schedule mutateSchedule){
        Schedule schedule = new Schedule(data).initialize();
        IntStream.range(0, mutateSchedule.getClasses().size()).forEach(x -> {
            if (Driver_schedule.MUTANT_RATE > Math.random()) mutateSchedule.getClasses().set(x,
                    schedule.getClasses().get(x));
        });
        return mutateSchedule;
    }
    Population selectTournamentPopulation(Population population){
        Population tournamentPopulation = new Population(Driver_schedule.TOURNAMENT_SELECTION_SIZE, data);
        IntStream.range(0, Driver_schedule.TOURNAMENT_SELECTION_SIZE).forEach(x -> {
            tournamentPopulation.getSchedules().set(x,
                    population.getSchedules().get((int) (Math.random() * population.getSchedules().size())));
        });
        return tournamentPopulation;
    }
}
