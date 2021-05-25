package ga.spawner

import ga.chromosome.Chromosome

abstract class Spawner {
    abstract fun spawn(chromosomeCount: Int): List<Chromosome>
}