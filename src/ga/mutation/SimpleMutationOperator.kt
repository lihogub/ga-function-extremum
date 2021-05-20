package ga.mutation

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import kotlin.random.Random

class SimpleMutationOperator : MutationOperator() {
    override fun mutate(chromosome: Chromosome): Chromosome {
        val newChromosome = ChromosomeImpl(chromosome)
        val chromosomeLength = chromosome.getLength()
        val mutationPosition = Random.nextInt(0, chromosomeLength)
        val oldGene = newChromosome.getGene(mutationPosition)
        oldGene.invert()
        newChromosome.setGene(mutationPosition, oldGene)
        return newChromosome
    }
}