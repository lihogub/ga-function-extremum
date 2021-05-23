package ga.evolution

import ga.chromosome.Chromosome
import ga.crossingover.Crossingover
import ga.distance.Distance
import ga.evaluator.Evaluator
import ga.mutation.Mutation
import ga.selector.PartnerSelector
import ga.selector.Selector
import kotlin.random.Random

class Evolution(private val mutatorList: List<Mutation>,
                private val crossingoverList: List<Crossingover>,
                private val partnerSelectorList: List<PartnerSelector>,
                private val selector: Selector,
                private val populationSize: Int,
                private val generationCount: Int,
                private val crossingoverProb: Double,
                private val mutationProb: Double) {

    private fun getTransformType(): Int {
        val randValue = Random.nextDouble()
        return when {
            randValue < crossingoverProb -> 2
            randValue < (crossingoverProb + mutationProb) -> 1
            else -> 0
        }
    }

    fun getNewPopulation(oldPopulation: List<Chromosome>): List<Chromosome> {
        val newPopulation = mutableListOf<Chromosome>()
        for (i in 0 until populationSize) {
            val firstChromosome = selector.select(oldPopulation)
            val newChromosome = when (getTransformType()) {
                2 -> {
                    val secondChromosome = partnerSelectorList
                        .random()
                        .select(population = oldPopulation, partner = firstChromosome)
                    crossingoverList
                        .random()
                        .crossingover(firstChromosome, secondChromosome)
                }
                1 -> mutatorList.random().mutate(firstChromosome)
                else -> firstChromosome
            }
            newPopulation.add(newChromosome)
        }
        return newPopulation.toList()
    }
}