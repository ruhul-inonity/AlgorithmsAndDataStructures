package GeneticAlgorithm;

import java.util.Arrays;

/**
 * Created by ruhul on 7/10/17.
 */
public class Driver {

    public static void main(String[] args){
        Population population = new Population(GeneticAlgo.POPULATION_SIZE).initializePopulation();
        GeneticAlgo geneticAlgo = new GeneticAlgo();
        System.out.println("..................................................");
        System.out.println("Generation # 0 " + " | Fittest chromosome fitness: "+population.getChromosomes()[0].getFitness());
        printPopulation(population, "Target Chromosome: "+ Arrays.toString(GeneticAlgo.TARGET_CHROMOSOME));
        int generationNumber = 0;

        while (population.getChromosomes()[0].getFitness() < GeneticAlgo.TARGET_CHROMOSOME.length){
            generationNumber++;
            System.out.println("\n..............................................");
            population = geneticAlgo.evolve(population);
            population.sortChromosomeByFitness();

            System.out.println("Generation # "+generationNumber + " | Fittest chromosome fitness: "+population.getChromosomes()[0].getFitness());
            printPopulation(population, "Target Chromosome: "+ Arrays.toString(GeneticAlgo.TARGET_CHROMOSOME));
        }
    }
    public static void printPopulation(Population population, String heading){
        System.out.println(heading);
        System.out.println("...................................................");
        for (int x = 0; x < population.getChromosomes().length; x++) {
            System.out.println("Chromosome # "+ x +  " : " + Arrays.toString(population.getChromosomes()[x].getGenes())+
                    " | Fitness: "+population.getChromosomes()[x].getFitness());
        }
    }

}


