package ga.crossingover

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import kotlin.random.Random

class SimpleCrossingover : Crossingover() {
    override fun crossingover(chromosomeA: Chromosome, chromosomeB: Chromosome): Chromosome {
        val chromosomeLength = chromosomeA.getLength()
        val splitPoint = Random.nextInt(0, chromosomeLength)
        val newChromosome = ChromosomeImpl(chromosomeA)
        for (i in splitPoint..chromosomeLength)
            newChromosome.setGene(i, chromosomeB.getGene(i))
        return newChromosome
    }
}