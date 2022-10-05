
class ItemService {
    val itemRepository = ItemRepository()


    fun selectRandomItems(num: Int) : List<Item>{
        val items = mutableListOf<Item>()
        var t=0
        if(num>itemRepository.items.size){ return itemRepository.items}
        while(t<num){
            val item2=itemRepository.randomItem()
            if(item2 !in itemRepository.items){
                items.add(item2)
            }
        }
        return items
    }
}