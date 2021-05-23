package ga.distance

import ga.chromosome.Chromosome

abstract class Distance {
    abstract fun distance(chromosomeA: Chromosome, chromosomeB: Chromosome): Int
}