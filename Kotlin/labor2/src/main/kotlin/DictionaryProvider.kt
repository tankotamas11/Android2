import interfaces.IDictionary
import models.ListDictionary

class DictionaryProvider {
    companion object {
        fun createDictionary(type: DictionaryType): IDictionary {
            return when (type) {
                DictionaryType.ARRAY_LIST -> ListDictionary
                //DictionaryType.TREE_SET -> TreeSetDictionary
                //DictionaryType.HASH_SET -> HashSetDictionary
            }
        }
    }
}

enum class DictionaryType{
    ARRAY_LIST
}