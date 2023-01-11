import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pickers(

    @SerialName("picker_id") var pickerId: String? = null,
    @SerialName("picker_name") var pickerName: String? = null,
    @SerialName("products") var products: ArrayList<Products> = arrayListOf(),
    @SerialName("tags") var tags: String? = null,
    @SerialName("attributes") var attributes: ArrayList<Attributes> = arrayListOf()

)