package ga.crossingover

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import kotlin.random.Random

class OnePointCrossingover : Crossingover() {
    override fun crossingover(chromosomeA: Chromosome, chromosomeB: Chromosome): Chromosome {
        val chromosomeLength = chromosomeA.getLength()
        val splitPoint = Random.nextInt(chromosomeLength)
        val newChromosome = ChromosomeImpl(chromosomeA)
        for (i in splitPoint until chromosomeLength)
            newChromosome.setGene(i, chromosomeB.getGene(i))
        return newChromosome
    }
}