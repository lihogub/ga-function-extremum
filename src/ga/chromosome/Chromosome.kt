package ga.chromosome

import ga.gene.Gene

abstract class Chromosome {
    abstract fun getLength(): Int
    abstract fun getGenome(): List<Gene>
    abstract fun setGenome(genome: List<Gene>)
    abstract fun getGene(index: Int): Gene
    abstract fun setGene(index: Int, gene: Gene)
}