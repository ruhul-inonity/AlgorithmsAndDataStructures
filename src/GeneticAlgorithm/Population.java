package GeneticAlgorithm;

import java.util.Arrays;

/**
 * Created by ruhul on 7/10/17.
 */
public class Population {
    private Chromosome[] chromosomes;

    public Population(int length) {
        chromosomes = new Chromosome[length];
    }

    public Population initializePopulation(){
        for (int x = 0; x < chromosomes.length; x++) {
            chromosomes[x] = new Chromosome(GeneticAlgo.TARGET_CHROMOSOME.length).initializeChrosome();
        }
        sortChromosomeByFitness();
        return this;
    }

    public Chromosome[] getChromosomes() {
        return chromosomes;
    }

    public void sortChromosomeByFitness() {
        Arrays.sort(chromosomes, (chromosome1,chromosome2) -> {
            int flag = 0;
            if (chromosome1.getFitness() > chromosome2.getFitness()) flag = -1;
            else if (chromosome1.getFitness() < chromosome2.getFitness()) flag = 1;
            return flag;
        });
    }
}
