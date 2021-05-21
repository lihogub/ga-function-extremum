package ga.mutation

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import kotlin.random.Random

class GoldenRatioMutation : Mutation() {
    override fun mutate(chromosome: Chromosome): Chromosome {
        val chromosomeLength = chromosome.getLength()
        val exchangePoint =
            if (Random.nextBoolean()) (chromosomeLength / 1.61803).toInt() else (chromosomeLength / 0.61803).toInt()
        val geneA = chromosome.getGene(exchangePoint)
        val geneB = chromosome.getGene(exchangePoint + 1)
        val newChromosome = ChromosomeImpl(chromosome)
        newChromosome.setGene(exchangePoint, geneB)
        newChromosome.setGene(exchangePoint + 1, geneA)
        return newChromosome
    }
}