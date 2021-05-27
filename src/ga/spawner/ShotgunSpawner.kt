package ga.spawner

import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import kotlin.random.Random

class ShotgunSpawner() : Spawner() {
    override fun spawn(chromosomeCount: Int): List<Chromosome> {
        val initChromosome = ChromosomeImpl()
        val chromosomeList = mutableListOf<Chromosome>(initChromosome)
        for (i in 1 until chromosomeCount) {
            val newChromosome = ChromosomeImpl(initChromosome)
            val selectedGeneIndex = Random.nextInt(initChromosome.getLength())
            val selectedGene = newChromosome.getGene(selectedGeneIndex)
            selectedGene.invert()
            newChromosome.setGene(selectedGeneIndex, selectedGene)
            chromosomeList.add(newChromosome)
        }
        return chromosomeList.toList()
    }
}