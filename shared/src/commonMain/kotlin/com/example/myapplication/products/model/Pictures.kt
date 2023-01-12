import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pictures(

    @SerialName("id") var id: String? = null,
    @SerialName("url") var url: String? = null,
    @SerialName("suggested_for_picker") var suggestedForPicker: ArrayList<String> = arrayListOf<String>(),
    @SerialName("max_width") var maxWidth: Int? = null,
    @SerialName("max_height") var maxHeight: Int? = null

)