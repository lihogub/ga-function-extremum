package ga.selector

import ga.chromosome.Chromosome
import ga.evaluator.Evaluator
import kotlin.random.Random

class ProportionalSelector(private val evaluator: Evaluator) : Selector() {
    override fun select(population: List<Chromosome>): Chromosome {
        val scoreSum = population.sumOf { c -> evaluator.evaluate(c) }
        val randomValue = Random.nextDouble()
        return population
            .sortedBy { c -> evaluator.evaluate(c) }
            .findLast { c -> evaluator.evaluate(c) / scoreSum <= randomValue }
            ?: population.last()
    }
}