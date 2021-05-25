package ga.evaluator

import ga.chromosome.Chromosome
import kotlin.math.pow

class DoubleEvaluator(private val targetFunction: (Double) -> Double,
                      private val leftBorder: Double,
                      private val rightBorder: Double) : Evaluator() {
    override fun evaluate(chromosome: Chromosome): Double {
        var value = 0.0
        val genome = chromosome.getGenome()
        Array(genome.size) {i -> i}
            .forEach { i -> if (genome[i].getState()) value += 2.0.pow(i.toDouble()) }
        return targetFunction(leftBorder + (rightBorder - leftBorder)*(value/2.0.pow(32)))
    }

    override fun average(population: List<Chromosome>): Double {
        return population.map {c -> evaluate(c)}.average()
    }

    override fun min(population: List<Chromosome>): Double {
        return population.map {c -> evaluate(c)}.minOrNull() ?: Double.MIN_VALUE
    }

    override fun max(population: List<Chromosome>): Double {
        return population.map {c -> evaluate(c)}.maxOrNull() ?: Double.MAX_VALUE
    }
}