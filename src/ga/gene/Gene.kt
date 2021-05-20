package ga.gene

abstract class Gene {
    abstract fun getState(): Boolean
    abstract fun setState(state: Boolean)
    abstract fun invert()
}