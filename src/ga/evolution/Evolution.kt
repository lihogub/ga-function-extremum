package ga.evolution

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import ga.crossingover.Crossingover
import ga.evaluator.Evaluator
import ga.mutation.Mutation
import ga.selector.PartnerSelector
import ga.selector.Selector
import ga.spawner.BlanketSpawner
import ga.spawner.Spawner
import kotlin.random.Random

class Evolution(private val spawnerList: List<Spawner>,
                private val mutatorList: List<Mutation>,
                private val crossingoverList: List<Crossingover>,
                private val partnerSelectorList: List<PartnerSelector>,
                private val selector: Selector,
                private val evaluator: Evaluator,
                private val crossingoverProb: Double,
                private val mutationProb: Double,
                private val rounds: Int,
                private val populationSize: Int) {

    private fun getTransformType(): Int {
        val randValue = Random.nextDouble()
        return when {
            randValue < crossingoverProb -> 2
            randValue < (crossingoverProb + mutationProb) -> 1
            else -> 0
        }
    }

    private fun getNewPopulation(oldPopulation: List<Chromosome>): List<Chromosome> {
        val newPopulation = mutableListOf<Chromosome>()
        val populationSize = oldPopulation.size
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

    fun start() {
        var np: List<Chromosome> = spawnerList.random().spawn(populationSize)
        for (i in 1..rounds) {
            np = this.getNewPopulation(np)
            println("$i avg: ${evaluator.average(np)}, min: ${evaluator.min(np)} max: ${evaluator.max(np)}")
        }
        println("Minimum is ${evaluator.min(np)}.")
    }
}