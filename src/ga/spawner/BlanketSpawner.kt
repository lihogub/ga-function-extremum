package ga.spawner

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl

class BlanketSpawner : Spawner() {
    override fun spawn(chromosomeCount: Int): List<Chromosome> {
        return Array(chromosomeCount) { i -> ChromosomeImpl(i*Int.MAX_VALUE/chromosomeCount) }.toList<Chromosome>()
    }
}