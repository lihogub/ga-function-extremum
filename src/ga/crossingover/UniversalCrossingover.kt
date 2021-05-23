package ga.crossingover

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import kotlin.random.Random

class UniversalCrossingover : Crossingover() {
    override fun crossingover(chromosomeA: Chromosome, chromosomeB: Chromosome): Chromosome {
        val chromosomeLength = chromosomeA.getLength()
        val newChromosome = ChromosomeImpl()
        for (i in 0 until chromosomeLength) {
            val gene = if (Random.nextBoolean()) chromosomeA.getGene(i) else chromosomeB.getGene(i)
            newChromosome.setGene(i, gene)
        }
        return newChromosome
    }
}