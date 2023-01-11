import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(

    @SerialName("key") var key: String? = null,
    @SerialName("value") var value: String? = null

)