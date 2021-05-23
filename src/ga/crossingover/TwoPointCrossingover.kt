package ga.crossingover

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import kotlin.random.Random

class TwoPointCrossingover : Crossingover() {
    override fun crossingover(chromosomeA: Chromosome, chromosomeB: Chromosome): Chromosome {
        val chromosomeLength = chromosomeA.getLength()
        val firstPoint = Random.nextInt(chromosomeLength)
        val secondPoint = Random.nextInt(firstPoint, chromosomeLength)
        val newChromosome = ChromosomeImpl(chromosomeA)
        for (i in firstPoint until secondPoint) {
            val gene = chromosomeB.getGene(i)
            newChromosome.setGene(i, gene)
        }
        return newChromosome
    }
}