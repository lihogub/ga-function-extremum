package ga.chromosome

import ga.gene.Gene
import ga.gene.BinaryGene

class ChromosomeImpl() : Chromosome {
    private val genomeLength: Int = 32
    private var genome = MutableList<Gene>(genomeLength) { BinaryGene(false) }

    constructor(chromosome: Chromosome) : this() { this.setGenome(chromosome.getGenome()) }

    override fun getLength(): Int = this.genomeLength

    override fun getGenome(): List<Gene> = this.genome.toList()

    override fun setGenome(genome: List<Gene>) { this.genome = genome.toMutableList() }

    override fun getGene(index: Int): Gene = BinaryGene(this.genome[index])

    override fun setGene(index: Int, gene: Gene) { this.genome[index] = BinaryGene(gene) }

    override fun toString(): String = "Chromosome #${this.hashCode().toString(16)} ${this.getGenome()}"
}