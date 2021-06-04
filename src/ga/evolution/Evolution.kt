package ga.evolution

import ga.chromosome.Chromosome
import ga.crossingover.Crossingover
import ga.evaluator.Evaluator
import ga.logger.Logger
import ga.mutation.Mutation
import ga.selector.PartnerSelector
import ga.selector.Selector
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
                private val populationSize: Int,
                private val logger: Logger) {



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
            if (i % (populationSize/100 + 1) == 0) print("#")
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
        var population: List<Chromosome> = spawnerList.random().spawn(populationSize)
        logger.log(population)
        for (i in 1..rounds) {
            population = this.getNewPopulation(population)
            logger.log(population)
            println("\n$i avg: ${evaluator.average(population)}, " +
                    "median: ${evaluator.median(population)} " +
                    "min: ${evaluator.min(population)} " +
                    "max: ${evaluator.max(population)}")
        }
        val minChromosome = population.minByOrNull { c -> evaluator.evaluate(c) }!!
        val minX = evaluator.toValue(minChromosome)
        val minY = evaluator.evaluate(minChromosome)
        println("Minimum X=${minX}, Y=${minY}.")
        logger.saveCSV()
    }
}