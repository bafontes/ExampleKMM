import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortDescription(

    @SerialName("type") var type: String? = null,
    @SerialName("content") var content: String? = null

)