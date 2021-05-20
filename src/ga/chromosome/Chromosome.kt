package ga.chromosome

import ga.gene.Gene

interface Chromosome {
    fun getLength(): Int
    fun getGenome(): List<Gene>
    fun setGenome(genome: List<Gene>)
    fun getGene(index: Int): Gene
    fun setGene(index: Int, gene: Gene)
}