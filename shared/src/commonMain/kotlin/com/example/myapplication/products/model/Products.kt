import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Products(

    @SerialName("product_id") var productId: String? = null,
    @SerialName("picker_label") var pickerLabel: String? = null,
    @SerialName("picture_id") var pictureId: String? = null,
    @SerialName("thumbnail") var thumbnail: String? = null,
    @SerialName("tags") var tags: ArrayList<String> = arrayListOf(),
    @SerialName("permalink") var permalink: String? = null

)