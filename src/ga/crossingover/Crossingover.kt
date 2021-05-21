package ga.crossingover

import ga.chromosome.Chromosome

abstract class Crossingover {
    abstract fun crossingover(chromosomeA: Chromosome, chromosomeB: Chromosome): Chromosome
}