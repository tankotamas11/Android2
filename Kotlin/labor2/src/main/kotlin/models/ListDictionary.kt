package models

import interfaces.IDictionary
import java.io.File

object ListDictionary : IDictionary {
    val words= mutableListOf<String>()
    init{
        File(IDictionary.FILE_NAME).readLines().forEach{add(it)}
    }

    override fun add(word: String): Boolean {
        if (!find(word)){
      return  words.add(word)
        }
        return false
    }

    override fun find(word: String): Boolean {
       return words.any{it.equals(word)}
    }

    override fun size(): Int {
        return words.size
    }
}