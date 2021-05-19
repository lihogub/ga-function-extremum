interface Chromosome {
    fun getLength(): Int
    fun getGene(index: Int): Boolean
    fun setGene(index: Int, state: Boolean)
}