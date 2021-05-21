package ga.crossingover

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import kotlin.random.Random

class GoldenRatioCrossingover : Crossingover() {
    override fun crossingover(chromosomeA: Chromosome, chromosomeB: Chromosome): Chromosome {
        val chromosomeLength = chromosomeA.getLength()
        val exchangePoint =
            if (Random.nextBoolean()) (chromosomeLength / 1.61803).toInt() else (chromosomeLength / 0.61803).toInt()
        val newChromosome = ChromosomeImpl(chromosomeA)
        for (i in exchangePoint..chromosomeLength)
            newChromosome.setGene(i, chromosomeB.getGene(i))
        return newChromosome
    }
}