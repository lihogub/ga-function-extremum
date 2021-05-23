package ga.comparator

import ga.chromosome.Chromosome

class HammingComparator : Comparator() {
    override fun compare(chromosomeA: Chromosome, chromosomeB: Chromosome): Int {
        val genomeA = chromosomeA.getGenome()
        val genomeB = chromosomeB.getGenome()
        var distance = 0
        Array(genomeA.size) { i -> i }
            .forEach { i -> if (genomeA[i].getState().xor(genomeB[i].getState())) distance++ }
        return distance
    }
}