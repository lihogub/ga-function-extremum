package ga.crossingover

import ga.chromosome.Chromosome

abstract class CrossingoverOperator {
    abstract fun crossingover(chromosomeA: Chromosome, chromosomeB: Chromosome): Chromosome
}