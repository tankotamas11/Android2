package models
import interfaces.IDictionary
import java.util.Dictionary
import java.util.TreeSet
import java.io.File


object TreeSetDictionary: IDictionary {
    val words= TreeSet<String>()

    init {
    File(IDictionary.FILE_NAME).readLines().forEach { add(it) }
    }

    override fun add(dict: String): Boolean{
        if(!find(dict)){
            words.add(dict)
            return true
        }
        return false
    }

    override fun find(dict: String): Boolean {
        if(words.find {it.contains(dict)} != null){
            return true
        }
        return false
    }

    override fun size(): Int {
        return words.size
    }}