package ga.evaluator

import ga.chromosome.Chromosome
import kotlin.math.pow

class DoubleEvaluator : Evaluator() {
    override fun evaluate(chromosome: Chromosome): Double {
        var value = 0.0
        val genomeOffset = chromosome.getLength() / 2
        val genome = chromosome.getGenome()
        Array(genome.size) {i -> i}
            .forEach { i -> if (genome[i].getState()) value += 2.0.pow(genomeOffset - i.toDouble()) }
        return value
    }
}